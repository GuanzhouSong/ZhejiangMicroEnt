<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/26
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<c:choose>

    <c:when test="${yrRegCheckList != null && yrRegCheckList.size()>0}">

        <c:forEach var="list"  items="${yrRegCheckList}" >
            <tr>
                <input type="hidden" class="_reportCheck" data-year="${list.year}"  data-status="${list.isReported}"/>
                <td>${list.year}</td>
                <%--年度年报状态：0未年报；1已年报；2已年报（逾期）--%>
                <td class="<c:if test="${list.isReported == '0'}">nopass</c:if>">${list.isReportedClientDesc}</td>

                <td><fmt:formatDate value="${list.firstReportTime}" pattern="yyyy-MM-dd" /></td>

                <td><fmt:formatDate value="${list.lastReportTime}"  pattern="yyyy-MM-dd" /></td>

                <td><c:if test="${list.isReported != '0'}">${list.modifyCount}</c:if></td>

                <td class="<c:if test="${list.reportState == '12'}">abnormal</c:if><c:if test="${list.reportState == '13'}">nopass</c:if>">
                	<c:if test="${list.isReported != '0'}">${list.reportStateClientDesc}</c:if>
                </td>

                <td>
	                <a href="javascript:void(0)" id="_operation" data-year="${list.year}" data-pripid="${pripid}" data-status="${list.isReported}" data-reportstate="${list.reportState}">
	                	<c:if test="${list.reportState == '00'}">填报</c:if>
	                	<c:if test="${list.reportState == '10' || list.reportState == '11' || list.reportState == '12'}">详情</c:if>
	                	<c:if test="${list.reportState == '13' || list.reportState == '20'}">修改</c:if>
	                </a>
                </td>

            </tr>
        </c:forEach>
    </c:when>

    <c:otherwise>
        <tr style="text-align: center;color: red;font-weight: bold;">
            <td colspan="7">暂无数据!</td>
        </tr>
    </c:otherwise>
</c:choose>

