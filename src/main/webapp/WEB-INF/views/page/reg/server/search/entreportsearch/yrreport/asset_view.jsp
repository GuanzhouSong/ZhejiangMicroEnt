<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/26
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="entTypeImpExtend" value="1122,1130,1151,1152,1212,1222,2122,2130,2151,2152,2212,2222,4500,4510,4550,4530,4570,4560,4580"/>
<c:set var="entType" value="${entType}"/>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>资产状况表浏览页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>

<!-- 企业财务信息 -->
<div class="mod caiwu">
    <div class="tips">
        <span class="txt">报表中背景颜色为</span>
        <span class="blockage"></span>
        <span class="txt">的内容经选择公示后将公示于企业信用信息公示系统</span>
    </div>

    <div class="mod-bd">
        <div class="title">
            <h3>企业财务信息</h3>
            <div class="currency">币种：<strong class="light">人民币</strong></div>
            <p>以下信息请比照你企业${year}年度资产负债表、利润表等财务报表信息进行填写</p>
        </div>
        <div class="content mod-bd-panel">
            <table class="table-public table-caiwu" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td class="odd">
                        <div class="item-name">货币资金：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.moneFunds}" pattern="###,###,###,##0.00"/></div>

                    </td>
                    <td class="even">
                        <div class="item-name">应付账款：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.accPay}" pattern="###,###,###,##0.00"/></div>
                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="item-name">应收账款：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.accRec}" pattern="###,###,###,##0.00"/></div>
                    </td>
                    <td class="even">
                        <div class="item-name">其他应付款：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.othPay}" pattern="###,###,###,##0.00"/></div>
                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="item-name">其他应收款：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.othAccRec}" pattern="###,###,###,##0.00"/></div>
                    </td>
                    <td class="even">
                        <div class="item-name">流动负债合计：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.totCurrLiab}" pattern="###,###,###,##0.00"/></div>
                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="item-name">存货：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.inventory}" pattern="###,###,###,##0.00"/></div>
                    </td>
                    <td class="even">
                        <div class="item-name bg">负债总额：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.liaGro}" pattern="###,###,###,##0.00"/></div>
                        <span class="item-publicity light">${yrAsset.liaGroIsPub=='1'?'公示':'不公示'}</span>
                    </td>
                </tr>
                <tr>
                	<td class="odd">
                        <div class="item-name">流动资产合计：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.totCurrAssets}" pattern="###,###,###,##0.00"/></div>
                    </td>
                    <td class="odd">
                        <div class="item-name">实收资本：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.recCap}" pattern="###,###,###,##0.00"/></div>
                    </td>
                </tr>
                <tr>
                	<td class="odd">
                        <div class="item-name">长期投资：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.longInvest}" pattern="###,###,###,##0.00"/></div>
                    </td>
                    <td class="even">
                        <div class="item-name bg">所有者权益合计：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.totEqu}" pattern="###,###,###,##0.00"/></div>
                        <span class="item-publicity light">${yrAsset.totEquIsPub=='1'?'公示':'不公示'}</span>
                    </td>
                </tr>
                <tr>
                	<td class="odd">
                        <div class="item-name">固定资产：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.fixAssets}" pattern="###,###,###,##0.00"/></div>
                    </td>
                    <td class="even">
                        <span class="line"></span>
                        <div class="item-name bg">营业总收入：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.vendInc}" pattern="###,###,###,##0.00"/></div>
                        <span class="item-publicity light">${yrAsset.vendIncIsPub=='1'?'公示':'不公示'}</span>
                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="item-name">无形资产：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.intAssets}" pattern="###,###,###,##0.00"/></div>
                        <%-- <span class="item-publicity light">不公示</span>--%>
                    </td>
                    <td class="even">
                        <span class="line-portrait"></span>
                        <span class="item-name bg">
                            <span class="item-name-box">其中：主营业务收入：</span>
                        </span>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.maiBusInc}" pattern="###,###,###,##0.00"/></div>
                        <span class="item-publicity light">${yrAsset.maiBusIncIsPub=='1'?'公示':'不公示'}</span>
                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="item-name bg">资产总额：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.assGro}" pattern="###,###,###,##0.00"/></div>
                        <span class="item-publicity light">${yrAsset.assGroIsPub=='1'?'公示':'不公示'}</span>
                    </td>
                    <td class="even">
                        <div class="item-name bg">利润总额：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.proGro}" pattern="###,###,###,##0.00"/></div>
                        <span class="item-publicity light">${yrAsset.proGroIsPub=='1'?'公示':'不公示'}</span>
                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="item-name">${year}年出口创汇总额：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.expGro}" pattern="###,###,###,##0.00"/></div>
                        <%-- <span class="item-publicity">公示</span>--%>
                    </td>
                    <td class="even">
                        <div class="item-name bg">净利润：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.netInc}" pattern="###,###,###,##0.00"/></div>
                        <span class="item-publicity light">${yrAsset.netIncIsPub=='1'?'公示':'不公示'}</span>
                    </td>
                </tr>
                <tr>
                    <td class="even">
                        <div class="item-name special-h">
                            ${year}年研究开发、技术改造、科技创新等方面的支出：
                        </div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.intelGro}" pattern="###,###,###,##0.00"/></div>
                    </td>
                    <c:if test="${year>=2016}">
                    <td class="odd">

                        <div class="item-name bg">企业控股情况：</div>

                        <c:if test="${fn:indexOf(entTypeImpExtend,entType) == -1}">
                            <div class="item-txt">
                                ${yrAsset.entControl=='1'?'国有控股':''}
                                ${yrAsset.entControl=='2'?'集体控股':''}
                                ${yrAsset.entControl=='3'?'私人控股':''}
                                ${yrAsset.entControl=='4'?'港澳台商控股':''}
                                ${yrAsset.entControl=='5'?'外商控股':''}
                                ${yrAsset.entControl=='6'?'其他':''}
                            </div>
                        </c:if>

                        <c:if test="${fn:indexOf(entTypeImpExtend,entType) != -1}">
                            <div class="item-txt">${yrAsset.entControl=='7'?'私营企业':''}</div>
                        </c:if>

                        <span class="item-publicity light">${yrAsset.entControlIsPub=='1'?'公示':'不公示'}</span>
                    </td>
                    </c:if>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="item-name bg">企业当前的经营状态：</div>
                        <div class="item-txt">
                            ${yrAsset.busStatusCN}
                        </div>
                    </td>
                </tr>

               <c:if test="${!empty yrAsset.noBusRea}">
                <tr>
                    <td class="odd" colspan="2">
                        <div class="item-name" style="vertical-align: top;">无经营活动收入或歇业的原因：</div>
                        <div class="item-txt">
                            <textarea class="textarea" disabled>${yrAsset.noBusRea}</textarea>
                        </div>
                    </td>
                </tr>
               </c:if>

                <c:if test="${year>=2016}">
                    <tr>
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name bg" style="vertical-align: top;">企业主营业务活动：</div>
                            <div class="item-txt">
                                <textarea class="textarea" disabled>${ empty yrAsset.entMainBusActivity?'无':yrAsset.entMainBusActivity}</textarea>
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
                    <td class="odd">
                        <div class="item-name">${year}年从金融机构获得贷款总额：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.finOrgLoan}" pattern="###,###,###,##0.0000"/></div>
                        <strong class="light">万元</strong>
                    </td>
                    <td class="even">
                        <div class="item-name">${year}年从小额贷款公司等其他渠道融资总额：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.comLoan}" pattern="###,###,###,##0.0000"/></div>
                        <strong class="light">万元</strong>
                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="item-name">截止${year}年末，从金融机构获得的贷款余额：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.endLoan}" pattern="###,###,###,##0.0000"/></div>
                        <strong class="light">万元</strong>
                    </td>
                    <td class="even">
                        <div class="item-name">${year}年贷款利息支出总额：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.payLoan}" pattern="###,###,###,##0.0000"/></div>
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
                    <td class="odd">
                        <div class="item-name">增值税：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.addTax}" pattern="###,###,###,##0.00"/></div>
                    </td>
                    <td class="even">
                        <div class="item-name special">城市维护建设税：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.cityTax}" pattern="###,###,###,##0.00"/></div>
                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="item-name">营业税：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.mngTax}" pattern="###,###,###,##0.00"/></div>
                    </td>
                    <td class="even">
                        <div class="item-name special">印花税：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.floTax}" pattern="###,###,###,##0.00"/></div>
                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="item-name">消费税：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.expenseTax}" pattern="###,###,###,##0.00"/></div>
                    </td>
                    <td class="even">
                        <div class="item-name special">企业所得税：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.entTax}" pattern="###,###,###,##0.00"/></div>
                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="item-name">土地增值税：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.landTax}" pattern="###,###,###,##0.00"/></div>
                    </td>
                    <td class="even">
                        <div class="item-name special">个人所得税：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.personTax}" pattern="###,###,###,##0.00"/></div>
                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="item-name">关税：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.dutyTax}" pattern="###,###,###,##0.00"/></div>
                    </td>
                    <td class="even">
                        <div class="item-name special">房产税：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.houseTax}" pattern="###,###,###,##0.00"/></div>
                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="item-name">教育费附加：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.techTax}" pattern="###,###,###,##0.00"/></div>
                    </td>
                    <td class="even">
                        <div class="item-name special">城镇土地使用税：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.lanUseTax}" pattern="###,###,###,##0.00"/></div>
                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="item-name">水利基金：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.waterTax}" pattern="###,###,###,##0.00"/></div>
                    </td>
                    <td class="even">
                        <div class="item-name special">其他：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.otherTax}" pattern="###,###,###,##0.00"/></div>
                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="item-name bg">纳税总额：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.ratGro}" pattern="###,###,###,##0.00"/></div>
                        <span class="item-publicity light">${yrAsset.ratGroIsPub=='1'?'公示':'不公示'}</span>
                    </td>
                    <td class="even">
                        <div class="item-name special">${year}年是否享受小微企业减免残保金政策：</div>
                        <div class="item-txt">${yrAsset.isMinDis=='1'?'是':'否'}</div>
                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="item-name">${year}年减免国税：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.minNationTax}" pattern="###,###,###,##0.00"/></div>
                    </td>
                    <td class="even">
                        <div class="item-name special bg">${year}年是否依法交纳残保金：</div>
                        <div class="item-txt light">${yrAsset.isLegPay=='1'?'是':'否'}</div>

                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="item-name">${year}年减免地税：</div>
                        <div class="item-txt">¥ <fmt:formatNumber value="${yrAsset.minLandTax}" pattern="###,###,###,##0.00"/></div>
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
                    <td>
                        <div class="item-name bg">企业从业人员数：</div>
                        <div class="item-txt">${yrAsset.empNum} 人</div>
                        <span class="item-publicity light">${yrAsset.empNumDis=='1'?'公示':'不公示'}</span>
                    </td>
                </tr>
                <c:if test="${year>=2016}">
                <tr>
                    <td>
                        <div class="item-name bg">(其中女性从业人数)：</div>
                        <div class="item-txt">${yrAsset.femaleEmploye} 人</div>
                        <span class="item-publicity light">${yrAsset.femaleEmployeIsPub=='1'?'公示':'不公示'}</span>
                    </td>
                </tr>
                </c:if>

                <c:if test="${fn:indexOf(entTypeImpExtend,entType) != -1}">
                    <tr>
                        <td>
                            <div class="item-name">企业法定代表人是否属于：</div>
                            <div class="item-type">
                                <label><input type="radio" name="people" ${yrAsset.isLegRep=='1'?'checked':'disabled'}>高校毕业生</label>
                                <i class="icon-question"></i>
                            </div>
                            <div class="item-type disabled">
                                <label><input type="radio" name="people" ${yrAsset.isLegRep=='2'?'checked':'disabled'}>退役士兵</label>
                            </div>
                            <div class="item-type disabled">
                                <label><input type="radio" name="people" ${yrAsset.isLegRep=='3'?'checked':'disabled'}>残疾人</label>
                                <i class="icon-question"></i>
                            </div>
                            <div class="item-type disabled">
                                <label><input type="radio" name="people" ${yrAsset.isLegRep=='4'?'checked':'disabled'}>失业人员再就业</label>
                            </div>
                            <div class="item-type disabled">
                                <label><input type="radio" name="people"  ${yrAsset.isLegRep=='5'?'checked':'disabled'}>都不是</label>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="border-t-l">
                            <div class="item-name">从业人员中属于：</div>
                            <div class="item-type first">
                                <span class="people">高校毕业生</span>
                                <div class="item-txt">（${yrAsset.uniGradOpers}）人</div>
                            </div>
                            <div class="item-type second">
                                <span class="people">退役士兵</span>
                                <div class="item-txt">（${yrAsset.exSoldOpers}）人</div>
                            </div>
                            <div class="item-type third">
                                <span class="bg people">残疾人</span>
                                <div class="item-txt">（${yrAsset.disOpers}）人</div>
                            </div>
                            <div class="item-type four">
                                <span class="people">失业人员再就业</span>
                                <div class="item-txt">（${yrAsset.unemOpers}）人</div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="border-b-l">
                            <div class="item-name">从业人员中${year}年新雇佣：</div>
                            <div class="item-type first">
                                <span class="people">高校毕业生</span>
                                <div class="item-txt">（${yrAsset.uniGradEmps}）人</div>
                            </div>
                            <div class="item-type second">
                                <span class="people">退役士兵</span>
                                <div class="item-txt">（${yrAsset.exSoldEmps}）人</div>
                            </div>
                            <div class="item-type third">
                                <span class="people">残疾人</span>
                                <div class="item-txt">（${yrAsset.disEmps}）人</div>
                            </div>
                            <div class="item-type four">
                                <span class="people">失业人员再就业</span>
                                <div class="item-txt">（${yrAsset.unemEmps}）人</div>
                            </div>
                        </td>
                    </tr>

                </c:if>


                <c:if test="${fn:indexOf(entTypeImpExtend,entType) == -1}">
                    <tr>
                        <td>
                            <div class="item-type focus-state">
                                <span class="people" style="width: 170px;background-color: #8be1b1">从业人员中属于残疾人雇工人数</span>
                                <div class="item-txt">${yrAsset.disOpers}人</div>
                            </div>
                        </td>
                    </tr>
                </c:if>

                <tr>
                    <td>
                        <div class="item-name bg">企业应安置残疾人员数：</div>
                        <div class="item-txt">${yrAsset.entOugthSetDis}人</div>
                      <%--  <span class="item-publicity">公示</span>--%>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="item-name bg">企业已安置残疾人员数：</div>
                        <div class="item-txt">${yrAsset.entSetDis}人</div>
                        <%--<span class="item-publicity">公示</span>--%>
                    </td>
                </tr>
            </table>
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
                    <td class="odd">
                        <div class="item-name">${year}年水电费支出总额</div>
                        <div class="item-txt"> ¥ <fmt:formatNumber value="${yrAsset.waterFee}" pattern="###,###,###,##0.00"/></div>
                    </td>
                    <td class="even">
                        <div class="item-name">${year}年工资支出总额</div>
                        <div class="item-txt"> ¥ <fmt:formatNumber value="${yrAsset.salaryFee}" pattern="###,###,###,##0.00"/></div>
                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="item-name">${year}年房租(含物业费)支出总额</div>
                        <div class="item-txt"> ¥ <fmt:formatNumber value="${yrAsset.rentFee}" pattern="###,###,###,##0.00"/></div>
                    </td>
                    <td class="even">
                        <div class="item-name">${year}年五险一金支出总额</div>
                        <div class="item-txt"> ¥ <fmt:formatNumber value="${yrAsset.socFee}" pattern="###,###,###,##0.00"/></div>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>

<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/server/yr/entreportsearch/yrreport/assert_view.js"/>"></script>

</body>
</html>
