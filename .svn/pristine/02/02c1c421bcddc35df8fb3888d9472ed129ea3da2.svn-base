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
<jsp:include page="common/header.jsp"></jsp:include>
<div class="mod clearfix">
    <jsp:include page="common/menu.jsp?module=wtsjcl&menu=plbd"></jsp:include>
    <div class="main">
        <div class="crumbs">
            <a href="javascript:void(0)">首页</a> &gt;
            <a href="javascript:void(0)" class="cur">起始页</a>
        </div>
        <hr/>
        <input id="msg" type="hidden" value="${msg}" />
        <form id="compare-form" method="post" enctype="multipart/form-data" action="/depsyn/doCompareUpload">
        <div class="drjgtj-box">
            <h3 class="date-upload-title">数据文件上传</h3>
            <div class="upload-box">
                <label for="">请上传文件（仅限Excel文件）</label>
                <input id="filename" type="text" id="js-excel-file" readonly>
                <input  type="button" value="浏览.." class="ipt-btn js-ipt-btn">
                <input class="importfile" name="filename" type="file" id="js-file-btn" style="display: none">
            </div>
            <p class="center mt55">
                <input id="upload" type="button" value="上传" class="ipt-btn" style="margin-right: 55px">
                <input type="button" value="取消" class="ipt-btn">
            </p>
        </div>
        </form>
    </div>
</div>
<jsp:include page="common/footer.jsp"></jsp:include>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/depsyn/compare_upload.js"></script>
</body>
</html>