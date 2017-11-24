require(['component/iframeLayer', 'common/util', 'common/http', 'jquery.validate', 'common/validateRules', 'jquery.serialize', 'ztree'], function (layer, util, http) {
    if ($(document).width() > 1440) {
        $('.log-hd').width('1440px');
    }
    ;

    //执行初始化函数
    init();

    /**
     * 初始化集合
     */
    function init() {
        formValid();
        bind();
    }

    /**
     * 登录表单验证
     */
    function formValid() {
        $('#login-form').validate({
            showErrors: function (errorMap, errorList) {
                for (var i in errorList) {
                    $(errorList[i].element).addClass('error');
                    $('#errorContainer').html(errorList[i].message);
                    break;
                }
            },
            onkeyup: function () {
                if ($(this.lastActive).valid()) {
                    $('#errorContainer').html('');
                    $(this.lastActive).removeClass('error');
                }
            },
            onfocusout: false,
            rules: {
                username: {
                    required: true,
                    rangelength: [5, 20]
                },
                password: {
                    required: true,
                    rangelength: [6, 20]
                },
                checkCode: {
                    required: true
                }
            },

            messages: {
                username: {
                    required: '登录账号不能为空',
                    rangelength: '登录账号长度必须是{0}到{1}之间'
                },
                password: {
                    required: '登录密码不能为空',
                    rangelength: '登录密码长度必须是{0}到{1}之间'
                },
                checkCode: {
                    required: '验证码不能为空'
                }
            },
            submitHandler: function (form) {
                var formParam = $(form).serializeObject();
                http.httpRequest({
                    url: 'login?dep=' + encodeURI($("#dep").val()),
                    type: 'post',
                    data: formParam,
                    success: function (data) {
                        if (data.status == 'success') {
                            location.assign('/depsyn/index');
                            return;
                        }
                        $('.js-checkcode').trigger('click');
                        data.msg && layer.msg(data.msg);
                    }
                });
            }
        });
    }

    /**
     * 事件绑定
     */
    function bind() {
        util.bindEvents([{
            el: '.js-checkcode',
            event: 'click',
            handler: function () {
                $('.js-check-img').attr('src', '/captcha?t=' + Math.random());
            }
        }])
    }

})