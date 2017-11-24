require([
	'component/iframeLayer',
	'common/util',
	'common/http',
	'jquery.validate',
	'jquery',
	'jquery.serialize',
	'jquery.placeholder',
	'jquery.icinfo'
], function ( layer, util,http) {
	$('input, textarea').placeholder();
	$('.js-ipt-box').expandInput();
    //执行初始化函数
    init();

    /**
     * 初始化集合
     */
    function init() {
        bind();
        initError();
	/* 暂时关闭弹框提示
		layer.dialog({
			type: 1,
			content: $('#index-alert'),
			title: false,
			closeBtn:false,
			area: ['720px','390px']
		});*/
    }
    
    //初始化错误页面
    function initError(){
    	if(window._CONFIG.error != ''){
    		layer.msg(window._CONFIG.error,{time:5000},function(){
  			  return false;
  		  });
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
     * 事件绑定
     */
    function bind() {
        util.bindEvents([{
        	// 证书登录框切换
            el: '.info-tab-hd li', 
            event: 'click',
            handler: function () {
                $(this).addClass('cur').siblings().removeClass('cur');
                $('.info-tab-cont .item').eq($(this).index()).show().siblings().hide();
				$('.info-tip .gsll-tip').eq($(this).index()).show().siblings().hide();
            }
        },{
        	// 证书登录
        	el: '#caslogin',
            event: 'click',
            handler: function () {
            	var url = window._CONFIG.casServer + window._CONFIG.webServer + "/reg/client/login/casall/0";
            	window.location.href = url;
            }
        },{
        	// 联络员登录统一代码/注册号校验
        	el: '#regno',
            event: 'blur',
            handler: function () {
            	var _regno = $.trim($("#regno").val());

				if(!_regno){
					layer.msg("请输入信息",{time:1000},function(){$("#regno").focus()});//提示和光标定位
					return;
				}

            	if(_regno == "" || _regno.length <= 6) {
                    layer.msg("统一代码/注册号出错，请核对后重新输入。",{time:1000},function(){
            			  $("#regno").select();
            			  return false;
            		  });
            	}else{
					$("#login-form").find(".ipt-txt").not($(".ipt-txt").first()).val(''); // 清空输入框
	            	http.httpRequest({
	                    url: '/reg/client/login/getinfoall',
	                    data: {regno : $.trim($("#regno").val())},
	                    success: function (data) {
	                        if (data.status == 'success') {
	                        	if (data.data.cert == 'true') {
                            		// 有证书: 跳转证书登录框
	                        		$('.zj-alert-cont').html("你企业（农专社）已申领有数字证书，请使用数字证书登录方式报送企业信息。");
	                            	layer.dialog({
	                                    content: $(".zj-alert-box"),
	                                    type: 1,
	                                    title: false,
	                                    closeBtn:false,
	                                    area: ['446px','215px']
	                                });
									//判断只读属性是否存在
									if(!$("#liaidnum").attr("readonly")){
										$("#liaidnum").attr("readonly",true);
									}
                                }else {
                                	// 没证书: 判断联络员
                                	// 有联络员
    	                        	if (data.data.lia == 'true') {
    	                        		$("#liaidnum").removeAttr("readonly");
    	                            }else {
    	                            	if (data.data.isNingBo == true) {
    	                            		layer.msg("你企业（农专社）未确认过企业联络员信息，请先注册企业联络员。",{time:3000},function(){
  	    	                      			    return false;
  	    	                      		  	});
    	                            	}else{
    	                            		layer.msg("信息有误！未办理联络员，请核对后重新输入。",{time:3000},function(){
    	    	                      			return false;
    	    	                      		});
    	                            	}
    	                            }
                                }
	                        }else {
	                        	if(data.errorCode == '0') {
	                        		//跳转到信息错误提示框
	                        		$('.zj-alert-cont').html("2016年1月1日起新设立的企业（农专社）应先领取数字证书后再通过数字证书方式报送企业信息。");
	                            	layer.dialog({
	                                    content: $(".zj-alert-box"),
	                                    type: 1,
	                                    title: false,
	                                    closeBtn:false,
	                                    area: ['446px','215px']
	                                });
	                        	}else if (data.msg) {
	                        		layer.msg(data.msg,{time:5000},function(){
//		                      			  $("#regno").focus();
		                      			  return false;
		                      		});
	                        	}
	                        }
	                    }
	                });
            	}
            }
        },{
        	// 联络员信息校验
        	el: '#liaidnum',
            event: 'blur',
            handler: function () {
            	var _liaidnum = $.trim($("#liaidnum").val());
            	if(_liaidnum == "") {
            		layer.msg("联络员证件号出错，请核对后重新输入。",{time:1000},function(){
//            			  $("#liaidnum").focus();
            			  return false;
            		  	});
            	}else{
                	$("#tel").val(''); // 清空手机号输入框
                	$("#entname").val('');
            		$("#lianame").val('');
                	http.httpRequest({
                        url: '/reg/client/login/liainfoall',
                        data: {liaidnum : $.trim($("#liaidnum").val())},
                        success: function (data) {
                            if (data.status == 'success') {
                            	$("#entname").val(data.data.entname);
                        		$("#lianame").val(data.data.lianame);
                            	$("#tel").val(data.data.tel);
                            }else {
                            	//跳转到信息错误提示框
                            	if (data.msg) {
	                        		layer.msg(data.msg,{time:3000},function(){
//		                      			  $("#liaidnum").focus();
		                      			  return false;
		                      		});
	                        	}
                            }
                        }
                    });	
            	}
            }
        },{
        	// 获取手机验证码, 发送短信
        	el: '.hq-yzm',
            event: 'click',
            handler: function () {
            	if($.trim($("#tel").val()) == "") {
            		layer.msg("联络员手机号出错，请核对后重新输入。",{time:1000},function(){
          			  return false;
          		  	});
            	}else{
            		var _this = $(this);
                	if($("#tel").val() != "") {
                		http.httpRequest({
                            url: '/reg/client/login/getnewpwd',
                            data: {},
                            success: function (data) {
                                if (data.status == 'success') {
									var liaName = $("#lianame").val();//联络员姓名
									var _tel = $("#tel").val(); //联系电话
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
        },{
        	// 联络员登录
        	el: '.js-log-yz',
            event: 'click',
            handler: function () {
                //联络员登录为空验证
            	var flag = true;
            	$("#login-form").find('.ipt-txt').each(function(){
            		if($(this).val() == '') {
            			flag = false;
            			layer.msg("请输入完整信息。",{time:1000},function(){});
            		}
            	});

            	if(!flag){return false;}

            	var formParam = $("#login-form").serializeObject();
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
        },{
        	//返回
        	el: '.back',
            event: 'click',
            handler: function () {
            	window.location.href='http://118.178.31.19/client/entsearch/toEntSearch';
            }
        },{
        	//企业联络员注册
        	el: '#register',
            event: 'click',
            handler: function () {
            	window.open("/reg/client/login/phoneapply/publist?entage=0");
            }
        },{
        	//企业联络员变更
        	el: '#modify',
            event: 'click',
            handler: function () {
            	window.open("/reg/client/login/phoneapply/publist?entage=1");
            }
        },{
        	// 申领证书
        	el: '.keyapply',
            event: 'click',
            handler: function () {
            	window.open ('http://www.icinfo.cn/html/Newleader.jsp','_blank');
            }
        },{
        	// 取消
        	el: '#cancel',
            event: 'click',
            handler: function () {
            	layer.closeAll();
            }
        },{
        	//切换到证书登录框
            el: '#showCertLoginBox',
            event: 'click',
            handler: function () {
            	layer.closeAll();
            	$('.info-tab-hd li').first().addClass('cur').siblings().removeClass('cur');
                $('.info-tab-cont .item').first().show().siblings().hide();
				$('.info-tip .gsll-tip').first().show().siblings().hide();
            }
        },{
			el: '.js-close-item',
			event: 'click',
			handler: function () {
				layer.closeAll();
			}
		}
        ])
    }
    
})