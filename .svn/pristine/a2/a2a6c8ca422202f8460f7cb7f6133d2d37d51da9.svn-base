require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate'], function (layer, dataTable, util, http, handlebars) {

    init();
    function init() { 
        bind();
    }
    
    var disposeState = $("#disposeState").val();
    if(disposeState=='1'){
    	$(".sp").hide();
    }else{
    	$(".sp").show();
    }
    
    $(":checkbox[name=disposeMssTmp]:checked").each(function(k,v){
    	if(this.value=='未发现问题或相关问题已规范、已改正，无需后续处置；'){
    		$(".disaf").prop("checked", false);
    		$('.disaf').attr("disabled","disabled");
    		$(this).prop("checked", true);
    		$(this).attr("disabled",false);
    		$("#other").attr("disabled",true);
    		$("input[name='disposeState']:eq(1)").prop("checked",true);
			$("input[name='disposeState']:eq(0)").prop("checked",false); 
			$('.dis').attr("disabled","disabled");
    	}
    })
    
    $(":checkbox[name=checkResultTmp]:checked").each(function(k,v){
    	if(this.value=='1'){
    		$(".crt").prop("checked", false);
    		$('.crt').attr("disabled","disabled");
    		$(this).prop("checked", true);
    		$(this).attr("disabled",false);
    	}
    })
    
    var pageviewtype = window._CONFIG.flag;
    if(pageviewtype=='4'){
    	$("#checkDate").attr("onclick","return false");
    	$("#taskForm input").each(function(k,v){
    		var inputtype = $(this).attr('type');
    		if(inputtype=='text'){
    			$(this).attr("readonly","readonly");
    		}else if(inputtype=='checkbox'){
    			$(this).attr("disabled",true);
    		}
    	})
    	$("#table2 textarea").each(function(k,v){
    		$(this).attr("readonly","readonly");
    	})
    }if(pageviewtype=='3' || pageviewtype=='4'){
    	$(".del").hide();
    }
    
    function save(commitWay){
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
		
		var itemflag = true;
		$("#table2 textarea").each(function(K,v){
			if($(this).val()==''){
				itemflag = false;
			}
		})
		
		if(commitWay=='2'){
            httprequestCommit();
            return;
        }
		var isCheckType=$("input[name='checkTypeTmp']").is(':checked');
		var isCheckResult=$("input[name='checkResultTmp']").is(':checked');
		var isDisposeMss = $("input[name='disposeMssTmp']").is(':checked');
		var disposeState = $("input[name='disposeState']:checked").val();
		var disposeFinishDate = $("#disposeFinishDate").val();
		var checkDeptName = $.trim($("#checkDeptName").val());
		var checkDeptPerson = $.trim($("#checkDeptPerson").val());
		var checkDate = $("#checkDate").val();
		var modifyContent = $("#modifyContent").val();
		if(!itemflag){
			layer.msg("请将检查事项填写完整", {time: 2000}, function() {});
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
		}else if(checkDeptName==""){
			layer.msg("检查执行部门是必填项", {time: 2000}, function() {});
		}else if(checkDeptPerson==""){
			layer.msg("检查人员是必填项", {time: 2000}, function() {});
		}else if(checkDate==""){
			layer.msg("检查日期是必填项", {time: 2000}, function() {});
		}else if($("#modifyContent")&&modifyContent==""){
			layer.msg("修改内容是必填项", {time: 2000}, function() {});
		}else{
			httprequestCommit();
		}
    }
    
    
    function httprequestCommit(){
    	var searchParams = $("#taskForm").serializeObject();
    	http.httpRequest({
			url: window._CONFIG.chooseUrl+'/server/specialrec/result/enterResult',
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
    
    function bind() {
    	var num=$("#maxNum").val();
    	var addNum=$("#addNum").val();
    	var sccheckCode = $("#sccheckCode").val();
        util.bindEvents([{
            el: '.save',
            event: 'click',
            handler: function () {
            	var commitWay = $(this).attr("dataType");
            	$("#dataType").val(commitWay);
            	save(commitWay);
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
            el: '.del',
            event: 'click',
            handler: function () {
            	num--;
            	if(num <= 0){
            		num = 1;
            		alert("至少保留一项检查内容！");
            		return false;
            	}
            	$(this).parent().parent().remove();
            }
        },{
            el: '.addSccheckType',
            event: 'click',
            handler: function () {
            	addNum ++; num++;
            	var trHTML = "<tr>"
        			+ "<td class='center'><a class='del'>删除</a></td>"
        			+ "<td class='center'>"
        			+ "<textarea  style='overflow-y:auto;'  name='checkContent_"+addNum+"'></textarea>"
        			+ "</td>"
        			+ "<td class='center'>"
        			+ "<textarea  style='overflow-y:auto;'  name='chechProblem_"+addNum+"'></textarea>"
        			+ "</td>"
        			+ "<td class='center'>"
        			+ "<textarea  style='overflow-y:auto;'  name='disposalContent_"+addNum+"'></textarea>"
        			+ "</td>"
        			+ "</tr>"
        		 $("#table2").append(trHTML);
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
            el: '#close',
            event: 'click',
            handler: function () {
            	layer.close({reload: false});
            }
        },{
      	  el: '#checkAll',  //全选
            event: 'click',
            handler: function () {
            	var allChecked= $("#checkAll").prop("checked");   
            	if(allChecked){
            		$(".prodis").show();
            	}else{
            		$(".prodis").hide();
            	}
            	$(".chk").prop("checked", allChecked);
            }
      },{
      	  	el: '#addAgent',
            event: 'click',
            handler: function () {
            	 layer.dialog({
                    title: '选择执法人员',
                    area: ['100%', '100%'],
                    content: '/syn/sccheck/pubscentresult/addScagentPage',
                    callback: function (data) { 
                    	if(data.success){
                    		var agentNames = data.agentNames;
                    		$("#checkDeptPerson").val(agentNames);
                    	}
                    }
                })
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
