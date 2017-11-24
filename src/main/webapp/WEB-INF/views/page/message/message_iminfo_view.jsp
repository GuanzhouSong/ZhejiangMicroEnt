<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <title>企业即时信息公示提醒</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	<meta name="renderer" content="webkit">
	<meta charset="utf-8">
    <link rel="stylesheet" href="/css/pub.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
	<link rel="stylesheet" href="/css/reg.client.css">
    <!-- 正式 -->
	<script type="text/javascript" src="https://hm.baidu.com/hm.js?503ba8bab9e32eb24b79b59a886d8e8f"></script>
	<!-- 测试 -->
	<!-- <script type="text/javascript" src="https://hm.baidu.com/hm.js?3ecdad4c6bf5c76ce987441f963a4fba"></script> -->
</head>
<body class="bg-brown1">
<div class="gstx-head mb20">
    <div class="gstx-head-top"></div>
    <div class="gstx-head-con">
        <div class="cent">
            <img src="/img/pub/NationalEmblem.jpg">
           <div class="title">
                <p class="title-one">国家企业信用信息公示系统<span class="province">(浙江)</span></p>
                <p class="title-t">National Enterprise Credit Infomation Publicity System</p>
           </div>
        </div>
    </div>
</div>

<div class="gstx-con">
    <a href="http://zj.gsxt.gov.cn/pub/infobulletin/yearreport" target="_blank" class="btn">立即申报</a>
    <div class="info">
        <p class="info-title">企业即时信息公示提醒 </p>
        <p class="time">发送日期：<span class="span_sendDate"></span></p>
        <div class="info-con mt35 border-bottom-ccc">
            <p class="mb15">您担任工商联络员的以下<span class="color-red">${fn:length(pList)}</span>家企业<span class="color-red">有企业即时信息（股东及出资信息）</span></p>
            <p class="color-red mb15">未公示或公示不完整情况：</p>
            <p class="color-red mb20">温馨提醒：为避免此原因被列入经营异常名录，请及时填报与公示</p>
        </div>

        <div class="info-con mt20 border-bottom-ccc letter-spacing-1">
            <p class="mb15">根据《企业信息公示暂行条例》企业股东及出资信息自形成之日起<span class="color-red">20个工作日</span></p>
            <p class="mb15">内应通过企业信用信息公示系统向社会公示。</p>
            <p class="mb20">请对照以下股东及出资信息公示规范要求报送并公示你企业的相关信息：</p>
            <ul>
                <li>1、认缴出资信息请比照你企业公司章程按照每个股东每次认缴出资信息进行填写；</li>
                <li>2、实缴出资信息应按照每个股东每次实际已出资信息进行填写；</li>
                <li>3、企业所有股东认缴金额总和应与你企业的注册资本额相一致；</li>
                <li>4、企业认缴出资日期已到期的，应及时填写对应的实缴出资信息。</li>
                <li>5、企业认缴出资股东人员姓名与数量应与企业登记的股东信息一致。</li>
            </ul>
        </div>

        <div class="info-con mt20 border-bottom-ccc letter-spacing-1">
            <c:if test="${not empty pList}">
            	<p class="mb20">未公示或公示不完整的企业有：</p>
            	<ul>
		        <c:forEach var="t" items="${pList}" varStatus="status"> 
			        <li><span class="">${status.count}、${t.entname}：</span>   统一社会信用代码:${t.unicode }</li> 
		        </c:forEach>
		        </ul>
		     </c:if>             
        </div>
        <div class="net mt20">
            <a href="http://zj.gsxt.gov.cn/pub/infobulletin/yearreport" target="_blank">报送地址：http://zj.gsxt.gov.cn/pub/infobulletin/yearreport</a>
        </div>
    </div>
</div>
</body>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/message/message_iminfo_view.js"></script>
</html>
