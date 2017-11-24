<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="en">
<head>
 	<meta http-equiv="X-UA-Compatible" content="IE=8" >
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/print.css"/>"/>
    <link rel="stylesheet" href="/css/reg.server.css">
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
	    <c:if test="${(pubOpanoMaly.batchEntType=='1' || pubOpanoMaly.batchEntType=='3') && pubOpanoMaly.speCause!='1'}"><!-- 企业单个新增 -->
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
				<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';">列入经营异常名录决定书</span>
				<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"><o:p></o:p></span>
			</p>
			<p id="entDocNo" class=p0 style="margin-bottom: 0pt; margin-top: 0pt; text-align: center; line-height: 28.0000pt;">
				<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';color:red;" class="docNo">
				   ${pubOpanoMaly.penDecNo}
				</span>
				<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
			</p>
			<p class=p0 style="margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
				<span style="mso-spacerun: 'yes';  font-size: 16.0000pt; font-family: '仿宋_GB2312';text-decoration:underline;color:red">${pubOpanoMaly.entName}(${pubOpanoMaly.regNO})</span>
				<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">：</span>
				<span style="mso-spacerun: 'yes'; text-decoration: underline; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
			</p>
			<p class=p0 style="text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
				<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">经查，你单位因</span>
				<span id="entReaCode" style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt;  font-size: 16.0000pt; font-family: '仿宋_GB2312';color:red;text-decoration:underline;"></span>
				<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">，违反了《企业信息公示暂行条例》和《经营异常名录管理暂行办法》</span>
				<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">的相关规定。根据<c:if test="${pubOpanoMaly.speCause != 4 }">《企业信息公示暂行条例》第十七条第一款和</c:if>《企业经营异常名录管理暂行办法》第</span>
				<span style="mso-spacerun: 'yes'; text-decoration: underline; font-size: 16.0000pt; font-family: '仿宋_GB2312';color:red">四</span>
				<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">条、第</span>
				<span id="entReaNo" style="mso-spacerun: 'yes'; text-decoration: underline; font-size: 16.0000pt; font-family: '仿宋_GB2312';color:red"></span>
				<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">条之规定，决定将你企业列入经营异常名录并予以公示。  </span>
			</p>
			<p class=p17 style="text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
				<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">如不服本决定，可在接到本决定书之日起六十日内向</span>
					<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span id="span_1" style="text-decoration:underline;color:red;">${pubOpanoMaly.deptUpName}</span>或者</span>
					<span style="mso-spacerun: 'yes'; text-decoration: underline; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span id="span_2" style="text-decoration:underline;color:red;">${pubOpanoMaly.deptSameGov}</span></span>
					<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">人民政府申请行政复议；或者六个月内向</span>
					<span style="mso-spacerun: 'yes'; text-decoration: underline; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span id="span_3" style="text-decoration:underline;color:red;">${pubOpanoMaly.deptSameCourt}</span></span>
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
				<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';color:red;" class="date">
				  <fmt:formatDate value="${pubOpanoMaly.abnTime}" type="date" pattern="yyyy年MM月dd日"/>
				</span>
				<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
			</p>
		</div> 
	    </c:if>
	    <c:if test="${(pubOpanoMaly.batchEntType=='1' || pubOpanoMaly.batchEntType=='3') && pubOpanoMaly.speCause =='1'}"><!-- 企业未年报列入 -->
	        <div id="ent" style="width:675px; margin:0 auto; page-break-before:auto; height:650px; *height:600px; _height:600px;position: relative">
		  			<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 10.5000pt; font-family: '宋体';">
						<o:p></o:p>
					</span>
					<p></p>
					<p class="p0" style="margin-bottom: 0pt; margin-top: 50pt;">
						<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 10.5000pt; font-family: '宋体';"><o:p>&nbsp;</o:p></span>
					</p>
					<p class="p0" style="margin-bottom: 0pt; margin-top: 0pt; text-align: center;">
						<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';color:red;"><span >${pubOpanoMaly.deptName}</span></span>
						<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"></span><span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"><o:p></o:p></span>
					</p>
					<p class="p0" style="margin-bottom: 0pt; margin-top: 0pt; text-align: center;">
						<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';">列入经营异常名录决定书</span>
						<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"><o:p></o:p></span>
					</p>
					<p class="p0" style="margin-bottom: 0pt; margin-top: 0pt; text-align: center; line-height: 28pt;">
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';color:red;" >
						${pubOpanoMaly.penDecNo}
						</span>
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
					</p>
					<p class="p0" style="margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
						<span style="mso-spacerun: 'yes';  font-size: 16.0000pt; font-family: '仿宋_GB2312';text-decoration:underline;color:red;" class="entName">${pubOpanoMaly.entName}(${pubOpanoMaly.regNO})</span><span></span><span></span></span><span>：</span>
						<span style="mso-spacerun: 'yes'; text-decoration: underline; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
					</p>
					<p class="p0" style="text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
						<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">经查，你企业为</span>
						<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';color:red;" >${pubOpanoMaly.year}</span>
						<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">年12月31日前成立，</span>
