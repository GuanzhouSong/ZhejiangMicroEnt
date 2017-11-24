<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>抽取对象查看</title>
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="stylesheet" href="/css/vendor/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<body class="pd10">
<div class="clearfix mb5">
    <form id="paramForm"><input type="hidden" value="${taskNO }" id="taskNO" name="taskNO"/></form>
    <h5 class="fl mr10 h5-title" id="totalH5">抽查检查名单：共${pubSctask.totalEnt }户</h5>
    </p>
</div>
<div>
    <table border="0" id="info-table" cellspacing="0" cellpadding="0" class="table-row perc-100 mt30 mb10 nowrap">
        <thead>
        <tr>
            <th>序号</th>
            <th>统一信用代码/注册号</th>
            <th>企业名称</th>
            <th>法定代表人</th>
            <th>联系电话</th>
            <th>联络员</th>
            <th>联络员电话</th>
            <th>成立日期</th>
            <th>企业类型</th>
            <th>行业</th>
        </tr>
        </thead>
    </table>
    <div class="center mb20">
        <input type="button" value="关闭" id="close" class="btn"/>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/drcheck/sctack/sctack_view.js"></script>
</body>
</html>