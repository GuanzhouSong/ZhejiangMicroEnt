var formParam;
require(['component/iframeLayer','common/util',  'common/http', 'jquery.validate', 'jquery','jquery.serialize','lib/jquery/jquery.base64'], function (layer,util , http) {
	
	if($(document).width()>1440){
        $('.log-hd').width('1440px');
	};

    document.onkeydown = function (event) {
        var e = event || window.event;
        if (e.keyCode == 13) {
            $("#login").click();
        }
    };
    
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
                    rangelength: [2, 20]
                },
                password: {
                    required: true,
                    rangelength: [2, 20]
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
            }
        });
    }

    /**
     * 事件绑定
     */
    function bind() {
        util.bindEvents([
            {
                el: '.js-checkcode',
                event: 'click',
                handler: function () {
                    $('.js-check-img').attr('src', '/cscaptcha?t=' + Math.random());
                }
            },
            {
                el: '#ckUser',
                event: 'click',
                handler: function () {
                    location.assign('/syn/server/sysuserck/show?userName='+$("#username").val());
                }
            },
            {
                el: '#exit',
                event: 'click',
                handler: function () {
                    layer.closeAll();
                }
            },
            {
                el: '#login',
                event: 'click',
                handler: function () {
                    if($("#login-form").valid()){
                         formParam = $("#login-form").serializeObject();
                        http.httpRequest({
                            headers: {"CSRFToken":$("#csrftoken").val()},
                            url: '/syn/loginsyn',
                            type: 'post',
                            data: {username: $.trim($("#username").val()), password: $.trim($.base64.encode($("#password").val())), checkCode: $.trim($("#checkCode").val())},
                            success: function (data) {
                                if (data.status == 'success') {
                                    location.assign('/syn/index');
                                    return;
                                }else if (data.status == 'fail'&&data.errorCode=='checked') {
                                    layer.dialog({
                                        title: '',
                                        area: ['600px', '340px'],
                                        type:1,
                                        content: $('#uncheck_tip'),
                                        callback: function (data) {
                                        }
                                    })
                                    return;
                                }
                                $('.js-checkcode').trigger('click');
                                data.msg && layer.msg(data.msg);
                            }
                        });
                    }
                }
            }
        ])
    }

})