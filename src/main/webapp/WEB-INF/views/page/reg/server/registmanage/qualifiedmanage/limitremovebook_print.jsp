<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=8">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/print.css"/>"/>
    <link rel="stylesheet" href="/css/reg.server.css">
    <style media="print" type="text/css">
        .Noprint {
            display: none;
        }
    </style>
    <style type="text/css">
        .height40 {
            height: 40px;
        }

        h1 {
		    font-family: "宋体";
		    font-size: 16pt;
		    height: 50px;
		    line-height: 50px;
		    font-weight: bold;
		    letter-spacing: 2px;
        }

        h2 {
            font-size: 14pt;
            line-height: 50px;
            height: 50px;
            font-weight: normal;
        }

        .djjg, .gxdw {
            font-size: 10pt;
            padding: 0 10pt;
        }

        p {
            text-indent: 2em;
        }

        p, span, div {
            line-height: 37px;
            font-family: "宋体";
            font-size: 14pt;
        }

        hr {
            display: block;
            -webkit-margin-before: 0.5em;
            -webkit-margin-after: 0.5em;
            -webkit-margin-start: auto;
            -webkit-margin-end: auto;
            border-style: inset;
            border-width: 1px;
        }

        .underline {
            text-decoration: underline;
            color:#0000ff;
        }
        .blue{
            color:#0000ff;
        }
        .ipt-txt2{
            background-color: #fff;
		    line-height: 16px;
		    height: 24px;
		    padding: 4px 4px;
		    border-top: none;
		    border-right: none;
		    border-left: none;
		    border-bottom: 1px solid #adadad;
        }
    </style>
</head>
<body>
<div class="button Noprint" style="width:600px;">
    <a href="javascript:Print();"><strong style="font-size:16px">直接打印</strong></a>
    <a href="javascript:PrintView();"><strong style="font-size:16px">打印预览</strong></a>
    <a href="javascript:PrintSetup();"><strong style="font-size:16px">打印设置</strong></a>
    <a id="closeBtn" href="javascript:window.top.close();"><strong style="font-size:16px">关闭窗口</strong></a>
</div>
<object height="20px" id="factory" viewastext="" classid="clsid:1663ed61-23eb-11d2-b92f-008048fdd814" codebase="/js/common/print/ScriptX.cab#version=6,2,433,14"> </object>
<object height="20px" id="WebBrowser" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>

<div style="width:650px; margin:0 auto;">
       <p class="right"> <span>${limitManageRecord.limitNO }</span></p>
       <h1 class="center" style="margin-top: 50pt;">法定代表人(高管人员)任职资格限制解除证明</h1>
       <c:if test="${qualificationLimit.limitType=='0' }"> 
       <p class="left"> <span class="underline">${qualificationLimit.clientName }</span>（身份证号：<span class="underline">${qualificationLimit.certNO }</span>） 因
	   <span class="underline">曾担任被吊销企业的法定代表人并对负有个人责任</span>，依照<span class="underline">
	       《公司法》和《企业法人法定代表人登记管理规定》的规定</span>被限制担任其它企业的法定代表人（或公司高管人员）,限制期限自<span class="underline"><fmt:formatDate value="${qualificationLimit.limitDateStart }" pattern="yyyy年MM月dd日" />-<fmt:formatDate value="${qualificationLimit.limitDateEnd }" pattern="yyyy年MM月dd日" />。</span>
	        现因原限制任职的法定事由已消除，依照规定提前解除其任职限制，解除生效日期为<span class="underline"><fmt:formatDate value="${qualificationLimit.removeDate }" pattern="yyyy年MM月dd日" /></span>
                  。如果该人员同时有其它法定事由被限制担任法定代表人（或高管人员）的，则应当依法继续限制其任职。
	   </p>
	   </c:if>
	   
	   <c:if test="${qualificationLimit.limitType=='4' }"> 
       <p class="left"> <span class="underline">${qualificationLimit.clientName }</span>（身份证号：<span class="underline">${qualificationLimit.certNO }</span>） 因
	   <span class="underline">曾担任被列入严重违法失信名单企业的法定代表人</span>，依照<span class="underline">
	       《企业信息公示暂行条例》的规定</span>被限制担任其它企业的法定代表人（或公司高管人员）,限制期限自<span class="underline"><fmt:formatDate value="${qualificationLimit.limitDateStart }" pattern="yyyy年MM月dd日" />-<fmt:formatDate value="${qualificationLimit.limitDateEnd }" pattern="yyyy年MM月dd日" />。</span>
	        现因原限制任职的法定事由已消除，依照规定提前解除其任职限制，解除生效日期为<span class="underline"><fmt:formatDate value="${qualificationLimit.removeDate }" pattern="yyyy年MM月dd日" /></span>
                  。如果该人员同时有其它法定事由被限制担任法定代表人（或高管人员）的，则应当依法继续限制其任职。
	   </p>
	   </c:if>
	   <p>特此证明。</p>
	   <c:if test="${ not empty limitManageRecord.removeLiaName || not empty limitManageRecord.removeLiaTel}">
	   <p>本局联系人：${limitManageRecord.removeLiaName }
	           电话：${limitManageRecord.removeLiaTel }
	   </p>
	   </c:if>
	   <p class="right blue">${limitManageRecord.department }</p>
	   <p class="right blue" ><fmt:formatDate value="<%=new Date()%>" pattern="yyyy年MM月dd日" /></p> 
</div>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/common/print/printsetup.js"/>"></script>
<script src="<c:url value="/js/common/print/print.js"/>"></script>
</body>
</html>