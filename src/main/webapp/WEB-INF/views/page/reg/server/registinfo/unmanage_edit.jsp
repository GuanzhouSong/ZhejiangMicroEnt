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
  <input type="hidden" name="id" value="${unmanageDto.id}">
  <input type="hidden" name="uid" value="${unmanageDto.UID}">
  <input type="hidden" name="priPID" value="${unmanageDto.priPID}">
   <div class="form-group"  >
   <label class="col-xs-3 control-label text-right">处理措施：</label>
 <div class="col-xs-3">
 <select  name="disposeWay" >
 <c:if test="${disposeWayShow=='display:none'}">
  <option value="6" selected="selected">销户</option>
 </c:if>
  <c:if test="${disposeWayShow!='display:none'}">
  <option value="">--请选择--</option>
   <option value="1" <c:if test="${unmanageDto.disposeWay==1}">selected="selected"</c:if> >行政告诫</option>
   <option value="2" <c:if test="${unmanageDto.disposeWay==2}">selected="selected"</c:if> >行政指导</option>
   <option value="3" <c:if test="${unmanageDto.disposeWay==3}">selected="selected"</c:if> >责令整改</option>
   <option value="4" <c:if test="${unmanageDto.disposeWay==4}">selected="selected"</c:if> >列入案源信息</option>
   <option value="5" <c:if test="${unmanageDto.disposeWay==5}">selected="selected"</c:if> >部门抄告抄送</option>
   <option value="6" <c:if test="${unmanageDto.disposeWay==6}">selected="selected"</c:if> >销户</option>
  </c:if>
<select>
    </div>
    <label class="col-xs-3 control-label text-right"> 经办人：</label>
        <div class="col-xs-3">
   <input type="text"  class="form-control" name="disposeName"
                                     value="${unmanageDto.disposeName}">
      </div>
      </div>
<div class="form-group">
<label class="col-xs-3 control-label text-right">处理日期：</label>
  <div class="col-xs-3">
  <input type="text" style="width: 170px;cursor: pointer;"
              onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"class="form-control"
              readonly="readonly"  name="disposeDate" value="<fmt:formatDate value="${unmanageDto.disposeDate }"  pattern="yyyy-MM-dd HH:mm:ss"/>" />
</div>
</div>
  <div class="form-group">
<label class="col-xs-3 control-label text-right">情况说明：</label>
         <div class="col-xs-9">
  <textarea class="form-control"  rows="3" id="remark" name="remark">${unmanageDto.remark}</textarea>
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
<script src="/js/reg/server/registinfo/unmanage_edit.js"></script>
</body>
</html>