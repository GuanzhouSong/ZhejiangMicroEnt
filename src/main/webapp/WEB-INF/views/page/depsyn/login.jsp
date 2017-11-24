<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        ${param.dep }
    </div>
    <div class="log-box">
        <div class="log-tab-hd js-tab-hd">
            <ul class="clearfix">
                <li class="cur">用户登录</li>
                <li>CA登录</li>
            </ul>
        </div>
        <div class="log-tab-cont js-tab-cont">
        	<form id="login-form">
	            <div class="item user-log">
	                <dl>
	                    <dd class="user"><i class="icon"></i><input type="text" class="ipt-txt" name="username" placeholder="用户名"/></dd>
	                    <dd class="pw"><i class="icon"></i><input type="password" class="ipt-txt" name="password" placeholder="密码"/></dd>
	                    <dd class="yzm"><i class="icon"></i>
	                    	<input type="text" name="checkCode" class="ipt-txt" placeholder="验证码"/>
	                    	
	                    	<img src="/captcha?t=0.9532056235676236" alt="" class="js-check-img" id="check-img">
                    	</dd>
	                    <dd class="cz clearfix pos-rel">
	                        <label class="fl"><input type="checkbox">下次自动登录</label>
	                        <a href="#" class="fr">忘记密码？</a>
                            <div id="errorContainer" class="ft14"></div>
	                    </dd>
	                    <dd class="btn"><input type="submit" value="登   录" class="log-btn" style="margin-right: 9px"><input type="button" value="重   置" class="cz-btn"></dd>
	                </dl>
	            </div>
            </form>
            
            <input type="hidden" id="dep" value="${param.dep}" />
            
            <form id="ca-form" style="display: none">
	            <div class="item ca-log">
	                <p class="btn center"><input type="button" value="登   录" class="log-btn"></p>
	            </div>
            </form>
        </div>
    </div>
</div>
<div class="mod">
    <div class="footer-box mt0">
        <div class="footer">
            <p>版权所有：浙江省工商行政管理局</p>
            <p>年报公示业务咨询电话：010-82691101（年报）&nbsp;&nbsp;&nbsp;&nbsp;技术支持电话：010-82691768（公示）&nbsp;&nbsp;&nbsp;&nbsp;京备xxxxxxxxICP</p>
        </div>
    </div>
</div>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script>
    $(function () {
        $('.js-tab-hd li').click(function () {
            $(this).addClass('cur').siblings().removeClass('cur');
            $('.js-tab-cont form').eq($(this).index()).show().siblings().hide();
        })
        $('#check-img').click(function(){
        	$(this).attr('src', '/captcha?t=' + Math.random());
        })
    })
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/depsyn/login_main.js"></script>
</body>
</html>