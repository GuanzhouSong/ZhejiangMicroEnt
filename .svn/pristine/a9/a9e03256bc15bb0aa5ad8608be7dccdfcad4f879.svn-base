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
            <input type="hidden"  name="uid" value="${pubScWorkPlan.uid}"/>
        	<table id="savetable" cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10">
        		 <tr>
	                <td class="bg-gray right"><span style="color:red;">*</span>抽查计划部门:</td>
	                <td colspan="3">
		                <div class="ipt-box pd0"> 
		                <select id="dutyDeptCode" name="dutyDeptCode" style="width: 200px" >
	                       <c:forEach var="codeDutydept" items="${codeDutydepts}" varStatus="status" >
		        		   <option value="${codeDutydept.deptCode}"  ${codeDutydept.deptCode==pubScWorkPlan.dutyDeptCode?'selected':''}>${codeDutydept.deptName}</option>
	        		       </c:forEach>
	                 	</select> 
		                <input type="hidden" id="dutyDeptName" name="dutyDeptName" value="${pubScWorkPlan.dutyDeptName}"/>
		                </div>
	                </td>
	            </tr>
        		<tr>
	               <td class="bg-gray right">抽查计划类型:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
			                <input type="radio" name="crossDepartFlag" value="1" <c:if test="${empty pubScWorkPlan.crossDepartFlag || pubScWorkPlan.crossDepartFlag == '1' }">checked="checked"</c:if>/>本部门
			                <input type="radio" name="crossDepartFlag" value="2" <c:if test="${pubScWorkPlan.crossDepartFlag == '2' }">checked="checked"</c:if>/>跨部门
		                </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right">抽查计划年度:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
			                <select id="planYear" name="planYear" style="width: 200px" required >
		                       <c:forEach var="nowYear" items="${yearList}" varStatus="status" >
			        		    <option value="${nowYear}"  ${nowYear==pubScWorkPlan.planYear?'selected':''}>${nowYear}</option>
		        		        </c:forEach>
		                 	</select> 
		                </div>
	                </td>
	            </tr>
	            <tr>
	                <td class="bg-gray right"><span style="color:red;">*</span>抽查计划名称:</td>
	                <td colspan="3">
		                <div class="ipt-box pd0"> 
		                 <input type="text" id="planName" name="planName" class="ipt-txt" style="width: 80%;" value="${pubScWorkPlan.planName}" maxlength="150"/>
		                </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right"><span style="color:red;">*</span>抽查类型:</td>
	                  <td colspan="3">
		                <div id="licZoneDiv" class="ipt-box pd0">
			                 <label><input type="radio" name="planType" ${pubScWorkPlan.planType=='1'?'checked':''}   value="1" >定向  &nbsp;</label>
			                 <label><input type="radio" name="planType" ${pubScWorkPlan.planType=='2'?'checked':''} value="2" >不定向  &nbsp;</label>
			            </div>
	                </td>
	            </tr> 
	            <tr>
	               <td class="bg-gray right"><span style="color:red;">*</span>计划活动期限:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
			                 <input type="text" id="planStartTime" name="planStartTime"   readonly="readonly" style="width: 150px;cursor: pointer;"
			                  class="ipt-txt" value="<fmt:formatDate value="${pubScWorkPlan.planStartTime}" pattern="yyyy-MM-dd" />" required/>
			                  
			                 至<input type="text" id="planEndTime" name="planEndTime"  readonly="readonly" style="width: 150px;cursor: pointer;"
			                  class="ipt-txt" value="<fmt:formatDate value="${pubScWorkPlan.planEndTime}" pattern="yyyy-MM-dd" />" required/>
		                </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right"><span style="color:red;">*</span>责任单位（牵头处室）:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
		                	<input type="text" id="planLeadDeptName" name="planLeadDeptName" class="ipt-txt" style="width: 80%;" value="${pubScWorkPlan.planLeadDeptName}" maxlength="50"/>
			            </div>
	                </td>
	            </tr>
	            <tr>
	                <td class="bg-gray right"><span style="color:red;">*</span>抽查范围及数量比例（地区）:</td>
	                <td colspan="3">
		                <div class="ipt-box pd0"> 
		                 <input type="text" id="planRange" name="planRange" class="ipt-txt" style="width: 80%;" value="${pubScWorkPlan.planRange}" maxlength="500"/>
		                </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right"><span style="color:red;"></span>发文文号:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
		                	<input type="text" id="planRemark" name="planRemark" class="ipt-txt" style="width: 80%;" value="${pubScWorkPlan.planRemark}" maxlength="200"/>
			            </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right"><span style="color:red;"></span>附件:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
		                	<input type="hidden" name="fileUrl" id="fileUrl" value="${pubScWorkPlan.fileUrl}">
		                	<input type="hidden" name="fileName" id="fileName" value="${pubScWorkPlan.fileName}">
	                        <input id="btnFile_4" type="file" class="w320" name="btnFile"> 
		                	<input type="button" id="btnUpload_4" value="上传" class="btn">
		                	<span>
		                	<h6 class="download" style="text-align: left;">
		                	  <%-- <c:if test="${flag=='2' && not empty pubScWorkPlan.fileName && not empty pubScWorkPlan.fileUrl}">
		                	  <a  id="dowFile" href="${sysUrl}/sccheck/pubscworkplan/getLetter.json?fileUrl=${pubScWorkPlan.fileUrl}&fName=${pubScWorkPlan.fileName}"><span  id="uploadFileName">${pubScWorkPlan.fileName}</span></a>
		                	  </c:if> --%>
		                	 <%--  <c:if test="${flag=='1'}"> --%>
		                	  <a  id="dowFile" href="javascript:void(0);"><span  id="uploadFileName" style="font-size:15px;"></span></a>
		                	 <%--  </c:if> --%>
        					</h6>
        					</span>
			            </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right"><span style="color:red;"></span>计划制定部门:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
		                	<input type="text"   class="ipt-txt" value="${flag=='2'?pubScWorkPlan.setDeptName:deptName}" readonly/>
			            </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right"><span style="color:red;"></span>设置人:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
		                	<input type="text"   class="ipt-txt" value="${flag=='2'?pubScWorkPlan.setUserName:sysUser.realName}" readonly/>
			            </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right"><span style="color:red;"></span>设置日期:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
		                	<c:if test="${flag=='1'}">
			                  <input type="text"   class="ipt-txt" value="<fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd" />" readonly/> 
			                </c:if>
			                <c:if test="${flag=='2'}">
			                  <input type="text"   class="ipt-txt" value="<fmt:formatDate value="${pubScWorkPlan.setTime}" pattern="yyyy-MM-dd" />" readonly/>
			                </c:if>
			            </div>
	                </td>
	            </tr>
	           </table>
             <div class="clearfix mt10 mb10">
	            <div class="center">
	                <button id="save" type="button" class="btn mr20">保存</button>
	                <button id="cancel" type="button" class="btn">关闭</button>
	            </div>
            </div>
        </form>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sccheck/scworkplan/scworkplan_edit_main.js"></script>
</body>
<script>
    window._CONFIG = {
    		_sysUrl:'${sysUrl}',
    		_viewFalg:'${flag}'
    }
</script>
</html>