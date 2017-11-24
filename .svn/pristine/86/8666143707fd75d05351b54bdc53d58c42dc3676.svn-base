<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>企业年报公示预览页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>
<jsp:include page="../../common/header.jsp"></jsp:include>
<div class="banner-bg">
    <div class="mod banner">
        <h4>欢迎您！${midBaseInfoDto.entName}</h4>
        <p>
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

    </div>
</div>
<div class="mod info-title">
    <h5 class="pdt20 center">年报公示信息表</h5>
    <strong class="light">注：以下为年报公示信息，若有误请返回对应的年度报告表中进行修改。</strong>
</div>
<div class="mod">
    <div class="mod-bd">
        <div class="title title-inner">
            <h3>基本信息</h3>
        </div>
        <div class="content">
            <table class="table-public">
                <tbody>
                <tr>
                    <td width="480">
                        <div class="item-name w214"><em>• </em>统一社会信用代码/注册号：</div>
                        <div class="item-txt w222">
                            <c:if test="${empty midBaseInfoDto.uniCode}">${yrBaseInfoList[0].regNO}</c:if>
                            <c:if test="${!empty midBaseInfoDto.uniCode}">${midBaseInfoDto.uniCode}</c:if>
                        </div>
                    </td>
                    <td width="480">
                        <div class="item-name w260"><em>• </em>企业名称：</div>
                        <div class="item-txt w176">${yrBaseInfoList[0].entName}</div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="item-name w214"><em>• </em>企业通信地址：</div>
                        <div class="item-txt w222">${yrOtherInfo.addr}</div>
                    </td>
                    <td>
                        <div class="item-name w260"><em>• </em>邮政编码：</div>
                        <div class="item-txt w176">${yrOtherInfo.postalCode}</div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="item-name w214"><em>• </em>企业联系电话：</div>
                        <div class="item-txt w222">${yrOtherInfo.tel}</div>
                    </td>
                    <td>
                        <div class="item-name w260"><em>• </em>企业电子邮箱：</div>
                        <div class="item-txt w176">${yrOtherInfo.email}</div>
                    </td>
                </tr>
                <tr>
                    <td class="pos-rel">
                        <div class="item-name w214"><em>• </em>从业人数：</div>
                        <div class="item-txt w222">${yrAsset.empNum}人</div>
                        <span class="right-tip pdr0">
                        	<c:if test="${yrAsset.empNumDis == '1'}">公示</c:if>
                    		<c:if test="${yrAsset.empNumDis == '0'}">不公示</c:if>
                        </span>
                    </td>
                    <td class="pos-rel">
                        <c:if test="${year > 2015}">
                            <div class="item-name w260"><em>• </em>其中女性从业人数：</div>
                            <div class="item-txt w176">${yrAsset.femaleEmploye}人</div>
                            <span class="right-tip pdr0">
                        	<c:if test="${yrAsset.femaleEmployeIsPub == '1'}">公示</c:if>
                    		<c:if test="${yrAsset.femaleEmployeIsPub == '0'}">不公示</c:if>
                        </span>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="item-name w214"><em>• </em>企业经营状态：</div>
                        <div class="item-txt w222">${yrAsset.busStatusCN}</div>
                    </td>
                    <td>
                        <c:if test="${fn:indexOf(repType,'forinvestment') != -1 && year > 2015}">
                            <div class="item-name w260"><em>• </em>企业控股情况：</div>
                            <div class="item-txt w176">
                                <c:if test="${yrAsset.entControl=='1'}">国有控股</c:if>
                                <c:if test="${yrAsset.entControl=='2'}">集体控股</c:if>
                                <c:if test="${yrAsset.entControl=='3'}">私人控股</c:if>
                                <c:if test="${yrAsset.entControl=='4'}">港澳台商控股</c:if>
                                <c:if test="${yrAsset.entControl=='5'}">外商控股</c:if>
                                <c:if test="${yrAsset.entControl=='6'}">其他</c:if>
                                <c:if test="${yrAsset.entControl=='7'}">私营企业</c:if>
                            </div>
                            <span class="right-tip pdr0">
                        	<c:if test="${yrAsset.entControlIsPub == '1'}">公示</c:if>
                    		<c:if test="${yrAsset.entControlIsPub == '0'}">不公示</c:if>
                        </span>
                        </c:if>
                    </td>
                </tr>
                <c:if test="${fn:indexOf(repType,'assetbranch') != -1}">
                    <tr>
                        <td>
                            <div class="item-name w214"><em>• </em>隶属企业统一社会信用代码/注册号：</div>
                            <div class="item-txt w222">${yrOtherInfo.supRegNO}</div>
                        </td>
                        <td>
                            <div class="item-name">隶属企业名称：</div>
                            <div class="item-txt">${yrOtherInfo.supEntname}</div>
                        </td>
                    </tr>
                </c:if>
                <tr>
                    <td>
                        <div class="item-name w214"><em>• </em>是否有网站或网店：</div>
                        <div class="item-txt w222" id="_isWebsite"></div>
                    </td>
                    <td>
                        <div class="item-name w260"><em>• </em>是否有对外提供担保信息：</div>
                        <div class="item-txt w176" id="_isForguarantee"></div>
                    </td>
                </tr>
                <c:if test="${fn:indexOf(repType,'forinvestment') != -1}">
                    <tr>
                        <td>
                            <div class="item-name w214"><em>• </em>是否有投资信息或购买其他公司股权：</div>
                            <div class="item-txt w222" id="_isForinvest"></div>
                        </td>
                        <td>
                            <c:if test="${fn:indexOf(repType,'alterstockinfo') != -1}">
                                <div class="item-name w260"><em>• </em>有限责任公司本年度是否发生股东股权转让：</div>
                                <div class="item-txt w176" id="_isStock"></div>
                            </c:if>
                        </td>
                    </tr>
                </c:if>
                <c:if test="${year > 2015}">
                    <tr>
                        <td colspan="2">
                            <div class="item-name w214"><em>• </em>企业主营业务活动：</div>
                            <div class="item-txt w222" id="">${yrAsset.entMainBusActivity}</div>
                        </td>
                    </tr>
                </c:if>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div class="mod">
    <div class="mod-bd">
        <div class="title">
            <h3>网站或网店信息</h3>
        </div>
        <div class="content">
            <div class="cont-height-limit">
                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th width="90">类型</th>
                        <th>名称</th>
                        <th>网址</th>
                    </tr>
                    </thead>
                    <tbody id="_website">
                    </tbody>
                </table>
            </div>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="_websiteItemCount"></em> 条信息，共<em id="_websitePageCount"></em>页</span>
                <div id="_websitePagination" class="pagination">

                </div>
            </div>
        </div>

    </div>
