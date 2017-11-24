<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/26
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="hx" uri="/WEB-INF/tld/hx.tld"%>
<c:set var="midBaseInfoDto" value="${sessionScope.midBaseInfoDto}"/>
<c:set var="yearReportFlag" value="${sessionScope.yearReportFlag}"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>
<jsp:include page="common/header.jsp"></jsp:include>
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
            <c:if test="${!empty midBaseInfoDto.regCap }">
                <em>注册资本：<fmt:formatNumber type="number"  value=" ${midBaseInfoDto.regCap }"  pattern="0.00" maxFractionDigits="2"/>万${midBaseInfoDto.currencyCn}</em>
            </c:if>
        </p>
    </div>
</div>

<%--数字证书登录 联络员变更 start--%>
<c:if test="${empty liaisonLogin}">
    <div class="mod mod-border investment-info mt10 js-content-show " id="js-change-UI" >
        <div class="mod-">
            <div class="title">
                <h3>工商联络员信息</h3>
                <p class="light">请及时更新联络员信息，确保工商部门有效联系你企业相关事项。</p>
            </div>
        </div>
        <div class="mod-bd">
            <div class="content liaison-layer">
                <form class="form-horizontal error-bottom" id="FormOne" >
                        <%--注册号--%>
                    <input type="hidden" id="regno"   name="regno"  value="${liaison.regno}" >
                        <%--统一社会信用代码--%>
                    <input type="hidden" id="unicode" name="unicode" value="${liaison.unicode}" >
                    <input type="hidden"    name="uid"  value="${liaison.uid}" >

                        <%--主体身份代码--%>
                    <input type="hidden" id="pripid"  name="pripid"  value="${liaison.pripid}" >

                    <table class="table-public table-align-l  mb20" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <tr>
                            <td class="odd focus-state">
                                <div class="item-name w180"><span class="light">*</span>法定代表人（负责人）姓名</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="lerep1" name="lerep" value="${liaison.lerep}" class="ipt-txt" placeholder="" ${fn:indexOf('27,33',midBaseInfoDto.entTypeCatg) != -1?'':'readonly'}><%--判是否是合伙人(27,33)  是 可以编辑  不是不可编辑 --%>
                                    <c:if test="${fn:indexOf('27,33',midBaseInfoDto.entTypeCatg) != -1}"><i class="icon-close"></i> </c:if>
                                </div>
                            </td>
                            <td class="even focus-state">
                                <div class="item-name w180"><span class="light">*</span>法定代表人（负责人）手机号码</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="lerepphone1" name="lerepphone" value="${liaison.lerepphone}" class="ipt-txt" placeholder="">
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="odd focus-state">
                                <div class="item-name w180"><span class="light">*</span>联络员姓名</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="lianame1" name="lianame" value="${liaison.lianame}" class="ipt-txt" placeholder="">
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                            <td class="even focus-state">
                                <div class="item-name w180"><span class="light">*</span>联络员证件类型</div>
                                <div class="ipt-box">
                                    <select id="_select1" name="liaidtype" class="ipt-txt">
                                        <option value="">--请选择--</option>
                                        <c:forEach var="list" items="${codeCertypeList}" >
                                            <option value="${list.code}" ${liaison.liaidtype==list.code?'selected':''}>${list.content}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="odd focus-state">
                                <div class="item-name w180"><span class="light">*</span>联络员手机号码</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="tel1" name="tel" value="${liaison.tel}" class="ipt-txt" placeholder="">
                                    <i class="icon-close"></i>
                                </div>
                                <input type="button" value="获取验证码" class="btn-common btn-h30 js-Code-one" data-code="js-Code-one">
                            </td>
                            <td class="even focus-state">
                                <div class="item-name w180"><span class="light">*</span>联络员证件号码</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="liaidnum" value="${liaison.liaidnum}" class="ipt-txt" placeholder="">
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="odd focus-state">
                                <div class="item-name w180">验证码</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="js-password-one" name="password" value="" class="ipt-txt" placeholder="">
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <div class="tips"><span class="light">如无法获取验证码！</span>请尝试重新获取验证码或凭企业工商联络员手机号码拨打客服热线400-888-4636查询验证码。</div>
                    <div class="btn-box">
                        <input type="submit" value="确定" class="btn-common js-change-save">
                        <input type="button" value="取消" class="btn-common js-change-cancel" >
                    </div>
                </form>
            </div>
        </div>
    </div>
</c:if>
<%--数字证书登录 联络员变更 end --%>

