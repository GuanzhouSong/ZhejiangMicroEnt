<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>农专社综合信息表页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>

<!-- 头部  start-->
<jsp:include page="../../common/header.jsp"></jsp:include>

<%--移入的tab标签栏--%>
<jsp:include page="../template/sfc_template.jsp"></jsp:include>


<form class="form-horizontal error-bottom" id="Form1">
    <%--隐藏域中的值--%>
    <input type="hidden" id="" name="id" value="${sfcCominfo.id}">
    <input type="hidden" id="" name="uid" value="${sfcCominfo.uid}">
    <input type="hidden" id="" name="year" value="${year}">
    <input type="hidden" id="" name="priPID" value="${priPID}">
<%--合作社类型  --%>
        <div class="mod pbreport-basic">
            <div class="mod-hd">
                <div class="title">
                    <h3>合作社类型 </h3>
                </div>
            </div>
            <div class="mod-bd">
                <div class="content content-contact">
                    <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <tr>
                            <td class="odd focus-state">
                                <div class="item-name"><strong class="light">* </strong>合作社类型</div>
                                <div class="radio-box">
                                    <label class="pdr20"><input type="radio" name="farArtType" value="1" <c:if test="${sfcCominfo.farArtType=='1'}">checked</c:if> >种植类</label>
                                    <label class="pdr20"><input type="radio" name="farArtType" value="2" <c:if test="${sfcCominfo.farArtType=='2'}">checked</c:if> >养殖类</label>
                                    <label class="pdr20"><input type="radio" name="farArtType" value="3" <c:if test="${sfcCominfo.farArtType=='3'}">checked</c:if> >服务类</label>
                                    <label class="pdr20"><input type="radio" name="farArtType" value="4" <c:if test="${sfcCominfo.farArtType=='4'}">checked</c:if> >营销类</label>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

<%--主要农产品 --%>
<div class="mod pbreport-basic">
    <div class="mod-hd">
        <div class="title">
            <h3>主要农产品 </h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content">
                <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name">主要农产品名称</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="farArtProName" value="${sfcCominfo.farArtProName}" class="ipt-txt w720">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name">已获得的农产品认证</div>
                            <div class="ipt-box">
                                <div class="check-box">
                                    <label class="pdr20">
                                        <input type="checkbox" name="farArtPolFreeCe"  class="_default"  value="1"  ${sfcCominfo.farArtPolFreeCe=='1'?'checked':''} >无公害产品认证
                                    </label>
                                    <label class="pdr20">
                                        <input type="checkbox" name="farArtGreenOrgCe" class="_default"  value="1" ${sfcCominfo.farArtGreenOrgCe=='1'?'checked':''} >绿色有机产品认证
                                    </label>
                                    <label class="pdr20">
                                        <input type="checkbox" name="farArtOrgCe"      class="_default"   value="1" ${sfcCominfo.farArtOrgCe=='1'?'checked':''} >有机农产品认证
                                    </label>
                                    <label class="pdr20">
                                        <input type="checkbox" name="farArtGeoCe"       class="_default"  value="1" ${sfcCominfo.farArtGeoCe=='1'?'checked':''} >农产品地理
                                    </label>
                                </div>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
        </div>
    </div>
</div>

<%--合作社规模--%>
<div class="mod subcapital">
    <div class="mod-hd">
        <div class="title">
            <h3>合作社规模</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content">

                <table class="table-public table-col" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name">合作社成员数(人)</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="farArtMemNum" value="${sfcCominfo.farArtMemNum}" class="ipt-txt ipt-txt-sm">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name">生产基地面积(亩)</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="farArtArea" name="farArtArea" value="${sfcCominfo.farArtArea}" class="ipt-txt ipt-txt-sm  ">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name w225">带动农户(户)</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="farArtDriFarmerNum" value="${sfcCominfo.farArtDriFarmerNum}" class="ipt-txt ipt-txt-lg">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name">自有产权房面积(平方米)</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="farArtPriProArea" value="${sfcCominfo.farArtPriProArea}" class="ipt-txt w304">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name w225">自有生产经营设备价值(万元)</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="farArtOpeEquVal" value="${sfcCominfo.farArtOpeEquVal}" class="ipt-txt ipt-txt-lg  millionUnits">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name">合作社投资总规模(万元)</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="farArtCoopTotalInv" value="${sfcCominfo.farArtCoopTotalInv}" class="ipt-txt ipt-txt-sm  millionUnits">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name">其中：成员出资(万元)</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="farArtMemInv" value="${sfcCominfo.farArtMemInv}" class="ipt-txt ipt-txt-sm  millionUnits">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name">贷款额(万元)</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="farArtLoanAmount" value="${sfcCominfo.farArtLoanAmount}" class="ipt-txt ipt-txt-sm  millionUnits">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name">政府补助(万元)</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="farArtGovGrants" value="${sfcCominfo.farArtGovGrants}" class="ipt-txt ipt-txt-sm  millionUnits">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>

        </div>
    </div>
