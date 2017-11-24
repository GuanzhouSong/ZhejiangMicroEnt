<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>抽查检查对象名单抽取</title>
<!--     <link rel="stylesheet" href="/css/syn.css"> -->
	<link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
     <link rel="stylesheet" href="/css/reg.server.css">
	<link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<div>
    <h5 class="h5-title center">任务名称：
	     <input type="text" class="ipt-txt" disabled="disabled" id="taskName" value="${pubScPlanTask.taskName} "  style="width: 400px; box-sizing: border-box; padding: 1px 3px;line-height: 28px;height: 30px;font: 13.3333px Arial;"/>
	     <a href="javascript:void(0);" style="color:blue;" id="taskDetail">详情</a>
	</h5>
</div><br/>
<h5 class="h5-title">
	<span>
	请选择抽取模式：
	<input type="radio" value="2" <c:if test="${pubScPlanTask.randomType == '2'}">checked="checked"</c:if> disabled="disabled"/>
	<label for="checkType1" >按专项库抽取</label>
	<input type="radio" value="1" <c:if test="${pubScPlanTask.randomType == '1'}">checked="checked"</c:if> disabled="disabled"/>
	<label for="checkType2" >按选取名单抽取</label>
	</span>
</h5>

<form id="qryForm">
<input type="hidden" id="userType" value=${userType }>
<input type="hidden" id="taskUid" name="taskUid" value=${taskUid }>
<input type="hidden" id="randomType" name="randomType" value="${pubScPlanTask.randomType}">
<c:if test="${pubScPlanTask.randomType == '1'}">
<div class="form-box mb5">
    <div class="form-list">
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-4">统一代码/注册号：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <input type="text" id="regNO" name="regNO" class="ipt-txt">
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-4">企业名称：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <input type="text" id="entName" name="entName" class="ipt-txt">
                    </div>
                </div>
            </div>
            <div class="col-4">
                <div class="col-7">
                    <div class="btn-box">
		                <input type="button" value="查 询" id="qry" class="btn mr20">
		                <input type="button" value="重 置" id="cancel" class="btn">
		            </div>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
        </div>
    </div>
</div>
</c:if>
</form>
<c:if test="${pubScPlanTask.randomType == '1'}">
<div>
    <table border="0" id="scentback-table" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap">
       <thead>
        <tr>
            <th>序号</th>
            <th>统一社会信用代码/注册号</th>
            <th>企业名称</th>
            <th>成立日期</th>
            <th>主体类别 </th>
            <th>上次抽查日期</th>
            <th>登记机关</th>
            <th>管辖单位</th>
        </tr>
        </thead>
    </table>
</div>
</c:if>
<h5 class="h5-title">
	<span style="color:red;float: right;">提示：抽取数量均按照四舍五入取整数。</span>
</h5>
<div>
    <table border="0"  id="scentcondition-table" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap">
       <thead>
        <tr>
            <th>序号</th>
            <th>任务涉及的检查事项</th>
            <th>对应的检查对象抽取库</th>
            <th>抽取库主体户数</th>
            <th>抽取目标户数</th>
        </tr>
        </thead>
    </table>
</div>
<div class="form-box">
    <div class="form-list">
        <div class="form-item clearfix mb10">
            <div class="col-4">
                <div class="col-6 item-name">检查对象抽取库总户数：</div>
                <div class="col-6 ipt-box">
                    <div class="col-8"><input type="text" class="ipt-txt" id="totalEnt" value="${pubScPlanTask.entTotal }" readonly="readonly"/></div>
                </div>
            </div>
            <div class="col-4">
                <div class="col-6 item-name">抽取目标总户数：</div>
                <div class="col-6 ipt-box">
                    <div class="col-8"><input type="text" class="ipt-txt" id="totalRandom" value="${pubScPlanTask.randomTotal }" readonly="readonly"/></div>
                </div>
            </div>
            <div class="col-4">
                <div class="col-6 item-name" id="itemcount">总抽取比例：</div>
                <div class="col-6 ipt-box">
                    <div class="col-8"><input type="text" class="ipt-txt" id="randomPercent" value="${pubScPlanTask.randomPercent }" readonly="readonly"/></div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="clearfix mt20">
    <div class="btn-box">
        <input type="button" value="查看已抽取企业" id="viewEnt" class="btn">
        <input type="button" value="关闭" id="cancleEdit" class="btn">
    </div>
</div><br/>

</body>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sccheck/scentback/crossRandomEnt_view.js"></script>
</html>