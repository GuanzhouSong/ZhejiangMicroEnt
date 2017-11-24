<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>权限管理</title>
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/css/vendor/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css?v=0177205e80">
</head>
<body>
<div class="page-content">
    <div class="col-xs-3" style="border-right: 1px solid #CCC; min-height: 400px">
        <div>
            <ul id="permisionTree" class="ztree"></ul>
        </div>
    </div>
    <div class="col-xs-9">
        <div class="form-header">
            权限维护
        </div>
        <button class="btn btn-sm" id="addBtn">新增</button>
        <button class="btn btn-sm" id="editBtn">修改</button>
        <button class="btn btn-sm" id="delBtn">删除</button>
        <div id="showArea">

        </div>
    </div>
</div>
<script id="viewTemplate" type="text/x-handlebars-template">
    <input type="hidden" id="id" value="{{id}}"/>
    <table class="table table-bordered" style="margin-top: 14px">
        <tbody>
        <tr>
            <td class="col-xs-2 text-right bgcolor_undertint">上级权限：</td>
            <td class="text-left">{{parentName}}</td>
        </tr>
        <tr>
            <td class="text-right bgcolor_undertint">权限名称：</td>
            <td class="text-left">{{name}}</td>
        </tr>
        <tr>
            <td class="text-right bgcolor_undertint">权限类型：</td>
            <td class="text-left">{{type}}</td>
        </tr>
        <tr>
            <td class="text-right bgcolor_undertint">权限资源：</td>
            <td class="text-left">{{url}}</td>
        </tr>
        <tr>
            <td class="text-right bgcolor_undertint">序号：</td>
            <td class="text-left">{{sort}}</td>
        </tr>
        <tr>
            <td class="text-right bgcolor_undertint">权限描述：</td>
            <td class="text-left">{{desc}}</td>
        </tr>
        </tbody>
    </table>
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js?v=138f208b85"></script>
<script src="/js/business/syspermision/list_main.js?v=868ea2f642"></script>
</body>
</html>
