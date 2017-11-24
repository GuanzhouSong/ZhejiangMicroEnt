require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate'], function (layer, dataTable, util, http, handlebars) {

    init();
    function init() { 
        bind();
    }
    
    function save(){
    	if(valifyParams()){
    		http.httpRequest({
    			url: '/syn/sccheck/pubscentresult/savecross',
    			dataType:"json",  
    			contentType : 'application/json',
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
   }
    
    function valifyParams(){
    	var flag = true;
    	$(".indexkey").each(function(){
    		var index = $(this).text();
    		var isCheck = $("input[name='check"+index+"']:checked ").val();
    		if(isCheck == "undefined" || isCheck == null || isCheck == "" || isCheck == undefined){
    			layer.tips("请选择是否检查",$("#ra_"+index+"_1"),{tips:3, tipsMore:true, ltype:0});
    			flag = false;
    			return false;
    		}
    		var problem = $("#problem_"+index).val();
    		if(isCheck == "1" && problem == ""){
    			layer.tips("请输入发现问题情况",$("#problem_"+index),{tips:3, tipsMore:true, ltype:0});
    			flag = false;
    			return false;
    		}
    	});
    	if(!flag){
    		return false;
    	}
    	var materails = "";
    	$(":checkbox[name=materail]:checked").each(function(k,v){
    		var value="";
    		if($(this).val() == "other"){
    			value = $("#materailOther").val();
    		}else{
    			value= $(this).val();
    		}
    		if(materails == ""){
    			materails = value;
    		}else{
    			materails = materails + "," + value;
    		}
    	});
    	if(materails == ""){
    		layer.tips("请选择要求提供材料",$("#materail1"),{tips:3, tipsMore:true, ltype:0});
			return false;
    	}
    	var checkResult = "";
    	$(":checkbox[name=checkResultTmp]:checked").each(function(k,v){
    		var text = $(this).attr("textkey");
    		if(checkResult == ""){
    			checkResult= $(this).val();
    		}else{
    			checkResult = checkResult+","+$(this).val();
    		}
		});
    	if(checkResult == ""){
    		layer.tips("请选择检查结果",$("#result1"),{tips:3, tipsMore:true, ltype:0});
			return false;
    	}
    	var disposeMss = "";
    	$(":checkbox[name=disposeMssTmp]:checked").each(function(k,v){
    		var value="";
    		if($(this).val() == "other"){
    			value = $("#other").val();
    		}else{
    			value= $(this).val();
    		}
			disposeMss += value;
    	});
    	if(disposeMss == ""){
    		layer.tips("请选择后续处置措施",$("#disposeMss1"),{tips:3, tipsMore:true, ltype:0});
			return false;
    	}
    	var disposeState = $("input[name='disposeState']:checked").val();
    	if(disposeState == "undefined" || disposeState == null || disposeState == "" || disposeState == undefined){
    		layer.tips("请选择后续处置措施是否完结",$("#disposeState1"),{tips:3, tipsMore:true, ltype:0});
			return false;
    	}
    	if(disposeState == "2" && checkResult != "1"){
    		var disposeFinishDate = $("#disposeFinishDate").val();
    		if(disposeFinishDate == ""){
    			layer.tips("请选择完结日期",$("#disposeFinishDate"),{tips:3, tipsMore:true, ltype:0});
    			return false;
    		}
    	}
    	var checkDate = $("#checkDate").val();
    	if(checkDate == ""){
    		layer.tips("请选择检查日期",$("#checkDate"),{tips:3, tipsMore:true, ltype:0});
			return false;
    	}
    	return true;
    }
    
    function getCommitParam(){
    	var pubScentResultDto = {};
    	var checkResultText = "";
    	var checkResult = "";
    	$(":checkbox[name=checkResultTmp]:checked").each(function(k,v){
    		var text = $(this).attr("textkey");
			checkResultText += text;
    		if(checkResult == ""){
    			checkResult= $(this).val();
    		}else{
    			checkResult = checkResult+","+$(this).val();
    		}
		});
    	var disposeMss = "";
    	$(":checkbox[name=disposeMssTmp]:checked").each(function(k,v){
    		var value="";
    		if($(this).val() == "other"){
    			value = $("#other").val();
    		}else{
    			value= $(this).val();
    		}
			disposeMss += value;
    	});
    	var materails = "";
    	$(":checkbox[name=materail]:checked").each(function(k,v){
    		var value="";
    		if($(this).val() == "other"){
    			value = $("#materailOther").val();
    		}else{
    			value= $(this).val();
    		}
    		if(materails == ""){
    			materails = value;
    		}else{
    			materails = materails + "," + value;
    		}
    	});
    	pubScentResultDto.problem = checkResultText;
    	var uid = $("#uid").val();
    	var priPID = $("#priPID").val();
    	var mainTaskUid = $("#mainTaskUid").val();
    	var taskUid = $("#taskUid").val();
    	var checkDate = $("#checkDate").val();
    	var auditState = $("#auditState").val();
    	var disposeFinishMss = $("#disposeFinishMss").val();
    	var disposeFinishDate = $("#disposeFinishDate").val();
    	var disposeState = $("input[name='disposeState']:checked").val();
    	var checkDeptName = $("#checkDeptName").val();
    	var checkDeptPerson = $("#checkDeptPerson").val();
    	var pubScentResult = new initPubScentResult(uid,taskUid,priPID,checkDate,checkResult,disposeMss,materails,auditState,checkDeptName,checkDeptPerson,disposeState,disposeFinishDate,disposeFinishMss);
    	pubScentResultDto.pubScentResult = pubScentResult;
    	pubScentResultDto.mainTaskUid = mainTaskUid;
    	var sccheckKeyList=new Array(); 
    	$(".indexkey").each(function(){
    		var index = $(this).text();
    		var checkContent = $("#content_"+index).html();
    		var checkMethod = $("#method_"+index).html();
    		var isCheck = $("input[name='check"+index+"']:checked ").val();
    		var problemValue = $("#problem_"+index).val();
    		var yesText = $("#ra_"+index+"_1").attr("defaultinput");
    		var noText = $("#ra_"+index+"_2").attr("defaultinput");
    		var sccheckKey = new initSccheckKey(checkContent,checkMethod,isCheck,problemValue,uid,taskUid,yesText,noText);
    		sccheckKeyList.push(sccheckKey);
    	});
    	pubScentResultDto.sccheckKeyList = sccheckKeyList;
    	return pubScentResultDto;
    }
    
    function initSccheckKey(checkContent,checkMethod,isCheck,problemValue,uid,taskUid,yesText,noText){
  	  this.checkContent=checkContent;
  	  this.checkMethod=checkMethod;
  	  this.isCheck=isCheck;
  	  this.problem=problemValue;
  	  this.resultUid=uid;
  	  this.taskUid=taskUid;
  	  this.yesText=yesText;
  	  this.noText=noText;
  }
    
    function initPubScentResult(uid,taskUid,priPID,checkDate,checkResult,disposeMss,materails,auditState,checkDeptName,checkDeptPerson,disposeState,disposeFinishDate,disposeFinishMss){
    	  this.uid=uid;
    	  this.taskUid=taskUid;
    	  this.priPID=priPID;
    	  this.checkDate=checkDate;
    	  this.checkResult=checkResult;
    	  this.disposeMss=disposeMss;
    	  this.materials=materails;
    	  this.auditState=auditState;
    	  this.checkDeptName=checkDeptName;
    	  this.checkDeptPerson=checkDeptPerson;
    	  this.disposeState=disposeState;
    	  this.disposeFinishDate=disposeFinishDate;
    	  this.disposeFinishMss=disposeFinishMss;
    }
      
    
    function bind() {
    	var num=$("#maxNum").val();
    	var sccheckCode = $("#sccheckCode").val();
        util.bindEvents([{
            el: '#save',
            event: 'click',
            handler: function () {
            	save();
            }
        },{
            el: '#close',
            event: 'click',
            handler: function () {
            	layer.close({reload: false});
            }
        },{
            el: '.dis',
            event: 'click',
            handler: function () {
            	var auditState = $("input[name='disposeState']:checked").val();
            	if(auditState=="1"){
            		$(".sp").hide();
            	}else{
            		$(".sp").show();
            	}
            }
        },{
            el: '.chk',
            event: 'click',
            handler: function () {
            	var isChk = $(this).prop("checked");
            	if(isChk){
            		$("#problem_"+$(this).val()).show();
            		$("#dispose_"+$(this).val()).show();
            	}else{
            		$("#problem_"+$(this).val()).hide();
            		$("#dispose_"+$(this).val()).hide();
            	}
            }
        },{
            el: '.crt',
            event: 'click',
            handler: function () {
            	var isChk = $(this).prop("checked");
            	var value = $(this).val();
            	if(isChk){
            		if(value=='1'){
            			$(".crt").prop("checked", false);
            			$('.crt').attr("disabled","disabled");
            			$(this).prop("checked", true);
            			$(this).attr("disabled",false);
            		}
            	}else{
            		$('.crt').attr("disabled",false);
            	}
            }
        },{
            el: '.disaf',
            event: 'click',
            handler: function () {
            	var isChk = $(this).prop("checked");
            	var value = $(this).val();
            	if(isChk){
            		if(value=='未发现问题或相关问题已规范、已改正，无需后续处置；'){
            			$(".disaf").prop("checked", false);
            			$('.disaf').attr("disabled","disabled");
            			$(this).prop("checked", true);
            			$(this).attr("disabled",false);
            			$("#other").attr("disabled",true);
            			$("#other").val("");
            			$("input[name='disposeState']:eq(1)").prop("checked",true);
            			$("input[name='disposeState']:eq(0)").prop("checked",false);
        		    	$(".sp").show();
        		    	$('.dis').attr("disabled","disabled");
            		}
            	}else{
            		$('.disaf').attr("disabled",false);
            		$("#other").attr("disabled",false);
            		$("input[name='disposeState']:eq(1)").prop("checked",false);
        			$("input[name='disposeState']:eq(0)").prop("checked",true);
    		    	$(".sp").hide();
    		    	$('.dis').attr("disabled",false);
            	}
            }
        },{
            el: '.problemno',
            event: 'click',
            handler: function () {
            	var allChecked= $(".problemno").prop("checked");
            	if(allChecked){
            		$("#table2").find(":checkbox:checked").each(function(){
            			var val = $(this).val();
            			if(val!='1'||val!='2'||val!='3'){
            				$("#problem_"+val).val("无");
            			}
            		});
            	}else{
            		$("#table2").find(":checkbox:checked").each(function(){
            			var val = $(this).val();
            			if(val!='1'||val!='2'||val!='3'){
            				$("#problem_"+val).val("");
            			}
            		});
            	}
            }
        },{
            el: '.disposeno',
            event: 'click',
            handler: function () {
            	var allChecked= $(".disposeno").prop("checked");
            	if(allChecked){
            		$("#table2").find(":checkbox:checked").each(function(){
            			var val = $(this).val();
            			if(val!='1'||val!='2'||val!='3'){
            				$("#dispose_"+val).val("无");
            			}
            		});
            	}else{
            		$("#table2").find(":checkbox:checked").each(function(){
            			var val = $(this).val();
            			if(val!='1'||val!='2'||val!='3'){
            				$("#dispose_"+val).val("");
            			}
            		});
            	}
            }
        },{
      	  	el: '.re1',
            event: 'click',
            handler: function () {
            	var flag = false;
            	$(".re1").each(function(){
            		if($(this).prop("checked")){
            			flag = true;
            		}
            	});
            	if(flag){
            		$(".re3").prop("checked",true);
            	}else{
            		$(".re3").prop("checked",false);
            	}
            }
      },{
      	  	el: '.re2',
            event: 'click',
            handler: function () {
            	var flag = false;
            	$(".re2").each(function(){
            		if($(this).prop("checked")){
            			flag = true;
            		}
            	});
            	if(flag){
            		$("#reCheckBox").prop("checked",true);
            	}else{
            		$("#reCheckBox").prop("checked",false);
            	}
            	
            	var flag1 = false;
            	$(".re1").each(function(){
            		if($(this).prop("checked")){
            			flag1 = true;
            		}
            	});
            	if(flag1){
            		$(".re3").prop("checked",true);
            	}else{
            		$(".re3").prop("checked",false);
            	}
            }
      },{
      	  	el: '.re3',
            event: 'click',
            handler: function () {
            	if($(this).prop("checked")){
            		$(".re2").prop("checked",true);
            		$(".re1").prop("checked",true);
            	}else{
            		$(".re1").prop("checked",false);
            		$(".re2").prop("checked",false);
            	}
            }
      },{
      	  	el: '#reCheckBox',
            event: 'click',
            handler: function () {
            	if($(this).prop("checked")){
            		$(".re2").prop("checked",true);
            	}else{
            		$(".re2").prop("checked",false);
            	}
            }
      },{
      	  	el: '.checkkey',
            event: 'click',
            handler: function () {
            	if($(this).prop("checked")){
        			var value = $(this).attr("defaultinput");
        			$(this).parent().next("td").find("input").val(value);
            	}
            }
      }]);
    }
});
