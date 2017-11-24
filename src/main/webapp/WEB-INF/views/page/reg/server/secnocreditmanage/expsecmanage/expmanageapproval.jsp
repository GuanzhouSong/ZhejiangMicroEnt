<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
 	<meta http-equiv="X-UA-Compatible" content="IE=8" >
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>列入严违审批表打印页面</title>
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
        <p><h1>${expSeriousCrimeList.deptName}</h1><br></p>
        <p><h1>列入严重违法失信企业名单审批表</h1></p>
    </div> 
    <table class="table-print" cellpadding="0" cellspacing="0" border="0" width="100%">
        <tbody>
        <tr>
            <td width="20%" style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';" height="80px">企业名称</td>
            <td width="37%" class="col-l" style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">${expSeriousCrimeList.entName}</td> 
        </tr>
        <tr>
            <td style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">注册号</td>
            <td class="col-l" style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">${expSeriousCrimeList.regNO}</td> 
        </tr>
        <tr>
            <td style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">列入严重违法失信企业名单的事实和法律依据</td> 
            <td class="col-l" style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';word-break:break-all;">
 					经查，该企业被列入经营异常名录届满3年仍未履行相关义务。<fmt:formatDate value="${expSeriousCrimeList.abnTime}" type="date" pattern="yyyy年MM月dd日"/>
					，该企业因${expSeriousCrimeList.speCauseCN}被${expSeriousCrimeList.decorgCN}列入经营异常名录。
 					截止<fmt:formatDate value="${expSeriousCrimeList.expExpiredDate}" type="date" pattern="yyyy年MM月dd日"/>
 					已届满3年，仍未履行相关义务。以上事实有：
 					1.<fmt:formatDate value="${expSeriousCrimeList.abnTime}" type="date" pattern="yyyy年MM月dd日"/>《列入经营异常名录决定书》一份；
 					2.<fmt:formatDate value="${expSeriousCrimeList.abnTime}" type="date" pattern="yyyy年MM月dd日"/>浙江省企业信用信息公示平台提示公告截图一份；
 					3.届满之日企业在公示系统、准入系统中的相关状态或者通过登记的住所（经营场所）无法联系的相关证据等${expSeriousCrimeList.addSecBasedNum}份。
 					上述行为违反了《企业信息公示暂行条例》的相关规定。
 					根据《严重违法失信企业名单管理暂行办法》第五条第一款第（一）项的规定，建议将其列入严重违法失信企业名单并予以公示。
 					<br>
                 <span style="float:right;">经办人员： ${expSeriousCrimeList.applyMan}</span><br>
                 <span style="float:right;">申请日期： <fmt:formatDate value="${expSeriousCrimeList.applyDate}" type="date" pattern="yyyy-MM-dd"/></span>

			</td>
        </tr>
        <tr>
            <td style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">初审意见</td>
            <td class="col-l" style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">
                 ${expSeriousCrimeList.firstOpin} <br>
                 <span style="float:right;">初审人员： ${expSeriousCrimeList.firstName}</span><br>
                 <span style="float:right;">初审日期： <fmt:formatDate value="${expSeriousCrimeList.firstdate}" type="date" pattern="yyyy-MM-dd"/></span>
            </td> 
        </tr>
        <tr>
            <td style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">审核意见</td>
            <td class="col-l" style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';word-break:break-all;">
                 ${expSeriousCrimeList.auditOpin}<br>
                 <span style="float:right;">审核人员： ${expSeriousCrimeList.auditName}</span><br>
                 <span style="float:right;">审核日期：<fmt:formatDate value="${expSeriousCrimeList.auditDate}" type="date" pattern="yyyy-MM-dd"/></span>
            </td> 
        </tr> 
<!--         <tr> -->
<!--             <td style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">备注</td> -->
<!--             <td class="col-l" style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';word-break:break-all;"> -->
<%--                  ${expSeriousCrimeList.remark} --%>
<!--             </td>  -->
<!--         </tr>  -->
        </tbody>
    </table>  
</div>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/common/print/printsetup.js"/>"></script>
<script src="<c:url value="/js/common/print/print.js"/>"></script>
</body>
</html>