</div>
<c:if test="${fn:indexOf(repType,'subcapital') != -1}">
    <div class="mod">
        <div class="mod-bd">
            <div class="title">
                <h3>股东及出资信息</h3>
            </div>
            <div class="content">
                <div class="cont-height-limit">
                    <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                        <thead>
                        <tr>
                            <th>股东</th>
                            <th>认缴出资额<br/><strong class="light">
                                (万${year > 2015?midBaseInfoDto.currencyCn:'元'})
                            </strong></th>
                            <th>认缴出资时间</th>
                            <th>认缴出资方式</th>
                            <th>实缴出资额<br/><strong class="light">
                                (万${year > 2015?midBaseInfoDto.currencyCn:'元'})
                            </strong></th>
                            <th>实缴出资时间</th>
                            <th>实缴出资方式</th>
                        </tr>
                        </thead>
                        <tbody id="_subcapital">
                        </tbody>
                    </table>
                </div>
                <div class="notice-pagination-box clearfix">
                    <span class="page-total">共查询到 <em id="_subcapitalItemCount"></em> 条信息，共<em id="_subcapitalPageCount"></em>页</span>
                    <div id="_subcapitalPagination" class="pagination">

                    </div>
                </div>
            </div>

        </div>
    </div>
</c:if>
<c:if test="${fn:indexOf(repType,'forinvestment') != -1}">
    <div class="mod">
        <div class="mod-bd">
            <div class="title">
                <h3>对外投资信息</h3>
            </div>
            <div class="content">
                <div class="cont-height-limit">
                    <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                        <thead>
                        <tr>
                            <th>投资设立企业或购买股权企业名称</th>
                            <th>注册号/统一社会信用代码</th>
                        </tr>
                        </thead>
                        <tbody id="_forinvest">
                        </tbody>
                    </table>
                </div>
                <div class="notice-pagination-box clearfix">
                    <span class="page-total">共查询到 <em id="_forinvestItemCount"></em> 条信息，共<em id="_forinvestPageCount"></em>页</span>
                    <div id="_forinvestPagination" class="pagination">

                    </div>
                </div>
            </div>

        </div>
    </div>
