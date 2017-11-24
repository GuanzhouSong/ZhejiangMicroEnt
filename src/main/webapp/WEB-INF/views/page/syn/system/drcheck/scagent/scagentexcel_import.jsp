<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<!-- 			<label for="">请上传文件（仅限Excel文件）</label> -->
            <input type="hidden" id="dutyDeptCode" value="${dutyDeptCode}"/>
            <input type="hidden" id="userType" value="${userType}"/>
			<table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10 f12">
			<c:if test="${userType == '1' || dutyDeptCode == 'A058'}">
			   <tr>
	                <td class="bg-gray right" width="30%"><span class="light">*</span>工作单位：</td>
	                <td>
	                    <div class="ipt-box pd0">
	                      <input type="hidden" name="slicenNO" id="localAdm" value="${pubScagent.slicenNO}"/>
	                      <input type="text" class="ipt-txt" id="localAdmName" value="${codeRegunitDesc}" placeholder="请选择工作单位" readonly/>
	                      <span class="add-icon" id="choseregUnit">
	                           <i></i>
	                      </span>
	                    </div>
	                </td>
            	</tr>
			</c:if>
			<c:if test="${userType == '2' && fn:indexOf(dutyDeptCode, 'A058') == -1}">
			     <tr>
	                <td class="bg-gray right" width="30%"><span class="light">*</span>工作单位：</td>
	                <td>
	                    <div class="ipt-box pd0">
	                      <input type="hidden" name="slicenNO" id="localAdm" value="${pubScagent.slicenNO}"/>
	                      <input type="text" class="ipt-txt" id="deptName" name="slicenNOName"  value="${codeRegunitDesc}" placeholder="请选择工作单位" readonly/>
	                      <span class="add-icon" id="deptChoose">
	                           <i></i>
	                      </span>
	                    </div>
	                </td>
            	</tr>
			</c:if>
            <tr>
            	<td class="bg-gray right" width="30%"><span class="light">*</span>excel上传：</td>
            	<td>
            		<div class="ipt-box pd0">
            		<input type="text" class="ipt-txt" id="js-excel-file" readonly style="display: none;">
<!-- 					<input type="button" value="浏览.." id="viewbtn" class="ipt-btn js-ipt-btn" style="cursor: pointer;">  -->
					<input name="file" type="file" id="js-file-btn">
					<c:if test="${userType == '1'  || fn:indexOf(dutyDeptCode, 'A058')!=-1 || fn:indexOf(dutyDeptCode, 'A012')!=-1 || fn:indexOf(dutyDeptCode, 'A027')!=-1}">
						<a href="/syn/server/drcheck/pubscagent/downloadExcel?file_name=randomscagent.xls" id="js-download">下载excel模板</a>
					</c:if>
					<c:if test="${userType == '2' && fn:indexOf(dutyDeptCode, 'A058') == -1 && fn:indexOf(dutyDeptCode, 'A012') == -1 && fn:indexOf(dutyDeptCode, 'A027') == -1}">
					    <a href="/syn/server/drcheck/pubscagent/downloadExcel?file_name=randomscagentsyn.xls" id="js-download">下载excel模板</a>
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
	<script src="/js/syn/system/drcheck/scagent/scagentexcel_import.js"></script>
</body>
</html>