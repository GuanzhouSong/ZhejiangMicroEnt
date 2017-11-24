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
<body>


<%--电子公章 start--%>
<c:if test="${ yrRegCheck.reportState != '20'&& yrRegCheck.reportState != '00'}">
    <div style="position: absolute;top: 72px;right: -108px;display: ${!empty qzImgBase64?'block':'none'}">
        <img src="${qzImgBase64}" style="width: 30%"/>
    </div>
</c:if>
<%--电子公章 end--%>

<!-- 头部 -->
<jsp:include page="../../common/header.jsp"></jsp:include>
<div class="banner-bg">
    <div class="mod banner">
        <h4>欢迎您！${midBaseInfoDto.entName}</h4>
        <p>
            <em class="js-show-tips show-tips fr" data-component="dropDown" data-trigger="toggle" data-target=".js-fold-msg">年报信息<i class="tiny-icon"></i></em>
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

        <%-- <p class="warn-txt">敬请下载安装<span>“联连”企业信用信息警示软件</span>，第一时间获取企业信用警示提示。避免消息滞后，延误处理，影响贵企业的信用状况</p>--%>
        <%--<a href="##"  target="_blank" class="download btn-icon"><h5>安装客户端软件</h5><span>第一时间获取预警信息推送</span></a>--%>
    </div>
</div>
<div class="fold-msg-bg js-fold-msg">
    <div class="mod state-msg">
        <em class="ann-rep">
            <span class="pdb16"><label>年报年度：</label>${yrRegCheck.year}年度</span>
            <span>
            	<label>首次提交：</label>
                <c:if test="${!empty yrRegCheck.firstReportTime}">
                    <fmt:formatDate value="${yrRegCheck.firstReportTime}" pattern="yyyy年MM月dd日"/>
                </c:if>
            </span>
        </em>
        <em class="rep-state">
            <span class="pdb16">
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
            <span class="pdb16"><label>公示状态：</label>
                <strong class="<c:if test="${yrRegCheck.reportState == '12' || yrRegCheck.reportState == '13'}">light</c:if> mr-20 inline-block">${yrRegCheck.reportStateClientDesc}</strong>
            </span>
            <span><label>历次年报公示记录：</label><a href="<c:url value="/reg/client/yr/sfc/yrprint/readSfcReportPage"/>?year=${encodeYear}"  target="_blank">查看</a></span>
        </em>
    </div>
</div>

<div class="mod caiwu">
    <div class="mod-hd">
        <div class="links">
            <c:if test="${yrRegCheck.reportState == '10' || yrRegCheck.reportState == '11'}">
                <!--申请修改年度报告（6月30日后 或者 之前年度）-->
                <c:if test="${duedate > 0630 || yrRegCheck.year < nowyear -1}">
                    <a href="javascript:void(0);" class="first" id="modapply">申请修改年度报告</a>
                </c:if>
                <!--修改年度报告（当年度6月30日前）-->
                <c:if test="${duedate <= 0630 && yrRegCheck.year == nowyear -1}">
                    <a href="javascript:void(0);" class="first" id="mod">修改年度报告</a>
                </c:if>
            </c:if>
            <c:if test="${yrRegCheck.isReported == '1' || yrRegCheck.isReported == '2'}">
                <a  href="<c:url value="/reg/client/yr/sfc/yrprint/showSfcReportProve"/>?year=${encodeYear}&printFalg=1"  target="_blank">查看与打印年度报告</a>
                <a   href="#"  id="printsfcReportProve">打印年度报告证明</a>
            </c:if>
        </div>

        <div class="tips">
            <span class="txt">报表中背景颜色为</span>
            <span class="blockage"></span>
            <span class="txt">的内容经选择公示后将公示于企业信用信息公示系统</span>
        </div>
    </div>
</div>

<!---后台传入的参数值-->
<form id="form-wz-params">
    <input type="hidden" name="anCheID" value="${yrSfcBaseinfo.anCheID}">
    <input type="hidden" name="priPID"  value="${yrSfcBaseinfo.priPID}"/>
    <input type="hidden" name="year"    value="${yrSfcBaseinfo.year}"/>
</form>



