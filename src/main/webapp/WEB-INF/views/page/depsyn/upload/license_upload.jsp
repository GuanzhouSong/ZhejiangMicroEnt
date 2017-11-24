<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>数据导入结果显示提交</title>
    <link rel="stylesheet" href="/css/pub-syn.css">
</head>
<body class="outer-bg">
<jsp:include page="../common/header.jsp"></jsp:include>
<div class="mod clearfix">
    <jsp:include page="../common/menu.jsp?module=zxlr&menu=pldr"></jsp:include>
    <div class="main">
        <div class="crumbs">
            <a href="javascript:void(0)">首页</a> &gt;
            <a href="javascript:void(0)">信息提供</a> &gt;
            <a href="javascript:void(0)" class="cur">批量导入</a>
        </div>
        <hr/>
        <div class="drjgtj-box">
            <h3 class="date-upload-title">数据文件上传</h3>
            <div class="upload-box">
                <label for="">请上传文件（仅限Excel文件）</label><input type="text" id="js-excel-file" readonly><input type="button" value="浏览.." class="ipt-btn js-ipt-btn">
                <input name="file" type="file" id="js-file-btn" style="display: none">
            </div>
            <p class="center mt55">
                <input id="js-upload" type="button" value="上传" class="ipt-btn" style="margin-right: 55px"><input id="js-cancel" type="button" value="取消" class="ipt-btn">
            </p>
        </div>
    </div>
</div>
<div class="mod">
    <div class="footer-box">
        <div class="footer">
            <p>版权所有：浙江省工商行政管理局</p>
            <p>年报公示业务咨询电话：400-888-4636（年报）&nbsp;&nbsp;&nbsp;&nbsp;技术支持电话：400-888-4636（公示）&nbsp;&nbsp;&nbsp;&nbsp;京ICP备16053442号-1</p>
        </div>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/depsyn/upload/license_upload.js"></script>
</body>
</html>