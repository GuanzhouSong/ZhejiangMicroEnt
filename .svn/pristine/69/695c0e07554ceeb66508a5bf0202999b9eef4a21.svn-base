var state;
var checkCode;
require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','pagination'], function (layer, dataTable, util, http, handlebars) {
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	bind();
    }
    
	 function loadScenCheckTaskList(page, length,callback) {
			var pubTitle = $("#pubTitle").val();
			var regOrgLike = $("#regOrgLike").val();
	    	var params = {checkCode:checkCode,pubTitle:pubTitle,auditArea:regOrgLike};
	        http.httpRequest({
	            url: '/pub/infobulletin/scenCheckTask.json',
	            data: {start: page*length,length: length,params:params},
	            success: function (data) {
	            	var itemCount = data.recordsTotal;
	            	if(itemCount != 0){
	            		$("#pageforhide").show();
	            		$("#nodata").text("").hide();
	            		$('.pagination').pagination(itemCount, {
		                    prev_text: '<i class="icon-triangle-left"></i>上一页',
		                    next_text: '下一页<i class="icon-triangle-right"></i>',
		                    num_display_entries: 3,
		                    num_edge_entries: 2,
		                    current_page: page,
		                    items_per_page:10,
		                    link_to: 'javascript:void(0)',
		                    ellipse_text: '...',
		                    first_text: '首页',
		                    last_text: '末页',
		                    callback:function(page,jq){
		                    	loadScenCheckTaskList(page,10);
		                    }
		                });
	            		var	myTemplate = handlebars.compile($("#notice_li_list").html());
		                $('#notice-list-id').html(myTemplate(data));
		                $("#notice-list-id a").click(function(){
		                	var relateid = $(this).attr("linkUID");
		                	showdetail(relateid, checkCode, null);
		                });
		                $("#notice-total").text(itemCount);
		                var pageNum = itemCount%10==0?itemCount/10:Math.ceil(itemCount/10);
		                $("#notice_pageNum").text(pageNum);
	            	}else{
	            		$(".notice-list").html("");
	            		$("#pageforhide").hide();
	            		$("#nodata").show().text("暂无"+$("#border-title span").text());
	            	}
	            }
	        });
	    }
	 
	 function loadWorkPlanList(page, length,callback) {
		 	var pubTitle = $("#pubTitle").val();
			var regOrgLike = $("#regOrgLike").val();
	    	var params = {checkCode:1,pubTitle:pubTitle,auditArea:regOrgLike};
	        http.httpRequest({
	            url: '/pub/infobulletin/scenCheckTask.json',
	            data: {start: page*length,length: length,params:params},
	            success: function (data) {
	            	var itemCount = data.recordsTotal;
	            	if(itemCount != 0){
	            		$("#pageforhide100").show();
	            		$("#nodata100").text("").hide();
	            		$('#pagination100').pagination(itemCount, {
		                    prev_text: '<i class="icon-triangle-left"></i>上一页',
		                    next_text: '下一页<i class="icon-triangle-right"></i>',
		                    num_display_entries: 3,
		                    num_edge_entries: 2,
		                    current_page: page,
		                    items_per_page:5,
		                    link_to: 'javascript:void(0)',
		                    ellipse_text: '...',
		                    first_text: '首页',
		                    last_text: '末页',
		                    callback:function(page,jq){
		                    	loadWorkPlanList(page,5);
		                    }
		                });
		                var myTemplate = handlebars.compile($("#notice_li_list").html());
		                $('#notice-list-id100').html(myTemplate(data));
		                $("#notice-list-id100 a").click(function(){
		                	var relateid = $(this).attr("linkUID");
		                	showdetail(relateid, 1, null);
		                });
		                $("#notice-total100").text(itemCount);
		                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
		                $("#notice_pageNum100").text(pageNum);
	            	}else{
	            		$("#notice-list-id100").html("");
	            		$("#pageforhide100").hide();
	            		$("#nodata100").show().text("暂无抽查工作计划公告");
	            	}
	            }
	        });
	    }
	 
	 function loadScTaskList(page, length,callback) {
		 	var pubTitle = $("#pubTitle").val();
			var regOrgLike = $("#regOrgLike").val();
	    	var params = {checkCode:2,pubTitle:pubTitle,auditArea:regOrgLike};
	        http.httpRequest({
	            url: '/pub/infobulletin/scenCheckTask.json',
	            data: {start: page*length,length: length,params:params},
	            success: function (data) {
	            	var itemCount = data.recordsTotal;
	            	if(itemCount != 0){
	            		$("#pageforhide200").show();
	            		$("#nodata200").text("").hide();
	            		$('#pagination200').pagination(itemCount, {
		                    prev_text: '<i class="icon-triangle-left"></i>上一页',
		                    next_text: '下一页<i class="icon-triangle-right"></i>',
		                    num_display_entries: 3,
		                    num_edge_entries: 2,
		                    current_page: page,
		                    items_per_page:5,
		                    link_to: 'javascript:void(0)',
		                    ellipse_text: '...',
		                    first_text: '首页',
		                    last_text: '末页',
		                    callback:function(page,jq){
		                    	loadScTaskList(page,5);
		                    }
		                });
		                var myTemplate = handlebars.compile($("#notice_li_list").html());
		                $('#notice-list-id200').html(myTemplate(data));
		                $("#notice-list-id200 a").click(function(){
		                	var relateid = $(this).attr("linkUID");
		                	showdetail(relateid, 2, null);
		                });
		                $("#notice-total200").text(itemCount);
		                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
		                $("#notice_pageNum200").text(pageNum);
	            	}else{
	            		$("#notice-list-id200").html("");
	            		$("#pageforhide200").hide();
	            		$("#nodata200").show().text("暂无抽查任务公告");
	            	}
	            }
	        });
	    }
	 
	 function loadScResultList(page, length,callback) {
		 	var pubTitle = $("#pubTitle").val();
			var regOrgLike = $("#regOrgLike").val();
	    	var params = {checkCode:3,pubTitle:pubTitle,auditArea:regOrgLike};
	        http.httpRequest({
	            url: '/pub/infobulletin/scenCheckTask.json',
	            data: {start: page*length,length: length,params:params},
	            success: function (data) {
	            	var itemCount = data.recordsTotal;
	            	if(itemCount != 0){
	            		$("#pageforhide300").show();
	            		$("#nodata300").text("").hide();
	            		$('#pagination300').pagination(itemCount, {
		                    prev_text: '<i class="icon-triangle-left"></i>上一页',
		                    next_text: '下一页<i class="icon-triangle-right"></i>',
		                    num_display_entries: 3,
		                    num_edge_entries: 2,
		                    current_page: page,
		                    items_per_page:5,
		                    link_to: 'javascript:void(0)',
		                    ellipse_text: '...',
		                    first_text: '首页',
		                    last_text: '末页',
		                    callback:function(page,jq){
		                    	loadScResultList(page,5);
		                    }
		                });
		                var myTemplate = handlebars.compile($("#notice_li_list").html());
		                $('#notice-list-id300').html(myTemplate(data));
		                $("#notice-list-id300 a").click(function(){
		                	var relateid = $(this).attr("linkUID");
		                	showdetail(relateid, 3, null);
		                });
		                $("#notice-total300").text(itemCount);
		                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
		                $("#notice_pageNum300").text(pageNum);
	            	}else{
	            		$("#notice-list-id300").html("");
	            		$("#pageforhide300").hide();
	            		$("#nodata300").show().text("暂无检查结果公告");
	            	}
	            }
	        });
	    }
	 
	    //进入详情页面
		function showdetail(linkUID,state,entName){
			var pubType = null;
			http.httpRequest({
	            url: '/pub/infobulletin/enCode',
	            serializable: false,
	            data: {pubType:state,entName:entName},
	            type: 'get',
	            success: function (data) {
	            	pubType = data.data.pubType;
	            	entName = data.data.entName;
	            	window.open('/pub/infobulletin/viewScCheck?relatedId='+linkUID+"&pubType="+pubType+"&entName="+entName);
	            }
	        });
		}
	
    //加载
	function loadScCheckList(state){
		if(state == '100'){
    		if($("#sccheckinfo").hasClass("selected")){
    			$(".bulletin-type").hide();
        		$(".info-spotbull").show();
        		loadWorkPlanList(0,5);
        		loadScTaskList(0,5);
        		loadScResultList(0,5);
    		}else{
    			loadScenCheckTaskList(0,10);
    		}
		}
	}
	
	function restoreDefalut(state){
		//搜索条件置空，区域筛选回复默认
    	$("#pubTitle").val("");
    	$("#regOrgLike").val("");
    	$(".notice-area a").each(function(){
    		$(this).removeClass("selected");
    	});
    	$("#notice-area-id a:first").addClass("selected");
	}
	 
	 function bind() {
	        util.bindEvents([
	        {
	            el: '.subnavbar a',
	            event: 'click',
	            handler: function() {
	            	$(".sidebar a").each(function(){
	            		$(this).removeClass('selected');
	            	})
	            	$(this).addClass("selected");
	            	$(".bulletin-type").hide();
	            	$("#single-box").show();
	            	$("#border-title span").text($(this).attr("desc"));
	            	state = $(this).attr("state")
	            	checkCode = $(this).attr("checkCode");
	            	//初始化
	            	restoreDefalut(state);
	            	//加载
	            	loadScCheckList (state);
	             }
	        },{
	            el: '.info',
	            event: 'click',
	            handler: function() {
	            	state =	$(this).attr("state");
	            	$(".sidebar a").each(function(){
	            		$(this).removeClass('selected');
	            	})
	            	$(this).addClass("selected");
	            	//初始化
	            	restoreDefalut(state);
	            	//加载
	            	loadScCheckList (state);
	             }
	        },{
	        	el: '.notice-area a',
	            event: 'click',
	            handler: function() {
	            	var regOrgLike = $(this).attr("regOrgLike");
	            	$(".notice-area a").each(function(){
	            		if($(this).attr("regOrgLike") == regOrgLike){
	            			$(this).addClass('selected');
	            			$("#regOrgLike").val(regOrgLike);
	            		}else{
	            			$(this).removeClass('selected');
	            		}
	            	});
	            	loadScCheckList (state);
	             }
	        },{
	            el: '#search_notice_list',//标题查询
	            event: 'click',
	            handler: function() {
	            	loadScCheckList (state);
	             }
	        }])
	    }
	 
})

