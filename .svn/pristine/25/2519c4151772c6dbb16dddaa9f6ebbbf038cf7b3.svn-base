<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--私营企业--%>
<c:set var="entTypeImpExtend" value="1122,1130,1151,1152,1212,1222,2122,2130,2151,2152,2212,2222,4500,4510,4550,4530,4570,4560,4580"/>
<%--企业小类--%>
<c:set var="entType" value="${sessionScope.midBaseInfoDto.entType}"/>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>资产状况表填写页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>
<!-- 头部  start-->
<jsp:include page="../../common/reportheader.jsp"></jsp:include>


<div class="fold-msg-bg js-fold-msg" >
    <jsp:include page="../template/view_template.jsp"></jsp:include>
</div>
<!-- 头部  end-->


<input type="hidden" id="_reportState" value="${yrRegCheck.reportState}">  <%--当前年报的状态：--%>
<input type="hidden" id="_year"  value="${year}" />
<input type="hidden" id="priPID" value="${priPID}"/>

<!-- 企业财务信息 -->
<form class="form-horizontal error-bottom" id="yrassetForm">

    <%--资产状况ID--%>
    <input type="hidden" id="assetID" name="assetID" value="${yrAsset.assetID}"/>
    <input type="hidden" name="year" value="${year}"/>
    <input type="hidden" name="priPID" value="${priPID}"/>
    <input type="hidden" name="anCheID" value="${anCheID}"/>

