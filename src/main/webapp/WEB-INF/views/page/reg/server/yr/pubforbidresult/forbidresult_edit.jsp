<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="hx" uri="/WEB-INF/tld/hx.tld"%>
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
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <title>敏感词审核</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    
</head>
<body>
<div class="pd20 clearfix">

<div id="Prompting_show" style="font-size: 16px;text-align: center;color: red;">☼温馨提示☼：由于页面数据加载量比较大,请您耐心等待,页面加载完成后再进行页面操作!</div>
<div class="clearfix reg-company-basic reg-company-basic-yellowish">
    <div class="clearfix reg-caption">
        <div class="title clearfix">
            <span class="name fl mr5">${midBaseInfo.entName}</span>
            <span class="${hx:yReportStyle(midBaseInfo.regState)}">${hx:publicStatus(midBaseInfo.regState)}</span>
            <span class="icon-rectangle blue fl mr10">${midBaseInfo.isIndivid=='1'?'个转企':''}</span>
            <c:if test="${isOpanomaly=='1'}">
                <span class="icon-rectangle red fl mr10">被列入经营异常名录和严重违法失信（黑名单）</span>
            </c:if>

            <c:if test="${isOpanomaly=='2'}">
                <span class="icon-rectangle red fl mr10">被列入经营异常名录</span>
            </c:if>

            <c:if test="${isOpanomaly=='3'}">
                <span class="icon-rectangle red fl mr10">被列入严重违法失信（黑名单）</span>
            </c:if>
        </div>
        <div class="clearfix">
            <p class="w360">
                <i class="book2-icon"></i>统一社会信用代码/注册号：<span>${!empty midBaseInfo.uniCode?midBaseInfo.uniCode:midBaseInfo.regNO}</span>
            </p>
            <p>
                <i class="local-icon"></i>登记机关：<span>${midBaseInfo.regOrgName}</span>
            </p>
        </div>
        <div class="clearfix">
            <p class="w360">
                <i class="person-icon"></i>法定代表人：<span>${midBaseInfo.leRep}</span>
            </p>
            <p>
                <i class="government-icon"></i>管辖单位：<span>${midBaseInfo.localAdmName}</span>
            </p>
        </div>

        <div class="clearfix">
            <p class="w360">
                <i class="capital-icon"></i>注册资本：
                <span>
                    <c:if test="${!empty midBaseInfo.regCap}">
                        <fmt:formatNumber type="number"  value=" ${midBaseInfo.regCap }"  pattern="0.00" maxFractionDigits="2"/>(万元)
                    </c:if>
                </span>
            </p>
            <c:if test="${midBaseInfo.regState!='D'&&midBaseInfo.regState!='DX'}">
                <p><i class="date-icon"></i>成立日期：<span>2014-6-30</span></p>
            </c:if>
        </div>

       <div class="clearfix">
           <c:if test="${midBaseInfo.regState=='D'}">
               <p class="w360">
                   <i class="date-icon"></i>吊销日期：<span><fmt:formatDate value="${midBaseInfo.altDate}" dateStyle="long"/></span>
               </p>
           </c:if>

           <c:if test="${midBaseInfo.regState=='DX'}">
               <p>
                   <i class="date-icon"></i> 注销日期：<span class="light"><fmt:formatDate value="${midBaseInfo.altDate}" dateStyle="long" /></span>
               </p>
           </c:if>
       </div>

       <div class="clearfix">
           <c:if test="${midBaseInfo.isIndivid=='1'}">
               <p>
                   <i class="date-icon"></i> 转企日期：<span class="light">${midBaseInfo.individDate}</span>
               </p>
           </c:if>
           <p>
               <i></i>&nbsp;<span class="light">&nbsp;</span>
           </p>
       </div>

<%--         <c:if test="${yrRegCheck.isReported == 1 || yrRegCheck.isReported == 2}"> --%>
        
