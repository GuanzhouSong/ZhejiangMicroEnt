<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="TypeCatg" value="12,14,22,24,28,32,34"/>
<c:set var="entType" value="${entType}"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>其它情况表填写页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>


<!-- 企业财务信息 -->
<form class="form-horizontal error-bottom" id="otherForm">
    <div class="mod caiwu">

        <div class="mod-bd">
            <div class="title">
                <h3>企业联络员信息</h3>
                <p>请按照当前企业实际情况<strong class="light">填写/修改</strong>相关联系信息</p>
            </div>
            <div class="content">
                <table class="table-public table-liaison" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name"><strong class="light">* </strong>法定代表人（负责人）姓名</div>
                            <div class="ipt-box">
                                <input type="text" name="leRep" value="${yrOtherInfo.leRep}" class="ipt-txt" readonly="readonly">
                            </div>
                        </td>
                        <td class="even focus-state">
                            <div class="item-name"><strong class="light">* </strong>法定代表人（负责人）手机号码</div>
                            <div class="ipt-box">
                                <input type="text" name="leRepPhone" value="${yrOtherInfo.leRepPhone}" class="ipt-txt" readonly="readonly">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name"><strong class="light">* </strong>企业联络员姓名</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="liaName" value="${yrOtherInfo.liaName}" class="ipt-txt">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td class="even focus-state">
                            <div class="item-name"><strong class="light">* </strong>企业联络员手机号码</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="liaPhone" value="${yrOtherInfo.liaPhone}" class="ipt-txt">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <%--liaidtype--%>
                            <div class="item-name"><strong class="light">* </strong>企业联络员证件类型</div>
                            <div class="ipt-box ">

                                <input type="text" name="" value="身份证" class="ipt-txt" readonly="readonly"/>
                                <input type="hidden" name="liaIDType" value="0" readonly="readonly"/>
                              <%--  <select id="liaIDType" name="liaIDType" class="select-txt">
                                    <option value="0">身份证</option>
                                    <option value="1">护照</option>
                                </select>--%>
                            </div>
                        </td>
                        <td class="even focus-state">
                            <div class="item-name"><strong class="light">* </strong>企业联络员证件号码</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="liaIDNum" value="${yrOtherInfo.liaIDNum}" class="ipt-txt">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>

    <!-- 企业联系信息 -->
    <div class="mod contact">
        <div class="mod-hd">
            <div class="title">
                <h3>企业联系信息</h3>
                <div class="currency">币种：<strong class="light">人民币</strong></div>
                <p>以下信息请按照你企业${year}年1月1日至12月31日期间全年应纳税金额填写</p>
            </div>
        </div>
        <div class="mod-bd">
            <div class="content content-contact">
                <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name bg"><strong class="light">* </strong>企业联系电话</div>
                            <div class="radio-box js-ipt-box">
                                <label><input type="radio" id="tel_no" name="otherInfoIsTel" value="0"  <c:if test="${yrOtherInfo.otherInfoIsTel=='0'}">checked</c:if> >无</label>
                                <label><input type="radio" id="tel_yes" name="otherInfoIsTel" value="1" <c:if test="${yrOtherInfo.otherInfoIsTel=='1'}">checked</c:if> >有</label>
                            </div>
                            <div class="ipt-box">
                                <input type="text" name="tel" value="${yrOtherInfo.tel}" class="ipt-txt">
                                <i class="icon-close"></i>
                            </div>
                        </td>


                        <td class="even focus-state">
                            <div class="item-name bg"><strong class="light">* </strong>企业电子邮箱</div>
                            <div class="radio-box js-ipt-box">
                                <label><input type="radio" id="email_no" name="otherInfoIsEmail" value="0"  <c:if test="${yrOtherInfo.otherInfoIsEmail=='0'}">checked</c:if> >无</label>
                                <label><input type="radio" id="email_yes" name="otherInfoIsEmail" value="1"  <c:if test="${yrOtherInfo.otherInfoIsEmail=='1'}">checked</c:if> >有</label>
                            </div>
                            <div class="ipt-box">
                                <input type="text" name="email" value="${yrOtherInfo.email}" class="ipt-txt">
                                <i class="icon-close"></i>
                            </div>
                        </td>



                    </tr>
                    <tr>
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name special bg"><i class="icon-question"></i><strong class="light">* </strong>企业通讯地址
                            </div>
                            <div class="ipt-box">
                                <div class="item-select">
                                    <select name="" class="select-txt">
                                        <option value="">--请选择--</option>
                                    </select>
                                    <select name="" class="select-txt">
                                        <option value="">--请选择--</option>
                                    </select>
                                    <select name="" class="select-txt">
                                        <option value="">--请选择--</option>
                                    </select>
                                </div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" class="ipt-txt" name="addr" value="${yrOtherInfo.addr==null?lastYrOtherInfo.addr:yrOtherInfo.addr}"
                                           placeholder="建议您如实填写详细通讯地址，例如街道名称，门牌号码，楼层和房间号等信息">
                                    <i class="icon-close"></i>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state"  <c:if test="${fn:indexOf(TypeCatg,entType) == -1}"> colspan="2" </c:if> >
                            <div class="item-name bg"><strong class="light">* </strong>邮政编码</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="postalCode" value="${yrOtherInfo.postalCode==null?lastYrOtherInfo.postalCode:yrOtherInfo.postalCode}"
                                       class="ipt-txt ipt-txt-lg" placeholder="如您不清楚邮政编号，请填写000000">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <%--判断当前登录企业是否是 分支机构--%>
                        <c:if test="${fn:indexOf(TypeCatg,entType) != -1}">
                        <td class="even focus-state">
                            <div class="item-name bg"><strong class="light">* </strong>隶属企业名称</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="supEntname" value="${yrOtherInfo.supEntname}" class="ipt-txt">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        </c:if>
                    </tr>

                    <tr>
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name">企业组织机构代码证号</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="entOrgCode" value="${yrOtherInfo.entOrgCode}"
                                       class="ipt-txt ipt-txt-lg">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="even focus-state" colspan="2">
                            <div class="item-name">企业税务证登记号</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="taxRegNo" value="${yrOtherInfo.taxRegNo}"
                                       class="ipt-txt ipt-txt-lg">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

