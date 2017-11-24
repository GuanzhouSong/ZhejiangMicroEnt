<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>部门选择（根据职能部门编码）</title>
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body>
<ul id="sysDepartTree" class="ztree ztree-list"></ul>
<div class="row ml10 mt5">
    <input type="button" value="确定" id="ok" class="btn mr20">
    <input type="button" value="取消" id="cancle" class="btn">
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/common/select/syn_dept_tree_select_by_duty.js"></script>
<script type="text/javascript">
    var deptDutyCodes='${dutyDeptCodes==null? sessionScope.session_sys_user.dutyDeptCodes:dutyDeptCodes}'
    window._CONFIG = {
        treeUrl: '<c:url value="/common/system/sysdepart/treeByDutyCodes"/>'+'?dutyDeptCodes='+deptDutyCodes+"&isFilterBySysUser="+'${isFilterBySysUser}'+'&isNoCheck='+'${isNoCheck}'+'&isUserMange='+'${isUserMange}',
        treeType:'${treeType}'
    }
</script>
</body>
</html>
