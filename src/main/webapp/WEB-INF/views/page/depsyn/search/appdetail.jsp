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
<div class="header mod">
    <img src="/img/pub-syn/top-img.png" alt="">
    <div class="header-tips">
        <div class="fl">
            <span><i class="icon icon1"></i>2016年12月20日</span>
            <span><i class="icon icon2"></i>您好！北京市环保局 李军</span>
        </div>
        <div class="fr">
            <a href=""><i class="icon icon3"></i>修改密码</a>
            <a href=""><i class="icon icon4"></i>用户退出</a>
        </div>
    </div>
</div>
<div class="mod clearfix">
    <div class="sidebar">
        <ul class="navbar">
            <li><a href="javascript:void(0)" class="info selected">信息提供</a>
                <ul class="subnavbar">
                    <li><a href="javascript:void(0)" class="selected">在线录入</a></li>
                    <li><a href="javascript:void(0)">批量导入</a></li>
                    <li><a href="javascript:void(0)">数据接口</a></li>
                    <li><a href="javascript:void(0)">数据交换</a></li>
                </ul>
            </li>
            <li><a href="javascript:void(0)" class="info">信息接收</a>
                <ul class="subnavbar">
                    <li><a href="javascript:void(0)">双告知</a></li>
                    <li><a href="javascript:void(0)">严重违法失信<br/>企业名单</a></li>
                    <li><a href="javascript:void(0)">经营异常名录</a></li>
                    <li><a href="javascript:void(0)">联合惩戒信息</a></li>
                </ul>
            </li>
            <li><a href="javascript:void(0)" class="info">信息管理</a>
                <ul class="subnavbar">
                    <li><a href="javascript:void(0)">本部门问题数据处理</a></li>
                    <li><a href="javascript:void(0)">本部门归集或接收<br/>信息的查询统计</a></li>
                    <li><a href="javascript:void(0)">数据应用反馈</a></li>
                    <li><a href="javascript:void(0)">批量比对</a></li>
                </ul>
            </li>
            <li><a href="javascript:void(0)" class="info">信息查询</a>
                <ul class="subnavbar">
                    <li><a href="javascript:void(0)">企业高级查询</a></li>
                    <li><a href="javascript:void(0)">查询接口</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <div class="main">
    <input type="hidden" name="encryPriPID" id="encryPriPID" value="${entBasicInfo.encryPriPID }"/>
    <form id="params">
        <input type="hidden" name="priPID" id="priPID" value="${entBasicInfo.priPID }"/>

    </form>
    <form id="mort_params">
        <input type="hidden" name="regNO" id="regNO" value="${entBasicInfo.regNO}"/>
        <input type="hidden" name="uniCode" id="uniCode" value="${entBasicInfo.UNICODE}"/>
    </form>
    <input type="hidden" name="entTypeCatg" id="entTypeCatg" value="${entBasicInfo.entTypeCatg }"/>
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
                                                                法定代表人:<span>${entBasicInfo.leRep }</span>
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
                    <li class="tab-selected"><a class="tab-item" href="../../depsyn/search/baseinfo?encryPriPID=279913F3FBF463ABF21A4B194A00E128CB53B966BB008522E33737F44C63B4E7&classFlag=1">基本信息</a>
                    </li>
                    <li><a class="tab-item" href="../../entinfo/licenseinfo?encryPriPID=279913F3FBF463ABF21A4B194A00E128CB53B966BB008522E33737F44C63B4E7&amp;classFlag=1">企业年报信息</a>
                    </li>
                    <li><a class="tab-item" href="../../entinfo/punishinfo?encryPriPID=279913F3FBF463ABF21A4B194A00E128CB53B966BB008522E33737F44C63B4E7&amp;classFlag=1">企业即时信息</a>
                    </li>
                    <li><a class="tab-item" href="../../entinfo/anomalyinfo?encryPriPID=279913F3FBF463ABF21A4B194A00E128CB53B966BB008522E33737F44C63B4E7&amp;classFlag=1">处罚信息</a>
                    </li>
                    <li><a class="tab-item" href="../../entinfo/illegalinfo?encryPriPID=279913F3FBF463ABF21A4B194A00E128CB53B966BB008522E33737F44C63B4E7&amp;classFlag=1">其他信息</a>
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
            <!-- 公司，外商投资企业主要人员信息 -->
	       <%--  <c:if test="${fn:indexOf('11,21', entBasicInfo.entTypeCatg)!=-1}"> --%>
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
	       <%--  </c:if> --%>
            <!-- 公司，外商投资企业股东信息 -->
        <%-- <c:if test="${fn:indexOf('11,21', entBasicInfo.entTypeCatg)!=-1}"> --%>
            <div class="mod-bd-panel_company">
                <h3 class="i-title">
                    <i></i>股东及出资信息
                    <span class="light ml50 font-14">股东及出资信息截止2014年2月28日。2014年2月28日之后工商只公示股东姓名，其他出资信息由企业自行公示。</span>
                </h3>
                <table class="table-common mb20">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>股东名字</th>
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
                    <td>{{inv}}</td>
                    <td>{{doType this}}</td>
                    <td>{{doNO this}}</td>
                    <td><a href="javascript:void(0);" class="js-gudong-view">查看</a></td>
                </tr>
                {{/each}}
            </script>
        <%-- </c:if> --%>
            <div class="mod-bd-panel_company no-borderlr">
                <h3 class="i-title">
                    <i></i>分支机构信息
                </h3>
                <table class="table-common mb20">
                    <thead>
                    <tr>
                        <th width="52">序号</th>
                        <th width="150">分支机构主体身份代码</th>
                        <th width="150">分支机构名称</th>
                        <th width="150">注册号</th>
                        <th width="100">统一社会信用代码</th>
                        <th>登记机关</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tbody id="table-midbranch_stock">
                    </tbody>
                </table>
                <div class="notice-pagination-box clearfix">
                    <span class="page-total">共查询到 <em id="_total_midbranch_stock"></em> 条信息，共 <em
                            id="_pageNum_midbranch_stock"></em> 页</span>
                    <div id="pagination_midbranch_stock" class="pagination">
                    </div>
                </div>
            </div>
             <script id="table-template-midbranch_stock" type="text/x-handlebars-template">
                {{#each data}}
                <tr data-id="{{id}}">
                    <td>{{xh @index}}</td>
                    <td>{{BRID}}</td>
                    <td>{{entName}}</td>
                    <td>{{regNO}}</td>
					<td>{{regNO}}</td>
					<td>{{regOrgName}}</td>
                </tr>
                {{/each}}
            </script>
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
                <td><a style="color:#666" href="javascript:void(0)" title="{{altBeContent}}">{{subAltBeContent
                    altBeContent}}</a></td>
                <td><a style="color:#666" href="javascript:void(0)" title="{{altAfContent}}">{{subAltAfContent
                    altAfContent}}</a></td>
                <td>{{transAltDate altDate}}</td>
            </tr>
            {{/each}}
        </script>
            <!-- 行政许可信息 -->
        <div class="mod-bd-panel_company">
        <h3 class="i-title">
        <i></i>行政许可信息
        </h3>
        <table class="table-common table-xuke mb20">
        <thead>
        <tr>
        <th width="40">序号</th>
        <th width="130">许可文件编号</th>
        <th width="120">许可文件名称</th>
        <th width="110">有效期自</th>
        <th width="110">有效期至</th>
        <th width="170">许可机关</th>
        <th width="140">许可内容</th>
        <th width="50">状态</th>
        <th>详情</th>
        </tr>
        </thead>
        <tbody id="permit">
        </tbody>
        </table>
        <div class="notice-pagination-box clearfix">
        <span class="page-total">共查询到 <em id="permitCount">0</em>  条信息，共 <em id="permitPageCount">0</em> 页</span>
        <div  id="pagepermit"  class="pagination">
        <a href="javascript:void(0)" class="prev disabled">首页</a><a
        href="javascript:void(0)" class="prev"><i class="icon-triangle-left"></i>上一页</a><a
        href="javascript:void(0)">1</a><a href="javascript:void(0)" class="next">下一页<i
        class="icon-triangle-right"></i></a><a href="javascript:void(0)"
        class="prev disabled">末页</a>

        </div>
        </div>
        <script id="permit-template" type="text/x-handlebars-template">
        {{#each data}}
        <tr>
        <td> {{addOne @index}}</td>
        <td> {{licNO}}</td>
        <td>{{licNameCN}}</td>
        <td>{{transDate valFrom}}</td>
        <td> {{transDate valTo}}</td>
        <td>{{licAnth}}</td>
        <td>{{licItem}}</td>
        <td>{{transPubType pubType}}</td>
        <td><a href="javascript:void(0)" id="{{licID}}" class="showPermit">查看</a></td>
        </tr>
        {{/each}}
        </script>
        </div>
        </div>
    </div>
</div>
<div class="mod">
    <div class="footer-box">
        <div class="footer">
            <p>版权所有：浙江省工商行政管理局</p>
			<p>年报公示业务咨询电话：400-888-4636（年报）&nbsp;&nbsp;&nbsp;&nbsp;技术支持电话：400-888-4636（公示）&nbsp;&nbsp;&nbsp;&nbsp;京ICP备16053442号-1</p>        </div>
    </div>
</div>
<script src="../../../../js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/depsyn/search/appdetail.js"></script>
</body>
</html>