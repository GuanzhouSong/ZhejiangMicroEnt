<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>人员维护</title>
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body>
<div class="pd20 clearfix">
    <h3 class="h3-title center">新增维护人员</h3>
    <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10">
        <tr>
            <td class="bg-gray right" width="15%"><span class="light"> *</span>姓名</td>
            <td colspan="5">
                <div class="ipt-box col-6"><input type="text" class="ipt-txt"></div>
            </td>
        </tr>
        <tr>
            <td class="bg-gray right"><span class="light"> *</span>工作单位</td>
            <td colspan="5">
                <div class="ipt-box col-12"><input type="text" class="ipt-txt"></div>
            </td>
        </tr>
        <tr>
            <td class="bg-gray right">办公地址</td>
            <td colspan="5">
                <div class="ipt-box col-12"><input type="text" class="ipt-txt"></div>
            </td>
        </tr>
        <tr>
            <td class="bg-gray right"><span class="light"> *</span>所属部门(科室)</td>
            <td width="30%">
                <div class="ipt-box col-12">
                    <select>
                        <option>已抄告反馈完成</option>
                        <option>已抄告反馈完成</option>
                        <option>已抄告反馈完成</option>
                    </select>
                </div>
            </td>
            <td class="bg-gray right" width="15%">是否允许外网访问</td>
            <td colspan="3">
                <div class="radio-box pd0">
                    <label><input type="radio">无证</label>
                    <label><input type="radio">无照</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="bg-gray right"><span class="light"> *</span>职务</td>
            <td colspan="5">
                <div class="ipt-box col-6"><input type="text" class="ipt-txt"></div>
            </td>
        </tr>
        <tr>
            <td class="bg-gray right"><span class="light"> *</span>办公电话</td>
            <td colspan="5">
                <div class="ipt-box col-6"><input type="text" class="ipt-txt"></div>
                <div class="radio-box pd0 ml20 fl">
                    <label class="mr20"><input type="checkbox">是否公开</label>
                </div>
                <span class="ml20 light-gray">半角输入，多个号码以逗号隔开，示例：0571-88361151</span>
            </td>
        </tr>
        <tr>
            <td class="bg-gray right"><span class="light"> *</span>手机号码</td>
            <td colspan="5">
                <div class="ipt-box col-6"><input type="text" class="ipt-txt"></div>
                <span class="ml20 light-gray">半角输入，多个号码以逗号隔开，示例：13005718321,13805718858</span>
            </td>
        </tr>
        <tr>
            <td class="bg-gray right">电子邮箱</td>
            <td>
                <div class="ipt-box col-6"><input type="text" class="ipt-txt"></div>
            </td>
            <td class="bg-gray right">QQ号</td>
            <td colspan="3">
                <div class="ipt-box col-6"><input type="text" class="ipt-txt"></div>
            </td>
        </tr>
        <tr>
            <td class="bg-gray right"><span class="light"> *</span>登录名</td>
            <td colspan="5">
                <div class="ipt-box col-6"><input type="text" class="ipt-txt"></div>
                <span class="ml20 light-gray">2-16位字母和数据组合</span>
            </td>
        </tr>
        <tr>
            <td class="bg-gray right"><span class="light"> *</span>登录密码</td>
            <td colspan="5">
                <div class="ipt-box col-6"><input type="text" class="ipt-txt"></div>
                <span class="ml20 light-gray">2-16位字母和数据组合</span>
            </td>
        </tr>
        <tr>
            <td class="bg-gray right">证书序列号</td>
            <td colspan="5">
                <div class="ipt-box col-12"><input type="text" class="ipt-txt"></div>
            </td>
        </tr>
        <tr>
            <td class="bg-gray right"><span class="light"> *</span>数据查询范围</td>
            <td colspan="5">
                <div class="ipt-box col-12"><input type="text" class="ipt-txt"></div>
            </td>
        </tr>
        <tr>
            <td class="bg-gray right">有效期止</td>
            <td>
                <div class="ipt-box col-6">
                    <select>
                        <option>已抄告反馈完成</option>
                        <option>已抄告反馈完成</option>
                        <option>已抄告反馈完成</option>
                    </select>
                </div>
            </td>
            <td class="bg-gray right">设置人</td>
            <td width="17%">汇信维护人员</td>
            <td class="bg-gray right">设置日期</td>
            <td>2016-10-14</td>
        </tr>
        <tr>
            <td class="bg-gray right">岗位</td>
            <td colspan="5">
                <div class="radio-box pd0">
                    <label class="mr20"><input type="checkbox">外资年报操作员</label>
                    <label class="mr20"><input type="checkbox">外资信息查询员</label>
                    <label class="mr20"><input type="checkbox">外资信息录入员</label>
                    <label class="mr20"><input type="checkbox">外资业务管理员</label>
                    <label class="mr20"><input type="checkbox">内资业务管理员</label>
                    <label class="mr20"><input type="checkbox">省局管理员</label>
                    <label class="mr20"><input type="checkbox">内资年报操作员</label>
                    <label class="mr20"><input type="checkbox">系统管理员</label>
                    <label class="mr20"><input type="checkbox">内资信息录入员</label>
                    <label class="mr20"><input type="checkbox">内资信息查询员</label>
                </div>
            </td>
        </tr>
    </table>
    <p class="center mt10"><input type="button" class="btn mr20" value="保 存"/><input type="button" class="btn" value="取 消"/></p>
</div>
</body>
</html>