<%--联络员详情或变更 start--%>
<c:if test="${!empty liaisonLogin}">
    <div class="mod mod-border investment-info mt10 js-content-show " id="js-change-UI" >
        <div class="mod-">
            <div class="title">
                <h3>工商联络员信息</h3>
                <p class="light">请及时更新联络员信息，确保工商部门有效联系你企业相关事项。</p>
            </div>
        </div>
        <div class="mod-bd">
            <div class="content liaison-layer">
                <form class="form-horizontal error-bottom" id="Form_lianson_one"  >
                    <table class="table-public table-align-l  mb20" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <input type="hidden"    name="uid"  value="${liaison.uid}" >
                        <input type="hidden"  name="pripid"  value="${liaison.pripid}" >
                        <input type="hidden"  name="regno"   value="${liaison.regno}" >
                        <input type="hidden"  name="unicode" value="${liaison.unicode}" >
                        <tr>
                            <td class="odd focus-state">
                                <div class="item-name w180">法定代表人（负责人）姓名</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="liaison_lerep_one" name="lerep" value="${liaison.lerep}" class="ipt-txt" placeholder="" readonly>
                                    <c:if test="${fn:indexOf('27,33',midBaseInfoDto.entTypeCatg) != -1}">
                                        <input type="hidden" id="commCopany" value="2733">
                                    </c:if>
                                </div>
                            </td>
                            <td class="even focus-state">
                                <div class="item-name w180">法定代表人（负责人）手机号码</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text"  id="liaison_lerepphone_one" name="lerepphone"  value="${liaison.lerepphone}" class="ipt-txt" placeholder="" readonly>
                                </div>
                                <input type="button"  value="修改" class="modify_liaison_phone"  style="border: 1px solid #3b75b2;background: #4786c8;color: #fff;width: 46px;height: 24px;line-height: 24px;border-radius: 2px;">
                            </td>
                        </tr>
                        <tr>
                            <td class="odd focus-state">
                                <div class="item-name w180">联络员姓名</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="liaison_lianame_one"  value="${liaison.lianame}" class="ipt-txt" placeholder="" readonly>
                                </div>
                            </td>
                            <td class="even focus-state">
                                <div class="item-name w180">联络员证件类型</div>
                                <div class="ipt-box">
                                    <c:forEach var="list" items="${codeCertypeList}" >
                                        <c:if test="${liaison.liaidtype==list.code}">
                                            <input type="text"  value="${list.content}" class="ipt-txt" placeholder="" readonly>
                                        </c:if>
                                    </c:forEach>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="odd focus-state">
                                <div class="item-name w180">联络员手机号码</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="liaison_tel_one"  value="${liaison.tel}" class="ipt-txt" placeholder="" readonly>

                                </div>
                            </td>
                            <td class="even focus-state">
                                <div class="item-name w180">联络员证件号码</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text"  value="${liaison.liaidnum}" class="ipt-txt" placeholder="" readonly>

                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <div class="btn-box">
                        <input type="submit" value="确定" class="btn-common js-content-show js-liaisonChange-save"  >
                        <input type="button" value="收起" class="btn-common js-change-cancel" >
                    </div>
                </form>
            </div>
        </div>
    </div>
</c:if>
<%--联络员详情 或变更 end --%>

<div class="mod subcapital mt10">
    <div class="mod-hd">
        <div class="title">
            <h3>工商联络员信息</h3>
            <p class="light">工商联络员信息有变化时请及时更新！真实有效的联络员信息有助于工商部门及时联系你企业。</p>
          <%--  <c:if test="${empty liaisonLogin}">
                <p class="light">工商联络员信息有变化时请及时更新！真实有效的联络员信息有助于工商部门及时联系你企业。</p>
            </c:if>--%>
            <div class="btn-box">
                <c:if test="${empty liaisonLogin}">
                    <a class="btn-common btn-add js-change ">变更</a>
                </c:if>
                <c:if test="${!empty liaisonLogin}">
                    <a class="btn-common btn-add js-change ">变更</a>
                </c:if>

            </div>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content">
            <table class="table-public table-liaison" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="50%">
                        <div class="item-name">法定代表人（负责人）：</div>
                        <span id="liaison_lerep">${liaison.lerep}</span>
                                <span class="ml20">
                                     <span id="liaison_lerepphone">${liaison.lerepphone}</span>
                                </span>
                    </td>
                    <td>
                        <div class="item-name">工商联络员：</div>
                        <span id="liaison_lianame">${liaison.lianame}</span>
                                <span class="ml20">
                                     <span id="liaison_tel">${liaison.tel}</span>
                                </span>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>


