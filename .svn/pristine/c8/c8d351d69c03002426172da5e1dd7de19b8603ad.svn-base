<%--
  Created by IntelliJ IDEA.
  User: dxh
  Date: 2017/5/22
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <!-- 视图适配  -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <!-- 360浏览器默认视图 -->
    <meta name="renderer" content="webkit">
    <title>双随机</title>
    <link rel="stylesheet" href="/css/random.css" type="text/css">
    <link rel="stylesheet" href="/css/vendor/liMarquee.css" type="text/css">
</head>
<body class="bg">
<div class="wrap">
    <div class="main">
        <div class="actual-wrap clearfix">
        	<input type="hidden" id="taskUid" value="${taskUid }"/>
            <div class="map-box map-hz fl">
	            <c:forEach var="pubScentDto" items="${pubScentDtoList}" varStatus="status">
	            	<c:if test="${status.index  == 0}">
	                	<div class="city city-0"><i></i>杭州市本级<span>${pubScentDto.specialNum }</span></div>
	                </c:if>
	                <c:if test="${status.index  == 1}">
		                <div class="city city-1">拱墅区<span>${pubScentDto.specialNum }</span></div>
	                </c:if>
	                <c:if test="${status.index  == 2}">
		                <div class="city city-2">西湖区<span>${pubScentDto.specialNum }</span></div>
		            </c:if>
	                <c:if test="${status.index  == 3}">    
		                <div class="city city-3">景区<span>${pubScentDto.specialNum }</span></div>
	                </c:if>
	                <c:if test="${status.index  == 4}">
		                <div class="city city-4">余杭区<span>${pubScentDto.specialNum }</span></div>
	                </c:if>
	                <c:if test="${status.index  == 5}">
		                <div class="city city-5">江干区<span>${pubScentDto.specialNum }</span></div>
	                </c:if>
	                <c:if test="${status.index  == 6}">
		                <div class="city city-6">经开区<span>${pubScentDto.specialNum }</span></div>
	                </c:if>
	                <c:if test="${status.index  == 7}">
		                <div class="city city-7">大江东<span>${pubScentDto.specialNum }</span></div>
	                </c:if>
	                <c:if test="${status.index  == 8}">
		                <div class="city city-8">下城区<span>${pubScentDto.specialNum }</span></div>
	                </c:if>
	                <c:if test="${status.index  == 9}">
		                <div class="city city-9">上城区<span>${pubScentDto.specialNum }</span></div>
	                </c:if>
	                <c:if test="${status.index  == 10}">
		                <div class="city city-10">萧山区<span>${pubScentDto.specialNum }</span></div>
	                </c:if>
	                <c:if test="${status.index  == 11}">
		                <div class="city city-11">滨江区<span>${pubScentDto.specialNum }</span></div>
	                </c:if>
	                <c:if test="${status.index  == 12}">
		                <div class="city city-12">富阳区<span>${pubScentDto.specialNum }</span></div>
	                </c:if>
	                <c:if test="${status.index  == 13}">
		                <div class="city city-13">桐庐县<span>${pubScentDto.specialNum }</span></div>
	                </c:if>
	                <c:if test="${status.index  == 14}">
		                <div class="city city-14">建德市<span>${pubScentDto.specialNum }</span></div>
	                </c:if>
	                <c:if test="${status.index  == 15}">
		                <div class="city city-15">淳安县<span>${pubScentDto.specialNum }</span></div>
	                </c:if>
	                <c:if test="${status.index  == 16}">
		                <div class="city city-16">临安区<span>${pubScentDto.specialNum }</span></div>
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
                <div style="margin-top: 20px!important;" class="lock-btn-div">
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
