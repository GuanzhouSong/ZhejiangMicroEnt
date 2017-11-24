<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<meta charset="utf-8">
<title>批量导入</title>
<link rel="stylesheet" href="/css/syn.css">
</head>

<body class="pd10">
	<div class="print-nocard">
		<div class="mt10">
		<input type="hidden" value="${taskUid }" id="taskUid"> 
		<input type="hidden" id="userType" value="${sysUser.userType}"> 
		<table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10 f12">
			<tr>
            	<td class="bg-gray right" width="30%"><span class="light">*</span>excel上传：</td>
            	<td>
            		<div class="ipt-box pd0">
					<input type="text" id="js-excel-file" class="ipt-txt" style="display: none;" readonly>
<!-- 					<input type="button" value="浏览.." id="viewbtn" class="ipt-btn js-ipt-btn" style="cursor: pointer;">  -->
					<input name="file" type="file" id="js-file-btn" >
					<c:if test="${sysUser.userType == '1'}">
						<a href="/reg/pub/server/sccheck/entback/downloadExcel?file_name=randomentinfo.xls" id="js-download">下载模板</a>
					</c:if>
					<c:if test="${sysUser.userType == '2'}">
						<a href="/syn/pub/server/sccheck/entback/downloadExcel?file_name=randomentinfo.xls" id="js-download">下载模板</a>
					</c:if>
					</div>
				</td>
           	</tr>
		</table>
			<p class="center mt20 mb30">
				
				<input type="button" class="btn mr20" id="js-upload" value="导入" style="cursor: pointer;">
				<input type="button" class="btn" id="js-cancel" value="关闭" style="cursor: pointer;">
			</p>
		</div>
	</div>
	<script src="/js/lib/require.js"></script>
	<script src="/js/config.js"></script>
	<script src="/js/syn/system/sccheck/scentback/scentback_excel.js"></script>
</body>
</html>