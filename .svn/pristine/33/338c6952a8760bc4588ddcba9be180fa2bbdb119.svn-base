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
    var table;
    var togetherTable;
    var searchParams;
    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	var randomType = $("#randomType").val();
    	if(randomType != ""){
    		loadTogetherTable();
    	}
    	if(randomType == '1'){
    		loadBackTable();
    	}
    }
    
    function loadBackTable(){
    	var userType = $("#userType").val();
    	var url = '/reg/pub/server/sccheck/entback/list.json';
    	if(userType == '2'){
    		url = '/syn/pub/server/sccheck/entback/list.json';
    	}
    	table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#scentback-table',
            //是否加索引值
            showIndex: true,
            scrollX: true,
            ajax: {
                url:url,
                data:function(d){
	               		 d.params = $("#qryForm").serializeObject();
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //'className'不要写成class
            columns: [
                {data: '_idx', 'className': 'center'},
                {data: null, 'className': 'center'}, 
                {data: 'regNO'},
                {data: 'entName'},
                {data: 'estDate'},
                {data: 'entTypeCatg'},
                {data: 'lastCheckTime'},
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
			},{
				targets:5,
				render:function(data,type,row,meta){
					if(row.entTypeCatg == "50"){
						return "个体户";
					}else if(row.entType == "16" || row.entType == "17"){
						return "农专社";
					}else if(row.entType == "23"){
						return "外企代表机构";
					}else{
						return "企业";
					}
				}
			}]
        })
    }
    
    function loadTogetherTable(){
    	var userType = $("#userType").val();
    	var turl = '/reg/pub/server/sccheck/entcondition/list.json';
    	if(userType == '2'){
    		turl = '/syn/pub/server/sccheck/entcondition/list.json';
    	}
    	togetherTable = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#scentcondition-table',
            "bPaginate" : false,
            //是否加索引值
            showIndex: true,
            scrollX: true,
            ajax: {
                url:turl,
                data:function(d){
	               	d.params = $("#qryForm").serializeObject();
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //'className'不要写成class
            columns: [
                {data: '_idx', 'className': 'center'},
                {data: 'checkName',cut: {length: 20,mark:'...'}},
                {data: 'specialName'},
                {data: 'specialNum'},
                {data: null},
                {data: null}
            ],
            columnDefs: [{
				targets:4,
				render:function(data,type,row,meta){
					return '<input type="radio" class="radio1" id="radio1_'+data.uid+'" name="spe_radio_'+data.uid+'" value="num_'+data.uid+'"/>固定'
					+'<input type="text" class="input1" id="num_'+data.uid+'" style="width: 50px;line-height:20px;"/>'
					+'<input type="radio" class="radio2" id="radio2_'+data.uid+'" name="spe_radio_'+data.uid+'" value="percent_'+data.uid+'"/>比例'
					+'<input type="text" class="input2" id="percent_'+data.uid+'" style="width: 50px;line-height:20px;"/>%'
					+'<input type="hidden" id="snum_'+data.uid+'" value="'+data.specialNum+'"/>'
					+'<input type="hidden" class="uid" value="'+data.uid+'"/>';
				}
			},{
				targets:5,
				render:function(data,type,row,meta){
					if(data.randomNum){
						return '<span id="count_'+data.uid+'">'+data.randomNum+'</span>';
					}else{
						return '<span id="count_'+data.uid+'">0</span>';
					}
				}
			}]
        })
    }

    function bind() {
        util.bindEvents([{      
			el: '#addPage',
            event: 'click',
            handler: function () {
            	var userType = $("#userType").val();
            	var url = '/reg/pub/server/sccheck/entback/addpage';
            	if(userType == '2'){
            		url = '/syn/pub/server/sccheck/entback/addpage';
            	}
            	layer.dialog({
		            title: '添加检查对象',
		            area: ['100%', '100%'],
		            content:url+"?taskUid="+$("#taskUid").val(),
		            callback: function (data) {
		            	if (data.reload) { 
		                	table.ajax.reload();
		                	$("#checkboxallid").prop("checked",false);
		                	$("#buttonFlag2").val("N");
		                	togetherTable.ajax.reload();
		                	clearCondition();
		                } 
		            }
		        })  
            }
        },{
        	el:'#exportEntBack',//导入检查对象名单
        	event:'click',
        	handler:function(){
        		var userType = $("#userType").val();
            	var url = '/reg/pub/server/sccheck/entback/exportpage';
            	if(userType == '2'){
            		url = '/syn/pub/server/sccheck/entback/exportpage';
            	}
        		var taskUid = $("#taskUid").val();
        		layer.dialog({
                     title: 'excel导入待抽检库',
                     area: ['40%', '30%'],
                     content: url+'?taskUid='+taskUid,
                     callback: function (data) {
                    	//重新加载列表数据
                         if (data.reload) {
                        	 table.ajax.reload();
                        	 $("#checkboxallid").prop("checked",false);
                        	 $("#buttonFlag2").val("N");
                        	 togetherTable.ajax.reload();
                        	 clearCondition();
                         }
                     }
                 });
        	}
        },{
	    	el:'#exportSpecial',//导入专项检查对象库
	    	event:'click',
	    	handler:function(){
	    		var userType = $("#userType").val();
	        	var url = '/reg/pub/server/sccheck/entback/special';
	        	if(userType == '2'){
	        		url = '/syn/pub/server/sccheck/entback/special';
	        	}
	    		var taskUid = $("#taskUid").val();
	    		layer.dialog({
	                 title: '导入专项检查对象库',
	                 area: ['60%', '70%'],
	                 content: url+'?taskUid='+taskUid,
	                 callback: function (data) {
	                	//重新加载列表数据
	                     if (data.reload) {
	                    	 table.ajax.reload();
	                    	 $("#checkboxallid").prop("checked",false);
	                     }
	                 }
	             });
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
    				layer.confirm('您确定要清除这一批待抽检库数据吗？', {icon: 2, title: '提示'}, function (index) {
    					var taskUid = $("#taskUid").val();
    					var formParam = {
    							delUidList: pripIdList,
    							taskUid : taskUid
    					};
    					var userType = $("#userType").val();
    	            	var url = '/reg/pub/server/sccheck/entback/del';
    	            	if(userType == '2'){
    	            		url = '/syn/pub/server/sccheck/entback/del';
    	            	}
    					http.httpRequest({
    						url: url,
    						dataType:"json",  
    						serializable: true,
    						data: formParam,
    						type:"post",
    						success: function (data) {
    							layer.msg(data.msg, {time: 1000}, function () {
    								if(data.status == 'success'){
    									table.ajax.reload();
    									$("#checkboxallid").prop("checked",false);
    									$("#buttonFlag2").val("N");
    									togetherTable.ajax.reload();
    									clearCondition();
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
					var formParam = {
							taskUid: taskUid
					};
					var userType = $("#userType").val();
	            	var url = '/reg/pub/server/sccheck/entback/clean';
	            	if(userType == '2'){
	            		url = '/syn/pub/server/sccheck/entback/clean';
	            	}
					http.httpRequest({
						url: url+"?taskUid="+taskUid,
						dataType:"json",  
						serializable: true,
						type:"post",
						success: function (data) {
							layer.msg(data.msg, {time: 1000}, function () {
								if(data.status == 'success'){
									table.ajax.reload();
									$("#checkboxallid").prop("checked",false);
									$("#buttonFlag2").val("N");
									togetherTable.ajax.reload();
									clearCondition();
								}
							});
						}
					});
				});
        	}
        },{
            el: '#qry',
            event: 'click',
            handler: function () {
            	 table.ajax.reload();
            	 $("#checkboxallid").prop("checked",false);
            }
        },{
            el: '#cancel',
            event: 'click',
            handler: function () {
            	$("#regNO").val("");
            	$("#entName").val("");
            }
        },{
            el: '#checkboxallid',
            event: 'click',
            handler: function () {
            	if($(this).prop("checked")){
            		$("input:checkbox[name='pubscentbackchk']").each(function () {
            			$(this).prop("checked",true);
            		});
				 }else{
					$("input:checkbox[name='pubscentbackchk']").each(function () {
	            			$(this).prop("checked",false);
            		});
				 }
            }
        },{
            el: '#confirm',
            event: 'click',
            handler: function () {
            	var userType = $("#userType").val();
            	var url = '/reg/pub/server/sccheck/entcondition/confirm';
            	if(userType == '2'){
            		url = '/syn/pub/server/sccheck/entcondition/confirm';
            	}
            	var taskUid = $("#taskUid").val();
				http.httpRequest({
					url: url+"?taskUid="+taskUid,
					dataType:"json",  
					serializable: true,
					type:"post",
					success: function (data) {
						layer.msg(data.msg, {time: 1000}, function () {
							if(data.status == 'success'){
								if(togetherTable != null){
									togetherTable.ajax.reload();
								}
								$("#totalEnt").val("");
				            	$("#totalRandom").val("");
				            	$("#randomPercent").val("");
				            	$("#buttonFlag1").val("Y");
							}
						});
					}
				});
            }
        },{
            el: '.chooseAll',
            event: 'click',
            handler: function () {
            	var value = $(this).val();
            	if(value == "1"){
            		$(".radio1").prop("checked",true);
            		$(".input1").val("");
            		$(".radio2").prop("checked",false);
            		$(".input2").val("");
            		$("#allNum").val("");
            	}else{
            		$(".radio2").prop("checked",true);
            		$(".input2").val("");
            		$(".radio1").prop("checked",false);
            		$(".input1").val("");
            		$("#allNum").val("");
            	}
            }
        },{
            el: '#allNum',
            event: 'blur',
            handler: function () {
            	var type = $("input[name='chooseAll']:checked").val();
            	var value = $(this).val();
            	if(type == "1"){
            		var g = /^([1-9]\d*|0)$/;
            		if(g.test(value)){
            			$(".input1").each(function(){
            				$(this).val(value);
            			});
            		}else{
            			layer.tips("请输入一个大于或者等于0的整数!",$("#allNum"),{tips:3, tipsMore:true, ltype:0});
            		}
            	}else if(type == "2"){
            		var g = /^([1-9]|[1-9][0-9]|100|0|100\.0|[1-9]{1,2}\.[0-9]|[0-9]\.[0-9])$/;
            		if(g.test(value)){
            			$(".input2").each(function(){
            				$(this).val(value);
            			});
            		}else{
            			layer.tips("请输入一个100以内的整数或小数(保留一位小数)",$("#allNum"),{tips:3, tipsMore:true, ltype:0});
            		}
            	}
            }
        },{
            el: '#confirmCondition',
            event: 'click',
            handler: function () {
            	if(!chooseCheckType()){
            		layer.tips("请选择抽取模式",$("#checkType1"),{tips:3, tipsMore:true, ltype:0});
            		return false;
            	}
            	var totalEnt = 0;
            	var totalRnadom = 0;
            	var flag = true;
            	var message = "";
            	var htmlId = "";
            	$(".uid").each(function(){
            		var uid = $(this).val();
            		var total = $("#snum_"+uid).val();
            		totalEnt += Number(total);
            		var id = $("input[name='spe_radio_"+uid+"']:checked").val();
            		if(typeof id == "undefined"){
            			$("#count_"+uid).html("0");
            		}else{
            			var value = $("#"+id).val();
	            		if(value != "" && value != null){
	            			var numvalue = Number(value);
	            			if(id.indexOf("num_") != -1){
	            				var g = /^([1-9]\d*|0)$/;
	                        	if(!g.test(value)){
	                        		message = "请输入一个大于或者等于0的整数!";
	            					htmlId = id;
	            					flag = false;
	            					return false;
	                        	}
	            				if(numvalue > Number(total)){
	            					message = "抽取目标户数不能大于抽取库主体户数！";
	            					htmlId = id;
	            					flag = false;
	            					return false;
	            				}
	            				$("#count_"+uid).html(numvalue);
	            				totalRnadom += numvalue;
	            			}else if(id.indexOf("percent_") != -1){
	            				var g = /^([1-9]|[1-9][0-9]|100|0|100\.0|[1-9]{1,2}\.[0-9]|[0-9]\.[0-9])$/;
	            				if(!g.test(value)){
	            					message = "请输入一个100以内的整数或小数(保留一位小数)！";
	            					htmlId = id;
	            					flag = false;
	            					return false;
	            				}
	            				var totalSelected =  Math.round(total * numvalue * 0.01);
	            				$("#count_"+uid).html(totalSelected);
	            				totalRnadom += totalSelected;
	            			}
	            		}else{
	            			$("#count_"+uid).html("0");
	            		}
            		}
            	});
            	if(!flag){
            		$("#"+htmlId).focus();
            		$("#"+htmlId).val("");
            		layer.tips(message,$("#"+htmlId),{tips:3, tipsMore:true, ltype:0});
            		return false;
            	}
            	var g1 = /^([1-9]\d*|0)$/;
            	if(!g1.test(totalRnadom)){
            		layer.msg("请按照选择的抽取数量方式，填写正确的抽取数量或者比例！", {time: 3000}, function () {});            		
            		return false;
            	}
            	if(totalRnadom > totalEnt){
            		layer.msg("抽取目标总户数不能超过检查对象抽取库总户数，请重新设置抽取数量！", {time: 3000}, function () {});
            		return false;
            	}
            	var randomType = $("input[name='checkType']:checked").val();
            	if(totalEnt == 0){
            		if(randomType == "1"){
            			layer.msg("请先添加检查对象", {time: 2000}, function () {});
            		}else if(randomType == "2"){
            			layer.msg("专项库中未查询到与当前任务设置的检查事项相对应的企业，请先添加专项库信息或者选择其他的抽取模式。", {time: 3000}, function () {});
            		}
            		return false;
            	}
            	$("#totalEnt").val(totalEnt);
            	$("#totalRandom").val(totalRnadom);
            	var randomPercent = (totalRnadom/totalEnt).toFixed(3);
            	var percent = (randomPercent * 100).toFixed(1)+"%";
            	$("#randomPercent").val(percent);
            	var userType = $("#userType").val();
            	var url = '/reg/pub/server/sccheck/entcondition/commit';
            	if(userType == '2'){
            		url = '/syn/pub/server/sccheck/entcondition/commit';
            	}
            	var taskCondition = $("#taskCondition").val();
            	http.httpRequest({
        			url: url,
        			dataType:"json",  
        			contentType : 'application/json;charset=utf-8',
        			data: JSON.stringify(getCommitParam(totalEnt,totalRnadom,percent,taskCondition,randomType)),
        			type:"post",
        			success: function (data) {
        				layer.msg(data.msg, {time: 1000}, function () {
        					if(data.status == 'success'){
        						$("#buttonFlag2").val("Y");
        					}
        				});
        			}
        		});
            }
        },{
            el: '#randomButton',
            event: 'click',
            handler: function () {
            	if(!chooseCheckType()){
            		layer.tips("请选择抽取模式",$("#checkType1"),{tips:3, tipsMore:true, ltype:0});
            		return false;
            	}
            	if(!checkButtonFlag("#buttonFlag2")){
            		layer.tips("请先确认抽取对象设置",$("#confirmCondition"),{tips:3, tipsMore:true, ltype:0});
            		return false;
            	}
            	if(!valifyFrom()){
            		return false;
            	}
            	layer.confirm('您确认要进行随机抽取企业操作吗？', {icon: 2, title: '提示'}, function (index) {
	        		var userType = $("#userType").val();
	        		var url = '/reg/pub/server/sccheck/entback/random';
	        		if(userType == '2'){
	        			url = '/syn/pub/server/sccheck/entback/random';
	        		}
	        		var taskUid = $("#taskUid").val();
	        		var randomType = $("input[name='checkType']:checked").val();
	        		if(typeof randomType == "undefined"){
	        			randomType = "";
	        		}
	        		layer.dialog({
	                    title: '随机抽取企业',
	                    area: ['100%', '100%'],
	                    content: url+'?taskUid='+taskUid+"&randomType="+randomType,
	                    callback: function (data) {
	                    	layer.close(index);
	                    	if(data.reload){
	    						layer.close({reload:true});
	    					}
	    					
	                    }
	                });
            	});
            }
        },{
            el: '#taskDetail',
            event: 'click',
            handler: function () {
            	var taskUid = $("#taskUid").val();
            	var userType = $("#userType").val();
            	var url = '/reg/server/sccheck/scplantask/addOrEditView?flag=3&uid='+taskUid;
            	if(userType == '2'){
            		url = '/syn/sccheck/scplantask/addOrEditView?flag=3&uid='+taskUid;
            	}
            	layer.dialog({
                    title: '查看详情',
                    area: ['100%', '100%'],
                    content:url,
                    callback: function(data) {
                    	 
                    }
                })
            }
        },{
            el: '#cancleEdit',
            event: 'click',
            handler: function () {
            	layer.close({reload:false});
            }
        },{
            el: '.checkType',
            event: 'click',
            handler: function () {
            	var randomType = $("input[name='checkType']:checked").val();
            	$("#randomType").val(randomType);
            	if(randomType == "1"){
            		$("#addbackDiv").show();
            		if(togetherTable == null){
                		loadTogetherTable();
                	}else{
                		togetherTable.ajax.reload();
                	}
            		if(table == null){
            			loadBackTable();
            		}else{
            			table.ajax.reload();
            		}
            	}else{
            		$("#addbackDiv").hide();
            		var taskUid = $("#taskUid").val();
            		var userType = $("#userType").val();
            		var url = '/reg/pub/server/sccheck/entcondition/specialrandom?taskUid='+taskUid;
                	if(userType == '2'){
                		url = '/syn/pub/server/sccheck/entcondition/specialrandom?taskUid='+taskUid;
                	}
            		http.httpRequest({
            			url: url,
            			dataType:"json",  
            			contentType : 'application/json;charset=utf-8',
            			type:"post",
            			success: function (data) {
            				if(togetherTable == null){
                        		loadTogetherTable();
                        	}else{
                        		togetherTable.ajax.reload();
                        	}
            			}
            		});
            	}
            	clearCondition();
            }
        }])
    }
    
    function clearCondition(){
    	$("#totalEnt").val("");
    	$("#totalRandom").val("");
    	$("#randomPercent").val("");
    }
    
    function getCommitParam(totalEnt,totalRnadom,percent,taskCondition,randomType){
    	var pubScentConditionList = new Array();
    	$(".uid").each(function(){
    		var uid = $(this).val();
    		var randomNum = $("#count_"+uid).html();
    		var pubScentCondition = new initPubScentCondition(uid, randomNum);
    		pubScentConditionList.push(pubScentCondition);
    	});
    	var pubScentConditionDto={};
    	pubScentConditionDto.pubScentConditionList = pubScentConditionList;
    	var taskUid = $("#taskUid").val();
    	var pubScPlanTask = new initPubScPlanTask(taskUid,totalEnt, totalRnadom, percent,taskCondition,randomType);
    	pubScentConditionDto.pubScPlanTask = pubScPlanTask;
    	return pubScentConditionDto;
    }
    
    function initPubScentCondition(uid,randomNum){
  	  this.uid=uid;
  	  this.randomNum=randomNum;
    }
    function initPubScPlanTask(taskUid,entTotal,randomTotal,randomPercent,taskCondition,randomType){
    	this.uid=taskUid;
    	this.entTotal=entTotal;
    	this.randomTotal=randomTotal;
    	this.randomPercent=randomPercent;
    	this.taskCondition=taskCondition;
    	this.randomType=randomType;
    }
    
    function checkButtonFlag(id){//抽取开关
    	var buttonFlag1 = $(id).val();
    	if(buttonFlag1 == "N"){
    		return false;
    	}
    	return true;
    }
    
    function chooseCheckType(){//抽取模式是否选中
    	var randomType = $("input[name='checkType']:checked").val();
    	if(typeof randomType == "undefined"){
    		return false;
    	}
    	return true;
    }
    
    function valifyFrom(){
    	var totalEntValue = $("#totalEnt").val();
    	var totalRnadomValue = $("#totalRandom").val();
    	var totalEnt = Number(totalEntValue);
    	var totalRnadom = Number(totalRnadomValue);
    	if(totalRnadom <= 0 ){
    		layer.msg("抽取目标总户数必须大于0，请重新设置抽取数量！", {time: 3000}, function () {});
    		return false;
    	}
    	if(totalRnadom > totalEnt){
    		layer.msg("抽取目标总户数不能超过检查对象抽取库总户数，请重新设置抽取数量！", {time: 3000}, function () {});
    		return false;
    	}
    	return true;
    }
})
