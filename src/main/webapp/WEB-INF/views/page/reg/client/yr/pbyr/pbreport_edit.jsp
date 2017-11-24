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
    <title>个体户年报报送页面</title>
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
      <%--  <p class="warn-txt">敬请下载安装<span>“联连”企业信用信息警示软件</span>，第一时间获取企业信用警示提示。避免消息滞后，延误处理，影响贵企业的信用状况</p>--%>
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
                <strong class="<c:if test="${yrRegCheck.reportState == '12' || yrRegCheck.reportState == '13'}">light</c:if> mr-20">${yrRegCheck.reportStateClientDesc}</strong>
            </span>
            <span><label>历次年报公示记录：</label><a href="<c:url value="/reg/client/yr/pb/yrprint/readPbReportPage"/>?year=${encodeYear}"   target="_blank">查看</a></span>
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
             <a  href="<c:url value="/reg/client/yr/pb/yrprint/showPbReportProve"/>?year=${encodeYear}&printFalg=1"   target="_blank">查看与打印年度报告</a>
             <a  id="printpbreport"  href="#">打印年度报告证明</a>
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
    <input type="hidden" name="anCheID" value="${yrPbBaseInfo.anCheID}">
    <input type="hidden" name="priPID"  value="${yrPbBaseInfo.priPID}"/>
    <input type="hidden" name="year"    value="${yrPbBaseInfo.year}"/>
</form>


<%--基本信息--%>
<form class="form-horizontal error-bottom" id="form">
  <input type="hidden" name="anCheID" id = "anCheID" value="${yrPbBaseInfo.anCheID}"/>
  <input type="hidden" name="priPID" id ="priPID" value="${yrPbBaseInfo.priPID}"/>
  <input type="hidden" name="year" id ="year" value="${yrPbBaseInfo.year}"/>
  <input type="hidden" name="regNO" value="${yrPbBaseInfo.regNO}"/>
  <input type="hidden" name="uniCode" value="${yrPbBaseInfo.uniCode}"/>
  <input type="hidden" id="encodeYear" value="${encodeYear}"/>
  <input type="hidden" id ="websiteFlag" name="websiteFlag" value="${yrPbBaseInfo.websiteFlag}"/>
