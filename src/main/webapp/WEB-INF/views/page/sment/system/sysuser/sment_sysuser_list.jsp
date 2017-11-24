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
                    <label class="item-name col-5">用户名：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" name="username" value="" class="ipt-txt"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">姓名：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" name="realNameLike" value="" class="ipt-txt" />
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">所属部门：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt"  name="deptCode" id="regOrg" value="" />
                            <input type="text" class="ipt-txt" readonly id="regOrgName" value="" />
	                            <span class="add-icon" id="choseDept">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix mb10">

                <div class="col-4">
                    <label class="item-name col-5"> 状态：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select name="status" style="cursor: pointer;" id="statusSelect">
                                <option value="">不限</option>
                                <option value="1">有效</option>
                                <option value="0">无效</option>
                            </select>
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

<div class="clearfix mb5 mt5">
    <p class="fl" hidden>
        <input  type="button" class="btn btn-sm mr5 enadd js-add" value="创建新用户">
    </p>
</div>
<div>
    <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row">
        <thead>
        <tr>
            <th style="padding:0 20px;">序号</th>
            <th>操作</th>
            <th>用户名</th>
            <th>姓名</th>
            <th>所属部门</th>
            <th>职位</th>
            <th>手机</th>
            <th>座机</th>
            <th>状态</th>
            <th>创建日期</th>
            <th>最近登录日期</th>
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
<script src="/js/sment/system/sysuser/sment_sysuser_list.js"></script>
<script>
    window._CONFIG = {
	        <c:if test="${sessionScope.session_sys_user.isAdmin!='1'}">
	        	select_detp_tree_url:'<c:url value="/common/system/dept/tree/select"/>',
	        </c:if>
	        <c:if test="${sessionScope.session_sys_user.isAdmin=='1'}">
	        	select_detp_tree_url:'<c:url value="/common/system/dept/tree/selectAll"/>',
        	</c:if>
    }
</script>
</body>
</html>