</div>

<%--上年度生产经营和销售情况 --%>
<div class="mod subcapital">
    <div class="mod-hd">
        <div class="title">
            <h3>上年度生产经营和销售情况 </h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content">

                <table class="table-public table-col" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td class="odd focus-state" colspan="4">
                            <div class="item-name">主要销售市场</div>
                            <div class="radio-box">
                                <label class="pdr20"><input type="radio" name="farArtMarketing" value="1" ${sfcCominfo.farArtMarketing=='1'?'checked':''} >省内</label>
                                <label class="pdr20"><input type="radio" name="farArtMarketing" value="2" ${sfcCominfo.farArtMarketing=='2'?'checked':''} >省外</label>
                                <label class="pdr20"><input type="radio" name="farArtMarketing" value="3" ${sfcCominfo.farArtMarketing=='3'?'checked':''} >国外</label>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name">上年度销售总额(万元)</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="farArtTotalSales" value="${!empty sfcCominfo.farArtTotalSales?sfcCominfo.farArtTotalSales: vendInc}" class="ipt-txt ipt-txt-sm  millionUnits" readonly>
                                <%--<i class="icon-close"></i>--%>
                            </div>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name">销售额年增长率(%)</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="farArtSalesIncRatio" value="${sfcCominfo.farArtSalesIncRatio}" class="ipt-txt ipt-txt-sm">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td class="odd w165 focus-state" colspan="2">
                            <div class="item-name w165">利润总额(万元)</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="farArtTotalProfit" value="${sfcCominfo.farArtTotalProfit}" class="ipt-txt w294  millionUnits">
                                <i class="icon-close"></i>
                            </div>
                        </td>

                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name">全年纳税总额(万元)</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="farArtTaxAmount" value="${!empty sfcCominfo.farArtTaxAmount?sfcCominfo.farArtTaxAmount:ratGro}" class="ipt-txt ipt-txt-sm  millionUnits" readonly>
                              <%--  <i class="icon-close"></i>--%>
                            </div>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name">其中：所得税总额(万元)</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="farArtGroIncTax" value="${sfcCominfo.farArtGroIncTax}" class="ipt-txt ipt-txt-sm  millionUnits">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name ">享受扶持资金(万元)</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="farArtSupFinancing" value="${sfcCominfo.farArtSupFinancing}" class="ipt-txt ipt-txt-sm  millionUnits">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name">税费减免总额(万元)</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="farArtTotalTaxCuts" value="${sfcCominfo.farArtTotalTaxCuts}" class="ipt-txt ipt-txt-sm  millionUnits">
                                <i class="icon-close"></i>
                            </div>
                        </td>

                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name">社员年均纯收入(元)</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="farArtAreNetIncome" value="${sfcCominfo.farArtAreNetIncome}" class="ipt-txt ipt-txt-sm js-item units">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name">统一采购农业投入品比例(%)</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="farArtInpProRatio" value="${sfcCominfo.farArtInpProRatio}" class="ipt-txt ipt-txt-sm">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td class="odd w165 focus-state" colspan="2">
                            <div class="item-name w165">统一销售主产品比例(%)</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="farArtSaleProRatio" value="${sfcCominfo.farArtSaleProRatio}" class="ipt-txt w294">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name">开展初加工后销售</div>
                            <div class="ipt-box">
                                <div class="radio-box">
                                    <label><input type="radio" name="farArtPreSales" value="1" ${sfcCominfo.farArtPreSales=='1'?'checked':''} >是</label>
                                    <label><input type="radio" name="farArtPreSales" value="0" ${sfcCominfo.farArtPreSales=='0'?'checked':''} >否</label>
                                </div>
                            </div>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name">开展深加工后销售</div>
                            <div class="radio-box">
                                <label><input type="radio" name="farArtDeepSales" value="1" ${sfcCominfo.farArtDeepSales=='1'?'checked':''} >是</label>
                                <label><input type="radio" name="farArtDeepSales" value="0" ${sfcCominfo.farArtDeepSales=='0'?'checked':''} >否</label>
                            </div>
                        </td>
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name">实现农超对接</div>
                            <div class="radio-box">
                                <label><input type="radio" name="farArtLinkFarSupmarket" value="1" ${sfcCominfo.farArtLinkFarSupmarket=='1'?'checked':''} >是</label>
                                <label><input type="radio" name="farArtLinkFarSupmarket" value="0" ${sfcCominfo.farArtLinkFarSupmarket=='0'?'checked':''} >否</label>
                            </div>
                        </td>

                    </tr>
                    </tbody>
                </table>

        </div>
    </div>
