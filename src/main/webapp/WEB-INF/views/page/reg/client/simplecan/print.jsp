<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>简易注销信息打印</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/print.css"/>"/>
<style media="print" type="text/css">
    .STYLE1 {
        font-size: 16px;
        font-weight: bold;
    }
    object { display: none}
    .Noprint{ display:none; }
    .PageNext{ page-break-after: always; clear: both; width: 100%}
</style>

</head>
<body>
<div class="button Noprint" style="width:600px;">
    <a href="javascript:Print();"><strong style="font-size:16px">打印</strong></a>
    <a href="javascript:PrintView();"><strong style="font-size:16px">预览</strong></a>
    <a href="javascript:PrintSetup();"><strong style="font-size:16px">设置</strong></a>
    <a id="closeBtn" href="javascript:closeWindow();"><strong style="font-size:16px">关闭</strong></a>
</div>

<object id="factory" viewastext="" classid="clsid:1663ed61-23eb-11d2-b92f-008048fdd814" codebase="/js/common/print/ScriptX.cab#version=6,2,433,14"> </object>
<object id="WebBrowser" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>


<div id="printarea">
<div class="print2">
    <table>
        <tr >
            <td  colspan="6"><h2>简易注销信息</h2></td>
        </tr>
          <tr>
                <td style="width:19%;text-align: center;">企业名称</td>
                <td style="width:18%;text-align: center;">统一代码/注册号</td>
                <td style="width:19%;text-align: center;">登记机关</td>
                <td style="width:15%;text-align: center;">公告申请日期</td>
                <td style="width:15%;text-align: center;">公告期自</td>
                <td style="width:15%;text-align: center;">公告期至</td>
         </tr>
         <tr>
              <td>${erEscAppinfo.entName}</td>
              <td>${empty erEscAppinfo.uniSCID?erEscAppinfo.regNO:erEscAppinfo.uniSCID}</td>
              <td>${erEscAppinfo.regOrg}</td>
              <td><fmt:formatDate value="${erEscAppinfo.appDate}" pattern="yyyy-MM-dd" /></td>
              <td><fmt:formatDate value="${erEscAppinfo.noticeFrom}" pattern="yyyy-MM-dd" /></td>
              <td><fmt:formatDate value="${erEscAppinfo.noticeTo}" pattern="yyyy-MM-dd" /></td>
         </tr>
    </table>
</div>
</div>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/common/print/printsetup.js"></script>
<script src="/js/common/print/print.js"></script>
 
</body>
</html>