</c:if>
<c:if test="${fn:indexOf(repType,'asset') != -1}">
    <c:if test="${fn:indexOf(repType,'assetbranch') == -1}">
        <div class="mod">
            <div class="mod-bd">
                <div class="title title-inner">
                    <h3>企业资产状况信息</h3>
                </div>
                <div class="content">
                    <table class="table-public table-report item-name-w162">
                        <tbody>
                        <tr>
                            <td width="296">
                                <div class="item-name w204">资产总额：</div>
                                <div class="item-txt"><fmt:formatNumber value="${yrAsset.assGro}" pattern="###,###,###,##0.00"/></div>
                                <span class="right-tip pdr0">
                        	<c:if test="${yrAsset.assGroIsPub == '1'}">公示</c:if>
                    		<c:if test="${yrAsset.assGroIsPub == '0'}">不公示</c:if>
                        </span>
                            </td>
                            <td width="320">
                                <div class="item-name w204">所有者权益合计：</div>
                                <div class="item-txt"><fmt:formatNumber value="${yrAsset.totEqu}" pattern="###,###,###,##0.00"/></div>
                                <span class="right-tip pdr0">
                        	<c:if test="${yrAsset.totEquIsPub == '1'}">公示</c:if>
                    		<c:if test="${yrAsset.totEquIsPub == '0'}">不公示</c:if>
                        </span>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="item-name w204">营业总收入：</div>
                                <div class="item-txt"><fmt:formatNumber value="${yrAsset.vendInc}" pattern="###,###,###,##0.00"/></div>
                                <span class="right-tip pdr0">
                        	<c:if test="${yrAsset.vendIncIsPub == '1'}">公示</c:if>
                    		<c:if test="${yrAsset.vendIncIsPub == '0'}">不公示</c:if>
                        </span>
                            </td>
                            <td>
                                <div class="item-name w204">利润总额：</div>
                                <div class="item-txt"><fmt:formatNumber value="${yrAsset.proGro}" pattern="###,###,###,##0.00"/></div>
                                <span class="right-tip pdr0">
                        	<c:if test="${yrAsset.proGroIsPub == '1'}">公示</c:if>
                    		<c:if test="${yrAsset.proGroIsPub == '0'}">不公示</c:if>
                        </span>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="item-name w204">营业总收入中主营业务收入：</div>
                                <div class="item-txt"><fmt:formatNumber value="${yrAsset.maiBusInc}" pattern="###,###,###,##0.00"/></div>
                                <span class="right-tip pdr0">
                        	<c:if test="${yrAsset.maiBusIncIsPub == '1'}">公示</c:if>
                    		<c:if test="${yrAsset.maiBusIncIsPub == '0'}">不公示</c:if>
                        </span>
                            </td>
                            <td>
                                <div class="item-name w204">净利润：</div>
                                <div class="item-txt"><fmt:formatNumber value="${yrAsset.netInc}" pattern="###,###,###,##0.00"/></div>
                                <span class="right-tip pdr0">
                        	<c:if test="${yrAsset.netIncIsPub == '1'}">公示</c:if>
                    		<c:if test="${yrAsset.netIncIsPub == '0'}">不公示</c:if>
                        </span>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="item-name w204"> 纳税总额：</div>
                                <div class="item-txt"><fmt:formatNumber value="${yrAsset.ratGro}" pattern="###,###,###,##0.00"/></div>
                                <span class="right-tip pdr0">
                        	<c:if test="${yrAsset.ratGroIsPub == '1'}">公示</c:if>
                    		<c:if test="${yrAsset.ratGroIsPub == '0'}">不公示</c:if>
                        </span>
                            </td>
                            <td>
                                <div class="item-name w204">负债总额：</div>
                                <div class="item-txt"><fmt:formatNumber value="${yrAsset.liaGro}" pattern="###,###,###,##0.00"/></div>
                                <span class="right-tip pdr0">
                        	<c:if test="${yrAsset.liaGroIsPub == '1'}">公示</c:if>
                    		<c:if test="${yrAsset.liaGroIsPub == '0'}">不公示</c:if>
                        </span>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="item-name w204">${year}年是否依法交纳残保金：</div>
                                <div class="item-txt">
                                    <c:if test="${yrAsset.isLegPay == '1'}">是</c:if>
                                    <c:if test="${yrAsset.isLegPay == '0'}">否</c:if>
                                </div>
                            </td>
                            <td>
                                <div class="item-name w204">从业人员中属于残疾人：</div>
                                <div class="item-txt">${yrAsset.disOpers}</div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="item-name w204">企业应安置残疾人员数：</div>
                                <div class="item-txt">${yrAsset.entOugthSetDis}</div>
                            </td>
                            <td>
                                <div class="item-name w204">企业已安置残疾人员数：</div>
                                <div class="item-txt">${yrAsset.entSetDis}</div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </c:if>
