<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>行政许可信息</title>
    <link rel="stylesheet" href="/css/pub.css">
</head>
<body>


<div class="mod-bd-panel_company">
    <h3 class="i-title">
        <i></i>${title}
    </h3>
    <table class="table-common table-zichan table-punishdetail">
        <tbody>
        <tr>
            <td width="190">${topTitle}</td>
            <td>  <fmt:formatDate value="${topContent}" dateStyle="long" /></td>
        </tr>
        <tr>
            <td width="190">${downTitle }</td>
            <td>${downContent }</td>
        </tr>
        </tbody>
    </table>
</div>


</body>
</html>