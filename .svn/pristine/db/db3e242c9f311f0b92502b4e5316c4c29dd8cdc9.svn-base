require(['component/iframeLayer', 'component/dataTable','common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','tab'], function (layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() { 
      var tabbale = new Tab($('#cgcs-tab'));
      var tab = $("#realtab").val();
      if(tab=="lead"){
    	  $("#realtab").val("lead");
    	  tabbale.showTab(0); 
    	  initleadTable();
      }
        bind();
        
    }


    var  leadsearchParams={};//查询参数声明!
    var  deptsearchParams={};
    var leadtable;
    var depttable;
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
    function initleadTable() {
       
    	leadtable = dataTable.load({
            el: '#lead-table',
            showIndex: true,
            scrollX: true,
            ajax: {
                url:'/syn/server/drcheck/scstack/leadscatcklistJSON',
                data:function(d){
	               		 d.params = leadsearchParams;
                }
            },
            columns: [
                {data: null,defaultContent: '11111'},
                {data: null,defaultContent: '11111'}, 
                {data: 'taskState'},
                {data: 'taskCode'},
                {data: 'leaderDeptDesc'},
                {data: 'implDeptDesc'},
                {data: 'taskName'},
                {data: 'startDate'},
                {data: 'endDate'},
                {data: 'taskEntCatgDesc'},
                {data: 'totalEnt'}
            ],
            columnDefs: [{
				targets: 1,
			    render: function (data, type, row, meta) { 
			    		return "<a class='commit  js_view'>查看</a>"; 
			    }
			},
			 {
				targets:2,
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
		            	 if(data.reload){ 
		            		leadtable.ajax.reload();
		            		var taskUid = data.taskUid;
			                if (data.taskUid) {
			                	layer.confirm('是否继续随机抽取检查对象？', {icon: 2, title: '提示'}, function (index) {
				              		  layer.dialog({
				                          title: '抽取对象',
				                          area: ['100%', '100%'],
				                          content:'/syn/server/drcheck/scstack/randomentinfo?taskNO='+taskUid,
				                          callback: function (data) {
				                        	  if(data.reload){
				                        		  leadtable.ajax.reload();
				                        		  if(data.flag){
				                        			  layer.confirm('检测到本次组织的任务中需要抽取执法人员，是否直接操作？', {icon: 2, title: '提示'}, function (index) {
				                        				  layer.close(index);
				                        				  layer.dialog({
				                        					  title: '设置任务计划',
				                        					  area: ['100%', '100%'],
				                        					  content:'/syn/server/drcheck/scstack/randomagent?taskNO='+taskUid,
				                        					  callback: function (data) {
				                        						  //重新加载列表数据
				                        						  if (data.reload) { 
				                        							  leadtable.ajax.reload();
				                        						  }
				                        					  }
				                        				  });
				                        			  });
				                        		  }
				                        	  }
				                          }
				                      });
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
			    	var data="";
			    	 if($("#realtab").val()=="lead"){
			    		data = leadtable.row($(this).closest('td')).data();
			    	 }else{
			    		data=depttable.row($(this).closest('td')).data();
			    	 }
			    	 
			    	
			    	var uid=data.uid;
			    	layer.dialog({
			            title: '任务详情',
			            area: ['95%', '95%'],
			            content:'/syn/server/drcheck/scstack/showScatck?uid='+uid,
			            callback: function (data) {
			                //重新加载列表数据
			                if (data.reload) {  
			                	
			                }
			            }
			        })
				
			}
		}, {
		    el: '.js_select',
		    event: 'click',
		    handler: function () {
		    	var data="";
		    	 if($("#realtab").val()=="lead"){
		    		data = leadtable.row($(this).closest('td')).data();
		    	 }else{
		    		data=depttable.row($(this).closest('td')).data();
		    	 }
	    		 
		    	var uid=data.uid;
		    	layer.dialog({
		            title: '设置任务计划',
		            area: ['100%', '100%'],
		            content:'/syn/server/drcheck/scstack/randomagent?taskNO='+uid,
		            callback: function (data) {
		                //重新加载列表数据
		                if (data.reload) { 
		                	depttable.ajax.reload(); 
		                }
		            }
		        })
			}
		},{
          el: '#choseleadImplDept',
          event: 'click',
          handler: function () {
        	     var userType = $("#userType").val();
//        	     var  deptLink = '/common/system/dept/tree/select';
//        	     if(userType == '2'){
        	    	var deptLink='/syn/system/sysdepart/alldeptradiotreeselect';
//        	     }
			     layer.dialog({
	                  title: '选择任务实施部门',
	                  area: ['328px', '600px'],
	                  content:deptLink,
	                  callback: function (data) {
	                	  //重新加载列表数据
	                      if (data) {
	                      	$("#inspectleadDept").val(userType =='2'?data.orgCode:data.orgCodes);
	                      	$("#InspectleadDeptName").val(userType =='2'?data.orgName:data.orgNames);
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
            el: '#qrylead',
            event: 'click',
            handler: function () {
            	 var categCode=new Array(); 
                 $(":checkbox[name=catgCode]:checked").each(function(k,v){
               	  categCode[k]= this.id; 
                  });
            	$("#leadtaskEntCatgCode").val(categCode.toString());
            	  
            	leadsearchParams=$("#leadsctackForm").serializeObject();
                
            	leadtable.ajax.reload();
                  //initCount();
            }
        },{
             el: '#cancellead',
             event: 'click',
             handler: function () {
	             $('#leadsctackForm')[0].reset();
	             $("#inspectleadDept").val("");
	             $("#leaderleadDeptCode").val("");
              
             }
         },{
            el: '#checkAll',
            event: 'click',
            handler: function () {
	             var flag=$(this).prop("checked");
	             $("input:checkbox[name='_checkbox']").prop("checked", flag);
             }
          },{
            el: '#leadTab',
            event: 'click',
            handler: function() {
            	if(leadtable==undefined){
            		initleadTable();
            	}else{
            		searchParams = $("#sendSearchForm").serializeObject();
            		 leadtable.ajax.reload();
            	}
            	/* $(".clearall").val("");
            	 getSendCount();*/
            }
        }])
    }

})
