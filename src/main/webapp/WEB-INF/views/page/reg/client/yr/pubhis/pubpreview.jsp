<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="entCatg" value="${midBaseInfoDto.entTypeCatg}"/>
<c:set var="entCatgBranch" value="12,14,32,34,22,23,24,25,26,28"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>企业年度报告页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/print.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>

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
        <a id="closeBtn" href="javascript:window.top.close();"><strong style="font-size:16px">关闭窗口</strong></a>
 	</div>
	<object height="20px" id="factory" viewastext="" classid="clsid:1663ed61-23eb-11d2-b92f-008048fdd814" codebase="/js/common/print/ScriptX.cab#version=6,2,433,14"> </object>
	<object height="20px" id="WebBrowser" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>
 </c:if>
<div class="mod info-title">
    <h5 class="pdt20 center">年报公示信息表</h5>
    <strong class="light">注：以下为年报公示信息，若有误请返回对应的年度报告表中进行修改。</strong>
</div>

<%-- 
<div class="mod">
    <div class="mod-bd">
        <div class="title title-inner">
            <h3>基本信息</h3> 
        </div>
        <div class="content">
            <table class="table-public table-report table-left-txt">
                <tbody>
                <tr>
                    <td width="480">
                        <div class="item-name w160">注册号/统一社会信用代码：</div>
                        <div class="item-txt">
	                        <c:if test="${empty midBaseInfoDto.uniCode}">${baseInfo.regNO}</c:if>
	                        <c:if test="${!empty midBaseInfoDto.uniCode}">${midBaseInfoDto.uniCode}</c:if>
                        </div>
                    </td>
                    <td width="480">
                        <div class="item-name">企业名称：</div>
                        <div class="item-txt">${baseInfo.entName}</div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="item-name w160">企业联系电话：</div>
                        <div class="item-txt">${baseInfo.tel}</div>
                    </td>
                    <td>
                        <div class="item-name ">邮政编码：</div>
                        <div class="item-txt">${baseInfo.postalCode}</div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="item-name">企业通信地址：</div>
                        <div class="item-txt">${baseInfo.addr}</div>
                    </td>
                    <td>

                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="item-name">企业电子邮箱：</div>
                        <div class="item-txt">${baseInfo.email}</div>
                    </td>
                    <td>
                        <div class="item-name">从业人数：</div>
                        <div class="item-txt">${baseInfo.empNum}</div>
                        <span class="right-tip">
                        	<c:if test="${baseInfo.empNumDis == '1'}">公示</c:if>
                    		<c:if test="${baseInfo.empNumDis == '0'}">不公示</c:if>
                        </span> 
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="item-name">企业经营状态：</div>
                        <div class="item-txt">${baseInfo.busStatusCN}</div>

                    </td>
                    <td colspan="3">
                        <div class="item-name">
                            是否有网站或网店：
	                    </div>
                        <div class="item-txt">
                            <c:if test="${empty websiteInfoList}">否</c:if>
                            <c:if test="${!empty websiteInfoList}">是</c:if>
                        </div>
                    </td>
                </tr>
                <c:if test="${fn:indexOf(entCatgBranch,entCatg) != -1}">
                     <tr>
                         <td> 
				   <div class="item-name">隶属关系：</div>
				   <div class="item-txt">${baseInfo.supEntname}</div>
				   </td>
                         <td> 
                          </td>
                      </tr>
			    </c:if> 
			    <!-- 公司 -->
			   <c:if test="${fn:indexOf(entCatgBranch,entCatg) == -1}">
                    <tr>
                    <td>
                        <div class="item-name">是否有投资信息或购买其他公司股权：</div>
                        <div class="item-txt" id="_isForinvest">
                         <c:if test="${empty forinvestMentList}">否</c:if>
	                     <c:if test="${!empty forinvestMentList}">是</c:if> 
                        </div>
                    </td>
                    <td>
                       <c:if test="${entCatg == 11 || entCatg == 21}">
                    	<div class="item-name">有限责任公司本年度是否发生股东股权转让：</div>
                        <div class="item-txt" id="_isStock">
                         <c:if test="${empty alterStockInfoList}">否</c:if>
	                     <c:if test="${!empty alterStockInfoList}">是</c:if> 
                        </div>
                        </c:if>
                    </td>
                    </tr>
			    </c:if> 
                </tbody>
            </table>
        </div>
    </div>