<%--基本信息--%>
<form class="form-horizontal error-bottom" id="form">
    <input type="hidden" name="anCheID" id = "anCheID" value="${yrSfcBaseinfo.anCheID}"/>
    <input type="hidden" name="priPID" id ="priPID" value="${yrSfcBaseinfo.priPID}"/>
    <input type="hidden" name="year" id ="year" value="${yrSfcBaseinfo.year}"/>
    <input type="hidden" name="regNO" id ="regNO" value="${yrSfcBaseinfo.regNO}"/>
    <input type="hidden" name="uniCode" id ="uniCode" value="${yrSfcBaseinfo.uniCode}"/>
    <input type="hidden" id ="encodeYear" value="${encodeYear}"/>
    <input type="hidden" id ="websiteFlag" name="websiteFlag" value="${yrSfcBaseinfo.websiteFlag}"/>
    <div class="mod pbreport-basic">
        <div class="mod-hd">
            <div class="title">
                <h3>基本信息</h3>
                <p>以下内容请按照当前农专社最新的情况进行填写</p>
            </div>
        </div>
        <div class="mod-bd">
            <div class="content content-contact">
                <table class="table-public table-contact table-selected " border="0" cellspacing="0" cellpadding="0">
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

                    <%--新增的企业住所 start--%>
                    <tr>
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name special ">
                                <strong class="light">* </strong>
                                住所
                            </div>
                            <div class="ipt-box">
                                <div class="item-select">
                                    <select name="" class="select-txt" disabled>
                                        <option value="330000000000">浙江省</option>
                                    </select>
                                    <select name="cityAddressCopy" class="select-txt" id="select_city_copy" >
                                        <option value="" >--请选择--</option>
                                    </select>
                                    <select name="areaAddressCopy" class="select-txt" id="select_area_copy" >
                                        <option value="" >--请选择--</option>
                                    </select>
                                    <select name="streeAddressCopy" class="select-txt" id="select_stree_copy" >
                                        <option value="" >--请选择--</option>
                                    </select>
                                </div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="" class="ipt-txt" name="addrDom" value="${sessionScope.midBaseInfoDto.dom}" placeholder="" readonly >
                                </div>
                            </div>
                        </td>
                    </tr>
                    <%--新增的企业住所 end--%>

                    <%--企业通讯地址 start--%>
                    <tr>
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name special bg">
                                <i class="icon-question" id="A" data-id="A" data-msg="企业通讯地址指企业接收法律文书、信函通知的详细地址"></i>
                                <strong class="light">* </strong>通信地址
                            </div>
                            <div class="ipt-box">
                                <div class="item-select">
                                    <select name="" class="select-txt" disabled>
                                        <option value="330000000000">浙江省</option>
                                    </select>
                                    <select name="cityAddress" class="select-txt" id="select_city" >
                                        <option value="" >--请选择--</option>
                                    </select>
                                    <select name="areaAddress" class="select-txt" id="select_area" >
                                        <option value="" >--请选择--</option>
                                    </select>
                                    <select name="streeAddress" class="select-txt" id="select_stree" >
                                        <option value="" >--请选择--</option>
                                    </select>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" id="desc_address" class="ipt-txt" name="desAddress" value="${yrSfcBaseinfo.desAddress}" placeholder="" style="width: 226px;">
                                        <i class="icon-close" id="icon-close-delete"></i>
                                    </div>
                                </div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="info_address" class="ipt-txt" name="dom" value="${yrSfcBaseinfo.dom}" placeholder="" readonly >
                                </div>
                            </div>
                        </td>
                    </tr>
                    <%--企业通讯地址 end--%>


                    <%--
                    <tr>
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name bg">通信地址</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="dom" value="${yrSfcBaseinfo.dom}" class="ipt-txt w725 sfcreport" >
                            </div>
                        </td>
                    </tr>
                    --%>

                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name bg"><strong class="light">* </strong>农专社联系电话</div>
                            <div class="radio-box js-ipt-box">
                                <label><input type="radio" id="tel_no" name="otherInfoIsTel" value="0"  <c:if test="${empty  yrSfcBaseinfo.tel}">checked</c:if> >无</label>
                                <label><input type="radio" id="tel_yes" name="otherInfoIsTel" value="1"  <c:if test="${not empty  yrSfcBaseinfo.tel}">checked</c:if> >有</label>
                            </div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="tel" id = "tel" value="${yrSfcBaseinfo.tel}" class="ipt-txt  sfcreport" placeholder="" required>
                                <i class="icon-close"></i>
                            </div>
                        </td>

                        <td class="even focus-state">
                            <div class="item-name bg"><strong class="light">* </strong>农专社电子邮箱</div>
                            <div class="radio-box js-ipt-box">
                                <label><input type="radio" id="email_no" name="otherInfoIsEmail" value="0"  <c:if test="${empty  yrSfcBaseinfo.email}">checked</c:if> >无</label>
                                <label><input type="radio" id="email_yes" name="otherInfoIsEmail" value="1"  <c:if test="${not empty  yrSfcBaseinfo.email}">checked</c:if> >有</label>
                            </div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="email" value="${yrSfcBaseinfo.email}"  class="ipt-txt sfcreport">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                    </tr>


                    <tr>
                        <td class="odd focus-state" colspan="4">
                            <div class="item-name">经营(业务)范围:</div>
                            <div class="ipt-box">
                                <textarea rows="2" name="opScope" style= "height:60px;" class="ipt-txt w725 sfcreport" readonly="readonly">${yrSfcBaseinfo.opScope}</textarea>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name bg"><strong class="light">* </strong>本年度新增</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="annNewMemNum" id="annNewMemNum" value="${yrSfcBaseinfo.annNewMemNum}" class="ipt-txt ipt-txt-lg sfcreport" placeholder="">
                                <i class="icon-close"></i>
                            </div>
                            <strong class="light">人</strong>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name bg"><strong class="light">* </strong>退出</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="annRedMemNum" id="annRedMemNum" value="${yrSfcBaseinfo.annRedMemNum}" class="ipt-txt ipt-txt-lg sfcreport" placeholder="">
                                <i class="icon-close"></i>
                            </div>
                            <strong class="light">人</strong>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name bg"><strong class="light">* </strong>实际人数共</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="memNum" id="memNum" value="${yrSfcBaseinfo.memNum}" class="ipt-txt ipt-txt-lg sfcreport" placeholder="">
                                <i class="icon-close"></i>
                            </div>
                            <strong class="light">人</strong>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name bg"><strong class="light">* </strong>其中农民人数</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="farnum" id="farnum" value="${yrSfcBaseinfo.farnum}" class="ipt-txt ipt-txt-lg sfcreport" placeholder="">
                                <i class="icon-close"></i>
                            </div>
                            <strong class="light">人</strong>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name"><strong class="light">*</strong>出资总额</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="memConGro" value="${yrSfcBaseinfo.memConGro}" class="ipt-txt ipt-txt-lg units sfcreport" placeholder="请输入金额">
                                <i class="icon-close"></i>
                            </div>
                            <strong class="light">元</strong>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name"><strong class="light">*</strong>社员信用户</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="creditMem" value="${yrSfcBaseinfo.creditMem}" class="ipt-txt ipt-txt-lg sfcreport" placeholder="">
                                <i class="icon-close"></i>
                            </div>
                            <strong class="light">%</strong>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name bg"><strong class="light">* </strong>从业人数</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="empNum" id="empNum" value="${yrSfcBaseinfo.empNum}" class="ipt-txt ipt-txt-lg sfcreport" placeholder="" >
                                <i class="icon-close"></i>
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
                                    <input type="text" name="femaleEmploye" id="femaleEmploye" value="${yrSfcBaseinfo.femaleEmploye}" class="ipt-txt ipt-txt-lg sfcreport" placeholder="">
                                    <i class="icon-close"></i>
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
                                <div class="item-name special bg">
                                    <i class="icon-question" id="nzzyywhd" data-id="nzzyywhd" data-msg="指农专社实际从事的主要业务活动"></i>
                                    主营业务活动
                                </div>
                                <div class="ipt-box">
                                    <textarea  name="entMainBusActivity" class="textarea sfcreport"  placeholder="">${yrSfcBaseinfo.entMainBusActivity}</textarea>
                                </div>
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
                <p>以下信息请按照截止${yrRegCheck.year}年度12月31日时的情况进行填写
                </p>
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
                                <input type="text" name="vendInc" value="${yrSfcBaseinfo.vendInc}" class="ipt-txt ipt-txt-lg units sfcreport" placeholder="请输入金额" >
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td class="odd">

                            <div class="radio-box">
                                <label><input type="radio" name="vendIncIsPub" value="1" <c:if test="${yrSfcBaseinfo.vendIncIsPub == '1'}">checked</c:if> >公示</label>
                                <label><input type="radio" name="vendIncIsPub" value="0" <c:if test="${yrSfcBaseinfo.vendIncIsPub == '0'}">checked</c:if> >不公示</label>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name bg"><strong class="light">* </strong>盈余总额(元)</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="priYeaProfit" value="${yrSfcBaseinfo.priYeaProfit}" class="ipt-txt ipt-txt-lg units sfcreport" placeholder="请输入金额" >
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td class="odd">
                            <div class="radio-box">
                                <label><input type="radio" name="maiBusIncIsPub" value="1" <c:if test="${yrSfcBaseinfo.maiBusIncIsPub == '1'}">checked</c:if>> 公示</label>
                                <label><input type="radio" name="maiBusIncIsPub" value="0" <c:if test="${yrSfcBaseinfo.maiBusIncIsPub == '0'}">checked</c:if> >不公示</label>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name bg"><strong class="light">* </strong>纳税总额(元)</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="ratGro" value="${yrSfcBaseinfo.ratGro}" class="ipt-txt ipt-txt-lg units sfcreport" placeholder="请输入金额">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td class="odd">

                            <div class="radio-box">
                                <label><input type="radio" name="ratGroIsPub" value="1" <c:if test="${yrSfcBaseinfo.ratGroIsPub == '1'}">checked</c:if> >公示</label>
                                <label><input type="radio" name="ratGroIsPub" value="0" <c:if test="${yrSfcBaseinfo.ratGroIsPub == '0'}">checked</c:if> >不公示</label>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name bg"><strong class="light">* </strong>获得政府扶持资金、补助(元)</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="priYeaSub" value="${yrSfcBaseinfo.priYeaSub}" class="ipt-txt ipt-txt-lg units sfcreport" placeholder="请输入金额">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td class="odd">

                            <div class="radio-box">
                                <label><input type="radio" name="priYeaSubIsPub" value="1" <c:if test="${yrSfcBaseinfo.priYeaSubIsPub == '1'}">checked</c:if> >公示</label>
                                <label><input type="radio" name="priYeaSubIsPub" value="0" <c:if test="${yrSfcBaseinfo.priYeaSubIsPub == '0'}">checked</c:if> >不公示</label>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name bg"><strong class="light">* </strong>金融贷款(元)</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="priYeaLoan" value="${yrSfcBaseinfo.priYeaLoan}" class="ipt-txt ipt-txt-lg units sfcreport" placeholder="请输入金额" >
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td class="odd">

                            <div class="radio-box">
                                <label><input type="radio" name="priYeaLoanIsPub" value="1" <c:if test="${yrSfcBaseinfo.priYeaLoanIsPub == '1'}">checked</c:if> >公示</label>
                                <label><input type="radio" name="priYeaLoanIsPub" value="0" <c:if test="${yrSfcBaseinfo.priYeaLoanIsPub == '0'}">checked</c:if> >不公示</label>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <%--联系信息--%>
    <%--<div class="mod pbreport-basic">
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
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name ="leRep" value="${yrSfcBaseinfo.leRep}" id="leRep"  class="ipt-txt ipt-txt-lg sfcreport" readonly="readonly" placeholder="请输入姓名" >
                                <i class="icon-close viewicon"></i>
                            </div>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name"><strong class="light">* </strong>法定代表人手机号码</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="leRepPhone" id="leRepPhone"  value="${yrSfcBaseinfo.leRepPhone}" class="ipt-txt ipt-txt-lg sfcreport" placeholder="请输入手机号码" >
                                <i class="icon-close viewicon"></i>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name"><strong class="light">* </strong>工商联络员姓名</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="liaName" id ="liaName" value="${yrSfcBaseinfo.liaName}" class="ipt-txt ipt-txt-lg sfcreport" placeholder="请输入联络员姓名" >
                                <i class="icon-close viewicon"></i>
                            </div>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name"><strong class="light">* </strong>联络员手机号码</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="liaPhone" id="liaPhone" value="${yrSfcBaseinfo.liaPhone}" class="ipt-txt ipt-txt-lg sfcreport" placeholder="请输入联络员手机号码" >
                                <i class="icon-close viewicon"></i>
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
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="liaIDNum" id = "liaIDNum" value="${yrSfcBaseinfo.liaIDNum}" class="ipt-txt ipt-txt-lg sfcreport" placeholder="请输入联络员证件号码">
                                <i class="icon-close viewicon"></i>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name bg"><strong class="light">* </strong>农专社联系电话</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="tel" id = "tel" value="${yrSfcBaseinfo.tel}" class="ipt-txt ipt-txt-lg sfcreport" placeholder="请输入联系电话" required>
                                <i class="icon-close"></i>
                            </div>
                        </td>

                            <td class="even focus-state">
                                <div class="item-name bg"><strong class="light">* </strong>农专社电子邮箱</div>
                                <div class="radio-box js-ipt-box">
                                    <label><input type="radio" id="email_no" name="otherInfoIsEmail" value="0"  <c:if test="${empty  yrSfcBaseinfo.email}">checked</c:if> >无</label>
                                    <label><input type="radio" id="email_yes" name="otherInfoIsEmail" value="1"  <c:if test="${not empty  yrSfcBaseinfo.email}">checked</c:if> >有</label>
                                </div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="email" value="${yrSfcBaseinfo.email}"  class="ipt-txt sfcreport">
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>--%>

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


    <%--添加开设网站网店情况 start--%>

    <div id="webAndStoreInfo" class="mod yonggong">
        <div class="mod-hd">
            <div class="title">
                <h3>网站或网店信息</h3>
                <p>以下信息请按照企业当前实际情况填写，如有多个网站或网店可多次添加。</p>
            </div>
        </div>
        <div class="mod-bd">
            <div class="content content-yonggong">
                <table class="table-public table-yonggong" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name bg"><strong class="light">* </strong>企业是否有网站或网店</div>
                            <div class="radio-box">
                                <label><input type="radio" id="js-yes" name="websiteFlag" value="1"  <c:if test="${yrSfcBaseinfo.websiteFlag == '1'}">checked</c:if>/>是</label>
                                <label><input type="radio" id="js-no" name="websiteFlag" value="0" <c:if test="${yrSfcBaseinfo.websiteFlag == '0'}">checked</c:if>/>否</label>
                            </div>

                            <c:if test="${yrRegCheck.reportState == '00' || yrRegCheck.reportState == '13' || yrRegCheck.reportState == '20'}">
                                <div class="radio-box" id="js-checkbox" style="display: ${yrSfcBaseinfo.websiteFlag == '1'?'inline-block':'none'};font-size: 14px;">
                                    <div class="radio-box" style="margin-left: 20px;">
                                        <strong class="light">请选择一种类型进行添加</strong>：
                                        <label><input type="checkbox" id="js-checkbox-one"    value="1">信息网站</label>&nbsp;&nbsp;
                                        <label><input type="checkbox" id="js-checkbox-two"    value="2">交易网站</label>&nbsp;&nbsp;
                                        <label><input type="checkbox" id="js-checkbox-three"  value="3">网店(或微店)</label>&nbsp;&nbsp;
                                    </div>
                                </div>
                            </c:if>

                        </td>
                    </tr>
                </table>
            </div>

            <table class="table-public table-web" style="margin-bottom: 4px;">
                <thead>
                <tr>
                    <th width="100">类型</th>
                    <th width="400">名称</th>
                    <th width="400">域名</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="_websit" dataSize="${fn:length(yrSfcWebsiteInfoList)}">
                <c:forEach var="list" items="${yrSfcWebsiteInfoList}">
                    <tr>
                        <td>
                            <c:if test="${list.webType=='2'}">网店(或微店)</c:if>
                            <c:if test="${list.webType=='1'}">${list.webSmallType=='1'?'交易网站':'信息网站'}</c:if>
                        </td>
                        <td>${list.webSitName}</td>
                        <td>${list.webSite}</td>
                        <td>
                            <a href="javascript:void(0)" class="_show" data-webid="${list.webID}">详情</a>
                            <c:if test="${yrRegCheck.reportState == '00' || yrRegCheck.reportState == '13' || yrRegCheck.reportState == '20'}">
                                <a href="javascript:void(0)" class="_delete" data-webid="${list.webID}"  data-pripid="${list.priPID}">删除</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <%--添加开设网站网店情况 end--%>

