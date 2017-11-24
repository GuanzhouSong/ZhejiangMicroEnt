require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate'], function (layer, dataTable, util, http, handlebars) {

    init();
    var scStackState={"00":"任务创建中","01":"待抽取对象","02":"实施中","03":"实施中","04":"实施中","05":"实施中","06":"已完成"}
    /**
     * 初始化函数集合
     */
    function init() { 
        bind();
        autoRowSpan(document.getElementById("checkItemTable"), 1, 1);
        initDataTable();
    }
    
    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#resulthis-table',
            //是否加索引值
            showIndex: true,
            scrollX: true,
            ajax: {
                url:'/syn/server/drcheck/pubscresult/resultlist.json',
                data:function(d){
	               	d.params = $("#resulthis-form").serializeObject();
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //'className'不要写成class
            columns: [
                {data: null, "className": "center"},
                {data: "taskCode","className": "center"}, 
                {data: "leaderDeptDesc", "className": "center"}, 
                {data: "inspectDesc", "className": "center"}, 
                {data: null,"className": "center"},
                {data: null,"className": "center"}
            ],
            columnDefs: [{
				targets:4,
				render:function(data,type,row,meta){
					if(row.taskState == '01' || row.taskState == '06'){
						return scStackState[row.taskState];
					}else if(row.taskState == '02' || row.taskState == '03' || row.taskState == '04' || row.taskState == '05'){
						if(row.resultFlag == null || row.resultFlag == "" || row.resultFlag == "undefined" || row.resultFlag == '0'){
							return "待录入结果";
						}else{
							if(row.auditState != null && ( row.auditState == "0" || row.auditState == "1")){
								return "待审核";
							}else{
								if(row.auditState != null && row.auditState == "2"){
									return "审核通过";
								}else if(row.auditState != null && row.auditState == "3"){
									return "审核不通过";
								}else if(row.auditState != null && row.auditState == "5"){
									return "退回修改";
								}
							}
							return scStackState[row.taskState];
						}
					}
				}
			},{
				targets:5,
				render:function(data,type,row,meta){
					var scResults = row.scResult;
			    	  var scResultArr = scResults.split(",");
			    	  var showResult = "";
			    	  for(var i=0;i<scResultArr.length;i++){
	                		if(parseInt(scResultArr[i]) == 1){
	                			showResult = showResult + '正常（符合信息公示相关规定）;';
	                		}else if(parseInt(scResultArr[i]) == 2){
	                			showResult = showResult + '未按规定公示即时信息;';
	                		}else if(parseInt(scResultArr[i]) == 3){
	                			showResult = showResult + '未按规定公示年报信息;';
	                		}else if(parseInt(scResultArr[i]) == 4){
	                			showResult = showResult + '通过登记的住所（经营场所）无法联系;';
	                		}else if(parseInt(scResultArr[i]) == 5){
	                			showResult = showResult + '公示信息隐瞒真实情况、弄虚作假;';
	                		}else if(parseInt(scResultArr[i]) == 6){
	                			showResult = showResult +  '不予配合情节严重;';
	                		}else if(parseInt(scResultArr[i]) == 7){
	                			showResult = showResult +  '已办理营业执照注销;';
	                		}else if(parseInt(scResultArr[i]) == 8){
	                			showResult = showResult +  '被吊销营业执照;';
	                		}else if(parseInt(scResultArr[i]) == 9){
	                			showResult = showResult +  '被撤销登记;';
	                		}else{
	                			showResult = showResult + "";
	                		}
	                	}
			    	return showResult;
				}
			}]
        });
    }
    
  //合并第一列单元格
	function autoRowSpan(tb,row,col){ 
		var lastValue=""; 
		var value=""; 
		var pos=1; 
		for(var i=row;i<tb.rows.length;i++){ 
			value = tb.rows[i].cells[col].innerText; 
			if(lastValue == value){ 
				tb.rows[i].deleteCell(col); 
				tb.rows[i-pos].cells[col].rowSpan = tb.rows[i-pos].cells[col].rowSpan+1; 
				pos++; 
			}else{ 
				lastValue = value; 
				pos=1; 
			} 
		} 
	} 
    
    function validForm(){
    	var str = $(".tab-selected").attr("flag");
    	if(str == "N"){
    		 $("#tab_ul_li li").removeClass("tab-selected");
    		 $("#itemPanelDivId").show();
    		 $("#itemPanelOtherDivId").hide();
    		 $("#ownLi").addClass("tab-selected");
    	}
    	var flag = true;
		var remark = $("#remark").val();
		var scResult = $("#scResult").val();
		var resultDetail = $("#resultDetail").val();
		var disposeScResult = $("#disposeScResult").val();
		var disposeDetail = $("#disposeDetail").val();
		var inspectDate = $("#inspectDate").val();
		var checkDesc = $("#checkDesc").val();
		if(remark == "" || remark.length > 200){
			layer.tips("请输入100字以内的其他需要说明事项",$("#remark"),{tips:3, tipsMore:true, ltype:0});
			flag = false;
		}else if(scResult == ""){
			layer.tips("请选择检查结果项",$("#scResult"+"_7"),{tips:3, tipsMore:true, ltype:0});
			flag = false;
		}else if(resultDetail == "" || resultDetail.length > 500){
			layer.tips("请输入250字以内的检查结果详情",$("#resultDetail"),{tips:3,tipsMore:true,ltype:0});
			flag = false;
		}else if(inspectDate == ""){
			layer.tips("请设置检查时间",$("#inspectDate"),{tips:3,tipsMore:true,ltype:0});
			flag = false;
		}else if(checkDesc == ""){
			layer.tips("请填写检查机关",$("#checkDesc"),{tips:3,tipsMore:true,ltype:0});
			flag = false;
		}
		if(flag){
			if(!$("#scResult_1").prop("checked")){
				if(disposeScResult == ""){
					layer.tips("请选择后续处置项",$("#scdispose"+"_4"),{tips:3, tipsMore:true, ltype:0});
					flag = false;
				}else if(disposeDetail == "" || resultDetail.length > 500){
					layer.tips("请输入250字以内的后续处置详情",$("#disposeDetail"),{tips:3,tipsMore:true,ltype:0});
					flag = false;
				}
			}
		}
		if(!flag){
			return false;
		}
		http.httpRequest({
			url: '/syn/pub/server/drcheck/pubscinfo/commit',
			dataType:"json",  
			contentType : 'application/json;charset=utf-8',
			data: JSON.stringify(getCommitParam()),
			type:"post",
			success: function (data) {
				layer.msg(data.msg, {time: 1000}, function () {
					if(data.status == 'success'){
						layer.close({reload: true});
					}
				});
			}
		});
    }
    
    function bind() {
        util.bindEvents([{
            el: '#tab_ul_li li',
            event: 'click',
            handler: function () {
            	 var flag = $(this).attr("flag");
            	 $("#tab_ul_li li").removeClass("tab-selected");
            	 $(this).addClass("tab-selected");
            	 if(flag == "N"){
            		 $("#itemPanelDivId").hide();
            		 $("#itemPanelOtherDivId").show();
            		 var deptCode = $(this).attr("deptCode");
            		 var deptDesc = $("#checkDesc").val();
            		 var lichooseid = $(this).attr("lichooseid");
            		 $("#checkOrgDesc_other").html(deptDesc);
            		 loadOtherPanel($("#taskNO").val(),lichooseid,deptCode);
            	 }else{
            		 $("#itemPanelDivId").show();
            		 $("#itemPanelOtherDivId").hide();
            	 }
            }
        },{
            el: '#save',
            event: 'click',
            handler: function () {
            	 validForm();
            }
        },{
            el: '#close',
            event: 'click',
            handler: function () {
            	layer.close({reload: false});
            }
        }]);
    }
    
    function loadOtherPanel(taskNO,lichooseid,inspectDept){
    	http.httpRequest({
			url: '/syn/pub/server/drcheck/pubscinfo/detail',
			dataType:"json",  
			contentType : 'application/json;charset=utf-8',
			data: {taskNO:taskNO,deptTaskNO:lichooseid,priPID:$("#priPID").val(),inspectDept:inspectDept},
			type:"get",
			success: function (result) {
				if(result.data){
					var pubScitemResultList = result.data.pubScitemResultList;
					var pubScresultOpinionHisList = result.data.pubScresultOpinionHiList;
					var pubScresult = result.data.pubScresult;
					var pubScdispose = result.data.pubScdispose;
					var agentNames = result.data.agentNames;
					var inspectDateDesc = result.data.inspectDateDesc;
					if(inspectDateDesc != null && inspectDateDesc != "" && inspectDateDesc != "undefined"){
						$("#inspectDate_other").val(inspectDateDesc);
					}else{
						$("#inspectDate_other").val("");
					}
					if(agentNames != null && agentNames != "" && agentNames != "undefined"){
						$("#checkAgent_other").html(agentNames);
					}else{
						$("#checkAgent_other").html("");
					}
					if(pubScresult != null && pubScresult != "" && pubScresult != "undefined"){
						var scResult = pubScresult.scResult;
						if(scResult.length > 1){
							var str = scResult.split(",");
							for(var i = 0;i<str.length;i++){
								$("#scResult_other_"+str[i]).prop("checked",true);
							}
						}else{
							$("#scResult_other_"+scResult).prop("checked",true);
						}
						if(pubScresult.scDetail != null && pubScresult.scDetail != "" && pubScresult.scDetail != "undefined"){
							$("#resultDetail_other").val(pubScresult.scDetail);
						}else{
							$("#resultDetail_other").val("");
						}
						if(pubScresult.remark != null && pubScresult.remark != "" && pubScresult.remark != "undefined"){
							$("#remark_other").val(pubScresult.remark);
						}else{
							$("#remark_other").val("");
						}
						if(pubScresult.setUserName != null && pubScresult.setUserName != "" && pubScresult.setUserName != "undefined"){
							$("#setOtherName").html(pubScresult.setUserName);
						}else{
							$("#setOtherName").html("");
						}
						if(pubScresult.setTime != null && pubScresult.setTime != "" && pubScresult.setTime != "undefined"){
							$("#setOtherTime").html(pubScresult.setTime);
						}else{
							$("#setOtherTime").html("");
						}
					}else{
						$(".scResult_other").each(function(){
							$(this).prop("checked",false);
						});
						$("#resultDetail_other").val("");
						$("#remark_other").val("");
						$("#setOtherName").html("");
						$("#setOtherTime").html("");
					}
					if(pubScdispose != null && pubScdispose != "" && pubScdispose != "undefined"){
						var scDisposeResult = pubScdispose.scResult;
						if(scDisposeResult.length > 1){
							var str = scDisposeResult.split(",");
							for(var i = 0;i<str.length;i++){
								$("#scdispose_other_"+str[i]).prop("checked",true);
							}
						}else{
							$("#scdispose_other_"+scDisposeResult).prop("checked",true);
						}
						$("#disposeDetail_other").val(pubScdispose.scDetail);
					}else{
						$(".scdispose_other").each(function(){
							$(this).prop("checked",false);
						});
						$("#disposeDetail_other").val("");
					}
					if(pubScitemResultList != null && pubScitemResultList.length >0){
						var html = "";
						for(var i = 0;i<pubScitemResultList.length;i++){
							var scName = pubScitemResultList[i].scName;
							var itemName = pubScitemResultList[i].itemName;
							var sameFlag = pubScitemResultList[i].sameFlag;
							var pubFlag = pubScitemResultList[i].pubFlag;
							var itemscResult = pubScitemResultList[i].scResult;
							if(itemscResult == null || itemscResult == "" || itemscResult == "undefined"){
								itemscResult = "";
							}
							var sameHtml = '';
							if(sameFlag == "1"){
								sameHtml = 'checked="checked"';
							}
							var pubHtml = '';
							if(pubFlag == "1"){
								pubHtml = 'checked="checked"';
							}
							html += '<tr><td>'+(i+1)+'</td><td class="left pd3">'+scName+'</td><td class="center pd3">'+itemName+'</td>'
							+'<td class="pd3"><div class="ipt-box"><input type="checkbox" '+sameHtml+' disabled="disabled"/>是否一致 <input type="checkbox" '+pubHtml+' disabled="disabled"/>是否公示&nbsp;<input type="text" class="ipt-txt" style="width:170px" value="'+itemscResult+'" disabled="disabled"/></div></td></tr>';
						}
						$("#checkItemOtherTbody").empty().append(html);
					}
					//历史审核意见
					if(pubScresultOpinionHisList != null && pubScresultOpinionHisList.length >0){
						var opinionHtml = "";
						for(var i = 0;i<pubScresultOpinionHisList.length;i++){
							var auditFlag = pubScresultOpinionHisList[i].auditFlag;
							if(auditFlag == '2'){auditFlag = '通过';}
							if(auditFlag == '3'){auditFlag = '不通过';}
							if(auditFlag == '5'){auditFlag = '退回修改';}
							var auditOpin = pubScresultOpinionHisList[i].auditOpin;
							var auditUserName = pubScresultOpinionHisList[i].auditUserName;
							var auditDate = pubScresultOpinionHisList[i].auditDate;
							opinionHtml +='<tr><td class="center">'+(i+1)+'</td><td class="center">'+auditFlag+'</td><td class="center">'+auditOpin+'</td>'
							+'<td class="center">'+auditUserName+'</td><td class="center">'+auditDate+'</td></tr>'
						}
						$("#pubOpinionHisList").empty().append(opinionHtml);
					}else{
						$("#pubOpinionHisList").empty().append('<tr><td colspan="5" class="center">暂无历史意见</td></tr>');
					}
					autoRowSpan(document.getElementById("checkItemOtherTable"), 1, 1);
				}
			}
		});
    }
    
    function getCommitParam(){
    	var pubScinfoDto=getSaveParam();
    	pubScinfoDto.id = $("#pubScinfoId").val();
    	return pubScinfoDto;
    }
    
    function getSaveParam(){
    	 var taskNO = $("#taskNO").val();
    	 var resultTaskNO = $("#resultTaskNO").val();
    	 var priPID = $("#priPID").val();
    	 var pubScitemResultList=new Array(); 
   		 var id = $("#pubDeptSctask").val();
   		 var inspectState = $("#inspectState").val();
   		 var scType = $("#inspectType").val();
   		 var inspectDept = $("#inspectDept").val();
   		 var remark = $("#remark").val();
   		 var resultParamFlag = $("#resultFlag").val();
		 $(".itemindex").each(function(){
			 var itemindex = $(this).attr("itemindex");
			 var itemid = $("#itemResultId_"+itemindex).val();
			 var itemCode = $("#itemCode_"+itemindex).val();
			 var itemName = $("#itemName_"+itemindex).val();
			 var itemResult = $("#itemResult_"+itemindex).val();
			 var scType = $("#scType_"+itemindex).val();
			 var scName = $("#scName_"+itemindex).val();
			 var sameFlag = "0";
			 var pubFlag = "0";
			 if($("#sameFlag_"+itemindex).prop("checked")){
				 sameFlag = "1";
			 }
			 if($("#pubFlag_"+itemindex).prop("checked")){
				 pubFlag = "1";
			 }
			 var pubScitemResult = new initPubScitemResult(itemid, itemCode, itemName, itemResult,resultTaskNO,priPID,scType,scName,sameFlag,pubFlag);
			 pubScitemResultList.push(pubScitemResult);
		 });
   		 var scResult = "";
		 var resultFlag = true;
		 $(".scResult").each(function(){
			 if($(this).prop("checked")){
				 if(resultFlag){
					 scResult += $(this).val();
					 resultFlag = false;
				 }else{
					 scResult += ","+$(this).val();
				 }
			 }
		 });
		 var scdispose = "";
		 var discopeFlag = true;
		 $(".scdispose").each(function(){
			 if($(this).prop("checked")){
				 if(discopeFlag){
					 scdispose += $(this).val();
					 discopeFlag = false;
				 }else{
					 scdispose += ","+$(this).val();
				 }
			 }
		 });
		 var inspectDate = $("#inspectDate").val();
		 var pubScresult = new initPubScresult($("#resultTaskNO").val(),priPID,scResult,$("#resultId").val(),$("#resultDetail").val(),remark,inspectDept,resultParamFlag,$("#checkDesc").val(),inspectDate);
		 var pubScdispose = new initPubDiscope($("#discopeTaskNO").val(),priPID,scdispose,$("#disposeId").val(),$("#disposeDetail").val());
   			 
	   	 var pubScinfoDto={};
	   	 pubScinfoDto.pubScitemResultList = pubScitemResultList;
	   	 pubScinfoDto.pubScresult = pubScresult;
	   	 pubScinfoDto.pubScdispose = pubScdispose;
	   	 pubScinfoDto.taskNO = taskNO;
    	 pubScinfoDto.priPID = priPID;
    	 var pubDeptSctask = new initPubDeptSctask(resultTaskNO, inspectDate);
    	 pubScinfoDto.pubDeptSctask = pubDeptSctask;
	   	 return pubScinfoDto;
    }
    
    function initPubDeptSctask(resultTaskNO,inspectDate){
    	  this.taskNO=resultTaskNO;
    	  this.inspectDate=inspectDate;
    }
    
    function initPubScitemResult(itemid,itemCode,itemName,itemResult,taskNO,priPID,scType,scName,sameFlag,pubFlag){
    	  this.id=itemid;
    	  this.itemCode=itemCode;
    	  this.itemName=itemName;
    	  this.scResult=itemResult;
    	  this.taskNO=taskNO;
    	  this.priPID=priPID;
    	  this.scType=scType;
    	  this.scName=scName;
    	  this.sameFlag=sameFlag;
    	  this.pubFlag=pubFlag;
      }
      
      function initPubScresult(taskNO,priPID,scResult,id,scDetail,remark,inspectDept,resultFlag,scDeptName,inspectDate){
      	this.taskNO=taskNO;
      	this.priPID=priPID;
      	this.scResult=scResult;
      	this.id=id;
      	this.scDetail=scDetail;
      	this.remark=remark;
      	this.inspectDept=inspectDept;
      	this.resultFlag=resultFlag;
      	this.auditState=resultFlag;
      	this.scDeptName=scDeptName;
      	this.inspectDeptTime=inspectDate;
      }
      
      function initPubDiscope(taskNO,priPID,scResult,id,scDetail){
      	this.taskNO=taskNO;
      	this.priPID=priPID;
      	this.scResult=scResult;
      	this.id=id;
      	this.scDetail=scDetail;
      }
});