<%--判断当前登录企业是否是 分支机构--%>
<c:if test="${fn:indexOf(TypeCatg,entType) == -1}">
    <!-- 企业党建信息 -->
    <div class="mod dangjian">
        <div class="mod-hd">
            <div class="title">
                <h3>企业党建信息</h3>
                <p>以下信息请按照截止${year}年12月31日时的企业情况进行填写</p>
            </div>
        </div>
        <div class="mod-bd">
            <div class="content content-dangjian">
                <table class="table-public table-dangjian" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <input type="hidden" id="_empNum" value="${empNum}"/><!-- 企业从业人数 -->
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name"><strong class="light">* </strong>其中党员（含预备党员）</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="_numParM" name="numParM" value="${yrOtherInfo.numParM}" class="ipt-txt">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name"><strong class="light">* </strong>法定代表人（执行合伙事务人，投资人，经营者）是否为党员</div>
                            <div class="radio-box">
                                <label><input type="radio" name="resParMSign" value="1"  <c:if test="${yrOtherInfo.resParMSign=='1'}">checked</c:if> >是</label>
                                <label><input type="radio" id="No_ResParMSign" name="resParMSign" value="0"  <c:if test="${yrOtherInfo.resParMSign=='0'}">checked</c:if> >否</label>
                            </div>
                        </td>
                        <td class="even focus-state">
                            <div class="item-name">是否担任党组织书记</div>
                            <div class="radio-box">
                                <label><input type="radio" name="resParSecSign" value="1"  <c:if test="${yrOtherInfo.resParSecSign=='1'}">checked</c:if> >是</label>
                                <label><input type="radio" name="resParSecSign" value="0"  <c:if test="${yrOtherInfo.resParSecSign=='0'}">checked</c:if> >否</label>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name">党组织建制</div>
                           <div class="ipt-box">
                                <select id="parIns" name="parIns" class="select-txt" >
                                    <option value="0"  <c:if test="${yrOtherInfo.parIns=='0'}">selected</c:if> >未组建党支部</option>
                                    <option value="1"  <c:if test="${yrOtherInfo.parIns=='1'}">selected</c:if> >党支部</option>
                                    <option value="2"  <c:if test="${yrOtherInfo.parIns=='2'}">selected</c:if> >党总支</option>
                                    <option value="3"  <c:if test="${yrOtherInfo.parIns=='3'}">selected</c:if> >党委</option>
                                </select>
                            </div>
                            <input type="hidden" id="_parIns" value="${yrOtherInfo.parIns}"/>
                            <input type="hidden" id="parInsCN" name="parInsCN" value="${yrOtherInfo.parInsCN==null?'未组建党支部':yrOtherInfo.parInsCN}"/>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name"><strong class="light">* </strong>组建时间</div>
                         <div class="ipt-box">
                              <input type="hidden" id="_parSetTime" name="parSetTime" value="<fmt:formatDate value="${yrOtherInfo.parSetTime}"  pattern="yyyy-MM-dd" />" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" class="ipt-txt laydate-icon" readonly="readonly" disabled="disabled">
                               <%-- <i class="icon-close"></i>--%>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name"><strong class="light">* </strong>组建方式</div>
                            <div class="ipt-box" >
                               <input type="hidden" id="_parOrgW" value="${yrOtherInfo.parOrgW}">
                              <select id="_one"  name="parOrgW" class="select-txt"  style="display: none" disabled="disabled">
                                    <option value="">--请选择--</option>
                                    <option value="1" >单独组建</option>
                                    <option value="2" >联合组建</option>
                              </select>

                              <select id="_two" name="parOrgW"  class="select-txt"  style="display: none;" disabled="disabled">
                                <option value="">--请选择--</option>
                                <option value="1" >单独组建</option>
                                <option value="2" >联合组建</option>
                                <option value="3" >加入社区党组织</option>
                                <option value="4" >加入民营（私营）企业协会党组织</option>
                                <option value="5" >加入上级企业（母公司）党组织</option>
                            </select>


                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>

    <!-- 企业经营信息 -->
    <div class="mod jyxx">
        <div class="mod-hd">
            <div class="title">
                <h3>企业经营信息</h3>
                <p>以下信息请按照截止${year}年12月31日时的企业情况进行填写</p>
            </div>
        </div>
        <div class="mod-bd">
            <div class="content content-jyxx">
                <table class="table-public table-jyxx" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name">企业拥有专利的数</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="otherInfoPatAmount" value="${yrOtherInfo.otherInfoPatAmount==null?'0':yrOtherInfo.otherInfoPatAmount}"
                                       class="ipt-txt" placeholder="0">
                                <i class="icon-close"></i>
                            </div>
                            个
                        </td>
                    </tr>
                    </tbody>
                </table>
                <table class="table-public table-jyxx" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th colspan="3"><span>商标注册与许可使用情况</span><span class="line"></span></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td class="odd focus-state" width="355">
                            <span class="line"></span>
                            <div class="item-name">国内商标注册数</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="domTraRegs" value="${yrOtherInfo.domTraRegs==null?'0':yrOtherInfo.domTraRegs}" class="ipt-txt"
                                       placeholder="0">
                                <i class="icon-close"></i>
                            </div>
                            个
                        </td>
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name">境外商标注册数</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="abrTraRegs" value="${yrOtherInfo.abrTraRegs==null?'0':yrOtherInfo.abrTraRegs}" class="ipt-txt"
                                       placeholder="0">
                                <i class="icon-close"></i>
                            </div>
                            个
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <span class="line-portrait"></span>
                            <div class="item-name item-name-box">其中：实际在使用商标数</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="usingTraRegs" value="${yrOtherInfo.usingTraRegs==null?'0':yrOtherInfo.usingTraRegs}"
                                       class="ipt-txt" placeholder="0">
                                <i class="icon-close"></i>
                            </div>
                            个
                        </td>
                        <td class="odd focus-state" width="365">
                            <div class="item-name">许可他人使用商标数</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="licOthTraRegs" value="${yrOtherInfo.licOthTraRegs==null?'0':yrOtherInfo.licOthTraRegs}"
                                       class="ipt-txt" placeholder="0">
                                <i class="icon-close"></i>
                            </div>
                            个
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name">本年新申请商标数</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="newAppTraRegs" value="${yrOtherInfo.newAppTraRegs==null?'0':yrOtherInfo.newAppTraRegs}"
                                       class="ipt-txt ipt-txt-sm" placeholder="0">
                                <i class="icon-close"></i>
                            </div>
                            个
                        </td>
                    </tr>
                    </tbody>
                </table>
                <table class="table-public table-jyxx" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th colspan="3"><span>广告投入费用及经营情况</span><span class="line"></span></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td class="odd focus-state" width="355">
                            <div class="item-name">本年度投入广告费</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="thAnnAdvFee" value="${yrOtherInfo.thAnnAdvFee==null?'0.00':yrOtherInfo.thAnnAdvFee}" class="ipt-txt otherItem" placeholder="0.00">
                                <i class="icon-close"></i>
                            </div>
                            元
                        </td>
                        <td class="odd focus-state" width="365">
                            <div class="item-name  item-name-box">其中：在互联网投入广告费</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="thIntAnnAdvFee" value="${yrOtherInfo.thIntAnnAdvFee==null?'0.00':yrOtherInfo.thIntAnnAdvFee}" class="ipt-txt otherItem" placeholder="0.00">
                                <i class="icon-close"></i>
                            </div>
                            元
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name"><strong class="light">* </strong>是否经营广告费</div>
                            <div class="radio-box">
                                <input type="hidden" id="_advBusFlag" value="${yrOtherInfo.advBusFlag}" />
                                <label><input type="radio" name="advBusFlag" value="1" <c:if test="${yrOtherInfo.advBusFlag=='1'}">checked</c:if> >专营</label>
                                <label><input type="radio" name="advBusFlag" value="2"  <c:if test="${yrOtherInfo.advBusFlag=='2'}">checked</c:if> >兼营</label>
                                <label><input type="radio" name="advBusFlag" value="0"  <c:if test="${yrOtherInfo.advBusFlag=='0'}">checked</c:if> >否</label>
                            </div>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name"><strong class="light">* </strong>本年度广告经营额</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="thAdvTurnover" value="${yrOtherInfo.thAdvTurnover}" class="ipt-txt otherItem" placeholder="0.00">
                                <i class="icon-close"></i>
                            </div>
                            元
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name"><strong class="light">* </strong>广告经营上缴税收</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="advTurTaxPaid" value="${yrOtherInfo.advTurTaxPaid}" class="ipt-txt ipt-txt-sm otherItem" placeholder="0.00">
                                <i class="icon-close"></i>
                            </div>
                            元
                        </td>
                    </tr>
                    </tbody>
                </table>
                <table class="table-public table-jyxx" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th colspan="2"><span>网络应用与经营信息</span><span class="line"></span></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td class="odd focus-state" width="355">
                            <div class="item-name">本年度通过网络交易经营额</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="thNetTraBusTur" value="${yrOtherInfo.thNetTraBusTur==null?'0.0000':yrOtherInfo.thNetTraBusTur}" class="ipt-txt million_yuan" placeholder="0.0000">
                                <i class="icon-close"></i>
                            </div>
                            <strong class="light">万元</strong>
                        </td>
                        <td class="odd focus-state">
                            <span class="line line2"></span>
                            <div class="item-name  item-name-box">其中：跨境网络交易进出口经营额</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="partyAccNetAmount" value="${yrOtherInfo.partyAccNetAmount==null?'0.0000':yrOtherInfo.partyAccNetAmount}" class="ipt-txt million_yuan" placeholder="0.0000">
                                <i class="icon-close"></i>
                            </div>
                            <strong class="light">万元</strong>
                        </td>
                        <td></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</c:if>
