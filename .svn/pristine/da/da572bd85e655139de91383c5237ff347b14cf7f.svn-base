<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.Date" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>行政许可审核</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<div class="clearfix">
    <!--  <div class="bg-gray2 clearfix company-info-title"><h3 class="h3-title">杭州若泉贸易有限公司</h3>注册号：330104000299976</div>
     <h4 class="h4-title mt10">企业基本信息</h4> -->
    <div class="clearfix mb5 mt5">
        <p class="h4-title"> 许可信息</p>
    </div>
    <input type="hidden" id="userType" value="${userType }">
    <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
        <tr>
            <td class="bg-gray right" width="25%">注册号详情</td>
            <td>${pubOtherlicence.regNO }</td>
            <td class="bg-gray right" width="20%">企业名称</td>
            <td>${pubOtherlicence.entName }</td>

        </tr>
        <tr>
            <td class="bg-gray right">许可文件编号</td>
            <td>${pubOtherlicence.licNO }</td>
            <td class="bg-gray right">许可文件名称</td>
            <td>${pubOtherlicence.licNameCN }</td>
        </tr>
        <tr>
            <td class="bg-gray right">有效起止日期</td>
            <td><fmt:formatDate value="${pubOtherlicence.licValFrom }" pattern="yyyy-MM-dd"/>~
                <fmt:formatDate value="${pubOtherlicence.licValTo }" pattern="yyyy-MM-dd"/></td>
            <td class="bg-gray right">许可机关</td>
            <td>${pubOtherlicence.licAnth }</td>
        </tr>

        <tr>
            <td class="bg-gray right">许可内容(限制500字)</td>
            <td colspan="3">
                ${pubOtherlicence.licScope }
            </td>

        </tr>
    </table>

    <p class="h4-title">审核信息</p>
    <div class="pdr20">
        <form id="auditForm">
            <input type="hidden" name="licID" value="${pubOtherlicence.licID}">
            <input type="hidden" name="priPID" value="${pubOtherlicence.priPID}">
            <input type="hidden" name="licNO" value="${pubOtherlicence.licNO}">
            <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
                <tr>
                    <td class="bg-gray right" width="25%">录入人</td>
                    <td>${pubOtherlicence.setName}</td>
                    <td class="bg-gray right" width="20%">录入日期</td>
                    <td><fmt:formatDate value="${pubOtherlicence.setDate }" pattern="yyyy-MM-dd"/></td>

                </tr>
                <tr>
                    <td class="bg-gray right" width="25%">审核人</td>
                    <td>${pubOtherlicence.auditName}

                    </td>

                    <td class="bg-gray right" width="20%">审核日期</td>
                    <td><fmt:formatDate value="${pubOtherlicence.auditDate}" pattern="yyyy-MM-dd"/>

                    </td>

                </tr>

                <tr>
                    <td class="bg-gray right" width="25%">审核结果</td>
                    <td><label><input type="radio" disabled class="required" readonly
                                      <c:if test="${pubOtherlicence.auditState==1 }">checked</c:if> name="auditState"
                                      value="1">通过</label>
                        <label><input type="radio" disabled class="required" readonly
                                      <c:if test="${pubOtherlicence.auditState==2 }">checked</c:if> name="auditState"
                                      value="2">不通过</label></td>
                    <td class="bg-gray right" width="20%">审核意见</td>
                    <td> ${pubOtherlicence.auditOpin }</td>

                </tr>

            </table>

            <div class="form-item clearfix  ">
                <div class="btn-box mt20 pdr20">

                    <input type="button" value="关闭" id="cancel" class="btn">
                </div>
            </div>

            </table>
        </form>
    </div>
</div>
</body>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/other/otherlicence/otherlicence_detail_main.js"></script>
</html>