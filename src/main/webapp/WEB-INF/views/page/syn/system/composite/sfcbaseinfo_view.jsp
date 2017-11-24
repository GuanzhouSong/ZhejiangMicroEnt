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
    <title>农专社年报报送页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body class="pd10">
<%--基本信息--%>
<form class="form-horizontal error-bottom" id="form">
  <input type="hidden" name="anCheID" id = "anCheID" value="${yrSfcBaseinfo.anCheID}"/>
  <input type="hidden" name="year" id ="year" value="${yrSfcBaseinfo.year}"/>
 <div class="mod pbreport-basic">
    <div class="mod-hd">
        <div class="title">
            <h3>基本信息</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
            <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td class="odd" colspan="2">
                        <div class="item-name bg">名称字号</div>
                        <div class="ipt-box">
                            <input type="text" name="farSpeArtName" value="${yrSfcBaseinfo.farSpeArtName}" class="ipt-txt w725 sfcreport" readonly>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="item-name bg">统一社会信用代码/注册号</div>
                        <div class="ipt-box">
                            <input type="text" class="ipt-txt ipt-txt-lg sfcreport" value="${empty yrSfcBaseinfo.uniCode ? yrSfcBaseinfo.regNO : yrSfcBaseinfo.uniCode}" readonly>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state" colspan="2">
                        <div class="item-name bg">通信地址</div>
                        <div class="ipt-box js-ipt-box">
                            ${yrSfcBaseinfo.dom}
                        </div>
                    </td>
                </tr>
                 <tr>
                    <td class="odd focus-state" colspan="4">
                        <div class="item-name">经营(业务)范围:</div>
                        <div class="ipt-box">
                            <textarea rows="2" disabled="disabled" name="opScope" style= "height:60px;" class="ipt-txt w725 sfcreport" readonly="readonly">${yrSfcBaseinfo.opScope}</textarea>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name bg"><strong class="light">* </strong>本年度新增</div>
                        <div class="ipt-box js-ipt-box">
                            ${yrSfcBaseinfo.annNewMemNum} 
                        </div>
                        <strong class="light">人</strong>
                    </td>
                    <td class="odd focus-state">
                        <div class="item-name bg"><strong class="light">* </strong>退出</div>
                        <div class="ipt-box js-ipt-box">
                           ${yrSfcBaseinfo.annRedMemNum}
                        </div>
                        <strong class="light">人</strong>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name bg"><strong class="light">* </strong>实际人数共</div>
                        <div class="ipt-box js-ipt-box">
                            ${yrSfcBaseinfo.memNum}
                        </div>
                        <strong class="light">人</strong>
                    </td>
                    <td class="odd focus-state">
                        <div class="item-name bg"><strong class="light">* </strong>其中农民人数</div>
                        <div class="ipt-box js-ipt-box">
                            ${yrSfcBaseinfo.farnum}
                        </div>
                        <strong class="light">人</strong>
                    </td>
                </tr>
                   <tr>
                    <td class="odd focus-state">
                        <div class="item-name"><strong class="light">*</strong>出资总额</div>
                        <div class="ipt-box js-ipt-box">
                            <fmt:formatNumber value="${yrSfcBaseinfo.memConGro}" pattern="###,###,###,##0.00"/>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                    <td class="odd focus-state">
                        <div class="item-name"><strong class="light">*</strong>社员信用户</div>
                        <div class="ipt-box js-ipt-box">
                            ${yrSfcBaseinfo.creditMem}
                        </div>
                        <strong class="light">%</strong>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name bg"><strong class="light">* </strong>从业人数</div>
                        <div class="ipt-box js-ipt-box">
                            ${empty yrSfcBaseinfo.empNum?'0':yrSfcBaseinfo.empNum}
                        </div>
                         <strong class="light">人</strong>                      
                    </td>
                    <td class="odd">
                        <div class="radio-box">
                            <label><input type="radio" name="empNumDis" value="1" <c:if test="${yrSfcBaseinfo.empNumDis == '1'}">checked</c:if> >公示</label>
                            <label><input type="radio" name="empNumDis" value="0" <c:if test="${yrSfcBaseinfo.empNumDis == '0'}">checked</c:if> >不公示</label>
                        </div>
                    </td>
                </tr>                
                <c:if test="${yrSfcBaseinfo.year > 2015}">               
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name bg"><strong class="light">* </strong>女性从业人数</div>
                        <div class="ipt-box js-ipt-box">
                            ${yrSfcBaseinfo.femaleEmploye}
                        </div>
                        <strong class="light">人</strong>
                    </td>
                    <td class="odd">
                        <div class="radio-box">
                            <label><input type="radio" name="femaleEmployeIsPub" value="1" <c:if test="${yrSfcBaseinfo.femaleEmployeIsPub == '1'}">checked</c:if> >公示</label>
                            <label><input type="radio" name="femaleEmployeIsPub" value="0" <c:if test="${yrSfcBaseinfo.femaleEmployeIsPub == '0'}">checked</c:if> >不公示</label>
                        </div>
                    </td>
                </tr>
                </c:if>
                <c:if test="${yrSfcBaseinfo.year > 2015}">
                <tr>
                    <td class="odd focus-state" colspan="2">
                        <div class="item-name special bg">主营业务活动</div>
                        <textarea disabled="disabled" id="mainBusActivity" name="entMainBusActivity" class="textarea sfcreport"  placeholder="请填写具体的主营业务内容">${yrSfcBaseinfo.entMainBusActivity}</textarea>
                    </td>
                </tr>
               </c:if>                               
                </tbody>
            </table>
        </div>
    </div>