<!-- 						<span  style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt;  font-size: 16.0000pt; font-family: '仿宋_GB2312';">依照《企业信息公示暂行条例》第八条的规定，</span> -->
						<span  style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt;  font-size: 16.0000pt; font-family: '仿宋_GB2312';">应当于每年6月30日前通过企业信用信息公示系统向工商部门报送上一年度年度报告。但截止 <span style="color:red;" >${pubOpanoMaly.seqYear}</span>年6月30日， </span>
						<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">你企业未按规定报送公示<span style="color:red;">${pubOpanoMaly.year}</span>年度报告，违反了《企业信息公示暂行条例》和《企业经营异常名录管理暂行办法》的相关规定。根据《企业信息公示暂行条例》第十七条第一款和《企业经营异常名录管理暂行办法》第四条、第六条之规定，决定将你企业列入经营异常名录并予以公示。</span>
					</p>
					<p class="p17" style="text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">如不服本决定，可在接到本决定书之日起六十日内向</span>
							<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span style="text-decoration:underline;color:red;" >${pubOpanoMaly.deptUpName}</span>或者</span>
							<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span style="text-decoration:underline;color:red;" >${pubOpanoMaly.deptSameGov}</span></span>
							<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">人民政府申请行政复议；或者六个月内向</span>
							<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span style="text-decoration:underline;color:red;" >${pubOpanoMaly.deptSameCourt}</span></span>
							<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">人民法院提起行政诉讼。&nbsp;</span>
							<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
					</p>
					<p class="p17" style="margin-left: 10.5000pt; text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; text-align: right; line-height: 28.0000pt;">
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p>&nbsp;</o:p></span>
					</p>
					<p class="p17" style="margin-left: 10.5000pt; text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; word-break: break-all; text-align: right; line-height: 28.0000pt;">
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">&nbsp;</span><span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span style="color:red;" >${pubOpanoMaly.deptName}</span></span><span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"></span><span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">（公章）</span><span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
					</p>
					<p class="p0" style="margin-bottom: 0pt; margin-top: 0pt; text-align: right; line-height: 28pt;">
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';color:red;" >
						<fmt:formatDate value="${pubOpanoMaly.abnTime}" type="date" pattern="yyyy年MM月dd日"/>
						</span>
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
					</p>
				</div>
	    </c:if>
	    
	      <c:if test="${pubOpanoMaly.batchEntType=='2'&&pubOpanoMaly.speCause!='1'}"><!-- 农专单个新增 -->
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
						<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';">列入经营异常名录决定书</span>
						<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"><o:p></o:p></span>
					</p>
					<p id="farmDocNo" class=p0 style="margin-bottom: 0pt; margin-top: 0pt; text-align: center; line-height: 28.0000pt;">
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';color:red;" >${pubOpanoMaly.penDecNo}</span>
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
					</p>
					<p class=p0 style="margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
						<span style="mso-spacerun: 'yes';  font-size: 16.0000pt; font-family: '仿宋_GB2312';text-decoration:underline;color:red">${pubOpanoMaly.entName}(${pubOpanoMaly.regNO})</span>
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">：</span>
						<span style="mso-spacerun: 'yes'; text-decoration: underline; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
					</p>
					<p class=p0
						style="text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
						<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">经查，你单位因</span>
						<span id="farmReaCode" style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt;  font-size: 16.0000pt; font-family: '仿宋_GB2312';color:red;text-decoration:underline;"></span>
						<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">，违反了《农民专业合作社年度报告公示暂行办法》</span>
						<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">的相关规定。根据《农民专业合作社年度报告公示暂行办法》第</span>
						<span id="farmReaNo" style="mso-spacerun: 'yes'; text-decoration: underline; font-size: 16.0000pt; font-family: '仿宋_GB2312';color:red"></span>
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">条之规定，决定将你单位列入经营异常名录并予以公示。</span>
					</p>
					<p class=p17
						style="text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
						<span
							style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">如不服本决定，可在接到本决定书之日起六十日内向</span>
							<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span id="span_1_1" style="text-decoration:underline;color:red;">${pubOpanoMaly.deptUpName}</span>或者</span>
							<span style="mso-spacerun: 'yes'; text-decoration: underline; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span id="span_2_2" style="text-decoration:underline;color:red;">${pubOpanoMaly.deptSameGov}</span></span>
							<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">人民政府申请行政复议；或者六个月内向</span>
							<span style="mso-spacerun: 'yes'; text-decoration: underline; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span id="span_3_3" style="text-decoration:underline;color:red;">${pubOpanoMaly.deptSameCourt}</span></span>
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
					<p class=p0 style="margin-bottom: 0pt; margin-top: 0pt; text-align: right; line-height: 28.0000pt;" >
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';color:red;" >
						 <fmt:formatDate value="${pubOpanoMaly.abnTime}" type="date" pattern="yyyy年MM月dd日"/>
						</span>
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
					</p>
				 </div>
	      </c:if>
	      <c:if test="${pubOpanoMaly.batchEntType=='2'&&pubOpanoMaly.speCause =='1'}"><!-- 农专批量导入 -->
	          <div id="farm" style="width:675px; margin:0 auto; page-break-before:auto; height:650px; *height:600px; _height:600px;position: relative">
		  			<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 10.5000pt; font-family: '宋体';">
						<o:p></o:p>
					</span>
					<p></p>
					<p class="p0" style="margin-bottom: 0pt; margin-top: 50pt;">
						<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 10.5000pt; font-family: '宋体';"><o:p>&nbsp;</o:p></span>
					</p>
					<p class="p0" style="margin-bottom: 0pt; margin-top: 0pt; text-align: center;">
						<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';color: red;"><span ></span>${pubOpanoMaly.deptName}</span>
						<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"></span><span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"><o:p></o:p></span>
					</p>
					<p class="p0" style="margin-bottom: 0pt; margin-top: 0pt; text-align: center;">
						<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';">列入经营异常名录决定书</span>
						<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"><o:p></o:p></span>
					</p>
					<p class="p0" style="margin-bottom: 0pt; margin-top: 0pt; text-align: center; line-height: 28pt;">
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';color: red;" class="docNo">  ${pubOpanoMaly.penDecNo}</span>
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
					</p>
					<p class="p0" style="margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
						<span style="mso-spacerun: 'yes';  font-size: 16.0000pt; font-family: '仿宋_GB2312';text-decoration:underline;color: red;" class="entName"><span  >${pubOpanoMaly.entName}(${pubOpanoMaly.regNO})</span><span></span><span></span></span><span>：</span>
						<span style="mso-spacerun: 'yes'; text-decoration: underline; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
					</p>
					<p class="p0" style="text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
						<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">经查，你单位为
						<span style="color: red;">${pubOpanoMaly.year}</span>年12月31日前成立，</span>
						<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt;  font-size: 16.0000pt; font-family: '仿宋_GB2312';">应当在每年6月30日前通过企业信用信息公示系统向工商部门报送上一年度年度报告。但截止
						<span id="ftcstopyear" style="color: red;">${pubOpanoMaly.seqYear}</span>年6月30日，你单位未按规定报送公示
						<span class="farmYear" style="color: red;">${pubOpanoMaly.year}</span>年度报告，违反了《农民专业合作社年度报告公示暂行办法》的相关规定。根据《农民专业合作社年度报告公示暂行办法》第十条之规定，决定将你单位列入经营异常名录并予以公示。 
						</span>
					</p>
					<p class="p17" style="text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">如不服本决定，可在本决定书公示之日起六十日内向</span>
							<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span style="text-decoration:underline;color: red;">${pubOpanoMaly.deptUpName}</span>或者</span>
							<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span style="text-decoration:underline;color: red;">${pubOpanoMaly.deptSameGov}</span></span>
							<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">人民政府申请行政复议；或者六个月内向</span>
							<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span style="text-decoration:underline;color: red;">${pubOpanoMaly.deptSameCourt}</span></span>
							<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">人民法院提起行政诉讼。&nbsp;</span>
							<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
					</p>
					<p class="p17" style="margin-left: 10.5000pt; text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; text-align: right; line-height: 28.0000pt;">
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p>&nbsp;</o:p></span>
					</p>
					<p class="p17" style="margin-left: 10.5000pt; text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; word-break: break-all; text-align: right; line-height: 28.0000pt;">
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">&nbsp;</span><span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span style="color: red;">${ pubOpanoMaly.deptName}</span></span><span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"></span><span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">（公章）</span><span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
					</p>
					<p class="p0" style="margin-bottom: 0pt; margin-top: 0pt; text-align: right; line-height: 28pt;">
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';color: red;" >
						<fmt:formatDate value="${pubOpanoMaly.abnTime}" type="date" pattern="yyyy年MM月dd日"/>
						</span>
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
					</p>
				</div>
	      </c:if>
	</div> 
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/server/opanomaly/pubopanomaly/pubopanomalyent/pubopanomalyentdecision_book_main.js"/>"></script>
<script src="<c:url value="/js/common/print/printsetup.js"/>"></script>
<script src="<c:url value="/js/common/print/print.js"/>"></script>

<script>
    window._CONFIG = {
       _speCause:'${pubOpanoMaly.speCause}', //列入原因编码 
       _deptName:'${pubOpanoMaly.deptName}' ,//部门名称
       
       _batchEntType:'${pubOpanoMaly.batchEntType}'
    } 
</script>
</body>
</html>