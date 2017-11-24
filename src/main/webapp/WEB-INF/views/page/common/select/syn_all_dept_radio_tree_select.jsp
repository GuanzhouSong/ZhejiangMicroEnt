<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>部门选择</title>
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body>
<ul id="sysDepartTree" class="ztree ztree-list"></ul>
<div class="row ml10 mt5">
    <input type="button" value="确定"  id="departmentSubmit" class="btn mr20">
    <input type="button" value="取消"  id="departmentClose" class="btn">
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
    <script src="/js/common/select/syn_dept_radio_tree_select.js"></script>
<script type="text/javascript">
    window._CONFIG = {
        treeUrl: '<c:url value="/common/system/sysdepart/treeWithAllDept"/>'+'?isNoCheck=${isNoCheck}'
    }
</script>
</body>
</html>