<!--             <div class="btn-box"> -->
<!--                 <div class="mb5 clearfix"> -->
<!--                     <a class="btn-print-box" style="width: 162px;"> -->
<!--                         <i class="print-icon2"></i> -->
<!--                         <span class="dy-report-bg">打印年度报告</span> -->
<%--                         <c:if test="${fn:indexOf('16,17,50',midBaseInfo.entTypeCatg) == -1}"> --%>
<%--                             <input type="hidden" class="js-reprot-year" value="<c:url value="/reg/server/reportprint/showReportProvePage"/>"> --%>
<%--                         </c:if> --%>
<%--                         <c:if test="${midBaseInfo.entTypeCatg == 16 || midBaseInfo.entTypeCatg == 17}"> --%>
<%--                             <input type="hidden" class="js-reprot-year" value="<c:url value="/reg/server/reportprint/showSfcReportProve"/>"> --%>
<%--                         </c:if> --%>
<%--                         <c:if test="${entCatg == 50}"> --%>
<%--                             <input type="hidden" class="js-reprot-year" value="<c:url value="/reg/server/reportprint/showPbReportProve"/>"> --%>
<%--                         </c:if> --%>
<!--                     </a> -->
<!--                 </div> -->
<!--                 <div> -->
<!--                     <a class="btn-print-box" style="width: 162px;"> -->
<!--                         <i class="print-icon2"></i> -->
<!--                         <span class="dy-reprot-zm">打印年度报告证明</span> -->
<%--                         <c:if test="${fn:indexOf('16,17,50',midBaseInfo.entTypeCatg) == -1}"> --%>
<%--                             <input type="hidden" class="js-reprot-zm" value="<c:url value="/reg/server/reportprint/showEnAnnualReportProve"/>"> --%>
<%--                         </c:if> --%>
<%--                         <c:if test="${midBaseInfo.entTypeCatg == 16 || midBaseInfo.entTypeCatg == 17}"> --%>
<%--                             <input type="hidden" class="js-reprot-zm" value="<c:url value="/reg/server/reportprint/printPubSfcPrintProve"/>"> --%>
<%--                         </c:if> --%>
<%--                         <c:if test="${entCatg == 50}"> --%>
<%--                             <input type="hidden" class="js-reprot-zm" value="<c:url value="/reg/server/reportprint/printPubPbPrintProve"/>"> --%>
<%--                         </c:if> --%>
<!--                     </a> -->
<!--                 </div> -->
<!--             </div> -->
<%--         </c:if> --%>

    </div>
    <c:if test="${erEscAppinfo.simplecanRea=='4'}">
        <div class="notice"><i class="notice-icon"></i>正在进行简易注销公告：公告期：<fmt:formatDate value="${erEscAppinfo.noticeFrom}" pattern="yyyy年MM月dd日"/>-<fmt:formatDate value="${erEscAppinfo.noticeTo}" pattern="yyyy年MM月dd日"/></div>
    </c:if>
</div>

<div class="supervise-about mt5 mb5">
    <div class="more js-fold reverse" style="cursor: pointer">展开详情<i></i></div>
</div>


<table cellpadding="0" cellspacing="0" border="0" class="table-horizontal  js-table-horizontal" style="display: none;">
    <tbody>
    <tr>
        <td class="bg-gray right" width="15%">类型</td>
        <td>${midBaseInfo.entTypeName}</td>
        <td class="bg-gray right">核准日期</td>
        <td><fmt:formatDate value="${midBaseInfo.apprDate}" dateStyle="long"/></td>
    </tr>
    <tr>
        <td class="bg-gray right">住所</td>
        <td>${midBaseInfo.dom}</td>
        <td class="bg-gray right">营业期限</td>
        <td><fmt:formatDate value="${midBaseInfo.opFrom}" dateStyle="long"/>至<fmt:formatDate value="${midBaseInfo.opTo}" dateStyle="long"/></td>
    </tr>
    <tr>
        <td class="bg-gray right">经营范围</td>
        <td colspan="3">${midBaseInfo.opScope}</td>
    </tr>
    </tbody>
</table>
<div class="light-info mt10">
    <div class="form-list light ">
        <div class="form-item clearfix">
            <div id="uniCode" class="col-4">
                <label class="right col-6">法定代表人（负责人）：</label>
                <div class="col-6">
                    ${midBaseInfo.leRep}  &nbsp;&nbsp;   ${midBaseInfo.tel}
                </div>
            </div>
            <div class="col-4" >
                <label class="right col-6">工商联络员：</label>
                <div class="col-6">
                    ${pubEppassword.lianame}  &nbsp;&nbsp;  ${pubEppassword.tel}
                </div>
            </div>
        </div>
    </div>
</div>

<!-- <div class="bg-gray2 clearfix company-info-title"> -->
<%-- <h3 class="h3-title">${yrRegCheck.entName}</h3> --%>
<%--     统一社会信用代码/注册号：${(!empty yrRegCheck.uniCode)?yrRegCheck.uniCode:yrRegCheck.regNO} --%>
<!-- </div> -->
<div class="supervise-about mt5 mb5">
    <div class="more js-fold-pubinfo reverse" style="cursor: pointer">展开公示详情<i></i></div>
