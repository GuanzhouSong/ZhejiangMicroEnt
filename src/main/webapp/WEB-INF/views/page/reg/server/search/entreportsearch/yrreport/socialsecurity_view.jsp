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


    <div class="mod caiwu">
        <div class="mod-hd">
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
                                参保人数
                            </th>
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
                                    <input type="text" id="endowmentNum" name="endowmentNum" value="${yrSocialSecurity.endowmentNum}" class="ipt-txt" readonly disabled />
                                </div>
                                人
                            </td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="paymentEndowment" value="${yrSocialSecurity.paymentEndowment}" class="ipt-txt one" readonly disabled />
                                </div>
                                <span class="light">万元</span>
                            </td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="actualPayEndowment" value="${yrSocialSecurity.actualPayEndowment}" class="ipt-txt two" readonly disabled />
                                </div>
                                <span class="light">万元</span>
                            </td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="cumuEndowment" value="${yrSocialSecurity.cumuEndowment}" class="ipt-txt three" readonly disabled />
                                </div>
                                <span class="light">万元</span>
                            </td>
                        </tr>
                        <tr>
                            <td>失业保险</td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="unemploymentNum" name="unemploymentNum" value="${yrSocialSecurity.unemploymentNum}" class="ipt-txt"  readonly disabled />
                                </div>
                                人
                            </td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="paymentUnemployment" value="${yrSocialSecurity.paymentUnemployment}" class="ipt-txt one"  readonly disabled />
                                </div>
                                <span class="light">万元</span>
                            </td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="actualPayUnemployment" value="${yrSocialSecurity.actualPayUnemployment}" class="ipt-txt two" readonly disabled />
                                </div>
                                <span class="light">万元</span>
                            </td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="cumuUnemployment" value="${yrSocialSecurity.cumuUnemployment}" class="ipt-txt three" readonly disabled />
                                </div>
                                <span class="light">万元</span>
                            </td>
                        </tr>
                        <tr>
                            <td>职工基本医疗保险</td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="medicalNum" name="medicalNum" value="${yrSocialSecurity.medicalNum}" class="ipt-txt" readonly disabled />
                                </div>
                                人
                            </td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="paymentMedical" value="${yrSocialSecurity.paymentMedical}" class="ipt-txt one"  readonly disabled />
                                </div>
                                <span class="light">万元</span>
                            </td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="actualPayMedical" value="${yrSocialSecurity.actualPayMedical}" class="ipt-txt two" readonly disabled />
                                </div>
                                <span class="light">万元</span>
                            </td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="cumuMedical" value="${yrSocialSecurity.cumuMedical}" class="ipt-txt three" readonly disabled />
                                </div>
                                <span class="light">万元</span>
                            </td>
                        </tr>
                        <tr>
                            <td>工伤保险</td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="empInjuryNum" name="empInjuryNum" value="${yrSocialSecurity.empInjuryNum}" class="ipt-txt " readonly disabled />
                                </div>
                                人
                            </td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="paymentEmpInjury" value="${yrSocialSecurity.paymentEmpInjury}" class="ipt-txt one" readonly disabled />
                                </div>
                                <span class="light">万元</span>
                            </td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="actualPayEmpInjury" value="${yrSocialSecurity.actualPayEmpInjury}" class="ipt-txt two"  readonly disabled/>
                                </div>
                                <span class="light">万元</span>
                            </td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="cumuEmpInjury" value="${yrSocialSecurity.cumuEmpInjury}" class="ipt-txt three" readonly disabled/>
                                </div>
                                <span class="light">万元</span>
                            </td>
                        </tr>
                        <tr>
                            <td>生育保险</td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="maternityNum" name="maternityNum" value="${yrSocialSecurity.maternityNum}" class="ipt-txt" readonly disabled />
                                </div>
                                人
                            </td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="paymentMaternity" value="${yrSocialSecurity.paymentMaternity}" class="ipt-txt one" readonly disabled/>
                                </div>
                                <span class="light">万元</span>
                            </td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="actualPayMaternity" value="${yrSocialSecurity.actualPayMaternity}" class="ipt-txt two" readonly disabled />
                                </div>
                                <span class="light">万元</span>
                            </td>
                            <td class="focus-state">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="cumuMaternity" value="${yrSocialSecurity.cumuMaternity}" class="ipt-txt three" readonly disabled/>
                                </div>
                                <span class="light">万元</span>
                            </td>
                        </tr>
                       <%--
                       <tr>
                            <td></td>
                            <td></td>
                            <td>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="_paymentBaseTotal" name="paymentBase" value="${yrSocialSecurity.paymentBase}" class="ipt-txt"  readonly disabled/>
                                </div>
                                <span class="light">万元</span>
                            </td>
                            <td>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="_cumulArrearsTotal" name="cumulArrears" value="${yrSocialSecurity.cumulArrears}" class="ipt-txt"  readonly disabled/>
                                </div>
                                <span class="light">万元</span>
                            </td>
                            <td>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="_actualPaymentTotal" name="actualPayment" value="${yrSocialSecurity.actualPayment}" class="ipt-txt"  readonly disabled/>
                                </div>
                                <span class="light">万元</span>
                            </td>
                        </tr>
                        --%>
                        <tr>
                            <td></td>
                            <td></td>
                            <td>
                                <div class="radio-box">
                                    <label><input type="radio" name="paymentBaseIsPub" value="1" readonly disabled ${yrSocialSecurity.paymentBaseIsPub=='1'?'checked':''}>公示</label>
                                    <label><input type="radio" name="paymentBaseIsPub" value="0" readonly disabled ${yrSocialSecurity.paymentBaseIsPub=='0'?'checked':''}>不公示</label>
                                </div>
                            </td>
                            <td>
                                <div class="radio-box">
                                    <label><input type="radio" name="cumulArrearsIsPub" value="1" readonly disabled ${yrSocialSecurity.cumulArrearsIsPub=='1'?'checked':''}>公示</label>
                                    <label><input type="radio" name="cumulArrearsIsPub" value="0" readonly disabled ${yrSocialSecurity.cumulArrearsIsPub=='0'?'checked':''}>不公示</label>
                                </div>
                            </td>
                            <td>
                                <div class="radio-box">
                                    <label><input type="radio" name="actualPaymentIsPub" value="1" readonly disabled ${yrSocialSecurity.actualPaymentIsPub=='1'?'checked':''}>公示</label>
                                    <label><input type="radio" name="actualPaymentIsPub" value="0" readonly disabled ${yrSocialSecurity.actualPaymentIsPub=='0'?'checked':''}>不公示</label>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

</body>
</html>