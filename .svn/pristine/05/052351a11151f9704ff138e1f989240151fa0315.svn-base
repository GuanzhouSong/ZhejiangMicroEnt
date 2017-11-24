<%--suppress ALL --%>
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
    <link rel="stylesheet" href="/css/vendor/liMarquee.css" type="text/css">
    <link rel="stylesheet" href="/css/random.css" type="text/css">
</head>
<body class="bg">
<div class="wrap wrap-ry">
    <div class="main">
        <h3 class="random-title"><i class="task-icon"></i>任务名称：全省危险化学品经营企业联合检查</h3>
        <div class="lottery-mod lottery-ry-mod">
            <div class="item">检查对象户数<i class="w168">936952</i></div>
            <div class="item">检查人员库<i class="w128">9999</i></div>
            <div class="item">每户配置检查人员<i class="w68">2</i></div>

            <!--抽取中 start-->
            <div class="wrap-lottery-list">
                <ul class="lottery-list js-list">
                    <li>1、杭州平行人造革有限公司</li>
                    <li>2、浙江汇信科技有限公司</li>
                    <li>3、浙江沙巴克网络科技有限公司</li>
                    <li>4、杭州平行人造革有限公司</li>
                    <li>5、浙江汇信科技有限公司</li>
                    <li>6、浙江沙巴克网络科技有限公司</li>
                    <li>7、浙江沙巴克网络科技有限公司</li>
                </ul>
            </div>
            <!--抽取中 end-->

            <!--抽取完成 start-->
            <div class="lottery-success center" style="display: none;">
                已完成检查对象 <span>936952</span> 户检查人员抽取
            </div>
            <!--抽取完成 end-->
            <p class="center">
                <%--<a href="javascript:void(0)" class="btn mt142"></a>--%>
                <a href="javascript:void(0)" class="btn btn-cancel"></a>
                <%--<a href="javascript:void(0)" class="btn btn-next"></a>--%>
            </p>
        </div>
    </div>
</div>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script>

    carrousel();

    /**
     * 轮播
     */
    function carrousel(){
        if (!$('.js-list').is(':hidden')) {
            var timer = null;

            $('.js-list').find('li').eq(1).addClass('special');

            timer = setInterval(function () {
                $('.js-list').find('li').removeClass('special');

                $('.js-list').find('li').eq(0).remove().appendTo($('.js-list'));
                $('.js-list').find('li').eq(1).addClass('special');

            }, 1000);
        }
    }


</script>
</body>
</html>
