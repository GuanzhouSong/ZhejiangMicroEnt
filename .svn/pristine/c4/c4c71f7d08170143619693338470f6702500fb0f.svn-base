require([
	'component/iframeLayer',
	'component/dataTable',
	'common/util',
	'common/http',
	'handlebars',
	'pagination',
	'jquery.placeholder',
	'jquery.icinfo'  //'component/sdkGt',
], function (layer, dataTable, util, http, handlebars) {
	$('input, textarea').placeholder();
	$('.js-ipt-box').expandInput();
    init();
    /**
     * 初始化函数集合
     */
    function init() {
		loadSupportInfoTable(0, 10);
    	bind();
    }


	//获取区域的选择

	function loadSupportInfoTable(page, length,callback) {
			var selectValue = $('.selectCode.cur').data("code");
			var nameOrRegNO = $.trim($(".search_input").val());
		 	//if(!nameOrRegNO&&!selectValue){return;}
	    	var params = {nameOrRegNO:nameOrRegNO,regOrg:selectValue};
	        http.httpRequest({
	            url: '/pub/smallentsupport/list.json',
	            data: {start: page*length,length: length,params:params},
				type:'post',
	            success: function (data) {
	            	var itemCount = data.recordsTotal;
	            	 $('#tody_pagination').pagination(itemCount, {
	                     prev_text: '<i class="icon-triangle-left"></i>上一页',
	                     next_text: '下一页<i class="icon-triangle-right"></i>',
	                     num_display_entries: 4,
	                     num_edge_entries: 2,
	                     current_page: page,
	                     link_to: 'javascript:void(0)',
	                     ellipse_text: '...',
	                     first_text: '首页',
	                     last_text: '尾页',
	                     callback:function(page,jq){
	                    	 loadSupportInfoTable(page,10);
	                     }
	                 });
					var handleHelper = handlebars.registerHelper("substr", function(v) {
						return v.length>18?v.substr(0,18)+'...':v;
					});//截取
	                var myTemplate = handlebars.compile($("#supportTemplate").html());
	                $('#supportList').html(myTemplate(data));
	                $("#tody_total").text(itemCount);
	                var pageNum = itemCount%10==0?itemCount/10:Math.ceil(itemCount/10);
	                $("#tody_pageNum").text(pageNum);
	            }
	        });
	    }
	 
	 function bind() {
		 util.bindEvents([
			/* {
				 el: '.search_btn', //搜索
				 event: 'click',
				 handler: function () {
					 loadSupportInfoTable(0, 10);
				 }
			 },*/
			 {
				 el: '.doView',
				 event: 'click',
				 handler: function () {
					 window.open('/pub/smallentsupport/details?pripid='+$(this).data("pripid"));
				 }
			 },
			 {
				 el: '.selectCode', //区域选择
				 event: 'click',
				 handler: function () {
					 $(this).addClass('cur');
					 $("#select_area").find(".selectCode").not($(this)).each(function(){
						 $(this).removeClass('cur');
					});
				 }
			 }
		 ])
	    }

	var handlerPopup = function (captchaObj) {
		// 成功的回调
		captchaObj.onSuccess(function () {
			var validate = captchaObj.getValidate();
			$.ajax({
				url: "../../pc-geetest/validate", // 进行二次验证
				type: "post",
				dataType: "json",
				data: {
					geetest_challenge: validate.geetest_challenge,
					geetest_validate: validate.geetest_validate,
					geetest_seccode: validate.geetest_seccode
				},
				success: function (data) {
					if (data && (data.status === "success")) {
						loadSupportInfoTable(0, 10);
						//$(document.body).html('<h1>登录成功</h1>');
					} else {
						//$(document.body).html('<h1>登录失败</h1>');
					}
				}
			});
		});
		$("#popup-submit").click(function () {
			captchaObj.show();
		});
		// 将验证码加到id为captcha的元素里
		captchaObj.appendTo("#popup-captcha");
		// 更多接口参考：http://www.geetest.com/install/sections/idx-client-sdk.html
	};
	// 验证开始需要向网站主后台获取id，challenge，success（是否启用failback）
	$.ajax({
		url: "../../pc-geetest/register?t=" + (new Date()).getTime(), // 加随机数防止缓存
		type: "get",
		dataType: "json",
		success: function (data) {
			// 使用initGeetest接口
			// 参数1：配置参数
			// 参数2：回调，回调的第一个参数验证码对象，之后可以使用它做appendTo之类的事件
			initGeetest({
				gt: data.gt,
				challenge: data.challenge,
				product: "popup", // 产品形式，包括：float，embed，popup。注意只对PC版验证码有效
				offline: !data.success // 表示用户后台检测极验服务器是否宕机，一般不需要关注
				// 更多配置参数请参见：http://www.geetest.com/install/sections/idx-client-sdk.html#config
			}, handlerPopup);
		}
	});


});
