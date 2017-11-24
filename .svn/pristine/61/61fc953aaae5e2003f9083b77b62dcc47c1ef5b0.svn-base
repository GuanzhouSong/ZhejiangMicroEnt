<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean id="nowdate" class="java.util.Date" />
<fmt:formatDate var="nowyear" value="${nowdate}" pattern="yyyy"/> 
<fmt:formatDate var="duedate" value="${nowdate}" pattern="MMdd"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>农专社年报页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>

<div class="mod caiwu">
   <div class="mod-hd">
   <div class="tips">
    <span class="txt">报表中背景颜色为</span>
    <span class="blockage"></span>
    <span class="txt">的内容经选择公示后将公示于企业信用信息公示系统</span>
   </div>
  
<%--基本信息--%>
<form class="form-horizontal error-bottom" id="form">
  <input type="hidden" name="anCheID" id = "anCheID" value="${yrSfcBaseinfo.anCheID}"/>
  <input type="hidden" name="priPID" id ="priPID" value="${yrSfcBaseinfo.priPID}"/>
  <input type="hidden" name="year" id ="year" value="${yrSfcBaseinfo.year}"/>
  <input type="hidden" name="regNO" id ="regNO" value="${yrSfcBaseinfo.regNO}"/>
  <input type="hidden" name="uniCode" id ="uniCode" value="${yrSfcBaseinfo.uniCode}"/>
<div class="mod pbreport-basic">
    <div class="mod-hd">
        <div class="title">
            <h3>基本信息</h3>
            <p>以下内容请按照当前农专社最新的情况进行填写</p>
        </div>
    </div>
    <div class="content mod-bd-panel">
            <table class="table-public table-caiwu" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td class="odd" colspan="2">
                        <div class="item-name bg">名称字号:</div>
                        <div class="item-txt">${yrSfcBaseinfo.farSpeArtName}</div>
                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="item-name bg">统一社会信用代码/注册号:</div>
                        <div class="item-txt">${empty yrSfcBaseinfo.uniCode ? yrSfcBaseinfo.regNO : yrSfcBaseinfo.uniCode}</div>
                    </td>
                </tr>
                <tr>
                    <td class="odd" colspan="2">
                        <div class="item-name">住所:</div>
                        <div class="item-txt">${yrSfcBaseinfo.addrDom}</div>
                    </td>
                </tr>
                <tr>
                    <td class="odd" colspan="2">
                        <div class="item-name">通信地址:</div>
                        <div class="item-txt">${yrSfcBaseinfo.dom}</div>
                    </td>
                </tr>
                 <tr>
                    <td class="odd" colspan="4">
                        <div class="item-name">经营(业务)范围:</div>
                        <div class="item-txt">
                            <textarea rows="2" name="opScope" style= "width: 800px;" class="item-txt" readonly="readonly">${yrSfcBaseinfo.opScope}</textarea>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name bg"><strong class="light">* </strong>本年度新增</div>
                        <div class="item-txt">${yrSfcBaseinfo.annNewMemNum}人</div>
                    </td>
                    <td class="even focus-state">
                        <div class="item-name bg"><strong class="light">* </strong>退出</div>
                        <div class="item-txt">
                            ${yrSfcBaseinfo.annRedMemNum}人
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name bg"><strong class="light">* </strong>实际人数共</div>
                        <div class="item-txt">
                            ${yrSfcBaseinfo.memNum}人
                        </div>
                    </td>
                    <td class="even focus-state">
                        <div class="item-name bg"><strong class="light">* </strong>其中农民人数</div>
                        <div class="item-txt">
                            ${yrSfcBaseinfo.farnum}人
                        </div>
                    </td>
                </tr>
                   <tr>
                    <td class="odd focus-state">
                        <div class="item-name"><strong class="light">*</strong>出资总额</div>
                        <div class="item-txt">
                            <fmt:formatNumber value="${yrSfcBaseinfo.memConGro}" pattern="###,###,###,##0.0000"/>万元
                        </div>
                    </td>
                    <td class="even focus-state">
                        <div class="item-name"><strong class="light">*</strong>社员信用户</div>
                        <div class="item-txt">
                            ${yrSfcBaseinfo.creditMem}%
                        </div>
                        
                    </td>
                <tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name bg"><strong class="light">* </strong>从业人数</div>
                        <div class="item-txt">
                            ${yrSfcBaseinfo.empNum}人
                            <c:if test="${yrSfcBaseinfo.empNumDis == '1'}">公示</c:if>
                            <c:if test="${yrSfcBaseinfo.empNumDis == '0'}">不公示</c:if> 
                        </div>
                    </td>
                </tr>
                 <c:if test="${year>=2016}">                               
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name bg"><strong class="light">* </strong>女性从业人数</div>
                        <div class="item-txt">
                            ${yrSfcBaseinfo.femaleEmploye}人
                            <c:if test="${yrSfcBaseinfo.femaleEmployeIsPub == '1'}">公示</c:if>
                            <c:if test="${yrSfcBaseinfo.femaleEmployeIsPub == '0'}">不公示</c:if>
                        </div>
                    </td>
                </tr>
                </c:if>
                <c:if test="${year>=2016}">
                <tr>
                    <td class="odd focus-state" colspan="2">
                        <div class="item-name special bg">主营业务活动</div>
                        <textarea id="mainBusActivity" name="entMainBusActivity" class="textarea sfcreport" readonly="readonly">${yrSfcBaseinfo.entMainBusActivity}</textarea>
                    </td>
                </tr>
               </c:if> 
                </tbody>
            </table>
        </div>
    </div>
