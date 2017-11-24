require([
	'common/util',
	'layer1',
	'common/http',
	'jquery.validate',
	'jquery',
	'jquery.serialize',
	'jquery.placeholder',
	'jquery.icinfo'
], function (util, layer, http) {
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
    }
    
    //初始化错误页面
    function initError(){
    	if(window._CONFIG.error != ''){
    		$(".fl .data-log-show").hide();
        	$(".fl .fr-tab.wro-state.common").show();
    	}
    }
    
    //手机验证码获取倒计时
    var wait = 60;//时间
    function time(btn) {
    	var btn=$(btn);
    	if (wait == 0) { 
    		btn.text('获取验证码');//显示按钮
    		//绑定获取验证码事件
    		btn.addClass("js-yzm");
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
        	// 进入政务服务网登录提示框
            el: '.cas', 
            event: 'click',
            handler: function () {
            	$(".fl .data-log-show").hide();
            	$(".fl .fr-tab.data-tab").show();
            }
        },{
        	// 跳转到政务服务网
        	el: '#caslogin',
            event: 'click',
            handler: function () {
            	var url = window._CONFIG.casServer + window._CONFIG.webServer + "/reg/client/login/cas/1";
            	window.location.href = url;
            }
        },{
        	// 返回证书登录框
        	el: '.oauth-goback',
            event: 'click',
            handler: function () {
            	$(".fl .fr-tab").hide();
            	$(".fl .data-log-show").show();
            }
        },{
        	// 返回联络员登录框
        	el: '.goback, .backlogin',
            event: 'click',
            handler: function () {
            	$(".fr .fr-tab").hide();
            	$(".fr .fr-tab.log-tab").show();
            }
        },{
        	// 申领证书
        	el: '.free-apply,.keyapply',
            event: 'click',
            handler: function () {
            	window.open ('http://www.icinfo.cn/html/Newleader.jsp','_blank');
            }
        },{
        	// 在线客服
        	el: '.pdr20',
            event: 'click',
            handler: function () {
            	window.open ('http://www.icinfo.cn/html/service.action','_blank');
            }
        },{
        	// 联络员登录统一代码/注册号校验
        	el: '#regno',
            event: 'blur',
            handler: function () {
            	var _regno = $.trim($("#regno").val());
            	if(_regno == "" || _regno.length <= 6) {
            		$('.js-log-tip.regno').show();
                    setTimeout(function(){
                        $('.js-log-tip').hide();
                    },3000);
                    return;
            	}else{
	            	$(".fr .fr-tab").hide();
	            	$(".fr .ipt-txt").not($(".ipt-txt").first()).val(''); // 清空输入框
	            	$(".fr-tab.loading").show();
	            	http.httpRequest({
	                    url: '/reg/client/login/getinfo',
	                    data: {regno : $.trim($("#regno").val()), type : '1'},
	                    success: function (data) {
	                    	$(".fr .fr-tab").hide();
	                        if (data.status == 'success') {
	                        	// 有联络员
	                        	if (data.data.lia == 'true') {
	                        		$("#entname").val(data.data.entname);
	                        		$("#lianame").val(data.data.lianame);
	                        		$("#liaidnum").removeAttr("readonly");
//	                        		if (data.data.cert == 'true') {
	                            		// 有证书: 跳转证书登录框
//	                            		$(".fr .fr-tab.apply-state.has-aly-login").show();
//	                                }else {
	                                	// 没证书: 返回登录框继续登录
	                                	$(".fr .fr-tab.log-tab").show();
//	                                }
	                            }else {
	                            	// 没联络员: 跳转到信息错误提示框
	                            	$(".fr .fr-tab.wro-state.wro-info").show();
	                            }
	                        }else {
	                        	//跳转到信息错误提示框
	                        	if (data.msg) {
	                        		$("#errorinfo").html(data.msg);
	                        	}
	                        	$(".fr .fr-tab.wro-state.common").show();
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
            		$('.js-log-tip.liaidnum').show();
                    setTimeout(function(){
                        $('.js-log-tip').hide();
                    },3000);
                    return;
            	}else{
            		$(".fr .fr-tab").hide();
                	$("#tel").val(''); // 清空手机号输入框
                	$(".fr .fr-tab.loading").show();
                	http.httpRequest({
                        url: '/reg/client/login/liainfo',
                        data: {liaidnum : $.trim($("#liaidnum").val())},
                        success: function (data) {
                        	$(".fr .fr-tab").hide();
                            if (data.status == 'success') {
                            	$("#tel").val(data.data);
                                // 返回登录框继续登录
                            	$(".fr .fr-tab.log-tab").show();
                            }else {
                            	//跳转到信息错误提示框
                            	if (data.msg) {
                            		$("#errorinfo").html(data.msg);
                            	}
                            	$(".fr .fr-tab.wro-state.common").show();
                            }
                        }
                    });	
            	}
            }
        },{
        	// 获取手机验证码, 发送短信
        	el: '.js-yzm',
            event: 'click',
            handler: function () {
            	if($.trim($("#tel").val()) == "") {
            		$('.js-log-tip.tel').show();
                    setTimeout(function(){
                        $('.js-log-tip').hide();
                    },3000);
                    return;
            	}else{
            		var _this = $(this);
                	$(".fr .fr-tab").hide();
                	if($("#tel").val() != "") {
                		http.httpRequest({
                            url: '/reg/client/login/getnewpwd',
                            data: {},
                            success: function (data) {
                                if (data.status == 'success') {
                                	$("#errorinfo").html("验证码已发送至你企业联络员手机号码上，<font color='red'><strong>24</strong></font>小时内有效，过期请重新获取！若3分钟后仍未接收到验证码，请联系工商部门。");
                                	time(_this);//倒计时
                                	_this.removeClass("js-yzm");
                                }else {
                            		$("#errorinfo").html("获取验证码失败。");
                                }
                            }
                        });
                	}
                	$(".fr .fr-tab.wro-state.common").show();
            	}
            }
        },{
        	// 联络员登录
        	el: '.js-log-yz',
            event: 'click',
            handler: function () {
            	$('.js-ipt-box').expandInput();
                //联络员登录为空验证
            	var flag = true;
            	$('.js-ipt-box').each(function(){
            		if($(this).find('input').val() == '') {
            			flag = false;
            			$(this).find('.js-log-tip').show();
            			setTimeout(function(){
                            $('.js-log-tip').hide();
                        },3000);
            		}
            	});
            	if(!flag){
            		return false;
            	}
            	var formParam = $("#login-form").serializeObject();
                http.httpRequest({
                    url: '/reg/client/login/pwd',
                    type: 'post',
                    data: formParam,
                    success: function (data) {
                    	if (data.status == 'success') {
                            location.assign('/reg/client/yr/yrregcheck/ent/index_list');
                            return;
                        }else {
                        	$("#errorinfo").html(data.msg);
                        	$(".fr .fr-tab").hide();
                        	$(".fr .fr-tab.wro-state.common").show();
                        }
                    }
                });
            }
        },{
        	// 企业联络员查询与办理申请（进入页面）
        	el: '#pubphoneapply',
            event: 'click',
            handler: function () {
				//确认联络员登录的跳转至联络员登录填报页
                var url = "/reg/client/login/phoneapply/list?entage=1";
                window.location.href = url;           	
//            	$(".fr .fr-tab").hide();
//            	if($("#regno").val() != ""){
//            		$("#entRegNo").val($("#regno").val());
//            	}
//            	$(".fr .fr-tab.apply-tab").show();  //联络员查询备案页面显示
            }
        },{
        	// 企业联络员查询与办理申请（查询与备案申请页）
        	el: '#checkPhoneapply',
            event: 'click',
            handler: function () {
            	var _entRegNo = $.trim($("#entRegNo").val());
            	if(_entRegNo != "" && _entRegNo.length > 6){  //注册号或统一代码不为空
            		$(".fr .fr-tab").hide();
                	$(".fr .fr-tab.loading").show();
            		http.httpRequest({
            		   url: '/reg/client/login/phoneapply/checkPhoneApply',
            		   data: {pasentkey :$("#entRegNo").val(),encatge : 1},
            		   success: function(data){
            			   debugger
            			   $(".fr .fr-tab").hide();
            			   if(data.status == 'success'){
            	            $(".fr .fr-tab.apply-tab").hide();  //联络员查询备案页面显示
            				   regNo = data.data;
//            				   if(data.msg == '1'){ ////已认领证书及确认过联络员
//            					   $(".fr .fr-tab.apply-state.has-aly.phoneApply").show();
//            				   }
//            				   if(data.msg == '2'){ //已认领证书未认领联络员 
//            					   $(".fr .fr-tab.apply-state.has-aly.phoneApply").show();
//            				   }
//            				   if(data.msg == '3'){ //未认领证书及确认过联络员
//            					   $(".fr .fr-tab.apply-state.no-aly").show();
//            				   }
//            				   if(data.msg == '4'){ //未认领证书未认领联络员
//            					   $(".fr .fr-tab.apply-state.no-aly").show();
//            				   } 
            				//确认联络员登录的跳转至联络员登录填报页
        	                var url = "/reg/client/login/phoneapply/list?regNo=" +regNo+ "&entage=1";
        	                window.location.href = url;
            			   }else{
            				   if(data.errorcode == '0'){//用户不在本系统范围内，请确认输入信息是否正确
            					   $(".fr .fr-tab.wro-state.not-info").show(); 
            				   }
            				   else{ //其他情况错误信息提示按返回错误信息
                               	$("#phoneApplay").html(data.msg);
                                  $(".fr .fr-tab.wro-state.not-info").show();
            				   }
            			   }
            		   }
            		});           		
            	}else{
     			   $(".ipt-tip.js-log-tip1").show();
     			   setTimeout(function(){
                   $('.ipt-tip.js-log-tip1').hide();
                   },2000)

				   }
            	}
            },
            {
            	// 查询办理注册号输入框的市区焦点事件
            	el: '#entRegNo',
                event: 'blur',
                handler: function () {
                	var _entRegNo = $.trim($("#entRegNo").val());
                	if(_entRegNo == "" || _entRegNo.length < 6 ){
                		$(".ipt-tip.js-log-tip1 ").show();
          			   setTimeout(function(){
                        $('.ipt-tip.js-log-tip1 ').hide();
                        },2000)
                	}
                }
            },
            {
            	// 返回查询框
            	el: '.gobcakphone',
                event: 'click',
                handler: function () {
                	$(".fr .fr-tab.wro-state.not-info").hide();
                	$(".fr .fr-tab.apply-tab").show();
                }
            }
        ])
    }
    
})