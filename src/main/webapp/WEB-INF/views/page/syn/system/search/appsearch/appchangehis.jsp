<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="en">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="renderer" content="webkit">
	<meta charset="utf-8">
	<title>变更历史信息</title>
	<link rel="stylesheet" href="/css/syn.css">
	<link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<body>
<form action="" id="hx-form">
	<input type="hidden" id="priPID" name="priPID" value="${priPID}">
	<input type="hidden" name="altDateOrder" value="1">
</form>

	<div class="pd20">
		<div class="tab-panel">
			<h5 class="com-info-title mt10">变更历史信息<span class="fr"></span>
			</h5>
			<table id="hx-table" border="0" cellspacing="0" cellpadding="0" class="table-row">
				<thead>
					<tr style="white-space: nowrap;">
						<th width="8%">序号</th>
						<th>变更事项</th>
						<th>变更时间</th>
						<th>变更前内容</th>
						<th>变更后内容</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>

<div class="form-item clearfix">
				<div class="btn-box">
					<input type="button" value="关 闭" class="btn mr20" id="cancel"> 
				</div>
			</div>
<script src="/js/lib/laydate/laydate.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/search/appsearch/appchangehis.js"></script>
</body>
</html>