<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<div class="form-box">
    <div class="form-list">
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5">案源名称：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt">
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">案件来源：</label>
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
                <label class="item-name col-5">案源录入人员：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt">
                    </div>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5">案源录入人员单位：</label>
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
                <label class="item-name col-5"> 案源登记时间：</label>
                <div class="col-6">
                    <div class="ipt-box col-5">
                        <input type="text" class="ipt-txt laydate-icon" onclick="laydate();">
                    </div>
                    <span class="item-txt col-2"><i class="line-icon"></i></span>
                    <div class="ipt-box col-5">
                        <input type="text" class="ipt-txt laydate-icon" onclick="laydate();">
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5"> 审核状态：</label>
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
        </div>
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5"> 审核时间：</label>
                <div class="col-6">
                    <div class="ipt-box col-5">
                        <input type="text" class="ipt-txt laydate-icon" onclick="laydate();">
                    </div>
                    <span class="item-txt col-2"><i class="line-icon"></i></span>
                    <div class="ipt-box col-5">
                        <input type="text" class="ipt-txt laydate-icon" onclick="laydate();">
                    </div>
                </div>
            </div>

        </div>
        <div class="form-item clearfix">
            <div class="btn-box">
                <input type="button" value="查 询" class="btn mr20">
                <input type="button" value="重 置" class="btn mr20">
            </div>
        </div>
    </div>
</div>
<div class="clearfix mb5 mt20">
    <p class="fl"><input type="button" class="btn btn-sm" value="导出"></p>
</div>
<div>
    <table border="0" cellspacing="0" cellpadding="0" class="table-row mt30">
        <tbody>
        <tr>
            <th>序号</th>
            <th>操作</th>
            <th>审核状态 </th>
            <th>案源名称</th>
            <th>案件来源</th>
            <th>案源登记时间</th>
            <th>案源录入人员单位</th>
            <th>案源录入人员姓名</th>
            <th>立案状态</th>
            <th>审核时间</th>
        </tr>
        <tr>
            <td>1</td>
            <td><a href="#">修改</a><a href="#">删除</a></td>
            <td>无证无照</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>

        </tr>
        <tr>
            <td>2</td>
            <td><a href="#">查看</a></td>
            <td></td>
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
<script src="/js/lib/laydate/laydate.js"></script>
</body>
</html>