</div>
</div>
</div>

<%--资产状况信息(币种：人民币)--%>
<div class="mod pbreport-basic">
    <div class="mod-hd">
        <div class="title">
            <h3>资产状况信息(币种：人民币)</h3>
            <p>以下信息请按照截止${year}年度12月31日时的情况进行填写
            </p>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
            <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name bg"><strong class="light">* </strong>销售额或营业收入：</div>
                        <div class="item-txt"><fmt:formatNumber value="${yrSfcBaseinfo.vendInc}" pattern="###,###,###,##0.0000"/>万元
                        <c:if test="${yrSfcBaseinfo.vendIncIsPub == '1'}">公示</c:if>
                        <c:if test="${yrSfcBaseinfo.vendIncIsPub == '0'}">不公示</c:if>
                        </div>
                    </td>
                    <td class="odd focus-state">
                        <div class="item-name bg"><strong class="light">* </strong>盈余总额：</div>
                        <div class="item-txt"><fmt:formatNumber value="${yrSfcBaseinfo.priYeaProfit}" pattern="###,###,###,##0.0000"/>万元
                        <c:if test="${yrSfcBaseinfo.maiBusIncIsPub == '1'}">公示</c:if>
                        <c:if test="${yrSfcBaseinfo.maiBusIncIsPub == '0'}">不公示</c:if>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name bg"><strong class="light">* </strong>纳税总额：</div>
                        <div class="item-txt"><fmt:formatNumber value="${yrSfcBaseinfo.ratGro}" pattern="###,###,###,##0.0000"/>万元
                        <c:if test="${yrSfcBaseinfo.ratGroIsPub == '1'}">公示</c:if>
                        <c:if test="${yrSfcBaseinfo.ratGroIsPub == '0'}">不公示</c:if>
                        </div>
                    </td>
                    <td class="odd focus-state">
                        <div class="item-name bg"><strong class="light">* </strong>获得政府扶持资金、补助(元)</div>
                        <div class="item-txt"><fmt:formatNumber value="${yrSfcBaseinfo.priYeaSub}" pattern="###,###,###,##0.0000"/>万元
                        <c:if test="${yrSfcBaseinfo.priYeaSubIsPub == '1'}">公示</c:if>
                        <c:if test="${yrSfcBaseinfo.priYeaSubIsPub == '0'}">不公示</c:if>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name bg"><strong class="light">* </strong>金融贷款(元)</div>
                        <div class="item-txt"><fmt:formatNumber value="${yrSfcBaseinfo.priYeaLoan}" pattern="###,###,###,##0.0000"/>万元
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

