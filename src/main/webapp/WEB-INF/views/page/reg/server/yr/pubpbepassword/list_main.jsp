<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="nowdate" class="java.util.Date" />
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <title>个体户密码管理页面</title>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<!-- 头部 -->
<body>
<div class="pd10 clearfix" id="searchparam">
    <div class="form-box">
    <h4 class="h4-title pd10">登录密码与登录锁定查询  <span class="light">必须输入完整的注册号或名称</span></h4>
         <div class="form-list">
         <form id="taskForm">
            <div class="form-item clearfix col-offset-1">
                <div class="col-3">
                    <div class="item-name col-4">注册号：</div>
                    <div class="col-8">
                        <div class="ipt-box">
                            <input  type="text" id="searchregNO" class="ipt-txt">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="item-name col-6">统一社会信用代码：</div>
                    <div class="col-6">
                        <div class="ipt-box">
                            <input type="text" id="searchuniCode" class="ipt-txt">
                        </div>
                    </div>
                </div>

                <div class="col-5">
                    <div class="item-name col-3">企业名称：</div>
                    <div class="col-8">
                        <div class="ipt-box">
                            <input type="text" id="searchentName" class="ipt-txt">
                        </div>
                    </div>
                </div>
            </div>
        </form>
        </div>
        <div class="form-item clearfix mt10" id="search">
            <div class="btn-box">
                <input type="submit" value="查 询" class="btn mr20" id="sa">
                <input type="button" id="cancel" value="重 置" class="btn" onclick="$('#taskForm')[0].reset();">
            </div>
        </div>
    </div>
  <div id ="show" style="display: none;">
	<h4 class="h4-title light">登录密码与登录锁定设置</h4>
	<form id="pbpassWordForm">
	<input type="hidden" name="appReviewOrg" id="appReviewOrg" />
	<input type="hidden" name="UID" id="uid" />
	<input type="hidden" name="password" id="password" />
	<input type="hidden" name="username" id="username"/>
	<input type="hidden" name="liaIDNum" id="liaIDNum" />
	<input type="hidden" name="liaName" id="liaName" />	
	<input type="hidden" name="priPID" id="priPID" />	
	<input type="hidden" name="entName" id="entName" />	
	<input type="hidden" name="regNO" id="regNO" />	
	<input type="hidden" name="uniCode" id="uniCode" />		
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt20">
		<tr>
            <td class="bg-gray right" width="15%">企业名称</td>
            <td width="35%"><span id="_entName"></span></td>
            <td class="bg-gray right" width="15%">企业注册号</td>
            <td width="35%"><span id="_regNO"></td>
        </tr>
        <tr>
            <td class="bg-gray right">法定代表人姓名</td>
            <td><span id="_liaName"></td>
            <td class="bg-gray right">身份证件号码</td>
            <td><span id="_liaIDNum"></td>
        </tr>
        <tr>
            <td class="bg-gray right">登录密码</td>
            <td><span id="_password" class="light"></span><input type="button" class="save" id="saveBtndiv" value="生成密码"/></td>
            <td class="bg-gray right">接收手机</td>
            <td><div class="ipt-box col-6"><input type="text" class="ipt-txt" id="_tel" name="tel" ></div></td>
        </tr>
        <tr>
            <td class="bg-gray right">工商操作人部门</td>
            <td><span id="_appReviewOrg"></span></td>
            <td class="bg-gray right">工商操作人登录名</td>
            <td><span id="_username"></span></td>
        </tr>
        <tr>
            <td class="bg-gray right">设置日期</td>
            <td colspan="3"><fmt:formatDate value="${nowdate}" type="date" pattern="yyyy-MM-dd"/></td>
        </tr>
	</table>

	<p class="center mt10">
	  <input type="submit" class="btn mr20" value="保存" id="submit"/> 
      <input type="button" class="btn" value="取 消" id="cancelBtn" />
    </p>
   </form>
</div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/yr/pubpbepassword/list.js"></script>
</body>
</html>
