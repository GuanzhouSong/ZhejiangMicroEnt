<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>登录</title>
    <link rel="stylesheet" href="/css/pub-syn.css">
</head>
<body class="outer-bg">
<div class="login-hd border-top7 center">
    <img src="/img/pub-syn/login-logo.png" alt="">
</div>
<div class="log-cont-bg">
    <div class="log-title">
        环保局
    </div>
    <div class="log-box">
        <div class="log-tab-hd js-tab-hd">
            <ul class="clearfix">
                <li class="cur">用户登录</li>
                <li>CA登录</li>
            </ul>
        </div>
        <div class="log-tab-cont js-tab-cont">
            <div class="item user-log">
                <dl>
                    <dd class="user"><input type="text" class="ipt-txt icon" placeholder="用户名"></dd>
                    <dd class="pw"><input type="password" class="ipt-txt icon" placeholder="密码"></dd>
                    <dd class="yzm"><input type="text" class="ipt-txt icon" placeholder="验证码"></dd>
                    <dd class="cz clearfix">
                        <label class="fl"><input type="checkbox">下次自动登录</label>
                        <a href="#" class="fr">忘记密码？</a>
                    </dd>
                    <dd class="btn"><input type="button" value="登   录" class="log-btn" style="margin-right: 9px"><input type="button" value="重   置" class="cz-btn"></dd>
                </dl>
            </div>
            <div class="item ca-log" style="display: none">
                <p class="btn center"><input type="button" value="登   录" class="log-btn"></p>

            </div>
        </div>
    </div>
</div>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script>
    $(function () {
        $('.js-tab-hd li').click(function () {
            $(this).addClass('cur').siblings().removeClass('cur');
            $('.js-tab-cont .item').eq($(this).index()).show().siblings().hide();
        })
    })
</script>
</body>
</html>