<div class="mod caiwu">
   <div class="mod-bd">

       <div class="mod-hd">
           <jsp:include page="../template/tab_template.jsp"></jsp:include>
       </div>

        <div class="title">
            <h3>企业财务信息</h3>
            <div class="currency">币种：<strong class="light">人民币</strong></div>
            <p>以下信息请比照你企业${year}年度资产负债表、利润表等财务报表信息进行填写</p>
        </div>
        <div class="content mod-bd-panel">
            <table class="table-public table-caiwu" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name">货币资金</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="moneFunds" name="moneFunds" value="${yrAsset.moneFunds}" class="ipt-txt assetItem units billionCheck" placeholder="请输入金额" data-title="货币资金">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                    <td class="even focus-state">
                        <div class="item-name">应付账款</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="accPay" value="${yrAsset.accPay}" class="ipt-txt assetItem units billionCheck" placeholder="请输入金额" data-title="应付账款">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name">应收账款</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="accRec" name="accRec" value="${yrAsset.accRec}" class="ipt-txt assetItem units billionCheck" placeholder="请输入金额" data-title="应收账款">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                    <td class="even focus-state">
                        <div class="item-name">其他应付款</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="othPay" name="othPay" value="${yrAsset.othPay}" class="ipt-txt assetItem units billionCheck" placeholder="请输入金额" data-title="其他应付款">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name">其他应收款</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="othAccRec" name="othAccRec" value="${yrAsset.othAccRec}" class="ipt-txt assetItem units billionCheck" placeholder="请输入金额" data-title="其他应收款">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                    <td class="even focus-state">
                        <div class="item-name">流动负债合计</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="totCurrLiab" name="totCurrLiab" value="${yrAsset.totCurrLiab}" class="ipt-txt assetItem units billionCheck" placeholder="请输入金额" data-title="流动负债合计">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name">存货</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="inventory" name="inventory" value="${yrAsset.inventory}" class="ipt-txt assetItem units billionCheck" placeholder="请输入金额" data-title="存货">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                    <td class="even focus-state">
                        <div class="item-name bg">
                            <i class="icon-question" id="fzze" data-id="fzze" data-msg="负债总额  ≥ 流动负债合计"></i>
                            负债总额
                        </div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="liaGro" name="liaGro" value="${yrAsset.liaGro}" class="ipt-txt assetItem units billionCheck" placeholder="请输入金额" data-title="负债总额">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                        <div class="radio-box">
                            <label><input type="radio" name="liaGroIsPub" value="1" <c:if test="${yrAsset.liaGroIsPub=='1'}">checked</c:if> >公示</label>
                            <label><input type="radio" name="liaGroIsPub" value="0" <c:if test="${yrAsset.liaGroIsPub=='0'}">checked</c:if> >不公示</label>
                        </div>
                    </td>

                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name">
                            <i class="icon-question" id="A" data-id="A" data-msg="流动资产合计≥ 货币资金+应收账款+其他应收款+存货"></i>
                            流动资产合计
                        </div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="totCurrAssets" name="totCurrAssets" value="${yrAsset.totCurrAssets}" class="ipt-txt assetItem units billionCheck" placeholder="请输入金额" data-title="流动资产合计">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                    <td class="odd focus-state">
                        <div class="item-name">
                          <%--  <i class="icon-question" id="sszb" data-id="sszb" data-msg="实收资本 <= 所有者权益合计"></i>--%>
                            实收资本
                        </div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="recCap" name="recCap" value="${yrAsset.recCap}" class="ipt-txt assetItem units billionCheck" placeholder="请输入金额" data-title="实收资本">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name">长期投资</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="longInvest" name="longInvest" value="${yrAsset.longInvest}" class="ipt-txt assetItem units billionCheck" placeholder="请输入金额" data-title="长期投资">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                    <td class="even focus-state">
                        <div class="item-name bg">所有者权益合计</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="totEqu" name="totEqu" value="${yrAsset.totEqu}" class="ipt-txt assetItem units billionCheck" placeholder="请输入金额" data-title="所有者权益合计">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                        <div class="radio-box">
                            <label><input type="radio" name="totEquIsPub" value="1"  <c:if test="${yrAsset.totEquIsPub=='1'}">checked</c:if>>公示</label>
                            <label><input type="radio" name="totEquIsPub" value="0"  <c:if test="${yrAsset.totEquIsPub=='0'}">checked</c:if>>不公示</label>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name">
                            <i class="icon-question" id="gdzc" data-id="gdzc" data-msg="请按照固定资产净值填写"></i>
                            固定资产
                        </div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="fixAssets" name="fixAssets" value="${yrAsset.fixAssets}" class="ipt-txt assetItem units billionCheck" placeholder="请输入金额" data-title="固定资产">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                    <td class="even focus-state">
                        <span class="line"></span>
                        <div class="item-name bg">营业总收入</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="vendInc" name="vendInc" value="${yrAsset.vendInc}" class="ipt-txt assetItem units billionCheck" placeholder="请输入金额" data-title="营业总收入">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                        <div class="radio-box">
                            <label><input type="radio" name="vendIncIsPub" value="1" <c:if test="${yrAsset.vendIncIsPub=='1'}">checked</c:if>>公示</label>
                            <label><input type="radio" name="vendIncIsPub" value="0" <c:if test="${yrAsset.vendIncIsPub=='0'}">checked</c:if>>不公示</label>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td class="odd focus-state">
                        <div class="item-name">无形资产</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="intAssets" name="intAssets" value="${yrAsset.intAssets}" class="ipt-txt assetItem units billionCheck" placeholder="请输入金额" data-title="无形资产">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                    <td class="even focus-state">
                        <span class="line-portrait"></span>
                        <span class="item-name bg">
                            <span class="item-name-box">其中：主营业务收入</span>
                        </span>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="maiBusInc" name="maiBusInc" value="${yrAsset.maiBusInc}" class="ipt-txt assetItem units billionCheck" placeholder="请输入金额" data-title="主营业务收入">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                        <div class="radio-box">
                            <label><input type="radio" name="maiBusIncIsPub" value="1" <c:if test="${yrAsset.maiBusIncIsPub=='1'}">checked</c:if>>公示</label>
                            <label><input type="radio" name="maiBusIncIsPub" value="0" <c:if test="${yrAsset.maiBusIncIsPub=='0'}">checked</c:if>>不公示</label>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td class="odd focus-state">
                        <div class="item-name bg">
                            <i class="icon-question" id="B" data-id="B" data-msg="资产总额=负债总额+所有者权益合计<br>资产总额≥ 流动资产合计+长期投资+固定资产+无形资产"></i>
                            资产总额
                        </div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="assGro" name="assGro" value="${yrAsset.assGro}" class="ipt-txt assetItem units billionCheck" placeholder="请输入金额" data-title="资产总额">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                        <div class="radio-box">
                            <label><input type="radio" name="assGroIsPub" value="1" <c:if test="${yrAsset.assGroIsPub=='1'}">checked</c:if>>公示</label>
                            <label><input type="radio" name="assGroIsPub" value="0" <c:if test="${yrAsset.assGroIsPub=='0'}">checked</c:if>>不公示</label>
                        </div>
                    </td>
                    <td class="even focus-state">
                        <div class="item-name bg">利润总额</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="proGro" value="${yrAsset.proGro}" class="ipt-txt assetItem units billionCheck" placeholder="请输入金额" data-title="利润总额">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                        <div class="radio-box">
                            <label><input type="radio" name="proGroIsPub" value="1" <c:if test="${yrAsset.proGroIsPub=='1'}">checked</c:if>>公示</label>
                            <label><input type="radio" name="proGroIsPub" value="0" <c:if test="${yrAsset.proGroIsPub=='0'}">checked</c:if>>不公示</label>
                        </div>
                    </td>

                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name ">
                           <%-- <i class="icon-question" id="ckchze" data-id="ckchze" data-msg="出口创汇额 ≤ 营业总收入"></i>--%>
                            ${year}年出口创汇总额
                        </div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="expGro" name="expGro" value="${yrAsset.expGro}" class="ipt-txt assetItem units billionCheck" placeholder="请输入金额" data-title="2016年出口创汇总额">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                    <td class="even focus-state">
                        <div class="item-name bg">净利润</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="netInc" value="${yrAsset.netInc}" class="ipt-txt assetItem units billionCheck" placeholder="请输入金额" data-title="净利润">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                        <div class="radio-box">
                            <label><input type="radio" name="netIncIsPub" value="1" <c:if test="${yrAsset.netIncIsPub=='1'}">checked</c:if>>公示</label>
                            <label><input type="radio" name="netIncIsPub" value="0" <c:if test="${yrAsset.netIncIsPub=='0'}">checked</c:if>>不公示</label>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="even focus-state">
                        <div class="item-name special-h">
                            ${year}年研究开发、技术改造、科技创新等方面的支出
                        </div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="intelGro" value="${yrAsset.intelGro}" class="ipt-txt assetItem units billionCheck" placeholder="请输入金额" data-title="${year}年研究开发、技术改造、科技创新等方面的支出">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                   <c:if test="${year>2015}">
                    <td class="odd focus-state">
                        <div class="item-name bg">
                            <i class="icon-question" id="qykgqk" data-id="qykgqk" data-msg="指企业实收资本中某种经济成分的出资人的实际投资情况，或出资人对企业资产的实际控制、支配程度进行分类。"></i>
                            企业控股情况
                        </div>
                           <c:if test="${fn:indexOf(entTypeImpExtend,entType) == -1}">
                                <div class="ipt-box">
                                    <select id="entControl" name="entControl" class="ipt-txt" >
                                        <option value="" >--请选择--</option>
                                        <option value="1" <c:if test="${yrAsset.entControl=='1'}">selected</c:if> >国有控股</option>
                                        <option value="2" <c:if test="${yrAsset.entControl=='2'}">selected</c:if>>集体控股</option>
                                        <option value="3" <c:if test="${yrAsset.entControl=='3'}">selected</c:if>>私人控股</option>
                                        <option value="4" <c:if test="${yrAsset.entControl=='4'}">selected</c:if>>港澳台商控股</option>
                                        <option value="5" <c:if test="${yrAsset.entControl=='5'}">selected</c:if>>外商控股</option>
                                        <option value="6" <c:if test="${yrAsset.entControl=='6'}">selected</c:if> >其他</option>
                                    </select>
                                </div>
                           </c:if>
                            <%--私营企业--%>
                           <c:if test="${fn:indexOf(entTypeImpExtend,entType) != -1}">
                               <input type="text" value="私营企业" class="ipt-txt" readonly/>
                               <input type="hidden" name="entControl" value="7" class="ipt-txt"/>
                           </c:if>
                         &nbsp;&nbsp;&nbsp;
                        <div class="radio-box">
                            <label><input type="radio" name="entControlIsPub" value="1" <c:if test="${yrAsset.entControlIsPub=='1'}">checked</c:if>>公示</label>
                            <label><input type="radio" name="entControlIsPub" value="0" <c:if test="${yrAsset.entControlIsPub=='0'}">checked</c:if>>不公示</label>
                        </div>
                    </td>
                   </c:if>
                </tr>
                <tr>
                    <td class="odd focus-state" colspan="2">
                        <div class="item-name bg">企业当前的经营状态</div>
                        <div class="radio-box">
                            <label><input type="radio" rel="busStatusCN" name="busSt" value="1" data-text="正常开业"  <c:if test="${yrAsset.busSt=='1'}">checked</c:if>>正常开业</label>
                            <label><input type="radio" rel="busStatusCN" name="busSt" value="2" data-text="筹建"      <c:if test="${yrAsset.busSt=='2'}">checked</c:if>>筹建</label>
                            <label><input type="radio" rel="busStatusCN" name="busSt" value="4" data-text="停业、歇业" <c:if test="${yrAsset.busSt=='4'}">checked</c:if>>停业、歇业</label>
                            <label><input type="radio" rel="busStatusCN" name="busSt" value="5" data-text="正在清算中" <c:if test="${yrAsset.busSt=='5'}">checked</c:if>>正在清算中</label>
                            <input type="hidden" id="busStatusCN" name="busStatusCN" value="${yrAsset.busStatusCN}"/>
                        </div>
                    </td>
                </tr>

                <tr id="_noBusRea">
                    <td class="odd focus-state" colspan="2">
                        <div class="item-name special">无经营活动收入或歇业的原因</div>
                        <div class="ipt-box">
                            <textarea id="noBusRea" name="noBusRea" class="textarea">${yrAsset.noBusRea}</textarea>
                        </div>
                    </td>
                </tr>

                <c:if test="${year>2015}">
                <tr>
                    <td class="odd focus-state" colspan="2">
                        <div class="item-name special bg">
                            <i class="icon-question" id="qyzyywhd" data-id="qyzyywhd" data-msg="指企业实际从事的主要业务活动"></i>
                            企业主营业务活动
                        </div>
                        <div class="ipt-box">
                            <textarea id="entMainBusActivity" name="entMainBusActivity" class="textarea"  placeholder="指企业实际从事的主要业务活动">${yrAsset.entMainBusActivity}</textarea>
                        </div>

                    </td>
                </tr>
                </c:if>
            </table>
        </div>
    </div>
