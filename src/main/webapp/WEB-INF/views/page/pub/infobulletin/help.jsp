<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>公示系统使用帮助页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/pub.css"/>"/>
</head>
<body class="enterprise-info-bg">
<jsp:include page="../common/noticeheader.jsp"></jsp:include>
<div class="mb20">
    <div class="mod mod-help">
        <div class="mod-help-hd mod-hd  mt20">
            <h3>使用帮助</h3>
        </div>
        <div class="mode-help-bd">
            <h1>网站使用须知</h1>
            <h3>一、公示依据</h3>
            <p>本系统信息公示依据《中华人民共和国政府信息公开条例》、《企业信息公示暂行条例》等法律法规、规章的有关规定。</p>
            <h3>二、系统功能简介</h3>
            <p>本系统提供全国企业、农民专业合作社、个体工商户等市场主体信用信息的填报、公示和查询服务。</p>
            <p>1、查询市场主体信用信息，输入名称或注册号进行查询。系统支持按名称的关键词模糊查询，一次最多显示50条记录。对于无效的查询条件，将不会显示查询结果。</p>
            <p>2、市场主体填报年度报告和其他信息，通过本系统，点击“企业公示信息填报”进行填报。</p>
            <h3>三、信息说明</h3>
            <p>1、本系统公示的信息来自工商行政管理部门、其他政府部门及市场主体，政府部门和市场主体分别对其公示信息的真实性负责。</p>
            <p>2、本系统使用过程中如有问题，可拨打市场主体所在省、自治区、直辖市企业信用信息公示系统主页下方的业务咨询电话或技术支持电话。</p>
        </div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>