</form>


<%--添加取得许可证情况 block--%>
<div class="mod mod-border investment-info js-content-show" id= "mod_licence" style="display: none;">
    <div class="mod-hd">
        <div class="title">
            <h3>添加取得许可证情况</h3>
            <p>以下内容请按照当前你农专社经营范围中涉及的前置或后置许可证进行填写</p>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content">
            <form class="form-horizontal error-bottom" id="licenceForm">
                <input type="hidden" name="licName" id ="licName" class="lichidden" value="${yrSfcLicenceInfo.licName}" ><!-- 许可证code -->
                <input type="hidden" name="anCheID" class="anCheID" value="${yrSfcBaseinfo.anCheID}" ><!-- 年报id -->
                <input type="hidden" name="licID" id="licID" class="lichidden" value="${yrSfcLicenceInfo.licID}"><!-- 许可证id -->
                <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name">行政许可名称</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="licNameCN" id = "licNameCN" class="ipt-txt ipt-txt-lg sfcreport" maxlength="20" placeholder="选择经营范围内涉及的许可">
                                <i class="icon-close"></i>
                            </div>
                            <strong class="light pointer" id="licenceList">许可证列表</strong>
                        </td>
                    </tr>
                    <tr>
                        <td class="even focus-state">
                            <div class="item-name">有效期至</div>
                            <div class="ipt-box">
                                <input type="text" name="valTo" id="valTo" class="ipt-txt laydate-icon ipt-txt-lg sfcreport" onclick="laydate({istime:true})" readonly="readonly" placeholder="选择许可证有效期截止日期">
                            </div>
                            <strong class="light"><label><input type="checkbox" name= "longTime"  id="longTime">无有效期或长期有效</label></strong>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <div class="btn-box">
                    <input type="submit" value="确定" class="btn-common sfcreport" >
                    <input type="button" value="取消" class="btn-common" id="licenceCancel">
                </div>
            </form>
        </div>
    </div>
