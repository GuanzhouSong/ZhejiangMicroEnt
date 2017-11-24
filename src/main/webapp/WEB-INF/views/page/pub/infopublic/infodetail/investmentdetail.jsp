<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>基本信息_股东及出资详情查看页面</title>
    <link rel="stylesheet" href="/css/pub.css">
</head>
<body>
<div class="mod-bd-panel_company">
    <h3 class="i-title">
        <i></i>企业资产状况信息
    </h3>
    <table class="table-common table-zichan">
        <tbody>
	        <tr>
	            <td width="200" class="odd">股东</td>
	            <td class="col-l">${midInv.inv}</td>
	        </tr>
	        <tr>
	            <td class="odd">认缴额（万${currencyCn }）</td>
	            <td class="col-l">${midInv.subConAm}</td>
	        </tr>
	        <tr>
	            <td class="odd">实缴额（万${currencyCn }）</td>
	            <td class="col-l">${midInv.acConAm}</td>
	        </tr>
        </tbody>
    </table>
</div>
<div class="mod-bd-panel_company">
    <h3 class="i-title">
        <i></i>认缴明细信息
    </h3>
    <table class="table-common">
        <thead>
        <tr>
            <th width="135">认缴出资方式 </th>
            <th width="135">认缴出资额（万${currencyCn }）</th>
            <th width="135">认缴出资日期 </th>
        </tr>
        </thead>
        <tbody>
        <!--
        <tr>
            <td>${midInv.subConForm}</td>
            <td>${midInv.subConAm}</td>
            <td><fmt:formatDate value="${midInv.subConDate}" pattern="yyyy年MM月dd日"/></td>
        </tr>
        <tr>
            <td>货币</td>
            <td>200</td>
            <td>2014年2月11日</td>
        </tr>
         -->
        </tbody>
    </table>
</div>
<div class="mod-bd-panel_company">
    <h3 class="i-title">
        <i></i>实缴明细信息
    </h3>
    <table class="table-common">
        <thead>
        <tr>
            <th width="135">实缴出资方式</th>
            <th width="135">实缴出资额（万${currencyCn }）</th>
            <th width="135">实缴出资日期</th>
        </tr>
        </thead>
        <tbody>
        <!-- 
        <tr>
            <td>实物</td>
            <td>${midInv.acConAm}</td>
            <td>2014年1月10日</td>
        </tr>
         -->
        </tbody>
    </table>
</div>
</body>
</html>