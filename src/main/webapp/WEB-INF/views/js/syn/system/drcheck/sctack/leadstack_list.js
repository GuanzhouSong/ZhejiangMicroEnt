require(['component/iframeLayer', 'component/dataTable','common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() { 
        initDataTable();
        bind();
       // initCount();
    }


    var searchParams={};//查询参数声明!
    var table;
    var deptState={"1":"待选执法人员","2":"已选执法人员","3":"等待录入结果","4":"已录入结果"};
    var scStackState={"00":"任务创建中","01":"待抽取对象","02":"待设置任务计划","03":"实施中","04":"实施中","05":"实施中","06":"已完成"}
    
    function initCount(){
    	http.httpRequest({
    		url:"/syn/server/drcheck/scstack/selectCount",
    		serializable:false,
    		data:searchParams,
    	    type:"post",
    	    success:function(data){
    	    	 var data=data.data;
    	    	$("#finished").text(data.finished);
    	    	$("#inspecting").text(data.inspecting);
    	    	$("#chooseAgent").text(data.chooseAgent);
    	    	$("#waitConfirmAgent").text(data.waitConfirmAgent);
    	    	$("#waitSetEnt").text(data.waitSetEnt);
    	    	$("#waitSetPlan").text(data.waitSetPlan);
    	    }
    	});
    }
    
    /**
     * 初始化dataTable
     */
    function initDataTable() {
       
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#scstack-table',
            //是否加索引值
            showIndex: true,
            scrollX: true,
            ajax: {
                url:'/syn/server/drcheck/scstack/leadscatcklistJSON',
                data:function(d){
	               		 d.params = searchParams;
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //'className'不要写成class
            columns: [
                {data: null, 'className': 'center'},
                {data: null, 'className': 'center'}, 
                {data: 'taskCode'},
                {data: 'taskCode'},
                {data: 'taskCode'},
                {data: 'taskName'},
                {data: 'startDate'},
                {data: 'endDate'},
                {data: 'taskEntCatgDesc'},
                {data: 'totalEnt'}
            ],
            columnDefs: [{
				targets: 1,
			    render: function (data, type, row, meta) {
			    	 if (row.taskState == '01') {
			    		return "<a class='commit js_audit'>抽取对象</a>";
			    	}/*else if(row.taskState=="02"){
			    		return "<a class='commit js_select'>抽选执法人员</a>";
			    	}else if(row.taskState=="03" && row.inspectState != ""){
			    		 return "<a class='commit  js_select'>抽选执法人员</a>";	
			    	}else if(row.taskState=="05" && row.inspectState == "1"){
			    		 return "<a class='commit  js_select'>抽选执法人员</a>";	
			    	}else*/{ 
			    		return "<a class='commit  js_view'>查看</a>";
			    	 }
			    }
			},
			 {
			  targets:2,
			  render:function(data,type,row,meta){
				  if(row.inspectState==null||row.inspectState==""){
					  return scStackState[row.taskState];
				  }else{
				  return deptState[row.inspectState];
				  }
				  }
			}, {
				targets:3,
				render:function(data,type,row,meta){
					return scStackState[row.taskState];
				}
			}]
        })
    }

   

    function bind() {
        util.bindEvents([{
		    el: '#toAdd',
		    event: 'click',
		    handler: function () {
		    	 
		    layer.dialog({
		            title: '任务设置',
		            area: ['100%', '100%'],
		            content:"/syn/server/drcheck/scstack/show",
		            callback: function (data) {
		            	 if(data.data!=null&&data.data!=""){ 
	            			table.ajax.reload();
			                if (data) {
			                	layer.msg('是否继续随机抽取检查对象？', {
			              		  time: 0 //不自动关闭
			              		  ,btn: ['继续', '否']
			              		  ,yes: function(index){
			              		    layer.close(index); 
				              		  layer.dialog({
				                          title: '抽取对象',
				                          area: ['100%', '100%'],
				                          content:'/syn/server/drcheck/scstack/randomentinfo?taskNO='+data.data.taskUid,
				                          callback: function (data) {
			                            	  table.ajax.reload();
				                          }
				                      });
			              		  },no:function(index){
			              			  layer.close(index);
			              		  }
			              		});
			                } 
		            	 }
		            }
		        })  
				
			}
		},{
			el:'#test',
			event:'click',
			handler:function(){}
			},{
			    el: '.js_view',
			    event: 'click',
			    handler: function () {
			    	var data = table.row($(this).closest('td')).data();
			    	var uid=data.uid;
			    	layer.dialog({
			            title: '任务详情',
			            area: ['85%', '70%'],
			            content:'/syn/server/drcheck/scstack/viewinfo?taskNO='+uid,
			            callback: function (data) {
			                //重新加载列表数据
			                if (data.reload) { 
			                	 
			                	/*$("#regOrg").val(data.reload.retruncode);
			                	$("#regOrgName").val(data.reload.returnname);*/
			                    
			                }
			            }
			        })
				
			}
		}, {
		    el: '.js_audit',
		    event: 'click',
		    handler: function () {
		    	var data = table.row($(this).closest('td')).data();
		    	var uid=data.uid;
		   layer.dialog({
		            title: '抽取对象',
		            area: ['100%', '100%'],
		            content:'/syn/server/drcheck/scstack/randomentinfo?taskNO='+uid,
		            callback: function (data) {
		                //重新加载列表数据
		                if (data.reload) { 
		                	table.ajax.reload();
		                	if(data.flag){
		                		layer.confirm('检测到本次组织的任务中需要抽取执法人员，是否需要直接操作？', {icon: 2, title: '提示'}, function (index) {
			                		layer.dialog({
			        		            title: '设置任务计划',
			        		            area: ['100%', '100%'],
			        		            content:'/syn/server/drcheck/scstack/randomagent?taskNO='+uid,
			        		            callback: function (data) {
			        		                //重新加载列表数据
			        		                if (data.reload) { 
			        		                	table.ajax.reload();
			        		                }
			        		            }
			        		        });
		                		});
		                	}
		                }
		            }
		        })
			}
		}, {
		    el: '.js_select',
		    event: 'click',
		    handler: function () {
		    	var data = table.row($(this).closest('td')).data();
		    	var uid=data.uid;
		   layer.dialog({
		            title: '设置任务计划',
		            area: ['100%', '100%'],
		            content:'/syn/server/drcheck/scstack/randomagent?taskNO='+uid,
		            callback: function (data) {
		                //重新加载列表数据
		                if (data.reload) { 
		                	table.ajax.reload();
		                }
		            }
		        })
			}
		}, {
          el: '#choseImplDept',
          event: 'click',
          handler: function () {
	        	 var userType = $("#userType").val();
//	     	     var deptLink = '/common/system/dept/tree/select';
//	     	     if(userType == '2'){
	     	    	var deptLink='/syn/system/sysdepart/alldeptradiotreeselect';
//	     	     }
			     layer.dialog({
	                  title: '选择任务实施部门',
	                  area: ['328px', '600px'],
	                  content: deptLink,
	                  callback: function (data) {
	                	  //重新加载列表数据
	                      if (data) {   
	                      	$("#inspectDept").val(userType =='2'?data.orgCode:data.orgCodes);
	                      	$("#InspectDeptName").val(userType =='2'?data.orgName:data.orgNames);
	                      }
	                  }
	              })
			   }
			},{
			    el: '#choseEntcatg',
			    event: 'click',
			    handler: function () {
				layer.dialog({
		            title: '选择企业类型',
		            area: ['328px', '600px'],
		            content: '/reg/server/other/pubohterlicence/toEntcatgTreeView',
		            callback: function (data) {
		                //重新加载列表数据
		                if (data.reload) { 
		                	$("#entType").val(data.reload.retruncode);
		                	var name=data.reload.returnname;
		                	$("#entTypeName").val(name);
		                }
		            }
		        })
			}
		},{
		    el: '#choseSilceno',
		    event: 'click',
		    handler: function () {
				layer.dialog({
		            title: '选择责任区',
		            area: ['328px', '600px'],
		            content: '/reg/server/other/pubohterlicence/toSlicenoTreeView',
		            callback: function (data) {
		                //重新加载列表数据
		                if (data.reload) { 
		                 
		                	$("#sliceNO").val(data.reload.retruncode);
		                	$("#sliceNoName").val(data.reload.returnname);
		                   table.ajax.reload();
		                }
		            }
		        })
		    }
		},{      
			el: '.js-edit',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.dialog({
                    title: '修改',
                    area: ['728px', '500px'],
                    content: '/reg/server/registinfo/registinfo/toShow?priPID=' + data.priPID+'&UID='+data.uid,
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        }, {
            el: '#qry',
            event: 'click',
            handler: function () {
            	var categCode=new Array(); 
                $(":checkbox[name=catgCode]:checked").each(function(k,v){
              	  categCode[k]= this.id; 
                 });
           	$("#leadtaskEntCatgCode").val(categCode.toString());
                 searchParams=$("#qryForm").serializeObject();
                  table.ajax.reload();
                  initCount();
            }
        },{
             el: '#cancel',
             event: 'click',
             handler: function () {
	             $('#qryForm')[0].reset();
	             $("#inspectDept").val("");
	             $("#leaderDeptName").val("");
              
             }
         },{
            el: '#checkAll',
            event: 'click',
            handler: function () {
	             var flag=$(this).prop("checked");
	             $("input:checkbox[name='_checkbox']").prop("checked", flag);
             }
          }])
    }

})