<%-- 首页tab切换主体开始 --%>
<div class="mod index-cont mt10">
    <div class="client-index-tab" data-component="tab">


        <div class="tab-header">
            <ul class="clearfix">
                <li class="tab-selected"><a href="javascript:void(0);" class="tab-item"><i class="tab-icon tab-icon0"></i>年度报告填报</a></li>
                <c:if test="${!empty imReportTypeList}">
                <li><a href="javascript:void(0);" class="tab-item"><i class="tab-icon tab-icon1"></i>其他自行公示信息填报</a></li>
                </c:if>
                <li><a href="javascript:void(0);" class="tab-item tab-apply"><i class="tab-icon tab-icon2"></i>简易注销公告填报</a></li>
                <li><a href="javascript:void(0);" class="tab-item"><i class="tab-icon tab-icon3"></i>公示信息异议申请</a></li>
                <li><a href="javascript:void(0);" class="tab-item tab-wenshu"><i class="tab-icon tab-icon4"></i>公务文书回执【<strong class="light" id="wenshu_total">0</strong>】</a></li>
            </ul>
        </div>
		 
		<!-- 数字证书登录 -->
		<c:if test="${loginType==5}">
	        <div class="title"> 
	         	  <a href="http://zj.gsxt.gov.cn/client/entsearch/toEntSearch"   target="_blank" > <h3 style="color: black;">企业公示信息查询</h3></a> 
	        </div> 
		</c:if>
        <div class="tab-content mb20 mt10">
            <div class="tab-panel tab-panel-show">
                <c:if test="${yearReportFlag == true}">
                    <div class="title">
                        <h3>企业年度报告申报&nbsp;<span class="cut-day" id="reportDueDays">(距6月30日年报期限还有<strong class="light dueDays"></strong>天！)</span></h3>
                        <p>
                            根据《企业信息公示暂行条例》第八条的规定，企业应当于<strong class="light">每年1月1日至6月30日</strong>报送公示年度报告。<br />未在规定期限内公示年度报告的，将被列入经营异常名录。
                        </p>
                    </div>
                    <div class="ann-report pdt10">
                        <table class="table-cw">
                            <thead>
                            <tr>
                                <th width="90">报告年度</th>
                                <th width="165">年报状态</th>
                                <th width="135">首次提交日期</th>
                                <th width="135">最近修改日期</th>
                                <th width="90">修改次数</th>
                                <th width="196">公示状态</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody id="tbody-tr" data-url='<c:url value="/reg/client/yr/yrregcheck/yearrport_template"/>'>
                            <c:choose>
                                <c:when test="${yrRegCheckList != null && yrRegCheckList.size()>0}">

                                    <c:forEach var="list"  items="${yrRegCheckList}" >
                                        <tr>

                                            <td>
                                                <input type="hidden" class="_reportCheck" data-year="${list.year}"  data-status="${list.isReported}"/>
                                                    ${list.year}
                                            </td>
                                                <%--年度年报状态：0未年报；1已年报；2已年报（逾期）--%>
                                            <td class="<c:if test="${list.isReported == '0'}">nopass</c:if>">${list.isReportedClientDesc}</td>

                                            <td><fmt:formatDate value="${list.firstReportTime}" pattern="yyyy-MM-dd" /></td>

                                            <td><fmt:formatDate value="${list.lastReportTime}"  pattern="yyyy-MM-dd" /></td>

                                            <td><c:if test="${list.isReported != '0'}">${list.modifyCount}</c:if></td>

                                            <td class="<c:if test="${list.reportState == '12'}">abnormal</c:if><c:if test="${list.reportState == '13'}">nopass</c:if>" 
                                            title="<c:if test="${list.reportState == '13'}">你企业${list.year}年度年报公示内容于<fmt:formatDate value='${list.lastReportTime}' pattern='yyyy-MM-dd' />日经审核不符合相关法规要求，不予正常公示，请修改后重新报送。</c:if>">
                                                <c:if test="${list.isReported != '0'}">${list.reportStateClientDesc}</c:if>
                                            </td>

                                            <td>
                                               
                                                <a href="javascript:void(0)" id="_operation" data-year="${list.year}" data-pripid="${pripid}" data-status="${list.isReported}" data-reportstate="${list.reportState}" data-encodeyear="${hx:encodeYear(list.year)}">
                                                    <c:if test="${list.reportState == '00'}">填报</c:if>
                                                    <c:if test="${(list.reportState == '10' || list.reportState == '11' || list.reportState == '12') && list.reportType != '6'}">详情</c:if>
                                                    <c:if test="${list.reportState == '13' || list.reportState == '20'}">修改</c:if>
                                                </a>
                                                <c:if test="${list.entTypeCatg=='16'|| list.entTypeCatg=='17'}">
                                                    <a href="javascript:void(0)" id="sfc_operation" data-year="${list.year}" data-pripid="${pripid}" data-status="${list.isReported}" data-encodeyear="${hx:encodeYear(list.year)}" data-url="<c:url value="/reg/client/yr/sfc/sfcwritehome/home"/>"  class="ml5">辅助报表</a>
                                                </c:if>
                                                <c:if test="${list.reportType == '6'}">该个体户已纸质年报</c:if>                    
                                                
                                            </td>

                                        </tr>
                                    </c:forEach>
                                </c:when>

                                <c:otherwise>
                                    <tr style="text-align: center;color: red;font-weight: bold;">
                                        <td colspan="7">暂无数据!</td>
                                    </tr>
                                </c:otherwise>
                            </c:choose>

                            </tbody>
                        </table>
                        <c:if test="${fn:indexOf('16,17,50',midBaseInfoDto.entTypeCatg) == -1}">
                            <div class="pub-brief clearfix">
                                <c:if test="${questionaireFlag == true || foodstorageFlag == true}">
                                    <strong>辅助报表</strong>
                                </c:if>
                                <c:if test="${questionaireFlag == true}">
                                    <input id="auditState" type="hidden" value="${individQueMain.auditState}"/>
                                    <input id="questionaireFlag" type="hidden" value="${questionaireFlag}"/>
                                    <c:if test="${individQueMain.auditState =='2' || individQueMain.auditState =='3'}">
                                        <span class="fl">已报送：<a id="questionaireView" href="<c:url value="/reg/client/yr/ent/individquestionnaire/view"/>" target="_blank">个转企经营情况表</a></span>
                                    </c:if>
                                    <c:if test="${empty individQueMain || individQueMain.auditState =='1'}">
                                        <span class="fl nopass"><span id="indiviStatus" class="fl nopass">未报送：</span><a id="questionaireView" href="<c:url value="/reg/client/yr/ent/individquestionnaire/view"/>" target="_blank">个转企经营情况表</a></span>
                                    </c:if>
                                </c:if>

                                <c:if test="${foodstorageFlag == true}">
                                    <input id="submitState" type="hidden" value="${foodstorageBase.submitState}"/>
                                    <c:if test="${foodstorageBase.submitState !='2'}">
                                        <span class="fl nopass"><span id="foodStatus" class="fl nopass">未报送：</span><a id="foodBaseView" href="<c:url value='/reg/client/yr/ent/foodstoragebase/list'/>" target="_blank">食品仓储备案表</a></span>
                                    </c:if>
                                    <c:if test="${foodstorageBase.submitState == '2'}">
                                        <span class="fl">已报送：<a id="foodBaseView" href="<c:url value='/reg/client/yr/ent/foodstoragebase/list'/>" target="_blank">食品仓储备案表</a></span>
                                    </c:if>
                                </c:if>
                            </div>
                        </c:if>
                    </div>
                </c:if>
            </div>
            <div class="tab-panel">
                <c:if test="${fn:indexOf('16,17,50',midBaseInfoDto.entTypeCatg) == -1}">
                    <div class="title">
                        <h3>企业即时信息申报 <%--<a href="javascript:void(0)" target="_blank" style="text-align: right" class="fr look-info">查看我的公示信息</a>--%></h3>
                        <p>
                            根据《企业信息公示暂行条例》第十条的规定，企业应当自下列信息形成之日起<strong class="light">20个工作日</strong>内完成报送公示。<br />未在工商行政管理部门责令期限内公示有关信息的将被列入经营异常名录。
                        </p>
                    </div>
                    <div class="msg-declare">
                        <c:forEach items="${imReportTypeList}" var="imRepName">
                            <c:if test="${imRepName == 'investment'}">
                                <span class="ctb-info"><a href="<c:url value="/reg/client/im/ent/investment/list"/>" target="_blank"><i class="tiny-icon"></i>股东及出资信息填报</a></span>
                            </c:if>
                            <c:if test="${imRepName == 'invsralt'}">
                                <span class="change-info"><a href="<c:url value="/reg/client/im/ent/invsralt/list"/>" target="_blank"><i class="tiny-icon"></i>股权变更信息填报</a></span>
                            </c:if>
                            <c:if test="${imRepName == 'permit'}">
                                <span class="allow-info"><a href="<c:url value="/reg/client/im/ent/permit/list"/>" target="_blank"><i class="tiny-icon"></i>行政许可信息填报</a></span>
                            </c:if>

                            <c:if test="${imRepName == 'ippldg'}">
                                <span class="reg-info"><a href="<c:url value="/reg/client/im/ent/ippldg/list"/>" target="_blank"><i class="tiny-icon"></i>知识产权出质登记信息填报</a></span>
                            </c:if>
                            <c:if test="${imRepName == 'case'}">
                                <span class="pub-info"><a href="<c:url value="/reg/client/im/ent/case/list"/>" target="_blank"><i class="tiny-icon"></i>行政处罚信息填报</a></span>
                            </c:if>
                        </c:forEach>
                    </div>
                </c:if>
            </div>
            <div class="tab-panel">
                <%--简易注销公告填写--%>
                <div id="simpleapply" class="mod thick-border logout-info" style="display:none">
                    <div class="mod-hd">
                        <div class="title">
                            <h3>简易注销公告</h3>
                            <span class="light">公告期为45个自然日，公告开始时间是点击“保存并公示”的系统时间！</span>
                        </div>
                    </div>
                    <div class="mod-bd">
                        <form id="simapplyform">
                        <input type="hidden" id="escid" name="id" value="">
                        <input type="hidden" id="priPID" name="priPID" value="${sessionScope.midBaseInfoDto.priPID}">
                        <input type="hidden" name="regOrg" value="${sessionScope.midBaseInfoDto.regOrg}">
                        <input type="hidden" name="localAdm" value="${sessionScope.midBaseInfoDto.localAdm}">
                        <input type="hidden" name="regNO" value="${sessionScope.midBaseInfoDto.regNO}">
                        <input type="hidden" name="uniSCID" value="${sessionScope.midBaseInfoDto.uniCode}"> 
                        <table class="table-public mt5">
                            <tbody>
                            <tr>
                                <td class="focus-state">
                                    <div class="item-name w168">企业名称</div>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="entName" value="${sessionScope.midBaseInfoDto.entName}" 
                                        class="ipt-txt w308" style="padding-left: 5px;text-align: left;"  readonly="readonly">
                                        <i class="icon-close"></i>
                                    </div>
                                </td>
                                <td class="focus-state">
                                    <div class="item-name w160">统一社会信用代码/注册号码</div>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name=""
                                        value="${empty sessionScope.midBaseInfoDto.uniCode?sessionScope.midBaseInfoDto.regNO:sessionScope.midBaseInfoDto.uniCode}"
                                         class="ipt-txt w200" style="padding-left: 5px;text-align: left;"  readonly="readonly">
                                        <i class="icon-close"></i>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="focus-state">
                                    <div class="item-name w168">登记机关</div>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="" value="${sessionScope.midBaseInfoDto.regOrgName}"  title="${sessionScope.midBaseInfoDto.regOrgName}"
                                        class="ipt-txt w308" style="padding-left: 5px;text-align: left;" readonly="readonly">
                                        <i class="icon-close"></i>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <div class="item-name w168">全体投资人承诺书</div>
                                    <input type="file" id="commitment_file" name="file" class="left ipt-txt w650">
                                    <input type="hidden" name="commitment" id="uploadurl">
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" value="" id="showfile" class="left ipt-txt w650" placeholder="" style="display:none">
                                        <input type="button" id="uploadfile" value="上传" class="btn-common btn-upload">
                                        <input type="button" id="reloadfile" value="重新上传" class="btn-common btn-upload" style="display:none">
                                        <input type="button" id="uploading" value="上传中..." class="btn-common btn-upload" style="display:none">
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <div class="item-name w168"></div>
                                    <div class="ipt-box js-ipt-box">
                                       <span class="light mt10"> 
	                                                                                                   注：经全体投资人签字确认的承诺书请扫描或拍照后以图片JPG格式进行上传，上传的单张图片大小不超过1M。
                                     &nbsp;&nbsp;<a href="<c:url value="/reg/client/simpleesc/erescappinfo/commitmod"/>">全体投资人承诺书模板下载</a>
                                </span>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" >
                                    <p class="center mt10 mb10">
                                        <input type="button" value="保 存" state="01"  class="btn-common mr5 apply-save">
                                        <input type="button" value="保存并公示" state="02" class="btn-common mr5 apply-save">
                                    </p>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        </form>
                    </div>
                </div>
                <%--简易注销公告详情--%>
                <div id="simpleinfo"  class="mod" style="display:none">
                    <div class="title subcapital">
                        <h3>简易注销公告</h3>
                        <div class="btn-box">
                            <a id="print" href="javascript:void(0)" class="btn-common btn-add">预览打印</a>
                            <a id="apply_cancel" href="javascript:void(0)" class="btn-common btn-add">撤销</a>
                        </div>
                        <p>
                            <strong class="light">自<span id="startTime"></span>申请简易注销公告起，企业将不能申请办理除简易注销外的其他工商登记业务；<br/>
                                至<span id="endTime"></span>公告期满，请务必于<span id="endDate"></span>前到原登记机关申请办理简易注销登记手续。</strong>
                        </p>
                    </div>
                    <div class="pd10">
                        <ul class="jyzx-notice clearfix">
                            <li><label>企业名称：</label><span>${sessionScope.midBaseInfoDto.entName}</span></li>
                            <li><label>统一社会信用代码/注册号：</label><span>${empty sessionScope.midBaseInfoDto.uniCode?sessionScope.midBaseInfoDto.regNO:sessionScope.midBaseInfoDto.uniCode}</span></li>
                            <li><label>登记机关：</label><span>${sessionScope.midBaseInfoDto.regOrgName}</span></li>
                            <li><label>公告期：</label><span id="noticeTime"></span></li>
                            <li><label>全体投资人承诺书：</label><span><a  href="/reg/client/simpleesc/erescappinfo/view" target="_blank">全体投资人承诺书</a></span></li>
                            <li><label>简易注销公告状态：</label><span id="simple_status"></span></li>
                        </ul>
                        <h4 class="tiny-title"><span class="left-icon"></span>异议信息</h4>
                        <table class="table-cw">
                          <thead>
	                            <tr>
	                                <th width="50">序号</th>
	                                <th>异议申请人</th>
	                                <th width="625">异议内容</th>
	                                <th>异议时间</th>
	                            </tr>
                          </thead>
	                        <tbody id="objection_page">
	                        </tbody>
                        </table>
                        <div class="notice-pagination-box clearfix">
                            <span class="page-total">共查询到<em id="tody_total"></em>条信息，共<em id="tody_pageNum"></em>页</span>
                            <div id="tody_pagination" class="pagination"><span class="current prev disabled">首页</span><span class="current prev"><i class="icon-triangle-left"></i>上一页</span><span class="current"></span><span class="current next">下一页<i class="icon-triangle-right"></i></span><span class="current prev disabled">末页</span></div>
                        </div>
                    </div>
                </div>
            </div>

           
            <%--公务文书回执--%>
            <!-- 数字证书登录 -->
			<c:if test="${loginType==5}">
            <div class="tab-panel">
                 <input type="hidden" id="writ-pripid" value="${pripid}">
                 <%@include file="writ/writ_sccheck_list.jsp"%>
            </div> 
            </c:if>
        </div>


    </div>
