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
                {data: null, "className": "center"}, 
                {data: "agentName", "className": "center"},
                {data: null, "className": "center"}, 
                {data: "entName", "className": "center"}, 
                {data: "taskCode", "className": "center"},
                {data: "taskName", "className": "center"}
            ],
            columnDefs: [{
            	targets:1,
    	        render:function(data,type,row,meta){
    	        	return "<input type='checkbox' value='"+data.uid+"'/>";
    	       }
	        },{
	        	targets:3,
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
        util.bindEvents([{
            el: '#chooseAll',
            event: 'click',
            handler: function () {
            	if($(this).prop("checked")){
					 $("#agent-table input").prop("checked",true);
				 }else{
					 $("#agent-table input").prop("checked",false);
				 }
            }
        },{
            el: '#adjust',
            event: 'click',
            handler: function () {
            	var deptCode = $("#deptCode").val();
            	var checkFlag = false;
            	var uidArray = new Array();
            	$("#agent-table input").each(function(){
            		if($(this).prop("checked")){
            			checkFlag = true;
            			uidArray.push($(this).val());
            		}
            	})
            	var agentUids = uidArray.toString();
            	if(checkFlag){
            		layer.dialog({
            			title:"执法人员调整",
            			area:['90%','80%'],
            			content:'/syn/server/drcheck/pubscinfoagent/chooseagent?deptCode='+deptCode+'&agentUids='+agentUids,
            			callback:function(data){
            				if(data.reload){
            					table.ajax.reload();
            				}
            			}
            		});
                }else{
                	layer.msg("请先选择一条执法人员记录！", {icon: 7,time: 1000});
                	return false;
                }	
            }
        }]);
    }
});