</div>
<div class="js-pubinfo" style="display: none;">
  <c:if test="${fn:indexOf('16,17,50',entCatg) == -1}">
   <h4 class="h4-title mt10">企业基本信息</h4>
   <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal" style="margin-bottom: 50px">
        <tr>
            <td class="bg-gray right" width="21%">企业名称</td>
            <td width="29%">${BaseInfo.entName}</td>
            <td class="bg-gray right" width="20%">统一社会信用代码/注册号：</td>
            <td width="30%">${(!empty BaseInfo.uniCode)?BaseInfo.uniCode:BaseInfo.regNO}</td>
        </tr>
        <tr>
            <td class="bg-gray right">企业通信地址</td>
            <td>${BaseInfo.addr}</td>
            <td class="bg-gray right">邮政编码</td>
            <td>${BaseInfo.postalCode}</td>
        </tr>
        <tr>
            <td class="bg-gray right">联系电话</td>
            <td>${BaseInfo.tel}</td>
            <td class="bg-gray right">电子邮箱</td>
            <td>${BaseInfo.email}</td>
        </tr>
        <tr>
            <td class="bg-gray right">从业人数</td>
            <td>
                ${empty BaseInfo.empNum?'0':BaseInfo.empNum}人&nbsp;&nbsp;&nbsp;
                <c:if test="${BaseInfo.empNumDis == '1'}">公示</c:if>
                <c:if test="${BaseInfo.empNumDis == '0'}">不公示</c:if>
            </td>
            <td class="bg-gray right">企业营业状态</td>
            <td>${BaseInfo.busStatusCN}</td>
        </tr>
        <c:if test="${fn:indexOf(entCatgBranch,entCatg) != -1}">
            <tr>
                 <td class="bg-gray right">隶属企业统一社会信用代码/注册号：</td>
                 <td>${BaseInfo.supRegNO}</td>
                 <td class="bg-gray right">隶属企业名称：</td>
                 <td>${BaseInfo.supEntname}</td>
            </tr>
        </c:if>
        <c:if test="${yrRegCheck.year > 2015}">
           <tr>
	            <td class="bg-gray right">其中女性从业人数</td>
	            <td>
	                ${empty BaseInfo.femaleEmploye?'0':BaseInfo.femaleEmploye}人&nbsp;&nbsp;&nbsp;
	                <c:if test="${BaseInfo.femaleEmployeIsPub == '1'}">公示</c:if>
	                <c:if test="${BaseInfo.femaleEmployeIsPub == '0'}">不公示</c:if>
	            </td>
	            <td class="bg-gray right">企业主营业务活动</td>
                <td>${BaseInfo.entMainBusActivity}</td>
	        <tr>
       </c:if>
        <tr>
           <td class="bg-gray right">是否有网站或网店</td>
           <td id="isWebInfo"></td>
           <td class="bg-gray right">是否有对外提供担保信息</td>
           <td id="isForguarantee"></td>
       </tr>
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
      
    <c:if test="${fn:indexOf('16,17',entCatg) != -1}">
      <h4 class="h4-title mt10">基本信息</h4>
      <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal" style="margin-bottom: 50px">
            <tr>
                <td class="bg-gray right" width="20%">名称</td>
                <td>${sfcBaseInfo.farSpeArtName}</td>
                <td class="bg-gray right" width="25%">统一社会信用代码/注册号：</td>
                <td>${(!empty sfcBaseInfo.uniCode)?sfcBaseInfo.uniCode:sfcBaseInfo.regNO}</td>
            </tr>
            <tr>
                <td class="bg-gray right">联系电话</td>
                <td>${sfcBaseInfo.tel}</td>
                <td class="bg-gray right">电子邮箱</td>
                <td>${sfcBaseInfo.email}</td>
            </tr>
            <tr>
                <td class="bg-gray right">成员人数</td>
                <td>${sfcBaseInfo.memNum}人</td>
                <td class="bg-gray right">农民人数</td>
                <td>${sfcBaseInfo.farnum}人</td>
            </tr>
             <tr>
                <td class="bg-gray right">本年度新增成员人数</td>
                <td>${sfcBaseInfo.annNewMemNum}人</td>
                <td class="bg-gray right">本年度退出成员人数</td>
                <td>${sfcBaseInfo.annRedMemNum}人</td>
            </tr>
            <tr>
               <td class="bg-gray right">从业人数</td>
               <td>
	                ${empty sfcBaseInfo.empNum?'0':sfcBaseInfo.empNum}人&nbsp;&nbsp;&nbsp;
	                <c:if test="${sfcBaseInfo.empNumDis == '1'}">公示</c:if>
	                <c:if test="${sfcBaseInfo.empNumDis == '0'}">不公示</c:if>
               </td>
	           <td class="bg-gray right">其中女性从业人数</td>
	           <td>
	                ${empty sfcBaseInfo.femaleEmploye?'0':sfcBaseInfo.femaleEmploye}人&nbsp;&nbsp;&nbsp;
	                <c:if test="${sfcBaseInfo.femaleEmployeIsPub == '1'}">公示</c:if>
	                <c:if test="${sfcBaseInfo.femaleEmployeIsPub == '0'}">不公示</c:if>
	           </td>
            </tr>
            <tr>
	               <td class="bg-gray right">通信地址</td>
	               <td colspan="3">${sfcBaseInfo.dom}</td>
	        </tr>
            <c:if test="${yrRegCheck.year > 2015}">
	          <tr>
	               <td class="bg-gray right">企业主营业务活动</td>
	               <td colspan="3">${sfcBaseInfo.entMainBusActivity}</td>
	          </tr>
       		</c:if>
         </table>
      </c:if>
      
      <c:if test="${entCatg == 50}">
      <h4 class="h4-title mt10">基本信息</h4>
      <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal" style="margin-bottom: 50px">
            <tr>
                <td class="bg-gray right" width="20%">名称</td>
                <td>${pbBaseInfo.traName}</td>
                <td class="bg-gray right" width="25%">经营者姓名</td>
                <td>${pbBaseInfo.name}</td>
            </tr>
            <tr>
                <td class="bg-gray right">营业执照注册号</td>
                <td>${pbBaseInfo.regNO}</td>
                <td class="bg-gray right">对外公开联系电话</td>
                <td>${pbBaseInfo.tel}</td>
            </tr>
            <tr>
                <td class="bg-gray right">资金数额</td>
                <td><fmt:formatNumber value="${pbBaseInfo.fundAm}" pattern="###,###,###,##0.0000"/>万元</td>
                <td class="bg-gray right">从业人数</td>
                <td>${pbBaseInfo.empNum}人</td>
            </tr>
         </table>
      </c:if>
      
     <c:if test="${entCatg == 50 || entCatg == 16 || entCatg == 17}">
	    <h4 class="h4-title mt10">行政许可信息</h4>
	    <div class="start-copy">
	    <table id="pubLicenceTable" border="0" cellspacing="0" cellpadding="0" width="100%" class="table-row mt30">
	        <thead>
	        <tr>
	            <th>序号</th>
	            <th>许可文件名称</th>
	            <th>有效期至</th>
	        </tr>
	        </thead>
	    </table>
	    </div>
    </c:if>
    
    
    <c:if test="${entCatg == 50}">
      <h4 class="h4-title mt10">生产经营情况信息</h4>
      <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
            <tr>
                <td class="bg-gray right" width="25%">销售额或营业收入</td>
                <td><fmt:formatNumber value="${pbBaseInfo.vendInc}" pattern="###,###,###,##0.0000"/>&nbsp;万元</td>
                <td class="bg-gray right" width="25%">纳税总额</td>
                <td><fmt:formatNumber value="${pbBaseInfo.ratGro}" pattern="###,###,###,##0.0000"/>&nbsp;万元</td>
            </tr>
       </table>
