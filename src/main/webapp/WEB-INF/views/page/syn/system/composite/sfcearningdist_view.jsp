<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>农专社盈余及分配表页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body class="pd10">
<div class="mod">
    <div class="mod-hd">
        <div class="title">
            <h3>盈余及盈余分配表</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content">
            <table class="table-public table-web table-fix">
                <thead>
                <tr class="focus-state">
                    <th width="160">项目</th>
                    <th width="40">行次</th>
                    <th width="260">金额</th>
                    <th width="160">项目</th>
                    <th width="40">行次</th>
                    <th>金额</th>
                </tr>
                </thead>
                <tbody>
                <tr class="focus-state">
                    <td colspan="3" class="column-l light">
                        本年盈余
                    </td>
                    <td colspan="3" class="column-l light">
                        盈余分配
                    </td>
                </tr>
                <tr class="focus-state">
                    <td class="column-l light">一、经营收入</td>
                    <td>1</td>
                    <td>
                        <div class="ipt-box js-ipt-box">
                            ${empty sfcIncstatement.busInc?'0.00':sfcIncstatement.busInc}
                        </div>
                    </td>
                    <td class="column-l light">四、本年盈余</td>
                    <td>16</td>
                    <td>
                        <div class="ipt-box js-ipt-box">
                            ${empty sfcIncstatement.thatSurplus?'0.00':sfcIncstatement.thatSurplus}
                        </div>
                    </td>
                </tr>
                <tr class="focus-state">
                    <td class="column-r">加：投资收益</td>
                    <td>2</td>
                    <td>
                        <div class="ipt-box js-ipt-box">
                           ${empty sfcIncstatement.annDisInc?'0.00':sfcIncstatement.annDisInc}
                        </div>
                    </td>
                    <td class="column-r">加：年初未分配盈余</td>
                    <td>17</td>
                    <td>
                        <div class="ipt-box js-ipt-box">
                            ${empty sfcIncstatement.undistSurplusBegin?'0.00':sfcIncstatement.undistSurplusBegin}
                        </div>
                    </td>
                </tr>
                <tr class="focus-state">
                    <td class="column-r">减：经营支出</td>
                    <td>5</td>
                    <td>
                        <div class="ipt-box js-ipt-box">
                            ${empty sfcIncstatement.busSpend?'0.00':sfcIncstatement.busSpend}
                        </div>
                    </td>
                    <td class="column-r">其他转入</td>
                    <td>18</td>
                    <td>
                        <div class="ipt-box js-ipt-box">
                            ${empty sfcIncstatement.otherTrans?'0.00':sfcIncstatement.otherTrans}
                        </div>
                    </td>
                </tr>
                <tr class="focus-state">
                    <td class="column-r">管理费用</td>
                    <td>6</td>
                    <td>
                        <div class="ipt-box js-ipt-box">
                            ${empty sfcIncstatement.manageFees?'0.00':sfcIncstatement.manageFees}
                        </div>
                    </td>
                    <td class="column-l light">五、可分配盈余</td>
                    <td>21</td>
                    <td>
                        <div class="ipt-box js-ipt-box">
                            ${empty sfcIncstatement.distSurplus?'0.00':sfcIncstatement.distSurplus}
                        </div>
                    </td>
                </tr>
                   <tr class="focus-state">
                       <td class="column-l light">二、经营收益</td>
                       <td>10</td>
                       <td>
                           <div class="ipt-box js-ipt-box">
                               ${empty sfcIncstatement.busEarn?'0.00':sfcIncstatement.busEarn}
                           </div>
                       </td>
                       <td class="column-r">减：提取盈余公积</td>
                       <td>22</td>
                       <td>
                           <div class="ipt-box js-ipt-box">
                               ${empty sfcIncstatement.extSurAccuFund?'0.00':sfcIncstatement.extSurAccuFund}
                           </div>
                       </td>
                   </tr>
                   <tr class="focus-state">
                       <td class="column-r">加：其他收入</td>
                       <td>11</td>
                       <td>
                           <div class="ipt-box js-ipt-box">
                               ${empty sfcIncstatement.otherInc?'0.00':sfcIncstatement.otherInc}
                           </div>
                       </td>
                       <td class="column-r">盈余返还</td>
                       <td>23</td>
                       <td>
                           <div class="ipt-box js-ipt-box">
                              ${empty sfcIncstatement.returnSurplusPay?'0.00':sfcIncstatement.returnSurplusPay}
                           </div>
                       </td>
                   </tr>
                   <tr class="focus-state">
                       <td class="column-r">减：其他支出</td>
                       <td>12</td>
                       <td>
                           <div class="ipt-box js-ipt-box">
                               ${empty sfcIncstatement.otherSpend?'0.00':sfcIncstatement.otherSpend}
                           </div>
                       </td>
                       <td class="column-r">剩余盈余分配</td>
                       <td>24</td>
                       <td>
                           <div class="ipt-box js-ipt-box">
                                ${empty sfcIncstatement.remainSurplusPay?'0.00':sfcIncstatement.remainSurplusPay}
                           </div>
                       </td>
                   </tr>
                   <tr class="focus-state">
                       <td class="column-l light">三、本年盈余</td>
                       <td>15</td>
                       <td>
                           <div class="ipt-box js-ipt-box">
                              ${empty sfcIncstatement.thisSurplus?'0.00':sfcIncstatement.thisSurplus}  
                           </div>
                       </td>
                       <td></td>
                       <td></td>
                       <td></td>
                   </tr>
                   <tr class="focus-state">
                       <td></td>
                       <td></td>
                       <td></td>
                       <td class="column-l light">六、年末未分配盈余</td>
                       <td>28</td>
                       <td>
                           <div class="ipt-box js-ipt-box">
                               ${empty sfcIncstatement.undistSurplusEnd?'0.00':sfcIncstatement.undistSurplusEnd}
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