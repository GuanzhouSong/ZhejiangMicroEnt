<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>农专社年报公示预览页面</title>
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
    <h5 class="pdt20 center">农专社年报公示信息表</h5>
    <strong class="light">注：以下为年报公示信息，若有误请返回对应的年度报告报表中进行修改。</strong>
</div>
<div class="mod">
    <div class="mod-hd">
        <div class="title">
            <h3>基本信息</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
          <input type="hidden" name="anCheID" id = "anCheID" value="${yrSfcBaseinfo.anCheID}"/>
          <input type="hidden" name="priPID" id ="priPID" value="${yrSfcBaseinfo.priPID}"/>
          <input type="hidden" name="year" id = "year" value="${yrSfcBaseinfo.year}"/>
            <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td class="odd">
                        <div class="item-name">名称字号：</div>
                        <div class="item-txt">${yrSfcBaseinfo.farSpeArtName}</div>
                    </td>
                    <td class="odd">
                        <div class="item-name">统一社会信用代码/注册号：</div>
                        <div class="item-txt">${empty yrSfcBaseinfo.uniCode ? yrSfcBaseinfo.regNO : yrSfcBaseinfo.uniCode}</div>
                    </td>
                </tr>
                <tr> 
                    <td class="odd">
                        <div class="item-name">联系电话：</div>
                        <div class="item-txt">${yrSfcBaseinfo.tel}</div>
                    </td>
                    <td class="odd">
                        <div class="item-name">电子邮箱：</div>
                        <div class="item-txt">${yrSfcBaseinfo.email}</div>
                    </td>
                </tr>
                 <tr>
                    <td class="odd" colspan="2">
                        <div class="item-name">成员人数：</div>
                        <div class="item-txt">共${yrSfcBaseinfo.memNum}人，其中农民人数：${yrSfcBaseinfo.farnum}人。 本年度新增${yrSfcBaseinfo.annNewMemNum}人，退出${yrSfcBaseinfo.annRedMemNum}人。</div>
                    </td>
                </tr>
                <tr>
                    <td class="odd" colspan="2">
                        <div class="item-name">通信地址：</div>
                        <div class="item-txt item-multipy">${yrSfcBaseinfo.dom}</div>
                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="item-name">从业人数：</div>
                        <div class="item-txt"><span class="inline-block w200">${yrSfcBaseinfo.empNum}人</span>
                        <c:if test="${yrSfcBaseinfo.empNumDis == '1'}">公示</c:if>
                        <c:if test="${yrSfcBaseinfo.empNumDis == '0'}">不公示</c:if>
                        </div>
                    </td>
                    <c:if test="${yrSfcBaseinfo.year > 2015}">
                    <td class="odd">
                        <div class="item-name">女性从业人数：</div>
                        <div class="item-txt"><span class="inline-block w200">${yrSfcBaseinfo.femaleEmploye}人</span>
                        <c:if test="${yrSfcBaseinfo.femaleEmployeIsPub == '1'}">公示</c:if>
                        <c:if test="${yrSfcBaseinfo.femaleEmployeIsPub == '0'}">不公示</c:if>
                        </div>
                    </td>
                    </c:if>
                </tr> 
                <c:if test="${yrSfcBaseinfo.year > 2015}">
                <tr>
                    <td class="odd" colspan="2">
                        <div class="item-name">主营业务活动：</div>
                        <div class="item-txt item-multipy">${yrSfcBaseinfo.entMainBusActivity}</div>
                    </td>
                </tr> 
                </c:if>                             
                </tbody>
            </table>
        </div>
    </div>
</div>

