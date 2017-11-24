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
</head>
<body class="bg">
<div class="wrap wrap-ry">
    <div class="main">
        <h3 class="random-title"><i class="task-icon"></i>任务名称：${pubScPlanTask.taskName }</h3>
        <input type="hidden" id="totalEntC" value="${pubScdeptTask.entNum }"/>
        <input type="hidden" id="deptTaskUid" value="${pubScdeptTask.uid }"/>
        <div class="lottery-mod lottery-ry-mod">
            <div class="item">检查对象户数<i class="w168">${pubScdeptTask.entNum }</i></div>
            <c:if test="${pubScdeptTask.randomType == '2' }">
            <div class="item">参与抽取人员<i class="w128">${pubScdeptTask.checkNum}</i></div>
            <div class="item">每户抽取<i class="w68 mr10">${pubScdeptTask.minNum}</i>人</div>
            </c:if>
            <c:if test="${pubScdeptTask.randomType == '1' }">
            <div class="item">参与抽取小组<i class="w128">${pubScdeptTask.checkNum}</i></div>
            <div class="item">随机抽取<i class="w68 mr10">${pubScdeptTask.minNum}</i>组</div>
            </c:if>

            <!--抽取中 start-->
            <div class="wrap-lottery-list" id="gdDiv">
                <div class="comp-list">
                    <ul class="swiper-comp lottery-list">
                    	<c:forEach var="pubScentDto" items="${pubScentDtoList}" varStatus="status">
	                        <li class="swiper-slide"><span class="span-50">${pubScentDto.entName }</span></li>
                    	</c:forEach>
                    </ul>
                </div>
                <div class="person-list">
                    <ul class="swiper-person lottery-list">
                    	<c:forEach var="pubScentDto" items="${pubScentDtoList}" varStatus="status">
	                        <li class="swiper-slide"><span class="span-40">${pubScentDto.agentNames }</span></li>
                    	</c:forEach>
                    </ul>
                </div>

            </div>
            <!--抽取中 end-->

            <!--抽取完成 start-->
            <div class="lottery-success center" style="display: none;" id="totalShow">
                已完成检查对象 <span>${pubScdeptTask.entNum }</span> 户检查人员抽取
            </div>
            <!--抽取完成 end-->
            <p class="center">
                <a href="javascript:void(0)" class="btn" id="start"></a>
                <a href="javascript:void(0)" class="btn btn-cancel" id="cancel" style="display: none;"></a>
                <a href="javascript:void(0)" class="btn btn-next" id="next" style="display: none;"></a>
            </p>
        </div>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="/js/syn/system/sccheck/scentagent/scentagent_move.js"></script>
<script>
    window._CONFIG = {
       chooseUrl:'${sysUser.userType == 2 ? "/syn" : "/reg"}', 
    }
</script>
</body>
</html>
