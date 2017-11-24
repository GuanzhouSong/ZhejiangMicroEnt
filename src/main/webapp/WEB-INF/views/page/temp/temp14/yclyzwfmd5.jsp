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
<div class="clearfix mb5 mt5">
    <p class="fl">
        <input type="button" class="btn btn-sm" value="导出">
    </p>
    <span class="light-yellow fr mt5">列入严违名单：共245家</span>
</div>
<div>
    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="table-row">
        <thead>
        <tr>
            <th>序号</th>
            <th>操作</th>
            <th> 统一代码/注册号</th>
            <th>企业名称</th>
            <th>法定代表人/负责人</th>
            <th>主体类别</th>
            <th>业务类型</th>
            <th> 业务状态</th>
            <th>列入异常原因</th>
            <th> 列入异常日期</th>
            <th> 异常届满前60日</th>
            <th> 异常届满日期</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>1<input type="checkbox"></td>
            <td><a href="#">修改</a><a href="#">删除</a></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><span class="light">待列入</span></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        </tbody>
    </table>
</div>
<h5 class="com-info-title left pdl10 mt10">列入严违信息<a href="javascript:void(0);" class="fr mr10">收起<i class="tran-icons"></i></a><a class="fr mr10" href="##">异常类列入严违历史记录</a></h5>
<table cellpadding="0" cellspacing="0" border="0" class="table-horizontal mb10">
    <tbody>
    <tr>
        <td class="bg-gray right" width="15%">列入严违原因</td>
        <td>
            <div class="ipt-box col-8">
                <select name="" id="">
                    <option value=""></option>
                    <option value=""></option>
                    <option value=""></option>
                </select>
            </div>
        </td>
    </tr>
    <tr>
        <td class="bg-gray right">
            列入严违说明
        </td>
        <td>
            <div class="max-height90">
                经查，该企业被列入经营异常名录届满3年仍未履行相关义务。**年*月*日，该企业因**（事由）被**工商（市场监管）局列入经营异常名录。截止**年*月*日已届满3年，仍未履行相关义务。以上事实有：1.**年*月*日《列入经营异常名录决定书》一份；2.**年*月*日浙江省企业信用信息公示平台《列入经营异常名录满3年提醒公告》一份；上述行为违反了《企业信息公示暂行条例》的相关规定。根据《严重违法失信企业名单管理暂行办法》第五条第一款第（一）项的规定，建议将其列入严重违法失信企业名单并予以公示。
            </div>
        </td>
    </tr>
    </tbody>
</table>
<h5 class="com-info-title left pdl10">审批意见信息</h5>
<table cellpadding="0" cellspacing="0" border="0" class="table-horizontal">
    <tbody>
    <tr>
        <td class="bg-gray right" width="15%">列入严违期限</td>
        <td width="25%"></td>
        <td class="bg-gray right" width="10%">经办人</td>
        <td width="20%"></td>
        <td class="bg-gray right" width="10%">申请日期</td>
        <td></td>
    </tr>
    </tbody>
</table>
<div class="btn-box mt20">
    <input type="button" id="search" value="提 交" class="btn mr10">
    <input type="reset" id="reset" value="取 消" class="btn">
</div>
</body>
</html>