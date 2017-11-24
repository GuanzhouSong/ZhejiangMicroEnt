<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>公示系统公告详情页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/pub.css"/>"/>
</head>
<body class="enterprise-info-bg">
<jsp:include page="../common/noticeheader.jsp"></jsp:include>
<div class="mb20 mt20">
	<div class="mod mod-notice-detail mod-notice-detail2">
		<div class="mod-notice-hd mod-hd">
			<h3>行政处罚公告</h3>
		</div>
		<div class="mod-notice-bd">
			<h1>
				${pubOtherpunish.penDecNo}
			</h1>
		<div class="xzcf-notice">
				<c:if test="${!empty pubOtherpunish.punDecDoc}">
				<p style="text-indent:2em;">${pubOtherpunish.punDecDoc}</p>
				</c:if>
				<c:if test="${empty pubOtherpunish.punDecDoc}">
				<p style="text-indent:2em;">${pubOtherpunish.penContent}</p>
				</c:if>
			</div>
		</div>
		<div  class="mod-notice-fd" style="padding-top: 80px; font-size: 14px;">
			<p>${pubOtherpunish.judAuth}</p>
			<p><fmt:formatDate value="${pubOtherpunish.penDecIssDate}" pattern="yyyy年MM月dd日" /></p>
		</div>
	</div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>