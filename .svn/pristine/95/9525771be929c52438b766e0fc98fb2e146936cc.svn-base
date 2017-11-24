<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>联络员确认书打印页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/printer.css"/>"/>
</head>
<body>
<div class="right-top Noprint" style="width:600px;margin-right: 10%">
	<a href="javascript:Print();"><strong style="font-size:16px">打印</strong></a><br>
	<a href="javascript:PrintView();"><strong style="font-size:16px">预览</strong></a><br>
	<a href="javascript:PrintSetup();"><strong style="font-size:16px">设置</strong></a><br>
	<a id="closeBtn" href="javascript:window.close();"><strong style="font-size:16px">关闭</strong></a>
</div>
<object height="0px" id="factory" viewastext="" classid="clsid:1663ed61-23eb-11d2-b92f-008048fdd814" codebase="/js/common/print/ScriptX.cab#version=6,2,433,14"> </object>
<object height="0px" id="WebBrowser" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>
<div id="printarea">
	<div class="print2" id="print2">
	</div>
</div>
 
<div class="mod mod-print" style="position:relative; bottom: 30px;">
			<div class="mod-print-hd">
	            <h1 style="font-family: 黑体">企业联络员备案表收讫回执单</h1>
	        </div>
	            <br/>
	            <br/>
	            <table class="table-print" cellpadding="0" cellspacing="0" border="0" width="100%">
	            	<h3 style="font-size: 16px;">&nbsp;&nbsp;&nbsp;&nbsp;今收到
	            	<span class="unline">&nbsp;&nbsp;&nbsp;&nbsp;${pubEppassword.entname}(企业名称)，统一代码/注册号：${(empty pubEppassword.unicode)?pubEppassword.regno:pubEppassword.unicode}</span>提交的企业联络员备案表（流水号${pubEppassword.pasid}），就企业联络员信息确认如下:</h3>
	            	<br/>
	            	<br/>
	                <tr>
	                    <td>企业法定代表人<br/>（负责人）姓名</td>
	                    <td class="col-l">${pubEppassword.lerep}</td>
	                    <td>手机号码</td>
	                    <td class="col-l">${pubEppassword.lerepphone}</td>
	                </tr>
	                <tr>
	                    <td>企业联络员姓名</td>
	                    <td class="col-l">${pubEppassword.lianame}</td>
	                    <td>手机号码<br/>（接收验证码）</td>
	                    <td class="col-l">${pubEppassword.tel}</td>
	                </tr>
	                <tr>
	                    <td>联络员身份证件类型</td>
	                    <td class="col-l">
		                   <c:forEach var="codeCertype" items="${codeCertypeList}" varStatus="">
				              <c:if test="${codeCertype.code == pubEppassword.liaidtype}">
				                ${codeCertype.content}
				              </c:if>
				           </c:forEach>
	                    </td>
	                    <td>联络员身份证件号码</td>
	                    <td class="col-l">${pubEppassword.liaidnum}</td>
	                </tr>
	                </table>
	                <br/>
	                <br/>
	           		<table border="0" cellpadding="0" cellspacing="2">
	           			<tr style="line-height: 60px;">
	           				<td style="font-family:仿宋_GB2312;padding-left:280px;"><h2 style="font-size: 22px;"><strong>备案表接收人：${sessionScope.session_sys_user.realName}<span></span></strong></h2></td>
	           			</tr>
	           			<tr style="line-height: 60px;">
	           				<td style="font-family:仿宋_GB2312;padding-left:280px;"><h2 style="font-size: 22px;"><strong>备案表接收部门：${sessionScope.session_sys_user.departMent.deptName}<span></span></strong></h2></td>
	           			</tr>
	           			<tr style="line-height: 60px;">
	           				<td style="font-family:仿宋_GB2312;padding-left:280px;"><h2 style="font-size: 22px;"><strong>备案表接收日期：<fmt:formatDate value="${pubEppassword.applytime }" pattern="yyyy-MM-dd" /> </strong></h2></td>
	           			</tr>
	           		</table>
        </div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/common/print/printsetup.js"></script>
<script src="/js/common/print/print.js"></script>
</body>
</html>
