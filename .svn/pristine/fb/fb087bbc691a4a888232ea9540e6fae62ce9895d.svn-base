<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>农专社成员权益变动表页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body class="pd10">
    <div class="mod">
        <div class="mod-hd">
            <div class="title">
                <h3>成员权益变动表</h3>
            </div>
        </div>
        <div class="mod-bd">
            <div class="content">
                <table class="table-public table-web table-fix">
                    <thead>
                    <tr>
                        <th width="80">项目</th>
                        <th colspan="2" width="140">股金</th>
                        <th colspan="2" width="140">专项基金</th>
                        <th colspan="2" width="140">资本公积</th>
                        <th colspan="2" width="140">盈余公积</th>
                        <th colspan="2" width="140">未分配盈余</th>
                        <th colspan="2">合计</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td class="light column-l">年初余额</td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                ${!empty sfcIncomechange.chgStockStartBal?sfcIncomechange.chgStockStartBal:sheetList[0].capitalAmount}
                            </div>
                        </td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                ${!empty sfcIncomechange.chgFundStartBal?sfcIncomechange.chgFundStartBal:sheetList[0].specificFund}
                            </div>
                        </td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                ${!empty sfcIncomechange.chgCapitalStartBal?sfcIncomechange.chgCapitalStartBal:sheetList[0].capAccuFund}
                            </div>
                        </td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                ${!empty sfcIncomechange.chgProfitStartBal?sfcIncomechange.chgProfitStartBal:sheetList[0].surAccuFund}
                            </div>
                        </td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                ${!empty sfcIncomechange.chgNogetStartBal?sfcIncomechange.chgNogetStartBal:sheetList[0].undistSurplus}
                            </div>
                        </td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                ${!empty sfcIncomechange.chgTotalStartBal?sfcIncomechange.chgTotalStartBal:sheetList[0].totEqu}
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td class="light column-l">本年增加数</td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                ${sfcIncomechange.chgStockAdd}
                            </div>
                        </td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                ${sfcIncomechange.chgFundAdd}
                            </div>
                        </td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                ${sfcIncomechange.chgCapitalAdd}
                            </div>
                        </td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                ${sfcIncomechange.chgProfitAdd}
                            </div>
                        </td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                ${sfcIncomechange.chgNogetAdd}
                            </div>
                        </td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                ${sfcIncomechange.chgTotalAdd}
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td colspan="2" class="column-r">其中：</td>
                        <td colspan="2" class="column-r">其中：</td>
                        <td colspan="2" class="column-r">其中：</td>
                        <td colspan="2" class="column-r">其中：</td>
                        <td colspan="2"></td>
                        <td colspan="2"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td width="100">资本公积转赠</td>
                        <td  class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                ${sfcIncomechange.chgStockAddCap}
                            </div>
                        </td>
                        <td width="110">国家财政直接补助</td>
                        <td  class="focus-state">
                            <div class="ipt-box js-ipt-box">
                               ${sfcIncomechange.chgFundAddSsd}
                            </div>
                        </td>
                        <td width="100">股金溢价</td>
                        <td  class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                ${sfcIncomechange.chgCapitalAddPre}
                            </div>
                        </td>
                        <td width="100">从盈余中提取</td>
                        <td  class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                ${sfcIncomechange.chgProfitAddSur}
                            </div>
                        </td>
                        <td colspan="2"></td>
                        <td colspan="2"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td width="40">盈余公积转赠</td>
                        <td  class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                ${sfcIncomechange.chgStockAddSur}
                            </div>
                        </td>
                        <td width="40">接受捐赠转入</td>
                        <td  class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                ${sfcIncomechange.chgFundAddDona}
                            </div>
                        </td>
                        <td width="40">资产评估增值</td>
                        <td  class="focus-state">
                            <div class="ipt-box js-ipt-box">
                               ${sfcIncomechange.chgCapitalAddAppr}
                            </div>
                        </td>
                        <td></td>
                        <td></td>
                        <td colspan="2"></td>
                        <td colspan="2"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td width="40">成员增加出资</td>
                        <td  class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                ${sfcIncomechange.chgStockAddMem}
                            </div>
                        </td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td colspan="2"></td>
                        <td colspan="2"></td>
                    </tr>
                    <tr class="focus-state">
                        <td class="light column-l">本年减少数</td>
                        <td colspan="2" class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                ${sfcIncomechange.chgStockLess}
                            </div>
                        </td>
                        <td colspan="2" class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                ${sfcIncomechange.chgFundLess}
                            </div>
                        </td>
                        <td colspan="2" class="focus-state">
                            <div class="ipt-box js-ipt-box">
                               ${sfcIncomechange.chgCapitalLess}
                            </div>
                        </td>
                        <td colspan="2" class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                ${sfcIncomechange.chgProfitLess}
                            </div>
                        </td>
                        <td colspan="2" class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                ${sfcIncomechange.chgNogetLess}
                            </div>
                        </td>
                        <td colspan="2" class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                ${sfcIncomechange.chgTotalLess}
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td colspan="2"></td>
                        <td colspan="2">
                        </td>
                        <td colspan="2">
                        </td>
                        <td colspan="2">
                        </td>
                        <td colspan="2" class="column-r">其中：</td>
                        <td colspan="2"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td colspan="2"></td>
                        <td colspan="2">
                        </td>
                        <td colspan="2">
                        </td>
                        <td colspan="2">
                        </td>
                        <td width="100">按交易量(额)分配的盈余</td>
                        <td  class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                ${sfcIncomechange.chgNogetLessVol}
                            </div>
                        </td>
                        <td colspan="2"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td colspan="2"></td>
                        <td colspan="2">
                        </td>
                        <td colspan="2">
                        </td>
                        <td colspan="2">
                        </td>
                        <td width="40">剩余盈余分配</td>
                        <td  class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                ${sfcIncomechange.chgNogetLessSur}
                            </div>
                        </td>
                        <td colspan="2"></td>
                    </tr>
                    <tr>
                        <td class="light column-l">年末余额</td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                ${!empty sfcIncomechange.chgStockEndBal?sfcIncomechange.chgStockEndBal:sheetList[1].capitalAmount}
                            </div>
                        </td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                ${!empty sfcIncomechange.chgFundEndBal?sfcIncomechange.chgFundEndBal:sheetList[1].specificFund}
                            </div>
                        </td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                ${!empty sfcIncomechange.chgCapitalEndBal?sfcIncomechange.chgCapitalEndBal:sheetList[1].capAccuFund}
                            </div>
                        </td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                ${!empty sfcIncomechange.chgProfitEndBal?sfcIncomechange.chgProfitEndBal:sheetList[1].surAccuFund}
                            </div>
                        </td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                ${!empty sfcIncomechange.chgNogetEndBal?sfcIncomechange.chgNogetEndBal:sheetList[1].undistSurplus}
                            </div>
                        </td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                ${!empty sfcIncomechange.chgTotalEndbal?sfcIncomechange.chgTotalEndbal:sheetList[1].totEqu}
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>