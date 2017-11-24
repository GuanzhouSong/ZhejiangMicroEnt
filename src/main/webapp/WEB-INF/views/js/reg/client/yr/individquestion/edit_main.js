require([
	'component/iframeLayer',
	'common/util',
	'common/http',
	'jquery.validate',
	'jquery.serialize',
	'laydate',
	'common/validateRules',
	'jquery.placeholder',
	'jquery.icinfo'
], function(layer, util, http) {
	$('.js-ipt-box').expandInput();
    init();
    /**
     * 初始化函数集合
     */
    
    function init() {
    	initData();
        bind();
        formValid(); 
    }
    
    var commitFlag = false;
    var saveFlag = false;
    
    function formValid(){
    	$("#questionnaireForm").validate({
			onfocusout:function(el){
				var parentEle, cls,ele = $(el);
				if (ele.valid()) {
					if (ele.is('input') && ele.attr('type') != 'text') {
						cls = 'error-tips-radio';
						ele.closest('.radio-box').removeClass(cls);
					} else if (ele.is('select')) {
						cls = 'error-tips';
						ele.removeClass(cls);
					} else {
						cls = 'error-tips';
						ele.removeClass(cls);
						parentEle = ele.parent();
						if (parentEle.has('.js-error-tips').length) {
							parentEle.find('.js-error-tips').remove();
						}
					}
				}
			},
			showErrors:function(errorMap,errorList){
				for (var i in errorMap) {
					var ele = $("#questionnaireForm input[name="+"'"+i+"'"+"]"), index, parentEle, cls;
					if (ele.is('input') && ele.attr('type') != 'text') {
						cls = 'error-tips-radio';
						ele.closest('.radio-box').addClass(cls);
					} else if (ele.is('select')) {
						cls = 'error-tips';
						ele.addClass(cls);
					} else {
						cls = 'error-tips';
						ele.addClass(cls);
						parentEle = ele.parent();
						if (!parentEle.has('.js-error-tips').length) {
							parentEle.append('<em class="js-error-tips error-tips-icon"></em>');
						}
					}
					(function (i) {
						parentEle && (parentEle.find('.js-error-tips').hover(function () {
							index = layer.tips(errorMap[i], $(this), {tips: 3, time: 0})
						}, function () {
							layer.close(index);
						}))
					})(i);
				}
			},
            rules: {
            	"individQueMainList[0].mobTel": {
					telandphone:true
                }
            },
            messages:{
            	"individQueMainList[0].mobTel":{
            	   checkMobile:"请输入正确格式的手机号码"
            	}
            },
    		submitHandler:function(){
    			/*//纳税人类型 转企前
	       		 if($("input[tax='taxpayerBefore']:checked").length == 0){
	       		    layer.tips('请选择 转企前纳税人类型','#before',{tips:3, tipsMore:true, ltype:0});
	 		    	return false;
	 		    }
	 		  	//纳税人类型 转企后
	 		  	if($("input[tax='taxpayerAfter']:checked").length == 0){
	 		  		layer.tips('请选择 转企前纳税人类型','#after',{tips:3, tipsMore:true, ltype:0});
	 		  		return false;
	 		  	}
	 			if($("input[confidence='confidence']:checked").length == 0){
	 				layer.tips('请选择是否有做大做强信心','#confidence',{tips:3, tipsMore:true, ltype:0});
	 		  		return false;
	 		  	}*/
	 			//1，2，3，4，8项金额判断
	 			var Flag = true;
	 		  	$(".moneyJudge").each(function(i,n){
	 		  		if($(this).val() > 0 && $(this).val() < 1000){
	 		  			layer.confirm('本报表金额数据的单位均为“元”，请注意检查所填写的金额数据无误。如需修改请点击“取消”。', {icon: 2, title: '提示'}, function (index) {
	 		  				httpRequestCommit();
	 		  				layer.close(index);
	 		  			});
	 		  			Flag = false;
	 		  		}
	 		  	});
	 		  	if(!Flag){return false;}
	 		  	httpRequestCommit();
    		 }
    	});
    }
    
    function httpRequestCommit(){
    	if(commitFlag){
			$("#auditState").val("2");//提交状态	
		}
		if(saveFlag){
			$("#auditState").val("1");//暂存状态	
		}
		var auditState = $("#auditState").val();
		  http.httpRequest({
               url: '/reg/client/yr/ent/individquestionnaire/commit',
               serializable: false,
               data: $('#questionnaireForm').serialize(),
               type: 'post',
               success: function (data) {
               if(data.status == 'success'){
               	if(auditState == '1'){
               		layer.msg("暂存成功！", {time: 1000}, function () {
               			window.location.reload();
                      });
               	}
               	if(auditState == '2'){
               		layer.msg("提交成功！", {time: 1000}, function () {
               		window.location.reload();
                      });
               	}
                }else{
               	    layer.msg(data.msg, {time: 1000}, function () {
                  });
                }
             }
        }) 
    }
    
    function initData(){
    	    //提交或修正状态，表单只读
    	    var auditState = $("#auditState").val();
    	    if(auditState =='2' || auditState =='3'){
    	    	$("#questionnaireForm input[type = 'text']").each(function(){
    	    		$(this).attr("disabled","disabled");
    	    	})
    	    	$("#questionnaireForm input[type = 'checkbox']").each(function(){
    	    		$(this).attr("disabled","disabled");
    	    	})
    	    	$("#questionnaireForm input[type = 'radio']").each(function(){
    	    		$(this).attr("disabled","disabled");
    	    	})
    	    }
    	   //将页面中财务相关输入框中，值为空的，设置默认值0
    		$(".moneyJudge").each(function() {
    	        var v = $.trim($(this).val()).replace(/\s+|[a-z]|[A-Z]|[\u4e00-\u9fa5]|,|。|,|，/g, "");
    	        if(v != "" && v != null){
    	        	$(this).val(parseFloat((isNaN(v) ? "0.00" : v) - 0).toFixed(2));
    	       }
    	    });
		/*
             //财务，经营面积只允许输入数字，且精确到分
    		 $(".moneyJudge,.opSpace").focus(function() {
    	            $(this).select();
    	        }).blur(function() {
		        var v = $.trim($(this).val()).replace(/\s+|[a-z]|[A-Z]|[\u4e00-\u9fa5]|,|。|,|，/g, "");
		        //长度校验
	            if(v.length > 16){
	                layer.tips('您输入的长度超出正常值！',$(this),{tips:3, tipsMore:true, ltype:0});
	                $(this).focus();return;
	            }
	            $(this).val(parseFloat((v == "" || isNaN(v) ? "0.00" : v) - 0).toFixed(2));
    	    });*/
      }
    
    //设置提交暂存状态
    $("#commit").click(function(){
    	commitFlag = true;
    	saveFlag = false;
    });
    $("#save").click(function(){
    	saveFlag = true;
    	commitFlag = false;
    });
    
    function bind() {
        util.bindEvents([
        {
            el: '#close',
            event: 'click',
            handler: function() {
            	window.close();
             }
        }])
    }

});