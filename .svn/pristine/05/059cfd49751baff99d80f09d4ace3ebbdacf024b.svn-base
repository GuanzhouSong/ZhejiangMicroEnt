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
    <title>警示系统-部门选择（单选）</title>
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon"/>
<%--    <link rel="stylesheet" href="/css/vendor/bootstrap-theme.min.css">--%>
<%--    <link rel="stylesheet" href="/css/vendor/bootstrap.min.css">--%>
     <link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body>

<ul id="departmentTree" class="ztree" style="width:100%;max-height:80%;overflow-y: auto"></ul>
<div class="row text-center" style="text-align:center;">
    <input type="button" value="确定" class="btn btn-primary" id="ok" class="btn">
    <input type="button" value="取消" class="btn btn-primary" id="cancel" class="btn">
</div>
<script type="text/javascript">
    window._CONFIG = {
        treeUrl: '<c:url value="/common/system/dept/tree/allTreeData.json"/>',
        treeType:'${treeType}'
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/common/select/warn_dept_radio_tree.js"></script>
</body>
</html>