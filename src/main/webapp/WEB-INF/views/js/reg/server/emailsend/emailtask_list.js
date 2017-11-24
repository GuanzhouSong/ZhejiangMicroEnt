require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {
    var searchParams={};
    var table;
	
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
    }
    
    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            el: '#user-table',
            showIndex: true,
			scrollX:true,
            ajax: {
                url:'/reg/server/emailtask/emailtasklist.json',
                data:function(d){
	               	d.params = searchParams;
                }
            },
            columns: [
                {data: null},   
                {data: null},
                {data: 'taskName'},
                {data: 'taskType'},
                {data: 'startTime'},
                {data: 'setName'},
                {data: 'setTime'},
                {data: 'deptName'}
            ],
            columnDefs: [
                          {
	             	         targets:1,
	             	         render:function(data,type,row,meta){
	                    		return "<a class='view'>详情</a>";
	             	         }
	                      },{
	             	         targets:3,
	             	         render:function(data,type,row,meta){
	             	        	if (row.taskType == '1') { 
		                    	    return "待发送";
		                    	}else if(row.taskType == '2'){
		                    		return "发送中";
		                    	}else if(row.taskType == '3'){
		                    		return "已结束";
		                    	}else{
		                    		return "";
		                    	}    
	             	         }
	                     }
                     ]
        })
    }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#searchForm").serializeObject();
        table.ajax.reload();
    });
    
    function bind() {
        util.bindEvents([
		{
		    el: '.delete',
		    event: 'click',
		    handler: function () {
		    	 var data = table.row($(this).closest('td')).data();
	        	 layer.confirm('删除后将不能恢复，确认要删除此任务吗？', {icon: 2, title: '提示'}, function (index) {
	        		 http.httpRequest({
                         url: '/reg/server/smstask/delete',
                         data: {taskid:data.uid},
                         serializable: false,
                         type: 'get',
                         success: function (data) {
                             if(data.status=='success'){
                            	 layer.msg(data.msg, {time: 1000}, function () {
                            		 window.location.reload();
                            	 })
                             }
                         }
                     });
	        		 layer.close(index);
	             });
		    }
		},{
            el: '#addTask',
            event: 'click',
            handler: function () {
            	window.location.href='/reg/server/emailtaskinfo/addemaillist';
            }
        },{
            el: '.view',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
            	layer.dialog({
                    title: '邮件任务详情',
                    area: ['1200px', '600px'],
                    content: '/reg/server/emailtaskinfo/taskDetail?uid='+data.uid,
                    callback: function (data) {
                    }
                })
            }
        },{
            el: '#choseDept',
            event: 'click',
            handler: function () {
                layer.dialog({
                    title: '选择部门',
                    area: ['400px', '600px'],
                    content: window._CONFIG.select_detp_tree_url,
                    callback: function (data) {
                        $("#regOrg").val(data.deptId);
                        $("#regOrgName").val(data.deptName);
                    }
                })
            }
        },{
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	$("#regOrg").val("");
            	$("#isLerep").val('');
            	$("#isLia").val('');
            }
        }])
    }

})
