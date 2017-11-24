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
    <title>随机抽取企业名单</title>
    <link rel="stylesheet" href="/css/random.css" type="text/css">
	<link rel="stylesheet" href="/css/vendor/liMarquee.css" type="text/css">
</head>
<body class="bg">
<div class="wrap">
    <div class="main">
        <div class="actual-wrap clearfix">
        <input type="hidden" id="taskUid" value="${taskUid }"/>
        <div class="map fl">
        	<c:forEach var="pubScentDto" items="${pubScentDtoList}" varStatus="status">
        		<c:if test="${status.index  == 0}">
		        	<div class="city city-0"><i></i>省局<span>${pubScentDto.specialNum }</span></div>
        		</c:if>
        		<c:if test="${status.index  == 1}">
	            	<div class="city city-1">湖州市<span>${pubScentDto.specialNum }</span></div>
	            </c:if>
	            <c:if test="${status.index  == 2}">
	            <div class="city city-2">杭州市<span>${pubScentDto.specialNum }</span></div>
	            </c:if>
	            <c:if test="${status.index  == 3}">
	            <div class="city city-3">金华市<span>${pubScentDto.specialNum }</span></div>
	            </c:if>
	            <c:if test="${status.index  == 4}">
	            <div class="city city-4">衢州市<span>${pubScentDto.specialNum }</span></div>
	            </c:if>
	            <c:if test="${status.index  == 5}">
	            <div class="city city-5">丽水市<span>${pubScentDto.specialNum }</span></div>
	            </c:if>
	            <c:if test="${status.index  == 6}">
	            <div class="city city-6">嘉兴市<span>${pubScentDto.specialNum }</span></div>
	            </c:if>
	            <c:if test="${status.index  == 7}">
	            <div class="city city-7">绍兴市<span>${pubScentDto.specialNum }</span></div>
	            </c:if>
	            <c:if test="${status.index  == 8}">
	            <div class="city city-8">舟山市<span>${pubScentDto.specialNum }</span></div>
	            </c:if>
	            <c:if test="${status.index  == 9}">
	            <div class="city city-9">宁波市<span>${pubScentDto.specialNum }</span></div>
	            </c:if>
	            <c:if test="${status.index  == 10}">
	            <div class="city city-10">台州市<span>${pubScentDto.specialNum }</span></div>
	            </c:if>
	            <c:if test="${status.index  == 11}">
	            <div class="city city-11">温州市<span>${pubScentDto.specialNum }</span></div>
	            </c:if>
        	</c:forEach>
        </div>
        <div class="take-out fr">
            <div class="number">实抽取数：<span class="cf00">${pubScPlanTask.randomTotal }</span></div>
            <div class="info-list-wrap js-list">
                <ul class="info-list">
                	<c:forEach var="pubScent" items="${pubScentList}" varStatus="status">
	                    <li><a href="javascript:void(0);" title="${pubScent.entName }">${fn:substring(pubScent.entName,0,20) }</a></li>
                	</c:forEach>
                </ul>
            </div>
            <div class="time">
                <div class="time-mark"></div>
                <i></i>抽取时间：<span><fmt:formatDate value="${pubScPlanTask.randomDate }" pattern="yyyy-MM-dd HH:mm:ss" /></span>
            </div>
            <c:if test="${pubScPlanTask.taskState == '01' }">
			<div class="lock-btn-div">
				<input type="button" value="锁定名单" class="lock-btn-one mr10" id="lookLock">
			</div>
			</c:if>
            <div class="back-btn">
                <i></i>
                <a class="cf00" id="close" href="javascript:void(0);">返回</a>
            </div>
        </div>
    </div>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="/js/lib/jquery.liMarquee.js"></script>
<script>
    $(function(){
        $('.js-list').liMarquee({
            direction: 'up',
            drag: false
        });
    });
</script>
<script src="/js/syn/system/sccheck/scentback/scentbackrandom_look.js"></script>
</body>
</html>