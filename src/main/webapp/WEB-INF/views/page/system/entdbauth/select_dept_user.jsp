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
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
</head>
<body class="pd10">
<input type="hidden" name="priPIDs" id="priPIDs" value="${priPIDs}">
<div class="pd20 clearfix">
    <h3 class="h3-title center"></h3>
    <table cellpadding="0" cellspacing="0" border="0" width="100%" style="height: 100%" class="table-horizontal mt10">
        <tr height="100%">
            <td class="bg-gray right" width="15%" height="100%">
                请选择部门：
            </td>
            <td width="35%" height="100%">
                <ul id="departmentTree" class="ztree" style="width:100%;max-height:500px;overflow-y: auto"></ul>
            </td>
            <td class="bg-gray right" width="20%">
                请选择人员：
            </td>
            <td width="35%" height="100%">
                <div id="deptUserDiv">
                </div>
            </td>
        </tr>
    </table>
    <p class="center mt10">
        <input type="button" id="departmentSubmit" class="btn mr20" value="确 定"/>
        <input type="button" class="btn" value="取 消" id="departmentClose"/>
    </p>
</div>

<script id="viewTemplate" type="text/x-handlebars-template">
    <input type="hidden" id="id" value="{{deptId}}"/>
</script>

<script id="deptUsersTmp" type="text/x-handlebars-template">
    {{#each data}}
    <label><input type="checkbox" id="{{id}}" name="userIds" value="{{id}}">{{realName}}</label>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/business/entdbauth/select_dept_user.js"></script>
</body>
</html>