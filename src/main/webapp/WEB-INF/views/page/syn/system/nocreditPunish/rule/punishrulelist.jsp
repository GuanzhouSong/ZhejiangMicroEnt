<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>惩戒规则</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<body class="pd10">

<div class="clearfix mb5">
    <p class="fl"><input type="button" id="add" class="btn btn-sm mr5" value="新建惩戒规则"/></p>
</div>

<div class="table-out" >
    <table id="rule-table" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap">
        <thead>
        <tr>
            <th >操作</th>
            <th >惩戒领域</th>
            <th >法律依据</th>
            <th >惩戒事由</th>
            <th >限制时间</th>
            <th >惩戒规则</th>
            <th >惩戒措施</th>
            <th >惩戒提请部门</th>
            <th >惩戒执行部门</th>
        </tr>
        </thead>
    </table>
</div>
<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <a href="javascript:void(0);" class="{{this.class}}">{{this.text}}</a>
    {{/each}}
</script>
<script>
	var userType = '${sessionScope.session_sys_user.userType}';
	var urlHead = '/syn';
	if(userType==1){
		urlHead='/reg/server';
	}
    window._CONFIG = {
   		urlHead: urlHead
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/nocreditPunish/rule/list_main.js"></script>
</body>
</html>