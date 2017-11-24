<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <title>年报登陆页</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>
<div class="cy-middle">
    <!-- 正文顶部条形匡 -->
    <div class="cy-bigdiv">
        <div class="cy-left cy-titlediv">
            <div class="cy-divheight">
                <div class="cy-title">
                    <div><span>方式一</span>在线电子申报</div>
                </div>
                <form id="login-form">
                    <div class="cy-padding">
                        <p class="cy-onlinep">用户名密码方式申报</p>
                        <p class="cy-btn">首次登录请先获取密码<a href="javascript:void(0);" id="togetPassword" class="verifycodebtn">点击获取密码</a></p>
                        <div class="cy-inputa js-ipt-box">
                            <input type="text" id="regNO" name="regNO" class="cy-input" placeholder="请输入统一代码（无则填注册号）">
                            <span class="log-tip js-log-tip regno">统一代码/注册号出错，请核对后重新输入</span>
                        </div>
                        <div class="cy-inputa js-ipt-box cy-inputaback">
                            <input type="password" id="password" name="password" class="cy-input" placeholder="请输入登录密码">
                            <span class="log-tip js-log-tip pwd">登录密码出错，请核对后重新输入</span>
                        </div>
                        <div class="cy-verify">
                        	验证码 <input id="checkcode" name="checkcode" type="text" maxlength="4" value="" style="width:85px;">
                        	<span><img src="/captcha?t=0.9532056235676236"  class="js-check-img" alt="" style="width:60px; height:26px;" title="看不清？换一张" ></span>
                            <a href="javascript:void(0);" class="js-checkcode">换一张</a>
<!--                         	<img src="/img/reg/client/doReadKaptcha.do;jsessionid=CD3DC56546188BFEAD100D3B461EA5BF" id="kaptchaImg" title="看不清？换一张" style="width:60px; height:26px;"> -->
                        </div>
                        <div class="cy-register"><a href="javascript:void(0);" id="login" >登录</a>
                        </div>
                    </div>
                </form>
                <p class="cy-forgrtpassword"><a id="forgetPwd">忘记密码</a></p>
                <div class="cy-imaginary"></div>
                <p class="cy-digital-certificate">数字证书方式申报</p>
                <form id="caloginForm">
                    <a href="javascript:void(0);" class="cy-singlecertificate" id="keyLogin">
                    <img src="/img/reg/client/03.fw.png;jsessionid=CD3DC56546188BFEAD100D3B461EA5BF"></a>
                </form>
                <p class="cy-querycertificate">
                	<a id="openNewLeader" href="javascript:void(0);" target="_blank" class="keyapply">数字证书新领查询与办理</a>
                	<img src="/img/reg/client/05.fw.png;jsessionid=CD3DC56546188BFEAD100D3B461EA5BF">
               	</p>
            </div>
        </div>
        <div class="cy-central cy-titlediv">
            <div class="cy-divheight">
                <div class="cy-title">
                    <div><span>方式二</span>手机电子申报</div>
                </div>
                <p class="cy-secondstyle-p">请先下载安装个体工商户年报APP</p>
                <p class="cy-secondstyle-p">再进入APP进行相关申报操作</p>
                <div class="cy-imaginary"></div>
                <p class="cy-secondstyle-p cy-download">电脑版下载</p>
                <!--           	<div class="cy-padding-left"><a href="#1" class="cy-download-iphone"></a></div> -->
                <div class="cy-padding-left"><a href="http://120.55.206.115/indreport/indreport_android.apk"
                                                class="cy-download-android"></a></div>
                <div class="cy-imaginary"></div>
                <p class="cy-secondstyle-p cy-download">手机二维码下载</p>
                <div class="cy-padding-left">
                    <!--               <div class="cy-disinblock"> -->

                    <!--                 <p class="cy-text-center">苹果手机版</p> -->
                    <!--               </div> -->
                    <div class="cy-disinblock">
                        <img src="/img/reg/client/indreport_android.png;jsessionid=CD3DC56546188BFEAD100D3B461EA5BF"
                             width="93px" height="93px">
                        <p class="cy-text-center">安卓手机版</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="cy-right">
            <div class="cy-right-top cy-titlediv">
                <div class="cy-divheightright">
                    <div class="cy-title cy-title-right">
                        <div><span>方式三</span>纸质线下申报</div>
                    </div>
                    <p class="cy-offline-pleft">如果你不愿意使用电子申报的方式，可以选择纸质线下申报方式报送年度报告。</p>
                    <p class="cy-offline-pleft">请下载、打印年度报告书，填写完整后由经营者本人签字后，当面报送或通过挂号信邮寄方式提交给核发营业执照的工商（市场监管）部门。</p>
                    <p class="cy-offline-pleft">工商部门在接收纸质年度报告书后10个工作日内，通过企业信用信息公示系统公示报送情况。</p>
                    <div class="cy-imaginary"></div>
                    <p class="cy-offline-img"><a href="javascript:void(0);" onclick="downloadTable();">点击下载纸质年度报告表</a>
                    </p>
                </div>
            </div>
            <div class="cy-link">
                <div class="cy-downlink"><a href="javascript:void(0);"  onclick="downloadDemo();">个体户网上年报操作视频演示</a>
                </div>
                <a href="/indreportcloud/jsp/client/other/note/tip_nb.jsp;jsessionid=CD3DC56546188BFEAD100D3B461EA5BF"
                   class="openByClBox">年报指南</a><a
                    href="/indreportcloud/jsp/client/other/note/note_nb.jsp;jsessionid=CD3DC56546188BFEAD100D3B461EA5BF"
                    class="openByClBox">年报公告</a><a href="http://online.icinfo.cn/eppnet/" target="_blank" class="icon2">证书服务</a><a
                    href="http://www.icinfo.cn/html/service.action" class="icon4" target="_blank">咨询热线</a>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    window._CONFIG = {
    	webServer: '${webServer}',
    	casServer: '${casServer}',
    	error:'${error}'
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/client/login/pblogin_main.js"></script>
</html>