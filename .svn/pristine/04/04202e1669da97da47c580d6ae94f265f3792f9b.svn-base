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
    <title>行政处罚公告页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/pub.css"/>"/>
</head>
<body class="enterprise-info-bg">
<jsp:include page="../common/noticeheader.jsp"></jsp:include>
<div class="mb20">
    <div class="mod mod-notice-detail">
        <div class="mod-notice-hd mod-hd mt20">
            <h3>行政处罚公告</h3>
        </div>
        <div class="mod-notice-bd" style="padding: 30px;">
            <input type="hidden" id="penType" value=" ${pubOtherpunish.penType}">
            <table class="table-horizontal" border="0" cellspacing="0" cellpadding="0" width="100%">
                <tr>
	                <td width="15%" class="ftd">注册号:</td>
	                <td width="35%">
	                ${pubOtherpunish.regNO}
	                </td>
	                <td width="20%" class="ftd">企业名称:</td>
	                <td width="30%">
	                ${pubOtherpunish.entName}
	                </td>
	            </tr>
	            <tr>
	               <td width="20%" class="ftd">处罚决定书文号:</td>
	                <td width="35%">
	                ${pubOtherpunish.penDecNo}
	                </td>
	                <td width="15%" class="ftd">违法行为类型:</td>
	                <td width="30%">
	                ${pubOtherpunish.illegActType}
	                </td>
	            </tr>
	            <tr>
	              <td class="ftd">行政处罚内容</td>
	              <td colspan="3">
	              ${pubOtherpunish.penContent}
	              </td>
	            </tr>
	            <tr>
	              <td class="ftd">处罚类型</td>
	              <td colspan="3" id="penTypeShow">
	              </td>
	            </tr>
	            <tr>
	               <td width="20%" class="ftd penAm" style="display: none">罚款金额（万元）:</td>
	                <td width="35%" class="penAm" style="display: none">
	                <fmt:formatNumber value="${pubOtherpunish.penAm}" pattern="###,###,###,##0.0000"/>
	                </td>
	                <td width="15%" class="ftd forfAm" style="display: none">没收金额（万元）:</td>
	                <td width="30%" class="forfAm" style="display: none">
	                <fmt:formatNumber value="${pubOtherpunish.forfAm}" pattern="###,###,###,##0.0000"/>
	                </td>
	            </tr>
	            <tr>
	               <td width="20%" class="ftd">处罚决定日期:</td>
	                <td width="35%">
	                <fmt:formatDate value="${pubOtherpunish.penDecIssDate}" pattern="yyyy-MM-dd" />
	                </td>
	                <td width="15%" class="ftd">处罚决定机关:</td>
	                <td width="30%">
	                ${pubOtherpunish.judAuth}
	                </td>
	            </tr>
            </table><br>
        </div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/pub/infobulletin/punish_main.js"></script>
</body>
</html>