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
	                <td width="18%" class="bg-gray right">统一信用代码/注册号:</td>
	                <td width="32%">
		                <div class="ipt-box pd0">
		                <input type="text" class="ipt-txt"  value="${empty baseInfo.uniCode?baseInfo.regNO:baseInfo.uniCode}" readonly="readonly">
		                </div>
	                </td>
	                <td width="18%" class="bg-gray right">企业名称:</td>
		            <td width="32%">
		                <div class="ipt-box pd0">
		                <input type="text" name="entName" class="ipt-txt" value="${baseInfo.entName}" readonly="readonly">
	                    </div>
	                </td>
	            </tr>
	            <tr>
	                <td class="bg-gray right">法定代表人:</td>
	                <td>
		                <div class="ipt-box pd0">
		                 <input type="text" name="" class="ipt-txt" value="${baseInfo.leRep}">
		                </div>
	                </td>
	                <td class="bg-gray right">登记机关:</td>
	                <td>
		                <div class="ipt-box pd0">
		                <input type="text" name="" class="ipt-txt" value="${baseInfo.regOrgName}">
		                </div>
	                </td>
	            </tr>
	            <tr>
	                <td class="bg-gray right">良好信息名称:</td>
	                <td colspan="3">
		                <div class="ipt-box pd0">
		                 ${favorAbleInfo.favName}
		                </div>
	                </td>
	            </tr>
	            <tr>
	                <td class="bg-gray right"><span style="color:red;">*</span>良好信息类别:</td>
	                <td colspan="3">
		                <div class="ipt-box pd0">
		                <c:if test="${favorAbleInfo.favType == '0'}">百强民营企业</c:if>
		                <c:if test="${favorAbleInfo.favType == '1'}">驰名商标</c:if>
		                <c:if test="${favorAbleInfo.favType == '2'}">知名商号</c:if>
		                <c:if test="${favorAbleInfo.favType == '3'}">著名商标</c:if>
		                <c:if test="${favorAbleInfo.favType == '4'}">守合同重信用企业</c:if>
		                <c:if test="${favorAbleInfo.favType == '5'}">信用示范管理企业</c:if>
		                <c:if test="${favorAbleInfo.favType == '6'}">小微企业成长之星</c:if>
		                </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right"><span style="color:red;">*</span>信息级别:</td>
	                  <td colspan="3">
		                <div id="licZoneDiv" class="ipt-box pd0">
		                    <c:if test="${favorAbleInfo.licZone == '0'}">全国</c:if>
		                    <c:if test="${favorAbleInfo.licZone == '1'}">省级</c:if>
		                    <c:if test="${favorAbleInfo.licZone == '2'}">市级</c:if>
		                    <c:if test="${favorAbleInfo.licZone == '3'}">县级</c:if>
		                </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right"><span style="color:red;">*</span>信息认定年度:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
			                 <input type="text" class="ipt-txt"   value="${favorAbleInfo.regYear}" readonly="readonly"/>
		                </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right">信息认定类别:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
			                 <input type="text" id=""  class="ipt-txt" value="${favorAbleInfo.regType}" readonly="readonly"/>
		                </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right"><span style="color:red;">*</span>认定有效期限:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
			                 <input type="text" id="" name="regFrom"   readonly="readonly" style="width: 180px;cursor: pointer;"
			                  class="ipt-txt" value="<fmt:formatDate value="${favorAbleInfo.regFrom}" pattern="yyyy-MM-dd" />" />
			                  
			                 -<input type="text" id="" name="regTo"  readonly="readonly" style="width: 180px;cursor: pointer;"
			                  class="ipt-txt" value="<fmt:formatDate value="${favorAbleInfo.regTo}" pattern="yyyy-MM-dd" />" />
		                </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right"><span style="color:red;">*</span>认定发布文号:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
			                 <input type="text" id="" name="regDocNo" class="ipt-txt" value="${favorAbleInfo.regDocNo}" readonly="readonly"/>
		                </div>
	                </td>
	            </tr>
	             <tr>
	               <td class="bg-gray right"><span style="color:red;">*</span>认定发布部门:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
			                 <input type="text" id="" name="regDeptCn" class="ipt-txt" value="${favorAbleInfo.regDeptCn}" readonly="readonly"/>
		                </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right"><span style="color:red;">*</span>认定发布时间:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
			                 <input type="text" id="" name="regDate"  readonly="readonly" style="width: 180px;cursor: pointer;"
			                  class="ipt-txt" value="<fmt:formatDate value="${favorAbleInfo.regDate}" pattern="yyyy-MM-dd" />" required/>
		                </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right">备注：</td>
	               <td colspan="3">
		                <div class="ipt-box pd0">
		                <textarea cols="" id="remark" class="ipt-txt"  rows="" style="width:100%;height: 80px" readonly="readonly">${favorAbleInfo.remark}</textarea>
		                </div>
	               </td>
	            </tr>
	            </table>
	            
	            <table id="committable" cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10">
	            <tr>
	                <td class="bg-gray right">录入员:</td>
	                <td>
		                <div class="ipt-box pd0">
		                 <input type="text" name="setName" class="ipt-txt" value="${favorAbleInfo.setName}" readonly>
		                </div>
	                </td>
	                <td class="bg-gray right">录入日期:</td>
	                <td>
		                <div class="ipt-box pd0">
		                <input type="text" name="setTime" class="ipt-txt" value="<fmt:formatDate value="${favorAbleInfo.setTime}" pattern="yyyy-MM-dd" />" readonly>
		                </div>
	                </td>
	                <td class="bg-gray right">录入部门:</td>
	                <td>
		                <div class="ipt-box pd0">
		                <input type="text" name="setDept" class="ipt-txt" value="${favorAbleInfo.setDept}" readonly>
		                </div>
	                </td>
	            </tr>
	            
		             <tr>
		                <td class="bg-gray right">审核员:</td>
		                <td>
			                <div class="ipt-box pd0">
			                 <input type="text" name="auditName" class="ipt-txt" value="${favorAbleInfo.auditName}" readonly>
			                </div>
		                </td>
		                <td class="bg-gray right">审核日期:</td>
		                <td>
			                <div class="ipt-box pd0">
			                <input type="text" name="auditDate" class="ipt-txt" value="<fmt:formatDate value="${favorAbleInfo.auditDate}" pattern="yyyy-MM-dd" />" readonly>
			                </div>
		                </td>
		                <td class="bg-gray right">审核部门:</td>
		                <td>
			                <div class="ipt-box pd0">
			                <input type="text" name="auditDept" class="ipt-txt" value="${favorAbleInfo.auditDept}" readonly>
			                </div>
		                </td>
		            </tr>
		            <tr>
		               <td class="bg-gray right"><span style="color:red;">*</span>审核结果:</td>
		               <td colspan="5">
						 <div id="auditDiv" class="ipt-box pd0">
			               <label><input type="radio" id="pass" onclick="return false" name="auditState" value="1" ${favorAbleInfo.auditState =='1'?'checked':''}/>&nbsp;同意&nbsp;</label>
			               <label><input type="radio" id="nopass" onclick="return false" name="auditState" value="2"  ${favorAbleInfo.auditState =='2'?'checked':''}/>&nbsp;不同意&nbsp;</label>     
			             </div>		               
		               </td>
		            </tr>
		            <tr>
		              <td class="bg-gray right"><span style="color:red;">*</span>审核意见：</td>
		              <td colspan="5">
		                <div class="ipt-box pd0">
		                <textarea cols="" id="auditOpin" class="ipt-txt"  rows="" style="width:100%;height: 80px" name="auditOpin" readonly>${favorAbleInfo.auditOpin}</textarea>
		                </div>
	               </td>
		            </tr>
                </table>
        </form>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
</body>
<script>
    window._CONFIG = {
            <c:if test="${sessionScope.session_sys_user.userType =='1'}">
             url:'/reg/server',
            </c:if>
            <c:if test="${sessionScope.session_sys_user.userType =='2'}">
             url:'/syn',
            </c:if>
    }
</script>
</html>