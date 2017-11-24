require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','pagination'], function (layer, dataTable, util, http, handlebars) {
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	//加载
		loadListData(0,10);
    }
    
    $("#details").click(function(){
    	$("#viewdetails").show();
    })
    $(".closemarkcss").click(function(){
    	$("#viewdetails").hide();
    })
	
	 function loadListData(page, length,callback) {
		    var uid = $("#uid").val(); 
	    	var params = {pubTaskUid:uid};
	        http.httpRequest({
	            url: '/pub/infobulletin/spottask',
	            data: {start: page*length,length: length,params:params},
	            type: 'post',
	            success: function (data) {
	            	var itemCount = data.recordsTotal;
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
	                    	loadListData(page,10);
	                    }
	                });
	                var dataList = data.data;
	                for(var i=0;i < dataList.length;i++){
	                	if(dataList[i].uniCode !=null && dataList[i].uniCod != ''){
	                		dataList[i].regNO = dataList[i].uniCode;
	                	}
	                }
	                var handleHelper = handlebars.registerHelper("xh",
	                		function(index) {return index+1+(page*10);
	                });
	                var myTemplate = handlebars.compile($("#noticelist").html());
	                $('#pageList').html(myTemplate(data));
	                $("#info_total").text(itemCount);
	                var pageNum = itemCount%10==0?itemCount/10:Math.ceil(itemCount/10);
	                $("#info_pageNum").text(pageNum);
	            }
	        });
	    }
})

