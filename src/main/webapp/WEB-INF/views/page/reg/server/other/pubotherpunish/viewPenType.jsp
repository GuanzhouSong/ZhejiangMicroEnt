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
<body>
  <input type="hidden" id="userType" value="${userType }">
<div class="container .container-fluid">
    <div class="clearfix" style="margin-bottom: 10px;">
    <div>
        <!-- 所选是： <span id="values" style="color: blue;"></span> -->
    </div>
         <input id="cityCode" type="hidden">
        <div class="col-xs-6">
           
            <ul id="permisionTree" class="ztree"></ul>
        </div>
    </div>
   <div class="clearfix mt10 ml10">
        <button id="save" type="button" class="btn btn-primary">保存</button>
        <button id="cancel" type="button" class="btn btn-primary">取消</button>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/other/otherpunish/pentype_main.js"></script>
</body>
</html>