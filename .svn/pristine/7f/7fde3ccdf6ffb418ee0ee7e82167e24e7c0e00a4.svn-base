<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>风险预警审核</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">
<form id="checkSearchForm">
    <div class="form-box mb5">
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">批次编号：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" name="batchNo">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-4"> 标识名称：</label>
                    <div class="col-8">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" name="markName">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">标识级别：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select name="markClass" class="clx">
                                <option value="">不限</option>
                                <option value="0">关注</option>
                                <option value="1">警示</option>
                                <option value="2">限制</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix mb10">
                <div class="col-4">
                    <label class="item-name col-5">审核状态：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select name="checkState" class="clx">
                                <option value="">请选择</option>
                                <option value="1">通过</option>
                                <option value="0">未通过</option>
                                <option value="2">未审核</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-4">标识有效期：</label>
                    <div class="col-8">
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt clx" readonly="readonly" onclick="laydate();"
                                   name="markStartDate">
                        </div>
                        <span class="item-txt col-2"><i class="line-icon"></i></span>
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt clx" readonly="readonly" onclick="laydate();"
                                   name="markEndDate">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">录入/审核人：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" name="importPeople">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="btn-box">
                    <input type="button" id="search" value="查 询" class="btn mr20">
                    <input type="button" id="reset" value="重 置" class="btn">
                </div>
            </div>
            <input type="hidden" class="ipt-txt" name="deptCode" id="deptCode" value="${csEntWarn.deptCode}">
        </div>
    </div>
</form>
<div class="clearfix mb5">
    <span class="ml40 light-yellow fr mt5">您有${tgNum}条记录审核通过，${wtgNum}条记录审核未通过，${wshNum}条记录未审核</span>
</div>
<div>
    <table id="ent-check-table" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap">
        <thead>
        <tr>
            <th>序号</th>
            <th>操作</th>
            <th>审核状态</th>
            <th>批次编号</th>
            <th>标识设置年度</th>
            <th>标识名称</th>
            <th>标识内容</th>
            <th>标识级别</th>
            <th>标识指定提示方式</th>
            <th>标识指定提示部门</th>
            <th>标识开始日期</th>
            <th>标识结束日期</th>
            <th>录入人</th>
            <th>录入时间</th>
            <th>审核人</th>
            <th>审核时间</th>
        </tr>
        </thead>
    </table>
</div>
<script src="/js/lib/laydate/laydate.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/risk/entwarninfo/entwarncheck_list.js"></script>
</body>
</html>