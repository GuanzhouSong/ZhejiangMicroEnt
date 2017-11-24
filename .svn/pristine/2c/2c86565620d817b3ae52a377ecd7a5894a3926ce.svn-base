<%--
   Copyright漏 2003-2016 娴欐睙姹囦俊绉戞妧鏈夐檺鍏徃, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>选择部门</title>
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body>
<ul id="sysDepartTree" class="ztree ztree-list"></ul>
<div class="row ml10 mt5">
    <input type="button" value="确定" id="departmentSubmit" class="btn mr20">
    <input type="button" value="取消" id="departmentClose" class="btn">
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<c:if test="${sysDeptFilter.treeType=='radio'}">
    <script src="/js/common/select/syn_dept_radio_tree_select_noall.js"></script>
</c:if>
<c:if test="${sysDeptFilter.treeType=='checkbox'}">
    <script src="/js/common/select/syn_dept_ckbox_tree_select_noall.js"></script>
</c:if>
<c:if test="${sysDeptFilter.treeType==''||sysDeptFilter.treeType==null}">
    <script src="/js/common/select/syn_dept_ckbox_tree_select_noall.js"></script>
</c:if>
<script type="text/javascript">
    window._CONFIG = {
        treeUrl: '<c:url value="/common/system/sysdepart/treeByFilter"/>',
        isNoCheck:'${sysDeptFilter.isNoCheck}',
        adCode:'${sysDeptFilter.adCode}',
        adCodes:'${sysDeptFilter.adCodes}'
    }
</script>
</body>
</html>
