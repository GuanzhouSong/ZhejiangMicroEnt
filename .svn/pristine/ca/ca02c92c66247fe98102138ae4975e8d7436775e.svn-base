require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate'], function (layer, dataTable, util, http, handlebars) {

    init();
    function init() { 
        bind();
    }
    
    function save(){
    	if(valifyParams()){
    		http.httpRequest({
    			url: '/syn/sccheck/pubscentresult/savedispose',
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
    	var disposeState = $("input[name='disposeState']:checked").val();
    	if(disposeState == "undefined" || disposeState == null || disposeState == "" || disposeState == undefined){
    		layer.tips("请选择后续处置措施是否完结",$("#disposeState1"),{tips:3, tipsMore:true, ltype:0});
			return false;
    	}
    	if(disposeState == "2"){
    		var disposeFinishMss = $("#disposeFinishMss").val();
    		if(disposeFinishMss == ""){
    			layer.tips("请输入完结信息",$("#disposeFinishMss"),{tips:3, tipsMore:true, ltype:0});
    			return false;
    		}
    		var disposeFinishDate = $("#disposeFinishDate").val();
    		if(disposeFinishDate == ""){
    			layer.tips("请选择完结日期",$("#disposeFinishDate"),{tips:3, tipsMore:true, ltype:0});
    			return false;
    		}
    	}
    	return true;
    }
    
    function getCommitParam(){
    	var pubScentResultDto = {};
    	var uid = $("#uid").val();
    	var disposeFinishMss = $("#disposeFinishMss").val();
    	var disposeFinishDate = $("#disposeFinishDate").val();
    	var disposeState = $("input[name='disposeState']:checked").val();
    	var pubScentResult = new initPubScentResult(uid,disposeState,disposeFinishDate,disposeFinishMss);
    	pubScentResultDto.pubScentResult = pubScentResult;
    	return pubScentResultDto;
    }
    
    function initPubScentResult(uid,disposeState,disposeFinishDate,disposeFinishMss){
    	  this.uid=uid;
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
