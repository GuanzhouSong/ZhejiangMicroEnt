<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>农专社资产负债表页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>

<!-- 头部  start-->
<jsp:include page="../../common/header.jsp"></jsp:include>

<%--移入的tab标签栏--%>
<jsp:include page="../template/sfc_template.jsp"></jsp:include>


<input type="hidden" id="lastYearData" value="${!empty lastYearData?'1':'0'}"> <%--上一年度 的年末对象值--%>
<form class="form-horizontal error-bottom" id="sfcassetliaForm">
    <div class="mod">
        <div class="mod-bd">
            <div class="title">
                <h3>资产负债表</h3>
            </div>
            <c:if test="${yrRegCheck.declStatus=='0'||yrRegCheck.declStatus=='3'}">
                <div class="btn-box">
                    <input type="button" value="读取上年度数据" class="btn-common  js-lastYearData" style="width: 120px;">
                    <input type="button" value="调账" class="btn-common js-editData " disabled="disabled" readonly="readonly">
                    <p style="font-weight: bold;font-size: 14px;color: red">
                        提示：报表年初数可通过<em style="color: green">【读取上年度数据】</em>获取。如遇本社实际年初数与上一年度申报数据不一致时，请点击<em style="color: green">【调帐】</em>功能进行修改。
                    </p>
                </div>
            </c:if>

            <div class="content clearfix">
                <p style="font-weight: bold;font-size:12px;text-align: right;margin-right: 32px;">单位: <strong class="light">元</strong></p>
                <div class="sfcassetlia-l">
                    <table class="table-public table-web table-fix">
                        <thead>
                        <tr class="focus-state">
                            <th width="160">资产</th>
                            <th width="40">行次</th>
                            <th width="130">年初数</th>
                            <th>年末数</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr class="focus-state">
                            <td colspan="4" class="column-l">
                                <strong class="light">流动资产:</strong>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="column-r">货币资金</td>
                            <td>1</td>
                            <td>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text"  id="yearstart1" name="sfcBalanctsheetList[0].moneFunds" value="${empty sfcBalanctsheetList[0].moneFunds?"0.00":sfcBalanctsheetList[0].moneFunds}" class="ipt-txt  units required"  placeholder="请输入金额" data-yeardata="${lastYearData.moneFunds}"/>
                                    <i class="icon-close"></i>
                                    <input type="hidden"   name="sfcBalanctsheetList[0].id"          value="${sfcBalanctsheetList[0].id}"  />
                                    <input type="hidden"   name="sfcBalanctsheetList[0].uid"         value="${sfcBalanctsheetList[0].uid}"  />
                                    <input type="hidden"   name="sfcBalanctsheetList[0].balanceType" value="0" />
                                    <input type="hidden"   name="sfcBalanctsheetList[0].year"        value="${year}"  />
                                    <input type="hidden"   name="sfcBalanctsheetList[0].priPID"      value="${priPID}"   />

                                </div>
                            </td>
                            <td>
                                  <div class="ipt-box  js-ipt-box">
                                      <input type="text"  id="yearend1" name="sfcBalanctsheetList[1].moneFunds" value="${empty sfcBalanctsheetList[1].moneFunds?"0.00":sfcBalanctsheetList[1].moneFunds}" class="ipt-txt units required" placeholder="请输入金额"/>
                                      <input type="hidden"   name="sfcBalanctsheetList[1].id"          value="${sfcBalanctsheetList[1].id}"  />
                                      <input type="hidden"   name="sfcBalanctsheetList[1].uid"         value="${sfcBalanctsheetList[1].uid}" />
                                      <input type="hidden"   name="sfcBalanctsheetList[1].balanceType" value="1" />
                                      <input type="hidden"   name="sfcBalanctsheetList[1].year"        value="${year}"  />
                                      <input type="hidden"   name="sfcBalanctsheetList[1].priPID"      value="${priPID}"  />
                                      <i class="icon-close"></i>
                                  </div>
                              </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="column-r">应收款项</td>
                            <td>5</td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearstart5" name="sfcBalanctsheetList[0].accRec" value="${empty sfcBalanctsheetList[0].accRec?"0.00":sfcBalanctsheetList[0].accRec}" class="ipt-txt units required"   placeholder="请输入金额" data-yeardata="${lastYearData.accRec}"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearend5" name="sfcBalanctsheetList[1].accRec" value="${empty sfcBalanctsheetList[1].accRec?"0.00":sfcBalanctsheetList[1].accRec}" class="ipt-txt units required"  placeholder="请输入金额"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="column-r">存货</td>
                            <td>6</td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearstart6" name="sfcBalanctsheetList[0].inventory" value="${empty sfcBalanctsheetList[1].inventory?"0.00":sfcBalanctsheetList[0].inventory}" class="ipt-txt units required  " placeholder="请输入金额" data-yeardata="${lastYearData.inventory}"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearend6" name="sfcBalanctsheetList[1].inventory" value="${empty sfcBalanctsheetList[1].inventory?"0.00":sfcBalanctsheetList[1].inventory}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="light column-r">流动资产合计</td>
                            <td>10</td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearstart10" name="sfcBalanctsheetList[0].totCurrAssets" value="${empty sfcBalanctsheetList[0].totCurrAssets?"0.00":sfcBalanctsheetList[0].totCurrAssets}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" readonly data-yeardata="${lastYearData.totCurrAssets}" />
                                </div>
                            </td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearend10" name="sfcBalanctsheetList[1].totCurrAssets" value="${empty sfcBalanctsheetList[1].totCurrAssets?"0.00":sfcBalanctsheetList[1].totCurrAssets}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" readonly/>
                                </div>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td colspan="4" class="column-l">
                                <strong class="light">长期资产:</strong>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="column-r">对外投资：</td>
                            <td>11</td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearstart11" name="sfcBalanctsheetList[0].forInvestAssets" value="${empty sfcBalanctsheetList[0].forInvestAssets?"0.00":sfcBalanctsheetList[0].forInvestAssets}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" data-yeardata="${lastYearData.forInvestAssets}"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearend11" name="sfcBalanctsheetList[1].forInvestAssets" value="${empty sfcBalanctsheetList[1].forInvestAssets?"0.00":sfcBalanctsheetList[1].forInvestAssets}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td colspan="4" class="column-l">
                                <strong class="light">农业资产:</strong>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="column-r">农畜(禽)资产</td>
                            <td>12</td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearstart12" name="sfcBalanctsheetList[0].liveStockAssets" value ="${empty sfcBalanctsheetList[0].liveStockAssets?"0.00":sfcBalanctsheetList[0].liveStockAssets}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" data-yeardata="${lastYearData.liveStockAssets}"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearend12" name="sfcBalanctsheetList[1].liveStockAssets" value ="${empty sfcBalanctsheetList[1].liveStockAssets?"0.00":sfcBalanctsheetList[1].liveStockAssets}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="column-r">林木资产</td>
                            <td>13</td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearstart13" name="sfcBalanctsheetList[0].treeAssets" value ="${empty sfcBalanctsheetList[0].treeAssets?"0.00":sfcBalanctsheetList[0].treeAssets}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" data-yeardata="${lastYearData.treeAssets}"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearend13" name="sfcBalanctsheetList[1].treeAssets" value ="${empty sfcBalanctsheetList[1].treeAssets?"0.00":sfcBalanctsheetList[1].treeAssets}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="column-r light">农业资产合计</td>
                            <td>15</td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearstart15" name="sfcBalanctsheetList[0].argAssetsAmount" value ="${empty sfcBalanctsheetList[0].argAssetsAmount?"0.00":sfcBalanctsheetList[0].argAssetsAmount}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" readonly data-yeardata="${lastYearData.argAssetsAmount}" />
                                </div>
                            </td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearend15" name="sfcBalanctsheetList[1].argAssetsAmount" value ="${empty sfcBalanctsheetList[1].argAssetsAmount?"0.00":sfcBalanctsheetList[1].argAssetsAmount}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" readonly/>
                                </div>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td colspan="4" class="column-l">
                                <strong class="light">固定资产:</strong>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="column-r">固定资产原值</td>
                            <td>16</td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearstart16" name="sfcBalanctsheetList[0].fixAssetsOri" value ="${empty sfcBalanctsheetList[0].fixAssetsOri?"0.00":sfcBalanctsheetList[0].fixAssetsOri}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" data-yeardata="${lastYearData.fixAssetsOri}"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearend16" name="sfcBalanctsheetList[1].fixAssetsOri" value ="${empty sfcBalanctsheetList[1].fixAssetsOri?"0.00":sfcBalanctsheetList[1].fixAssetsOri}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="column-r">减：累计折旧</td>
                            <td>17</td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearstart17" name="sfcBalanctsheetList[0].accDepreciation" value ="${empty sfcBalanctsheetList[0].accDepreciation?"0.00":sfcBalanctsheetList[0].accDepreciation}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" data-yeardata="${lastYearData.accDepreciation}"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearend17" name="sfcBalanctsheetList[1].accDepreciation" value ="${empty sfcBalanctsheetList[1].accDepreciation?"0.00":sfcBalanctsheetList[1].accDepreciation}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" />
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="column-r">固定资产净值</td>
                            <td>20</td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearstart20" name="sfcBalanctsheetList[0].fixAssetsWorth" value ="${empty sfcBalanctsheetList[0].fixAssetsWorth?"0.00":sfcBalanctsheetList[0].fixAssetsWorth}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" readonly data-yeardata="${lastYearData.fixAssetsWorth}"  />
                                </div>
                            </td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearend20" name="sfcBalanctsheetList[1].fixAssetsWorth" value ="${empty sfcBalanctsheetList[1].fixAssetsWorth?"0.00":sfcBalanctsheetList[1].fixAssetsWorth}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" readonly/>
                                </div>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="column-r">固定资产清理</td>
                            <td>21</td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearstart21" name="sfcBalanctsheetList[0].fixAssetsClean" value ="${empty sfcBalanctsheetList[0].fixAssetsClean?"0.00":sfcBalanctsheetList[0].fixAssetsClean}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" data-yeardata="${lastYearData.fixAssetsClean}"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearend21" name="sfcBalanctsheetList[1].fixAssetsClean" value ="${empty sfcBalanctsheetList[1].fixAssetsClean?"0.00":sfcBalanctsheetList[1].fixAssetsClean}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="column-r">在建工程</td>
                            <td>22</td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearstart22" name="sfcBalanctsheetList[0].proConstr" value ="${empty sfcBalanctsheetList[0].proConstr?"0.00":sfcBalanctsheetList[0].proConstr}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" data-yeardata="${lastYearData.proConstr}"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                            <td>
                                <div class="ipt-box  js-ipt-box ">
                                    <input type="text"  id="yearend22" name="sfcBalanctsheetList[1].proConstr" value ="${empty sfcBalanctsheetList[1].proConstr?"0.00":sfcBalanctsheetList[1].proConstr}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="column-r">固定资产合计</td>
                            <td>25</td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearstart25" name="sfcBalanctsheetList[0].fixAssetsAmount" value ="${empty sfcBalanctsheetList[0].fixAssetsAmount?"0.00":sfcBalanctsheetList[0].fixAssetsAmount}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" readonly data-yeardata="${lastYearData.fixAssetsAmount}"/>
                                </div>
                            </td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearend25" name="sfcBalanctsheetList[1].fixAssetsAmount" value ="${empty sfcBalanctsheetList[1].fixAssetsAmount?"0.00":sfcBalanctsheetList[1].fixAssetsAmount}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" readonly/>
                                </div>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td colspan="4" class="column-l">
                                <strong class="light">其他资产:</strong>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="column-r">无形资产</td>
                            <td>27</td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearstart27" name="sfcBalanctsheetList[0].intAssets" value ="${empty sfcBalanctsheetList[0].intAssets?"0.00":sfcBalanctsheetList[0].intAssets}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" data-yeardata="${lastYearData.intAssets}"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearend27" name="sfcBalanctsheetList[1].intAssets" value ="${empty sfcBalanctsheetList[1].intAssets?"0.00":sfcBalanctsheetList[1].intAssets}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="column-r light">长期资产合计</td>
                            <td>28</td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearstart28" name="sfcBalanctsheetList[0].longAssetsAmount" value ="${empty sfcBalanctsheetList[0].longAssetsAmount?"0.00":sfcBalanctsheetList[0].longAssetsAmount}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" readonly data-yeardata="${lastYearData.longAssetsAmount}"/>
                                </div>
                            </td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearend28" name="sfcBalanctsheetList[1].longAssetsAmount" value ="${empty sfcBalanctsheetList[1].longAssetsAmount?"0.00":sfcBalanctsheetList[1].longAssetsAmount}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" readonly/>
                                </div>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="column-r light">资产总计</td>
                            <td>29</td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearstart29" name="sfcBalanctsheetList[0].assGro" value ="${empty sfcBalanctsheetList[0].assGro?"0.00":sfcBalanctsheetList[0].assGro}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" readonly data-yeardata="${lastYearData.assGro}"/>
                                </div>
                            </td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearend29" name="sfcBalanctsheetList[1].assGro" value ="${empty sfcBalanctsheetList[1].assGro?"0.00":sfcBalanctsheetList[1].assGro}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" readonly/>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="sfcassetlia-r">
                    <table class="table-public table-web table-fix">
                        <thead>
                        <tr class="focus-state">
                            <th width="160">负债和所有者权益</th>
                            <th width="40">行次</th>
                            <th width="130">年初数</th>
                            <th>年末数</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr class="focus-state">
                            <td colspan="4" class="column-l">
                                <strong class="light">流动负债:</strong>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="column-r">短期借款</td>
                            <td>30</td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearstart30" name="sfcBalanctsheetList[0].shortBorrowing" value ="${empty sfcBalanctsheetList[0].shortBorrowing?"0.00":sfcBalanctsheetList[0].shortBorrowing}" class="ipt-txt units required " maxlength="16"  placeholder="请输入金额" data-yeardata="${lastYearData.shortBorrowing}"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearend30" name="sfcBalanctsheetList[1].shortBorrowing" value ="${empty sfcBalanctsheetList[1].shortBorrowing?"0.00":sfcBalanctsheetList[1].shortBorrowing}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="column-r">应付款项</td>
                            <td>31</td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearstart31" name="sfcBalanctsheetList[0].accPay" value ="${empty sfcBalanctsheetList[0].accPay?"0.00":sfcBalanctsheetList[0].accPay}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" data-yeardata="${lastYearData.accPay}"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearend31" name="sfcBalanctsheetList[1].accPay" value ="${empty sfcBalanctsheetList[1].accPay?"0.00":sfcBalanctsheetList[1].accPay}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="column-r">应付工资</td>
                            <td>32</td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearstart32" name="sfcBalanctsheetList[0].wagePay" value ="${empty sfcBalanctsheetList[0].wagePay?"0.00":sfcBalanctsheetList[0].wagePay}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" data-yeardata="${lastYearData.wagePay}"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearend32" name="sfcBalanctsheetList[1].wagePay" value ="${empty sfcBalanctsheetList[1].wagePay?"0.00":sfcBalanctsheetList[1].wagePay}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="column-r">应付盈余返还</td>
                            <td>33</td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearstart33" name="sfcBalanctsheetList[0].returnSurplusPay" value ="${empty sfcBalanctsheetList[0].returnSurplusPay?"0.00":sfcBalanctsheetList[0].returnSurplusPay}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" data-yeardata="${lastYearData.returnSurplusPay}"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearend33" name="sfcBalanctsheetList[1].returnSurplusPay" value ="${empty sfcBalanctsheetList[1].returnSurplusPay?"0.00":sfcBalanctsheetList[1].returnSurplusPay}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="column-r">应付剩余盈余</td>
                            <td>35</td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearstart35" name="sfcBalanctsheetList[0].remainSurplusPay" value ="${empty sfcBalanctsheetList[0].remainSurplusPay?"0.00":sfcBalanctsheetList[0].remainSurplusPay}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" data-yeardata="${lastYearData.remainSurplusPay}"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearend35" name="sfcBalanctsheetList[1].remainSurplusPay" value ="${empty sfcBalanctsheetList[1].remainSurplusPay?"0.00":sfcBalanctsheetList[1].remainSurplusPay}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="light column-r">流动负债合计</td>
                            <td>36</td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearstart36" name="sfcBalanctsheetList[0].totCurrLiab" value ="${empty sfcBalanctsheetList[0].totCurrLiab?"0.00":sfcBalanctsheetList[0].totCurrLiab}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" readonly data-yeardata="${lastYearData.totCurrLiab}"/>
                                </div>
                            </td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearend36" name="sfcBalanctsheetList[1].totCurrLiab" value ="${empty sfcBalanctsheetList[1].totCurrLiab?"0.00":sfcBalanctsheetList[1].totCurrLiab}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" readonly/>
                                </div>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td colspan="4" class="column-l">
                                <strong class="light">长期负债:</strong>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="column-r">长期借款</td>
                            <td>40</td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearstart40" name="sfcBalanctsheetList[0].longBorrowing" value ="${empty sfcBalanctsheetList[0].longBorrowing?"0.00":sfcBalanctsheetList[0].longBorrowing}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" data-yeardata="${lastYearData.longBorrowing}"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearend40" name="sfcBalanctsheetList[1].longBorrowing" value ="${empty sfcBalanctsheetList[1].longBorrowing?"0.00":sfcBalanctsheetList[1].longBorrowing}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="column-r">专项应付款</td>
                            <td>41</td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearstart41" name="sfcBalanctsheetList[0].specificPay" value ="${empty sfcBalanctsheetList[0].specificPay?"0.00":sfcBalanctsheetList[0].specificPay}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" data-yeardata="${lastYearData.specificPay}"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearend41" name="sfcBalanctsheetList[1].specificPay" value ="${empty sfcBalanctsheetList[1].specificPay?"0.00":sfcBalanctsheetList[1].specificPay}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="column-r light">长期负债合计</td>
                            <td>42</td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearstart42" name="sfcBalanctsheetList[0].LTermLiaAm" value ="${empty sfcBalanctsheetList[0].LTermLiaAm?"0.00":sfcBalanctsheetList[0].LTermLiaAm}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" readonly data-yeardata="${lastYearData.LTermLiaAm}"/>
                                </div>
                            </td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearend42" name="sfcBalanctsheetList[1].LTermLiaAm" value ="${empty sfcBalanctsheetList[1].LTermLiaAm?"0.00":sfcBalanctsheetList[1].LTermLiaAm}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" readonly/>
                                </div>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="column-r light">负债合计</td>
                            <td>43</td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearstart43" name="sfcBalanctsheetList[0].liaGro" value ="${empty sfcBalanctsheetList[0].liaGro?"0.00":sfcBalanctsheetList[0].liaGro}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" readonly data-yeardata="${lastYearData.liaGro}"/>
                                </div>
                            </td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearend43" name="sfcBalanctsheetList[1].liaGro" value ="${empty sfcBalanctsheetList[1].liaGro?"0.00":sfcBalanctsheetList[1].liaGro}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" readonly/>
                                </div>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td colspan="4" class="column-l">
                                <strong class="light">所有者权益:</strong>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="column-r">股金</td>
                            <td>44</td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearstart44" name="sfcBalanctsheetList[0].capitalAmount" value ="${empty sfcBalanctsheetList[0].capitalAmount?"0.00":sfcBalanctsheetList[0].capitalAmount}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" data-yeardata="${lastYearData.capitalAmount}"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearend44" name="sfcBalanctsheetList[1].capitalAmount" value ="${empty sfcBalanctsheetList[1].capitalAmount?"0.00":sfcBalanctsheetList[1].capitalAmount}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="column-r">专项基金</td>
                            <td>45</td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearstart45" name="sfcBalanctsheetList[0].specificFund" value ="${empty sfcBalanctsheetList[0].specificFund?"0.00":sfcBalanctsheetList[0].specificFund}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" data-yeardata="${lastYearData.specificFund}"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearend45" name="sfcBalanctsheetList[1].specificFund" value ="${empty sfcBalanctsheetList[1].specificFund?"0.00":sfcBalanctsheetList[1].specificFund}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="column-r">资本公积</td>
                            <td>46</td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearstart46" name="sfcBalanctsheetList[0].capAccuFund" value ="${empty sfcBalanctsheetList[0].capAccuFund?"0.00":sfcBalanctsheetList[0].capAccuFund}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" data-yeardata="${lastYearData.capAccuFund}"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearend46" name="sfcBalanctsheetList[1].capAccuFund" value ="${empty sfcBalanctsheetList[1].capAccuFund?"0.00":sfcBalanctsheetList[1].capAccuFund}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="column-r">盈余公积</td>
                            <td>47</td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearstart47" name="sfcBalanctsheetList[0].surAccuFund" value ="${empty sfcBalanctsheetList[0].surAccuFund?"0.00":sfcBalanctsheetList[0].surAccuFund}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" data-yeardata="${lastYearData.surAccuFund}"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearend47" name="sfcBalanctsheetList[1].surAccuFund" value ="${empty sfcBalanctsheetList[1].surAccuFund?"0.00":sfcBalanctsheetList[1].surAccuFund}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额">
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="column-r">未分配盈余</td>
                            <td>50</td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearstart50" name="sfcBalanctsheetList[0].undistSurplus" value ="${empty sfcBalanctsheetList[0].undistSurplus?"0.00":sfcBalanctsheetList[0].undistSurplus}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" data-yeardata="${lastYearData.undistSurplus}"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearend50" name="sfcBalanctsheetList[1].undistSurplus" value ="${empty sfcBalanctsheetList[1].undistSurplus?"0.00":sfcBalanctsheetList[1].undistSurplus}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额"/>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="column-r light">所有者权益合计</td>
                            <td>51</td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearstart51" name="sfcBalanctsheetList[0].totEqu" value ="${empty sfcBalanctsheetList[0].totEqu?"0.00":sfcBalanctsheetList[0].totEqu}" class="ipt-txt units required" placeholder="请输入金额" readonly data-yeardata="${lastYearData.totEqu}"/>
                                </div>
                            </td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearend51" name="sfcBalanctsheetList[1].totEqu" value ="${empty sfcBalanctsheetList[1].totEqu?"0.00":sfcBalanctsheetList[1].totEqu}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" readonly/>
                                </div>
                            </td>
                        </tr>
                        <tr class="focus-state">
                            <td class="column-r light">负债和所有者权益总计</td>
                            <td>54</td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearstart54" name="sfcBalanctsheetList[0].totLiaEqu" value ="${empty sfcBalanctsheetList[0].totLiaEqu?"0.00":sfcBalanctsheetList[0].totLiaEqu}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" readonly data-yeardata="${lastYearData.totLiaEqu}"/>
                                </div>
                            </td>
                            <td>
                                <div class="ipt-box  js-ipt-box">
                                    <input type="text"  id="yearend54" name="sfcBalanctsheetList[1].totLiaEqu" value ="${empty sfcBalanctsheetList[1].totLiaEqu?"0.00":sfcBalanctsheetList[1].totLiaEqu}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额" readonly/>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <div class="mod mod-border ${!empty sfcBalanctsheetList[0].remark?'':'js-content-show'}  js-remark-ui"> <%----%>
        <div class="mod-hd">
            <div class="title">
                <h3>调账说明：</h3>
            </div>
        </div>

        <div class="mod-bd">
            <table class="table-public table-web table-fix">
                <thead>
                </thead>
                <tbody>
                <tr class="focus-state">
                    <td>
                        <div class="ipt-box  js-ipt-box">
                            <input type="text" id="_remark" name="sfcBalanctsheetList[0].remark" value ="${sfcBalanctsheetList[0].remark}" class="ipt-txt" placeholder="请输入调账原因" readonly style="text-align: left;height: 46px;margin: 3px 0;">
                           <%-- <i class="icon-close"></i>--%>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

    <div class="mod mod-border">
        <div class="mod-hd">
            <div class="title">
                <h3>补充资料</h3>
            </div>
        </div>
        <dit class="mod-bd">
            <div class="content">
                <table class="table-public table-web table-fix">
                    <thead>
                    <tr>
                        <th width="537">项目</th>
                        <th>金额</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="focus-state">
                        <td>无法收回、尚未批准核销的应收款项</td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                <input type="text" name="sfcBalanctsheetList[1].apprAccRec" value ="${empty sfcBalanctsheetList[1].apprAccRec?"0.00":sfcBalanctsheetList[1].apprAccRec}" class="ipt-txt units required" placeholder="请输入金额">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td>盘亏、毁损和报废、尚未批准核销的存货</td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                <input type="text" name="sfcBalanctsheetList[1].apprInventory" value ="${empty sfcBalanctsheetList[1].apprInventory?"0.00":sfcBalanctsheetList[1].apprInventory}" class="ipt-txt units required" placeholder="请输入金额">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td>无法收回、尚未批准核销的对外投资</td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                <input type="text" name="sfcBalanctsheetList[1].apprForInvestAssets" value ="${empty sfcBalanctsheetList[1].apprForInvestAssets?"0.00":sfcBalanctsheetList[1].apprForInvestAssets}" class="ipt-txt units required" placeholder="请输入金额">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td>死亡毁损、尚未批准核销的农业资产</td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                <input type="text" name="sfcBalanctsheetList[1].apprArgAssets" value ="${empty sfcBalanctsheetList[1].apprArgAssets?"0.00":sfcBalanctsheetList[1].apprArgAssets}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td>盘亏、毁损和报废、尚未批准核销的固定资产</td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                <input type="text" name="sfcBalanctsheetList[1].apprFixAssets" value ="${empty sfcBalanctsheetList[1].apprFixAssets?"0.00":sfcBalanctsheetList[1].apprFixAssets}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td>毁损和报废、尚未批准核销的在建工程</td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                <input type="text" name="sfcBalanctsheetList[1].apprProConstr" value ="${empty sfcBalanctsheetList[1].apprProConstr?"0.00":sfcBalanctsheetList[1].apprProConstr}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td>注销和无效、尚未批准核销的无形资产</td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                <input type="text" name="sfcBalanctsheetList[1].apprIntAssets" value ="${empty sfcBalanctsheetList[1].apprIntAssets?"0.00":sfcBalanctsheetList[1].apprIntAssets}" class="ipt-txt units required " maxlength="16" placeholder="请输入金额">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </dit>
    </div>
    <div class="mod mod-border">
        <div class="mod-hd">
            <div class="title">
                <h3>说明：所有栏目数据不能为空</h3>
            </div>
        </div>

        <dit class="mod-bd">
            <div class="content">
                <table class="table-public table-fix">
                    <tbody>
                    <tr>
                        <td class="column-r">1. 数据填报说明：</td>
                        <td>栏目灰色部分由系统有关科目计算后给出，无需人工填报。</td>
                    </tr>
                    <tr>
                        <td class="column-r" valign="top">2. 报表数据关系：</td>
                        <td>
                            1+5+6=10；12+13=15；16-17=20 ；20+21+22=25；<br/>
                            11+15+25+27=28；10+28=29；30+31+32+33+35=36；<br/>
                            40+41=42；36+42=43；44+45+46+47+50=51；43+51=54；报表平衡检测:29=54
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </dit>
    </div>
    <div class="btn-box">
        <input type="submit" value="确定" class="btn-common js-save">
        <input type="button" value="取消" class="btn-common js-btn-cancel ">
    </div>

</form>

<jsp:include page="../../common/footer.jsp"></jsp:include>

<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/component/dropDown.js"/>"></script>


<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/client/yr/auxtab/balanctsheet_edit.js"/>"></script>


</body>
</html>