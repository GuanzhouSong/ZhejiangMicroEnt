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
            <label class="item-name col-2"> 当事人名称：</label>
            <div class="col-3">
                <div class="ipt-box col-6">
                    <input type="text" class="ipt-txt">
                </div>
                <div class="radio-box col-6" >
                    <label><input type="radio" class="ipt-txt">企业</label>
                    <label><input type="radio" class="ipt-txt">个体户</label>
                </div>
            </div>
            <label class="item-name col-2">统一信用代码/注册号：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt">
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2"> 管辖单位：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <select name="">
                        <option value=""></option>
                        <option value=""></option>
                        <option value=""></option>
                    </select>
                </div>
            </div>
            <label class="item-name col-2">登记机关：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <select name="">
                        <option value=""></option>
                        <option value=""></option>
                        <option value=""></option>
                    </select>
                </div>
            </div>
        </div>
        <div class="btn-box">
            <input type="button" value="查 询" class="btn mr20">
            <input type="button" value="重 置" class="btn mr20">
        </div>
    </div>
</div>
<div class="mt10">
    <table border="0" cellspacing="0" cellpadding="0" class="table-row mt30">
        <tbody>
        <tr>
            <th>序号</th>
            <th>当事人名称</th>
            <th>当事人类型 </th>
            <th>管辖单位</th>
            <th>登记机关</th>
            <th>法定代表人</th>
            <th>统一信用代码/注册号</th>
            <th>经营地址</th>
            <th>联系电话</th>
        </tr>
        <tr>
            <td><input type="checkbox">1</td>
            <td></td>
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
<div class="form-item clearfix">
    <div class="btn-box">
        <input type="submit" value="保 存" class="btn mr20">
        <input type="submit" value="取消编辑" class="btn">
    </div>
</div>
<script src="/js/lib/laydate/laydate.js"></script>
</body>
</html>