</div>
<%-- 首页tab切换主体结束 --%>

<%-- 数字证书登录 联络员信息 无 或 法定代表人发生变化或时间太久变更 start--%>
<c:if test="${empty liaisonLogin}">  <%--用于判断是否是联络员登录  判断条件为true:表示是 数字证书登录 false：表示是 联络员登录 --%>
    <div class="liaison-layer js-content-show "  id="js-liaison-info">
        <div class="mod-hd">
            <h3 class="light">工商联络员信息</h3>
            <c:if test="${empty liaison}"><div class="reminder">提示：请先完善你企业（农专社）的工商联络员信息！真实有效的联络员信息有助于工商部门及时联系你企业。</div></c:if>
            <c:if test="${!empty liaison}"><div class="reminder">提示：你企业（农专社）法定代表人（负责人）已变更，请重新完善有效的工商联络员信息！</div></c:if>
        </div>
        <div class="mod-bd">
            <form class="form-horizontal error-bottom" id="FormTwo" >
                    <%--uuid--%>
                <input type="hidden"    name="uid"  value="${liaison.uid}" >
                    <%--接受状态 01：已接受 --%>
                <input type="hidden"    name="passtatus"  value="01" >
                    <%--注册号--%>
                <input type="hidden" id="regno"   name="regno"    value="${!empty liaison.regno?liaison.regno:midBaseInfoDto.regNO}" >
                    <%--统一社会信用代码--%>
                <input type="hidden" id="unicode" name="unicode"  value="${!empty liaison.unicode?liaison.unicode:midBaseInfoDto.uniCode}" >
                    <%--主体身份代码--%>
                <input type="hidden" id="pripid"  name="pripid"   value="${!empty liaison.pripid?liaison.pripid:midBaseInfoDto.priPID}" >
                    <%--企业小类--%>
                <input type="hidden" id="enttype" name="enttype"  value="${!empty liaison.enttype?liaison.enttype:midBaseInfoDto.entType}" >
                    <%--企业名称--%>
                <input type="hidden" id="entName" name="entname"  value="${!empty liaison.entname?liaison.entname:midBaseInfoDto.entName}">
                <div class="content">
                    <table class="table-public table-align-l mb10" border="0" cellspacing="0" cellpadding="0" >
                        <tbody>
                        <tr>
                            <td class="odd focus-state">
                                <div class="item-name w180"><span class="light">*</span>法定代表人（负责人）姓名</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="lerep2" name="lerep" value="${midBaseInfoDto.leRep}" class="ipt-txt " placeholder="" ${fn:indexOf('27,33',midBaseInfoDto.entTypeCatg) != -1?'':'readonly'}><%--判是否是合伙人(27,33)  是 可以编辑  不是不可编辑 --%>
                                    <c:if test="${fn:indexOf('27,33',midBaseInfoDto.entTypeCatg) != -1}"><i class="icon-close"></i> </c:if>
                                </div>
                            </td>
                            <td class="even focus-state">
                                <div class="item-name w180"><span class="light">*</span>法定代表人（负责人）手机号码</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="lerepphone2" name="lerepphone" value="${liaison.lerepphone}" class="ipt-txt " placeholder="">
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="odd focus-state">
                                <div class="item-name w180"><span class="light">*</span>联络员姓名</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="lianame2" name="lianame" value="${liaison.lianame}" class="ipt-txt " placeholder="">
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                            <td class="even focus-state">
                                <div class="item-name w180"><span class="light">*</span>联络员证件类型</div>
                                <div class="ipt-box">
                                    <select id="_select2" name="liaidtype" class="ipt-txt">
                                        <option value="">--请选择--</option>
                                        <c:forEach var="list" items="${codeCertypeList}" >
                                            <option value="${list.code}" ${liaison.liaidtype==list.code?'selected':''}>${list.content}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="odd focus-state">
                                <div class="item-name w180"><span class="light">*</span>联络员手机号码</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="tel2" name="tel" value="${liaison.tel}" class="ipt-txt " placeholder="">
                                    <i class="icon-close"></i>
                                </div>
                                <input type="button" value="获取验证码"  class="btn-common btn-h30 js-Code-two" data-code="js-Code-two">
                            </td>
                            <td class="even focus-state">
                                <div class="item-name w180"><span class="light">*</span>联络员证件号码</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="liaidnum" value="${liaison.liaidnum}" class="ipt-txt " placeholder="">
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="odd focus-state">
                                <div class="item-name w180">验证码</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="js-password-two" name="password" value="" class="ipt-txt" placeholder="">
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>

                    <div class="tips"><span class="light">如无法获取验证码！</span>请尝试重新获取验证码或凭企业工商联络员手机号码拨打客服热线400-888-4636查询验证码。</div>
                    <p class="center mt10">
                        <input type="submit" value="提交"  class="btn-common js-FormTwo">
                    </p>
                </div>
            </form>
        </div>
    </div>
