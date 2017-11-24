<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title></title>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<div class="clearfix">
      <input type="hidden" id="userType" value="${userType }">
    <div>
        <h1 class="h4-title left mt5">股权冻结信息</h1>
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
            <tr>
                <td width="10%" class="center bg-gray">序号</td>
                <td width="15%" class="center bg-gray">被执行人</td>
                <td width="15%" class="center bg-gray">股权数额</td>
                <td width="15%" class="center bg-gray">执行法院</td>
                <td width="20%" class="center bg-gray">协助公示通知书文号</td>
                <td width="15%" class="center bg-gray">状态</td>
                <td class="center bg-gray">详情</td>
            </tr>
            <c:if test="${empty pubJusticeInfoListOne}">
                <tr>
                    <td colspan="7" class="light center">无数据</td>
                </tr>
            </c:if>
            <c:forEach var="pubJusticeInfo" items="${pubJusticeInfoListOne}" varStatus="status">
                <tr>
                    <td class="center"><c:out value="${status.count}"></c:out></td>
                    <td class="center"><c:out value="${pubJusticeInfo.inv}"></c:out></td>
                    <td class="center"><c:out value="${pubJusticeInfo.froAm}"></c:out></td>
                    <td class="center"><c:out value="${pubJusticeInfo.executionCourt}"></c:out></td>
                    <td class="center"><c:out value="${pubJusticeInfo.botRefNum}"></c:out></td>
                    <td class="center">
                        <c:choose>
                            <c:when test="${pubJusticeInfo.frozState =='1'}">冻结</c:when>
                            <c:when test="${pubJusticeInfo.frozState =='2'}">解除冻结</c:when>
                            <c:when test="${pubJusticeInfo.frozState =='3'}">失效</c:when>
                            <c:otherwise>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td class="center">
                        <a href="javascript:void(0);" id="doViewOne" frozState="${pubJusticeInfo.frozState}"
                           UID="${pubJusticeInfo.UID}" priPID="${pubJusticeInfo.priPID}"
                           justiceConNO="${pubJusticeInfo.justiceConNO}">详情</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="">
        <h1 class="h4-title left mt5">股东强制变更信息</h1>
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
            <tr>
                <td width="10%" class="center bg-gray">序号</td>
                <td width="15%" class="center bg-gray">被执行人</td>
                <td width="20%" class="center bg-gray">股权数额</td>
                <td width="20%" class="center bg-gray">受让人</td>
                <td width="20%" class="center bg-gray">执行法院</td>
                <td class="center bg-gray">详情</td>
            </tr>
            <c:if test="${empty pubJusticeInfoListTwo}">
                <tr>
                    <td colspan="7" class="light center">无数据</td>
                </tr>
            </c:if>
            <c:forEach var="pubJusticeInfo" items="${pubJusticeInfoListTwo}" varStatus="status">
                <tr>
                    <td class="center"><c:out value="${status.count}"></c:out></td>
                    <td class="center"><c:out value="${pubJusticeInfo.inv}"></c:out></td>
                    <td class="center"><c:out value="${pubJusticeInfo.froAm}"></c:out></td>
                    <td class="center"><c:out value="${pubJusticeInfo.assInv}"></c:out></td>
                    <td class="center"><c:out value="${pubJusticeInfo.executionCourt}"></c:out></td>
                    <td class="center">
                        <a href="javascript:void(0);" id="doViewTwo" UID="${pubJusticeInfo.UID}"
                           priPID="${pubJusticeInfo.priPID}">详情</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/other/pubjusticeinfo/pubjusticeInfosearch_details_main.js"></script>
</body>
</html>