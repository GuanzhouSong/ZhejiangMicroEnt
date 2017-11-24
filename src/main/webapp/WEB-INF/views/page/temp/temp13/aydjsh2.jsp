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
<div class="print-nocard">
    <h3>案源登记审核</h3>
</div>
<div class="clearfix mb5">
    <p class="fl"><input type="button" class="btn btn-sm mr5" value="新增"></p>
</div>
<div class="mb10">
    <table border="0" cellspacing="0" cellpadding="0" class="table-row mt30">
        <tbody>
        <tr>
            <th>序号</th>
            <th>操作</th>
            <th>当事人名称 </th>
            <th>当事人类型</th>
            <th>法定代表人</th>
            <th>法定代表人证件号码</th>
            <th>统一信用代码/注册号</th>
            <th>经营地址</th>
            <th>联系电话</th>
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
        </tr>
        </tbody>
    </table>
</div>
<h6 class="mb5 h6-title">案源基本信息</h6>
<div class="form-box">
    <div class="form-list">
        <div class="form-item clearfix">
            <label class="item-name col-2">案源名称：</label>
            <div class="col-8">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt">
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2">案件类型：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <select name="">
                        <option value=""></option>
                        <option value=""></option>
                        <option value=""></option>
                    </select>
                </div>
            </div>
            <label class="item-name col-2">案源登记时间：</label>
            <div class="col-3">

            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2">案源登记内容：</label>
            <div class="col-8">
                <div class="ipt-box">
                    <textarea name="" id="" rows="5"></textarea>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2">案源录入人员姓名：</label>
            <div class="col-3">

            </div>
            <label class="item-name col-2">案源录入人员单位：</label>
            <div class="col-3">

            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2">备份：</label>
            <div class="col-8">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt">
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2">审核结果：</label>
            <div class="col-2">
                <div class="radio-box">
                    <label for=""><input type="radio">通过</label>
                    <label for=""><input type="radio">不通过</label>
                </div>
            </div>
            <label class="item-name col-2">审核人员：</label>
            <div class="col-2">

            </div>
            <label class="item-name col-2">审核日期：</label>
            <div class="col-2">

            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2">审核意见：</label>
            <div class="col-8">
                <div class="ipt-box">
                    <textarea name="" id="" rows="5"></textarea>
                </div>
            </div>
        </div>

    </div>
</div>
<div class="form-item clearfix">
    <div class="btn-box">
        <input type="submit" value="打 印" class="btn mr20">
        <input type="submit" value="提交审核" class="btn mr20">
        <input type="submit" value="返 回" class="btn">
    </div>
</div>
<script src="/js/lib/laydate/laydate.js"></script>
</body>
</html>