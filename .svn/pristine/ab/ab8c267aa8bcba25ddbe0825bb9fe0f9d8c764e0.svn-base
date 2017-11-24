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
        <h3 class="random-title"><i class="task-icon"></i>任务名称：${pubScPlanTask.taskName }</h3>
        <div class="lottery-mod">
            <div class="item">抽取库总户数<i class="w158">${pubScPlanTask.entTotal }</i></div>
            <div class="item">抽取比例<i class="w158">${pubScPlanTask.randomPercent }</i></div>
            <div class="item">应抽取数<i class="w158">${pubScPlanTask.randomTotal }</i></div>
			<input type="hidden" id="num" value="${pubScPlanTask.randomTotal }"/>
			<input type="hidden" id="taskUid" value="${taskUid }"/>
            <div class="lot-number">
                <div class="name">实抽取数</div>
                <div class="random-number">
                    <i id="i5">0</i>
                    <i id="i4">0</i>
                    <i id="i3">0</i>
                    <i id="i2">0</i>
                    <i id="i1">0</i>
                </div>
            </div>
            <p class="center">
                <a href="javascript:void(0)" class="btn" id="random"></a>
                <a href="javascript:void(0)" class="btn btn-cancel" id="cancel" style="display: none;"></a>
                <a href="javascript:void(0)" class="btn btn-next" id="next" style="display: none; "></a>
            </p>
        </div>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sccheck/scentback/scentbackrandom_move.js"></script>
</body>
</html>