</div>

        <!-- 企业融资情况 -->
        <div class="mod rongzi">
            <div class="mod-hd">
                <div class="title">
                    <h3>企业融资情况</h3>
                    <div class="currency">币种：<strong class="light">人民币</strong></div>
                </div>
            </div>
            <div class="mod-bd">
                <div class="content content-rongzi">
                    <table class="table-public table-rongzi" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <tr>
                            <td class="odd focus-state">
                                <div class="item-name">${year}年从金融机构获得贷款总额</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="finOrgLoan" value="${yrAsset.finOrgLoan}" class="ipt-txt million_yuan millionUnits" placeholder="请输入金额">
                                    <i class="icon-close"></i>
                                </div>
                                <strong class="light">万元</strong>
                            </td>
                            <td class="even focus-state">
                                <div class="item-name">${year}年从小额贷款公司等其他渠道融资总额</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="comLoan" value="${yrAsset.comLoan}" class="ipt-txt million_yuan millionUnits" placeholder="请输入金额">
                                    <i class="icon-close"></i>
                                </div>
                                <strong class="light">万元</strong>
                            </td>
                        </tr>
                        <tr>
                            <td class="odd focus-state">
                                <div class="item-name">截止${year}年末，从金融机构获得的贷款余额</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="endLoan" value="${yrAsset.endLoan}" class="ipt-txt million_yuan millionUnits" placeholder="请输入金额">
                                    <i class="icon-close"></i>
                                </div>
                                <strong class="light">万元</strong>
                            </td>
                            <td class="even focus-state">
                                <div class="item-name">${year}年贷款利息支出总额</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="payLoan" value="${yrAsset.payLoan}" class="ipt-txt million_yuan millionUnits" placeholder="请输入金额">
                                    <i class="icon-close"></i>
                                </div>
                                <strong class="light">万元</strong>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>


