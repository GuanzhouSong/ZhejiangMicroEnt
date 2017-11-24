require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','pagination','common/validateRules'],
		function (layer, dataTable, util, http, handlebars) {
	
	init();
	
	function init() {
		loadNoticeListData(0,5);
	}
	$(".notice-area a").hover(function () {
        $(this).addClass('selected');
    }, function () {
        $(this).removeClass('selected');
    });
	
	$("#search_notice_list").click(function(){
		loadNoticeListData(0,5);
	});
	$('#speCauseCN').keydown(function(e){
	    if(e.keyCode == 13){
	    	loadNoticeListData(0,5);
	    }
	});
	
	 function loadNoticeListData(page, length, callback) {
		var notice_state = $("#notice_state").val();
		var speCauseCN = $("#speCauseCN").val();
		var regOrgLike;
		$("notice-area-id a").each(function(){
			var selected = $(this).attr("class");
			if(selected == "selected"){
				regOrgLike = $(this.attr("regOrgLike"));
			}
		});
    	var params = {state:notice_state,speCauseCN:speCauseCN};
        http.httpRequest({
            url: '/pub/client/pubopanomaly/list.json',
            data: {start: page*length,length: length,params:params},
            success: function (data) {
            	var itemCount = data.recordsTotal;
                $('.pagination').pagination(itemCount, {
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
                    	loadNoticeListData(page,5);
                    }
                });
                var myTemplate = handlebars.compile($("#notice_li_list").html());
                $('#notice-list-id').html(myTemplate(data));
                $("#notice-list-id a").click(function(){
                	var noticeidvalue = $(this).attr("noticeidvalue");
                	showdetail(noticeidvalue);
                });
                $("#notice-total").text(itemCount);
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $("#notice_pageNum").text(pageNum);
            }
        });
    }
	 
	function showdetail(id){
		window.open('http://localhost:8083/pub/client/pubopanomaly/showdetail?id='+id+"&state="+$("#notice_state").val());
	}
});