</div> --%>


<div class="mod">
    <div class="mod-bd">
        <div class="title title-inner">
            <h3>基本信息</h3>
        </div>
        <div class="content">
            <table class="table-public">
                <tbody>
                <tr>
                    <td width="480">
                        <div class="item-name w214"><em>• </em>统一社会信用代码/注册号：</div>
                        <div class="item-txt w214">
	                        <c:if test="${empty baseInfo.uniCode}">${baseInfo.regNO}</c:if>
	                        <c:if test="${!empty baseInfo.uniCode}">${baseInfo.uniCode}</c:if>
                        </div>
                    </td>
                    <td width="480">
                        <div class="item-name w260"><em>• </em>企业名称：</div>
                        <div class="item-txt w176">${baseInfo.entName}</div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="item-name w214"><em>• </em>企业通信地址：</div>
                        <div class="item-txt w222">${baseInfo.addr}</div>
                    </td>
                    <td>
                        <div class="item-name w260"><em>• </em>邮政编码：</div>
                        <div class="item-txt w176">${baseInfo.postalCode}</div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="item-name w214"><em>• </em>企业联系电话：</div>
                        <div class="item-txt w222">${baseInfo.tel}</div>
                    </td>
                    <td>
                        <div class="item-name w260"><em>• </em>企业电子邮箱：</div>
                        <div class="item-txt w176">${baseInfo.email}</div>
                    </td>
                </tr>
                <tr>
                    <td class="pos-rel">
                        <div class="item-name w214"><em>• </em>从业人数：</div>
                        <div class="item-txt w222">${baseInfo.empNum}人</div>
                        <span class="right-tip pdr0">
                        	<c:if test="${baseInfo.empNumDis == '1'}">公示</c:if>
                    		<c:if test="${baseInfo.empNumDis == '0'}">不公示</c:if>
                        </span>
                    </td>
                    <td class="pos-rel"
		                <c:if test="${year > 2015}">
						<div class="item-name"><em>• </em>其中女性从业人数：</div>
		                       <div class="item-txt w176">${empty baseInfo.femaleEmploye?0:baseInfo.femaleEmploye}人</div>
		                       <span class="right-tip pdr0">
		                       	<c:if test="${baseInfo.femaleEmployeIsPub == '1'}">公示</c:if>
		                   		<c:if test="${baseInfo.femaleEmployeIsPub == '0'}">不公示</c:if>
		                       </span>
						</c:if> 
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="item-name w214"><em>• </em>企业经营状态：</div>
                        <div class="item-txt w222">${baseInfo.busStatusCN}</div>
                    </td>
                    <td>
                    	<c:if test="${fn:indexOf(repType,'forinvestment') != -1 && year > 2015}">
                        <div class="item-name w160"><em>• </em>企业控股情况：</div>
                        <div class="item-txt w176">
                        	<c:if test="${baseInfo.entControl=='1'}">国有控股</c:if>
                        	<c:if test="${baseInfo.entControl=='2'}">集体控股</c:if>
                        	<c:if test="${baseInfo.entControl=='3'}">私人控股</c:if>
                        	<c:if test="${baseInfo.entControl=='4'}">港澳台商控股</c:if>
                        	<c:if test="${baseInfo.entControl=='5'}">外商控股</c:if>
                        	<c:if test="${baseInfo.entControl=='6'}">其他</c:if>
                        </div>
                        <span class="right-tip pdr0">
                        	<c:if test="${baseInfo.entControlIsPub == '1'}">公示</c:if>
                    		<c:if test="${baseInfo.entControlIsPub == '0'}">不公示</c:if>
                        </span>
                        </c:if>
                    </td>
                </tr>
                <c:if test="${fn:indexOf(repType,'assetbranch') != -1}">
                <tr>
                    <td>
                        <div class="item-name w214"><em>• </em>隶属企业统一社会信用代码/注册号：</div>
                        <div class="item-txt w222">${baseInfo.supRegNO}</div>
                    </td>
                    <td>
		         		<div class="item-name">隶属企业名称：</div>
                        <div class="item-txt">${baseInfo.supEntname}</div>
                    </td>
                </tr>
                </c:if>
                <tr>
                    <td>
                        <div class="item-name w214"><em>• </em>是否有网站或网店：</div>
                        <div class="item-txt w222" >
                             <c:if test="${empty websiteInfoList}">否</c:if>
	                         <c:if test="${!empty websiteInfoList}">是</c:if> 
                        </div>
                    </td>
                    <td>
                        <div class="item-name w260"><em>• </em>是否有对外提供担保信息：</div>
                        <div class="item-txt w176" id="_isForguarantee">
	                        <c:if test="${empty forGuaranteeInfoList}">否</c:if>
		                    <c:if test="${!empty forGuaranteeInfoList}">是</c:if>
                        </div>
                    </td>
                </tr>
                <c:if test="${fn:indexOf(repType,'forinvestment') != -1}">
                <tr>
                    <td>
                        <div class="item-name w214"><em>• </em>是否有投资信息或购买其他公司股权：</div>
                        <div class="item-txt w222" id="_isForinvest">
                         <c:if test="${empty forinvestMentList}">否</c:if>
	                     <c:if test="${!empty forinvestMentList}">是</c:if>
                        </div>
                    </td>
                    <td>
                        <c:if test="${fn:indexOf(repType,'alterstockinfo') != -1}">
                            <div class="item-name w260"><em>• </em>有限责任公司本年度是否发生股东股权转让：</div>
                            <div class="item-txt w176" >
                            <c:if test="${empty alterStockInfoList}">否</c:if>
	                     	<c:if test="${!empty alterStockInfoList}">是</c:if> 
                            </div>
                        </c:if>
                    </td>
                </tr>
                </c:if>
                
                <c:if test="${year > 2015}">
					<tr>
                    <td colspan="2">
                        <div class="item-name w214"><em>• </em>企业主营业务活动：</div>
                        <div class="item-txt w222" id="">${baseInfo.entMainBusActivity}</div>
                    </td>
                    </tr>	
				</c:if>
                </tbody>
            </table>
        </div>
    </div>
