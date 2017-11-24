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
  <input type="hidden" name="id" value="${unrecordDto.id}">
  <input type="hidden" name="uid" value="${unrecordDto.UID}">
  <input type="hidden" name="priPID" value="${unrecordDto.priPID}">
   <div class="form-group">

      <label class="col-xs-3 control-label text-right">许可证名称：</label>
        <div class="col-xs-3">
   <input type="text"  class="form-control" name="licName"
                                     value="${unrecordDto.licName}">
      </div>
      </div>

  <div class="form-group">
<label class="col-xs-3 control-label text-right">许可证状况说明：</label>
         <div class="col-xs-9">
  <textarea class="form-control"  rows="3" id="remark" name="remark">${unrecordDto.remark}</textarea>
</div>
</div>
</div>



 <div class="row text-center">
                 <button id="save"  class="btn btn-primary glyphicon glyphicon-hand-up">保存</button>
                <button id="cancel" type="button" class="btn btn-primary">返回</button>
            </div>
        </form>
    </div>
</div>


<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/registinfo/unrecord_edit.js"></script>
</body>
</html>