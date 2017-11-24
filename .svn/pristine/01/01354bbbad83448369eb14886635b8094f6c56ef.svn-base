<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>电子营业执照</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/pub.css"/>"/>
</head>
<body class="enterprise-info-bg">
<jsp:include page="../../common/noticeheader.jsp"></jsp:include>
<div class="mod detail-main" style="text-align: center;">
	<div class="tab-panel">
	    <div class="undertaking-img">
	         <c:if test="${elBusinessLicFlag == '1'}">
				<img width="780" height="890" src="data:image/jpeg;base64,${businessLicByte}" alt="" >
			 </c:if>
			 <c:if test="${elBusinessLicFlag != '1'}">
			     <div align="center">
			        <h1 style="color:red;font-size: 2em;font-weight: bold;">该企业未签发电子营业执照</h1>
			     </div>
			 </c:if>
		</div>
	</div>
</div>
<jsp:include page="../../common/footer.jsp"></jsp:include>
</body>
</html>