</c:if>
<c:if test="${fn:indexOf(repType,'assetbranch') != -1}">
    <div class="mod">
        <div class="mod-bd">
            <div class="title title-inner">
                <h3>企业经营情况信息</h3>
            </div>
            <div class="content">
                <table class="table-public table-report item-name-w162">
                    <tbody>
                    <tr>
                        <td width="296">
                            <div class="item-name w204">营业总收入中主营业务收入：</div>
                            <div ${yrAsset.entBelong=='2'?'style="display: none"':''}><%--判断是否是非独立核算  --%>
                                <div class="item-txt"><fmt:formatNumber value="${yrAsset.maiBusInc}" pattern="###,###,###,##0.00"/></div>
                                <span class="right-tip pdr0">
                                <c:if test="${yrAsset.maiBusIncIsPub == '1'}">公示</c:if>
                                <c:if test="${yrAsset.maiBusIncIsPub == '0'}">不公示</c:if>
                            </div>
                        </span>

                        </td>
                        <td width="320">
                            <div class="item-name w204">净利润：</div>
                            <div ${yrAsset.entBelong=='2'?'style="display: none"':''}>
                                <div class="item-txt"><fmt:formatNumber value="${yrAsset.netInc}" pattern="###,###,###,##0.00"/></div>
                                <span class="right-tip pdr0">
                                <c:if test="${yrAsset.netIncIsPub == '1'}">公示</c:if>
                                <c:if test="${yrAsset.netIncIsPub == '0'}">不公示</c:if>
                            </div>

                        </span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="item-name w204"> 纳税总额：</div>
                            <div ${yrAsset.entBelong=='2'?'style="display: none"':''}>
                                <div class="item-txt"><fmt:formatNumber value="${yrAsset.ratGro}" pattern="###,###,###,##0.00"/></div>
                                <span class="right-tip pdr0">
                                <c:if test="${yrAsset.ratGroIsPub == '1'}">公示</c:if>
                                <c:if test="${yrAsset.ratGroIsPub == '0'}">不公示</c:if>
                                </span>
                            </div>

                        </td>
                        <td>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</c:if>
<div class="mod">
    <div class="mod-bd">
        <div class="title">
            <h3>对外提供保证担保信息</h3>
        </div>
        <div class="content">
            <div class="cont-height-limit">
                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th width="118">债权人</th>
                        <th width="150">债务人</th>
                        <th width="80">主债权</br>种类</th>
                        <th width="100">主债权</br>数额</th>
                        <th width="170">履行债务的期限</th>
                        <th>保证的</br>期间</th>
                        <th>保证的</br>方式</th>
                        <th width="63">是否公示</th>
                    </tr>
                    </thead>
                    <tbody id="_forguarantee">
                    </tbody>
                </table>
            </div>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="_forguaranteeItemCount"></em> 条信息，共<em id="_forguaranteePageCount"></em>页</span>
                <div id="_forguaranteePagination" class="pagination">

                </div>
            </div>
        </div>
    </div>
</div>
<c:if test="${fn:indexOf(repType,'alterstockinfo') != -1}">
    <div class="mod">
        <div class="mod-bd">
            <div class="title">
                <h3>股权变更信息</h3>
            </div>
            <div class="content">
                <div class="cont-height-limit">
                    <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                        <thead>
                        <tr>
                            <th>股东</th>
                            <th width="200">变更前股权比例</th>
                            <th width="200">变更后股权比例</th>
                            <th width="150">股权变更日期</th>
                        </tr>
                        </thead>
                        <tbody id="_stock">
                        </tbody>
                    </table>
                </div>
                <div class="notice-pagination-box clearfix">
                    <span class="page-total">共查询到 <em id="_stockItemCount"></em> 条信息，共<em id="_stockPageCount"></em>页</span>
                    <div id="_stockPagination" class="pagination">

                    </div>
                </div>
            </div>
        </div>
    </div>
