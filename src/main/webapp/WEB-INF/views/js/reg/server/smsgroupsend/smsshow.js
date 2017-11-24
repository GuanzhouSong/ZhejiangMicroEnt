require(['component/iframeLayer', 'common/util', 'common/http', 'jquery.validate','common/validateRules', 'jquery.serialize','laydate'], function (layer, util, http) {


    init();

    /**
     * 初始化函数集合
     */
    
    function init() {
    	//初始化任务编号
    	var today=new Date();
    	
		var y = today.getFullYear();
	    var m = today.getMonth() + 1;
	    m = m < 10 ? ('0' + m) : m;
	    var d = today.getDate();
	    d = d < 10 ? ('0' + d) : d;
	    var hours = today.getHours();
        var minutes = today.getMinutes();
        var seconds = today.getSeconds();
		var smsDate = y + '-' + m + '-' + d;
		var setDate = y + '-' + m + '-' + d+" "+hours+":"+minutes+":"+seconds;
		$("#smsDate").val(smsDate).attr("onclick","return false;");
		$("#setTime").val(setDate);
		
    	formValid();
        bind();
    }

    /**
     * 表单验证
     */
    function formValid() {
        $('#smsForm').validate({
            rules: {
            	taskName: {
                    required: true
                }
            },
            submitHandler: function () {
        		$("#hiddensmsDate").val($("#smsDate").val());
            	if($("#smsLerep").is(':checked')||$("#smsLia").is(':checked')){
            		var formParam = $('#smsForm').serializeObject();
            		http.httpRequest({
            			url: '/reg/server/smstask/save',
            			serializable: true,
            			data: formParam,
            			type: 'post',
            			success: function (data) {
            				layer.msg(data.msg, {time: 1000}, function () {
            					window.location.href='/reg/server/smstask/list';
            				});
            			}
            		})
            	}else{
            		layer.msg("请您<em style='color: red;'>【至少选择一项】</em>短信发送对象!", {icon: 7,time: 1000});
            	}
            }
        })
    }
    
    $("#isCurrent").click(function(){
    	if($(this).prop("checked")){
    		init();
    	}else{
    		$("#smsDate").val("").attr("onclick","laydate({min: laydate.now(),max: laydate.now(+7)})");
    	}
    })
   
    function bind() {
        util.bindEvents([{
            el: '#cancel',
            event: 'click',
            handler: function () {
            	window.location.href='/reg/server/smstaskinfo/addSmsList';
            }
        },{
            el: '#smsType',
            event: 'change',
            handler: function () {
            	var smsType = $("#smsType").val();
            	var deptName=$("#deptName").val();
            	if(smsType=="1"){
            		$("#smsMsg").val("【"+deptName+"】企业年报至6月30日结束，请及时登录公示系统zj.gsxt.gov.cn报送，逾期将被列入异常名录，如已报送请忽略。");
            	}else{
            		$("#smsMsg").val("【"+deptName+"】个体户年报截止6月30日，请至公示系统zj.gsxt.gov.cn电子报送或提交纸质报告。如已报送请忽略。");
            	}
            }
        },{
            el: '#smsLerep',
            event: 'click',
            handler: function () {
            	 if($(this).is(':checked')) {  //选中负责人 
            		 $("#repeatLerep").removeAttr("disabled");
            	 }else{
            		 $("#repeatLerep").attr("disabled","disabled");
            	 }
            }
        },{
            el: '#smsLia',
            event: 'click',
            handler: function () {
            	 if($(this).is(':checked')) {  //选中联络员
            		 $("#repeatLia").removeAttr("disabled");
            	 }else{
            		 $("#repeatLia").attr("disabled","disabled");
            	 }
            }
        },{
            el: '#repeatLerep',
            event: 'click',
            handler: function () {
            	 if($(this).is(':checked')) {  //负责人去重 
            		 if($("#repeatLia").is(':checked')){//选中(都去重)
            			 $("#rsmsIntroduction").val($("#rsmsIntroductionAnd").val());
            			 $("#rsms").html($("#rsmsIntroductionAnd").val());
            		 }else{//负责人去重，联络员不去重
            			 $("#rsmsIntroduction").val($("#rsmsIntroductionLerep").val());
            			 $("#rsms").html($("#rsmsIntroductionLerep").val());
            		 }
            	 }else{//负责人不去重
            		 if($("#repeatLia").is(':checked')){//选中(负责人不去重，联络员去重)
            			 $("#rsmsIntroduction").val($("#rsmsIntroductionLia").val());
            			 $("#rsms").html($("#rsmsIntroductionLia").val());
            		 }else{//负责人不去重，联络员不去重
            			 $("#rsmsIntroduction").val($("#smsIntroduction").val());
            			 $("#rsms").html($("#smsIntroduction").val());
            		 }
            	 }
            }
        },{
            el: '#repeatLia',
            event: 'click',
            handler: function () {
            	 if($(this).is(':checked')) {  //联络员去重 
            		 if($("#repeatLerep").is(':checked')){//选中(都去重)
            			 $("#rsmsIntroduction").val($("#rsmsIntroductionAnd").val());
            			 $("#rsms").html($("#rsmsIntroductionAnd").val());
            		 }else{//负责人不去重，联络员去重
            			 $("#rsmsIntroduction").val($("#rsmsIntroductionLia").val());
            			 $("#rsms").html($("#rsmsIntroductionLia").val());
            		 }
            	 }else{//联络员不去重
            		 if($("#repeatLerep").is(':checked')){//选中(联络员不去重，负责人去重)
            			 $("#rsmsIntroduction").val($("#rsmsIntroductionLerep").val());
            			 $("#rsms").html($("#rsmsIntroductionLerep").val());
            		 }else{//联络员不去重，负责人不去重
            			 $("#rsmsIntroduction").val($("#smsIntroduction").val());
            			 $("#rsms").html($("#smsIntroduction").val());
            		 }
            	 }
            }
        }])
    }

})