</c:if>
<%-- 数字证书登录 联络员信息 无 或 变更 end--%>

<%--联络员登录 确认联络员信息 start--%>
<c:if test="${!empty liaisonLogin}">
    <div class="liaison-layer js-content-show "  id="js-liaison-login-info">
        <div class="mod-hd">
            <h3 class="light">工商联络员信息</h3>
                <div class="reminder">提示：请您核对工商联络员信息是否完整并正确,确认无误后进行提交。</div>
        </div>
        <div class="mod-bd">
            <form class="form-horizontal error-bottom" id="Form_lianson_two" >
                <input type="hidden"    name="uid"  value="${liaison.uid}" >
                <input type="hidden"  name="pripid"  value="${liaison.pripid}" >
                <input type="hidden"  name="regno"   value="${liaison.regno}" >
                <input type="hidden"  name="unicode" value="${liaison.unicode}" >
                <div class="content">
                    <table class="table-public table-align-l mb10" border="0" cellspacing="0" cellpadding="0" >
                        <tbody>
                        <tr>
                            <td class="odd focus-state">
                                <div class="item-name w180"><span class="light">*</span>法定代表人（负责人）姓名</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="liaison_lerep_two"  name="lerep" value="${!empty midBaseInfoDto.leRep?midBaseInfoDto.leRep:liaison.lerep}" class="ipt-txt " placeholder="" ${fn:indexOf('27,33',midBaseInfoDto.entTypeCatg) != -1?'':'readonly'}><%--判是否是合伙人(27,33)  是 可以编辑  不是不可编辑 --%>
                                    <c:if test="${fn:indexOf('27,33',midBaseInfoDto.entTypeCatg) != -1}"><i class="icon-close"></i> </c:if>
                                </div>
                            </td>
                            <td class="even focus-state">
                                <div class="item-name w180"><span class="light">*</span>法定代表人（负责人）手机号码</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="liaison_lerepphone_two"  name="lerepphone" value="${liaison.lerepphone}" class="ipt-txt" >
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="odd focus-state">
                                <div class="item-name w180"><span class="light">*</span>联络员姓名</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="liaison_lianame_two"  name="lianame" value="${liaison.lianame}" class="ipt-txt " readonly>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                            <td class="even focus-state">
                                <div class="item-name w180"><span class="light">*</span>联络员证件类型</div>
                                <div class="ipt-box">
                                    <c:forEach var="list" items="${codeCertypeList}" >
                                        <c:if test="${liaison.liaidtype==list.code}">
                                            <input type="text"  value="${list.content}" class="ipt-txt"  readonly>
                                        </c:if>
                                    </c:forEach>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="odd focus-state">
                                <div class="item-name w180"><span class="light">*</span>联络员手机号码</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="liaison_tel_two" name="tel" value="${liaison.tel}" class="ipt-txt " readonly>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                            <td class="even focus-state">
                                <div class="item-name w180"><span class="light">*</span>联络员证件号码</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="liaidnum" value="${liaison.liaidnum}" class="ipt-txt " readonly>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <p class="center mt10">
                        <input type="submit" value="提交"  class="btn-common js-liaison-save">
                    </p>
                </div>
            </form>
        </div>
    </div>
