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
    <title>通知书</title>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
	<form id="taskForm" method="post">
	<input type="hidden" id="resultUid" name="resultUid" value="${pubScentResultDto.uid }">
   	<input type="hidden" id="priPID" name="priPID" value="${pubScentResultDto.priPID }">
	<input type="hidden" id="id" name="id" value="${pubScentResultMaterial.id }">
	<input type="hidden" id="uid" name="uid" value="${pubScentResultMaterial.uid }">
	<input type="hidden" id="checkDateFrom" name="checkDateFrom" value="">
	<input type="hidden" id="checkDateTo" name="checkDateTo" value="">
	<input type="hidden" id="fillDate" name="fillDate" value="">
	<input type="hidden" id="num" value="${num }">
     <h2 class="tzs-title">
         市场监管领域随机抽查通知书
     </h2>
     <div class="tzs-content">
         <div class="title">（${pubScentResultDto.entName }/${!empty pubScentResultDto.uniCode?pubScentResultDto.uniCode:pubScentResultDto.regNO}）：</div>
         <p class="tindent24">
             根据相关法律法规和《国务院关于“先照后证”改革后加强事中事后监管的意见》、《国务院办公厅关于推广随机抽查规范事中事后监管的通知》等相关规定，我部门决定对你单位进行抽查检查（抽查任务编号：<input type="text" readonly="readonly" class="ipt-txt2" value='${pubScentResultDto.taskCode }'>）。现将有关情况通知如下：
         </p>
         <p>一、抽查检查事项</p>
         <p class="tindent24">
         	<c:forEach var="pubSccheckItem" items="${pubSccheckItemList }" varStatus="status">
         		（${status.index + 1}）<u>${pubSccheckItem.checkName }</u>；
         	</c:forEach>
         </p>
         <p>二、检查时间和检查方法</p>
         <p class="tindent24">我部门将于<input type="text" id="checkDateFromYear" name="checkDateFromYear" value="${checkDateFromYear }" class="ipt-txt2 w60 center">年<input id="checkDateFromMonth" name="checkDateFromMonth" type="text" value="${checkDateFromMonth }" class="ipt-txt2 w32 center">月<input id="checkDateFromDay" name="checkDateFromDay" value="${checkDateFromDay }" type="text" class="ipt-txt2 w32 center">日 至 <input id="checkDateToYear" name="checkDateToYear" value="${checkDateToYear }" type="text" class="ipt-txt2 w60 center">年<input id="checkDateToMonth" name="checkDateToMonth" value="${checkDateToMonth }" type="text" class="ipt-txt2 w32 center">月<input id="checkDateToDay" name="checkDateToDay" value="${checkDateToDay }" type="text" class="ipt-txt2 w32 center">日期间对你单位进行检查，视情采取实地核查、书面检查、网络检测、检验检测、委托专业机构开展相关辅助性工作等方式。</p>
         <p>三、需要准备的资料 <a id="addColumn">添加信息栏</a></p>
         <p class="tindent24">请你单位在接受检查时，事先准备以下资料：</p>
         <div class="ready">
         <c:forEach var="material" items="${materialList }" varStatus="status">
         	<p class='tindent24 h32'>（${status.index + 1}）<input type='text' value='${material }' name='material${status.index + 1}' class='ipt-txt2 w450'><i class='tzs-close-icon'></i> <a class='del'>删除</a></p>
         </c:forEach>
         </div>
         <br><br>
         <p class="tindent24">请务必配合我部门依法开展抽查检查工作。对于不配合检查的，我部门将依法采取相应监管措施，并将不配合情况向社会公开。</p>
         <p class="tindent24">联系人：<input type="text" id="contactName" name="contactName" class="ipt-txt2 w120 mr40" value="${realName }">联系电话：<input id="contactTel" name="contactTel" type="text" class="ipt-txt2 w120" value="${phone }"></p>
         <div class="tzs-time fr">
             <p class="tr"><input type="text" class="ipt-txt2" id="deptment" name="deptment" value="${deptName }">（公章）</p>
             <p class="tr"><input id="fillDateYear" name="fillDateYear" value="${fillDateYear }" type="text" class="ipt-txt2 w60 center"> 年 <input id="fillDateMonth" name="fillDateMonth" value="${fillDateMonth }" type="text" class="ipt-txt2 w32 center"> 月 <input id="fillDateDay" name="fillDateDay" value="${fillDateDay }" type="text" class="ipt-txt2 w32 center"> 日</p>
         </div>
     </div>
     </form>
     <p class="center mb30 mt20">
	    <input type="button" class="btn mr20" id="save" value="保存">
	    <input type="button" class="btn mr20" id="print" value="打印" 
	    	<c:if test="${pubScentResultDto.admissionFlag!='1' }">style="display: none"</c:if>
	    >
	    <input type="button" class="btn" id="close" value="关闭">
    </p>
     
    <script src="/js/lib/require.js"></script>
	<script src="/js/config.js"></script>
	<script src="/js/syn/system/sccheck/scresult/scresultnotice_edit.js"></script>
</body>
</html>