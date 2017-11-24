<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>抽查检查任务设置</title>
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">
<div class="print-nocard">
    <h3>抽查检查任务设置</h3>
</div>
<h6 class="h6-title">检查任务设置</h6>
<div class="form-box pd20">
    <div class="form-list">
        <div class="form-item clearfix">
            <label class="item-name col-2">任务编号：</label>
            <div class="col-4">
                <div class="ipt-box col-12">
                    <input type="text" class="ipt-txt">
                </div>
            </div>
            <span class="ml10 inline-block mt5">任务牵头组织机关简称+抽查+年度+序号，如：浙工商抽查[2017]1号</span>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2">任务名称：</label>
            <div class="col-8">
                <div class="ipt-box col-12">
                    <input type="text" class="ipt-txt">
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2">任务组织部门：</label>
            <div class="col-8">
                <div class="ipt-box col-12">
                    <select name="">
                        <option value=""></option>
                        <option value=""></option>
                        <option value=""></option>
                    </select>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2">检查实施部门：</label>
            <div class="col-8">
                <div class="ipt-box col-12">
                    <select name="">
                        <option value=""></option>
                        <option value=""></option>
                        <option value=""></option>
                    </select>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2">检查主体类型：</label>
            <div class="col-8">
                <div class="ipt-box col-12">
                    <select name="">
                        <option value=""></option>
                        <option value=""></option>
                        <option value=""></option>
                    </select>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2">任务期限：</label>
            <div class="col-8">
                <div class="ipt-box col-3">
                    <input type="text" class="ipt-txt">
                </div>
                <span class="item-txt col-1"><i class="line-icon"></i></span>
                <div class="ipt-box col-3">
                    <input type="text" class="ipt-txt">
                </div>
            </div>
        </div>
        <div class="form-item form-item-border clearfix display-table">
            <label class="item-name col-2 table-cell vm">任务说明：</label>
            <div class="col-8 table-cell">
                <div class="clearfix mt5 table-cell-item">
                    <span class="fl col-2 right">抽查检查依据：</span>
                    <div class="ipt-box col-10">
                        <input type="text" class="ipt-txt">
                    </div>
                </div>
                <div class="clearfix mt5 table-cell-item">
                    <span class="fl col-2 right">检查区域：</span>
                    <div class="ipt-box col-10">
                        <input type="text" class="ipt-txt">
                    </div>
                </div>
                <div class="clearfix mt5 table-cell-item">
                    <span class="fl col-2 right">抽查检查对象：</span>
                    <div class="ipt-box col-10">
                        <input type="text" class="ipt-txt">
                    </div>
                </div>
                <div class="clearfix mt5 table-cell-item">
                    <span class="fl col-2 right">抽查检查内容：</span>
                    <div class="ipt-box col-10">
                        <input type="text" class="ipt-txt">
                    </div>
                </div>
                <div class="clearfix mt5 mb5 table-cell-item">
                    <span class="fl col-2 right"> 检查方式及要求：</span>
                    <div class="ipt-box col-10">
                        <input type="text" class="ipt-txt">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<h6 class="h6-title mt20">检查内容设置</h6>
<table class="table-row" cellpadding="0" cellspacing="0" border="0">
    <thead>
    <tr>
        <th width="7%">序号</th>
        <th width="20%">检查部门  </th>
        <th> 检测事项 </th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>1</td>
        <td>工商局 </td>
        <td class="left">
            <div class="display-table">
                <span class="table-cell vm">登记事项；企业公示；广告管理；商标管理</span>
                <span class="table-cell right vm"><input type="button" class="btn btn-xs" value="选择"></span>
            </div>
        </td>
    </tr>
    </tbody>
</table>
<div class="clearfix mt20">
    <div class="btn-box">
        <input type="button" value="创 建" class="btn mr20">
        <input type="button" value="重 置" class="btn mr20">
        <input type="button" value="取消编辑" class="btn">
    </div>
</div>
</body>
</html>