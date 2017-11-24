<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <title>未进入限制公示列表</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">

    <form id="taskForm">
        <div class="form-box pd14-mr">
            <div class="form-list">
                <div class="form-item clearfix">
                    <div class="col-3">
                        <label class="item-name col-6"><span class="long-label">统一代码/注册号：</span></label>
                        <div class="col-6">
                            <div class="ipt-box col-12">
                                <input type="text" class="ipt-txt" name="uniCode">
                            </div>
                        </div>
                    </div>
                    <div class="col-3">
                        <label class="item-name col-5">企业名称：</label>
                        <div class="col-7">
                            <div class="ipt-box col-12">
                                <input type="text" class="ipt-txt" name="entName">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-item">
                    <div class="btn-box mt10">
                        <input type="button" id="search" value="查 询" class="btn mr20">
                        <input type="reset" id="cancel" value="重 置" class="btn">
                    </div>
                </div>
            </div>
        </div>
    </form>
<div class="iframe-wrap mt10">
<input class="btn btn-sm glyphicon glyphicon-plus" type="button" value="返回" onclick="history.go(-1)">
    <span style="color:red;">提示：此处仅查询显示当前未列入过限制公示名单的企业。</span>
    <div class="clearfix mb5 mt5">
       <p class="fl"><input type="button" class="btn btn-sm mr5 js-add" value="新增限制公示名单" /></p>
    </div>
    <table id="pubnotexcludeent-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30" width="100%">
        <thead>
        <tr>
            <th>序号</th>
        	<th>操作</th>
            <th>统一代码/注册号</th>
            <th>企业名称</th>
            <th>法定代表人</th>
            <th>成立日期</th>
            <th>登记状态</th>
            <th>登记机关</th>
            <th>管辖单位</th>
        </tr>
        </thead>
    </table>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/yr/pubexcludeent/listnotexclude_main.js"></script>
</body>
</html>
