<%--
  Created by IntelliJ IDEA.
  User: dxh
  Date: 2017/5/22
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <h3 class="random-title"><i class="task-icon"></i>任务名称：全省危险化学品经营企业联合检查</h3>
        <div class="random-extract-info">
            <span class="name">检查对象户数：</span><span class="data">2595623</span>
            <span class="name">参与抽取人员：</span><span class="data">9999</span>
            <span class="name">每户抽取：</span><span class="data_new">2</span><span class="name">人</span>
        </div>
        <div class="name-list-table-wrap">
            <div class="name-list-title">
                <span class="w60">序号</span><span class="w810">企业名称</span><span class="w385">检查人员</span>
            </div>
            <div class="name-list-wrap js-list">
                <ul class="name-info-list">
                    <li>
                        <span class="w60">1</span><span class="w810">企业名称</span><span class="w385">某某某、某某某某、某某某某某某</span>
                    </li>
                    <li>
                        <span class="w60">2</span><span class="w810">企业名称</span><span class="w385">检查人员</span>
                    </li>
                    <li>
                        <span class="w60">3</span><span class="w810">企业名称</span><span class="w385">检查人员</span>
                    </li>
                    <li>
                        <span class="w60">4</span><span class="w810">企业名称</span><span class="w385">检查人员</span>
                    </li>
                    <li>
                        <span class="w60">5</span><span class="w810">企业名称</span><span class="w385">检查人员</span>
                    </li>
                    <li>
                        <span class="w60">6</span><span class="w810">企业名称</span><span class="w385">检查人员</span>
                    </li>
                </ul>
            </div>
        </div>
        <div class="random-btn-box center">
        <a class="name-list-btn mr20" href="javascript:void(0)">重新抽取</a>
        <a class="name-list-btn" href="javascript:void(0)">锁定名单</a>
        </div>
        <div class="random-date">
            <i class="clock-icon"></i>
            抽取时间：2017-02-15 15:25:36
        </div>
    </div>
</div>
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

</body>
</html>