</div>

<%--内部管理状况 --%>
<div class="mod pbreport-basic">
    <div class="mod-hd">
        <div class="title">
            <h3>内部管理状况 </h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content">

                <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name">已执行的事项</div>
                            <div class="ipt-box">
                                <div class="check-box">
                                    <label class="pdr20"><input type="checkbox" class="_default" name="farArtSupBoardItem" value="1" ${sfcCominfo.farArtSupBoardItem=='1'?'checked':''} >设立监事会</label>
                                    <label class="pdr20"><input type="checkbox" class="_default" name="farArtMemMeetingItem" value="1" ${sfcCominfo.farArtMemMeetingItem=='1'?'checked':''} >定期召开社员大会</label>
                                    <label class="pdr20"><input type="checkbox" class="_default" name="farArtAccItem" value="1" ${sfcCominfo.farArtAccItem=='1'?'checked':''} >建立会计核算</label>
                                    <label class="pdr20"><input type="checkbox" class="_default" name="farArtFinDisItem" value="1" ${sfcCominfo.farArtFinDisItem=='1'?'checked':''} >定期财务公开</label>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name">其他事项执行情况</div>
                            <div class="ipt-box js-ipt-box">
                                <textarea name="farArtOtherItem"  cols="90" rows="4" style="vertical-align: middle;">${sfcCominfo.farArtOtherItem}</textarea>
                                <i class="icon-close"></i>
                            </div>
                        </td>
                    </tr>

                    </tbody>
                </table>
        </div>
    </div>
</div>

<%--技术培训，农产品质量管理 --%>
<div class="mod pbreport-basic">
    <div class="mod-hd">
        <div class="title">
            <h3>技术培训，农产品质量管理</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
            <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name"><strong class="light">* </strong>上年度组织开展技术培训</div>
                        <div class="ipt-box">
                            <div class="radio-box ">
                                <label><input type="radio" name="farArtTecTrain" value="1" ${sfcCominfo.farArtTecTrain=='1'?'checked':''} class="js-farArtTecTrain_have">有</label>
                                <label><input type="radio" name="farArtTecTrain" value="0" ${sfcCominfo.farArtTecTrain=='0'?'checked':''} class="js-farArtTecTrain_no">无</label>
                            </div>
                        </div>
                    </td>
                    <td class="odd focus-state">
                        <div class="item-name"><strong class="light">* </strong>培训师来源</div>
                        <div class="ipt-box">
                            <div class="check-box radio-box" id="js-source">
                                <label class="pdr20"><input type="checkbox" name="laiyuan" data-name="farArtTeaExt"  value="1" class="source" ${sfcCominfo.farArtTeaExt=='1'?'checked':''}>外聘</label>
                                <label class="pdr20"><input type="checkbox" name="laiyuan" data-name="farArtTeaInt"  value="1" class="source" ${sfcCominfo.farArtTeaInt=='1'?'checked':''}>自有</label>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name"><strong class="light">* </strong>上年度组织或参加培训总数(次)</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="farArtTrainNum" name="farArtTrainNum" value="${sfcCominfo.farArtTrainNum}" class="ipt-txt ipt-txt-lg">
                            <i class="icon-close"></i>
                        </div>
                    </td>
                    <td class="odd focus-state">
                        <div class="item-name"><strong class="light">* </strong>参加培训人数(人/次)</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="farArtMemAttNum" name="farArtMemAttNum" value="${sfcCominfo.farArtMemAttNum}" class="ipt-txt ipt-txt-lg">
                            <i class="icon-close"></i>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state" colspan="2">
                        <div class="item-name"><strong class="light">* </strong>已开展的质量工作有</div>
                        <div class="ipt-box">
                            <div class="check-box radio-box"  >
                                <label class="pdr20"><input type="checkbox" class="work" name="far" data-name="farArtQuaSta"     value="1"  ${sfcCominfo.farArtQuaSta=='1'?'checked':''} >执行农产品质量标准</label>
                                <label class="pdr20"><input type="checkbox" class="work" name="far" data-name="farArtQuaTraSys"  value="1"  ${sfcCominfo.farArtQuaTraSys=='1'?'checked':''} >建立农产品质量追溯制度</label>
                                <label class="pdr20"><input type="checkbox" class="work" name="far" data-name="farArtQuaSys"     value="1"  ${sfcCominfo.farArtQuaSys=='1'?'checked':''} >获得产品质量体系认证</label>
                                <label class="pdr20"><input type="checkbox" class="work" name="far" data-name="farArtQuaRiskSys" value="1"  ${sfcCominfo.farArtQuaRiskSys=='1'?'checked':''}>建立风险储备金制度</label>
                            </div>
                        </div>
                    </td>

                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%--互联网运用情况 --%>
