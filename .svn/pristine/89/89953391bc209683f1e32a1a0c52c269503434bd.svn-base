require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate', 'common/ajaxfileupload','pagination'], function (layer, dataTable, util, http,handlebars) {
    init();

	function init() {
        _bind();
    }

    function _bind() {
    	util.bindEvents([{
            el: '.dutycode',
            event: 'click',
            handler: function () {
               var dutyCode = $(this).attr("dutycode");
               $("#dutyDeptCode").val(dutyCode);
               $(".dutycode").each(function(){
            	  $(this).removeClass("cur");
               });
               $(this).addClass("cur");
               search();
            }
        },{
            el: '.opetype',
            event: 'click',
            handler: function () {
            	$("#operateli .cur").removeClass("cur");
            	$(this).addClass("cur");
            	//切换项目
            	changeDivContent();
            	//更新
                search();
            }
        }]);
    }
    
    function changeDivContent(){
    	var opetype = $("#operateli .cur").attr("opetype");
    	for(var i = 1;i<=4;i++){
    		var str = i+"";
    		if(opetype == str){
    			$("#divcontent"+i).show();
    		}else{
    			$("#divcontent"+i).hide();
    		}
    	}
    }
     
     // 抽查计划公告
	 function loadWorkPlanList(page, length,callback) {
	        http.httpRequest({
	            url: '/pub/infobulletin/scenCheckTask.json',
	            data: {
	            	start: page*length,
	            	length: length,
	            	params:{checkCode:1}
	            },
	            success: function (data) {
	            	var itemCount = data.recordsTotal;
	            	if(itemCount == 0){
	            		$("#pageforhide2").hide();
	            		$("#nodata2").show().text("暂无抽查计划公告");
	            	}else{
	            		publicContent(data,page,itemCount,2);
		            }
               }
	     });
	}
	 
	 // 抽查任务公告
	 function loadScTaskList(page, length,callback) {
	        http.httpRequest({
	            url: '/pub/infobulletin/scenCheckTask.json',
	            data: {
	            	start: page*length,
	            	length: length,
	            	params:{checkCode:2}
	            },
	            success: function (data) {
	            	var itemCount = data.recordsTotal;
	            	if(itemCount == 0){
	            		$("#pageforhide3").hide();
	            		$("#nodata3").show().text("暂无抽查任务公告");
	            	}else{
	            		publicContent(data,page,itemCount,3);
		            }
               }
	     });
	}
	 
	 // 抽查结果公告
	 function loadScResultList(page, length,callback) {
	        http.httpRequest({
	            url: '/pub/infobulletin/scenCheckTask.json',
	            data: {
	            	start: page*length,
	            	length: length,
	            	params:{checkCode:3}
	            },
	            success: function (data) {
	            	var itemCount = data.recordsTotal;
	            	if(itemCount == 0){
	            		$("#pageforhide4").hide();
	            		$("#nodata4").show().text("暂无抽查结果公告");
	            	}else{
	            		publicContent(data,page,itemCount,4);
		            }
               }
	     });
	}
	 
	 
	 // 公共内容
	 function publicContent(data,page,itemCount,objItem){
	    $("#pageforhide"+objItem).show();
 		$("#nodata"+objItem).text("").hide();
 		$('#pagination'+objItem).pagination(itemCount, {
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
            	if(objItem==2){loadWorkPlanList(page,5);}
            	if(objItem==3){loadScTaskList(page,5);}
            	if(objItem==4){loadScResultList(page,5);}
             }
         });
         var myTemplate = handlebars.compile($("#notice_li_list").html());
         var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
         $('#list'+objItem).html(myTemplate(data));
         $("#notice-total"+objItem).text(itemCount);
         $("#notice_pageNum"+objItem).text(pageNum);
         $("#list"+objItem+" a").click(function(){
         	 alert("详情");
         });
	 }
    
    //根据tab类别查询
    function search(opetype){
    	var opetype = $("#operateli .cur").attr("opetype");
    	if(opetype == "1"){
    		//检查事项清单列表展示TODO
    		
    	}else if(opetype == "2"){
    		//抽查计划公告列表展示TODO
    		loadWorkPlanList(0,5);
    		
    	}else if(opetype == "3"){
    		//抽查任务公告展示TODO
    		loadScTaskList(0,5);
    		
    	}else if(opetype == "4"){
    		//抽查任务公告展示TODO
    		loadScResultList(0,5);
    		
    	}
    }
});
