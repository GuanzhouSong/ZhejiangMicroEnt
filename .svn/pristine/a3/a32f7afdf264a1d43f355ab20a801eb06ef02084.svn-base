<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body>
 
<form id="sysUserForm">
    <div class="pd20 clearfix">
        <h3 class="h3-title center"></h3>
		<input type="hidden" id="uid" name="uid" value="${codeMarkType.uid}">
		<input type="hidden" id="dutyDeptName" name="dutyDeptName" value="${codeMarkType.dutyDeptName}">
		<input type="hidden" id="specialName" name="specialName" value="${codeMarkType.specialName}">
		<input type="hidden" id="markCode" name="markCode" value="${codeMarkType.markCode}">
		<input type="hidden" id="setUserUid" name="setUserUid" value="${codeMarkType.setUserUid}">
		<input type="hidden" id="setDeptCode" name="setDeptCode" value="${codeMarkType.setDeptCode}">
<%-- 		<input type="hidden" id="rightCodes" name="rightCodes" value="${codeMarkType.rightCodes}"> --%>
<%-- 		<input type="hidden" id="leaderCodes" name="leaderCodes" value="${codeMarkType.leaderCodes}"> --%>
          <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10 f12"> 
             <tr>
                <td class="bg-gray right" width="30%"><span class="light">*</span>分类监管标签名称：</td>
                <td width="70%">
                    <div class="ipt-box pd0">
                        <input type="text" id="markName" name="markName" value="${codeMarkType.markName}" class="ipt-txt isShow" required="required"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right" width="30%"><span class="light">*</span>对应的专项库：</td>
                <td width="70%">
                    <div class="ipt-box pd0">
                        <select id="specialCode" name="specialCode" required="required">
                        	<option value="">请选择</option>
                        	<c:forEach items="${codeSpecialTypeList}" var="codeSpecialType">
	                        	<option value="${codeSpecialType.specialCode}" <c:if test="${codeMarkType.specialCode == codeSpecialType.specialCode}">selected="selected"</c:if>>${codeSpecialType.specialName}</option>
	                    	</c:forEach>
                        </select>
                    </div>
                </td>
            </tr>
             <tr>
                <td class="bg-gray right">说明：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" id="remark" name="remark"  value="${codeMarkType.remark}" class="ipt-txt isShow" />
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right"><span class="light">*</span>是否需要专业监管：</td>
                <td>
                    <div style="font-size: 13px">
                        <label><input type="radio" id="ischeckFlag" name="checkFlag" <c:if test="${codeMarkType.checkFlag == '0'}"> checked="checked"</c:if> value="0" class="ipt-txt"/>否&nbsp;</label>
                        <label><input type="radio" id="nocheckFlag" name="checkFlag" <c:if test="${codeMarkType.checkFlag == '1'}"> checked="checked"</c:if> value="1" class="ipt-txt" />是&nbsp;</label>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">是否需要专业资格资质：</td>
                <td>
                     <div class="ipt-box pd0">
	                      <input type="hidden" id="rightCodes" name="rightCodes" value="${codeMarkType.rightCodes}"/>
	                      <input type="text" id="rightNames" name="rightNames" value="${codeMarkType.rightNames}" class="ipt-txt isShow" readonly="readonly"/>
	                      <span class="add-icon" id="rightAdd">
	                        <i></i>
	                      </span>
                     </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">是否需要配备专家（组长）：</td>
                <td>
<!--                     <div style="font-size: 13px"> -->
<%--                         <label><input type="radio" id="isleaderCodes" name="leaderCodesV" <c:if test="${codeMarkType.leaderCodes == 'N'}"> checked="checked"</c:if> value="N" class="ipt-txt"/>否&nbsp;</label> --%>
<%--                         <label><input type="radio" id="noleaderCodes" name="leaderCodesV" <c:if test="${!empty codeMarkType.leaderCodes && codeMarkType.leaderCodes != 'N'}"> checked="checked"</c:if> value="Y" class="ipt-txt" />是&nbsp;</label> --%>
<!--                     </div> -->
                    <div class="ipt-box pd0">
	                      <input type="hidden" id="leaderCodes" name="leaderCodes" value="${codeMarkType.leaderCodes}"/>
	                      <input type="text" id="leaderNames" name="leaderNames" value="${codeMarkType.leaderNames}" class="ipt-txt isShow" readonly="readonly"/>
	                      <span class="add-icon" id="expertAdd">
	                        <i></i>
	                      </span>
                     </div>
                </td>
            </tr>
            <tr>
               <td class="bg-gray right"><span class="light">*</span>状态：</td>
               <td>
                   <div style="font-size: 13px">
                        <label><input type="radio" id="isScVlid" name="isVlid" <c:if test="${codeMarkType.isVlid == '1' || empty codeMarkType.isVlid}"> checked="checked"</c:if> value="1" class="ipt-txt"/>有效&nbsp;</label>
                        <label><input type="radio" id="noScVlid" name="isVlid" <c:if test="${codeMarkType.isVlid == '0'}"> checked="checked"</c:if> value="0" class="ipt-txt" />失效&nbsp;</label>
                    </div>
               </td>
            </tr>
            <tr>
               <td class="bg-gray right"><span class="light">*</span>适用部门：</td>
               <td>
                   <div class="ipt-box pd0">
                        <select id="dutyDeptCode" name="dutyDeptCode" required="required">
                        	<option value="">请选择</option>
                        	<c:forEach items="${codeDutydeptList}" var="codeDutydept">
	                        	<option value="${codeDutydept.deptCode}" <c:if test="${codeMarkType.dutyDeptCode == codeDutydept.deptCode}">selected="selected"</c:if>>${codeDutydept.deptName}</option>
	                    	</c:forEach>
                        </select>
                    </div>
               </td>
            </tr>
             <tr>
                <td class="bg-gray right">创建日期：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" id="creatTime" name="creatTime"  value="<fmt:formatDate value="${codeMarkType.creatTime}" pattern="yyyy-MM-dd" />" class="ipt-txt isShow" readonly="readonly"/>
                    </div>
                </td>
            </tr>
             <tr>
                <td class="bg-gray right">设置人：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" id="setUserName" name="setUserName"  value="${codeMarkType.setUserName}" class="ipt-txt isShow" readonly="readonly"/>
                    </div>
                </td>
            </tr>
        </table>
         <p class="center mt10">
         	<c:if test="${viewFlag != '2'}">
	        <input type="submit" id="save" class="btn mr20" value="保 存"/>
	        </c:if>
	        <button id="cancel" type="button" class="btn">关闭</button>
	     </p>
    </div>
</form>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sccheck/marktype/marktype_edit.js"></script>
</body>
</html>
