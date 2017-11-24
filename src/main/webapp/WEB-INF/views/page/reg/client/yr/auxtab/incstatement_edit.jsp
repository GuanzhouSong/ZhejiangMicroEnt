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
<body>



<!-- 头部  start-->
<jsp:include page="../../common/header.jsp"></jsp:include>

<%--移入的tab标签栏--%>
<jsp:include page="../template/sfc_template.jsp"></jsp:include>


<form class="form-horizontal error-bottom" id="sfcearningdistForm">
    <input type="hidden"   name="id"      value="${sfcIncstatement.id}"  />
    <input type="hidden"   name="uid"      value="${empty sfcIncstatement.uid?'':sfcIncstatement.uid}"  />
   <%-- <input type="hidden"   name="year"     value="${empty sfcIncstatement.year?'':sfcIncstatement.year}"  />
    <input type="hidden"   name="priPID"   value="${empty sfcIncstatement.priPID?'0.00':sfcIncstatement.priPID}"  />--%>
    <input type="hidden"   name="year"     value="${year}"  />
    <input type="hidden"   name="priPID"   value="${priPID}"  />

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
                            <input type="text" id="statement1"  name="busInc"   value="${empty sfcIncstatement.busInc?'0.00':sfcIncstatement.busInc}" class="ipt-txt units required" placeholder="请输入金额">
                            <i class="icon-close"></i>
                        </div>
                    </td>
                    <td class="column-l light">四、本年盈余</td>
                    <td>16</td>
                    <td>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="statement16"  name="thatSurplus"  value="${empty sfcIncstatement.thatSurplus?'0.00':sfcIncstatement.thatSurplus}" class="ipt-txt units required" placeholder="请输入金额" readonly>
                           <%-- <i class="icon-close"></i>--%>
                        </div>
                    </td>
                </tr>
                <tr class="focus-state">
                    <td class="column-r">加：投资收益</td>
                    <td>2</td>
                    <td>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="statement2"  name="annDisInc"  value="${empty sfcIncstatement.annDisInc?'0.00':sfcIncstatement.annDisInc}" class="ipt-txt units required" placeholder="请输入金额">
                            <i class="icon-close"></i>
                        </div>
                    </td>
                    <td class="column-r">加：年初未分配盈余</td>
                    <td>17</td>
                    <td>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="statement17"  name="undistSurplusBegin"  value="${empty sfcIncstatement.undistSurplusBegin?'0.00':sfcIncstatement.undistSurplusBegin}" class="ipt-txt units required" placeholder="请输入金额">
                            <i class="icon-close"></i>
                        </div>
                    </td>
                </tr>
                <tr class="focus-state">
                    <td class="column-r">减：经营支出</td>
                    <td>5</td>
                    <td>
                        <div class="ipt-box js-ipt-box">
                            <input type="text"  id="statement5" name="busSpend"  value="${empty sfcIncstatement.busSpend?'0.00':sfcIncstatement.busSpend}" class="ipt-txt units required" placeholder="请输入金额">
                            <i class="icon-close"></i>
                        </div>
                    </td>
                    <td class="column-r">其他转入</td>
                    <td>18</td>
                    <td>
                        <div class="ipt-box js-ipt-box">
                            <input type="text"  id="statement18" name="otherTrans"  value="${empty sfcIncstatement.otherTrans?'0.00':sfcIncstatement.otherTrans}" class="ipt-txt units required" placeholder="请输入金额">
                            <i class="icon-close"></i>
                        </div>
                    </td>
                </tr>
                <tr class="focus-state">
                    <td class="column-r">管理费用</td>
                    <td>6</td>
                    <td>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="statement6"  name="manageFees"  value="${empty sfcIncstatement.manageFees?'0.00':sfcIncstatement.manageFees}" class="ipt-txt units required" placeholder="请输入金额">
                            <i class="icon-close"></i>
                        </div>
                    </td>
                    <td class="column-l light">五、可分配盈余</td>
                    <td>21</td>
                    <td>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="statement21" name="distSurplus"  value="${empty sfcIncstatement.distSurplus?'0.00':sfcIncstatement.distSurplus}" class="ipt-txt units required" placeholder="请输入金额" readonly>
                          <%--  <i class="icon-close"></i>--%>
                        </div>
                    </td>
                </tr>
                   <tr class="focus-state">
                       <td class="column-l light">二、经营收益</td>
                       <td>10</td>
                       <td>
                           <div class="ipt-box js-ipt-box">
                               <input type="text" id="statement10"  name="busEarn"  value="${empty sfcIncstatement.busEarn?'0.00':sfcIncstatement.busEarn}" class="ipt-txt units required" placeholder="请输入金额" readonly>
                             <%--  <i class="icon-close"></i>--%>
                           </div>
                       </td>
                       <td class="column-r">减：提取盈余公积</td>
                       <td>22</td>
                       <td>
                           <div class="ipt-box js-ipt-box">
                               <input type="text" id="statement22" name="extSurAccuFund"  value="${empty sfcIncstatement.extSurAccuFund?'0.00':sfcIncstatement.extSurAccuFund}" class="ipt-txt units required" placeholder="请输入金额">
                               <i class="icon-close"></i>
                           </div>
                       </td>
                   </tr>
                   <tr class="focus-state">
                       <td class="column-r">加：其他收入</td>
                       <td>11</td>
                       <td>
                           <div class="ipt-box js-ipt-box">
                               <input type="text" id="statement11" name="otherInc"  value="${empty sfcIncstatement.otherInc?'0.00':sfcIncstatement.otherInc}" class="ipt-txt units required" placeholder="请输入金额">
                               <i class="icon-close"></i>
                           </div>
                       </td>
                       <td class="column-r">盈余返还</td>
                       <td>23</td>
                       <td>
                           <div class="ipt-box js-ipt-box">
                               <input type="text" id="statement23" name="returnSurplusPay"  value="${empty sfcIncstatement.returnSurplusPay?'0.00':sfcIncstatement.returnSurplusPay}" class="ipt-txt units required" placeholder="请输入金额">
                               <i class="icon-close"></i>
                           </div>
                       </td>
                   </tr>
                   <tr class="focus-state">
                       <td class="column-r">减：其他支出</td>
                       <td>12</td>
                       <td>
                           <div class="ipt-box js-ipt-box">
                               <input type="text" id="statement12" name="otherSpend"  value="${empty sfcIncstatement.otherSpend?'0.00':sfcIncstatement.otherSpend}" class="ipt-txt units required" placeholder="请输入金额">
                               <i class="icon-close"></i>
                           </div>
                       </td>
                       <td class="column-r">剩余盈余分配</td>
                       <td>24</td>
                       <td>
                           <div class="ipt-box js-ipt-box">
                               <input type="text" id="statement24"  name="remainSurplusPay"  value="${empty sfcIncstatement.remainSurplusPay?'0.00':sfcIncstatement.remainSurplusPay}" class="ipt-txt units required" placeholder="请输入金额">
                               <i class="icon-close"></i>
                           </div>
                       </td>
                   </tr>
                   <tr class="focus-state">
                       <td class="column-l light">三、本年盈余</td>
                       <td>15</td>
                       <td>
                           <div class="ipt-box js-ipt-box">
                               <input type="text" id="statement15" name="thisSurplus"  value="${empty sfcIncstatement.thisSurplus?'0.00':sfcIncstatement.thisSurplus}" class="ipt-txt units required" placeholder="请输入金额" readonly>
                               <input type="hidden" id="priYeaProfit" value="${priYeaProfit}"><%--农专主表中的：priYeaProfit： 盈余总额--%>
                              <%-- <i class="icon-close"></i>--%>
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
                               <input type="text" id="statement28"  name="undistSurplusEnd"  value="${empty sfcIncstatement.undistSurplusEnd?'0.00':sfcIncstatement.undistSurplusEnd}" class="ipt-txt units required" placeholder="请输入金额" readonly>
                            <%--   <i class="icon-close"></i>--%>
                           </div>
                       </td>
                   </tr>
                </tbody>
            </table>
        </div>
    </div>
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
                    <td>1. 数据填报说明：栏目灰色部分由系统有关科目计算后给出，无需人工填报。</td>
                </tr>
                <tr>
                    <td>2. 报表数据关系：1+2-5-6=10；10+11-12=15；16+17+18=21 ；21-22-23-24=28；</td>
                </tr>
                </tbody>
            </table>
        </div>
    </dit>
</div>
<div class="btn-box">
    <input type="submit" value="确定" class="btn-common js-save">
    <input type="button" value="取消" class="btn-common js-btn-cancel">
</div>

</form>

<jsp:include page="../../common/footer.jsp"></jsp:include>

<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/component/dropDown.js"/>"></script>

<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/client/yr/auxtab/incstatement_edit.js"/>"></script>

</body>
</html>