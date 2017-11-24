<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>变更重建档详情</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
var _priPID='${priPID}';
</script>
</head>
<body class="pd10">

    <table id="user-table"  border="0" cellspacing="0" cellpadding="0" class="table-row mt30"width="100%">
        <thead>
        <tr>
            <th width="6%">序号</th>
            <th width="10%">变更事项</th>
            <th width="18%">变更前内容</th>
            <th  width="18%">变更后内容</th>
            <th width="10%">变更日期</th>
        </tr>
        </thead>
    </table>
 <div class="center">
    <input id="cancel" type="button" class="btn" value="返 回">
 </div>

<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="{{this.class}}">{{this.text}}</button>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/registinfo/againdetail_list.js"></script>
</body>
</html>
