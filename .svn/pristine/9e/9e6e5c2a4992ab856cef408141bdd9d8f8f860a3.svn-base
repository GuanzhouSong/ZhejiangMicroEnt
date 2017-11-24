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
<body>

<!-- 头部  start-->
<jsp:include page="../../common/header.jsp"></jsp:include>

<%--移入的tab标签栏--%>
<jsp:include page="../template/sfc_template.jsp"></jsp:include>



<form class="form-horizontal error-bottom" id="TableForm">
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
                        <input type="hidden"   name="id"      value="${sfcIncomechange.id}"  />
                        <input type="hidden"   name="uid"      value="${empty sfcIncomechange.uid?'':sfcIncomechange.uid}"  />
                        <input type="hidden"   name="year"     value="${year}"  />
                        <input type="hidden"   name="priPID"   value="${priPID}"  />

                        <td class="light column-l">年初余额</td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="chgStockStartBal"   name="chgStockStartBal"   value="${sheetList[0].capitalAmount}" class="ipt-txt" placeholder="请输入金额" readonly>
                            </div>
                        </td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="chgFundStartBal"  name="chgFundStartBal"   value="${sheetList[0].specificFund}" class="ipt-txt" placeholder="请输入金额" readonly>
                            </div>
                        </td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="chgCapitalStartBal"  name="chgCapitalStartBal"   value="${sheetList[0].capAccuFund}" class="ipt-txt" placeholder="请输入金额" readonly>
                            </div>
                        </td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="chgProfitStartBal"  name="chgProfitStartBal"   value="${sheetList[0].surAccuFund}" class="ipt-txt" placeholder="请输入金额" readonly>
                            </div>
                        </td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="chgNogetStartBal"  name="chgNogetStartBal"   value="${sheetList[0].undistSurplus}" class="ipt-txt" placeholder="请输入金额" readonly>
                            </div>
                        </td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="chgTotalStartBal"  name="chgTotalStartBal"   value="${sheetList[0].totEqu}" class="ipt-txt" placeholder="请输入金额" readonly>
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td class="light column-l">本年增加数</td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="chgStockAdd"  name="chgStockAdd"   value="${sfcIncomechange.chgStockAdd}" class="ipt-txt units"   placeholder="请输入金额">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="chgFundAdd"  name="chgFundAdd"   value="${sfcIncomechange.chgFundAdd}" class="ipt-txt units" placeholder="请输入金额">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="chgCapitalAdd"  name="chgCapitalAdd"   value="${sfcIncomechange.chgCapitalAdd}" class="ipt-txt units" placeholder="请输入金额">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="chgProfitAdd"  name="chgProfitAdd"   value="${sfcIncomechange.chgProfitAdd}" class="ipt-txt units" placeholder="请输入金额">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="chgNogetAdd"  name="chgNogetAdd"   value="${sfcIncomechange.chgNogetAdd}" class="ipt-txt units" placeholder="请输入金额">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="chgTotalAdd"  name="chgTotalAdd"   value="${sfcIncomechange.chgTotalAdd}" class="ipt-txt" placeholder="请输入金额" readonly>
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
                        <td width="40">资本公积转赠</td>
                        <td  class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="chgStockAddCap"  name="chgStockAddCap"   value="${sfcIncomechange.chgStockAddCap}" class="ipt-txt units"  placeholder="请输入金额">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td width="40">国家财政直接补助</td>
                        <td  class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="chgFundAddSsd"  name="chgFundAddSsd"   value="${sfcIncomechange.chgFundAddSsd}" class="ipt-txt units" placeholder="请输入金额">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td width="40">股金溢价</td>
                        <td  class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="chgCapitalAddPre"  name="chgCapitalAddPre"   value="${sfcIncomechange.chgCapitalAddPre}" class="ipt-txt units" placeholder="请输入金额">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td width="40">从盈余中提取</td>
                        <td  class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="chgProfitAddSur"  name="chgProfitAddSur"   value="${sfcIncomechange.chgProfitAddSur}" class="ipt-txt units" placeholder="请输入金额">
                                <i class="icon-close"></i>
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
                                <input type="text" id="chgStockAddSur"  name="chgStockAddSur"   value="${sfcIncomechange.chgStockAddSur}" class="ipt-txt units" placeholder="请输入金额">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td width="40">接受捐赠转入</td>
                        <td  class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="chgFundAddDona"  name="chgFundAddDona"   value="${sfcIncomechange.chgFundAddDona}" class="ipt-txt units" placeholder="请输入金额">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td width="40">资产评估增值</td>
                        <td  class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="chgCapitalAddAppr"  name="chgCapitalAddAppr"   value="${sfcIncomechange.chgCapitalAddAppr}" class="ipt-txt units" placeholder="请输入金额">
                                <i class="icon-close"></i>
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
                                <input type="text" id="chgStockAddMem"  name="chgStockAddMem"   value="${sfcIncomechange.chgStockAddMem}" class="ipt-txt units" placeholder="请输入金额">
                                <i class="icon-close"></i>
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
                                <input type="text" id="chgStockLess"  name="chgStockLess"   value="${sfcIncomechange.chgStockLess}" class="ipt-txt units" placeholder="请输入金额">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td colspan="2" class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="chgFundLess"  name="chgFundLess"   value="${sfcIncomechange.chgFundLess}" class="ipt-txt units"  placeholder="请输入金额">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td colspan="2" class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="chgCapitalLess"  name="chgCapitalLess"   value="${sfcIncomechange.chgCapitalLess}" class="ipt-txt units" placeholder="请输入金额">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td colspan="2" class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="chgProfitLess"  name="chgProfitLess"   value="${sfcIncomechange.chgProfitLess}" class="ipt-txt units" placeholder="请输入金额">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td colspan="2" class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="chgNogetLess"  name="chgNogetLess"   value="${sfcIncomechange.chgNogetLess}" class="ipt-txt units" placeholder="请输入金额">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td colspan="2" class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="chgTotalLess"  name="chgTotalLess"   value="${sfcIncomechange.chgTotalLess}" class="ipt-txt" placeholder="请输入金额" readonly>
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
                        <td width="40">按交易量(额)分配的盈余</td>
                        <td  class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="chgNogetLessVol"  name="chgNogetLessVol"   value="${sfcIncomechange.chgNogetLessVol}" class="ipt-txt units" placeholder="请输入金额">
                                <i class="icon-close"></i>
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
                                <input type="text" id="chgNogetLessSur"  name="chgNogetLessSur"   value="${sfcIncomechange.chgNogetLessSur}" class="ipt-txt units" placeholder="请输入金额">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td colspan="2"></td>
                    </tr>
                    <tr>
                        <td class="light column-l">年末余额</td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="chgStockEndBal"  name="chgStockEndBal"   value="${sheetList[1].capitalAmount}" class="ipt-txt" placeholder="请输入金额" readonly>
                            </div>
                        </td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="chgFundEndBal"  name="chgFundEndBal"   value="${sheetList[1].specificFund}" class="ipt-txt" placeholder="请输入金额" readonly>
                            </div>
                        </td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="chgCapitalEndBal"  name="chgCapitalEndBal"  value="${sheetList[1].capAccuFund}" class="ipt-txt" placeholder="请输入金额" readonly>
                            </div>
                        </td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="chgProfitEndBal"  name="chgProfitEndBal"   value="${sheetList[1].surAccuFund}" class="ipt-txt" placeholder="请输入金额" readonly>
                            </div>
                        </td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="chgNogetEndBal"  name="chgNogetEndBal"   value="${sheetList[1].undistSurplus}" class="ipt-txt" placeholder="请输入金额" readonly>
                            </div>
                        </td>
                        <td colspan="2">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="chgTotalEndbal"  name="chgTotalEndbal"   value="${sheetList[1].totEqu}" class="ipt-txt" placeholder="请输入金额" readonly>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="btn-box">
        <input type="submit" value="确定" class="btn-common js-save">
        <input type="button" value="取消" class="btn-common js-cancel">
    </div>
