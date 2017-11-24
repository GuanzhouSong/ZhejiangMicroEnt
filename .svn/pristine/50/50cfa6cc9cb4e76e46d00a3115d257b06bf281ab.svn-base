<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>个体户年报公示预览页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>
<form id="_params">
    <input type="hidden" name="year" value="${year}"/>
    <input type="hidden" name="priPID" value="${priPID}"/>
</form>
<%--弹出框--%>
<div class="layer"></div>
<div class="yrpubpreview-pop" id="yrpubpreview-pop" style="display: block;">
    <h5>确认补录你个体户年度报告？</h5>
    <p>1、该年度报告内容将通过企业信用信息公示系统（ http://gsxt.zjaic.gov.cn ）向社会公示，接受社会公众查询和监督；</p>
    <p>2、你企业对年度报告内容的合法性、真实性负责。因公示信息错误、遗漏及违反国家相关规定引起的后果与法律责任由你企业承担；</p>
    <p>3、工商机关对年度报告内容不审查，但将对报告内容进行抽查检查。检查中发现企业在年度报告时弄虚作假、隐瞒真实的，将依法处理并予公示。</p>
    <strong>请确认年度报告信息真实完整！如需修改请取消返回</strong>
    <div class="btn-box">
        <input type="button" value="确定" class="btn-common" id="commit"/>
        <input type="button" value="取消" class="btn-common" id="confirmCancel"/>
    </div>
    <div class="center b-tip">
        服务热线：400-888-4636   服务QQ群：12790338
    </div>
</div>

<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/yr/pbaddrec/pbaddrec_commit.js"></script>
</body>
</html>