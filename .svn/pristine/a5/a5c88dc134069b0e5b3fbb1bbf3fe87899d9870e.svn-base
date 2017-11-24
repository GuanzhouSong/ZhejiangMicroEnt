<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<c:set var="entCatg" value="${yrRegCheck.entTypeCatg}"/>
<c:set var="entCatgBranch" value="12,14,32,34,22,23,24,25,26,28"/>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title></title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/sment/sment.server.css">

</head>
<style type="text/css">
    .center {
        text-align: center;
    }
</style>
<body class="pd10">
<div class="clearfix">
    <c:if test="${fn:indexOf('16,17,50',entCatg) == -1}">
        <h4 class="h4-title mt10">企业基本信息</h4>
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
            <tr>
                <td class="bg-gray right" width="21%">企业名称</td>
                <td width="29%">${baseInfo.entName}</td>
                <td class="bg-gray right" width="20%">注册号</td>
                <td width="30%">${(!empty baseInfo.uniCode)?baseInfo.uniCode:baseInfo.regNO}</td>
            </tr>
            <tr>
                <td class="bg-gray right">企业通信地址</td>
                <td>${baseInfo.addr}</td>
                <td class="bg-gray right">邮政编码</td>
                <td>${baseInfo.postalCode}</td>
            </tr>
            <tr>
                <td class="bg-gray right">联系电话</td>
                <td>${baseInfo.tel}</td>
                <td class="bg-gray right">电子邮箱</td>
                <td>${baseInfo.email}</td>
            </tr>
            <tr>
	            <td class="bg-gray right">从业人数</td>
	            <td>
	                ${empty baseInfo.empNum?'0':baseInfo.empNum}人&nbsp;&nbsp;&nbsp;
	                <c:if test="${baseInfo.empNumDis == '1'}">公示</c:if>
	                <c:if test="${baseInfo.empNumDis == '0'}">不公示</c:if>
	            </td>
	            <td class="bg-gray right">企业营业状态</td>
	            <td>${baseInfo.busStatusCN}</td>
	        </tr>
	        <c:if test="${fn:indexOf(entCatgBranch,entCatg) != -1}">
	            <tr>
	                 <td class="bg-gray right">隶属企业统一社会信用代码/注册号：</td>
	                 <td>${baseInfo.supRegNO}</td>
	                 <td class="bg-gray right">隶属企业名称：</td>
	                 <td>${baseInfo.supEntname}</td>
	            </tr>
	        </c:if>
	        <c:if test="${yrRegCheck.year > 2015}">
	           <tr>
		            <td class="bg-gray right">其中女性从业人数</td>
		            <td>
		                ${empty baseInfo.femaleEmploye?'0':baseInfo.femaleEmploye}人&nbsp;&nbsp;&nbsp;
		                <c:if test="${baseInfo.femaleEmployeIsPub == '1'}">公示</c:if>
		                <c:if test="${baseInfo.femaleEmployeIsPub == '0'}">不公示</c:if>
		            </td>
		            <td class="bg-gray right">企业主营业务活动 </td>
	                <td>${baseInfo.entMainBusActivity}</td>
		        <tr>
	       </c:if>
	       <tr>
	           <td class="bg-gray right">是否有网站或网店</td>
	           <td id="isWebInfo"></td>
	           <td class="bg-gray right">是否有对外提供担保信息</td>
	           <td id="isForguarantee"></td>
	       </tr>
	       <c:if test="${yrRegCheck.year > 2015}">
	           <tr>
		            <td class="bg-gray right">企业控股情况</td>
	                <td colspan="3">
	                	<c:choose>
                           <c:when test="${baseInfo.entControl=='1' }">
                               	国有控股
                           </c:when>
                           <c:when test="${baseInfo.entControl=='2' }">
                               	集体控股
                           </c:when>
                           <c:when test="${baseInfo.entControl=='3' }">
                              	 私人控股
                           </c:when>
                           <c:when test="${baseInfo.entControl=='4' }">
                               	港澳台商控股
                           </c:when>
                           <c:when test="${baseInfo.entControl=='5' }">
                               	外商控股
                           </c:when>
                           <c:when test="${baseInfo.entControl=='6' }">
                               	其他
                           </c:when>
                           <c:when test="${baseInfo.entControl=='7' }">
                               	私营企业
                           </c:when>
                           <c:otherwise>
                           		-
                           </c:otherwise>
                        </c:choose>
	                </td>
		        <tr>
	       </c:if>
            <c:if test="${fn:indexOf(entCatgBranch,entCatg) == -1}">
	          <tr>
	           <td class="bg-gray right">企业是否有对外投资设立企业信息</td>
	           <td id="isInvestInfo" colspan="3"></td>
	          </tr>
	       </c:if>
	       <c:if test="${entCatg == 11 || entCatg == 21}">
	          <tr>
	          <td class="bg-gray right">有限责任公司本年度是否发生股东股权转让</td>
	          <td id="isStockInfo" colspan="3"></td>
	        </tr>
	       </c:if>
        </table>
    </c:if>

    <h4 class="h4-title mt10">网站信息</h4>
    <div class="start-copy">
        <table id="pubwebTable" border="0" cellspacing="0" cellpadding="0" width="100%" class="table-row mt30">
            <thead>
            <tr>
                <th>序号</th>
                <th>网站名称</th>
                <th>网站类型</th>
                <th>网站地址</th>
            </tr>
            </thead>
        </table>
    </div>

    <!-- 企业情况 -->
    <c:if test="${fn:indexOf('16,17,50',entCatg) == -1}">

        <h4 class="h4-title mt10">对外担保信息</h4>
        <div class="start-copy">
            <table id="guranteeTable" border="0" cellspacing="0" cellpadding="0" width="100%" class="table-row mt30">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>债权人</th>
                    <th>债务人</th>
                    <th>主债权种类</th>
                    <th>主债权数额(万元)</th>
                    <th>对外担保是否公示</th>
                    <th>保证的方式</th>
                </tr>
                </thead>
            </table>
        </div>

        <c:if test="${entCatg == 11 || entCatg == 21}">
            <div class="start-copy">
                <h4 class="h4-title mt10">投资人及出资信息</h4>
                <table id="subcaptalTable" border="0" cellspacing="0" cellpadding="0" width="100%"
                       class="table-row mt30">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>出资人名称(姓名)</th>
                        <th>注册号(或身份证号)</th>
                        <th>认缴出资额<br/>(万${currencyCn})</th>
                        <th>认缴出资方式</th>
                        <th>认缴出资日期</th>
                        <th>实缴出资额<br/>(万${currencyCn})</th>
                        <th>实缴出资方式</th>
                        <th>实缴出资日期</th>
                    </tr>
                    </thead>
                </table>
            </div>

            <h4 class="h4-title mt10">股权转让信息</h4>
            <div class="start-copy">
                <table id="alterStockTable" border="0" cellspacing="0" cellpadding="0" width="100%"
                       class="table-row mt30">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>股东</th>
                        <th>变更前股权比例</th>
                        <th>变更后股权比例</th>
                        <th>股权变更日期</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </c:if>

        <c:if test="${fn:indexOf(entCatgBranch,entCatg) == -1}">
            <h4 class="h4-title mt10">对外投资信息</h4>
            <div class="start-copy">
                <table id="forinvestMentTable" border="0" cellspacing="0" cellpadding="0" width="100%"
                       class="table-row mt30">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>对外投资企业统一社会信用代码</th>
                        <th>在中国境内投资设立或购买股权的企业名称</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </c:if>


        <h4 class="h4-title mt10">企业资产状况信息</h4>
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
            <c:if test="${fn:indexOf(entCatgBranch,entCatg) == -1}">
                <tr>
                    <td class="bg-gray right" width="20%">资产总额</td>
                    <td width="30%">
                        <fmt:formatNumber value="${baseInfo.assGro*10000}" pattern="###,###,###,##0.00"/> 元&nbsp;&nbsp;&nbsp;
                        <c:if test="${baseInfo.assGroIsPub == '1'}">公示</c:if>
                        <c:if test="${baseInfo.assGroIsPub == '0'}">不公示</c:if>
                    </td>
                    <td class="bg-gray right" width="20%">负债总额</td>
                    <td width="30%">
                        <fmt:formatNumber value="${baseInfo.liaGro*10000}" pattern="###,###,###,##0.00"/> 元&nbsp;&nbsp;&nbsp;
                        <c:if test="${baseInfo.liaGroIsPub == '1'}">公示</c:if>
                        <c:if test="${baseInfo.liaGroIsPub == '0'}">不公示</c:if>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" width="20%">营业总收入</td>
                    <td width="30%">
                        <fmt:formatNumber value="${baseInfo.vendInc*10000}" pattern="###,###,###,##0.00"/> 元&nbsp;&nbsp;&nbsp;
                        <c:if test="${baseInfo.vendIncIsPub == '1'}">公示</c:if>
                        <c:if test="${baseInfo.vendIncIsPub == '0'}">不公示</c:if>
                    </td>
                    <td class="bg-gray right" width="20%">利润总额</td>
                    <td width="30%">
                        <fmt:formatNumber value="${baseInfo.proGro*10000}" pattern="###,###,###,##0.00"/> 元&nbsp;&nbsp;&nbsp;
                        <c:if test="${baseInfo.proGroIsPub == '1'}">公示</c:if>
                        <c:if test="${baseInfo.proGroIsPub == '0'}">不公示</c:if>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" width="20%">其中：主营业务收入</td>
                    <td width="30%">
                        <fmt:formatNumber value="${baseInfo.maiBusInc*10000}" pattern="###,###,###,##0.00"/> 元&nbsp;&nbsp;&nbsp;
                        <c:if test="${baseInfo.maiBusIncIsPub == '1'}">公示</c:if>
                        <c:if test="${baseInfo.maiBusIncIsPub == '0'}">不公示</c:if>
                    </td>
                    <td class="bg-gray right" width="20%">净利润</td>
                    <td width="30%">
                        <fmt:formatNumber value="${baseInfo.netInc*10000}" pattern="###,###,###,##0.00"/> 元&nbsp;&nbsp;&nbsp;
                        <c:if test="${baseInfo.netIncIsPub == '1'}">公示</c:if>
                        <c:if test="${baseInfo.netIncIsPub == '0'}">不公示</c:if>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" width="20%">纳税总额</td>
                    <td width="30%">
                        <fmt:formatNumber value="${baseInfo.ratGro*10000}" pattern="###,###,###,##0.00"/> 元&nbsp;&nbsp;&nbsp;
                        <c:if test="${baseInfo.ratGroIsPub == '1'}">公示</c:if>
                        <c:if test="${baseInfo.ratGroIsPub == '0'}">不公示</c:if>
                    </td>
                    <td class="bg-gray right" width="20%">所有者权益合计</td>
                    <td width="30%">
                        <fmt:formatNumber value="${baseInfo.totEqu*10000}" pattern="###,###,###,##0.00"/> 元&nbsp;&nbsp;&nbsp;
                        <c:if test="${baseInfo.totEquIsPub == '1'}">公示</c:if>
                        <c:if test="${baseInfo.totEquIsPub == '0'}">不公示</c:if>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" width="20%">从业人数</td>
                    <td width="30%">
                            ${baseInfo.empNum}人&nbsp;&nbsp;&nbsp;
                        <c:if test="${baseInfo.empNumDis == '1'}">公示</c:if>
                        <c:if test="${baseInfo.empNumDis == '0'}">不公示</c:if>
                    </td>
                    <td class="bg-gray right" width="20%">${yrRegCheck.year}年是否依法交纳残保金</td>
                    <td width="30%">
                        <c:if test="${baseInfo.isLegPay == '1'}">是</c:if>
                        <c:if test="${baseInfo.isLegPay == '0'}">否</c:if>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" width="20%">从业人员中属于残疾人</td>
                    <td width="30%">
                            ${(!empty baseInfo.disableMgr)?baseInfo.disableMgr:baseInfo.disOpers} 人
                    </td>
                    <td class="bg-gray right" width="20%">企业应安置残疾人员数</td>
                    <td width="30%">
                            ${baseInfo.entOugthSetDis} 人
                    </td>
                </tr>
            </c:if>
            <c:if test="${fn:indexOf(entCatgBranch,entCatg) != -1}">
                <tr>
                    <td class="bg-gray right" width="20%">其中：主营业务收入</td>
                    <td width="30%">
                        <fmt:formatNumber value="${baseInfo.maiBusInc*10000}" pattern="###,###,###,##0.00"/> 元&nbsp;&nbsp;&nbsp;
                        <c:if test="${baseInfo.maiBusIncIsPub == '1'}">公示</c:if>
                        <c:if test="${baseInfo.maiBusIncIsPub == '0'}">不公示</c:if>
                    </td>
                    <td class="bg-gray right" width="20%">纳税总额</td>
                    <td width="30%">
                        <fmt:formatNumber value="${baseInfo.ratGro*10000}" pattern="###,###,###,##0.00"/> 元&nbsp;&nbsp;&nbsp;
                        <c:if test="${baseInfo.ratGroIsPub == '1'}">公示</c:if>
                        <c:if test="${baseInfo.ratGroIsPub == '0'}">不公示</c:if>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" width="20%">净利润</td>
                    <td width="30%">
                        <fmt:formatNumber value="${baseInfo.netInc*10000}" pattern="###,###,###,##0.00"/> 元&nbsp;&nbsp;&nbsp;
                        <c:if test="${baseInfo.netIncIsPub == '1'}">公示</c:if>
                        <c:if test="${baseInfo.netIncIsPub == '0'}">不公示</c:if>
                    </td>
                    <td class="bg-gray right" width="20%">从业人数</td>
                    <td width="30%">
                            ${baseInfo.empNum}人&nbsp;&nbsp;&nbsp;
                        <c:if test="${baseInfo.empNumDis == '1'}">公示</c:if>
                        <c:if test="${baseInfo.empNumDis == '0'}">不公示</c:if>
                    </td>
                </tr>
            </c:if>
        </table>
        
        <c:if test="${yrRegCheck.year > 2015}">
	         <h4 class="h4-title mt10">社保信息</h4>
	         <div class="start-copy">
	         <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-row mt30" style="margin-bottom: 50px">
	           <thead>
	                 <tr>
                        <th  width="20%">参保险种</th>
                        <th  width="20%">参保人数（人）</th>
                        <th  width="20%">单位缴费基数（万元）</th>
                        <th  width="20%">本期实际缴费金额（万元）</th>
                        <th  width="20%">单位累计欠缴金额（万元）</th>
                    </tr>
                      <tr>
                        <td>城镇职工基本养老保险</td>
                        <td>${baseInfo.endowmentNum}</td>
                        <td>${baseInfo.paymentEndowment}</td>
                        <td>${baseInfo.actualPayEndowment}</td>
                        <td>${baseInfo.cumuEndowment}</td>
                    </tr>
                    <tr>
                        <td>失业保险</td>
                        <td>${baseInfo.unemploymentNum}</td>
                        <td>${baseInfo.paymentUnemployment}</td>
                        <td>${baseInfo.actualPayUnemployment}</td>
                        <td>${baseInfo.cumuUnemployment}</td>
                    </tr>
                    <tr>
                        <td>职工基本医疗保险</td>
                        <td>${baseInfo.medicalNum}</td>
                        <td>${baseInfo.paymentMedical}</td>
                        <td>${baseInfo.actualPayMedical}</td>
                        <td>${baseInfo.cumuMedical}</td>
                    </tr>
                    <tr>
                        <td>工伤保险</td>
                        <td>${baseInfo.empInjuryNum}</td>
                        <td>${baseInfo.paymentEmpInjury}</td>
                        <td>${baseInfo.actualPayEmpInjury}</td>
                        <td>${baseInfo.cumuEmpInjury}</td>
                    </tr>
                    <tr>
                        <td>生育保险</td>
                        <td>${baseInfo.maternityNum}</td>
                        <td>${baseInfo.paymentMaternity}</td>
                        <td>${baseInfo.actualPayMaternity}</td>
                        <td>${baseInfo.cumuMaternity}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td>${baseInfo.paymentBaseIsPub=='1'?'公示':'不公示'}</td>
                        <td>${baseInfo.actualPaymentIsPub=='1'?'公示':'不公示'}</td>
                        <td>${baseInfo.cumulArrearsIsPub=='1'?'公示':'不公示'}</td>
                    </tr>
                </thead>
	         </table>
	         </div>
        </c:if>
    </c:if>

    <h4 class="h4-title mt10">修改记录</h4>
    <div class="start-copy">
        <table id="modHisTable" border="0" cellspacing="0" cellpadding="0" width="100%" class="table-row mt30">
            <thead>
            <tr>
                <th>序号</th>
                <th>修改事项</th>
                <th>修改前</th>
                <th>修改后</th>
                <th>修改日期</th>
            </tr>
            </thead>
        </table>
    </div>

    <div class="form-box mt20 pdr20">
        <input type="hidden" id="entTypeCatg" name="entTypeCatg" value="${yrRegCheck.entTypeCatg}">
        <c:if test="${fn:indexOf('16,17,50',entCatg) == -1}">
            <input type="hidden" id="anCheID" value="${baseInfo.anCheID}"/>
        </c:if>
    </div>
</div>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/yr/pubforbidresult/edit_main.js"></script>
</body>
</html>