<div class="mod subcapital">
    <div class="mod-hd">
        <div class="title">
            <h3>互联网运用情况</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content">

                <table class="table-public table-col" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td class="odd focus-state" width="250">
                            <div class="item-name">设立独立网站或网页</div>
                            <div class="ipt-box">
                                <div class="ipt-box">
                                    <div class="radio-box">
                                        <label><input type="radio" name="farArtWebsite" value="1" ${sfcCominfo.farArtWebsite=='1'?'checked':''} onclick="$('#farArtWebName, #farArtWebUrl').prop('readonly', false).addClass('required')" >有</label>
                                        <label><input type="radio" name="farArtWebsite" value="0" id="farArtWebsite_no" ${sfcCominfo.farArtWebsite=='0'?'checked':''}  >无</label>
                                    </div>
                                </div>
                            </div>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name w100">网站名称</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="farArtWebName" name="farArtWebName" value="${sfcCominfo.farArtWebName}" ${sfcCominfo.farArtWebsite=='0'?'readonly':''}  class="ipt-txt ipt-txt-lg ${sfcCominfo.farArtWebsite=='1'?'required':''}">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name w100">网址</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="farArtWebUrl" name="farArtWebUrl" value="${sfcCominfo.farArtWebUrl}"  ${sfcCominfo.farArtWebsite=='0'?'readonly':''}  class="ipt-txt ipt-txt-lg ${sfcCominfo.farArtWebsite=='1'?'required':''}">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name">运用互联网络发布信息</div>
                            <div class="ipt-box">
                                <div class="radio-box">
                                    <label><input type="radio" name="farArtNetRelInfo" value="1" ${sfcCominfo.farArtNetRelInfo=='1'?'checked':''} onclick="$('#farArtNetAdCost').prop('readonly', false).addClass('required')" >有</label>
                                    <label><input type="radio" name="farArtNetRelInfo" value="0" id="farArtNetRelInfo_no" ${sfcCominfo.farArtNetRelInfo=='0'?'checked':''}  >无</label>
                                </div>
                            </div>
                        </td>
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name w180">其中累计用于网络广告费用(万元)</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="farArtNetAdCost" name="farArtNetAdCost" value="${sfcCominfo.farArtNetAdCost}" ${sfcCominfo.farArtNetRelInfo=='0'?'readonly':''} class="ipt-txt w520 ${sfcCominfo.farArtNetRelInfo=='1'?'required':''} ">
                                <i class="icon-close"></i>
                            </div>
                        </td>

                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name">通过网络销售产品或服务</div>
                            <div class="ipt-box">
                                <div class="radio-box">
                                    <label><input type="radio" name="farArtNetSales" value="1" ${sfcCominfo.farArtNetSales=='1'?'checked':''} onclick="$('#farArtNetSalesAmount').prop('readonly', false).addClass('required')"  >有</label>
                                    <label><input type="radio" name="farArtNetSales" value="0" id="farArtNetSales_no" ${sfcCominfo.farArtNetSales=='0'?'checked':''}  >无</label>
                                </div>
                            </div>
                        </td>
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name w180">其中上年度网上销售额(万元)</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="farArtNetSalesAmount" name="farArtNetSalesAmount" value="${sfcCominfo.farArtNetSalesAmount}" ${sfcCominfo.farArtNetSales=='0'?'readonly':''} class="ipt-txt w520  ${sfcCominfo.farArtNetSales=='1'?'required':''} ">
                                <i class="icon-close"></i>
                            </div>
                        </td>

                    </tr>

                    </tbody>
                </table>

        </div>
    </div>
