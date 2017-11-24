<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>查看更多通知公告</title>
    <link rel="shortcut icon" href="../img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/layout-default-latest.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">
<input type="hidden" id="moreFlag" value="1"/>
<div class="notice-info border-bottom">
    <div class="title"><strong><i class="xbt-icon"></i>通知公告</strong></div>
    <ul class="notice-info-list">
</div>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/business/bulletin/bulletin_list.js"></script>

<script>
    window._CONFIG = {
        chooseUrl: '${sessionScope.session_sys_user.userType == '2' ? "/syn" : "/reg"}'
    }
</script>
</body>
</html>
