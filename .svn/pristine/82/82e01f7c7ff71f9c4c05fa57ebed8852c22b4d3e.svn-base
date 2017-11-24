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
    <style>
        .mod{
            width: auto;
        }
    </style>
</head>
<body class="pd10">
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
                                <div class="item-txt">
                                    <c:if test="${sfcCominfo.farArtType=='1'}"> 种植类</c:if> 
                                    <c:if test="${sfcCominfo.farArtType=='2'}"> 养殖类</c:if>
                                    <c:if test="${sfcCominfo.farArtType=='3'}"> 服务类</c:if>
                                    <c:if test="${sfcCominfo.farArtType=='4'}"> 营销类</c:if>
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
                                ${sfcCominfo.farArtProName}
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
                                ${sfcCominfo.farArtMemNum}
                            </div>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name">生产基地面积(亩)</div>
                            <div class="ipt-box js-ipt-box">
                                ${sfcCominfo.farArtArea}
                            </div>
                        </td>
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name w225">带动农户(户)</div>
                            <div class="ipt-box js-ipt-box">
                                ${sfcCominfo.farArtDriFarmerNum}
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name">自有产权房面积(平方米)</div>
                            <div class="ipt-box js-ipt-box">
                                ${sfcCominfo.farArtPriProArea}
                            </div>
                        </td>
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name w225">自有生产经营设备价值(万元)</div>
                            <div class="ipt-box js-ipt-box">
                               ${sfcCominfo.farArtOpeEquVal}
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name">合作社投资总规模(万元)</div>
                            <div class="ipt-box js-ipt-box">
                                ${sfcCominfo.farArtCoopTotalInv}
                            </div>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name">其中：成员出资(万元)</div>
                            <div class="ipt-box js-ipt-box">
                                ${sfcCominfo.farArtMemInv}
                            </div>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name">贷款额(万元)</div>
                            <div class="ipt-box js-ipt-box">
                                ${sfcCominfo.farArtLoanAmount}
                            </div>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name">政府补助(万元)</div>
                            <div class="ipt-box js-ipt-box">
                                ${sfcCominfo.farArtGovGrants}
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
                            <div class="ipt-box js-ipt-box">
                               <c:if test="${sfcCominfo.farArtMarketing =='1'}"> 省内</c:if> 
                               <c:if test="${sfcCominfo.farArtMarketing =='2'}"> 省外</c:if> 
                               <c:if test="${sfcCominfo.farArtMarketing =='3'}"> 国外</c:if> 
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name">上年度销售总额(万元)</div>
                            <div class="ipt-box js-ipt-box">
                                ${!empty sfcCominfo.farArtTotalSales?sfcCominfo.farArtTotalSales: vendInc}
                            </div>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name">销售额年增长率(%)</div>
                            <div class="ipt-box js-ipt-box">
                                ${sfcCominfo.farArtSalesIncRatio}
                            </div>
                        </td>
                        <td class="odd w165 focus-state" colspan="2">
                            <div class="item-name w165">利润总额(万元)</div>
                            <div class="ipt-box js-ipt-box">
                                ${sfcCominfo.farArtTotalProfit}
                            </div>
                        </td>

                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name">全年纳税总额(万元)</div>
                            <div class="ipt-box js-ipt-box">
                                ${!empty sfcCominfo.farArtTaxAmount?sfcCominfo.farArtTaxAmount:ratGro}
                            </div>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name">其中：所得税总额(万元)</div>
                            <div class="ipt-box js-ipt-box">
                                ${sfcCominfo.farArtGroIncTax}
                            </div>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name ">享受扶持资金(万元)</div>
                            <div class="ipt-box js-ipt-box">
                                ${sfcCominfo.farArtSupFinancing}
                            </div>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name">税费减免总额(万元)</div>
                            <div class="ipt-box js-ipt-box">
                                ${sfcCominfo.farArtTotalTaxCuts}
                            </div>
                        </td>

                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name">社员年均纯收入(元)</div>
                            <div class="ipt-box js-ipt-box">
                                ${sfcCominfo.farArtAreNetIncome}
                            </div>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name">统一采购农业投入品比例(%)</div>
                            <div class="ipt-box js-ipt-box">
                                ${sfcCominfo.farArtInpProRatio}
                            </div>
                        </td>
                        <td class="odd w165 focus-state" colspan="2">
                            <div class="item-name w165">统一销售主产品比例(%)</div>
                            <div class="ipt-box js-ipt-box">
                                ${sfcCominfo.farArtSaleProRatio}
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name">开展初加工后销售</div>
                            <div class="ipt-box js-ipt-box">
                                  <c:if test="${sfcCominfo.farArtPreSales =='1'}"> 是</c:if>
                                  <c:if test="${sfcCominfo.farArtPreSales =='0'}"> 否</c:if> 
                            </div>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name">开展深加工后销售</div>
                            <div class="ipt-box js-ipt-box">
                                  <c:if test="${sfcCominfo.farArtDeepSales =='1'}"> 是</c:if>
                                  <c:if test="${sfcCominfo.farArtDeepSales =='0'}"> 否</c:if>
                            </div>
                        </td>
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name">实现农超对接</div>
                            <div class="ipt-box js-ipt-box">
                                  <c:if test="${sfcCominfo.farArtLinkFarSupmarket =='1'}"> 是</c:if>
                                  <c:if test="${sfcCominfo.farArtLinkFarSupmarket =='0'}"> 否</c:if>
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
                                ${sfcCominfo.farArtOtherItem}
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
                            <div class="ipt-box js-ipt-box ">
                                  <c:if test="${sfcCominfo.farArtTecTrain =='1'}"> 有</c:if>
                                  <c:if test="${sfcCominfo.farArtTecTrain =='0'}"> 无</c:if>
                            </div>
                        </div>
                    </td>
                    <td class="odd focus-state">
                        <div class="item-name"><strong class="light">* </strong>培训师来源</div>
                        <div class="ipt-box">
                            <div class="check-box">
                                <label class="pdr20"><input type="checkbox" name="farArtTeaExt" value="1" ${sfcCominfo.farArtTeaExt=='1'?'checked':''}>外聘</label>
                                <label class="pdr20"><input type="checkbox" name="farArtTeaInt" value="1" ${sfcCominfo.farArtTeaInt=='1'?'checked':''}>自有</label>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name"><strong class="light">* </strong>上年度组织或参加培训总数(次)</div>
                        <div class="ipt-box js-ipt-box">
                            ${sfcCominfo.farArtTrainNum}
                        </div>
                    </td>
                    <td class="odd focus-state">
                        <div class="item-name"><strong class="light">* </strong>参加培训人数(人/次)</div>
                        <div class="ipt-box js-ipt-box">
                            ${sfcCominfo.farArtMemAttNum}
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state" colspan="2">
                        <div class="item-name"><strong class="light">* </strong>已开展的质量工作有</div>
                        <div class="ipt-box">
                            <div class="check-box">
                                <label class="pdr20"><input type="checkbox" id="farArtQuaSta" class="work" name="farArtQuaSta"     value="1"  ${sfcCominfo.farArtQuaSta=='1'?'checked':''} >执行农产品质量标准</label>
                                <label class="pdr20"><input type="checkbox" class="work" name="farArtQuaTraSys"  value="1"  ${sfcCominfo.farArtQuaTraSys=='1'?'checked':''} >建立农产品质量追溯制度</label>
                                <label class="pdr20"><input type="checkbox" class="work" name="farArtQuaSys"     value="1"  ${sfcCominfo.farArtQuaSys=='1'?'checked':''} >获得产品质量体系认证</label>
                                <label class="pdr20"><input type="checkbox" class="work" name="farArtQuaRiskSys" value="1"  ${sfcCominfo.farArtQuaRiskSys=='1'?'checked':''}>建立风险储备金制度</label>
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
                                    <div class="ipt-box js-ipt-box">
                                  <c:if test="${sfcCominfo.farArtWebsite =='1'}"> 有</c:if>
                                  <c:if test="${sfcCominfo.farArtWebsite =='0'}"> 无</c:if>
                                    </div>
                                </div>
                            </div>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name w100">网站名称</div>
                            <div class="ipt-box js-ipt-box">
                                ${sfcCominfo.farArtWebName}
                            </div>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name w100">网址</div>
                            <div class="ipt-box js-ipt-box">
                                ${sfcCominfo.farArtWebUrl}
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name">运用互联网络发布信息</div>
                            <div class="ipt-box">
                                <div class="ipt-box js-ipt-box">
                                  <c:if test="${sfcCominfo.farArtNetRelInfo =='1'}"> 有</c:if>
                                  <c:if test="${sfcCominfo.farArtNetRelInfo =='0'}"> 无</c:if>
                                </div>
                            </div>
                        </td>
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name w180">其中累计用于网络广告费用(万元)</div>
                            <div class="ipt-box js-ipt-box">
                                ${sfcCominfo.farArtNetAdCost}
                            </div>
                        </td>

                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name">通过网络销售产品或服务</div>
                            <div class="ipt-box">
                                <div class="ipt-box js-ipt-box">
                                  <c:if test="${sfcCominfo.farArtNetSales =='1'}"> 有</c:if>
                                  <c:if test="${sfcCominfo.farArtNetSales =='0'}"> 无</c:if>
                                </div>
                            </div>
                        </td>
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name w180">其中上年度网上销售额(万元)</div>
                            <div class="ipt-box js-ipt-box">
                                ${sfcCominfo.farArtNetSalesAmount}
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
                        <div class="ipt-box js-ipt-box">
                            <span>已获得: </span>
                            <label class="pdr20">
                            ${sfcCominfo.farArtDemoCoopGrade=='1'?'国家级':''}  
                            ${sfcCominfo.farArtDemoCoopGrade=='2'?'省级':''}
                            ${sfcCominfo.farArtDemoCoopGrade=='3'?'市级':''}
                            ${sfcCominfo.farArtDemoCoopGrade=='4'?'县级':''}
                            ${sfcCominfo.farArtDemoCoopGrade=='5'?'目前正在申报':''}
                            </label>
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
                                ${sfcCominfo.farArtBank}
                            </div>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name w100">帐号</div>
                            <div class="ipt-box js-ipt-box">
                                ${sfcCominfo.farArtBankAccount}
                            </div>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name w100">信用等级</div>
                            ${sfcCominfo.farArtCreditLevel=='01'?'AAA':''}
                            ${sfcCominfo.farArtCreditLevel=='02'?'AA':''}
                            ${sfcCominfo.farArtCreditLevel=='03'?'A':''}
                            ${sfcCominfo.farArtCreditLevel=='04'?'B':''}
                            ${sfcCominfo.farArtCreditLevel=='05'?'C':''}
                            ${sfcCominfo.farArtCreditLevel=='06'?'D':''}
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state" width="250">
                            <div class="item-name w110">组织机构代码证号</div>
                            <div class="ipt-box js-ipt-box">
                                ${sfcCominfo.entOrgCode}
                            </div>
                        </td>
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name w100">税务登记证号</div>
                            <div class="ipt-box js-ipt-box">
                                ${sfcCominfo.taxRegNo}
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
                            ${sfcCominfo.farArtIsNpcMem=='0'?'无':''}
                            ${sfcCominfo.farArtIsNpcMem=='1'?'县级':''}
                            ${sfcCominfo.farArtIsNpcMem=='2'?'市级':''}
                            ${sfcCominfo.farArtIsNpcMem=='3'?'省级':''}
                            ${sfcCominfo.farArtIsNpcMem=='4'?'国家级':''} 
                            <label>政协委员</label>
                            ${sfcCominfo.farArtIsCppccMem=='0'?'无':''}
                            ${sfcCominfo.farArtIsCppccMem=='1'?'县级':''}
                            ${sfcCominfo.farArtIsCppccMem=='2'?'市级':''}
                            ${sfcCominfo.farArtIsCppccMem=='3'?'省级':''}
                            ${sfcCominfo.farArtIsCppccMem=='4'?'国家级':''} 
                            <label>党代表</label>
                            ${sfcCominfo.farArtIsPartyRep=='0'?'无':''}
                            ${sfcCominfo.farArtIsPartyRep=='1'?'县级':''}
                            ${sfcCominfo.farArtIsPartyRep=='2'?'市级':''}
                            ${sfcCominfo.farArtIsPartyRep=='3'?'省级':''}
                            ${sfcCominfo.farArtIsPartyRep=='4'?'国家级':''} 
                        </td>
                    </tr>
                    <tr>
                        <td class="odd">
                            <div class="item-name">合作社负责人或社员中获得</div>
                            <label>优秀党员</label>
                            ${sfcCominfo.farArtIsOutPartyMum=='0'?'无':''}
                            ${sfcCominfo.farArtIsOutPartyMum=='1'?'县级':''}
                            ${sfcCominfo.farArtIsOutPartyMum=='2'?'市级':''}
                            ${sfcCominfo.farArtIsOutPartyMum=='3'?'省级':''}
                            ${sfcCominfo.farArtIsOutPartyMum=='4'?'国家级':''} 
                            <label>劳动模范</label>
                            ${sfcCominfo.farArtIsModelWorker=='0'?'无':''}
                            ${sfcCominfo.farArtIsModelWorker=='1'?'县级':''}
                            ${sfcCominfo.farArtIsModelWorker=='2'?'市级':''}
                            ${sfcCominfo.farArtIsModelWorker=='3'?'省级':''}
                            ${sfcCominfo.farArtIsModelWorker=='4'?'国家级':''} 
                            <label>三八红旗手</label>
                            ${sfcCominfo.farArtIsWomSetter=='0'?'无':''}
                            ${sfcCominfo.farArtIsWomSetter=='1'?'县级':''}
                            ${sfcCominfo.farArtIsWomSetter=='2'?'市级':''}
                            ${sfcCominfo.farArtIsWomSetter=='3'?'省级':''}
                            ${sfcCominfo.farArtIsWomSetter=='4'?'国家级':''} 
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



