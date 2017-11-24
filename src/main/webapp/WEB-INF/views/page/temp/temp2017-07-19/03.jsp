<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="index-pd">
<ul class="sub-tabs js-sub-tab">
    <li><a href="javascript:;">主体发展情况</a></li>
    <li class="active"><a href="javascript:;">信用信息公示情况</a></li>
    <li><a href="javascript:;">企业年报情况</a></li>
    <li><a href="javascript:;">失信联合惩戒</a></li>
    <li><a href="javascript:;">证照“双告知”</a></li>
    <li><a href="javascript:;">抽查“双随机”</a></li>
    <li><a href="javascript:;">“多证合一”管理</a></li>
</ul>
<div class="sub-items">
    <div class="item-box clearfix">

        <div class="item-top h-65">
            <div class="one-col-box100 pdr5 fl">
                <div class="clearfix item-top-title" style="">
                    <div class="select-box fl mr20">
                        请选择：
                        <select class="w-85 h-30">
                            <option>浙江省</option>
                            <option>上海</option>
                            <option>广东</option>
                        </select>
                    </div>
                    <span class="closing-date ml20">截止日期：2017年7月16日</span>
                    <div class="total-data fl">
                        <div class="total"><span class="text-data">系统公示主体总数</span><div class="num-box left140"><span class="ml10 num">0</span><span class="num">0</span><span class="num">2</span><span class="num">3</span><span class="num">1</span><span class="num">6</span><span class="num">3</span><span class="num">1</span></div><span class="text-data">户</span></div>
                    </div>
                </div>
            </div>
        </div>

        <div class="two-col-box45 pdr5 fl">
            <div class="charts-cont">
                <h5 class="cts-hd pdr15">
                    企业信用信息公示概览
                </h5>
                <div id="pie" class="lic_distribute" style="width:100%; height:295px;"></div>
            </div>
        </div>
        <div class="two-col-box55 pdl5 fl">
            <div class="charts-cont clearfix">
                <h5 class="cts-hd pdr15">
                    企业信用信息公示
                </h5>
                <div class="two-col-box40 fl">
                    <div class="info-text">
                        <div>
                            <p class="permit-color">行政许可</p>
                            <p class="fs14">xxx户/xxx条</p>
                        </div>
                        <div>
                            <p class="abnormal-color">列入经营异常名单</p>
                            <p class="fs14">xxx户/xxx条</p>
                        </div>
                        <div>
                            <p class="danger-color">列入严重违法失信名单</p>
                            <p class="fs14">xxx户/xxx条</p>
                        </div>
                    </div>
                </div>
                <div class="two-col-box60 fl">
                    <div class="punish-title mt20 center">
                        <span class="mr20 fs16 color-o">行政处罚</span> <span class="fs14">xxx户/xxx条</span>
                    </div>
                    <div id="pie" class="lic_distribute" style="width:100%; height:235px;"></div>
                </div>

            </div>
        </div>

        <div class="charts-cont fl">
            <h5 class="cts-hd pdr15">
                企业基本信息公示
            </h5>
            <div class="echarts-box">
                <div id="pie" class="lic_distribute" style="width:100%; height:349px;"></div>
            </div>

        </div>

        <div class="charts-cont fl">
            <h5 class="cts-hd pdr15">
                信息公告统计
            </h5>
            <div class="two-col-box60 fl">
                <div class="mt20 clearfix notice-box">
                    <div class="abnormal-notice">
                        <p class="mt85">异常名录公告</p>
                        <p>xxx条</p>
                    </div>
                    <div class="illegal-notice">
                        <p class="mt85">严重违法失信企业名单公告</p>
                        <p>xxx条</p>
                    </div>
                    <div class="check-notice">
                        <p class="mt85">异常名录公告</p>
                        <p>xxx条</p>
                    </div>
                    <div class="punish-notice">
                        <p class="mt85">异常名录公告</p>
                        <p>xxx条</p>
                    </div>
                    <div class="judicial-notice">
                        <p class="mt85">异常名录公告</p>
                        <p>xxx条</p>
                    </div>
                    <div class="simple-notice">
                        <p class="mt85">异常名录公告</p>
                        <p>xxx条</p>
                    </div>
                    <div class="other-notice">
                        <p class="mt85">异常名录公告</p>
                        <p>xxx条</p>
                    </div>
                </div>
            </div>


            <div class="two-col-box40 fl">
                <div class="select-box mt20 bg-ef pdl20">
                    <span class="fs16">信息公告分类统计</span>
                   <div class="fr mr20">
                       请选择：
                       <select class="w-145 h-30">
                           <option>经营异常名录公告</option>
                           <option>上海</option>
                           <option>广东</option>
                       </select>
                   </div>
                </div>
                <div id="pie" class="lic_distribute" style="width:100%; height:230px;"></div>
            </div>
        </div>
    </div>
</div>


<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script>
    $('.js-sub-tab li').click(function () {
        $(this).addClass('active').siblings().removeClass('active');
        $('.sub-items .item-box').eq($(this).index()).show().siblings().hide();
    })
</script>
</body>
</html>
