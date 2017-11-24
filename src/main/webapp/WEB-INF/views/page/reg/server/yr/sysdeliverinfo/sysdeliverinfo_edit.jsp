<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<jsp:useBean id="nowdate" class="java.util.Date" />
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
<body>
<div class="pdr15 pdl15">
    <div class="" style="margin-top: 10px;">
        <form class="form-horizontal" id="sysDeliverInfoForm">
			<input type="hidden" name="uid" value="${sysDeliverInfo.uid}" />
			<input type="hidden" name="deptId" id="deptId" value="${sysDeliverInfo.deptId}" />
			<input type="hidden" name="deliCode" id="deliCode" value="${sysDeliverInfo.deliCode}" />
			<input type="hidden" name="setName" id="setName" value="${sysUser.realName }">   
<%-- 			<input type="hidden" name="setTime" id="setTime" value="${nowdate}">    --%>
	        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10">
            <tr>
            <td class="bg-gray right" width="20%"><span style="color:red">* </span>送达单位名称</td>
            <td colspan="3">
                <div class="ipt-box col-12">
                 <input type="text" name="deliName" id = "deliName"
                           value="${sysDeliverInfo.deliName }" readonly="readonly" class="ipt-txt">            
                </div>
            </td>
            </tr>
            <tr>
            <td class="bg-gray right"><span style="color:red">* </span>送达地址：</td>
            <td colspan="3">
                <div class="ipt-box col-12">
                 <input type="text" name="deliAddress" class="ipt-txt"
                           value="${sysDeliverInfo.deliAddress }">            
                </div>
            </td>
            </tr>
            <tr>
            <td class="bg-gray right"><span style="color:red">* </span>联系人：</td>
            <td colspan="3">
                <div class="ipt-box col-12">
                  <input type="text" name="linkman" class="ipt-txt"
                           value="${sysDeliverInfo.linkman }">            
                </div>
            </td>
            </tr>
            <tr>
            <td class="bg-gray right"><span style="color:red">* </span>联系电话：</td>
            <td colspan="3">
                <div class="ipt-box col-12">
                   <input type="text" name="tel" class="ipt-txt" value="${sysDeliverInfo.tel }">
                </div>
            </td>
            </tr>
            <tr>
            <td class="bg-gray right"><span style="color:red">* </span>主体类型：</td>
            <td colspan="3">
                <div class="radio-box pd0">
                    <label><input type="radio" value="1" name="deliType" <c:if test="${sysDeliverInfo.deliType == '1'}">checked</c:if> >内资</label>
                    <label><input type="radio" value="2" name="deliType" <c:if test="${sysDeliverInfo.deliType == '2'}">checked</c:if> >外资</label>
                    <label><input type="radio" value="3" name="deliType" <c:if test="${sysDeliverInfo.deliType == '3'}">checked</c:if> >农专社</label>
                </div>
            </td>
            </tr>           
            <tr>
            <td class="bg-gray right"><span style="color:red">* </span>邮政编码：</td>
            <td width="30%">
                <div class="ipt-box col-12">
               	    <input type="text" name="postalCode" class="ipt-txt" value="${sysDeliverInfo.postalCode }">
                </div>
            </td>
            <td class="bg-gray right" width="15%" id="isValid"><span style="color:red">* </span>是否有效 </td>
            <td>
                <div class="radio-box pd0">
                    <label><input type="radio" value="1" name="isValid" <c:if test="${sysDeliverInfo.isValid == '1'}">checked</c:if> >是</label>
                    <label><input type="radio" value="0" name="isValid" <c:if test="${sysDeliverInfo.isValid == '0'}">checked</c:if> >否</label>
                </div>
            </td>
            </tr>
            <tr>
            <td class="bg-gray right" width="15%">备注：</td>
            <td colspan="3">
                <div class="ipt-box col-12">
                	<textarea rows="1" name="remark" class="ipt-txt">${sysDeliverInfo.remark }</textarea>
                </div>
            </td>
            </tr>
            <tr>
            <td class="bg-gray right" width="20%">设置人：</td>
            <td width="30%">
                <div class="ipt-box col-12">
                   ${sysUser.realName }          
                </div>
            </td>
            <td class="bg-gray right" width="15%" id="isValid">设置时间：</td>
            <td>
                <div class="ipt-box col-12">
                <fmt:formatDate value="${nowdate}" pattern="yyyy-MM-dd"/>
                </div>
            </td>
            </tr>
            </table>
           <br/> 
            <div class="row center">
                <button id="save" type="submit" class="btn">保存</button>            
                <button id="cancel" type="button" class="btn ">取消</button>
            </div>
        </form>
    </div>
</div>
<script>
    window._CONFIG = {
        _deptId:'${deptId}'  ,
        _deliName:'${deliName}',
        _deliCode:'${deliCode}',
        _deliType:'${deliType}',
        _uid:'${sysDeliverInfo.uid}'
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/yr/sysdeliverinfo/sysdeliverinfo_edit.js"></script>
</body>
</html>