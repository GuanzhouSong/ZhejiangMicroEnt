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
<form id="sysPermisionForm">
    <div class="clearfix">
        <h3 class="h3-title center"></h3>
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10">
            <tr>
                <td class="bg-gray right" width="15%"><span class="light"> *</span>上级权限：</td>
                <td width="30%">
                    <div class="ipt-box pd0">
                        <input type="hidden" name="id" value="${sysPermision.id}"/>
                        <c:choose>
                            <c:when test="${empty sysPermision}">
                                <input type="radio" name="parentId" checked="checked" value="${parentIdForSibling}">添加同级权限
                                <input type="radio" name="parentId" value="${parentIdForSub}">添加子权限
                            </c:when>
                            <c:otherwise>
                                ${empty parentName?"没有了":parentName}
                            </c:otherwise>
                        </c:choose>
                    </div>
                </td>

            </tr>
            <tr>
                <td class="bg-gray right" width="15%"><span class="light"> *</span>权限名称：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" name="name" class="ipt-txt" placeholder="请输入权限名称"
                               value="${sysPermision.name}">
                    </div>
                </td>
            </tr>

            <tr>
                <td class="bg-gray right" width="15%"><span class="light"> *</span>权限类型：</td>
                <td width="30%">
                    <div class="ipt-box pd0">
                        <c:choose>
                            <c:when test="${empty sysPermision}">
                                <input type="radio" name="type" checked="checked" value="1">菜单权限
                                <input type="radio" name="type" value="0">操作权限
                            </c:when>
                            <c:otherwise>
                                ${sysPermision.type=="1"?"菜单权限":"操作权限"}
                            </c:otherwise>
                        </c:choose>

                    </div>
                </td>

            </tr>
            <tr>
                <td class="bg-gray right" width="15%"><span class="light"> *</span>权限资源：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" name="url" class="ipt-txt" placeholder="请输入权限资源"
                               value="${sysPermision.url}">
                    </div>
                </td>
            </tr>

            <tr>
                <td class="bg-gray right" width="15%"><span class="light"> </span>关联资源：</td>
                <td width="30%">
                    <div class="ipt-box pd0">
                        <input type="text" name="relatedUrl" class="ipt-txt" placeholder="请输入关联权限资源"
                               value="${sysPermision.relatedUrl}">
                    </div>
                </td>

            </tr>
            <tr>
                <td class="bg-gray right" width="15%"><span class="light"> </span>序号：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" name="sort" class="ipt-txt" placeholder="请输入序号"
                               value="${sysPermision.sort}">
                    </div>
                </td>
            </tr>

        </table>
        <p class="center mt10"><input type="button" id="save" class="btn mr20" value="保 存"/><input type="button" class="btn" value="取 消" id="cancel"/></p>
    </div>
</form>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/sment/system/syspermision/sment_syspermision_edit.js"></script>
</body>
</html>
