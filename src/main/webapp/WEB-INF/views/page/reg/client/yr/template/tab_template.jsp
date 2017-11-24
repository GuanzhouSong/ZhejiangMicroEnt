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
<jsp:useBean id="nowdate" class="java.util.Date" />
<fmt:formatDate var="nowyear" value="${nowdate}" pattern="yyyy"/>
<fmt:formatDate var="duedate" value="${nowdate}" pattern="MMdd"/>

<%--
    <div class="links">
        <a href="javascript:void(0);" class="first">修改年度报告</a>
        <a href="javascript:void(0);">打印年度报告证明</a>
    </div>
--%>

<div class="links">
    <c:if test="${yrRegCheck.reportState == '10' || yrRegCheck.reportState == '11'}">
        <!--申请修改年度报告（6月30日后 或者 之前年度）-->
        <c:if test="${duedate > 0630 || yrRegCheck.year < nowyear -1}">
            <a href="<c:url value="/reg/client/yr/modapplication/ent/show"/>?year=${encodeYear}" class="first" id="modapply" target="_blank" >申请修改年度报告</a>
        </c:if>
        <!--修改年度报告（当年度6月30日前）-->
        <c:if test="${duedate <= 0630 && yrRegCheck.year == nowyear -1}">
            <a href="javascript:void(0);"  class="first"  data-year="${year}" data-pripid="${priPID}"  onclick="_mod(this)">修改年度报告</a>
       </c:if>
    </c:if>

    <c:if test="${yrRegCheck.isReported == '1' || yrRegCheck.isReported == '2'}">
        <a  href="<c:url value="/reg/client/yr/ent/pubprint/showReportProvePage"/>?year=${encodeYear}&printFalg=1"  target="_blank">查看与打印年度报告</a>&nbsp;&nbsp;
        <a  href="<c:url value="/reg/client/yr/ent/pubprint/showEnAnnualReportProve"/>?year=${encodeYear}"  target="_blank">打印年度报告证明</a>
    </c:if>
</div>

<div class="tips">
    <span class="txt">报表中背景颜色为</span>
    <span class="blockage"></span>
    <span class="txt">的内容经选择公示后将公示于企业信用信息公示系统</span>
</div>

<div class="btn-box">
	<c:if test="${yrRegCheck.reportState == '00' ||yrRegCheck.reportState == '13' || yrRegCheck.reportState == '20'}">
    <input class="btn-report js-btn-report" onclick="_report(this)" data-year="${year}" data-pripid="${priPID}" type="button" value="预览并提交年报"/>
	</c:if>
    <%--预览跳转页面url--%>
    <input type="hidden"  id="mod_url"     value="<c:url value="/reg/client/yr/modapplication/ent/show"/>?year=${encodeYear}"/>
    <input type="hidden"  id="preview_url" value="<c:url value="/reg/client/yr/ent/pubpreview/show"/>?year=${encodeYear}"/>

