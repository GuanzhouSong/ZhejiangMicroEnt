require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','pagination'], function (layer, dataTable, util, http,handlebars) {

    init();
    
    
    var startNorDate = {
            elem: '#taskStartTime',
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
            elem: '#taskEndTime',
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
    $("#taskStartTime").click(function(){laydate(startNorDate);});
    $("#taskEndTime").click(function(){laydate(endNorDate);});
    
    
    /**
     * 初始化函数集合
     */
    
    function init() {
    	loadBackTable();
        bind();
    }
    
    function loadBackTable(){
    	table = dataTable.load({
            el: '#scentback-table',
            showIndex: true,
            scrollX: true,
            ajax: {
                url:window._CONFIG.chooseUrl+'/server/specialrec/ent/list.json',
                data:function(d){
	               	d.params = $("#qryForm").serializeObject();
                }
            },
            columns: [
                {data: '_idx', 'className': 'center'},
                {data: null, 'className': 'center'}, 
                {data: 'regNO'},
                {data: 'entName'},
                {data: 'dom',cut: {length: 20,mark:'...'}},
                {data: 'regOrgName'},
                {data: 'localAdmName'}
            ],
            columnDefs: [{
				targets:1,
				render:function(data,type,row,meta){
					return '<input type="checkbox" name="pubscentbackchk" class="backchk" value="'+data.uid+'"/>';
				}
			},{
				targets:2,
				render:function(data,type,row,meta){
					if(row.uniCode&&row.uniCode!="null"){
						return row.uniCode;
					}else{
						return row.regNO;
					}
				}
			}]
        })
    }
    
    
    function validrecfrom(){
    	  var dutyDeptCode = $("#dutyDeptCode").val();
     	  if(dutyDeptCode == "" || dutyDeptCode == null){
     		  layer.msg("您的账号未设置对应的职能部门，请先设置职能部门！", {ltype: 0,time:2000});
	    	  return false;
     	  }
     	  var dutyDeptName = $("#dutyDeptCode").find("option:selected").text();
     	  $("#dutyDeptName").val(dutyDeptName);
     	  
     	  var crossDepartFlag=$("input[name='taskType']:checked").val();
      	  if(typeof crossDepartFlag=="undefined"||crossDepartFlag==null||crossDepartFlag==""){
      		  layer.msg("请选择任务类型", {ltype: 0,time:2000});
	    	  return false;
      	  }
	   	  var taskName=$.trim($("#taskName").val());
	   	  if(taskName==null||taskName==""){
	   		  layer.msg("任务名称不能为空", {ltype: 0,time:2000});
		      return false;
	   	  }
	   	  var taskInspectDeptCode=$.trim($("#taskInspectDeptCode").val());
		  var taskInspectDeptName=$.trim($("#taskInspectDeptName").val());
	      	  if((taskInspectDeptCode==null||taskInspectDeptCode=="")||(taskInspectDeptName==null||taskInspectDeptName=="")  ){
	      		  layer.msg("请选择参与部门", {ltype: 0,time:2000});
		    	  return false;
	      	  }
	   	  var taskStartTime=$.trim($("#taskStartTime").val());
	   	  var taskEndTime=$.trim($("#taskEndTime").val());
	   	  if((taskStartTime==null||taskStartTime=="")||(taskEndTime==null||taskEndTime=="")  ){
	   		  layer.msg("请选择任务期限", {ltype: 0,time:2000});
		      return false;
	   	  }
	   	  var taskArr = $(".dataTables_empty").text();
		  if(taskArr=="无"){
				layer.msg("请添加检查名单", {ltype: 0,time:2000});
				return false;
		  }
	   	  return true;
    }
     
    function bind() {
        util.bindEvents([
        {
            el: '#cancel',
            event: 'click',
            handler: function() {
            	layer.close();
            }
       },{
           el: '#choselicDeptType',
           event: 'click',
           handler: function () { 
               layer.dialog({
                   title: '选择职能部门',
                   area: ['400px', '600px'],
                   content: '/common/system/code_duty_dept/duty_dept_select',
                   callback: function (data) {  
                     $("#taskInspectDeptCode").val(data.deptCodes);
                   	 $("#taskInspectDeptName").val(data.deptNames); 
                   }
               })
           }
       },{
           el: '#save',
           event: 'click',
           handler: function() {
        	  if(validrecfrom()){
              	  var formParam=$('#favorableForm').serializeArray();
            	  http.httpRequest({ 
                       url: window._CONFIG.chooseUrl+'/server/specialrec/task/commitSpeciakrec',
                       data: formParam,
                       type: 'post',
                       success: function (data) {
                    	   if(data.status!=="success"){ 
                    		   layer.msg(data.msg, {time: 3000}, function () {});
                    	   }else{
                    		   layer.close(data);
                    	   }
                       }
                 });
        	  }
           }
      },{      
			el: '#addPage',
            event: 'click',
            handler: function () {
            	var taskUid = $("#taskUid").val();
            	layer.dialog({
		            title: '添加检查名单',
		            area: ['100%', '100%'],
		            content: window._CONFIG.chooseUrl+'/server/specialrec/task/addpage?taskUid='+taskUid,
		            callback: function (data) {
		            	if (data.reload) {
		            		$("#taskUid,#mainTaskUid").val(data.reBackUid);
		                	table.ajax.reload();
		                } 
		            }
		        })  
            }
        },{
        	el:'#delEntBack',//删除检查对象
        	event:'click',
        	handler:function(){
        		var pripIdList = new Array();
    			$("input:checkbox[name='pubscentbackchk']:checked").each(function () {
    				pripIdList.push($(this).val());
    			});
    			if (pripIdList.length > 0) {
    				layer.confirm('您确定要清除这一批待检查数据吗？', {icon: 2, title: '提示'}, function (index) {
    					http.httpRequest({
    						url: window._CONFIG.chooseUrl+'/server/specialrec/ent/delete',
    						data: {delUidList:pripIdList.toString()},
    						type:"post",
    						success: function (data) {
    							layer.msg(data.msg, {time: 1000}, function () {
    								if(data.status == 'success'){
    									table.ajax.reload();
    									$("#checkboxallid").prop("checked",false);
    								}
    							});
    						}
    					});
    				});
    			}else {
    				layer.msg("请您先<em style='color: red;'>【选中一项】</em>进行操作!", {icon: 7,time: 1000});
    			}
        	}
        },{
        	el:'#cleanEntBack',//清空检查对象
        	event:'click',
        	handler:function(){
        		layer.confirm('您确定要清空所有检查对象吗？', {icon: 2, title: '提示'}, function (index) {
        			var taskUid = $("#taskUid").val();
					http.httpRequest({
						url: window._CONFIG.chooseUrl+'/server/specialrec/ent/cleanAll?taskUid='+taskUid,
						type:"post",
						success: function (data) {
							layer.msg(data.msg, {time: 1000}, function () {
								if(data.status == 'success'){
									table.ajax.reload();
									$("#checkboxallid").prop("checked",false);
								}
							});
						}
					});
				});
        	}
        },{
            el: '.crossDepartFlag',
            event: 'click',
            handler: function () {  
          	  var crossDepartFlag=$("input[name='taskType']:checked").val();
          	  if(crossDepartFlag == "1"){
          		  $("#choselicDeptType").hide();
          		  var dutyDeptCode = $("#dutyDeptCode").val();
          		  var dutyDeptName = $("#dutyDeptCode").find("option:selected").text();
          		  if(dutyDeptCode != null && dutyDeptCode != ""){
          			  $("#taskInspectDeptCode").val(dutyDeptCode);
          			  $("#taskInspectDeptName").val(dutyDeptName);
          		  }else{
          			  $("#taskInspectDeptCode").val("");
          			  $("#taskInspectDeptName").val("");
          		  }
          	  }else{
          		  $("#choselicDeptType").show();
          		  $("#taskInspectDeptCode").val("");
      			  $("#taskInspectDeptName").val("");
          	  }
            }
        },{
            el: '#checkboxallid',
            event: 'click',
            handler: function () {
            	if($(this).prop("checked")){
            		$('.backchk').prop("checked",true);
				 }else{
	            	$('.backchk').prop("checked",false);
				 }
            }
        },{
            el: '#qry',
            event: 'click',
            handler: function () {
            	 table.ajax.reload();
            }
        },{
            el: '#reset',
            event: 'click',
            handler: function () {
            	$("#regNO").val("");
            	$("#entName").val("");
            }
        },{
            el: '#exportEntBack',
            event: 'click',
            handler: function () {
        		var taskUid = $("#taskUid").val();
        		layer.dialog({
                     title: 'excel导入专项整治检查名单',
                     area: ['40%', '30%'],
                     content: window._CONFIG.chooseUrl+'/server/specialrec/task/exportpage?taskUid='+taskUid,
                     callback: function (data) {
                    	//重新加载列表数据
                         if (data.reload) {
                        	 $("#taskUid,#mainTaskUid").val(data.reTaskUid);
                        	 table.ajax.reload();
                         }
                     }
                 });
            }
        }])
    }

})