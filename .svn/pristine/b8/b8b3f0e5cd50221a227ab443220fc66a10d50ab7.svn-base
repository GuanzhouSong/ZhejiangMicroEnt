require(['layer1', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','pagination'], function (layer, dataTable, util, http, handlebars) {
    init();
    /**
     * 初始化函数集合
     */
    
    function init() {
    	bind();
    	
    	loadListData(0,10);
    }
    
    
	 function loadListData(page, length,callback) {
		    var params = {relatedUid: $("#uid").val()};
	        http.httpRequest({
	            url: '/pub/infobulletin/spotresult',
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
	                
	                var handleHelper = handlebars.registerHelper("xh",
	                		function(index) {return index+1+(page*10);
	                });
	                
	                handlebars.registerHelper("taskTypeDesc",function(value,options){
        				if(value=='1'){
        					return "定向";
        				}else if(value=='2'){
        					return "不定向";
        				}else{
        					return "-";
        				}
    			　　});
	                
	                handlebars.registerHelper("checkDateFormat",function(value,options){
	                	if(value != null && value !="" && value !="undefine"){
	                		return value.replace('-','').replace('-','');
	                	}
	                });
	                
	                handlebars.registerHelper("auditStateForm",function(value,options){
	                	if(value == "5"){
	                		return "详细";
	                	}else{
	                		return "";
	                	}
	                });
	                
	                var myTemplate = handlebars.compile($("#noticelist").html());
	                $('#pageList').html(myTemplate(data));
	                $("#info_total").text(itemCount);
	                var pageNum = itemCount%10==0?itemCount/10:Math.ceil(itemCount/10);
	                $("#info_pageNum").text(pageNum);
	            }
	        });
	    }
	 
	 function bind() {
	        util.bindEvents([
	        {
	            el: '.resultItem',
	            event: 'click',
	            handler: function() {
	            	var $obj = $(this);
	            	var priPID = $obj.attr("priPID");
	            	var taskUid = $obj.attr("taskUid");
	            	window.open('/pub/infobulletin/spotResultIetm?priPID='+priPID+"&taskUid="+taskUid);
	             }
	       }])
	   
	 }
})

