<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="renderer" content="webkit">
	<meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <title>个体工商户年度报告收讫通知书</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/printer.css"/>"/>
</head>
<body>
<div class="right-top Noprint" style="width:600px;margin-right: 10%">
	<a href="javascript:Print();"><strong style="font-size:16px">打印</strong></a><br>
	<a href="javascript:PrintView();"><strong style="font-size:16px">预览</strong></a><br>
	<a href="javascript:PrintSetup();"><strong style="font-size:16px">设置</strong></a><br>
	<a id="closeBtn" href="javascript:	window.close();"><strong style="font-size:16px">关闭</strong></a>
</div>
<object height="0px" id="factory" viewastext="" classid="clsid:1663ed61-23eb-11d2-b92f-008048fdd814" codebase="/js/common/print/ScriptX.cab#version=6,2,433,14"> </object>
<object height="0px" id="WebBrowser" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>
<div id="printarea">
	<div class="print2" id="print2">
	</div>
</div>
 
<div class="mod mod-print" style="position:relative; bottom: 30px;">
			<div class="mod-print-hd">
	            <h1 style="font-family: 黑体;margin: 70px 0 90px 0;">个体工商户年度报告收讫通知书</h1>
	        </div>
	    <%
    	    String checkLegRep = URLDecoder.decode(request.getParameter("checkLegRep"),"UTF-8"); 
    	    String checkRegNo = URLDecoder.decode(request.getParameter("checkRegNo"),"UTF-8"); 
    	    String checkOperUserName = URLDecoder.decode(request.getParameter("checkOperUserName"),"UTF-8"); 
    	    String checkOperUserDeptName = URLDecoder.decode(request.getParameter("checkOperUserDeptName"),"UTF-8"); 
    	    String checkOperDate = request.getParameter("checkOperDate");
    	%>
	                  
	    <h2 style="text-indent:2em;">今收到<span style="text-decoration: underline;"><%=checkLegRep%></span>报送的<%=request.getParameter("year")%>年度个体工商户年度报告（注册号：<%=checkRegNo%>）。</h2> 
  		<h2 style="margin:130px 0 0 250px;">报告书接收人：<%=checkOperUserName%></h2>
  		<h2 style="margin:130px 0 0 250px;"><%=checkOperUserDeptName%></h2>
  		<h2 style="margin:90px 0 0 250px;">报告书接收日期：<%=checkOperDate%></h2>
        </div>
</body>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/common/print/printsetup.js"></script>
</html>
<style type="text/css">
h2 {
    display: block;
    -webkit-margin-before: 0.83em;
    -webkit-margin-after: 0.83em;
    -webkit-margin-start: 0px;
    -webkit-margin-end: 0px;
    font-size: 20px;
    letter-spacing: 2px;
    line-height: 38px;
    font-family: "宋体";
}
</style>
