<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="midBaseInfoDto" value="${sessionScope.midBaseInfoDto}"/>
<c:set var="yearReportFlag" value="${sessionScope.yearReportFlag}"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>
<div class="banner-bg">
    <div class="mod banner">
        <h4>欢迎您！${midBaseInfoDto.entName}</h4>
        <p>
            <em class="register-office">登记机关：${midBaseInfoDto.regOrgName}</em>
            <c:if test="${!empty midBaseInfoDto.uniCode}"><em>统一社会信用代码：${midBaseInfoDto.uniCode}</em></c:if>
            <em>注册号：${midBaseInfoDto.regNO}</em>
        </p>
    </div>
</div>

<div style="text-align: center;margin-top: 50px;margin-bottom: 50px">
    <img width="800" height="750" src="data:image/png;base64,${erEscAppinfo.commitment}" alt="" >
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>