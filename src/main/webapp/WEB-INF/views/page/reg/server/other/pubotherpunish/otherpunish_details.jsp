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
    .center {
        text-align: center;
    }
</style>
<body class="pd10">
<div>
      <input type="hidden" id="userType" value="${userType }">
    <input id="viewType" type="hidden" value="${viewType}">
    <div class="audit" style="display: none">
        <!--处罚类型 -->
        <input type="hidden" id="penType" value="${pubOtherpunishHis.penType}">
        <div>
            <h1 class="h4-title left mt5">行政处罚</h1>
            <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
                <tr>
                    <td width="15%" class="bg-gray right">注册号:</td>
                    <td width="35%">
                        ${pubOtherpunishHis.regNO}
                    </td>
                    <td width="20%" class="bg-gray right">企业名称:</td>
                    <td width="30%">
                        ${pubOtherpunishHis.entName}
                    </td>
                </tr>
                <tr>
                    <td width="20%" class="bg-gray right">处罚决定书文号:</td>
                    <td width="35%">
                        ${pubOtherpunishHis.penDecNo}
                    </td>
                    <td width="15%" class="bg-gray right">违法行为类型:</td>
                    <td width="30%">
                        ${pubOtherpunishHis.illegActType}
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right">行政处罚内容</td>
                    <td colspan="3">
                    <div class="ipt-box pd0">
	                <textarea id="penContent" class="ipt-txt"  rows="" style="width:100%;height: 130px" readonly="readonly">${pubOtherpunishHis.penContent}</textarea>
	                </div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right">处罚类型</td>
                    <td colspan="3" id="penTypeShow">
                    </td>
                </tr>
                <tr>
                    <td width="20%" class="bg-gray right penAm" style="display: none">罚款金额（万元）:</td>
                    <td width="35%" class="penAm" style="display: none">
                        ${pubOtherpunishHis.penAm}
                    </td>
                    <td width="15%" class="bg-gray right forfAm" style="display: none">没收金额（万元）:</td>
                    <td width="30%" class="forfAm" style="display: none">
                        ${pubOtherpunishHis.forfAm}
                    </td>
                </tr>
                <tr>
                    <td width="20%" class="bg-gray right">处罚决定日期:</td>
                    <td width="35%">
                        <fmt:formatDate value="${pubOtherpunishHis.penDecIssDate}" pattern="yyyy-MM-dd"/>
                    </td>
                    <td width="15%" class="bg-gray right">处罚决定机关:</td>
                    <td width="30%">
                        ${pubOtherpunishHis.judAuth}
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right">公示状态</td>
                    <td colspan="3">
                        <c:if test="${pubOtherpunishHis.pubFlag =='1'}">已公示</c:if>
                        <c:if test="${pubOtherpunishHis.pubFlag =='0'}">未公示</c:if>
                    </td>
                </tr>
            </table>
        </div>

        <div style="position: relative;margin-top: 15px">
            <h1 class="h4-title left mt5">审核信息</h1>
            <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
                <tr>
                    <td width="15%" class="bg-gray right">录入人:</td>
                    <td width="35%">
                        ${pubOtherpunishHis.setName}
                    </td>
                    <td width="20%" class="bg-gray right">录入日期:</td>
                    <td width="30%">
                        <fmt:formatDate value="${pubOtherpunishHis.setDate}" pattern="yyyy-MM-dd"/>
                    </td>
                </tr>
                <tr>
                    <td width="20%" class="bg-gray right">审核人:</td>
                    <td width="35%">
                        ${pubOtherpunishHis.auditName}
                    </td>
                    <td width="15%" class="bg-gray right">审核日期:</td>
                    <td width="30%">
                        <fmt:formatDate value="${pubOtherpunishHis.auditDate}" pattern="yyyy-MM-dd"/>
                    </td>
                </tr>
                <tr>
                    <td width="20%" class="bg-gray right">审核结果:</td>
                    <td width="35%">
                        <c:if test="${pubOtherpunishHis.auditState=='1'}">审核通过</c:if>
                        <c:if test="${pubOtherpunishHis.auditState=='2'}">审核不通过</c:if>
                    </td>
                    <td width="15%" class="bg-gray right">审核意见:</td>
                    <td width="30%">
                        ${pubOtherpunishHis.auditOpin}
                    </td>
                </tr>
            </table>
        </div>
    </div>
    <div class='alter' style="position:relative;display: none">
        <h1 class="h4-title left mt5">变更信息</h1>
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
            <tr>
                <td width="20%" class="bg-gray right">处罚变更日期:</td>
                <td width="35%">
                    <fmt:formatDate value="${pubOtherPunishAlter.altDate}" pattern="yyyy-MM-dd"/>
                </td>
                <td width="20%" class="bg-gray right">处罚变更机关:</td>
                <td width="30%">
                    ${pubOtherPunishAlter.judAuth}
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">变更内容:</td>
                <td colspan="3">
                    ${pubOtherPunishAlter.contents}
                </td>
            </tr>
        </table>
    </div>
    <div class="clearfix mt10 mb20">
        <div class="center">
            <button id="cancel" type="button" class="btn btn-primary">取消</button>
        </div>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/other/otherpunish/otherpunish_details_main.js"></script>
</body>
</html>