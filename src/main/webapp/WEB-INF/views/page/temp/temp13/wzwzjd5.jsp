<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>无证无照建档</title>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<table cellspacing="0" cellpadding="0" border="0" class="table-horizontal" width="100%">
    <tr>
        <td class="bg-gray" align="right" width="15%">
            <span class="light">*</span>当事人姓名
        </td>
        <td width="35%">
            <div class="ipt-box">
                <input type="text" class="ipt-txt">
            </div>
        </td>
        <td class="bg-gray" align="right" width="15%">
            身份证号码
        </td>
        <td width="35%">
            <div class="ipt-box">
                <input type="text" class="ipt-txt">
            </div>
        </td>
    </tr>
    <tr>
        <td class="bg-gray" align="right">
            经营时所使用的名称
        </td>
        <td>
            <div class="ipt-box">
                <input type="text" class="ipt-txt">
            </div>
        </td>
        <td class="bg-gray" align="right">
            当事人联系电话
        </td>
        <td>
            <div class="ipt-box">
                <input type="text" class="ipt-txt">
            </div>
        </td>
    </tr>
    <tr>
        <td class="bg-gray" align="right">
            社会信用代码/注册号
        </td>
        <td>
            <div class="ipt-box">
                <input type="text" class="ipt-txt">
            </div>
        </td>
        <td class="bg-gray" align="right">
            法定代表人
        </td>
        <td>
            <div class="ipt-box">
                <input type="text" class="ipt-txt">
            </div>
        </td>
    </tr>
    <tr>
        <td class="bg-gray" align="right">登记状态</td>
        <td>
            <span class="light">吊销未注销  </span>
        </td>
        <td class="bg-gray" align="right">经营期限至</td>
        <td>
            <span class="light">2016-04-30  </span>
        </td>
    </tr>
    <tr>
        <td class="bg-gray" align="right"><span class="light">*</span>管辖单位</td>
        <td>
            <div class="display-table">
                <span class="table-cell vm">登记事项；企业公示；广告管理；商标管理</span>
                <span class="table-cell right vm"><input type="button" class="btn btn-xs" value="选择"></span>
            </div>
        </td>
        <td class="bg-gray" align="right">片区/商圈</td>
        <td>
            <div class="display-table">
                <span class="table-cell vm">登记事项；企业公示；广告管理；商标管理</span>
                <span class="table-cell right vm"><input type="button" class="btn btn-xs" value="选择"></span>
            </div>
        </td>
    </tr>
    <tr>
        <td class="bg-gray" align="right"><span class="light">*</span>监管项目</td>
        <td colspan="3">
            <div class="display-table">
                <span class="table-cell vm">登记事项；企业公示；广告管理；商标管理</span>
                <span class="table-cell right vm"><input type="button" class="btn btn-xs" value="选择"></span>
            </div>
        </td>
    </tr>
</table>
<div class="form-box">
    <table cellspacing="0" cellpadding="0" border="0" class="table-horizontal table-noborder table-nobg" width="100%">
        <tr>
            <td align="right" width="15%">
                <span class="light">*</span>无证无照类型：
            </td>
            <td>
                <div class="ipt-box col-5">
                    <select name="">
                        <option value=""></option>
                        <option value=""></option>
                        <option value=""></option>
                    </select>
                </div>
            </td>
        </tr>
        <tr>
            <td align="right" width="15%">
                <span class="light">*</span>是否涉及：
            </td>
            <td>
                <div class="radio-box">
                    <label><input type="checkbox">涉及前置许可</label>
                    <label><input type="checkbox">涉及后置许可</label>
                    <label><input type="checkbox">不涉及</label>
                </div>
            </td>
        </tr>
        <tr>
            <td align="right" width="15%">
                <span class="light">*</span>经营内容：
            </td>
            <td>
                <div class="ipt-box col-10">
                    <input type="text" class="fl ipt-txt">
                        <span class="add-icon">
                            <i></i>
                        </span>
                </div>
            </td>
        </tr>
        <tr>
            <td align="right" width="15%">
                <span class="light">*</span>经营地点：
            </td>
            <td>
                <div class="ipt-box">
                    <div class="col-2">
                        <div class="mr10">
                            <select name="">
                                <option value=""></option>
                                <option value=""></option>
                                <option value=""></option>
                            </select>
                        </div>
                    </div>
                    <div class="col-2">
                        <div class="mr10">
                            <select name="">
                                <option value=""></option>
                                <option value=""></option>
                                <option value=""></option>
                            </select>
                        </div>
                    </div>
                    <div class="col-2">
                        <div class="mr10">
                            <select name="">
                                <option value=""></option>
                                <option value=""></option>
                                <option value=""></option>
                            </select>
                        </div>
                    </div>
                    <div class="col-4">
                        <input type="text" class="ipt-txt">
                    </div>
                </div>
            </td>
        </tr>
    </table>
</div>
<div class="clearfix mb5 mt20">
    <h3 class="h3-title fl mr10 mt5">无证记录</h3><p class="fl"><input type="button" class="btn btn-sm mr5" value="添加"></p>
</div>
<div>
    <table border="0" cellspacing="0" cellpadding="0" class="table-row mt30">
        <tbody>
        <tr>
            <th width="7%">序号</th>
            <th width="20%">涉及许可证类型  </th>
            <th width="20%"> 涉及许可证名称</th>
            <th>许可证状况说明</th>
            <th width="13%">录入人</th>
            <th width="7%">录入时间</th>
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
<div class="clearfix mb5 mt20">
    <h3 class="h3-title fl mr10 mt5">发现记录</h3><p class="fl"><input type="button" class="btn btn-sm mr5" value="添加"></p>
</div>
<div>
    <table border="0" cellspacing="0" cellpadding="0" class="table-row mt30">
        <tbody>
        <tr>
            <th width="7%">序号</th>
            <th width="20%">发现时间    </th>
            <th width="20%"> 发现人 </th>
            <th>发现途径 </th>
            <th>情况说明 </th>
            <th width="13%">录入人</th>
            <th width="7%">录入时间</th>
        </tr>
        <tr>
            <td>1</td>
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
<div class="clearfix mb5 mt20">
    <h3 class="h3-title fl mr10 mt5">处理记录</h3><p class="fl"><input type="button" class="btn btn-sm mr5" value="添加"></p>
</div>
<div>
    <table border="0" cellspacing="0" cellpadding="0" class="table-row mt30">
        <tbody>
        <tr>
            <th width="7%">序号</th>
            <th width="20%">处理日期</th>
            <th width="20%"> 处理措施 </th>
            <th>经办人</th>
            <th>情况说明 </th>
            <th width="13%">录入人</th>
            <th width="7%">录入时间</th>
        </tr>
        <tr>
            <td>1</td>
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
<div class="form-box mt10">
    <div class="form-list">
        <div class="form-item clearfix">
            <div class="col-5">
                <label class="item-name col-5">经办人：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt">
                    </div>
                </div>
            </div>
            <div class="col-5">
                <label class="item-name col-5"> 经办时间：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt">
                    </div>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <div class="col-5">
                <label class="item-name col-5">录入人：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt">
                    </div>
                </div>
            </div>
            <div class="col-5">
                <label class="item-name col-5"> 录入时间：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="clearfix mt10">
    <div class="btn-box">
        <input type="button" value="保 存" class="btn mr20">
        <input type="button" value="返 回" class="btn">
    </div>
</div>
</body>
</html>