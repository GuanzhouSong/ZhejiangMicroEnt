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
    
    function prefixInteger(num, length) {
  	  return (num/Math.pow(10,length)).toFixed(length).substr(2);
  	}
    
    function save(){
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
		var arrA = new Array();
		for(var i = 1;i <= 12; i++) {
			var num = "A"+prefixInteger(i,2);
			var disposeState = $("input[name='chk_"+num+"']:checked").val();
			if(disposeState==undefined){
			}else{
				arrA.push(disposeState);
			}
		}
		var arrB = new Array();
		for(var i = 13;i <= 22; i++) {
			var num = "B"+prefixInteger(i-12,2);
			var disposeState = $("input[name='chk_"+num+"']:checked").val();
			if(disposeState==undefined){
			}else{
				arrB.push(disposeState);
			}
		}
		var arrC = new Array();
		for(var i = 23;i <= 36; i++) {
			var num = "C"+prefixInteger(i-22,2);
			var disposeState = $("input[name='chk_"+num+"']:checked").val();
			if(disposeState==undefined){
			}else{
				arrC.push(disposeState);
			}
		}
		var arrOther = new Array();
		for(var i = 1;i <= 1000; i++) {
			var num = "OTHER"+i;
			var disposeState = $("input[name='chk_"+num+"']:checked").val();
			if(disposeState==undefined){
			}else{
				arrOther.push(disposeState);
			}
		}
		arr=arrA.concat(arrB).concat(arrC).concat(arrOther);
		//A01,A02,A03,A04
		for(var i=0;i<arr.length;i++){
			var problem = $.trim($("#problem_"+arr[i]).val());
			var dispose = $.trim($("#dispose_"+arr[i]).val());
			if(problem==""||dispose==""){
				flag=false;
				break;
			}
		}
		
		var isCheckType=$("input[name='checkTypeTmp']").is(':checked');
		var isCheckResult=$("input[name='checkResultTmp']").is(':checked');
		var isDisposeMss = $("input[name='disposeMssTmp']").is(':checked');
		//var disposeMss = $.trim($("#disposeMss").val());
		var disposeState = $("input[name='disposeState']:checked").val();
		var disposeFinishDate = $("#disposeFinishDate").val();
		var checkDeptName = $.trim($("#checkDeptName").val());
		var checkDeptPerson = $.trim($("#checkDeptPerson").val());
		var checkDate = $("#checkDate").val();
		if(arr.length<=0){
			layer.msg("请至少选择一项检查事项", {time: 2000}, function() {});
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
		}else if(checkDeptName==""){
			layer.msg("检查执行部门是必填项", {time: 2000}, function() {});
		}else if(checkDeptPerson==""){
			layer.msg("检查人员是必填项", {time: 2000}, function() {});
		}else if(checkDate==""){
			layer.msg("检查日期是必填项", {time: 2000}, function() {});
		}else{
			var searchParams = $("#taskForm").serializeObject();
	    	http.httpRequest({
				url: '/syn/sccheck/pubscentresult/alterscresult',
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
    	var num=$("#maxNum").val();
    	var sccheckCode = $("#sccheckCode").val();
        util.bindEvents([{
            el: '#save',
            event: 'click',
            handler: function () {
            	save();
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
            el: '.del',
            event: 'click',
            handler: function () {
            	num--;
            	$(this).parent().parent().remove();
            }
        },{
            el: '.addSccheckType',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '添加检查事项',
                    area: ['400px', '600px'],
                    content: '/syn/server/drcheck/pubscagent/scChecktypeSelect?isPermissionCheck=true&sccheckCodeIn='+sccheckCode,
                    callback: function (data) { 
                    	var arr = " ";
                    	$("#table2 input:checkbox").each(function(){
                    		arr = arr+","+$(this).val();
                    	});
	                  	var msg=""; 
	                  	var returncodesArr= data.returncodes.split(","); 
	                  	var returnnameArr=data.returnname.split(",");
	                  	var pcodesArr=data.pcodes.split(",");
	                  	var pnamesArr=data.pnames.split(",");
	                  	if(returncodesArr.length>0){
	                  		for(var i=0;i<returncodesArr.length;i++){
	                			 var tCode=returncodesArr[i];
	                			 var tName=returnnameArr[i];
	                			 if(arr.indexOf(tCode)>=0){
                 					continue;
                 				 }
	                			 if(tCode=='A'||tCode=='B'||tCode=='C'){
	                				 continue;
	                			 }
	                			 var trHTML = "<tr>"
	                				 		+ "<td class='center'><a class='del'>删除</a></td>"
	                				 		+ "<td>"+tName+"<input type='hidden' name='checkName_"+tCode+"' value='"+tName+"'></td>"
		                                	+ "<td class='center'>"
		                                	+ "<input type='checkbox' class='chk' value="+tCode+" name='chk_"+tCode+"'"
		                                	+ ">是"
		                                	+ "</td>"
		                                	+ "<td><textarea class='prodis' style='display: none' id='problem_"+tCode+"' name='problem_"+tCode+"'></textarea></td>"
		                                	+ "<td><textarea class='prodis' style='display: none' id='dispose_"+tCode+"' name='dispose_"+tCode+"'></textarea></td>"
		                                	+ "</tr>"
	                			 $("#table2").append(trHTML);
	                  		}
	                  	}   
                   }
                })
            }
        },{
            el: '.addOtherSccheckType',
            event: 'click',
            handler: function () {
            	num++;
            	if(num==1){
            		var trHTML = "<tr>"
            			+ "<td class='center'><a class='del'>删除</a></td>"
            			+ "<td>其他:<input type='text' id='checkName_OTHER"+num+"' name='checkName_OTHER"+num+"'></td>"
            			+ "<td class='center'>"
            			+ "<input type='checkbox' class='chk' value='OTHER"+num+"' name='chk_OTHER"+num+"'"
            			+ ">是"
            			+ "</td>"
            			+ "<td><textarea class='prodis' style='display: none' id='problem_OTHER"+num+"' name='problem_OTHER"+num+"'></textarea></td>"
            			+ "<td><textarea class='prodis' style='display: none' id='dispose_OTHER"+num+"' name='dispose_OTHER"+num+"'></textarea></td>"
            			+ "</tr>"
            		 $("#table2").append(trHTML);
            	}else{
            		if($.trim($("#checkName_OTHER"+(num-1)).val())!=""){
            			var trHTML = "<tr>"
            				+ "<td class='center'><a class='del'>删除</a></td>"
            				+ "<td>其他:<input type='text' id='checkName_OTHER"+num+"' name='checkName_OTHER"+num+"'></td>"
            				+ "<td class='center'>"
            				+ "<input type='checkbox' class='chk' value='OTHER"+num+"' name='chk_OTHER"+num+"'"
            				+ ">是"
            				+ "</td>"
            				+ "<td><textarea class='prodis' style='display: none' id='problem_OTHER"+num+"' name='problem_OTHER"+num+"'></textarea></td>"
            				+ "<td><textarea class='prodis' style='display: none' id='dispose_OTHER"+num+"' name='dispose_OTHER"+num+"'></textarea></td>"
            				+ "</tr>"
            				$("#table2").append(trHTML);
            		}else{
            			num--;
            			layer.msg("请先填写其他检查项！", {time: 2000}, function() {});
            		}
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
