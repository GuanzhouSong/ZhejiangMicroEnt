<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>年报登录页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>
    <div class="mod log-hd">
    <a href="##" target="_blank"><img src="<c:url value="/img/reg/client/reg-c-logo.jpg"/>" alt=""></a>
    <div class="related-link fr">
        相关链接：<a href="http://www.zjzwfw.gov.cn/" target="_blank">浙江政务服务网</a> | <a href="<c:url value='/client/entsearch/toEntSearch'/>" target="_blank">企业信用信息公示系统</a>
    </div>
</div>
    <div class="mod log-cont">
        <div class="clearfix">
            <div class="fl data-log">
                <div class="data-log-show">
                    <h4><i></i>企业数字证书（电子执照）登录</h4>
                    <div class="center log-photo">
                        <img src="/img/reg/client/qyd-electronic-photo.png" alt="">
                        <p>身份认证，电子签名，安全申报</br>
                            一证通用，一键登录，快捷申报</p>
                        <input type="button" class="btn-common btn-orange mr10 keyapply" value="数字证书免费申领">
                        <input type="button" class="btn-common cas" value="登录">
                    </div>
                </div>
                <!-- 政务服务网登录提示 start -->
	            <div class="fr-tab data-tab"  style="display: none">
	                <img src="<c:url value="/img/reg/client/data-zy-logo.jpg"/>" alt="">
	                <span>您正在登录【浙江政务服务网】统一用户认证中心</span>
	                <h3>请确认您已插入企业数字证书 <em>我们将很快为您完成企业的身份认证</em></h3>
	                <input type="button" value="确定" class="btn btn-common" id="caslogin">
	                <a href="javascript:void(0);" class="goback oauth-goback">返回</a>
	            </div>
	            <!-- 政务服务网登录提示 end -->
	            <!-- 通用提示 start -->
	            <div class="fr-tab wro-state common" style="display: none">
	                <h4 class="clearfix left"><i class=""></i>企业数字证书（电子执照）登录</h4>
	                <img src="<c:url value="/img/reg/client/data-wrong.png"/>" alt="" class="pdb6 pdt75">
	                <h3>${error}</h3>
	                <input type="button" value="确定" class="btn btn-common oauth-goback">
	            </div>
	            <!-- 通用提示 end -->
            </div>
            <div class="fr com-log">
                <div class="fr-tab log-tab">
                    <h4 class="clearfix"><i class=""></i>企业联络员登录<a href="javascript:void(0);"  class="fr"  id="pubphoneapply">联络员备案申请</a></h4>
                    <form id="login-form">
                	<input type="hidden" id="systemType" name="systemType" value="1">
                        <div class="usual-log">
                            <ul>
                                <li class="focus-state">
                                    <label>统一代码/注册号：</label><!-
                                    -><div class="ipt-box js-ipt-box">
                                        <input type="text" id="regno" name="regno" value="" class="ipt-txt">
                                        <i class="icon-close"></i>
                                        <span class="log-tip js-log-tip regno">统一代码/注册号出错，请核对后重新输入</span>
                                    </div>
                                </li>
                                <li class="focus-state">
                                    <label>企业名称：</label><!-
                                    -><div class="ipt-box js-ipt-box">
                                        <input type="text" id="entname" name="entname" value="" class="ipt-txt" readonly="readonly">
                                    </div>
                                </li>
                                <li class="focus-state">
                                    <label>联络员姓名：</label><!-
                                    -><div class="ipt-box js-ipt-box">
                                        <input type="text" id="lianame" name="lianame" value="" class="ipt-txt" readonly="readonly">
                                    </div>
                                </li>
                                <li class="focus-state">
                                    <label>联络员证件号：</label><!-
                                    -><div class="ipt-box js-ipt-box">
                                        <input type="text" id="liaidnum" name="liaidnum" value="" class="ipt-txt" readonly="readonly">
                                        <i class="icon-close"></i>
                                        <span class="log-tip js-log-tip liaidnum">联络员证件号出错，请核对后重新输入</span>
                                    </div>
                                </li>
                                <li class="focus-state">
                                    <label>联络员手机号：</label><!-
                                    -><div class="ipt-box js-ipt-box">
                                        <input type="text" id="tel" name="tel" value="" class="ipt-txt" readonly="readonly">
                                        <span class="log-tip js-log-tip tel">联络员手机号出错，请核对后重新输入</span>
                                    </div>
                                </li>
