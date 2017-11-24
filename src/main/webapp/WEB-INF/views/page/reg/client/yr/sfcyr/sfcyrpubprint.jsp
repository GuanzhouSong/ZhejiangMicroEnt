<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>农民专业合作社年报公示预览页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/print.css"/>"/>
    <style media="print" type="text/css">
        .STYLE1 {
            font-size: 16px;
            font-weight: bold;
        }

        object {
            display: none
        }

        .Noprint {
            display: none;
        }

        .PageNext {
            page-break-after: always;
            clear: both;
            width: 100%
        }
    </style>
    <style type="text/css">
        .height40 {
            height: 40px;
        }
    </style>
</head>
<body>
<c:if test="${printFalg=='2'}">
	 <div class="button Noprint" style="width:600px;">
	    <a href="javascript:Print();"><strong style="font-size:16px">直接打印</strong></a>
	    <a href="javascript:PrintView();"><strong style="font-size:16px">打印预览</strong></a>
	    <a href="javascript:PrintSetup();"><strong style="font-size:16px">打印设置</strong></a>
	    <a id="closeBtn" href="javascript:window.close();"><strong style="font-size:16px">关闭窗口</strong></a>
	</div>
	<object height="20px" id="factory" viewastext="" classid="clsid:1663ed61-23eb-11d2-b92f-008048fdd814" codebase="/js/common/print/ScriptX.cab#version=6,2,433,14"> </object>
	<object height="20px" id="WebBrowser" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>
</c:if>
<div class="mod info-title">
    <h5 class="pdt20 center">农民专业合作社年报公示信息表</h5>
    <strong class="light">注：以下为年报公示信息，若有误请返回对应的年度报告报表中进行修改。</strong>
</div>
<div class="mod">
    <div class="mod-hd">
        <div class="title">
            <h3>基本信息</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
            <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td class="odd">
                        <div class="item-name">名称字号：</div>
                        <div class="item-txt">${midBaseInfoDto.entName}</div>
                    </td>
                    <td class="odd">
                        <div class="item-name">统一社会信用代码/注册号：</div>
                        <div class="item-txt">${sfcBaseInfo.regNO}</div>
                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="item-name">联系电话：</div>
                        <div class="item-txt">${sfcBaseInfo.tel}</div>
                    </td>
                    <td class="odd">
                        <div class="item-name">电子邮箱：</div>
                        <div class="item-txt">${sfcBaseInfo.email}</div>
                    </td>
                </tr>
                <tr>
                    <td class="odd" colspan="2">
                        <div class="item-name">成员人数：</div>
                        <div class="item-txt">共${sfcBaseInfo.memNum}人，其中农民人数：${sfcBaseInfo.farnum}人。 本年度新增${sfcBaseInfo.annNewMemNum}人，退出${sfcBaseInfo.annRedMemNum}人。</div>
                    </td>
                </tr>
                <tr>
                    <td class="odd" colspan="2">
                        <div class="item-name">通信地址：</div>
                        <div class="item-txt item-multipy">${sfcBaseInfo.dom}</div>
                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="item-name">从业人数：</div>
                        <div class="item-txt"><span class="inline-block w200">${sfcBaseInfo.empNum}人</span>
                        <c:if test="${sfcBaseInfo.empNumDis == '1'}">公示</c:if>
                        <c:if test="${sfcBaseInfo.empNumDis == '0'}">不公示</c:if>
                        </div>
                    </td>
                    <c:if test="${sfcBaseInfo.year > 2015}">
                    <td class="odd">
                        <div class="item-name">女性从业人数：</div>
                        <div class="item-txt"><span class="inline-block w200">${sfcBaseInfo.femaleEmploye}人</span>
                        <c:if test="${sfcBaseInfo.femaleEmployeIsPub == '1'}">公示</c:if>
                        <c:if test="${sfcBaseInfo.femaleEmployeIsPub == '0'}">不公示</c:if>
                        </div>
                    </td>
                    </c:if>
                </tr>
                <c:if test="${sfcBaseInfo.year > 2015}">
                <tr>
                    <td class="odd" colspan="2">
                        <div class="item-name">主营业务活动：</div>
                        <div class="item-txt item-multipy">${sfcBaseInfo.entMainBusActivity}</div>
                    </td> 
                </tr> 
                </c:if> 
                </tbody>
            </table>
        </div>
    </div>
