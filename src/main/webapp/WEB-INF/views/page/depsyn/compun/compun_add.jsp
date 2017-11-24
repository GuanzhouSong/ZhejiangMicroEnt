<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>信息提供在线录入联合惩戒信息新增</title>
    <link rel="stylesheet" href="/css/pub-syn.css">
</head>
<body>
<div class="popup-box">
    <div class="title">添加联合惩戒信息</div>
    <form id="js-form">
        <div class="popup-hd">
            <table cellpadding="0" cellspacing="0" border="0" width="100%" class="popup-table">
                <tr>
                    <td align="right">证照号码/证件号码</td>
                    <td><input type="text" class="ipt-txt" name="comNO" required></td>
                </tr>
                <tr>
                    <td align="right">名称/姓名</td>
                    <td><input type="text" name="comName" required></td>
                </tr>
                <tr>
                    <td align="right">信息发送部门名称</td>
                    <td><input type="text" name="sendDepName" required></td>
                </tr>
                <tr>
                    <td align="right">信息接收部门名称</td>
                    <td><input type="text" name="recvDepName" required></td>
                </tr>
                <tr>
                    <td align="right">信息类型</td>
                    <td><input type="text" name="msgType" required></td>
                </tr>
                <tr>
                    <td align="right">限制法律依据</td>
                    <td><input type="text" name="limLegalBase" required></td>
                </tr>
                <tr>
                    <td align="right">法律描述</td>
                    <td><input type="text" name="legalDesc" required></td>
                </tr>
                <tr>
                    <td align="right">限制期限自</td>
                    <td><input type="text" name="valFrom" class="js-valFrom-date" required></td>
                </tr>
                <tr>
                    <td align="right">限制期限至</td>
                    <td><input type="text" name="valTo" class="js-valTo-date" required></td>
                </tr>
            </table>
        </div>
        <div class="popup-btn-box clearfix">
            <input id="js-cancel" type="button" value="关闭" class="ipt-btn fr mb3">
            <input id="js-confirm" type="submit" value="确认" class="ipt-btn fr mr10 mb3">
        </div>
    </form>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/depsyn/compun/compun_add_main.js"></script>
</body>
</html>