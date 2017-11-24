<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <title>联络员确认书申请页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>
<!-- 头部 -->
<div class="mod header">
    <a href="#" target="_blank">
        <img src="/img/reg/client/reg-c-logo.jpg" alt="">
    </a>
</div>
<div class="mod">
    <div class="mod-hd mb20">
        <div class="title">
            <h3>企业工商联络员备案流程</h3>
        </div>
        <span class="flow-path">
            <span>填写联络员备案表</span>
            <i class="right-arrow"></i>
            <span>打印联络员备案表</span>
            <i class="right-arrow"></i>
            <span>备案表签字盖章</span>
            <i class="right-arrow"></i>
            <span>送达联络员备案表</span>
            <i class="right-arrow"></i>
            <span>工商部门接收备案表</span>
        </span>
    </div>
</div>
<!-- 填写《企业工商联络员确认通知书》 -->
<div class="mod">
    <div class="mod-hd">
        <div class="title">
            <h3>填写《企业工商联络员备案表》</h3>
            <p><span class="light">注：企业联络员信息发生变化或企业名称、企业法定代表人（负责人）发生变更后与企业备案信息不符时，应重新办理联络员备案。</span></p>
        </div>
    </div>
    <div class="mod-bd">
       <form id ="phoneApply_form">
         <input type="hidden" name="pasid" id="pasid" value="${phoneApply.pasid}" class="ipt-txt">
         <div class="content content-advice-note">
            <ul class="advice-note-list">
                 <c:if test="${empty phoneApply}">
		         <input type="hidden" name="regno" id="regno" value="" class="ipt-txt">
		         <input type="hidden" name="unicode" id="unicode" class="ipt-txt">
		         <input type="hidden" name="pripid" id="pripid" value="" class="ipt-txt">
		         <input type="hidden" name="enttype" id="enttype" class="ipt-txt">
                 <li>
                 	<div class="item-name">统一社会信用代码：</div>
                     <div class="item-txt">
                         <div class="ipt-box js-ipt-box">
                             <input type="text" id="regcode" value="" class="ipt-txt" placeholder="无统一社会信用代码则填写注册号" >
                             <i class="icon-close"></i>
                         </div>
                         <span id="regcode-span" style="display: none;"><i class="icon-tip"></i><label id="regcode-error" class="tip" for="regcode" style="display: inline;">请输入正确的注册号或者统一代码</label></span>
                     </div>
                </li>
                <li>
                    <div class="item-name">企业名称：</div>
                    <div class="item-txt">
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="entname" id="entName" class="ipt-txt" readonly="readonly">
                            <i class="icon-close"></i>
                        </div>
                    </div>
                </li>
                <li class="focus-state">
                    <div class="item-name">法定代表人（负责人）姓名：</div>
                    	 <div class="item-txt">
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="lerep" id="lerep" value="${midbaseinfo.leRep}" class="ipt-txt ipt-edit" readonly="readonly">
                            <i class="icon-close"></i>
                        </div>
                    </div>
                </li>
                </c:if>
                <c:if test="${phoneApply != null}">
		         <input type="hidden" name="regno" value="${phoneApply.regno}" class="ipt-txt">
		         <input type="hidden" name="unicode" value="${phoneApply.unicode}" class="ipt-txt">
		         <input type="hidden" name="pripid" value="${phoneApply.pripid}" class="ipt-txt">
		         <input type="hidden" name="enttype" value="${phoneApply.enttype}" class="ipt-txt">
		         <input type="hidden" name="entname" value="${phoneApply.entname}" class="ipt-txt">
                  <li>
                  <c:if test="${not empty phoneApply.unicode}">
                 	<div class="item-name">统一代码：</div>
                    <div class="item-txt">${phoneApply.unicode}</div>
                    </c:if>
		            <c:if test="${not empty phoneApply.regno }&&${empty  phoneApply.unicode}">
		            <div class="item-name">注册号：</div>
                    <div class="item-txt">${phoneApply.regno}</div>
		            </c:if>
                </li>
                <li>
                    <div class="item-name">企业名称：</div>
                    <div class="item-txt">${phoneApply.entname}</div>
                </li>
                    <c:if test="${phoneApply.enttype==33}">
		                <li class="focus-state">
		                    <div class="item-name">法定代表人（负责人）姓名：</div>
		                    	 <div class="item-txt">
		                        <div class="ipt-box js-ipt-box">
		                            <input type="text" name="lerep" value="${phoneApply.lerep}" class="ipt-txt ipt-edit ipt-view">
		                            <i class="icon-close"></i>
		                        </div>
		                    </div>
		                </li>
                    </c:if>
                     <c:if test="${phoneApply.enttype!=33}">
	                     <li>
		                     <div class="item-name">法定代表人（负责人）姓名：</div>
		                    <div class="item-txt">${phoneApply.lerep}</div>
		       			  <input type="hidden" name="lerep" value="${phoneApply.tel}" class="ipt-txt ">
	                    </li>	
                    </c:if>
                </c:if>
                <li class="focus-state">
                    <div class="item-name">法定代表人（负责人）手机号码：</div>
                    <div class="item-txt">
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="lerepphone" id="lerepphone" value="${phoneApply.lerepphone}" class="ipt-txt ipt-edit ipt-view" readonly="readonly">
                            <i class="icon-close"></i>
                        </div>
                    </div>
	               <span class="light-yellow">注：企业法定代表人与企业联络员不为同一人，两者手机号码也需不一样。</span>
                </li>
                <li class="focus-state">
                    <div class="item-name">企业联络员姓名：</div>
                    <div class="item-txt">
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="lianame" id="lianame" value="${phoneApply.lianame}" class="ipt-txt ipt-edit ipt-view" readonly="readonly">
                            <i class="icon-close"></i>
                        </div>
                    </div>
	               <span class="light-yellow">注：企业法定代表人（负责人）与企业联络员可以为同一人。</span>
                </li>
                <li class="focus-state">
                    <div class="item-name">企业联络员证件类型：</div>
                    <div class="item-txt">
                        <div class="ipt-box">
                            <select name="liaidtype" id="liaidtype" class="select-txt select-edit select-view" disabled="disabled" >
			                	<c:forEach items="${Certypes}" var="certype" varStatus="status">
			                		<option value="${certype.code }">${certype.content }</option>
			                	</c:forEach>
                            </select>
                        </div>
                    </div>
                </li>
                <li class="focus-state">
                    <div class="item-name">企业联络员证件号码：</div>
                    <div class="item-txt">
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="liaidnum" id="liaidnum" value="${phoneApply.liaidnum}" class="ipt-txt ipt-edit ipt-view" readonly="readonly">
                            <i class="icon-close"></i>
                        </div>
                    </div>
                </li>
                <li class="focus-state">
                    <div class="item-name">企业联络员手机号码：</div>
                    <div class="item-txt">
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="tel" id="tel" value="${phoneApply.tel}" class="ipt-txt ipt-edit ipt-view" readonly="readonly">
                            <i class="icon-close"></i>
                        </div>
                        <span class="light-yellow">注：请正确填写，以免无法接收系统登录密码。</span>
                    </div>
                    <br>
                </li>
                <li class="focus-state tel-tip" style="display:none;" >
                    <div class="item-name"></div>
                    <div class="item-txt">
                       <span id="tel-span" style="display: none;"><i class="icon-tip"></i><label id="tel-error" class="tip" style="display: inline;">法定代表人与联络员不为同一人，两者手机号码也需不一样。</label></span>
                    </div>
                    <br>
                </li>
                <li class="focus-state">
                    <div class="item-name">验证码：</div>
                    <div class="item-txt">
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="checkcode" value="" class="ipt-txt ipt-txt-small">
                            <i class="icon-close"></i>
                        </div>
                        <div class="item-yzm">
                            <span><img src="/captcha?t=0.9532056235676236"  class="js-check-img" alt=""></span>
                            <a href="javascript:void(0);" class="js-checkcode">换一张</a>
                        </div>
                    </div>
                </li>
                <li class="mt5">
                    <div class="item-name"></div>
                    <div class="item-txt">
                        <input type="submit" value="保存" class="btn-common btn-middle">
                    </div>
                </li>
            </ul>
        </div>
        </form>
    </div>
