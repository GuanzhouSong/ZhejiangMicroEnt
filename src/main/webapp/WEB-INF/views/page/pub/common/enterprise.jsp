<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="enterprise-info-top">
    <div class="outer-blue-bg mod1366">
        <div class="mod enterprise-info-header">
            <ul class="enterprise-info-nav">
                <li><a href="../../client/entsearch/toEntSearch"><i class="icon-home"></i>首页</a></li>
                <li><a href="http://118.178.33.191/login"><i class="icon-reported"></i>企业信息填报</a></li>
                <li><a href="../../pub/infobulletin/index"><i class="icon-notice"></i>信息公告</a></li>
                <li><a href="../../pub/infobulletin/help"><i class="icon-help"></i>使用帮助</a></li>
            </ul>
            <a href="#" class="inner-area-select">导航</a>
            <div class="area-box search-box-style">
                <p><a href="http://www.gsxt.gov.cn" class="gjzj">国家企业信用信息公示系统</a></p>
                <p><span>华北</span><a href="http://bj.gsxt.gov.cn">北京</a><a href="http://tj.gsxt.gov.cn">天津</a><a href="http://he.gsxt.gov.cn">河北</a><a href="http://sx.gsxt.gov.cn">山西</a><a href="http://nm.gsxt.gov.cn">内蒙古</a>
                </p>
                <p><span>东北</span><a href="http://ln.gsxt.gov.cn">辽宁</a><a href="http://jl.gsxt.gov.cn">吉林</a><a href="http://hl.gsxt.gov.cn">黑龙江</a></p>
                <p><span>华东</span><a href="http://sh.gsxt.gov.cn">上海</a><a href="http://js.gsxt.gov.cn">江苏</a><a href="http://zj.gsxt.gov.cn">浙江</a><a href="http://ah.gsxt.gov.cn">安徽</a><a href="http://fj.gsxt.gov.cn">福建</a><a href="http://jx.gsxt.gov.cn">江西</a><a href="http://sd.gsxt.gov.cn">山东</a>
                </p>
                <p><span>华南</span><a href="http://gd.gsxt.gov.cn">广东</a><a href="http://gx.gsxt.gov.cn">广西</a><a href="http://hi.gsxt.gov.cn">海南</a></p>
                <p><span>华中</span><a href="http://ha.gsxt.gov.cn">河南</a><a href="http://hb.gsxt.gov.cn">湖北</a><a href="http://hn.gsxt.gov.cn">湖南</a></p>
                <p><span>西南</span><a href="http://cq.gsxt.gov.cn">重庆</a><a href="http://sc.gsxt.gov.cn">四川</a><a href="http://gz.gsxt.gov.cn">贵州</a><a href="http://yn.gsxt.gov.cn">云南</a><a href="http://xz.gsxt.gov.cn">西藏</a>
                </p>
                <p><span>西北</span><a href="http://sn.gsxt.gov.cn">陕西</a><a href="http://gs.gsxt.gov.cn">甘肃</a><a href="http://qh.gsxt.gov.cn">青海</a><a href="http://nx.gsxt.gov.cn">宁夏</a><a href="http://xj.gsxt.gov.cn">新疆</a>
                </p>
            </div>
        </div>
    </div>
    <div class="outer-white-bg mod1366">
        <div class="mod enterprise-info-search clearfix">
            <div class="logo"><a href="#"></a></div>
            <div class="search-content">
                <div class="select-tab">
                    <i class="search-icon"></i>
                    <a id="ent" onclick="entpub(this)" href="#"
                       <c:if test="${classFlag==1}"> class="select"</c:if>
                     >企业信用信息</a>
                    <i class="tab-line"></i>
                    <a id="entopanomaly" onclick="entpub(this)" href="#"
                    	<c:if test="${classFlag==2}"> class="select"</c:if>
                    >经营异常名录</a>
                    <i class="tab-line"></i>
                    <a id="entCrime" onclick="entpub(this)" href="#"
                    	<c:if test="${classFlag==3}"> class="select"</c:if>
                    >严重违法失信企业名单</a>
                </div>
                <div class="search-do">
                    <form action="../../client/entsearch/list" method="get" id="form">
                    	<input type="hidden" name="isOpanomaly" id="isOpanomaly">
                    	<input type="hidden" name="pubType" id="pubType" value="1">
                        <input type="text" class="se-box" placeholder="请输入企业名称、统一社会信用代码或注册号">
                        <input type="hidden" id="searchKeyWord" name="searchKeyWord">
                        <input type="button" id="popup-submit" value="" class="se-btn">
                    </form>
                    <div id="popup-captcha"></div>
                </div>
            </div>
        </div>
    </div>

</div>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="http://static.geetest.com/static/tools/gt.js"></script>
<script src="/js/pub/entinfo/des.js"></script>
<script>

    //禁用回车键(Enter)
    document.onkeydown = function () {
        if (window.event && window.event.keyCode == 13) {
            window.event.returnValue =
                    false;
        }
    };
	
	var msg = "${msg}";
    if (msg != "") {
        alert(msg);
    }

	function entpub(obj,url){
		$('.select-tab a').removeClass("select");
		$(obj).addClass("select");
	}
    $('.inner-area-select').on('click',function () {
        $('.area-box').toggle();
    })
    $(document).on('click',function (e) {
        if($(e.target).closest('.inner-area-select').length==0&&$(e.target).closest('.area-box').length == 0){
            $('.area-box').hide();
        }
    })
    
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
                    	
                        if ($('#entopanomaly').hasClass("select")) {
                            $('#isOpanomaly').val(1);
                        } else if($('#entCrime').hasClass("select")){
                        	$('#isOpanomaly').val(2);
                        } else {
                            $('#isOpanomaly').val("");
                        }
                        var keyword = $(".se-box").val();
                        var encodeKeyword = strEnc(keyword,'a','b','c');
                        $("#searchKeyWord").val(encodeKeyword);
                        $("#form").submit(); 
                    } else {
                        $(document.body).html('<h1>登录失败</h1>');
                    }
                }
            });
        });
      /*  //ent建
        $('#form').on('keydown', function(e) {
        	if (e.keyCode == 13) {
    			return false;
    		}
      	});*/
        $("#popup-submit").click(function () {
            var searchKeyword = $(".se-box").val();
            if ($.trim(searchKeyword) == "") {
                alert("企业名称、统一社会信用代码或注册号不能为空!");
            } else if($.trim(searchKeyword).length<2){
            	alert("请输入至少两个字符!");
            } else {
                captchaObj.show();
            }
        });
        // 将验证码加到id为captcha的元素里
        captchaObj.appendTo("#popup-captcha");
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
</script>