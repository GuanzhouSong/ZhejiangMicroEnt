<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>惩戒规则</title>
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css"> 
</head>
<body class="pd10">

	<div class="table-out">
	    <table id="rule_table" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap">
	        <thead>
	        <tr>
	            <th>序号</th>
	            <th>惩戒事由</th>
	            <th>执行措施</th>
	        </tr>
	        </thead>
	    </table>
	</div>
<script>
	var userType = '${sessionScope.session_sys_user.userType}';
	var urlHead = '/syn';
	if(userType==1){
		urlHead='/reg/server'
	}
    window._CONFIG = {
   		urlHead: urlHead
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/nocreditPunish/rule/selectdig.js"></script>
</body>
</html>