<%--联系信息--%>
<div class="mod pbreport-basic">
    <div class="mod-hd">
        <div class="title">
            <h3>联系信息</h3>
            <p>已办理过工商联络员确认手续的农专社请核对以下信息是否正确，如需变更请重新办理联络员确认手续；</br>未办理过工商联络员确认手续的农专社请按照当前农专社年度报告时的情况进行填写
            </p>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
            <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name"><strong class="light">* </strong>法定代表人姓名</div>
                        <div class="item-txt">
                            ${yrSfcBaseinfo.leRep}
                        </div>
                    </td>
                    <td class="odd focus-state">
                        <div class="item-name"><strong class="light">* </strong>法定代表人手机号码</div>
                        <div class="item-txt">
                            ${yrSfcBaseinfo.leRepPhone}
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name"><strong class="light">* </strong>工商联络员姓名</div>
                        <div class="item-txt">
                            ${yrSfcBaseinfo.liaName}
                        </div>
                    </td>
                    <td class="odd focus-state">
                        <div class="item-name"><strong class="light">* </strong>联络员手机号码</div>
                        <div class="item-txt">
                            ${yrSfcBaseinfo.liaPhone}
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name"><strong class="light">* </strong>联络员证件类型</div>
                        <select name="liaIDType" id="liaIDType" class="select-txt w245 sfcreport" onfocus="this.defaultIndex=this.selectedIndex;" onchange="this.selectedIndex=this.defaultIndex;">
                            <c:forEach items="${Certypes}" var="certype" varStatus="status">
			                		<option value="${certype.code }" <c:if test="${yrSfcBaseinfo.liaIDType == certype.code}">selected</c:if> >${certype.content }</option>
			                </c:forEach>
                        </select>
                    </td>
                    <td class="odd focus-state">
                        <div class="item-name"><strong class="light">* </strong>联络员证件号码</div>
                        <div class="item-txt">
                            ${yrSfcBaseinfo.liaIDNum}
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name bg"><strong class="light">* </strong>农专社联系电话</div>
                        <div class="item-txt">
                             ${yrSfcBaseinfo.tel}
                        </div>
                    </td>
                    <td class="odd focus-state">
                        <div class="item-name bg"><strong class="light">* </strong>农专社电子邮箱</div>
                        <div class="item-txt">
                            ${yrSfcBaseinfo.email}
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%--工商服务--%>
<div class="mod pbreport-basic">
    <div class="mod-hd">
        <div class="title">
            <h3>工商服务</h3>
            <p>请勾选希望得到工商部门提供的执法服务事项:
            </p>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
            <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td class="odd">
                     <input type="hidden" name="icService" id="icService" value="${yrSfcBaseinfo.icService}">
                        <div class="check-box">
                            <label><input type="checkbox" name="icServiceCheck" value="1" >商标注册、著名商标、知名商号等品牌建设方面，需要支持帮助</label>
                        </div>
                    </td>
                    <td class="odd">
                        <div class="check-box">
                            <label><input type="checkbox" name="icServiceCheck" value="2">食品流通领域安全与经营管理方面，需要业务培训辅导</label>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="check-box">
                            <label><input type="checkbox" name="icServiceCheck" value="3">订单合同、购销协议管理方面，需要工商部门辅导规范</label>
                        </div>
                    </td>
                    <td class="odd">
                        <div class="check-box">
                            <label><input type="checkbox" name="icServiceCheck" value="4">通过网络平台营销、农产品进超市方面，需要帮助联络</label>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="check-box">
                            <label><input type="checkbox" name="icServiceCheck" value="5">因种子、农药、化肥等农资质量问题，需要查处、维权</label>
                        </div>
                    </td>
                    <td class="odd">
                        <div class="check-box">
                            <label><input type="checkbox" name="icServiceCheck" value="6" id ="icServiceCheck6" >其它需要工商部门给予支持和帮助的情况</label>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd" colspan="4" style="display: none;" id="othICService" >
                        <div class="w725">
                           <textarea rows="3" name="othICService" id ="othICServiceReal" style="width: 99%;height: 50px;overflow: auto;" >${yrSfcBaseinfo.othICService}</textarea>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</form>


<%--开设网站网店情况--%>
<div class="mod subcapital">
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
                        <th width="90" class="bg">序号</th>
                        <th width="90" class="bg">类型</th>
                        <th class="bg">名称</th>
                        <th class="bg">网址</th>
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

<%--取得许可证情况--%>
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
                        <th width="90" class="bg">序号</th>
                        <th class="bg">行政许可名称</th>
                        <th class="bg">有效期至</th>
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