</c:if>

<c:if test="${fn:indexOf('16,17',entCatg) != -1}">
      <h4 class="h4-title mt10">资产状况信息</h4>
      <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal" style="margin-bottom: 50px">
            <tr>
                <td class="bg-gray right" width="20%">销售额或营业收入</td>
                <td><fmt:formatNumber value="${sfcBaseInfo.vendInc*10000}" pattern="###,###,###,##0.00"/> &nbsp;元</td>
                <td class="bg-gray right" width="25%">盈余总额</td>
                <td><fmt:formatNumber value="${sfcBaseInfo.priYeaProfit*10000}" pattern="###,###,###,##0.00"/> &nbsp;元</td>
            </tr>
            <tr>
                <td class="bg-gray right">纳税金额</td>
                <td><fmt:formatNumber value="${sfcBaseInfo.ratGro*10000}" pattern="###,###,###,##0.00"/> &nbsp;元</td>
                <td class="bg-gray right">获得政府扶持资金、补助</td>
                <td><fmt:formatNumber value="${sfcBaseInfo.priYeaSub*10000}" pattern="###,###,###,##0.00"/> &nbsp;元</td>
            </tr>
            <tr>
                <td class="bg-gray right">金融贷款</td>
                <td><fmt:formatNumber value="${sfcBaseInfo.priYeaLoan*10000}" pattern="###,###,###,##0.00"/> &nbsp;元</td>
                <td class="bg-gray right"></td>
                <td></td>
            </tr>
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
                        <td>${sfcBaseInfo.endowmentNum}</td>
                        <td><fmt:formatNumber value="${sfcBaseInfo.paymentEndowment}" pattern="###,###,###,##0.0000"/></td>
                        <td><fmt:formatNumber value="${sfcBaseInfo.actualPayEndowment}" pattern="###,###,###,##0.0000"/></td>
                        <td><fmt:formatNumber value="${sfcBaseInfo.cumuEndowment}" pattern="###,###,###,##0.0000"/></td>
                    </tr>
                    <tr>
                        <td>失业保险</td>
                        <td>${sfcBaseInfo.unemploymentNum}</td>
                        <td><fmt:formatNumber value="${sfcBaseInfo.paymentUnemployment}" pattern="###,###,###,##0.0000"/></td>
                        <td><fmt:formatNumber value="${sfcBaseInfo.actualPayUnemployment}" pattern="###,###,###,##0.0000"/></td>
                        <td><fmt:formatNumber value="${sfcBaseInfo.cumuUnemployment}" pattern="###,###,###,##0.0000"/></td>
                    </tr>
                    <tr>
                        <td>职工基本医疗保险</td>
                        <td>${sfcBaseInfo.medicalNum}</td>
                        <td><fmt:formatNumber value="${sfcBaseInfo.paymentMedical}" pattern="###,###,###,##0.0000"/></td>
                        <td><fmt:formatNumber value="${sfcBaseInfo.actualPayMedical}" pattern="###,###,###,##0.0000"/></td>
                        <td><fmt:formatNumber value="${sfcBaseInfo.cumuMedical}" pattern="###,###,###,##0.0000"/></td>
                    </tr>
                    <tr>
                        <td>工伤保险</td>
                        <td>${sfcBaseInfo.empInjuryNum}</td>
                        <td><fmt:formatNumber value="${sfcBaseInfo.paymentEmpInjury}" pattern="###,###,###,##0.0000"/></td>
                        <td><fmt:formatNumber value="${sfcBaseInfo.actualPayEmpInjury}" pattern="###,###,###,##0.0000"/></td>
                        <td><fmt:formatNumber value="${sfcBaseInfo.cumuEmpInjury}" pattern="###,###,###,##0.0000"/></td>
                    </tr>
                    <tr>
                        <td>生育保险</td>
                        <td>${sfcBaseInfo.maternityNum}</td>
                        <td><fmt:formatNumber value="${sfcBaseInfo.paymentMaternity}" pattern="###,###,###,##0.0000"/></td>
                        <td><fmt:formatNumber value="${sfcBaseInfo.actualPayMaternity}" pattern="###,###,###,##0.0000"/></td>
                        <td><fmt:formatNumber value="${sfcBaseInfo.cumuMaternity}" pattern="###,###,###,##0.0000"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td>${sfcBaseInfo.paymentBaseIsPub=='1'?'公示':'不公示'}</td>
                        <td>${sfcBaseInfo.actualPaymentIsPub=='1'?'公示':'不公示'}</td>
                        <td>${sfcBaseInfo.cumulArrearsIsPub=='1'?'公示':'不公示'}</td>
                    </tr>
                </thead>
	         </table>
	         </div>
        </c:if>
         
      <h4 class="h4-title mt10">分支机构信息</h4>
      <div class="start-copy">
	      <table id="sfcBranchtable" border="0" cellspacing="0" cellpadding="0" width="100%" class="table-row mt30">
	        <thead>
	        <tr>
	            <th>序号</th>
	            <th>分支机构统一社会信用代码/注册号</th>
	            <th>分支机构名称</th>
	        </tr>
	        </thead>
	      </table>
      </div>
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
		    <table id="subcaptalTable" border="0" cellspacing="0" cellpadding="0" width="100%" class="table-row mt30">
		        <thead>
		        <tr>
		            <th>序号</th>
		            <th>出资人名称(姓名)</th>
		            <th>注册号(或身份证号)</th>
		            <th>认缴出资额(万元)</th>
		            <th>认缴出资方式</th>
		            <th>认缴出资日期</th>
		            <th>实缴出资额(万元)</th>
		            <th>实缴出资方式</th>
		            <th>实缴出资日期</th>
		        </tr>
		        </thead>
		    </table>
		    </div>
	    
		    <h4 class="h4-title mt10">股权转让信息</h4>
		    <div class="start-copy">
		    <table id="alterStockTable" border="0" cellspacing="0" cellpadding="0" width="100%" class="table-row mt30">
		        <thead>
		        <tr>
		            <th>序号</th>
		            <th>股东</th>
		            <th>变更前股权比例（%）</th>
		            <th>变更后股权比例（%）</th>
		            <th>股权变更日期</th>
		        </tr>
		        </thead>
		    </table>
		    </div>
	    </c:if>

	    <c:if test="${fn:indexOf(entCatgBranch,entCatg) == -1}"> 
		    <h4 class="h4-title mt10">对外投资信息</h4>
		    <div class="start-copy">
		    <table id="forinvestMentTable" border="0" cellspacing="0" cellpadding="0" width="100%" class="table-row mt30">
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
      <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal" style="margin-bottom: 50px">
       <c:if test="${fn:indexOf(entCatgBranch,entCatg) == -1}">
                    <tr>
		         		<td class="bg-gray right" width="20%">资产总额</td>
		         		<td width="30%">
		         			<fmt:formatNumber value="${BaseInfo.assGro*10000}" pattern="###,###,###,##0.00"/> 元&nbsp;&nbsp;&nbsp;
		         			<c:if test="${BaseInfo.assGroIsPub == '1'}">公示</c:if>
                    		<c:if test="${BaseInfo.assGroIsPub == '0'}">不公示</c:if>
		         		</td>
		         		<td class="bg-gray right" width="20%">负债总额</td>
		         		<td width="30%">
		         			<fmt:formatNumber value="${BaseInfo.liaGro*10000}" pattern="###,###,###,##0.00"/> 元&nbsp;&nbsp;&nbsp;
		         			<c:if test="${BaseInfo.liaGroIsPub == '1'}">公示</c:if>
                    		<c:if test="${BaseInfo.liaGroIsPub == '0'}">不公示</c:if>
		         		</td>
		        	</tr>
		        	<tr>
		         		<td class="bg-gray right" width="20%">营业总收入</td>
				 		<td width="30%">
		         			<fmt:formatNumber value="${BaseInfo.vendInc*10000}" pattern="###,###,###,##0.00"/> 元&nbsp;&nbsp;&nbsp;
		         			<c:if test="${BaseInfo.vendIncIsPub == '1'}">公示</c:if>
                    		<c:if test="${BaseInfo.vendIncIsPub == '0'}">不公示</c:if>
		         		</td>
				 		<td class="bg-gray right" width="20%">利润总额</td>
				 		<td width="30%">
		         			<fmt:formatNumber value="${BaseInfo.proGro*10000}" pattern="###,###,###,##0.00"/> 元&nbsp;&nbsp;&nbsp;
		         			<c:if test="${BaseInfo.proGroIsPub == '1'}">公示</c:if>
                    		<c:if test="${BaseInfo.proGroIsPub == '0'}">不公示</c:if>
		         		</td>
		        	</tr>
			    	<tr>
		         		<td class="bg-gray right" width="20%">其中：主营业务收入</td>
				 		<td width="30%">
		         			<fmt:formatNumber value="${BaseInfo.maiBusInc*10000}" pattern="###,###,###,##0.00"/> 元&nbsp;&nbsp;&nbsp;
		         			<c:if test="${BaseInfo.maiBusIncIsPub == '1'}">公示</c:if>
                    		<c:if test="${BaseInfo.maiBusIncIsPub == '0'}">不公示</c:if>
		         		</td>
				 		<td class="bg-gray right" width="20%">净利润</td>
				 		<td width="30%">
		         			<fmt:formatNumber value="${BaseInfo.netInc*10000}" pattern="###,###,###,##0.00"/> 元&nbsp;&nbsp;&nbsp;
		         			<c:if test="${BaseInfo.netIncIsPub == '1'}">公示</c:if>
                    		<c:if test="${BaseInfo.netIncIsPub == '0'}">不公示</c:if>
		         		</td>
		        	</tr>
			    	<tr>
		         		<td class="bg-gray right" width="20%">纳税总额</td>
				 		<td width="30%">
		         			<fmt:formatNumber value="${BaseInfo.ratGro*10000}" pattern="###,###,###,##0.00"/> 元&nbsp;&nbsp;&nbsp;
		         			<c:if test="${BaseInfo.ratGroIsPub == '1'}">公示</c:if>
                    		<c:if test="${BaseInfo.ratGroIsPub == '0'}">不公示</c:if>
		         		</td>
				 		<td class="bg-gray right" width="20%">所有者权益合计</td>
				 		<td width="30%">
		         			<fmt:formatNumber value="${BaseInfo.totEqu*10000}" pattern="###,###,###,##0.00"/> 元&nbsp;&nbsp;&nbsp;
		         			<c:if test="${BaseInfo.totEquIsPub == '1'}">公示</c:if>
                    		<c:if test="${BaseInfo.totEquIsPub == '0'}">不公示</c:if>
		         		</td>
		        	</tr>
		        	<tr>
		        		<td class="bg-gray right" width="20%">${yrRegCheck.year}年是否依法交纳残保金</td>
		        		<td width="30%">
			        			<c:if test="${BaseInfo.isLegPay == '1'}">是</c:if>
	                    		<c:if test="${BaseInfo.isLegPay == '0'}">否</c:if>
		        		</td>
		        		<td class="bg-gray right" width="20%">从业人员中属于残疾人</td>
			         	<td width="30%">
			         		${empty BaseInfo.disableMgr?'0':BaseInfo.disableMgr} 人
			         	</td>
		        	</tr>
		        	<tr>
		        	    <td class="bg-gray right" width="20%">企业应安置残疾人员数</td>
		        		<td width="30%">
		        			${empty BaseInfo.entOugthSetDis?'0':BaseInfo.entOugthSetDis} 人
		        		</td>
		        		<td class="bg-gray right" width="20%">企业已安置残疾人员数</td>
		        		<td width="30%">
		        			${empty BaseInfo.entSetDis?'0':BaseInfo.entSetDis} 人
		        		</td>
		        	</tr>
            </c:if>
            <c:if test="${fn:indexOf(entCatgBranch,entCatg) != -1}">
                    <tr>
						<td class="bg-gray right" width="20%">其中：主营业务收入</td>
				 		<td width="30%">
		         			<fmt:formatNumber value="${BaseInfo.maiBusInc*10000}" pattern="###,###,###,##0.00"/> 元&nbsp;&nbsp;&nbsp;
		         			<c:if test="${BaseInfo.maiBusIncIsPub == '1'}">公示</c:if>
                    		<c:if test="${BaseInfo.maiBusIncIsPub == '0'}">不公示</c:if>
		         		</td>
				 		<td class="bg-gray right" width="20%">纳税总额</td>
				 		<td width="30%">
		         			<fmt:formatNumber value="${BaseInfo.ratGro*10000}" pattern="###,###,###,##0.00"/> 元&nbsp;&nbsp;&nbsp;
		         			<c:if test="${BaseInfo.ratGroIsPub == '1'}">公示</c:if>
                    		<c:if test="${BaseInfo.ratGroIsPub == '0'}">不公示</c:if>
		         		</td>
		        	</tr>
		        	<tr>
				 		<td class="bg-gray right" width="20%">净利润</td>
				 		<td width="30%">
		         			<fmt:formatNumber value="${BaseInfo.netInc*10000}" pattern="###,###,###,##0.00"/> 元&nbsp;&nbsp;&nbsp;
		         			<c:if test="${BaseInfo.netIncIsPub == '1'}">公示</c:if>
                    		<c:if test="${BaseInfo.netIncIsPub == '0'}">不公示</c:if>
		         		</td>
		        		<td class="bg-gray right" width="20%">从业人数</td>
			         	<td width="30%">
			         		${BaseInfo.empNum}人&nbsp;&nbsp;&nbsp;
			         		<c:if test="${BaseInfo.empNumDis == '1'}">公示</c:if>
                    		<c:if test="${BaseInfo.empNumDis == '0'}">不公示</c:if>
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
                        <td>${BaseInfo.endowmentNum}</td>
                        <td><fmt:formatNumber value="${BaseInfo.paymentEndowment}" pattern="###,###,###,##0.0000"/></td>
                        <td><fmt:formatNumber value="${BaseInfo.actualPayEndowment}" pattern="###,###,###,##0.0000"/></td>
                        <td><fmt:formatNumber value="${BaseInfo.cumuEndowment}" pattern="###,###,###,##0.0000"/></td>
                    </tr>
                    <tr>
                        <td>失业保险</td>
                        <td>${BaseInfo.unemploymentNum}</td>
                        <td><fmt:formatNumber value="${BaseInfo.paymentUnemployment}" pattern="###,###,###,##0.0000"/></td>
                        <td><fmt:formatNumber value="${BaseInfo.actualPayUnemployment}" pattern="###,###,###,##0.0000"/></td>
                        <td><fmt:formatNumber value="${BaseInfo.cumuUnemployment}" pattern="###,###,###,##0.0000"/></td>
                    </tr>
                    <tr>
                        <td>职工基本医疗保险</td>
                        <td>${BaseInfo.medicalNum}</td>
                        <td><fmt:formatNumber value="${BaseInfo.paymentMedical}" pattern="###,###,###,##0.0000"/></td>
                        <td><fmt:formatNumber value="${BaseInfo.actualPayMedical}" pattern="###,###,###,##0.0000"/></td>
                        <td><fmt:formatNumber value="${BaseInfo.cumuMedical}" pattern="###,###,###,##0.0000"/></td>
                    </tr>
                    <tr>
                        <td>工伤保险</td>
                        <td>${BaseInfo.empInjuryNum}</td>
                        <td><fmt:formatNumber value="${BaseInfo.paymentEmpInjury}" pattern="###,###,###,##0.0000"/></td>
                        <td><fmt:formatNumber value="${BaseInfo.actualPayEmpInjury}" pattern="###,###,###,##0.0000"/></td>
                        <td><fmt:formatNumber value="${BaseInfo.cumuEmpInjury}" pattern="###,###,###,##0.0000"/></td>
                    </tr>
                    <tr>
                        <td>生育保险</td>
                        <td>${BaseInfo.maternityNum}</td>
                        <td><fmt:formatNumber value="${BaseInfo.paymentMaternity}" pattern="###,###,###,##0.0000"/></td>
                        <td><fmt:formatNumber value="${BaseInfo.actualPayMaternity}" pattern="###,###,###,##0.0000"/></td>
                        <td><fmt:formatNumber value="${BaseInfo.cumuMaternity}" pattern="###,###,###,##0.0000"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td>${BaseInfo.paymentBaseIsPub=='1'?'公示':'不公示'}</td>
                        <td>${BaseInfo.actualPaymentIsPub=='1'?'公示':'不公示'}</td>
                        <td>${BaseInfo.cumulArrearsIsPub=='1'?'公示':'不公示'}</td>
                    </tr>
                </thead>
	         </table>
	         </div>
        </c:if>
 </c:if>
 </div>
    <h4 class="h4-title mt10">敏感词信息</h4>
    <div class="start-copy">
    <table id="forbidWordTable" border="0" cellspacing="0" cellpadding="0" width="100%" class="table-row mt30">
        <thead>
        <tr>
            <th>序号</th>
            <th>敏感信息</th>
            <th>时间</th>
        </tr>
        </thead>
    </table>
    </div>
    
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
 
