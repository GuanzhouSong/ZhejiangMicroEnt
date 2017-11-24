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
		<form id="decisionbookform">
	      <input type="hidden" id="deptUpName" name="deptUpName" value="${departMent.deptUpName}"/> 
	      <input type="hidden" id="deptName" name="deptName" value="${departMent.deptName}"/> 
	      <input type="hidden" id="deptSameGov" name="deptSameGov"  value="${departMent.sameGov}"/> 
	      <input type="hidden" id="deptSameCourt" name="deptSameCourt"  value="${departMent.sameCourt}"/>
	      <input type="hidden" id="busExcList" name="busExcList"  value="${pubOpanoMaly.busExcList}"/> 
 	    </form>
		<div style="width:675px; margin:0 auto; page-break-before:auto; height:600px; *height:600px; _height:600px;position: relative">
			<!-- 企业决定书 -->
			<c:if test="${(pubOpanoMaly.batchEntType==1 || pubOpanoMaly.batchEntType==3) && pubOpanoMaly.impFlag==0}"> 
		    	<div id="ent" style="width:675px; margin:0 auto; page-break-before:auto; *height:600px; _height:600px;position: relative">
		  			<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 10.5000pt; font-family: '宋体';">
						<o:p></o:p>
					</span>
					<p></p>
					<p class="p0" style="margin-bottom: 0pt; margin-top: 50pt;">
						<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 10.5000pt; font-family: '宋体';"><o:p>&nbsp;</o:p></span>
					</p>
					<p class="p0" style="margin-bottom: 0pt; margin-top: 0pt; text-align: center;">
						<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"><span id="entDeptName">${pubOpanoMaly.deptName}</span></span>
						<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"></span><span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"><o:p></o:p></span>
					</p>
					<p class="p0" style="margin-bottom: 0pt; margin-top: 0pt; text-align: center;">
						<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';">列入经营异常名录决定书</span>
						<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"><o:p></o:p></span>
					</p>
					<p class="p0" style="margin-bottom: 0pt; margin-top: 0pt; text-align: center; line-height: 28pt;">
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';" class="docNo" style="color: red;">${penDecNo}</span>
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
					</p>
					<p class="p0" style="margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
						<span style="mso-spacerun: 'yes';  font-size: 16.0000pt; font-family: '仿宋_GB2312';text-decoration:underline; color: red;" class="entName"><span  id="entName">${pubOpanoMaly.entName}(${pubOpanoMaly.regNO})</span><span>等共${initBatchNum}家</span><span>企业</span></span><span>：</span>
						<span style="mso-spacerun: 'yes'; text-decoration: underline; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
					</p>
					<p class="p0" style="text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
						<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">经查，上述企业为</span>
						<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';color: red;" class="entYear">${pubOpanoMaly.year}</span>
						<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">年12月31日前成立，</span>
						<span id="entReaCode" style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt;  font-size: 16.0000pt; font-family: '仿宋_GB2312';">应当在每年6月30日前通过企业信用信息公示系统向工商部门报送上一年度的企业年度报告。但截止 <span id="appentstopyear" style="color: red;">${pubOpanoMaly.seqYear}</span>年6月30日，  </span>
						<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">上述企业未按规定报送公示<span class="entYear" style="color: red;">${pubOpanoMaly.year}</span>年度报告，违反了《企业信息公示暂行条例》和《企业经营异常名录管理暂行办法》的相关规定。根据《企业信息公示暂行条例》第十七条第一款和《企业经营异常名录管理暂行办法》第四条、第六条之规定，决定将上述企业列入经营异常名录并予以公示。</span>
					</p>
					<p class="p17" style="text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">上述企业如不服本决定，可在接到本决定书之日起六十日内向</span>
							<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span id="span_1" style="text-decoration:underline; color: red;">${pubOpanoMaly.deptUpName}</span>或者</span>
							<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span id="span_2" style="text-decoration:underline; color: red;">${pubOpanoMaly.deptSameGov}</span></span>
							<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">人民政府申请行政复议；或者六个月内向</span>
							<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span id="span_3" style="text-decoration:underline; color: red;">${pubOpanoMaly.deptSameCourt}</span></span>
							<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">人民法院提起行政诉讼。&nbsp;</span>
							<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
					</p>
					<p class="p17" style="margin-left: 10.5000pt; text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; text-align: right; line-height: 28.0000pt;">
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p>&nbsp;</o:p></span>
					</p>
					<p class="p17" style="margin-left: 10.5000pt; text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; word-break: break-all; text-align: right; line-height: 28.0000pt;">
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">&nbsp;</span><span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';color: red;"><span id="entGz">${pubOpanoMaly.deptName}</span></span><span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"></span><span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';color: red;">（公章）</span><span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
					</p>
					<p class="p0" style="margin-bottom: 0pt; margin-top: 0pt; text-align: right; line-height: 28pt;">
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';color: red;" class="date"><fmt:formatDate value="${pubOpanoMaly.abnTime}" type="date" pattern="yyyy年MM月dd日"/>
						</span>
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
					</p>
				</div>
				</c:if>
				
				<!-- 农专社决定书 -->
			<c:if test="${pubOpanoMaly.batchEntType==2 && pubOpanoMaly.impFlag==0}"> 
		    	<div id="farm" style="width:675px; margin:0 auto; page-break-before:auto;*height:600px; _height:600px;position: relative">
		  			<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 10.5000pt; font-family: '宋体';">
						<o:p></o:p>
					</span>
					<p></p>
					<p class="p0" style="margin-bottom: 0pt; margin-top: 50pt;">
						<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 10.5000pt; font-family: '宋体';"><o:p>&nbsp;</o:p></span>
					</p>
					<p class="p0" style="margin-bottom: 0pt; margin-top: 0pt; text-align: center;">
						<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"><span id="farmDeptName">${pubOpanoMaly.deptName}</span></span>
						<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"></span><span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"><o:p></o:p></span>
					</p>
					<p class="p0" style="margin-bottom: 0pt; margin-top: 0pt; text-align: center;">
						<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';">列入经营异常名录决定书</span>
						<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"><o:p></o:p></span>
					</p>
					<p class="p0" style="margin-bottom: 0pt; margin-top: 0pt; text-align: center; line-height: 28pt;">
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';color: red;" class="docNo">${penDecNo}</span>
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
					</p>
					<p class="p0" style="margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
						<span style="mso-spacerun: 'yes';  font-size: 16.0000pt; font-family: '仿宋_GB2312';text-decoration:underline;color: red;" class="entName"><span  id="farmName">${pubOpanoMaly.entName}(${pubOpanoMaly.regNO})</span><span>等共${initBatchNum}家</span><span>农专社</span></span><span>：</span>
						<span style="mso-spacerun: 'yes'; text-decoration: underline; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
					</p>
					<p class="p0" style="text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
						<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">经查，上述农专社为<span class="farmYear" style="color: red;">${pubOpanoMaly.year}</span>年12月31日前成立，应当在每年6月30日前通过企业信用信息公示系统向工商部门报送</span>
						<span id="entReaCode" style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt;  font-size: 16.0000pt; font-family: '仿宋_GB2312';">上一年度年度的年度报告。但截止<span id="ftcstopyear" style="color: red;">${pubOpanoMaly.seqYear}</span>年6月30日，上述农专社未按规定报送公示<span class="farmYear" style="color: red;">${pubOpanoMaly.year}</span>年度报告，违反了《农民专业合作社年度报告公示暂行办法》的相关规定。根据《农民专业合作社年度报告公示暂行办法》第十条之规定，决定将上述农专社列入经营异常名录并予以公示。</span>
					</p>
					<p class="p17" style="text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">上述农专社如不服本决定，可在本决定书公示之日起六十日内向</span>
							<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span id="span_1_1" style="text-decoration:underline;color: red;">${pubOpanoMaly.deptUpName}</span>或者</span>
							<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span id="span_2_2" style="text-decoration:underline;color: red;">${pubOpanoMaly.deptSameGov}</span></span>
							<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">人民政府申请行政复议；或者六个月内向</span>
							<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><span id="span_3_3" style="text-decoration:underline;color: red;">${pubOpanoMaly.deptSameCourt}</span></span>
							<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">人民法院提起行政诉讼。&nbsp;</span>
							<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
					</p>
					<p class="p17" style="margin-left: 10.5000pt; text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; text-align: right; line-height: 28.0000pt;">
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p>&nbsp;</o:p></span>
					</p>
					<p class="p17" style="margin-left: 10.5000pt; text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; word-break: break-all; text-align: right; line-height: 28.0000pt;">
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">&nbsp;</span><span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';color: red;"><span id="farmGz">${pubOpanoMaly.deptName}</span></span><span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';color: red;"></span><span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">（公章）</span><span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
					</p>
					<p class="p0" style="margin-bottom: 0pt; margin-top: 0pt; text-align: right; line-height: 28pt;">
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';color: red;" class="date"><fmt:formatDate value="${pubOpanoMaly.abnTime}" type="date" pattern="yyyy年MM月dd日"/></span>
						<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
					</p>
				</div>
			</c:if>
			
			<!-- 下面企业名单部分 -->
			<p class=p0 style="margin-bottom: 0pt; margin-top: 0pt; layout-grid-mode: char; text-align:left ;">
				<span style="mso-spacerun: 'yes'; font-size: 12.0000pt; font-family: '宋体';">附：企业名单</span>
			</p>
			<table align=center style="border-collapse: collapse; width: 500.4000pt; margin-left: 4.0000pt; mso-table-layout-alt: fixed; padding: 0.0000pt 1.4000pt 0.0000pt 1.4000pt;">
				<tr style="height: 19.8500pt;">
					<td width="10%" valign=center style="text-align:center;padding: 2px; border-left: 0.7500pt solid rgb(0, 0, 0); mso-border-left-alt: 0.7500pt solid rgb(0, 0, 0); border-right: 0.7500pt solid rgb(0, 0, 0); mso-border-right-alt: 0.7500pt solid rgb(0, 0, 0); border-top: 0.7500pt solid rgb(0, 0, 0); mso-border-top-alt: 0.7500pt solid rgb(0, 0, 0); border-bottom: 0.7500pt solid rgb(0, 0, 0); mso-border-bottom-alt: 0.7500pt solid rgb(0, 0, 0);">
							<span style="mso-spacerun: 'yes'; font-size: 10.0000pt; font-family: '宋体';">序号</span>
					</td>
					<td width="30%" valign=center style="text-align:center;padding: 2px; border-left: 0.7500pt solid rgb(0, 0, 0); mso-border-left-alt: 0.7500pt solid rgb(0, 0, 0); border-right: 0.7500pt solid rgb(0, 0, 0); mso-border-right-alt: 0.7500pt solid rgb(0, 0, 0); border-top: 0.7500pt solid rgb(0, 0, 0); mso-border-top-alt: 0.7500pt solid rgb(0, 0, 0); border-bottom: 0.7500pt solid rgb(0, 0, 0); mso-border-bottom-alt: 0.7500pt solid rgb(0, 0, 0);">
							<span style="mso-spacerun: 'yes'; font-size: 10.0000pt; font-family: '宋体';">列入决定书文号</span>
					</td>
					<td width="30%" valign=center style="text-align:center;padding: 2px; border-left: 0.7500pt solid rgb(0, 0, 0); mso-border-left-alt: 0.7500pt solid rgb(0, 0, 0); border-right: 0.7500pt solid rgb(0, 0, 0); mso-border-right-alt: 0.7500pt solid rgb(0, 0, 0); border-top: 0.7500pt solid rgb(0, 0, 0); mso-border-top-alt: 0.7500pt solid rgb(0, 0, 0); border-bottom: 0.7500pt solid rgb(0, 0, 0); mso-border-bottom-alt: 0.7500pt solid rgb(0, 0, 0);">
							<span style="mso-spacerun: 'yes'; font-size: 10.0000pt; font-family: '宋体';">统一社会信用代码/注册号</span>
					</td>
					<td width="30%" valign=center style="text-align:center;padding: 2px; border-left: 0.7500pt solid rgb(0, 0, 0); mso-border-left-alt: 0.7500pt solid rgb(0, 0, 0); border-right: 0.7500pt solid rgb(0, 0, 0); mso-border-right-alt: 0.7500pt solid rgb(0, 0, 0); border-top: 0.7500pt solid rgb(0, 0, 0); mso-border-top-alt: 0.7500pt solid rgb(0, 0, 0); border-bottom: 0.7500pt solid rgb(0, 0, 0); mso-border-bottom-alt: 0.7500pt solid rgb(0, 0, 0);">
							<span style="mso-spacerun: 'yes'; font-size: 10.0000pt; font-family: '宋体';">企业名称</span>
					</td>
				</tr>
				<c:forEach var="pubOpanoMalyDto" items="${pubOpanoMalys}" varStatus="status">
					<tr style="height: 19.8500pt;">
					<td valign=center style="text-align:center;padding: 2px; border-left: 0.7500pt solid rgb(0, 0, 0); mso-border-left-alt: 0.7500pt solid rgb(0, 0, 0); border-right: 0.7500pt solid rgb(0, 0, 0); mso-border-right-alt: 0.7500pt solid rgb(0, 0, 0); border-top: 0.7500pt solid rgb(0, 0, 0); mso-border-top-alt: 0.7500pt solid rgb(0, 0, 0); border-bottom: 0.7500pt solid rgb(0, 0, 0); mso-border-bottom-alt: 0.7500pt solid rgb(0, 0, 0);">
							<span style="mso-spacerun: 'yes'; font-size: 11.0000pt; font-family: '宋体';">${status.count}</span>
					</td>
					<td valign=center style="text-align:center;padding: 2px; border-left: 0.7500pt solid rgb(0, 0, 0); mso-border-left-alt: 0.7500pt solid rgb(0, 0, 0); border-right: 0.7500pt solid rgb(0, 0, 0); mso-border-right-alt: 0.7500pt solid rgb(0, 0, 0); border-top: 0.7500pt solid rgb(0, 0, 0); mso-border-top-alt: 0.7500pt solid rgb(0, 0, 0); border-bottom: 0.7500pt solid rgb(0, 0, 0); mso-border-bottom-alt: 0.7500pt solid rgb(0, 0, 0);">
							<span style="mso-spacerun: 'yes'; font-size: 11.0000pt; font-family: '宋体';">${pubOpanoMalyDto.penDecNo}</span>
					</td>
					<td valign=center style="text-align:center;padding: 2px; border-left: 0.7500pt solid rgb(0, 0, 0); mso-border-left-alt: 0.7500pt solid rgb(0, 0, 0); border-right: 0.7500pt solid rgb(0, 0, 0); mso-border-right-alt: 0.7500pt solid rgb(0, 0, 0); border-top: 0.7500pt solid rgb(0, 0, 0); mso-border-top-alt: 0.7500pt solid rgb(0, 0, 0); border-bottom: 0.7500pt solid rgb(0, 0, 0); mso-border-bottom-alt: 0.7500pt solid rgb(0, 0, 0);">
							<span style="mso-spacerun: 'yes'; font-size: 11.0000pt; font-family: '宋体';">${empty pubOpanoMalyDto.uniSCID ? pubOpanoMalyDto.regNO : pubOpanoMalyDto.uniSCID }</span>
					</td>
					<td valign=center style="text-align:left;padding: 2px; border-left: 0.7500pt solid rgb(0, 0, 0); mso-border-left-alt: 0.7500pt solid rgb(0, 0, 0); border-right: 0.7500pt solid rgb(0, 0, 0); mso-border-right-alt: 0.7500pt solid rgb(0, 0, 0); border-top: 0.7500pt solid rgb(0, 0, 0); mso-border-top-alt: 0.7500pt solid rgb(0, 0, 0); border-bottom: 0.7500pt solid rgb(0, 0, 0); mso-border-bottom-alt: 0.7500pt solid rgb(0, 0, 0);">
							<span style="mso-spacerun: 'yes'; font-size: 11.0000pt; font-family: '宋体';">${pubOpanoMalyDto.entName}</span>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<%-- <script src="<c:url value="/js/reg/server/opanomaly/pubopanomaly/pubopanomalyent/pubopanomalyentdecision_book_main.js"/>"></script>  --%>
<script src="<c:url value="/js/common/print/printsetup.js"/>"></script>
<script src="<c:url value="/js/common/print/print.js"/>"></script>
</body>
</html>