<%--分支机构情况--%>
<div class="mod subcapital">
    <div class="mod-hd">
        <div class="title">
            <h3>分支机构情况</h3>
        </div>
    </div>
     <div class="mod-bd">
        <div class="content content-contact">
          <div class="content-sm-height">
                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th width="90" class="bg">序号</th>
                        <th class="bg">分支机构名称</th>
                        <th class="bg">分支机构统一代码/注册号</th>
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
<%--企业社保信息--%>
<c:if test="${year>=2016}">
<form id="socialsecurityform" >
<input type="hidden" name="socialID" id = "socialID" value="${yrSfcSocialSecurity.socialID}"/> <!-- 社保信息唯一标识 -->
<div class="mod subcapital" style="display: block;">
    <div class="mod-hd">
        <div class="title">
            <h3>企业社保信息</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content">
            <div class="content-sm-height">
                <table class="table-public table-public2 table-public3" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th width="168">参保险种</th>
                        <th width="210">参保人数</th>
                        <th width="210">单位缴费基数</th>
                        <th width="210">本期实际缴费金额</th>
                        <th>单位累计欠缴金额</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>城镇职工基本养老保险</td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="endowmentNum" id="endowmentNum" value="${yrSfcSocialSecurity.endowmentNum}" class="ipt-txt sfcreport" >
                            </div>
                            人
                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="paymentEndowment"  value="${yrSfcSocialSecurity.paymentEndowment}" class="ipt-txt one sfcreport" >
                            </div>
                            <span class="light">万元</span>
                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="actualPayEndowment" value="${yrSfcSocialSecurity.actualPayEndowment}" class="ipt-txt two sfcreport" >
                                <i class="icon-close"></i>
                            </div>
                            <span class="light">万元</span>
                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="cumuEndowment" value="${yrSfcSocialSecurity.cumuEndowment}" class="ipt-txt three sfcreport" >
                                <i class="icon-close"></i>
                            </div>
                            <span class="light">万元</span>
                        </td>
                    </tr>
                    <tr>
                        <td>失业保险</td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="unemploymentNum" id="unemploymentNum" value="${yrSfcSocialSecurity.unemploymentNum}" class="ipt-txt sfcreport" >
                                <i class="icon-close"></i>
                            </div>
                            人
                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="paymentUnemployment" value="${yrSfcSocialSecurity.paymentUnemployment}" class="ipt-txt one sfcreport" >
                                <i class="icon-close"></i>
                            </div>
                            <span class="light">万元</span>
                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="actualPayUnemployment" value="${yrSfcSocialSecurity.actualPayUnemployment}" class="ipt-txt two sfcreport" >
                                <i class="icon-close"></i>
                            </div>
                            <span class="light">万元</span>
                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="cumuUnemployment" value="${yrSfcSocialSecurity.cumuUnemployment}" class="ipt-txt three sfcreport" >
                                <i class="icon-close"></i>
                            </div>
                            <span class="light">万元</span>
                        </td>
                    </tr>
                    <tr>
                        <td>职工基本医疗保险</td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="medicalNum" id="medicalNum" value="${yrSfcSocialSecurity.medicalNum}" class="ipt-txt sfcreport" >
                                <i class="icon-close"></i>
                            </div>
                            人
                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="paymentMedical" value="${yrSfcSocialSecurity.paymentMedical}" class="ipt-txt one sfcreport" >
                                <i class="icon-close"></i>
                            </div>
                            <span class="light">万元</span>
                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="actualPayMedical" value="${yrSfcSocialSecurity.actualPayMedical}" class="ipt-txt two sfcreport" >
                                <i class="icon-close"></i>
                            </div>
                            <span class="light">万元</span>
                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="cumuMedical" value="${yrSfcSocialSecurity.cumuMedical}" class="ipt-txt three sfcreport" >
                                <i class="icon-close"></i>
                            </div>
                            <span class="light">万元</span>
                        </td>
                    </tr>
                    <tr>
                        <td>工伤保险</td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="empInjuryNum" id="empInjuryNum" value="${yrSfcSocialSecurity.empInjuryNum}" class="ipt-txt sfcreport" >
                                <i class="icon-close"></i>
                            </div>
                            人
                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="paymentEmpInjury" value="${yrSfcSocialSecurity.paymentEmpInjury}" class="ipt-txt one sfcreport" >
                                <i class="icon-close"></i>
                            </div>
                            <span class="light">万元</span>
                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="actualPayEmpInjury" value="${yrSfcSocialSecurity.actualPayEmpInjury}" class="ipt-txt two sfcreport" >
                                <i class="icon-close"></i>
                            </div>
                            <span class="light">万元</span>
                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="cumuEmpInjury" value="${yrSfcSocialSecurity.cumuEmpInjury}" class="ipt-txt three sfcreport" >
                                <i class="icon-close"></i>
                            </div>
                            <span class="light">万元</span>
                        </td>
                    </tr>
                    <tr>
                        <td>生育保险</td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="maternityNum" id="maternityNum" value="${yrSfcSocialSecurity.maternityNum}" class="ipt-txt sfcreport" >
                                <i class="icon-close"></i>
                            </div>
                            人
                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="paymentMaternity" value="${yrSfcSocialSecurity.paymentMaternity}" class="ipt-txt one sfcreport" >
                                <i class="icon-close"></i>
                            </div>
                            <span class="light">万元</span>
                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="actualPayMaternity" value="${yrSfcSocialSecurity.actualPayMaternity}" class="ipt-txt two sfcreport" >
                                <i class="icon-close"></i>
                            </div>
                            <span class="light">万元</span>
                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="cumuMaternity" value="${yrSfcSocialSecurity.cumuMaternity}" class="ipt-txt three sfcreport" >
                                <i class="icon-close"></i>
                            </div>
                            <span class="light">万元</span>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" readonly="readonly" id="paymentBase" name="paymentBase" value="${yrSfcSocialSecurity.paymentBase}" class="ipt-txt sfcreport" >
                            </div>
                            <span class="light">万元</span>
                        </td>
                        <td>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" readonly="readonly" id="actualPayment" name="actualPayment" value="${yrSfcSocialSecurity.actualPayment}" class="ipt-txt sfcreport" >
                            </div>
                            <span class="light">万元</span>
                        </td>
                        <td>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" readonly="readonly" id="cumulArrears"  name="cumulArrears" value="${yrSfcSocialSecurity.cumulArrears}" class="ipt-txt sfcreport" >
                            </div>
                            <span class="light">万元</span>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td>
                            <div class="radio-box">
                                <label><input type="radio" name="paymentBaseIsPub" value="1" ${yrSfcSocialSecurity.paymentBaseIsPub=='1'?'checked':''}>公示</label>
                                <label><input type="radio" name="paymentBaseIsPub" value="0" ${yrSfcSocialSecurity.paymentBaseIsPub=='0'?'checked':''}>不公示</label>
                            </div>
                        </td>
                        <td>
                            <div class="radio-box">
                                <label><input type="radio" name="actualPaymentIsPub" value="1" ${yrSfcSocialSecurity.actualPaymentIsPub=='1'?'checked':''}>公示</label>
                                <label><input type="radio" name="actualPaymentIsPub" value="0" ${yrSfcSocialSecurity.actualPaymentIsPub=='0'?'checked':''}>不公示</label>
                            </div>
                        </td>
                        <td>
                            <div class="radio-box">
                                <label><input type="radio" name="cumulArrearsIsPub" value="1" ${yrSfcSocialSecurity.cumulArrearsIsPub=='1'?'checked':''}>公示</label>
                                <label><input type="radio" name="cumulArrearsIsPub" value="0" ${yrSfcSocialSecurity.cumulArrearsIsPub=='0'?'checked':''}>不公示</label>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</form>
</c:if>
<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/component/dropDown.js"/>"></script>
<script id="table-template-one" type="text/x-handlebars-template">
{{#each data}}  
             <tr>
                    <td>{{xh @index}}</td>
                    <td>{{licNameCN}}</td>
                    <td>{{valto valTo}}</td>
             </tr> 
{{/each}} 
</script>
<script id="table-template" type="text/x-handlebars-template">
    {{#each data}}  
             <tr>
                    <td>{{num @index}}</td>
                    <td>{{webtype webType}}</td>
                    <td>{{webSitName}}</td>
                    <td>{{webSite}}</td>
                </tr> 
    {{/each}} 
</script>
<script id="table-template-three" type="text/x-handlebars-template">
    {{#each data}}  
             <tr>
                    <td>{{addOne @index}}</td>
                    <td>{{brName}}</td>
                    <td>{{uniCode}}</td>
                </tr> 
    {{/each}} 
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/yr/entreportsearch/sfcreport_view.js"></script>
</body>
</html>