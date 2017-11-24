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
            <input type="hidden"  name="uid" value="${pubScPlanTask.uid}"/>
        	<table id="savetable" cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10">
        		<tr>
        		    <td class="bg-gray right" width="30%"><span style="color:red;">*</span>抽查计划部门:</td>
	                <td colspan="3" width="70%">
		                <div class="ipt-box pd0"> 
		                	${pubScPlanTask.dutyDeptName }
		                </div>
	                </td>
	            </tr>
        		<tr>
	               <td class="bg-gray right">抽查计划类型:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
			                 ${pubScPlanTask.crossDepartFlag=='1'?'本部门':''}
			                 ${pubScPlanTask.crossDepartFlag=='2'?'跨部门':''}
		                </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right" width="160">任务组织部门:</td>
	               <td>
		                <div class="ipt-box pd0">
			                 <%-- <input type="text" id="taskLeadDeptName" name="taskLeadDeptName" class="ipt-txt" style="width: 300px" value="${pubScPlanTask.taskLeadDeptName}" readonly="readonly"/> --%>
			                 ${pubScPlanTask.taskLeadDeptName}
		                </div>
	               </td>
	               <td class="bg-gray right">任务编号:</td>
	               <td>
		                <div class="ipt-box pd0">
			                 <%-- <input type="text" id="taskCode" name="taskCode" class="ipt-txt" style="width: 300px" value="${pubScPlanTask.taskCode}" readonly="readonly"/> --%>
			                 ${pubScPlanTask.taskCode}
		                </div>
	               </td>
	            </tr>
	           <tr>
	               <td class="bg-gray right"><span style="color:red;">*</span>任务来源:</td>
	                  <td colspan="3">
		                <div id="licZoneDiv" class="ipt-box">
		                	<div class="fl lh30">
			                 	<label id="lsTatsk"><input type="radio" name="taskResource" ${pubScPlanTask.taskResource=='1'?'checked':''}   value="1"  disabled="disabled">临时任务  &nbsp;</label>
			                 	<label id="yearPlan"><input type="radio" name="taskResource" ${pubScPlanTask.taskResource=='2'?'checked':''} value="2" disabled="disabled">年度抽查工作计划  &nbsp;</label>
			                </div>
			            <div id="licZoneDiv" class="ipt-box dib2 w754">
			            <c:if test="${pubScPlanTask.taskResource=='2'}">
			            	<input type="text" class="ipt-txt" name="resourcePlanName" id="resourcePlanName" value="${pubScPlanTask.resourcePlanName}" readonly="readonly"/>
	                    </c:if>
			            </div>
	                </td>
	            </tr> 
	            <tr>
	                <td class="bg-gray right"><span style="color:red;">*</span>抽查任务名称:</td>
	                <td colspan="3">
		                <div class="ipt-box pd0"> 
		                 <%-- <input type="text" id="taskName" name="taskName" class="ipt-txt" style="width: 300px" value="${pubScPlanTask.taskName}" maxlength="150" readonly="readonly"/> --%>
		                 ${pubScPlanTask.taskName}
		                </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right"><span style="color:red;">*</span>抽查类型:</td>
	                  <td>
		                <div id="licZoneDiv" class="ipt-box pd0">
			                 <label><input type="radio" name="taskType" ${pubScPlanTask.taskType=='1'?'checked':''}   value="1" disabled="disabled">定向  &nbsp;</label>
			                 <label><input type="radio" name="taskType" ${pubScPlanTask.taskType=='2'?'checked':''} value="2" disabled="disabled">不定向  &nbsp;</label>
			            </div>
	                </td>
	                <td class="bg-gray right"><span style="color:red;">*</span>任务期限:</td>
	                <td>
		                <div class="ipt-box pd0">
			                 <input type="text" id="taskStartTime" name="taskStartTime"   readonly="readonly" style="width: 150px;cursor: pointer;"
			                  class="ipt-txt" value="<fmt:formatDate value="${pubScPlanTask.taskStartTime}" pattern="yyyy-MM-dd" />" required/>
			                  
			                 至<input type="text" id="taskEndTime" name="taskEndTime"  readonly="readonly" style="width: 150px;cursor: pointer;"
			                  class="ipt-txt" value="<fmt:formatDate value="${pubScPlanTask.taskEndTime}" pattern="yyyy-MM-dd" />" required/>
		                </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right"><span style="color:red;">*</span>任务参与部门:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
		                		<%-- <input type="hidden" class="ipt-txt" name="taskInspectDeptCode" id="taskInspectDeptCode" value="${pubScPlanTask.taskInspectDeptCode}" /> 
		                	    <input type="text" class="ipt-txt" name="taskInspectDeptName" id="taskInspectDeptName" value="${pubScPlanTask.taskInspectDeptName}" placeholder ="请选择任务实施部门" readonly="readonly"/>
	                    --%> 
	                    ${pubScPlanTask.taskInspectDeptName}
	                    </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right">任务说明：</td>
	               <td colspan="3">
		                <div class="ipt-box pd0">
		               <%--  <textarea cols="" id="taskContent" class="ipt-txt"  rows="" style="width:100%;height: 80px" name="taskContent" maxlength="500" readonly="readonly">${pubScPlanTask.taskContent}</textarea> --%>
		               ${pubScPlanTask.taskContent}
		                </div>
	               </td>
	            </tr>
	             <tr>
	               <td class="bg-gray right">抽取对象是否公示：</td>
	               <td colspan="3">
		                <div class="ipt-box pd0">
		                <label><input type="radio" name="publicFlag" ${pubScPlanTask.publicFlag=='1'?'checked':''}   value="1"  disabled="disabled">公示抽取名单  &nbsp;</label>
			                 <label><input type="radio" name="publicFlag" ${pubScPlanTask.publicFlag=='2'?'checked':''} value="2" disabled="disabled">不公示抽取名单  &nbsp;</label>
		                </div>
	               </td>
	            </tr>
	            </table> 
	            <br>
	            <br>
	            
	            <div class="clearfix mb5 mt5">
			        <p class="fl">检查事项</p>
			    </div> 
                <table  border="0" cellspacing="0" cellpadding="0" class="table-row" width="100%">
                   <thead>
                   <tr>
                       <th width="8%">序号</th>
                       <th width="12%">检查类别</th>
                       <th width="40%">检查事项</th>
                       <th width="40%">说明</th>
                   </tr>
                   </thead>
                   <tbody id="invsral">
                     	<%-- <c:if test="${empty pubSccheckItemList}">
		        		<tr>
		        			<td colspan="4" style="text-align:center;">无</td>
		        		</tr>
		        		</c:if> --%>
		        		<c:if test="${not empty pubSccheckItemList}">
                   		<c:forEach var="pubSccheckItemList" items="${pubSccheckItemList}" varStatus="status">
			        		<tr>
			        		
			        			<td >${status.count}</td>
			        			<td >${pubSccheckItemList.checkTypeName}</td>
			        			<td >${pubSccheckItemList.checkName}</td>
			        			<td >${pubSccheckItemList.remark} </td>
			        		</tr>
		        		</c:forEach> 
		        		</c:if>
                   </tbody>
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
<script src="/js/syn/system/sccheck/scplantask/scplantask_detail_main.js"></script>
</body>
<script>
    window._CONFIG = {
    		_sysUrl:'${sysUrl}',
    		_viewFalg:'${flag}'
    }
</script>
</html>