<!-- 企业税费缴纳 -->
<div class="mod shuifei">
    <div class="mod-hd">
        <div class="title">
            <h3>企业税费缴纳</h3>
            <div class="currency">币种：<strong class="light">人民币</strong></div>
            <p>以下信息请按照国税、地税全年实际纳税总额（与国地税纳税申报表缴纳数据相符）填写</p>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-shuifei">
            <table class="table-public table-shuifei" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name">增值税</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="addTax" name="addTax" value="${yrAsset.addTax}" class="ipt-txt assetItem units" placeholder="请输入金额">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                    <td class="even focus-state">
                        <div class="item-name special">城市维护建设税</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="cityTax" name="cityTax" value="${yrAsset.cityTax}" class="ipt-txt assetItem units" placeholder="请输入金额">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name">营业税</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="mngTax" name="mngTax" value="${yrAsset.mngTax}" class="ipt-txt assetItem units" placeholder="请输入金额">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                    <td class="even focus-state">
                        <div class="item-name special">印花税</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="floTax" name="floTax" value="${yrAsset.floTax}" class="ipt-txt assetItem units" placeholder="请输入金额">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name">消费税</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="expenseTax" name="expenseTax" value="${yrAsset.expenseTax}" class="ipt-txt assetItem units" placeholder="请输入金额">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                    <td class="even focus-state">
                        <div class="item-name special">企业所得税</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="entTax" name="entTax" value="${yrAsset.entTax}" class="ipt-txt assetItem units" placeholder="请输入金额">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name">土地增值税</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="landTax" name="landTax" value="${yrAsset.landTax}" class="ipt-txt assetItem units" placeholder="请输入金额">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                    <td class="even focus-state">
                        <div class="item-name special">个人所得税</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="personTax" name="personTax" value="${yrAsset.personTax}" class="ipt-txt assetItem units" placeholder="请输入金额">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>

                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name">关税</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="dutyTax" name="dutyTax" value="${yrAsset.dutyTax}" class="ipt-txt assetItem units" placeholder="请输入金额">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                    <td class="even focus-state">
                        <div class="item-name special">房产税</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="houseTax" name="houseTax" value="${yrAsset.houseTax}" class="ipt-txt assetItem units" placeholder="请输入金额">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name">教育费附加</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="techTax" name="techTax" value="${yrAsset.techTax}" class="ipt-txt assetItem units" placeholder="请输入金额">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                    <td class="even focus-state">
                        <div class="item-name special">城镇土地使用税</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="lanUseTax" name="lanUseTax" value="${yrAsset.lanUseTax}" class="ipt-txt assetItem units" placeholder="请输入金额">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name">水利基金</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="waterTax" name="waterTax" value="${yrAsset.waterTax}" class="ipt-txt assetItem units" placeholder="请输入金额">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                    <td class="even focus-state">
                        <div class="item-name special">其他</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="otherTax" name="otherTax" value="${yrAsset.otherTax}" class="ipt-txt assetItem units" placeholder="请输入金额">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name bg">
                            <i class="icon-question" id="C" data-id="C" data-msg="纳税总额=增值税+城市维护建设税+营业税+印花税+消费税+企业所得税+土地增值税+个人所得税+关税+房产税+教育费附加+城镇土地使用税+水利基金+其他"></i>
                            纳税总额
                        </div>
                        <div class="ipt-box">
                            <input type="text" id="ratGro" name="ratGro" value="${yrAsset.ratGro}" class="ipt-txt assetItem units millionCheck" readonly data-title="">
                        </div>
                        <strong class="light">元</strong>
                        <div class="radio-box">
                            <label><input type="radio" name="ratGroIsPub" value="1" <c:if test="${yrAsset.ratGroIsPub=='1'}">checked</c:if>>公示</label>
                            <label><input type="radio" name="ratGroIsPub" value="0" <c:if test="${yrAsset.ratGroIsPub=='0'}">checked</c:if>>不公示</label>
                        </div>
                    </td>
                    <td class="even focus-state">
                        <div class="item-name special">${year}年是否享受小微企业减免残保金政策</div>
                        <div class="radio-box">
                            <label><input type="radio" name="isMinDis" value="1" <c:if test="${yrAsset.isMinDis=='1'}">checked</c:if>>是</label>
                            <label><input type="radio" name="isMinDis" value="0" <c:if test="${yrAsset.isMinDis=='0'}">checked</c:if>>否</label>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name">${year}年减免国税</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="minNationTax" value="${yrAsset.minNationTax}" class="ipt-txt assetItem units" placeholder="请输入金额">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                    <td class="even focus-state">
                        <div class="item-name special bg">
                            <i class="icon-question" id="sfyfjlbj" data-id="sfyfjlbj" data-msg="根据《中华人民共和国残疾人保障法》、《浙江省残疾人保障条例》、《浙江省残疾人就业办法》等法律法规规定：国家机关、社会团体、企业事业单位、民办非企业单位等各类用人单位，均应按本单位在职职工总数百分之一点五比例安排残疾人就业。未达到该比例的，按其差额人数和上年度本地区职工平均工资的百分之一百缴纳残疾人就业保障金。"></i>
                            ${year}年是否依法交纳残保金</div>
                        <div class="radio-box">
                            <label><input type="radio" name="isLegPay" value="1" <c:if test="${yrAsset.isLegPay=='1'}">checked</c:if>>是</label>
                            <label><input type="radio" name="isLegPay" value="0" <c:if test="${yrAsset.isLegPay=='0'}">checked</c:if>>否</label>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name">${year}年减免地税</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="minLandTax" value="${yrAsset.minLandTax}" class="ipt-txt assetItem units" placeholder="请输入金额">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- 企业用工情况 -->
