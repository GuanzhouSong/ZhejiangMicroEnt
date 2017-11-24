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
<body class="pd10">
<div>
    <div class="audit">
        <input type="hidden" id="userType" value="${userType }">
        <input type="hidden" id="executeItemHid" name="executeItem" value="${pubJusticeInfo.executeItem}">
        <div>
            <h1 class="h4-title left mt5">司法协助公示信息录入详情</h1>
            <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal 10">
                <tr>
                    <td width="35%" class="bg-gray right">股权所在企业统一代码/注册号</td>
                    <td width="65%">
                        ${pubJusticeInfo.uniSCID}
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right">股权所在企业名称</td>
                    <td>
                        ${pubJusticeInfo.entName}
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right"><span class="red">* </span>执行法院</td>
                    <td>
                        ${pubJusticeInfo.executionCourt}
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right"><span class="red">* </span>执行事项</td>
                    <td>
                        <c:if test="${pubJusticeInfo.executeItem == 1}">公示冻结股权、其他投资权益</c:if>
                        <c:if test="${pubJusticeInfo.executeItem == 2}">续行冻结股权、其他投资权益</c:if>
                        <c:if test="${pubJusticeInfo.executeItem == 3}">解除冻结股权、其他投资权益</c:if>
                        <c:if test="${pubJusticeInfo.executeItem == 4}">强制转让被执行人股权，办理有限责任公司股东变更登记</c:if>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right">司法协助公示通知书文号</td>
                    <td>
                        ${pubJusticeInfo.botRefNum}
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right"><span class="red">* </span>执行裁定书文号</td>
                    <td>
                        ${pubJusticeInfo.exeRulNum}
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right"><span class="red">* </span>执行通知书文号</td>
                    <td>
                        ${pubJusticeInfo.executeNo}
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right"><span class="red">* </span>被执行人</td>
                    <td>
                        ${pubJusticeInfo.inv}
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right"><span class="red">* </span>被执行人证照(证件)种类</td>
                    <td>
  						<c:forEach var="codeCertype" items="${codeCertypeList}" varStatus="">
							  <c:if test="${codeCertype.code == pubJusticeInfo.cerType}">
							      ${codeCertype.content}
							  </c:if>	
                       	</c:forEach>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right"><span class="red">* </span>被执行人证照(证件)号码</td>
                    <td>
                        ${pubJusticeInfo.cerNO}
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right"><span class="red">* </span>被执行人持有股权、其他投资权益的数额</td>
                    <td>
                        <fmt:formatNumber value="${pubJusticeInfo.froAm}" pattern="###,###,###,##0.0000"/>${pubJusticeInfo.froAuth}
                    </td>
                </tr>
                <tr class="commonType froType">
                    <td class="bg-gray right"><span class="red">* </span>冻结期限自</td>
                    <td>
                        <fmt:formatDate value="${pubJusticeInfo.froFrom}" pattern="yyyy-MM-dd"/>
                    </td>
                </tr>
                <tr class="commonType froType">
                    <td class="bg-gray right"><span class="red">* </span>冻结期限至</td>
                    <td>
                        <fmt:formatDate value="${pubJusticeInfo.froTo}" pattern="yyyy-MM-dd"/>
                    </td>
                </tr>
                <tr class="commonType froType">
                    <td class="bg-gray right"><span class="red">* </span>冻结期限</td>
                    <td>
                        ${pubJusticeInfo.frozDeadline}
                    </td>
                </tr>
                <tr class="commonType thawType">
                    <td class="bg-gray right"><span class="red">* </span>解除冻结日期</td>
                    <td>
                        <fmt:formatDate value="${pubJusticeInfo.thawDate}" pattern="yyyy-MM-dd"/>
                    </td>
                </tr>
                <tr class="commonType thawType froType">
                    <td class="bg-gray right"><span class="red">* </span>公示日期</td>
                    <td>
                        <fmt:formatDate value="${pubJusticeInfo.publicDate}" pattern="yyyy-MM-dd"/>
                    </td>
                </tr>
                <tr class="commonType alienType">
                    <td class="bg-gray right"><span class="red">* </span>受让人</td>
                    <td>
                        ${pubJusticeInfo.assInv}
                    </td>
                </tr>
                <tr class="commonType alienType">
                    <td class="bg-gray right"><span class="red">* </span>受让人证照(证件)种类</td>
                    <td>
                        <c:forEach var="codeCertype" items="${codeCertypeList}" varStatus="">
							  <c:if test="${codeCertype.code == pubJusticeInfo.assCerType}">
							      ${codeCertype.content}
							  </c:if>	
                       	</c:forEach>
                    </td>
                </tr>
                <tr class="commonType alienType">
                    <td class="bg-gray right"><span class="red">* </span>受让人证照(证件)号码</td>
                    <td>
                        ${pubJusticeInfo.assCerNO}
                    </td>
                </tr>
                <tr class="commonType alienType">
                    <td class="bg-gray right"><span class="red">* </span>协助执行日期</td>
                    <td>
                        <fmt:formatDate value="${pubJusticeInfo.executeDate}" pattern="yyyy-MM-dd"/>
                    </td>
                </tr>
            </table>
        </div>

        <div>
            <c:if test="${pubJusticeInfo.auditState == '1'}">
            <h1 class="h4-title left mt5">修改记录</h1>
            <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10">
                <tr>
                    <td class="center bg-gray">序号</td>
                    <td class="center bg-gray">修改日期</td>
                    <td class="center bg-gray">修改人</td>
                    <td class="center bg-gray">审核结果</td>
                    <td class="center bg-gray">审核人</td>
                    <td class="center bg-gray">审核日期</td>
                    <td class="center bg-gray">操作</td>
                </tr>
                <c:forEach var="pubServerHisMod" items="${pubServerHisModList}" varStatus="status">
                <tr>
                    <td class="center"><c:out value="${status.count}"></c:out></td>
                    <td class="center"><fmt:formatDate value="${pubServerHisMod.altDate}"
                                                       pattern="yyyy-MM-dd"/></td>
                    <td class="center"><c:out value="${pubServerHisMod.altName}"></c:out></td>
                    <td class="center">
                        <c:choose>
                        <c:when test="${pubServerHisMod.auditState =='1'}">审核通过</c:when>
                        <c:when test="${pubServerHisMod.auditState =='2'}">审核不通过</c:when>
                        <c:otherwise>
                        </c:otherwise>
                        </c:choose>
        </div>
        </td>
        <td class="center"><c:out value="${pubServerHisMod.auditName}"></c:out></td>
        <td class="center"><fmt:formatDate value="${pubServerHisMod.auditDate}" pattern="yyyy-MM-dd"/></td>
        <td class="center">
            <a href="javascript:void(0);" id="doView" modUID="${pubServerHisMod.modUID}"
               priPID="${pubServerHisMod.priPID}" hisNO="${pubServerHisMod.hisNO}">详情</a>
        </td>
        </tr>
        </c:forEach>
        </table>
        </c:if>
    </div>

    <c:if test="${pubJusticeInfo.auditState == '2'}">
        <div class="">
            <h1 class="h4-title left mt5">审核信息</h1>
            <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
                <tr>
                    <td width="20%" class="bg-gray right">录入员</td>
                    <td width="30%">
                        <div class="tdBox">${pubJusticeInfo.setName}</div>
                    </td>
                    <td width="30%" class="bg-gray right">录入日期</td>
                    <td width="30%">
                        <div class="tdBox"><fmt:formatDate value="${pubJusticeInfo.setDate}"
                                                           pattern="yyyy-MM-dd"/></div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right">审核员</td>
                    <td>
                            ${pubJusticeInfo.auditName}
                    </td>
                    <td class="bg-gray right">审核日期</td>
                    <td>
                        <fmt:formatDate value="${pubJusticeInfo.auditDate}" pattern="yyyy-MM-dd"/>
                            <%-- 	                 <fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd" /> --%>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right"><span class="red">* </span>审核结果</td>
                    <td colspan="3">
                        <c:if test="${pubJusticeInfo.auditState == '1'}">同意</c:if>
                        <c:if test="${pubJusticeInfo.auditState == '2'}">不同意</c:if>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right"><span class="red">* </span>审核意见</td>
                    <td colspan="3">
                            ${pubJusticeInfo.auditOpin}
                    </td>
                </tr>
            </table>
        </div>
    </c:if>

</div>
<div class="clearfix mt10">
    <div class="center mb10">
        <button id="cancel" type="button" class="btn">关闭</button>
    </div>
</div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/other/pubjusticeinfo/pubjusticeinfo_details_main.js"></script>
</body>
</html>