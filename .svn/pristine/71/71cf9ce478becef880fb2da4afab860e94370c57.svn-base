require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery', 'jquery.validate', 'jquery.serialize', 'laydate','pagination'],
function(layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	initlicence();//初始化许可证
    	initwebsite();//初始化网站
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
            url: '/reg/server/yr/pb/pblicence/licencelist.json',
            serializable: false,
            data: {start: page*length,length: length,params:{"anCheID":anCheID}},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#pagination1').pagination(itemCount, {
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,//主体页数
                    num_edge_entries: 2,//边缘页数
                    items_per_page:5,  //每页条数
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页',
                    callback:function(page,jq){
                        loadData_one(page,5);
                    }
                });
                var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1;});//序号
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
            url: '/reg/server/yr/pb/pbwebsite/websitelist.json',
            serializable: false,
            data: {start: page*length,length: length,params:{"anCheID":anCheID}},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#pagination2').pagination(itemCount, {
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,//主体页数
                    num_edge_entries: 2,//边缘页数
                    items_per_page:5,  //每页条数
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页',
                    callback:function(page,jq){
                        loadData(page,5);
                    }
                });
                handlebars.registerHelper("num", function(index) {return index+1;});//序号
                handlebars.registerHelper("webtype", function(webType) {
                	if(webType == '2') {
                		return "网店";
            		}else if(webType == '1') {
            			return "网站";
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

   

    //按钮事件
    function bind() {
        util.bindEvents([
	     {//预览页面取消按钮
	         el: '#cancel',
	         event: 'click',
	         handler: function () {
//	        	 window.close();
	             layer.close();
	         }
	     },
	     //提交年报弹出框
         {el: '#save',
         event: 'click',
         handler: function () {
        	var params = $('#_params').serializeObject();//查询参数
         	layer.dialog({
                content: "/reg/server/yr/pbaddrec/commitpage?priPID="+$("#priPID").val()+"&year="+params['year'],
                type: 2,
                area: ['700px','400px'],
                callback: function (data) {
                    //重新加载列表数据
                    if (data.reload) {
                        layer.close({reload: true});
                    }
                }
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
         },
         {
        	//提交
            el: '#commit',
            event: 'click',
            handler: function () {
            	$("#commit").attr("disabled","disabled");
            	var params = $('#_params').serializeObject();//查询参数
//            	var _index;
            	http.httpRequest({
                    url: '/reg/server/yr/pbaddrec/addrec',
                    data: {year: params['year'], priPID: $("#priPID").val()},
                    type: "post",
    		        beforeSend:function(){ //发送前执
                        layer.msg('补录提交时数据处理可能比较慢,请您耐心等待,请勿关闭浏览器!', {icon: 16, time: -1, shade: [0.4, '#CCC']});
                    },
                    success: function (data) {
                        if (data.status == 'success') {
                        	layer.msg(data.msg, {icon: 6,time: 2000}, function () {
                            	layer.close({reload: true});                  		
                            });
                        }else {
                        	layer.msg(data.msg, {icon: 5,time: 2000}, function () {
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
