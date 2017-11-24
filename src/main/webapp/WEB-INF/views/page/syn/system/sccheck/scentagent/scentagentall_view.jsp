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
<div class="wrap wrap-ry">
    <div class="main">
        <h3 class="random-title"><i class="task-icon"></i>任务名称：${pubScPlanTask.taskName }</h3>
        <input type="hidden" value="${pubScdeptTask.uid }" id="deptTaskUid" />
        <div class="random-extract-info">
            <span class="name">检查对象户数：</span><span class="data">${pubScdeptTask.entNum }</span>
            <c:if test="${pubScdeptTask.randomType == '2' }">
	            <span class="name">参与抽取人员：</span><span class="data">${pubScdeptTask.checkNum}</span>
	            <span class="name">每户抽取：</span><span class="data_new">${pubScdeptTask.minNum}</span><span class="name">人</span>
            </c:if>
            <c:if test="${pubScdeptTask.randomType == '1' }">
	            <span class="name">参与抽取小组：</span><span class="data">${pubScdeptTask.checkNum}</span>
	            <span class="name">随机抽取：</span><span class="data_new">${pubScdeptTask.minNum}</span><span class="name">组</span>
            </c:if>
        </div>
        <div class="name-list-table-wrap">
            <div class="name-list-title">
                <span class="w60">序号</span><span class="w810">企业名称</span><span class="w385">检查人员</span>
            </div>
            <div class="name-list-wrap js-list">
                <ul class="name-info-list">
                	<c:forEach var="pubScent" items="${pubScentDtoList}" varStatus="status">
                    <li>
                        <span class="w60">${status.index+1 }</span><span class="w810" title="${pubScent.entName }">${fn:substring(pubScent.entName,0,20) }</span><span class="w385">${pubScent.agentNames }</span>
                    </li>
                	</c:forEach>
                </ul>
            </div>
        </div>
        <div class="random-btn-box center">
            <a class="name-list-btn mr10" href="javascript:void(0)"  id="reRandom">重新抽取</a>
            <%--<a class="name-list-btn mr10" href="javascript:void(0)">配备专家</a>--%>
            <a class="name-list-btn" href="javascript:void(0)" id="lock">锁定名单</a>
        </div>
        <div class="random-date-new">
            <i class="clock-icon"></i>
            抽取时间：<fmt:formatDate value="${pubScdeptTask.randomDate }" pattern="yyyy-MM-dd HH:mm:ss" />
        </div>
    </div>
</div>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/lib/jquery.liMarquee.js"></script>
<script src="/js/syn/system/sccheck/scentagent/scentagentall_view.js"></script>
<script>
    $(function(){
        $('.js-list').liMarquee({
            direction: 'up',
            drag: false
        });
    });
    window._CONFIG = {
       chooseUrl:'${sysUser.userType == 2 ? "/syn" : "/reg"}', 
    }
</script>
</body>
</html>
