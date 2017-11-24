<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>用户管理</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/css/vendor/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css?v=0177205e80">
</head>
<body>
<div class="iframe-wrap">
    <div class="toobar">
        <button class="btn btn-primary btn-sm glyphicon glyphicon-plus js-add" type="button">&nbsp;创建新用户</button>
    </div>
    <table id="user-table" class="table table-striped table-bordered table-hover" width="100%">
        <thead>
        <tr>
            <th>用户名</th>
            <th>姓名</th>
            <th>电子邮件</th>
            <th>用户状态</th>
            <th>创建时间</th>
            <th>最后登录时间</th>
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
<script src="/js/config.js?v=138f208b85"></script>
<script src="/js/business/sysuser/list_main.js?v=20499378e2"></script>
</body>
</html>
