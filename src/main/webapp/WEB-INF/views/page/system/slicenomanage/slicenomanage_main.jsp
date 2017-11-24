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

    <title>片区商圈维护</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="/css/reg.server.css">

</head>
<body class="pd10">
<div class="page-content clear">
    <div class="col-3 border-box" style="border-right: 1px solid #CCC; min-height: 400px">
        <div>
            <ul id="sliceNoTree" class="ztree"></ul>
        </div>
    </div>
    <div class="col-8 border-box pdl15">
        <div class="form-header">
           片区商圈维护
        </div>
        <button class="btn btn-sm" id="addBtn" style="display:none">新增</button>
        <button class="btn btn-sm" id="editBtn">修改</button>
        <button class="btn btn-sm" id="delBtn">删除</button>
        <div id="showArea">

        </div>
    </div>
</div>
<script id="viewTemplate" type="text/x-handlebars-template">
    <input type="hidden" id="code" value="{{code}}"/>
    <table class="table-horizontal mt15">
        <tbody>
        <tr>
            <td class="right bg-gray " width="24%">所属管辖地区：</td>
            <td class="text-left">{{parentName}}</td>
        </tr>
        <tr>
            <td class="right bg-gray ">所属管辖地区编码：</td>
            <td class="text-left">{{supCode}}</td>
        </tr>
        <tr>
            <td class="right bg-gray ">类型：</td>
            <td class="text-left">{{type}}</td>
        </tr>
        <tr>
            <td class="right bg-gray ">片区名称：</td>
            <td class="text-left">{{content}}</td>
        </tr>
        <tr>
            <td class="right bg-gray ">片区编码：</td>
            <td class="text-left">{{code}}</td>
        </tr>
        </tbody>
    </table>
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/business/slicenomanage/list_main.js"></script>
</body>
</html>
