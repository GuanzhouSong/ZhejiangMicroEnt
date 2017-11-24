<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title> 系统登录页面</title>
    <link rel="stylesheet" href="/css/reg.server.css">

    <script>
        //失效自动跳转到顶层登录页面
        if (top.location != self.location) {
            top.location = "<c:url value='/'/>";
        }
    </script>
</head>

<body class="login-bg">
<div class="log-header clearfix">
    <div class="mod">
        <h1><img src="/img/reg/server/login-header-logo.png" alt="" class="fl"></h1>
    </div>
</div>
<div class="log-cont-bg">
    <div class="light-yellow-bg"></div>
    <div class="log-cont">
        <h1 class="login-title"><img src="/img/reg/server/login-title.png" alt=""></h1>
        <div class="log-box clearfix">
            <div class="work-id-log fl">
                <h4 class="mb10">电子工作证登录</h4>
                <p><i class="icon-circle">01</i>
                    <span>请先插入电子工作证，再点击确认登录按钮后输入<br />
                    电子工作证密码</span></p>
                <p><i class="icon-circle">02</i><span>如需申领电子工作证请点击<a href="#">我要申领</a></span></p>
                <div><a href="###" class="btn">电子工作证登录</a></div>
            </div>
            <div class="user-log fr">
                <form id="login-form">
                    <h4>用户名密码登录</h4>
                    <ul>
                        <li class="user"><i class="xt-icon"></i>
                            <input type="text" name="username" id="username" placeholder="请输入用户名">
                        </li>

                        <li class="pw"><i class="xt-icon"></i>
                            <input type="password" name="password" id="password" placeholder="请输入密码">
                        </li>

                        <li class="xt-yzm">
                            <input type="text" name="checkCode" placeholder="请输入验证码"><span>
                            <img src="/cscaptcha?t=0.9532056235676236" class="js-check-img" alt="" width="94px"></span>
                            <a href="javascript:void(0);" class="js-checkcode">换一张</a>
                        </li>

                    </ul>
                    <div id="errorContainer" class="ft14"></div>

                    <div class="right">
                        <input type="button" class="btn" id="login" value="确认登录">
                    </div>
                </form>
            </div>
            <div class="box-shadow"></div>
            <div class="no-border-l"></div>
            <div class="no-border-r"></div>
        </div>
        <!-- <div class="note-con">
            <h3>
                公&nbsp;&nbsp;&nbsp;&nbsp;告
            </h3>
            <p>各位：</p>
            <p>由于省政务云平台进行技术升级改造，本系统将于2017年4月7日18:00~4月9日15:00暂停使用，如造成不便请见谅！</p>
        </div> -->
    </div>
    <%--<span class="mid-height"></span>--%>
</div>
<%--<div class="rel-info">--%>
    <%--<label class="ml20">相关链接：</label>--%>
    <%--<a href="http://www.zjzwfw.gov.cn/" target="_blank" class="mr20"><i class="xt-icon"></i>浙江政务服务网</a>--%>
    <%--<a href="http://www.gsxt.gov.cn/" target="_blank" class="mr20"><i class="xt-icon"></i>国家企业信用信息公示系统</a>--%>
    <%--<a href="http://www.zjcredit.gov.cn/"  target="_blank" class="mr20"><i class="xt-icon"></i>信用浙江网</a>--%>
    <%--<a href="http://www.zj.gov.cn" target="_blank" class="mr20"><i class="xt-icon"></i>浙江省人民政府</a>--%>
<%--<!--     <a href="http://online.icinfo.cn/eppnet/" target="_blank" class="mr20"><i class="xt-icon"></i>企业数字证书（电子执照）服务</a> -->--%>
<%--</div>--%>
<div class="mod log-footer center">
    <div class="other-tip">
        <a href="">收藏本站</a>|
        <a href="">关于监管警示系统</a>|
        <a href="" target="_Blank">新手指南</a>|
        <a href="http://www.icinfo.cn/html/service.action" target="_Blank">联系我们</a>
        <select onchange="if(this.value!='')window.open(this.value);this.options[0].selected=true">
            <option value="相关链接">相关链接</option>
            <option value="http://www.zjzwfw.gov.cn/">浙江政务服务网</option>
            <option value="http://www.gsxt.gov.cn/">国家企业信用信息公示系统</option>
            <option value="http://www.zjcredit.gov.cn/">信用浙江网</option>
            <option value="http://www.zj.gov.cn/">浙江省人民政府网</option>
            <option value="http://118.178.33.191/syn/login/">浙江企业信息交换共享平台</option>
            <!--                 <option value="http://online.icinfo.cn/eppnet/">企业数字证书（电子执照）服务</option> -->
        </select>
    </div>
    <p>
        <span class="mr30">版权所有：浙江省工商行政管理局</span>目前网站访问量  31662741  人次
    </p>
    <p>
        <span class="mr30">技术支持：浙江汇信科技有限公司</span><span>技术服务热线：400-888-4636</span>
    </p>
    <p>
        1366*768分辨率/IE9.0或以上浏览器访问达到最佳效果
    </p>
</div>

<%-- <div class="index-alert-box" id="index-alert" style="display: none">
    <h2>敬告<i class="close-item js-close-item"></i></h2>
    <p>根据《企业信息公示暂行条例》的规定，企业、个体工商户、农民专业合作社应当于6月30日前报送并公示年度报告，<span class="light">超过6月30日未年报将被列入经营异常名录（状态）</span>。年报系统自<span class="light">2017年7月1日</span>零时起暂时关闭，<span class="light">2017年7月11日</span>零时重新开放接受企业、个体工商户、农民专业合作社补报年报。在此期间即时信息公示和简易注销公告功能同时关闭。</P>
    <P class="mt28">特此通知！</P>
    <div class="end-sign"><img src="/img/pub/zf-icon.jpg" alt="">浙江省工商行政管理局</div>
</div> --%>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/business/login/login_main.js"></script>
</body>
</html>