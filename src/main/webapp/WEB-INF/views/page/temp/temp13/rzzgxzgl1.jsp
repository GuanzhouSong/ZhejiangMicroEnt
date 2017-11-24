<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>任职资格限制管理</title>
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">
<div class="form-box">
    <div class="form-list">
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5">限制类别：</label>
                <div class="col-7">
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
                <label class="item-name col-4"> 当事人名称：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt">
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-4">  限制期限：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
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
        </div>
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5">当事人证件类型：</label>
                <div class="col-7">
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
                <label class="item-name col-4"> 当事人证件号：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt">
                    </div>
                </div>
            </div>
        </div>
        <div class="form-item clearfix mt20">
            <div class="btn-box">
                <input type="button" value="查 询" class="btn mr20">
                <input type="button" value="重 置" class="btn">
            </div>
        </div>
    </div>
</div>
<div class="clearfix mb5 mt20">
    <p class="fl"><input type="button" class="btn btn-sm mr5" value="限制管理"><input type="button" class="btn btn-sm" value="导出"></p>
</div>
<div>
    <table border="0" cellspacing="0" cellpadding="0" class="table-row mt30">
        <tbody>
        <tr>
            <th width="7%">序号</th>
            <th width="20%">统一信用代码/注册号 </th>
            <th width="7%"> 企业名称</th>
            <th width="13%"> 法定代表人 </th>
            <th width="13%">住所</th>
            <th>案件详情</th>
        </tr>
        <tr>
            <td>1</td>
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