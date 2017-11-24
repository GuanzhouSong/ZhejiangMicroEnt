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

<form id="searchForm">
    <div class="form-box mb5">
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">操作用户：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" name="logUser" value="" class="ipt-txt"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">操作时间：</label>
                    <div class="ipt-box col-3">
                            <input type="text" class="ipt-txt laydate-icon clx" style="cursor: pointer;" onclick="laydate()"
                                   readonly="readonly" name="logTimeStart" value=""/>
                        </div>
                        <span class="item-line ">-</span>
                        <div class="ipt-box col-3">
                            <input type="text" class="ipt-txt laydate-icon clx" style="cursor: pointer;" onclick="laydate()"
                                   readonly="readonly"
                                   name="logTimeEnd" value=""/>
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

<div>
    <table id="hx-table" border="0" cellspacing="0" cellpadding="0" class="table-row">
        <thead>
        <tr>
            <th style="padding:0 20px;">序号</th>
            <th>最新操作人</th>
            <th>操作类型</th>
            <th>备注</th>
            <th>操作时间</th>
        </tr>
        </thead>
    </table>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/sment/system/sment_log_list.js"></script>
</body>
</html>
