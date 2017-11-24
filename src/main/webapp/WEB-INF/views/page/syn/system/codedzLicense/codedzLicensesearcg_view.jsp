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
    <title>后置备案事项查询</title>
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
<body class="pd10">
	<div class="main"> 
        	<br/>
        	<div class="listBox2 thBg">
               <div class="leftTop"></div>
               <div class="right1Top"></div>
               <table  class="table-horizontal" width="100%">
               	   <tr>
                       <td class="bg-gray right" style="width: 100px;"><div class="ipt-box">备案事项编码</div></td>
                       <td colspan="5">
                       	<div class="ipt-box">${codeLicense.exaCode}</div>
                       </td>
                   </tr>
                   <tr>
                       <td class="bg-gray right"><div class="ipt-box">备案事项名称</div></td>
                       <td colspan="5">
                       	<div class="ipt-box">${codeLicense.exaName}</div>
                       </td>
                   </tr>
                   <tr>
                       <td class="bg-gray right"><div class="ipt-box">备案部门</div></td>
                       <td colspan="5">
                       	<div class="ipt-box">${codeLicense.licDept}</div>
                       </td>
                   </tr>
                   <tr>
                       <td class="bg-gray right"><div class="ipt-box">备案部门级别</div></td>
                       <td colspan="5">
                       	<div class="ipt-box" id="licZoneTem"></div>
                       </td>
                   </tr>
                   <tr>
                       <td class="bg-gray right"><div class="ipt-box">职能部门</div></td>
                       <td colspan="5">
                       	<div class="ipt-box">${licDeptTypeStr}</div>
                       </td>
                   </tr>
                   <tr>
                       <td class="bg-gray right"><div class="ipt-box">法律依据</div></td>
                       <td colspan="5">
                       	<div class="ipt-box">${codeLicense.licRea}</div>
                       </td>
                   </tr> 
               </table>
           </div> 
           <div class="form-item clearfix col-offset-3 mt10">
            <div class="ml60"> 
                <input id="cancelcodelicense" type="button" class="btn" value="关闭"/>
            </div>
           </div>
        </div>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/syn/system/codedzLicense/codedzlicense_view_main.js"/>"></script>
<script>
    window._CONFIG = {
        _licZone:'${codeLicense.licZone}'
      }
</script>
</body>
</html> 