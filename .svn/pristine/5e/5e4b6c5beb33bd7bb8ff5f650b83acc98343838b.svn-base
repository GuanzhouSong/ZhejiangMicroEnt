<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title></title>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<style type="text/css">
</style>
<body class="pd10">
<div>
  <input type="hidden" id="userType" value="${userType }">
    <div class="">
        <div>
            <h1 class="h4-title left mt5">公示信息</h1>
            <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
                <tr>
                    <td width="15%" class="bg-gray right">注册号:</td>
                    <td width="35%">
                        ${pubOtherpunish.regNO}
                    </td>
                    <td width="15%" class="bg-gray right">企业名称:</td>
                    <td width="35%">
                        ${pubOtherpunish.entName}
                    </td>
                </tr>
                <tr>
                    <td width="15%" class="bg-gray right">处罚决定书文号:</td>
                    <td width="35%">
                        ${pubOtherpunish.penDecNo}
                    </td>
                    <td width="15%" class="bg-gray right">违法行为类型:</td>
                    <td width="35%">
                        ${pubOtherpunish.illegActType}
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right">行政处罚内容</td>
                    <td colspan="3">
                    <div class="ipt-box pd0">
	                <textarea id="penContent" class="ipt-txt"  rows="" style="width:100%;height: 130px" readonly="readonly">${pubOtherpunish.penContent}</textarea>
	                </div>
                    </td>
                </tr>
                <tr>
                    <td width="15%" class="bg-gray right">处罚决定日期:</td>
                    <td width="35%">
                        <fmt:formatDate value="${pubOtherpunish.penDecIssDate}" pattern="yyyy-MM-dd"/>
                    </td>
                    <td width="15%" class="bg-gray right">处罚决定机关:</td>
                    <td width="35%">
                        ${pubOtherpunish.judAuth}
                    </td>
                </tr>
            </table>
        </div>
    </div>

    <form id="alterForm">
        <input type="hidden" name="priPID" value="${pubOtherpunish.priPID}">
        <input type="hidden" name="caseNO" value="${pubOtherpunish.caseNO}">
        <div class='alter'>
            <h1 class=" h4-title left mt5">变更信息</h1>
            <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
                <tr>
                    <td width="20%" class="bg-gray right">处罚变更日期:</td>
                    <td width="35%">
                        <div class="ipt-box pd0">
                            <input type="text" class="ipt-txt w-120" onclick="laydate()"
                                   readonly="readonly" name="altDate" value="" required/>
                        </div>
                    </td>
                    <td width="20%" class="bg-gray right">处罚变更机关:</td>
                    <td width="30%">
                        <div class="ipt-box pd0">
                            <input type="text" id="" class="ipt-txt" name="judAuth" required>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right">变更内容:</td>
                    <td colspan="3">
                        <div class="ipt-box pd0">
                            <textarea id="punAlt"  name="contents" style="width:100%;height: 100px" class="ipt-txt" required></textarea>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
        <div class="clearfix mt10">
            <div class="center">
                <button id="save" type="submit" class="btn btn-primary mr20">保存</button>
                <button id="cancel" type="button" class="btn btn-primary">取消</button>
            </div>
        </div>
    </form>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/other/otherpunish/otherpunishinput_alter_main.js"></script>
</body>
</html>