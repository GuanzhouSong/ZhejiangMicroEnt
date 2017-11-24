<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>无证无照建档</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/css/vendor/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
   <form  id="qryForm">
<table class="table table-striped table-bordered table-hover"width="100%">
        <tr>
          <td width="200px">当事人：</td>
          <td width="350px">
              <input type="text" name="name" value=""  placeholder="请输入当事人"/>
          </td>
          <td width="200px">经营时所使用的名称：</td>
          <td width="350px">
              <input type="text" name="mgrName"   placeholder="请输入经营时所使用的名称"/>
          </td>
        </tr>
        <tr>
          <td width="200px">统一代码：</td>
          <td width="350px">
              <input type="text" name="uniCode" value=""  placeholder="请输入统一代码"/>
          </td>
          <td width="200px">注册号：</td>
          <td width="350px">
              <input type="text" name="regNO"   placeholder="请输入注册号"/>
          </td>
        </tr>
        <tr>
          <td width="200px">身份证件号码：</td>
          <td width="350px">
              <input type="text" name="cerNO" value=""  placeholder="请输入身份证件号码"/>
          </td>
          <td width="200px">经营场所：</td>
          <td width="350px">
              <input type="text" name="proLocAddress"   placeholder="请输入经营场所"/>
          </td>
        </tr>
        <tr>
          <td width="200px">管辖单位：</td>
          <td width="350px">
            <select  name="localAdm"   >
                                <option value="">--请选择--</option>
                                <c:forEach items="${codeRegUnitList}"  var="pr">
                                <option value="${pr.code }"
                                >${pr.content }</option>
                                 </c:forEach>
              <select>
          </td>
          <td width="200px">类型：</td>
          <td width="350px">
         <select  name="unlicType"   >
         <option value="">--请选择--</option>
         <option value="1"  >无照</option>
         <option value="2"  >无照无证</option>
         <option value="3" >有照无证</option>
         <option value="4"  >执照过期</option>
         <option value="5" >吊销未注销</option>
        <select>
          </td>
        </tr>
        <tr>
          <td width="200px">发现日期：</td>
          <td width="350px">
            <input type="text" style="width: 80px;cursor: pointer;"
             onclick="laydate()"
             readonly="readonly" name="findDate_start" value="" />-
             <input type="text" style="width: 80px;cursor: pointer;"
             onclick="laydate()"
             readonly="readonly"  name="findDate_end" value="<fmt:formatDate value="<%=new Date() %>"  pattern="yyyy-MM-dd"/>" />
          </td>
          <td width="200px">片区商圈：</td>
          <td width="350px">
            <select  name="sliceNo"   >
                               <option value="">--请选择--</option>
                               <c:forEach items="${codeSlicenoList}"  var="pr">
                               <option value="${pr.code }"
                               >${pr.content }</option>
                                </c:forEach>
             <select>
          </td>
        </tr>
  <tr>
          <td width="200px">状态：</td>
          <td width="350px">
         <select  name="unlicState"   >
         <option value="">--请选择--</option>
         <option value=""  >不限</option>
         <option value="1" >未销户</option>
         <option value="2" >已销户</option>
        <select>
         </td>
          <td width="200px">发现人：</td>
          <td width="350px">
        <input type="text" name="findName"   placeholder="请输入发现人"/>
          </td>
        </tr>
      </table>
       </form>
       <div class="row text-center">
              <button id="qry" class="btn btn-primary glyphicon glyphicon-hand-up">查询</button>
              <button id="cancel" class="btn btn-success glyphicon glyphicon-search">重置</button>
          </div>

<div class="iframe-wrap">

    <div class="toobar"> <button class="btn btn-primary btn-sm glyphicon glyphicon-plus js-regist" type="button">&nbsp;无照无证监管</button>
    </div>
    <table id="user-table" class="table table-striped table-bordered table-hover" width="100%">
        <thead>
        <tr>
            <th>序号</th>
            <th>全选<input type='checkbox' id='checkAll'></th>
            <th>当事人</th>
            <th>身份证号码</th>
            <th>统一代码</th>
            <th>注册号</th>
            <th>经营时所使用名称</th>
            <th>经营场所</th>
            <th>联系电话</th>
            <th class="unlicType">类型</th>
            <th class="unlicState">状态</th>
        </tr>
        </thead>
    </table>
</div>
<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="{{this.class}}">{{this.text}}</button>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/registinfo/unlicensedsupervise_list.js"></script>
</body>
</html>