<div class="form-box pdr20">
<form id="forbidCheckForm">
       <input type="hidden"  id="uniCode" value="${yrRegCheck.uniCode}" />
       <input type="hidden"  id="entName" name="entName" value="${yrRegCheck.entName}" />
       <input type="hidden"  id="regNO" name="regNO" value="${yrRegCheck.regNO}" />
       <input type="hidden"  id="year" name="year" value="${yrRegCheck.year}" />
       <input type="hidden"  id="priPID" name="priPID" value="${yrRegCheck.priPID}" />
       <input type="hidden" id="entTypeCatg" name="entTypeCatg" value="${yrRegCheck.entTypeCatg}">
       <c:if test="${fn:indexOf('16,17',entCatg) != -1}">
        <input type="hidden" id="anCheID"  value="${sfcBaseInfo.anCheID}"/>
       </c:if>
       <c:if test="${entCatg == 50}">
       <input type="hidden" id="anCheID"   value="${pbBaseInfo.anCheID}"/>
       </c:if>
       <c:if test="${fn:indexOf('16,17,50',entCatg) == -1}">
        <input type="hidden" id="anCheID"  value="${BaseInfo.anCheID}"/>
       </c:if>
       <div class="form-list">
        <div class="form-item clearfix">
            <div class="item-name col-1">审核结果：</div>
            <div class="radio-box col-11">
               <label><input type="radio" name="auditState"  id="success"  title="通过" value="1"  <c:if test="${yrRegCheck.reportState == '11'}">checked</c:if> <c:if test="${yrRegCheck.reportState != '12'}">disabled</c:if> />通过&nbsp;&nbsp;</label>
          	   <label><input type="radio" name="auditState"  id="fail"     title="不通过" value="0" <c:if test="${yrRegCheck.reportState == '13'}">checked</c:if> <c:if test="${yrRegCheck.reportState != '12'}">disabled</c:if> />不通过&nbsp;&nbsp;</label>
            </div>
        </div>
        <div class="form-item clearfix">
            <div class="item-name col-1">审核意见：</div>
            <div class="ipt-box col-11">
                <textarea rows="5" id="auditOpinion" name="auditOpinion" <c:if test="${yrRegCheck.reportState != '12'}">disabled</c:if>>${auditOpinion}</textarea>
            </div>
        </div>
    </div>
	<c:if test="${yrRegCheck.reportState == '12'}">
	<div class="form-item clearfix">
	   <div class="btn-box">
	    <input id="commit" class="btn mr20" type="button" value="保存"/>
	    <input id="close" class="btn" type="button" value="关闭"/>
	   </div>
	</div>
	</c:if>
