<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>主体智能比对</title>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body>

<div class="relative-network-wrap">
    <div class="relative-search">
        <form id="js-params" >
        <input class="rs-input" type="text" placeholder="请输入企业名称">
        <input class="rs-input" type="text" placeholder="请输入企业名称">
        <a class="rs-btn-cx" href="javascript:void(0);" id="searchEnt">查询</a>
        <a class="rs-btn-add" href="javascript:void(0);">关系企业</a>
        <a href="javascript:void(0);" class="relation u-add" onclick="addCompany()" ></a>
        <a href="javascript:void(0);" class="relation u-reduce" onclick="removeCompany()" ></a>
        </form>
    </div>
    <div class="relative-legend">
        <p><span>股东关系：</span><span style="margin-left: 35px;">高管关系：</span><span style="margin-left: 35px;">法定代表人关系：</span><span style="margin-left: 35px;">既是法定代表人也是高管关系：</span><span style="float: right;color: #ff0000;">注：最多查询4个企业。</span></p>
    </div>
    <div class="relative-data" id="relationChart">

    </div>
</div>

<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/server/relation/relation.js"/>"></script>
</body>
</html>