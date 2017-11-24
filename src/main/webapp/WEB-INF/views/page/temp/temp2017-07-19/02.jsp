<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="index-pd">
    <ul class="sub-tabs js-sub-tab">
        <li class="active"><a href="javascript:;">主体发展情况</a></li>
        <li><a href="javascript:;">信用信息公示情况</a></li>
        <li><a href="javascript:;">企业年报情况</a></li>
        <li><a href="javascript:;">失信联合惩戒</a></li>
        <li><a href="javascript:;">证照“双告知”</a></li>
        <li><a href="javascript:;">抽查“双随机”</a></li>
        <li><a href="javascript:;">“多证合一”管理</a></li>
    </ul>
    <div class="sub-items">
        <div class="item-box clearfix">

            <div class="item-top h-215">
                <div class="two-col-box65 pdr5 fl">
                    <span class="closing-date">截止日期：2017年7月16日</span>
                    <div class="total-data">
                        <div class="total mt20 ml25"><span class="text-data left30 top10">在册企业总数</span><div class="num-box left140"><span class="ml10 num">0</span><span class="num">0</span><span class="num">2</span><span class="num">3</span><span class="num">1</span><span class="num">6</span><span class="num">3</span><span class="num">1</span></div><span class="text-data left590 top10">户</span></div>
                        <div class="text-data increase ml142">同比增长<span class="ml20"><img src="/img/top_icon.png">13.88%</span></div>
                    </div>
                </div>

                <div class="two-col-box35 pdl5 fl">
                    右侧饼图
                </div>
            </div>

            <div class="two-col-box pdr5 fl">
                <div class="charts-cont mt0">
                    <h5 class="cts-hd pdr15">
                        主体年增长情况
                        <div class="fr">
                            <span class="cur">在册总数</span>
                            <span>企业</span>
                            <span>个体户</span>
                            <span>农转让</span>
                        </div>
                    </h5>
                    <div id="pie" class="lic_distribute" style="width:100%; height:445px;"></div>
                </div>
            </div>
            <div class="two-col-box pdl5 fl">
                <div class="charts-cont mt0 clearfix">
                    <h5 class="cts-hd pdr15">
                        在册主体分部
                        <div class="fr">
                            <span class="cur">企业</span>
                            <span>个体户</span>
                            <span>农转让</span>
                        </div>
                    </h5>
                    <div id="pie" class="lic_distribute fl" style="width:60%; height:445px;background-color: red;"></div>
                    <div class="table-box fl">
                        <table class="table-row">
                            <thead>
                                <tr>
                                    <th>地市</th>
                                    <th>企业（户）</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>省局</td>
                                    <td>71517 <span class="top-icon ml10"></span></td>
                                </tr>
                                <tr>
                                    <td>杭州</td>
                                    <td>71517 <span class="top-icon ml10"></span></td>
                                </tr>
                                <tr>
                                    <td>宁波</td>
                                    <td>71517 <span class="down-icon ml10"></span></td>
                                </tr>
                                <tr>
                                    <td>温州</td>
                                    <td>71517 <span class="top-icon ml10"></span></td>
                                </tr>
                                <tr>
                                    <td>嘉兴</td>
                                    <td>71517 <span class="down-icon ml10"></span></td>
                                </tr>
                                <tr>
                                    <td>湖州</td>
                                    <td>71517 <span class="top-icon ml10"></span></td>
                                </tr>
                                <tr>
                                    <td>绍兴</td>
                                    <td>71517 <span class="down-icon ml10"></span></td>
                                </tr>
                                <tr>
                                    <td>金华</td>
                                    <td>71517 <span class="down-icon ml10"></span></td>
                                </tr>
                                <tr>
                                    <td>衢州</td>
                                    <td>71517 <span class="top-icon ml10"></span></td>
                                </tr>
                                <tr>
                                    <td>舟山</td>
                                    <td>71517 <span class="down-icon ml10"></span></td>
                                </tr>
                                <tr>
                                    <td>台州</td>
                                    <td>71517 <span class="top-icon ml10"></span></td>
                                </tr>
                                <tr>
                                    <td>丽水</td>
                                    <td>71517 <span class="down-icon ml10"></span></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <div class="two-col-box60 pdr5 fl">
                <div class="charts-cont">
                    <h5 class="cts-hd pdr15">
                        企业年增长情况
                        <div class="fr">
                            <span class="cur w-120">企业（内、外）</span>
                            <span>内资企业</span>
                            <span>外资企业</span>
                            <span>新设企业</span>
                            <span>小微企业</span>
                            <span>私营企业</span>
                        </div>
                    </h5>
                    <div id="pie" class="lic_distribute" style="width:100%; height:365px;"></div>
                </div>
            </div>
            <div class="two-col-box40 pdl5 fl">
                <div class="charts-cont">
                    <h5 class="cts-hd pdr15">
                        主体“新设/注销”趋势
                        <div class="fr">
                            <span class="cur">在册总数</span>
                            <span>企业</span>
                            <span>个体户</span>
                            <span>农转让</span>
                        </div>
                    </h5>
                    <div id="pie" class="lic_distribute" style="width:100%; height:365px;"></div>
                </div>
            </div>

            <div class="charts-cont fl">
                <h5 class="cts-hd pdr15">
                    主体“新设/注销”趋势
                    <div class="fr">
                        <span class="cur">在册总数</span>
                        <span>企业</span>
                        <span>个体户</span>
                        <span>农转让</span>
                    </div>
                </h5>
                <div class="echarts-box">
                    <div class="select-box top10 left30 pdl20">
                        请选择：
                        <select class="w-85 h-30">
                            <option>浙江</option>
                            <option>上海</option>
                            <option>广东</option>
                        </select>
                    </div>
                    <div id="pie" class="lic_distribute" style="width:100%; height:500px;"></div>
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