<div class="mod">
    <div class="mod-hd">
        <div class="title">
            <h3>资产状况信息</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
            <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td class="odd">
                        <div class="item-name">销售额或营业收入：</div>
                        <div class="item-txt"><span class="inline-block w200"><fmt:formatNumber value="${yrSfcBaseinfo.vendInc}" pattern="###,###,###,##0.00"/> 元</span>
                        <c:if test="${yrSfcBaseinfo.vendIncIsPub == '1'}">公示</c:if>
                        <c:if test="${yrSfcBaseinfo.vendIncIsPub == '0'}">不公示</c:if>
                        </div>
                    </td>
                    <td class="odd">
                        <div class="item-name">盈余总额：</div>
                        <div class="item-txt"><span class="inline-block w200"><fmt:formatNumber value="${yrSfcBaseinfo.priYeaProfit}" pattern="###,###,###,##0.00"/> 元</span>
                        <c:if test="${yrSfcBaseinfo.maiBusIncIsPub == '1'}">公示</c:if>
                        <c:if test="${yrSfcBaseinfo.maiBusIncIsPub == '0'}">不公示</c:if>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="item-name">纳税金额：</div>
                        <div class="item-txt"><span class="inline-block w200"><fmt:formatNumber value="${yrSfcBaseinfo.ratGro}" pattern="###,###,###,##0.00"/> 元</span>
                        <c:if test="${yrSfcBaseinfo.ratGroIsPub == '1'}">公示</c:if>
                        <c:if test="${yrSfcBaseinfo.ratGroIsPub == '0'}">不公示</c:if>
                        </div>
                    </td>
                    <td class="odd">
                        <div class="item-name">获得政府扶持资金、补助：</div>
                        <div class="item-txt"><span class="inline-block w200"><fmt:formatNumber value="${yrSfcBaseinfo.priYeaSub}" pattern="###,###,###,##0.00"/> 元</span>
                        <c:if test="${yrSfcBaseinfo.priYeaSubIsPub == '1'}">公示</c:if>
                        <c:if test="${yrSfcBaseinfo.priYeaSubIsPub == '0'}">不公示</c:if>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="item-name">金融贷款：</div>
                        <div class="item-txt"><span class="inline-block w200"><fmt:formatNumber value="${yrSfcBaseinfo.priYeaLoan}" pattern="###,###,###,##0.00"/> 元</span>
                        <c:if test="${yrSfcBaseinfo.priYeaLoanIsPub == '1'}">公示</c:if>
                        <c:if test="${yrSfcBaseinfo.priYeaLoanIsPub == '0'}">不公示</c:if>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>


<div class="mod">
    <div class="mod-hd">
        <div class="title">
            <h3>行政许可情况</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
            <div class="content-sm-height">
                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th width="50%">行政许可名称</th>
                        <th width="50%">有效期至</th>
                    </tr>
                    </thead>
                    <tbody id="dbao_page_one">
                    </tbody>
                </table>
            </div>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="itemCount1"></em> 条信息，共<em id="pageCount1"></em>页</span>
                <div id="pagination1" class="pagination">
                </div>
            </div>
        </div>
    </div>
</div>

<div class="mod">
    <div class="mod-hd">
        <div class="title">
            <h3>网站或网店信息</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
           <div class="content-sm-height">
             
                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th width="20%" >类型</th>
                        <th width="40%" >名称</th>
                        <th width="40%" >网址</th>
                    </tr>
                    </thead>
                    <tbody id="dbao_page">
                    </tbody>
                </table>
            </div>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="itemCount"></em> 条信息，共<em id="pageCount"></em>页</span>
                <div id="pagination2" class="pagination">
                </div>
            </div>
        </div>
    </div>
</div>

<div class="mod">
    <div class="mod-hd">
        <div class="title">
            <h3>分支机构信息</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
            <div class="content-sm-height">
                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th width="50%">分支机构名称</th>
                        <th width="50%">分支机构注册号</th>
                    </tr>
                    </thead>
                    <tbody id="dbao_page_branch">
                    </tbody>
                </table>
            </div>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="itemCount3"></em> 条信息，共<em id="pageCount3"></em>页</span>
                <div id="pagination3" class="pagination">
                </div>
            </div>
        </div>
    </div>
</div>

