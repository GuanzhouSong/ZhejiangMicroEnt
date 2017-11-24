require(['component/iframeLayer', 'component/dataTable','common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {
	var params={};//查询参数声明!
	var clickFlag = false;
	init();
	    /**
		 * 初始化函数集合
		 */
	    function init() {
	    	//初始化检查主体类型
	    	initdataForEntCatg();
	    	//列表加载
	        initDataTable();
	        
	        bind();
	        loadTotal();
	    }
	    
	    
	    function initdataForEntCatg(){
	        var catgCode = $("#taskEntCatgCode").val();
	        if(catgCode.indexOf("0") != -1){$("#entType_0").show();$("#comType").attr("checked",true);}
	        if(catgCode.indexOf("1") != -1){$("#entType_1").show();$("#perType").attr("checked",true);}
	        if(catgCode.indexOf("2") != -1){$("#entType_2").show();$("#farmType").attr("checked",true);}
	        
	        var type=new Array();
	    	$(":checkbox[name=_checkobx]:checked").each(function(k,v) {
	            type[k]=$(this).val();
	        });
	    	http.httpRequest({
				url: '/commom/server/entcatg/selectEntcatgByCation',
				serializable: false, 
				contentType : 'application/json;charset=utf-8', //设置请求头信息
	            dataType:"json",
				data:JSON.stringify(type),
				type:"post",
				success: function (data) {
	             var data=data.data;
	             var string="<option value=''>请选择</option>";
	             $.each(data,function(k,v){
	            	 string+="<option value="+v.code+">"+v.content+"</option>"
	             });
	                $("#entType").html(string);
				}
			}); 
	    }
        
	    var start = {
	            elem: '#estDateStart', //选择ID为START的input
	            format: 'YYYY-MM-DD', //自动生成的时间格式
	            min: '1970-01-01', //设定最小日期为当前日期
	            max: '2099-06-16', //最大日期
	            istime: true, //必须填入时间
	            istoday: false,  //是否是当天
	            start: laydate.now(0,"YYYY-MM-DD"),  //设置开始时间为当前时间
	            choose: function(datas){
	            end.min = datas; //开始日选好后，重置结束日的最小日期
	            end.start = datas; //将结束日的初始值设定为开始日
	            }
	        };
	        var end = {
	            elem: '#estDateEnd',
	            format: 'YYYY-MM-DD',
	            min: '1970-01-01',
	            max: '2099-06-16',
	            istime: true,
	            istoday: false,
	            start: laydate.now(0,"YYYY-MM-DD"),
	            choose: function(datas){
	            start.max = datas; //结束日选好后，重置开始日的最大日期
	            }
	        };

	    
	    $("#estDateStart").click(function(){laydate(start);});
	    $("#estDateEnd").click(function(){laydate(end);});
	    
	    
	    var listtable;
	    var backtable;
	    var infotable;

	    /**
		 * 初始化dataTable
		 */
	    function initDataTable() {
	    	listtable = dataTable.load({
	            el: '#list-table',
	            showIndex: true,
	            scrollX: true,
	            ajax: {
	                url:'/syn/server/drcheck/scstack/panoQueryPage',
	                data:function(d){
	                	if(clickFlag){
	                		d.params = params;
	                	}else{
	                		d.params = $("#searchForm").serializeObject();
	                	}
	                }
	            },
	            columns: [
	                {data: null,"className": "center",defaultContent:'111'},
	                {data: null,"className": "center"}, 
	                {data: null,"className": "center"}, 
	                {data: "entName","className": "center"}, 
	                {data: "leRep","className": "center"},
	                {data: "tel", "className": "center"},
	                {data: "liaTel", "className": "center"},
	                {data: "liaName", "className": "center"},
	                {data: "estDate", "className": "center"}, 
	                {data: "entTypeName", "className": "center"}
	            ],
	            columnDefs: [{
	            	targets:1,
	    	        render:function(data,type,row,meta){
	    	        	return "<input type='checkbox' name='pubscinfocheckbox' value='"+data.priPID+"' />";
	    	       }
		        },{
	            	targets:2,
	    	        render:function(data,type,row,meta){
	    	        	if(data.uniscid != null && data.uniscid != ""){
		   					return data.uniscid;
		   				}else{
		   					return data.regNO;
		   				}
	    	       }
		        }]
	        });
	    	
	    	backtable = dataTable.load({
	            el: '#back-table',
	            showIndex: true,
	            scrollX: true,
	            ajax: {
	                url:'/syn/pub/server/drcheck/pubscinfoback/list.json',
	                data:function(d){
		               	d.params = $("#paramForm").serializeObject();
	                }
	            },
	            columns: [
	                {data: "id","className": "center"},
	                {data: null,"className": "center"}, 
	                {data: "entName", "className": "center"}, 
	                {data: "leRep","className": "center"},
	                {data: "tel", "className": "center"},
	                {data: "liaName","className": "center"},
	                {data: "leRepPhone", "className": "center"},
	                {data: "estDate", "className": "center"},
	                {data: "entTypeCatgDesc","className": "center"},
	                {data: "industryDesc","className": "center"}
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
	    	
	    	infotable = dataTable.load({
	            el: '#info-table',
	            showIndex: true,
	            scrollX: true,
	            ajax: {
	                url:'/syn/pub/server/drcheck/pubscinfo/randomlist.json',
	                data:function(d){
		               	d.params = $("#paramForm").serializeObject();
	                }
	            },
	            columns: [
	                {data: "id","className": "center"},
	                {data: null,"className": "center"}, 
	                {data: "entName","className": "center"}, 
	                {data: "leRep","className": "center"},
	                {data: "tel", "className": "center"},
	                {data: "liaName","className": "center"},
	                {data: "leRepPhone","className": "center"},
	                {data: "estDate","className": "center"},
	                {data: "entTypeCatgDesc","className": "center"},
	                {data: "industryDesc","className": "center"}
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
	    }
	    
	    function loadTotal() {
	    	http.httpRequest({
				url: '/syn/pub/server/drcheck/pubscinfoback/count',
				serializable: false, 
				data: $("#paramForm").serializeObject(),
				type:"post",
				success: function (data) {
					var total = data.msg;
					$("#total").val(total);
					$("#totalWating").html("共"+total+"户");
				}
			});
	    }
	    
	    function bind() {
	        util.bindEvents([{
	            el: '#confirmPubscinfoBack',
	            event: 'click',
	            handler: function () {
	            	var total = $("#total").val();
	            	if(total == "0" || total == ""){
	            		layer.tips("请先导入待抽检名单",$("#addPubscinfoBack"),{tips:3, tipsMore:true, ltype:0});
	            	}else{
	            		layer.confirm('确认本次抽取对象后，将不得修改，是否继续操作？', {icon: 2, title: '提示'}, function (index) {
	            			$("#confirmFlag").val("Y");
	            			$("#addPubscinfoBack").hide();
	            			$("#insertBatchBack").hide();
	            			$("#cleanPubscinfoBack").hide();
	            			$("#confirmPubscinfoBack").hide();
	            			layer.close(index);
	            			var total = $("#total").val();
	            			layer.msg("成功导入待抽检库"+total+"家企业，可进行【第三步：摇号抽取被检查对象】", {icon: 7,time: 2000});
	            		});
	            	}
	            }
	        },{
	            el: '#chooseAll',
	            event: 'click',
	            handler: function () {
	            	if($(this).prop("checked")){
            			$("#checkboxallid").prop("checked",false);	
            			$("#list-table input").prop("checked",false);
	            	}
	            }
	        },{
	            el: '#checkboxallid',
	            event: 'click',
	            handler: function () {
	            	if($(this).prop("checked")){
						 $("#list-table input").prop("checked",true);
						 if($("#chooseAll").prop("checked")){
							 $("#chooseAll").prop("checked",false);	
		            	}
					 }else{
						 $("#list-table input").prop("checked",false);
					 }
	            }
	        },{
	            el: '#addPubscinfoBack',
	            event: 'click',
	            handler: function () {
            		if($("input:checkbox[name='chooseAll']:checked").prop("checked")){
            			layer.confirm('您确定要导入所有企业吗？', {icon: 2, title: '提示'}, function (index) {
            				 var formParam = $('#searchForm').serializeObject();
        					http.httpRequest({
        						url: '/syn/pub/server/drcheck/pubscinfoback/addAll',
        						serializable: false,
        						data: $("#searchForm").serializeObject(),
        						type:"post",
        						success: function (data) {
        							layer.msg(data.msg, {time: 1000}, function () {
        								if(data.status == 'success'){
        									backtable.ajax.reload();
        									loadTotal();
        								}
        							});
        						}
        					});
        				});
            		}else{
            			var pripIdList = new Array();
            			$("input:checkbox[name='pubscinfocheckbox']:checked").each(function () {
            				pripIdList.push($(this).val());
            			});
            			if (pripIdList.length > 0) {
            				layer.confirm('您确定要导入这批企业名称吗？', {icon: 2, title: '提示'}, function (index) {
            					var formParam = {
            							taskNO:$("#taskNO").val(),
            							pripIdList: pripIdList
            					};
            					http.httpRequest({
            						url: '/syn/pub/server/drcheck/pubscinfoback/add',
            						dataType:"json",  
            						serializable: true,
            						data: formParam,
            						type:"post",
            						success: function (data) {
            							layer.msg(data.msg, {time: 1000}, function () {
            								if(data.status == 'success'){
            									backtable.ajax.reload();
            									loadTotal();
            								}
            							});
            						}
            					});
            				});
            			}else {
            				layer.msg("请您先<em style='color: red;'>【选中一项】</em>进行操作!", {icon: 7,time: 1000});
            			}
            		}
	            }
	        },{
	            el: '#cleanPubscinfoBack',
	            event: 'click',
	            handler: function () {
            		layer.confirm('您确定要清除待抽检库吗？', {icon: 2, title: '提示'}, function (index) {
            			http.httpRequest({
            				url: '/syn/pub/server/drcheck/pubscinfoback/remove',
            				serializable: false, 
            				data: $("#paramForm").serializeObject(),
            				type:"post",
            				success: function (data) {
            					layer.msg(data.msg, {time: 1000}, function () {
            						if(data.status == 'success'){
            							backtable.ajax.reload();
            							 loadTotal();
            						}
            					});
            				}
            			});
            		});
	            }
	        },{
	            el: '#randombutton',
	            event: 'click',
	            handler: function () {
	            	var confirmFlag = $("#confirmFlag").val();
	            	if(confirmFlag != "Y"){
	            		layer.tips("请先确认本次抽取对象",$("#confirmPubscinfoBack"),{tips:1, tipsMore:true, ltype:0});
	            		return false;
	            	}else{
		            	var checkpercent = $("#checkpercent").val();
		            	var g = /^([1-9]|[1-9][0-9]|[1-9]\.[0-9]|[1-9][0-9]\.[0-9])$/;
	            		if(!g.test(checkpercent)){
	            			layer.tips("请输入1到100之间的整数或者1到100之间的（一位）小数，例如1.3",$("#checkpercent"),{tips:1, tipsMore:true, ltype:0});
	            			$("#checkpercent").val("");
	            			$("#totalSelected").html("0");
	            			return false;
	            		}
	            		var total = $("#total").val();
	            		if(total == "" || total == "0"){
	            			layer.msg("请先选择待抽取对象", {icon: 7,time: 1000});
		            		return false;
	            		}
	            		var percent = $("#checkpercent").val();
	            		var totalSelected =  Math.round(total * percent * 0.01);
	            		if(totalSelected == 0){
	            			totalSelected = 1;
	            		}
	            		$("#totalSelected").html(totalSelected);
	            		if(totalSelected == "" || totalSelected == "0"){
	            			layer.tips("应抽取户数需大于0",$("#totalSelected"),{tips:1, tipsMore:true, ltype:0});
		            		return false;
	            		}
            			layer.confirm('系统将随机抽取【'+totalSelected+'】家企业，可能需要一段时间，是否继续操作？', {icon: 2, title: '提示'}, function (index) {
            				http.httpRequest({
            					url: '/syn/pub/server/drcheck/pubscinfoback/randoment',
            					data: {taskNO:$("#taskNO").val(),totalRandomNumber:totalSelected},
            					type:"post",
            					success: function (data) {
            						layer.msg(data.msg, {time: 1000}, function () {
            							if(data.status == 'success'){
            								backtable.ajax.reload();
            								infotable.ajax.reload();
//            								loadTotal();
//            								$("#firstNum").val("");
//            								$("#totalSelected").html("0");
//            								$("#checkpercent").val("");
            								$("#totalH5").html("抽查检查名单：共"+totalSelected+"户");
            								$("#totalEnt").val(totalSelected);
            								$("#randombutton").hide();
            							}
            						});
            					}
            				});
            			});
	            		
	            	}
	            }
	        },{
	            el: '#checkpercent',
	            event: 'blur',
	            handler: function () {
	            	var checkpercent = $(this).val();
	            	var g = /^([1-9]|[1-9][0-9]|[1-9]\.[0-9]|[1-9][0-9]\.[0-9])$/;
            		if(!g.test(checkpercent)){
            			layer.tips("请输入1到100之间的整数或者1到100之间的（一位）小数，例如1.3",$("#checkpercent"),{tips:1, tipsMore:true, ltype:0});
            			$(this).val("");
            			$("#totalSelected").html("0");
            			return false;
            		}
            		var total = $("#total").val();
            		var percent = $(this).val();
            		var totalSelected =  Math.round(total * percent * 0.01);
            		if(totalSelected == 0){
            			totalSelected = 1;
            		}
            		$("#totalSelected").html(totalSelected);
	            }
	        },{
	            el: '#searchInfo',
	            event: 'click',
	            handler: function () {
	            	var totalEnt = $("#totalEnt").val();
	            	if(totalEnt == "" || totalEnt == "0"){
	            		layer.tips("请先随机抽取被检查名单",$("#randombutton"),{tips:3, tipsMore:true, ltype:0});
	            	}else{
		            	var url = "/syn/pub/server/drcheck/pubscinfo/scdetail?taskNO="+$("#taskNO").val();
	                    window.open(url);
	            	}
	            }
	        },{
	            el: '#cleanInfo',
	            event: 'click',
	            handler: function () {
            		layer.confirm('您确定要清除检查名单吗？', {icon: 2, title: '提示'}, function (index) {
            			http.httpRequest({
            				url: '/syn/pub/server/drcheck/pubscinfo/clean',
            				serializable: false, 
            				data: {taskNO:$("#taskNO").val()},
            				type:"post",
            				success: function (data) {
            					layer.msg(data.msg, {time: 1000}, function () {
            						$("#firstNum").val("");
            						$("#totalSelected").html("0");
            						$("#totalH5").html("抽查检查名单：共0户");
            						$("#totalEnt").val("0");
            						infotable.ajax.reload();
            					});
            				}
            			});
            		});
	            }
	        },{
	            el: '#commit',
	            event: 'click',
	            handler: function () {
	            	var totalEnt = $("#totalEnt").val();
	            	if(totalEnt == "" || totalEnt == "0"){
	            		layer.tips("请先随机抽取被检查名单",$("#randombutton"),{tips:3, tipsMore:true, ltype:0});
	            	}else{
	            		layer.confirm('确认锁定并发送抽查任务吗？', {icon: 2, title: '提示'}, function (index) {
	            			http.httpRequest({
	            				url: '/syn/server/drcheck/scstack/commit',
	            				serializable: false, 
	            				data: {taskNO:$("#taskNO").val()},
	            				type:"post",
	            				success: function (data) {
	            					layer.msg(data.msg, {time: 1000}, function () {
	            						if(data.data != null){
	            							layer.close({reload:true,flag:data.data});
	            						}else{
	            							layer.close({reload:true,flag:false});
	            						}
	            					});
	            				}
	            			});
	            		});
	            	}
	            }
	        },{
	            el: '#close',
	            event: 'click',
	            handler: function () {
	            	layer.confirm('取消本次摇号结果将清空所有记录， 确定继续操作吗？', {icon: 2, title: '提示'}, function (index) {
	            		layer.close(index);
	            		layer.close({reload:false});
	            	});
	            }
	        },{
	        	el:"#selectEntType",
	        	event:'click',
	        	handler:function(){
	        		showEntTypeTree();
	        	}
	        },{
	        	el:'#selectIndustry',
	        	event:'click',
	        	handler:function(){
	        		showIndustryTree();
	        	}
	        },{
		        el:'#selectRegOrg',
		        event:'click',
		        handler:function(){
		        	showRegOrgTree();
		        }
	        }, {
		        el:'#selectLocalAdm',
		        event:'click',
		        handler:function(){
		        	showLocalAdmTree();
		        }
	        },{
	            el: '#search',
	            event: 'click',
	            handler: function () {
	            	clickFlag = true;
	            	params = $("#searchForm").serializeObject();
	            	listtable.ajax.reload();
	            	$("#chooseAll").prop("checked",false);
	            	$("#checkboxallid").prop("checked",false);
	            }
	        },
	        {
	        	el:'#cancel',
	        	event:'click',
	        	handler:function(){
	        		$('#searchForm')[0].reset(); 
	        		$("#industryCo").val("");
	        		$("#regOrg").val("");
	        		$("#localAdm").val("");
	        		
	        	}
	        },
	        {
	        	el:'#insertBatchBack',//进入批量导入待抽检库页面
	        	event:'click',
	        	handler:function(){
	        		var taskNO = $("#taskNO").val();
	        		layer.dialog({
	                     title: '批量导入待抽检库',
	                     area: ['40%', '30%'],
//	                     content: '/syn/server/drcheck/pubscagent/choosepage?deptTaskUid='+deptTaskUid,
	                     content: '/syn/pub/server/drcheck/pubscinfoback/enterimportpage?taskNO='+taskNO,
	                     callback: function (data) {
	                    	//重新加载列表数据
	                         if (data.reload) {
	                        	 loadTotal();
	                        	 backtable.ajax.reload();
	                         }
	                     }
	                 });
	        	}
	        }
	        
	        
	         
	        ]);
	    }
	    
	    function showEntTypeTree(){
	    	layer.dialog({
	            title: '选择企业类型',
	            area: ['350px', '666px'],
	            content: '/commom/server/entcatg/entcatgmutiselect',
	            callback: function (data) {
	            	$("#entType").val('');
	            	$("#entTypeName").val('');
	            	$("#entType").val(data.returncodes);
	            	$("#entTypeName").val(data.returnname);
	            }
	        })
	    }
	    function showIndustryTree(){
	    	layer.dialog({
	            title: '选择行业',
	            area: ['350px', '666px'],
	            content: '/commom/server/industry/toIndustryPhyTree',
	            callback: function (data) {
	            	$("#industryCo").val('');
	            	$("#industryName").val('');
	            	$("#industryCo").val(data.returncodes);
	            	$("#industryName").val(data.returnname);
	            }
	        })
	    }
	    
	    function showRegOrgTree(){
	    	layer.dialog({
	            title: '选择登记机关',
	            area: ['350px', '666px'],
	            content: '/commom/server/regorg/regorgmutiselectnocheck',
	            callback: function (data) {
	            	$("#regOrg").val('');
	            	$("#regOrgName").val('');
	            	$("#regOrg").val(data.returncodes);
	            	$("#regOrgName").val(data.returnname);
	            }
	        })
	    }
	    function showLocalAdmTree(){
	    	layer.dialog({
	            title: '选择管辖单位',
	            area: ['350px', '666px'],
	            content: '/commom/server/regunit/regunitmutiselectnocheck',
	            callback: function (data) {
	            	$("#localAdm").val('');
	            	$("#localAdmName").val('');
	            	$("#localAdm").val(data.returncodes);
	            	$("#localAdmName").val(data.returnname);
	            }
	        })
	    }
	    
	    
	    
});
