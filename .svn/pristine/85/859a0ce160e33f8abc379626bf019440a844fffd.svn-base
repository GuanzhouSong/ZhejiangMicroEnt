require(['component/iframeLayer', 'component/dataTable','common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {
	init();
	var backtable;
	var agenttable;
	var infotable;
    /**
	 * 初始化函数集合
	 */
    function init() { 
        bind();
        infotable = dataTable.load({
            // 需要初始化dataTable的dom元素
            el: '#info-table',
            // 是否加索引值
            showIndex: true,
            scrollX: true,
            ajax: {
                url:'/syn/pub/server/drcheck/pubscinfo/randomlist.json',
                data:function(d){
	               	d.params = $("#paramForm").serializeObject();
                }
            },
            // 需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            // 'className'不要写成class
            columns: [
                {data: "id", width:"40px","className": "center"},
                {data: null,width:"40px", "className": "center"}, 
                {data: "entName",width:"250px", "className": "center"}, 
                {data: "leRep", width:"100px","className": "center"},
                {data: "tel", width:"100px","className": "center"},
                {data: "liaName", width:"100px","className": "center"},
                {data: "leRepPhone",width:"100px", "className": "center"},
                {data: "estDate",width:"100px", "className": "center"},
                {data: "entTypeCatgDesc",width:"250px", "className": "center"},
                {data: "industryDesc", width:"250px","className": "center"}
            ],
            columnDefs: [{
            	targets:1,
    	        render:function(data,type,row,meta){
    	        	if(data.uniCode != null && data.uniCode != ""){
	   					return data.uniCode;
	   				}else{
	   					return data.regNO;
	   				}
    	       }
	        }]
        });
        initownbackTable();
        initotherTable();
        
    }
    
    /**
     * 初始化dataTable
     */
    function initotherTable() {
    	agenttable = dataTable.load({
            el: "#agentTableId",
            showIndex: true,
            scrollX: true,
            ajax: {
                url:"/syn/pub/server/drcheck/pubsctaskagent/list.json",
                data:function(d){
	               	d.params = $("#backFormId").serializeObject();
                }
            },
            columns: [
                {data: "id", width:"40px","className": "center"},
                {data: "agentName",width:"100px", "className": "center"},
                {data: "unitName", width:"100px","className": "center"}, 
                {data: "unitLevel", width:"100px","className": "center"}, 
                {data: "deptCodeDesc", width:"250px","className": "center"},
                {data: "deptCatg", width:"100px","className": "center"},
                {data: "sliceName",  width:"100px","className": "center"},
                {data: "agentRange", width:"100px", "className": "center"}
            ],
            columnDefs: [{
	        	targets:3,
	        	render:function(data,type,row,meta){
	        		if(row.unitLevel!=null&&row.unitLevel!=""){
	        			 if(row.unitLevel=="1"){
	        				 return "市级";
	        			 } else if(row.unitLevel=="2"){
	        				 return "县级";
	        			 }else{
	        				 return "省级";
	        			 }
	        			 
	        		}
	        		
	        	}
	        }]
        });
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
                url:"/syn/pub/server/drcheck/pubsctaskagentback/list.json",
                data:function(d){
	               	d.params = $("#backFormId").serializeObject();
                }
            },
            columns: [
                {data: "id", width:"40px", "className": "center"},
                {data: "agentName",width:"100px", "className": "center"},
                {data: "unitName",  width:"100px","className": "center"}, 
                {data: "unitLevel", width:"100px", "className": "center"}, 
                {data: "deptCodeDesc", width:"250px","className": "center"},
                {data: "deptCatg",  width:"100px","className": "center"},
                {data: "sliceName", width:"100px", "className": "center"},
                {data: "agentRange", width:"100px", "className": "center"},
                {data: null, width:"50px", "className": "center"}
            ],
            columnDefs: [{
	        	targets:3,
	        	render:function(data,type,row,meta){
	        		if(row.unitLevel!=null&&row.unitLevel!=""){
	        			 if(row.unitLevel=="1"){
	        				 return "市级";
	        			 } else if(row.unitLevel=="2"){
	        				 return "县级";
	        			 }else{
	        				 return "省级";
	        			 }
	        		}else{
	        			return "";
	        		}
	        		
	        	}
	        },{
            	targets:8,
    	        render:function(data,type,row,meta){
    	        	return '<a href="javascript:void(0)" class="deleteback" backid="'+data.id+'">删除</a>';
    	       }
	        }]
        });
    }
    
    function updateCheckItem(){
    	http.httpRequest({
			url: '/syn/drcheck/syn/server/scitem/saveDeptScitem',
			serializable: false,  
			data: {"deptTaskNO":$("#deptTaskUid").val(),
					"taskNO":$("#taskNO").val(),
					"deptCode":$("#deptCode").val(),
					"scTypes":$("#scNameCodes").val(),
					"scNames":$("#scNames").html()},
			type:"post",
			success: function (data) { 
				 if(data.status="success"){
					 layer.msg("更新检查项成功",{time:1000});
				} else{
					layer.msg("更新检查项失败",{time:1000});
				} 
			}
		});
    }
    
    function bind() {
    	util.bindEvents([{
            el: '.deleteback',
            event: 'click',
            handler: function () {
            	 var backid = $(this).attr("backid");
            	 http.httpRequest({
     				url: '/syn/pub/server/drcheck/pubsctaskagentback/delete',
     				serializable: false, 
     				data: {id:backid},
     				type:"post",
     				success: function (data) {
     					layer.msg(data.msg, {time: 1000}, function () {
     						backtable.ajax.reload();
     					});
     				}
     			});
            }
        },{
            el: '#deptChooseButton',
            event: 'click',
            handler: function () {
            	 var dptId= $("#scNameCodes").val();
                 layer.dialog({
                     title: '选择检查事项',
                     area: ['30%', '40%'],
                     content: '/syn/drcheck/syn/server/sctype/toTreePage',
                     callback: function (data) {
                    	 if(data.reload.retruncode != null && data.reload.retruncode != "" && data.reload.retruncode != "undefined"){
                    		 var retruncode=data.reload.retruncode; 
                    		 var scNames = data.reload.returnname;
                    		 $("#scNameCodes").val(retruncode);
                    		 $("#scNames").html(scNames);
                    		 updateCheckItem();
                    	 }
                     }
                 });
            }
        },{
            el: '#addAgentId',
            event: 'click',
            handler: function () {
            	 var deptTaskUid= $("#deptTaskUid").val();
            	 var deptCode= $("#deptCode").val();
            	 var scTypeWay= $("#scTypeWay").val();
                 layer.dialog({
                     title: '选择执法人员',
                     area: ['90%', '90%'],
                     content: '/syn/server/drcheck/pubscagent/choosepage?deptTaskUid='+deptTaskUid+'&deptCode='+deptCode+'&scTypeWay='+scTypeWay,
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
            	var checkNumber = $("#checkNumber").val();
            	var groupAgentNumber = $("#groupAgentNumber").val();
            	var g = /^\d+$/;
        		if(!g.test(checkNumber)||checkNumber=="0"){
        			layer.tips("请输入一个大于0的整数",$("#checkNumber"),{tips:1, tipsMore:true, ltype:0});
        			return false;
        		}else if(!g.test(groupAgentNumber) || groupAgentNumber=="0" || groupAgentNumber < 2){
        			layer.tips("请输入一个大于等于2的整数",$("#groupAgentNumber"),{tips:1, tipsMore:true, ltype:0});
        			return false;
        		}else if(parseInt(checkNumber) < parseInt(groupAgentNumber)){
        			layer.tips("随机抽取的执法人员数量不得小于每组最少分配人数！",$("#checkNumber"),{tips:1, tipsMore:true, ltype:0});
        			return false;
        		}else{
        			layer.confirm('系统将随机抽取【'+checkNumber+'】个执法人员，按照每组不少于【'+groupAgentNumber+'】人分组，并且随机匹配到每家企业，可能需要一段时间，是否继续？', {icon: 2, title: '提示'}, function (index) {
	        			var scTypeWay= $("#scTypeWay").val();
	        			http.httpRequest({
	        				url: '/syn/pub/server/drcheck/pubsctaskagent/random',
	        				serializable: false, 
	        				data: {deptTaskNO:$("#deptTaskUid").val(),taskNO:$("#taskNO").val(),number:checkNumber,scTypeWay:scTypeWay,groupAgentNumber:groupAgentNumber},
	        				type:"post",
	        				success: function (data) {
	        					layer.msg(data.msg, {time: 1000}, function () {
	        						if(data.status == 'success'){
	        							agenttable.ajax.reload();
	        							backtable.ajax.reload();
	        							$("#addAgentId").hide();
	        							$("#clean").hide();
	        							$("#random").hide();
	        							$("#agent-form").hide();
	        							$("#searchAgentScinfo").show();
	        						}
	        					});
	        				}
	        			});
        			});
        		}
            }
        },{
            el: '#save',
            event: 'click',
            handler: function () {
            	layer.confirm('系统将按照匹配结果，将企业分配给执法人员，保存设置后将不得修改，是否继续操作？', {icon: 2, title: '提示'}, function (index) {
            		http.httpRequest({
            			url: '/syn/server/drcheck/scstack/save',
            			serializable: false, 
            			data: {deptTaskNO:$("#deptTaskUid").val(),taskNO:$("#taskNO").val(),deptTaskUid:$("#deptTaskUid").val()},
            			type:"post",
            			success: function (data) {
            				layer.msg(data.msg, {time: 1000}, function () {
            					if(data.status == 'success'){
            						layer.close({reload: true});
            					}
            				});
            			}
            		});
            	});
            }
        },{
            el: '#searchAgentScinfo',
            event: 'click',
            handler: function () {
            	var deptTaskUid= $("#deptTaskUid").val();
            	var taskNO = $("#taskNO").val();
            	layer.dialog({
                    title: '企业与人员随机配对结果',
                    area: ['80%', '80%'],
                    content: '/syn/pub/server/drcheck/pubscinfo/matchresult?deptTaskNO='+deptTaskUid+'&taskNO='+taskNO,
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
            el: '#ulID li',
            event: 'click',
            handler: function () {
            	var lichooseid = $(this).attr("lichooseid");
            	var flag = $(this).attr("flag");
            	$("#ulID li").removeClass("tab-selected");
            	$(this).addClass("tab-selected");
            	$("#depttaskNO").val(lichooseid);
            	if(flag == "Y"){
            		$("#sctypeDivid").show();
            		$("#backDIV").show();
            		$("#flPid").show();
            	}else{
            		$("#sctypeDivid").hide();
            		$("#backDIV").hide();
            		$("#flPid").hide();
            	}
            	agenttable.ajax.reload();
            }
        },{
			el: '#fold-text',
			event: 'click',
			handler:function(){
				if($(this).text() == '收起') {
					$('#fold-box').hide();
					$(this).text('展开');
				} else {
					$('#fold-box').show();
					$(this).text('收起');
				}
			}
		}]);
    }
});
