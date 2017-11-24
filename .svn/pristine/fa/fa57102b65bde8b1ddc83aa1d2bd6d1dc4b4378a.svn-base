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
    <title>已抽取企业列表</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<form id="paramForm">
<input type="hidden" value="${taskUid }" name="taskUid" id="taskUid"/> <!-- 当前任务uid -->
<div class="tip-info right">
	查询结果：
	未录入<label id="notinput" class="light-blue">0</label>条，
	待审核<label id="tocheck" class="light-blue">0</label>条，
	审核退回<label id="checkreturn" class="light-blue">0</label>条，
	已公示<label id="alreadypub" class="light-blue">0</label>条，
	未完结<label id="notover" class="light-blue">0</label>条
</div>
<table border="0" id="info-table" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap">
    <thead>
    <tr>
        <th>序号</th>
        <th>统一信用代码/注册号</th>
        <th>企业名称</th>
        <th>检查状态</th>
        <th>后续处置状态</th>
        <th>检查部门</th>
        <th>检查人员</th>
        <th>检查时间</th>
        <th>检查结果</th>
        <th>登记机关</th>
        <th>管辖单位</th>
    </tr>
    </thead>
</table>
 	
<div class="center mb20" style="padding: 20px;">
<input type="button" value="关闭" class="btn" id="close"/>
<input type="button" value="导出全部" class="btn" id="export" style="display:none"/>
</div>
<script>
    window._CONFIG = {
       chooseUrl:'${sysUser.userType == 2 ? "/syn" : "/reg"}', 
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sccheck/scent/scentshow_list.js"></script>
</body>
</html>