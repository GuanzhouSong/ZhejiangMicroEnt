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
    
    function save(){
		var disposeState = $("input[name='disposeState']:checked").val();
		var disposeFinishDate = $("#disposeFinishDate").val();
		if(disposeState=='1'){
			layer.msg("后续处置措施是否完结必须选择已完结!", {time: 2000}, function() {});
		}else if(disposeState=='2'&&disposeFinishDate==""){
			layer.msg("完结日期是必填项", {time: 2000}, function() {});
		}else{
			var searchParams = $("#taskForm").serializeObject();
			http.httpRequest({
				url: '/syn/sccheck/pubscentresult/supplyscresult',
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
		                                	+ "<td>"+tName+"</td>"
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
            el: '.pa',
            event: 'click',
            handler: function () {
            	var auditState = $("input[name='auditState']:checked").val();
            	if(auditState=="4"){
            		$("#auditOpinion").val("审核不通过，退回检查结果信息。");
            	}else{
            		$("#auditOpinion").val("审核通过，检查结果信息予以公示。");
            	}
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
      }]);
    }
});
