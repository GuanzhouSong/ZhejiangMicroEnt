<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>审批部门对照维护</title>
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body>
<jsp:useBean id="nowdate" class="java.util.Date" />
<fmt:formatDate var="nowdate" value="${nowdate}" pattern="yyyy-MM-dd"/>
<div class="pd20 clearfix">
    <div class="light-info left"><span class="light bold f14">提示：带*的为必填项。</span></div>							
    <form id="form">
    <table border="0" cellspacing="0" cellpadding="0" class="table-horizontal mb10">
        <tbody>
        <tr>
            <td class="bg-gray right " width="14%">登记机关编码</td>
            <td width="36%">
                <div class="ipt-box col-12">
                    <input type="text" name="code" value="${codeRegorg.code}" class="fl ipt-txt" value="" readonly="readonly">
                </div>
            </td>
            <td class="bg-gray right" width="14%"><span class="light">* </span>登记机关简称</td>
            <td>
                <div class="ipt-box col-12">
                 <input type="text"  value="${codeRegorg.contentShort}" class="fl ipt-txt" readonly="readonly">
               </div>
	        </td>
        </tr>
        <tr>
            <td class="bg-gray right " width="10%">登记机关名称</td>
            <td colspan="3">
                <div class="ipt-box col-12">
                    <input type="text" value="${codeRegorg.content}" class="fl ipt-txt" readonly="readonly">
                </div>
            </td>
        </tr>
        <tr>
            <td class="bg-gray right" width="10%"><span class="light">* </span>联络员姓名</td>
            <td width="40%">
                <div class="ipt-box col-12"> 
                    <input type="text" name="liaName"  value="${codeRegorg.liaName}" class="fl ipt-txt view" >
                </div>
            </td>
            <td class="bg-gray right" width="10%"><span class="light">* </span>联系电话</td>
            <td> 
                <div class="ipt-box col-12"> 
                    <input type="text" name="liaPhone"  value="${codeRegorg.liaPhone}" class="fl ipt-txt view" >
                </div>
	       </td>
        </tr>
        </tbody>
    </table>
    </form>
</div>
</body>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/syn/system/coderegorg/regorg_edit.js"/>"></script>
<script>
    window._CONFIG = {
       type:'${type}',//操作类型 
       chooseUrl:'${userType == 2 ? "/syn" : "/reg/server"}'
     }
</script>
</html>