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
                url:'/reg/server/smstask/list.json',
                data:function(d){
	               	d.params = searchParams;
                }
            },
            columns: [
                {data: null,width:'50px','defaultContent': '111'},   
                {data: null,width:'80px','defaultContent': '111'},
                {data: 'taskid',width:'100px'},
                {data: 'taskName',width:'120px'},
                {data: 'taskType',width:'100px'},
                {data: null,width:'80px','defaultContent': '111'},
                {data: 'smsType',width:'100px'},
                {data: 'smsIntroduction',width:'100px'},
                {data: 'smsDate',width:'80px'},
                {data: 'setName',width:'80px'},
                {data: 'setTime',width:'80px'},
                {data: 'deptName',width:'80px'}
            ],
            columnDefs: [
                          {
	             	         targets:1,
	             	         render:function(data,type,row,meta){
	             	        	if (row.taskType == '1') { 
	             	        		//return "<a class='alter'>修改</a>&nbsp;<a class='delete'>删除</a>";
		                    	    return "<a class='delete'>删除</a>";
		                    	}else{
		                    		return "<a class='view'>详情</a>";
		                    	}  
	             	         }
	                      },{
	             	         targets:4,
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
	                     },{
	             	         targets:6,
	             	         render:function(data,type,row,meta){
	             	        	if (row.smsType == '1') { 
		                    	    return "年报提醒（适用企业、农专社）";
		                    	}else if(row.smsType == '2'){
		                    		return "年报提醒（适用个体户）";
		                    	}else{
		                    		return "";
		                    	}  
	             	         }
	                      },{
	             	         targets:5,
	             	         render:function(data,type,row,meta){
	             	        	if (row.smsLerep == '1' && (row.smsLia == null || row.smsLia =='')) { 
		                    	    return "负责人";
		                    	}else if(row.smsLia == '1' && (row.smsLerep == null || row.smsLerep == '')){
		                    		return "联络员";
		                    	}else if(row.smsLia == '1' && row.smsLerep == '1'){
		                    		return "负责人、联络员";
		                    	}else{
		                    		return "";
		                    	}  
		             	     }
		                  }
                     ]
        })
    }
    
    //选中负责人
    $("#smsLerep").click(function(){
    	if($(this).prop("checked")){
    		$("#isLerep").val('1');
    	}else{
    		$("#isLerep").val('');
    	}
    })
    //选中联络员
     $("#smsLia").click(function(){
    	if($(this).prop("checked")){
    		$("#isLia").val('1');
    	}else{
    		$("#isLia").val('');
    	}
    })

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
            	window.location.href='/reg/server/smstaskinfo/addSmsList';
            }
        },{
            el: '.view',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
            	layer.dialog({
                    title: '短信任务详情',
                    area: ['1200px', '600px'],
                    content: '/reg/server/smstaskinfo/taskDetail?uid='+data.uid,
                    callback: function (data) {
                    }
                })
            	//window.location.href='/reg/server/smstaskinfo/taskDetail?taskId='+data.taskid;
            }
        },{
            el: '#smsTypeFind',
            event: 'click',
            handler: function () {
            	layer.dialog({
                    title: '短信类别查看',
                    area: ['800px', '400px'],
                    content: '/reg/server/smstaskinfo/smsTypeFind',
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
