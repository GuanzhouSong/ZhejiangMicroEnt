<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>良好信息公示公告页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/pub.css"/>"/>
</head>
<style type="text/css">
.table-other td {
    border: 1px solid #edeeee;
    padding: 10px 5px;
    color: #666;
}
.checkcss {
    background-color: #eae3db;
    font-weight: bold;
    text-align: right;
    color: #87550F;
    text-align: center;
}
</style>
<body class="enterprise-info-bg">
<jsp:include page="../common/noticeheader.jsp"></jsp:include>
<div class="mb20">
    <div class="mod mod-notice-detail">
        <div class="mod-notice-hd mod-hd mt20">
            <h3>${title }公示</h3>
        </div>
        <div class="mod-notice-bd" style="margin-top: 10px;padding-bottom: 10px;">
            <table class="table-other" border="0" cellspacing="0" cellpadding="0" width="98%">
                <tr>
                    <td width="20%" class="checkcss" style="color:#87550F">统一社会信用代码/注册号</td>
                    <td width="30%">${!empty favorAbleInfo.uniSCID?favorAbleInfo.uniSCID:favorAbleInfo.regNO}</td>
                    <td width="15%" class="checkcss" style="color:#87550F">企业名称</td>
                    <td width="35%">${favorAbleInfo.entName }</td>
                </tr>
                <tr>
                    <td width="20%" class="checkcss" style="color:#87550F">评定级别</td>
                    <td width="30%">
                    	<c:if test="${favorAbleInfo.licZone=='0' }">国家级</c:if>
                    	<c:if test="${favorAbleInfo.licZone=='1' }">省级</c:if>
                    	<c:if test="${favorAbleInfo.licZone=='2' }">市级</c:if>
                    	<c:if test="${favorAbleInfo.licZone=='3' }">县级</c:if>
                    	<c:if test="${favorAbleInfo.licZone=='4' }">AAA</c:if>
                    	<c:if test="${favorAbleInfo.licZone=='5' }">AA</c:if>
                    	<c:if test="${favorAbleInfo.licZone=='6' }">A</c:if>
                    </td>
                    <td width="15%" class="checkcss" style="color:#87550F">认定发布部门</td>
                    <td width="35%">${favorAbleInfo.regDeptCn }</td>
                </tr>
                <tr>
                    <td width="20%" class="checkcss" style="color:#87550F">公示时间</td>
                    <td width="30%"><fmt:formatDate pattern="yyyy-MM-dd" value="${favorAbleInfo.regDate }" /></td>
                    <td width="15%" class="checkcss" style="color:#87550F">有效期至</td>
                    <td width="35%">
                    	<fmt:formatDate pattern="yyyy-MM-dd" value="${favorAbleInfo.regTo }" />
            		</td>
                </tr>
                <tr>
                    <td width="20%" class="checkcss" style="color:#87550F">认定发布年度</td>
                    <td width="30%">${favorAbleInfo.regYear }</td>
                    <td width="15%" class="checkcss" style="color:#87550F">认定类别</td>
                    <td width="35%">
                    	${favorAbleInfo.regType}
                    </td>
                </tr>
             </table>
        </div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>