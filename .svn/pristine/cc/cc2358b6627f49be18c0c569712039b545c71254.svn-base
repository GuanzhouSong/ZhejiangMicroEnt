<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>涉证企业名单</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">
<form id="taskForm">
    <div class="form-box mb5">
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" name="entName">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5"> 统一社会信用代码：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" name="uniSCID">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                <label class="item-name col-5">注册号：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" name="regNO">
                        </div>
                    </div>
                </div>
            </div>
            <input type="hidden" name="adcode" value="${adcode}">
            <div class="form-item clearfix mt10">
                <div class="btn-box">
                    <input type="button" id="search" value="查 询" class="btn mr20">
                    <input type="button" id="reset" value="重 置" class="btn">
                </div>
            </div>
        </div>
    </div>
</form>
<div class="clearfix mb5">
    <p class="fl">
        <span class="mt5" id="downinfo"></span>
        <input type="button" class="btn btn-sm js-batchdownload js-export" value="下载">
    </p>
</div>
<div>
    <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap">
        <thead>
        <tr>
            <th>序号</th>
            <th><input type="checkbox" class="chbAll">全选</th>
            <th>企业名称</th>
            <th>统一社会信用代码</th>
            <th>注册号</th>
            <th>经营范围</th>
            <th>地址</th>
            <th>成立时间</th>
            <th>登记机关</th>
            <th>下载状态</th>
        </tr>
        </thead>
    </table>
</div>
<script src="/js/lib/laydate/laydate.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/inforece/pubdtinfo/pubdtinfo_list.js"></script>
</body>
</html>