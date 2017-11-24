<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>企业详情地方特色信息页面</title>
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
            <i class="icon-date"></i>成立日期：<span>${fn:substring(entBasicInfo.estDate,0,10)}</span>
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
		            <a href="../../entinfo/iminfo?encryPriPID=${entBasicInfo.encryPriPID }">企业即时信息</a>
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
            <a href="../../entinfo/featureinfo?encryPriPID=${entBasicInfo.encryPriPID }" class="current">地方特色信息</a>
        </li>
    </ul>
</div>

<div class="mb20">
    <div class="mod company-about">
        <div class="mod-bd-panel_company">
            <div class="tip">
                地方特色信息由政府各部门提供，信息的真实性准确性由政府各部门负责
            </div>
            <h3 class="i-title">
                <i></i>商标信息
            </h3>
            <table class="table-common table-feature">
                <thead>
                <tr>
                    <th width="90">
                        序号
                    </th>
                    <th>
                        注册商标
                    </th>
                    <th width="180">
                        使用商品
                    </th>
                    <th width="150">
                        驰名商标/著名商标
                    </th>
                    <th width="150">
                        认定机关
                    </th>
                    <th width="150">
                        认定时间
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        1
                    </td>
                    <td>
                        小米
                    </td>
                    <td>
                        小米
                    </td>
                    <td>
                    </td>
                    <td>
                        北京市工商局
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
                        小米
                    </td>
                    <td>
                        小米
                    </td>
                    <td>
                    </td>
                    <td>
                        北京市工商局
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
                        小米
                    </td>
                    <td>
                        小米
                    </td>
                    <td>
                    </td>
                    <td>
                        北京市工商局
                    </td>
                    <td>
                        2012年6月2日
                    </td>
                </tr>
                </tbody>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 885634 条信息，共234页</span>
                <div id="pagination1" class="pagination"></div>
        </div>
    </div>
    <div class="mod company-about">
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>广告资质
            </h3>
            <table class="table-common table-feature">
                <thead>
                <tr>
                    <th width="90">
                        序号
                    </th>
                    <th>
                        级别
                    </th>
                    <th width="200">
                        类别
                    </th>
                    <th width="150">
                        有效期
                    </th>
                    <th width="150">
                        认定时间
                    </th>
                    <th width="150">
                        认定机关
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td colspan="6">该企业暂无广告资质信息</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="../../../../js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="../../../../js/lib/pagination/jquery.pagination.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/pub/entinfo/entinfo_main.js"></script>
<script>
    $('#pagination1').pagination(500, {
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