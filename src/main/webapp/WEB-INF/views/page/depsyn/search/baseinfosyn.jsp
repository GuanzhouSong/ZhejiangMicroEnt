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
    <input type="hidden" name="encryPriPID" id="encryPriPID" value="${entBasicInfo.encryPriPID }"/>
    <form id="params">
        <input type="hidden" name="priPID" id="priPID" value="${entBasicInfo.priPID }"/>
    </form>
    <input type="hidden" name="entTypeCatg" id="entTypeCatg" value="${entBasicInfo.entTypeCatg }"/>
        <div class="crumbs">
            <a href="/depsyn/index">首页</a> &gt;
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
                        <span>
                        <c:choose>
                                <c:when test="${!empty entBasicInfo.UNICODE}">
                                    ${entBasicInfo.UNICODE }
                                </c:when>
                                <c:otherwise>
                                    ${entBasicInfo.regNO }
                                </c:otherwise>
                        </c:choose></span>
                    </p>
                    <p>
                        <i class="person2-icon"></i>
                                                                法定代表人/经营者:<span>${entBasicInfo.leRep }</span>
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
                	<li class="tab-selected"><a class="tab-item" href="../../depsyn/search/baseinfosyn?encryPriPID=${entBasicInfo.encryPriPID }&classFlag=1">基本信息</a>
                    </li>
                    <li><a class="tab-item" href="../../depsyn/search/yrinfosyn?encryPriPID=${entBasicInfo.encryPriPID }&year=2015">企业年报信息</a>
                    </li>
                    <li><a class="tab-item" href="../../depsyn/search/jsinfo?encryPriPID=${entBasicInfo.encryPriPID }&classFlag=1">企业即时信息</a>
                    </li>
                    <li><a class="tab-item" href="../../depsyn/search/cfinfo?encryPriPID=${entBasicInfo.encryPriPID }&classFlag=1">处罚信息</a>
                    </li>
                    <li><a class="tab-item" href="../../depsyn/search/qtinfo?encryPriPID=${entBasicInfo.encryPriPID }&classFlag=1">其他信息</a>
                    </li>

                </ul>
            </div>
            <div class="mod-bd-panel_company">
                <h3 class="i-title">
                    <i></i>照面信息
                </h3>
                <ul class="encounter-info clearfix">
                <!-- 分支机构 -->
                <c:if test="${fn:indexOf('12,14,34,32,22,28,24', entBasicInfo.entTypeCatg)!=-1}">
                    <li>
                        <span class="title right qyzc-info"><em>• </em>统一社会信用代码/注册号：</span>
	                    <span>
		                    <c:choose>
                                <c:when test="${!empty entBasicInfo.UNICODE}">
                                    ${entBasicInfo.UNICODE }
                                </c:when>
                                <c:otherwise>
                                    ${entBasicInfo.regNO }
                                </c:otherwise>
                            </c:choose>
	                    </span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>企业名称：</span>
                        <span>${entBasicInfo.entName }</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>类型：</span>
                        <span>${entBasicInfo.entTypeName }</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>负责人：</span>
                        <span>${entBasicInfo.leRep }</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>营业期限自：</span>
                        <span>${entBasicInfo.opFromStr}</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>营业期限至：</span>
                        <span>${entBasicInfo.opToStr}</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>登记机关：</span>
                        <span>${entBasicInfo.regOrgName }</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>成立日期：</span>
                        <span>${entBasicInfo.estDateStr}</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>登记状态：</span>
	                    <span>
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
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>核准日期：</span>
                        <span>${entBasicInfo.apprDateStr}</span>
                    </li>
                    <li class="item-width">
                        <span class="title right qyzc-info"><em>• </em>营业场所：</span>
                        <span>${entBasicInfo.dom }</span>
                    </li>
                    <li class="item-width">
                        <span class="title right qyzc-info"><em>• </em>经营范围：</span>
                        <span>${entBasicInfo.opScope }</span>
                    </li>
                </c:if>
                <!-- 公司,外商投资企业,非公司企业法人 -->
                <c:if test="${fn:indexOf('11,21,13', entBasicInfo.entTypeCatg)!=-1}">
                    <li>
                        <span class="title right qyzc-info"><em>• </em>统一社会信用代码/注册号：</span>
	                    <span>
	                    	<c:choose>
                                <c:when test="${!empty entBasicInfo.UNICODE}">
                                    ${entBasicInfo.UNICODE }
                                </c:when>
                                <c:otherwise>
                                    ${entBasicInfo.regNO }
                                </c:otherwise>
                            </c:choose>
	                    </span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>企业名称：</span>
                        <span>${entBasicInfo.entName }</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>类型：</span>
                        <span>${entBasicInfo.entTypeName }</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>法定代表人：</span>
                        <span>${entBasicInfo.leRep }</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>注册资本：</span>
                        <span>${entBasicInfo.regCap }万人民币</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>成立日期：</span>
                        <span>${entBasicInfo.estDateStr }</span>
                    </li>
                    <li>
	                    <span class="title right qyzc-info">
							<em>• </em>
		                    <c:if test="${fn:indexOf('11,21', entBasicInfo.entTypeCatg)!=-1}">
                                营业期限自：
                            </c:if>
	                    	<c:if test="${fn:indexOf('13', entBasicInfo.entTypeCatg)!=-1}">
                                经营期限自：
                            </c:if>
	                    </span>
                        <span>${entBasicInfo.opFromStr}</span>
                    </li>
                    <li>
	                    <span class="title right qyzc-info">
							<em>• </em>
	                    	<c:if test="${fn:indexOf('11,21', entBasicInfo.entTypeCatg)!=-1}">
                                营业期限至：
                            </c:if>
	                    	<c:if test="${fn:indexOf('13', entBasicInfo.entTypeCatg)!=-1}">
                                经营期限至：
                            </c:if>
	                    </span>
                        <span>${entBasicInfo.opToStr}</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>登记机关：</span>
                        <span>${entBasicInfo.regOrgName }</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>核准日期：</span>
                        <span>${entBasicInfo.apprDateStr}</span>
                    </li>
                    <li class="item-width">
                        <span class="title right qyzc-info"><em>• </em>登记状态：</span>
	                    <span>
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
                    </li>
                    <li class="item-width">
                        <span class="title right qyzc-info"><em>• </em>住所：</span>
                        <span>${entBasicInfo.dom }</span>
                    </li>
                    <li class="item-width">
                        <span class="title right qyzc-info"><em>• </em>经营范围：</span>
                        <span>${entBasicInfo.opScope }</span>
                    </li>


                </c:if>

                <!-- 合伙企业,外商投资合伙企业 -->
                <c:if test="${fn:indexOf('33,27', entBasicInfo.entTypeCatg)!=-1}">
                    <li>
                        <span class="title right qyzc-info"><em>• </em>统一社会信用代码/注册号：</span>
	                    <span>
	                    	<c:choose>
                                <c:when test="${!empty entBasicInfo.UNICODE}">
                                    ${entBasicInfo.UNICODE }
                                </c:when>
                                <c:otherwise>
                                    ${entBasicInfo.regNO }
                                </c:otherwise>
                            </c:choose>
	                    </span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>企业名称：</span>
                        <span>${entBasicInfo.entName }</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>类型：</span>
                        <span>${entBasicInfo.entTypeName }</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>执行事务合伙人：</span>
                        <span>${entBasicInfo.leRep }</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>合伙期限自：</span>
                        <span>${entBasicInfo.opFromStr}</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>合伙期限至：</span>
                        <span>${entBasicInfo.opToStr}</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>登记机关：</span>
                        <span>${entBasicInfo.regOrgName }</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>成立日期：</span>
                        <span>${entBasicInfo.estDateStr}</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>登记状态：</span>
	                    <span>
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
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>核准日期：</span>
                        <span>${entBasicInfo.apprDateStr}</span>
                    </li>
                    <li class="item-width">
                        <span class="title right qyzc-info"><em>• </em>主要经营场所：</span>
                        <span>${entBasicInfo.dom }</span>
                    </li>
                    <li class="item-width">
                        <span class="title right qyzc-info"><em>• </em>经营范围：</span>
                        <span>${entBasicInfo.opScope }</span>
                    </li>
                </c:if>

                <!-- 个人独资企业,农民专业合作社分支机构 -->
                <c:if test="${fn:indexOf('31,17', entBasicInfo.entTypeCatg)!=-1}">
                    <li>
                        <span class="title right qyzc-info"><em>• </em>统一社会信用代码/注册号：</span>
	                    <span>
	                    	<c:choose>
                                <c:when test="${!empty entBasicInfo.UNICODE}">
                                    ${entBasicInfo.UNICODE }
                                </c:when>
                                <c:otherwise>
                                    ${entBasicInfo.regNO }
                                </c:otherwise>
                            </c:choose>
	                    </span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>企业名称：</span>
                        <span>${entBasicInfo.entName }</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>类型：</span>
                        <span>${entBasicInfo.entTypeName }</span>
                    </li>
                    <li>
	                    <span class="title right qyzc-info">
							<em>• </em>
	                    	<c:if test="${fn:indexOf('31', entBasicInfo.entTypeCatg)!=-1}">
                                投资人：
                            </c:if>
	                    	<c:if test="${fn:indexOf('17', entBasicInfo.entTypeCatg)!=-1}">
                                负责人：
                            </c:if>
	                    </span>
                        <span>${entBasicInfo.leRep }</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>登记机关：</span>
                        <span>${entBasicInfo.regOrgName }</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>成立日期：</span>
                        <span>${entBasicInfo.estDateStr}</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>登记状态：</span>
	                    <span>
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
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>核准日期：</span>
                        <span>${entBasicInfo.apprDateStr}</span>
                    </li>
                    <li class="item-width">
	                    <span class="title right qyzc-info">
	                    	<em>• </em>
	                    	<c:if test="${fn:indexOf('31', entBasicInfo.entTypeCatg)!=-1}">
                                住所：
                            </c:if>
	                    	<c:if test="${fn:indexOf('17', entBasicInfo.entTypeCatg)!=-1}">
                                经营场所：
                            </c:if>
	                    </span>
                        <span>${entBasicInfo.dom }</span>
                    </li>
                    <li class="item-width">
	                    <span class="title right qyzc-info">
							<em>• </em>
	                    	<c:if test="${fn:indexOf('31', entBasicInfo.entTypeCatg)!=-1}">
                                经营范围：
                            </c:if>
	                    	<c:if test="${fn:indexOf('17', entBasicInfo.entTypeCatg)!=-1}">
                                业务范围：
                            </c:if>
	                    </span>
                        <span>${entBasicInfo.opScope }</span>
                    </li>
                </c:if>

                <!-- 个体户,农民专业合作社 -->
                <c:if test="${fn:indexOf('50,16', entBasicInfo.entTypeCatg)!=-1}">
                    <li>
                        <span class="title right qyzc-info"><em>• </em>统一社会信用代码/注册号：</span>
	                    <span>
	                    	<c:choose>
                                <c:when test="${!empty entBasicInfo.UNICODE}">
                                    ${entBasicInfo.UNICODE }
                                </c:when>
                                <c:otherwise>
                                    ${entBasicInfo.regNO }
                                </c:otherwise>
                            </c:choose>
	                    </span>
                    </li>
                    <li>
	                    <span class="title right qyzc-info">
							<em>• </em>
	                    	<c:if test="${fn:indexOf('50', entBasicInfo.entTypeCatg)!=-1}">
                                名称：
                            </c:if>
	                    	<c:if test="${fn:indexOf('16', entBasicInfo.entTypeCatg)!=-1}">
                                企业名称：
                            </c:if>
	                    </span>
                        <span>${entBasicInfo.entName }</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>类型：</span>
                        <span>${entBasicInfo.entTypeName }</span>
                    </li>
                    <li>
	                    <span class="title right qyzc-info">
							<em>• </em>
	                    	<c:if test="${fn:indexOf('50', entBasicInfo.entTypeCatg)!=-1}">
                                经营者：
                            </c:if>
	                    	<c:if test="${fn:indexOf('16', entBasicInfo.entTypeCatg)!=-1}">
                                法定代表人：
                            </c:if>
	                    </span>
                        <span>${entBasicInfo.leRep }</span>
                    </li>
                    <c:if test="${fn:indexOf('50', entBasicInfo.entTypeCatg)!=-1}">
                        <li>
                            <span class="title right qyzc-info"><em>• </em>组成形式：</span>
                            <span>${entBasicInfo.compFormName }</span>
                        </li>
                        <li>
                            <span class="title right qyzc-info"><em>• </em>注册日期：</span>
                            <span>${entBasicInfo.estDateStr}</span>
                        </li>
                    </c:if>
                    <c:if test="${fn:indexOf('16', entBasicInfo.entTypeCatg)!=-1}">
                        <li>
                            <span class="title right qyzc-info"><em>• </em>成员出资总额：</span>
                            <span>${entBasicInfo.regCap }万元人民币</span>
                        </li>
                        <li>
                            <span class="title right qyzc-info"><em>• </em>成立日期：</span>
                            <span>${entBasicInfo.estDateStr}</span>
                        </li>
                    </c:if>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>登记机关：</span>
                        <span>${entBasicInfo.regOrgName }</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>核准日期：</span>
                        <span>${entBasicInfo.apprDateStr}</span>
                    </li>
                    <li class="item-width">
                        <span class="title right qyzc-info"><em>• </em>登记状态：</span>
	                    <span>
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
                    </li>
                    <li class="item-width">
	                    <span class="title right qyzc-info">
							<em>• </em>
	                    	<c:if test="${fn:indexOf('50', entBasicInfo.entTypeCatg)!=-1}">
                                经营场所：
                            </c:if>
	                    	<c:if test="${fn:indexOf('16', entBasicInfo.entTypeCatg)!=-1}">
                                住所：
                            </c:if>
	                    </span>
                        <span>${entBasicInfo.dom }</span>
                    </li>
                    <li class="item-width">
	                    <span class="title right qyzc-info">
							<em>• </em>
	                    	<c:if test="${fn:indexOf('50', entBasicInfo.entTypeCatg)!=-1}">
                                经营范围：
                            </c:if>
	                    	<c:if test="${fn:indexOf('16', entBasicInfo.entTypeCatg)!=-1}">
                                业务范围：
                            </c:if>
	                    </span>
                        <span>${entBasicInfo.opScope }</span>
                    </li>
                </c:if>
            </ul>
        </div>
 </div>
 <!-- 内资非公司企业法人主管部门（出资人）信息 -->
        <c:if test="${fn:indexOf('13', entBasicInfo.entTypeCatg)!=-1}">
            <div class="mod company-about">
                <div class="mod-bd-panel_company">
                    <h3 class="i-title">
                        <i></i>主管部门（出资人）信息
                    </h3>
                    <table class="table-common mb20">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>出资人类型</th>
                            <th>出资人</th>
                            <th>证照/证件类型</th>
                            <th>证照/证件号码</th>
                        </tr>
                        </thead>
                        <tbody id="table-midinv_stock">
                        </tbody>
                    </table>
                    <div class="notice-pagination-box clearfix">
                        <span class="page-total">共查询到 <em id="_total_midinv_stock"></em> 条信息，共 <em
                                id="_pageNum_midinv_stock"></em> 页</span>
                        <div id="pagination_midinv_stock" class="pagination">
                        </div>
                    </div>
                </div>
            </div>
            <script id="table-template-midinv_stock" type="text/x-handlebars-template">
                {{#each data}}
                <tr data-id="{{id}}">
                    <td>{{xh @index}}</td>
                    <td>{{doInvType this}}</td>
                    <td>{{inv}}</td>
                    <td>{{doType this}}</td>
                    <td>{{doNO this}}</td>
                </tr>
                {{/each}}
            </script>
        </c:if>
        <!-- 个人独资企业投资人信息 -->
        <c:if test="${fn:indexOf('31', entBasicInfo.entTypeCatg)!=-1}">
            <div class="mod company-about">
                <div class="mod-bd-panel_company">
                    <h3 class="i-title">
                        <i></i>投资人信息
                    </h3>
                    <table class="table-common mb20">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>姓名</th>
                            <th>出资方式</th>
                        </tr>
                        </thead>
                        <tbody id="table-midinv_stock">
                        </tbody>
                    </table>
                    <div class="notice-pagination-box clearfix">
                        <span class="page-total">共查询到 <em id="_total_midinv_stock"></em> 条信息，共 <em
                                id="_pageNum_midinv_stock"></em> 页</span>
                        <div id="pagination_midinv_stock" class="pagination">
                        </div>
                    </div>
                </div>
            </div>
            <script id="table-template-midinv_stock" type="text/x-handlebars-template">
                {{#each data}}
                <tr data-id="{{id}}">
                    <td>{{xh @index}}</td>
                    <td>{{inv}}</td>
                    <td>{{sConForm}}</td>
                </tr>
                {{/each}}
            </script>
        </c:if>

        <!-- 合伙企业，外商投资合伙企业 -->
        <c:if test="${fn:indexOf('33,27', entBasicInfo.entTypeCatg)!=-1}">
            <div class="mod company-about">
                <div class="mod-bd-panel_company">
                    <h3 class="i-title">
                        <i></i>合伙人信息
                    </h3>
                    <table class="table-common mb20">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>合伙人</th>
                            <th>合伙人类型</th>
                            <th>证照/证件类型</th>
                            <th>证照/证件号码</th>
                        </tr>
                        </thead>
                        <tbody id="table-midinv_stock">
                        </tbody>
                    </table>
                    <div class="notice-pagination-box clearfix">
                        <span class="page-total">共查询到 <em id="_total_midinv_stock"></em> 条信息，共 <em
                                id="_pageNum_midinv_stock"></em> 页</span>
                        <div id="pagination_midinv_stock" class="pagination">
                        </div>
                    </div>
                </div>
            </div>
            <script id="table-template-midinv_stock" type="text/x-handlebars-template">
                {{#each data}}
                <tr data-id="{{id}}">
                    <td>{{xh @index}}</td>
                    <td>{{inv}}</td>
                    <td>{{doInvType this}}</td>
                    <td>{{doType this}}</td>
                    <td>{{doNO this}}</td>
                </tr>
                {{/each}}
            </script>
        </c:if>

        <!-- 公司，外商投资企业股东信息 -->
        <c:if test="${fn:indexOf('11,21', entBasicInfo.entTypeCatg)!=-1}">
            <div class="mod-bd-panel_company">
                <h3 class="i-title">
                    <i></i>股东及出资信息
                    <span class="light ml50 font-14">股东及出资信息截止2014年2月28日。2014年2月28日之后工商只公示股东姓名，其他出资信息由企业自行公示。</span>
                </h3>
                <table class="table-common mb20">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>股东类型</th>
                        <th>股东</th>
                        <th>证照/证件类型</th>
                        <th>证照/证件号码</th>
                        <th>详情</th>
                    </tr>
                    </thead>
                    <tbody id="table-midinv_stock">
                    </tbody>
                </table>
                <div class="notice-pagination-box clearfix">
                    <span class="page-total">共查询到 <em id="_total_midinv_stock"></em> 条信息，共 <em
                            id="_pageNum_midinv_stock"></em> 页</span>
                    <div id="pagination_midinv_stock" class="pagination">
                    </div>
                </div>
            </div>
            <script id="table-template-midinv_stock" type="text/x-handlebars-template">
                {{#each data}}
                <tr data-id="{{id}}">
                    <td>{{xh @index}}</td>
                    <td>{{doInvType this}}</td>
                    <td>{{inv}}</td>
                    <td>{{doType this}}</td>
                    <td>{{doNO this}}</td>
                    <td><a href="javascript:void(0);" class="js-gudong-view">查看</a></td>
                </tr>
                {{/each}}
            </script>
        </c:if>

        <!-- 公司，外商投资企业主要人员信息 -->
        <c:if test="${fn:indexOf('11,21', entBasicInfo.entTypeCatg)!=-1}">
            <div class="mod-bd-panel_company">
                <h3 class="i-title">
                    <i></i>主要人员信息
                    <a href="javascript:void(0)" class="more" id="mainmember"> <
                        <查看更多>>
                    </a>
                    <span class="number" id="member">共计X条信息</span>
                </h3>
                <div class="renyuan-list member clearfix">
                </div>
            </div>
        </c:if>

        <!-- 个体户参加经营的家庭成员姓名 -->
        <c:if test="${fn:indexOf('50', entBasicInfo.entTypeCatg)!=-1}">
            <div class="mod-bd-panel_company">
                <h3 class="i-title">
                    <i></i>参加经营的家庭成员姓名
                    <span class="number" id="member">共计X条信息</span>
                </h3>
                <div class="renyuan-list member clearfix">
                </div>
            </div>
        </c:if>

        <!-- 农民专业合作社成员名册信息 -->
        <c:if test="${fn:indexOf('16', entBasicInfo.entTypeCatg)!=-1}">
            <div class="mod-bd-panel_company">
                <h3 class="i-title">
                    <i></i>成员名册
                    <span class="number" id="memberinv">共计X条信息</span>
                </h3>
                <div class="renyuan-list memberinv clearfix">
                </div>
            </div>
        </c:if>
	<!-- 公司,合伙企业,个人独资企业,外商投资企业,外商投资合伙企业分支机构信息 -->
        <c:if test="${fn:indexOf('11,33,31,21,27', entBasicInfo.entTypeCatg)!=-1}">
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>分支机构信息
            </h3>
            <table class="table-common mb20">
                <thead>
                <tr>
                    <th width="52">序号</th>
                    <th width="150">分支机构主体身份代码</th>
                    <th width="200">分支机构名称</th>
                    <th width="150">注册号</th>
                    <th>登记机关</th>
                </tr>
                </thead>
                <tbody id="table-midbranch">
                </tbody>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="_total_midbranch"></em> 条信息，共 <em id="_pageNum_midbranch"></em> 页</span>
                <div id="pagination_midbranch" class="pagination">
                </div>
            </div>
        </div>
        <script id="table-template-midbranch" type="text/x-handlebars-template">
            {{#each data}}
            <tr>
                <td>{{xh @index}}</td>
                <td>{{brid}}</td>
				<td>{{entName}}</td>
                <td>{{regNO}}</td>
                <td>{{regOrgName}}</td>
            </tr>
            {{/each}}
        </script>
        </c:if>

        <!-- 变更信息 -->
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>变更信息
            </h3>
            <table class="table-common mb20">
                <thead>
                <tr>
                    <th width="40">序号</th>
                    <th width="70">变更事项</th>
                    <th width="140">变更前内容</th>
                    <th width="140">变更后内容</th>
                    <th width="100">变更日期</th>
                </tr>
                </thead>
                <tbody id="table-midaltitem">
                </tbody>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="_total_midaltitem"></em> 条信息，共 <em id="_pageNum_midaltitem"></em> 页</span>
                <div id="pagination_midaltitem" class="pagination">
                </div>
            </div>
        </div>
        <script id="table-template-midaltitem" type="text/x-handlebars-template">
            {{#each data}}
            <tr data-id="{{id}}">
                <td>{{xh @index}}</td>
                <td>{{altContent}}</td>
                <td><span title="{{altBeContent}}">{{subAltBeContent altBeContent}}</span></td>
                <td><span title="{{altAfContent}}">{{subAltAfContent altAfContent}}</span></td>
                <td>{{transAltDate altDate}}</td>
            </tr>
            {{/each}}
        </script>
            <!-- 行政许可信息 -->
        <!-- 行政许可信息 -->
        <div class="mod-bd-panel_company">
            <h3 class="i-title"> <i></i>行政许可信息 </h3>
            <table class="table-common table-xuke mb20">
                <thead>
                <tr>
                    <th class="col-first"> 序号 </th>
                    <th class="col-second"> 许可文件编号 </th>
                    <th class="col-three"> 许可文件名称 </th>
                    <th class="col-four"> 有效期自 </th>
                    <th class="col-five"> 有效期至 </th>
                    <th class="col-six"> 许可机关 </th>
                    <th class="col-seven"> 许可内容 </th>
                </tr>
                </thead>
                <tbody id="_listData">

                </tbody>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="_total"></em> 条信息，共 <em id="_pageNum"></em> 页</span>
                <div id="pagination" class="pagination"></div>
            </div>
        </div>
     <script id="table-template" type="text/x-handlebars-template">
    {{#each data}}
    		<tr>
        		<td>{{num @index}}</td>
        		<td>{{licNO}}</td>
        		<td>{{licNameCN}}</td>
        		<td>{{licValFrom licValFrom}}</td>
        		<td>{{licValTo licValTo}}</td>
        		<td>{{licAnth}}</td>
        		<td>{{licScope}}</td>
    		</tr>
			<tr style="{{dataList pubOtherlicenceModList}}">
            	<td colspan="7" class="tip2">
                        <div class="fl">有变更情形：</div>
                        <div class="fl">
                            {{#with pubOtherlicenceModList}}
                            	{{#each this}}
                                <p>{{addOne @index}}、{{altDate altDate}}将{{altItem}}由{{altBe}}变更为{{altAf}}。</p>
                                {{/each}}
                        	{{/with}}
                        </div>
            	</td>
            </tr>
    {{/each}}
</script>
    </div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
<script>
    //参数的传递
    window._CONFIG = {
        repType: '${imReportType}',
        pageType: '${pageType}',
    }
</script>
<script src="../../../js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/depsyn/search/baseinfosyn_list.js"></script>
</body>
</html>