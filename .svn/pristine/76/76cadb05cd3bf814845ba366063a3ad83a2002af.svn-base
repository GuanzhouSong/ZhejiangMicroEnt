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
    <style>
        .mod {
            width: auto;
        }

        .mod .mod-bd > .content {
            padding: 0;
        }
    </style>
</head>
<body class="pd10">
<div class="mod">
    <div class="mod-bd">
        <div class="content clearfix">
            <p style="font-weight: bold;font-size:12px;text-align: right;margin-right: 32px;">单位: <strong class="light">元</strong>
            </p>
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
                                ${empty sfcBalanctsheetList[0].moneFunds?"0.00":sfcBalanctsheetList[0].moneFunds}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].moneFunds?"0.00":sfcBalanctsheetList[1].moneFunds}
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td class="column-r">应收款项</td>
                        <td>5</td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[0].accRec?"0.00":sfcBalanctsheetList[0].accRec}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].accRec?"0.00":sfcBalanctsheetList[1].accRec}
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td class="column-r">存货</td>
                        <td>6</td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].inventory?"0.00":sfcBalanctsheetList[0].inventory}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].inventory?"0.00":sfcBalanctsheetList[1].inventory}
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td class="light column-r">流动资产合计</td>
                        <td>10</td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[0].totCurrAssets?"0.00":sfcBalanctsheetList[0].totCurrAssets}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].totCurrAssets?"0.00":sfcBalanctsheetList[1].totCurrAssets}
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
                                ${empty sfcBalanctsheetList[0].forInvestAssets?"0.00":sfcBalanctsheetList[0].forInvestAssets}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].forInvestAssets?"0.00":sfcBalanctsheetList[1].forInvestAssets}
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
                                ${empty sfcBalanctsheetList[0].liveStockAssets?"0.00":sfcBalanctsheetList[0].liveStockAssets}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].liveStockAssets?"0.00":sfcBalanctsheetList[1].liveStockAssets}
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td class="column-r">林木资产</td>
                        <td>13</td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[0].treeAssets?"0.00":sfcBalanctsheetList[0].treeAssets}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].treeAssets?"0.00":sfcBalanctsheetList[1].treeAssets}
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td class="column-r light">农业资产合计</td>
                        <td>15</td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[0].argAssetsAmount?"0.00":sfcBalanctsheetList[0].argAssetsAmount}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].argAssetsAmount?"0.00":sfcBalanctsheetList[1].argAssetsAmount}
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
                                ${empty sfcBalanctsheetList[0].fixAssetsOri?"0.00":sfcBalanctsheetList[0].fixAssetsOri}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].fixAssetsOri?"0.00":sfcBalanctsheetList[1].fixAssetsOri}
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td class="column-r">减：累计折旧</td>
                        <td>17</td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[0].accDepreciation?"0.00":sfcBalanctsheetList[0].accDepreciation}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].accDepreciation?"0.00":sfcBalanctsheetList[1].accDepreciation}
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td class="column-r">固定资产净值</td>
                        <td>20</td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[0].fixAssetsWorth?"0.00":sfcBalanctsheetList[0].fixAssetsWorth}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].fixAssetsWorth?"0.00":sfcBalanctsheetList[1].fixAssetsWorth}
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td class="column-r">固定资产清理</td>
                        <td>21</td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[0].fixAssetsClean?"0.00":sfcBalanctsheetList[0].fixAssetsClean}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].fixAssetsClean?"0.00":sfcBalanctsheetList[1].fixAssetsClean}
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td class="column-r">在建工程</td>
                        <td>22</td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[0].proConstr?"0.00":sfcBalanctsheetList[0].proConstr}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box ">
                                ${empty sfcBalanctsheetList[1].proConstr?"0.00":sfcBalanctsheetList[1].proConstr}
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td class="column-r">固定资产合计</td>
                        <td>25</td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[0].fixAssetsAmount?'0.00':sfcBalanctsheetList[0].fixAssetsAmount}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].fixAssetsAmount?'0.00':sfcBalanctsheetList[1].fixAssetsAmount}
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
                                ${empty sfcBalanctsheetList[0].intAssets?'0.00':sfcBalanctsheetList[0].intAssets}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].intAssets?'0.00':sfcBalanctsheetList[1].intAssets}
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td class="column-r light">长期资产合计</td>
                        <td>28</td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[0].longAssetsAmount?'0.00':sfcBalanctsheetList[0].longAssetsAmount}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].longAssetsAmount?'0.00':sfcBalanctsheetList[1].longAssetsAmount}
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td class="column-r light">资产总计</td>
                        <td>29</td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[0].assGro?'0.00':sfcBalanctsheetList[0].assGro}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].assGro?'0.00':sfcBalanctsheetList[1].assGro}
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
                                ${empty sfcBalanctsheetList[0].shortBorrowing?'0.00':sfcBalanctsheetList[0].shortBorrowing}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].shortBorrowing?'0.00':sfcBalanctsheetList[1].shortBorrowing}
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td class="column-r">应付款项</td>
                        <td>31</td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[0].accPay?'0.00':sfcBalanctsheetList[0].accPay}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].accPay?'0.00':sfcBalanctsheetList[1].accPay}
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td class="column-r">应付工资</td>
                        <td>32</td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[0].wagePay?'0.00':sfcBalanctsheetList[0].wagePay}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].wagePay?'0.00':sfcBalanctsheetList[1].wagePay}
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td class="column-r">应付盈余返还</td>
                        <td>33</td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[0].returnSurplusPay?'0.00':sfcBalanctsheetList[0].returnSurplusPay}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].returnSurplusPay?'0.00':sfcBalanctsheetList[1].returnSurplusPay}
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td class="column-r">应付剩余盈余</td>
                        <td>35</td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[0].remainSurplusPay?'0.00':sfcBalanctsheetList[0].remainSurplusPay}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].remainSurplusPay?'0.00':sfcBalanctsheetList[1].remainSurplusPay}
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td class="light column-r">流动负债合计</td>
                        <td>36</td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[0].totCurrLiab?'0.00':sfcBalanctsheetList[0].totCurrLiab}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].totCurrLiab?'0.00':sfcBalanctsheetList[1].totCurrLiab}
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
                                ${empty sfcBalanctsheetList[0].longBorrowing?'0.00':sfcBalanctsheetList[0].longBorrowing}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].longBorrowing?'0.00':sfcBalanctsheetList[1].longBorrowing}
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td class="column-r">专项应付款</td>
                        <td>41</td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[0].specificPay?'0.00':sfcBalanctsheetList[0].specificPay}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].specificPay?'0.00':sfcBalanctsheetList[1].specificPay}
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td class="column-r light">长期负债合计</td>
                        <td>42</td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[0].LTermLiaAm?'0.00':sfcBalanctsheetList[0].LTermLiaAm}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].LTermLiaAm?'0.00':sfcBalanctsheetList[1].LTermLiaAm}
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td class="column-r light">负债合计</td>
                        <td>43</td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[0].liaGro?'0.00':sfcBalanctsheetList[0].liaGro}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].liaGro?'0.00':sfcBalanctsheetList[1].liaGro}
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
                                ${empty sfcBalanctsheetList[0].capitalAmount?'0.00':sfcBalanctsheetList[0].capitalAmount}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].capitalAmount?'0.00':sfcBalanctsheetList[1].capitalAmount}
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td class="column-r">专项基金</td>
                        <td>45</td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[0].specificFund?'0.00':sfcBalanctsheetList[0].specificFund}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].specificFund?'0.00':sfcBalanctsheetList[1].specificFund}
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td class="column-r">资本公积</td>
                        <td>46</td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[0].capAccuFund?'0.00':sfcBalanctsheetList[0].capAccuFund}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].capAccuFund?'0.00':sfcBalanctsheetList[1].capAccuFund}
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td class="column-r">盈余公积</td>
                        <td>47</td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[0].surAccuFund?'0.00':sfcBalanctsheetList[0].surAccuFund}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].surAccuFund?'0.00':sfcBalanctsheetList[1].surAccuFund}
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td class="column-r">未分配盈余</td>
                        <td>50</td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[0].undistSurplus?'0.00':sfcBalanctsheetList[0].undistSurplus}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].undistSurplus?'0.00':sfcBalanctsheetList[1].undistSurplus}
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td class="column-r light">所有者权益合计</td>
                        <td>51</td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[0].totEqu?'0.00':sfcBalanctsheetList[0].totEqu}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].totEqu?'0.00':sfcBalanctsheetList[1].totEqu}
                            </div>
                        </td>
                    </tr>
                    <tr class="focus-state">
                        <td class="column-r light">负债和所有者权益总计</td>
                        <td>54</td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[0].totLiaEqu?'0.00':sfcBalanctsheetList[0].totLiaEqu}
                            </div>
                        </td>
                        <td>
                            <div class="ipt-box  js-ipt-box">
                                ${empty sfcBalanctsheetList[1].totLiaEqu?'0.00':sfcBalanctsheetList[1].totLiaEqu}
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<div class="mod mod-border ${not empty sfcBalanctsheetList[0].remark?'':'js-content-show'}  js-remark-ui"> <%----%>
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
                        ${sfcBalanctsheetList[0].remark}
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