</div>
<%--取得许可证情况--%>
<div class="mod subcapital">
    <div class="mod-hd">
        <div class="title">
            <h3>取得许可证情况</h3>
            <div class="btn-box">
                <a class="btn-common btn-add sfcreportbutton" id="js-add">新增</a>
            </div>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content">
            <div class="subcapital-tips">
                <label><input type="checkbox" id="checkLicAll" >全选</label>
                默认读取许可证信息<c:if test="${yrRegCheck.reportState == '00' || yrRegCheck.reportState == '13' || yrRegCheck.reportState == '20'}">，请根据企业当前实际情况进行<strong class="light">添加/修改</strong></c:if>
                <div class="fr edit">
                    <a id="js-edit" href="javascript:void(0);" class="sfcreportbutton">修改</a>
                    <a id="js-delete" href="javascript:void(0);" class="sfcreportbutton">删除</a>
                </div>
            </div>
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

<%--添加分支机构情况--%>
<div class="mod mod-border investment-info js-content-show" id = "mod_brach" style="display: none;">
    <div class="mod-hd">
        <div class="title">
            <h3>添加分支机构情况</h3>
            <p>以下信息请按照截止${yrRegCheck.year}年度12月31日时的情况进行填写。若你社无分支机构情况请直接空白表单保存。单击选中信息可进行修</p>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content">
            <form class="form-horizontal error-bottom" id="brachForm" >
                <input type="hidden" name="anCheID" class="anCheID" value="${yrSfcBaseinfo.anCheID}"><!-- 年报id -->
                <input type="hidden" name="brID" id ="brID" class="brhidden" value="${yrSfcBranchInfo.brID}"><!-- 网站id -->
                <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name">分支机构统一社会信用码/注册号</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="uniCode" id="branUniCode" class="ipt-txt  ipt-txt-lg sfcreport" placeholder="请输入分支机构统一代码/注册号" >
                                <i class="icon-close branch"></i>
                            </div>
                        </td>
                        <td class="odd">
                            <div class="item-name">分支机构名称</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="brName" id="brName" readonly="readonly" class="ipt-txt  ipt-txt-lg sfcreport" placeholder="请输入分支机构名称">
                                <i class="icon-close branch"></i>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <div class="btn-box">
                    <input type="submit" value="确定" class="btn-common sfcreport">
                    <input type="button" value="取消" class="btn-common" id="branchCancel">
                </div>
            </form>
        </div>
    </div>
