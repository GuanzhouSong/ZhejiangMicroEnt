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
	                <td class="bg-gray right"><span style="color:red;">*</span>任务设置部门:</td>
	                <td colspan="3">
		                <div class="ipt-box pd0"> 
		                <select id="dutyDeptCode" name="dutyDeptCode" style="width: 200px" >
	                       <c:forEach var="codeDutydept" items="${codeDutydepts}" varStatus="status" >
		        		   <option value="${codeDutydept.deptCode}"  ${codeDutydept.deptCode==pubScPlanTask.dutyDeptCode?'selected':''}>${codeDutydept.deptName}</option>
	        		       </c:forEach>
	                 	</select> 
		                <input type="hidden" id="dutyDeptName" name="dutyDeptName" value="${pubScPlanTask.dutyDeptName}"/>
		                </div>
	                </td>
	            </tr>
        		<tr>
	               <td class="bg-gray right"><span style="color:red;">*</span>任务类型:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
			                <input type="radio" class="crossDepartFlag" name="crossDepartFlag" value="1" <c:if test="${pubScPlanTask.crossDepartFlag == '1' }">checked="checked"</c:if>/>本部门双随机抽查
			                <input type="radio" class="crossDepartFlag" name="crossDepartFlag" value="2" <c:if test="${pubScPlanTask.crossDepartFlag == '2' }">checked="checked"</c:if>/>跨部门双随机抽查
		                </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right" width="160">任务组织部门:</td>
	               <td>
		                <div class="ipt-box pd0">
			                 <input type="text" id="taskLeadDeptName" name="taskLeadDeptName" class="ipt-txt" style="width: 300px" value="${deptName}" readonly="readonly"/>
		                </div>
	               </td>
	               <c:if test="${flag=='2'}">
		               <td class="bg-gray right">任务编号:</td>
		               <td>
			                <div class="ipt-box pd0">
				                 <input type="text" id="taskCode" name="taskCode" class="ipt-txt" style="width: 300px" value="${pubScPlanTask.taskCode}" readonly="readonly"/>
			                </div>
		               </td>
	               </c:if>
	               <c:if test="${flag=='1'}">
		               <td class="bg-gray right">
		               	<c:if test="${sysUser.dutyDeptCodes == 'A014' }">任务编号:</c:if>
		               </td>
		               <td>
			                <div class="ipt-box pd0"> 
			                	<c:if test="${sysUser.dutyDeptCodes == 'A014' }">
			                		<select name="otherDocName" style="width:20%;">
			                			<option></option>
			                			<option value="禁毒">禁毒</option>
			                		</select>
			                		特殊字号选择，例：浙公<span style="color:red;"><strong>禁毒</strong></span>抽查〔2017〕1号；如不选，则默认浙公抽查〔2017〕1号
			                	</c:if>
			                </div>
		               </td>
	               </c:if>
	            </tr>
	           <tr>
	               <td class="bg-gray right"><span style="color:red;">*</span>任务来源:</td>
	                  <td colspan="3">
		                <div id="licZoneDiv" class="ipt-box">
		                	<div class="fl lh30">
			                 	<label id="lsTatsk"><input type="radio" name="taskResource" ${pubScPlanTask.taskResource=='1'?'checked':''}   value="1"  >临时任务  &nbsp;</label>
			                 	<label id="yearPlan"><input type="radio" name="taskResource" ${pubScPlanTask.taskResource=='2'?'checked':''} value="2" >年度抽查工作计划  &nbsp;</label>
			            	</div>
			            <select id="planYear"  style="width: 80px">
			               <c:forEach var="year" items="${yearList}" varStatus="status" >
		        		   	<option value="${year}">${year}</option>
	        		       </c:forEach>
			            </select>
			            <div id="licZoneDiv" class="ipt-box dib2" style="width:500px">
			            <input type="hidden" id="resourcePlanUid" name="resourcePlanUid" value="${pubScPlanTask.resourcePlanUid}">
			            <input type="text" class="ipt-txt" name="resourcePlanName" id="resourcePlanName" value="${pubScPlanTask.resourcePlanName}" placeholder ="请选择对应的抽查工作计划" readonly="readonly"/>
	                            <span class="add-icon" id="choseDept">
	                                <i></i>
	                            </span> </div>
			            </div>
	                </td>
	            </tr> 
	            <tr>
	                <td class="bg-gray right"><span style="color:red;">*</span>抽查任务名称:</td>
	                <td colspan="3">
		                <div class="ipt-box pd0"> 
		                 <input type="text" id="taskName" name="taskName" class="ipt-txt" style="width: 80%;" value="${pubScPlanTask.taskName}" maxlength="150"/>
		                </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right"><span style="color:red;">*</span>抽查类型:</td>
	                  <td>
		                <div id="licZoneDiv" class="ipt-box pd0">
			                 <label><input type="radio" id="taskType1" name="taskType" ${pubScPlanTask.taskType=='1'?'checked':''}   value="1" >定向  &nbsp;</label>
			                 <label><input type="radio" id="taskType2" name="taskType" ${pubScPlanTask.taskType=='2'?'checked':''} value="2" >不定向  &nbsp;</label>
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
		                		<input type="hidden" class="ipt-txt" name="taskInspectDeptCode" id="taskInspectDeptCode" value="${pubScPlanTask.taskInspectDeptCode}" /> 
		                	    <input type="text" class="ipt-txt" name="taskInspectDeptName" id="taskInspectDeptName" value="${pubScPlanTask.taskInspectDeptName}" placeholder ="请选择任务参与部门" readonly="readonly"/>
	                            <span class="add-icon" id="choselicDeptType">
	                                <i></i>
	                            </span>
			            </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right">任务说明（2000字以内）：</td>
	               <td colspan="3">
		                <div class="ipt-box pd0">
		                <textarea cols="" id="taskContent" class="ipt-txt"  rows="" style="width:100%;height: 80px" name="taskContent" maxlength="500">${pubScPlanTask.taskContent}</textarea>
		                </div>
	               </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right"><span style="color:red;">*</span>抽取对象是否公示：</td>
	               <td colspan="3">
		                <div class="ipt-box pd0">
		                <label><input type="radio" name="publicFlag" ${pubScPlanTask.publicFlag=='1'?'checked':''}   value="1" >公示抽取名单  &nbsp;</label>
			                 <label><input type="radio" name="publicFlag" ${pubScPlanTask.publicFlag=='2' || empty pubScPlanTask.publicFlag?'checked':''} value="2" >不公示抽取名单  &nbsp;</label>
		                </div>
	               </td>
	            </tr>
	            </table> 
	            
	            
	             <div class="clearfix mb5 mt5">
			        <p class="fl"><input type="button" id="addSccheckType" class="btn btn-sm mr5" value="添加检查事项"></p>
			        <p class="fl"><input type="button" id="addOtherSccheckType" class="btn btn-sm mr5" value="添加其他检查事项"></p>
			     </div> 
                <table  border="0" cellspacing="0" cellpadding="0" class="table-row" width="100%">
                   <thead>
                   <tr>
                       <th width="8%">序号</th>
                       <th width="10%">操作</th>
                       <th width="12%">检查类别</th>
                       <th width="35%">检查事项</th>
                       <th width="35%">说明</th>
                   </tr>
                   </thead>
                   <tbody id="invsral">
                          <c:if test="${flag=='2'}">
                          <%-- 	<c:if test="${empty pubSccheckItemList}">
			        		<tr>
			        			<td colspan="5" style="text-align:center;">无</td>
			        		</tr>
			        		</c:if> --%>
			        		<c:if test="${not empty pubSccheckItemList}">
	                   		<c:forEach var="pubSccheckItemList" items="${pubSccheckItemList}" varStatus="status">
				        		<tr data-id="tid${status.count}" data-index="${status.count}"  id="tid${status.count}"> 
								    <input  type="hidden" id="pubSccheckItemList${status.count}checkType" name="pubSccheckItemList[${status.count}].checkType" value="${pubSccheckItemList.checkType}" />
								    <input  type="hidden" id="pubSccheckItemList${status.count}checkTypeName" name="pubSccheckItemList[${status.count}].checkTypeName" value="${pubSccheckItemList.checkTypeName}" />
								    <input  type="hidden" id="pubSccheckItemList${status.count}checkCode" name="pubSccheckItemList[${status.count}].checkCode"   value="${pubSccheckItemList.checkCode}" />
								    <input  type="hidden" id="pubSccheckItemList${status.count}checkName" name="pubSccheckItemList[${status.count}].checkName"   value="${pubSccheckItemList.checkName}" />
                                    <td >${status.count}</td>
				        			<td ><a href="javascript:void(0)" class="js-yrinfo">删 除</a></td>
				        			<td >${pubSccheckItemList.checkTypeName}</td>
				        			<td >${pubSccheckItemList.checkName}</td>
				        			<td >
				        			 <input type="text" id="pubSccheckItemList${status.count}remark" name="pubSccheckItemList[${status.count}].remark" class="ipt-txt"  style="width: 90%;height: 80%;" value="${pubSccheckItemList.remark}" maxlength="500">
				        			</td>
				        		</tr>
			        		</c:forEach> 
			        		</c:if>
                          </c:if>
                   </tbody>
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

 <script id="invsral-template" type="text/x-handlebars-template">
      {{#each this}}
           <tr data-id="tid{{addOne @index}}" data-index="{{addOne @index}}"  id="tid{{addOne @index}}">
			    <input  type="hidden" id="pubSccheckItemList{{addOne @index}}checkType" name="pubSccheckItemList[{{addOne @index}}].checkType" value="{{pCode}}" />
			    <input  type="hidden" id="pubSccheckItemList{{addOne @index}}checkTypeName" name="pubSccheckItemList[{{addOne @index}}].checkTypeName" value="{{deptCode}}" />
			    <input  type="hidden" id="pubSccheckItemList{{addOne @index}}checkCode" name="pubSccheckItemList[{{addOne @index}}].checkCode"   value="{{code}}" />
			    <input  type="hidden" id="pubSccheckItemList{{addOne @index}}checkName" name="pubSccheckItemList[{{addOne @index}}].checkName"   value="{{content}}" />
			    <td>{{addOne @index}}</td>
                <td> {{{transType code}}}</td>
                <td> {{deptCode}}</td>
                <td> {{content}}</td>
                <td><input type="text" id="pubSccheckItemList{{addOne @index}}remark" name="pubSccheckItemList[{{addOne @index}}].remark" class="ipt-txt"  style="width: 90%;height: 80%;"  value="{{id}}" maxlength="500"></td>
           </tr>
      {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sccheck/scplantask/scplantask_edit_main.js"></script>
</body>
<script>
    window._CONFIG = {
    		_sysUrl:'${sysUrl}',
    		_viewFalg:'${flag}',
    		_taskResource:'${pubScPlanTask.taskResource}'
    }
</script>
</html>