</div>

<div class="mod">
    <div class="mod-bd">
        <div class="title">
            <h3>网站或网店信息</h3>
        </div>
        <div class="content">
            <div style="overflow-y: auto;overflow-x: hidden;">
                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                     <thead>
                     <tr>
                        <th width="90">类型</th>
                        <th>名称</th>
                        <th>网址</th>
                     </tr>
                     </thead>
                     <tbody >
                      	<c:forEach var="websiteInfo" items="${websiteInfoList}" varStatus="status">
			        		<tr>
			        			<td >
			        			 <c:if test="${websiteInfo.webType==1}">网站</c:if>
			        			 <c:if test="${websiteInfo.webType==2}">网店</c:if> 
			        			</td>
			        			<td > ${websiteInfo.webSitName}</td>
			        			<td >${websiteInfo.webSite} </td>
			        		</tr>
		        		</c:forEach> 
                	 </tbody>
                </table>
            </div>
        </div> 
    </div>
</div>
<!-- 公司 -->
<%-- <c:if test="${entCatg == 11 || entCatg == 21}"> --%>
<c:if test="${fn:indexOf(repType,'subcapital') != -1}">
<div class="mod">
    <div class="mod-bd">
        <div class="title">
            <h3>股东及出资信息</h3>
        </div>
        <div class="content">
            <div style="overflow-y: auto;overflow-x: hidden;">
                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th>股东</th>
                        <th>认缴出资额<br>(万${year>2015?currencyCN:'元'})</th>
                        <th>认缴出资时间</th>
                        <th>认缴出资方式</th>
                        <th>实缴出资额<br>(万${year>2015?currencyCN:'元'})</th>
                        <th>实缴出资时间</th>
                        <th>实缴出资方式</th>
                    </tr>
                    </thead>
                    <tbody id="_subcapital">
                    <c:forEach var="subcapital" items="${subcapitalList}" varStatus="status">
			        		<tr>
			        			<td >${subcapital.inv}</td> 
			        			<td >
			        			<fmt:formatNumber value="${subcapital.lisubconam}" pattern="###,###,###,##0.0000"/>
			        			</td>
			        			<td > 
								    <fmt:formatDate value="${subcapital.subConDate}"
									pattern="yyyy-MM-dd" /> 
			        			</td>
			        			<td >${subcapital.conFormCN} </td>
			        			<td >
			        			<fmt:formatNumber value="${subcapital.liacconam}" pattern="###,###,###,##0.0000"/>
			        			</td>
			        			<td > 
								    <fmt:formatDate value="${subcapital.acConDate}"
									pattern="yyyy-MM-dd" /> 
			        			</td>
 			        			<td >${subcapital.acConFormCn} </td>
			        		</tr>
		        		</c:forEach> 
                    
                	</tbody>
                </table>
            </div>
        </div> 
    </div>
