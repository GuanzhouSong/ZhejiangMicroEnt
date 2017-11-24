<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>首页</title>
    <link rel="stylesheet" href="/css/sment/sment.server.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/vendor/idangerous.swiper2.7.6.css"/>"/>
</head>
<body class="pd10">
<div>
    <div class="m-zj-notice clearfix">
        <i class="u-mail"></i>
        <span class="u-notice">通知公告</span>
        <input type="hidden" id="moreFlag" value="0"/>
        <ul id="ul-list">
            <li><a href=""><i>● </i><span>2017-07-07</span> 关于举办全省新设小微企业活力指数编制工作培训班的通知[ 浙江省工商行政管理局 ]</a></li>
            <li><a href=""><i>● </i><span>2017-06-22</span> 关于做好2017年服务小微企业成长“十大优秀项目”“十大优秀平台”和小微企业“成长之星”推荐上报工作的通知[
                浙江省工商行政管理局 ] </a></li>
        </ul>
        <a href="javascript:void(0)" class="u-all">查看全部</a>
    </div>
    <div class="flow-x-auto">
        <div class="m-zj-todo clearfix">
            <div class="u-todo u-todo-l" style="width:48%">
                <span class="u-l">待办事项</span>
                <a style="display: none;" href="/sment/entarchives/toEntarchivesEntlist" class="h-explain J_menuItem"
                   id="fastLink1">添加企业入库</a><em></em>
                <a style="display: none;" href="/sment/entarchives/toEntarchivesList" class="h-explain J_menuItem"
                   id="fastLink2">库内企业管理</a><em></em>
                <a style="display: none;" href="/sment/entarchives/monitor/list" class="h-explain J_menuItem"
                   id="fastLink3">跟踪监测预警</a><em></em>
                <ul>
                    <li><a href="javascript:void(0);" class="h-explain fastLink" data-idx='1'><i>● </i>待添加初创型 <span>[<span
                            id="span_cultivationTypeCode_1">0</span>]</span></a></li>
                    <li><a href="javascript:void(0);" class="h-explain fastLink" data-idx='1'><i>● </i>待添加成长型 <span>[<span
                            id="span_cultivationTypeCode_2">0</span>]</span></a></li>
                    <li><a href="javascript:void(0);" class="h-explain fastLink" data-idx='1'><i>● </i>待添加领军型 <span>[<span
                        id="span_cultivationTypeCode_3">0</span>]</span></a></li>
                    <li><a state="1" href="javascript:void(0);" class="h-explain fastLink span_help" data-idx='2'><i>● </i>待更新需求 <span>[<span
                            id="span_help_1">0</span>]</span></a></li>
                    <li><a state="2" href="javascript:void(0);" class="h-explain fastLink span_help" data-idx='2'><i>● </i>待帮扶 <span>[<span
                            id="span_help_2">0</span>]</span></a></li>
                </ul>
            </div>
            <div class="u-todo u-todo-r" style="width:52%">
                <span class="u-r">提醒事项</span>
                <ul>
                    <li><a href="javascript:void(0);" class="h-explain fastLink span_txsx" state="1" data-idx='3'><i>● </i>入库企业注销 <span>[<span
                            id="span_rkqyzx">0</span>]</span></a></li>
                    <li><a href="javascript:void(0);" class="h-explain fastLink span_txsx" state="2" data-idx='3'><i>● </i>入库企业上规升级 <span>[<span
                            id="span_sgsj">0</span>]</span></a></li>
                    <li><a href="javascript:void(0);" class="h-explain fastLink span_txsx" state="3" data-idx='3'><i>● </i>入库企业营收下降 <span>[<span
                            id="span_ysxj">0</span>]</span></a></li>
                    <li><a href="javascript:void(0);" class="h-explain fastLink span_txsx" state="4" data-idx='3'><i>● </i>入库企业经营异常 <span>[<span
                            id="span_jyyc">0</span>]</span></a></li>
                    <li><a href="javascript:void(0);" class="h-explain fastLink span_txsx" state="5" data-idx='3'><i>● </i>入库企业违法违规 <span>[<span
                            id="span_wfwg">0</span>]</span></a></li>
                </ul>
            </div>
        </div>
    </div>

    <!-- 图 -->

    <div class="m-chart-con mb20 clearfix">
        <h4 class="u-xwqy">小微企业全景</h4>
        <div class="u-spread">
            <h5 class="type-title">浙江省小微企业分布图</h5>
            <div id="main1_1" style="height: 300px;"></div>
        </div>
        <div class="u-com-num">
            <h5 class="type-title">小微企业在册数</h5>
            <div id="main1_2" style="height: 300px;"></div>
        </div>
        <div class="u-com-add">
            <h5 class="type-title">小微企业新设/注销数（月）</h5>
            <div id="main2_1" style="height: 300px;"></div>
        </div>
        <div class="clearfix"></div>
        <div class="u-con-msg">
            <div class="u-brt">
                <span>小微企业总数：<i id="js_baseinfoCount">0</i> 户</span>
                <span>小微企业三产比例：<i id="js_scbl">0 : 0 : 0</i></span>
                <span>八大万亿产业小微企业：<i id="js_bdwycount">0</i> 户</span>
            </div>
            <div class="u-brt">
                <span>规上、限上企业：<i id="js_entAboveCount">0</i> 户</span>
                <span>动产抵押企业：<i id="js_dcdyCount">0</i> 户</span>
                <span>注册商标：<i id="js_gjsbCount">0</i> 个</span>
            </div>
            <div class="u-brt">
                <span>盈利企业：<i id="js_addProCount">0</i> 户</span>
                <span>纳税总额：<i id="js_ratGro">0</i> 万元</span>
                <span>从业人数：<i id="js_empNum">0</i> 人</span>
            </div>
        </div>

        <div class="u-com-grow">
            <h5 class="type-title">限上规上企业成长轨迹</h5>
            <div class="type-tuli">
                <span><i class="u-rect-r"></i>规上服务业</span>
                <span><i class="u-rect-o"></i>规上工业</span>
                <span><i class="u-rect-b"></i>限上</span>
                <span class="ml20">单位：万元</span>
            </div>
            <div class="flow-x-auto">
                <ul class="clearfix czgj-box">
                    <li>
                        <h6>营业总收入</h6>
                        <div id="main3_2" style="height: 300px;"></div>
                    </li>
                    <li>
                        <h6>利润总额</h6>
                        <div id="main3_3" style="height: 300px;"></div>
                    </li>
                    <li>
                        <h6>纳税总额</h6>
                        <div id="main3_4" style="height: 300px;"></div>
                    </li>
                </ul>
            </div>

        </div>
    </div>