</form>

<div class="mod mod-border" style="margin-top: 2px;">
    <div class="mod-hd">
        <div class="title">
            <h3>说明：数据平衡关系</h3>
        </div>
    </div>
    <dit class="mod-bd">
        <div class="content">
            <table class="table-public table-fix">
                <tbody>
                <tr>
                    <td>1.资本公积转赠+盈余公积转赠+成员增加出资<=股金本年增加数！ </td>
                </tr>
                <tr>
                    <td>2.国家财政直接补助+接受捐赠转入<=专项基金本年增加数！ </td>
                </tr>
                <tr>
                    <td>3.股金溢价+资产评估增值<=资本公积本年增加数！ </td>
                </tr>
                <tr>
                    <td>4.从盈余中提取<=盈余公积本年增加数！ </td>
                </tr>
                <tr>
                    <td>5.其中按交易量(额)分配的盈余+剩余盈余分配<=未分配盈余本年减少数 </td>
                </tr>
                <tr>
                    <td>6.【股金】数据平衡关系: 年初余额+本年增加数-本年减少数 = 年末余额 </td>
                </tr>
                <tr>
                    <td>7.【专项基金】数据平衡关系: 年初余额+本年增加数-本年减少数 = 年末余额 </td>
                </tr>
                <tr>
                    <td>8.【资本公积】数据平衡关系: 年初余额+本年增加数-本年减少数 = 年末余额 </td>
                </tr>
                <tr>
                    <td>9.【盈余公积】数据平衡关系: 年初余额+本年增加数-本年减少数 = 年末余额 </td>
                </tr>
                <tr>
                    <td>10.【未分配盈余】数据平衡关系: 年初余额+本年增加数-本年减少数 = 年末余额 </td>
                </tr>
                </tbody>
            </table>
        </div>
    </dit>
</div>


<jsp:include page="../../common/footer.jsp"></jsp:include>

<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/client/yr/auxtab/incomechange_edit.js"/>"></script>
</body>
</html>