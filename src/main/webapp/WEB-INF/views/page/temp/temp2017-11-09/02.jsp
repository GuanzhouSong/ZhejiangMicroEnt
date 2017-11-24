<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body>

<div class="relative-network-wrap">
    <div class="relative-search">
        <input class="rs-input" type="text" placeholder="公司名称">
        <input class="rs-input" type="text" placeholder="公司名称">
        <input class="rs-input" type="text" placeholder="公司名称">
        <input class="rs-input" type="text" placeholder="公司名称">
        <a class="rs-btn-cx" href="javascript:;">查询</a>
        <a class="rs-btn-add" href="javascript:;">关系企业</a>
        <a href="" class="relation u-add"></a>
        <a href="" class="relation u-reduce"></a>
    </div>
    <div class="relative-legend">
        <p><span>股东关系：</span><span style="margin-left: 35px;">高管关系：</span><span style="margin-left: 35px;">法定代表人关系：</span><span style="margin-left: 35px;">既是法定代表人也是高管关系：</span><span style="float: right;color: #ff0000;">注：最多查询4个法人关系。</span></p>
    </div>
    <div class="relative-data">

    </div>
</div>


</body>
</html>