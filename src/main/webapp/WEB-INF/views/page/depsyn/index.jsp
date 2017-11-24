<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>主页</title>
    <link rel="stylesheet" href="/css/pub-syn.css">
</head>
<body class="outer-bg">
<jsp:include page="common/header.jsp"></jsp:include>
<div class="mod clearfix">
    <jsp:include page="common/menu.jsp"></jsp:include>
    <div class="main">
        <div class="crumbs">
            <a href="javascript:void(0)">首页</a> &gt;
            <a href="javascript:void(0)" class="cur">起始页</a>
        </div>
        <hr/>
        <div class="index-cont clearfix">
        <div class="fl">
            <p>待接收的信息<span class="light">0</span>条</p>
            <p><a href="">双告知 <span class="light">0</span>条</a></p>
            <p><a href="">严重违法失信企业名单 <span class="light">0</span>条</a></p>
            <p><a href="">经营异常名录 <span class="light">0</span>条</a></p>
            <p><a href="">联合惩戒信息 <span class="light">0</span>条</a></p>
        </div>
        <div class="fl" style="margin-left: 105px;">
            <p>反馈的错误信息<span class="light">0</span>条</p>
            <p><a href="">行政许可信息 <span class="light">0</span>条</a></p>
            <p><a href="">行政处罚信息 <span class="light">0</span>条</a></p>
            <p><a href="">抽查检查结果 <span class="light">0</span>条</a></p>
            <p><a href="">小微企业扶持信息 <span class="light">0</span>条</a></p>
        </div>
        </div>
    </div>
</div>
<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>