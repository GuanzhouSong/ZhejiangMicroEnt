<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>动产抵押详细信息</title>
    <link rel="stylesheet" href="/css/pub.css">
</head>
<body>
<%--冻结、解冻、续行冻结（失效）、变更--%>
<div class="mod-bd-panel_company">
    <h3 class="i-title">
        <i></i>动产抵押登记信息
    </h3>
    <table class="table-common table-zichan">
        <tbody>
        <tr>
            <td width="190">登记编号</td>
            <td width="240">${mortRegInfo.filingNO}</td>
            <td width="190">登记日期</td>
            <td width="240"><fmt:formatDate value="${mortRegInfo.checkDate}" pattern="yyyy年MM月dd日"/></td>
        </tr>
        <tr>
            <td>登记机关</td>
            <td>${mortRegInfo.departMentName}</td>
            <td></td>
            <td></td>
        </tr>
        </tbody>
    </table>
</div>

<div class="mod-bd-panel_company">
    <h3 class="i-title">
        <i></i>抵押权人概况信息
    </h3>
    <table class="table-common">
        <thead>
        <tr>
            <th width="90">序号</th>
            <th width="250">抵押权人名称</th>
            <th width="180">抵押权人证照/证件类型</th>
            <th width="180">证照/证件号码</th>
            <th width="180">住所地</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>1</td>
            <td>${mortRegInfo.mortGageeName}</td>
            <td>
            	<c:if test="${mortRegInfo.mortGageeCertType=='gsyyzz'}">
            	${mortRegInfo.mortGageeCertType=='gsyyzz'?'工商营业执照':'身份证'}
            	</c:if>
           	</td>
            <td>
                <c:if test="${mortRegInfo.mortGageeCertType=='gsyyzz'}">
            	${mortRegInfo.mortGageeCertNO}
            	</c:if>
            </td>
            <td>${mortRegInfo.mortGageeAddr}</td>
        </tr>
        </tbody>
    </table>
</div>

<div class="mod-bd-panel_company">
    <h3 class="i-title">
        <i></i>被担保债权概况信息
    </h3>
    <table class="table-common table-zichan table-punishdetail">
        <tbody>
        <tr>
            <td width="190">种类</td>
            <td width="240">
            	<c:if test="${mortRegInfo.mortGageType=='jdht'}">借贷合同</c:if>
            	<c:if test="${mortRegInfo.mortGageType=='mmht'}">买卖合同</c:if>
            	<c:if test="${mortRegInfo.mortGageType=='qtht'}">其他合同</c:if>
           	</td>
            <td width="190">数额</td>
            <td width="240">${mortRegInfo.mortGageAmount} 万元</td>
        </tr>
        <tr>
            <td>担保的范围</td>
            <td>${mortRegInfo.warCov}</td>
            <td>债务人履行债务的期限</td>
            <td>
            	<fmt:formatDate value="${mortRegInfo.pefPerForm}" pattern="yyyy年MM月dd日"/> 至 <fmt:formatDate value="${mortRegInfo.pefPerTo}" pattern="yyyy年MM月dd日"/>
            </td>
        </tr>
        <tr>
            <td>备注</td>
            <td colspan="3">${mortRegInfo.remark}</td>
        </tr>
        </tbody>
    </table>
</div>

<div class="mod-bd-panel_company">
    <h3 class="i-title">
        <i></i>抵押物概况信息
    </h3>
    <table class="table-common">
        <thead>
        <tr>
            <th width="90">序号</th>
            <th width="250">名称</th>
            <th width="180">所有权或使用权归属</th>
            <th width="250">数量、质量、状况、所在地等情况</th>
            <th width="180">备注</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="mortGuaranteeInfo" varStatus="status" items="${mortGuaranteeInfoList}">
        <tr>
            <td>${status.index + 1}</td>
            <td>${mortGuaranteeInfo.guaName}</td>
            <td>${mortGuaranteeInfo.own}</td>
            <td>${mortGuaranteeInfo.guaDes}</td>
            <td>${mortGuaranteeInfo.remark}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<c:if test="${not empty mortAltitemInfoList}">
<div class="mod-bd-panel_company">
    <h3 class="i-title">
        <i></i>变更信息
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
        <c:forEach var="mortAltitemInfo" varStatus="status" items="${mortAltitemInfoList}">
        <tr>
            <td>${status.index + 1}</td>
            <td><fmt:formatDate value="${mortAltitemInfo.checkDate}" pattern="yyyy年MM月dd日"/></td>
            <td>${mortAltitemInfo.remark}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</c:if>
<c:if test="${not empty mortCancelInfo}">
<div class="mod-bd-panel_company">
    <h3 class="i-title">
        <i></i>注销信息
    </h3>
    <table class="table-common table-zichan table-punishdetail">
        <tbody>
        <tr>
            <td width="190">注销日期</td>
            <td><fmt:formatDate value="${mortCancelInfo.checkDate}" pattern="yyyy年MM月dd日"/></td>
        </tr>
        <tr>
            <td width="190">注销原因</td>
            <td>${mortCancelInfo.canRea}</td>
        </tr>
        </tbody>
    </table>
</div>
</c:if>
</body>
</html>