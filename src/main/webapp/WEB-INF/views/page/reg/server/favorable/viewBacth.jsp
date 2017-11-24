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
	            <table id="committable" cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10">
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
                </table>
             <div class="clearfix mt10">
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
<script src="/js/reg/server/favorable/favorablebatch.js"></script>
</body>
<script>
    window._CONFIG = {
    		uids:'${uids}',
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