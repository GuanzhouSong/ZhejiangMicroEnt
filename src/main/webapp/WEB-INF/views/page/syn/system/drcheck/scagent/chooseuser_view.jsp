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
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<body class="pd10">

<form id="entSearchForm">
    <input type="hidden" name="deptCode" id="deptCode" value="${sysUser.deptCode}">
    <input type="hidden" id="userType" value="${sysUser.userType}">
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
                            <input type="text" name="realName" value="" class="ipt-txt" />
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5"> 状态：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select name="status" style="cursor: pointer;">
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
                    <input type="reset" id="cancel" value="重 置" class="btn">
                </div>
            </div>
        </div>

        </div>
    </div>
</form>
<div>
    <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row">
        <thead>
        <tr>
            <th>用户名</th>
            <th>姓名</th>
            <th>所属部门</th>
            <th>电子邮件</th>
            <th>用户状态</th>
            <th>创建时间</th>
            <th>最后登录时间</th>
            <th>操作</th>
        </tr>
        </thead>
    </table>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/drcheck/scagent/chooseuser_main.js"></script>
</body>
</html>
