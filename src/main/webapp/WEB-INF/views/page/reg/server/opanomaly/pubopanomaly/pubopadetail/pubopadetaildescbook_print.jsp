<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:useBean id="nowdate" class="java.util.Date" />
<!doctype html>
<html lang="en">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="renderer" content="webkit">
	<meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/print.css"/>"/>
    <style media="print" type="text/css"> 
		.Noprint{ display:none; } 
	</style> 
	<style type="text/css">
		.height40{
			height: 40px;
		}
	</style>
</head>
<title>打印决定书</title> 
<body>
<div class="button Noprint" style="width:600px;">
    <a href="javascript:Print();"><strong style="font-size:16px">直接打印</strong></a>
    <a href="javascript:PrintView();"><strong style="font-size:16px">打印预览</strong></a>
    <a href="javascript:PrintSetup();"><strong style="font-size:16px">打印设置</strong></a>
    <a id="closeBtn" href="javascript:window.top.close();"><strong style="font-size:16px">关闭窗口</strong></a>
</div>
<object height="20px" id="factory" viewastext="" classid="clsid:1663ed61-23eb-11d2-b92f-008048fdd814" codebase="/js/common/print/ScriptX.cab#version=6,2,433,14"> </object>
<object height="20px" id="WebBrowser" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>

	<div class="main">
	   <!-- 企业移出异常决定书 -->
	     <c:if test="${pubOpaDetail.entTypeCatg != '16' && pubOpaDetail.entTypeCatg !='17' && pubOpaDetail.isMove == '1' }">
		   <div id="ent" style="width:675px; margin:0 auto; page-break-before:auto; height:650px; *height:600px; _height:600px;position: relative">
			<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 10.5000pt; font-family: '宋体';">
				<o:p></o:p>
			</span>
			</p>
			<p class=p0 style="margin-bottom: 0pt; margin-top: 50pt;">
				<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 10.5000pt; font-family: '宋体';"><o:p>&nbsp;</o:p></span>
			</p>
			<p class=p0 style="margin-bottom: 0pt; margin-top: 0pt; text-align: center;">
				<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"><span style="color:red" class="dept"></span></span>
				<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"></span><span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"><o:p></o:p></span>
			</p>
			<p class=p0 style="margin-bottom: 0pt; margin-top: 0pt; text-align: center;">
				<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';">移出经营异常名录决定书</span>
				<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"><o:p></o:p></span>
			</p>
			<p id="entDocNo" class=p0 style="margin-bottom: 0pt; margin-top: 0pt; text-align: center; line-height: 28.0000pt;">
				<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';color:red;" class="docNo"></span>
				<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
			</p>
			<p class=p0 style="margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
				<span style="mso-spacerun: 'yes';  font-size: 16.0000pt; font-family: '仿宋_GB2312';text-decoration:underline;color:red">${pubOpaDetail.entName}(${pubOpaDetail.regNO})</span>
				<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">：</span>
				<span style="mso-spacerun: 'yes'; text-decoration: underline; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
			</p>
			<p class=p0 style="text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
				<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">经查，你单位</span>
				<span id="entReaCode" style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt;  font-size: 16.0000pt; font-family: '仿宋_GB2312';color:red;text-decoration:underline;"></span>
				<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">。根据<c:if test="${pubOpaDetail.remExcpres !='4' && pubOpaDetail.remExcpres !='5'}">《企业信息公示暂行条例》第十七条第二款和</c:if>《经营异常名录管理暂行办法》第</span>
				<span id="entReaNo" style="mso-spacerun: 'yes'; text-decoration: underline; font-size: 16.0000pt; font-family: '仿宋_GB2312';color:red"></span>
				<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">条的规定，决定将你单位移出经营异常名录。</span>
			</p>
			<p class=p17 style="text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
				<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">你单位如不服本决定，可在接到本决定书之日起六十日内向</span>
					<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span id="span_1" style="text-decoration:underline;color:red;">${pubOpaDetail.deptUpName}</span>或者</span>
					<span style="mso-spacerun: 'yes'; text-decoration: underline; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span id="span_2" style="text-decoration:underline;color:red;">${pubOpaDetail.deptSameGov}</span></span>
					<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">人民政府申请行政复议；或者六个月内向</span>
					<span style="mso-spacerun: 'yes'; text-decoration: underline; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span id="span_3" style="text-decoration:underline;color:red;">${pubOpaDetail.deptSameCourt}</span></span>
					<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">人民法院提起行政诉讼。&nbsp;</span>
					<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
			</p>
			<p class=p17
				style="margin-left: 10.5000pt; text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; text-align: right; line-height: 28.0000pt;">
				<span
					style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p>&nbsp;</o:p></span>
			</p>
			<p class=p17
				style="margin-left: 10.5000pt; text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; word-break: break-all; text-align: right; line-height: 28.0000pt;">
				<span
					style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">&nbsp;</span><span
					style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span style="color:red;" class="dept"></span></span><span
					style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"></span><span
					style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">（公章）</span><span
					style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
			</p>
			<p class=p0 style="margin-bottom: 0pt; margin-top: 0pt; text-align: right; line-height: 28.0000pt;" id="entDate">
				<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';color:red;" class="date"></span>
				<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
			</p>
		  </div>
		</c:if>
		
		
	    <!-- 企业移出异常决定书 (更正撤销)-->
	     <c:if test="${pubOpaDetail.entTypeCatg != '16' && pubOpaDetail.entTypeCatg !='17' && pubOpaDetail.isMove == '2'}">
		   <div id="ent" style="width:675px; margin:0 auto; page-break-before:auto; height:650px; *height:600px; _height:600px;position: relative">
			<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 10.5000pt; font-family: '宋体';">
				<o:p></o:p>
			</span>
			</p>
			<p class=p0 style="margin-bottom: 0pt; margin-top: 50pt;">
				<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 10.5000pt; font-family: '宋体';"><o:p>&nbsp;</o:p></span>
			</p>
			<p class=p0 style="margin-bottom: 0pt; margin-top: 0pt; text-align: center;">
				<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"><span style="color:red" class="dept"></span></span>
				<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"></span><span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"><o:p></o:p></span>
			</p>
			<p class=p0 style="margin-bottom: 0pt; margin-top: 0pt; text-align: center;">
				<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';">移出经营异常名录决定书</span>
				<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"><o:p></o:p></span>
			</p>
			<p id="entDocNo" class=p0 style="margin-bottom: 0pt; margin-top: 0pt; text-align: center; line-height: 28.0000pt;">
				<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';color:red;" class="docNo"></span>
				<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
			</p>
			<p class=p0 style="margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
				<span style="mso-spacerun: 'yes';  font-size: 16.0000pt; font-family: '仿宋_GB2312';text-decoration:underline;color:red">${pubOpaDetail.entName}(${pubOpaDetail.regNO})</span>
				<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">：</span>
				<span style="mso-spacerun: 'yes'; text-decoration: underline; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
			</p>
			<p class=p0 style="text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
				<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">经查，你企业于<span class="abnTime" style="color:red"><fmt:formatDate value="${pubOpaDetail.abnTime}" pattern="yyyy年MM月dd日" /></span>因</span>
				<span id="enspeCauseCN" style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt;  font-size: 16.0000pt; font-family: '仿宋_GB2312';color:red;text-decoration:underline;">${pubOpaDetail.speCauseCN}</span>
				<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">被列入经营异常名录的情形有误。根据《企业经营异常名录管理暂行办法》第</span>
				<span id="enspeNo" style="mso-spacerun: 'yes'; text-decoration: underline; font-size: 16.0000pt; font-family: '仿宋_GB2312';color:red">十六</span>
				<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">条之规定，应予更正。决定撤销
				<span class="abnTime" style="color:red"><fmt:formatDate value="${pubOpaDetail.abnTime}" pattern="yyyy年MM月dd日" /></span>
				由<span class="decorgCN" style="color: red">${pubOpaDetail.decorgCN}</span>作出的《列入经营异常名录决定书》（<span class="rePenDecNo" style="color: red">${pubOpanoMaly.penDecNo}</span>）。  </span>
			</p>
