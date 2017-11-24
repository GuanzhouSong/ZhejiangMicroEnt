require(['common/util', 'layer1', 'common/http', 'jquery.validate', 'jquery', 'jquery.serialize', 'common/validateRules','jquery.placeholder','jquery.icinfo'], function (util, layer, http) {
    $('input, textarea').placeholder();
    $('.js-ipt-box').expandInput();
    //执行初始化函数
    init();

    /**
     * 初始化集合
     */
    function init() {
    	//修改时初始化输入框
    	var pasid = $("#pasid").val();
    	if(pasid != null && pasid != ''){
  			$(".ipt-view").removeAttr("readonly","readonly");
  			$(".select-view").removeAttr("disabled","true");
    	}
    	
    	formValid();
        bind();
        initsel();
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
    /**
     * 登录表单验证
     */
    function formValid() {
        $('#phoneApply_form').validate({
            rules: {
                lerepphone: {
                    required: true,
                    checkMobile: true
                },
                lianame: {
                    required: true,
                    maxlength:50   
                },
                liaidnum: {
                    required: true,
                    idCard: true,
                    maxlength:50
                },
                tel: {
                    required: true,
                    checkMobile: true
                },
                checkCode: {
                    required: true
                }
            },
            messages: {
                lerepphone: {
                    required: '手机号码不能为空'
                },
                lianame: {
                    required: '联络员不能为空',
                    maxlength:'姓名不能大于50位'
                },
                liaidnum: {
                    required: '联络员证件号不能为空',
                    maxlength:'号码不能大于50位'
                },
                tel: {
                    required: '手机号码不能为空'
                },
                checkCode: {
                    required: '验证码不能为空'
                }
            },
            wrapper: 'span',
            errorElement: 'label',
            errorClass: 'tip',
            errorPlacement: function (error, element) {
                var el = element.closest('.ipt-box');
                var error = error.prepend('<i class="icon-tip"></i>');
                error.insertAfter(el);
            },
            onkeyup:false,
            onfocusout:function(el){
                $(el).valid();
            },
            submitHandler: function (form) {
                var formParam = $(form).serializeObject();
                debugger
//                console.log(formParam);
                var lerep = formParam.lerep;
                var lerepphone = formParam.lerepphone;
                var lianame = formParam.lianame;
                var tel = formParam.tel;
                if((lerep != lianame) && (lerepphone == tel) ){
                  $("#tel-span").show();
                  $("#tel-error").show().html('法定代表人与联络员不为同一人，两者手机号码也需不一样');
                  $(".tel-tip").show();
                  return;
                }else{
                  $(".tel-tip").hide();
                  $("#tel-span").hide();
                  $("#tel-error").hide();
                  http.httpRequest({
                      url: '/reg/client/login/phoneapply/save',
                      type: 'post',
                      data: formParam,
                      success: function (data) {
                          var pasId = '';
                          if (data.status == 'success') {
                          	pasId = data.data;
                              if (data.msg == '0') {
                                  layer.msg("修改成功",{time:2000},function(){
                                  	   location.assign('/reg/client/login/phoneapply/view?pasID=' + pasId );
                                  });
                              }
                              if (data.msg == '2') {
                              	 layer.msg("保存成功",{time:2000},function(){
                              		 location.assign('/reg/client/login/phoneapply/view?pasID=' + pasId );
                              	 });
                              }
                          } else {
                              alert(data.msg);
                          }
                          $('.js-checkcode').trigger('click');
                      }
                  });
                }

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
            el: '.js-checkcode',
            event: 'click',
            handler: function () {
                $('.js-check-img').attr('src', '/captcha?t=' + Math.random());
            }
        },
        {
        	// 联络员备案统一代码/注册号校验
        	el: '#regcode',
            event: 'blur',
            handler: function () {
            	var _regno = $.trim($("#regcode").val());
            	if(_regno == "" || _regno.length <= 6) {
            		$("#regcode-error").show().html('请输入正确的注册号或者统一代码');
                    $("#regcode-span").show();
                    return ;
            	}else{
            		$("#regcode-span").hide();
	            	http.httpRequest({
	            		url: '/reg/client/login/phoneapply/checkPhoneApply',
	                    data: {pasentkey : _regno, encatge :  window._CONFIG._entage},
	                    success: function (data) {
	                        if (data.status == 'success') {
//                                debugger
	                        	var midBaseInfo = data.data;  //得到midBaseinfo 对象
                                $("#regno").val(midBaseInfo.regNO);
                                $("#unicode").val(midBaseInfo.uniCode);
                                $("#pripid").val(midBaseInfo.priPID);
                                $("#lerep").val(midBaseInfo.leRep);	                        	
                                $("#entName").val(midBaseInfo.entName);
                                $("#enttype").val(midBaseInfo.entType);
                      			$(".ipt-edit").removeAttr("readonly","readonly");
                      			$(".select-edit").removeAttr("disabled","true");
	                        }else {
//	                        	debugger
	                        	//跳转到信息错误提示框
	                        	if (data.msg) {
	                                $("#regno").val('');
	                                $("#unicode").val('');
	                                $("#pripid").val('');
	                                $("#lerep").val('');	                        	
	                                $("#entName").val('');
	                                $("#enttype").val('');
	                      			$(".ipt-edit").attr("readonly","readonly");
	                      			$(".select-edit").attr("disabled","true");
	                        		$("#regcode-error").show().html(data.msg);
	                                $("#regcode-span").show();
	                        	}
	                        }
	                    }
	                });
            	}
            }
        },
        {
        	// 联络员备案统一代码/注册号校验
        	el: '#tel',
            event: 'blur',
            handler: function () {
                $(".tel-tip").hide();
            }
        }
        ])
    }

})