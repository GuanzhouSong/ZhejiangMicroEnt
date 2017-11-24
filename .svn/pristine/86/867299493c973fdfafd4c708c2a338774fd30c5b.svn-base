<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>资源权限编辑</title>
    <link rel="stylesheet" href="/css/sment/sment.server.css">

</head>
<body class="pd10">
<form id="hxForm">
    <div class="clearfix">
        <h3 class="h3-title center"></h3>
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10">
            <tr>
                <td class="bg-gray right" width="15%"><span class="light"> *</span>上级区域名称：</td>
                <td width="30%">
                    <div class="ipt-box pd0">
                        <input type="hidden" name="areaCode" value="${smBusEntarchivesArea.areaCode}"/>
                        <c:if test="${pid != null && pid !=''}">
                        	<input type="radio" name="areaPcode" checked="checked" value="${pid}">添加同级区域类型
                        </c:if>
                        <c:if test="${pid != null && pid ==''}">
                         <input type="radio" name="areaPcode" checked="checked" value="${sid}">添加子区域类型
                        </c:if>   
                        <c:if test="${pid == null}">
                          ${pName}
                        </c:if> 
                    </div>
                </td>

            </tr>
            <tr>
                <td class="bg-gray right" width="15%"><span class="light"> *</span>区域类型：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" name="areaName" class="ipt-txt" placeholder="请输入区域类型名称"
                               value="${smBusEntarchivesArea.areaName}">
                    </div>
                </td>
            </tr>
        </table>
        <p class="center mt10"><input type="button" id="save" class="btn mr20" value="保 存"/><input type="button" class="btn" value="取 消" id="cancel"/></p>
    </div>
</form>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/sment/system/sment_area_manage_edit.js"></script>
</body>
</html>
