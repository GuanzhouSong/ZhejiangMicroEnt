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
<div class="mod state-msg">
    <em class="ann-rep">
        <span><label>年报年度：</label><font class="light">${yrRegCheck.year}</font>年度</span>
            <span>
            	<label>首次提交：</label>
                <c:if test="${!empty yrRegCheck.firstReportTime}">
                    <fmt:formatDate value="${yrRegCheck.firstReportTime}" pattern="yyyy年MM月dd日"/>
                </c:if>
            </span>
    </em>
    <em class="rep-state">
            <span>
                <label>年度报告状态：</label>
                <strong class="<c:if test="${yrRegCheck.isReported == '0'}">light</c:if>">${yrRegCheck.isReportedClientDesc}</strong>
            </span>
            <span>
            	<label>最近修改：</label>
                 <c:if test="${!empty yrRegCheck.lastReportTime}">
                     <fmt:formatDate value="${yrRegCheck.lastReportTime}" pattern="yyyy年MM月dd日"/>
                 </c:if>
            </span>
    </em>
    <em class="pub-state w147 bdnone">
            <span><label>公示状态：</label>
                <strong class="word-expand <c:if test="${yrRegCheck.reportState == '12' || yrRegCheck.reportState == '13'}">light</c:if>">${yrRegCheck.reportStateClientDesc}</strong>
            </span>
        <span><label>历次年报公示记录：</label><a href="<c:url value="/reg/client/yr/ent/pubprint/readReportPage"/>?year=${encodeYear}"  target="_blank">查看</a></span>
    </em>
</div>


<%--电子公章 start--%>
<c:if test="${ yrRegCheck.reportState != '20'&& yrRegCheck.reportState != '00'}">
    <div style="position: absolute;top: 72px;right: -108px;display: ${!empty qzImgBase64?'block':'none'}">
        <img src="${qzImgBase64}" style="width: 30%"/>
    </div>
</c:if>
<%--电子公章 end--%>