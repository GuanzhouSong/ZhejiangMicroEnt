require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery', 'jquery.validate', 'jquery.serialize', 'laydate','pagination','common/validateRules'],
function(layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	tableInit();
    	initlicence();//初始化许可证
    	initwebsite();//初始化网站
    	initBranch();//初始化分支机构
//        bind();
    }
    
    //提交表单初始化
    function tableInit(){  	
    	//设置为年报状态不为未公示及待修改时表单不能修改
		$(":radio").attr("disabled","disabled");
		$(":checkbox").attr("disabled","disabled");
		$(".sfcreport").attr("readonly","readonly");
		$(".icon-close").hide();
		//其他工商服务信息初始化
		initIcService();
    }
    
    //其他工商服务
    function initIcService(){
    	var icServiceArray = $("#icService").val();
        $("input:checkbox[name=icServiceCheck]").each(function(){
            if(util.in_array(icServiceArray,$(this).val())){
                $(this).prop("checked",true);
                if($("#icServiceCheck6").prop("checked")){
                	$("#othICService").show();
                	$("#othICService").val(window._CONFIG.othICService);
                }
            }
        });
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
            url: '/reg/server/yr/sfc/sfcbaseinfoserver/licencelist.json',
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
                var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*5);});//序号
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
            url: '/reg/server/yr/sfc/sfcbaseinfoserver/websitelist.json',
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
                handlebars.registerHelper("num", function(index) {return index+1+(page*5);});//序号
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

    
    /**
     * 分支机构初始化
     */
    function initBranch(){
    	loadData_two(0,5);
    };//初始化网站
    
    function loadData_two(page, length, callback) {
    	var anCheID = $('#anCheID').val();//查询参数
        http.httpRequest({
            url: '/reg/server/yr/sfc/sfcbaseinfoserver/branchlist.json',
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
                handlebars.registerHelper("addOne", function(index) {return index+1+(page*5);});//序号
                var myTemplate = handlebars.compile($("#table-template-three").html());
                $('#dbao_page_branch').html(myTemplate(data));
                $("#itemCount3").text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $("#pageCount3").text(pageNum);//共多少页
            }
        });
    };
});