</div>
<ul class="tabs-nav" id="tabs-nav" >
    <c:forEach  items="${sessionScope.reportTypeList}" var="repName">

        <c:if test="${repName == 'subcapital'}">
            <li class="${repName == tabName?'_items active':'_items'}" >
                <%--用于判断当前页面是否有出资情况--%>
                <input type="hidden" id="_cz_" value="subcapital">
                <a href="javascript:void(0);" data-url="<c:url value="/reg/client/yr/ent/subcapital/show"/>?year=${encodeYear}" onclick="_Tabs(this)">
                    出资情况（<c:if test="${yrForm.subcapital == '1'}"><strong class="blue">已填报</strong></c:if>
                    <c:if test="${yrForm.subcapital != '1'}"><strong class="light">待填报</strong></c:if>）</a>
            </li>
        </c:if>

        <c:if test="${repName == 'forinvestment'}">
            <li class="${repName == tabName?'_items active':'_items'}" >
                <a href="javascript:void(0);"  data-url="<c:url value="/reg/client/yr/ent/forinvestment/show"/>?year=${encodeYear}" onclick="_Tabs(this)">
                    对外投资（<c:if test="${yrForm.forinvestment == '1'}"><strong class="blue">已填报</strong></c:if>
                    <c:if test="${yrForm.forinvestment != '1'}"><strong class="light">待填报</strong></c:if>）</a>
            </li>
        </c:if>


        <c:if test="${repName == 'asset'}">
            <li class="${repName == tabName?'_items active':'_items'}" >
                <a href="javascript:void(0);" data-url="<c:url value="/reg/client/yr/ent/yrasset/show"/>?year=${encodeYear}" onclick="_Tabs(this)">
                    资产状况（<c:if test="${yrForm.asset == '1'}"><strong class="blue">已填报</strong></c:if>
                    <c:if test="${yrForm.asset != '1'}"><strong class="light">待填报</strong></c:if>）</a>
            </li>
        </c:if>

        <c:if test="${repName == 'assetbranch'}">
            <li class="${repName == tabName?'_items active':'_items'}" >
                <a href="javascript:void(0);" data-url="<c:url value="/reg/client/yr/ent/yrassetbranch/show"/>?year=${encodeYear}" onclick="_Tabs(this)">
                    经营情况（<c:if test="${yrForm.assetbranch == '1'}"><strong class="blue">已填报</strong></c:if>
                    <c:if test="${yrForm.assetbranch != '1'}"><strong class="light">待填报</strong></c:if>）</a>
            </li>
        </c:if>

        <c:if test="${repName == 'alterstockinfo'}">
            <li class="${repName == tabName?'_items active':'_items'}" >
                <a href="javascript:void(0);" data-url="<c:url value="/reg/client/yr/ent/alterstock/show"/>?year=${encodeYear}" onclick="_Tabs(this)">
                    股权转让（<c:if test="${yrForm.alterstockinfo == '1'}"><strong class="blue">已填报</strong></c:if>
                    <c:if test="${yrForm.alterstockinfo != '1'}"><strong class="light">待填报</strong></c:if>）</a>
            </li>
        </c:if>


        <c:if test="${repName == 'otherinfo'}">
            <li class="${repName == tabName?'_items active':'_items'}" >
                <input type="hidden" id="_qt_" value="otherinfo">
                <a href="javascript:void(0);" data-url="<c:url value="/reg/client/yr/ent/yrotherinfo/show"/>?year=${encodeYear}" onclick="_Tabs(this)">
                    其他情况（<c:if test="${yrForm.otherinfo == '1'}"><strong class="blue">已填报</strong></c:if>
                    <c:if test="${yrForm.otherinfo != '1'}"><strong class="light">待填报</strong></c:if>）
                </a>
            </li>
        </c:if>

       <c:if test="${repName == 'forguaranteeinfo'}">
            <li class="${repName == tabName?'_items active':'_items'}" >
                <a href="javascript:void(0);" data-url="<c:url value="/reg/client/yr/ent/forguarantee/show"/>?year=${encodeYear}" onclick="_Tabs(this)">
                    对外担保（<c:if test="${yrForm.forguaranteeinfo == '1'}"><strong class="blue">已填报</strong></c:if>
                    <c:if test="${yrForm.forguaranteeinfo != '1'}"><strong class="light">待填报</strong></c:if>）</a>
            </li>
        </c:if>
    </c:forEach>

    <c:if test="${year>=2016}">
        <li class="${tabName =='socialSecurity'?'_items active':'_items'}" >
            <a href="javascript:void(0);" data-url="<c:url value="/reg/client/yr/ent/yrsocialsecurity/show"/>?year=${encodeYear}" onclick="_Tabs(this)">
                社保信息（<c:if test="${yrForm.socialSecurity == '1'}"><strong class="blue">已填报</strong></c:if>
                <c:if test="${yrForm.socialSecurity != '1'}"><strong class="light">待填报</strong></c:if>）</a>
            </a>
        </li>
   </c:if>

</ul>




