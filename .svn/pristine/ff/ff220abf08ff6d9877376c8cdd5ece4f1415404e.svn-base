<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>抽查检查任务设置查看</title>
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">
<div class="print-nocard">
    <h3>抽查检查任务设置查看</h3>
</div>
<h3 class="h6-title">检查任务设置查看</h3>


<form id="sctickForm">
<input type="hidden" id="userType" value=${userType }>
<div>
    <table class="table-horizontal">
            <tr>
                <td class="bg-gray right" width="14%">任务编号：</td>
                <td>
                    <div class="ipt-box col-12">
                        <input type="text" id="taskCode" name="taskCode" value="${scatck.taskCode}" readonly class="ipt-txt">
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
                        <input type="text" name="taskName" id="taskName" value="${scatck.taskName}" class="ipt-txt required" readonly>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">任务组织部门：</td>
                <td width="36%">
                    <div class="ipt-box col-12">
                        <input type="text" id="leaderDeptDesc" value="${scatck.leaderDeptDesc}" name="leaderDeptDesc" class="fl ipt-txt required" readonly>
                    </div>
                </td>
                <td class="bg-gray right" width="14%"><span style="color:red">*</span>抽查方式：</td>
                <td width="36%">
                    <div class="radio-box col-12">
                        <label class="mr20">
                            <input type="radio" name="speckWay" class="roles required" ${scatck.speckWay=='0'?'checked':''}  value="0" disabled="disabled">定向
                        </label>
                        <label>
                            <input type="radio" name="speckWay" class="roles" ${scatck.speckWay=='1'?'checked':''}  value="1" disabled="disabled">不定向
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
                        <input type="text" id="inspectDeptDescs" name="inspectDeptDescs" value="${scatck.implDeptDesc}" readonly  class="fl ipt-txt required">
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
                            <input type="checkbox" name="catgCode" class="roles" id="0" ${fn:indexOf(scatck.taskEntCatgCode,'0')!=-1?'checked':''}  value="企业" disabled="disabled">企业
                        </label>
                        <label class="checkbox-inline">
                            <input type="checkbox" name="catgCode" class="roles" id="1" ${fn:indexOf(scatck.taskEntCatgCode,'1')!=-1?'checked':''} value="个体户" disabled="disabled">个体户
                        </label>
                        <label class="checkbox-inline">
                            <input type="checkbox" name="catgCode" class="roles" id="2" ${fn:indexOf(scatck.taskEntCatgCode,'2')!=-1?'checked':''} value="农专社" disabled="disabled">农专社
                        </label>
                    </div>
                </td>
                <td class="bg-gray right"><span style="color:red">*</span>任务期限：</td>
                <td>
                    <div class="ipt-box col-3">
                        <input type="text" id="startDate" name="startDate" value="<fmt:formatDate value="${scatck.startDate}" pattern="yyyy-MM-dd" />" class="ipt-txt required pointer" readonly>
                    </div>
                    <span class="item-txt col-1"><i class="line-icon"></i></span>
                    <div class="ipt-box col-3">
                        <input type="text" id="endDate" name="endDate" value="<fmt:formatDate value="${scatck.endDate}" pattern="yyyy-MM-dd" />" class="ipt-txt required pointer" readonly>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right"><span style="color:red">*</span>任务说明（2000字内）：</td>
                <td colspan="3">
                    <div class="ipt-box">
                        <textarea id="checkContent" name="checkContent" class="min-h100 required" readonly>${scatck.checkContent}</textarea>
                    </div>
                </td>
            </tr>
        </table>
</div>
<h3 class="h6-title mt20">检查内容设置</h3>
<table class="table-row perc-100" cellpadding="0" cellspacing="0" border="0">
    <thead>
    <tr>
        <th width="7%">序号</th>
        <th width="20%">检查部门  </th>
        <th> 检测事项 </th>
    </tr>
    </thead>
    <tbody id="tableList">
    <c:forEach var="deptScatck" items="${deptSctackList}" varStatus="status">
	    <tr>
	    <td>${status.index + 1}</td>
	    <td>${deptScatck.inspectDesc}</td>
	    <td>${deptScatck.inspectTypeDesc }</td>
	    </tr>
    </c:forEach> 
    </tbody>
   
</table>
<div class="clearfix mt20">
    <div class="btn-box"> 
        <input type="button" value="关闭" id="cancleEdit" class="btn">
    </div>
</div>
</form>
</body>
 
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script type="text/javascript">
require(['component/iframeLayer','jquery'],function(layer) {
    $("#cancleEdit").click(function(){layer.close();});
})
</script>
</html>