</c:if>
<%--联络员登录 确认联络员信息 end--%>



<%--获取联络员的 参数判断条件 隐藏域 start --%>
<input type="hidden" id="_liaison" value="${liaison}">
<input type="hidden" id="_flag" value="${flag}">
<input type="hidden" id="liaisonLogin" value="${liaisonLogin}"><%--是否是联络员登录--%>
<input type="hidden" id="_EntTypeCatg" value="${EntTypeCatg}"><%--企业类型 主要用于判断是否是个体户--%>
<input type="hidden" id="date_flag" value="${date_flag}">
<%--获取联络员的 参数判断条件 隐藏域 end --%>

<%--联络员 法人代表已变更 start--%>
<div class="logout-layer" style="display: none;">
    <div class="title">
        <h3>请确认您符合以下条件</h3>
    </div>
    <div class="content">
        <h4>一：简易注销适用范围</h4>
        <p  style="text-indent:2em;">领取营业执照后未开展经营活动（未开业），申请注销登记前未发生债权债务或已将债权债务清算完结（无债权债务）的如下企业：</p>
        <p>1.有限责任公司；</p>
        <p>2.非公司企业法人；</p>
        <p>3.个人独资企业；</p>
        <p>4.合伙企业；</p>
        <h4>二：企业有下列情形之一的，不适用简易注销程序</h4>
        <p>1.涉及国家规定实施准入特别管理措施的外商投资企业；&nbsp;<a href="<c:url value="/reg/client/simpleesc/erescappinfo/otherinfo"/>" style="text-decoration: underline;">外商投资准入特别管理措施</a></p>
        <p>2.被列入企业经营异常名录或严重违法失信企业名单的；</p>
        <p>3.存在股权（投资权益）被冻结，出质或动产抵押等情形；</p>
        <p>4.有正在被立案调查或采取行政强制，司法协助，被予以行政处罚等情形的；</p>
        <p>5.企业所属的非法人分支机构未办理注销登记；</p>
        <p>6.曾被终止简易注销程序的；</p>
        <p>7.法律，行政法规或者国务院决定规定在注销登记前需经批准的；</p>
        <p>8.不适用企业简易注销的其他企业；</p>
        <h4>
            三：人民法院裁定强制清算或裁定宣告破产的，有关企业清算组，企业管理人可持人民法院终结强制清算程序的裁定或终结破产裁定程序的裁定，可直接向被强制清算人或破产人的原登记机关申请办理简易注销登记，无需进行简易注销公告。</h4>
        <p class="mt10 center"><input type="checkbox" class="ipt-checkbox" id="read"><label for="read">我已阅读</label></p>
        <p class="mt5 center"><input type="button" value="确 定" class="btn-common btn-sure"></p>
    </div>
