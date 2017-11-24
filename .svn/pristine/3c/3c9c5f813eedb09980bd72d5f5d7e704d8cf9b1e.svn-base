<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <title>个体户年报登录获取密码页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>
<form action="">
<div class="table-box">
    <table class="table-public table-web table-get-password" border="0" cellspacing="0" cellpadding="0">
        <tbody>
        <tr>
            <td width="258" class="bg">
                <strong class="light">*</strong>*统一社会信用代码（无则填注册号）
            </td>
            <td>
                <input type="text" class="ipt-txt" id="number_get"/>
                <strong class="light">号码涉及字母信息请大写输入</strong>
            </td>
        </tr>
        <tr>
            <td class="bg">
                名称字号
            </td>
            <td>
                <input type="text" class="ipt-txt ipt-txt-lg" id="entName" disabled="disabled"/>
            </td>
        </tr>
        <tr>
            <td class="bg">
                经营者姓名
            </td>
            <td>
                <input type="text" class="ipt-txt ipt-txt-lg" id="leRep" disabled="disabled"/>
            </td>
        </tr>
        <tr>
            <td class="bg">
                <strong class="light">*</strong>经营者身份证号码
            </td>
            <td>
                <input type="text" class="ipt-txt ipt-txt-lg" id="liaIDNum" disabled="disabled"/>
                <input style="display: none" id="cerNO"/>
            </td>
        </tr>
        <tr>
            <td class="bg">
                经营者手机号码
            </td>
            <td>
                <input type="text" class="ipt-txt" id="tel" disabled="disabled"/>
                <strong class="light">注：用于密码找回，请勿填错。</strong>
            </td>
        </tr>
        </tbody>
    </table>
    <div class="btn-box">
        <input type="button" value="获取密码" class="btn-common" id="getPassword">
        <input type="reset" value="重置" class="btn-common"  >
        <input type="button" value="取消" class="btn-common" id="close">
    </div>
</div>
</form>
</body>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/client/login/pblogin_main.js"></script>
</html>