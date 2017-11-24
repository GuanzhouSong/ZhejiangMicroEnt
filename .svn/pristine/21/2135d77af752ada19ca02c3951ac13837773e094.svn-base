<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>企业详情</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/print.css"/>"/>
    
    <style media="print" type="text/css">
        .STYLE1 {
            font-size: 16px;
            font-weight: bold;
        }

        object {
            display: none
        }

        .Noprint {
            display: none;
        }

        .PageNext {
            page-break-after: always;
            clear: both;
            width: 100%
        }
    </style>

    <style type="text/css">
        .height40 {
            height: 40px;
        }
    </style>
</head>
<body class="pd10">
<div class="clearfix reg-company-basic">
<div class="button Noprint" style="width:600px;">
	    <a href="javascript:Print();"><strong style="font-size:16px">直接打印</strong></a>
	    <a href="javascript:PrintView();"><strong style="font-size:16px">打印预览</strong></a>
	    <a href="javascript:PrintSetup();"><strong style="font-size:16px">打印设置</strong></a>
	    <a id="closeBtn" href="javascript:window.top.close();"><strong style="font-size:16px">关闭窗口</strong></a>
<object height="0px" hidden="hidden" id="factory" viewastext="" classid="clsid:1663ed61-23eb-11d2-b92f-008048fdd814" codebase="/js/common/print/ScriptX.cab#version=6,2,433,14"> </object>
<object height="0px" hidden="hidden" id="WebBrowser" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>
</div>
<input type="hidden" id="priPID" value="${priPID }">
<input type="hidden" id="uid" value="${uid}">
<input type="hidden" id="efftStatus" value="${favorAbleInfo.efftStatus}">
    <div class="clearfix reg-caption">
        <div class="title clearfix">
            <span class="name fl mr5">${entBasicInfo.entName }</span> 
        </div>
        <p>
            <i class="book2-icon"></i>统一社会信用代码/注册号：
            <span>
             <c:choose>
                <c:when test="${!empty entBasicInfo.uniCode}">
                    ${entBasicInfo.uniCode }
                </c:when>
                <c:otherwise>
                    ${entBasicInfo.regNO }
                </c:otherwise>
            </c:choose>
            </span>
        </p>
        <p>
            <i class=""></i>打印时间：<span>${nowDate}</span>
        </p> 
        <!-- <div class="btn-box">
            <div>
            <a href="javascript:void(0);" class="green-bg" id="printbtncon" target="_blank"><input type="button" class="btn-print" id="s" /></a>
            </div> 
        </div> -->
    </div>
</div>
  
<div class="clearfix mt5 mb5">
    <h6 class="add-title fl">企业良好信息</h6>
    
</div>
<table class="table-row" cellpadding="0" cellspacing="0" border="0">
    <thead>
    <tr>
        <th>序号</th>
        <th>良好信息名称</th>
        <th>良好信息类别</th>
        <th>评定级别</th>
        <th>认定发布年度</th>
        <th>认定类别</th>
        <th>认定有效期始</th>
        <th>认定有效期止</th>
        <th>状态</th>
        <th>认定发布时间</th>
        <th>认定发布文号</th>
        <th>认定发布部门</th>
    </tr>
    </thead>
    <tbody id="case">
    </tbody>
</table>
<script id="case-template" type="text/x-handlebars-template">
            {{#each data}}
            <tr>
                <td> {{addOne @index}}</td>
 				<td>{{favName}}</td>
                <td>{{transfavType favType}}</td>
                <td>{{translicZone licZone}}</td>
                <td>{{regYear}}</td>
                <td>{{regType}}</td>
                <td>{{regFrom}}</td>
                <td>{{regTo}}</td> 
                <td rowspan="">{{transEfftStatus efftStatus}}</td>
				<td>{{regDate}}</td> 
				<td>{{regDocNo}}</td> 
				<td>{{regDeptCn}}</td> 
            </tr>
            {{/each}}
        </script>
<div class="clearfix mt5 mb5">
    <h6 class="add-title fl">企业不良信息</h6>
</div>
<table class="table-row" cellpadding="0" cellspacing="0" border="0">
    <thead>
    <tr>
        <th>序号</th>
        <th>不良信息类别</th>
        <th>信息来源</th>
        <th>发生日期</th>
        <th>文号</th>
    </tr>
    </thead>
    <tbody id="ippldg">
    </tbody>
</table>
<script id="ippldg-template" type="text/x-handlebars-template">
            {{#each data}}
            <tr>
                <td>{{addOne @index}}</td>
                <td>{{regType}}</td>
                <td>{{transRegDeptCn regDeptCn}}</td>
                <td> {{regDate}}</td>
                <td>{{transRegDocNo regDocNo}}</td>
            </tr>
            {{/each}}
</script>
</body>
<script>
    //参数的传递
    window._CONFIG = {
        repType: '${imReportType}',
        _sysUrl: '${sysUrl}'

    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/favorable/favorabledetail_edit_main.js"></script>
<script src="/js/reg/server/favorable/favorabledetail_print_main.js"></script>
<script src="<c:url value="/js/common/print/printsetup.js"/>"></script>
<script src="<c:url value="/js/common/print/print.js"/>"></script>
</html>
