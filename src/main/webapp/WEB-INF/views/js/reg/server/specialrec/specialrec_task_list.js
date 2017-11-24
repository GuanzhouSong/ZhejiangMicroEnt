require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
    var searchParams={};//查询参数声明!
    var table;
  
    init();
  
    
    var startNorDate = {
            elem: '#startInfaustlDate',
            format: 'YYYY-MM-DD',
            min: '1970-01-01', 
            max: '2099-06-16',
            istime: true, 
            istoday: false, 
            start: laydate.now(0,"YYYY-MM-DD"), 
            choose: function(datas){
            	endNorDate.min = datas;
            	endNorDate.start = datas
            }
        };
        var endNorDate = {
            elem: '#endInfaustlDate',
            format: 'YYYY-MM-DD',
            min: '1970-01-01',
            max: '2099-06-16',
            istime: true,
            istoday: false,
            startNorDate: laydate.now(0,"YYYY-MM-DD"),
            choose: function(datas){
            	startNorDate.max = datas;
            }
        }; 
    $("#startInfaustlDate").click(function(){laydate(startNorDate);});
    $("#endInfaustlDate").click(function(){laydate(endNorDate);});
    
    
    
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
     	searchParams = $("#taskForm").serializeObject();
        table = dataTable.load({
            el: '#specialrec_table',
 			scrollX:true,
            showIndex: true,
            ajax: {
                url:window._CONFIG.chooseUrl+'/server/specialrec/task/list.json',
                data:function(d){ 
                	d.params = searchParams;
                }
            },
            columns: [ 
					{data: null,'defaultContent':'11'},
					{data: null,width:"100px"},
					{data: 'taskCode'},
					{data: 'taskName',cut: {length: 20,mark:'...'}},
					{data: 'taskType'},
					{data: 'taskState'},
					{data: 'checkEntTotal',width:"100px"},
					{data: 'completedTotal',width:"100px"},
					{data: 'taskStartTime'},
					{data: 'taskEndTime'},
					{data: 'partiDeptName',cut: {length: 20,mark:'...'}},
					{data: 'orgDeptName',cut: {length: 20,mark:'...'}},
					{data: 'setUserName'},
					{data: 'setTime'}
    				
            ] ,
            columnDefs: [{
                             targets: 1,
                             render: function (data, type, row, meta) { 
                            	 var taskState = row.taskState;
                            	 if(taskState == "01"){
                            		 return  '<a class="editdata link" id="'+row.uid+'"  href="javascript:void(0);" style="color:blue;">修改</a>'+
                              	    		 '<a class="delete link" id="'+row.uid+'"  href="javascript:void(0);" style="color:blue;">删除</a>'; 
	                           	 }else if(taskState == "02" || taskState == "03"){
	                           		 return '<a class="view link" id="'+row.uid+'"  href="javascript:void(0);" style="color:blue;">详情</a>'; 
	                           	 }else{
	                           		 return "-";
	                           	 }
                             }
                          },{
                              targets: 4,
                              render: function (data, type, row, meta) { 
                             	 if(row.taskType == "1"){
                             		return "本部门专项整治检查";
                             	 }else if(row.taskType == "2"){
                             		return "跨部门专项整治检查";
                             	 }else {
                             		return "";
                             	 } 
                              }
                           },{
                                targets: 5,
                                render: function (data, type, row, meta) { 
                                	if("01" == data){
                              			return '<span style="color:red;">待执行</span>'; 
	                              	 }else if("02" == data){
	                              		 return "执行中";
	                              	 }else if("03" == data){
	                              		 return "已完成";
	                              	 }else {
	                              		 return "";
	                              	 } 
                                }
                             },
            ],
            "fnDrawCallback": function (oSettings) {
             	http.httpRequest({ 
                     url: window._CONFIG.chooseUrl+'/server/specialrec/task/count.json',
                     serializable: false,
                     type:'post',
                     data: {params:searchParams} ,
                     success: function (data) {
                    	if(data.data != null){
                    		var dataobj = data.data;
                         	$("#totalall").text(dataobj.totalall==null?'0':dataobj.totalall);
                         	$("#dzxgs").text(dataobj.dzxgs==null?'0':dataobj.dzxgs);
                         	$("#zxzgs").text(dataobj.zxzgs==null?'0':dataobj.zxzgs);
                         	$("#ywcgs").text(dataobj.ywcgs==null?'0':dataobj.ywcgs);
                         	$("#xjcgs").text(dataobj.xjcgs==null?'0':dataobj.xjcgs);
                         	$("#yjcgs").text(dataobj.yjcgs==null?'0':dataobj.yjcgs);
                    	}
                     }
                 });
             }
         })
    } 
     
    
    function bind() {
        util.bindEvents([
      {
            el: '.editdata',
            event: 'click',
            handler: function () { 
            	var data = table.row($(this).closest('td')).data();
            	layer.dialog({
                    title: '修改抽查任务',
                    area: ['95%', '98%'],
                    content:window._CONFIG.chooseUrl+'/server/specialrec/task/addOrmodify?flag=2'+'&recTaskUid='+data.uid,
                    callback: function(data) {
                    	if(typeof data.status!="undefined"){
                      		 if(data.status=="success"){ 
                          		 layer.msg("修改成功", {time: 2000}, function () {
                          			  table.ajax.reload(); 
                                 });
                          	 }
                      	 }
                    }
                })
            }
        },{
            el: '.view',
            event: 'click',
            handler: function () { 
            	var data = table.row($(this).closest('td')).data();
           	 	var uid=data.uid;
            	layer.dialog({
                    title: '查看详情',
                    area: ['95%', '98%'],
                    content:window._CONFIG.chooseUrl+'/server/specialrec/task/addOrmodify?flag=3'+'&recTaskUid='+data.uid,
                    callback: function(data) {
                    	 
                    }
                })
            }
        },{
            el: '#add',
            event: 'click',
            handler: function () { 
            	layer.dialog({
                    title: '添加新检查任务',
                    area: ['95%', '98%'],
                    content:window._CONFIG.chooseUrl+'/server/specialrec/task/addOrmodify?flag=1',
                    callback: function(data) {
                    	if(typeof data.status!="undefined"){
                      		 if(data.status=="success"){ 
                          		 layer.msg("添加成功", {time: 2000}, function () {
                          			  table.ajax.reload(); 
                                 });
                          	 }  
                      	 }
                    }
                })
            }
        },{
            el: '.delete',
            event: 'click',
            handler: function () { 
            	var data = table.row($(this).closest('td')).data(); 
            	layer.confirm('确定要删除吗?', {icon: 3, title: '提示'}, function () { 
	                http.httpRequest({
	                    type: 'post',
	                    url: window._CONFIG.chooseUrl+'/server/specialrec/task/delete',
	                    data: {recTaskUid: data.uid},
	                    success: function (data) {
	                        if (data.status == 'success') {  
				                layer.msg("删除成功", {time: 2000}, function () {
				                	table.ajax.reload();
				                }); 
	                        }else{
	                        	layer.msg(data.msg, {ltype: 0,time:3000});
	                        } 
	                    }
	                });
                })
            }
         },{
        	el: '#search',
            event: 'click',
            handler: function () { 
            	searchParams = $("#taskForm").serializeObject();
            	table.ajax.reload();
            }
        }
      ]);
   }
})