<div class="mod mod-border mt10">
    <div class="mod-hd">
        <div class="title">
            <h3>补充资料</h3>
        </div>
    </div>
    <div class="mod-bd">
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
                            ${empty sfcBalanctsheetList[1].apprAccRec?'0.00':sfcBalanctsheetList[1].apprAccRec}
                        </div>
                    </td>
                </tr>
                <tr class="focus-state">
                    <td>盘亏、毁损和报废、尚未批准核销的存货</td>
                    <td>
                        <div class="ipt-box  js-ipt-box">
                            ${empty sfcBalanctsheetList[1].apprInventory?'0.00':sfcBalanctsheetList[1].apprInventory}
                        </div>
                    </td>
                </tr>
                <tr class="focus-state">
                    <td>无法收回、尚未批准核销的对外投资</td>
                    <td>
                        <div class="ipt-box  js-ipt-box">
                            ${empty sfcBalanctsheetList[1].apprForInvestAssets?'0.00':sfcBalanctsheetList[1].apprForInvestAssets}
                        </div>
                    </td>
                </tr>
                <tr class="focus-state">
                    <td>死亡毁损、尚未批准核销的农业资产</td>
                    <td>
                        <div class="ipt-box  js-ipt-box">
                            ${empty sfcBalanctsheetList[1].apprArgAssets?'0.00':sfcBalanctsheetList[1].apprArgAssets}
                        </div>
                    </td>
                </tr>
                <tr class="focus-state">
                    <td>盘亏、毁损和报废、尚未批准核销的固定资产</td>
                    <td>
                        <div class="ipt-box  js-ipt-box">
                            ${empty sfcBalanctsheetList[1].apprFixAssets?'0.00':sfcBalanctsheetList[1].apprFixAssets}
                        </div>
                    </td>
                </tr>
                <tr class="focus-state">
                    <td>毁损和报废、尚未批准核销的在建工程</td>
                    <td>
                        <div class="ipt-box  js-ipt-box">
                            ${empty sfcBalanctsheetList[1].apprProConstr?'0.00':sfcBalanctsheetList[1].apprProConstr}
                        </div>
                    </td>
                </tr>
                <tr class="focus-state">
                    <td>注销和无效、尚未批准核销的无形资产</td>
                    <td>
                        <div class="ipt-box  js-ipt-box">
                            ${empty sfcBalanctsheetList[1].apprIntAssets?'0.00':sfcBalanctsheetList[1].apprIntAssets}
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