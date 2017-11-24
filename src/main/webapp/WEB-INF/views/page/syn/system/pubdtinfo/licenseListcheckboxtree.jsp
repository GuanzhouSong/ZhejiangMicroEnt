<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>审批事项树</title>
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body>
<div class="pd10">
	<input class="tree-box-searcher" id="tree-box-searchertree_Njjg" title="输入关键字可以检索" placeholder="输入关键字进行检索">
	<input type="button" class="tree-box-searcher-btn btn" id="tree-box-searcher" value="检索">
	<input type="hidden" id="isLisence" value="${isLisence}"/>
	<input type="hidden" id="isRadio" value="${isRadio}"/>
</div>
<ul id="ycCodeLicenseTree" class="ztree" style="width:100%;max-height:80%;overflow-y: auto"></ul>
<div class="row ml10 mt5">
	<input type="button" value="确定" class="btn btn-primary mr20" id="codelicenseSubmit">
	<input type="button" value="关闭" class="btn btn-primary" id="codelicenseClose">
</div>
<script>
    window._CONFIG = {
       chooseUrl:'${userType == 2 ? "/syn" : "/reg/server"}', 
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/pubdtinfo/licenseListcheckboxtree.js"></script>
</body>
</html>
