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
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>年报修改申请审核</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab"> 
    <form id="taskForm" class="form-box">
      <div class="form-list">
             <div class="form-item clearfix">
                 <div class="col-4">
                     <label class="item-name col-5">注册号：</label>
                     <div class="col-7">
                         <div class="ipt-box col-11">
                             <input type="text" class="ipt-txt" name="regNo" value="" placeholder="请输入注册号">
                         </div>
                     </div>
                 </div>
                 <div class="col-4" >
                     <label class="item-name col-5">企业名称：</label>
                     <div class="col-7">
                         <div class="ipt-box col-11">
                             <input type="text" class="ipt-txt" name="entName" value="" placeholder="请输入企业名称"/>
                         </div>
                     </div>
                 </div>
                 <div class="col-4">
                     <label class="item-name col-5">年度：</label>
                     <div class="col-7">
                         <div class="ipt-box col-11">
                             <select name="year" style="cursor: pointer;">
                                <option value="">全部</option>
                                <c:forEach items="${yearList}" var="year" varStatus="status">
                                    <option value="${year }">${year }</option>
                                </c:forEach>
                            </select>
                         </div>
                     </div>
                 </div>
             </div>
             <div class="form-item clearfix">
                <!--  <div class="col-4">
                     <label class="item-name col-5">注册号：</label>
                     <div class="col-7">
                         <div class="ipt-box col-11">
                             <input type="text" class="ipt-txt" name="regNo" value="" placeholder="请输入注册号">
                         </div>
                     </div>
                 </div>
                 <div class="col-4" >
                     <label class="item-name col-5">企业名称：</label>
                     <div class="col-7">
                         <div class="ipt-box col-11">
                             <input type="text" class="ipt-txt" name="entName" value="" placeholder="请输入企业名称"/>
                         </div>
                     </div>
                 </div> -->
                 <div class="col-4">
                     <label class="item-name col-5">操作类型：</label>
                     <div class="col-7">
                         <div class="ipt-box col-11">
                             <select name="logOperation" style="cursor: pointer;">
                                <option value="">全部</option>
                                <c:forEach items="${logOperationList}" var="ogOperation" varStatus="status">
                                    <option value="${ogOperation.logOperation }">${ogOperation.logType }</option>
                                </c:forEach>
                            </select>
                         </div>
                     </div>
                 </div>
             </div>
          </div>
          <div class="clearfix mt10">
 				<div class="center">
             		<input type="button"  id="search" value="查询" class="btn mr20">
             		<input type="button"  id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
            	</div>
          </div>
    </form>
<div class="mt20">
    <table id="syslog-table" border="0" cellspacing="0" cellpadding="0" class="table-row" style="width: 100%;white-space: nowrap;">
        <thead>
        <tr>
            <th style="min-width: 50px">序号</th>
            <th style="min-width: 70px">年度</th>
            <th style="min-width: 140px">注册号</th>
            <th style="min-width: 150px">企业名称</th>
            <th style="min-width: 100px">企业类型</th>
            <th style="min-width: 100px">操作来源</th>
            <th style="min-width: 100px">操作类型</th>
            <th style="min-width: 80px">操作人</th>
      		<th style="min-width: 100px">IP</th>
            <th style="min-width: 120px">操作日期</th>
        </tr>
        </thead>
    </table>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/business/syslog/list_main.js"></script>
</div>
</body>
</html>
