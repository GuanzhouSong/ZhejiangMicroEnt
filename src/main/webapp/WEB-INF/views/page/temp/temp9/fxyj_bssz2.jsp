<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>预警标识设置</title>
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body>
<div class="pd20">
    <div class="print-nocard mb20">
        <h3>预警提示标识信息</h3>
    </div>
    <div class="form-list">
        <div class="form-item clearfix">
            <label class="item-name col-2">预警标识名称：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" placeholder="请输入企业名称">
                </div>
            </div>
            <label class="item-name col-2">预警标识类型：</label>
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
        <div class="form-item clearfix">
            <label class="item-name col-2"> 预警标识级别：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <select name="">
                        <option value=""></option>
                        <option value=""></option>
                        <option value=""></option>
                    </select>
                </div>
            </div>
            <label class="item-name col-2">预警标识有效期：</label>
            <div class="col-3">
                <div class="ipt-box col-5">
                    <input type="text" class="ipt-txt laydate-icon" onclick="laydate();">
                </div>
                <span class="item-txt col-2"><i class="line-icon"></i></span>
                <div class="ipt-box col-5">
                    <input type="text" class="ipt-txt laydate-icon" onclick="laydate();">
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2">预警标识内容：</label>
            <div class="col-8">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt">
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2"> 指定提示方式：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <select name="">
                        <option value=""></option>
                        <option value=""></option>
                        <option value=""></option>
                    </select>
                </div>
            </div>
            <label class="item-name col-2">指定提示部门：</label>
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
        <div class="form-item clearfix">
            <label class="item-name col-2"> 设置部门：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <select name="">
                        <option value=""></option>
                        <option value=""></option>
                        <option value=""></option>
                    </select>
                </div>
            </div>
            <label class="item-name col-2">设置时间：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <input type="text" class="ipt-txt laydate-icon" onclick="laydate();">
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2"> 设置部门联系人：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt">
                </div>
            </div>
            <label class="item-name col-2">联系电话：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt">
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2"> 传真：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt">
                </div>
            </div>
            <label class="item-name col-2">邮箱：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt">
                </div>
            </div>
        </div>
        <div class="form-item clearfix mt40">
            <div class="btn-box">
                <input type="submit" value="打 印" class="btn mr20">
                <input type="submit" value="提 交" class="btn mr20">
                <input type="submit" value="取消编辑" class="btn">
            </div>
        </div>
    </div>
</div>
<script src="/js/lib/laydate/laydate.js"></script>
</body>
</html>