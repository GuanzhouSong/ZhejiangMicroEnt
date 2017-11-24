<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="hx" uri="/WEB-INF/tld/hx.tld"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <style type="text/css">
    	.yj-ipt .close-box .close-icon {
		    margin: 9px 8px 0 10px;
		}
    </style>
</head>
<body class="pd10">
<table cellpadding="0" cellspacing="0" border="0" class="table-horizontal mb10">
    <tbody>
     <tr>
        <td width="20%" class="bg-gray right">行政处罚决定书文号</td>
        <td width="30%">${midCaseInfo.penDecNo}</td>
        <td width="20%" class="bg-gray right">作出行政处罚机关名称</td>
        <td width="30%">${midCaseInfo.penAuth}</td>
    </tr>
    <tr>
        <td width="20%" class="bg-gray right">名称</td>
        <td width="30%">${midCaseInfo.unitName}</td>
        <td width="20%" class="bg-gray right">统一社会信用代码/注册号</td>
        <td width="30%">${midCaseInfo.regNO}</td>
    </tr>
    <tr>
        <td width="20%" class="bg-gray right">法定代表人（负责人）姓名</td>
        <td width="30%">${midCaseInfo.leRep}</td>
        <td width="20%" class="bg-gray right">作出行政处罚决定日期</td>
        <td width="30%"><fmt:formatDate value="${midCaseInfo.penDecIssDate}" pattern="yyyy年MM月dd日"/></td>
    </tr>
    <tr>
        <td width="20%" class="bg-gray right">违法行为类型</td>
        <td width="30%">${midCaseInfo.illegActType}</td>
        <td width="20%" class="bg-gray right">行政处罚内容</td>
        <td width="30%">${midCaseInfo.penContent}</td>
    </tr>
    <tr>
        <td width="20%" class="bg-gray right">行政处罚决定书</td>
        <td colspan="3" width="80%"><br><br>${midCaseInfo.punDecDoc}</td>
    </tr>
    </tbody>
</table>
</body>
</html>