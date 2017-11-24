<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>失信联合惩戒公告详情页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/pub.css"/>"/>
</head>
<script type="text/javascript">
    function handleCarNo(pramdate) {
        if (pramdate == null || pramdate == '' || pramdate == 'undefine') {
            return "";
        }
        var subStr = pramdate.substr(0, pramdate.length - 6);
        return subStr + '******';
    }
</script>
<body class="enterprise-info-bg">
<jsp:include page="../common/noticeheader.jsp"></jsp:include>
<div class="mb20 mt20">
    <div class="mod mod-notice-detail mod-notice-detail2">
        <div class="mod-notice-hd mod-hd">
            <h3>失信联合惩戒公告</h3>
        </div>
        <c:if test="${pubType =='20'}">
            <div class="mod-notice-bd" style="padding: 30px">
                <table class="table-horizontal table-horizontal-update mb10" border="0" cellspacing="0" cellpadding="0" width="100%">
                    <tr>
                        <td width="18%" class="ftd">发布机关</td>
                        <td width="35%">
                                ${noCreditPunishInfo.punReqDept}
                        </td>
                        <td width="18%" class="ftd">发布日期</td>
                        <td width="29%">
                            <fmt:formatDate
                                    value="${empty noCreditPunishInfo.auditTime?noCreditPunishInfo.createTime:noCreditPunishInfo.auditTime}"
                                    pattern="yyyy-MM-dd"/>
                        </td>
                    </tr>
                    <tr>
                        <td width="18%" class="ftd">惩戒领域</td>
                        <td width="35%">
                                ${noCreditPunishInfo.punField}
                        </td>
                        <td width="18%" class="ftd">惩戒事由</td>
                        <td width="29%">
                                ${noCreditPunishInfo.punCause}
                        </td>
                    </tr>
                    <tr>
                        <td class="ftd">惩戒依据</td>
                        <td colspan="3">
                                ${noCreditPunishInfo.legBasis}
                        </td>
                    </tr>
                    <tr>
                        <td class="ftd">惩戒规则</td>
                        <td colspan="3">${noCreditPunishInfo.punRule}
                        </td>
                    </tr>
                    <tr>
                        <td class="ftd">惩戒措施</td>
                        <td colspan="3">${noCreditPunishInfo.punMea}
                        </td>
                    </tr>
                    <tr>
                        <td width="18%" class="ftd penAm">惩戒执行部门</td>
                        <td width="35%" class="penAm">
                                ${noCreditPunishInfo.punExeDept}
                        </td>
                        <td width="18%" class="ftd forfAm">惩戒执行期限</td>
                        <td width="29%" class="forfAm">
                            <c:if test="${noCreditPunishInfo.isLife == '1'}">终身</c:if>
                            <c:if test="${noCreditPunishInfo.isLife != '1'}">
                                <fmt:formatDate value="${noCreditPunishInfo.exeBegin}" pattern="yyyy-MM-dd"/>至
                                <c:if test="${!empty noCreditPunishInfo.exeEnd}">
									<fmt:formatDate value="${noCreditPunishInfo.exeEnd}" pattern="yyyy-MM-dd"/>                                
                                </c:if>
                                <c:if test="${empty noCreditPunishInfo.exeEnd}">终身</c:if>
                            </c:if>
                        </td>
                    </tr>
                </table>
                <table class="table-horizontal table-horizontal-update" border="0" cellspacing="0" cellpadding="0" width="100%">
                    <tr>
                        <td width="18%" class="ftd">被惩戒当事人</td>
                        <td width="35%">
                                ${noCreditPunishInfo.entName}
                        </td>
                        <td width="18%" class="ftd">统一社会信用代码/注册号</td>
                        <td width="29%">
                                ${empty noCreditPunishInfo.uniCode?noCreditPunishInfo.regNo:noCreditPunishInfo.uniCode}
                        </td>
                    </tr>
                    <tr>
                        <td width="18%" class="ftd">法定代表人</td>
                        <td width="35%">
                                ${noCreditPunishInfo.leRep}
                        </td>
                        <td width="18%" class="ftd">身份证号</td>
                        <td width="29%">
                            <script>document.write(handleCarNo("${noCreditPunishInfo.cardNo}"))</script>
                        </td>
                    </tr>
                    <tr>
                        <td width="18%" class="ftd">法律文书编号</td>
                        <td width="35%">
                                ${noCreditPunishInfo.legNo}
                        </td>
                        <td width="18%" class="ftd">文书出具日期</td>
                        <td width="29%">
                            <fmt:formatDate value="${empty noCreditPunishInfo.legDate?noCreditPunishInfo.exeBegin:noCreditPunishInfo.legDate}" pattern="yyyy-MM-dd"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="ftd">违法性质</td>
                        <td colspan="3">
							${noCreditPunishInfo.illegalProperty}
                        </td>
                    </tr>
                    <tr>
                        <td class="ftd">违法事实</td>
                        <td colspan="3">
                            ${noCreditPunishInfo.illegalFact}
                        </td>
                    </tr>
                    <tr>
                        <td class="ftd">处理结果</td>
                        <td colspan="3">
                            ${noCreditPunishInfo.punHandleRes}
                        </td>
                    </tr>

                </table>
            </div>

        </c:if>

        <c:if test="${pubType =='21'}">
            <div class="mod-notice-bd" style="padding: 30px">
                <table class="table-horizontal table-horizontal-update mb10" border="0" cellspacing="0" cellpadding="0" width="100%">
                    <tr>
                        <td width="18%" class="ftd">发布机关</td>
                        <td width="35%">
                                ${noCreditPunishInfo.punReqDept}
                        </td>
                        <td width="18%" class="ftd">发布日期</td>
                        <td width="29%">
                            <fmt:formatDate
                                    value="${empty noCreditPunishInfo.auditTime?noCreditPunishInfo.createTime:noCreditPunishInfo.auditTime}"
                                    pattern="yyyy-MM-dd"/>
                        </td>
                    </tr>
                    <tr>
                        <td width="18%" class="ftd">惩戒领域</td>
                        <td width="35%">
                                ${noCreditPunishInfo.punField}
                        </td>
                        <td width="18%" class="ftd">惩戒事由</td>
                        <td width="29%">
                                ${noCreditPunishInfo.punCause}
                        </td>
                    </tr>
                    <tr>
                        <td class="ftd">惩戒依据</td>
                        <td colspan="3">
                                ${noCreditPunishInfo.legBasis}
                        </td>
                    </tr>
                    <tr>
                        <td class="ftd">惩戒规则</td>
                        <td colspan="3">${noCreditPunishInfo.punRule}
                        </td>
                    </tr>
                    <tr>
                        <td class="ftd">惩戒措施</td>
                        <td colspan="3">${noCreditPunishInfo.punMea}
                        </td>
                    </tr>
                    <tr>
                        <td width="18%" class="ftd penAm">惩戒执行部门</td>
                        <td width="35%" class="penAm">
                                ${noCreditPunishInfo.punExeDept}
                        </td>
                        <td width="18%" class="ftd forfAm">惩戒执行期限</td>
                        <td width="29%" class="forfAm">
                            <c:if test="${noCreditPunishInfo.isLife == '1'}">终身</c:if>
                            <c:if test="${noCreditPunishInfo.isLife != '1'}">
                                <fmt:formatDate value="${noCreditPunishInfo.exeBegin}" pattern="yyyy-MM-dd"/>至
                                 <c:if test="${!empty noCreditPunishInfo.exeEnd}">
									<fmt:formatDate value="${noCreditPunishInfo.exeEnd}" pattern="yyyy-MM-dd"/>                                
                                </c:if>
                                <c:if test="${empty noCreditPunishInfo.exeEnd}">终身</c:if>
                            </c:if>
                        </td>
                    </tr>
                </table>
                <table class="table-horizontal table-horizontal-update" border="0" cellspacing="0" cellpadding="0" width="100%">
                    <tr>
                        <td width="18%" class="ftd">被惩戒当事人</td>
                        <td width="35%">
                                ${noCreditPunishInfo.entName}
                        </td>
                        <td width="18%" class="ftd">身份证号</td>
                        <td width="29%">
                            <script>document.write(handleCarNo("${noCreditPunishInfo.cardNo}"))</script>
                        </td>
                    </tr>

                    <tr>
                        <td width="18%" class="ftd">法律文书编号</td>
                        <td width="35%">
                                ${noCreditPunishInfo.legNo}
                        </td>
                        <td width="18%" class="ftd">文书出具日期</td>
                        <td width="29%">
                            <fmt:formatDate value="${empty noCreditPunishInfo.legDate?noCreditPunishInfo.exeBegin:noCreditPunishInfo.legDate}" pattern="yyyy-MM-dd"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="ftd">违法性质</td>
                        <td colspan="3">
 							${noCreditPunishInfo.illegalProperty}
                        </td>
                    </tr>
                    <tr>
                        <td class="ftd">违法事实</td>
                        <td colspan="3">
                            ${noCreditPunishInfo.illegalFact}
                        </td>
                    </tr>
                    <tr>
                        <td class="ftd">处理结果</td>
                        <td colspan="3">
                            ${noCreditPunishInfo.punHandleRes}
                        </td>
                    </tr>

                </table>

            </div>
        </c:if>
    </div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>