</c:if>
<c:if test="${year > 2015}">
    <div class="mod">
        <div class="mod-bd">
            <div class="title">
                <h3>社保信息</h3>
            </div>
            <div class="content">
                <table class="table-public table-public2-preview" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th width="168" >参保险种</th>
                        <th width="210">
                            参保人数</br>（单位：人）
                        </th>
                        <th width="210">单位缴费基数</br>（单位：万元）</th>
                        <th width="210">本期实际缴费金额</br>（单位：万元）</th>
                        <th>单位累计欠缴金额</br>（单位：万元）</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>城镇职工基本养老保险</td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" readonly="readonly" id="endowmentNum" name="endowmentNum" value="${yrSocialSecurity.endowmentNum}" class="ipt-txt" placeholder="">
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="paymentEndowment" value="${yrSocialSecurity.paymentEndowment}" class="ipt-txt one" placeholder="请输入金额">

                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="actualPayEndowment" value="${yrSocialSecurity.actualPayEndowment}" class="ipt-txt two" placeholder="请输入金额">

                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="cumuEndowment" value="${yrSocialSecurity.cumuEndowment}" class="ipt-txt three" placeholder="请输入金额">
                                <i class=""></i>
                            </div>

                        </td>
                    </tr>
                    <tr>
                        <td>失业保险</td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" id="unemploymentNum" name="unemploymentNum" value="${yrSocialSecurity.unemploymentNum}" class="ipt-txt" placeholder="">
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="paymentUnemployment" value="${yrSocialSecurity.paymentUnemployment}" class="ipt-txt one" placeholder="请输入金额">
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="actualPayUnemployment" value="${yrSocialSecurity.actualPayUnemployment}" class="ipt-txt two" placeholder="请输入金额">
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="cumuUnemployment" value="${yrSocialSecurity.cumuUnemployment}" class="ipt-txt three" placeholder="请输入金额">
                                <i class=""></i>
                            </div>

                        </td>
                    </tr>
                    <tr>
                        <td>职工基本医疗保险</td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" id="medicalNum" name="medicalNum" value="${yrSocialSecurity.medicalNum}" class="ipt-txt" placeholder="">
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="paymentMedical" value="${yrSocialSecurity.paymentMedical}" class="ipt-txt one" placeholder="请输入金额">
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="actualPayMedical" value="${yrSocialSecurity.actualPayMedical}" class="ipt-txt two" placeholder="请输入金额">
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="cumuMedical" value="${yrSocialSecurity.cumuMedical}" class="ipt-txt three" placeholder="请输入金额">
                                <i class=""></i>
                            </div>

                        </td>
                    </tr>
                    <tr>
                        <td>工伤保险</td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" id="empInjuryNum" name="empInjuryNum" value="${yrSocialSecurity.empInjuryNum}" class="ipt-txt " placeholder="">
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="paymentEmpInjury" value="${yrSocialSecurity.paymentEmpInjury}" class="ipt-txt one" placeholder="请输入金额">
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="actualPayEmpInjury" value="${yrSocialSecurity.actualPayEmpInjury}" class="ipt-txt two" placeholder="请输入金额">
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="cumuEmpInjury" value="${yrSocialSecurity.cumuEmpInjury}" class="ipt-txt three" placeholder="请输入金额">
                                <i class=""></i>
                            </div>

                        </td>
                    </tr>
                    <tr>
                        <td>生育保险</td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" id="maternityNum" name="maternityNum" value="${yrSocialSecurity.maternityNum}" class="ipt-txt" placeholder="">
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="paymentMaternity" value="${yrSocialSecurity.paymentMaternity}" class="ipt-txt one" placeholder="请输入金额">
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="actualPayMaternity" value="${yrSocialSecurity.actualPayMaternity}" class="ipt-txt two" placeholder="请输入金额">
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="cumuMaternity" value="${yrSocialSecurity.cumuMaternity}" class="ipt-txt three" placeholder="请输入金额">
                                <i class=""></i>
                            </div>

                        </td>
                    </tr>

                    <tr>
                        <td></td>
                        <td></td>
                        <td>
                            <div class="radio-box">
                                <label>${yrSocialSecurity.paymentBaseIsPub=='1'?'公示':'不公示'}</label>
                            </div>
                        </td>
                        <td>
                            <div class="radio-box">
                                <label>${yrSocialSecurity.actualPaymentIsPub=='1'?'公示':'不公示'}</label>
                            </div>
                        </td>
                        <td>
                            <div class="radio-box">
                                <label>${yrSocialSecurity.cumulArrearsIsPub=='1'?'公示':'不公示'}</label>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>

            </div>
        </div>
    </div>