</div>

<%--资产状况信息(币种：人民币)--%>
<div class="mod pbreport-basic">
    <div class="mod-hd">
        <div class="title">
            <h3>资产状况信息(币种：人民币)</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
            <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name bg"><strong class="light">* </strong>销售额或营业收入(元)</div>
                        <div class="ipt-box js-ipt-box">
                          <fmt:formatNumber value="${yrSfcBaseinfo.vendInc}" pattern="###,###,###,##0.00"/>
                        </div>
                    </td>
                    <td class="odd"> 
                        <div class="radio-box">
	                        ${yrSfcBaseinfo.vendIncIsPub == '1'?'公示':''}
	                        ${yrSfcBaseinfo.vendIncIsPub == '0'?'不公示':''}
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name bg"><strong class="light">* </strong>盈余总额(元)</div>
                        <div class="ipt-box js-ipt-box">
                            <fmt:formatNumber value="${yrSfcBaseinfo.priYeaProfit}" pattern="###,###,###,##0.00"/>
                        </div>
                    </td>
                    <td class="odd">
                        <div class="radio-box">
                            ${yrSfcBaseinfo.maiBusIncIsPub == '1'?'公示':''}
	                        ${yrSfcBaseinfo.maiBusIncIsPub == '0'?'不公示':''}
                       </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name bg"><strong class="light">* </strong>纳税总额(元)</div>
                        <div class="ipt-box js-ipt-box">
                          <fmt:formatNumber value="${yrSfcBaseinfo.ratGro}" pattern="###,###,###,##0.00"/> 
                        </div>
                    </td>
                    <td class="odd">
                        <div class="radio-box">
                            ${yrSfcBaseinfo.ratGroIsPub == '1'?'公示':''}
	                        ${yrSfcBaseinfo.ratGroIsPub == '0'?'不公示':''}
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name bg"><strong class="light">* </strong>获得政府扶持资金、补助(元)</div>
                        <div class="ipt-box js-ipt-box">
                          <fmt:formatNumber value="${yrSfcBaseinfo.priYeaSub}" pattern="###,###,###,##0.00"/> 
                        </div>
                    </td>
                    <td class="odd"> 
                        <div class="radio-box">
                            ${yrSfcBaseinfo.priYeaSubIsPub == '1'?'公示':''}
	                        ${yrSfcBaseinfo.priYeaSubIsPub == '0'?'不公示':''}
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name bg"><strong class="light">* </strong>金融贷款(元)</div>
                        <div class="ipt-box js-ipt-box">
                            <fmt:formatNumber value="${yrSfcBaseinfo.priYeaLoan}" pattern="###,###,###,##0.00"/>
                        </div>
                    </td>
                    <td class="odd"> 
                        <div class="radio-box">
                            ${yrSfcBaseinfo.priYeaLoanIsPub == '1'?'公示':''}
	                        ${yrSfcBaseinfo.priYeaLoanIsPub == '0'?'不公示':''}
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
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
            <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name"><strong class="light">* </strong>法定代表人姓名</div>
                        <div class="ipt-box js-ipt-box">
                            ${yrSfcBaseinfo.leRep}
                        </div>
                    </td>
                    <td class="odd focus-state">
                        <div class="item-name"><strong class="light">* </strong>法定代表人手机号码</div>
                        <div class="ipt-box js-ipt-box">
                           ${yrSfcBaseinfo.leRepPhone}
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name"><strong class="light">* </strong>工商联络员姓名</div>
                        <div class="ipt-box js-ipt-box">
                            ${yrSfcBaseinfo.liaName}
                        </div>
                    </td>
                    <td class="odd focus-state">
                        <div class="item-name"><strong class="light">* </strong>联络员手机号码</div>
                        <div class="ipt-box js-ipt-box">
                            ${yrSfcBaseinfo.liaPhone}
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name"><strong class="light">* </strong>联络员证件类型</div>
		                    <c:forEach items="${Certypes}" var="certype" varStatus="status">
			                    <c:if test="${yrSfcBaseinfo.liaIDType == certype.code}">${certype.content }</c:if> 
			                </c:forEach>
                    </td>
                    <td class="odd focus-state">
                        <div class="item-name"><strong class="light">* </strong>联络员证件号码</div>
                        <div class="ipt-box js-ipt-box">
                            ${yrSfcBaseinfo.liaIDNum}
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name bg"><strong class="light">* </strong>农专社联系电话</div>
                        <div class="ipt-box js-ipt-box">
                            ${yrSfcBaseinfo.tel}
                        </div>
                    </td>
                    <td class="odd focus-state">
                        <div class="item-name bg"><strong class="light">* </strong>农专社电子邮箱</div>
                        <div class="ipt-box js-ipt-box">
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
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
            <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td class="odd">
                     <input type="hidden" name="icService" id="icService" value="${yrSfcBaseinfo.icService}"><!-- 年报id -->
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
            <h3>开设网站网店情况</h3> 
        </div>
    </div>
    <div class="mod-bd">
        <div class="content"> 
          <!-- 网站查询信息 -->
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
<div class="mod subcapital">
    <div class="mod-hd">
        <div class="title">
            <h3>取得许可证情况</h3> 
        </div>
    </div>
    <div class="mod-bd">
        <div class="content"> 
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
        <div class="content"> 
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
                                <input type="text"  readonly="readonly" name="paymentEndowment" value="${yrSfcSocialSecurity.paymentEndowment}" class="ipt-txt one" placeholder="">

                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="actualPayEndowment" value="${yrSfcSocialSecurity.actualPayEndowment}" class="ipt-txt two" placeholder="">

                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="cumuEndowment" value="${yrSfcSocialSecurity.cumuEndowment}" class="ipt-txt three" placeholder="">
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
                                <input type="text"  readonly="readonly" name="paymentUnemployment" value="${yrSfcSocialSecurity.paymentUnemployment}" class="ipt-txt one" placeholder="">
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="actualPayUnemployment" value="${yrSfcSocialSecurity.actualPayUnemployment}" class="ipt-txt two" placeholder="">
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="cumuUnemployment" value="${yrSfcSocialSecurity.cumuUnemployment}" class="ipt-txt three" placeholder="">
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
                                <input type="text"  readonly="readonly" name="paymentMedical" value="${yrSfcSocialSecurity.paymentMedical}" class="ipt-txt one" placeholder="">
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="actualPayMedical" value="${yrSfcSocialSecurity.actualPayMedical}" class="ipt-txt two" placeholder="">
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="cumuMedical" value="${yrSfcSocialSecurity.cumuMedical}" class="ipt-txt three" placeholder="">
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
                                <input type="text"  readonly="readonly" name="paymentEmpInjury" value="${yrSfcSocialSecurity.paymentEmpInjury}" class="ipt-txt one" placeholder="">
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="actualPayEmpInjury" value="${yrSfcSocialSecurity.actualPayEmpInjury}" class="ipt-txt two" placeholder="">
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="cumuEmpInjury" value="${yrSfcSocialSecurity.cumuEmpInjury}" class="ipt-txt three" placeholder="">
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
                                <input type="text"  readonly="readonly" name="paymentMaternity" value="${yrSfcSocialSecurity.paymentMaternity}" class="ipt-txt one" placeholder="">
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="actualPayMaternity" value="${yrSfcSocialSecurity.actualPayMaternity}" class="ipt-txt two" placeholder="">
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="cumuMaternity" value="${yrSfcSocialSecurity.cumuMaternity}" class="ipt-txt three" placeholder="">
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


<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/component/dropDown.js"/>"></script>
<script src="<c:url value="/js/lib/placeholder/jquery.placeholder.min.js"/>"></script>
<script src="<c:url value="/js/lib/jquery/jquery.icinfo.js"/>"></script>
 
 
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
<script>
    window._CONFIG = {
    	pubEppassword:'${pubEppassword}', //获取备案信息对象（仅能判断是否存在）
    	leRep:'${pubEppassword.lerep}' ,      //法定代表人
    	leRepPhone:'${pubEppassword.lerepphone}',  //法定代表人电话
    	liaName:'${pubEppassword.lianame}',  //联络员姓名
    	tel:'${pubEppassword.tel}',  //联络员电话
    	liaIDType:'${pubEppassword.liaidtype}',  //联络员证件号码
    	liaIDNum:'${pubEppassword.liaidnum}',  //联络员证件号码
    	icService:'${yrSfcBaseinfo.icService}', //工商服务信息
    	othICService:'${yrSfcBaseinfo.othICService}', //工商其他服务信息
    	_sysUrl:'${sysUrl}'
        
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="<c:url value="/js/syn/system/composite/sfcbaseinfo_view_main.js"/>"></script>
</body>
</html>