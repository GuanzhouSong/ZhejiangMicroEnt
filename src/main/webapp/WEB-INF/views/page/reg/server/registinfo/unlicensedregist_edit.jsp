<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.lang.System" language="java"%>
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
var uid='${unlicensedInfoDto.UID}';
</script>
<body>
<div class="container .container-fluid">
 <form class="form-horizontal error-bottom" id="registInfoForm">
  <input type="hidden" name="uid" value="${unlicensedInfoDto.UID}">
  <input type="hidden" name="priPID" value="${unlicensedInfoDto.priPID}">
  <div class="form-group">
  <label class="col-xs-3 control-label text-right"> 统一代码：</label>
  <div class="col-xs-3">
   <input type="text" name="uniCode" id="uniCode" class="form-control"readonly="true"
   <%-- 法定代表人、经营期限至、登记状态”栏始终只读，根据统一代码、注册号自动显示 --%>
       value="${unlicensedInfoDto.uniCode }">
       </div>
  <label class="col-xs-3 control-label text-right"> 注册号：</label>
<div class="col-xs-3">
  <input type="text"id="regNO" name="regNO" class="form-control"
                                    value="${unlicensedInfoDto.regNO}">
</div>
</div>
  <div class="form-group">
法定代表人：
   <input type="text" name="leRep"readonly="true"
                                     value="${unlicensedInfoDto.leRep }">
经营期限至：
<c:set var="nowDate" value="<%=System.currentTimeMillis()%>"></c:set>
  <input type="text" name="opTo"readonly="true"
   <%-- --%> <c:if test="${unlicensedInfoDto.opTo.getTime()  - nowDate <= 0 }">
         style="color:#FF0000"
       </c:if>
    value="<fmt:formatDate value='${unlicensedInfoDto.opTo}' type='date'/>">
</div>
<%-- （已到期的经营期限、登记状态为注销未吊销的显红）--%>
  <div class="form-group">
   登记状态：
   <input type="text" name="regState"readonly="true"
     <c:if test="${unlicensedInfoDto.regState=='5'}">
       style="color:#FF0000"
     </c:if>
     value="${unlicensedInfoDto.regState}" >


当事人姓名：
  <input type="text" name="name"required
                                    value="${unlicensedInfoDto.name }">
</div>

  <div class="form-group">
固定电话：
   <input type="text" name="fixTel"
                                     value="${unlicensedInfoDto.fixTel }">
身份证号码：
  <input type="text" name="cerNO"
                                    value="${unlicensedInfoDto.cerNO }">
</div>

  <div class="form-group">
手机号码：
   <input type="text" name="mobTel"
                                     value="${unlicensedInfoDto.mobTel }">
 经营内容：
  <input type="text" name="mgrScope"readonly="true"required
                                    value="${unlicensedInfoDto.mgrScope }">
</div>
<div class="form-group">
 监管项目code：
   <input type="text" name="superNos"required
                                     value="${unlicensedInfoDto.superNos }">
监管项目：
  <input type="text" name="superNoNames"required
                                    value="${unlicensedInfoDto.superNoNames }">
</div>
<div class="form-group">
经营时所使用的名称：
   <input type="text" name="mgrName"readonly="true"
                                     value="${unlicensedInfoDto.mgrName }">
</div>
<div class="form-group">
经营地点：
<select  name="proLocCity"   >
                  <option value="">--请选择--</option>
                  <c:forEach items="${proLocCityList}"  var="pr">
                  <option value="${pr.code }"
                  <c:if test="${pr.code ==unlicensedInfoDto.proLocCity}">
                  selected="selected"
                  </c:if>
                  >${pr.content }</option>
                  </c:forEach>
<select>
<select  name="proLocCounty"   >
                  <option value="">--请选择--</option>
                  <c:forEach items="${proLocCountyList}"  var="pr">
                  <option value="${pr.code }"
                  <c:if test="${pr.code ==unlicensedInfoDto.proLocCounty}">
                  selected="selected"
                  </c:if>
                  >${pr.content }</option>
                   </c:forEach>
<select>
<select  name="proLocStreet"   >
                  <option value="">--请选择--</option>
                  <c:forEach items="${proLocStreetList}"  var="pr">
                  <option value="${pr.code }"
                  <c:if test="${pr.code ==unlicensedInfoDto.proLocStreet}">
                  selected="selected"
                  </c:if>
                  >${pr.content }</option>
                   </c:forEach>
<select>
 <input type="text" name="proLocAddress"required
                                     value="${unlicensedInfoDto.proLocAddress }">
</div>
<div class="form-group">
管辖单位：
 <select  name="localAdm"   required>
     <option value="">--请选择--</option>
     <c:forEach items="${codeRegUnitList}"  var="pr">
     <option value="${pr.code }"
     <c:if test="${pr.code ==unlicensedInfoDto.localAdm}">
      selected="selected"
     </c:if>
     >${pr.content }</option>
      </c:forEach>