</c:if>


<%-- 签章参数 start --%>
    <form id="signature_params">
        <input type="hidden"  name="keyCerSn" value="${sessionScope.keyCerSn}"> <%--证书序列号--%>
        <input type="hidden"  name="year" value="${year}"/>
        <input type="hidden"  name="pripid" value="${sessionScope.midBaseInfoDto.priPID}"/>
    </form>
<%-- 签章参数 end   --%>


<div class="mod" id="js-signature-box" style="display: ${sessionScope.loginType!='2'?'block':'none'}">
    <div class="btn-box">
        <button id="js-signature"  type="button" class="btn-common btn-save">加盖电子公章</button>
        <p class="center mb10"><strong class="light">注：加盖电子公章前请先插入数字证书。</strong></p>
    </div>
</div>


<div class="mod" id="js-yearbox" style="display: ${sessionScope.loginType=='2'?'block':'none'}" >
    <div class="btn-box">
        <p class="center mb10"><strong class="light">注：年报公示信息将通过企业信用信息公示平台向社会公众公开，请确认以上信息无误</strong></p>
        <button id="save" type="button" class="btn-common btn-save">提交年报</button>
    </div>
</div>

<%--弹出框--%>
<div class="layer"></div>
<div class="yrpubpreview-pop" id="yrpubpreview-pop">
    <h5>你企业即将报送 <span class="light">${year}</span>年度报告</h5>
    <p>1、该年度报告内容将通过企业信用信息公示系统（ http://gsxt.zjaic.gov.cn ）向社会公示，接受社会公众查询和监督；</p>
    <p>2、你企业对年度报告内容的合法性、真实性负责。因公示信息错误、遗漏及违反国家相关规定引起的后果与法律责任由你企业承担；</p>
    <p>3、工商机关对年度报告内容不审查，但将对报告内容进行抽查检查。检查中发现企业在年度报告时弄虚作假、隐瞒真实的，将依法处理并予公示。</p>
    <strong>请确认年度报告信息真实完整！如需修改请取消返回</strong>
    <div class="btn-box">
        <input type="button" value="确定" class="btn-common" id="commit"/>
        <input type="button" value="取消" class="btn-common" id="cancel"/>
    </div>
    <div class="center b-tip">
        服务热线：400-888-4636   服务QQ群：12790338
    </div>
</div>

<jsp:include page="../../common/footer.jsp"></jsp:include>

<form id="_params">
    <input type="hidden" name="year" value="${year}"/>
    <input type="hidden" name="priPID" value="${sessionScope.midBaseInfoDto.priPID}"/>
</form>
<script>
    //参数的传递
    window._CONFIG = {
        repType: '${repType}'
    }

</script>
<script id="website-table-template" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{webType webType}}</td>
        <td>{{webSitName}}</td>
        <td>{{webSite}}</td>
    </tr>
    {{/each}}
</script>

<script id="subcapital-table-template" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{inv}}</td>
        <td>{{lisubconam}}</td>
        <td>{{subConDate}}</td>
        <td>{{conFormCN}}</td>
        <td>{{liacconam}}</td>
        <td>{{acConDate}}</td>
        <td>{{acConFormCn}}</td>
    </tr>
    {{/each}}
</script>

<script id="forinvest-table-template" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{entName}}</td>
        <td>{{uniCode}}</td>
    </tr>
    {{/each}}
</script>

<script id="forguarantee-table-template" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{more}}</td>
        <td>{{mortgagor}}</td>
        <td>{{priClaSecKind priClaSecKind}}</td>
        <td>{{priClaSecAm}}万元</td>
        <td>{{pefPerForm}}至{{pefPerTo}}</td>
        <td>{{guaPeriod guaPeriod}}</td>
        <td>{{gaType gaType}}</td>
        <td>{{isPubFlag isPubFlag}}</td>
    </tr>
    {{/each}}
</script>

<script id="stock-table-template" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{inv}}</td>
        <td>{{beTransAmPr}}%</td>
        <td>{{afTransAmPr}}%</td>
        <td>{{altDate}}</td>
    </tr>
    {{/each}}
</script>
<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/component/dropDown.js"/>"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/client/yr/pubpreview/preview_main.js"></script>
<script src="<c:url value="/js/reg/client/yr/qianzhang/qz_edit.js"/>"></script>
</body>
</html>