</div>

<div class="mod">
    <div class="mod-hd">
        <div class="title">
            <h3>行政许可情况</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
            <div >
                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th width="50%">许可文件名称</th>
                        <th width="50%">有效期至</th>
                    </tr>
                    </thead>
                    <tbody> 
                    <c:forEach var="sfcLicenceInfo" items="${sfcLicenceInfoList}" varStatus="status">
			        		<tr>
			        			<td >${sfcLicenceInfo.licNameCN}</td> 
			        			<td >
			        			<fmt:formatDate var="pbvalTo"
								value="${sfcLicenceInfo.valTo}"
								pattern="yyyy-MM-dd" />
			        			${(!fn:contains(pbvalTo,'9999'))?pbvalTo:'长期有效'}
			        			</td>
			        		</tr>
		        	</c:forEach> 
                    </tbody>
                </table>
            </div>
            <!-- <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em>1</em> 条信息，共<em>1</em>页</span>
                <div id="pagination1" class="pagination">
                </div>
            </div> -->
        </div>
    </div>
</div>

<div class="mod">
    <div class="mod-hd">
        <div class="title">
            <h3>网站或网店信息</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
            <div >
                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th width="20%">类型</th>
                        <th width="40%">名称</th>
                        <th width="40%">网址</th>
                    </tr>
                    </thead>
                    <tbody>
                     <c:forEach var="sfcWebsiteInfo" items="${sfcWebsiteInfoList}" varStatus="status">
		        		<tr>
	        				<td >
		        			 <c:if test="${sfcWebsiteInfo.webType==1}">网站</c:if>
		        			 <c:if test="${sfcWebsiteInfo.webType==2}">网店</c:if> 
		        			</td>
		        			<td > ${sfcWebsiteInfo.webSitName}</td>
		        			<td >${sfcWebsiteInfo.webSite} </td>
		        		</tr>
		        	</c:forEach> 
                    </tbody>
                </table>
            </div>
            <!-- <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em>1</em> 条信息，共<em>1</em>页</span>
                <div id="pagination2" class="pagination">
                </div>
            </div> -->
        </div>
    </div>
</div>

<div class="mod">
    <div class="mod-hd">
        <div class="title">
            <h3>分支机构情况</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
            <div >
                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th width="50%">分支机构名称</th>
                        <th width="50%">分支机构注册号</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <c:forEach var="sfcBranchInfo" items="${sfcBranchInfoList}" varStatus="status">
		        		<tr>
	        				<td >${sfcBranchInfo.brName}</td>
		        			<td >${sfcBranchInfo.uniCode}</td>
		        		</tr>
		        	    </c:forEach> 
                    </tr>
                    </tbody>
                </table>
            </div>
           <!--  <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em>1</em> 条信息，共<em>1</em>页</span>
                <div id="pagination3" class="pagination">
                </div>
            </div> -->
        </div>
    </div>
</div>