<div class="mod yonggong">
    <div class="mod-hd">
        <div class="title">
            <h3>企业用工情况</h3>
            <p>以下信息请按照你企业当前最新的实际情况填写。</p>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-yonggong">
            <table class="table-public table-yonggong" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name bg">
                            <i class="icon-question" id="qycyrs" data-id="qycyrs" data-msg="“企业从业人员”指企业雇佣且签订劳动合同的所有人员"></i>
                            企业从业人员数
                        </div>
                        <div class="item-type focus-state">
                            <div class="ipt-box js-ipt-box" <%--data-tips-message="企业人员" data-tips-options='{"time":-1,"tips":1}'--%>>
                                <input type="text" id="empNum" name="empNum" value="${yrAsset.empNum}" class="ipt-txt ">
                                <i class="icon-close"></i>
                            </div>
                            人
                        </div>
                        <div class="radio-box">
                            <label><input type="radio" name="empNumDis" value="1" <c:if test="${yrAsset.empNumDis=='1'}">checked</c:if>>公示</label>
                            <label><input type="radio" name="empNumDis" value="0" <c:if test="${yrAsset.empNumDis=='0'}">checked</c:if>>不公示</label>
                        </div>
                    </td>
                </tr>
                <c:if test="${year>2015}">
                <tr>
                    <td class="even focus-state">
                        <div class="item-name bg">(其中女性从业人数)</div>
                        <div class="item-type focus-state">
                            <div class="ipt-box js-ipt-box" >
                                <input type="text" id="femaleEmploye" name="femaleEmploye" value="${yrAsset.femaleEmploye}" class="ipt-txt">
                                <i class="icon-close"></i>
                            </div>
                            人
                        </div>
                        <div class="radio-box">
                            <label><input type="radio" name="femaleEmployeIsPub" value="1" <c:if test="${yrAsset.femaleEmployeIsPub=='1'}">checked</c:if>>公示</label>
                            <label><input type="radio" name="femaleEmployeIsPub" value="0" <c:if test="${yrAsset.femaleEmployeIsPub=='0'}">checked</c:if>>不公示</label>
                        </div>
                    </td>
                </tr>
                </c:if>

                <c:if test="${fn:indexOf(entTypeImpExtend,entType) != -1}">
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name">企业法定代表人是否属于</div>
                        <div class="radio-box">
                            <div class="item-type focus-state">
                                <label><input type="radio" name="isLegRep" value="1" <c:if test="${yrAsset.isLegRep=='1'}">checked</c:if>>高校毕业生</label>
                                <i class="icon-question" id="gxbys" data-id="gxbys" data-msg="高校毕业生”指截止${year}年末毕业两年内的高校毕业生"></i>
                            </div>
                            <div class="item-type focus-state">
                                <label><input type="radio" name="isLegRep" value="2" <c:if test="${yrAsset.isLegRep=='2'}">checked</c:if>>退役士兵</label>
                            </div>
                            <div class="item-type focus-state">
                                <label><input type="radio" name="isLegRep" value="3" <c:if test="${yrAsset.isLegRep=='3'}">checked</c:if>>残疾人</label>
                                <i class="icon-question" id="cjr" data-id="cjr" data-msg="“残疾人”须持有二代残疾人证。同一人员只能按照一种人员类别进行统计"></i>
                            </div>
                            <div class="item-type focus-state">
                                <label><input type="radio" name="isLegRep" value="4" <c:if test="${yrAsset.isLegRep=='4'}">checked</c:if>>失业人员再就业</label>
                            </div>
                            <div class="item-type focus-state">
                                <label><input type="radio" name="isLegRep" value="5" <c:if test="${yrAsset.isLegRep=='5'}">checked</c:if>>都不是</label>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd other">
                        <div class="item-name">从业人员中属于</div>
                        <div class="item-type focus-state">
                            <span class="people">高校毕业生</span>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="uniGradOpers" name="uniGradOpers" value="${yrAsset.uniGradOpers}" class="ipt-txt small">
                                <i class="icon-close"></i>
                            </div>
                            人
                        </div>
                        <div class="item-type focus-state">
                            <span class="people">退役士兵</span>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="exSoldOpers" name="exSoldOpers" value="${yrAsset.exSoldOpers}" class="ipt-txt small">
                                <i class="icon-close"></i>
                            </div>
                            人
                        </div>
                        <div class="item-type focus-state">
                            <span class="bg people">残疾人</span>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="disOpers" name="disOpers" value="${yrAsset.disOpers}" class="ipt-txt small">
                                <i class="icon-close"></i>
                            </div>
                            人
                        </div>
                        <div class="item-type focus-state">
                            <span class="people">失业人员再就业</span>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="unemOpers" name="unemOpers" value="${yrAsset.unemOpers}" class="ipt-txt small">
                                <i class="icon-close"></i>
                            </div>
                            人
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd other">
                        <div class="item-name">从业人员中${year}年新雇佣</div>
                        <div class="item-type focus-state">
                            <span class="people">高校毕业生</span>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="uniGradEmps" name="uniGradEmps" value="${yrAsset.uniGradEmps}" class="ipt-txt small">
                                <i class="icon-close"></i>
                            </div>
                            人
                        </div>
                        <div class="item-type focus-state">
                            <span class="people">退役士兵</span>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="exSoldEmps" name="exSoldEmps" value="${yrAsset.exSoldEmps}" class="ipt-txt small">
                                <i class="icon-close"></i>
                            </div>
                            人
                        </div>
                        <div class="item-type focus-state">
                            <span class="people">残疾人</span>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="disEmps" name="disEmps" value="${yrAsset.disEmps}" class="ipt-txt small">
                                <i class="icon-close"></i>
                            </div>
                            人
                        </div>
                        <div class="item-type focus-state">
                            <span class="people">失业人员再就业</span>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="unemEmps" name="unemEmps" value="${yrAsset.unemEmps}" class="ipt-txt small">
                                <i class="icon-close"></i>
                            </div>
                            人
                        </div>
                    </td>
                </tr>
                </c:if>

                <c:if test="${fn:indexOf(entTypeImpExtend,entType) == -1}">
                    <tr>
                        <td>
                            <div class="item-type focus-state">
                                <span class="people" style="width: 170px;background-color: #8be1b1">从业人员中属于残疾人雇工人数</span>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="disOpers" name="disOpers" value="${yrAsset.disOpers}" class="ipt-txt small">
                                    <i class="icon-close"></i>
                                </div>
                                人
                            </div>
                        </td>
                    </tr>
                </c:if>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name bg">
                            <i class="icon-question" id="qyyazcjrs" data-id="qyyazcjrs" data-msg="根据相关法律法规规定，国家机关、社会团体、企业事业单位、民办非企业单位等各类用人单位，均应按本单位在职职工总数百分之一点五比例安排残疾人就业。"></i>
                            企业应安置残疾人员数
                        </div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="entOugthSetDis" name="entOugthSetDis" value="${yrAsset.entOugthSetDis}" class="ipt-txt ">
                            <i class="icon-close"></i>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name bg">企业已安置残疾人员数</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="entSetDis" name="entSetDis" value="${yrAsset.entSetDis}" class="ipt-txt ">
                            <i class="icon-close"></i>
                        </div>
                    </td>
                </tr>
            </table>
            <c:if test="${fn:indexOf(entTypeImpExtend,entType) != -1}">
                <div class="tips">
                    <i class="icon-triangle"></i>同一人员只能按照一种人员类别进行统计。
                </div>
            </c:if>


        </div>
    </div>
