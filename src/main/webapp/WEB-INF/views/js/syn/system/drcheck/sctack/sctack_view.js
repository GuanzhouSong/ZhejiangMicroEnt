require(['component/iframeLayer', 'component/dataTable','common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {
	var params={};//查询参数声明! 
	init();
	    /**
		 * 初始化函数集合
		 */
	    function init() { 
	        initDataTable();
	        bind();
	        loadTotal();
	    }
	    
	    
	    var infotable;

	    /**
		 * 初始化dataTable
		 */
	    function initDataTable() {
	    	infotable = dataTable.load({
	            // 需要初始化dataTable的dom元素
	            el: '#info-table',
	            // 是否加索引值
	            showIndex: true,
	            scrollX: true,
	            ajax: {
	                url:'/syn/pub/server/drcheck/pubscinfo/randomlist.json',
	                data:function(d){
		               	d.params = $("#paramForm").serializeObject();
	                }
	            },
	            // 需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
	            // 'className'不要写成class
	            columns: [
	                {data: "id", width:"40px","className": "center"},
	                {data: null,width:"40px", "className": "center"}, 
	                {data: "entName",width:"250px", "className": "center"}, 
	                {data: "leRep", width:"100px","className": "center"},
	                {data: "tel", width:"100px","className": "center"},
	                {data: "liaName", width:"100px","className": "center"},
	                {data: "leRepPhone",width:"100px", "className": "center"},
	                {data: "estDate",width:"100px", "className": "center"},
	                {data: "entTypeCatgDesc",width:"250px", "className": "center"},
	                {data: "industryDesc", width:"250px","className": "center"}
	            ],
	            columnDefs: [{
	            	targets:1,
	    	        render:function(data,type,row,meta){
	    	        	if(data.uniCode != null && data.uniCode != ""){
		   					return data.uniCode;
		   				}else{
		   					return data.regNO;
		   				}
	    	       }
		        }]
	        });
	    }
	    
	    function loadTotal() {
	    	http.httpRequest({
				url: '/syn/pub/server/drcheck/pubscinfoback/count',
				serializable: false, 
				data: $("#paramForm").serializeObject(),
				type:"post",
				success: function (data) {
					var total = data.msg;
					$("#total").val(total);
					$("#totalWating").html("共"+total+"户");
				}
			});
	    }
	    
	    function bind() {
	        util.bindEvents([{
	        	 el: '#close',
	             event: 'click',
	             handler: function () { 
	            	layer.close(); 
	             }
	          }
	       ]);
	    }
});
