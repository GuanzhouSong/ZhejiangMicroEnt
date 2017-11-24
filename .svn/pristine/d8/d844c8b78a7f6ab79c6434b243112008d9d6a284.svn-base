require(['component/iframeLayer', 'component/dataTable','common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {
	init();
	var agenttable;
	
    /**
	 * 初始化函数集合
	 */
    function init() { 
        bind();
        initotherTable();
    }
    
    /**
     * 初始化dataTable
     */
    function initotherTable() {
    	agenttable = dataTable.load({
            //需要初始化dataTable的dom元素
            el: "#agentTableId",
            //是否加索引值
            showIndex: true,
            scrollX: true,
            ajax: {
                url:"/syn/pub/server/drcheck/pubsctaskagent/list.json",
                data:function(d){
	               	d.params = $("#backFormId").serializeObject();
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //'className'不要写成class
            columns: [
                {data: "id", width:"40px","className": "center"},
                {data: "unitCode", width:"100px","className": "center"}, 
                {data: "unitLevel", width:"100px","className": "center"}, 
                {data: "deptCodeDesc", width:"250px","className": "center"},
                {data: "deptCatg", width:"100px","className": "center"},
                {data: "agentName",width:"100px", "className": "center"},
                {data: "agentArea",  width:"100px","className": "center"},
                {data: "slicenNO",  width:"100px","className": "center"},
                {data: "agentRange", width:"100px", "className": "center"}
            ],
            columnDefs: [{
	        	targets:2,
	        	render:function(data,type,row,meta){
	        		if(row.unitLevel!=null&&row.unitLevel!=""){
	        			 if(row.unitLevel=="1"){
	        				 return "市级";
	        			 } else if(row.unitLevel=="2"){
	        				 return "县级";
	        			 }else{
	        				 return "";
	        			 }
	        			 
	        		}
	        		
	        	}
	        }]
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
