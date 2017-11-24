<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="/css/synzw.css">
    <script>
        //失效自动跳转到顶层登录页面
        if (top.location != self.location) {
            top.location = "<c:url value='/'/>";
        }
    </script>
</head>
<body class="login-bg">
<div class="log-header clearfix">
    <div class="mod pos-rel">
        <h1 class="clearfix"><img src="/img/syn/login/zjs-logo.png" alt="" class="fl"></h1>
        <p class="zwfw-logo"><img src="/img/syn/login/zw-logo.png" alt=""></p>
    </div>
</div>
<div class="log-cont-bg">
    <div class="light-yellow-bg"></div>
    <div class="log-cont">
        <h1 class="login-title"><img src="/img/syn/login/login-title-b.png" alt=""></h1>
        <div class="log-box clearfix">
            <div class="work-id-log fl">
                <h4 class="mb10">电子工作证登录</h4>
                <p><i class="icon-circle">01</i>
                    <span>请先插入电子工作证，再点击确认登录按钮后输入<br>
                    电子工作证密码</span></p>
                <p><i class="icon-circle">02</i><span>如需申领电子工作证请点击<a href="#">我要申领</a></span></p>
                <div><a href="###" class="btn">电子工作证登录</a></div>
            </div>
            <div class="user-log fr">
                <form id="login-form" method="post">
                    <h4>用户名密码登录</h4>
                    <ul>
                        <li class="user"><i class="xt-icon"></i>
                            <input type="text" name="username" id="username" placeholder="请输入用户名">
                        </li>

                        <li class="pw"><i class="xt-icon"></i>
                            <input type="password" name="password" id="password" placeholder="请输入密码">
                        </li>

                        <li class="xt-yzm">
                            <input type="text" name="checkCode" placeholder="请输入验证码"  id="checkCode"><span>
                            <img src="/cscaptcha?t=0.9532056235676236" class="js-check-img" alt="" width="90px"></span>
                            <a href="javascript:void(0);" class="js-checkcode">换一张</a>
                        </li>

                    </ul>
                    <input type='hidden' value='${CSRFToken}' id='csrftoken'>
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

</div>








<div class="mod log-footer center">
    <div class="other-tip">
        <a href="">收藏本站</a>|
        <a href="">关于监管警示系统</a>|
        <a href="<c:url value='/static_page/xszn.jsp'/>" target="_Blank">新手指南</a>|
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
        <span class="mr30">版权所有：浙江省工商行政管理局</span>
<!--         	目前网站访问量  31662741  人次 -->
    </p>
    <p>
        <span class="mr30">技术支持：浙江汇信科技有限公司</span><span>技术服务热线：400-888-4636</span>
    </p>
    <p>
        1366*768分辨率/IE9.0或以上浏览器访问达到最佳效果
    </p>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/business/synlogin/governlogin_main.js"></script>
</body>
</html>
