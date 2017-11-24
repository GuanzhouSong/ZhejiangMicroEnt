<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>企业与人员随机配对结果</title>
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="stylesheet" href="/css/vendor/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<body class="pd10">
<div id="fold-box">
<form id="scinfoAgentResultForm">
	<input type="hidden" name="taskNO" value="${taskNO }">
	<input type="hidden" name="deptTaskNO" value="${deptTaskNO }">
</form>
<table border="0" id="info-table" cellspacing="0" cellpadding="0" class="table-row perc-100 mt30 mb10 nowrap">
        <thead>
        <tr>
            <th>序号</th>
            <th>统一信用代码/注册号</th>
            <th>企业名称</th>
            <th>执法人员</th>
        </tr>
        </thead>
    </table>
</div>
<div class="center mb20">
<input type="button" value="关闭" class="btn" id="closeBtn"/>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/drcheck/sctack/scinfoAgentResult.js"></script>
</body>
</html>