</div>
</c:if>
<%-- <c:if test="${fn:indexOf(entCatgBranch,entCatg) == -1}"> --%>
<c:if test="${fn:indexOf(repType,'forinvestment') != -1}">
<div class="mod">
    <div class="mod-bd">
        <div class="title">
            <h3>对外投资信息</h3>
        </div>
        <div class="content">
            <div style="overflow-y: auto;overflow-x: hidden;">
                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th>投资设立企业或购买股权企业名称</th>
                        <th>注册号/统一社会信用代码</th>
                    </tr>
                    </thead>
                    <tbody id="_forinvest">
                     <c:forEach var="forinvestMent" items="${forinvestMentList}" varStatus="status">
			        		<tr>
			        			<td >${forinvestMent.entName}</td> 
			        			<td >${forinvestMent.uniCode}</td> 
			        		</tr>
		        	</c:forEach> 
                	</tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</c:if>


<c:if test="${fn:indexOf(repType,'assetbranch') != -1}">
<div class="mod">
 <div class="mod-bd">
     <div class="title title-inner">
         <h3>企业经营情况信息</h3>
     </div>
     <div class="content">
         <table class="table-public table-report item-name-w162 table-left-txt">
             <tbody>
             <tr>
                 <td>
                     <div class="item-name w204">营业总收入中主营业务收入（元）：</div>
                     <div class="item-txt">
                         <c:if test="${!empty baseInfo.maiBusInc }">
                             <fmt:formatNumber value="${baseInfo.maiBusInc*10000}" pattern="###,###,###,##0.00"/>
                         </c:if>
                     </div>
                     <span class="right-tip">
                     	<c:if test="${baseInfo.maiBusIncIsPub == '1'}">公示</c:if>
                 		<c:if test="${baseInfo.maiBusIncIsPub == '0'}">不公示</c:if>
                     </span>
                 </td>
                 <td>
                     <div class="item-name w204">净利润（元）：</div>
                     <div class="item-txt">
                        <c:if test="${!empty baseInfo.netInc }">
                             <fmt:formatNumber value="${baseInfo.netInc*10000}" pattern="###,###,###,##0.00"/>
                        </c:if>
                     </div>

                     <span class="right-tip">
                     	<c:if test="${baseInfo.netIncIsPub == '1'}">公示</c:if>
                 		<c:if test="${baseInfo.netIncIsPub == '0'}">不公示</c:if>
                     </span>
                 </td>
             </tr>
             <tr>
                 <td>
                     <div class="item-name w204"> 纳税总额（元）：</div>
                     <div class="item-txt">
                         <c:if test="${!empty baseInfo.ratGro}">
                         <fmt:formatNumber value="${baseInfo.ratGro*10000}" pattern="###,###,###,##0.00"/>
                         </c:if>
                     </div>
                     <span class="right-tip">
                     	<c:if test="${baseInfo.ratGroIsPub == '1'}">公示</c:if>
                 		<c:if test="${baseInfo.ratGroIsPub == '0'}">不公示</c:if>
                        </span>
                    </td>

                    <td>
                        <div class="item-name w204"></div>
                        <div class="item-txt"></div>
                        <span class="right-tip">
                        	 
                        </span>
                    </td>
                </tr> 
                </tbody>
            </table>
        </div>
    </div>
