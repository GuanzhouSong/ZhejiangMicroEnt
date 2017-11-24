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

<div class="banner-bg">
    <div class="mod banner">
        <h4>欢迎您！${midBaseInfoDto.entName}</h4>
        <p>
           <%-- <em class="js-show-tips show-tips fr" data-component="dropDown" data-trigger="toggle" data-target=".js-fold-msg">年报信息<i class="tiny-icon"></i></em>--%>
            <em class="register-office">登记机关：${midBaseInfoDto.regOrgName}</em>
            <c:if test="${!empty midBaseInfoDto.uniCode}"><em>统一社会信用代码：${midBaseInfoDto.uniCode}</em></c:if>
            <em>注册号：${midBaseInfoDto.regNO}</em>
        </p>
        <p>
            <em class="register-office">法定代表人/负责人：${midBaseInfoDto.leRep}</em>
            <em>成立日期：<fmt:formatDate value="${midBaseInfoDto.estDate}" dateStyle="long"/></em>
            <c:if test="${!empty midBaseInfoDto.regCap}">
                <em>注册资本：<fmt:formatNumber type="number"  value=" ${midBaseInfoDto.regCap }"  pattern="0.00" maxFractionDigits="2"/>万${midBaseInfoDto.currencyCn}</em>
            </c:if>
        </p>
   <%--     <p class="warn-txt">敬请下载安装<span>“联连”企业信用信息警示软件</span>，第一时间获取企业信用警示提示。避免消息滞后，延误处理，影响贵企业的信用状况</p>--%>
    </div>
</div>

<div class="fold-msg-bg js-fold-msg" >
    <div style="text-align: center;height: 40px;line-height: 40px;font-size: 16px;">
        当前辅助报表的状态：
        <strong class="light">
            ${yrRegCheck.declStatus=='0'?'未申报':''}
            ${yrRegCheck.declStatus=='1'?'申报待核':''} <%--只能查看--%>
            ${yrRegCheck.declStatus=='3'?'已退回':''}   <%--可以进行修改--%>
        </strong>
        <strong style="color: #2196F3;font-weight: normal;">
            ${yrRegCheck.declStatus=='2'?'已核实':''}   <%--只能查看--%>
        </strong>
    </div>
        <%--农专综合信息年报 报表的状态值--%>
       <input type="hidden" id="_declStatus" value="${yrRegCheck.declStatus}">
</div>


<div class="mod caiwu">
    <div class="mod-hd">
        <div class="btn-box" style="top:13px;">
            <c:if test="${yrRegCheck.declStatus == '0'}">
                <input class="btn-report js-btn-report" onclick="sfc_report(this)" data-year="${year}" data-pripid="${priPID}" type="button" value="上报"/>
            </c:if>
            <c:if test="${yrRegCheck.declStatus == '3'}">
                <input class="btn-report js-btn-report" onclick="sfc_report(this)" data-year="${year}" data-pripid="${priPID}" type="button" value="修改上报"/>
            </c:if>
        </div>

        <ul class="tabs-nav" id="tabs-nav" >
            <li class="${tabName == 'cominfo'?'_items active':'_items'}" >
                <a href="javascript:void(0);" data-url="<c:url value="/reg/client/yr/sfc/cominfo/show"/>?year=${encodeYear}"  onclick="_SfcTabs(this)" >
                    综合信息填写(<c:if test="${sfcForm.cominfo == '1'}"><strong class="blue">已填报</strong></c:if>
                                <c:if test="${sfcForm.cominfo == '0'}"><strong class="light">待填报</strong></c:if>)</a>

            </li>

            <li class="${tabName == 'balanctsheet'?'_items active':'_items'}" >
                <a href="javascript:void(0);" data-url="<c:url value="/reg/client/yr/sfc/balanctsheet/show"/>?year=${encodeYear}" onclick="_SfcTabs(this)" >
                    资产负债(<c:if test="${sfcForm.balanctsheet == '1'}"><strong class="blue">已填报</strong></c:if>
                            <c:if test="${sfcForm.balanctsheet == '0'}"><strong class="light">待填报</strong></c:if>)</a>
            </li>

            <li class="${tabName == 'incstatement'?'_items active':'_items'}" >
                <a href="javascript:void(0);" data-url="<c:url value="/reg/client/yr/sfc/incstatement/show"/>?year=${encodeYear}" onclick="_SfcTabs(this)" >
                    盈余及分配(<c:if test="${sfcForm.incstatement == '1'}"><strong class="blue">已填报</strong></c:if>
                             <c:if test="${sfcForm.incstatement == '0'}"><strong class="light">待填报</strong></c:if>)</a>
            </li>


            <li class="${tabName == 'incomechange'?'_items active':'_items'}" >
                <a href="javascript:void(0);" data-url="<c:url value="/reg/client/yr/sfc/incomechange/show"/>?year=${encodeYear}" onclick="_SfcTabs(this)" >
                    成员权益变动(<c:if test="${sfcForm.incomechange == '1'}"><strong class="blue">已填报</strong></c:if>
                               <c:if test="${sfcForm.incomechange == '0'}"><strong class="light">待填报</strong></c:if>)</a>
            </li>


        </ul>
    </div>
</div>



