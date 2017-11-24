<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>股权出质登记信息</title>
    <link rel="stylesheet" href="/css/pub.css">
</head>
<body>
<c:if test="${not empty spPledge && (spPledge.status == 'K' || spPledge.status == 'B')}">
<div class="mod-bd-panel_company">
    <h3 class="i-title">
        <i></i>股权出质变更信息
    </h3>
    <table class="table-common">
        <thead>
        <tr>
            <th width="90">序号</th>
            <th width="250">变更日期</th>
            <th>变更内容</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${spPledge.status == 'K'}">
        <tr>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        </c:if>
        <c:if test="${spPledge.status == 'B'}">
        <tr>
            <td>1</td>
            <td><fmt:formatDate value="${spPledge.equPleDate}" pattern="yyyy年MM月dd日"/></td>
            <td></td>
        </tr>
        </c:if>
        </tbody>
    </table>
</div>
</c:if>
<c:if test="${not empty spPledge && spPledge.status == 'X'}">
<div class="mod-bd-panel_company">
    <h3 class="i-title">
        <i></i>股权出质注销信息
    </h3>
    <table class="table-common table-zichan table-punishdetail">
        <tbody>
        <tr>
            <td width="190">注销日期</td>
            <td><fmt:formatDate value="${spPledge.equPleDate}" pattern="yyyy年MM月dd日"/></td>
        </tr>
        <tr>
            <td width="190">注销原因</td>
            <td>${spPledge.canRea}</td>
        </tr>
        </tbody>
    </table>
</div>
</c:if>
<c:if test="${not empty spPledge && spPledge.status == 'C'}">
<div class="mod-bd-panel_company">
    <h3 class="i-title">
        <i></i>股权出质撤销信息
    </h3>
    <table class="table-common table-zichan table-punishdetail">
        <tbody>
        <tr>
            <td width="190">撤销日期</td>
            <td><fmt:formatDate value="${spPledge.equPleDate}" pattern="yyyy年MM月dd日"/></td>
        </tr>
        <tr>
            <td width="190">撤销原因</td>
            <td></td>
        </tr>
        </tbody>
    </table>
</div>
</c:if>
</body>
</html>