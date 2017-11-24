require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http','jquery', 'jquery.validate', 'jquery.serialize', 'laydate','common/validateRules'],
function(layer, dataTable, util, http) {

    init();
    /**
     * 初始化函数集合
     */
    
    function init() {
    	//初始化
    	initData();
        bind();
        formValid(); 
    }
    
    
    function formValid(){
    	$("#questionnaireForm").validate({
    		rules: {
            	"individQueMainList[0].mobTel": {
                    checkMobile:true
                }
            },
            messages:{
            	"individQueMainList[0].mobTel":{
            	   checkMobile:"请输入正确格式的手机号码"
            	}
            },
		    showErrors:function(errorMap,errorList){
            for(var i in errorMap){
                layer.tips(errorMap[i],$("#questionnaireForm input[name="+"'"+i+"'"+"]"),{
                    tips:3,
                    tipsMore:true,
                    ltype:0
                 });
               }
            },
            submitHandler:function(){
    			//纳税人类型 转企前
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
	 		  	}
	 			//1，2，3，4，8项金额判断
	 			var Flag = true;
	 		  	$(".moneyJudge").each(function(i,n){
	 		  		if($(this).val() > 0 && $(this).val() < 1000){
	 		  			layer.confirm('本报表金额数据的单位均为“元”，请注意检查所填写的金额数据无误。如需修改请点击“取消”。', {icon: 2, title: '提示'}, function (index) {
	 		  				httpRequestCommit();
	 		  				layer.close(index);
	 		  			})
	 		  			Flag = false;
	 		  		}
	 		  	});
	 		  	if(!Flag){return false;}
	 		  	httpRequestCommit();
    		 }
    	});
    }
    
    function httpRequestCommit(){
    	 $("#auditState").val("3");//提交状态	
         var formParam = $('#questionnaireForm').serialize();
			  http.httpRequest({
                 url: '/reg/server/yr/individquestionnaire/commit',
                 serializable: false,
                 data: formParam,
                 type: 'post',
                 success: function (data) {
                 if(data.status == 'success'){
            		layer.msg(data.msg, {time: 1000}, function () {
            			layer.close({reload:true});
            	  })
                 }else{
                 	layer.msg(data.msg);
                 }
              }
         }) 
    }
    
    function initData(){
 	   //将页面中财务相关输入框中，值为空的，设置默认值0
 		$(".moneyJudge").each(function() {
 	        var v = $.trim($(this).val()).replace(/\s+|[a-z]|[A-Z]|[\u4e00-\u9fa5]|,|。|,|，/g, "");
 	        if(v != "" && v != null){
 	        	$(this).val(parseFloat((isNaN(v) ? "0.00" : v) - 0).toFixed(2));
 	        }
 	  });
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
	    });
  }
    
    function bind() {
        util.bindEvents([
        {
            el: '#close',
            event: 'click',
            handler: function() {
            	layer.close();
             }
        }])
    }

})