<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>打印审批表</title>
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
        <p><h1>${deptName}</h1><br></p>
        <p><h1>经营异常名录审批表</h1></p>
    </div> 
    <table class="table-print" cellpadding="0" cellspacing="0" border="0" width="100%">
        <tbody>
        <tr>
            <td width="20%" style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';" height="80px">企业名称</td>
            <td width="37%" class="col-l" style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">${pubPbopanomalyDto.entName}</td> 
        </tr>
        <tr>
            <td style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">注册号</td>
            <td class="col-l" style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">${pubPbopanomalyDto.regNO}</td> 
        </tr>
        <tr>
            <td style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">事实和理由</td> 
            <td class="col-l" style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';word-break:break-all;">${pubPbopanomalyDto.signRea}</td>
        </tr>
        <tr>
            <td style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">初审意见</td>
            <td class="col-l" style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">
                 ${pubPbopanomalyDto.firstOpin} <br>
                 <span style="float:right;">初审人员： ${pubPbopanomalyDto.firstName}</span><br>
                 <span style="float:right;">初审日期： <fmt:formatDate value="${pubPbopanomalyDto.firstDate}" type="date" pattern="yyyy-MM-dd"/></span>
            </td> 
        </tr>
        <tr>
            <td style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">审核意见</td>
            <td class="col-l" style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';word-break:break-all;">
                 ${pubPbopanomalyDto.auditOpin}<br>
                 <span style="float:right;">审核人员： ${pubPbopanomalyDto.auditName}</span><br>
                 <span style="float:right;">审核日期：<fmt:formatDate value="${pubPbopanomalyDto.auditDate}" type="date" pattern="yyyy-MM-dd"/></span>
            </td> 
        </tr> 
        <tr>
            <td style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';">备注</td>
            <td class="col-l" style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';word-break:break-all;">
            </td> 
        </tr> 
        </tbody>
    </table>  
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/common/print/printsetup.js"></script>
<script src="/js/common/print/print.js"></script>
</body>
</html>
