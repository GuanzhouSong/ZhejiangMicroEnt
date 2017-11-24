<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>随机抽取企业</title>
    <link rel="stylesheet" href="/css/random.css" type="text/css">
</head>
<body class="bg">
<div class="wrap">
    <div class="main">
    	<input type="hidden" id="taskUid" value="${taskUid }"/>
        <h3 class="random-title"><i class="task-icon"></i>任务名称：${pubScPlanTask.taskName }</h3>
        <div class="random-extract-info">
            <span class="name">抽取库总户数：</span><span class="data">${pubScPlanTask.entTotal }</span>
            <span class="name">抽取比例：</span><span class="data">${pubScPlanTask.randomPercent }</span>
            <span class="name">应抽取数：</span><span class="data">${pubScPlanTask.randomTotal }</span>
            <span class="name">实抽取数：</span><span class="data">${pubScPlanTask.randomTotal }</span>
        </div>
        <div class="custom-scroll">
        <table cellpadding="0" cellspacing="0" class="random-extract-table" width="100%">
            <thead>
            <tr>
                <th width="60">序号</th>
                <th width="825">检查事项</th>
                <th width="170">应抽取户数</th>
                <th width="170">已抽取户数</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="pubScentCondition" items="${pubSecentConditionList}" varStatus="status">
	            <tr>
	                <td>${status.index+1 }</td>
	                <td class="left pl5">
	                <c:if test="${!empty pubScentCondition.checkCode }">
		                ${pubScentCondition.checkName}
	                </c:if>
	                <c:if test="${empty pubScentCondition.checkCode }">
	                	其他检查事项
	                </c:if>
	                </td>
	                <td>${pubScentCondition.randomNum }</td>
	                <td>${pubScentCondition.randomNum }</td>
	            </tr>
            </c:forEach>
            </tbody>
        </table>
        </div>
        <div class="random-btn-box center">
        	<c:if test="${pubScPlanTask.taskState == '01' }">
	            <input type="button" value="重新抽取" id="restart" class="reset-btn mr10">
	            <input type="button" value="锁定名单" id="lock" class="lock-btn mr10">
            </c:if>
            <input type="button" value="查看名单" id="look" class="check-btn">
        </div>
        <div class="random-date">
            <i class="clock-icon"></i>
            	抽取时间：<fmt:formatDate value="${pubScPlanTask.randomDate }" pattern="yyyy-MM-dd HH:mm:ss" />
        </div>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sccheck/scentback/scentbackrandom_lock.js"></script>
</body>
</html>