<div class="mod pbreport-basic">
    <div class="mod-hd">
        <div class="title">
            <h3>基本信息</h3>
            <p>以下内容请按照当前个体工商户最新的情况进行填写</p>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
            <table class="table-public table-contact pbReport table-selected" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td class="odd" colspan="2">
                        <div class="item-name bg">名称字号</div>
                        <div class="ipt-box">
                            <input type="text" name="traName" value="${yrPbBaseInfo.traName}" class="ipt-txt w725 pbReport" readonly>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="item-name bg">统一社会信用代码/注册号</div>
                        <div class="ipt-box">
                            <input type="text" class="ipt-txt ipt-txt-lg pbReport" value="${empty yrPbBaseInfo.uniCode ? yrPbBaseInfo.regNO : yrPbBaseInfo.uniCode}" readonly>
                        </div>
                    </td>
                    <td class="odd">
                        <div class="item-name bg">经营者姓名</div>
                        <div class="ipt-box">
                            <input type="text" class="ipt-txt ipt-txt-lg pbReport" name="name" value="${yrPbBaseInfo.name}" readonly>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name bg"><strong class="light">* </strong>对外公开联系电话</div>
                        <select name="" id="isComphone" class="select-txt select-txt-sm pbReport" >
                            <option value="1" <c:if test="${!empty yrPbBaseInfo.tel}">selected</c:if> >有</option>
                            <option value="0" <c:if test="${empty yrPbBaseInfo.tel}">selected</c:if> >无</option>
                        </select>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="tel" id="_tel" value="${yrPbBaseInfo.tel}" class="ipt-txt w184 pbReport">
                            <c:if test="${!empty yrPbBaseInfo.tel}"><i class="icon-close" id="comPhoneClose"></i></c:if>
                        </div>
                    </td>
                    <td class="odd focus-state">
                        <div class="item-name"><strong class="light">* </strong>联系手机号码</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="comPhone" value="${yrPbBaseInfo.comPhone}" class="ipt-txt ipt-txt-lg pbReport">
                            <i class="icon-close"></i>
                        </div>
                    </td>
                </tr>



                <tr>
                    <td class="odd focus-state" colspan="2">
                        <div class="item-name special ">
                            <strong class="light">* </strong>经营场所
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
                                <input type="text" id="" class="ipt-txt" name="opLoc" value="${sessionScope.midBaseInfoDto.dom}" placeholder="" readonly >
                            </div>
                        </div>
                    </td>
                </tr>



                <%--实际经营场所 start--%>
                <tr>
                    <td class="odd focus-state" colspan="2">
                        <div class="item-name special ">
                            <strong class="light">* </strong>实际经营场所
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
                                    <input type="text" id="desc_address" class="ipt-txt" name="desAddress" value="${yrPbBaseInfo.desAddress}" placeholder="" style="width: 226px;">
                                    <i class="icon-close" id="icon-close-delete"></i>
                                </div>
                            </div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="info_address" class="ipt-txt" name="addr" value="${yrPbBaseInfo.addr}" placeholder="" readonly >
                            </div>
                        </div>
                    </td>
                </tr>
                <%--实际经营场所 end--%>


                <tr>
                    <td class="odd focus-state">
                        <div class="item-name bg"><strong class="light">* </strong>累积已投入经营资金</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="fundAm" id="fundAm" value="${yrPbBaseInfo.fundAm}" class="ipt-txt ipt-txt-lg units pbReport" placeholder="请输入金额">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                    <td class="odd focus-state">
                        <div class="item-name bg"><strong class="light">* </strong>其中，${yrRegCheck.year}年投入经营资金</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="pbFundAm" id="pbFundAm" value="${yrPbBaseInfo.pbFundAm}" class="ipt-txt ipt-txt-lg units pbReport" placeholder="请输入金额">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state" colspan="2">
                        <div class="item-name bg"><strong class="light">* </strong>${yrRegCheck.year}年末,从业人数（含雇工）</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="empNum" id= "empNum" value="${yrPbBaseInfo.empNum}" class="ipt-txt ipt-txt-lg pbReport" placeholder="填写大于1的整数">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">人</strong>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state" colspan="2">
                        <div class="item-name">其中，经营者属于</div>
                        <div class="radio-box pbReport">
                            <label><input type="radio" name="isLegRep" value="1" <c:if test="${yrPbBaseInfo.isLegRep == '1'}">checked</c:if> class="conForm">高校毕业生</label>
                            <label><input type="radio" name="isLegRep" value="2" <c:if test="${yrPbBaseInfo.isLegRep == '2'}">checked</c:if> class="conForm">退役士兵</label>
                            <label><input type="radio" name="isLegRep" value="3" <c:if test="${yrPbBaseInfo.isLegRep == '3'}">checked</c:if> class="conForm">残疾人</label>
                            <label><input type="radio" name="isLegRep" value="4" <c:if test="${yrPbBaseInfo.isLegRep == '4'}">checked</c:if> class="conForm">失业人员再就业</label>
                            <label><input type="radio" name="isLegRep" value="5" <c:if test="${yrPbBaseInfo.isLegRep == '5'}">checked</c:if> class="conForm">都不是</label>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state" colspan="2">
                        <div class="item-name">其中，雇工人员中属于</div>
                        高校毕业生
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="uniGradEmps" id="uniGradEmps" value="${yrPbBaseInfo.uniGradEmps}" class="ipt-txt ipt-txt-sm pbReport" placeholder="">
                            <i class="icon-close"></i>
                        </div>
                        退役士兵
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="exSoldEmps" id="exSoldEmps" value="${yrPbBaseInfo.exSoldEmps}" class="ipt-txt ipt-txt-sm pbReport" placeholder="" >
                            <i class="icon-close"></i>
                        </div>
                        残疾人
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="disEmps" id="disEmps" value="${yrPbBaseInfo.disEmps}" class="ipt-txt ipt-txt-sm pbReport" placeholder="" >
                            <i class="icon-close"></i>
                        </div>
                        失业人员再就业
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="unemEmps" id="unemEmps" value="${yrPbBaseInfo.unemEmps}" class="ipt-txt ipt-txt-sm pbReport" placeholder="" >
                            <i class="icon-close"></i>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%--经营信息--%>