</form>
</div>
</div>
<div class="layder-bd mt40" id="send-message-layer" style="display: none;">
    <div class="send-message">
        <div>
            <table border="0" cellspacing="0" cellpadding="0" class="table-row">
                <tr>
                    <td colspan="4" style="font-weight:bold;font-size:14px;text-align: left;">
                        提示：
                    </td>
                </tr>
                <tr>
                    <td style="color: black;text-indent: 2em;" class="left"><label><input type="checkbox" class="sendMsg"/> 审核结果短信通知企业工商联络员</label></td>
                </tr>
                <tr>
                    <td colspan="4" style="font-weight:bold;font-size:14px;color:black;text-align: left">
                        <span style="line-height:1.4;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;短信内容为：<br />
${midBaseInfo.entName}，你企业${yrRegCheck.year}年度年报公示内容于${curDate}日经审核不符合相关法规要求，不予正常公示，请修改后重新报送。</span>
                    </td>
                </tr>
            </table>
        </div>
        <div class="clearfix mt20">
            <div class="center">
                <input type="button" class="btn mr20" value="确定" id="send">
                <input type="button" class="btn mr20" value="取消" id="cancel"> 
            </div>
        </div>
    </div>
</div>
<form id="praramContent">
    <input type="hidden"  id="enYear"    name="enYear"        value="${enYear}">
    <input type="hidden"  id="enPriPid"    name="enPriPid"        value="${enPriPid}">
    <input type="hidden"  id="liaTel"       value="${pubEppassword.tel}">
    <input type="hidden"  id="district"    value="${midBaseInfo.regOrg}">
    <input type="hidden"  id="curDate"    value="${curDate}">
</form>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/yr/pubforbidresult/edit_main.js"></script>
</body>
</html>