</div>

<%--示范合作社   --%>
<div class="mod pbreport-basic">
    <div class="mod-hd">
        <div class="title">
            <h3>示范合作社 </h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
            <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name"><strong class="light">* </strong>示范合作社验收情况</div>
                        <div class="radio-box">
                            <span>已获得: </span>
                            <label class="pdr20"><input type="radio" name="farArtDemoCoopGrade" value="1" ${sfcCominfo.farArtDemoCoopGrade=='1'?'checked':''} >国家级</label>
                            <label class="pdr20"><input type="radio" name="farArtDemoCoopGrade" value="2" ${sfcCominfo.farArtDemoCoopGrade=='2'?'checked':''} >省级</label>
                            <label class="pdr20"><input type="radio" name="farArtDemoCoopGrade" value="3" ${sfcCominfo.farArtDemoCoopGrade=='3'?'checked':''} >市级</label>
                            <label class="pdr20"><input type="radio" name="farArtDemoCoopGrade" value="4" ${sfcCominfo.farArtDemoCoopGrade=='4'?'checked':''} >县级</label>
                            <label class="pdr20"><input type="radio" name="farArtDemoCoopGrade" value="5" ${sfcCominfo.farArtDemoCoopGrade=='5'?'checked':''} >目前正在申报</label>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%--银行，机构及税务登记证  --%>
<div class="mod subcapital">
    <div class="mod-hd">
        <div class="title">
            <h3>银行，机构及税务登记证 </h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content">

                <table class="table-public table-col" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td class="odd focus-state" width="250">
                            <div class="item-name w110">开户银行（基本户）</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="farArtBank" value="${sfcCominfo.farArtBank}" class="ipt-txt w120">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name w100">帐号</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="farArtBankAccount" value="${sfcCominfo.farArtBankAccount}" class="ipt-txt ipt-txt-lg">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name w100">信用等级</div>
                            <select name="farArtCreditLevel" class="select-txt w245">
                                <option value="01" ${sfcCominfo.farArtCreditLevel=='01'?'selected':''}>AAA</option>
                                <option value="02" ${sfcCominfo.farArtCreditLevel=='02'?'selected':''}>AA</option>
                                <option value="03" ${sfcCominfo.farArtCreditLevel=='03'?'selected':''}>A</option>
                                <option value="04" ${sfcCominfo.farArtCreditLevel=='04'?'selected':''}>B</option>
                                <option value="05" ${sfcCominfo.farArtCreditLevel=='05'?'selected':''}>C</option>
                                <option value="06" ${sfcCominfo.farArtCreditLevel=='06'?'selected':''}>D</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state" width="250">
                            <div class="item-name w110">组织机构代码证号</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="entOrgCode" value="${sfcCominfo.entOrgCode}" class="ipt-txt w120">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name w100">税务登记证号</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="taxRegNo" value="${sfcCominfo.taxRegNo}" class="ipt-txt w520">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                    </tr>

                    </tbody>
                </table>

        </div>
    </div>
</div>

