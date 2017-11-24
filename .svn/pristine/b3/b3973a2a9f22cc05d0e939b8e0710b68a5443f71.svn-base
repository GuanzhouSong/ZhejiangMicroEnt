require(['component/iframeLayer','common/util', 'common/http','jquery','jquery.serialize','jquery.validate','common/validateRules'],
		function (layer,util, http) {


    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	formValid();
    	
        bind();
    }
    
    function formValid(){
    	$("#slicenoInfoForm").validate({
            showErrors:function(errorMap,errorList){
                for(var i in errorMap){
                    layer.tips(errorMap[i],$('#slicenoInfoForm input[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
            },
    		submitHandler:function(){
	    			if($("input[type='radio']:checked").length == 0){
	    				layer.tips("请选择片区类型",$('#checksuc'),{tips:3,tipsMore:true,ltype:0});
	    				return false;
	    			}
//	    			if($("input[name='supCode']").val() == $("#deptCode").val()){
//	    				layer.tips("片区编码不能和管辖单位地区编码相同！",$('#deptCode'),{tips:3,tipsMore:true,ltype:0});
//	    				return false;
//	    			}
	                  var formParam = $('#slicenoInfoForm').serializeObject();
	 				  http.httpRequest({
	 	                    url: '/reg/system/slicenomanage/save',
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
    	});
    }

    function bind() {
        util.bindEvents([{
            el: '#cancel',
            event: 'click',
            handler: function () {
                layer.close();
            }
        }])
    }
})