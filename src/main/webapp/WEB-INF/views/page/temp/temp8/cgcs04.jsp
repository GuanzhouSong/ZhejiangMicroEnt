<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <div class="tab-header tab-chaogao">
        <ul class="clearfix">
            <li class="tab-selected"><span class="tab-item">我发起的抄告抄送</span></li>
            <li><span class="tab-item">我接收的抄告抄送</span></li>
        </ul>
    </div>
    <div class="tab-content mb20">
        <div class="tab-panel">
            <div class="form-box">
                <div class="form-list">
                    <div class="form-item clearfix">
                        <div class="col-4">
                            <label class="item-name col-5">抄告主题检索：</label>
                            <div class="col-7">
                                <div class="ipt-box col-8">
                                    <input type="text" class="ipt-txt">
                                </div>
                            </div>

                        </div>
                        <div class="col-4">
                            <label class="item-name col-5">抄告信息来源：</label>
                            <div class="col-7">
                                <div class="ipt-box col-8">
                                    <select>
                                        <option>已抄告反馈完成</option>
                                        <option>已抄告反馈完成</option>
                                        <option>已抄告反馈完成</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <label class="item-name col-5">抄告类型：</label>
                            <div class="col-7">
                                <div class="ipt-box col-8">
                                    <select>
                                        <option>已抄告反馈完成</option>
                                        <option>已抄告反馈完成</option>
                                        <option>已抄告反馈完成</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-item clearfix">
                        <div class="col-4">
                            <label class="item-name col-5">涉嫌违法事项：</label>
                            <div class="col-7">
                                <div class="ipt-box col-8">
                                    <select>
                                        <option></option>
                                        <option></option>
                                        <option></option>
                                    </select>
                                </div>
                            </div>

                        </div>
                        <div class="col-4">
                            <label class="item-name col-5">涉嫌违法当事人：</label>
                            <div class="col-7">
                                <div class="ipt-box col-8">
                                    <input type="text" class="ipt-txt">
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <label class="item-name col-5"> 是否需要反馈：</label>
                            <div class="col-7">
                                <div class="ipt-box col-8">
                                    <select>
                                        <option></option>
                                        <option></option>
                                        <option></option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-item clearfix mb12">
                        <div class="col-4">
                            <label class="item-name col-5">抄告接收部门：</label>
                            <div class="col-7">
                                <div class="ipt-box col-8">
                                    <select>
                                        <option></option>
                                        <option></option>
                                        <option></option>
                                    </select>
                                </div>
                            </div>

                        </div>
                        <div class="col-4">
                            <label class="item-name col-5">抄告发起人：</label>
                            <div class="col-7">
                                <div class="ipt-box col-8">
                                    <select>
                                        <option></option>
                                        <option></option>
                                        <option></option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <label class="item-name col-5">抄告状态：</label>
                            <div class="col-7">
                                <div class="ipt-box col-8">
                                    <select>
                                        <option></option>
                                        <option></option>
                                        <option></option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-item clearfix">
                        <div class="col-4">
                            <label class="item-name col-5">抄告发起日期：</label>
                            <div class="col-7">
                                <div class="ipt-box col-5">
                                    <input type="text" class="ipt-txt laydate-icon" onclick="laydate();">
                                </div>
                                <span class="item-txt">到</span>
                                <div class="ipt-box col-5">
                                    <input type="text" class="ipt-txt laydate-icon" onclick="laydate();">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-item clearfix">
                        <div class="btn-box">
                            <input type="submit" value="查 询" class="btn mr20">
                            <input type="button" value="重 置" class="btn">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="clearfix mb5">
    <p class="fl"><input type="button" class="btn btn-sm mr5" value="导出"><input type="button" class="btn btn-sm"
                                                                                value="打印"></p>
    <span class="light-yellow fr mt15">共发起30条抄告抄送，其中3条待反馈，27条已反馈</span>
</div>

<div class="table-out">
    <table border="0" cellspacing="0" cellpadding="0" class="table-row mt30">
        <tbody>
        <tr>
            <th width="4%">序号</th>
            <th width="6%">操作</th>
            <th width="7%">抄告状态</th>
            <th width="7%">抄告类型</th>
            <th width="13%">抄告接收部门</th>
            <th width="13%">涉嫌违法事项</th>
            <th width="13%">抄告单编号</th>
            <th width="13%">抄告信息来源</th>
            <th width="9%">是否需要反馈</th>
            <th width="13%">涉嫌违法当事人</th>
        </tr>
        <tr>
            <td>1</td>
            <td>处理</td>
            <td>待审核</td>
            <td>无证无照</td>
            <td>桐庐县工商局</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
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
            <td></td>
            <td></td>
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
            <td></td>
            <td></td>
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
            <td></td>
            <td></td>
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
            <td></td>
            <td></td>
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
            <td></td>
            <td></td>
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
            <td></td>
            <td></td>
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
            <td></td>
            <td></td>
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
            <td></td>
            <td></td>
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
<div class="layder-hd">
    <div class="form-list send-message">
        <div class="form-item clearfix">
            <label class="item-name col-3">无证无照类型：</label>
            <div class="col-6">
                <div class="radio-box">
                    <label><input type="radio">无证</label>
                    <label><input type="radio">无照</label>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3">企业名称：</label>
            <div class="col-6">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" placeholder="请输入企业名称">
                </div>
            </div>

        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3">证件类型：</label>
            <div class="col-6">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt">
                </div>
            </div>

        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3">证件号：</label>
            <div class="col-6">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt">
                </div>
            </div>

        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3">当事人地址：</label>
            <div class="col-6">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt">
                </div>
            </div>

        </div>
        <div class="form-item clearfix mb20">
            <label class="item-name col-3">当事人联系电话：</label>
            <div class="col-6">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt">
                </div>
            </div>
        </div>
        <div class="form-item clearfix col-offset-3">
            <div class="ml60">
                <input type="submit" value="校 验" class="btn">
            </div>
        </div>
    </div>
</div>
<script src="/js/lib/laydate/laydate.js"></script>
</body>
</html>