<%--社会荣誉--%>
<div class="mod pbreport-basic">
    <div class="mod-hd">
        <div class="title">
            <h3>社会荣誉</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content">

                <table class="table-public table-contact table-col" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td class="odd">
                            <div class="item-name">合作社负责人或社员中担任</div>
                            <label>人大代表</label>
                            <select name="farArtIsNpcMem" class="select-txt w120 mr20">
                                <option value="0" ${sfcCominfo.farArtIsNpcMem=='0'?'selected':''}>无</option>
                                <option value="1" ${sfcCominfo.farArtIsNpcMem=='1'?'selected':''}>县级</option>
                                <option value="2" ${sfcCominfo.farArtIsNpcMem=='2'?'selected':''}>市级</option>
                                <option value="3" ${sfcCominfo.farArtIsNpcMem=='3'?'selected':''}>省级</option>
                                <option value="4" ${sfcCominfo.farArtIsNpcMem=='4'?'selected':''}>国家级</option>
                            </select>

                            <label>政协委员</label>
                            <select name="farArtIsCppccMem" class="select-txt w120 mr20">
                                <option value="0" ${sfcCominfo.farArtIsCppccMem=='0'?'selected':''}>无</option>
                                <option value="1" ${sfcCominfo.farArtIsCppccMem=='1'?'selected':''}>县级</option>
                                <option value="2" ${sfcCominfo.farArtIsCppccMem=='2'?'selected':''}>市级</option>
                                <option value="3" ${sfcCominfo.farArtIsCppccMem=='3'?'selected':''}>省级</option>
                                <option value="4" ${sfcCominfo.farArtIsCppccMem=='4'?'selected':''}>国家级</option>
                            </select>

                            <label>党代表</label>
                            <select name="farArtIsPartyRep" class="select-txt w120">
                                <option value="0" ${sfcCominfo.farArtIsPartyRep=='0'?'selected':''}>无</option>
                                <option value="1" ${sfcCominfo.farArtIsPartyRep=='1'?'selected':''}>县级</option>
                                <option value="2" ${sfcCominfo.farArtIsPartyRep=='2'?'selected':''}>市级</option>
                                <option value="3" ${sfcCominfo.farArtIsPartyRep=='3'?'selected':''}>省级</option>
                                <option value="4" ${sfcCominfo.farArtIsPartyRep=='4'?'selected':''}>国家级</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd">
                            <div class="item-name">合作社负责人或社员中获得</div>
                            <label>优秀党员</label>
                            <select name="farArtIsOutPartyMum" class="select-txt w120 mr20">
                                <option value="0" ${sfcCominfo.farArtIsOutPartyMum=='0'?'selected':''}>无</option>
                                <option value="1" ${sfcCominfo.farArtIsOutPartyMum=='1'?'selected':''}>县级</option>
                                <option value="2" ${sfcCominfo.farArtIsOutPartyMum=='2'?'selected':''}>市级</option>
                                <option value="3" ${sfcCominfo.farArtIsOutPartyMum=='3'?'selected':''}>省级</option>
                                <option value="4" ${sfcCominfo.farArtIsOutPartyMum=='4'?'selected':''}>国家级</option>
                            </select>

                            <label>劳动模范</label>
                            <select name="farArtIsModelWorker" class="select-txt w120 mr20">
                                <option value="0" ${sfcCominfo.farArtIsModelWorker=='0'?'selected':''}>无</option>
                                <option value="1" ${sfcCominfo.farArtIsModelWorker=='1'?'selected':''}>县级</option>
                                <option value="2" ${sfcCominfo.farArtIsModelWorker=='2'?'selected':''}>市级</option>
                                <option value="3" ${sfcCominfo.farArtIsModelWorker=='3'?'selected':''}>省级</option>
                                <option value="4" ${sfcCominfo.farArtIsModelWorker=='4'?'selected':''}>国家级</option>
                            </select>

                            <label>三八红旗手</label>
                            <select name="farArtIsWomSetter" class="select-txt w120">
                                <option value="0" ${sfcCominfo.farArtIsWomSetter=='0'?'selected':''}>无</option>
                                <option value="1" ${sfcCominfo.farArtIsWomSetter=='1'?'selected':''}>县级</option>
                                <option value="2" ${sfcCominfo.farArtIsWomSetter=='2'?'selected':''}>市级</option>
                                <option value="3" ${sfcCominfo.farArtIsWomSetter=='3'?'selected':''}>省级</option>
                                <option value="4" ${sfcCominfo.farArtIsWomSetter=='4'?'selected':''}>国家级</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name">合作社负责人或社员中担任</div>
                            <div class="ipt-box">
                                <div class="check-box">
                                    <label class="pdr20"><input type="checkbox" class="_default" name="farArtIsVilSec" ${sfcCominfo.farArtIsVilSec=='1'?'checked':''} value="1">村支书</label>
                                    <label class="pdr20"><input type="checkbox" class="_default" name="farArtIsVilDir" ${sfcCominfo.farArtIsVilDir=='1'?'checked':''} value="1">村主任</label>
                                </div>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
        </div>
    </div>
</div>
</form>

