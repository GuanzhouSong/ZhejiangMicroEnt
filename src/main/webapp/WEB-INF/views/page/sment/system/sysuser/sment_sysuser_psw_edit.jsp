<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

	<title>修改密码页面</title>
	<link rel="stylesheet" href="/css/sment/sment.server.css">
</head>

<body>
<form id="psw_edit">
    <div class="pd20 clearfix">
        <h3 class="h3-title center"></h3>
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal table-sment">
            <tr>
                <td class="right" width="22%"><span class="light"></span><i class="login-icon"></i>登录名</td>
                <td colspan="3">
                    <div class="ipt-box pd0">
                        <input type="hidden" name="id" value="${sysUser.id}"/>
                        <input type="text" id="username" readonly name="username" value="${sessionScope.session_sys_user.username}" class="ipt-txt"/>
                    </div>
                </td>
            </tr>
			<tr>
				<td class="right" width="22%"><i class="password-icon"></i>原密码</td>
				<td colspan="3">
					<div class="ipt-box pd0">
						<input type="password" name="password" id="sysUserPsw" class="ipt-txt" maxlength="20"  />
					</div>
				</td>
			</tr>
			<tr>
				<td class="right" width="22%"><i class="password-icon"></i>新密码</td>
				<td colspan="3">
					<div class="ipt-box pd0">
						<input type="password" name="sysUserPswNew" id="sysUserPswNew"    class="ipt-txt required"  maxlength="20"/><span id="sysUserPswNewMsg" class="msg"></span>
					</div>
				</td>
			</tr>
			<tr>
				<td class="right" width="22%"><i class="password-icon"></i>再次输入新密码</td>
				<td colspan="3">
					<div class="ipt-box pd0">
						<input type="password" name="sysUserPswNewAgain" id="sysUserPswNewAgain"  class="ipt-txt required" maxlength="12"  /><span id="sysUserPswNewAgainMsg" class="msg"></span>
					</div>
				</td>
			</tr>

        </table>
        <p class="center mt10"><input type="button" id="save" class="btn mr40" value="提 交"/><input type="button" class="btn" value="取 消" id="cancel"/></p>
    </div>
</form>

    </div>
	<script src="/js/lib/require.js"></script>
	<script src="/js/config.js"></script>
	<script src="/js/sment/system/sysuser/sment_psw_edit.js"></script>
</body>
</html>