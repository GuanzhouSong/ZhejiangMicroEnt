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
    <%--<link rel="stylesheet" href="/css/vendor/liMarquee.css" type="text/css">--%>
    <link rel="stylesheet" href="/css/random.css" type="text/css">
</head>
<body class="bg">
<div class="wrap wrap-ry">
    <div class="main">
        <h3 class="random-title"><i class="task-icon"></i>任务名称：全省危险化学品经营企业联合检查</h3>
        <div class="lottery-mod lottery-ry-mod">
            <div class="item">检查对象户数<i class="w168">936952</i></div>
            <div class="item">参与抽取人员<i class="w128">9999</i></div>
            <div class="item">每户抽取<i class="w68 mr10">2</i>人</div>

            <!--抽取中 start-->
            <div class="wrap-lottery-list">
                <div class="comp-list">
                    <ul class="swiper-comp lottery-list">
                        <li class="swiper-slide"><span class="span-50">杭州平行人造革有限公司1</span></li>
                        <li class="swiper-slide"><span class="span-50">杭州平行人造革有限公司2</span></li>
                        <li class="swiper-slide"><span class="span-50">杭州平行人造革有限公司3</span></li>
                        <li class="swiper-slide"><span class="span-50">杭州平行人造革有限公司4</span></li>
                        <li class="swiper-slide"><span class="span-50">杭州平行人造革有限公司5</span></li>
                    </ul>
                </div>
                <div class="person-list">
                    <ul class="swiper-person lottery-list">
                        <li class="swiper-slide"><span class="span-40">某某某1&nbsp某某某1&nbsp某某某1&nbsp.....</span></li>
                        <li class="swiper-slide special02"><span class="span-40">某某某1&nbsp某某某1&nbsp某某某2&nbsp...</span></li>
                        <li class="swiper-slide"><span class="span-40">某某某1&nbsp某某某1&nbsp某某某3</span></li>
                        <li class="swiper-slide"><span class="span-40">某某某1&nbsp某某某1&nbsp某某某4</span></li>
                        <li class="swiper-slide"><span class="span-40">某某某1&nbsp某某某1&nbsp某某某5</span></li>
                    </ul>
                </div>

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
<%--<script src="/js/lib/swiper/swiper.min.js"></script>--%>
<script>
    function carrousel(swiptercont,time) {
        this.node = $(swiptercont);
        this.time=time;
        this.rocking = true;
        this.height = this.node.find('li').height();
        this.length = this.node.find('li').length;

        this.init = function() {
            this.node.append(this.node.find('li').eq(0).clone());
            this.node.append(this.node.find('li').eq(1).clone());
            this.node.append(this.node.find('li').eq(2).clone());
            this.node.find('li').eq(1).addClass('special02')
//            this.node.height(this.height*(this.length+3));
            this.swiper();

        };
        this.swiper = function() {
            var that=this;

            this.node.animate({
                marginTop: '-='+8+ 'px'
            }, this.time,'linear', function() {
                var margTop = $(this).css('marginTop').slice(0, -2);

                if(margTop%that.height==-that.height/2){
                    $(this).find('li').eq(2-Math.ceil(margTop/that.height)).addClass('special02').siblings().removeClass('special02');
                }

                if(margTop%that.height==0){
                    if(margTop/that.height == -that.length) {
                        $(this).css('marginTop', '0px');
                        that.node.find('li').eq(1).addClass('special02').siblings().removeClass('special02');
                    }

                    if(!that.rocking){
                        return false;
                    }
                }

                that.swiper();
            });

        }
        this.stop=function () {
            this.rocking=false;
        }

        this.init();
    }

    var compSwiper = new carrousel('.swiper-comp',150);
    var perSwiper = new carrousel('.swiper-person',75);

    setTimeout(function () {
        compSwiper.stop();
    },3000)


</script>
</body>
</html>