<%--添加/修改 荣誉项--%>
<form class="form-horizontal error-bottom" id="Form2">
<div class="mod mod-border investment-info js-contentform-show js-content-show  js-editUI" id="fasd" >
    <div class="mod-hd">
        <div class="title">
            <h3>添加/修改 荣誉项</h3>
        </div>
    </div>

        <div class="mod-bd">
            <div class="content">
                <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0" >
                    <%--隐藏域--%>
                    <input type="hidden" id="_uid"    name="uid" value="">
                    <input type="hidden" id="_priPID" name="priPID" value="${priPID}">
                    <input type="hidden" id="_year"   name="year" value="${year}">
                    <tbody>
                    <tr>
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name w216">合作社及负责人获得的其它社会荣誉名称</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="farArtHonorName" name="farArtHonorName" class="ipt-txt  ipt-txt-lg" placeholder="无则填写注册号">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd  focus-state" colspan="2">
                            <div class="item-name w216">授予单位
                            </div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="farArtHonorIssAut" name="farArtHonorIssAut"  class="ipt-txt  ipt-txt-lg" placeholder="中国境内企业">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd  focus-state">
                            <div class="item-name w216">有效日期始</div>
                            <div class="ipt-box">
                                <input type="text" id="_start" name="valFrom" class="ipt-txt ipt-txt-lg icon-date pr217 laydate-icon" readonly="readonly">
                            </div>

                        </td>
                        <td class="even  focus-state">
                            <div class="item-name w80">有效日期末</div>
                            <div class="ipt-box">
                                <input type="text" id="_end" name="valTo" class="ipt-txt ipt-txt-lg icon-date pr217 laydate-icon" readonly="readonly">
                            </div>
                            <strong class="light pointer"><a href="javascript:void(0)"  id="setTimes" >(长期有效请点此处)</a></strong>
                        </td>
                    </tr>

                    </tbody>
                </table>

                <div class="btn-box">
                    <input type="submit" value="确定" class="btn-common js-submit">
                    <input type="button" value="取消" class="btn-common js-cancel">
                </div>
            </div>
     </div>

</div>
</form>

<%--荣誉项--%>
<div class="mod subcapital">
    <div class="mod-hd">
        <div class="title">
            <h3>荣誉项</h3>
            <div class="btn-box">
                <a href="javascript:void(0)" class="btn-common btn-add drop-on js-addUI">新增</a>
            </div>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content">
            <div class="subcapital-tips">
                <label><input type="checkbox" id="_checkAll">全选</label>
                需要新增荣誉信息请点击“添加”，需要修改或删除信息请点击所选中的荣誉信息
                <div class="fr edit">
                    <a href="javascript:void(0)" class="btn-edit js-edit">修改</a>
                    <a href="javascript:void(0)" class="btn-delete js-delete">删除</a>
                </div>
            </div>
            <div class="content-sm-height">
                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th width="52">序号</th>
                        <th width="415">合作社及负责人获得的其它社会荣誉名称</th>
                        <th width="275">授予机关</th>
                        <th>有效期始</th>
                        <th>有效期末</th>
                    </tr>
                    </thead>
                    <tbody id="_listPage">

                    </tbody>
                </table>
            </div>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到<em id="_total"></em>条信息，共<em id="_pageNum"></em>页</span>
                <div id="pagination" class="pagination">

                </div>
            </div>
        </div>
    </div>
</div>

