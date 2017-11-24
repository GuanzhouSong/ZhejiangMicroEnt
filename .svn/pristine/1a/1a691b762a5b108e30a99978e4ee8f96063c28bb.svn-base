<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>本部门问题数据处理</title>
    <link rel="stylesheet" href="/css/pub-syn.css">
</head>
<body class="outer-bg">
<div class="header mod">
<jsp:include page="common/header.jsp"></jsp:include>
<div class="mod clearfix">
   <jsp:include page="common/menu.jsp?module=wtsjcl&menu=xxcxtj"></jsp:include>
    <div class="main">
        <div class="crumbs">
            <a href="javascript:void(0)">首页</a> &gt;
            <a href="javascript:void(0)">信息管理</a> &gt;
            <a href="javascript:void(0)" class="cur">本部门归集或接收信息的查询统计</a>
        </div>
        <div class="pdlr5">
            <div class="search-box filter-item mb36">
                <p>
                    <label class="tr w100">查询年度：</label>
                    <select name="year" id="selectDate">
                                </select>
                    <input type="button"  id="search" value="查询" class="ipt-btn ml50">
                </p>
            </div>
            <table cellpadding="0" cellspacing="0" class="table-common">
                <thead>
                <tr>
                    <th rowspan="2" width="68">提供/接收<br/>类别</th>
                    <th rowspan="2" colspan="2" width="168">信息类别</th>
                    <th colspan="2" width="140">全省总计</th>
                    <th colspan="2" width="140">省本级</th>
                    <th colspan="2" width="140">杭州市</th>
                    <th colspan="2" width="140">宁波市</th>
                    <th colspan="2" width="140">温州市</th>
                    <th colspan="2" width="140">嘉兴市</th>
                    <th colspan="2" width="140">湖州市</th>
                    <th colspan="2" width="140">绍兴市</th>
                    <th colspan="2" width="140">金华市</th>
                    <th colspan="2" width="140">衢州市</th>
                    <th colspan="2" width="140">舟山市</th>
                    <th colspan="2" width="140">台州市</th>
                    <th colspan="2" width="140">丽水市</th>
                </tr>
                <tr>
                    <th>本年度</th>
                    <th>累计</th>
                    <th>本年度</th>
                    <th>累计</th>
                    <th>本年度</th>
                    <th>累计</th>
                    <th>本年度</th>
                    <th>累计</th>
                    <th>本年度</th>
                    <th>累计</th>
                    <th>本年度</th>
                    <th>累计</th>
                    <th>本年度</th>
                    <th>累计</th>
                    <th>本年度</th>
                    <th>累计</th>
                    <th>本年度</th>
                    <th>累计</th>
                    <th>本年度</th>
                    <th>累计</th>
                    <th>本年度</th>
                    <th>累计</th>
                    <th>本年度</th>
                    <th>累计</th>
                    <th>本年度</th>
                    <th>累计</th>
                </tr>
                </thead>
                <tbody>
                <tr id="tj6">
                    <td rowspan="21" class="bg-gray">本部门<br/>发送信息</td>
                    <td colspan="2" class="bg-gray">总计<br/>提供条数</td>
                </tr>
                <tr id="tj7">
                    <td rowspan="4" width="14" class="bg-gray" style="padding: 0px 5px;">行<br/>政<br/>许<br/>可<br/>信<br/>息</td>
                    <td class="bg-gray" width="70">合计</td>
                </tr>
                <tr id="tj8">
                    <td class="bg-gray">记名成功</td>
                </tr>
                <tr id="tj9">
                    <td class="bg-gray">记名不成功</td>
                </tr>
                <tr id="tj10">
                    <td class="bg-gray">处理中</td>
                </tr>
                <tr id="tj11">
                    <td rowspan="4" class="bg-gray">行政处罚信息</td>
                    <td class="bg-gray">合计</td>
                </tr>
                <tr id="tj12">
                    <td class="bg-gray">记名成功</td>
                </tr>
                <tr id="tj13">
                    <td class="bg-gray">记名不成功</td>
                </tr>
                <tr id="tj14">
                    <td class="bg-gray">处理中</td>
                </tr>
                <tr id="tj15">
                    <td rowspan="4" class="bg-gray">抽查检查结果</td>
                    <td class="bg-gray">合计</td>
                </tr>
                <tr id="tj16">
                    <td class="bg-gray">记名成功</td>
                </tr>
                <tr id="tj17">
                    <td class="bg-gray">记名不成功</td>
                </tr>
                <tr id="tj18">
                    <td class="bg-gray">处理中</td>
                </tr>
                <tr id="tj19">
                    <td rowspan="4" class="bg-gray">小微企业扶持信息</td>
                    <td class="bg-gray">合计</td>
                </tr>
                <tr id="tj20">
                    <td class="bg-gray">记名成功</td>
                </tr>
                <tr id="tj21">
                    <td class="bg-gray">记名不成功</td>
                </tr>
                <tr id="tj22">
                    <td class="bg-gray">处理中</td>
                </tr>
                <tr id="tj23">
                    <td rowspan="3" class="bg-gray">联合惩戒信息</td>
                    <td class="bg-gray">合计</td>
                </tr>
                <tr id="tj24">
                    <td class="bg-gray">有效条数</td>
                </tr>
                <tr >
                </tr>
                <tr id="tj25">
                    <td class="bg-gray">部门公告</td>
                    <td class="bg-gray">发布条数</td>
                </tr>
                <tr id="tj1">
                    <td rowspan="5" class="bg-gray">本门<br/>接收信息</td>
                    <td colspan="2" class="bg-gray">总计<br/>接收条数</td>
                </tr>
                <tr id="tj2">
                    <td class="bg-gray">双告知</td>
                    <td class="bg-gray">接收条数</td>
                </tr>
                <tr id="tj3">
                    <td class="bg-gray">经营异常名录</td>
                    <td class="bg-gray">接收条数</td>
                </tr>
                <tr id="tj4">
                    <td class="bg-gray">严重违法失信企业名单</td>
                    <td class="bg-gray">接收条数</td>
                </tr>
                <tr id="tj5">
                    <td class="bg-gray">联合惩戒信息</td>
                    <td class="bg-gray">接收条数</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div class="mod">
    <div class="footer-box">
        <div class="footer">
            <p>版权所有：浙江省工商行政管理局</p>
            <p>年报公示业务咨询电话：400-888-4636（年报）&nbsp;&nbsp;&nbsp;&nbsp;技术支持电话：400-888-4636（公示）&nbsp;&nbsp;&nbsp;&nbsp;京ICP备16053442号-1</p>
        </div>
    </div>
</div>
</body>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/depsyn/infostat_list.js"></script>
</html>