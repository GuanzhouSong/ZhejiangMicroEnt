<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="index-pd">
<ul class="sub-tabs js-sub-tab">
    <li><a href="javascript:;">信用信息公示情况</a></li>
    <li><a href="javascript:;">信用信息公示情况</a></li>
    <li class="active"><a href="javascript:;">信用信息公示情况</a></li>
    <li><a href="javascript:;">信用信息公示情况</a></li>
    <li><a href="javascript:;">信用信息公示情况</a></li>
</ul>

<div class="sub-items">
    <div class="item-box" style="display: none"><img src="/img/reg/server/show-img01.jpg" alt=""></div>
    <div class="item-box" style="display: none"><img src="/img/reg/server/show-img02.jpg" alt=""></div>
    <div class="item-box">
        <div class="mb10 title-tab clearfix">
            <h4 class="cur"><a href="javascript:;">浙江省可信证照全景图<em>截止2017年7月16日 13:35</em></a></h4>
        </div>
        <div class="form-box mb10">
            <div class="form-list">
                <div class="form-item clearfix">
                    <div class="col-6">
                        <label class="item-name col-7">
                            <span class="long-label">年报年度：</span>
                        </label>
                        <div class="col-5">
                            <div class="ipt-box col-12">
                                <input type="text" class="ipt-txt" name="uniSCID">
                            </div>
                        </div>
                    </div>
                    <div class="col-6">
                        <label class="item-name col-3">主体类型：</label>
                        <div class="col-7">
                            <div class="ipt-box col-12">
                                <span class="type-sele cur">企业</span>
                                <span class="type-sele">个体户</span>
                                <span class="type-sele">农专社</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="clearfix">
            <div class="two-col-box60 pdr5 fl">
                <div class="data-msg-info mb10">
                    <ul class="clearfix">
                        <li class="jds-info">
                            <div>
                                <h5>应报数（万户）</h5>
                                <strong>168.18</strong>
                            </div>
                        </li>
                        <li class="ybs-info">
                            <div>
                                <h5>已报数（万户）</h5>
                                <strong>168.18</strong></div>
                        </li>
                        <li class="nbl-info">
                            <div>
                                <h5>年报率</h5>
                                <strong>168.18</strong></div>
                        </li>
                    </ul>
                </div>
                <div class="two-col-box pdr5">
                    <div class="charts-cont mt0">
                        <h5 class="cts-hd">
                            证照分布（厅级）
                        </h5>
                        <div id="pie" class="lic_distribute" style="width:100%; height:290px;"></div>
                    </div>
                </div>
                <div class="two-col-box pdl5">
                    <div class="charts-cont mt0">
                        <h5 class="cts-hd">
                            证照分布（厅级）
                        </h5>
                        <div id="pie" class="lic_distribute" style="width:100%; height:290px;"></div>
                    </div>
                </div>

            </div>
            <div class="two-col-box40 pdl5 fl">
                <div class="charts-cont mt0">
                    <h5 class="cts-hd">
                        证照分布（厅级）
                    </h5>
                    <div id="pie" class="lic_distribute" style="width:100%; height:390px;"></div>
                </div>
            </div>
            <div class="charts-cont fl">
                <h5 class="cts-hd">
                    证照分布（厅级）
                </h5>

                <ul class="company-type clearfix mt10">
                    <li class="active">企业（内、外资）</li><li>内资企业</li><li>外资企业</li><li>新设企业</li><li>小微企业</li><li class="last-child">私营企业</li>
                </ul>
                <div class="center nb-charts-tip"><span><i class="ynb"></i>已年报</span><span><i class="wnb"></i>未年报</span><span><i class="nbl"></i>年报率</span></div>
                <div class="clearfix mb20">
                    <div class="two-col-box fl border-right">
                        <div id="pie" class="lic_distribute" style="width:100%; height:390px;"></div>
                    </div>
                    <div class="two-col-box fl">
                        <div id="pie" class="lic_distribute" style="width:100%; height:390px;"></div>
                    </div>
                </div>


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
