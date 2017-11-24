require(['component/iframeLayer', 'component/dataTable','common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {
	init();
	var infotable;
	
    /**
	 * 初始化函数集合
	 */
    function init() { 
        bind();
        infotable = dataTable.load({
            el: '#info-table',
            showIndex: true,
            scrollX: true,
            ajax: {
                url:'/syn/pub/server/drcheck/pubscinfo/resultlist.json',
                data:function(d){
	               	d.params = $("#scinfoAgentResultForm").serializeObject();
                }
            },
            columns: [
                {data: "id", width:"40px","className": "center"},
                {data: null,width:"40px", "className": "center"}, 
                {data: "entName",width:"250px", "className": "center"}, 
                {data: "agentName", width:"100px","className": "center"}
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
    
    function bind() {
    	util.bindEvents([{
            el: '#closeBtn',
            event: 'click',
            handler: function () {
            	layer.close({reload: false});
            }
        }]);
    }
    	

});
