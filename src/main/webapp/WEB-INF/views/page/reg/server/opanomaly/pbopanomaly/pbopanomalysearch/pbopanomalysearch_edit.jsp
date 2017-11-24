<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html> 
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <title>异常状态设置申请</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<style>
#unusualCatalog {
	padding:0px;
	margin:0px;
    overflow-x: hidden;
    overflow-y: auto;
    height: 100px;
}
.warn {
    background:#F00 !important;
    color:#FFF !important
}
#form select,#form textarea{background:#F4F8F9;}
</style>
<body class="pd10">
	<div class="main">
        	<div class="listBox2 thBg">
                <div class="leftTop"></div>
                <div class="right1Top"></div>
                <table class="table-horizontal" width="100%">
                    <tr id="appBasic">
                        <td class="bg-gray right"><div class="ipt-box">企业名称 </div></td>
                        <td><div class="ipt-box">${pubPbopanomalyDtoList[0].entName}</div></td>
	                    <td class="bg-gray right"><div class="ipt-box">注册号</div></td>
	                    <td><div class="ipt-box">${pubPbopanomalyDtoList[0].regNO}</div></td>
	                    <td class="bg-gray right"><div class="ipt-box">经营者</div></td>
	                    <td><div class="ipt-box">${pubPbopanomalyDtoList[0].leRep}</div></td>
	                </tr>
	                <tr id="appBasic">
                        <td class="bg-gray right"><div class="ipt-box">登记机关</div></td>
                        <td><div class="ipt-box">${pubPbopanomalyDtoList[0].regOrgName}</div></td>
	                    <td class="bg-gray right"><div class="ipt-box">成立日期</div></td>
	                    <td><div class="ipt-box"><fmt:formatDate value="${pubPbopanomalyDtoList[0].estDate}" pattern="yyyy-MM-dd"/></div></td>
	                    <td class="bg-gray right"><div class="ipt-box">标记状态</div></td>
	                    <td><div class="ipt-box">${pubPbopanomalyDtoList[0].isRecovery == '1' ? '未恢复' : '已恢复'}</div></td>
	                </tr>
	                <tr>
	                	<td class="bg-gray right"><div class="ipt-box">管辖单位</div></td>
                        <td colspan="5"><div class="ipt-box">${pubPbopanomalyDtoList[0].localAdmName}</div></td>
<!-- 	                	<td class="bg-gray right"><div class="ipt-box">责任区</div></td> -->
<%--                         <td colspan="3"><div class="ipt-box">${pubPbopanomalyDtoList[0].localAdmName}</div></td> --%>
	                </tr>
	            </table>
        	</div>
        	<br/>
        	<div class="listBox2 thBg">
               <div class="leftTop"></div>
               <div class="right1Top"></div>
               <table  class="table-horizontal" width="100%">
               	   <tr>
                       <td class="bg-gray right"><div class="ipt-box">标记异常原因</div></td>
                       <td colspan="5">
                       	<div class="ipt-box">${pubPbopanomalyDtoList[0].excpStaResCN}</div>
                       </td>
                   </tr>
                   <tr>
                       <td class="bg-gray right"><div class="ipt-box">事实和理由</div></td>
                       <td colspan="5"><div class="ipt-box"><textarea style="width:100%" disabled="disabled">${pubPbopanomalyDtoList[0].signRea}</textarea></div></td>
                   </tr>
                   <tr>
                   	<td class="bg-gray right" width="12%"><div class="ipt-box">标记日期</div></td>
                       <td width="15%"><div class="ipt-box"><fmt:formatDate value="${pubPbopanomalyDtoList[0].cogDate}" pattern="yyyy-MM-dd"/></div></td>
                       <td class="bg-gray width="12%"><div class="ipt-box">设置人</div></td>
                       <td width="15%"><div class="ipt-box">${pubPbopanomalyDtoList[0].setName}</div></td>
                       <td class="bg-gray width="12%"><div class="ipt-box">决定机关</div></td>
                       <td width="31%"><div class="ipt-box">${pubPbopanomalyDtoList[0].decorgCN}</div></td>
                   </tr>
               </table>
           </div>
           <br />
           <c:if test="${pubPbopanomalyDtoList[0].isRecovery == '0'}">
           <div class="listBox2 thBg">
               <div class="leftTop"></div>
               <div class="right1Top"></div>
               <table class="table-horizontal" width="100%">
               	<tr>
                       <td class="bg-gray right"><div class="ipt-box">恢复正常原因</div></td>
                       <td colspan="5">
                       	<div class="ipt-box">${pubPbopanomalyDtoList[0].norReaCN}</div>
                       </td>
                   </tr>
                   <tr>
                       <td class="bg-gray right"><div class="ipt-box">事实和理由</div></td>
                       <td colspan="5"><div class="ipt-box"><textarea style="width:100%" disabled="disabled">${pubPbopanomalyDtoList[0].recoverRea}</textarea></div></td>
                   </tr>
                   <tr>
                   	<td class="bg-gray width="12%"><div class="ipt-box">恢复日期</div></td>
                       <td width="15%"><div class="ipt-box"><fmt:formatDate value="${pubPbopanomalyDtoList[0].norDate}" pattern="yyyy-MM-dd"/></div></td>
                       <td class="bg-gray width="12%"><div class="ipt-box">设置人</div></td>
                       <td width="15%"><div class="ipt-box">${pubPbopanomalyDtoList[0].resetName}</div></td>
                       <td class="bg-gray width="12%"><div class="ipt-box">决定机关</div></td>
                       <td width="31%"><div class="ipt-box">${pubPbopanomalyDtoList[0].norDecOrgCN}</div></td>
                   </tr>
               </table>
           </div>
           <br />
           </c:if>
        </div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
</body>
</html>
<style type="text/css">
#form select,#form textarea{background:#F4F8F9;}
table.gridtable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;
}
table.gridtable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #dedede;
}
table.gridtable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #ffffff;
}
.listBox2 {
    padding: 0px;
    position: relative;
    width: 100%;
    margin: auto;
}
.listBox2 table {
    border: 1px solid #dcdcdc;
    width: 100%;
    font-size: 12px;
}
.txt_1 {
    width: 99%;
    height: 50px;
    border: 1px solid #cccccc;
    font-size: 12px;
}
</style>