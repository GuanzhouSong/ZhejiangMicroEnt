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
<body>
  <input type="hidden" id="userType" value="${userType }">
<div class="pd10 clearfix">
    <!--  <div class="bg-gray2 clearfix company-info-title"><h3 class="h3-title">杭州若泉贸易有限公司</h3>注册号：330104000299976</div>
     <h4 class="h4-title mt10">企业基本信息</h4> -->
    <div class="clearfix mb5 mt5">
        <p class="h4-title"> 许可信息</p>
    </div>
    <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
        <tr>
            <td class="bg-gray right" width="25%">注册号</td>
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
            <td colspan="3"><textarea rows="9" cols="110" readonly>${pubOtherlicence.licScope }
            </textarea></td>

        </tr>
    </table>
    <div>
        <div class="clearfix mb5 mt5">
            <p class="h4-title">修改记录</p>
        </div>
        <table border="0" cellspacing="0" cellpadding="0" class="table-row mt30">
            <tbody>
            <tr>
                <th width="7%">序号</th>
                <th width="13%">修改日期</th>
                <th width="13%">修改人</th>
                <th width="7%">审核结果</th>
                <th width="8%">审核日期</th>
                <th width="13%">操作</th>
            </tr>

            <c:forEach items="${hisList}" var="item" varStatus="status">
                <tr>

                    <td>${status.index}</td>
                    <td><fmt:formatDate value="${item.setDate }" pattern="yyyy-MM-dd"/></td>
                    <td>${item.setName}</td>
                    <td>
                        <c:if test="${item.auditState=='1' }">审核通过</c:if>
                        <c:if test="${item.auditState=='2' }">审核不通过</c:if>

                    </td>
                    <td><fmt:formatDate value="${item.auditDate }" pattern="yyyy-MM-dd"/></td>
                    <td><a href="#" id="${item.hisNO }" class="js_detail">详情</a></td>

                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>


</div>
<div class="form-item clearfix">
    <div class="btn-box">

        <input type="button" id="cancel" value="关闭" class="btn">
    </div>
</div>

</body>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/other/otherlicence/otherlicence_detail_main.js"></script>
</html>