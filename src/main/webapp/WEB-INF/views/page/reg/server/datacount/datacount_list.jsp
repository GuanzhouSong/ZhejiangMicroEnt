<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>数据统计</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body class="pd10">
<div class="form-box">
    <form id="qryForm">

        <div class="form-list pd14-mr">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">成立日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" readonly="readonly" onclick="laydate()" name="startDate"
                                   class="ipt-txt laydate-icon clx">
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" readonly="readonly" onclick="laydate()" name="endDate"
                                   class="ipt-txt laydate-icon clx">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">统计层级：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select id="statLevel" name="statLevel">
                                <option value="RegOrg" selected="selected">按登记机关</option>
                                <option value="LocalAdm">按管辖单位</option>
                                </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix mt10">
                <div class="btn-box">
                    <input id="qry" type="button" value="查 询" class="btn mr20">
                    <input id="cancel" type="button" value="重 置" class="btn">
                </div>
            </div>
        </div>
    </form>
</div>
<div class="clearfix mb5 mt5">
    </div>
<table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap" width="100%">
    <thead>
    <tr>
        <th  rowspan="2">序号</th>
        <th  rowspan="2">部门</th>
        <th  colspan="2">信息产业</th>
        <th  colspan="2">环保产业</th>
        <th  colspan="2">旅游产业</th>
        <th  colspan="2">金融产业</th>
        <th  colspan="2">健康产业</th>
        <th  colspan="2">时尚产业</th>
        <th  colspan="2">高端制造业</th>
        <th  colspan="2">小计</th>
    </tr>
    <tr>
        <th >户数</th>
        <th >注册资本（万元）</th>
        <th >户数</th>
        <th >注册资本（万元）</th>
        <th >户数</th>
        <th >注册资本（万元）</th>
        <th >户数</th>
        <th >注册资本（万元）</th>
        <th >户数</th>
        <th >注册资本（万元）</th>
        <th >户数</th>
        <th >注册资本（万元）</th>
        <th >户数</th>
        <th >注册资本（万元）</th>
        <th >户数</th>
        <th >注册资本（万元）</th>
    </tr>
    </thead>
    <%--<tfoot>
    <tr>
        <th>总计：</th>
        <th>部门</th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    </tfoot>--%>
</table>
</div>
<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="{{this.class}}">{{this.text}}</button>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/datacount/datacount_list.js"></script>
</body>
</html>