</div>
</c:if> 
 
<c:if test="${fn:indexOf(repType,'asset') != -1}">
<c:if test="${fn:indexOf(repType,'assetbranch') == -1}">
 <div class="mod">
   <div class="mod-bd">
       <div class="title title-inner">
           <h3>企业资产状况信息</h3>
       </div>
       <div class="content">
           <table class="table-public table-report item-name-w162 table-left-txt">
               <tbody>
               <tr>
                   <td width="480">
                       <div class="item-name w204">资产总额（元）：</div>
                       <div class="item-txt"><fmt:formatNumber value="${baseInfo.assGro*10000}" pattern="###,###,###,##0.00"/></div>
                       <span class="right-tip">
                       	<c:if test="${baseInfo.assGroIsPub == '1'}">公示</c:if>
                   		<c:if test="${baseInfo.assGroIsPub == '0'}">不公示</c:if>
                       </span>
                   </td>
                   <td width="480">
                       <div class="item-name w204">所有者权益合计（元）：</div>
                       <div class="item-txt"><fmt:formatNumber value="${baseInfo.totEqu*10000}" pattern="###,###,###,##0.00"/></div>
                       <span class="right-tip">
                       	<c:if test="${baseInfo.totEquIsPub == '1'}">公示</c:if>
                   		<c:if test="${baseInfo.totEquIsPub == '0'}">不公示</c:if>
                       </span>
                   </td>
               </tr>
               <tr>
                   <td>
                       <div class="item-name w204">营业总收入（元）：</div>
                       <div class="item-txt"><fmt:formatNumber value="${baseInfo.vendInc*10000}" pattern="###,###,###,##0.00"/></div>
                       <span class="right-tip">
                       	<c:if test="${baseInfo.vendIncIsPub == '1'}">公示</c:if>
                   		<c:if test="${baseInfo.vendIncIsPub == '0'}">不公示</c:if>
                       </span>
                   </td>
                   <td>
                       <div class="item-name w204">利润总额（元）：</div>
                       <div class="item-txt"><fmt:formatNumber value="${baseInfo.proGro*10000}" pattern="###,###,###,##0.00"/></div>
                       <span class="right-tip">
                       	<c:if test="${baseInfo.proGroIsPub == '1'}">公示</c:if>
                   		<c:if test="${baseInfo.proGroIsPub == '0'}">不公示</c:if>
                       </span>
                   </td>
               </tr>
               <tr>
                   <td>
                       <div class="item-name w204">营业总收入中主营业务收入（元）：</div>
                       <div class="item-txt"><fmt:formatNumber value="${baseInfo.maiBusInc*10000}" pattern="###,###,###,##0.00"/></div>
                       <span class="right-tip">
                       	<c:if test="${baseInfo.maiBusIncIsPub == '1'}">公示</c:if>
                   		<c:if test="${baseInfo.maiBusIncIsPub == '0'}">不公示</c:if>
                       </span>
                   </td>
                   <td>
                       <div class="item-name w204">净利润（元）：</div>
                       <div class="item-txt"><fmt:formatNumber value="${baseInfo.netInc*10000}" pattern="###,###,###,##0.00"/></div>
                       <span class="right-tip">
                       	<c:if test="${baseInfo.netIncIsPub == '1'}">公示</c:if>
                   		<c:if test="${baseInfo.netIncIsPub == '0'}">不公示</c:if>
                       </span>
                   </td>
               </tr>
               <tr>
                   <td>
                       <div class="item-name w204"> 纳税总额（元）：</div>
                       <div class="item-txt"><fmt:formatNumber value="${baseInfo.ratGro*10000}" pattern="###,###,###,##0.00"/></div>
                       <span class="right-tip">
                       	<c:if test="${baseInfo.ratGroIsPub == '1'}">公示</c:if>
                   		<c:if test="${baseInfo.ratGroIsPub == '0'}">不公示</c:if>
                       </span>
                   </td>
                   <td>
                       <div class="item-name w204">负债总额（元）：</div>
                       <div class="item-txt"><fmt:formatNumber value="${baseInfo.liaGro*10000}" pattern="###,###,###,##0.00"/></div>
                       <span class="right-tip">
                       	<c:if test="${baseInfo.liaGroIsPub == '1'}">公示</c:if>
                   		<c:if test="${baseInfo.liaGroIsPub == '0'}">不公示</c:if>
                       </span>
                   </td>
               </tr>
               <tr>
                   <td>
                       <div class="item-name w204">${year}年是否依法交纳残保金：</div>
                       <div class="item-txt">
                       	<c:if test="${baseInfo.isLegPay == '1'}">是</c:if>
                   		<c:if test="${baseInfo.isLegPay == '0'}">否</c:if>
                       </div>
                   </td>
                   <td>
                       <div class="item-name w204">从业人员中属于残疾人：</div>
                       <div class="item-txt">${baseInfo.disOpers}</div>
                   </td>
               </tr>
               <tr>
                   <td>
                       <div class="item-name w204">企业应安置残疾人员数：</div>
                       <div class="item-txt">${baseInfo.entOugthSetDis}</div>
                   </td>
                   <td>
                       <div class="item-name w204">企业已安置残疾人员数：</div>
                       <div class="item-txt">${baseInfo.entSetDis}</div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</c:if>
