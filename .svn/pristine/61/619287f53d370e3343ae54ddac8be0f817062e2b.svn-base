<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>信息管理数据应用反馈新增</title>
    <link rel="stylesheet" href="/css/pub-syn.css">
</head>
<body>
<form id="hxForm">
<div class="popup-box">
    <div class="title">实际处理条数录入</div>
    <div class="popup-hd">
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="popup-table">
            <tr>
                <td align="right">信息来源</td>
                <td>${csDepsynComPunDto.inputDepCode}</td>
            </tr>
            <tr>
                <td align="right">反馈类型</td>
                <td>联合惩戒反馈信息</td>
            </tr>
            <tr>
                <td align="right">年度</td>
                <td>${csDepsynComPunDto.year}</td>
            </tr>
            <tr>
                <td align="right">信息类别</td>
                <td>${csDepsynComPunDto.msgType}</td>
            </tr>
            <tr>
                <td align="right">接收条数</td>
                <td>${csDepsynComPunDto.num}</td>
            </tr>
            <tr>
                <td align="right">实际处理条数</td>
                <td><input type="text" name="realNum" value="${csDepsynComPunDto.realNum}"> 条</td>
            </tr>
        </table>
    </div>
    <input type="hidden" name="inputDepCode" value="${csDepsynComPunDto.inputDepCode}">
    <input type="hidden" name="msgType" value="${csDepsynComPunDto.msgType}">
    <div class="popup-btn-box clearfix">
        <input type="button" value="关闭" id="close"class="ipt-btn fr mb3">
        <input type="submit" value="提交" id="" class="ipt-btn fr mr10 mb3">
    </div>
</div>
</form>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/depsyn/sjyyfk_edit.js"></script>
</body>
</html>