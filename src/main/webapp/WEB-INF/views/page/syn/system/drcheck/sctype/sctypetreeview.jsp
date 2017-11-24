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
<div class="container .container-fluid">
    <div class="clearfix" style="margin-bottom: 10px;">
    <div>
        <!-- 所选是： <span id="values" style="color: blue;"></span> -->
    </div>
    <input type="hidden" id="dptId" value="${dptId}" >
    <input type="hidden" id="deptCode" value="${deptCode}" >
         <input id="cityCode" type="hidden">
        <div class="col-xs-6">
           
            <ul id="permisionTree" class="ztree"></ul>
        </div>
    </div>
    <div class="row center">
       <button id="save" type="button" class="btn btn-primary">保存</button>
        <button id="cancel" type="button" class="btn btn-primary mr20">取消</button> 
    </div>
</div>
<script>
    var roleId = '${sysRole.id}';
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
 
<script src="/js/syn/system/drcheck/sctype/sctypetreeview.js"></script>
</body>
</html>