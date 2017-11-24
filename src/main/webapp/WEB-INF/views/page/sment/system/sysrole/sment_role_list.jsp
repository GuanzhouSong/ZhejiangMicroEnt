<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>角色管理</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/sment/sment.server.css">
</head>
<body class="pd10">

<div class="clearfix mb5">
    <p class="fl">
        <input  type="button" class="btn btn-sm mr5 enadd js-add" value="创建角色">
    </p>
</div>
<div>
    <table id="role-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30">
        <thead>
        <tr>
            <th>序号</th>
            <th>角色名</th>
            <th>角色表述</th>
            <th>操作</th>
        </tr>
        </thead>
    </table>
</div>

<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="{{this.class}}">{{this.text}}</button>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/sment/system/sysrole/sment_sysrole_list.js"></script>
</body>
</html>