</div>
<%--分支机构情况--%>
<div class="mod subcapital">
    <div class="mod-hd">
        <div class="title">
            <h3>分支机构情况</h3>
            <div class="btn-box">
                <a class="btn-common btn-add sfcreportbutton" id="js-branch-add">新增</a>
            </div>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content">
            <div class="subcapital-tips">
                <label><input type="checkbox" id="checkBranchAll" >全选</label>
                默认读取分支机构信息<c:if test="${yrRegCheck.reportState == '00' || yrRegCheck.reportState == '13' || yrRegCheck.reportState == '20'}">，请根据企业当前实际情况进行<strong class="light">添加/修改</strong></c:if>
                <div class="fr edit">
                    <a href="javascript:void(0);" id="js-branch-edit" class="sfcreportbutton">修改</a>
                    <a href="javascript:void(0);" id="js-branch-delete" class="sfcreportbutton" >删除</a>
                </div>

            </div>
            <div class="content-sm-height">
                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th width="90" class="bg">序号</th>
                        <th class="bg">分支机构统一社会信用码/注册号</th>
                        <th class="bg">分支机构名称</th>
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
<c:if test="${yrRegCheck.year > 2015}">
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
                                <th width="210">
                                    <i class="icon-question" id="nzzbrs" data-id="nzzbrs" data-msg="指报告期末参加社会保险的职工人数（不含离退休人数）。即企业上年度年末参保人数，非平均人数。"></i>
                                    参保人数
                                </th>
                                <th width="210">
                                    <i class="icon-question" id="nzdwjfjs" data-id="nzdwjfjs" data-msg="指报告期内单位缴纳社会保险费的工资总额，按缴费人员的应缴口径计算。即企业上年度全年1至12月每月工资总额累计数。"></i>
                                    单位缴费基数
                                </th>
                                <th width="210">
                                    <i class="icon-question" id="nzbqsjjfje" data-id="nzbqsjjfje" data-msg="指报告期内单位实际缴纳的社会保险费，不包括补缴欠费和跨年度（或跨季度）的预缴金额。即企业上年度全年1至12月每月实际缴纳社会保险费累计数，不含个人缴纳部分。"></i>
                                    本期实际缴费金额</th>
                                <th>
                                    <i class="icon-question" id="nzdwljqjje" data-id="nzdwljqjje" data-msg="指截至报告期末单位累计欠缴各项社会保险费金额（本金）。"></i>
                                    单位累计欠缴金额</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>城镇职工基本养老保险</td>
                                <td class="focus-state">
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="endowmentNum" id="endowmentNum" value="${yrSfcSocialSecurity.endowmentNum}" class="ipt-txt sfcreport" placeholder="请输入整数">
                                        <i class="icon-close"></i>
                                    </div>
                                    人
                                </td>
                                <td class="focus-state">
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="paymentEndowment"  value="${yrSfcSocialSecurity.paymentEndowment}" class="ipt-txt one sfcreport" placeholder="请输入金额">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="light">万元</span>
                                </td>
                                <td class="focus-state">
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="actualPayEndowment" value="${yrSfcSocialSecurity.actualPayEndowment}" class="ipt-txt two sfcreport" placeholder="请输入金额">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="light">万元</span>
                                </td>
                                <td class="focus-state">
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="cumuEndowment" value="${yrSfcSocialSecurity.cumuEndowment}" class="ipt-txt three sfcreport" placeholder="请输入金额">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="light">万元</span>
                                </td>
                            </tr>
                            <tr>
                                <td>失业保险</td>
                                <td class="focus-state">
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="unemploymentNum" id="unemploymentNum" value="${yrSfcSocialSecurity.unemploymentNum}" class="ipt-txt sfcreport" placeholder="请输入整数">
                                        <i class="icon-close"></i>
                                    </div>
                                    人
                                </td>
                                <td class="focus-state">
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="paymentUnemployment" value="${yrSfcSocialSecurity.paymentUnemployment}" class="ipt-txt one sfcreport" placeholder="请输入金额">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="light">万元</span>
                                </td>
                                <td class="focus-state">
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="actualPayUnemployment" value="${yrSfcSocialSecurity.actualPayUnemployment}" class="ipt-txt two sfcreport" placeholder="请输入金额">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="light">万元</span>
                                </td>
                                <td class="focus-state">
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="cumuUnemployment" value="${yrSfcSocialSecurity.cumuUnemployment}" class="ipt-txt three sfcreport" placeholder="请输入金额">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="light">万元</span>
                                </td>
                            </tr>
                            <tr>
                                <td>职工基本医疗保险</td>
                                <td class="focus-state">
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="medicalNum" id="medicalNum" value="${yrSfcSocialSecurity.medicalNum}" class="ipt-txt sfcreport" placeholder="请输入整数">
                                        <i class="icon-close"></i>
                                    </div>
                                    人
                                </td>
                                <td class="focus-state">
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="paymentMedical" value="${yrSfcSocialSecurity.paymentMedical}" class="ipt-txt one sfcreport" placeholder="请输入金额">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="light">万元</span>
                                </td>
                                <td class="focus-state">
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="actualPayMedical" value="${yrSfcSocialSecurity.actualPayMedical}" class="ipt-txt two sfcreport" placeholder="请输入金额">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="light">万元</span>
                                </td>
                                <td class="focus-state">
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="cumuMedical" value="${yrSfcSocialSecurity.cumuMedical}" class="ipt-txt three sfcreport" placeholder="请输入金额">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="light">万元</span>
                                </td>
                            </tr>
                            <tr>
                                <td>工伤保险</td>
                                <td class="focus-state">
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="empInjuryNum" id="empInjuryNum" value="${yrSfcSocialSecurity.empInjuryNum}" class="ipt-txt sfcreport" placeholder="请输入整数">
                                        <i class="icon-close"></i>
                                    </div>
                                    人
                                </td>
                                <td class="focus-state">
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="paymentEmpInjury" value="${yrSfcSocialSecurity.paymentEmpInjury}" class="ipt-txt one sfcreport" placeholder="请输入金额">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="light">万元</span>
                                </td>
                                <td class="focus-state">
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="actualPayEmpInjury" value="${yrSfcSocialSecurity.actualPayEmpInjury}" class="ipt-txt two sfcreport" placeholder="请输入金额">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="light">万元</span>
                                </td>
                                <td class="focus-state">
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="cumuEmpInjury" value="${yrSfcSocialSecurity.cumuEmpInjury}" class="ipt-txt three sfcreport" placeholder="请输入金额">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="light">万元</span>
                                </td>
                            </tr>
                            <tr>
                                <td>生育保险</td>
                                <td class="focus-state">
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="maternityNum" id="maternityNum" value="${yrSfcSocialSecurity.maternityNum}" class="ipt-txt sfcreport" placeholder="请输入整数">
                                        <i class="icon-close"></i>
                                    </div>
                                    人
                                </td>
                                <td class="focus-state">
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="paymentMaternity" value="${yrSfcSocialSecurity.paymentMaternity}" class="ipt-txt one sfcreport" placeholder="请输入金额">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="light">万元</span>
                                </td>
                                <td class="focus-state">
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="actualPayMaternity" value="${yrSfcSocialSecurity.actualPayMaternity}" class="ipt-txt two sfcreport" placeholder="请输入金额">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="light">万元</span>
                                </td>
                                <td class="focus-state">
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="cumuMaternity" value="${yrSfcSocialSecurity.cumuMaternity}" class="ipt-txt three sfcreport" placeholder="请输入金额">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="light">万元</span>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <!--                         <td> -->
                                <!--                             <div class="ipt-box js-ipt-box"> -->
                                    <%--                                 <input type="text" readonly="readonly" id="paymentBase" name="paymentBase" value="${yrSfcSocialSecurity.paymentBase}" class="ipt-txt" placeholder="请输入金额"> --%>
                                <!--                             </div> -->
                                <!--                             <span class="light">万元</span> -->
                                <!--                         </td> -->
                                <td>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" readonly="readonly" id="actualPayment" name="actualPayment" value="${yrSfcSocialSecurity.actualPayment}" class="ipt-txt" placeholder="请输入金额">
                                    </div>
                                    <span class="light">万元</span>
                                </td>
                                <td>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" readonly="readonly" id="cumulArrears"  name="cumulArrears" value="${yrSfcSocialSecurity.cumulArrears}" class="ipt-txt" placeholder="请输入金额">
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
<c:if test="${yrRegCheck.reportState == '00' || yrRegCheck.reportState == '13' || yrRegCheck.reportState == '20'}">
    <div class="mod save-box">
        <button class="btn-common btn-save sfcreport" id="save">暂存</button>
        <button class="btn-common btn-save sfcreport" id="view">预览并提交</button>
    </div>