<c:if test="${yrSfcBaseinfo.year > 2015}">
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
                                <input type="text" readonly="readonly" id="endowmentNum" name="endowmentNum" value="${yrSfcSocialSecurity.endowmentNum}" class="ipt-txt" placeholder="">
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="paymentEndowment" value="${yrSfcSocialSecurity.paymentEndowment}" class="ipt-txt one" placeholder="请输入金额">

                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="actualPayEndowment" value="${yrSfcSocialSecurity.actualPayEndowment}" class="ipt-txt two" placeholder="请输入金额">

                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="cumuEndowment" value="${yrSfcSocialSecurity.cumuEndowment}" class="ipt-txt three" placeholder="请输入金额">
                                <i class=""></i>
                            </div>

                        </td>
                    </tr>
                    <tr>
                        <td>失业保险</td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" id="unemploymentNum" name="unemploymentNum" value="${yrSfcSocialSecurity.unemploymentNum}" class="ipt-txt" placeholder="">
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="paymentUnemployment" value="${yrSfcSocialSecurity.paymentUnemployment}" class="ipt-txt one" placeholder="请输入金额">
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="actualPayUnemployment" value="${yrSfcSocialSecurity.actualPayUnemployment}" class="ipt-txt two" placeholder="请输入金额">
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="cumuUnemployment" value="${yrSfcSocialSecurity.cumuUnemployment}" class="ipt-txt three" placeholder="请输入金额">
                                <i class=""></i>
                            </div>

                        </td>
                    </tr>
                    <tr>
                        <td>职工基本医疗保险</td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" id="medicalNum" name="medicalNum" value="${yrSfcSocialSecurity.medicalNum}" class="ipt-txt" placeholder="">
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="paymentMedical" value="${yrSfcSocialSecurity.paymentMedical}" class="ipt-txt one" placeholder="请输入金额">
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="actualPayMedical" value="${yrSfcSocialSecurity.actualPayMedical}" class="ipt-txt two" placeholder="请输入金额">
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="cumuMedical" value="${yrSfcSocialSecurity.cumuMedical}" class="ipt-txt three" placeholder="请输入金额">
                                <i class=""></i>
                            </div>

                        </td>
                    </tr>
                    <tr>
                        <td>工伤保险</td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" id="empInjuryNum" name="empInjuryNum" value="${yrSfcSocialSecurity.empInjuryNum}" class="ipt-txt " placeholder="">
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="paymentEmpInjury" value="${yrSfcSocialSecurity.paymentEmpInjury}" class="ipt-txt one" placeholder="请输入金额">
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="actualPayEmpInjury" value="${yrSfcSocialSecurity.actualPayEmpInjury}" class="ipt-txt two" placeholder="请输入金额">
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="cumuEmpInjury" value="${yrSfcSocialSecurity.cumuEmpInjury}" class="ipt-txt three" placeholder="请输入金额">
                                <i class=""></i>
                            </div>

                        </td>
                    </tr>
                    <tr>
                        <td>生育保险</td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" id="maternityNum" name="maternityNum" value="${yrSfcSocialSecurity.maternityNum}" class="ipt-txt" placeholder="">
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="paymentMaternity" value="${yrSfcSocialSecurity.paymentMaternity}" class="ipt-txt one" placeholder="请输入金额">
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="actualPayMaternity" value="${yrSfcSocialSecurity.actualPayMaternity}" class="ipt-txt two" placeholder="请输入金额">
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="cumuMaternity" value="${yrSfcSocialSecurity.cumuMaternity}" class="ipt-txt three" placeholder="请输入金额">
                                <i class=""></i>
                            </div>

                        </td>
                    </tr>
<!--                     <tr> -->
<!--                         <td></td> -->
<!--                         <td></td> -->
<!--                         <td> -->
<!--                             <div class="ipt-box js-ipt-box"> -->
<%--                                 <input type="text"  readonly="readonly" id="_paymentBaseTotal" name="paymentBase" value="${yrSfcSocialSecurity.paymentBase}" class="ipt-txt" placeholder="" readonly> --%>
<!--                             </div> -->

<!--                         </td> -->
<!--                         <td> -->
<!--                             <div class="ipt-box js-ipt-box"> -->
<%--                                 <input type="text"  readonly="readonly" id="_cumulArrearsTotal" name="cumulArrears" value="${yrSfcSocialSecurity.cumulArrears}" class="ipt-txt" placeholder="" readonly> --%>
<!--                             </div> -->

<!--                         </td> -->
<!--                         <td> -->
<!--                             <div class="ipt-box js-ipt-box"> -->
<%--                                 <input type="text"  readonly="readonly" id="_actualPaymentTotal" name="actualPayment" value="${yrSfcSocialSecurity.actualPayment}" class="ipt-txt" placeholder="" readonly> --%>
<!--                             </div> -->

<!--                         </td> -->
<!--                     </tr> -->
                    <tr>
                        <td></td>
                        <td></td>
                        <td>
                            <div class="radio-box">
                                <label>${yrSfcSocialSecurity.paymentBaseIsPub=='1'?'公示':'不公示'}</label>
                            </div>
                        </td>
                        <td>
                            <div class="radio-box">
                                <label>${yrSfcSocialSecurity.actualPaymentIsPub=='1'?'公示':'不公示'}</label>
                            </div>
                        </td>
                        <td>
                            <div class="radio-box">
                                <label>${yrSfcSocialSecurity.cumulArrearsIsPub=='1'?'公示':'不公示'}</label>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
