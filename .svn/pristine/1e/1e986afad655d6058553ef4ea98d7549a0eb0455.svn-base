require(['common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','pagination'], function (util, http, handlebars) {
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	loadSupportInfoTable();
    }
    //嵌入列表加载
	 function loadSupportInfoTable() {
	        http.httpRequest({
	            url: '/pub/smallentsupport/list.json',
	            type:'get',
	            success: function (data) {
	            	var backlist = data.data;
	            	if(backlist !=null){
	            		var showArray = new Array();
		            	for(var i=0;i<6;i++){
		            		showArray.push(backlist[i]);
		            	}
		            	data.data = showArray;
	            	}
	                var myTemplate = handlebars.compile($("#supportTemplate").html());
	                $('#smallentgrid').html(myTemplate(data));
	                $(".doView").click(function(){
	                	var uid = $(this).attr("_id");
	                	window.open('/pub/smallentsupport/details?UID='+uid);
	                });
	            }
	        });
	    }

})
