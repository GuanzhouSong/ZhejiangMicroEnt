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
    <link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<div class="page-content clear">
    <div class="col-3 border-box" style="border-right: 1px solid #CCC; min-height: 400px">
        <div>
            <ul id="departmentTree" class="ztree"></ul>
        </div>
    </div>
    <div class="col-9 border-box pdl15">
        <div class="form-header">
            部门维护
        </div>
        <button class="btn btn-sm" id="addBtn">新增</button>
        <button class="btn btn-sm" id="editBtn">修改</button>
        <button class="btn btn-sm" id="delBtn">删除</button>
        <div id="showArea">

        </div>
    </div>
</div>
<script id="viewTemplate" type="text/x-handlebars-template">
    <input type="hidden" id="id" value="{{deptDID}}"/>
    <table class="table table-horizontal mt15">
        <tbody>
        <tr>
            <td class="right bg-gray" width="18%">上级部门：</td>
            <td class="left">{{parentName}}</td>
        </tr>
        <tr>
            <td class="right bg-gray">部门名称：</td>
            <td class="left">{{deptName}}</td>
        </tr>
        <tr>
            <td class="right bg-gray">部门简称：</td>
            <td class="left">{{deptShortName}}</td>
        </tr>
        <tr>
            <td class="right bg-gray">部门编码：</td>
            <td class="left">{{deptCode}}</td>
        </tr>
        <tr>
            <td class="right bg-gray">部门地址：</td>
            <td class="left">{{deptAddress}}</td>
        </tr>
        <tr>
            <td class="right bg-gray">邮编：</td>
            <td class="left">{{postalCode}}</td>
        </tr>
        <tr>
            <td class="right bg-gray">备注：</td>
            <td class="left">{{remark}}</td>
        </tr>
        <tr>
            <td class="right bg-gray">设置人：</td>
            <td class="left">{{setter}}</td>
        </tr>
		<tr>
            <td class="right bg-gray">设置日期：</td>
            <td class="left">{{setDate}}</td>
        </tr>
		<tr>
            <td class="right bg-gray">是否有效：</td>
            <td class="left">{{isValid}}</td>
        </tr>
        </tbody>
    </table>
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/yr/deptmanage/list_main.js"></script>
</body>
</html>