</form>
    <!-- 网站或网店信息 -->
    <div class="mod yonggong">
        <div class="mod-hd">
            <div class="title">
                <h3>网站或网店信息</h3>
                <p>以下信息请按照当前企业年度报告时的情况进行填写</p>
            </div>
        </div>
        <div class="mod-bd">
            <div class="content content-yonggong">
                <table class="table-public table-yonggong" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name bg">企业是否有网站或网店</div>
                            <div class="radio-box">
                                <label><input type="radio" id="_yes" name="gongshi" value="1" <c:if test="${yrWebsiteInfoList!=null&&yrWebsiteInfoList.size()>0}">checked</c:if> >是</label>
                                <label><input type="radio" id="_no"  name="gongshi" value="0" <c:if test="${yrWebsiteInfoList==null}">checked</c:if> >否</label>
                                <input type="hidden" id="_wzdata" value="${yrWebsiteInfoList.size()}"/>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>



<!-- 企业网站信息 -->
<div id="qywz" class="mod yonggong" style="display: none">
    <div class="mod-hd">
        <div class="title">
            <h3>企业网站信息</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content table-website">
            <table class="table-public table-web">
                <thead>
                <tr>
                    <th width="88">类型</th>
                    <th width="320">名称</th>
                    <th width="360">域名</th>
                </tr>
                </thead>
                <tbody id="_websit">
                   <c:forEach var="list" items="${yrWebsiteInfoList}">
                       <tr>
                           <td>${list.webType==0?'网站':'网店'}</td>
                           <td>${list.webSitName}</td>
                            <td>${list.webSite}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script><%-- 填报表单中的jquery 这行代码不能删除  这里涉及到提交年报使用到的$.ajax请求--%>
<script src="<c:url value="/js/component/dropDown.js"/>"></script>
<script src="<c:url value="/js/lib/placeholder/jquery.placeholder.min.js"/>"></script>
<script src="<c:url value="/js/lib/jquery/jquery.icinfo.js"/>"></script>
<script>
    $('input, textarea').placeholder(); //ie8支持placeholder
    $('.js-ipt-box').expandInput();
</script>

<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/server/yr/other/view_main.js"/>"></script>



</body>
</html>