</div>
<!-- 企业经营费用 -->
<div class="mod jingying">
    <div class="mod-hd">
        <div class="title">
            <h3>企业经营情况</h3>
            <div class="currency">币种：<strong class="light">人民币</strong></div>
            <p>以下信息请按照你企业${year}年1月1日至12月31日期间的费用填写</p>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-jingying">
            <table class="table-public table-jingying" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name">${year}年水电费支出总额</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="waterFee" value="${yrAsset.waterFee}" class="ipt-txt assetItem units millionCheck" placeholder="请输入金额" data-title="${year}年水电费支出总额">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                    <td class="even focus-state">
                        <div class="item-name">${year}年工资支出总额</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="salaryFee" name="salaryFee" value="${yrAsset.salaryFee}" class="ipt-txt assetItem units" placeholder="请输入金额" data-title="${year}年工资支出总额">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name">${year}年房租(含物业费)支出总额</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text"  name="rentFee" value="${yrAsset.rentFee}" class="ipt-txt assetItem units millionCheck" placeholder="请输入金额" data-title="${year}年房租(含物业费)支出总额">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                    <td class="even focus-state">
                        <div class="item-name">${year}年五险一金支出总额</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="socFee" name="socFee" value="${yrAsset.socFee}" class="ipt-txt assetItem units millionCheck" placeholder="请输入金额" data-title="${year}年五险一金支出总额">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>

<div class="btn-box">
    <c:if test="${yrForm.asset!='1'}">
        <input type="button" value="暂存" class="btn-common btn-save js-temporary">
    </c:if>
    <button id="save" type="submit" class="btn-common btn-save js-save">保存</button>

</div>

</form>

<jsp:include page="../../common/footer.jsp"></jsp:include>
<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/component/dropDown.js"/>"></script>
<%--jsp页面传递给js的参数值--%>
<script>
    window._CONFIG = {
       _entype:'${fn:indexOf(entTypeImpExtend,entType)}', //获取企业类型小类是否属于列出的类型值
        _priPid:'${priPID}',  //获取主体身份代码
        _year:'${year}' //年份
    }

</script>


<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/client/yr/asset/edit_main.js"/>"></script>



</body>
</html>
