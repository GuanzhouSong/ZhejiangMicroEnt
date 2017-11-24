<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>照面信息</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
</head>
<body  class="pd20">
<form id="registInfoForm">

        <table cellpadding="0" cellspacing="0" border="0" class="table-horizontal">
            <tbody>
            <tr>
                <td class="bg-gray right" width="15%">统一信用代码/注册号</td>
                <td>${midBaseInfo.uniCode == null ? midBaseInfo.regNO : midBaseInfo.uniCode}</td>
                <td class="bg-gray right" width="15%">企业名称</td>
                <td >${midBaseInfo.entName}</td>

            </tr>
            <tr>
                <td class="bg-gray right">类型</td>
                <td>${midBaseInfo.entTypeName}</td>
                <td class="bg-gray right">法定代表人</td>
                <td>${midBaseInfo.leRep}</td>

            </tr>
            <tr>
                <td class="bg-gray right">注册资本(万元)</td>
                <td>${midBaseInfo.regCapUSD}</td>
                <td class="bg-gray right">成立日期</td>
                <td><fmt:formatDate value="${midBaseInfo.estDate}"/></td>
            </tr>
            <tr>
                <td class="bg-gray right">营业期限自</td>
                <td><fmt:formatDate value="${midBaseInfo.opFrom}"/></td>
                <td class="bg-gray right">营业期限至</td>
                <td><fmt:formatDate value="${midBaseInfo.opTo}"/></td>
            </tr>
            <tr>
                <td class="bg-gray right">登记机关</td>
                <td>${midBaseInfo.regOrgName}</td>
                <td class="bg-gray right">核准日期</td>
                <td><fmt:formatDate value="${midBaseInfo.apprDate}"/></td>
            </tr>
            <tr>
                <td class="bg-gray right">住所（经营场所）</td>
                <td>${midBaseInfo.dom}</td>
                <td class="bg-gray right">登记状态</td>
                <td>${midBaseInfo.regState}</td>
            </tr>
            <tr>
                <td class="bg-gray right">经营范围</td>
                <td colspan="3">${midBaseInfo.opScope}</td>
            </tr>

            </tbody>
        </table>

       <div class="center" >
           <p class="center mt20">
            <input  id="cancel" type="button" class="btn" value="关闭">
           </p>
        </div>

</form>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/inforece/manabno/manabno_edit.js"></script>
</body>
</html>