require(['component/iframeLayer', 'common/util', 'common/http', 'handlebars', 'jquery.validate', 'common/validateRules', 'jquery.serialize','ztree'], function (layer, util, http,handlebars) {


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
        $('#psw_edit').validate({
            onkeyup:false,
            rules: {
                password: {
                    required: true
                },

                sysUserPswNew: {
                    required: true,
                    minlength:6,
                    maxlength:20
                },

                sysUserPswNewAgain: {
                    required: true,
                    minlength:6,
                    maxlength:20
                }
            },
            showErrors:function(errorMap,errorList){
                for(var i in errorMap){
                    layer.tips(errorMap[i],$('#psw_edit input[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
            },
            submitHandler: function () {

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
            },
            {
                el: '#save',
                event: 'click',
                handler: function () {
                    if($("#psw_edit").valid()){

                        var pwdFlag = false;

                        //校验原密码是否正确
                        http.httpRequest({
                            url: '/reg/server/sysuser/doCheckSysUserPsw',
                            data: {password: $("#sysUserPsw").val()},
                            async:false,
                            success: function (data) {
                                if(data["status"] == "success"){
                                    pwdFlag = true;
                                }else{
                                    layer.msg("原密码不正确!", {time: 1000}, function () {
                                    });
                                    pwdFlag = false;
                                }
                            }
                        });
                        if(!pwdFlag){return false;}
                        if($("#sysUserPswNew").val() == $("#sysUserPsw").val()){
                            layer.msg("新密码不能与原密码相同", {time: 1000}, function () {
                            });
                            return false;
                        }

                        if($("#sysUserPswNewAgain").val() != $("#sysUserPswNew").val()){
                            layer.msg("两次密码输入不一致!", {time: 1000}, function () {
                            });
                            return false;
                        }
                        //修改密码
                        http.httpRequest({
                            url: '/reg/server/sysuser/doChangePsw',
                            data: {password: $("#sysUserPswNew").val()},
                            async:false,
                            success: function (data) {
                                layer.msg(data.msg, {time: 3000}, function () {
                                    layer.close(data);
                                });
                            }
                        })
                    }
                }
            }
        ])
    }

})