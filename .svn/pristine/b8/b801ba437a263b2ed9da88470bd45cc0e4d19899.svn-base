require(['component/iframeLayer','common/util', 
         'common/http', 'jquery.validate', 'jquery', 'jquery.serialize', 
         'common/validateRules','jquery.placeholder','jquery.icinfo',
         ], function (layer, util,http) {
//    $('input, textarea').placeholder();
//    $('.js-ipt-box').expandInput();
    //执行初始化函数
    init();

    /**
     * 初始化集合
     */
    function init() {
    	//修改时初始化输入框
//    	var pasid = $("#pasid").val();
//    	if(pasid != null && pasid != ''){
//  			$(".ipt-view").removeAttr("readonly","readonly");
//  			$(".select-view").removeAttr("disabled","true");
//    	}
    	
    	formValid();
        bind();
//        initsel();
    }
    
    
    /**
     * 初始化
     */
    function  initsel(){
    	$('.js-ipt-box').expandInput();
    	//证书类型下拉框
    	if(window._CONFIG._liaidtype!=""){
    	$("#liaidtype").val(window._CONFIG._liaidtype);
    	};
    	 if ($("#liaidtype option:selected").val() != 10) {
             $("#liaidnum").rules("remove", "idCard");
         } 
    }
    
  //手机验证码获取倒计时
    var wait = 60;//时间
    function time(btn) {
    	var btn=$(btn);
    	if (wait == 0) { 
    		btn.text('获取验证码');//显示按钮
    		//绑定获取验证码事件
    		btn.addClass("hq-yzm");
    		wait = 60; 
    	} else { 
    		btn.text(wait + '秒');//显示时间
    		wait--; 
    		setTimeout(function() { 
    			time(btn);//循环调用 
    		},1000); 
    	} 
    }
    
    /**
     * 登录表单验证
     */
    var index;
    function formValid() {
        $('#phoneApply_form').validate({
            rules: {
            	lerep:{
                    required: true,
                    maxlength:50   
            	},
                lianame: {
                    required: true,
                    maxlength:50   
                },
                liaidtype:{
                    required: true
                },
                liaidnum: {
                    required: true,
                    idCard: true,
                    maxlength:50
                },
                tel: {
                    required: true,
                    checkMobile: true
                }
            },
            messages: {
            	lerep: {
                    required: '法定代表人不能为空',
                    maxlength:'法定代表人长度不能大于50位'
                },
                lianame: {
                    required: '联络员不能为空',
                    maxlength:'姓名长度不能大于50位'
                },
                liaidnum: {
                    required: '联络员证件号不能为空',
                    maxlength:'号码不能大于50位'
                },
                tel: {
                    required: '手机号码不能为空'
                }
            },
//            wrapper: 'span',
//            errorElement: 'label',
//            errorClass: 'tip',
//            errorPlacement: function (error, element) {
//                var el = element.closest('.ipt-box');
//                var error = error.prepend('<i class="icon-tip"></i>');
//                error.insertAfter(el);
//            },
            onkeyup:false,
            onfocusout:function(el){
                $(el).valid();
            },
            showErrors:function(errorMap,errorList){
                for(var i in errorMap){
                    layer.tips(errorMap[i],$('#phoneApply_form input[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
            },
            submitHandler: function (form) {
            	//处理合伙企业证件号码加密，但可修改，存入信息应为修改过后的证件号码
                var entTypeCatg =$("#entTypeCatg").val();
                var encerNo =$("#encerNo").val();
            	if(entTypeCatg == '33' || entTypeCatg == '27' ){
            		if(encerNo.indexOf("*") < 0){ //如果显示的加密字符不包含*，说明是改过的
                        $("#cerNo").val(encerNo);	
            		}
            	}
            	var formParam = $(form).serializeObject();
            	//登录表单赋值
                $("#login-regno").val($("#regno").val());
                $("#login-entname").val(formParam.entname);
                $("#login-liaidnum").val(formParam.liaidnum);
                $("#login-lianame").val(formParam.lianame);
                  http.httpRequest({
                      url: '/reg/client/login/phoneapply/pubsave',
                      type: 'post',
                      data: formParam,
                      success: function (data) {
                          var pasId = '';
                          if (data.status == 'success') {
                          	pasId = data.data;
                              if (data.msg == '2') {
                            	  if(entTypeCatg == "50"){
		                            index =	layer.dialog({
		                                    content: $(".tip4"),
		                                    type: 1,
		                                    title: false,
		                                    closeBtn:false,
		                                    area: ['446px','215px']
		                                });
                            	  }else{
                                   	 layer.msg("保存成功",{time:2000},function(){
                                    		 location.assign('/reg/client/login/phoneapply/pubview?pasID=' + pasId );
                                    	 });
                            	  }
                              }
                          } else {
                              alert(data.msg);
                          }
                      }
                  });
                }
        });
    }

    /**
     * 事件绑定
     */
    function bind() {
        util.bindEvents([
             {
            // 类型改变时移除身份证验证
            el: '#liaidtype',
            event: 'change',
            handler: function () {
                $("#liaidnum").val("");
                if ($("#liaidtype option:selected").val() != 10) {
                    $("#liaidnum").rules("remove", "idCard");
                } else {
                    $("#liaidnum").rules("add", {idCard: true});
                }
            }
        },
        {
        	// 联络员备案统一代码/注册号校验
        	el: '#regcode',
            event: 'blur',
            handler: function () {
            	var _regno = $.trim($("#regcode").val());
            	if(_regno == "" || _regno.length <= 6) {
                    layer.tips('请输入正确的注册号或者统一代码',$('#regcode'),{tips:3,tipsMore:true,ltype:0});
                    return ;
            	}else{
            		$("#regcode-span").hide();
	            	http.httpRequest({
	            		url: '/reg/client/login/phoneapply/pubsCheckPhoneApply',
	                    data: {pasentkey : _regno, encatge : 0},
	                    success: function (data) {
	                        if (data.status == 'success') {
	                        	var midBaseInfo = data.data;  //得到midBaseinfo 对象
                                $("#regno").val(midBaseInfo.regNO);
                                $("#unicode").val(midBaseInfo.uniCode);
                                $("#pripid").val(midBaseInfo.priPID);
                                $("#entName").val(midBaseInfo.entName);
                                $("#enttype").val(midBaseInfo.entType);
                                $("#entTypeCatg").val(midBaseInfo.entTypeCatg);
                                $("#lerepphone").val(midBaseInfo.tel);
                                $("#lerep").val(midBaseInfo.leRep);	                        	
                                $("#cerNo").val(midBaseInfo.cerNO);	
                                $("#encerNo").val(midBaseInfo.encerNO);                               
                                if(midBaseInfo.entTypeCatg == '33' || midBaseInfo.entTypeCatg == '27' ){ //合伙企业放开法定代表人，可以自行输入
                          			$(".ipt-specical").removeAttr("readonly","readonly");
                                }else{
                          			$(".ipt-specical").attr("readonly","readonly");
                                }
                      			$(".ipt-edit").removeAttr("readonly","readonly");
                      			$(".select-edit").removeAttr("disabled");
                      			
//	                            index =	layer.dialog({
//                                content: $(".tip4"),
//                                type: 1,
//                                title: false,
//                                closeBtn:false,
//                                area: ['446px','215px']
//                            });
                      			
	                        }else {
//	                        	debugger
	                        	//跳转到信息错误提示框
	                        	if (data.msg) {
	                                if(data.errorCode == 'pb1' || data.errorCode == 'ent2'){
	                            		//关闭当前页面
		                        		$('.cont2').html(data.msg);
		                            	layer.dialog({
		                                    content: $(".tip2"),
		                                    type: 1,
		                                    title: false,
		                                    closeBtn:false,
		                                    area: ['446px','215px']
		                                });
	                                }else if(data.errorCode == 'ent1'){ //回到登录页
	                            		//返回登录页
		                        		$('.cont1').html(data.msg);
		                            	layer.dialog({
		                                    content: $(".tip1"),
		                                    type: 1,
		                                    title: false,
		                                    closeBtn:false,
		                                    area: ['446px','215px']
		                                });
	                                }else{
		                        		$("#regno").val('');
		                                $("#unicode").val('');
		                                $("#pripid").val('');
		                                $("#entName").val('');
		                                $("#enttype").val('');
		                                $("#lerepphone").val('');
		                                $("#lerep").val('');	                        	
		                                $("#cerNo").val('');
		                                $("#encerNo").val('');
	                          			$(".ipt-specical").attr("readonly","readonly");
		                      			$(".ipt-edit").attr("readonly","readonly");
		                      			$(".select-edit").attr("disabled","true");
		                                layer.tips(data.msg,$('#regcode'),{tips:3,tipsMore:true,ltype:0});
	                                }
	                        		
	                        	}
	                        }
	                    }
	                });
            	}
            }
        },
        {
            // 返回到登录页
            el: '.gobacklogin',
            event: 'click',
            handler: function () {
                var url = "/reg/client/login/all";
                window.location.href = url;
            }
        },
        {
        	// 申领证书
        	el: '.keyapply',
            event: 'click',
            handler: function () {
            	window.open ('http://www.icinfo.cn/html/Newleader.jsp','_blank');
            }
        },{
        	// 关闭
        	el: '#close',
            event: 'click',
            handler: function () {
            	window.close();
            	layer.closeAll();
            }
        },
        {
        	// 取消
        	el: '#cancel',
            event: 'click',
            handler: function () {
            	layer.closeAll();
            }
        },
        {
        	// 联络员登录
        	el: '.js-log-yz',
            event: 'click',
            handler: function () {
//            	debugger
                //联络员登录为空验证
            	var password = $.trim($("#password").val());
            	if($.trim($("#gttel").val()) == "" || password == "" || password.length != 6 ) {
            		layer.msg("请输入完整信息。",{time:1000},function(){
          			  return false;
          		  	});
            	}else{
                	var formParam = $("#loginform").serializeObject();
                    http.httpRequest({
                        url: '/reg/client/login/pwdall',
                        type: 'post',
                        data: formParam,
                        success: function (data) {
                        	if (data.status == 'success') {
                                location.assign('/reg/client/yr/yrregcheck/index_list');
                                return;
                            }else {
                            	layer.msg(data.msg,{time:3000},function(){
                            		return false;
                          		});
                            }
                        }
                    });
            	}
            }
        },
        {
        	// 继续登录
        	el: '.publogin',
            event: 'click',
            handler: function () {
            	//先关闭当前会话框
                layer.close(index);
                $("#gttel").val($("#tel").val());
//                $("#gttel").val(13345908080);
//        		$('.cont2').html(data.msg);
            	layer.dialog({
                    content: $(".tip5"),
                    type: 1,
                    title: false,
                    closeBtn:false,
                    area: ['446px','215px']
                });
            }
        },
        {
        	// 获取手机验证码, 发送短信
        	el: '.hq-yzm',
            event: 'click',
            handler: function () {
            	if($.trim($("#gttel").val()) == ""  || $.trim($("#gttel").val()).length != 11) {
            		layer.msg("联络员手机号出错，请核对后重新输入。",{time:1000},function(){
          			  return false;
          		  	});
            	}else{
            		var _this = $(this);
                	if($("#gttel").val() != "") {
                		http.httpRequest({
                            url: '/reg/client/login/getnewzcpwd',
                            data: {"regCode":$("#regcode").val(),"regNo":$("login-regno").val()},
                            success: function (data) {
                                if (data.status == 'success') {
									var liaName = $("#login-lianame").val();//联络员姓名
									var _tel = $("#gttel").val(); //联系电话
      /*                          	layer.msg("验证码已发送至你企业联络员手机号码上，<font color='red'><strong>24</strong></font>小时内有效，过期请重新获取！若3分钟后仍未接收到验证码，请联系工商部门。",{time:5000},function(){});*/
									layer.alert("验证码已发至你企业联络员:<em style='color: red;'>"+liaName+"</em>号码为<em style='color: red'> "+_tel+"</em>的手机上，<em style='color:red;>'> 24</em>小时内有效，过期请重新获取！如无法收到验证码，请联系工商部门。",{icon:6},function(index){layer.close(index)});
									time(_this);//倒计时
                                	_this.removeClass("hq-yzm");
                                }else {
                            		layer.msg("获取验证码失败。",{time:3000},function(){
		                      		});
                                }
                            }
                        });
                	}
            	}
            }
        }
        ])
    }

})