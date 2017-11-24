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
    <title>联络员确认书预览页面</title>
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
<!-- 查看或打印《企业工商联络员确认通知书》 -->
<div class="mod">
    <div class="mod-hd">
        <div class="title">
            <h3>查看或打印《企业工商联络员备案表》</h3>
            <div class="currency"><a target="_blank" href="/reg/client/login/phoneapply/diliverinfo">确认书送达地址与咨询电话</a></div>
            <p>请将打印好的备案表，<span class="orange">经企业法定代表人（负责人）签字并盖章（企业公章），粘贴联络员身份证复印件后，</span>送达或挂号邮寄至市场监管局（工商局）。</p>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-advice-note">
            <ul class="advice-note-list">
                <li>
                   <div class="item-name">统一代码/注册号：</div>
                    <div class="item-txt">${empty pubPhoneApply.unicode ? pubPhoneApply.regno : pubPhoneApply.unicode}</div>
                </li>
                <li>
                    <div class="item-name">企业名称：</div>
                    <div class="item-txt">${pubPhoneApply.entname }</div>

                </li>
                <li>
                    <div class="item-name">法定代表人（负责人）姓名：</div>
                    <div class="item-txt">${pubPhoneApply.lerep}</div>
                </li>

                <li>
                    <div class="item-name">法定代表人（负责人）手机号码：</div>
                    <div class="item-txt">${pubPhoneApply.lerepphone }</div>
                </li>
                <li>
                    <div class="item-name">企业联络员姓名：</div>
                	  <div class="item-txt">${pubPhoneApply.lianame }</div>
                </li>
                <li>
                    <div class="item-name">企业联络员证件类型：</div>
                    <div class="item-txt">
                      <c:forEach items="${Certypes}" var="certype" varStatus="status">
			                <c:if test="${certype.code == pubPhoneApply.liaidtype}">
			                  ${certype.content }
			                </c:if>
			          </c:forEach>
                    </div>	
                </li>
                <li>
                    <div class="item-name">企业联络员证件号码：</div>
                    <div class="item-txt">${pubPhoneApply.liaidnum}</div>
                </li>
                <li>
                    <div class="item-name">企业联络员手机号码：</div>
                    <div class="item-txt">${pubPhoneApply.tel}</div>
                </li>
            </ul>

            <div class="btn-box">
                <a target="_blank" href="/reg/client/login/phoneapply/print?pasID=${pubPhoneApply.pasid}" class="btn-common btn-print">打 印</a>
                <a href="/reg/client/login/phoneapply/list?pasId=${pubPhoneApply.pasid}" class="modification">修改</a>

            </div>
        </div>
    </div>
</div>
<!-- 企业工商联络员信息确认说明 -->
<div class="mod">
    <div class="mod-bd">
        <div class="content explain-liaison">
            <h3 class="e-title">企业工商联络员备案说明</h3>
            <div>
                <p>一、企业年度报告和其他信息（即时信息）的报送采取网上电子化报送方式，公示系统提供两种网上身份验证确认方式：一是使用数字证书直接登录，在线填报保存后即完成年度报告和其他信息的报送、公示。数字证书可至当地行政服务中心“浙江政务服务网实名认证/数字证书发行与服务窗口”或登录汇信网（www.icinfo.cn）免费申领。二是对于无数字证书的企业，需事先办理企业工商联络员及其手机号码的备案手续，公示系统向企业工商联络员的手机发送密码，企业凭该密码登录公示系统报送年度报告或其他信息。</p>
                <p>、企业工商联络员备案，是非数字证书用户进行身份认证的唯一方式，是进行网上报送、公示年度报告必要环节。否则，企业无法登录浙江省企业信用信息公示系统进行网上报送、公示年度报告和其他企业信息。</p>
                <p>三、备案的基本流程是：①企业进入公示系统，在线填写保存《企业工商联络员备案表》；②打印备案表，由法定代表人（负责人）签字并加盖企业公章（分支机构无公章的，可加盖隶属企业公章），提供联络员身份证复印件；③将备案表提交或挂号邮寄至市场监管局（工商局）；④市场监管局（工商局）接收并于５个工作日内在公示系统完成联络员备案手续，系统自动向联络员发送手机短信告知备案情况。</p>
                <p>四、企业对已经备案的企业工商联络员的报送、公示信息行为负责，企业工商联络员发生变化或企业名称、法定代表人（负责人）发生变更后与企业备案的信息不符时，应当及时向工商行政管理部门重新办理备案手续。</p>
                <p>五、在填写备案表内容时，务必确保填写的企业工商联络员信息无误！若打印后发现有错误的，请修改并重新保存后再打印。</p>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>

<%-- <script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script> --%>


<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="<c:url value="/js/component/dropDown.js"/>"></script>

</body>
</html>