<select>
片区/商圈：
<select  name="sliceNo"   >
                  <option value="">--请选择--</option>
                  <c:forEach items="${codeSlicenoList}"  var="pr">
                  <option value="${pr.code }"
                  <c:if test="${pr.code ==unlicensedInfoDto.sliceNo}">
                  selected="selected"
                  </c:if>
                  >${pr.content }</option>
                   </c:forEach>
<select>
</div>
<div class="form-group">
类型：
 <select  name="unlicType"   required>
 <option value="">--请选择--</option>
 <option value="1" <c:if test="${unlicensedInfoDto.unlicType==1}">selected="selected"</c:if> >无照</option>
 <option value="2" <c:if test="${unlicensedInfoDto.unlicType==2}">selected="selected"</c:if> >无照无证</option>
 <option value="3" <c:if test="${unlicensedInfoDto.unlicType==3}">selected="selected"</c:if> >有照无证</option>
 <option value="4" <c:if test="${unlicensedInfoDto.unlicType==4}">selected="selected"</c:if> >执照过期</option>
 <option value="5" <c:if test="${unlicensedInfoDto.unlicType==5}">selected="selected"</c:if> >吊销未注销</option>
<select>
是否涉及：
<input type="checkbox"required  id="isInvolve" name="isInvolve" <c:if test="${unlicensedInfoDto.isInvolve==0}"> checked="checked" </c:if>
value="0" />无
<input type="checkbox" required id="isInvolve" name="isInvolve" <c:if test="${unlicensedInfoDto.isInvolve==1}"> checked="checked" </c:if>
value="1" />涉及前置许可
<input type="checkbox"  required id="isInvolve" name="isInvolve" <c:if test="${unlicensedInfoDto.isInvolve==2}"> checked="checked" </c:if>
value="2" />涉及后置许可
</div>

    </div>
</div>

无证记录：
    <div class="toobar">
        <button class="btn btn-primary btn-sm glyphicon glyphicon-plus js-record-add" type="button">&nbsp;新增</button>
        <button class="btn btn-primary btn-sm glyphicon glyphicon-plus js-record" type="button">&nbsp;编辑</button>
    </div>
    <table id="record-table" class="table table-striped table-bordered table-hover" width="100%">
        <thead>
        <tr>
            <th>序号</th>
            <th>全选<input type='checkbox' id='record_checkAll'></th>
            <th>许可证名称</th>
            <th>许可证状况说明</th>
        </tr>
        </thead>
    </table>

发现记录：
    <div class="toobar">
        <button class="btn btn-primary btn-sm glyphicon glyphicon-plus js-find-add" type="button">&nbsp;新增</button>
        <button class="btn btn-primary btn-sm glyphicon glyphicon-plus js-find" type="button">&nbsp;编辑</button>
    </div>
    <table id="find-table" class="table table-striped table-bordered table-hover" width="100%">
        <thead>
        <tr>
            <th>序号</th>
            <th>全选<input type='checkbox' id='find_checkAll'></th>
            <th>发现时间</th>
            <th>发现人</th>
            <th>发现途径</th>
            <th>情况说明</th>
        </tr>
        </thead>
    </table>


处理记录：

    <div class="toobar">
        <button class="btn btn-primary btn-sm glyphicon glyphicon-plus js-manage-add" type="button">&nbsp;新增</button>
        <button class="btn btn-primary btn-sm glyphicon glyphicon-plus js-manage" type="button">&nbsp;编辑</button>
    </div>
    <table id="manage-table" class="table table-striped table-bordered table-hover" width="100%">
        <thead>
        <tr>
            <th>序号</th>
            <th>全选<input type='checkbox' id='manage_checkAll'></th>
            <th>处理日期</th>
            <th>处理措施</th>
            <th>经办人</th>
            <th>情况说明</th>
        </tr>
        </thead>
    </table>
<div class="form-group">
 记录人：
   <input type="text" name="setName"required
                                     value="${unlicensedInfoDto.setName }">
记录日期：
<input type="text" style="width: 80px;cursor: pointer;" required
onclick="laydate({istime: true,format: 'YYYY-MM-DD hh:MM:ss'})"
readonly="readonly" name="setTime"
value="<fmt:formatDate value="${unlicensedInfoDto.setTime }"  pattern="yyyy-MM-dd HH:mm:ss"/>" />
</div>


 <div class="row text-center">
                 <button id="save"  class="btn btn-primary glyphicon glyphicon-hand-up">保存</button>
                <button id="cancel" type="button" class="btn btn-primary">返回</button>
  </div>
</form>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/registinfo/unlicensedregist_edit.js"></script>
</body>
</html>