<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>企业详情即时信息页面</title>
    <link rel="stylesheet" href="/css/pub.css">
</head>
<body class="enterprise-info-bg">
<!-- 头部 -->
<jsp:include page="../../common/enterprise.jsp"></jsp:include>
<!-- 公司基本信息 -->
<div class="mod company-basic clearfix">
    <div class="thumbnail">
        <img src="../../../../img/pub/thumbnail.png" alt="">
    </div>
    <div class="caption">
        <h3 class="title">${entBasicInfo.entName }
        	<c:if test="${entBasicInfo.regState=='K'||entBasicInfo.regState=='A'||entBasicInfo.regState=='B'}">
	            <span class="icon-rectangle icon-blue">存续</span>
            </c:if>
            <c:if test="${entBasicInfo.regState=='DA'}">
            	<span class="tip">（该企业被列入经营异常名录）</span>
           		<span class="icon-rectangle icon-red">吊销未注销</span>
            </c:if>
            <c:if test="${entBasicInfo.regState=='D'}">
            	<span class="tip">（该企业被列入经营异常名录）</span>
           		<span class="icon-rectangle icon-gray">吊销</span>
            </c:if>
        </h3>
        <p>
            <i class="icon-book"></i>统一社会信用代码/注册号：<span>${entBasicInfo.regNO }</span>
        </p>
        <p>
            <i class="icon-person"></i>法定代表人：<span>${entBasicInfo.leRep }</span>
        </p>
        <p>
            <i class="icon-local"></i>住所：<span>${entBasicInfo.dom }</span>
        </p>
        <p>
            <i class="icon-date"></i>成立日期：<span><fmt:formatDate value="${entBasicInfo.estDate}" pattern="yyyy-MM-dd"/> </span>
        </p>
    </div>
    <div class="btn-box">
        <a href="#"><i class="icon-send"></i>发送报告</a>
        <a href="#"><i class="icon-share"></i>信息分享</a>
    </div>
</div>

<!-- tab -->
<div class="mod company-tab">
    <ul class="tab-list">
        <li>
            <a href="../../entinfo/baseinfo?encryPriPID=${entBasicInfo.encryPriPID }">基本信息</a>
        </li>
        <c:choose>  
		    <c:when test="${entBasicInfo.entTypeCatg==16||entBasicInfo.entTypeCatg==17||entBasicInfo.entTypeCatg==50}"> 
		    </c:when>  
		    <c:otherwise>
		        <li>
		            <a href="../../entinfo/iminfo?encryPriPID=${entBasicInfo.encryPriPID }" class="current">企业即时信息</a>
		        </li>
		    </c:otherwise>
	    </c:choose>
        <li>
            <a href="../../entinfo/yrinfo?encryPriPID=${entBasicInfo.encryPriPID }&id=1">
            <c:choose>  
			    <c:when test="${entBasicInfo.entTypeCatg==16||entBasicInfo.entTypeCatg==17}"> 
					农专年报信息
			    </c:when>  
			    <c:when test="${entBasicInfo.entTypeCatg==50}">  
					个体户年报信息
			    </c:when>  
			    <c:otherwise>
					企业年报信息
			    </c:otherwise>
		    </c:choose>
            </a>
        </li>
        <li>
            <a href="../../entinfo/anomalyinfo?encryPriPID=${entBasicInfo.encryPriPID }">警示信息</a>
        </li>
        <li>
            <a href="../../entinfo/otherinfo?encryPriPID=${entBasicInfo.encryPriPID }">其他信息</a>
        </li>
        <li>
            <a href="../../entinfo/featureinfo?encryPriPID=${entBasicInfo.encryPriPID }">地方特色信息</a>
        </li>
    </ul>
</div>

