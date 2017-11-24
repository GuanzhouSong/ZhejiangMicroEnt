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
                url:'/syn/server/drcheck/pubscagent/chooseagent',
                data:function(d){
	               	d.params = $("#chooseagentform").serializeObject();
                }
            },
            columns: [
                {data: "id", "className": "center"},
                {data: "agentName", "className": "center"},
                {data: "employeeNO", "className": "center"},
                {data: "orgName", "className": "center"},
                {data: "deptCatg", "className": "center"},
                {data: "stationTerm", "className": "center"},
                {data: "agentRange", "className": "center"},
                {data: null, "className": "center"}
            ],
            columnDefs: [{
		        	targets:7,
		        	render:function(data,type,row,meta){
		        		return "<a class='pointer adjust' value='"+row.uid+"'>指定</a>";
		        	}
		         }
             ]
        });
    }
    
    $("#search").click(function(){
        table.ajax.reload();
    }); 
    
    function bind() {
        util.bindEvents([{
            el: '.adjust',
            event: 'click',
            handler: function () {
            	var agentUids = $("#agentUids").val();
            	var data = table.row($(this).closest('td')).data();
            	layer.confirm('是否确认指定【<span style="color:red">'+data.agentName+'</span>】为新的执法人员？', {icon: 2, title: '提示'}, function () {
	            	http.httpRequest({
						url: '/syn/server/drcheck/pubscinfoagent/commit',
						serializable: false,
						type:"post",
						data:{adjustUid:data.uid,agentUids:agentUids},
						success: function (data) {
							layer.msg(data.msg, {time: 1000}, function () {
								if(data.status == 'success'){
									layer.close({reload: true});
								}
							});
						}
					});	
            	})
             }
        }]);
     }
});
