<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>无证无照建档</title>
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">
<div class="form-box">
    <div class="form-list">
        <div class="form-item clearfix">
            <div class="col-5">
                <label class="item-name col-5">当事人：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt">
                    </div>
                </div>
            </div>
            <div class="col-7">
                <label class="item-name col-4"> 经营时所使用的名称：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt">
                    </div>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <div class="col-5">
                <label class="item-name col-5">证件号码：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt">
                    </div>
                </div>
            </div>
            <div class="col-7">
                <label class="item-name col-4"> 经营场所：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt">
                    </div>
                </div>
            </div>
        </div>
        <div class="form-item clearfix mt20">
            <div class="btn-box">
                <input type="button" value="查询对比" class="btn mr20">
                <input type="button" value="重 置" class="btn">
            </div>
        </div>
    </div>
</div>
<div class="clearfix mb5 mt20">
    <h3 class="h3-title fl mr10 mt5">无证无照库情况</h3><p class="fl"><input type="button" class="btn btn-sm mr5" value="新建档"><input type="button" class="btn btn-sm" value="打印"></p>
</div>
<div>
    <table border="0" cellspacing="0" cellpadding="0" class="table-row mt30">
        <tbody>
        <tr>
            <th width="7%">序号</th>
            <th width="7%">操作 </th>
            <th width="7%"> 当事人</th>
            <th>身份证号码</th>
            <th width="13%"></th>
            <th width="7%"></th>
            <th width="7%"></th>
            <th width="7%"></th>
            <th width="7%"></th>
            <th width="7%"></th>
        </tr>
        <tr>
            <td>1</td>
            <td><a href="#">抽取对象</a><a href="#">查看</a></td>
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
</body>
</html>