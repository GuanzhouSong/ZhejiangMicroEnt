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
    <title>专项整治检查</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<style type="text/css">
</style>
<body class="pd10">
<div class="">
    <div class="">
        <form id="favorableForm">
            <input type="hidden" id="mainTaskUid"  name="uid" value="${SpecialRecTask.uid}"/>
            <input type="hidden"  name="taskState" value="01"/>
            <h3 style="color: orange;">检查任务基本信息</h3>
        	<table id="savetable" cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10">
        		<tr>
	                <td class="bg-gray right"><span style="color:red;">*</span>任务设置部门:</td>
	                <td colspan="3">
		                <div class="ipt-box pd0"> 
		                <select id="dutyDeptCode" name="dutyDeptCode" style="width: 200px" >
	                       <c:forEach var="codeDutydept" items="${codeDutydepts}" varStatus="status" >
		        		   <option value="${codeDutydept.deptCode}"  ${codeDutydept.deptCode==SpecialRecTask.dutyDeptCode?'selected':''}>${codeDutydept.deptName}</option>
	        		       </c:forEach>
	                 	</select> 
		                <input type="hidden" id="dutyDeptName" name="dutyDeptName" value="${SpecialRecTask.dutyDeptName}"/>
		                </div>
	                </td>
	            </tr>
        		<tr>
	               <td class="bg-gray right"><span style="color:red;">*</span>任务类型:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
			                <label><input type="radio" class="crossDepartFlag"  name="taskType" value="1" <c:if test="${SpecialRecTask.taskType == '1' }">checked="checked"</c:if>/>本部门专项整治检查</label>
			                <label><input type="radio" class="crossDepartFlag"  name="taskType" value="2" <c:if test="${SpecialRecTask.taskType == '2' }">checked="checked"</c:if>/>跨部门专项整治检查</label>
		                </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right" width="160">任务组织部门:</td>
	               <td colspan='${flag ==1?'3':'1'}'>
		                <div class="ipt-box pd0">
			                 <input type="text" id="orgDeptName" name="orgDeptName" class="ipt-txt" style="width: 300px" 
			                 value="${sysUser.userType =='1'?sysUser.departMent.deptName:sysUser.sysDepart.orgName}" readonly="readonly"/>
			                 <input type="hidden"  name="orgDeptCode" 
			                 value="${sysUser.userType =='1'?sysUser.departMent.deptCode:sysUser.sysDepart.adcode}" />
		                </div>
	               </td>
	              <c:if test="${flag !='1'}">
	                   <td class="bg-gray right">任务编号:</td>
	               	   <td>
		                  <div class="ipt-box pd0">
			                   <input type="text" id="taskCode" name="taskCode" class="ipt-txt" style="width: 300px" value="${SpecialRecTask.taskCode}" readonly="readonly"/>
		                  </div>
	              	    </td>
	              </c:if>
	            </tr>
	            <tr>
	               <td class="bg-gray right"><span style="color:red;">*</span>任务参与部门:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
		                		<input type="hidden" class="ipt-txt" name="partiDeptCode" id="taskInspectDeptCode" value="${SpecialRecTask.partiDeptCode}" /> 
		                	    <input type="text" class="ipt-txt" name="partiDeptName" id="taskInspectDeptName" value="${SpecialRecTask.partiDeptName}" placeholder ="请选择任务参与部门" readonly="readonly"/>
	                            <span class="add-icon" id="choselicDeptType">
	                                <i></i>
	                            </span>
			            </div>
	                </td>
	            </tr>
	            <tr>
	                <td class="bg-gray right"><span style="color:red;">*</span>检查任务名称:</td>
	                <td colspan="3">
		                <div class="ipt-box pd0"> 
		                 <input type="text" id="taskName" name="taskName" class="ipt-txt" style="width: 80%;" value="${SpecialRecTask.taskName}" maxlength="150"/>
		                </div>
	                </td>
	            </tr>
	            <tr>
	                <td class="bg-gray right"><span style="color:red;">*</span>任务期限:</td>
	                <td colspan="3">
		                <div class="ipt-box pd0">
			                 <input type="text" id="taskStartTime" name="taskStartTime"   readonly="readonly" style="width: 150px;cursor: pointer;"
			                  class="ipt-txt" value="<fmt:formatDate value="${SpecialRecTask.taskStartTime}" pattern="yyyy-MM-dd" />" required/>
			                  
			                 至<input type="text" id="taskEndTime" name="taskEndTime"  readonly="readonly" style="width: 150px;cursor: pointer;"
			                  class="ipt-txt" value="<fmt:formatDate value="${SpecialRecTask.taskEndTime}" pattern="yyyy-MM-dd" />" required/>
		                </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right">任务说明（2000字以内）：</td>
	               <td colspan="3">
		                <div class="ipt-box pd0">
		                <textarea cols="" id="taskContent" class="ipt-txt"  rows="" style="width:100%;height: 80px" name="taskContent" maxlength="500">${SpecialRecTask.taskContent}</textarea>
		                </div>
	               </td>
	            </tr>
	            </table> 
	    </form>
	        <div class="mt10">
	            <form id="qryForm">
	                <input type="hidden" id="taskUid" name="taskUid" value="${SpecialRecTask.uid}">
	                <h3 style="color: orange;">检查任务名单</h3>
					<div class="form-box mb10 mt10">
						<c:if test="${flag != 3}"> 
			             	<div class="clearfix mb5" id="waitrandom">
						    	<p class="fl"><input type="button" class="btn btn-sm" id="addPage" value="添加检查名单">
						    	<input type="button" class="btn btn-sm" id="exportEntBack" value="导入检查名单">
						    	<input type="button" class="btn btn-sm" id="delEntBack" value="删除检查名单">
						    	<input type="button" class="btn btn-sm" id="cleanEntBack" value="清空检查名单">
						    	</p>
							 </div>
			            </c:if>
					    <div class="form-list">
					        <div class="form-item clearfix">
					            <div class="col-4">
					                <label class="item-name col-4">统一代码/注册号：</label>
					                <div class="col-7">
					                    <div class="ipt-box col-12">
					                        <input type="text" id="regNO" name="unicodeOrReg" class="ipt-txt">
					                    </div>
					                </div>
					            </div>
					            <div class="col-4">
					                <label class="item-name col-4">企业名称：</label>
					                <div class="col-7">
					                    <div class="ipt-box col-12">
					                        <input type="text" id="entName" name="entName" class="ipt-txt">
					                    </div>
					                </div>
					            </div>
					            <div class="col-4">
					                <div class="col-7">
					                    <div class="btn-box">
							                <input type="button" value="查 询" id="qry" class="btn mr20">
							                <input type="button" value="重 置" id="reset" class="btn">
							            </div>
					                </div>
					            </div>
					        </div>
					        <div class="form-item clearfix">
					        </div>
					    </div>
					</div>
				    </form>
					<div>
					    <table border="0" id="scentback-table" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap">
					       <thead>
					        <tr>
					            <th>序号</th>
					            <th><input type="checkbox" id="checkboxallid"/>全选（当前页）</th>
					            <th>统一社会信用代码/注册号</th>
					            <th>企业名称</th>
					            <th>住所</th>
					            <th>登记机关</th>
					            <th>管辖单位</th>
					        </tr>
					        </thead>
					        <tbody id="invsral">
					        </tbody>
					    </table>
					</div>
		    </div>
			     
	             <div class="clearfix mt10 mb10">
		            <div class="center">
		             <c:if test="${flag != 3}"> 
		             	<button id="save" type="button" class="btn mr20">保存</button>
		             </c:if>
		                <button id="cancel" type="button" class="btn">关闭</button>
		            </div>
	            </div>
      </div>
</div>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/specialrec/specialrec_task_edit.js"></script>
</body>
<script>
window._CONFIG = {
		   chooseUrl:'${sysUser.userType == 2 ? "/syn" : "/reg"}',
		   viewFalg:'${flag}', 
		}
</script>
</html>