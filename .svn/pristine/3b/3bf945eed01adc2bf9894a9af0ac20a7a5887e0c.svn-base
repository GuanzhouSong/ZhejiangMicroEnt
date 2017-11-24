<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>公示系统公告详情页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/pub.css"/>"/>
</head>
<body class="enterprise-info-bg">
<jsp:include page="../common/noticeheader.jsp"></jsp:include>
<div class="mb20 mt20">
    <div class="mod mod-notice-detail mod-notice-detail2">
        <div class="mod-notice-hd mod-hd">
            <h3>严重违法公告</h3>
        </div>
        <div class="mod-notice-bd">
            <h1>
              ${expSeriousCrimeList.addSecOrg}
                <p>列入严重违法失信企业名单决定书</p>
            </h1>
            <p class="tr-center mb20">${expSeriousCrimeList.addSecNo}</p>
            ${expSeriousCrimeList.entName}（统一社会信用代码/注册号：<u>${empty expSeriousCrimeList.uniSCID?expSeriousCrimeList.regNO:expSeriousCrimeList.uniSCID}</u>）：
            <p  style="text-indent:2em;">
		                 经查，你单位因被列入经营异常名录届满3年仍未履行相关义务，违反了《企业信息公示暂行条例》的有关规定且情节严重。依据《严重违法失信企业名单管理暂行办法》第五条第一款第（一）项的规定，
		                 现决定将你单位列入严重违法失信企业名单，并通过企业信用信息公示系统向社会公示。你单位应主动纠正相关违法行为，并申请移出严重违法失信企业名单。</p>
		    <p  style="text-indent:2em;">
			     你单位如对本决定有异议，可以自公示之日起三十日内向我局提出书面申请并提交相关证明材料，要求核实。也可在接到本决定书之日起六十日内向<u>${expSeriousCrimeList.addSecOrg}</u>申请行政复议；
			     或者六个月内向人民法院提起行政诉讼。</p>         
        </div>
        <div class="mod-notice-fd" style="padding-top: 80px">
            <p>${expSeriousCrimeList.addSecOrg}</p>
            <p><fmt:formatDate value="${expSeriousCrimeList.addSecDate}" pattern="yyyy年MM月dd日"/></p>
        </div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>