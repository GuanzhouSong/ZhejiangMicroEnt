<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>党组织人员列表</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
	<link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<form id="qryForm">
	<input type="hidden" value="${partyOrgID }" name="partyOrgID">
	<input type="hidden" value="1" name="auditState">
	<input type="hidden" value="${operateType }" id="operateType">
</form>
<div class="clearfix mb5">
    <span class="light">提示：查询当前党组织下的有效的人员列表。</span>
</div>
<div>
    <table border="0" id="user-table" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap">
        <thead>
        <tr>
            <th>序号</th>
            <th><input type="checkbox" id="checkall"></th>
            <th>姓名</th>
        </tr>
        </thead>
    </table>
</div>
 <p class="center mt10 mb10">
    <input type="button" id="ok" value="确定" class="btn mr20">
    <input type="button" id="close" value="关闭" class="btn mr20">
</p>
</body>
<script>
    window._CONFIG = {
       chooseUrl:'${sysUser.userType == 2 ? "/syn" : "/reg/server"}', 
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/partycreate/partactivity/choosemember_list.js"></script>
</html>