<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>执法人员调整</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">
<div class="form-box">
	<form id="chooseagentform">
    <div class="form-list">
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5">执法人员姓名：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt" name="agentName">
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">企业名称：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt" name="entName">
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">抽查任务编号：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt" name="taskCode">
                    </div>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5">抽查任务名称：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt" name="taskName">
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">任务审查状态：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <select name="auditState" class="ipt-txt" >
                         <option value="">全部</option>
                         <option value="0">待录入</option>
                         <option value="1">待审核</option>
                         <option value="3">不同意</option>
                         <option value="5">退回修改</option>
                        </select>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-item clearfix mt10">
            <div class="btn-box">
                <input type="button" value="查 询" id="search" class="btn mr20">
                <input type="button" value="重 置" class="btn" onclick="$('#chooseagentform')[0].reset();">
            </div>
        </div>
   </div>
    </form>
</div>
<div class="mt5">
    <input type="button" class="btn btn-sm mb5" id="adjust" value="调整">
    <table border="0" id="agent-table" cellspacing="0" cellpadding="0" class="table-row perc-100 mt30">
        <thead>
        <tr>
            <th>序号</th>
            <th><input type="checkbox" id="chooseAll"/></th>
            <th>执法人员姓名 </th>
            <th>任务状态</th>
            <th>企业名称</th>
            <th>抽查任务编号</th>
            <th>抽查任务名称</th>
        </tr>
        </thead>
    </table>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/drcheck/scagent/scagent_adjust.js"></script>
</body>
</html>