<%--联系信息--%>
<%--<form class="form-horizontal error-bottom" id="Form3">
<div class="mod pbreport-basic">
    <div class="mod-hd">
        <div class="title">
            <h3>联系信息</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-col">
            <table class="table-public table-col" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td class="odd focus-state" width="320px">
                        <div class="item-name w120"><strong class="light">* </strong>法定代表人</div>
                        <div class="ipt-box w190 js-ipt-box">
                            <input type="text" name="leRep" value="${!empty sfcCominfo.leRep?sfcCominfo.leRep:yrSfcBaseinfo.leRep}" class="ipt-txt w190" readonly>
                           &lt;%&ndash; <i class="icon-close"></i>&ndash;%&gt;
                        </div>
                    </td>
                    <td class="odd focus-state" width="320px">
                        <div class="item-name w120"><strong class="light"> </strong>固定电话</div>
                        <div class="ipt-box w190 js-ipt-box">
                            <input type="text" name="leRepTel" value="${sfcCominfo.leRepTel}" class="ipt-txt w190">
                            <i class="icon-close"></i>
                        </div>
                    </td>
                    <td class="odd focus-state" width="320px">
                        <div class="item-name w120"><strong class="light">* </strong>移动电话</div>
                        <div class="ipt-box w190 js-ipt-box">
                            <input type="text" name="leRepPhone" value="${!empty sfcCominfo.leRepPhone?sfcCominfo.leRepPhone:yrSfcBaseinfo.leRepPhone}" class="ipt-txt w190"  readonly>
                           &lt;%&ndash; <i class="icon-close"></i>&ndash;%&gt;
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state" width="320px">
                        <div class="item-name w120"><strong class="light"> </strong>财务负责人</div>
                        <div class="ipt-box w190 js-ipt-box">
                            <input type="text" name="finance" value="${sfcCominfo.finance}" class="ipt-txt w190">
                            <i class="icon-close"></i>
                        </div>
                    </td>
                    <td class="odd focus-state" width="320px">
                        <div class="item-name w120"><strong class="light"> </strong>固定电话</div>
                        <div class="ipt-box w190 js-ipt-box">
                            <input type="text" name="financeTel" value="${sfcCominfo.financeTel}" class="ipt-txt w190">
                            <i class="icon-close"></i>
                        </div>
                    </td>
                    <td class="odd focus-state" width="320px">
                        <div class="item-name w120"><strong class="light"> </strong>移动电话</div>
                        <div class="ipt-box w190 js-ipt-box">
                            <input type="text" name="financePhone" value="${sfcCominfo.financePhone}" class="ipt-txt w190" >
                            <i class="icon-close"></i>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state" width="320px">
                        <div class="item-name w120"><strong class="light">* </strong>工商联络员</div>
                        <div class="ipt-box w190 js-ipt-box">
                            <input type="text" name="liaName" value="${!empty sfcCominfo.liaName?sfcCominfo.liaName:yrSfcBaseinfo.liaName}" class="ipt-txt w190" readonly>
                           &lt;%&ndash; <i class="icon-close"></i>&ndash;%&gt;
                        </div>
                    </td>
                    <td class="odd focus-state" width="320px">
                        <div class="item-name w120"><strong class="light"> </strong>固定电话</div>
                        <div class="ipt-box w190 js-ipt-box">
                            <input type="text" name="liaTel" value="${sfcCominfo.liaTel}" class="ipt-txt w190">
                            <i class="icon-close"></i>
                        </div>
                    </td>
                    <td class="odd focus-state" width="320px">
                        <div class="item-name w120"><strong class="light">* </strong>移动电话</div>
                        <div class="ipt-box w190 js-ipt-box">
                            <input type="text" name="liaPhone" value="${!empty sfcCominfo.liaPhone?sfcCominfo.liaPhone:yrSfcBaseinfo.liaPhone}" class="ipt-txt w190" readonly>
                           &lt;%&ndash; <i class="icon-close"></i>&ndash;%&gt;
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state" width="320px">
                        <div class="item-name w120"><strong class="light"> </strong>单位电子邮箱</div>
                        <div class="ipt-box w190 js-ipt-box">
                            <input type="text" name="unitEmail" value="${sfcCominfo.unitEmail}" class="ipt-txt w190">
                            <i class="icon-close"></i>
                        </div>
                    </td>
                    <td class="odd focus-state" colspan="2">
                        <div class="item-name w120"><strong class="light"> </strong>联络员电子邮箱</div>
                        <div class="ipt-box w190 js-ipt-box">
                            <input type="text" name="liaEMail" value="${sfcCominfo.liaEMail}" class="ipt-txt w510">
                            <i class="icon-close"></i>
                        </div>
                    </td>

                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</form>--%>

<div class="mod save-box">
    <button class="btn-common btn-save js-btn-save">确定</button>
    <button class="btn-common btn-save js-btn-cancel">取消</button>
</div>

<%--列表参数--%>
<form id="_params">
    <input type="hidden" name="year" value="${year}"/>
    <input type="hidden" name="priPID" value="${priPID}"/>
</form>


<jsp:include page="../../common/footer.jsp"></jsp:include>

<%-- table 列表--%>
<script id="table-template" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td><input type="checkbox" name="_checkbox" value="{{uid}}">{{num @index}}</td>
        <td>{{farArtHonorName}}</td>
        <td>{{farArtHonorIssAut}}</td>
        <td>{{valFrom}}</td>
        <td>{{valTo}}</td>
    </tr>
    {{/each}}
</script>

<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/component/dropDown.js"/>"></script>

<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/client/yr/auxtab/cominfo_edit.js"/>"></script>

</body>

</html>