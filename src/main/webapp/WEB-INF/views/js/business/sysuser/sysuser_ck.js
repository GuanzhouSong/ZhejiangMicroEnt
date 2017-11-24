require([
    'component/iframeLayer',
    'component/dataTable',
    'common/util',
    'common/http',
    'handlebars',
    'jquery',
    'jquery.serialize',
    'jquery.validate',
    'common/validateRules',
    'jquery.placeholder',
    'jquery.icinfo'
], function (layer, dataTable, util, http, handlebars) {
    $('input, textarea').placeholder();
    var wait = 60; 
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        var isLogin=window._CONFIG.isLogin;
        var isChecked=window._CONFIG.isChecked;
        if(isChecked=="1"){
            layer.msg("该用户已经通过帐号验证，无需重复验证！", {time: 2000}, function () {
                location.assign('/syn/logout');
            });
            return;
        }
        if(isLogin=="0"){
            layer.msg("请先登录再来进行帐号验证！", {time: 2000}, function () {
                location.assign('/syn/logout');
            });
            return;
        }
      //  formValid();
        bind();
    }

    jQuery.validator.addMethod("email", function(value, element) {
        var tel =/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        return this.optional(element) || (tel.test(value));
    }, "请正确填写您邮箱！");

    /**
     * 表单验证
     */
    function formValid() {
        $('#user_ck_form').validate({
            onkeyup:false,
            rules: {
                deptFullName: {
                    required: true
                },
                deptShortName: {
                    required: true
                },
                deptAddress:{
                    required: true
                },
                userRealName:{
                    required: true
                } ,
                userSex:{
                    required: true
                },
                deptName:{
                    required: true
                },
                post:{
                    required: true
                } ,
                phone:{
                    required:true,
                    isTel: true
                } ,
                userEmail:{
                    required:true,
                    email: true
                } ,
                userPassword:{
                    required: true,
                    rangelength: [6, 12]
                },
                telPhone:{
                    required:true,
                    isTel: true
                } ,
                checkCode:{
                    required:true
                },
                dutyCodeNames:{    //本部门对应的审批职能部门
                    required:function(){
                        var _value = $("#dutyCodeNames").val().replace(/(^\s*)|(\s*$)/g, "");//获取输入框中的值去掉前后空格
                        var _code = $("#dutyCodes").val();//
                        if(_code){return false;}
                        if(_value=='无'){
                            return false
                        }else {
                            return true;
                        }
                    }
                },
                licItemNames:{     //本部门涉及的后置审批事项
                    required:function(){
                        var _value = $("#licItemNames").val().replace(/(^\s*)|(\s*$)/g, "");//获取输入框中的值去掉前后空格
                        var _code = $("#licItems").val();//
                        if(_code){return false;}
                        if(_value=='无'){
                            return false
                        }else {
                            return true;
                        }
                    }
                }
            },
            showErrors:function(errorMap,errorList){
                for(var i in errorMap){
                    layer.tips(errorMap[i],$('#user_ck_form input[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
            },
            messages: {
                dutyCodeNames:{
                    required:"请选择审批职能部门"
                },
                licItemNames:{
                    required:"请选择审批事项"
                }
            },
            submitHandler: function () {

            }
        })
    }

    function bind() {
        util.bindEvents([
            {
                el: '#save',
                event: 'click',
                handler: function () {
                	var sysUserPswNew=$.trim($("#sysUserPswNew").val());
                	if(sysUserPswNew==null||sysUserPswNew==""){
                		 layer.msg("请输入新密码!", {time: 2000}, function () {
                         });
                         return false;
                	}
                	if(sysUserPswNew.length<6){
               		    layer.msg("密码长度必须大于或等于6位!", {time: 2000}, function () {
                        });
                        return false;
                  	} 

                	var sysUserPswNewAgain=$.trim($("#sysUserPswNewAgain").val()); 
                	if(sysUserPswNewAgain==null||sysUserPswNewAgain==""){
               		    layer.msg("请输入确认密码!", {time: 2000}, function () {
                        });
                        return false;
                	}
                	
                	if(sysUserPswNew != sysUserPswNewAgain){
                        layer.msg("前后两次密码不一致!", {time: 1000}, function () {
                        });
                        return false;
                    }
                	
                	var checkCode=$.trim($("#checkCode").val()); 
                	if(checkCode==null||checkCode==""){
               		    layer.msg("未输入验证码!", {time: 2000}, function () {
                        });
                        return false;
                	}
                	
                	if(checkCode.length!=6){
               		    layer.msg("验证码长度必须为6位!", {time: 2000}, function () {
                        });
                        return false;
                  	} 
                	 
                	 var formParam = $('#user_ck_form').serializeObject();
                     http.httpRequest({
                         url: '/syn/server/sysuserck/save',
                         serializable: true,
                         data: formParam,
                         type: 'post',
                         success: function (data) {
                             layer.msg(data.msg, {time: 2000}, function () {
                                 if(data.status=="success"){
                                     location.assign('/syn/logout');
                                 }/*else{
                                     layer.msg("发送短信出现异常！", {time: 1000}, function () {

                                     })
                                 }*/
                             });

                         }
                     })
                }
            },
            {
                el: '#toLogin',
                event: 'click',
                handler: function () {
                    var formParam = $('#user_ck_form').serializeObject();
                    http.httpRequest({
                        url: '/syn/server/sysuserck/save',
                        serializable: true,
                        data: formParam,
                        type: 'post',
                        success: function (data) {
                            layer.msg(data.msg, {time: 1000}, function () {
                                if(data.status=="success"){
                                    location.assign('/syn/logout');
                                }else{
                                    layer.msg("发送短信出现异常！", {time: 1000}, function () {

                                    })
                                }
                            });

                        }
                    })
                }
            },
            {
                el: '#selectLicItems',
                event: 'click',
                handler: function () {
                    if(!$("#licItemNo").prop("checked")){
                        layer.dialog({
                            title: '选择后置审批事项',
                            area: ['66%', '80%'],
                            content: '/syn/pubdtinfo/codeLicenseCheckboxTreePage',
                            callback: function (data) {
                                $("#licItemNames").val(data.reload.content);
                                $("#licItems").val(data.reload.code);
                            }
                        })
                    }else{
                        layer.msg('请先取消选中下面的"无对应的后置审批事项",再来后置审批事项！', {time: 3000}, function () {
                        });
                    }
                }
            },
            {
                el: '#selectDutyCodes',
                event: 'click',
                handler: function () {
                    if(!$("#dutyNo").prop("checked")){
                        layer.dialog({
                            title: '选择职能部门',
                            area: ['440px', '80%'],
                            content: '/common/system/code_duty_dept/duty_dept_select',
                            callback: function (data) {
                                $("#dutyCodes").val(data.deptCodes);
                                $("#dutyCodeNames").val(data.deptNames);
                            }
                        })
                    }else{
                        layer.msg('请先取消选中下面的"无对应的审批职能部门",再来选择职能部门！', {time: 3000}, function () {
                        });
                    }
                }
            },
            {
                el: '#genCheckCode',
                event: 'click',
                handler: function () { 
                	//计数器
                	timeCount();
                	var telPhone=$.trim($("#telPhone").val()); 
                    if(telPhone==null||telPhone==""){
                        layer.msg('请先输入手机号码（请填写浙江省内移动、联通、电信号码）', {time: 3000}, function () {
                        });
                        return false;
                    }
                    var formParam = $('#user_ck_form').serializeObject();
                    http.httpRequest({
                        url: '/syn/server/sysuserck/gen_sms_code',
                        serializable: true,
                        data: formParam,
                        type: 'post',
                        success: function (data) { 
                            layer.msg(data.msg, {time: 3000}, function () {
                                layer.close({reload: true});
                            });
                        }
                    }) 
                }
            },
            {
                el: '#cancel',
                event: 'click',
                handler: function () {
                    location.assign('/syn/logout');
                }
            } ,
            {
                el: '#exit',
                event: 'click',
                handler: function () {
                    layer.closeAll();
                }
            }
            ,
            {
                //无对应的审批职能部门
                el: '#dutyNo',
                event: 'click',
                handler: function () {
                    if($("#dutyNo").prop("checked")){
                           $("#dutyCodes").val("");
                            $("#dutyCodeNames").val("无");
                    }else{
                        $("#dutyCodes").val("");
                        $("#dutyCodeNames").val("");
                    }
                }
            },
            {
                //无对应的后置审批事项
                el: '#licItemNo',
                event: 'click',
                handler: function () {
                    if($("#licItemNo").prop("checked")){
                        $("#licItems").val("");
                        $("#licItemNames").val("无");
                    }else{
                        $("#licItems").val("");
                        $("#licItemNames").val("");
                    }
                }
            }

        ])
    }
    
    
    //计数器 
    function timeCount() { 
        if (wait == 0) { 
            wait = 60;
            $("#genCheckCode").text("重新获取验证码");
            $("#genCheckCode").css("display",""); 
            $("#genCheckCodeAfter").css("display","none"); 
        } else { 
        	$("#genCheckCodeAfter").css("display",""); 
        	$("#genCheckCodeAfter").text(wait+"s后重新获取");
        	$("#genCheckCode").css("display","none"); 
            wait--;
            setTimeout(function () {
            	timeCount() ;
            },
            1000)
        }
    }

    //确认用户验证的填写信息
    function showConfirm(){
        layer.dialog({
            title: '',
            area: ['600px', '480px'],
            type:1,
            content: $('#ck_success'),
            callback: function (data) {
                //location.assign('/syn/logout');
            }
        })
        $("#unitName").html($("#deptFullName").val());
        $("#licItem").html($("#licItemNames").val());

    }
})
