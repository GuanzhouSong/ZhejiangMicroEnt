<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>主体填报公示信息</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/pub.css"/>"/>
</head>
<body class="enterprise-info-bg notice-info-top">
<div>
    <div class="mod1366 info-tb-hd border-top9">
        <div class="logo"><a href="/client/entsearch/toEntSearch"></a></div>
    </div>
</div>
<div class="mod">
    <form id ="phoneApply_form">       
    <div class="border-box2">
        <table class="table-horizontal2" border="0" cellspacing="0" cellpadding="0" width="100%">
            <tbody>
            <tr>
                <td width="354" class="bg-brown" align="right">统一社会信用代码/注册号*</td>
                <td>
                    ${empty pubPhoneApply.unicode ? pubPhoneApply.regno : pubPhoneApply.unicode}
                </td>
            </tr>
            <tr>
                <td class="bg-brown" align="right">法定代表人（负责人）姓名*</td>
                <td>
                   ${pubPhoneApply.lerep}
                </td>
            </tr>
            <tr>
                <td class="bg-brown" align="right">法定代表人（负责人）证件号码*</td>
                <td>
                   ${pubPhoneApply.cerNO }
                </td>
            </tr>
            <tr>
                <td class="bg-brown" align="right">联络员姓名*</td>
                <td>
                  ${pubPhoneApply.lianame }
                </td>
            </tr>
            <tr>
                <td class="bg-brown" align="right">联络员证件类型*</td>
                <td>
                	<c:forEach items="${Certypes}" var="certype" varStatus="status">
		                <c:if test="${certype.code == pubPhoneApply.liaidtype}">
		                  ${certype.content }
		                </c:if>
                	</c:forEach>
                </td>
            </tr>
            <tr>
                <td class="bg-brown" align="right">联络员证件号码*</td>
                <td>
                    ${pubPhoneApply.liaidnum}
                </td>
            </tr>
            <tr>
                <td class="bg-brown" align="right">联络员手机号码*</td>
                <td>
                   ${pubPhoneApply.tel}
                </td>
            </tr>
            </tbody>
        </table>
        <c:if test="${pubPhoneApply.enttype != '9500' }">        
        <p class="tr-center" style="margin-top: 30px;">
        <a target="_blank" href="/reg/client/login/phoneapply/pubprint?pasID=${pubPhoneApply.pasid}" class="btn">打&nbsp;&nbsp;印</a>
        </p>
        <p style="margin-top: 20px;text-indent: 2em;">请将打印好的《企业工商联络员备案表》，<span class="span-orange">经企业法定代表人（负责人）签字并盖章（企业公章），粘贴联络员身份证复印件后，</span>按照打印的备案表上的地址送达或挂号邮寄至市场监管局（工商局）。</p>
        </c:if>
    </div>
    </form>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
</script>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
</body>
</html>