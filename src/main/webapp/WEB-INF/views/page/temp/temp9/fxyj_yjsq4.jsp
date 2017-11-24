<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>添加企业标识</title>
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body>
<div class="pd20">
    <div class="form-list">
        <div class="form-item clearfix">
            <div class="item-name col-1">审核意见：</div>
            <div class="ipt-box col-10">
                <textarea rows="4" id=""></textarea>
            </div>
        </div>
    </div>
    <div class="form-box">
        <div class="form-list">
            <div class="form-item clearfix">
                <label class="item-name col-10 right">批次编号：4444</label>
            </div>
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
        </div>
    </div>

    <div class="clearfix mb5 mt10">
        <p class="fl"><input type="button" class="btn btn-sm mr5" value="添加"><input type="button" class="btn btn-sm" value="批量删除"></p>
    </div>
    <div>
        <table border="0" cellspacing="0" cellpadding="0" class="table-row mt30">
            <tbody>
            <tr>
                <th width="7%">全选<input type="checkbox"/></th>
                <th>统一信用代码/注册号 </th>
                <th width="13%"> </th>
                <th width="13%"> </th>
                <th width="13%">  </th>
                <th width="7%"></th>
                <th width="8%"> </th>
                <th width="13%"></th>
                <th width="7%"></th>
            </tr>
            <tr>
                <td><input type="checkbox"/></td>
                <td>无证无照</td>
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

    <div class="form-item clearfix mt40">
        <div class="btn-box">
            <input type="submit" value="确 认" class="btn mr20">
            <input type="submit" value="取消申请" class="btn mr20">
            <input type="submit" value="返 回" class="btn">
        </div>
    </div>
</div>
<script src="/js/lib/laydate/laydate.js"></script>
</body>
</html>