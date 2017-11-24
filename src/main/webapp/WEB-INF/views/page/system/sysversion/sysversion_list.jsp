<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>版本管理</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box">
        <div class="form-list pdr8">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">设置人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="setName" value="" placeholder="请输入设置人">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">设置时间：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt pointer laydate-icon" onclick="laydate()"
                                   name="createTimeStart" readonly="readonly"/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt pointer laydate-icon" onclick="laydate()"
                                   name="createTimeEnd" value="" readonly="readonly"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">标题：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="title" value="" placeholder="请输入标题"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-group clearfix mt10">
            <div class="center">
                <input type="button" id="search" value="查询" class="btn mr20">
                <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
            </div>
        </div>
    </form>
    <div>
        <div class="mt5 mb5">
            <button class="btn btn-sm" id="addSysVersion" type="button">&nbsp;新增</button>
        </div>
        <table id="sysversion-table" border="0" cellspacing="0" cellpadding="0" class="table-row">
            <thead>
            <tr>
                <th>序号</th>
                <th>标题</th>
                <th>内容</th>
                <th>设置人</th>
                <th>设置时间</th>
                <th>操作</th>
            </tr>
            </thead>
        </table>
    </div>
</div>


<div style="border-top: 1px solid grey;">
    <div style="margin-top: 10px;">
         <span>
        描述：如果新增或删除省级联动数据,则需要手动进行刷新获取最新的缓存数据。
    </span>
        <button class="js-clearAaddressMap btn mr20">猛击刷新</button>
    </div>
</div>

<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <a class="{{this.class}}">{{this.text}}</a>
        {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/business/sysversion/list_main.js"></script>
</body>
</html>
