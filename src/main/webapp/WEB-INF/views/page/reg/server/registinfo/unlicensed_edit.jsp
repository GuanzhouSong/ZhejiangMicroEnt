<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="/css/vendor/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/css/vendor/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
</head>
<script type="text/javascript">
</script>
<body>
<div class="container .container-fluid">
 <div class="clearfix" style="margin-top: 10px;">
 <form class="form-horizontal error-bottom" id="registInfoForm">
   <div class="form-group">
<label class="col-xs-3 control-label text-right">监管项目列表：</label>
<div class="col-xs-9">
<c:forEach items="${unlicenseds}" var="p">
<input name="_unlicensed" type="checkbox" value="${p.superNo}"
<c:forEach items = "${checkedSuperNo}" var ="v">
<c:if test="${v==p.superNo}">
checked="checked"
</c:if>
</c:forEach>
/><label>${p.superName}</label>
</c:forEach>

</div>
</div>

</div>
<label class="col-xs-12 control-label text-left">已选择的监管项目：</label>
  <div class="form-group">
<div class="col-xs-12">
  <input type="hidden" id="superNo" name="superNo" value=" ${registUnlicensed.superNo}" ></input>
  <textarea class="form-control"   rows="3" id="superName" name="superName" readonly="readonly">${registUnlicensed.superName}</textarea>
</div>

 <div class="row text-center">
    <button id="save"  class="btn btn-primary glyphicon glyphicon-hand-up">确定</button>
    <button id="cancel" type="button" class="btn btn-primary">返回</button>
 </div>
        </form>
    </div>
</div>


<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/registinfo/unlicensed_edit.js"></script>
</body>
</html>