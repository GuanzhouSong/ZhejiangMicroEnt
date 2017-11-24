<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>社保信息</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>

<!-- 头部  start-->
<jsp:include page="../../common/reportheader.jsp"></jsp:include>


<div class="fold-msg-bg js-fold-msg">
    <jsp:include page="../template/view_template.jsp"></jsp:include>
</div>
<!-- 头部  end-->
<input type="hidden" id="_reportState" value="${yrRegCheck.reportState}">  <%--当前年报的状态：--%>
<input type="hidden" id="_year"  value="${year}" />
<input type="hidden" id="priPID" value="${priPID}"/>

<form class="form-horizontal error-bottom" id="socialsecurityForm">

    <input type="hidden" name="anCheID" value="${anCheID}">
    <input type="hidden" name="priPID" value="${priPID}">
    <input type="hidden" name="year" value="${year}">
    <input type="hidden" name="socialID" value="${yrSocialSecurity.socialID}">
    <input type="hidden" name="uniCode"  value="${!empty yrSocialSecurity.uniCode?yrSocialSecurity.uniCode:midBaseInfoDto.uniCode}">
    <input type="hidden" name="regNO"    value="${!empty yrSocialSecurity.regNO?yrSocialSecurity.regNO:midBaseInfoDto.regNO}">
    <input type="hidden" name="entName"  value="${!empty yrSocialSecurity.entName?yrSocialSecurity.entName:midBaseInfoDto.entName}">


    <div class="mod caiwu">
        <div class="mod-hd">
            <div class="mod-hd" >
                <jsp:include page="../template/tab_template.jsp"></jsp:include>
            </div>
            <div class="title">
                <h3>企业社保信息</h3>
                <div class="currency">币种：<strong class="light">人民币</strong></div>
            </div>
        </div>
        <div class="mod-bd">
            <div class="content mod-bd-panel">
                <%--<div class="con-title">参保险种及对应人数</div>--%>
                <div class="w-960">
                    <table class="table-public table-public2" border="0" cellspacing="0" cellpadding="0">
                        <thead>
                        <tr>
                            <th width="168">参保险种</th>
                            <th width="210">
                                <i class="icon-question" id="canbaoTotal" data-id="canbaoTotal" data-msg="指报告期末参加社会保险的职工人数（不含离退休人数）。即企业上年度年末参保人数，非平均人数。"></i>
                                参保人数
                            </th>
                            <th width="210">
                                <i class="icon-question" id="danweijiaofei" data-id="danweijiaofei" data-msg="指报告期内单位缴纳社会保险费的工资总额，按缴费人员的应缴口径计算。即企业上年度全年1至12月每月工资总额累计数。"></i>
                                单位缴费基数
                            </th>
                            <th width="210">
                                <i class="icon-question" id="benqishijiao" data-id="benqishijiao" data-msg="指报告期内单位实际缴纳的社会保险费，不包括补缴欠费和跨年度（或跨季度）的预缴金额。即企业上年度全年1至12月每月实际缴纳社会保险费累计数，不含个人缴纳部分。"></i>
                                本期实际缴费金额
                            </th>
                            <th>
                                <i class="icon-question" id="dangweiqianjiao" data-id="dangweiqianjiao" data-msg="指截至报告期末单位累计欠缴各项社会保险费金额（本金）。"></i>
                                单位累计欠缴金额
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>城镇职工基本养老保险</td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="endowmentNum" name="endowmentNum" value="${yrSocialSecurity.endowmentNum}" class="ipt-txt" placeholder="" />
                                    <i class="icon-close"></i>
                                </div>
                                人
                            </td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="paymentEndowment" value="${yrSocialSecurity.paymentEndowment}" class="ipt-txt one" placeholder="请输入金额" />
                                    <i class="icon-close"></i>
                                </div>
                                <span class="light">万元</span>
                            </td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="actualPayEndowment" value="${yrSocialSecurity.actualPayEndowment}" class="ipt-txt two" placeholder="请输入金额" />
                                    <i class="icon-close"></i>
                                </div>
                                <span class="light">万元</span>
                            </td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="cumuEndowment" value="${yrSocialSecurity.cumuEndowment}" class="ipt-txt three" placeholder="请输入金额" />
                                    <i class="icon-close"></i>
                                </div>
                                <span class="light">万元</span>
                            </td>
                        </tr>
                        <tr>
                            <td>失业保险</td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="unemploymentNum" name="unemploymentNum" value="${yrSocialSecurity.unemploymentNum}" class="ipt-txt" placeholder="" />
                                    <i class="icon-close"></i>
                                </div>
                                人
                            </td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="paymentUnemployment" value="${yrSocialSecurity.paymentUnemployment}" class="ipt-txt one" placeholder="请输入金额" />
                                    <i class="icon-close"></i>
                                </div>
                                <span class="light">万元</span>
                            </td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="actualPayUnemployment" value="${yrSocialSecurity.actualPayUnemployment}" class="ipt-txt two" placeholder="请输入金额" />
                                    <i class="icon-close"></i>
                                </div>
                                <span class="light">万元</span>
                            </td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="cumuUnemployment" value="${yrSocialSecurity.cumuUnemployment}" class="ipt-txt three" placeholder="请输入金额" />
                                    <i class="icon-close"></i>
                                </div>
                                <span class="light">万元</span>
                            </td>
                        </tr>
                        <tr>
                            <td>职工基本医疗保险</td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="medicalNum" name="medicalNum" value="${yrSocialSecurity.medicalNum}" class="ipt-txt" placeholder="" />
                                    <i class="icon-close"></i>
                                </div>
                                人
                            </td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="paymentMedical" value="${yrSocialSecurity.paymentMedical}" class="ipt-txt one" placeholder="请输入金额" />
                                    <i class="icon-close"></i>
                                </div>
                                <span class="light">万元</span>
                            </td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="actualPayMedical" value="${yrSocialSecurity.actualPayMedical}" class="ipt-txt two" placeholder="请输入金额" />
                                    <i class="icon-close"></i>
                                </div>
                                <span class="light">万元</span>
                            </td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="cumuMedical" value="${yrSocialSecurity.cumuMedical}" class="ipt-txt three" placeholder="请输入金额" />
                                    <i class="icon-close"></i>
                                </div>
                                <span class="light">万元</span>
                            </td>
                        </tr>
                        <tr>
                            <td>工伤保险</td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="empInjuryNum" name="empInjuryNum" value="${yrSocialSecurity.empInjuryNum}" class="ipt-txt " placeholder="" />
                                    <i class="icon-close"></i>
                                </div>
                                人
                            </td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="paymentEmpInjury" value="${yrSocialSecurity.paymentEmpInjury}" class="ipt-txt one" placeholder="请输入金额" />
                                    <i class="icon-close"></i>
                                </div>
                                <span class="light">万元</span>
                            </td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="actualPayEmpInjury" value="${yrSocialSecurity.actualPayEmpInjury}" class="ipt-txt two" placeholder="请输入金额" />
                                    <i class="icon-close"></i>
                                </div>
                                <span class="light">万元</span>
                            </td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="cumuEmpInjury" value="${yrSocialSecurity.cumuEmpInjury}" class="ipt-txt three" placeholder="请输入金额" />
                                    <i class="icon-close"></i>
                                </div>
                                <span class="light">万元</span>
                            </td>
                        </tr>
                        <tr>
                            <td>生育保险</td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="maternityNum" name="maternityNum" value="${yrSocialSecurity.maternityNum}" class="ipt-txt" placeholder="" />
                                    <i class="icon-close"></i>
                                </div>
                                人
                            </td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="paymentMaternity" value="${yrSocialSecurity.paymentMaternity}" class="ipt-txt one" placeholder="请输入金额" />
                                    <i class="icon-close"></i>
                                </div>
                                <span class="light">万元</span>
                            </td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="actualPayMaternity" value="${yrSocialSecurity.actualPayMaternity}" class="ipt-txt two" placeholder="请输入金额" />
                                    <i class="icon-close"></i>
                                </div>
                                <span class="light">万元</span>
                            </td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="cumuMaternity" value="${yrSocialSecurity.cumuMaternity}" class="ipt-txt three" placeholder="请输入金额" />
                                    <i class="icon-close"></i>
                                </div>
                                <span class="light">万元</span>
                            </td>
                        </tr>

                       <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                           <%-- <td>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="_paymentBaseTotal" name="paymentBase" value="${yrSocialSecurity.paymentBase}" class="ipt-txt" placeholder="" readonly />
                                </div>
                                <span class="light">万元</span>
                            </td>--%>
                            <td>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="_actualPaymentTotal" name="actualPayment" value="${yrSocialSecurity.actualPayment}" class="ipt-txt" placeholder="" readonly />
                                </div>
                                <span class="light">万元</span>
                            </td>
                            <td>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="_cumulArrearsTotal" name="cumulArrears" value="${yrSocialSecurity.cumulArrears}" class="ipt-txt" placeholder="" readonly />
                                </div>
                                <span class="light">万元</span>
                            </td>
                        </tr>

                        <tr>
                            <td></td>
                            <td></td>
                            <td>
                                <div class="radio-box">
                                    <label><input type="radio" name="paymentBaseIsPub" value="1" ${yrSocialSecurity.paymentBaseIsPub=='1'?'checked':''}>公示</label>
                                    <label><input type="radio" name="paymentBaseIsPub" value="0" ${yrSocialSecurity.paymentBaseIsPub=='0'?'checked':''}>不公示</label>
                                </div>
                            </td>
                            <td>
                                <div class="radio-box">
                                    <label><input type="radio" name="actualPaymentIsPub" value="1" ${yrSocialSecurity.actualPaymentIsPub=='1'?'checked':''}>公示</label>
                                    <label><input type="radio" name="actualPaymentIsPub" value="0" ${yrSocialSecurity.actualPaymentIsPub=='0'?'checked':''}>不公示</label>
                                </div>
                            </td>
                            <td>
                                <div class="radio-box">
                                    <label><input type="radio" name="cumulArrearsIsPub" value="1" ${yrSocialSecurity.cumulArrearsIsPub=='1'?'checked':''}>公示</label>
                                    <label><input type="radio" name="cumulArrearsIsPub" value="0" ${yrSocialSecurity.cumulArrearsIsPub=='0'?'checked':''}>不公示</label>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <div class="btn-box">
        <button  type="submit" class="btn-common btn-save js-save">保存</button>
    </div>
</form>

<%--企业从业人数--%>
<input type="hidden" id="_empNum" value="${empNum}"/>

<jsp:include page="../../common/footer.jsp"></jsp:include>

<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/client/yr/socialsecurity/edit_main.js"/>"></script>

</body>
</html>