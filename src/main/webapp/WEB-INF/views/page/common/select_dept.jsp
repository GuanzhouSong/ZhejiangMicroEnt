<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/css/vendor/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div>
    <div id="deptDiv">

    </div>
    <ul id="departmentTree" class="ztree" style="width:100%;max-height:555px;overflow-y: auto"></ul>
</div>
<div class="row text-center">
    <button id="cancel" type="button" class="btn btn-primary">取消</button>
    <button id="ok" type="button" class="btn btn-primary">确定</button>
</div>

<script id="viewTemplate" type="text/x-handlebars-template">
    <input type="hidden" id="id" value="{{deptId}}"/>
</script>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/common/select_dept.js"></script>
</body>
</html>