require(['component/iframeLayer', 'component/dataTable','common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {
	init();
	
    /**
	 * 初始化函数集合
	 */
    function init() { 
    	initDataTable();
    	bind();
    }
    
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            el: '#agent-table',
            showIndex: true,
            ajax: {
                url:'/syn/server/drcheck/pubscinfoagent/adjust.json',
                data:function(d){
	               	d.params = $("#chooseagentform").serializeObject();
                }
            },
            columns: [
                {data: "id", "className": "center"},
                {data: "taskCode", "className": "center"},
                {data: "taskName", "className": "center"},
                {data: "entName", "className": "center"}, 
                {data: null, "className": "center"}, 
                {data: "agentName", "className": "center"}
            ],
            columnDefs: [{
	        	targets:4,
	        	render:function(data,type,row,meta){
	        		if(row.auditState == null || row.auditState == "" || row.auditState == "0"){
    	        		return "待录入";
    	        	}else if(data.auditState == "1"){
    	        		return "待审核";
    	        	}else if(data.auditState == "2"){
    	        		return "同意";
    	        	}else if(data.auditState == "3"){
    	        		return "不同意";
    	        	}else if(data.auditState == "5"){
    	        		return "退回修改";
    	        	}else{
    	        		return "";
    	        	}
	        	}
	          }
           ]
        });
    }
    
    $("#search").click(function(){
        table.ajax.reload();
    }); 
    
    function bind() {
        util.bindEvents([
       ]);
    }
});
