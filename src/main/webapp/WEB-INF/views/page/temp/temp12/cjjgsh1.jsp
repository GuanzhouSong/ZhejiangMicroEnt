<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>抽查检查结果审核</title>
    <link rel="stylesheet" href="/css/syn.css">
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
                <label class="item-name col-5"> 登记机关：</label>
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
                <label class="item-name col-5">任务编号：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt">
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">任务名称：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt">
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5"> 管辖单位：</label>
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
                <label class="item-name col-5">检查主体类型：</label>
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
                <label class="item-name col-5">检查实施部门：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt">
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5"> 任务组织部门：</label>
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
                <label class="item-name col-5">任务期始：</label>
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
            <div class="col-4">
                <label class="item-name col-5">任务设置日期：</label>
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
        <div class="form-item clearfix mt20">
            <div class="btn-box">
                <input type="button" value="查 询" class="btn mr20">
                <input type="button" value="重 置" class="btn">
            </div>
        </div>
    </div>
</div>
<div class="clearfix mb5 mt20">
    <p><input type="button" class="btn btn-sm mr5" value="导出"><input type="button" class="btn btn-sm" value="打印"></p>
</div>
<div>
    <table border="0" cellspacing="0" cellpadding="0" class="table-row mt30">
        <tbody>
        <tr>
            <th width="7%">序号</th>
            <th width="7%">操作 </th>
            <th width="7%"> 审核状态   </th>
            <th>任务编号</th>
            <th width="13%"> 任务名称   </th>
            <th width="7%">统一信用代码/注册号  </th>
            <th width="7%">  企业名称   </th>
            <th width="7%"> 法定代表人 </th>
            <th width="7%">  成立日期</th>
            <th width="7%"> 住所</th>
        </tr>
        <tr>
            <td>1</td>
            <td><a href="#">抽取对象</a><a href="#">查看</a></td>
            <td>无证无照</td>
            <td>桐庐县工商局</td>
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