<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body>
<div class="pd10">
	<input class="tree-box-searcher" id="tree-box-searchertree_Njjg" placeholder="输入关键字进行检索">
	<input type="button" class="tree-box-searcher-btn btn" id="tree-box-searcher" value="检索">
</div>
<div class="ztree" style="margin-bottom: 10px;">
    <div>
        <!--     所选是： <span id="values" style="color: blue;"></span> -->
    </div>
    <input id="cityCode" type="hidden">
    <ul id="permisionTree" class=""></ul>
</div>
<div class="row ml10 mt5">
    <button id="save" type="button" class="btn">保存</button>
    <button id="cancel" type="button" class="btn ml20">取消</button>

</div>
<script>
    var roleId = '${sysRole.id}';
</script>
<script type="text/javascript">
    window._CONFIG = {
        isPermissionCheck:'${isPermissionCheck}',
        areaFlag:'${areaFlag}'
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>

<script src="/js/syn/system/sccheck/experttype/experttype_tree.js"></script>
</body>
</html>