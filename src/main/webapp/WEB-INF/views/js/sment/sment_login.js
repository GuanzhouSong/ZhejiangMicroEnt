require(['common/util', 'layer1','component/iframeLayer', 'common/http', 'jquery.validate', 'jquery','jquery.serialize'], function (util, layer1, layer, http) {


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
    	$('#username').val("");
    	$('#password').val("");
        formValid();
        bind();
        //从cookie中获取用户名和密码
        var username = icinfo.cookie.get("cs.sment.username");
        var password = icinfo.cookie.get("cs.sment.password");
        
        if(username!=null&&username!=""&&username !="null"){
        	$('#username').val(username);
        }
        if(password!=null&&password!=""&&password!="null"){
        	$('#password').val(password);
        }
        
        if((username!=null &&username!=""&&username !="null")|| (password!=null &&password!=""&&password!="null")){
        	 $("[name = rememberpassword]:checkbox").attr("checked", true);
        } 
    }
    
    //显示登记机关
    function showRegorg(){
    	 layer.dialog({
             title: '选择登记机关',
             area: ['400px', '600px'],
             content: '/commom/server/regorg/regorgsingleselectnocheck',
             callback: function (data) { 
             	if(typeof data.returncode!="undefined"){ 
                 	 var jsonData={
                 			username:$.trim($("#username").val()), 
                 			password:$.trim($("#password").val()),
                 			regOrgCode:data.returncode ,
                 			regOrgName:data.returname  
                 	 }; 
                 	  http.httpRequest({
                          url: '/sment/login/doLoginSmentOrg',
                          type: 'post',
                          data: jsonData,
                          success: function (data) { 
                          	  //用户名不重名
                              if (data.status == 'success'&&data.data=="1") {
                            	  	//如果选择记住密码则往cookie中存用户名和密码 否则设置为空
	                              	if($('input[name="rememberpassword"]:checked').length>0){
	                              		//有效期2年
	                              		this.expires=720*24*3600*1000;
	                              		  icinfo.cookie.set("cs.sment.username", $.trim($('#username').val()),this);
	                                      icinfo.cookie.set("cs.sment.password",$.trim($('#password').val()),this);
	                              	}else{
	                              		  icinfo.cookie.set("cs.sment.username", "");
	                                      icinfo.cookie.set("cs.sment.password","");
	                              	}
                                  location.assign('/sment/login/sment_index');
                                  return;
                              } 
                              data.msg && layer.msg(data.msg,{time:4000});
                          }
                      });
                 	 $('.js-checkcode').trigger('click');
             	}
             }
         })
    }

    /**
     * 登录表单验证
     */
    function formValid() {
        $('#login-form').validate({
            showErrors: function (errorMap, errorList) {
                for (var i in errorList) {
                    $(errorList[i].element).addClass('error');
                    $('#errorContainer').html(errorList[i].message).addClass('errorContainer-bg');
                    break;
                }
            },
            onkeyup: function () {
                if ($(this.lastActive).valid()) {
                    $('#errorContainer').html('').removeClass('errorContainer-bg');
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
                    rangelength: [1, 20]
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
            },{
                el: '#_apply',
                event: 'click',
                handler: function () {
                    layer.msg('暂未开通！',{time:1500});
                }
            },{
                el: '#_elogin',
                event: 'click',
                handler: function () {
                	layer.msg('暂未开通！',{time:1500});
                }
            },{
                el: '#login',
                event: 'click',
                handler: function () {
                    if($("#login-form").valid()){
                        var formParam = $("#login-form").serializeObject();
                        http.httpRequest({
                            url: '/sment/login/doLogin',
                            type: 'post',
                            data: formParam, 
                            success: function (data) {
                            	   //用户名不重名
                                if (data.status == 'success'&&data.data=="1") {
                                	//如果选择记住密码则往cookie中存用户名和密码 否则设置为空
                                	if($('input[name="rememberpassword"]:checked').length>0){
                                		//有效期2年
                                		this.expires=720*24*3600*1000;
                                		icinfo.cookie.set("cs.sment.username", $.trim($('#username').val()),this);
                                        icinfo.cookie.set("cs.sment.password",$.trim($('#password').val()),this);
                                	}else{
                                		icinfo.cookie.set("cs.sment.username", "");
                                        icinfo.cookie.set("cs.sment.password","");
                                	}
                                    location.assign('/sment/login/sment_index');
                                    return;
                                }else if (data.status == 'success'&&data.data=="2") {//用户重名则选择登记机关
                                	showRegorg();
                                    return;
                                }
                                $('.js-checkcode').trigger('click');
                                data.msg && layer.msg(data.msg,{time:3000});
                            }
                        });
                    }

                }
            },{
                el: '.js-log-now',
                event: 'click',
                handler:function () {
                    $(this).hide();
                    $('.log-cont').slideDown();
                }
            }
        ])
    }

})