</div>
<!-- 企业工商联络员信息确认说明 -->
<div class="mod">
    <div class="mod-bd">
        <div class="content explain-liaison">
            <h3 class="e-title">企业工商联络员备案说明</h3>
            <div>
                <p>一、企业年度报告和其他信息（即时信息）的报送采取网上电子化报送方式，公示系统提供两种网上身份验证确认方式：一是使用数字证书直接登录，在线填报保存后即完成年度报告和其他信息的报送、公示。数字证书可至当地行政服务中心“浙江政务服务网实名认证/数字证书发行与服务窗口”或登录汇信网（www.icinfo.cn）免费申领。二是对于无数字证书的企业，需事先办理企业工商联络员及其手机号码的备案手续，公示系统向企业工商联络员的手机发送密码，企业凭该密码登录公示系统报送年度报告或其他信息。
                <p>二、企业工商联络员备案，是非数字证书用户进行身份认证的唯一方式，是进行网上报送、公示年度报告必要环节。否则，企业无法登录浙江省企业信用信息公示系统进行网上报送、公示年度报告和其他企业信息。
                <p>三、备案的基本流程是：①企业进入公示系统，在线填写保存《企业工商联络员备案表》；②打印备案表，由法定代表人（负责人）签字并加盖企业公章（分支机构无公章的，可加盖隶属企业公章），提供联络员身份证复印件；③将备案表提交或挂号邮寄至市场监管局（工商局）；④市场监管局（工商局）接收并于５个工作日内在公示系统完成联络员备案手续，系统自动向联络员发送手机短信告知备案情况。
                <p>四、企业对已经备案的企业工商联络员的报送、公示信息行为负责，企业工商联络员发生变化或企业名称、法定代表人（负责人）发生变更后与企业备案的信息不符时，应当及时向工商行政管理部门重新办理备案手续。
                <p>五、在填写备案表内容时，务必确保填写的企业工商联络员信息无误！若打印后发现有错误的，请修改并重新保存后再打印。
            </div>
        </div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
<script>
    window._CONFIG = {
        _liaidtype:'${phoneApply.liaidtype}' , //获取
        _entage :'${entage}'   //系统类型 1  企业或者及时  2  农专
    }
</script>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/client/login/pubphoneapply_edit.js"></script>
</body>
</html>
