require(['component/iframeLayer',
         'common/util',
         'common/http', 'jquery.validate', 'jquery', 'jquery.serialize', 'common/validateRules','jquery.placeholder',
         'jquery.icinfo'], function (layer,util, http) {
//    $('input, textarea').placeholder();
//    $('.js-ipt-box').expandInput();
    //执行初始化函数
    init();

    /**
     * 初始化集合
     */
    function init() {
    	
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
    /**
     * 登录表单验证
     */
    function formValid() {
        $('#phoneApply_form').validate({
            rules: {
            	lerep:{
                    required: true
            	},
            	cerNo:{
                    required: true
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
//                var enttype =$("#enttype").val();
//                var encerNo =$("#encerNo").val();
//            	if(enttype == '4531' || enttype == '5430' ){
//            		if(encerNo.indexOf("*") < 0){ //如果显示的加密字符不包含*，说明是改过的
//                        $("#cerNo").val(encerNo);	
//            		}
//            	}
                var entTypeCatg =$("#entTypeCatg").val();
                var encerNo =$("#encerNo").val();
            	if(entTypeCatg == '33' || entTypeCatg == '27' ){
            		if(encerNo.indexOf("*") < 0){ //如果显示的加密字符不包含*，说明是改过的
                        $("#cerNo").val(encerNo);	
            		}
            	}
            	var formParam = $(form).serializeObject();
//            	console.log(formParam);
                  http.httpRequest({
                      url: '/reg/client/login/phoneapply/pubsave',
                      type: 'post',
                      data: formParam,
                      success: function (data) {
                          var pasId = '';
                          if (data.status == 'success') {
                          	pasId = data.data;
                              if (data.msg == '2') {
                              	 layer.msg("保存成功",{time:2000},function(){
//                                debugger
                              		 location.assign('/reg/client/login/phoneapply/pubview?pasID=' + pasId );
                              	 });
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
	                    data: {pasentkey : _regno, encatge : 1},
	                    success: function (data) {
	                        if (data.status == 'success') {
	                        	if(data.msg == '1'){
                            		//关闭当前页面
	                        		$('.cont3').html("数字证书用户可直接在线变更企业联络员信息，无需书面提交《企业联络员信息确认书》，建议领取数字证书后直接在线变更企业联络员。");
	                            	layer.dialog({
	                                    content: $(".tip3"),
	                                    type: 1,
	                                    title: false,
	                                    closeBtn:false,
	                                    area: ['446px','215px']
	                                });
	                        	}
		                        	var pubEppassword = data.data;  //得到pub 对象
	                                $("#regno").val(pubEppassword.regno);
	                                $("#unicode").val(pubEppassword.unicode);
	                                $("#pripid").val(pubEppassword.pripid);
	                                $("#entName").val(pubEppassword.entname);
	                                $("#enttype").val(pubEppassword.enttype);
	                                $("#entTypeCatg").val(pubEppassword.entTypeCatg);
	                                $("#lerepphone").val(pubEppassword.lerepphone);
	                                $("#lerep").val(pubEppassword.lerep);	                        	
	                                $("#cerNo").val(pubEppassword.cerNO);	                        	
	                                $("#encerNo").val(pubEppassword.encerNO);	                        	
	                                $("#oldlianame").val(pubEppassword.lianame);
	                                $("#oldliaidnum").val(pubEppassword.liaidnum);	                        	
	                                $("#oldtel").val(pubEppassword.tel);
	                                if(pubEppassword.entTypeCatg == '33' || pubEppassword.entTypeCatg == '27' ){ //合伙企业放开法定代表人，可以自行输入
	                          			$(".ipt-specical").removeAttr("readonly","readonly");
	                                }else{
	                          			$(".ipt-specical").attr("readonly","readonly");
	                                }
	                                $(".ipt-edit").removeAttr("readonly","readonly");
	                      			$(".select-edit").removeAttr("disabled");
	                        }else {
//	                        	debugger
	                        	//跳转到信息错误提示框
	                        	if (data.msg) {
	                                if(data.errorCode == 'pb2'){
	                            		//关闭当前页面
		                        		$('.cont2').html(data.msg);
		                            	layer.dialog({
		                                    content: $(".tip2"),
		                                    type: 1,
		                                    title: false,
		                                    closeBtn:false,
		                                    area: ['446px','215px']
		                                });
	                                }else if(data.errorCode == 'ent3'){
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
		                                $("#oldlianame").val('');
		                                $("#oldliaidnum").val('');	                        	
		                                $("#oldtel").val('');
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
            el: '#gobacklogin',
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
        },
        {
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
        }
        ])
    }

})