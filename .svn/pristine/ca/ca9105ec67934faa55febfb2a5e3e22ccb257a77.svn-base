require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery', 'jquery.validate', 'jquery.serialize', 'laydate','pagination'],
function(layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	initlicence();//初始化许可证
    	initwebsite();//初始化网站
    	initBranch();//初始化分支机构
        bind();
    }
     
    /**
     * 许可证初始化(传值为年报id)
     */
    function initlicence(){
    	 loadData_one(0,5);
    };
    
    function loadData_one(page, length, callback) {
    	var anCheID = $('#anCheID').val();//查询参数
        http.httpRequest({
            url: '/reg/client/yr/sfc/sfclicence/licencelist.json',
            serializable: false,
            data: {start: page*length,length: length,params:{"anCheID":anCheID}},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数          	
                $('#pagination1').pagination(itemCount, {
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    items_per_page:5,  //每页条数
                    num_display_entries: 3,//主体页数`104
                    num_edge_entries: 2,//边缘页数
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页',
                    callback:function(page,jq){
                        loadData_one(page,5);
                    }
                });
//                var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*5);});//序号
                handlebars.registerHelper("valto", function(valTo) {
                	if(valTo =="9999-09-09"){
                		return "长期有效";
                	}else{
                		return valTo;
                	}
                });
                var myTemplate = handlebars.compile($('#table-template-one').html());
                $('#dbao_page_one').html(myTemplate(data));
                $("#itemCount1").text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $("#pageCount1").text(pageNum);//共多少页
            }
        });
    };
    
    
    /**
     * 初始化网站
     */
    function initwebsite(){
    	loadData(0,5);
    };//初始化网站
    
    function loadData(page, length, callback) {
    	var anCheID = $('#anCheID').val();//查询参数
        http.httpRequest({
            url: '/reg/client/yr/sfc/sfcwebsite/websitelist.json',
            serializable: false,
            data: {start: page*length,length: length,params:{"anCheID":anCheID}},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#pagination2').pagination(itemCount, {
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    items_per_page:5,  //每页条数
                    num_display_entries: 3,//主体页数
                    num_edge_entries: 2,//边缘页数
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页',
                    callback:function(page,jq){
                        loadData(page,5);
                    }
                });
                handlebars.registerHelper("webtype", function(webType) {
                    if(webType&&webType=='2'){
                        return '网店(或微店)';
                    }else{
                        var webSmallType = this.webSmallType;
                        if(webSmallType){return webSmallType=='1'?'交易网站':'信息网站';}else{return '';}
                    }
                });
                var myTemplate = handlebars.compile($("#table-template").html());
                $('#dbao_page').html(myTemplate(data));
                $("#itemCount").text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $("#pageCount").text(pageNum);//共多少页
            }
        });
    };

    
    /**
     * 分支机构初始化
     */
    function initBranch(){
    	loadData_two(0,5);
    };//初始化网站
    
    function loadData_two(page, length, callback) {
    	var anCheID = $('#anCheID').val();//查询参数
        http.httpRequest({
            url: '/reg/client/yr/sfc/sfcbranch/branchlist.json',
            serializable: false,
            data: {start: page*length,length: length,params:{"anCheID":anCheID}},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#pagination3').pagination(itemCount, {
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    items_per_page:5,  //每页条数（默认为10）
                    num_display_entries: 3,//主体页数
                    num_edge_entries: 2,//边缘页数
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页',
                    callback:function(page,jq){
                        loadData_two(page,5);
                    }
                });
                var myTemplate = handlebars.compile($("#table-template-three").html());
                $('#dbao_page_branch').html(myTemplate(data));
                $("#itemCount3").text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $("#pageCount3").text(pageNum);//共多少页
            }
        });
    };
   

    //按钮事件
    function bind() {
        util.bindEvents([
	    {//预览页面取消按钮
	         el: '#cancel',
	         event: 'click',
	         handler: function () {
	        	 window.close();
	         }
	     },
	     //提交年报弹出框
         {el: '#save',
         event: 'click',
         handler: function () {
//         	$(".layer").show();
//         	$(".yrpubpreview-pop").show();
         	layer.dialog({
                content: $('#yrpubpreview-pop'),
                type: 1,
                area: ['700px','400px']
            });
            }
         },
         {//弹出框取消按钮
             el: '#confirmCancel',
             event: 'click',
             handler: function () {
            	 layer.closeAll();
//             	$(".layer").hide();
//             	$(".yrpubpreview-pop").hide();
//             	 window.close();
             }
         },{
	        	//提交
	            el: '#commit',
	            event: 'click',
	            handler: function () {
	            	$("#commit").attr("disabled","disabled");
	            	var params = $('#_params').serializeObject();//查询参数
//	            	var _index;
	            	http.httpRequest({
	                    url: '/reg/client/yr/yrcommit/sfc/commitreport',
	                    type: 'post',
	    		        beforeSend:function(){ //发送前执
                            layer.msg('年报提交时数据处理可能比较慢,请您耐心等待,请勿关闭浏览器!', {icon: 16, time: -1, shade: [0.4, '#CCC']});
	                    },
	                    data: {year: params['year'], pripid: params['priPID']},
	                    success: function (data) {
	                        if (data.status == 'success') {
	                        	layer.msg(data.msg, {icon: 6,time: 2000}, function () {
	                        		//刷新父页面
	                        		window.opener.location.href = window.opener.location.href;
	                        		window.close();
	                            });
	                        }else {
	                        	layer.msg(data.msg,{icon: 5,time: 2000}, function () {
	                                return;
	                            });
	                        }
	                    }
	                });
	            }
	        }
      ])
    }
});
