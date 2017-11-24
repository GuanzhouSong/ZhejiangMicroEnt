require(['component/iframeLayer', 'common/util', 'common/http', 'jquery.validate', 'jquery.serialize','common/validateRules','laydate'], function (layer, util, http) {


    init();

    /**
     * 初始化函数集合
     */

    function init() {
        formValid();
        bind();
    } 
    
    /**
     * 表单验证
     */
    function formValid() {
//    	//添加时赋值
//    	if( window._CONFIG._uid==null || window._CONFIG._uid == ''){
//    		$('#deliName').val(window._CONFIG._deliName);
//    		$('#deptId').val(window._CONFIG._deptId);
//    		$('#deilCode').val(window._CONFIG._deilCode);
//    		$('#deliType').val(window._CONFIG._deliType);
//    	}
		$('#deliName').val(window._CONFIG._deliName);
		$('#deptId').val(window._CONFIG._deptId);
		$('#deliCode').val(window._CONFIG._deliCode);
		$('#deliType').val(window._CONFIG._deliType);
        
		$('#sysDeliverInfoForm').validate({
            rules: {
            	deliAddress:{
            		required:true
            	},
            	linkman:{
            		required:true
            	},	
            	tel: {
                    required: true,
                    telandphone:true
                },
                postalCode:{
                	required:true,
                	isZipCode:true
                },
                isValid:{
                	required:true
                },
                deliType:{
                	required:true
                }               
            },
            messages:{
            	deliAddress:{
            		required:"配送地址不为空",
            	},
            	linkman:{
            		required:"联系人不为空",
            	},
            	tel:{
            	   required:"手机号码不为空"
            	},
            	postalCode:{
                	required:"邮政编码不为空"
                },
                isValid :{
                	required:"请选择是否有效"
                },
                deliType:{
                	required:"请选择主体类型"
                }
            },
            onkeyup:false,
            onfocusout:function(el){
                $(el).valid();
            },
            showErrors:function(errorMap,errorList){
                for(var i in errorMap){
                    layer.tips(errorMap[i],$('#sysDeliverInfoForm input[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
            },
            submitHandler: function () {
                var formParam = $('#sysDeliverInfoForm').serializeObject();
                http.httpRequest({
                    url: '/reg/server/yr/sysdeliverinfo/edit',
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                    	if(data.status == "success"){
                        	if(data.msg == '0'){
                                layer.msg("保存成功", {time: 1000}, function () {
                                    layer.close({reload: true});
                                });
                        	}
                        	if(data.msg == '1'){
                                layer.msg("修改成功", {time: 1000}, function () {
                                    layer.close({reload: true});
                                });
                        	}
                    	}else{
                    		layer.msg(data.msg, {time: 1000}, function () {
                                layer.close({reload: true});
                            });
                    	}
                    }
                })
            }
        })
    }

    function bind() {
        util.bindEvents([
           {
            el: '#cancel',
            event: 'click',
            handler: function () {
                layer.close();
            }
          }
           ])
    }

})