</div>

<%--全体投资人承诺书弹出框--%>
<div class="tzy-cns-box" style="display: none;">
    <p>企业只有一次机会申请简易注销公告！如选
        择撤销简易注销公告，将不能再次进行简易
        注销公告，申请办理简易注销登记手续。</p>
    <div class="center mt10">
    <input type="button" id="confirm" class="btn-common mr10" value="确认撤销">
    <input type="button" id="cancel" class="btn-common tipcancel" value="取消"></div>
</div>
<div class="tzyb-cns-box simConfirm" style="display: none;text-align: center;">
    <p>公告期：<span id="noticefrom"></span>-<span class="noticeto"></span></p>
    <p>至<span class="noticeto"></span>公告期满，请务必于<span class="tipTime"></span>前到原登记机关申请办理简易注销登记手续。</p>
    <p>如需撤销简易注销公告，请于<span class="tipTime"></span>前撤销</p>
    <p>一经提交则无法再做修改！</p>
    <div class="center mt10">
    <input type="button" id="confirm02" class="btn-common mr10" value="确定">
    <input type="button" class="btn-common tipcancel" value="取消"></div>
</div>


<div class="mod footer">
    Copyright ©2003-2016&nbsp;&nbsp;<span class="mr20">浙江省工商行政管理局版权所有</span><span class="mr10">技术支持：浙江汇信科技有限公司</span>服务电话：400-888-4636</br>
    <span class="mr10">仅支持IE8及以上浏览器</span>建议使用1024*768以上分辨率
