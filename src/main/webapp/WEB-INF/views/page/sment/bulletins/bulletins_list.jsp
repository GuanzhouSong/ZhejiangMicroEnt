<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>通知公告</title>
    <link rel="stylesheet" href="/css/sment/sment.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<body>
	<form id="taskForm">
		 <input type="hidden" name="set" />
	</form>
	<div >
		<div class="clearfix mb5 mt5">
		    <p class="left">
		        <button class="btn" type="button" id="addPage">&nbsp;新增公告
		        </button>
		    </p>
		</div>
		<div>
	    <table id="user-table"  border="0" cellspacing="0" cellpadding="0" class="table-row mt30" style="width: 100%;white-space: nowrap;">
	        <thead>
	        <tr>
	            <th>序号</th>
	            <th>操作</th>
	            <th>公告标题</th>
	            <th>发布时间</th>
	        </tr>
	        </thead>
	    </table>
	</div>
	</div>
	
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/sment/bulletins/list_main.js"></script>
</body>
</html>