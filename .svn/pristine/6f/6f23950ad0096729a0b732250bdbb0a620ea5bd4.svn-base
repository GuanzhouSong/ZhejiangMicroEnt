<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>信息管理数据应用反馈新增</title>
    <link rel="stylesheet" href="/css/pub-syn.css">
</head>
<body>
<div class="popup-box">
    <div class="title">添加行政许可信息</div>
    <form id="hxForm">
    <div class="popup-hd">
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="popup-table">
            <tr>
                <td align="right">企业名称</td>
                <td>${csDepsynLicense.entName}</td>
            </tr>
            <tr>
                <td align="right">统一社会信用代码</td>
                <td>${csDepsynLicense.uniScid}</td>
            </tr>
            <tr>
                <td align="right">许可文件编号</td>
                <td><input type="text" name="licNO" value="${csDepsynLicense.licNO}"></td>
            </tr>
            <tr>
                <td align="right">许可文件名称</td>
                <td><input type="text" name="licName" value="${csDepsynLicense.licName}"></td>
            </tr>
            <tr>
                <td align="right">许可机关</td>
                <td><input type="text" name="licAnth" value="${csDepsynLicense.licAnth}"></td>
            </tr>
            <tr>
                <td align="right">登记状态</td>
                   <td><select name="regState">
                     <option value="有效"  ${csDepsynLicense.regState=='有效'?'selected':'' }>有效</option>
                     <option value="无效"  ${csDepsynLicense.regState=='无效'?'selected':'' }>无效</option>
                    </select>
                </td>
            </tr>
        </table>
    </div>
    <input type="hidden" name="id" value="${csDepsynLicense.id}">
    <div class="popup-btn-box clearfix">
        <input type="button" value="关闭" id="close" class="ipt-btn fr mb3">
        <input type="submit" value="提交" class="ipt-btn fr mr10 mb3">
    </div>
   </form>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/depsyn/licensemanage_edit.js"></script>
</body>
</html>