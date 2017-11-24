require(['component/iframeLayer', 'component/dataTable','common/util', 'common/http', 'handlebars', 
         'jquery.validate','jquery','jquery.serialize','common/validateRules','laydate'], function (layer, dataTable, util, http, handlebars) {
	init();
	var backtable;
	var grouptable;
	var agenttable;
	var infotable;
//    var chooseUrl = window._CONFIG.chooseUrl;
    /**
	 * 初始化函数集合
	 */
    function init() {
        $("#clientNameCount").rules("add", {number: true});
        bind();
        infotable = dataTable.load({
            // 需要初始化dataTable的dom元素
            el: '#info-table',
            // 是否加索引值
            showIndex: true,
            scrollX: true,
            ajax: {
                url:window._CONFIG.chooseUrl+'/server/sccheck/pubscent/list.json',
                data:function(d){
	               	d.params = $("#paramForm").serializeObject();
                }
            },
            // 需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            // 'className'不要写成class
            columns: [
                {data: "_idx","className": "center"},
                {data: "regNO","className": "center"}, 
                {data: "entName", "className": "center"}, 
                {data: "estDate", "className": "center"},
                {data: "entTypeCatg", "className": "center"},
//                {data: "lastCheckTime","className": "center"},
//                {data: "specialName", "className": "center"},
                {data: "regOrgName","className": "center"},
                {data: "localAdmName", "className": "center"}
                ],
            columnDefs: [{
            	targets:1,
    	        render:function(data,type,row,meta){
    	        	if(row.uniCode != null && row.uniCode != ""){
	   					return row.uniCode;
	   				}else{
	   					return row.regNO;
	   				}
    	       }
	        },
	        {
            	targets:4,
    	        render:function(data,type,row,meta){
    	        	if(data != null && data != ""){
	   					if(data == '50'){//个体户
	   						return "个体户";
	   					}else if(data == '23'){
	   						return "外企代表机构";
	   					}else if(data == '16' || data == '17'){
	   						return "农专社";
	   					}else{
	   						return "企业";
	   					}
	   				}else{
	   					return '';
	   				}
    	       }
	        }
            ]
        });
        var randomType = $("#randomType").val();
        if(randomType == "1"){
        	initgroupTable();
        }else if(randomType == "2"){
        	initownbackTable();
        }
    }
    
    
    /**
     * 初始化dataTable
     */
    function initownbackTable() {
    	backtable = dataTable.load({
            el: "#backTableId",
            showIndex: true,
            scrollX: true,
            ajax: {
                url:window._CONFIG.chooseUrl+"/server/sccheck/pubscentAgentBack/list.json",
                data:function(d){
            		d.params = $.extend({}, $("#paramForm").serializeObject(), {"agentName" : $("#agentName").val()});               		
                }
            },
            columns: [
                {data: "_idx","className": "center"},
                {data: null, "className": "center"},
                {data: 'agentName', 'className': 'center'},
                {data: 'agentSex'},
                {data: 'employeeNO'},
                {data: 'agentNO'},
                {data: 'mobile'},
                {data: 'studyLevel'},
                {data: 'agentAge'},
                {data: 'deptCatg'},
                {data: 'expertFlag'},
                {data: 'agentState'},
                {data: 'agentArea'},
                {data: 'unitLevel'},
                {data: 'unitName'},
                {data: 'agentPosition'},
                {data: 'slicenNOName'},
                {data: 'lawNO'},
                {data: 'lawEndDate'},
                {data: 'govLawNO'},
                {data: 'govLawEndDate'},
                {data: 'setUserName'},
                {data: 'setTime'}
            ],
            columnDefs: [
				{
					targets:1,
				    render:function(data,type,row,meta){
						    return "<input value='" + row.agentUid + "' name = 'checkboxlist' class='chb checkbox' type='checkbox' />";
				   }
				},{
					targets: 3,
				    render: function (data, type, row, meta) {
				    	if(row.agentSex =='1'){
				    		return "男";
				    	}else if(row.agentSex =='2'){
				    		return "女";
				    	}else{
				    		return "";
				    	}
				   }
			    },{
					targets: 7,
				    render: function (data, type, row, meta) {
				    	if(row.studyLevel =='8'){return "小学";}
				       else if(row.studyLevel =='4'){return "初中";}
					   else if(row.studyLevel =='5'){return "高中";}
					   else if(row.studyLevel =='1'){return "大专";}
					   else	if(row.studyLevel =='2'){return "本科";}
					   else	if(row.studyLevel =='3'){return "研究生";}
					   else if(row.studyLevel =='6'){return "硕士";}
					   else if(row.studyLevel =='7'){return "博士";}
					   else if(row.studyLevel =='9'){return "博士后";}
					   else{ return "";}
				   }
		        },{
					targets: 9,
				    render: function (data, type, row, meta) {
				    	var deptCatg = row.deptCatg;
			    		if(deptCatg == null || deptCatg == "" || deptCatg == "undefined"){
			    			return "";
			    		}else{
			    			return deptCatg.replace('1','工商行政管理类').replace('2','食品药品管理类').replace('3','质量技术监督类').replace('4','安全生产类').replace('5','物价管理类');
			    		}
				   }
		        },{
					targets: 10,
				    render: function (data, type, row, meta) {
				    	var expertFlag = row.expertFlag;
				    	if(expertFlag =='N'){
				    		return "<span style='color:red;'>否</span>";
				    	}else if(expertFlag !='N'){
				    		if(expertFlag == null || expertFlag == "" || expertFlag == "undefined"){
				    			return "";
				    		}else{
				    			return expertFlag.replace('Y,','').replace('1','保化组长').replace('2','药品GSP').replace('3','药品GMP').replace('4','医疗器械GSP').replace('5','医疗器械GMP').replace('Y','是');
				    		}
				       }
				   }
		        },{
					targets: 11,
				    render: function (data, type, row, meta) {
				    	if(row.agentState =='1'){return "有效";}
				       else if(row.agentState =='2'){return "<span style='color:red;'>失效</span>";}
					   else{ return "";}
				   }
		        },{
					targets: 12,
				    render: function (data, type, row, meta) {
				    	if(row.agentArea =='ZJ'){return "省本级";}
				       else if(row.agentArea =='H'){return "杭州";}
					   else if(row.agentArea =='N'){return "宁波";}
					   else if(row.agentArea =='W'){return "温州";}
					   else	if(row.agentArea =='Jx'){return "嘉兴";}
					   else	if(row.agentArea =='Hu'){return "湖州";}
					   else if(row.agentArea =='S'){return "绍兴";}
					   else if(row.agentArea =='J'){return "金华";}
					   else if(row.agentArea =='Q'){return "衢州";}
					   else if(row.agentArea =='Z'){return "舟山";}
					   else if(row.agentArea =='T'){return "台州";}
					   else if(row.agentArea =='L'){return "丽水";}
					   else{ return "";}
				   }
		        },{ 
					targets:13,
					render:function(data,type,row,meta){
						if(row.unitLevel!=null&&row.unitLevel!=""){
						 if(row.unitLevel=="1"){
							 return "市级";
						 } else if(row.unitLevel=="2"){
							 return "县级";
						 }else if(row.unitLevel=="3"){
							 return "省级";
						 }else if(row.unitLevel=="4"){
							 return "所级";
						 }else{
							 return "";
						 }
					   }
					}
				},{ 
					targets:15,
					render:function(data,type,row,meta){
						 if(row.agentPosition=="1"){
							 return "局领导";
						 } else if(row.agentPosition=="2"){
							 return "科室（处、办、中心）负责人（正职）";
						 }else if(row.agentPosition=="3"){
							 return "科室（处、办、中心）负责人（副职）";
						 }else if(row.agentPosition=="4"){
							 return "所（站、分局）长（正职）";
						 }else if(row.agentPosition=="5"){
							 return "所（站、分局）长（副职）";
						 }else if(row.agentPosition=="6"){
							 return "一般干部";
						 }else{
							 return "";
						 }
					   }
				}],
		    "fnDrawCallback": function (oSettings) {
		    	var searchMap = $("#paramForm").serializeObject();
		    	http.httpRequest({ 
	                url: window._CONFIG.chooseUrl+"/server/sccheck/pubscentAgentBack/DataCountList",
	                serializable: false,
//	                type:'post',
	                data: {params:searchMap} ,
	                success: function (data) {
	                	var pubScentAgentCount = data.data;
	                    if (data.status == 'success') {  
							$("#clientNameCount").val(pubScentAgentCount);
	                    }else{
							$("#clientNameCount").val(0);
	                    }
	                }
	            });
			}
        });
    }
    
    //表格之外的查询按钮事件
    $("#searchChecker").click(function(){
    	backtable.ajax.reload(); 
    });
    
    /**
     * 初始化dataTable
     */
    function initgroupTable() {
    	grouptable = dataTable.load({
            el: "#groupTableId",
            showIndex: true,
            scrollX: true,
            ajax: {
                url:window._CONFIG.chooseUrl+"/server/sccheck/scgroup/grouplist.json",
                data:function(d){
            		d.params = $("#paramForm").serializeObject();               		
                }
            },
            columns: [
                {data: "_idx",  "className": "center"},
                {data: null,  "className": "center"},
                {data: "memberNum","className": "center"},
                {data: "agentNames",  "className": "center"}, 
                {data: "teamLeader", "className": "center"},
                {data: "expertNames", "className": "center"}
            ],
            columnDefs: [{
					targets:1,
				    render:function(data,type,row,meta){
						    return "<input value='" + row.uid + "' name = 'checkboxgroup' class='groupchb checkbox' type='checkbox' />";
				   }
            }],
		    "fnDrawCallback": function (oSettings) {
		    	var searchMap = $("#paramForm").serializeObject();
		    	http.httpRequest({ 
	                url: window._CONFIG.chooseUrl+"/server/sccheck/scgroup/groupcount",
	                serializable: false,
//	                type:'post',
	                data: {params:searchMap} ,
	                success: function (data) {
	                	var groupCount = data.data;
	                    if (data.status == 'success') {  
							$("#groupCount").val(groupCount);
	                    }else{
							$("#groupCount").val(0);
	                    }
	                }
	            });
			}
    	});
    }
    
    
    
    function bind() {
    	util.bindEvents([
        {
            el: '.view',
            event: 'click',
            handler: function () { 
           	 	var uid=$("#uid").val();
            	layer.dialog({
                    title: '查看详情',
                    area: ['100%', '100%'],
                    content:'/reg/server/sccheck/scplantask/addOrEditView?flag=3&uid='+uid,
                    callback: function(data) {
                    	 
                    }
                })
            }
        },{
      	  el: '#checkAll',  //全选
            event: 'click',
            handler: function () {
            	var allChecked= $("#checkAll").prop("checked");   
            	$(".chb").prop("checked", allChecked);
            }
      },{
        		el: '#deleteAll',
        		event: 'click',
        		handler: function () {
               	 var deptTaskUid= $("#taskUid").val();
  	           layer.confirm('确定清空本部门下的执法人员吗？', {
	               icon: 2,
	               title: '提示'
	           },  function(){
	        	   http.httpRequest({
       				url: window._CONFIG.chooseUrl+'/server/sccheck/pubscentAgentBack/deleteRtnAll',
       				serializable: false, 
       				data: {deptTaskUid:deptTaskUid},
       				type:"post",
       				success: function (data) {
       					layer.msg(data.msg, {time: 1000}, function () {
       						backtable.ajax.reload();
       					});
       				}
       			});
	           });
  	           }
        	},{
        		el: '#delete',
        		event: 'click',
        		handler: function () {
        	           var ids=new Array();
        	            $(":checkbox[name=checkboxlist]:checked").each(function(k,v){
        	           	ids[k]=this.value; 
        	            });
        	            
        	            if(ids[0]==""||ids[0]==null){
        	                layer.msg("请您至少选择一位执法人员!", {icon: 7,time: 1000});
        	           	 return false;
        	            }
        	          
        	           layer.confirm('确定删除选中的执法人员吗？', {
        	               icon: 2,
        	               title: '提示'
        	           },
        	           function(index) {
        	        	   http.httpRequest({
        	                   url: window._CONFIG.chooseUrl+'/server/sccheck/pubscentAgentBack/deleteRtn',
        	                   data: {
        	                	  agentIds:ids.toString(),
        	                	  deptTaskUid:$("#taskUid").val()
        	                   },
        	                   type: 'post',
        	                   success: function(data) {  
        	                               layer.msg(data.msg, {
        	                                   time: 500
        	                               },
        	                               function() {
        	                            	   backtable.ajax.reload();
        	                               });
        	                       }
        	        	   });
        	           });
        		}
        	},{
                el: '#addAgentId',
                event: 'click',
                handler: function () {
                	 var deptTaskUid= $("#taskUid").val();
                	 var deptCode= $("#deptCode").val();
                	 var scTypeWay= $("#scTypeWay").val();
                     layer.dialog({
                         title: '选择执法人员',
                         area: ['100%', '100%'],
                         content: window._CONFIG.chooseUrl+'/server/drcheck/pubscagent/choosepage?deptTaskUid='+deptTaskUid+'&deptCode='+deptCode+'&scTypeWay='+scTypeWay,
                         callback: function (data) {
                        	//重新加载列表数据
                             if (data.reload) {
                            	 backtable.ajax.reload();
                             }
                         }
                     });
                }
            },{
	            el: '#clean',
	            event: 'click',
	            handler: function () {
	            	http.httpRequest({
	     				url: '/syn/pub/server/drcheck/pubsctaskagent/clean',
	     				serializable: false, 
	     				data: {taskNO:$("#deptTaskUid").val()},
	     				type:"post",
	     				success: function (data) {
	     					layer.msg(data.msg, {time: 1000}, function () {
	     						agenttable.ajax.reload();
	     					});
	     				}
	     			});
	            }
        },{
            el: '#random',
            event: 'click',
            handler: function () {
            	var randomType = $("input[name='randomType']:checked ").val();
            	var deptTaskUid= $("#taskUid").val();
            	if(randomType == "1"){
            		var groupCount = $("#groupCount").val();
            		if(groupCount == '0' || groupCount == 0){
            			layer.msg("请先添加检查小组 !", {icon: 7,time: 3000});
    	                return false;
            		}
            		var randomGroupNumber= $("#randomGroupNumber").val();
                	var reg = /^\d+$/;
                	if(randomGroupNumber == '' || (! reg.test(randomGroupNumber)) || parseInt(randomGroupNumber) <= 0 ){
                		layer.tips("请输入正整数的随机抽取小组个数!",$("#randomGroupNumber"),{tips:1, tipsMore:true, ltype:0});
    	                return false;
                	}
                	if(parseInt(randomGroupNumber) > parseInt(groupCount)){
                		layer.tips("随机抽取小组数量不能超过检查小组总数!",$("#randomGroupNumber"),{tips:1, tipsMore:true, ltype:0});
    	                return false;
                	}
//            		layer.confirm('系统将随机匹配企业和检查小组，可能需要一段时间，是否继续？', {icon: 2, title: '提示'}, function (index) {
            			layer.dialog({
                            title: '企业和执法人员随机配对',
                            area: ['100%', '100%'],
                            content: window._CONFIG.chooseUrl+'/pub/server/sccheck/entagent/randomPage?deptTaskUid='
                            		+deptTaskUid+'&randomType='+randomType+'&groupNum='+randomGroupNumber,
                            callback: function (data) {
                            	if(data.reload){
        		            		layer.close({reload:true});
        		            	}
                            }
                        });
//    	    			http.httpRequest({
//    	    				url: '/reg/pub/server/sccheck/entagent/random',
//    	    				serializable: false, 
//    	    				data: {deptTaskUid:deptTaskUid,randomType:randomType,groupNum:randomGroupNumber},
//    	    				type:"post",
//    	    				success: function (data) {
//    	    					layer.msg(data.msg, {time: 1000}, function () {
//    	    						if(data.status == 'success'){
//    	    							$("#random").val("重新抽取检查名单");
//    	    							$("#view").show();
//    	    							$("#lock").show();
//    	    							$("#randomTypeValue").val(randomType);
//    	    							$("#groupNumValue").val("0");
//    	    						}
//    	    					});
//    	    				}
//    	    			});
//                	});
            	}else if(randomType == "2"){
        			var checkNumber= $("#checkNumber").val();
                	var pubScentAgentCount = $("#clientNameCount").val();
                	var reg = /^\d+$/;
                	if(checkNumber == '' || (! reg.test(checkNumber)) || parseInt(checkNumber) <= 0 ){
                		layer.tips("请输入正确的正整数作为检查人员总数 !",$("#checkNumber"),{tips:1, tipsMore:true, ltype:0});
    	                return false;
                	}
                	if(parseInt(checkNumber) > parseInt(pubScentAgentCount) ){
                		layer.msg("设置的检查人员总数不能大于待选库中检查人员总数 !", {icon: 7,time: 3000});
                		return false;
                	}
//                	layer.confirm('系统将随机匹配企业和执法人员，可能需要一段时间，是否继续？', {icon: 2, title: '提示'}, function (index) {
//    	    			http.httpRequest({
//    	    				url: '/reg/pub/server/sccheck/entagent/random',
//    	    				serializable: false, 
//    	    				data: {deptTaskUid:deptTaskUid,randomType:randomType,groupNum:checkNumber},
//    	    				type:"post",
//    	    				success: function (data) {
//    	    					layer.msg(data.msg, {time: 1000}, function () {
//    	    						if(data.status == 'success'){
//    	    							$("#random").val("重新抽取检查名单");
//    	    							$("#view").show();
//    	    							$("#lock").show();
//    	    							$("#randomTypeValue").val(randomType);
//    	    							$("#groupNumValue").val(checkNumber);
//    	    						}
//    	    					});
//    	    				}
//    	    			});
//                	});
                	layer.dialog({
                        title: '企业和执法人员随机配对',
                        area: ['100%', '100%'],
                        content: window._CONFIG.chooseUrl+'/pub/server/sccheck/entagent/randomPage?deptTaskUid='
                        		+deptTaskUid+'&randomType='+randomType+'&groupNum='+checkNumber,
                        callback: function (data) {
                        	if(data.reload){
    		            		layer.close({reload:true});
    		            	}
                        }
                    });
            	}else{
            		layer.tips("请先选择检查人员抽取库抽取方式",$("#type1"),{tips:3, tipsMore:true, ltype:0});
            		return false;
            	}
            }
        },{
            el: '#view',
            event: 'click',
            handler: function () {
            	var deptTaskUid= $("#taskUid").val();
            	layer.dialog({
                    title: '企业和执法人员随机配对结果',
                    area: ['80%', '80%'],
                    content: window._CONFIG.chooseUrl+'/pub/server/sccheck/entagent/view?deptTaskUid='+deptTaskUid,
                    callback: function (data) {
                    }
                });
            }
        },{
            el: '#close',
            event: 'click',
            handler: function () {
            	layer.close({reload: false});
            }
        },{
            el: '.type',
            event: 'click',
            handler: function () {
            	var randomType = $("input[name='randomType']:checked").val();
            	if(randomType == "1"){
            		$("#group-div").show();
            		$("#agent-div").hide();
            		if(grouptable == null){
            			initgroupTable()
            		}else{
            			grouptable.ajax.reload();
            		}
            	}else{
            		$("#group-div").hide();
            		$("#agent-div").show();
            		if(backtable == null){
            			initownbackTable();
            		}else{
            			 backtable.ajax.reload();
            		}
            	}
            }
        },{
        	  el: '#checkAllGroup',  //全选
              event: 'click',
              handler: function () {
              	var allChecked= $("#checkAllGroup").prop("checked");   
              	$(".groupchb").prop("checked", allChecked);
              }
        },{
    		el: '#deleteGroup',
    		event: 'click',
    		handler: function () {
    	           var ids=new Array();
    	            $(":checkbox[name=checkboxgroup]:checked").each(function(k,v){
    	            	ids[k]=this.value; 
    	            });
    	            
    	            if(ids[0]==""||ids[0]==null){
    	                layer.msg("请您至少选择一个检查小组!", {icon: 7,time: 1000});
    	           	 return false;
    	            }
    	          
    	           layer.confirm('确定删除选中的检查小组吗？', {
    	               icon: 2,
    	               title: '提示'
    	           },
    	           function(index) {
    	        	   http.httpRequest({
    	                   url: window._CONFIG.chooseUrl+'/server/sccheck/scgroup/delete',
    	                   data: {
    	                	  groupUids:ids.toString()
    	                   },
    	                   type: 'post',
    	                   success: function(data) {  
                               layer.msg(data.msg, {
                                   time: 500
                               },
                               function() {
                            	   grouptable.ajax.reload();
                               });
	                       }
    	        	   });
    	           });
    		}
    	},{
    		el: '#deleteAllGroup',
    		event: 'click',
    		handler: function () {
	             layer.confirm('您确定要清空所有的检查小组吗？', {
	               icon: 2,
	               title: '提示'
		           },  function(){
		        	   http.httpRequest({
		   				url: window._CONFIG.chooseUrl+'/server/sccheck/scgroup/clean',
		   				serializable: false, 
		   				type:"post",
		   				success: function (data) {
		   					layer.msg(data.msg, {time: 1000}, function () {
		   						grouptable.ajax.reload();
		   					});
		   				}
		   			});
		           });
           }
    	},{
            el: '#addGroupId',
            event: 'click',
            handler: function () {
            	layer.dialog({
                    title: '添加检查小组成员',
                    area: ['80%', '60%'],
                    content: window._CONFIG.chooseUrl+'/server/sccheck/scgroup/randomadd',
                    callback: function (data) {
                    	if(data.reload){
                    		grouptable.ajax.reload();
                    	}
                    }
                });
            }
        }]);
    }
});
