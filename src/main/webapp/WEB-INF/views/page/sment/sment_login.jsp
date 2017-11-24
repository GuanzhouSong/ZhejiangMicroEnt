<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>浙江省小微企业云平台</title>
    <link rel="stylesheet" href="/css/sment/sment.server.css">
    <script>
        //失效自动跳转到顶层登录页面
        if (top.location != self.location) {
            top.location = "<c:url value='/'/>";
        }
    </script>
</head>

<body>
<div class="login-bg log-bg">
    <div class="log-cont-wrap">
        <div class="log-cont-top"></div>
        <div class="log-cont-mid">
            <div class="log-cont-bg">
                <div class="log-now">
                    <a href="javascript:;" class="btn-log btn js-log-now"></a>
                </div>
                <div class="log-cont">
                    <div class="log-box clearfix">
                        <div class="work-id-log">
                            <div><a href="javascript:;" id="_elogin" class="btn-log btn">电子工作证登录</a></div>
                            <p>
                                <a href="javascript:;" id="_apply">电子工作证申领</a>
                            </p>
                        </div>
                        <div class="user-log">
                            <div>
                                <form id="login-form">
                                    <div>
                                        <ul>
                                            <li class="user">
                                                <input type="text" name="username" id="username" placeholder="请输入用户名">
                                            </li>

                                            <li class="pw">
                                                <input type="password" name="password" id="password" placeholder="请输入密码">
                                            </li>

                                            <li class="xt-yzm">
                                                <input type="text" name="checkCode" placeholder="请输入验证码"><span>
                                    <img src="/cscaptcha?t=0.9532056235676236" class="js-check-img" alt="" width="94px"></span>
                                                <a href="javascript:void(0);" class="js-checkcode">换一张</a>
                                            </li>

                                        </ul>
                                    </div>
                                    <div class="clearfix">
                                        <div class="fl">
                                            <input type="checkbox" name="rememberpassword" id="rememberpassword" value="1" > 记住密码
                                        </div>
                                        <div id="errorContainer" class="ft14 fr">登录密码不能为空</div>
                                    </div>


                                    <div class="right">
                                        <input style="background-color: #1a407c"  type="button" class="btn-log btn" id="login" value="确认登录" />

                                    </div>
                                </form>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="log-cont-bom"></div>

    </div>
</div>


<div style="position: static!important;" class="mod-1 log-footer center">

    <p class="footer-info" style="line-height: 100px;">
        <span class="mr30">版权所有：浙江省工商行政管理局</span>
        <span class="mr30">技术支持：浙江汇信科技有限公司</span>
        <span class="mr30">客服：400-888-4636</span>
        <span class="mr30">技术：0571-88234769</span>

    </p>

</div>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/sment/sment_login.js"></script>
<script src="/js/common/icinfo-1.0.0.min.source.js"></script>
</body>
</html>