</div>
<div class="type-box mb20">
    <h3 class="type-hd">小微企业培育库</h3>
    <div class="clearfix">
        <div class="fl pie-charts">
            <h4 class="type-title">动态统计</h4>
            <div class="swiper-charts" style="height:302px">
                <ul class="swiper-wrapper">
                    <li class="swiper-slide">
                        <h5>入库企业</h5>
                        <div id="main3_1" style="height: 300px;"></div>
                    </li>
                    <li class="swiper-slide">
                        <h5>区域分类</h5>
                        <div id="main5_1" style="height: 300px;" ></div>
                    </li>
                    <li class="swiper-slide">
                        <h5>八大产业</h5>
                        <div id="main5_2" style="height: 300px;"></div>
                    </li>
                    <li class="swiper-slide">
                       <h5>创业人群</h5>
                       <div id="main5_3" style="height: 300px;"></div>
                    </li>
                </ul>
                <div class="swipe-btn swipe-next js-news-next">&gt</div>
                <div class="swipe-btn swipe-prev js-news-prev">&lt</div>
            </div>
        </div>
        <div class="fl zxt-charts">
            <h4 class="type-title">成长轨迹</h4>
            <div id="main5_4" style="height: 300px;"></div>
        </div>
    </div>
</div>
<div class="type-box" ${deptCode != '3300' ? 'hidden' : "" }>
    <h3 class="type-hd">数据归集</h3>
    <div style="height: 300px;" id="main4_1">
    </div>
</div>
<script src="../../../../js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="../../../../js/lib/swiper/idangerous.swiper2.7.6.min.js"></script>
<script>
    //图片轮播切
    var mySwiper = new Swiper('.swiper-charts', {
        onlyExternal: true,
        loop: true,
        speed: 500
    });
    $('.js-news-prev').click(function () {
        mySwiper.swipePrev();
    });
    $('.js-news-next').click(function () {
        mySwiper.swipeNext();
    });

    $('.swiper-wrapper li').eq(-1).addClass('js-first-echarts');
    $('.swiper-wrapper li').eq(-2).addClass('js-last-echarts');
    
    //给swiper-wrapper 下面的第一个下面的第一个div设置id js-first
    //给swiper-wrapper 下面的倒数第一个下面的第一个div设置id js-last
// 	$('.swiper-wrapper li').eq(0).children('div:eq(0)').attr('id','js-first');
//     $('.swiper-wrapper li').eq(-1).children('div:eq(0)').attr('id','js-last'); 
    

</script>
<script type="text/javascript">
    var deptCode = "${sessionScope.session_sys_user.departMent.deptCode }".substring(0, 6);
    if (deptCode == "330000") {
        deptCode = "33";
    } else {
        deptCode = deptCode.substring(0, 4);
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/sment/sment_welcome.js"></script>
</body>
</html>