<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>通知书打印页面</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" type="text/css" href="/css/printer.css"/>
</head>
<body class="pd10">
<div class="button Noprint" style="width:600px;">
    <a href="javascript:Print();"><strong style="font-size:16px">直接打印</strong></a>
    <a href="javascript:PrintView();"><strong style="font-size:16px">打印预览</strong></a>
    <a href="javascript:PrintSetup();"><strong style="font-size:16px">打印设置</strong></a>
    <a id="closeBtn" href="javascript:window.top.close();"><strong style="font-size:16px">关闭窗口</strong></a>
</div>
<object height="0px" id="factory" viewastext="" classid="clsid:1663ed61-23eb-11d2-b92f-008048fdd814" codebase="/js/common/print/ScriptX.cab#version=6,2,433,14"> </object>
<object height="0px" id="WebBrowser" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>
     <h2 class="tzs-title">
         市场监管领域随机抽查通知书
     </h2>
     <div class="tzs-content">
         <div class="title">（${pubScentResultDto.entName }/${!empty pubScentResultDto.uniCode?pubScentResultDto.uniCode:pubScentResultDto.regNO}）：</div>
         <p class="tindent24">
             根据相关法律法规和《国务院关于“先照后证”改革后加强事中事后监管的意见》、《国务院办公厅关于推广随机抽查规范事中事后监管的通知》等相关规定，我部门决定对你单位进行抽查检查（抽查任务编号：<u>${pubScentResultDto.taskCode }</u>）。现将有关情况通知如下：
         </p>
         <p>一、抽查检查事项</p>
         <p class="tindent24">
         	<c:forEach var="pubSccheckItem" items="${pubSccheckItemList }" varStatus="status">
         		（${status.index + 1}）<u>${pubSccheckItem.checkName }</u>；
         	</c:forEach>
         	
         </p>
         <p>二、检查时间和检查方法</p>
         <p class="tindent24">我部门将于<u>${checkDateFromYear }</u> 年 <u>${checkDateFromMonth }</u> 月 <u>${checkDateFromDay }</u> 日 至<u>${checkDateToYear }</u> 年 <u>${checkDateToMonth }</u> 月 <u>${checkDateToDay }</u> 日 期间对你单位进行检查，视情采取实地核查、书面检查、网络检测、检验检测、委托专业机构开展相关辅助性工作等方式。</p>
         <p>三、需要准备的资料 <a id="addColumn">添加信息栏</a></p>
         <p class="tindent24 ready">请你单位在接受检查时，事先准备以下资料：</p>
         
         <c:forEach var="material" items="${materialList }" varStatus="status">
         	<p class='tindent24 h32'>（${status.index + 1}）<u>${fn:substring(material,0 ,45 ) }</u><i class='tzs-close-icon'></i></p>
         	<c:forEach var="length" begin="45" end="${fn:length(material)}" step="45">
         		<p class='tindent24 h32'><u>${fn:substring(material,length ,length+45) }</u><i class='tzs-close-icon'></i></p>
         	</c:forEach>
         </c:forEach>
         <br><br>
         <p class="tindent24">请务必配合我部门依法开展抽查检查工作。对于不配合检查的，我部门将依法采取相应监管措施，并将不配合情况向社会公开。</p>
         <p class="tindent24">联系人：<u>${realName }</u> &nbsp;&nbsp;&nbsp;联系电话：<u>${phone }</u></p>
         <div class="tzs-time fr">
             <p class="tr"><u>${deptName }</u>（公章）</p>
             <p class="tr"><u>${fillDateYear }</u> 年 <u>${fillDateMonth }</u> 月 <u>${fillDateDay }</u> 日</p>
         </div>
     </div>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/common/print/printsetup.js"/>"></script>
<script src="<c:url value="/js/common/print/print.js"/>"></script>
</body>
</html>