<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>信息提供在线录入小微企业扶持信息新增</title>
    <link rel="stylesheet" href="/css/pub-syn.css">
</head>
<body>
<div class="popup-box">
    <div class="title">添加小微企业扶持信息</div>
    <form id="js-form">
        <div class="popup-hd">
            <!-- 企业名称 -->
            <input type="hidden" name="entName" value="${param.entName}">
            <!-- 统一社会信用代码 -->
            <input type="hidden" name="uniScid" value="${param.uniScid}">
            <input type="hidden" name="checkState" value="1">
            <!-- 注册号 -->
            <input type="hidden" name="regNO" value="${param.regNO}">
            <table cellpadding="0" cellspacing="0" border="0" width="100%" class="popup-table">
                <tr>
                    <td align="right">部门</td>
                    <td><input type="text" class="ipt-txt" name="depName" required></td>
                </tr>
                <tr>
                    <td align="right">扶持内容</td>
                    <td><input type="text" name="helpContent" required></td>
                </tr>
                <tr>
                    <td align="right">扶持日期</td>
                    <td><input type="text" name="helpDate" class="js-helpDate-date" required></td>
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
<script src="/js/depsyn/small/small_add_main.js"></script>
</body>
</html>