<div class="mb20">
    <!-- 股东及出资信息 -->
    <div class="mod company-about">
        <div class="mod-bd-panel_company">
            <div class="tip">
                企业即时信息由该企业提供，企业对其即时信息的真实性、合法性负责
            </div>
            <h3 class="i-title">
                <i></i>股东及出资信息
                <a href="#" class="more">查看修改记录>></a>
            </h3>
            <table class="table-common table-gudong-imme">
                <thead>
                <tr>
                    <th rowspan="2" width="80">
                        股东
                    </th>
                    <th rowspan="2" width="55">
                        认缴额(万元)
                    </th>
                    <th rowspan="2" width="55">
                        实缴额(万元)
                    </th>
                    <th colspan="4">
                        认缴明细
                    </th>
                    <th colspan="4">
                        实缴明细
                    </th>
                </tr>
                <tr>
                    <th width="70">
                        认缴出资方式
                    </th>
                    <th width="70">
                        认缴出资额(万元)
                    </th>
                    <th width="105">
                        认缴出资日期
                    </th>
                    <th width="105">
                        公示日期
                    </th>
                    <th width="70">
                        实缴出资方式
                    </th>
                    <th width="70">
                        实缴出资额(万元)
                    </th>
                    <th width="105">实缴出资日期</th>
                    <th>
                        公示日期
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td rowspan="3">
                        张云兵
                    </td>
                    <td rowspan="3">
                        500
                    </td>
                    <td rowspan="3">
                        400
                    </td>
                    <td>
                        知识产权
                    </td>
                    <td>
                        100
                    </td>
                    <td>
                        2014年1月10日
                    </td>
                    <td>
                        2014年1月10日
                    </td>
                    <td>
                        货币
                    </td>
                    <td>
                        50
                    </td>
                    <td>
                        2014年2月25日
                    </td>
                    <td>
                        2014年2月25日
                    </td>
                </tr>
                <tr>
                    <td>
                        实物
                    </td>
                    <td>
                        100
                    </td>
                    <td>
                        2014年1月10日
                    </td>
                    <td>
                        2014年1月10日
                    </td>
                    <td>
                        货币
                    </td>
                    <td>
                        50
                    </td>
                    <td>
                        2014年2月25日
                    </td>
                    <td>
                        2014年2月25日
                    </td>
                </tr>
                <tr>
                    <td>
                        实物
                    </td>
                    <td>
                        100
                    </td>
                    <td>
                        2014年1月10日
                    </td>
                    <td>
                        2014年1月10日
                    </td>
                    <td>
                        货币
                    </td>
                    <td>
                        50
                    </td>
                    <td>
                        2014年2月25日
                    </td>
                    <td>
                        2014年2月25日
                    </td>
                </tr>
                </tbody>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 885634 条信息，共234页</span>
                <div id="pagination" class="pagination">

                </div>
            </div>
        </div>
    </div>

    <!-- 股权变更信息 -->
    <div class="mod company-about">
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>股权变更信息
                <a href="#" class="more">查看修改记录&gt;&gt;</a>
            </h3>
            <table class="table-common">
                <thead>
                <tr>
                    <th width="80">
                        序号
                    </th>
                    <th width="200">
                        股东
                    </th>
                    <th width="200">
                        变更前股权比例
                    </th>
                    <th width="170">
                        变更后股权比例
                    </th>
                    <th width="150">
                        股权变更日期
                    </th>
                    <th>
                        公示日期
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        1
                    </td>
                    <td>
                        张强
                    </td>
                    <td>
                        90%
                    </td>
                    <td>
                        30%
                    </td>
                    <td>
                        2012年6月2日
                    </td>
                    <td>
                        2012年6月2日
                    </td>
                </tr>
                <tr>
                    <td>
                        2
                    </td>
                    <td>
                        张强
                    </td>
                    <td>
                        90%
                    </td>
                    <td>
                        30%
                    </td>
                    <td>
                        2012年6月2日
                    </td>
                    <td>
                        2012年6月2日
                    </td>
                </tr>
                <tr>
                    <td>
                        3
                    </td>
                    <td>
                        张强
                    </td>
                    <td>
                        90%
                    </td>
                    <td>
                        30%
                    </td>
                    <td>
                        2012年6月2日
                    </td>
                    <td>
                        2012年6月2日
                    </td>
                </tr>
                <tr>
                    <td>
                        4
                    </td>
                    <td>
                        张强
                    </td>
                    <td>
                        90%
                    </td>
                    <td>
                        30%
                    </td>
                    <td>
                        2012年6月2日
                    </td>
                    <td>
                        2012年6月2日
                    </td>
                </tr>
                <tr>
                    <td>
                        5
                    </td>
                    <td>
                        张强
                    </td>
                    <td>
                        90%
                    </td>
                    <td>
                        30%
                    </td>
                    <td>
                        2012年6月2日
                    </td>
                    <td>
                        2012年6月2日
                    </td>
                </tr>
                </tbody>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 885634 条信息，共234页</span>
                <div id="pagination2" class="pagination">

                </div>
            </div>
        </div>
    </div>

    <!-- 行政许可信息 -->
    <div class="mod company-about">
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>行政许可信息
            </h3>
            <table class="table-common">
                <thead>
                <tr>
                    <th width="46">
                        序号
                    </th>
                    <th width="130">
                        许可文件编号
                    </th>
                    <th width="130">
                        许可文件名称
                    </th>
                    <th width="110">
                        有效期自
                    </th>
                    <th width="110">
                        有效期至
                    </th>
                    <th width="150">
                        许可机关
                    </th>
                    <th width="150">
                        许可内容
                    </th>
                    <th width="50">
                        状态
                    </th>
                    <th>
                        详情
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        1
                    </td>
                    <td>
                        20130000018587
                    </td>
                    <td>
                        矿产经营资格证书
                    </td>
                    <td>
                        2010年1月3日
                    </td>
                    <td>
                        2014年5月3日
                    </td>
                    <td>北京发展和改革委员会</td>
                    <td>矿产开采经营</td>
                    <td>有效</td>
                    <td><a href="#">查看</a></td>
                </tr>
                <tr>
                    <td>
                        2
                    </td>
                    <td>
                        20130000018587
                    </td>
                    <td>
                        矿产经营资格证书
                    </td>
                    <td>
                        2010年1月3日
                    </td>
                    <td>
                        2014年5月3日
                    </td>
                    <td>北京发展和改革委员会</td>
                    <td>矿产开采经营</td>
                    <td>有效</td>
                    <td><a href="#">查看</a></td>
                </tr>
                <tr>
                    <td>
                        3
                    </td>
                    <td>
                        20130000018587
                    </td>
                    <td>
                        矿产经营资格证书
                    </td>
                    <td>
                        2010年1月3日
                    </td>
                    <td>
                        2014年5月3日
                    </td>
                    <td>北京发展和改革委员会</td>
                    <td>矿产开采经营</td>
                    <td>有效</td>
                    <td><a href="#">查看</a></td>
                </tr>
                <tr>
                    <td>
                        4
                    </td>
                    <td>
                        20130000018587
                    </td>
                    <td>
                        矿产经营资格证书
                    </td>
                    <td>
                        2010年1月3日
                    </td>
                    <td>
                        2014年5月3日
                    </td>
                    <td>北京发展和改革委员会</td>
                    <td>矿产开采经营</td>
                    <td>有效</td>
                    <td><a href="#">查看</a></td>
                </tr>
                <tr>
                    <td>
                        5
                    </td>
                    <td>
                        20130000018587
                    </td>
                    <td>
                        矿产经营资格证书
                    </td>
                    <td>
                        2010年1月3日
                    </td>
                    <td>
                        2014年5月3日
                    </td>
                    <td>北京发展和改革委员会</td>
                    <td>矿产开采经营</td>
                    <td>有效</td>
                    <td><a href="#">查看</a></td>
                </tr>
                </tbody>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 885634 条信息，共234页</span>
                <div id="pagination4" class="pagination">

                </div>
            </div>
        </div>
    </div>

    <!-- 知识产权出质登记信息 -->
    <div class="mod company-about">
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>知识产权出质登记信息
            </h3>
            <table class="table-common">
                <thead>
                <tr>
                    <th width="35">
                        序号
                    </th>
                    <th width="170">
                        注册号/统一社会信用代码
                    </th>
                    <th width="80">
                        名称
                    </th>
                    <th width="70">
                        种类
                    </th>
                    <th width="92">
                        出质人名称
                    </th>
                    <th width="92">
                        质权人名称
                    </th>
                    <th width="210">
                        质权登记期限
                    </th>
                    <th width="35">
                        状态
                    </th>
                    <th width="100">
                        公示日期
                    </th>
                    <th>
                        详情
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        1
                    </td>
                    <td>
                        9111000MA023819110
                    </td>
                    <td>
                        福乐多
                    </td>
                    <td>
                        商标
                    </td>
                    <td>
                        李铭
                    </td>
                    <td>蒋大为</td>
                    <td>2013年10月6日-2014年10月6日</td>
                    <td>有效</td>
                    <td>2012年6月2日</td>
                    <td><a href="#">查看</a></td>
                </tr>
                <tr>
                    <td>
                        2
                    </td>
                    <td>
                        9111000MA023819110
                    </td>
                    <td>
                        福乐多
                    </td>
                    <td>
                        商标
                    </td>
                    <td>
                        李铭
                    </td>
                    <td>蒋大为</td>
                    <td>2013年10月6日-2014年10月6日</td>
                    <td>有效</td>
                    <td>2012年6月2日</td>
                    <td><a href="#">查看</a></td>
                </tr>
                <tr>
                    <td>
                        3
                    </td>
                    <td>
                        9111000MA023819110
                    </td>
                    <td>
                        福乐多
                    </td>
                    <td>
                        商标
                    </td>
                    <td>
                        李铭
                    </td>
                    <td>蒋大为</td>
                    <td>2013年10月6日-2014年10月6日</td>
                    <td>有效</td>
                    <td>2012年6月2日</td>
                    <td><a href="#">查看</a></td>
                </tr>
                <tr>
                    <td>
                        4
                    </td>
                    <td>
                        9111000MA023819110
                    </td>
                    <td>
                        福乐多
                    </td>
                    <td>
                        商标
                    </td>
                    <td>
                        李铭
                    </td>
                    <td>蒋大为</td>
                    <td>2013年10月6日-2014年10月6日</td>
                    <td>有效</td>
                    <td>2012年6月2日</td>
                    <td><a href="#">查看</a></td>
                </tr>
                <tr>
                    <td>
                        5
                    </td>
                    <td>
                        9111000MA023819110
                    </td>
                    <td>
                        福乐多
                    </td>
                    <td>
                        商标
                    </td>
                    <td>
                        李铭
                    </td>
                    <td>蒋大为</td>
                    <td>2013年10月6日-2014年10月6日</td>
                    <td>有效</td>
                    <td>2012年6月2日</td>
                    <td><a href="#">查看</a></td>
                </tr>
                </tbody>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 885634 条信息，共234页</span>
                <div id="pagination5" class="pagination">

                </div>
            </div>
        </div>
    </div>

    <!-- 行政处罚信息 -->
    <div class="mod company-about">
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>行政处罚信息
            </h3>
            <table class="table-common table-chufa">
                <thead>
                <tr>
                    <th width="35">
                        序号
                    </th>
                    <th width="155">
                        决定书文号
                    </th>
                    <th width="155">
                        违法行为类型
                    </th>
                    <th width="130">
                        行政处罚内容
                    </th>
                    <th width="155">
                        决定机关名称
                    </th>
                    <th width="110">
                        处罚决定日期
                    </th>
                    <th width="110">
                        公示日期
                    </th>
                    <th>
                        备注
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        1
                    </td>
                    <td>
                        京工商处字2012第1号
                    </td>
                    <td>
                        京工商处字2012第1号
                    </td>
                    <td>
                        罚款100万
                    </td>
                    <td>
                        北京市工商行政管理局
                    </td>
                    <td>2013年12月1日</td>
                    <td>2013年12月1日</td>
                    <td rowspan="2">复议结束</td>
                </tr>
                <tr>
                    <td colspan="7" class="tip2">
                        <div class="fl">有变更情形：</div>
                        <div class="fl">
                            <p>1、北京市工商行政管理局2013年5月4日将行政复议罚款金额由100万变更为50万。</p>
                            <p>2、北京市工商行政管理局2012年3月4日将行政复议罚款金额由50万变更为60万</p>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 885634 条信息，共234页</span>
                <div id="pagination6" class="pagination">

                </div>
            </div>
        </div>
    </div>

