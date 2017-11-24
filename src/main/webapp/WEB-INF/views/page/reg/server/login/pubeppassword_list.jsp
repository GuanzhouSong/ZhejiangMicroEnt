<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>联络员备案表接收</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<style type="text/css">
    .accept {
        text-decoration: none;
        color: #003399;
        cursor: pointer;
        font-size: 13px;
    }
</style>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box">
        <div class="form-list">
            <div class="form-item clearfix">
                <label class="item-name col-5">流水号:&nbsp;&nbsp;</label>
                <div class=" col-7">
                    <div class="col-4 ipt-box">
                        <input type="text" id="pasidval" class="ipt-txt" name="pasid" value="" placeholder="输入流水号后4位即可查询"/>
                    </div>
                </div>
            </div>

        </div>
        <div class="center mt10">
            <input type="button" id="search" value="查询" class="btn mr20">
            <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
        </div>
    </form>
    <div>
        <table id="permit-table" border="0" cellspacing="0" cellpadding="0" class="table-row display nowrap mt10">
            <thead>
            <tr>
                <th>序号</th>
                <th>操作</th>
                <th>流水号</th>
                <th>统一代码/注册号</th>
                <th>企业名称</th>
                <th>法定代表人</th>
                <th>联络员证件号</th>
                <th>联络员姓名</th>
                <th>登记机关</th>
                <th>管辖单位</th>
            </tr>
            </thead>
        </table>
    </div>
    <script src="/js/lib/require.js"></script>
    <script src="/js/config.js"></script>
    <script src="/js/reg/server/login/pubeppassword_list_main.js"></script>
</div>
</body>
</html>