</c:if>

<div class="mod">
    <div class="mod-bd">
        <div class="title">
            <h3>对外提供保证担保信息</h3>
        </div>
        <div class="content">
            <div style="overflow-y: auto;overflow-x: hidden;">
                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th width="118">债权人</th>
                        <th width="150">债务人</th>
                        <th width="80">主债权</br>种类</th>
                        <th width="100">主债权</br>数额（万元）</th>
                        <th width="170">履行债务的期限</th>
                        <th>保证的</br>期间</th>
                        <th>保证的</br>方式</th>
                        <th width="63">是否公示</th>
                    </tr>
                    </thead>
                    <tbody id="_forguarantee">
	                     <c:forEach var="forGuaranteeInfo" items="${forGuaranteeInfoList}" varStatus="status">
				        		<tr>
				        			<td width="200">${forGuaranteeInfo.more}</td> 
				        			<td width="100">${forGuaranteeInfo.mortgagor}</td>
				        			<td width="100">
					        			<c:if test="${forGuaranteeInfo.priClaSecKind==1}">
					        			合同
					        			</c:if>
					        			<c:if test="${forGuaranteeInfo.priClaSecKind==2}">
					        			其他
					        			</c:if>
				        			</td>
				        			<td width="100"><fmt:formatNumber value="${forGuaranteeInfo.priClaSecAm}" pattern="###,###,###,##0.0000"/></td>
				        			<td width="210">
				        			   <fmt:formatDate value="${forGuaranteeInfo.pefPerForm}"
										pattern="yyyy-MM-dd" /> 至
										<fmt:formatDate value="${forGuaranteeInfo.pefPerTo}"
										pattern="yyyy-MM-dd" />
				        			</td> 
				        			<td width="100">
					        			<c:if test="${forGuaranteeInfo.guaPeriod==1}">
					        			期间
					        			</c:if>
					        			<c:if test="${forGuaranteeInfo.guaPeriod==2}">
					        			未约定
					        			</c:if>
				        			</td>
				        			<td width="100">
					        			<c:if test="${forGuaranteeInfo.gaType==1}">
					        			一般保证
					        			</c:if>
					        			<c:if test="${forGuaranteeInfo.gaType==2}">
					        			连带保证
					        			</c:if>
					        			<c:if test="${forGuaranteeInfo.gaType==3}">
					        			未约定
					        			</c:if>
				        			</td>
				        			<td width="100">
					        			<c:if test="${forGuaranteeInfo.isPubFlag==1}">
					        			公示
					        			</c:if>
					        			<c:if test="${forGuaranteeInfo.isPubFlag==0}">
					        			不公示
					        			</c:if>
				        			</td>
				        		</tr>
			        	   </c:forEach> 
                	</tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<%-- <c:if test="${entCatg == 11 || entCatg == 21}"> --%>
