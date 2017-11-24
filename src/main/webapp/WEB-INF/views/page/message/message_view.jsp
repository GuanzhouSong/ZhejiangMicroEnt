<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<meta charset="utf-8">
<title></title>
<%--<link rel="stylesheet" href="/css/reg.server.css">--%>
<link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
<link rel="stylesheet" href="/css/reg.client.css">
</head>
<body>
 <form id="excelExportForm" method="post">
 	<input type="hidden" id="msgUid" name="msgUid">
 </form>
 <form id="taskForm" class="form-box">
       <div class="mt10" id="div_export" style="display: none">
            <div class="right">
				<a class="dt-button buttons-excel buttons-html5" id="btn_excelExport"  href="#"><span>导出</span></a>
            </div>
        </div>
	<div class="mt20">
	 	
		<div class="mod mod-tb-notice-detail">
			<div class="mod-bd">
				<div class="content">
					<div class="hd center">
						<h3>
							<span id="msgTitle"></span>
						</h3>
						<p>
							<span class="mr40">发送时间：<span id="sendTime"></span>
						</p>
					</div>
					<div class="bd">
						<div class="bd-cont" id="content">
							<span id="msgContent">
								
							</span>
						</div>
						<!-- <div class="fd">发布人：警示系统超级管理员</div> -->
					</div>
				</div>
			</div>
			<div class="mt10" style="display: none" id="div_pageTable">
				<div class="iframe-wrap">
					<%--    <p><h2>企业名称:${map.entName}&nbsp;&nbsp;&nbsp;注册号/ 统一信用社会代码:${map.uniCode }</h2></p> --%>
					<table id="permit-table" class="table-row display nowrap" cellspacing="0" width="100%">
						<thead>
							<tr>
								<th>序号</th>
								<th>企业名称</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>

			<table id="tab_wx" class="table-row" cellspacing="0" width="100%" style="display: none">
				<thead>
				<tr>
					<th>序号</th>
					<th>企业名称</th>
				</tr>
				</thead>
				<tbody id="tbody_entList">
				
				</tbody>
			</table>
		</div>


</form>
		<script id="tpl_entList" type="text/x-handlebars-template">
		{{#each this}}
			<tr>
					<td>{{tableNum @index}}</td>
					<td>{{entName}}</td>
				</tr>
		{{/each}}
		</script>
		<script src="/js/lib/require.js"></script>
		<script src="/js/config.js"></script>
		<script src="/js/reg/server/message/message_view.js"></script>
		
</body>
</html>