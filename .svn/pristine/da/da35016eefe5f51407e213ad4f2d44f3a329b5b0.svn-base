<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>年报修改申请审核</title>
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="stylesheet" href="/css/vendor/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/css/vendor/bootstrap.min.css">
</head>
<body>
<div style="margin-top: 6px;">
    <form id="taskForm">
        <table class="table table-striped table-bordered table-hover" width="100%">
            <tr>
                <td width="11%" align="right" style="font-weight:bold;">统一代码/注册号</td>
                <td width="17%">
                    <input type="text" name="regNo" value="" />
                </td>

                <td width="8%" align="right" style="font-weight:bold;">企业名称</td>
                <td width="17%">
                    <input type="text" name="entName" value="" />
                </td>

                <td width="8%" align="right" style="font-weight:bold;">审核员</td>
                <td width="17%">
                 <input type="text" name="AudName" value="" />
                </td>
                <td align="right" style="font-weight:bold;">审核結果</td>
                <td>
                 <select name="modResult" style="width:80%;cursor: pointer;">
                 	<option value=""></option>
                 	<option value="0">无</option>
                 	<option value="1">同意</option>
                 	<option value="2">不同意</option>
                 </select>
                </td>
            </tr>
            <tr>
            	<td align="right" style="font-weight:bold;">登记机关</td>
                <td>
                 <select name="regOrg" style="width:80%;cursor: pointer;">
                 	<option></option>
                 	<c:forEach items="${codeRegorgList}" var="codeRegorg" varStatus="status">
                 		<option value="${codeRegorg.code }">${codeRegorg.content }</option>
                 	</c:forEach>
                 </select>
                </td>
                <td align="right" style="font-weight:bold;">抽查机关</td>
                <td>
                    <select name="LocalAdm" style="width:80%;cursor: pointer;">
                    	<option></option>
	                	<c:forEach items="${codeRegorgList}" var="codeRegorg" varStatus="status">
	                 		<option value="${codeRegorg.code }">${codeRegorg.content }</option>
	                 	</c:forEach>
	                </select>
                </td>
                <td align="right" style="font-weight:bold;">管辖单位</td>
                <td>
                    <select name="CheckDep" style="width:80%;cursor: pointer;">
	                 	<option></option>
	                 	<c:forEach items="${codeRegUnitList}" var="codeRegUnit" varStatus="status">
	                 		<option value="${codeRegUnit.code }">${codeRegUnit.content }</option>
	                 	</c:forEach>
	                </select>
                </td>
                <td width="8%" align="right" style="font-weight:bold;">年度</td>
                <td width="17%">
                 <select name="year" style="width:80%;cursor: pointer;">
                 	<option value=""></option>
                 	<c:forEach items="${yearList}" var="year" varStatus="status">
                 		<option value="${year }">${year }</option>
                 	</c:forEach>
                 </select>
                </td>
            </tr>
             <tr>
                <td align="right" style="font-weight:bold;">申请日期</td>
                <td colspan="3">
                    <input type="text" name="modSubmitDateStart" style="cursor: pointer;" onclick="laydate()" readonly="readonly"/>-
                    <input type="text" name="modSubmitDateEnd" style="cursor: pointer;" onclick="laydate()" readonly="readonly"/>
                </td>

                <td align="right" style="font-weight:bold;">审核日期</td>
                <td colspan="3">
                    <input type="text" name="audDateStart" style="cursor: pointer;" onclick="laydate()" readonly="readonly"/>-
                    <input type="text" name="audDateEnd" style="cursor: pointer;" onclick="laydate()" readonly="readonly"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<%--查询 & 重置--%>
<div class="row text-center">
    <button id="search" class="btn btn-success glyphicon glyphicon-search" >查询</button>
    <button id="cancel" class="btn btn-primary glyphicon glyphicon-hand-up" onclick="$('#taskForm')[0].reset();">清空</button>
</div><br/>
<div>
    <table border="0" id="modapplication-table" cellspacing="0" cellpadding="0" class="table-row mt30">
        <thead>
        <tr>
            <th>序号</th>
            <th>年度</th>
            <th>统一代码/注册号</th>
            <th>企业名称</th>
            <th>年报状态</th>
            <th>申请日期</th>
            <th>审核结果</th>
            <th>修改审核员</th>
      		<th>审核日期</th>
            <th>登记机关</th>
       		<th>抽查机关</th>
            <th>管辖单位</th>
            <th>操作</th>
        </tr>
        </<thead>
    </table>
</div>
<!-- <script id="tpl" type="text/x-handlebars-template"> -->
<!--     {{#each func}} -->
<!--     <button type="button" class="{{this.class}}">{{this.text}}</button> -->
<!--     {{/each}} -->
<!-- </script> -->
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/yr/modapplication/list_main.js"></script>
</body>
</html>