<c:if test="${fn:indexOf(repType,'alterstockinfo') != -1}">
<div class="mod">
    <div class="mod-bd">
        <div class="title">
            <h3>股权变更信息</h3>
        </div>
        <div class="content">
            <div style="overflow-y: auto;overflow-x: hidden;">
                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th width="118">股东</th>
                        <th width="150">变更前股权比例(%)</th>
                        <th width="80">变更后股权比例(%)</th>
                        <th>股权变更日期</th>
                    </tr>
                    </thead>
                    <tbody id="_stock">
                      <c:forEach var="alterStockInfo" items="${alterStockInfoList}" varStatus="status">
			        		<tr>
			        			<td width="200">${alterStockInfo.inv}</td> 
			        			<td width="100">${alterStockInfo.beTransAmPr}</td>
			        			<td width="100">${alterStockInfo.afTransAmPr}</td>
			        			<td width="100">
			        			   <fmt:formatDate value="${alterStockInfo.altDate}"
									pattern="yyyy-MM-dd" /> 
			        			</td> 
			        		</tr>
		        	   </c:forEach> 
                	</tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</c:if>

<c:if test="${year > 2015}">
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
                                <input type="text" readonly="readonly" id="endowmentNum" name="endowmentNum" value="${baseInfo.endowmentNum}" class="ipt-txt" >
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" name="paymentEndowment" value="<fmt:formatNumber value="${baseInfo.paymentEndowment}" pattern="###,###,###,##0.0000"/>" class="ipt-txt one" > 
                            </div>
                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                  <input type="text"  readonly="readonly" name="paymentEndowment" value="<fmt:formatNumber value="${baseInfo.actualPayEndowment}" pattern="###,###,###,##0.0000"/>" class="ipt-txt one" >
                            </div> 
                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                 <input type="text"  readonly="readonly" name="paymentEndowment" value="<fmt:formatNumber value="${baseInfo.cumuEndowment}" pattern="###,###,###,##0.0000"/>" class="ipt-txt one" >
                                 <i class=""></i>
                            </div>

                        </td>
                    </tr>
                    <tr>
                        <td>失业保险</td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" id="unemploymentNum" name="unemploymentNum" value="${baseInfo.unemploymentNum}" class="ipt-txt" >
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                 <input type="text"  readonly="readonly" name="paymentEndowment" value="<fmt:formatNumber value="${baseInfo.paymentUnemployment}" pattern="###,###,###,##0.0000"/>" class="ipt-txt one" >
                                 <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                 <input type="text"  readonly="readonly" name="paymentEndowment" value="<fmt:formatNumber value="${baseInfo.actualPayUnemployment}" pattern="###,###,###,##0.0000"/>" class="ipt-txt one" >
                                 <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                 <input type="text"  readonly="readonly" name="paymentEndowment" value="<fmt:formatNumber value="${baseInfo.cumuUnemployment}" pattern="###,###,###,##0.0000"/>" class="ipt-txt one" >
                                 <i class=""></i>
                            </div>

                        </td>
                    </tr>
                    <tr>
                        <td>职工基本医疗保险</td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" id="medicalNum" name="medicalNum" value="${baseInfo.medicalNum}" class="ipt-txt" >
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                 <input type="text"  readonly="readonly" name="paymentEndowment" value="<fmt:formatNumber value="${baseInfo.paymentMedical}" pattern="###,###,###,##0.0000"/>" class="ipt-txt one" >
                                 <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                 <input type="text"  readonly="readonly" name="paymentEndowment" value="<fmt:formatNumber value="${baseInfo.actualPayMedical}" pattern="###,###,###,##0.0000"/>" class="ipt-txt one" >
                                 <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                 <input type="text"  readonly="readonly" name="paymentEndowment" value="<fmt:formatNumber value="${baseInfo.cumuMedical}" pattern="###,###,###,##0.0000"/>" class="ipt-txt one" >
                                 <i class=""></i>
                            </div>

                        </td>
                    </tr>
                    <tr>
                        <td>工伤保险</td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" id="empInjuryNum" name="empInjuryNum" value="${baseInfo.empInjuryNum}" class="ipt-txt " >
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                 <input type="text"  readonly="readonly" name="paymentEndowment" value="<fmt:formatNumber value="${baseInfo.paymentEmpInjury}" pattern="###,###,###,##0.0000"/>" class="ipt-txt one" >
                                 <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                 <input type="text"  readonly="readonly" name="paymentEndowment" value="<fmt:formatNumber value="${baseInfo.actualPayEmpInjury}" pattern="###,###,###,##0.0000"/>" class="ipt-txt one" >
                                 <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                 <input type="text"  readonly="readonly" name="paymentEndowment" value="<fmt:formatNumber value="${baseInfo.cumuEmpInjury}" pattern="###,###,###,##0.0000"/>" class="ipt-txt one" >
                                 <i class=""></i>
                            </div>

                        </td>
                    </tr>
                    <tr>
                        <td>生育保险</td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                <input type="text"  readonly="readonly" id="maternityNum" name="maternityNum" value="${baseInfo.maternityNum}" class="ipt-txt" >
                                <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                 <input type="text"  readonly="readonly" name="paymentEndowment" value="<fmt:formatNumber value="${baseInfo.paymentMaternity}" pattern="###,###,###,##0.0000"/>" class="ipt-txt one" >
                                 <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                 <input type="text"  readonly="readonly" name="paymentEndowment" value="<fmt:formatNumber value="${baseInfo.actualPayMaternity}" pattern="###,###,###,##0.0000"/>" class="ipt-txt one" >
                                 <i class=""></i>
                            </div>

                        </td>
                        <td class="focus-state">
                            <div class="ipt-box js-ipt-box">
                                 <input type="text"  readonly="readonly" name="paymentEndowment" value="<fmt:formatNumber value="${baseInfo.cumuMaternity}" pattern="###,###,###,##0.0000"/>" class="ipt-txt one" >
                                 <i class=""></i>
                            </div>

                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td>
                            <div class="radio-box">
                                <label>${baseInfo.paymentBaseIsPub=='1'?'公示':'不公示'}</label>
                            </div>
                        </td>
                        <td>
                            <div class="radio-box">
                                <label>${baseInfo.actualPaymentIsPub=='1'?'公示':'不公示'}</label>
                            </div>
                        </td>
                        <td>
                            <div class="radio-box">
                                <label>${baseInfo.cumulArrearsIsPub=='1'?'公示':'不公示'}</label>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table> 
            </div>
        </div>
    </div>
</c:if>

<div class="mod">
    <div class="btn-box">
     <p class="center mb10"><strong class="light">注：年报公示信息将通过企业信用信息公示平台向社会公众公开，请确认以上信息无误</strong></p>
     <c:if test="${printFalg!='2'}">
	   <button class="btn-common" id="print" >打印</button>
     </c:if> 
    </div>
</div>
<jsp:include page="../../common/footer.jsp"></jsp:include> 
 
<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/component/dropDown.js"/>"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="<c:url value="/js/common/print/printsetup.js"/>"></script>
<script src="<c:url value="/js/common/print/print.js"/>"></script>
<script src="<c:url value="/js/reg/client/yr/pubhis/edit_main.js"/>"></script>
<script>
    window._CONFIG = {
    	_encodeYear:'${encodeYear}'  //加密后的年度 
     }
</script>
</body>
</html>
