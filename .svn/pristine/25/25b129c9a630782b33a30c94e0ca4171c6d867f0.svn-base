<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>企业高级查询详情页</title>
    <link rel="stylesheet" href="/css/pub-syn.css">
</head>
<body class="outer-bg">
<jsp:include page="../common/header.jsp"></jsp:include>
<div class="mod clearfix">
<jsp:include page="../common/menu.jsp?module=qygjcx&menu=qygjcx"></jsp:include>
    <div class="main">
        <div class="crumbs">
            <a href="javascript:void(0)">首页</a> &gt;
            <a href="javascript:void(0)">信息查询</a> &gt;
            <a href="javascript:void(0)" class="cur">企业高级查询</a>
        </div>
        <hr>
        <div class="clearfix">
            <div class="company-basic clearfix">
            	<div class="caption">
                    <div class="title clearfix">
                        <span class="fl mr5">${entBasicInfo.entName }</span>
                        <span class="icon-rectangle icon-blue fl">
                        <c:if test="${entBasicInfo.regState=='K'||entBasicInfo.regState=='A'||entBasicInfo.regState=='B'}">
                                存续
                            </c:if>
				            <c:if test="${entBasicInfo.regState=='DA'}">
                                吊销未注销
                            </c:if>
				            <c:if test="${entBasicInfo.regState=='D'}">
                                吊销
                            </c:if>
                        </span>
                    </div>
                    <p>
                        <i class="book2-icon"></i>统一社会信用代码/注册号：
                        <span><c:choose>
                                <c:when test="${!empty entBasicInfo.UNICODE}">
                                    ${entBasicInfo.UNICODE }
                                </c:when>
                                <c:otherwise>
                                    ${entBasicInfo.regNO }
                                </c:otherwise>
                        </c:choose></span>
                    </p>
                    <p>
                        <i class="person2-icon"></i>法定代表人/经营者：
                        <span>${entBasicInfo.leRep }</span>
                    </p>
                    <p>
                        <i class="local-icon"></i>登记机关：<span>${entBasicInfo.regOrgName }</span>
                    </p>
                    <p>
                        <i class="date-icon"></i>成立日期：<span>${entBasicInfo.estDateStr }</span>
                    </p>
                </div>
            </div>
            <div class="tab-header tab-detail">
                <ul class="clearfix">
                    <li><a class="tab-item" href="../../depsyn/search/baseinfo?encryPriPID=${entBasicInfo.encryPriPID }&classFlag=1">基本信息</a>
                    </li>
                    <li class="tab-selected"><a class="tab-item" href="../../depsyn/search/yrinfosyn?encryPriPID=${entBasicInfo.encryPriPID }&amp;year=2015">企业年报信息</a>
                    </li>
                    <li><a class="tab-item" href="../../depsyn/search/jsinfo?encryPriPID=${entBasicInfo.encryPriPID }&classFlag=1">企业即时信息</a>
                    </li>
                    <li><a class="tab-item" href="../../depsyn/search/cfinfo?encryPriPID=${entBasicInfo.encryPriPID }&classFlag=1">处罚信息</a>
                    </li>
                    <li><a class="tab-item" href="../../depsyn/search/qtinfo?encryPriPID=${entBasicInfo.encryPriPID }&classFlag=1">其他信息</a>
                    </li>

                </ul>
            </div>
            <div class="mod-bd-panel_company pt10">
                <div class="nianbao">
                    <div class="nianbao-con">
                        <div class="title"><h3>${baseInfo.year}年度报告</h3><a href="#nianbao">有${baseInfo.updateInfo}条修改记录</a></div>
                        <p>企业年报信息由该企业提供，企业对其年报信息的真实性、合法性负责</p>
                    </div>
                    <div class="time">填报时间：${baseInfo.ancheDateStr}</div>
                </div>
                <h3 class="i-title">
                    <i></i>基本信息
                </h3>
                <ul class="encounter-info clearfix">
                    <c:choose>
                        <c:when test="${entBasicInfo.entTypeCatg==16||entBasicInfo.entTypeCatg==17}">
                            <li>
                                <em>• </em>
                                <span class="title">统一社会信用代码/注册号：</span>
							<span>
								<c:choose>
                                    <c:when test="${!empty baseInfo.uniCode}">
                                        ${baseInfo.uniCode }
                                    </c:when>
                                    <c:otherwise>
                                        ${baseInfo.regNO }
                                    </c:otherwise>
                                </c:choose>
							</span>
                            </li>
                            <li>
                                <em>• </em>
                                <span class="title">农专社名称：</span>
                                <span>${baseInfo.farSpeArtName}</span>
                            </li>
                            <li>
                                <em>• </em>
                                <c:choose>
                                    <c:when test="${fn:indexOf(baseInfo.altItem,'email')!=-1 }">
                                        <span class="title light">电子邮件：</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="title">电子邮件：</span>
                                    </c:otherwise>
                                </c:choose>
                                <span>${baseInfo.email}</span>
                            </li>
                            <li>
                                <em>• </em>
                                <c:choose>
                                    <c:when test="${fn:indexOf(baseInfo.altItem,'tel')!=-1 }">
                                        <span class="title light">联系电话：</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="title ">联系电话：</span>
                                    </c:otherwise>
                                </c:choose>
                                <span>${baseInfo.tel}</span>
                            </li>
                            <li>
                                <em>• </em>
                                <c:choose>
                                    <c:when test="${fn:indexOf(baseInfo.altItem,'memNum')!=-1 }">
                                        <span class="title light">成员人数：</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="title ">成员人数：</span>
                                    </c:otherwise>
                                </c:choose>
                                <span>${baseInfo.memNum}人</span>
                            </li>
                            <li>
                                <em>• </em>
                                <c:choose>
                                    <c:when test="${fn:indexOf(baseInfo.altItem,'farnum')!=-1 }">
                                        <span class="title light">成员人数中农民人数：</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="title ">成员人数中农民人数：</span>
                                    </c:otherwise>
                                </c:choose>
                                <span>${baseInfo.farnum}人</span>
                            </li>
                            <li>
                                <em>• </em>
                                <c:choose>
                                    <c:when test="${fn:indexOf(baseInfo.altItem,'annNewMemNum')!=-1 }">
                                        <span class="title light">本年度新增成员人数：</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="title ">本年度新增成员人数：</span>
                                    </c:otherwise>
                                </c:choose>
                                <span>${baseInfo.annNewMemNum}人</span>
                            </li>
                            <li>
                                <em>• </em>
                                <c:choose>
                                    <c:when test="${fn:indexOf(baseInfo.altItem,'annRedMemNum')!=-1 }">
                                        <span class="title light">本年度退出成员人数：</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="title ">本年度退出成员人数：</span>
                                    </c:otherwise>
                                </c:choose>
                                <span>${baseInfo.annRedMemNum}人</span>
                            </li>
                            <li>
                                <em>• </em>
                                <span class="title ">是否有网站或网店：</span>
							<span> 
								<c:if test="${baseInfo.ifWebSite > 0}"> 是</c:if> 
								<c:if test="${baseInfo.ifWebSite == 0}">否</c:if>
							</span>
                            </li>
                        </c:when>
                        <c:when test="${entBasicInfo.entTypeCatg==50}">
                            <li>
                                <em>• </em>
                                <span class="title">注册号：</span>
							<span>
								<c:choose>
                                    <c:when test="${!empty baseInfo.uniCode}">
                                        ${baseInfo.uniCode }
                                    </c:when>
                                    <c:otherwise>
                                        ${baseInfo.regNO }
                                    </c:otherwise>
                                </c:choose>
							</span>
                            </li>
                            <li>
                                <em>• </em>
                                <span class="title">个体户名称：</span>
                                <span>${baseInfo.traName}</span>
                            </li>
                            <li>
                                <em>• </em>
                                <span class="title">经营者名称：</span>
                                <span>${baseInfo.name}</span>
                            </li>
                            <li>
                                <em>• </em>
                                <c:choose>
                                    <c:when test="${fn:indexOf(baseInfo.altItem,'tel')!=-1 }">
                                        <span class="title light">经营者联系电话：</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="title ">经营者联系电话：</span>
                                    </c:otherwise>
                                </c:choose>
                                <span>${baseInfo.tel}</span>
                            </li>
                            <li>
                                <em>• </em>
                                <c:choose>
                                    <c:when test="${fn:indexOf(baseInfo.altItem,'fundAmStr')!=-1 }">
                                        <span class="title light">资金数额：</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="title ">资金数额：</span>
                                    </c:otherwise>
                                </c:choose>
                                <span>${baseInfo.fundAmStr}</span>
                            </li>
                            <li>
                                <em>• </em>
                                <c:choose>
                                    <c:when test="${fn:indexOf(baseInfo.altItem,'empNum')!=-1 }">
                                        <span class="title light">从业人数：</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="title ">从业人数：</span>
                                    </c:otherwise>
                                </c:choose>
                                <span>
                                <c:if test="${!empty baseInfo.empNum}">${baseInfo.empNum}人</c:if>
                                <c:if test="${empty baseInfo.empNum}">0人</c:if>	
                                </span>
                            </li>
                            <li>
                                <em>• </em>
                                <span class="title ">是否有网站或网店：</span>
							<span> 
								<c:if test="${baseInfo.ifWebSite > 0}"> 是</c:if> 
								<c:if test="${baseInfo.ifWebSite == 0}">否</c:if>
							</span>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li>
                                <em>• </em>
                                <span class="title">统一社会信用代码/注册号：</span>
	                        <span>
	                        	<c:choose>
                                    <c:when test="${!empty baseInfo.uniCode}">
                                        ${baseInfo.uniCode }
                                    </c:when>
                                    <c:otherwise>
                                        ${baseInfo.regNO }
                                    </c:otherwise>
                                </c:choose>
	                        </span>
                            </li>
                            <li>
                                <em>• </em>
                                <span class="title">企业名称：</span>
                                <span>${baseInfo.entName}</span>
                            </li>
                            <c:if test="${fn:indexOf('12,14,34,32,22,28,24', entBasicInfo.entTypeCatg)!=-1}">
                                <li>
                                    <em>• </em>
                                    <span class="title">隶属企业统一社会信用代码/注册号：</span>
                                    <span>${baseInfo.supRegNO}</span>
                                </li>
                                <li>
                                    <em>• </em>
                                    <span class="title">隶属企业名称：</span>
                                    <span>${baseInfo.supEntname}</span>
                                </li>
                            </c:if>
                            <li>
                                <em>• </em>
                                <c:choose>
                                    <c:when test="${fn:indexOf(baseInfo.altItem,'addr')!=-1 }">
                                        <span class="title light">企业通信地址：</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="title ">企业通信地址：</span>
                                    </c:otherwise>
                                </c:choose>
                                <span>${baseInfo.addr}</span>
                            </li>
                            <li>
                                <em>• </em>
                                <c:choose>
                                    <c:when test="${fn:indexOf(baseInfo.altItem,'postalCode')!=-1 }">
                                        <span class="title light">邮政编码：</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="title ">邮政编码：</span>
                                    </c:otherwise>
                                </c:choose>
                                <span>${baseInfo.postalCode}</span>
                            </li>
                            <li>
                                <em>• </em>
                                <c:choose>
                                    <c:when test="${fn:indexOf(baseInfo.altItem,'tel')!=-1 }">
                                        <span class="title light">企业联系电话：</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="title ">企业联系电话：</span>
                                    </c:otherwise>
                                </c:choose>
                                <span>${baseInfo.tel}</span>
                            </li>
                            <li>
                                <em>• </em>
                                <c:choose>
                                    <c:when test="${fn:indexOf(baseInfo.altItem,'email')!=-1 }">
                                        <span class="title light">企业电子邮箱：</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="title ">企业电子邮箱：</span>
                                    </c:otherwise>
                                </c:choose>
                                <span>${baseInfo.email}</span>
                            </li>
                            <c:choose>
                                <c:when test="${fn:indexOf('12,14,34,32,22,28,24', entBasicInfo.entTypeCatg)!=-1}">
                                    <li>
                                        <em>• </em>
                                        <c:choose>
                                            <c:when test="${fn:indexOf(baseInfo.altItem,'dom')!=-1 }">
                                                <span class="title light">营业场所：</span>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="title ">营业场所：</span>
                                            </c:otherwise>
                                        </c:choose>
                                        <span>${baseInfo.dom}</span>
                                    </li>
                                    <li>
                                        <em>• </em>
                                        <c:choose>
                                            <c:when test="${fn:indexOf(baseInfo.altItem,'busStatus')!=-1 }">
                                                <span class="title light">企业经营状态：</span>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="title ">企业经营状态：</span>
                                            </c:otherwise>
                                        </c:choose>
                                        <span>${baseInfo.busStatusCN}</span>
                                    </li>
                                    <li>
                                        <em>• </em>
                                        <c:choose>
                                            <c:when test="${fn:indexOf(baseInfo.altItem,'empNum')!=-1 }">
                                                <span class="title light">从业人数：</span>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="title ">从业人数：</span>
                                            </c:otherwise>
                                        </c:choose>
                                        <span>${baseInfo.empNumStr}</span>
                                    </li>
                                    <c:if test="${baseInfo.year>2015}">
                                        <li>
                                            <em>• </em>
                                            <c:choose>
                                                <c:when test="${fn:indexOf(baseInfo.altItem,'femaleEmploye')!=-1 }">
                                                    <span class="title light">其中女性从业人数：</span>
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="title ">其中女性从业人数：</span>
                                                </c:otherwise>
                                            </c:choose>
                                            <span>${baseInfo.femaleEmployeStr}</span>
                                        </li>
                                    </c:if>
                                    <li>
                                        <em>• </em>
                                        <span class="title">是否有对外担保信息：</span>
			                        <span>
			                        	<c:if test="${baseInfo.ifForguarantee > 0}"> 是</c:if> 
										<c:if test="${baseInfo.ifForguarantee == 0}">否</c:if>
			                        </span>
                                    </li>
                                    <li>
                                        <em>• </em>
                                        <span class="title">是否有网站或网店：</span>
			                        <span>
				                        <c:if test="${baseInfo.ifWebSite > 0}"> 是</c:if> 
										<c:if test="${baseInfo.ifWebSite == 0}">否</c:if>
									</span>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <li>
                                        <em>• </em>
                                        <c:choose>
                                            <c:when test="${fn:indexOf(baseInfo.altItem,'empNum')!=-1 }">
                                                <span class="title light">从业人数：</span>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="title ">从业人数：</span>
                                            </c:otherwise>
                                        </c:choose>
                                        <span>${baseInfo.empNumStr}</span>
                                    </li>
                                    <c:if test="${baseInfo.year>2015}">
                                        <li>
                                            <em>• </em>
                                            <c:choose>
                                                <c:when test="${fn:indexOf(baseInfo.altItem,'femaleEmploye')!=-1 }">
                                                    <span class="title light">其中女性从业人数：</span>
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="title ">其中女性从业人数：</span>
                                                </c:otherwise>
                                            </c:choose>
                                            <span>${baseInfo.femaleEmployeStr}</span>
                                        </li>
                                    </c:if>
                                    <li>
                                        <em>• </em>
                                        <c:choose>
                                            <c:when test="${fn:indexOf(baseInfo.altItem,'busStatus')!=-1 }">
                                                <span class="title light">企业经营状态：</span>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="title ">企业经营状态：</span>
                                            </c:otherwise>
                                        </c:choose>
                                        <span>${baseInfo.busStatusCN}</span>
                                    </li>
                                    <c:if test="${baseInfo.year>2015}">
                                        <li>
                                            <em>• </em>
                                            <span class="title">企业控股情况：</span>
			                        <span>
				                        <c:choose>
                                            <c:when test="${baseInfo.entControlStr=='1' }">
                                                国有控股
                                            </c:when>
                                            <c:when test="${baseInfo.entControlStr=='2' }">
                                                集体控股
                                            </c:when>
                                            <c:when test="${baseInfo.entControlStr=='3' }">
                                                私人控股
                                            </c:when>
                                            <c:when test="${baseInfo.entControlStr=='4' }">
                                                港澳台商控股
                                            </c:when>
                                            <c:when test="${baseInfo.entControlStr=='5' }">
                                                外商控股
                                            </c:when>
                                            <c:when test="${baseInfo.entControlStr=='6' }">
                                                其他
                                            </c:when>
                                            <c:otherwise>
                                                ${baseInfo.entControlStr}
                                            </c:otherwise>
                                        </c:choose>
			                        </span>
                                        </li>
                                    </c:if>
                                    <li>
                                        <em>• </em>
                                        <span class="title">是否有投资信息或购买其他公司股权：</span>
			                        <span>
			                        	<c:if test="${baseInfo.ifForInvest > 0}"> 是</c:if> 
										<c:if test="${baseInfo.ifForInvest == 0}">否</c:if>
			                        </span>
                                    </li>
                                    <li>
                                        <em>• </em>
                                        <span class="title ">是否有网站或网店：</span>
			                        <span>
				                        <c:if test="${baseInfo.ifWebSite > 0}"> 是</c:if> 
										<c:if test="${baseInfo.ifWebSite == 0}">否</c:if>
									</span>
                                    </li>
                                    <li>
                                        <em>• </em>
                                        <span class="title">是否有对外担保信息：</span>
			                        <span>
			                        	<c:if test="${baseInfo.ifForguarantee > 0}"> 是</c:if> 
										<c:if test="${baseInfo.ifForguarantee == 0}">否</c:if>
			                        </span>
                                    </li>
                                    <c:if test="${fn:indexOf(repType,'alterstockinfo') != -1}">
                                        <li>
                                            <em>• </em>
                                            <span class="title">有限责任公司本年度是否发生股东股权转让：</span>
				                        <span>
				                        	<c:if test="${baseInfo.ifAleErstock > 0}"> 是</c:if> 
											<c:if test="${baseInfo.ifAleErstock == 0}">否</c:if>
				                        </span>
                                        </li>
                                    </c:if>
                                </c:otherwise>
                            </c:choose>
                            <c:if test="${baseInfo.year>2015}">
                                <li class="item-width">
                                    <em>• </em>
                                    <c:choose>
                                        <c:when test="${fn:indexOf(baseInfo.altItem,'entMainBusActivity')!=-1 }">
                                            <span class="title light">企业主营业务活动：</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="title ">企业主营业务活动：</span>
                                        </c:otherwise>
                                    </c:choose>
                                    <span>${baseInfo.entMainBusActivity}</span>
                                </li>
                            </c:if>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
            
            <form id="params">
                <input type="hidden" id="anCheID" name="anCheID" value="${baseInfo.anCheID}"/>
            </form>
            <input type="hidden" name="entTypeCatg" id="entTypeCatg" value="${entBasicInfo.entTypeCatg }"/>
            
            <c:choose>
                <c:when test="${entBasicInfo.entTypeCatg==16||entBasicInfo.entTypeCatg==17}">
                <!-- 农专网站或网店信息 -->
                    <div class="mod-bd-panel_company">
                        <c:choose>
                            <c:when test="${fn:indexOf(baseInfo.altTableItem,'SfcWebsiteInfo')!=-1 }">
                                <h3 class="i-title">
                                    <i></i><span class="light">网站或网店信息</span>
                                    <span class="number" id="sfcwebsitelight">共计X条信息</span>
                                </h3>
                            </c:when>
                            <c:otherwise>
                                <h3 class="i-title">
                                    <i></i>网站或网店信息
                                    <span class="number" id="sfcwebsite">共计X条信息</span>
                                </h3>
                            </c:otherwise>
                        </c:choose>
                        <div class="renyuan-list sfc_website clearfix">
                        </div>
                    </div>
                    <!-- 农专资产状况信息 -->
                    <div class="mod-bd-panel_company">
                        <h3 class="i-title">
                            <i></i>生产经营情况信息
                        </h3>
                        <table class="table-common table-zichan">
                            <tr>
                                <td>营业额或营业收入</td>
                                <td>${baseInfo.vendIncStr}</td>
                                <td>纳税金额</td>
                                <td>${baseInfo.ratGroStr}</td>
                            </tr>
                            <tr>
                                <td>盈余总额</td>
                                <td>${baseInfo.priYeaProfitStr}</td>
                                <td>获得政府扶持资金、补助</td>
                                <td>${baseInfo.priYeaSubStr}</td>
                            </tr>
                            <tr>
                                <td>金融贷款</td>
                                <td>${baseInfo.priYeaLoanStr}</td>
                                <td></td>
                                <td></td>
                            </tr>
                        </table>
                    </div>
                    <!-- 农专分支机构信息 -->
                    <div class="mod-bd-panel_company">
                        <c:choose>
                            <c:when test="${fn:indexOf(baseInfo.altTableItem,'SfcBranchInfo')!=-1 }">
                                <h3 class="i-title">
                                    <i></i><span class="light">分支机构信息</span>
                                </h3>
                            </c:when>
                            <c:otherwise>
                                <h3 class="i-title">
                                    <i></i>分支机构信息
                                </h3>
                            </c:otherwise>
                        </c:choose>

                        <table class="table-common mb20">
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>分支机构统一社会信用码/注册号</th>
                                <th>分支机构名称</th>
                            </tr>
                            </thead>
                            <tbody id="table-sfc_branchinfo">
                            </tbody>
                        </table>
                        <div class="notice-pagination-box clearfix">
                            <span class="page-total">共查询到 <em id="_total_sfc_branchinfo"></em> 条信息，共 <em
                                    id="_pageNum_sfc_branchinfo"></em> 页</span>
                            <div id="pagination_sfc_branchinfo" class="pagination">
                            </div>
                        </div>
                    </div>
                    <script id="table-template-sfc_branchinfo" type="text/x-handlebars-template">
                        {{#each data}}
                        <tr>
                            <td>{{xh @index}}</td>
                            <td>{{{uniCode this}}}</td>
                            <td>{{{brName this}}}</td>
                        </tr>
                        {{/each}}
                    </script>
                    <!-- 农专年报行政许可信息 -->
                    <div class="mod-bd-panel_company">
                        <c:choose>
                            <c:when test="${fn:indexOf(baseInfo.altTableItem,'SfcLicenceInfo')!=-1 }">
                                <h3 class="i-title">
                                    <i></i><span class="light">行政许可信息</span>
                                </h3>
                            </c:when>
                            <c:otherwise>
                                <h3 class="i-title">
                                    <i></i>行政许可信息
                                </h3>
                            </c:otherwise>
                        </c:choose>
                        <table class="table-common mb20">
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>许可文件中文名称</th>
                                <th>有效期至</th>
                            </tr>
                            </thead>
                            <tbody id="table-sfc_licenceinfo">
                            </tbody>
                        </table>
                        <div class="notice-pagination-box clearfix">
                            <span class="page-total">共查询到 <em id="_total_sfc_licenceinfo"></em> 条信息，共 <em
                                    id="_pageNum_sfc_licenceinfo"></em> 页</span>
                            <div id="pagination_sfc_licenceinfo" class="pagination">
                            </div>
                        </div>
                    </div>
                    <script id="table-template-sfc_licenceinfo" type="text/x-handlebars-template">
                        {{#each data}}
                        <tr>
                            <td>{{xh @index}}</td>
                            <td>{{{licNameCN this}}}</td>
                            <td>{{{valTo this}}}</td>
                        </tr>
                        {{/each}}
                    </script>

                    <!-- 农专年报修改信息 -->
                    <div class="mod-bd-panel_company">
                        <h3 class="i-title">
                            <i></i>年报修改信息
                        </h3>
                        <table class="table-common mb20">
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>修改事项</th>
                                <th>修改前</th>
                                <th>修改后</th>
                                <th>修改日期</th>
                            </tr>
                            </thead>
                            <tbody id="table-sfc_updateinfo">
                            </tbody>
                        </table>
                        <div class="notice-pagination-box clearfix">
                            <span class="page-total">共查询到 <em id="_total_sfc_updateinfo"></em> 条信息，共 <em
                                    id="_pageNum_sfc_updateinfo"></em> 页</span>
                            <div id="pagination_sfc_updateinfo" class="pagination">
                            </div>
                        </div>
                    </div>
                    <script id="table-template-sfc_updateinfo" type="text/x-handlebars-template">
                        {{#each data}}
                        <tr>
                            <td>{{xh @index}}</td>
                            <td>{{altItemName}}</td>
                            <td>{{{altBe this}}}</td>
                            <td>{{{altAf this}}}</td>
                            <td>{{transAltDate altDate}}</td>
                        </tr>
                        {{/each}}
                    </script>
                </c:when>
                <c:when test="${entBasicInfo.entTypeCatg==50}">
                <!-- 个体户网站或网店信息 -->
                    <div class="mod-bd-panel_company">
                        <c:choose>
                            <c:when test="${fn:indexOf(baseInfo.altTableItem,'PbWebsiteinfo')!=-1 }">
                                <h3 class="i-title">
                                    <i></i><span class="light">网站或网店信息</span>
                                    <span class="number" id="pbwebsitelight">共计X条信息</span>
                                </h3>
                            </c:when>
                            <c:otherwise>
                                <h3 class="i-title">
                                    <i></i>网站或网店信息
                                    <span class="number" id="pbwebsite">共计X条信息</span>
                                </h3>
                            </c:otherwise>
                        </c:choose>
                        <div class="renyuan-list pb_website clearfix">
                        </div>
                    </div>
                    <!-- 个体户生产经营情况信息 -->
                    <div class="mod-bd-panel_company">
                        <c:choose>
                            <c:when test="${fn:indexOf(baseInfo.altItem,'vendIncIsPub')!=-1||fn:indexOf(baseInfo.altItem,'ratGroIsPub')!=-1 }">
                                <h3 class="i-title">
                                    <i></i><span class="light">生产经营情况信息</span>
                                </h3>
                            </c:when>
                            <c:otherwise>
                                <h3 class="i-title">
                                    <i></i>生产经营情况信息
                                </h3>
                            </c:otherwise>
                        </c:choose>
                        <table class="table-common table-zichan">
                            <tr>
                                <td>营业额或营业总收入</td>
                                <td>${baseInfo.vendIncStr}</td>
                                <td>纳税总额</td>
                                <td>${baseInfo.ratGroStr}</td>
                            </tr>
                        </table>
                    </div>
                    <!-- 个体户年报行政许可信息 -->
                    <div class="mod-bd-panel_company">
                        <c:choose>
                            <c:when test="${fn:indexOf(baseInfo.altTableItem,'PbLicenceinfo')!=-1 }">
                                <h3 class="i-title">
                                    <i></i><span class="light">行政许可信息</span>
                                </h3>
                            </c:when>
                            <c:otherwise>
                                <h3 class="i-title">
                                    <i></i>行政许可信息
                                </h3>
                            </c:otherwise>
                        </c:choose>

                        <table class="table-common mb20">
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>许可文件中文名称</th>
                                <th>有效期至</th>
                            </tr>
                            </thead>
                            <tbody id="table-pb_licenceinfo">
                            </tbody>
                        </table>
                        <div class="notice-pagination-box clearfix">
                            <span class="page-total">共查询到 <em id="_total_pb_licenceinfo"></em> 条信息，共 <em
                                    id="_pageNum_pb_licenceinfo"></em> 页</span>
                            <div id="pagination_pb_licenceinfo" class="pagination">
                            </div>
                        </div>
                    </div>
                    <script id="table-template-pb_licenceinfo" type="text/x-handlebars-template">
                        {{#each data}}
                        <tr>
                            <td>{{xh @index}}</td>
                            <td>{{{licNameCN this}}}</td>
                            <td>{{{valTo this}}}</td>
                        </tr>
                        {{/each}}
                    </script>

                    <!-- 个体户年报修改信息 -->
                    <div class="mod-bd-panel_company">
                        <h3 class="i-title">
                            <i></i>修改信息
                        </h3>
                        <table class="table-common mb20">
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>修改事项</th>
                                <th>修改前</th>
                                <th>修改后</th>
                                <th>修改日期</th>
                            </tr>
                            </thead>
                            <tbody id="table-pb_updateinfo">
                            </tbody>
                        </table>
                        <div class="notice-pagination-box clearfix">
                            <span class="page-total">共查询到 <em id="_total_pb_updateinfo"></em> 条信息，共 <em
                                    id="_pageNum_pb_updateinfo"></em> 页</span>
                            <div id="pagination_pb_updateinfo" class="pagination">
                            </div>
                        </div>
                    </div>
                    <script id="table-template-pb_updateinfo" type="text/x-handlebars-template">
                        {{#each data}}
                        <tr>
                            <td>{{xh @index}}</td>
                            <td>{{altItemName}}</td>
                            <td>{{{altBe this}}}</td>
                            <td>{{{altAf this}}}</td>
                            <td>{{transAltDate altDate}}</td>
                        </tr>
                        {{/each}}
                    </script>
                </c:when>
                <c:otherwise>
                <!-- 网站或网店信息 -->
                    <div class="mod-bd-panel_company">
                        <c:choose>
                            <c:when test="${fn:indexOf(baseInfo.altTableItem,'WebsiteInfo')!=-1 }">
                                <h3 class="i-title ">
                                    <i></i><span class="light">网站或网店信息</span>
                                    <span class="number" id="websitelight">共计X条信息</span>
                                </h3>
                            </c:when>
                            <c:otherwise>
                                <h3 class="i-title">
                                    <i></i>网站或网店信息
                                    <span class="number" id="website">共计X条信息</span>
                                </h3>
                            </c:otherwise>
                        </c:choose>

                        <div class="renyuan-list website clearfix">
                        </div>
                    </div>
                <!-- 企业资产状况信息 -->
                <div class="mod-bd-panel_company no-borderlr">
	                <h3 class="i-title">
	                    <i></i>企业资产状况信息
	                </h3>
	                <table class="table-common mb20">
	                    <thead>
	                    <tr>
	                        <th width="52">序号</th>
	                        <th width="100">资产总额</th>
	                        <th width="100">负债总额</th>
	                        <th width="100">所有者权益合计</th>
	                        <th width="100">主营业务收入</th>
	                        <th width="100">利润总额</th>
	                        <th width="100">净利润</th>
	                        <th width="100">纳税总额</th>
	                    </tr>
	                    </thead>
	                    <tbody>
	                    <tr>
	                        <td>1</td>
	                        <td>${baseInfo.assGroStr}</td>
	                        <td>${baseInfo.liaGroStr}</td>
	                        <td>${baseInfo.totEquStr}</td>
	                        <td>${baseInfo.maiBusIncStr}</td>
	                        <td>${baseInfo.proGroStr}</td>
	                        <td>${baseInfo.netIncStr}</td>
	                        <td>${baseInfo.ratGroStr}</td>
	                    </tr>
	                    </tbody>
	                </table>
	            </div>
	            <!-- 股东及出资信息 -->
	            <c:if test="${fn:indexOf(repType,'subcapital') != -1}">
	            <div class="mod-bd-panel_company no-borderlr">
	                <c:choose>
                        <c:when test="${fn:indexOf(baseInfo.altTableItem,'Subcapital')!=-1 }">
                            <h3 class="i-title">
                                <i></i><span class="light">股东及出资信息</span>
                            </h3>
                        </c:when>
                        <c:otherwise>
                            <h3 class="i-title">
                                <i></i>股东及出资信息
                            </h3>
                        </c:otherwise>
                    </c:choose>
	                <table class="table-common mb20">
	                    <thead>
	                    <tr>
	                        <th width="52">序号</th>
	                        <th width="100">股东/发起人名称</th>
	                        <th width="100">累计认缴额</th>
	                        <th width="100">认缴出资日期</th>
	                        <th width="100">认缴出资方式</th>
	                        <th width="100">累计实缴额</th>
	                        <th width="100">实缴出资日期</th>
	                        <th width="100">实缴出资方式</th>
	                    </tr>
	                    </thead>
	                    <tbody id="table-inv">
                        </tbody>
	                </table>
	                <div class="notice-pagination-box clearfix">
                        <span class="page-total">共查询到 <em id="_total_inv"></em> 条信息，共 <em
                                id="_pageNum_inv"></em> 页</span>
                        <div id="pagination_inv" class="pagination">
                        </div>
                    </div>
	            </div>
	            <script id="table-template-inv" type="text/x-handlebars-template">
                            {{#each data}}
                            <tr>
                                <td>{{xh @index}}</td>
                                <td>{{{inv this}}}</td>
                                <td>{{{lisubconam this}}}</td>
                                <td>{{{subConDate this}}}</td>
                                <td>{{{conFormCN this}}}</td>
                                <td>{{{liacconam this}}}</td>
                                <td>{{{acConDate this}}}</td>
                                <td>{{{acConFormCn this}}}</td>
                            </tr>
                            {{/each}}
                 </script>
	            </c:if>
	            <!-- 对外提供保证担保信息 -->
                    <div class="mod-bd-panel_company no-borderlr">
                        <c:choose>
                            <c:when test="${fn:indexOf(baseInfo.altTableItem,'ForGuaranteeInfo')!=-1 }">
                                <h3 class="i-title">
                                    <i></i><span class="light">对外提供保证担保信息</span>
                                </h3>
                            </c:when>
                            <c:otherwise>
                                <h3 class="i-title">
                                    <i></i>对外提供保证担保信息
                                </h3>
                            </c:otherwise>
                        </c:choose>
	            	<table class="table-common mb20" id="forguaranteeinfo_div">
                    <thead>
                         <tr>
                             <th>序号</th>
                             <th>债权人</th>
                             <th>债务人</th>
                             <th>主债权种类</th>
                             <th>主债权数额</th>
                             <th>履行债务的期限</th>
                             <th>保证的期间</th>
                             <th>保证的方式</th>
                         </tr>
                         </thead>
                         <tbody id="table-forguaranteeinfo">
                         </tbody>
                     </table>
                     <div class="notice-pagination-box clearfix">
                         <span class="page-total">共查询到 <em id="_total_forguaranteeinfo"></em> 条信息，共 <em
                                 id="_pageNum_forguaranteeinfo"></em> 页</span>
                         <div id="pagination_forguaranteeinfo" class="pagination">
                         </div>
                     </div>
                 </div>
                    <script id="table-template-forguaranteeinfo" type="text/x-handlebars-template">
                        {{#each data}}
                        <tr>
                            <td>{{xh @index}}</td>
                            <td>{{{more this}}}</td>
                            <td>{{{mortgagor this}}}</td>
                            <td>{{{transKindCN this}}}</td>
                            <td>{{{priClaSecAm this}}}</td>
                            <td>{{{pefPerDate this}}}</td>
                            <td>{{{guaPeriodCN this}}}</td>
                            <td>{{{transTypeCN this}}}</td>
                        </tr>
                        {{/each}}
                    </script>
                    <!-- 对外投资信息 -->
                    <c:if test="${fn:indexOf(repType,'forinvestment') != -1}">
                        <div class="mod-bd-panel_company no-borderlr">
                            <c:choose>
                                <c:when test="${fn:indexOf(baseInfo.altTableItem,'ForinvestMent')!=-1 }">
                                    <h3 class="i-title">
                                        <i></i><span class="light">对外投资信息</span>
                                        <span class="number" id="yrforinvestment">共计X条信息</span>
                                    </h3>
                                </c:when>
                                <c:otherwise>
                                    <h3 class="i-title">
                                        <i></i>对外投资信息
                                        <span class="number" id="yrforinvestment">共计X条信息</span>
                                    </h3>
                                </c:otherwise>
                            </c:choose>
                            <div class="renyuan-list forinvestment clearfix">
                            </div>
                        </div>
                    </c:if>
                    
                    <!-- 股权变更信息 -->
                    <c:if test="${fn:indexOf(repType,'alterstockinfo') != -1}">
                        <div class="mod-bd-panel_company no-borderlr">
                            <c:choose>
                                <c:when test="${fn:indexOf(baseInfo.altTableItem,'AlterStockInfo')!=-1 }">
                                    <h3 class="i-title">
                                        <i></i><span class="light">股权变更信息</span>
                                    </h3>
                                </c:when>
                                <c:otherwise>
                                    <h3 class="i-title">
                                        <i></i>股权变更信息
                                    </h3>
                                </c:otherwise>
                            </c:choose>
                            <table class="table-common mb20">
                                <thead>
                                <tr>
                                    <th width="100">序号</th>
                                    <th width="200">股东</th>
                                    <th width="150">变更前股权比例</th>
                                    <th width="150">变更后股权比例</th>
                                    <th width="200">股权变更日期</th>
                                </tr>
                                </thead>
                                <tbody id="table-alterstockinfo">
                                </tbody>
                            </table>
                            <div class="notice-pagination-box clearfix">
                                <span class="page-total">共查询到 <em id="_total_alterstockinfo"></em> 条信息，共 <em
                                        id="_pageNum_alterstockinfo"></em> 页</span>
                                <div id="pagination_alterstockinfo" class="pagination">
                                </div>
                            </div>
                        </div>
                        <script id="table-template-alterstockinfo" type="text/x-handlebars-template">
                            {{#each data}}
                            <tr>
                                <td>{{xh @index}}</td>
                                <td>{{{inv this}}}</td>
                                <td>{{{beTransAmPr this}}}</td>
                                <td>{{{afTransAmPr this}}}</td>
                                <td>{{{altDate this}}}</td>
                            </tr>
                            {{/each}}
                        </script>
                    </c:if>
                    <!-- 修改信息 -->
                    <div class="mod-bd-panel_company" id="nianbao">
                        <h3 class="i-title">
                            <i></i>修改信息
                        </h3>
                        <table class="table-common mb20">
                            <thead>
                            <tr>
                                <th width="60">序号</th>
                                <th width="130">修改事项</th>
                                <th width="300">修改前</th>
                                <th width="300">修改后</th>
                                <th width="150">修改日期</th>
                            </tr>
                            </thead>
                            <tbody id="table-updateinfo">
                            </tbody>
                        </table>
                        <div class="notice-pagination-box clearfix">
                            <span class="page-total">共查询到 <em id="_total_updateinfo"></em> 条信息，共 <em
                                    id="_pageNum_updateinfo"></em> 页</span>
                            <div id="pagination_updateinfo" class="pagination">
                            </div>
                        </div>
                    </div>
                    <script id="table-template-updateinfo" type="text/x-handlebars-template">
                        {{#each data}}
                        <tr>
                            <td>{{xh @index}}</td>
                            <td>{{altItemName}}</td>
                            <td>{{{altBe this}}}</td>
                            <td>{{{altAf this}}}</td>
                            <td>{{transAltDate altDate}}</td>
                        </tr>
                        {{/each}}
                    </script>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
<script>
      //参数的传递
      window._CONFIG = {
          repType: '${repType}'
      }
</script>
<script src="../../../../js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="/js/depsyn/search/yrinfosyn_list.js"></script>
</body>
</html>