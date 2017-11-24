<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>行政指导录入页</title>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body>
<div class="pd20 clearfix">
    <h4 class="h4-title mt10">修改行政指导 某某企业</h4>
    <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mb10">
        <tbody>
        <tr>
            <td class="bg-gray right">统一信用代码/注册号</td>
            <td colspan="3">2416546784967</td>
            <td class="bg-gray right">企业名称</td>
            <td colspan="3"></td>
        </tr>
        <tr>
            <td class="bg-gray right"  width="12%">开始日期</td>
            <td width="15%">
                <div class="ipt-box col-12">
                    <input type="text" class="ipt-txt" value="">
                </div>
            </td>
            <td class="bg-gray right" width="10%">结束日期</td>
            <td width="15%">
                <div class="ipt-box col-12">
                    <input type="text" class="ipt-txt" value="">
                </div>
            </td>
            <td class="bg-gray right" width="10%">申请人</td>
            <td width="13%"></td>
            <td class="bg-gray right" width="10%">申请日期</td>
            <td></td>
        </tr>
        <tr>
            <td class="bg-gray right">行政指导项目</td>
            <td colspan="7">
                <div class="ipt-box col-2">
                    <select name="" id="">
                        <option value=""></option>
                        <option value=""></option>
                        <option value=""></option>
                    </select>
                </div>
            </td>
        </tr>
        </tbody>
    </table>
    <div class="bg-gray pdt30lr50b30">
        <div class="form-list2">
            <div class="form-item2">
                <div class="item-name2">你企业因</div>
                <div class="ipt-box2">
                    <input type="text" class="ipt-txt2">
                </div>
                <div class="item-name2">的情况，特对你企业提醒提示如下:</div>
            </div>
            <div class="form-item2 col-12">
                <div class="ipt-box2"><textarea rows="5"></textarea></div>
            </div>
            <div class="form-item2">
                <span class="item-name2">被充说明：</span>
                <div class="ipt-box2">
                    <input type="text" class="ipt-txt2">
                </div>
            </div>
            <div class="form-item2">
                <div class="item-name2">联系人：</div>
                <div class="ipt-box2">
                    <input type="text" class="ipt-txt2">
                </div>
                <div class="item-name2">联系电话：</div>
                <div class="ipt-box2 ">
                    <input type="text" class="ipt-txt2">
                </div>
                <div class="item-name2">出具日期：</div>
                <div class="ipt-box2 ">
                    <input type="text" class="ipt-txt2">
                </div>
            </div>
            <div class="form-item2">
                <div class="item-name2">登记机关：</div>
                <div class="ipt-box2">
                    <input type="text" class="ipt-txt2">
                </div>
                <div class="item-name2">管辖单位：</div>
                <div class="ipt-box2">
                    <input type="text" class="ipt-txt2">
                </div>
            </div>
        </div>
    </div>
    <div class="center">
        <input type="submit" class="btn mr20" value="保 存">
        <input type="button" class="btn" value="取 消">
    </div>
</div>
</body>
</html>