function selectNomal(id){
	if($("#scResult_1").prop("checked")){
		$(".scResult").each(function(){
			var value = $(this).val();
			if(value != id){
				$(this).prop("checked",false);
			}
		});
		$("#scResult").val(id);
	}else{
		$("#scResult").val("");
	}
	choosedItem("scResult", "resultDetail");
}

function selectUnNomal(id){
	if($("#scResult_1").prop("checked")){
		$("#scResult_1").prop("checked",false);
	}
	var scResult = "";
	var flag = true;
	$(".scResult").each(function(){
		if($(this).prop("checked")){
			var value = $(this).val();
			if(flag){
				scResult += value;
				flag = false;
			}else{
				scResult += ","+value;
			}
		}
	});
	$("#scResult").val(scResult);
	choosedItem("scResult", "resultDetail");
}

function choosedItem(classid,htmlid){
	var html = "";
	var flag = true;
	$("."+classid).each(function(){
		if($(this).prop("checked")){
			if(flag){
				html = $(this).attr("itemva");
				flag = false;
			}else{
				html += "；"+$(this).attr("itemva");
			}
		}
	});
	$("#"+htmlid).val(html);
}

function choosedispose(){
	var scdispose = "";
	var flag = true;
	$(".scdispose").each(function(){
		if($(this).prop("checked")){
			var value = $(this).val();
			if(flag){
				scdispose += value;
				flag = false;
			}else{
				scdispose += ","+value;
			}
		}
	});
	$("#disposeScResult").val(scdispose);
	choosedItem("scdispose", "disposeDetail");
}
