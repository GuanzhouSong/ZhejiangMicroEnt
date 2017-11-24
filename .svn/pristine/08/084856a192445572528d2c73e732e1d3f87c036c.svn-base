require(['component/iframeLayer', 'component/dataTable','common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {
	init();
	
    /**
	 * 初始化函数集合
	 */
    function init() { 
        bind();
        var userType = $("#userType").val();
        var url = '/reg/pub/server/sccheck/entagent/listJSON';
        if(userType == '2'){
        	url = '/syn/pub/server/sccheck/entagent/listJSON';
        }
        dataTable.load({
            el: '#info-table',
            showIndex: true,
            scrollX: true,
            ajax: {
                url:url,
                data:function(d){
	               	d.params = $("#scentAgentForm").serializeObject();
                }
            },
            columns: [
                {data: '_idx',"className": "center"},
                {data: null, "className": "center"}, 
                {data: "entName", "className": "center"}, 
                {data: "agentNames","className": "center"}
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
