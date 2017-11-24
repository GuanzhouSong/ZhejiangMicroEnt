<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="renderer" content="webkit">
	<meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <title></title>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<style type="text/css">
</style>
<body class="pd10">
<div class="">
    <div class="">
        <form id="favorableForm">
        	<table id="savetable" cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10">
        		<tr>
	                <td class="bg-gray right" width="30%"><span style="color:red;">*</span>抽查计划部门:</td>
	                <td colspan="3" width="70%">
		                <div class="ipt-box pd0"> 
		                	${pubScWorkPlan.dutyDeptName }
		                </div>
	                </td>
	            </tr>
        		<tr>
	               <td class="bg-gray right">抽查计划类型:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
			                 ${pubScWorkPlan.crossDepartFlag=='1'?'本部门':''}
			                 ${pubScWorkPlan.crossDepartFlag=='2'?'跨部门':''}
		                </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right">抽查计划年度:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
			                <%-- <select id="planYear" name="planYear" style="width: 200px" disabled="disabled"  >
		                       <c:forEach var="nowYear" items="${yearList}" varStatus="status" >
			        		    <option value="${nowYear}"  ${nowYear==pubScWorkPlan.planYear?'selected':''}>${nowYear}</option>
		        		        </c:forEach>
		                 	</select>  --%>
		                 	${pubScWorkPlan.planYear}
		                </div>
	                </td>
	            </tr>
	            <tr>
	                <td class="bg-gray right"><span style="color:red;">*</span>抽查计划名称:</td>
	                <td colspan="3">
		                <div class="ipt-box pd0"> 
		                 <%-- <input type="text" id="planName" disabled="disabled" name="planName" class="ipt-txt" style="width: 300px" value="${pubScWorkPlan.planName}" maxlength="150"/> --%>
		                ${pubScWorkPlan.planName}
		                </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right"><span style="color:red;">*</span>抽查类型:</td>
	                  <td colspan="3">
		                <div id="licZoneDiv" class="ipt-box pd0">
		                ${pubScWorkPlan.planType=='1'?'定向':''}
		                ${pubScWorkPlan.planType=='2'?'不定向':''}
			                 <%-- <label><input type="radio" name="planType" ${pubScWorkPlan.planType=='1'?'checked':''}   value="1"  disabled="disabled" >定向  &nbsp;</label>
			                 <label><input type="radio" name="planType" ${pubScWorkPlan.planType=='2'?'checked':''} value="2" disabled="disabled" >不定向  &nbsp;</label>
			                  --%>
			             </div>
	                </td>
	            </tr> 
	            <tr>
	               <td class="bg-gray right"><span style="color:red;">*</span>计划活动期限:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
		                <fmt:formatDate value="${pubScWorkPlan.planStartTime}" pattern="yyyy-MM-dd" />
			                <%--  <input type="text" disabled="disabled"  id="planStartTime" name="planStartTime"   readonly="readonly" style="width: 150px;cursor: pointer;"
			                  class="ipt-txt" value="<fmt:formatDate value="${pubScWorkPlan.planStartTime}" pattern="yyyy-MM-dd" />" required/>
			                  --%> 
			                 至
			        <fmt:formatDate value="${pubScWorkPlan.planEndTime}" pattern="yyyy-MM-dd" />
			                <%--  <input type="text" id="planEndTime" disabled="disabled"  name="planEndTime"  readonly="readonly" style="width: 150px;cursor: pointer;"
			                  class="ipt-txt" value="<fmt:formatDate value="${pubScWorkPlan.planEndTime}" pattern="yyyy-MM-dd" />" required/> --%>
		                </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right"><span style="color:red;">*</span>责任单位（牵头处室）:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
		                	<%-- <input type="text" id="planLeadDeptName" disabled="disabled"  name="planLeadDeptName" class="ipt-txt" style="width: 300px" value="${pubScWorkPlan.planLeadDeptName}" maxlength="50"/> --%>
			            ${pubScWorkPlan.planLeadDeptName}
			            </div>
	                </td>
	            </tr>
	            <tr>
	                <td class="bg-gray right"><span style="color:red;">*</span>抽查范围及数量比例（地区）:</td>
	                <td colspan="3">
		                <div class="ipt-box pd0"> 
		                 <%-- <input type="text" id="planRange" disabled="disabled"  name="planRange" class="ipt-txt" style="width: 300px" value="${pubScWorkPlan.planRange}" maxlength="500"/> --%>
		                ${pubScWorkPlan.planRange}
		                </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right"><span style="color:red;"></span>发文文号:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
		                	<%-- <input type="text" id="planRemark" name="planRemark" class="ipt-txt" style="width: 300px" value="${pubScWorkPlan.planRemark}"  readonly="readonly"/> --%>
			            ${pubScWorkPlan.planRemark}
			            </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right"><span style="color:red;"></span>附件:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
		                	<span>
		                	<h6 class="download" style="text-align: left;">
		                	  <c:if test="${not empty pubScWorkPlan.fileName && not empty pubScWorkPlan.fileUrl}">
		                	  <a  id="dowFile" href="${sysUrl}/sccheck/pubscworkplan/getLetter.json?fileUrl=${pubScWorkPlan.fileUrl}&fName=${pubScWorkPlan.fileName}"><span  id="uploadFileName" style="font-size:15px;">${pubScWorkPlan.fileName}</span></a>
		                	  </c:if>
        					</h6>
        					</span>
			            </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right"><span style="color:red;"></span>计划制定部门:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
		                	<%-- <input type="text"   class="ipt-txt" value="${pubScWorkPlan.setDeptName}" readonly/> --%>
		                	${pubScWorkPlan.setDeptName}
			            </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right"><span style="color:red;"></span>设置人:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
		                	<%-- <input type="text"   class="ipt-txt" value="${pubScWorkPlan.setUserName}" readonly/> --%>
		                	${pubScWorkPlan.setUserName}
			            </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right"><span style="color:red;"></span>设置日期:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
			                  <%-- <input type="text"   class="ipt-txt" value="<fmt:formatDate value="${pubScWorkPlan.setTime}" pattern="yyyy-MM-dd" />" readonly/> --%>
			                  <fmt:formatDate value="${pubScWorkPlan.setTime}" pattern="yyyy-MM-dd" />
			            </div>
	                </td>
	            </tr>
	            </table>
             <div class="clearfix mt10 mb10">
	            <div class="center">
	                <button id="cancel" type="button" class="btn">关闭</button>
	            </div>
            </div>
        </form>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sccheck/scworkplan/scworkplan_detail_main.js"></script>
</body>
</html>