<!--                 <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0"> -->
<!--                     <tbody> -->
<!--                     <tr> -->
<!--                         <td class="bg-gray f14" width="500px">单位缴费基数（万元）</td> -->
<!--                         <td class="left"> -->
<%--                             <span class="money">${yrSfcSocialSecurity.paymentBase}</span> --%>
<!--                             <span class="right-tip pdr"> -->
<%--                         	<c:if test="${yrSfcSocialSecurity.paymentBaseIsPub == '1'}">公示</c:if> --%>
<%--                     		<c:if test="${yrSfcSocialSecurity.paymentBaseIsPub == '0'}">不公示</c:if> --%>
<!--                         </span> -->
<!--                         </td> -->
<!--                     </tr> -->
<!--                     <tr> -->
<!--                         <td class="bg-gray f14">本期实际缴费金额（万元）</td> -->
<!--                         <td class="left"> -->
<%--                             <span class="money">${yrSfcSocialSecurity.actualPayment}</span> --%>
<!--                             <span class="right-tip pdr"> -->
<%--                         	<c:if test="${yrSfcSocialSecurity.actualPaymentIsPub == '1'}">公示</c:if> --%>
<%--                     		<c:if test="${yrSfcSocialSecurity.actualPaymentIsPub == '0'}">不公示</c:if> --%>
<!--                         </span> -->
<!--                         </td> -->
<!--                     </tr> -->
<!--                     <tr> -->
<!--                         <td class="bg-gray f14">单位累计欠缴金额（万元）</td> -->
<!--                         <td class="left"> -->
<%--                             <span class="money">${yrSfcSocialSecurity.cumulArrears}</span> --%>
<!--                             <span class="right-tip pdr"> -->
<%--                         	<c:if test="${yrSfcSocialSecurity.cumulArrearsIsPub == '1'}">公示</c:if> --%>
<%--                     		<c:if test="${yrSfcSocialSecurity.cumulArrearsIsPub == '0'}">不公示</c:if> --%>
<!--                         </span> -->
<!--                         </td> -->
<!--                     </tr> -->
<!--                     </tbody> -->
<!--                 </table> -->
            </div>
        </div>
    </div>
</c:if>



<%-- 签章参数 start --%>
<form id="signature_params">
    <input type="hidden"  name="keyCerSn" value="${sessionScope.keyCerSn}"> <%--证书序列号--%>
    <input type="hidden"  name="year" value="${yrSfcBaseinfo.year}"/>
    <input type="hidden"  name="pripid" value="${yrSfcBaseinfo.priPID}"/>
</form>
<%-- 签章参数 end   --%>
<div class="mod" id="js-signature-box" style="display: ${sessionScope.loginType!='2'?'block':'none'}">
    <div class="btn-box">
        <button id="js-signature"  type="button" class="btn-common btn-save">加盖电子公章</button>
        <p class="center mb10"><strong class="light">注：加盖电子公章前请先插入数字证书。</strong></p>
    </div>
</div>


<div id="js-yearbox" style="display: ${sessionScope.loginType=='2'?'block':'none'}">
    <p class="light tr-center mt20 center">注：年报公示信息将通过企业信用信息公示平台向社会公众公开，请确认以上信息无误。</p>
    <div class="mod btn-box">
        <button class="btn-common" id="save">确定</button>
        <button class="btn-common" id="cancel">取消</button>
    </div>
</div>



<form id="_params">
    <input type="hidden" name="year" value="${year}"/>
    <input type="hidden" name="priPID" value="${param.priPID}"/>
</form>

<%--弹出框--%>
<div class="layer"></div>
<div class="yrpubpreview-pop"  id="yrpubpreview-pop">
    <h5>确认报送你农专社年度报告？</h5>
    <p>1、该年度报告内容将通过企业信用信息公示系统（ http://gsxt.zjaic.gov.cn ）向社会公示，接受社会公众查询和监督；</p>
    <p>2、你农专社对年度报告内容的合法性、真实性负责。因公示信息错误、遗漏及违反国家相关规定引起的后果与法律责任由你企业承担；</p>
    <p>3、工商机关对年度报告内容不审查，但将对报告内容进行抽查检查。检查中发现企业在年度报告时弄虚作假、隐瞒真实的，将依法处理并予公示。</p>
    <strong>请确认年度报告信息真实完整！如需修改请取消返回</strong>
    <div class="btn-box">
        <input type="button" value="确定" class="btn-common" id="commit"/>
        <input type="button" value="取消" class="btn-common" id="confirmCancel"/>
    </div>
    <div class="center b-tip">
        服务热线：400-888-4636   服务QQ群：12790338
    </div>
</div>
<jsp:include page="../../common/footer.jsp"></jsp:include>
<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script id="table-template-one" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{licNameCN}}</td>
        <td>{{valto valTo}}</td>
    </tr>
    {{/each}}
</script>
<script id="table-template" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{webtype webType}}</td>
        <td>{{webSitName}}</td>
        <td>{{webSite}}</td>
    </tr>
    {{/each}}
</script>
<script id="table-template-three" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{brName}}</td>
        <td>{{uniCode}}</td>
    </tr>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/client/yr/sfcyr/sfcyrpubpreview.js"></script>
<script src="<c:url value="/js/reg/client/yr/qianzhang/qz_edit.js"/>"></script>
</body>
</html>