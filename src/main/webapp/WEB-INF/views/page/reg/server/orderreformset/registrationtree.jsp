<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
 	<meta http-equiv="X-UA-Compatible" content="IE=8" >
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon"/> 
    <link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<!-- <div>
	<input class="tree-box-searcher" id="tree-box-searchertree_Njjg" title="输入关键字可以检索" placeholder="输入关键字进行检索">
	<input type="button" class="tree-box-searcher-btn" id="tree-box-searcher" value="检索">
</div> -->
<ul id="registrationtree" class="ztree" style="width:100%;max-height:80%;overflow-y: auto"></ul>
<div class="row text-center">
	<input type="button" value="确定" class="btn btn-primary" id="registrationtreeSubmit" class="btn">
	<input type="button" value="关闭" class="btn btn-primary" id="registrationtreeClose" class="btn">
</div>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/server/orderreformset/registrationtree_list_main.js"/>"></script>
</body>
</html>
