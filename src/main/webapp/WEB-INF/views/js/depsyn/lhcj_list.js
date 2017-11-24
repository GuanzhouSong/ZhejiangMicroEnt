require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','pagination','common/validateRules'],
		function (layer, dataTable, util, http, handlebars) {
	
    
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initPubdtinfo();
        bind();
    }
    
    function initPubdtinfo(){
    	initPubdtinfoTable(0,5);
    }
    /**
     * 初始化dataTable
     */
    function initPubdtinfoTable(page, length, callback) {
    	var params = {entName:$("#entName").val()};
    	http.httpRequest({
            url: '/depsyn/searchlist.json',
            data: {start: page*length,length: length,params:params},
            success: function (data) {
            	console.log(data);
                var itemCount = data.recordsTotal;
                count_downinfo(params,itemCount);
                $('.pagination').pagination(itemCount, {
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,
                    num_edge_entries: 2,
                    items_per_page:5,
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页',
                    callback:function(page,jq){
                    	initPubdtinfoTable(page,5);
                    }
                });
                var infoArry = data.data
                if(infoArry != null){
                	for(var i=0;i<data.data.length;i++){
                    	if(infoArry[i].downState == '1'){
                    		infoArry[i].downStateDesc = "已下载";
                    	}else{
                    		infoArry[i].downStateDesc = "未下载";
                    	}
                    	if(infoArry[i].uniSCID == null){
                    		infoArry[i].uniSCID = infoArry[i].regNO;
                    	}
                	}
                }
                var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*5);});//序号
                var myTemplate = handlebars.compile($("#pubdtinfo_list").html());
                $('#pubdtinfo_page').html(myTemplate(data));
                $("#pro_total").text(itemCount);
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $("#pro_pageNum").text(pageNum);
            }
        });
    }
    
    $("#search").click(function(){
    	initPubdtinfo();
    })


    //draw事件，统计下载信息
    function count_downinfo(searchParams,itemCount) {
        var total=0;downed=0;nondown=0;
        http.httpRequest({
            url: '/depsyn/searchlistJSON_downednum',
            serializable: true,
            data: searchParams,
            type: 'post',
            success: function (data) {
                downed = data.data;
                nondown = itemCount-downed;
                var info = '共 <span class="light">'+itemCount+'</span>条，已下载 <span class="light">'+downed+'</span>条，未下载<span class="light">'+nondown+'</span>条';
                $('#downinfo').html(info);
            }
        });
    }
    
    function down(priPID,id){
    	http.httpRequest({
            url: '/syn/infomange/inforecestat/save',
            serializable: false,
            data: {'priPID':priPID,'type':'4','id':id},
            type: 'post',
            success: function (data) {
                layer.msg(data.msg, {time: 1000}, function () {
                	if(data.status=='success'){
                		initPubdtinfo();
                	}
                });
            }
        });
    }
    
    $('.js-batchdownload').click(function(){
    	var priArr = "";
    	var idArr = "";
      	 $('.chb').each(function(){ 
      		 var priPID = $(this).attr("priPID");
      		 var downState = $(this).attr("downState");
      		 var id = $(this).val();
          	 if($(this).is(':checked')){
          		    if(downState != '1'){
          		    	priArr = priArr + priPID+',';
              		    idArr = idArr + id +',';
          		  }
      		  }
   		 });
      	 
//      	 if(downState == '1'){return;}
      	 down(priArr.substring(0,priArr.length-1),idArr.substring(0,idArr.length-1));
      });
    
    function bind() {
        util.bindEvents([{
            el: '#pubdtinfoTable a',
            event: 'click',
            handler: function () {
                var priPID = $(this).attr("priPID");
                layer.dialog({
                    title: false,
                    closeBtn: false,
                    shadeClose: true,
                    area: ['900px', '400px'],
                    content: '/depsyn/toedit?pripid=' + priPID,
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
                        	initPubdtinfo();
                        }
                    }
                })
            }
        },{
                el: '.down', //下载
                event: 'click',
                handler: function () {
            	//down(data.priPID,data.id);
                }
            },{
                el: '#download',
                event: 'click',
                handler: function(){
                	if($(".chb:checked").length == 0){
                		layer.msg("请至少选中一项进行下载！", {time: 1000},null);
                		return false;
                	}
                	var paramObject={};
                	var paramArry = new Array();
                	var titleArry = new Array();
                	$(".chb:checked").each(function(){
                		var checkArry = new Array();
                		var tdid = $(this).val();
                		$("#tr"+tdid+" td:gt(1)").each(function(){
                			checkArry.push($(this).text());
                		})
                		paramArry.push(checkArry);
                	})
                	$("#trTitle th:gt(1)").each(function(){
                		titleArry.push($(this).text());
                	})
                	
                	$("#cellInfo").val(paramArry);
                	$("#cellTitle").val(titleArry);
                	$("#fileName").val("联合惩戒");
                	
                	$("#excelform").submit();//表单提交 
                	
                }
            },{
            	el:'.chbAll',
            	event:'click',
            	handler:function(){
            		var check = $(this).prop('checked');
          	        $('.chb').prop('checked', check);
            		if($(this).prop("checked")){
            			$(".chb").attr("checked",true);
            		}else{
            			$(".chb").attr("checked",false);
            		}
            	}
            }
        ])
    }

})

