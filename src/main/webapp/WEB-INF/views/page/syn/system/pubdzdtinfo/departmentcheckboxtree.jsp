<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>部门管理</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body>
	<div class="main" >
		<div style="float:left;width:100%">
			<div>
			</div>
			<div class="tree" style="width:300px;">
				<ul id=departmentchecktree class="ztree"></ul>
			</div>
		</div>
		<div class="btnCenter">
			<input type="button" value="确定" class="btn btn-primary" id="departmentSubmit" class="btn">
			<input type="button" value="关闭" class="btn btn-primary" id="departmentClose" class="btn">
		</div>
	</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/pubdzdtinfo/departmentcheckboxtree.js"></script>
</body>
</html>
