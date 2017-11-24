<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
 	<meta http-equiv="X-UA-Compatible" content="IE=8" >
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>列入异常名录审批表</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/printer.css"/>"/>
</head>
<body>
<div class="button Noprint" style="width:600px;">
    <a href="javascript:Print();"><strong style="font-size:16px">直接打印</strong></a>
    <a href="javascript:PrintView();"><strong style="font-size:16px">打印预览</strong></a>
    <a href="javascript:PrintSetup();"><strong style="font-size:16px">打印设置</strong></a>
    <a id="closeBtn" href="javascript:window.top.close();"><strong style="font-size:16px">关闭窗口</strong></a>
</div>
<object height="0px" id="factory" viewastext="" classid="clsid:1663ed61-23eb-11d2-b92f-008048fdd814" codebase="/js/common/print/ScriptX.cab#version=6,2,433,14"> </object>
<object height="0px" id="WebBrowser" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>
<div id="printarea">
	<div class="print2" id="print2">
	</div>
</div>

<div class="mod mod-print" style="position:relative; bottom: 30px;">
    <div class="mod-print-hd">
        <p><h1>${pubOpanoMaly.deptName}</h1><br></p>
        <p><h1>经营异常名录审批表</h1></p>
    </div> 
    <table class="table-print" cellpadding="0" cellspacing="0" border="0" width="100%">
        <tbody>
        <c:if test="${type != 'batch'}">
        <tr>
            <td width="20%" style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';" height="80px">企业名称</td>
            <td width="37%" class="col-l" style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">${pubOpanoMaly.entName}</td> 
        </tr>
        <tr>
            <td style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">注册号</td>
            <td class="col-l" style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">${pubOpanoMaly.regNO}</td> 
        </tr>
        </c:if>
        <c:if test="${type == 'batch'}">
        <tr>
            <td width="20%" style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';" height="80px">企业名称</td>
            <td width="37%" class="col-l" style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">${pubOpanoMaly.entName}等共${initBatchNum}家企业（农专社）</td> 
        </tr>
        </c:if>
        <tr>
            <td style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">事实和理由</td> 
            <td class="col-l" style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';word-break:break-all;">${pubOpanoMaly.anomalyRea}</td>
        </tr>
        <tr>
            <td style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">初审意见</td>
            <td class="col-l" style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">
                 ${pubOpanoMaly.firstOpin} <br>
                 <span style="float:right;">初审人员： ${pubOpanoMaly.firstName}</span><br>
                 <span style="float:right;">初审日期： <fmt:formatDate value="${pubOpanoMaly.firstdate}" type="date" pattern="yyyy-MM-dd"/></span>
            </td> 
        </tr>
        <tr>
            <td style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">审核意见</td>
            <td class="col-l" style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';word-break:break-all;">
                 ${pubOpanoMaly.auditOpin}<br>
                 <span style="float:right;">审核人员： ${pubOpanoMaly.auditName}</span><br>
                 <span style="float:right;">审核日期：<fmt:formatDate value="${pubOpanoMaly.auditDate}" type="date" pattern="yyyy-MM-dd"/></span>
            </td> 
        </tr> 
        <tr>
            <td style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">备注</td>
            <td class="col-l" style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';word-break:break-all;">
                 ${pubOpanoMaly.remark}
            </td> 
        </tr> 
        </tbody>
    </table>
            <c:if test="${type == 'batch'}">
    		<!-- 下面企业名单部分 -->
			<p class=p0 style="margin-bottom: 0pt; margin-top: 0pt; layout-grid-mode: char; text-align:left ;">
				<span style="mso-spacerun: 'yes'; font-family: '宋体';">附：企业名单</span>
			</p>
			<table align=center style="width:100%;border-collapse: collapse; margin-left: 4.0000pt; mso-table-layout-alt: fixed; padding: 0.0000pt 1.4000pt 0.0000pt 1.4000pt;">
				<tr style="height: 19.8500pt;">
					<td width="10%" valign=center style="text-align:center;padding: 2px; border-left: 0.7500pt solid rgb(0, 0, 0); mso-border-left-alt: 0.7500pt solid rgb(0, 0, 0); border-right: 0.7500pt solid rgb(0, 0, 0); mso-border-right-alt: 0.7500pt solid rgb(0, 0, 0); border-top: 0.7500pt solid rgb(0, 0, 0); mso-border-top-alt: 0.7500pt solid rgb(0, 0, 0); border-bottom: 0.7500pt solid rgb(0, 0, 0); mso-border-bottom-alt: 0.7500pt solid rgb(0, 0, 0);">
							<span style="mso-spacerun: 'yes'; font-family: '宋体';">序号</span>
					</td>
					<td width="30%" valign=center style="text-align:center;padding: 2px; border-left: 0.7500pt solid rgb(0, 0, 0); mso-border-left-alt: 0.7500pt solid rgb(0, 0, 0); border-right: 0.7500pt solid rgb(0, 0, 0); mso-border-right-alt: 0.7500pt solid rgb(0, 0, 0); border-top: 0.7500pt solid rgb(0, 0, 0); mso-border-top-alt: 0.7500pt solid rgb(0, 0, 0); border-bottom: 0.7500pt solid rgb(0, 0, 0); mso-border-bottom-alt: 0.7500pt solid rgb(0, 0, 0);">
							<span style="mso-spacerun: 'yes';  font-family: '宋体';">统一社会信用代码/注册号</span>
					</td>
					<td width="60%" valign=center style="text-align:center;padding: 2px; border-left: 0.7500pt solid rgb(0, 0, 0); mso-border-left-alt: 0.7500pt solid rgb(0, 0, 0); border-right: 0.7500pt solid rgb(0, 0, 0); mso-border-right-alt: 0.7500pt solid rgb(0, 0, 0); border-top: 0.7500pt solid rgb(0, 0, 0); mso-border-top-alt: 0.7500pt solid rgb(0, 0, 0); border-bottom: 0.7500pt solid rgb(0, 0, 0); mso-border-bottom-alt: 0.7500pt solid rgb(0, 0, 0);">
							<span style="mso-spacerun: 'yes';  font-family: '宋体';">企业名称</span>
					</td>
				</tr>
				<c:forEach var="pubOpanoMalyDto" items="${pubOpanoMalys}" varStatus="status">
					<tr style="height: 19.8500pt;">
					<td valign=center style="text-align:center;padding: 2px; border-left: 0.7500pt solid rgb(0, 0, 0); mso-border-left-alt: 0.7500pt solid rgb(0, 0, 0); border-right: 0.7500pt solid rgb(0, 0, 0); mso-border-right-alt: 0.7500pt solid rgb(0, 0, 0); border-top: 0.7500pt solid rgb(0, 0, 0); mso-border-top-alt: 0.7500pt solid rgb(0, 0, 0); border-bottom: 0.7500pt solid rgb(0, 0, 0); mso-border-bottom-alt: 0.7500pt solid rgb(0, 0, 0);">
							<span style="mso-spacerun: 'yes';  font-family: '宋体';">${status.count}</span>
					</td>
					<td valign=center style="text-align:center;padding: 2px; border-left: 0.7500pt solid rgb(0, 0, 0); mso-border-left-alt: 0.7500pt solid rgb(0, 0, 0); border-right: 0.7500pt solid rgb(0, 0, 0); mso-border-right-alt: 0.7500pt solid rgb(0, 0, 0); border-top: 0.7500pt solid rgb(0, 0, 0); mso-border-top-alt: 0.7500pt solid rgb(0, 0, 0); border-bottom: 0.7500pt solid rgb(0, 0, 0); mso-border-bottom-alt: 0.7500pt solid rgb(0, 0, 0);">
							<span style="mso-spacerun: 'yes';  font-family: '宋体';">${empty pubOpanoMalyDto.uniSCID ? pubOpanoMalyDto.regNO : pubOpanoMalyDto.uniSCID  }</span>
					</td>
					<td valign=center style="text-align:left;padding: 2px; border-left: 0.7500pt solid rgb(0, 0, 0); mso-border-left-alt: 0.7500pt solid rgb(0, 0, 0); border-right: 0.7500pt solid rgb(0, 0, 0); mso-border-right-alt: 0.7500pt solid rgb(0, 0, 0); border-top: 0.7500pt solid rgb(0, 0, 0); mso-border-top-alt: 0.7500pt solid rgb(0, 0, 0); border-bottom: 0.7500pt solid rgb(0, 0, 0); mso-border-bottom-alt: 0.7500pt solid rgb(0, 0, 0);">
							<span style="mso-spacerun: 'yes';  font-family: '宋体';">${pubOpanoMalyDto.entName}</span>
					</td>
				</tr>
				</c:forEach>
			</table>
			</c:if>
</div>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/common/print/printsetup.js"/>"></script>
<script src="<c:url value="/js/common/print/print.js"/>"></script>
</body>
</html>
