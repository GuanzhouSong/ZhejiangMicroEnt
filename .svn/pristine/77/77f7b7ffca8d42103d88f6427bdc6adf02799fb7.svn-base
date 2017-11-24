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
<div>
    <div class="">
        <form id="punishform">
          <input type="hidden" id="userType" value="${userType }">
            <input type="hidden" id="priPID" name="priPID" value="${pubOtherpunish.priPID}">
            <input type="hidden" id="caseNO" name="caseNO" value="${pubOtherpunish.caseNO}">
            <input type="hidden"  name="setDeptname" value="${pubOtherpunish.setDeptname}">
             <input type="hidden" id="penType" value="${pubOtherpunish.penType}">
        	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10">
	            <tr>
	                <td width="15%" class="bg-gray right">注册号:</td>
	                <td width="35%">
		                <div class="ipt-box pd0">
		                <input type="text" name="regNO" class="ipt-txt"  value="${pubOtherpunish.regNO}" readonly="readonly">
		                </div>
	                </td>
	                <td width="15%" class="bg-gray right">企业名称:</td>
	                <td width="30%">
		                <div class="ipt-box pd0">
		                  <input type="text" name="entName" class="ipt-txt" value="${pubOtherpunish.entName}" readonly="readonly">
		                </div>
	                </td>
	            </tr>
	            <tr>
	                <td width="20%" class="bg-gray right">处罚决定书文号:</td>
	                <td width="35%">
	                  <div class="ipt-box pd0">
	                 	<input type="text" name="penDecNo" class="ipt-txt" value="${pubOtherpunish.penDecNo}" readonly="readonly">
	                  </div>
	                </td>
	                <td width="15%" class="bg-gray right">违法类型:</td>
	                <td width="30%">
	                  <div class="ipt-box pd0">
	                	<input type="text" name="illegActType" class="ipt-txt" value="${pubOtherpunish.illegActType}" readonly="readonly">
	                  </div>
	                </td>
	            </tr>
	            <tr>
	               <td width="20%" class="bg-gray right">处罚类型:</td>
	               <td width="80%" colspan="3">
	                <div class="ipt-box pd0">
	                    <label><input type="checkbox"  value="1" >警告</input></label>
						<label><input type="checkbox"  value="2" >罚款</input></label>
						<label><input type="checkbox"  value="3" >没收违法所得和非法财物</input></label>
						<label><input type="checkbox"  value="4" >责令停产停业</input></label>
						<label><input type="checkbox"  value="5" >暂扣许可证</input></label>
						<label><input type="checkbox"  value="6" >暂扣执照(登记证)</input></label><br/>
						<label><input type="checkbox"  value="7" >吊销许可证</input></label>
						<label><input type="checkbox"  value="8" >吊销执照(登记证)</input></label>
						<label><input type="checkbox"  value="9" >法律、法规规定的其他行政处罚方式</input></label>
					</div>
					</td>
	            </tr>
	            <tr>
	               <td width="20%" class="bg-gray right penAm" style="display: none">罚款金额<span style="color: red">(万元)</span></td>
	               <td width="30%" class="penAm" style="display: none">
	                <div class="ipt-box pd0">
	                <input type="text" name="penAm" class="ipt-txt" value="${pubOtherpunish.penAm}" readonly="readonly">
	                </div>
	               </td>
	               <td width="20%" class="bg-gray right forfAm" style="display: none">没收金额<span style="color: red">(万元)</span></td>
	               <td width="30%" class="forfAm" style="display: none">
	                <div class="ipt-box pd0">
	                <input type="text" name="forfAm" class="ipt-txt" value="${pubOtherpunish.forfAm}" readonly="readonly">
	                </div>
	               </td>
	            </tr>
	            <tr>
	               <td width="20%" class="bg-gray right">行政处罚内容</td>
	               <td colspan="3">
	                <div class="ipt-box pd0">
	                <textarea cols="" rows="" name="penContent" style="width:100%;height: 120px" readonly="readonly">${pubOtherpunish.penContent}</textarea>
	                </div>
	               </td>
	            </tr>
	            <tr>
	                <td width="20%" class="bg-gray right">处罚决定日期:</td>
	                <td width="35%">
	                <div class="ipt-box pd0">
	                 <input type="text" name="penDecIssDate" class="ipt-txt" value="<fmt:formatDate value="${pubOtherpunish.penDecIssDate}" pattern="yyyy-MM-dd" />" readonly="readonly">
	                </div>
	                </td>
	                <td width="15%" class="bg-gray right">处罚决定机关:</td>
	                <td width="30%">
	                 <div class="ipt-box pd0">
	                <input type="text" name="judAuth" class="ipt-txt" value="${pubOtherpunish.judAuth}" readonly="readonly">
	                </div>
	                </td>
	             </tr>
	              <tr>
	                <td width="20%" class="bg-gray right">录入人:</td>
	                <td width="35%">
	                <div class="ipt-box pd0">
	                 <input type="text" name="setName" class="ipt-txt" value="${pubOtherpunish.setName}" readonly="readonly">
	                </div>
	                </td>
	                <td width="15%" class="bg-gray right">录入日期:</td>
	                <td width="30%">
	                <div class="ipt-box pd0">
	                <input type="text" name="setDate" class="ipt-txt" value="<fmt:formatDate value="${pubOtherpunish.setDate}" pattern="yyyy-MM-dd" />" readonly="readonly">
	                </div>
	                </td>
	             </tr>
	              <tr>
	                <td width="20%" class="bg-gray right">审核人:</td>
	                <td width="35%">
	                <div class="ipt-box pd0">
	                 <input type="text" name="auditName" class="ipt-txt" value="${sessionScope.session_sys_user.realName}" readonly="readonly">
	                 </div>
	                </td>
	                <td width="15%" class="bg-gray right">审核日期:</td>
	                <td width="30%">
	                <div class="ipt-box pd0">
	                <input type="text" name="auditDate" class="ipt-txt" value="<fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd" />" readonly="readonly">
	                </div>
	                </td>
	             </tr>
	              <tr>
	                <td width="20%" class="bg-gray right">审核结果:</td>
	                <td width="35%">
	                <div class="ipt-box pd0">
	                 <label><input type="radio" id="checksuc" name="auditState" value="1" ${pubOtherpunish.auditState =='1'?'checked':''}>通过</label>&nbsp;&nbsp;
	                 <label><input type="radio" id="checkfal" name="auditState" value="2" ${pubOtherpunish.auditState =='2'?'checked':''}>不通过</label>
	                </div>
	                </td>
	                <td width="15%" class="bg-gray right">审核意见:</td>
	                <td width="30%">
	                <div class="ipt-box pd0">
	                <input type="text" id="auditOpin" class="ipt-txt" name="auditOpin" value="${pubOtherpunish.auditOpin}">
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
<script src="/js/reg/server/other/otherpunish/otherpunish_audit_main.js"></script>
</body>
</html>