<div class="mod contact">
    <div class="mod-hd">
        <div class="title">
            <h3>经营信息</h3>
            <p>以下内容请按照${yrRegCheck.year}年1月1日-12月31日期间的信息进行填写</p>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
            <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name bg js-ipt-box"><strong class="light">* </strong>营业额或营业收入</div>
                        <div class="ipt-box">
                            <input type="text" name="vendInc" value="${yrPbBaseInfo.vendInc}" id="vendInc" class="ipt-txt ipt-txt-lg units pbReport" placeholder="请输入金额">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                    <td class="odd focus-state">
                        <div class="item-name"><strong class="light">* </strong>本条信息是否向社会公开</div>
                        <div class="radio-box">
                            <label><input type="radio" name="vendIncIsPub" value="1" <c:if test="${yrPbBaseInfo.vendIncIsPub == '1'}">checked</c:if> >是</label>
                            <label><input type="radio" name="vendIncIsPub" value="0" <c:if test="${yrPbBaseInfo.vendIncIsPub == '0'}">checked</c:if> >否</label>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state" colspan="2">
                        <div class="item-name"><strong class="light">* </strong>属于免征纳税对象</div>
                        <div class="radio-box">
                            <label><input type="radio" name="rreeTaxIs" id="rreeTaxYes" value="1" <c:if test="${yrPbBaseInfo.rreeTaxIs == '1'}">checked</c:if> >是</label>
                            <label><input type="radio" name="rreeTaxIs" id="rreeTaxNo" value="0" <c:if test="${yrPbBaseInfo.rreeTaxIs == '0'}">checked</c:if> >否</label>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name bg"><strong class="light">* </strong>纳税总额</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="ratGro" id="ratGro"  value="${yrPbBaseInfo.ratGro}" class="ipt-txt ipt-txt-lg units pbReport" placeholder="请输入金额">
                            <i class="icon-close viewicon"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
                    <td class="odd focus-state">
                        <div class="item-name"><strong class="light">* </strong>本条信息是否向社会公开</div>
                        <div class="radio-box pbReport">
                            <label><input type="radio" name="ratGroIsPub" value="1" <c:if test="${yrPbBaseInfo.ratGroIsPub == '1'}">checked</c:if> >是</label>
                            <label><input type="radio" name="ratGroIsPub" value="0" <c:if test="${yrPbBaseInfo.ratGroIsPub == '0'}">checked</c:if> >否</label>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- 网站网店 start -->
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
                                <label><input type="radio" id="js-yes" name="websiteFlag" value="1"  <c:if test="${yrPbBaseInfo.websiteFlag == '1'}">checked</c:if>/>是</label>
                                <label><input type="radio" id="js-no" name="websiteFlag" value="0" <c:if test="${yrPbBaseInfo.websiteFlag == '0'}">checked</c:if>/>否</label>
                            </div>

                            <c:if test="${yrRegCheck.reportState == '00' || yrRegCheck.reportState == '13' || yrRegCheck.reportState == '20'}">
                                <div class="radio-box" id="js-checkbox" style="display: ${yrPbBaseInfo.websiteFlag == '1'?'inline-block':'none'};font-size: 14px;">
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
                <tbody id="_websit" dataSize="${fn:length(yrPbWebsiteInfoList)}">
                <c:forEach var="list" items="${yrPbWebsiteInfoList}">
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
                                <a href="javascript:void(0)" class="_delete" data-webid="${list.webID}" data-ancheid="${list.anCheID}">删除</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>



<!-- 网站网店 end -->

<%--共产党员党建情况--%>
<div class="mod contact">
    <div class="mod-hd">
        <div class="title">
            <h3>共产党员党建情况</h3>
            <p>以下内容请按照当前你个体工商户最新的情况进行填写</p>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
            <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name w240"><strong class="light">*</strong>从业人员中，有中共党员（含预备党员）</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="numParM" name ="numParM" value="${yrPbBaseInfo.numParM}" class="ipt-txt pbReport" placeholder="" >
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">人</strong>
                    </td>
                    <td class="odd">
                        <div class="item-name w240"><strong class="light">*</strong>已独立或联合建立党支部</div>
                        <div class="radio-box">
                            <label><input type="radio" name="partOrgIs" value="1" <c:if test="${yrPbBaseInfo.partOrgIs == '1'}">checked</c:if> >是</label>
                            <label><input type="radio" name="partOrgIs" value="0" <c:if test="${yrPbBaseInfo.partOrgIs == '0'}">checked</c:if> >否</label>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name w240"><strong class="light">*</strong>经营者本人为党员</div>
                        <div class="radio-box">
                            <label><input type="radio" name="resParMSign" id="resParMSignYes" value="1" <c:if test="${yrPbBaseInfo.resParMSign == '1'}">checked</c:if>>是</label>
                            <label><input type="radio" name="resParMSign" id="resParMSignNO" value="2" <c:if test="${yrPbBaseInfo.resParMSign == '2'}">checked</c:if> >否</label>
                        </div>
                    </td>
                    <td class="odd">
                        <div class="item-name w240"><strong class="light">*</strong>经营者本人为党组织书记</div>
                        <div class="radio-box">
                            <label><input type="radio" name="resParSecSign" value="1" class ="resParSecSign" <c:if test="${yrPbBaseInfo.resParSecSign == '1'}">checked</c:if> >是</label>
                            <label><input type="radio" name="resParSecSign" value="2" class = "resParSecSign" <c:if test="${yrPbBaseInfo.resParSecSign == '2'}">checked</c:if> >否</label>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</form>