<%--荣誉项--%>
<div class="mod subcapital">
    <div class="mod-hd">
        <div class="title">
            <h3>荣誉项</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content">
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
<form class="form-horizontal error-bottom" id="Form3">
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
                           ${!empty sfcCominfo.leRep?sfcCominfo.leRep:yrSfcBaseinfo.leRep}
                        </div>
                    </td>
                    <td class="odd focus-state" width="320px">
                        <div class="item-name w120"><strong class="light"> </strong>固定电话</div>
                        <div class="ipt-box w190 js-ipt-box">
                            ${sfcCominfo.leRepTel}
                        </div>
                    </td>
                    <td class="odd focus-state" width="320px">
                        <div class="item-name w120"><strong class="light">* </strong>移动电话</div>
                        <div class="ipt-box w190 js-ipt-box">
                            ${!empty sfcCominfo.leRepPhone?sfcCominfo.leRepPhone:yrSfcBaseinfo.leRepPhone}
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state" width="320px">
                        <div class="item-name w120"><strong class="light"> </strong>财务负责人</div>
                        <div class="ipt-box w190 js-ipt-box">
                            ${sfcCominfo.finance}
                        </div>
                    </td>
                    <td class="odd focus-state" width="320px">
                        <div class="item-name w120"><strong class="light"> </strong>固定电话</div>
                        <div class="ipt-box w190 js-ipt-box">
                            ${sfcCominfo.financeTel}
                        </div>
                    </td>
                    <td class="odd focus-state" width="320px">
                        <div class="item-name w120"><strong class="light"> </strong>移动电话</div>
                        <div class="ipt-box w190 js-ipt-box">
                            ${sfcCominfo.financePhone}
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state" width="320px">
                        <div class="item-name w120"><strong class="light">* </strong>工商联络员</div>
                        <div class="ipt-box w190 js-ipt-box">
                            ${!empty sfcCominfo.liaName?sfcCominfo.liaName:yrSfcBaseinfo.liaName}
                        </div>
                    </td>
                    <td class="odd focus-state" width="320px">
                        <div class="item-name w120"><strong class="light"> </strong>固定电话</div>
                        <div class="ipt-box w190 js-ipt-box">
                            ${sfcCominfo.liaTel}
                        </div>
                    </td>
                    <td class="odd focus-state" width="320px">
                        <div class="item-name w120"><strong class="light">* </strong>移动电话</div>
                        <div class="ipt-box w190 js-ipt-box">
                           ${!empty sfcCominfo.liaPhone?sfcCominfo.liaPhone:yrSfcBaseinfo.liaPhone}
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state" width="320px">
                        <div class="item-name w120"><strong class="light"> </strong>单位电子邮箱</div>
                        <div class="ipt-box w190 js-ipt-box">
                            ${sfcCominfo.unitEmail}
                        </div>
                    </td>
                    <td class="odd focus-state" colspan="2">
                        <div class="item-name w120"><strong class="light"> </strong>联络员电子邮箱</div>
                        <div class="ipt-box w190 js-ipt-box">
                            ${sfcCominfo.liaEMail}
                        </div>
                    </td>

                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</form>

<%--列表参数--%>
<form id="_params"> 
    <input type="hidden"   name="year" value="${year}">
    <input type="hidden"   name="priPID" value="${priPID}">
</form>

<%-- table 列表--%>
<script id="table-template" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{num @index}}</td>
        <td>{{farArtHonorName}}</td>
        <td>{{farArtHonorIssAut}}</td>
        <td>{{valFrom}}</td>
        <td>{{valTo}}</td>
    </tr>
    {{/each}}
</script>
<script>
    window._CONFIG = { 
       _sysUrl:'${sysUrl}'
    }
</script>
<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/component/dropDown.js"/>"></script>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/syn/system/composite/sfcgeneralinfo_view_main.js"/>"></script>
</body>
</html>