<div class="mod">
    <div class="mod-hd">
        <div class="title">
            <h3>资产状况信息</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
            <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td class="odd">
                        <div class="item-name">销售额或营业收入：</div>
                        <div class="item-txt"><span class="inline-block w200"><fmt:formatNumber value="${sfcBaseInfo.vendInc*10000}" pattern="###,###,###,##0.00"/> 元
                        </span><c:if test="${sfcBaseInfo.vendIncIsPub == '1'}">公示</c:if>
                    		   <c:if test="${sfcBaseInfo.vendIncIsPub == '0'}">不公示</c:if>
                    	</div>
                    </td>
                    <td class="odd">
                        <div class="item-name">盈余总额：</div>
                        <div class="item-txt"><span class="inline-block w200"><fmt:formatNumber value="${sfcBaseInfo.priYeaProfit*10000}" pattern="###,###,###,##0.00"/> 元
                        </span><c:if test="${sfcBaseInfo.maiBusIncIsPub == '1'}">公示</c:if>
		                       <c:if test="${sfcBaseInfo.maiBusIncIsPub == '0'}">不公示</c:if>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="item-name">纳税金额：</div>
                        <div class="item-txt"><span class="inline-block w200"><fmt:formatNumber value="${sfcBaseInfo.ratGro*10000}" pattern="###,###,###,##0.00"/> 元
                        </span><c:if test="${sfcBaseInfo.ratGroIsPub == '1'}">公示</c:if>
		                       <c:if test="${sfcBaseInfo.ratGroIsPub == '0'}">不公示</c:if>
		                </div>
                    </td>
                    <td class="odd">
                        <div class="item-name">获得政府扶持资金、补助：</div>
                        <div class="item-txt"><span class="inline-block w200"><fmt:formatNumber value="${sfcBaseInfo.priYeaSub*10000}" pattern="###,###,###,##0.00"/> 元
                        </span><c:if test="${sfcBaseInfo.priYeaSubIsPub == '1'}">公示</c:if>
		                       <c:if test="${sfcBaseInfo.priYeaSubIsPub == '0'}">不公示</c:if>
		                </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="item-name">金融贷款：</div>
                        <div class="item-txt"><span class="inline-block w200"><fmt:formatNumber value="${sfcBaseInfo.priYeaLoan*10000}" pattern="###,###,###,##0.00"/> 元
                        </span><c:if test="${sfcBaseInfo.priYeaLoanIsPub == '1'}">公示</c:if>
		                       <c:if test="${sfcBaseInfo.priYeaLoanIsPub == '0'}">不公示</c:if>
		                </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<c:if test="${sfcBaseInfo.year >2015}">
