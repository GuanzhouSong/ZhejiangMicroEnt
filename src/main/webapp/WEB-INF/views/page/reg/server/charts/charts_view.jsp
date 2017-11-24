<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="areaCode" value="${fn:substring(session_sys_user.deptCode, 0, 4)}"/>
<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>警示首页-可视化图形</title>
    <link rel="shortcut icon" href="../img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/layout-default-latest.css">
</head>
<body class="index-pd">
<ul class="sub-tabs js-sub-tab">
    <li class="" data-tab="_tab1" init="0"><a href="javascript:;">主体发展情况</a></li>
    <li class="" data-tab="_tab2" init="0"><a href="javascript:;">信用信息公示情况</a></li>
    <li class="" data-tab="_tab3" init="0"><a href="javascript:;">企业年报情况</a></li>
    <li class="" data-tab="_tab4" init="0"><a href="javascript:;">抽查“双随机”</a></li>
    <li class="" data-tab="_tab5" init="0"><a href="javascript:;">双告知情况</a></li>
</ul>

<div class="sub-items">

    <!-- tab1 主体发展情况 start -->
    <div class="item-box clearfix _tab1" style="display: none;">

        <div class="item-top h-215">
            <div class="two-col-box65 pdr5 fl">
                <span class="closing-date">截止日期：${serverPreDate}</span>
                <div class="total-data">
                    <div class="total mt20 ml25">
                        <span class="text-data left30 top10">在册市场主体总数</span>
                        <div class="num-box left140" id="tab1_num">
                            <span class="ml10 num">0</span>
                            <span class="num">0</span>
                            <span class="num">0</span>
                            <span class="num">0</span>
                            <span class="num">0</span>
                            <span class="num">0</span>
                            <span class="num">0</span>
                            <span class="num">0</span>
                        </div>
                        <span class="text-data left590 top10">户</span></div>
                 <%--   <div class="text-data increase ml142">同比增长<span class="ml20"><img src="/img/top_icon.png">13.88%</span></div>--%>
                </div>
            </div>
            <div id="chart1_0" class="two-col-box35 pdl5 fl" style="height: 210px;"></div>
        </div>

        <div class="two-col-box pdr5 fl">
            <div class="charts-cont mt0">
                <h5 class="cts-hd pdr15">
                    主体年增长情况
                    <div class="fr" id="js-tab1-1">
                        <span class="tab1_1 cur" data-value="0">全部</span>
                        <span class="tab1_1" data-value="1">企业</span>
                        <span class="tab1_1" data-value="2">农专社</span>
                        <span class="tab1_1" data-value="3">个体户</span>
                    </div>
                </h5>
                <div id="chart1_1" class="lic_distribute" style="width:100%; height:445px;"></div>
            </div>
        </div>
        <div class="two-col-box pdl5 fl">
            <div class="charts-cont mt0 clearfix">
                <h5 class="cts-hd pdr15">
                    在册主体分布
                    <div class="fr" id="js-tab1-2">
                        <span class="tab1_2 cur" data-value="1">企业</span>
                        <span class="tab1_2" data-value="2">农专社</span>
                        <span class="tab1_2" data-value="3">个体户</span>
                    </div>
                </h5>
                <div id="chart1_2" class="lic_distribute fl" style="width:60%; height:445px;"></div>
                <div class="table-box fl">
                    <table class="table-row">
                        <thead>
                        <tr>
                            <th>地市</th>
                            <th>企业（户）</th>
                        </tr>
                        </thead>
                        <tbody id="tab1-city-num">
                        <!--
                         图标样式：
                             <td>71517 <span class="top-icon ml10"></span></td> 向上
                             <td>71517 <span class="down-icon ml10"></span></td> 向下
                         -->
                        <tr>
                            <td>省局</td>
                            <td class="city"></td>
                        </tr>
                        <tr>
                            <td>杭州</td>
                            <td class="city"></td>
                        </tr>
                        <tr>
                            <td>宁波</td>
                            <td class="city"></td>
                        </tr>
                        <tr>
                            <td>温州</td>
                            <td class="city"></td>
                        </tr>
                        <tr>
                            <td>嘉兴</td>
                            <td class="city"></td>
                        </tr>
                        <tr>
                            <td>湖州</td>
                            <td class="city"></td>
                        </tr>
                        <tr>
                            <td>绍兴</td>
                            <td class="city"></td>
                        </tr>
                        <tr>
                            <td>金华</td>
                            <td class="city"></td>
                        </tr>
                        <tr>
                            <td>衢州</td>
                            <td class="city"></td>
                        </tr>
                        <tr>
                            <td>舟山</td>
                            <td class="city"></td>
                        </tr>
                        <tr>
                            <td>台州</td>
                            <td class="city"></td>
                        </tr>
                        <tr>
                            <td>丽水</td>
                            <td class="city"></td>
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
                    <div class="fr" id="js-tab1-3">
                        <span class="tab1_3 cur w-120" data-value="4">企业(内、外)</span>
                        <span class="tab1_3" data-value="5">内资企业</span>
                        <span class="tab1_3" data-value="6">外资企业</span>
                       <%--
                        <span class="tab1_3" data-value="4">新设企业</span>
                        <span class="tab1_3" data-value="5">小微企业</span>
                        <span class="tab1_3" data-value="6">私营企业</span>
                        --%>
                    </div>
                </h5>
                <div id="chart1_3" class="lic_distribute" style="width:100%; height:365px;"></div>
            </div>
        </div>
        <div class="two-col-box40 pdl5 fl">
            <div class="charts-cont">
                <h5 class="cts-hd pdr15">
                    主体“新设/注销”趋势
                    <div class="fr" id="js-tab1-4">
                        <span class="tab1_4 cur" data-value="0">全部</span>
                        <span class="tab1_4 " data-value="1">企业</span>
                        <span class="tab1_4" data-value="2">农专社</span>
                        <span class="tab1_4" data-value="3">个体户</span>
                    </div>
                </h5>
                <div id="chart1_4" class="lic_distribute" style="width:100%; height:365px;"></div>
            </div>
        </div>

        <div class="charts-cont fl">
            <h5 class="cts-hd pdr15">
                行业新设/注销企业趋势
              <%--  <div class="fr" id="js-tab1-5">
                    <span class="tab1_5 cur" data-value="0">全部</span>
                    <span class="tab1_5 " data-value="1">企业</span>
                    <span class="tab1_5" data-value="2">个体户</span>
                    <span class="tab1_5" data-value="3">农专社</span>
                </div>--%>
            </h5>
            <div class="echarts-box">
                <div class="select-box top10 left30 pdl20">
                    请选择：
                    <select class="w-85 h-30" id="js-tab1-city">
                        <option value="33" selected>全省</option>
                        <option value="3300">省局</option>
                        <option value="3301">杭州</option>
                        <option value="3302">宁波</option>
                        <option value="3303">温州</option>
                        <option value="3304">嘉兴</option>
                        <option value="3305">湖州</option>
                        <option value="3306">绍兴</option>
                        <option value="3307">金华</option>
                        <option value="3308">衢州</option>
                        <option value="3309">舟山</option>
                        <option value="3310">台州</option>
                        <option value="3325">丽水</option>
                    </select>
                    年份：
                    <select class="w-85 h-30" id="js-tab1-year">
                        <c:forEach var="i" begin="2005" end='${reportYear}' step="1">
                            <option value="${i}" ${i==reportYear?'selected':''}>${i}</option>
                        </c:forEach>
                    </select>
                    月份：
                    <select class="w-85 h-30" id=js-tab1-month>
                        <option value="01" ${month=='01'?'selected':''}>01</option>
                        <option value="02" ${month=='02'?'selected':''}>02</option>
                        <option value="03" ${month=='03'?'selected':''}>03</option>
                        <option value="04" ${month=='04'?'selected':''}>04</option>
                        <option value="05" ${month=='05'?'selected':''}>05</option>
                        <option value="06" ${month=='06'?'selected':''}>06</option>
                        <option value="07" ${month=='07'?'selected':''}>07</option>
                        <option value="08" ${month=='08'?'selected':''}>08</option>
                        <option value="09" ${month=='09'?'selected':''}>09</option>
                        <option value="10" ${month=='10'?'selected':''}>10</option>
                        <option value="11" ${month=='11'?'selected':''}>11</option>
                        <option value="12" ${month=='12'?'selected':''}>12</option>
                    </select>
                    <input type="button" id="js-tab1-serarch" value="查询" class="btn mr20">
                </div>
                <div id="chart1_5" class="lic_distribute" style="width:100%; height:600px;"></div>
            </div>

        </div>
    </div>
    <!-- tab1 主体发展情况 end -->

    <!-- tab2 信用信息公示情况 start  -->
    <div class="item-box clearfix _tab2" style="display: none;" >
        <div class="item-top h-65">
            <div class="one-col-box100 pdr5 fl">
                <div class="clearfix item-top-title" style="">
                    <div class="select-box fl mr20">
                        请选择：
                        <select class="w-85 h-30" id="js-tab2-city">
                            <option value="33">全省</option>
                            <option value="3300" ${areaCode=='3300'?'selected':''}>省局</option>
                            <option value="3301" ${areaCode=='3301'?'selected':''}>杭州</option>
                            <option value="3302" ${areaCode=='3302'?'selected':''}>宁波</option>
                            <option value="3303" ${areaCode=='3303'?'selected':''}>温州</option>
                            <option value="3304" ${areaCode=='3304'?'selected':''}>嘉兴</option>
                            <option value="3305" ${areaCode=='3305'?'selected':''}>湖州</option>
                            <option value="3306" ${areaCode=='3306'?'selected':''}>绍兴</option>
                            <option value="3307" ${areaCode=='3307'?'selected':''}>金华</option>
                            <option value="3308" ${areaCode=='3308'?'selected':''}>衢州</option>
                            <option value="3309" ${areaCode=='3309'?'selected':''}>舟山</option>
                            <option value="3310" ${areaCode=='3310'?'selected':''}>台州</option>
                            <option value="3325" ${areaCode=='3325'?'selected':''}>丽水</option>
                        </select>
                    </div>
                    <span class="closing-date ml20">截止日期：${serverPreDate}</span>
                    <div class="total-data fl">
                        <div class="total"><span class="text-data">系统公示主体总数</span><div class="num-box left140"  id="tab2_num" ><span class="ml10 num">0</span><span class="num">0</span><span class="num">0</span><span class="num">0</span><span class="num">0</span><span class="num">0</span><span class="num">0</span><span class="num">0</span></div><span class="text-data">户</span></div>
                    </div>
                </div>
            </div>
        </div>

        <div class="two-col-box45 pdr5 fl">
            <div class="charts-cont">
                <h5 class="cts-hd pdr15">
                    企业信用信息公示概览
                </h5>
                <div id="chart2_1" class="lic_distribute" style="width:100%; height:295px;"></div>
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
                            <p class="fs14" id="js-tab2-xzxk">获取中...</p>
                        </div>
                        <div>
                            <p class="abnormal-color">列入经营异常名单</p>
                            <p class="fs14" id="js-tab2-lrjyyc">获取中...</p>
                        </div>
                        <div>
                            <p class="danger-color">列入严重违法失信名单</p>
                            <p class="fs14" id="js-tab2-lryzwfsx">获取中...</p>
                        </div>
                    </div>
                </div>
                <div class="two-col-box60 fl">
                    <div class="punish-title mt20 center">
                        <span class="mr20 fs16 color-o">行政处罚</span> <span class="fs14" id="js-tab2-xzcf">xxx户/xxx条</span>
                    </div>
                    <div id="chart2_2" class="lic_distribute" style="width:100%; height:235px;"></div>
                </div>

            </div>
        </div>

        <div class="charts-cont fl">
            <h5 class="cts-hd pdr15">
                企业基本信息公示
            </h5>
            <div class="echarts-box">
                <div id="chart2_3" class="lic_distribute" style="width:100%; height:460px;"></div>
            </div>

        </div>

        <div class="charts-cont fl">
            <h5 class="cts-hd pdr15">
                信息公告统计
            </h5>
            <div class="two-col-box60 fl">
                <div id="chart2_4" class="lic_distribute" style="width:100%; height:400px;"></div>
            </div>


            <div class="two-col-box40 fl">
                <div class="select-box mt20 bg-ef pdl20">
                    <span class="fs16">信息公告分类统计</span>
                    <div class="fr mr20">
                        请选择：
                        <select class="w-145 h-30" id="js-tab2-notice">
                            <option value="1">经营异常名录公告</option>
                            <option value="2">严重违法失信企业公告</option>
                            <option value="3">抽查检查公告</option>
                            <option value="4">行政处罚公告</option>
                            <option value="5">司法协助公告</option>
                            <option value="6">简易注销公告</option>
                            <option value="7">其他公告</option>
                            <%--  <option value="8">催报公告</option>--%>
                        </select>
                    </div>
                </div>
                <div id="chart2_5" class="lic_distribute" style="width:100%; height:400px;"></div>
            </div>
        </div>
    </div>
    <!-- tab2 信用信息公示情况 end  -->

    <!-- tab3 企业年报情况 start -->
    <div class="item-box clearfix _tab3" style="display: none;">
        <div class="mb10 title-tab clearfix">
            <h4 class="cur"><a href="javascript:;">企业年度报告<em>截止时间${serverPreDate}</em></a></h4>
        </div>
        <div class="form-box mb10">
            <div class="form-list">
                <div class="form-item clearfix">
                    <div class="fl">
                        <div class="mr20 clearfix">
                            <label class="item-name fl">
                                查询范围：
                            </label>
                            <div class="fl mr10">
                                <c:if test="${fn:substring(session_sys_user.deptCode, 0, 4)=='3300'}">
                                    <select id="js-tab3-city" style="width: 100px;height: 25px;">
                                        <option value="33">全省</option>
                                        <option value="3300" selected>省局</option>
                                        <option value="3301">杭州</option>
                                        <option value="3302">宁波</option>
                                        <option value="3303">温州</option>
                                        <option value="3304">嘉兴</option>
                                        <option value="3305">湖州</option>
                                        <option value="3306">绍兴</option>
                                        <option value="3307">金华</option>
                                        <option value="3308">衢州</option>
                                        <option value="3309">舟山</option>
                                        <option value="3310">台州</option>
                                        <option value="3325">丽水</option>
                                    </select>
                                </c:if>
                                ${fn:substring(session_sys_user.deptCode, 0, 4)=='3301'?'杭州':''}
                                ${fn:substring(session_sys_user.deptCode, 0, 4)=='3302'?'宁波':''}
                                ${fn:substring(session_sys_user.deptCode, 0, 4)=='3303'?'温州':''}
                                ${fn:substring(session_sys_user.deptCode, 0, 4)=='3304'?'嘉兴':''}
                                ${fn:substring(session_sys_user.deptCode, 0, 4)=='3305'?'湖州':''}
                                ${fn:substring(session_sys_user.deptCode, 0, 4)=='3306'?'绍兴':''}
                                ${fn:substring(session_sys_user.deptCode, 0, 4)=='3307'?'金华':''}
                                ${fn:substring(session_sys_user.deptCode, 0, 4)=='3308'?'衢州':''}
                                ${fn:substring(session_sys_user.deptCode, 0, 4)=='3309'?'舟山':''}
                                ${fn:substring(session_sys_user.deptCode, 0, 4)=='3310'?'台州':''}
                                ${fn:substring(session_sys_user.deptCode, 0, 4)=='3325'?'丽水':''}
                            </div>
                            <label class="item-name fl">
                                年报年度：
                            </label>
                            <div class="ipt-box fl">
                                <div class="ipt-box col-1">
                                    <select id="js-tab3-year" style="width: 100px;height: 25px;">
                                        <c:forEach var="selectYear" items="${yearList}">
                                            <option value="${selectYear}" ${selectYear==(year-1)?'selected':''}>${selectYear}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="fl">
                        <label class="item-name fl">主体类型：</label>
                        <div class="fl">
                            <div class="ipt-box fl mr20" id="js-tab3-type">
                                <span class="js-tab3-entTypeCatg type-sele cur " data-value="1">企业</span>
                                <span class="js-tab3-entTypeCatg type-sele " data-value="2">农专社</span>
                                <span class="js-tab3-entTypeCatg type-sele" data-value="3">个体户</span>
                            </div>

                        </div>
                    </div>
                    <div class="fl" style="text-align: center;margin-bottom: 4px;">
                        <input type="button" id="js-tab3-serarch" value="查询" class="btn mr20">
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
                                <h5>应报数（户）</h5>
                                <strong id="js-tab-sum1">获取中...</strong>
                            </div>
                        </li>
                        <li class="ybs-info">
                            <div>
                                <h5>已报数（户）</h5>
                                <strong id="js-tab-sum2">获取中...</strong></div>
                        </li>
                        <li class="nbl-info">
                            <div>
                                <h5>年报率</h5>
                                <strong id="js-tab-sum3">获取中...</strong></div>
                        </li>
                    </ul>
                </div>
                <div class="two-col-box pdr5">
                    <div class="charts-cont mt0" style="position: relative">

                        <h5 class="cts-hd">
                            近3年年报率
                        </h5>
                        <!-- chart3_1  -->
                        <div style="height: 10px;color: red;text-align: center;font-size: 16px;"></div>
                        <div id="chart3_1" class="lic_distribute" style="width:100%; height:290px;"></div>
                        <!-- 遮罩层 修复关于鼠标移入彩虹图出现的百分比bug -->
                        <div style="z-index: 19891016; width: 400px;height: 300px; background-color: #eeeaea; opacity: 0.01;filter:alpha(opacity=1);position: absolute;display: block;top: -10px;"></div>
                    </div>
                </div>
                <div class="two-col-box pdl5">
                    <div class="charts-cont mt0">
                        <h5 class="cts-hd">
                            年报报送方式情况
                        </h5>
                        <!-- chart3_2  -->
                        <div style="height: 10px;color: red;text-align: center;font-size: 16px;"></div> <!-- 信息提示 -->
                        <div id="chart3_2" class="lic_distribute" style="width:100%; height:290px;"></div>
                    </div>
                </div>

            </div>
            <div class="two-col-box40 pdl5 fl">
                <div class="charts-cont mt0">
                    <h5 class="cts-hd">
                        报送趋势
                    </h5>
                    <!-- chart3_3  -->
                    <div style="height: 10px;color: red;text-align: center;font-size: 16px;"></div> <!-- 信息提示 -->
                    <div id="chart3_3"  class="lic_distribute" style="width:100%; height:390px;"></div>
                </div>
            </div>
            <div class="charts-cont fl">
                <h5 class="cts-hd">
                    年报主体情况
                </h5>

                <ul class="company-type clearfix mt10 w50" id="js-tab3-qy-type">
                    <li class="js-tab3-qytype active " data-type="4">企业（内、外资）</li>
                    <li class="js-tab3-qytype"  data-type="5">内资企业</li>
                    <li class="js-tab3-qytype last-child"  data-type="6">外资企业</li>
                    <%-- <li class="js-tab3-qytype"  data-type="7">新设企业</li>
                     <li class="js-tab3-qytype"  data-type="8">小微企业</li>
                     <li class="js-tab3-qytype last-child "  data-type="9">私营企业</li>--%>
                </ul>


                <div class="center nb-charts-tip w50">
                    <span><i class="ynb"></i>已年报</span>
                    <span><i class="wnb"></i>未年报</span>
                    <span><i class="nbl"></i>年报率</span>
                </div>
                <div class="clearfix mb20">
                    <div class="two-col-box fl border-right">
                        <!-- chart3_4  -->
                        <div style="height: 10px;color: red;text-align: center;font-size: 16px;"></div> <!-- 信息提示 -->
                        <div id="chart3_4"  class="lic_distribute" style="width:100%; height:600px;">

                        </div>
                    </div>

                    <div class="two-col-box fl">
                        <div style="height: 10px;color: red;text-align: center;font-size: 16px;"></div> <!-- 信息提示 -->
                        <div id="chart3_5" class="lic_distribute" style="width:100%; height:600px;">

                        </div>
                    </div>
                </div>


            </div>

        </div>
    </div>
    <!-- tab3 企业年报情况 end -->

    <!-- tab4 抽查“双随机”  -->
    <div class="item-box _tab4" style="display: none;">
	<div class="page-wrap1">
	    <div class="page-wrap-gray1">
	        <div class="count-select">
	            <p><span>统计区域：
	            <select name="checkRptArea" id="checkRptArea">
                  <option value="">全省</option>
                  <option value="3300">省局</option>
                  <option value="3301">杭州</option>
                  <option value="3302">宁波</option>
                  <option value="3303">温州</option>
                  <option value="3304">嘉兴</option>
                  <option value="3305">湖州</option>
                  <option value="3306">绍兴</option>
                  <option value="3307">金华</option>
                  <option value="3308">衢州</option>
                  <option value="3309">舟山</option>
                  <option value="3310">台州</option>
                  <option value="3325">丽水</option>
	            </select>
	            </span>
	            </p>
	            <p><span>统计年度：	            
	            <select name="rptYear" id="rptYear">
                     <c:forEach var="selectYear" items="${curyearList}">
                         <option value="${selectYear}">${selectYear}</option>
                     </c:forEach>
	            </select></span></p>
	            <p class="fr">截止日期：<span>${serverPreDate}</span></p>
	        </div>
	        <div class="six-entry">
	            <ul class="clearfix">
	                <li class="u-color1">
	                    <h4 class="six-entry-title">年度抽查计划（个）</h4>
	                    <div>
	                        <div>
	                            <i id="jh1">0</i>
	                            <p id="jh2">本部门：0</p>
	                            <p id="jh3">跨部门：0</p>
	                        </div>
	                    </div>
	                </li>
	                <li class="u-color2">
	                    <h4 class="six-entry-title">抽查检查任务（个）</h4>
	                    <div>
	                        <div>
	                            <i id="rw1">0</i>
	                            <p id="rw2">本部门：0</p>
	                            <p id="rw3">跨部门：0</p>
	                        </div>
	                    </div>
	                </li>
	                <li class="u-color3">
	                    <h4 class="six-entry-title">应抽查主体（户次）</h4>
	                    <p id="surezt">获取中...</p>
	                </li>
	                <li class="u-color4">
	                    <h4 class="six-entry-title">已抽查主体（户次）</h4>
	                    <p id="isCheckzt">获取中...</p>
	                </li>
	                <li class="u-color5">
	                    <h4 class="six-entry-title">参与检查人员（人次）</h4>
	                    <p id="checknum">获取中...</p>
	                </li>
	                <li class="u-color6">
	                    <h4 class="six-entry-title">抽查完成率</h4>
	                    <p id="checkroate">获取中...</p>
	                </li>
	            </ul>
	        </div>
	
	        <div class="u-count-wrap">
	            <h4 class="u-count-tit">本年度各地市抽查工作情况</h4>
	            <div class="clearfix">
	                <div class="u-count-l" id="chart4_0">
	
	                </div>
	                <div class="u-count-r">
	                    <div class="u-tab-wrap">
	                        <table class="u-count-check" id="checktable">
	                            <tr>
	                                <th>地市</th>
	                                <th>应检查（户次）</th>
	                                <th>已检查（户次）</th>
	                                <th>检查人员（人次）</th>
	                                <th>检查完成率</th>
	                            </tr>
	                            <tr><td>省局</td><td></td><td></td><td></td><td></td></tr>
	                            <tr><td>杭州</td><td></td><td></td><td></td><td></td></tr>
	                            <tr><td>宁波</td><td></td><td></td><td></td><td></td></tr>
	                            <tr><td>温州</td><td></td><td></td><td></td><td></td></tr>
	                            <tr><td>嘉兴</td><td></td><td></td><td></td><td></td></tr>
	                            <tr><td>湖州</td><td></td><td></td><td></td><td></td></tr>
	                            <tr><td>绍兴</td><td></td><td></td><td></td><td></td></tr>
	                            <tr><td>金华</td><td></td><td></td><td></td><td></td></tr>
	                            <tr><td>衢州</td><td></td><td></td><td></td><td></td></tr>
	                            <tr><td>台州</td><td></td><td></td><td></td><td></td></tr>
	                            <tr><td>舟山</td><td></td><td></td><td></td><td></td></tr>
	                            <tr><td>丽水</td><td></td><td></td><td></td><td></td></tr>
	                        </table>
	                    </div>
	                </div>
	            </div>
	        </div>
	
	        <div class="u-count-wrap">
	            <h4 class="u-count-tit">抽查结果情况</h4>
	            <div class="clearfix check-result">
	                <div class="u-echart-t1" id="chart4_1">
	
	                </div>
	                <div class="u-echart-t2">
	                    <div class="u-left">
	                        <p>完结率 <span id="endRoate">获取中...</span></p>
	                        <h4 id="endTotal" style="width:0%"><span id="endleft" style="width:93.38%"></span></h4>
	                        <div class="end-msg">
	                            <div class="u-l">
	                                <p>已完结</p>
	                                <h6 id="endNum">获取中...</h6>
	                            </div>
	                            <div class="u-r">
	                                <p>未完结</p>
	                                <h6 id="notEndNum">获取中...</h6>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="u-right" id="chart4_2" style="height:300px;">
	
	                    </div>
	                </div>
	            </div>
	        </div>
	
	    </div>
	</div>
    </div>
    <!-- tab4 抽查双随机 完 -->
    
    <!-- tab5 双告知 开始 -->
    <div class="_tab5 item-box" style="display: none;">
	    <div class="page-wrap1">
	    <div class="page-wrap-gray1">
	        <div class="count-select">
	            <p>
	            <span>统计区域：
	            	<select name="areaCode" id="selectarea">
	                  <option value="" ${areaCode=='3300'?'selected':''}>全省</option>
	                   <option value="3300">省局</option>
                       <option value="3301" ${areaCode=='3301'?'selected':''}>杭州</option>
                       <option value="3302" ${areaCode=='3302'?'selected':''}>宁波</option>
                       <option value="3303" ${areaCode=='3303'?'selected':''}>温州</option>
                       <option value="3304" ${areaCode=='3304'?'selected':''}>嘉兴</option>
                       <option value="3305" ${areaCode=='3305'?'selected':''}>湖州</option>
                       <option value="3306" ${areaCode=='3306'?'selected':''}>绍兴</option>
                       <option value="3307" ${areaCode=='3307'?'selected':''}>金华</option>
                       <option value="3308" ${areaCode=='3308'?'selected':''}>衢州</option>
                       <option value="3309" ${areaCode=='3309'?'selected':''}>舟山</option>
                       <option value="3310" ${areaCode=='3310'?'selected':''}>台州</option>
                       <option value="3325" ${areaCode=='3325'?'selected':''}>丽水</option>
	            	</select>
	            </span>
	            </p>
	            <p>
	            <span>统计年度：
	             	<select name="dtyear" id="selectyear">
	             	   <c:forEach var="selectYear" end="1" items="${curyearList}" step="1">
                         <option value="${selectYear}">${selectYear}年</option>
                       </c:forEach>
	             	</select>
	            </span>
	            </p>
	            <p class="fr">截止日期：<span>${serverPreDate}</span></p>
	        </div>
	
	        <div class="clearfix">
	            <div class="fl sgz-data">
	                <ul>
	                    <li>
	                        <div class="tsbm-item">
	                            <p><em>推送部门（个）</em></p>
	                            <span>获取中...</span>
	                        </div>
	                    </li>
	                    <li>
	                        <div class="yxts-item">
	                            <p><em>有效推送（条）</em></p>
	                            <span>获取中...</span>
	                        </div>
	                    </li>
	                    <li>
	                        <div class="yrl-item">
	                            <p><em>已认领（条）</em></p>
	                            <span>获取中...</span>
	                        </div>
	                    </li>
	                    <li>
	                        <div class="lyl-item">
	                            <p><em>认领率</em></p>
	                            <span>获取中...</span>
	                        </div>
	                    </li>
	                </ul>
	            </div>
	            <div class="fl rl-chart">
	                <h4>认领情况</h4>
	                <div id="chart5_0" style="height: 230px;margin-top: -230px"></div>
	            </div>
	        </div>
	
	        <div class="u-count-wrap">
	            <h4 class="u-count-tit">部门推送情况</h4>
	            <div class="clearfix">
	                <div class="u-count-l">
	                    <h4 class="inner-hd">推送部门Top10</h4>
	                    <div id="chart5_1" style="width:90%; height:420px;margin-left: 10px">
	
	                    </div>
	                </div>
	                <div class="u-count-r">
	                    <div class="u-tab-wrap">
	                        <table class="u-count-check">
	                            <tr>
	                                <th>职能部门</th>
	                                <th>有效推送（条）</th>
	                                <th>已认领（条）</th>
	                                <th>认领率</th>
	                            </tr>
	                            <tbody id="pushInfo">
	                             
	                            </tbody>
	                        </table>
	                    </div>
	                </div>
	            </div>
	        </div>
	
	        <div class="u-count-wrap">
	            <h4 class="u-count-tit">部门认领情况</h4>
	            <div class="clearfix">
	                <div class="b-count-l">
	                    <div class="count-select center">
	                        <p>
	                          <span>职能部门：
	                          	<select name="dutyDeptCode" id="dutyDeptCode">
	                          	 <option value=""></option>
	                          	 <c:forEach var="codeDutyDept" items="${dutyCodeList}">
                                       <option value="${codeDutyDept.deptCode}"}>${codeDutyDept.deptName}</option>
                                  </c:forEach>
	                          	</select>
	                          </span>
	                        </p>
	                    </div>
	                    <div id="chart5_2" style="width:95%; height:300px;">
	
	                    </div>
	                </div>
	                <div class="b-count-r">
	                    <div class="u-tab-wrap" id="chart5_3" style="width:90%; height:300px;">
	
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
</div>
    

</div>

<%-- 后台参数 start --%>
<script>
    window._config = {
        tabId:'${tabId}',
        year:'${reportYear}', //年份
        month:'${month}', //月份
        yearAndMonth:'${yearAndMonth}', //年份和月份
        serverDate:'${serverDate}',//系统时间
        serverPreDate:'${serverPreDate}', //当前系统前一天日期
        areaCode:'${fn:substring(session_sys_user.deptCode, 0, 4)}'  //当前用户所属部门编码
    };

</script>
<%-- 后台参数 start --%>
<script src="/js/lib/respond.js"></script>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/server/charts/charts_main.js"/>"></script>

</body>
</html>




