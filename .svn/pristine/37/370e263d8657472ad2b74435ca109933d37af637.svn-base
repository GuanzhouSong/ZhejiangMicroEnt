<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>用户管理</title>
    <link rel="stylesheet" href="/css/sment/sment.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<body class="pd10">

<form id="entSearchForm">
    <div class="form-box mb5">
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">角色：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select  id="roleId" name="roleId">
                                <option value="">--请选择--</option>
                                <c:forEach var="role" items="${allRoles}">
                                    <c:if test="${empty userRoles[role.id]}">
                                        <option  value="${role.id}">${role.name}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">职务：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" name="postLike" value="" class="ipt-txt" />
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">所属部门：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt"  name="deptCode" id="deptCode" value="" />
                            <input type="text" class="ipt-txt" readonly id="deptName" value="" />
	                            <span class="add-icon" id="choseDept">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item center mt10">
                <div class="btn-box">
                    <input type="button" id="search" value="查 询" class="btn mr20">
                    <input type="reset" id="reset" value="重 置" class="btn">
                </div>
            </div>
        </div>

        </div>
    </div>
</form>

<div class="light-info">
    <span class="light">提示：一般情况下请先选择角色并填写其他查询条件，点击查询出某类角色的用户，再勾选下方的用户列表，最后点击【添加角色】或者【删除角色】来针对多个用户设置角色。 </span>
    <i class="xbt-icon close"></i>
</div>

<div class="clearfix mb5 mt5">
    <p class="fl">
        <input  type="button" class="btn btn-sm mr5 enadd js-add" value="添加角色">
        <input  type="button" class="btn btn-sm mr5 enadd js-remove" value="删除角色">
    </p>
</div>
<div>
    <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row">
        <thead>
        <tr>
            <th style="padding:0 20px;">序号</th>
            <th>全选<br/><input type="checkbox" id="checkAll"></th>
            <th>用户名</th>
            <th>姓名</th>
            <th>所属部门</th>
            <th>科室</th>
            <th>职位</th>
            <th>设置人</th>
            <th>设置日期</th>
        </tr>
        </thead>
    </table>
</div>
<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="{{this.class}}">{{this.text}}</button>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/business/sysuser/sysuser/user_role_edit.js"></script>
<script>
    window._CONFIG = {
        namespace:'${sessionScope.session_sys_user.userType=="1"?"/reg/server":"/syn/system"}',
        isAdmin:'${sessionScope.session_sys_user.isAdmin}',
        <c:if test="${sessionScope.session_sys_user.userType=='1'}">
        <c:if test="${sessionScope.session_sys_user.isAdmin!='1'}">
        select_detp_tree_url:'<c:url value="/common/system/dept/tree/select"/>',
        </c:if>
        <c:if test="${sessionScope.session_sys_user.isAdmin=='1'}">
        select_detp_tree_url:'<c:url value="/common/system/dept/tree/selectAll"/>',
        </c:if>
        </c:if>
        <c:if test="${sessionScope.session_sys_user.userType=='2'}">
        <c:if test="${sessionScope.session_sys_user.isAdmin!='1'}">
        select_detp_tree_url:'<c:url value="/common/system/sysdepart/deptSelectByDuty"/>'+'?dutyDeptCodes='+'${sessionScope.session_sys_user.dutyDeptCodes}'+'&isFilterBySysUser=true&treeType=radio&isNoCheck=true',
        </c:if>
        <c:if test="${sessionScope.session_sys_user.isAdmin=='1'}">
        select_detp_tree_url:'<c:url value="/common/system/sysdepart/alldeptradiotreeselect"/>'+'?isNoCheck=1',
        </c:if>
        </c:if>

    }
</script>
</body>
</html>
