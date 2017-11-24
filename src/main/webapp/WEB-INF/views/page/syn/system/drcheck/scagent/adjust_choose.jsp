<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>抽查检查结果录入</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">
<div class="form-box">
	<form id="chooseagentform">
	<input type="hidden" name="deptCode" id="deptCode" value="${deptCode}"/>
	<input type="hidden" id="agentUids" value="${agentUids}"/>
    <div class="form-list">
        <div class="form-item clearfix">
            <div class="col-5">
                <label class="item-name col-5">执法人员姓名：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt" name="agentName">
                    </div>
                </div>
            </div>
            <div class="col-5">
                <label class="item-name col-5">执法人员工号：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt" name="employeeNO">
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
<div>
    <table border="0" id="agent-table" cellspacing="0" cellpadding="0" class="table-row perc-100 mt30">
        <thead>
        <tr>
            <th>序号</th>
            <th>姓名</th>
            <th>工号</th>
            <th>部门机构</th>
            <th>岗位大类</th>
            <th>岗位资格资质</th>
            <th>执法清单范围</th>
            <th>操作</th>
        </tr>
        </<thead>
    </table>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/drcheck/scagent/scagent_adjust_choose.js"></script>
</body>
</html>