<div class="mod">
        <div class="mod-bd">
            <div class="title">
                <h3>社保信息</h3>
            </div>
            <div class="content">
                <table class="table-public table-public2-preview" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th width="168" >参保险种</th>
                        <th width="210">
                            参保人数</br>（单位：人）
                        </th>
                        <th width="210">单位缴费基数</br>（单位：万元）</th>
                        <th width="210">本期实际缴费金额</br>（单位：万元）</th>
                        <th>单位累计欠缴金额</br>（单位：万元）</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>城镇职工基本养老保险</td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text" readonly="readonly" id="endowmentNum" name="endowmentNum" value="${sfcBaseInfo.endowmentNum}" class="ipt-txt" >
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="paymentEndowment" value="<fmt:formatNumber value="${sfcBaseInfo.paymentEndowment}" pattern="###,###,###,##0.0000"/>" class="ipt-txt one" > 
                            </div>
                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                  <input type="text"  readonly="readonly" name="paymentEndowment" value="<fmt:formatNumber value="${sfcBaseInfo.actualPayEndowment}" pattern="###,###,###,##0.0000"/>" class="ipt-txt one" >
                            </div> 
                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                 <input type="text"  readonly="readonly" name="paymentEndowment" value="<fmt:formatNumber value="${sfcBaseInfo.cumuEndowment}" pattern="###,###,###,##0.0000"/>" class="ipt-txt one" >
                                 <i class=""></i>
                            </div>

                        </td>
                    </tr>
                    <tr>
                        <td>失业保险</td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" id="unemploymentNum" name="unemploymentNum" value="${sfcBaseInfo.unemploymentNum}" class="ipt-txt" >
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                 <input type="text"  readonly="readonly" name="paymentEndowment" value="<fmt:formatNumber value="${sfcBaseInfo.paymentUnemployment}" pattern="###,###,###,##0.0000"/>" class="ipt-txt one" >
                                 <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                 <input type="text"  readonly="readonly" name="paymentEndowment" value="<fmt:formatNumber value="${sfcBaseInfo.actualPayUnemployment}" pattern="###,###,###,##0.0000"/>" class="ipt-txt one" >
                                 <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                 <input type="text"  readonly="readonly" name="paymentEndowment" value="<fmt:formatNumber value="${sfcBaseInfo.cumuUnemployment}" pattern="###,###,###,##0.0000"/>" class="ipt-txt one" >
                                 <i class=""></i>
                            </div>

                        </td>
                    </tr>
                    <tr>
                        <td>职工基本医疗保险</td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" id="medicalNum" name="medicalNum" value="${sfcBaseInfo.medicalNum}" class="ipt-txt" >
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                 <input type="text"  readonly="readonly" name="paymentEndowment" value="<fmt:formatNumber value="${sfcBaseInfo.paymentMedical}" pattern="###,###,###,##0.0000"/>" class="ipt-txt one" >
                                 <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                 <input type="text"  readonly="readonly" name="paymentEndowment" value="<fmt:formatNumber value="${sfcBaseInfo.actualPayMedical}" pattern="###,###,###,##0.0000"/>" class="ipt-txt one" >
                                 <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                 <input type="text"  readonly="readonly" name="paymentEndowment" value="<fmt:formatNumber value="${sfcBaseInfo.cumuMedical}" pattern="###,###,###,##0.0000"/>" class="ipt-txt one" >
                                 <i class=""></i>
                            </div>

                        </td>
                    </tr>
                    <tr>
                        <td>工伤保险</td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" id="empInjuryNum" name="empInjuryNum" value="${sfcBaseInfo.empInjuryNum}" class="ipt-txt " >
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                 <input type="text"  readonly="readonly" name="paymentEndowment" value="<fmt:formatNumber value="${sfcBaseInfo.paymentEmpInjury}" pattern="###,###,###,##0.0000"/>" class="ipt-txt one" >
                                 <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                 <input type="text"  readonly="readonly" name="paymentEndowment" value="<fmt:formatNumber value="${sfcBaseInfo.actualPayEmpInjury}" pattern="###,###,###,##0.0000"/>" class="ipt-txt one" >
                                 <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                 <input type="text"  readonly="readonly" name="paymentEndowment" value="<fmt:formatNumber value="${sfcBaseInfo.cumuEmpInjury}" pattern="###,###,###,##0.0000"/>" class="ipt-txt one" >
                                 <i class=""></i>
                            </div>

                        </td>
                    </tr>
                    <tr>
                        <td>生育保险</td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" id="maternityNum" name="maternityNum" value="${sfcBaseInfo.maternityNum}" class="ipt-txt" >
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                 <input type="text"  readonly="readonly" name="paymentEndowment" value="<fmt:formatNumber value="${sfcBaseInfo.paymentMaternity}" pattern="###,###,###,##0.0000"/>" class="ipt-txt one" >
                                 <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                 <input type="text"  readonly="readonly" name="paymentEndowment" value="<fmt:formatNumber value="${sfcBaseInfo.actualPayMaternity}" pattern="###,###,###,##0.0000"/>" class="ipt-txt one" >
                                 <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                 <input type="text"  readonly="readonly" name="paymentEndowment" value="<fmt:formatNumber value="${sfcBaseInfo.cumuMaternity}" pattern="###,###,###,##0.0000"/>" class="ipt-txt one" >
                                 <i class=""></i>
                            </div>

                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td>
                            <div class="radio-box">
                                <label>${sfcBaseInfo.paymentBaseIsPub=='1'?'公示':'不公示'}</label>
                            </div>
                        </td>
                        <td>
                            <div class="radio-box">
                                <label>${sfcBaseInfo.actualPaymentIsPub=='1'?'公示':'不公示'}</label>
                            </div>
                        </td>
                        <td>
                            <div class="radio-box">
                                <label>${sfcBaseInfo.cumulArrearsIsPub=='1'?'公示':'不公示'}</label>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table> 
            </div>
        </div>
    </div>
</c:if>


<p class="light tr-center mt20 center">注：年报公示信息将通过企业信用信息公示平台向社会公众公开，请确认以上信息无误。</p>
<c:if test="${printFalg=='1'}">
  <div class="mod btn-box">
    <button class="btn-common" id="sfcprintreport">打印</button> 
  </div>
</c:if>
<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/component/dropDown.js"/>"></script>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/common/print/printsetup.js"/>"></script>
<script src="<c:url value="/js/common/print/print.js"/>"></script>
<script src="<c:url value="/js/reg/client/yr/sfcyr/sfcreportprint_edit.js"/>"></script> 
<script>
  window._CONFIG = {
     _year:'${encodeYear}', //年报年度加密
     _pripid:'${pripid}'  //主体代码 
  }
</script>
</body>
</html>