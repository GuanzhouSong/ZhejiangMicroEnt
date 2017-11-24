<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>部门选择</title>
    <link rel="stylesheet" href="/css/pub-syn.css">
</head>
<body class="outer-bg">
<div class="login-hd border-top7 center">
    <img src="/img/pub-syn/login-logo.png" alt="">
</div>
<div class="log-cont-bg">
    <h3 class="section-title">请选择部门</h3>
    <div class="section-box">
        <div class="sect-tab-hd js-tab-hd">
            <ul class="clearfix">
                <li class="cur">省政府组成部门</li>
                <li>省政府直属特设机构</li>
                <li>省政府直属机构</li>
                <li>部门管理机构</li>
                <li>其他省级单位</li>
            </ul>
        </div>
        <div class="sect-tab-cont js-tab-cont mt10">
            <div class="item">
                <ul class="clearfix">
                    <li><a href="#">浙江省发展和改革委员会</a></li>
                    <li><a href="#">浙江省经济和信息化委员会</a></li>
                    <li><a href="#">浙江省教育厅</a></li>
                    <li><a href="#">浙江省科学技术厅</a></li>
                </ul>
                <ul class="clearfix">
                    <li><a href="#">浙江省民族宗教事务委员会</a></li>
                    <li><a href="#"> 浙江省公安厅</a></li>
                    <li><a href="#">浙江省监察厅</a></li>
                    <li><a href="#">浙江省民政厅</a></li>
                </ul>
                <ul class="clearfix">
                    <li><a href="#">浙江省司法厅</a></li>
                    <li><a href="#">浙江省财政厅</a></li>
                    <li><a href="#">浙江省人力资源和社会保障厅</a></li>
                    <li><a href="#">浙江省国土资源厅</a></li>

                </ul>
                <ul class="clearfix">
                    <li><a href="#">浙江省环境保护厅</a></li>
                    <li><a href="#">浙江省住房和城乡建设厅</a></li>
                    <li><a href="#">浙江省交通运输厅</a></li>
                    <li><a href="#">浙江省水利厅</a></li>
                </ul>
                <ul class="clearfix">
                    <li><a href="#">浙江省农业厅</a></li>
                    <li><a href="#">浙江省林业厅</a></li>
                    <li><a href="#">浙江省商务厅</a></li>
                    <li><a href="#">浙江省文化厅</a></li>
                </ul>
                <ul class="clearfix">
                    <li><a href="#">浙江省卫生计生委</a></li>
                    <li><a href="#">浙江省审计厅</a></li>
                    <li><a href="#">浙江省外事侨务办公室</a></li>
                </ul>

            </div>
            <div class="item" style="display: none">
                <ul>
                    <li><a href="#"><span class="mr-20">浙江省国有资产监督管理委员会</span></a></li>
                </ul>
            </div>
            <div class="item" style="display: none">
                <ul>
                    <li><a href="#">浙江省地方税务局</a></li>
                    <li><a href="#">浙江省工商行政管理局</a></li>
                    <li><a href="#">浙江省质量技术监督局</a></li>
                    <li><a href="#">浙江省新闻出版广电局</a></li>
                </ul>
                <ul>
                    <li><a href="#">浙江省体育局</a></li>
                    <li><a href="#">浙江省安全生产监督管理局</a></li>
                    <li><a href="#">浙江省食品药品监督管理局</a></li>
                    <li><a href="#">浙江省统计局</a></li>
                </ul>
                <ul>
                    <li><a href="#">浙江省海洋与渔业局</a></li>
                    <li><a href="#">浙江省旅游局</a></li>
                    <li><a href="#">浙江省粮食局</a></li>
                    <li><a href="#">浙江省机关事务管理局</a></li>
                </ul>
                <ul>
                    <li><a href="#">浙江省人民政府法制办公室</a></li>
                    <li><a href="#">浙江省人民防空办公室</a></li>
                </ul>
            </div>
            <div class="item" style="display: none">
                <ul>
                    <li><a href="#">浙江省物价局
                    </a></li>
                    <li><a href="#">浙江省文物局
                    </a></li>
                    <li><a href="#">浙江省监狱管理局
                    </a></li>
                </ul>
            </div>
            <div class="item" style="display: none">
                <ul>
                    <li><a href="#">浙江省供销社
                    </a></li>
                    <li><a href="#">浙江省测绘与地理信息局
                    </a></li>
                    <li><a href="#">浙江省地震局
                    </a></li>
                    <li><a href="#">国家统计局浙江调查总队
                    </a></li>
                </ul>
                <ul>
                    <li><a href="#">浙江省金融办</a></li>
                    <li><a href="#">浙江省气象局</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script>
    $(function () {
        $('.js-tab-hd li').click(function () {
            $(this).addClass('cur').siblings().removeClass('cur');
            $('.js-tab-cont .item').eq($(this).index()).show().siblings().hide();
        })
    })
</script>
</body>
</html>
