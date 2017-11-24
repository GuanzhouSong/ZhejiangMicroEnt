require(['component/iframeLayer', 'common/util', 'common/http', 'jquery.validate', 'jquery.serialize','common/validateRules'], function (layer, util, http) {


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
        $('#yrPbform').validate({
            rules: {
            	tel: {
                    required: true,
                    telandphone:true
                }
            },
            messages:{
            	tel:{
            	   required:"联系电话不为空",
            	   telandphone:"请输入最新正确格式手机号码或者带区号的电话号码"
            	}
            },
            
            onkeyup:false,
            onfocusout:function(el){
                $(el).valid();
            },
            showErrors:function(errorMap,errorList){
                for(var i in errorMap){
                    layer.tips(errorMap[i],$('#yrPbform input[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
            },
            
            submitHandler: function () {
                var formParam = $('#yrPbform').serializeObject();
                http.httpRequest({
                    url: '/reg/server/yr/pbreceive/receive',
                    serializable: true,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                    	if(data.status == "success"){
                            layer.msg("接收成功", {time: 1000}, function () {
                                layer.close({reload: true});
                            });
                    	}else{
                    		if(data.status == "fail"){
                                layer.msg(data.msg, {time: 1000}, function () {
                                    layer.close();
                                });                    		}
                            layer.close();
                    	}
                    }
                })
            }
        })
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