</div>
<form id="queryYearReportForm">
   <input type="hidden" name="priPID" value="${sessionScope.midBaseInfoDto.priPID}">
</form>
<%--模板写法--%>
<script id="objection_table" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
       <td>{{xh @index}}</td>
       <td>{{name}}</td>
       <td class="yc-cont">{{objection}}</td>
       <td>{{objapptime}}</td>
    </tr>
    {{/each}}
</script>
<script>
    var catg = '${midBaseInfoDto.entTypeCatg}', url;
    if(catg == '50') {
        url = '<c:url value="/reg/client/yr/pb/pbbaseinfo/show"/>';
    }else if(catg == '16' || catg == '17') {
        url = '<c:url value="/reg/client/yr/sfc/sfcbaseinfo/show"/>';
    }else{
        url = '<c:url value="/reg/client/yr/yrwritehomepage/write_homepage"/>';
    }
    window._CONFIG = {
        operation_url: url//操作
    }
</script>


<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/component/dropDown.js"/>"></script>
<script src="<c:url value="/js/component/tab.js"/>"></script>
<script>
    $(function () {
        $('.js-warn-msg').on('click','.detail a',function(){
            var html = $(this).html();
            $(this).html(html == '详情'?'收起':'详情');
            $(this).closest('tr').next().find('.warn-dropdown-cont').toggle();
        })

        $('.js-tip-box').click(function () {
            $('.layer').show();
            $('.tipbox').show()
        })
        $('.js-tipbox-close').click(function () {
            $('.layer').hide();
            $('.tipbox').hide()
        });
    });
</script>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<!--主页-->
<script src="<c:url value="/js/reg/client/index_main.js"/>"></script>
<!--文书-->
<%--<script src="<c:url value="/js/reg/client/writ/writ_list.js"/>"></script>--%>
</body>
</html>
