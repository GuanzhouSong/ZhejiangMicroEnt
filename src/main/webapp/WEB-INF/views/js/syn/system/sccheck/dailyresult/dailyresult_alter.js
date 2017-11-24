require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate'], function (layer, dataTable, util, http, handlebars) {

    init();
    function init() { 
        bind();
    }
    
    var disposeS = $("input[name='disposeState']:checked").val();
    if(disposeS=='1'){
    	$(".sp").hide();
    }else{
    	$(".sp").show();
    }
    
    //提交，需要校验表单，状态已录入
    function save(){
    	$("#state").val(2);
    	var isDisposeMssFlag=true;
    	var checkType=new Array();
		$(":checkbox[name=checkTypeTmp]:checked").each(function(k,v){
			checkType[k]= this.value;
		});
		$("#checkType").val(checkType);
		
		var checkResult=new Array();
		$(":checkbox[name=checkResultTmp]:checked").each(function(k,v){
			checkResult[k]= this.value;
		});
		$("#checkResult").val(checkResult);
		
		var disposeMss=new Array();
		$(":checkbox[name=disposeMssTmp]:checked").each(function(k,v){
			if(this.value=='other'){
				if($("#other").val()!=""){
					disposeMss[k]= $("#other").val();
				}else{
					isDisposeMssFlag=false;
				}
			}else{
				disposeMss[k]= this.value;
			}
		});
		$("#disposeMss").val(disposeMss);
		//检查事项情况
		var flag=true;
		var arr = new Array();
		for(var i = 1;i <= 1000; i++) {
			var num = i;
			var checkName = $("#checkName"+num).val();
			if(checkName){
				arr.push(i);
			}else{
			}
		}
		
		for(var i=0;i<arr.length;i++){
			var problem = $.trim($("#problem"+arr[i]).val());
			var dispose = $.trim($("#dispose"+arr[i]).val());
			if(problem==""||dispose==""){
				flag=false;
				break;
			}
		}
		
		var checkObjType = $("#checkObjType").val();
		var dom = $.trim($("#dom").val());
		var lerep = $.trim($("#lerep").val());
		var tel = $.trim($("#tel").val());
		var liaName = $.trim($("#liaName").val());
		var liaTel = $.trim($("#liaTel").val());
		var isCheckType=$("input[name='checkTypeTmp']").is(':checked');
		var isCheckResult=$("input[name='checkResultTmp']").is(':checked');
		var isDisposeMss = $("input[name='disposeMssTmp']").is(':checked');
		var disposeState = $("input[name='disposeState']:checked").val();
		var disposeFinishDate = $("#disposeFinishDate").val();
		var checkDeptPerson = $.trim($("#checkDeptPerson").val());
		var checkDate = $("#checkDate").val();
		var alterContent = $.trim($("#alterContent").val());
		var regu = /^\d+$/;
		if(dom==""&&checkObjType!='1'){
			layer.msg("住所地址不能为空", {time: 2000}, function() {});
		}else if(lerep==""&&checkObjType!='1'){
			layer.msg("负责人不能为空", {time: 2000}, function() {});
		}else if(tel==""&&checkObjType!='1'){
			layer.msg("负责人电话不能为空", {time: 2000}, function() {});
		}else if(!regu.test(tel)&&checkObjType!='1'){
			layer.msg("负责人电话格式不正确", {time: 2000}, function() {});
		}else if(liaName==""&&checkObjType!='1'){
			layer.msg("联系人不能为空", {time: 2000}, function() {});
		}else if(liaTel==""&&checkObjType!='1'){
			layer.msg("联系人电话不能为空", {time: 2000}, function() {});
		}else if(!regu.test(liaTel)&&checkObjType!='1'){
			layer.msg("联系人电话格式不正确", {time: 2000}, function() {});
		}else if(arr.length<=0){
			layer.msg("检查内容不能为空", {time: 2000}, function() {});
		}else if(!flag){
			layer.msg("发现问题和处置情况是必填项", {time: 2000}, function() {});
		}else if(!isCheckType){
			layer.msg("核查方式是必填项", {time: 2000}, function() {});
		}else if(!isCheckResult){
			layer.msg("核查结果是必填项", {time: 2000}, function() {});
		}else if(isDisposeMssFlag==""||!isDisposeMss){
			layer.msg("后续处置措施是必填项", {time: 2000}, function() {});
		}else if(disposeState==undefined){
			layer.msg("后续处置措施是否完结是必填项", {time: 2000}, function() {});
		}else if(disposeState=='2'&&disposeFinishDate==""){
			layer.msg("完结日期是必填项", {time: 2000}, function() {});
		}else if(checkDeptPerson==""){
			layer.msg("检查人员是必填项", {time: 2000}, function() {});
		}else if(checkDate==""){
			layer.msg("检查日期是必填项", {time: 2000}, function() {});
		}else if(alterContent==""){
			layer.msg("修改内容是必填项", {time: 2000}, function() {});
		}else{
			var searchParams = $("#taskForm").serializeObject();
	    	http.httpRequest({
				url: '/reg/dailycheck/dailyinspectresult/doinsertcheckobj',
				dataType:"json",  
				contentType : 'application/json',
				data: JSON.stringify(searchParams),
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
    
    function bind() {
    	var num;
    	if($("#maxNum").val()&&$("#maxNum").val()!=0){
    		num=$("#maxNum").val();
    	}else{
    		num=1;
    	}
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
            el: '.addInfo',
            event: 'click',
            handler: function () {
            	num++;
            	var trHTML = "<tr>"
        			+ "<td class='center'><a class='del'>删除</a></td>"
        			+ "<td class='center'>"+num+"</td>"
        			+ "<td><textarea id='checkName"+num+"' name='checkName"+num+"'></textarea></td>"
        			+ "<td><textarea class='prodis' id='problem"+num+"' name='problem"+num+"'></textarea></td>"
        			+ "<td><textarea class='prodis' id='dispose"+num+"' name='dispose"+num+"'></textarea></td>"
        			+ "</tr>"
        		 $("#table2").append(trHTML);
            }
        },{
            el: '.del',
            event: 'click',
            handler: function () {
            	$(this).parent().parent().remove();
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
      }]);
    }
});
