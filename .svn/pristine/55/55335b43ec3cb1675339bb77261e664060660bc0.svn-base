<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
<head>
 	<meta http-equiv="X-UA-Compatible" content="IE=8" >
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>异常状态查看明细</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<style>
    #unusualCatalog {
        padding: 0px;
        margin: 0px;
        overflow-x: hidden;
        overflow-y: auto;
        height: 100px;
    }

    .warn {
        background: #F00 !important;
        color: #FFF !important
    }

    #form select, #form textarea {
        background: #F4F8F9;
    }
</style>
<body class="pd10">
<div class="main">
    <h1 id="title"></h1>
    <form id="pubauditosaveform">
        <div class="listBox2 thBg">
            <div class="leftTop"></div>
            <div class="right1Top"></div>
            <table class="table-horizontal">
                <tr id="appBasic">
                    <td class="bg-gray right" width="100px">
                        <div class="tdBox">企业名称</div>
                    </td>
                    <td width="270px">
                        <div class="tdBox">${midBaseInfoDto.entName}</div>
                    </td>
                    <td class="bg-gray right" width="100px">
                        <div class="tdBox">注册号</div>
                    </td>
                    <td width="180px">
                        <div class="tdBox">${midBaseInfoDto.regNO}</div>
                    </td>
                    <td class="bg-gray right" width="100px">
                        <div class="tdBox">成立日期</div>
                    </td>
                    <td width="150px">
                        <div class="tdBox"><fmt:formatDate value="${midBaseInfoDto.estDate}" type="date"
                                                           pattern="yyyy-MM-dd"/></div>
                    </td>
                </tr>
                <tr id="appBasic">
                    <td class="bg-gray right">
                        <div class="tdBox">登记机关</div>
                    </td>
                    <td>
                        <div class="tdBox">${midBaseInfoDto.regOrgName}</div>
                    </td>
                    <td class="bg-gray right">
                        <div class="tdBox">法定代表人</div>
                    </td>
                    <td>
                        <div class="tdBox">${midBaseInfoDto.leRep}</div>
                    </td>
                    <td class="bg-gray right">
                        <div class="tdBox">联系电话</div>
                    </td>
                    <td>
                        <div class="tdBox">${midBaseInfoDto.tel}</div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right">
                        <div class="tdBox">管辖单位</div>
                    </td>
                    <td>
                        <div class="tdBox">${midBaseInfoDto.localAdmName}</div>
                    </td>
                    <td class="bg-gray right">
                        <div class="tdBox">联络员</div>
                    </td>
                    <td>
                        <div class="tdBox">${pubEppassword.lianame }</div>
                    </td>
                    <td class="bg-gray right">
                        <div class="tdBox">联络员电话</div>
                    </td>
                    <td>
                        <div class="tdBox">${pubEppassword.tel}</div>
                    </td>

                </tr>
            </table>
        </div>
        <br/>
        <div class="listBox2 thBg">
            <div class="leftTop"></div>
            <div class="rightTop"></div>
            <table width="100%" border="0" class="table-horizontal">
                <tr>
                    <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center">
                        <div class="tdBox"><font color="red"> </font>列入文号</div>
                    </td>
                    <td colspan="6">
                        <div class="tdBox"> ${pubOpanoMaly.penDecNo}</div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center">
                        <div class="tdBox"><font color="red"> </font>列入原因</div>
                    </td>
                    <td colspan="6">
                        <div class="tdBox"><c:if
                                test="${!empty pubOpanoMaly.year}">${pubOpanoMaly.year}年度</c:if> ${pubOpanoMaly.speCauseCN}</div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center">
                        <div class="tdBox"><font color="red"></font>事实和理由</div>
                    </td>
                    <td colspan="6">
                        <div class="tdBox">${pubOpanoMaly.anomalyRea}</div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center">
                        <div class="tdBox"><font color="red"> </font>初审意见</div>
                    </td>
                    <td colspan="6">
                        <div class="tdBox">${pubOpanoMaly.firstOpin}</div>
                    </td>
                </tr>
                <%--   <tr>
                      <td class="bg-gray right" width="100" valign="middle" class="lb_1" style="text-align:center"><div class="tdBox">作出决定日期</div></td>
                      <td width="180"><div class="tdBox"> <fmt:formatDate value="${pubOpanoMaly.abnTime}" type="date" pattern="yyyy-MM-dd"/></div></td>
                      <td class="bg-gray right" width="120"  colspan="2" valign="middle" class="lb_1" style="text-align:center"><div class="tdBox">注：局领导已在纸质材料上审批的，请录入领导审批日期，若尚未审批可不填写。</div></td>
                      <td class="bg-gray right" width="130" valign="middle" class="lb_1" style="text-align:center"><div class="tdBox">决定机关</div></td>
                      <td width="250" colspan="2"><div class="tdBox">${pubOpanoMaly.decorgCN}</div></td>
                  </tr> --%>
                <tr>
                    <td class="bg-gray right" width="100" valign="middle" class="lb_1" style="text-align:center">
                        <div class="tdBox">初审日期</div>
                    </td>
                    <td width="180">
                        <div class="tdBox"><fmt:formatDate value="${pubOpanoMaly.firstdate}" type="date"
                                                           pattern="yyyy-MM-dd"/></div>
                    </td>
                    <td class="bg-gray right" width="120" valign="middle" class="lb_1" style="text-align:center">
                        <div class="tdBox">初审人</div>
                    </td>
                    <td width="180">
                        <div class="tdBox">${pubOpanoMaly.firstName}</div>
                    </td>
                    <td class="bg-gray right" width="130" valign="middle" class="lb_1" style="text-align:center">
                        <div class="tdBox">初审部门</div>
                    </td>
                    <td width="250" colspan="2">
                        <div class="tdBox">${pubOpanoMaly.firstDept}</div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" width="100" valign="middle" class="lb_1" style="text-align:center">
                        <div class="tdBox">审核意见</div>
                    </td>
                    <td colspan="6">
                        <div class="radio-box">
                            <c:if test="${pubOpanoMaly.auditState=='1'}">
                                <input type="radio" disabled="disabled" checked="checked" id="auditStateY"
                                       name="auditState" value="1">予以列入经营异常名录
                                <input type="radio" disabled="disabled" id="auditStateN" name="auditState" value="2">不予以列入经营异常名录
                            </c:if>
                            <c:if test="${pubOpanoMaly.auditState=='2'}">
                                <input type="radio" disabled="disabled" checked="checked" id="auditStateY"
                                       name="auditState" value="1">予以列入经营异常名录
                                <input type="radio" disabled="disabled" checked="checked" id="auditStateN"
                                       name="auditState" value="2">不予以列入经营异常名录
                            </c:if>
                            <br>
                            ${pubOpanoMaly.auditOpin}
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" width="100" valign="middle" class="lb_1" style="text-align:center">
                        <div class="tdBox">审核日期</div>
                    </td>
                    <td width="180">
                        <div class="tdBox"><fmt:formatDate value="${pubOpanoMaly.auditDate}" type="date"
                                                           pattern="yyyy-MM-dd"/></div>
                    </td>
                    <td class="bg-gray right" width="120" valign="middle" class="lb_1" style="text-align:center">
                        <div class="tdBox">审核人</div>
                    </td>
                    <td width="180">
                        <div class="tdBox">${pubOpanoMaly.auditName}</div>
                    </td>
                    <td class="bg-gray right" width="130" valign="middle" class="lb_1" style="text-align:center">
                        <div class="tdBox">审核部门</div>
                    </td>
                    <td width="250" colspan="2">
                        <div class="tdBox">${pubOpanoMaly.auditDept}</div>
                    </td>
                </tr>
                <!-- <tr id="decisiontr" style="display: none">
                   <td class="bg-gray right" width="100" valign="middle" class="lb_1" style="text-align:center"><div class="tdBox">*生成决定书</div></td>
                   <td width="180" colspan="6"><div class="tdBox"><a style="text-decoration: underline;cursor: pointer;" onclick="doEnDecisionBook()">生成列入经营异常名录决定书</a></div></td>
                </tr> -->
            </table>
        </div>
    </form>
    <div class="center mt10">
        <input type="button" class="btn " id="cancel" value="关闭"/>
    </div>
</div>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/server/opanomaly/pubopanomaly/pubopanomalyent/pubopanomalyentaudit_edit_main.js"/>"></script>
</body>
</html>
<style type="text/css">
    table.gridtable {
        font-family: verdana, arial, sans-serif;
        font-size: 11px;
        color: #333333;
        border-width: 1px;
        border-color: #666666;
        border-collapse: collapse;
    }

    table.gridtable th {
        border-width: 1px;
        padding: 8px;
        border-style: solid;
        border-color: #666666;
        background-color: #dedede;
    }

    table.gridtable td {
        border-width: 1px;
        padding: 8px;
        border-style: solid;
        border-color: #666666;
        background-color: #ffffff;
    }
</style>