</c:if>

<%--传递至js的参数： start--%>
<input type="hidden" id="params_area_address" value="${yrSfcBaseinfo.areaAddress}" ><%--330104000000--%>
<input type="hidden" id="params_stree_address" value="${yrSfcBaseinfo.streeAddress}"><%--330104005000--%>
<input type="hidden" id="params_area_addresscopy" value="${yrSfcBaseinfo.areaAddressCopy}"><%--330104000000--%>
<input type="hidden" id="params_stree_addresscopy" value="${yrSfcBaseinfo.streeAddressCopy}"><%--330104005000--%>
<%--传递至js的参数： end--%>

<jsp:include page="../../common/footer.jsp"></jsp:include>

<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/component/dropDown.js"/>"></script>
<script src="<c:url value="/js/lib/placeholder/jquery.placeholder.min.js"/>"></script>
<script src="<c:url value="/js/lib/jquery/jquery.icinfo.js"/>"></script>
<script>
    $('input, textarea').placeholder(); //ie8支持placeholder
    $('.js-ipt-box').expandInput();
</script>
<script>
    $('.js-write-tips').on('click', function () {
        var that = this;
        layer.tips($('.js-tip-cont').html(), that, {tips: 3, time: -1, closeBtn: 1, area: '500px'})
    })
