<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>行政指导申请</title>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<div class="form-box">
    <div class="form-list">
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5">统一信用代码/注册号：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt">
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">企业名称：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt">
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">行政指导有效日期：</label>
                <div class="col-6">
                    <div class="ipt-box col-5">
                        <input type="text" class="ipt-txt">
                    </div>
                    <span class="item-txt col-2"><i class="line-icon"></i></span>
                    <div class="ipt-box col-5">
                        <input type="text" class="ipt-txt">
                    </div>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5">申请/审核人：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt">
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">提示状态：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <select name="">
                            <option value=""></option>
                            <option value=""></option>
                            <option value=""></option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5"> 管辖单位：</label>
                <div class="col-6">
                    <div class="ipt-box col-5">
                        <input type="text" class="fl ipt-txt" placeholder="选择">
                            <span class="add-icon">
                                <i></i>
                            </span>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5">行政指导项目：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <select name="">
                            <option value=""></option>
                            <option value=""></option>
                            <option value=""></option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">审核结果：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <select name="">
                            <option value=""></option>
                            <option value=""></option>
                            <option value=""></option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5"> 登记机关：</label>
                <div class="col-6">
                    <div class="ipt-box col-5">
                        <input type="text" class="fl ipt-txt" placeholder="选择">
                            <span class="add-icon">
                                <i></i>
                            </span>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <div class="btn-box">
                <input type="button" value="查 询" class="btn mr20">
                <input type="button" value="重 置" class="btn">
            </div>
        </div>
    </div>
</div>
<div class="clearfix mb5 mt20">
    <p class="fl"><input type="button" class="btn btn-sm mr5" value="新增"><input type="button" class="btn btn-sm" value="导出"></p>
</div>
<div>
    <table border="0" cellspacing="0" cellpadding="0" class="table-row mt30">
        <tbody>
        <tr>
            <th width="7%">操作</th>
            <th width="7%">审核状态</th>
            <th>统一信用代码/注册号/批号</th>
            <th width="13%">企业名称 </th>
            <th width="13%"> 行政指导项目</th>
            <th width="7%">开始日期</th>
            <th width="7%"> 结束日期</th>
            <th width="7%">申请人</th>
            <th width="7%">申请日期</th>
            <th width="7%">审核人</th>
            <th width="7%">审核日期</th>
        </tr>
        <tr>
            <td><a href="#">修改</a><a href="#">删除</a></td>
            <td>待审核</td>
            <td>无证无照</td>
            <td>桐庐县工商局</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>