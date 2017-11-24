<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>公示系统公告详情页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/pub.css"/>"/>
</head>
<body>
<jsp:include page="../common/enterprise.jsp"></jsp:include>
<div class="mod mod-notice-detail">
    <div class="mod-notice-hd mod-hd">
        <h3>经营异常公告</h3>
    </div>
    <div class="mod-notice-bd">
        <h1>
        	<c:if test="${state == 'in' }">
        		关于${pubOpanoMalyDto.entName }列入经营异常名录行政决定的公告
	            <p>${pubOpanoMalyDto.penDecNo }</p>
        	</c:if>
        	<c:if test="${state == 'out' }">
        		关于${pubOpanoMalyDto.entName }移出经营异常名录行政决定的公告
            	<p>${pubOpanoMalyDto.penDecNoDetail }</p>
            </c:if>
        </h1>
        <h3>${pubOpanoMalyDto.entName }：</h3>
        <c:if test="${state == 'in' }">
        <p style="text-indent:2em;">经查，你单位因公示企业信息隐瞒真实情况、弄虚作假。违反了《企业信息公示暂行条例》和《企业经营异常名录管理暂行办法》的相关规定。根据《企业信息公示暂行条例》第十七条第一款和《企业经营异常名录管理暂行办法》第四条第一款第（三）项和第八条的规定，现决定将你单位列入经营异常名录。 </p>
        <p style="text-indent:2em;">你单位如不服本决定，可在接到本决定书之日起六十日内向${pubOpanoMalyDto.decorgCN }申请行政复议；或者六个月内向人民法院提起行政诉讼。</p>    
        </c:if>
        <c:if test="${state == 'out' }">
        <p style="text-indent:2em;">经查，你单位已经补报未报年份的年度报告并公示。根据《企业信息公示暂行条例》第十七条第二款和《企业经营异常名录管理暂行办法》第十一条的规定，决定将你单位移出经营异常名录。</p>
        <p style="text-indent:2em;">你单位如不服本决定，可在接到本决定书之日起六十日内向${pubOpanoMalyDto.decorgCN }申请行政复议；或者六个月内向人民法院提起行政诉讼。</p>    
        </c:if>
    </div>
    <div class="mod-notice-fd">
        <p>${pubOpanoMalyDto.decorgCN }</p>
        <p>${pubOpanoMalyDto.auditDateDesc }</p>
    </div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>