</script>


<!--网站网店 列表模板-->
<script id="table-template-web" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{descText webType}}</td>
        <td>{{webSitName}}</td>
        <td>{{webSite}}</td>
        <td>
            <a href="javascript:void(0)" class="_show" data-webid="{{webID}}" >详情</a>
            <a href="javascript:void(0)" class="_delete" data-webid="{{webID}}"  data-pripid="{{priPID}}">删除</a>
        </td>
    </tr>
    {{/each}}
</script>





<script id="table-template-one" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td><input type="checkbox" name="licencechose" value="{{licID}}">{{xh @index}}</td>
        <td>{{licNameCN}}</td>
        <td>{{valto valTo}}</td>
    </tr>
    {{/each}}
</script>

<script id="table-template-three" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td><input type="checkbox" name="branchchose" value="{{brID}}">{{addOne @index}}</td>
        <td>{{uniCode}}</td>
        <td>{{brName}}</td>
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
        _memNum:'${yrSfcBaseinfo.memNum}' , //保存过后的农专社此项数据不为空
        _reportState:'${yrRegCheck.reportState}',//年报状态
        mod_url: '<c:url value="/reg/client/yr/modapplication/sfc/show"/>'
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/client/yr/sfcyr/sfcreport_edit.js"></script>
</body>
</html>