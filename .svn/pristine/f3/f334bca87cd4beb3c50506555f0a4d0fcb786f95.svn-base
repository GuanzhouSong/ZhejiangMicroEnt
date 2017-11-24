<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>系统登录页面</title>

    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <link rel="shortcut icon" href="../img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/syn.css">

    <script>
        //失效自动跳转到顶层登录页面
        if (top.location != self.location) {
            top.location = "<c:url value='/'/>";
        }
    </script>
</head>

<body>
<div class="log-hd-bg">
    <div class="log-hd mod"><a href="#" class="ml60"><img src="../../img/syn/xt-hd-logo.png" alt="" class="mt25"></a>
    </div>
</div>
<div class="log-cont-bg">
    <div class="log-cont">
        <h3 class="center pdb60"><img src="../../img/syn/xt-cont-logo.png" alt=""></h3>
        <div class="log-box clearfix">
            <div class="user-log">
                <form id="login-form">
                    <h4>
                        <i class="xt-icon"></i>用户登录
                        <i class="triangle-icon"></i>
                    </h4>
                    <a href="###" class="electroniccard-login">
                        电子工作证登录
                        <i class="enter-icon"></i>
                    </a>
                    <a href="###" class="electroniccard-apply fr">
                        电子工作证申领
                        <i class="arrow-icon"></i>
                    </a>

                    <ul>
                        <li class="user"><input type="text" name="username" id="username"
                                                                       placeholder="请输入用户名"></li>
                        <li class="pw"><input type="password" name="password" id="password"
                                                                     placeholder="请输入密码"></li>
                        <li class="xt-yzm">
                            <input type="text" placeholder="请输入验证码"><span><img src="/captcha?t=0.9532056235676236"
                                                                               alt="" class="js-check-img" width="94px"></span><a
                                href="javascript:void(0);" class="js-checkcode">换一张</a>
                        </li>
                    </ul>
                    <div id="errorContainer" class="ft14"></div>
                    <div><input type="button" id="login" class="btn"  value="确认登录"></div>
                </form>
            </div>
        </div>
    </div>
    <div class="mod log-footer center">
        <div class="other-tip">
            <a href="">收藏本站</a>|
            <a href="">关于信息交换共享平台</a>|
            <a href="">新手指南</a>|
            <a href="">联系我们</a>|
            <a href="">近回首页</a>
            <select>
                <option value="相关链接">相关链接</option>
                <option value="浙江政务服务网">浙江政务服务网</option>
                <option value="国家企业信用信息公示系统">国家企业信用信息公示系统</option>
                <option value="信用浙江网">信用浙江网</option>
                <option value="企业数字证书（电子执照）服务">企业数字证书（电子执照）服务</option>
            </select>
        </div>
        <p>
            主办单位：浙江省人民政府办公厅&nbsp;&nbsp;&nbsp;&nbsp;承办单位：浙江省工商行政管理局<br />
            技术支持：浙江汇信科技有限公司&nbsp;&nbsp;&nbsp;&nbsp;<span class="light-black">技术服务热线：400-888-4636</span>&nbsp;&nbsp;&nbsp;&nbsp;建议使用1366*768分辨率/IE9.0或以上浏览器访问达到最佳效果
    </div>
</div>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/business/synlogin/login_main.js"></script>
</body>
</html>