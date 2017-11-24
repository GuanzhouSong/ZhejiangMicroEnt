<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>抽查检查任务设置</title>
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">
<div class="print-nocard">
    <h3>抽查检查任务设置</h3>
</div>
<h6 class="h6-title">检查任务设置</h6>
<form id="sctickForm">
    <input type="hidden" id="userType" value=${userType }>
    <div>
        <table class="table-horizontal">
            <tr>
                <td class="bg-gray right" width="14%">任务编号：</td>
                <td>
                    <div class="ipt-box col-12">
                    	${taskNumber}
                        <input type="hidden" id="taskCode" name="taskCode" value="${taskNumber}" class="ipt-txt">
                    </div>
                </td>
                <td colspan="2" class="left-border-none">
                    <span class="ml10 inline-block">任务牵头组织机关简称+抽查+年度+序号，如：浙工商抽查[2017]1号</span>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right"><span style="color:red">*</span>任务名称：</td>
                <td colspan="3">
                    <div class="ipt-box col-12">
                        <input type="text" name="taskName" id="taskName" class="ipt-txt required" >
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">任务组织部门：</td>
                <td width="36%">
                    <div class="ipt-box col-12">
                    	${deptName}
                        <input type="hidden" id="leaderDeptDesc" value="${deptName}" name="leaderDeptDesc" class="fl ipt-txt required" placeholder="选择" style="height: 30px;cursor: pointer;">
                        <input type="hidden" id="leaderDeptCode" value="${deptCode}" name="leaderDeptCode">
                        <input type="hidden" id="deptNumber" value="${deptNumber}">
                    </div>
                </td>
                <td class="bg-gray right" width="14%"><span style="color:red">*</span>抽查方式：</td>
                <td width="36%">
                    <div class="radio-box col-12">
                        <label class="mr20">
                            <input type="radio" name="speckWay" class="roles required"  value="0">定向
                        </label>
                        <label>
                            <input type="radio" name="speckWay" class="roles"  value="1">不定向
                        </label>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right"><span style="color:red">*</span>
                    检查实施部门：
                </td>
                <td colspan="3">
                    <div class="ipt-box col-12">
                        <input type="text" id="inspectDeptDescs" name="inspectDeptDescs" value="" readonly 
                        class="fl ipt-txt required" placeholder="选择" style="height: 30px;cursor: pointer;">
                        <input type="hidden" id="inspectDepts" name="inspectDept" value="">
                        <span class="add-icon" id="choseImplDept"><i></i></span>
                        <input type="hidden" id="implDeptCode" name="implDeptCode">
                        <input type="hidden" id="implDeptDesc" name="implDeptDesc">
                    </div>
                </td>

            </tr>
            <tr>
                <td class="bg-gray right"><span style="color:red">*</span>
                    检查主体范围：
                </td>
                <td>
                    <div class="ipt-box col-12">
                        <label class="checkbox-inline">
                            <input type="checkbox" name="catgCode" class="roles" id="0"  value="企业">企业
                        </label>
                        <label class="checkbox-inline">
                            <input type="checkbox" name="catgCode" class="roles" id="1"  value="个体户">个体户
                        </label>
                        <label class="checkbox-inline">
                            <input type="checkbox" name="catgCode" class="roles" id="2"  value="农专社">农专社
                        </label>
                    </div>
                </td>
                <td class="bg-gray right"><span style="color:red">*</span>任务期限：</td>
                <td>
                    <div class="ipt-box col-3">
                        <input type="text" id="startDate" name="startDate" value="" readonly class="ipt-txt required pointer">
                    </div>
                    <span class="item-txt col-1"><i class="line-icon"></i></span>
                    <div class="ipt-box col-3">
                        <input type="text" id="endDate" name="endDate" readonly class="ipt-txt required pointer">
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right"><span style="color:red">*</span>任务说明（2000字内）：</td>
                <td colspan="3">
                    <div class="ipt-box">
<!--                     	抽查检查依据：&#13;抽查检查对象：&#13;抽查检查内容：&#13;抽查检查方式及要求： -->
                        <textarea id="checkContent" name="checkContent" class="min-h100 required" placeholder="请输入抽查检查依据、抽查检查对象、抽查检查内容、抽查检查方式和要求等任务说明信息"></textarea>
                    </div>
                </td>
            </tr>
        </table>
    </div>
    <h6 class="h6-title mt20">检查内容设置</h6>
    <table class="table-row perc-100" cellpadding="0" cellspacing="0" border="0">
        <thead>
        <tr>
            <th width="7%">序号</th>
            <th width="20%">检查部门</th>
            <th> 检测事项</th>
        </tr>
        </thead>
        <tbody id="tableList">

        </tbody>
    </table>
    <div class="clearfix mt20">
        <div class="btn-box">
            <input type="submit" value="创 建" class="btn mr20">
            <input type="button" value="重 置" id="cancel" class="btn mr20">
            <input type="button" value="关闭" id="cancleEdit" class="btn">
        </div>
    </div>
</form>
</body>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/drcheck/sctack/sctack_set.js"></script>
</html>