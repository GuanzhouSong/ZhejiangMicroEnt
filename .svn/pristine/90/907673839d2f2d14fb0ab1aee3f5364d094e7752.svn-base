<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>主体填报公示信息</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/pub.css"/>"/>
</head>
<body class="info-tb-gray notice-info-top">
<div>
    <div class="mod1366 info-tb-hd border-top9">
        <div class="logo"><a href="http://118.178.31.19/client/entsearch/toEntSearch"></a></div>
    </div>
</div>
<div class="info-tb-cont pos-rel">
    <div class="info-tab-hd pos-rel">
        <ul class="clearfix">
            <li class="cur">电子营业执照登录</li>
            <li>工商联络员登录</li>
        </ul>
        <a href="http://gsxt.zjaic.gov.cn/client/entsearch/toEntSearch" class="turn-back">返回首页</a>
    </div>
    <div class="info-tab-cont">
        <div class="item">
            <div class="ele-yyzz-log">
                <h4>数字证书（电子营业执照）</h4>
                <span>
                    身份认证，电子签名，安全申报 </br>
                    一证通用，一键登录，快捷申报
                </span>
                <p class="data-log-btn">
                    <input type="button" value="免费申领数字证书"  class="keyapply dc-gain-btn">
                    <input  id="caslogin" type="button" value="数字证书登录">
                </p>
            </div>
            <p style="margin: 30px 40px 0;text-indent: 28px;">根据省政府减负工作有关要求，从<span style="color: #f92220;">2017年1月1日</span>起，浙江省对所有在册企业和农民专业合作社（个体工商户除外）统一免费发放法人数字证书（限首次新领用户），同时取消法人数字证书延期、变更等服务费（介质费除外）。尚未领取证书的企业、农民专业合作社可到相关证书服务网点（<a href="http://www.icinfo.cn/station/stationIndex.action?city=%E6%9D%AD%E5%B7%9E&style=s1" target="_blank"><font class="light">查看各地服务网点</font></a>）领取，或致电客服400-888-4636，也可以登录数字证书服务网站（<a href="http://www.icinfo.cn" target="_blank"><font class="light">www.icinfo.cn</font></a>）问询。</p>
        </div>
        <div class="item" style="display: none">
            <form id="login-form">
                <ul class="gslly-log">
                    <li class="clearfix" style="margin-bottom: 17px">
                        <label><span>统一社会信用代码/注册号</span></label>
                        <input type="text" id="regno" name="regno" value="" class="ipt-txt">
                    </li>

                    <li class="clearfix" style="margin-bottom: 25px">
                        <label><span>工商联络员身份证号码</span></label>
                        <input type="text" id="liaidnum" name="liaidnum" value="" class="ipt-txt" readonly="readonly">
                    </li>

                    <li class="clearfix" style="margin-bottom: 23px"><label>
                        <span>企业（个体、农专）名称</span></label>
                        <input type="text" id="entname" name="entname" value="" class="ipt-txt" readonly="readonly">
                    </li>

                    <li class="clearfix" style="margin-bottom: 21px">
                        <label><span>工商联络员姓名</span></label>
                        <input type="text" id="lianame" name="lianame" value="" class="ipt-txt" readonly="readonly">
                    </li>

                    <li class="clearfix" style="margin-bottom: 24px"><label>
                        <span>工商联络员手机号</span></label>
                        <input type="text" id="tel" name="tel" value="" class="ipt-txt" readonly="readonly">
                    </li>

                    <li class="clearfix" style="margin-bottom: 18px">
                        <label><span>验证码</span></label>
                        <input type="text" id="password" name="password" value="" class="ipt-txt yzm"><span
                            class="hq-yzm">获取验证码</span>
                    </li>

                    <li class="log-btn" style="padding-left: 92px">
                        <input type="button" value="登 录" style="margin-right: 52px" class="btn-common js-log-yz">
                        <input type="reset"  value="重 置" style="margin-right: 62px">
                        <input type="button" value="返 回" class="back">
                    </li>

                </ul>
            </form>
        </div>
    </div>
    <div class="app-download">
        <p><span class="light">个体工商户</span>手机报送年报</p>
        <p>请搜索“<span class="light">浙江工商年报</span>”</p>
        <p>或直接扫码下载APP</p>
        <div class="app-android-ewm">
            <img src="/img/pub/android-ewm.png" alt="">
            <p>安卓版</p>
        </div>
        <div class="app-android-ewm" style="margin-top: 6px;">
            <img src="/img/pub/ios-ewm.png" alt="">
            <p>苹果版</p>
        </div>
    </div>
</div>
<div class="info-tip">
    <p class="gsll-tip center">说明：若数字证书已过期，或企业注册信息发生变化，请先在线获取<a href="http://online.icinfo.cn/eppnet/" target="_blank"><font class="light">【数字证书维护服务】</font></a></p>
    <p class="gsll-tip center"  style="display: none;">
        说明：在首次【公示信息填报】之前，请先
        <a id="register" style="cursor: pointer;"><font class="light">【联络员注册】</font></a>，
        若注册信息发生变化请
        <font id="modify" class="light" style="cursor: pointer;">【联络员变更】</font>！
    </p>
</div>
<div class="zj-alert-box">
    <ul>
        <li class="zj-alert-hd">提示框<div id="cancel">X</div></li>
        <li class='zj-alert-cont'></li>
        <li class="zj-alert-footer"><input type="button" value="确定" id="showCertLoginBox"></li>
    </ul>
</div>


    <div class="index-alert-box" id="index-alert" style="display: none">
        <h2>敬告
            <i class="close-item js-close-item"></i>
        </h2>
        <p>根据《企业信息公示暂行条例》的规定，企业、个体工商户、农民专业合作社应当于6月30日前报送并公示年度报告，<span class="light">超过6月30日未年报将被列入经营异常名录（状态）</span>。年报系统自<span class="light">2017年7月1日</span>零时起暂时关闭，<span class="light">2017年7月11日</span>零时重新开放接受企业、个体工商户、农民专业合作社补报年报。在此期间即时信息公示和简易注销公告功能同时关闭。</P>
            <%--<P class="mt28">特此通知！</P>--%>
        <%--<div class="end-sign"><img src="/img/pub/zf-icon.jpg" alt="">浙江省工商行政管理局</div>--%>
    </div>



<script>
    //参数的传递
    window._CONFIG = {
        webServer: '${webServer}',
        casServer: '${casServer}',
        error: "${error}"
    }

</script>
<jsp:include page="../common/footer.jsp"></jsp:include>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/pub/infobulletin/fillpublicinformation_main.js"></script>
</body>
</html>