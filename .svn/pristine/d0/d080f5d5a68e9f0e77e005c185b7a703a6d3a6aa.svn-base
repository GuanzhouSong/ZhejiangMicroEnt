require(['common/util', 'layer1', 'common/http', 'jquery.validate', 'jquery', 'jquery.serialize', 'common/validateRules','jquery.icinfo'], function (util, layer, http) {

    //执行初始化函数
    init();

    /**
     * 初始化集合
     */
    function init() {
        bind();
    }
 
    
    /*
     * 检查身份证号码
     */
    function checkIDNum() {
  	  if($.trim($("#liaIDNum").val())==""){
  		  if($.trim($("#number_get").val())==""){
      		  layer.msg("请先输入企业注册号",{time:1000},function(){
      			  $("#number_get").focus();
      			  return false;
      		  });
  		  }else {
  			  layer.msg("身份证号码不能为空");
      		  return false ;
  		  }
  	  }else if ($("#cerNO").val()!=$("#liaIDNum").val()){
  	      		layer.msg("身份证号码错误，请重新输入！");
  	      		$("#liaIDNum").val("");
  	      		return false;
  	  }else {
  		  $("#tel").removeAttr("disabled");
  		  return true;
  	  }
    }
    
    //校验企业信息号码
    function checkNum() {
  	  if($.trim($("#number_get").val())==""){
  		  layer.msg("号码不能为空",{time:1000},function(){
  			  $("#number_get").focus();
  		  });
  		  return false;
  	  }else{
  		  var load = layer.load(2);
  		  http.httpRequest({
                url: '/reg/client/login/pbepassword/checkInfo',
                type: 'post',
                data: {number: $("#number_get").val(),
              	  flag:$("#flag").val()},
                success: function (data) {
                	layer.close(load);
                   if(data.msg=="success"){
                	   if(data.MidBaseInfo==""||data.MidBaseInfo==null){
                		   $("#liaName").val("");
            			   $("#entName").val("");
                		   layer.msg("未找到该企业,请先获取密码",{},function(){
                			   $("#number_get").val("");
                			  
                		   });
                	   }else{
                		   
                		   $("#entName").val(data.MidBaseInfo.entName);
                        	 $("#leRep").val(data.MidBaseInfo.leRep);	//企业
                        	 $("#liaName").val(data.MidBaseInfo.liaName); //个体户
                        	 $("#cerNO").val(data.MidBaseInfo.cerNO);
                        	 $("#liaIDNum").removeAttr("disabled");
                	   }
                   }else if(data.msg=="error"){
                  	 layer.msg("请输入正确的号码");
                  	$("#number_get").val("");
                  	$("#entName").val('');
                  	 $("#leRep").val('');	//企业
                	 $("#liaName").val(''); //个体户
                	 $("#cerNO").val('');
                  	$("#number_get").focus();
                  	 return false;
                   }else if(data.msg=="exis"){
                	   layer.msg("已经获取过密码！请点击登录下方的“忘记密码”",{},function(){
                		   var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                           parent.layer.close(index);
                	   });
                	   return false;
                   }else if(data.msg=="noexist"){
                	   layer.msg("企业尚未获取密码,请先获取密码",{},function(){
                		   var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                           parent.layer.close(index);
                	   });
                	   return false;
                   }
                }
            });  
  		  return true;
  	  }
    }
    /**
     * 事件绑定
     */
    function bind() {
    	$("#liaIDNum").blur(function(){
    		checkIDNum();
    	});
    	$("#number_get").blur(function(){
    		checkNum();
    	});
    	
        util.bindEvents([{
            //进入忘记密码页面
            el: '#forgetPwd',
            event: 'click',
            handler: function () {
            	layer.open({
            		type: 2,
            		area: ['800px', '300px'],
            		  title: '忘记密码',
            		  content: "/reg/client/login/pbepassword/toForgetPassword"
            		});   
            }
        },{
        	//进入获取密码页面
        	el: '#togetPassword',
            event: 'click',
            handler: function () {
            layer.open({
              		type: 2,
              		area: ['800px', '350px'],
              		  title: '获取密码',
              		  content: "/reg/client/login/pbepassword/toGetPassword"
              		});   
            }
        },{
        	//插入密码表
        	el: '#getPassword',
        	event: 'click',
	        handler: function () {
	        	if($.trim($("#number_get").val())==""){
	      		  layer.msg("请先输入企业注册号",{time:1000},function(){
	      			  $("#number_get").focus();
	      			  return;
	      		  });}
	        	if(checkIDNum()!=false){
	        		 http.httpRequest({
	                     url: '/reg/client/login/pbepassword/insertPassword',
	                     type: 'post',
	                     data: {number: $("#number_get").val(),
	                     	tel:$("#tel").val()},
	                     success: function (data) {
	                        if(data.msg=="success"){
	                     	   layer.msg("获取成功 ，请注意查收短信", {time: 3000}, function () {
	                         	   var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	                                parent.layer.close(index);
	                     	   });
	                        }else  if(data.msg=="false") {
	                     	   alert("请求失败");
	                        }
	                     }
	                 });
	        	}
	        }
        },{
        	el: '#close',
        	event: 'click',
		    handler: function () {
		    	 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		         parent.layer.close(index);
		    }
        },{   
        	//忘记密码提交
        	el: '#forgetSubmit',
        	event: 'click',
        	handler: function () {
        		if($.trim($("#number_get").val())==""){
			  		 layer.msg("企业信息不能为空");
			  		$("#number_get").focus();
			  		 return;
		  		 }
				 http.httpRequest({
			          url: '/reg/client/login/pbepassword/forgetPassword',
			          type: 'post',
			          data: {number: $("#number_get").val()
			          	},
			          success: function (data) {
			        	  if(data.status=="success"){
			        		  layer.alert("你的新密码为"+data.msg,function(){
			        			  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
			          	         parent.layer.close(index);
			        		  });
			        		 
			        	  }else{
			        		  layer.alert(data.msg,function(){
			        			  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
			         	         parent.layer.close(index);
			        		  });
			        	  }
			          }
				 });
        	}
		},{
			// 用户名密码登录
        	el: '#login',
            event: 'click',
            handler: function () {
            	$('.js-ipt-box').expandInput();
                //登录为空验证
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
                    url: '/reg/client/login/pb/pwd',
                    type: 'post',
                    data: formParam,
                    success: function (data) {
                    	if (data.status == 'success') {
                            location.assign('/reg/client/yr/yrregcheck/pb/index_list');
                            return;
                        }else {
                        	layer.msg(data.msg);
                        }
                        $('.js-checkcode').trigger('click');
                    }
                });
            }
        },{
			// 证书登录
        	el: '#keyLogin',
            event: 'click',
            handler: function () {
                var url = window._CONFIG.casServer + window._CONFIG.webServer + "/reg/client/login/cas/2";
            	window.location.href = url;
            }
        },{
        	// 申领证书
        	el: '.keyapply',
            event: 'click',
            handler: function () {
            	window.open ('http://www.icinfo.cn/html/Newleader.jsp','_blank');
            }
        },{
            el: '.js-checkcode',
            event: 'click',
            handler: function () {
                $('.js-check-img').attr('src', '/captcha?t=' + Math.random());
            }
        }
        ]);
    }
});