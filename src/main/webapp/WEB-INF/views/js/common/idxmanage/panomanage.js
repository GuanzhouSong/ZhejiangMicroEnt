require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery',
         'jquery.serialize','laydate','common/validateRules'],
         function (layer, dataTable, util, http,handlebars) {
	
	init();
    /**
     * 初始化函数集合
     */
    function init() {
    	formValidate();
    	deleteFormValidate();
    }
    
    function formValidate(){
    	$('#hx-form').validate({
    		rules: {
    			keyword:{required:true},
    			upassword:{required:true} 
    		},
    		onkeyup:false,
            showErrors:function(errorMap,errorList){
            	 for(var i in errorMap){
                     layer.tips(errorMap[i],$('#hx-form input[name='+i+'],textarea[name='+i+']'),{
                         tips:3,
                         tipsMore:true,
                         ltype:0
                     });
                 }
            },
            submitHandler: function () {
                http.httpRequest({
                    url: '/esmanage/doUpdatePano',
                    serializable: true,
                    data: $("#hx-form").serializeObject(),
                    type: 'post',
                    success: function (data) {
                        layer.msg(data.msg, {time: 2000}, function () {
                        	if(data.status=='success'){
                        		window.location.reload();
                        	}
                        });
                    }
                });
            }
        });
    }
    
    function deleteFormValidate(){
    	$('#hx-form-delete').validate({
    		rules: {
    			keyword_delete:{required:true},
    			upassword_delete:{required:true} 
    		},
    		onkeyup:false,
            showErrors:function(errorMap,errorList){
            	 for(var i in errorMap){
                     layer.tips(errorMap[i],$('#hx-form-delete input[name='+i+'],textarea[name='+i+']'),{
                         tips:3,
                         tipsMore:true,
                         ltype:0
                     });
                 }
            },
            submitHandler: function () {
                http.httpRequest({
                    url: '/esmanage/doDeletePano',
                    serializable: true,
                    data: $("#hx-form-delete").serializeObject(),
                    type: 'post',
                    success: function (data) {
                        layer.msg(data.msg, {time: 2000}, function () {
                        	if(data.status=='success'){
                        		window.location.reload();
                        	}
                        });
                    }
                });
            }
        });
    }
    
    
})
