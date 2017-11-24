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
            <input type="hidden" id="" name="uid" value="${favorAbleInfo.uid}"/>
            <input type="hidden" id="" name="priPID" value="${baseInfo.priPID}"/>
            <input type="hidden" id="" name="regNO" value="${baseInfo.regNO}"/>
            <input type="hidden" id="" name="uniSCID" value="${baseInfo.uniCode}"/>
            <input type="hidden" id="" name="regOrg" value="${baseInfo.regOrg}"/>
            <input type="hidden" id="" name="localAdm" value="${baseInfo.localAdm}"/>
            <input type="hidden" id="" name="efftStatus" value="${favorAbleInfo.efftStatus}"/>
            <input type="hidden" id="" name="createTime" value="<fmt:formatDate value="${favorAbleInfo.createTime}" pattern="yyyy-MM-dd HH:mm:ss" />"/>
            <c:if test="${isAudit != '1'}">
            	<input type="hidden" id="" name="auditState" value="${favorAbleInfo.auditState}"/>
            </c:if>
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
		                 <input type="text" name="" class="ipt-txt" value="${baseInfo.leRep}" readonly="readonly">
		                </div>
	                </td>
	                <td class="bg-gray right">登记机关:</td>
	                <td>
		                <div class="ipt-box pd0">
		                <input type="text" name="" class="ipt-txt" value="${baseInfo.regOrgName}" readonly="readonly">
		                </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right">良好信息名称:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
			                 <input type="text" id="" name="favName" class="ipt-txt" style="width: 300px" value="${favorAbleInfo.favName}" maxlength="100"/> 
		                </div>
	                </td>
	            </tr>
	            <tr>
	                <td class="bg-gray right"><span style="color:red;">*</span>良好信息类别:</td>
	                <td colspan="3">
		                <div class="ipt-box pd0">
		                 <select id="favType" name="favType" style="width: 200px" required>
		                   <option value=""></option>
		                   <option value="0" ${favorAbleInfo.favType == '0'?'selected':''}>百强民营企业</option>
		                   <option value="1" ${favorAbleInfo.favType == '1'?'selected':''}>驰名商标</option>
		                   <option value="2" ${favorAbleInfo.favType == '2'?'selected':''}>知名商号</option>
		                   <option value="3" ${favorAbleInfo.favType == '3'?'selected':''}>著名商标</option>
		                   <option value="4" ${favorAbleInfo.favType == '4'?'selected':''}>守合同重信用企业</option>
		                   <option value="5" ${favorAbleInfo.favType == '5'?'selected':''}>信用示范管理企业</option>
		                   <option value="6" ${favorAbleInfo.favType == '6'?'selected':''}>小微企业成长之星</option>
		                 </select>
		                </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right"><span style="color:red;">*</span>信息级别:</td>
	                  <td colspan="3">
		                <div id="licZoneDiv" class="ipt-box pd0">
			                 <label><input type="radio" id="tip" name="licZone"  value="0" ${favorAbleInfo.licZone =='0'?'checked':''}>全国  &nbsp;</label>
			                 <label><input type="radio" name="licZone"  value="1" ${favorAbleInfo.licZone =='1'?'checked':''}>省级  &nbsp;</label>
			                 <label><input type="radio" name="licZone"  value="2" ${favorAbleInfo.licZone =='2'?'checked':''}>市级  &nbsp;</label>
			                 <label><input type="radio" name="licZone"  value="3" ${favorAbleInfo.licZone =='3'?'checked':''}>县级  &nbsp;</label>
		                </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right"><span style="color:red;">*</span>信息认定年度:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
			                 <select id="regYear" name="regYear" style="width: 200px" required>
                                <c:forEach var="nowYear" items="${yearList}" varStatus="status" >
			        		     <option value="${nowYear}" ${favorAbleInfo.regYear==nowYear?'selected':''}>${nowYear}</option>
		        		        </c:forEach>  
                             </select>
		                </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right">信息认定类别:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
			                 <input type="text" id="" name="regType" class="ipt-txt" style="width: 200px" value="${favorAbleInfo.regType}"/>
			                 <span style="color: orange;">&nbsp;如：新认定、延续确认、首次公示、继续公示等</span>
		                </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right"><span style="color:red;">*</span>认定有效期限:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
			                 <input type="text" id="regFrom" name="regFrom"  onclick="laydate()" readonly="readonly" style="width: 150px;cursor: pointer;"
			                  class="ipt-txt" value="<fmt:formatDate value="${favorAbleInfo.regFrom}" pattern="yyyy-MM-dd" />" required/>
			                  
			                 -<input type="text" id="regTo" name="regTo" onclick="laydate()" readonly="readonly" style="width: 150px;cursor: pointer;"
			                  class="ipt-txt" value="<fmt:formatDate value="${favorAbleInfo.regTo}" pattern="yyyy-MM-dd" />" required/>
			                  <input type="checkbox" id='longLic'/>长期有效
		                </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right"><span style="color:red;">*</span>认定发布文号:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
			                 <input type="text" id="" name="regDocNo" class="ipt-txt" value="${favorAbleInfo.regDocNo}" required/>
		                </div>
	                </td>
	            </tr>
	             <tr>
	               <td class="bg-gray right"><span style="color:red;">*</span>认定发布部门:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
			                 <input type="text" id="regDeptCn" name="regDeptCn" style="width: 250px" class="ipt-txt" value="${favorAbleInfo.regDeptCn}"
			                 placeholder="请从部门列表中选择，如无则直接输入" required/>
			                 <input type="hidden" class="ipt-txt"  name="regDept" id="regDept" value="${favorAbleInfo.regDept}" />
			                 <c:if test="${isAudit != '1'}">
                             <span class="add-icon" style="right: auto;" id="choseDept">
                                <i></i>
                             </span>
                             </c:if>
		                </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right"><span style="color:red;">*</span>认定发布时间:</td>
	                  <td colspan="3">
		                <div class="ipt-box pd0">
			                 <input type="text" id="" name="regDate"  onclick="laydate()" readonly="readonly" style="width: 150px;cursor: pointer;"
			                  class="ipt-txt" value="<fmt:formatDate value="${favorAbleInfo.regDate}" pattern="yyyy-MM-dd" />" required/>
		                </div>
	                </td>
	            </tr>
	            <tr>
	               <td class="bg-gray right">备注：</td>
	               <td colspan="3">
		                <div class="ipt-box pd0">
		                <textarea cols="" id="remark" class="ipt-txt"  rows="" style="width:100%;height: 80px" name="remark">${favorAbleInfo.remark}</textarea>
		                </div>
	               </td>
	            </tr>
	            </table>
	            
	            <table id="committable" cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10">
	            <c:if test="${isAudit != '1'}">
		            <tr>
		                <td class="bg-gray right">录入员:</td>
		                <td>
			                <div class="ipt-box pd0">
			                 <input type="text" name="setName" class="ipt-txt" value="${sessionScope.session_sys_user.realName}" readonly/>
			                </div>
		                </td>
		                <td class="bg-gray right">录入日期:</td>
		                <td>
			                <div class="ipt-box pd0">
			                <input type="text" name="setTime" class="ipt-txt" value="<fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd" />" readonly/>
			                </div>
		                </td>
		                <td class="bg-gray right">录入部门:</td>
		                <td>
			                <div class="ipt-box pd0">
			                <input type="text" name="setDept" class="ipt-txt" value="${sessionScope.session_sys_user.departMent.deptName}" readonly/>
			                </div>
		                </td>
		            </tr>
	            </c:if>
	            
	            <c:if test="${isAudit == '1' && favorAbleInfo.auditState == '0'}">
	            
	             <tr>
	                <td class="bg-gray right">录入员:</td>
	                <td>
		                <div class="ipt-box pd0">
		                 <input type="text" name="setName" class="ipt-txt" value="${favorAbleInfo.setName}" readonly/>
		                </div>
	                </td>
	                <td class="bg-gray right">录入日期:</td>
	                <td>
		                <div class="ipt-box pd0">
		                <input type="text" name="setTime" class="ipt-txt" value="<fmt:formatDate value="${favorAbleInfo.setTime}" pattern="yyyy-MM-dd" />" readonly/>
		                </div>
	                </td>
	                <td class="bg-gray right">录入部门:</td>
	                <td>
		                <div class="ipt-box pd0">
		                <input type="text" name="setDept" class="ipt-txt" value="${favorAbleInfo.setDept}" readonly/>
		                </div>
	                </td>
	            </tr>
	            
		             <tr>
		                <td class="bg-gray right">审核员:</td>
		                <td>
			                <div class="ipt-box pd0">
			                 <input type="text" name="auditName" class="ipt-txt" value="${sessionScope.session_sys_user.realName}" readonly/>
			                </div>
		                </td>
		                <td class="bg-gray right">审核日期:</td>
		                <td>
			                <div class="ipt-box pd0">
			                <input type="text" name="auditDate" class="ipt-txt" value="<fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd" />" readonly/>
			                </div>
		                </td>
		                <td class="bg-gray right">审核部门:</td>
		                <td>
			                <div class="ipt-box pd0">
			                <input type="text" name="auditDept" class="ipt-txt" value="${sessionScope.session_sys_user.departMent.deptName}" readonly/>
			                </div>
		                </td>
		            </tr>
		            <tr>
		               <td class="bg-gray right"><span style="color:red;">*</span>审核结果:</td>
		               <td colspan="5">
						 <div id="auditDiv" class="ipt-box pd0">
			               <label><input type="radio" id="pass" name="auditState" value="1"/>&nbsp;同意&nbsp;</label>
			               <label><input type="radio" id="nopass" name="auditState" value="2"/>&nbsp;不同意&nbsp;</label>     
			             </div>		               
		               </td>
		            </tr>
		            <tr>
		              <td class="bg-gray right"><span style="color:red;">*</span>审核意见：</td>
		              <td colspan="5">
		                <div class="ipt-box pd0">
		                <textarea cols="" id="auditOpin" class="ipt-txt"  rows="" style="width:100%;height: 80px" name="auditOpin" required>${favorAbleInfo.auditOpin}</textarea>
		                </div>
	               </td>
		            </tr>
	            </c:if>
                </table>
             <div class="clearfix mt10 mb10">
	            <div class="center">
	                <button id="save" type="submit" class="btn mr20">保存</button>
	                <button id="cancel" type="button" class="btn">关闭</button>
	            </div>
            </div>
        </form>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/favorable/favorableinput_edit_main.js"></script>
</body>
<script>
    window._CONFIG = {
    		isAudit:'${isAudit}',
            <c:if test="${sessionScope.session_sys_user.userType =='1'}">
             url:'/reg/server',
             select_detp_tree_url:'<c:url value="/common/system/dept/tree/select"/>',
            </c:if>
            <c:if test="${sessionScope.session_sys_user.userType =='2'}">
             url:'/syn',
             select_detp_tree_url:'<c:url value="/common/system/dept/tree/selectAll"/>',
            </c:if>
    }
</script>
</html>