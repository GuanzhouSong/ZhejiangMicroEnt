<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>认领页面</title>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<script type="text/javascript">
</script>
<body class="pd10">
<form id="registInfoForm">
<input id="priPID" type="hidden" name="priPID" value="${registInfoDto.priPID}"/>
<table class="table-horizontal table-noborder" cellpadding="0" cellspacing="0" border="0" width="100%">
    <tr>
        <td align="right">退回人：</td>
        <td >${registInfoDto.backName}</td>
         <input type="hidden" name="backName" value="${registInfoDto.backName}">
        <td align="right">退回日期：</td>
        <td ><fmt:formatDate value="${registInfoDto.backTime }"  pattern="yyyy-MM-dd HH:mm:ss"/></td>
        <input type="hidden" name="backTime"
       value="<fmt:formatDate value="${registInfoDto.backTime }"  pattern="yyyy-MM-dd HH:mm:ss"/>">

    </tr>
    <tr>
        <td align="right">退回说明：</td>
        <td colspan="3"></td>
    </tr>
    <tr>
        <td colspan="4">
            <div class="ipt-box">
                <textarea name="backReason" id="backReason" maxlength="200" cols="30" rows="10" placeholder="请输入退回说明"></textarea>
            </div>
        </td>
    </tr>
</table>
<div class="center mt20">
    <input id="save" type="submit" class="btn mr20" value="保 存">
    <input id="cancel" type="button" class="btn mr20" value="取 消">
</div>
</form>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/registinfo/batchback_edit.js"></script>
</body>
</html>