<!-- 			<p class=p17 style="text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;"> -->
<!-- 				<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">你单位如不服本决定，可在接到本决定书之日起六十日内向</span> -->
<%-- 					<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span id="span_1" style="text-decoration:underline;color:red;">${departMent.deptUpName}</span>或者</span> --%>
<%-- 					<span style="mso-spacerun: 'yes'; text-decoration: underline; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span id="span_2" style="text-decoration:underline;color:red;">${departMent.sameGov}</span></span> --%>
<!-- 					<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">人民政府申请行政复议；或者六个月内向</span> -->
<%-- 					<span style="mso-spacerun: 'yes'; text-decoration: underline; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span id="span_3" style="text-decoration:underline;color:red;">${departMent.sameCourt}</span></span> --%>
<!-- 					<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">人民法院提起行政诉讼。&nbsp;</span> -->
<!-- 					<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span> -->
<!-- 			</p> -->
			<p class=p17
				style="margin-left: 10.5000pt; text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; text-align: right; line-height: 28.0000pt;">
				<span
					style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p>&nbsp;</o:p></span>
			</p>
			<p class=p17
				style="margin-left: 10.5000pt; text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; word-break: break-all; text-align: right; line-height: 28.0000pt;">
				<span
					style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">&nbsp;</span><span
					style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span style="color:red;" class="dept"></span></span><span
					style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"></span><span
					style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">（公章）</span><span
					style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
			</p>
			<p class=p0 style="margin-bottom: 0pt; margin-top: 0pt; text-align: right; line-height: 28.0000pt;" id="entDate">
				<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';color:red;" class="date"></span>
				<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
			</p>
		  </div>
		</c:if>		
		
	   
		<!-- 农专移出异常决定书 -->
		<c:if test="${(pubOpaDetail.entTypeCatg == '16' || pubOpaDetail.entTypeCatg =='17') && pubOpaDetail.isMove == '1' }">
		   <div id="farm" style="width:675px; margin:0 auto; page-break-before:auto; height:650px; *height:600px; _height:600px;position: relative">
				<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 10.5000pt; font-family: '宋体';">
					<o:p></o:p>
				</span>
				</p>
				<p class=p0 style="margin-bottom: 0pt; margin-top: 50pt;">
					<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 10.5000pt; font-family: '宋体';"><o:p>&nbsp;</o:p></span>
				</p>
				<p class=p0 style="margin-bottom: 0pt; margin-top: 0pt; text-align: center;">
					<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"><span style="color:red" class="dept"></span></span>
					<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"></span><span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"><o:p></o:p></span>
				</p>
				<p class=p0 style="margin-bottom: 0pt; margin-top: 0pt; text-align: center;">
					<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';">移出经营异常名录决定书</span>
					<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"><o:p></o:p></span>
				</p>
				<p id="farmDocNo" class=p0 style="margin-bottom: 0pt; margin-top: 0pt; text-align: center; line-height: 28.0000pt;">
					<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';color:red;" class="docNo"></span>
					<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
				</p>
				<p class=p0 style="margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
					<span style="mso-spacerun: 'yes';  font-size: 16.0000pt; font-family: '仿宋_GB2312';text-decoration:underline;color:red">${pubOpaDetail.entName}(${pubOpaDetail.regNO})</span>
					<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">：</span>
					<span style="mso-spacerun: 'yes'; text-decoration: underline; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
				</p>
				<p class=p0
					style="text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
                    <span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">经查，你单位因</span>
					<span id="farmReaCode" style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt;  font-size: 16.0000pt; font-family: '仿宋_GB2312';color:red;text-decoration:underline;"></span>
					<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">根据《农民专业合作社年度报告公示暂行办法》第</span>
					<span id="farmReaNo" style="mso-spacerun: 'yes'; text-decoration: underline; font-size: 16.0000pt; font-family: '仿宋_GB2312';color:red"></span>
					<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">条的规定，现决定将你单位移出经营异常名录。</span>
				</p>
				<p class=p17
					style="text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
					<span
						style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">你单位如不服本决定，可在接到本决定书之日起六十日内向</span>
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span id="span_1_1" style="text-decoration:underline;color:red;">${pubOpaDetail.deptUpName}</span>或者</span>
						<span style="mso-spacerun: 'yes'; text-decoration: underline; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span id="span_2_2" style="text-decoration:underline;color:red;">${pubOpaDetail.deptSameGov}</span></span>
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">人民政府申请行政复议；或者六个月内向</span>
						<span style="mso-spacerun: 'yes'; text-decoration: underline; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span id="span_3_3" style="text-decoration:underline;color:red;">${pubOpaDetail.deptSameCourt}</span></span>
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">人民法院提起行政诉讼。&nbsp;</span>
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
				</p>
				<p class=p17 style="margin-left: 10.5000pt; text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; text-align: right; line-height: 28.0000pt;">
					<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p>&nbsp;</o:p></span>
				</p>
				<p class=p17 style="margin-left: 10.5000pt; text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; word-break: break-all; text-align: right; line-height: 28.0000pt;">
					<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">&nbsp;</span>
					<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">
					<span style="color:red;" class="dept"></span></span>
					<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"></span>
					<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">（公章）</span>
					<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
				</p>
				<p class=p0 style="margin-bottom: 0pt; margin-top: 0pt; text-align: right; line-height: 28.0000pt;" id="farmDate">
					<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';color:red;" class="date"></span>
					<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
				</p>
			</div>
		</c:if>
		
		 	    <!-- 农专社移出异常决定书 (更正撤销)-->
	     <c:if test="${(pubOpaDetail.entTypeCatg == '16' || pubOpaDetail.entTypeCatg =='17') && pubOpaDetail.isMove == '2'}">
		   <div id="ent" style="width:675px; margin:0 auto; page-break-before:auto; height:650px; *height:600px; _height:600px;position: relative">
			<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 10.5000pt; font-family: '宋体';">
				<o:p></o:p>
			</span>
			</p>
			<p class=p0 style="margin-bottom: 0pt; margin-top: 50pt;">
				<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 10.5000pt; font-family: '宋体';"><o:p>&nbsp;</o:p></span>
			</p>
			<p class=p0 style="margin-bottom: 0pt; margin-top: 0pt; text-align: center;">
				<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"><span style="color:red" class="dept"></span></span>
				<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"></span><span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"><o:p></o:p></span>
			</p>
			<p class=p0 style="margin-bottom: 0pt; margin-top: 0pt; text-align: center;">
				<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';">移出经营异常名录决定书</span>
				<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"><o:p></o:p></span>
			</p>
			<p id="entDocNo" class=p0 style="margin-bottom: 0pt; margin-top: 0pt; text-align: center; line-height: 28.0000pt;">
				<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';color:red;" class="docNo"></span>
				<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
			</p>
			<p class=p0 style="margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
				<span style="mso-spacerun: 'yes';  font-size: 16.0000pt; font-family: '仿宋_GB2312';text-decoration:underline;color:red">${pubOpaDetail.entName}(${pubOpaDetail.regNO})</span>
				<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">：</span>
				<span style="mso-spacerun: 'yes'; text-decoration: underline; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
			</p>
			<p class=p0 style="text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
				<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">经查，你单位于<span class="abnTime" style="color:red"><fmt:formatDate value="${pubOpaDetail.abnTime}" pattern="yyyy年MM月dd日" /></span>因</span>
				<span id="enspeCauseCN" style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt;  font-size: 16.0000pt; font-family: '仿宋_GB2312';color:red;text-decoration:underline;">${pubOpaDetail.speCauseCN}</span>
				<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">被列入经营异常名录的情形有误。根据《农民专业合作社年度报告公示暂行办法》第</span>
				<span id="enspeNo" style="mso-spacerun: 'yes'; text-decoration: underline; font-size: 16.0000pt; font-family: '仿宋_GB2312';color:red">十六</span>
				<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">条之规定，应予更正。决定撤销
				<span class="abnTime" style="color:red"><fmt:formatDate value="${pubOpaDetail.abnTime}" pattern="yyyy年MM月dd日" /></span>
				由<span class="decorgCN" style="color: red">${pubOpaDetail.decorgCN}</span>作出的《列入经营异常名录决定书》（<span class="rePenDecNo" style="color: red">${pubOpanoMaly.penDecNo}</span>）。  </span>
			</p>