</div>

<jsp:include page="../../common/footer.jsp"></jsp:include>
<script src="../../../../js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="../../../../js/lib/pagination/jquery.pagination.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/pub/entinfo/entinfo_main.js"></script>
<script>
    $('#pagination').pagination(500, {
        callback: function () {
        },
        prev_text: '<i class="icon-triangle-left"></i>上一页',
        next_text: '下一页<i class="icon-triangle-right"></i>',
        num_display_entries: 3,
        num_edge_entries: 2,
        current_page: 1,
        link_to: 'javascript:void(0)',
        ellipse_text: '...',
        first_text: '首页',
        last_text: '末页',
    });

    $('#pagination2').pagination(500, {
        callback: function () {
        },
        prev_text: '<i class="icon-triangle-left"></i>上一页',
        next_text: '下一页<i class="icon-triangle-right"></i>',
        num_display_entries: 3,
        num_edge_entries: 2,
        current_page: 1,
        link_to: 'javascript:void(0)',
        ellipse_text: '...',
        first_text: '首页',
        last_text: '末页',
    });

    $('#pagination3').pagination(500, {
        callback: function () {
        },
        prev_text: '<i class="icon-triangle-left"></i>上一页',
        next_text: '下一页<i class="icon-triangle-right"></i>',
        num_display_entries: 3,
        num_edge_entries: 2,
        current_page: 1,
        link_to: 'javascript:void(0)',
        ellipse_text: '...',
        first_text: '首页',
        last_text: '末页',
    });

    $('#pagination4').pagination(500, {
        callback: function () {
        },
        prev_text: '<i class="icon-triangle-left"></i>上一页',
        next_text: '下一页<i class="icon-triangle-right"></i>',
        num_display_entries: 3,
        num_edge_entries: 2,
        current_page: 1,
        link_to: 'javascript:void(0)',
        ellipse_text: '...',
        first_text: '首页',
        last_text: '末页',
    });

    $('#pagination5').pagination(500, {
        callback: function () {
        },
        prev_text: '<i class="icon-triangle-left"></i>上一页',
        next_text: '下一页<i class="icon-triangle-right"></i>',
        num_display_entries: 3,
        num_edge_entries: 2,
        current_page: 1,
        link_to: 'javascript:void(0)',
        ellipse_text: '...',
        first_text: '首页',
        last_text: '末页',
    });

    $('#pagination6').pagination(500, {
        callback: function () {
        },
        prev_text: '<i class="icon-triangle-left"></i>上一页',
        next_text: '下一页<i class="icon-triangle-right"></i>',
        num_display_entries: 3,
        num_edge_entries: 2,
        current_page: 1,
        link_to: 'javascript:void(0)',
        ellipse_text: '...',
        first_text: '首页',
        last_text: '末页',
    });
</script>
</body>
</html>