<%--添加取得许可证情况 block--%>
<div class="mod mod-border investment-info js-content-show" id= "mod_licence" style="display: none;">
    <div class="mod-hd">
        <div class="title">
            <h3>添加取得许可证情况</h3>
            <p>以下内容请按照当前你个体工商户经营范围中涉及的前置或后置许可证进行填写</p>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content">
            <form class="form-horizontal error-bottom" id="licenceForm">
              <input type="hidden" name="licName" id ="licName" class="lichidden" value="${yrPbLicenceInfo.licName}" ><!-- 许可证code -->
              <input type="hidden" name="anCheID" id="anCheID" class="anCheID" value="${yrPbBaseInfo.anCheID}" ><!-- 年报id -->
              <input type="hidden" name="licID" id="licID" class="lichidden" value="${yrPbLicenceInfo.licID}"><!-- 许可证id -->
                <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name">行政许可名称</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="licNameCN" id ="licNameCN" class="ipt-txt ipt-txt-lg sfcreport" placeholder="选择经营范围内涉及的许可" >
                                <i class="icon-close"></i>
                            </div>
                            <strong class="light pointer" id="licenceList">许可证列表</strong>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name">有效期至</div>
                            <div class="ipt-box">
                                <input type="text" readonly name="valTo" id="valTo" class="ipt-txt laydate-icon ipt-txt-lg pbReport" placeholder="选择许可证有效期截止日期" 
                                       onclick="laydate({istime:true})">
                            </div>
                            <strong class="light"><label><input type="checkbox" name="longTime"  id="longTime"/>无有效期或长期有效</label></strong>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <div class="btn-box">
                    <input type="submit" value="确定" class="btn-common pbReport">
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
                <a class="btn-common btn-add pbReportbutton" id="js-add">新增</a>
            </div>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content">
            <div class="subcapital-tips">
                <label><input type="checkbox" id="checkLicAll">全选</label>
                默认读取许可证信息<c:if test="${yrRegCheck.reportState == '00' || yrRegCheck.reportState == '13' || yrRegCheck.reportState == '20'}">，请根据企业当前实际情况进行<strong class="light ">添加/修改</strong></c:if>
                <div class="fr edit">
                    <a id="js-edit" href="javascript:void(0);" class="pbReportbutton">修改</a>
                    <a id="js-delete" href="javascript:void(0);" class="pbReportbutton">删除</a>
                </div>
            </div>
            <div style="overflow-y: auto;min-height: 30px">
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

<c:if test="${yrRegCheck.reportState == '00' || yrRegCheck.reportState == '13' || yrRegCheck.reportState == '20'}">
<div class="mod save-box">
    <button class="btn-common btn-save" id="save">暂存</button>
    <button class="btn-common btn-save" id="view">预览并提交</button>
</div>
</c:if>

<%--传递至js的参数： start--%>
<input type="hidden" id="params_area_address" value="${yrPbBaseInfo.areaAddress}" >
<input type="hidden" id="params_stree_address" value="${yrPbBaseInfo.streeAddress}">

<input type="hidden" id="params_area_addresscopy" value="${yrPbBaseInfo.areaAddressCopy}">
<input type="hidden" id="params_stree_addresscopy" value="${yrPbBaseInfo.streeAddressCopy}">
<%--传递至js的参数： end--%>

<jsp:include page="../../common/footer.jsp"></jsp:include>
<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/component/dropDown.js"/>"></script>

<!-- 行政许可 start  -->
<script id="table-template-one" type="text/x-handlebars-template">
{{#each data}}  
             <tr>
                    <td><input type="checkbox" name="licencechose" value="{{licID}}">{{xh @index}}</td>
                    <td>{{licNameCN}}</td>
                    <td>{{valto valTo}}</td>
             </tr> 
{{/each}} 
</script>
<!-- 行政许可 end  -->

<!-- 网站网店 模板 start -->
<script id="table-template-web" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{descText webType}}</td>
        <td>{{webSitName}}</td>
        <td>{{webSite}}</td>
        <td>
            <a href="javascript:void(0)" class="_show" data-webid="{{webID}}" >详情</a>
            <a href="javascript:void(0)" class="_delete" data-webid="{{webID}}"  data-ancheid="{{anCheID}}">删除</a>
        </td>
    </tr>
    {{/each}}
</script>
<!-- 网站网店 模板 end -->


<!-- 网站点击 -->
<script>
    $('.js-write-tips').on('click', function () {
        var that = this;
        layer.tips($('.js-tip-cont').html(), that, {tips: 3, time: -1, closeBtn: 1,area:'500px'})
    })
</script>
<script>
    window._CONFIG = {
        _empNum:'${yrPbBaseInfo.empNum}' , //获取从业人数  判断是否保存过
        _year:'${year}' ,//年度
        _pripid:'${pripid}', //主体代码 
        _reportState:'${yrRegCheck.reportState}',
        mod_url: '<c:url value="/reg/client/yr/modapplication/pb/show"/>',
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/client/yr/pbyr/pbreport_edit.js"></script>
</body>
</html>