<!-- 			<p class=p17 style="text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;"> -->
<!-- 				<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">你单位如不服本决定，可在接到本决定书之日起六十日内向</span> -->
<%-- 					<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span id="span_1" style="text-decoration:underline;color:red;">${departMent.deptUpName}</span>或者</span> --%>
<%-- 					<span style="mso-spacerun: 'yes'; text-decoration: underline; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span id="span_2" style="text-decoration:underline;color:red;">${departMent.sameGov}</span></span> --%>
<!-- 					<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">人民政府申请行政复议；或者六个月内向</span> -->
<%-- 					<span style="mso-spacerun: 'yes'; text-decoration: underline; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span id="span_3" style="text-decoration:underline;color:red;">${departMent.sameCourt}</span></span> --%>
<!-- 					<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">人民法院提起行政诉讼。&nbsp;</span> -->
<!-- 					<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span> -->
<!-- 			</p> -->
			<p class=p17
				style="margin-left: 10.5000pt; text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; text-align: right; line-height: 28.0000pt;">
				<span
					style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p>&nbsp;</o:p></span>
			</p>
			<p class=p17
				style="margin-left: 10.5000pt; text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; word-break: break-all; text-align: right; line-height: 28.0000pt;">
				<span
					style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">&nbsp;</span><span
					style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span style="color:red;" class="dept"></span></span><span
					style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"></span><span
					style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">（公章）</span><span
					style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
			</p>
			<p class=p0 style="margin-bottom: 0pt; margin-top: 0pt; text-align: right; line-height: 28.0000pt;" id="entDate">
				<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';color:red;" class="date"></span>
				<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
			</p>
		  </div>
		</c:if>
	</div> 
</body>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="<c:url value="/js/reg/server/opanomaly/pubopanomaly/pubopadetail/pubopadetaildescbook_edit.js"/>"></script> </body>
<script src="<c:url value="/js/common/print/printsetup.js"/>"></script>
<script src="<c:url value="/js/common/print/print.js"/>"></script>

<script>
    window._CONFIG = {
       _speCause:'${pubOpaDetail.speCause}', //列入原因编码 
       _deptName:'${pubOpaDetail.deptName}', //部门名称
       _entTypeCatg:'${pubOpaDetail.entTypeCatg}', //企业大类
       _remExcpres:'${pubOpaDetail.remExcpres}', //申请移出原因
       docNo:'${pubOpaDetail.penDecNo}', //文号
       abnYear:'${pubOpanoMaly.year}', //年报年份
       remDate:'<fmt:formatDate value="${pubOpaDetail.remDate}" pattern="yyyy年MM月dd日" />'
    } 
</script>
</html>