<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>国家企业信用信息公示系统</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/pub.css"/>"/>
</head>
<body class="zj-search-bg">
<div class="index-banner-bg mod1366">
    <div class="border-top9">
        <div class="mod header-se">
            <h2 class=""><a href="#"><img src="/img/pub/zj-logo.png" alt=""></a></h2>
            <a href="javascript:void(0)" class="area-select locate-icon">导航<b class="pull-down-icon"></b></a>
            <div class="area-box">
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
            <a href="http://118.178.30.4/syn/login" class="local-pd collect-icon" target="_blank">地方频道</a>
        </div>
    </div>
    <div class="se-banner-bg">
        <div class="search-banner"></div>
        <div class="search-cont">
            <div class="select-tab">
                <a id="ent" class="select" onclick="entpub(this)" href="#"
                        <c:if test="${classFlag==1 }">
                            class="select"
                        </c:if>
                >企业信用信息</a>
                <a id="entOpanomaly" onclick="entpub(this)" href="#"
                        <c:if test="${classFlag==2 }">
                            class="select"
                        </c:if>
                >经营异常名录</a>
                <a id="entCrime" onclick="entpub(this)" href="#"
                		<c:if test="${classFlag==3 }">
                            class="select"
                        </c:if>
                >严重违法失信企业名单</a>
            </div>
            <div class="search-do">
                <form action="list" method="get" id="form">
                    <input type="hidden" name="isOpanomaly" id="isOpanomaly">
                    <input type="hidden" name="pubType" id="pubType" value="1">
                    <input type="text" class="se-box" placeholder="请输入企业名称、统一社会信用代码或注册号">
                    <input type="hidden" id="searchKeyWord" name="searchKeyWord">
                    <input type="button" id="popup-submit" value="" class="se-btn">
                </form>
                <div id="popup-captcha"></div>
            </div>
        </div>
        <!-- <div class="note-con">
            <h3>
                公&nbsp;&nbsp;&nbsp;&nbsp;告
            </h3>
            <p>各用户朋友：</p>
            <p>由于省政务云平台进行技术升级改造，本系统将于2017年4月7日18:00~4月9日15:00暂停使用，如造成不便请见谅！</p>
            <div class="left-icon"><span></span></div>
            <div class="right-icon"><span></span></div>
        </div> -->
    </div>
</div>
<div>
    <div class="mod1366 se-other-nav">
        <ul class="clearfix">
            <li><a href="../../pub/infobulletin/index"><em><i class="se-icon gs-info"></i></em><span>信息公告</span></a></li>
            <li><a href="http://118.178.33.191/login"><em><i class="se-icon se-compinfo"></i></em><span>企业信息填报</span></a>
            </li>
            <%--<li><a href="#"><i class="se-icon part-app"></i><span>部门信息交换</span></a></li>--%>
            <li><a href="http://xwqy.gsxt.gov.cn/home?df=33" target="_blank"><em><i
                    class="se-icon xwqy-info"></i></em><span>小微企业名录</span></a></li>
            <li><a href="../../pub/infobulletin/help"><em><i class="se-icon use-help"></i></em><span>使用帮助</span></a></li>
        </ul>
    </div>
</div>
<jsp:include page="../../common/footer.jsp"></jsp:include>
<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/component/tab.js"/>"></script>
<script src="<c:url value="/js/lib/laydate/laydate.js"/>"></script>
<script src="http://static.geetest.com/static/tools/gt.js"></script>
<script src="/js/pub/entinfo/des.js"></script>
<script type="text/javascript" src="http://fwtj.gsxt.gov.cn/js/logcollector.js?nodenum=330000"></script>
<!-- <script src="<c:url value="/js/pub/count/logcollector.js"/>"></script> -->
<script>

    //禁用回车键(Enter)
    document.onkeydown = function () {
        if (window.event && window.event.keyCode == 13) {
            window.event.returnValue = false;
        }
    };
	window.onload = function() {

        var entName = '${entName}'; //获取企业名称
        if(entName){
            $(".se-box").val(entName);
            $("#searchKeyWord").val(entName);
        }

		var sessionId = '<%=request.getSession().getId()%>';
		sessionId_gsxt = sessionId; // 正常情况JS可以拿到sessionId,但经过测试发现有些web服务器，js拿不到sessionId，这种情况需要手动对sessionId进行赋值，如sessionId_gsxt=${sessionId}
		document.cookie=sessionId;
		try{
	        t1Collect_gsxt(); // 收集访问信息，每个页面都需要调用该方法
        }catch(e){
        	
        }
	};

    var msg = "${msg}";
    if (msg != "") {
        alert(msg);
    }

    function entpub(obj) {
        $('.select-tab a').removeClass("select");
        $(obj).addClass("select");
    }

    $('.area-select').on('click', function () {
        $('.area-box').toggle();
    })
    $(document).on('click', function (e) {
        if ($(e.target).closest('.area-select').length == 0 && $(e.target).closest('.area-box').length == 0) {
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
                        if ($('#entOpanomaly').hasClass("select")) {
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
      /*  //ent健问题
        $('#form').on('keydown', function(e) {
    		if (e.keyCode == 13) {
    			var searchKeyword = $(".se-box").val();
                if ($.trim(searchKeyword) == "") {
                    alert("企业名称、统一社会信用代码或注册号不能为空!");
                } else if($.trim(searchKeyword).length<2){
                	alert("请输入至少两个字符!");
                } else {
                	captchaObj.show();
        			return false;
                }
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

</body>
</html>