<!--                                 <li class="yzm focus-state"> -->
<!--                                     <label>手机验证码：</label><!- -->
<!--                                     -><div class="ipt-box js-ipt-box"> -->
<!--                                         <input type="text" id="password" name="password" value="" class="ipt-txt yzm"> -->
<!--                                         <i class="icon-close"></i> -->
<!--                                         <em class="log-tip js-log-tip pwd">验证码出错，请核对后重新输入</em> -->
<!--                                     </div> -->
<!--                                     <span class="js-yzm">获取验证码</span> -->
<!--                                 </li> -->
                                <li class="btn pos-rel">
                                    <label></label><input type="button" value="企业联络员登录" class="btn-common js-log-yz">
                                </li>
                            </ul>
                        </div>
                    </form>
                </div>
                <!-- 联络员办理提示 start -->
                <div class="fr-tab apply-tab" style="display: none">
                    <h3>企业联络员查询与备案申请<em>请输入要查询或要备案联络员的企业统一代码/注册号。</em></h3>
                    <p>
                        <lable>统一代码/注册号：</lable>
                        <input type="text" id="entRegNo" name="entRegNo" maxlength="18" class="js-ipt-box1">
                    </p>
                    <p class="pos-rel1">
                        <input type="button" class="btn btn-common js-log-yz1" id = "checkPhoneapply" value="确定"/>
                        <span class="ipt-tip js-log-tip1 entRegNo">统一代码/注册号出错，请核对后重新输入</span>
                        <a href="javascript:void(0);" class="goback">返回</a>
                    </p>
                </div>
                <div class="fr-tab wro-state not-info" style="display: none">
                    <h4 class="clearfix left"><i class=""></i>企业联络员查询与备案申请</h4>
                    <img src="<c:url value="/img/reg/client/data-wrong.png"/>" alt="" class="pdb6 mt40">
                    <h3 id = "phoneApplay">输入信息有误或不属于本系统用户范围！<em>请确认后重新输入。</em></h3>
                    <input type="button" value="确定" class="btn btn-common gobcakphone">
                    <span class="mt38">如贵企业联络员相关事项已变更，应及时向工商登记机关重新办理联络员确认手续。</span>
                </div>
                <div class="fr-tab apply-state has-aly phoneApply" style="display: none">
	                <h4 class="clearfix left"><i class=""></i>企业联络员查询与备案申请</h4>
                    <div>
                        <h3>贵企业有申领企业数字证书。<em>建议使用企业数字证书登录年报系统，更安全更便捷！</em></h3>
                        <p>
                            <input type="button" class="btn-common btn btn-icon oauth" value="企业数字证书登录"/>
                            <a href="javascript:void(0);" class= "phoneApplyBtn">不，继续办理企业联络员确认手续</a>
                        </p>
                    </div>
	                <span>如贵企业联络员相关事项已变更，应及时向工商登记机关重新办理联络员确认手续。</span>
	            </div>
	            <div class="fr-tab apply-state no-aly" style="display: none">
	                <h4 class="clearfix left"><i class=""></i>企业联络员查询与备案申请</h4>
                    <div>
                        <h3>贵企业未申领企业数字证书。<em>建议使用企业数字证书登录年报系统，更安全更便捷！</em></h3>
                        <p>
                            <input type="button" class="btn-common btn btn-icon keyapply" value="申领并使用企业数字证书"/>
                            <a href="javascript:void(0);" class="phoneApplyBtn">不，继续办理企业联络员确认手续</a>
                        </p>
                    </div>
	                <span>如贵企业联络员相关事项已变更，应及时向工商登记机关重新办理联络员确认手续。</span>
	            </div>
                <!-- 联络员办理提示 end -->
				<!-- 联络员登录提示 start -->
                <div class="fr-tab apply-state has-aly-login"  style="display: none">
                    <h4 class="clearfix left"><i class=""></i>企业联络员登录</h4>
                    <div>
                        <h3>贵企业有申领企业数字证书。<em>建议使用企业数字证书登录年报系统，更安全更便捷！</em></h3>
                        <p>
                            <input type="button" class="btn btn-common left oauth" value="企业数字证书登录"/>
                            <a href="javascript:void(0);" class="backlogin">不，继续使用企业联络员方式登录</a>
                        </p>
                    </div>
                    <span>如贵企业联络员相关事项已变更，应及时向工商登记机关重新办理联络员确认手续。</span>
                </div>

                <div class="fr-tab wro-state wro-info"  style="display: none">
                    <h4 class="clearfix left"><i class=""></i>企业联络员登录</h4>
                    <img src="<c:url value="/img/reg/client/data-wrong.png"/>" alt="" class="pdb6 mt30">
                    <h3 class="stress">信息有误！请核对后重新输入。</h3>
                    <input type="button" value="确定" class="btn btn-common backlogin">
                    <h3 class="recommend">推荐使用企业数字证书登录申报</h3>
                    <a href="javascript:void(0);" class="free-apply">免费申领</a>
                    <span>如贵企业联络员相关事项已变更，应及时向工商登记机关重新办理联络员确认手续。</span>
                </div>

                <div class="fr-tab wro-state no-fit-info" style="display: none">
                    <h4 class="clearfix left"><i class=""></i>企业联络员登录</h4>
                    <img src="<c:url value="/img/reg/client/data-no-fit.png"/>" alt="" class="pdb6 mt26">
                    <h3 class="stress">输入的联络员信息与确认信息不一致。</br>无法获取手机验证码！请确认无误后重新输入。</h3>
                    <input type="button" value="确定" class="btn btn-common backlogin">
                    <h3 class="recommend">推荐使用企业数字证书登录申报</h3>
                    <a href="javascript:void(0);" class="free-apply pdb20">免费申领</a>
                    <span>如贵企业联络员相关事项已变更，应及时向工商登记机关重新办理联络员确认手续。</span>
                </div>
                <!-- 联络员登录提示 end -->
                <!-- 通用提示 start -->
                <div class="fr-tab loading" style="display: none">
                    <h4 class="clearfix left"><i class=""></i>企业联络员登录</h4>
                    <span class="loading-tip">正在验证信息，请稍后！</span>
                    <img src="<c:url value="/img/reg/client/loading.png"/>" alt="">
                    <span class="info-tip mt100">如贵企业联络员相关事项已变更，应及时向工商登记机关重新办理联络员确认手续。</span>
                </div>
                <div class="fr-tab wro-state common" style="display: none">
	                <h4 class="clearfix left"><i class=""></i>企业联络员登录</h4>
	                <img src="<c:url value="/img/reg/client/data-wrong.png"/>" alt="" class="pdb6 mt40">
	                <h3 id="errorinfo"></h3>
	                <input type="button" value="确定" class="btn btn-common goback">
	            </div>
                <!-- 通用提示 end -->
            </div>
            <span class="center-line"></span>
        </div>
    </div>
    <div class="mod">
        <div class="other-info">
            <P>
                <a href="<c:url value="/reg/client/login/bulletins/list"/>" target="_blank"><i class="notice-icon"></i>通知公告</a>
                <a href="<c:url value="/reg/client/login/help"/>" target="_blank"><i class="help-icon"></i>填报帮助</a>
                <a href="<c:url value="/reg/client/login/ques"/>" target="_blank"><i class="question-icon"></i>常见问题</a>
                <a href="<c:url value="/reg/client/login/phoneapply/diliverinfo"/>" target="_blank"><i class="consult-icon"></i>工商部门咨询电话</a>
                <a href="http://online.icinfo.cn/eppnet/" target="_blank"><i class="server-icon"></i>企业数字证书服务</a>
            </P>
        </div>
    </div>
    <script>
    //参数的传递
    window._CONFIG = {
    		webServer: '${webServer}',
    		casServer: '${casServer}',
            error:"${error}"
    }

	</script>
    <jsp:include page="../common/footer.jsp"></jsp:include>
    
    <script src="/js/lib/require.js"></script>
	<script src="/js/config.js"></script>
	<script src="/js/reg/client/login/login_main.js"></script>
</body>
</html>