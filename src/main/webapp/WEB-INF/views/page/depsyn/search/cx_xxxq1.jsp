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
                    <li><a class="tab-item" href="../../depsyn/search/baseinfosyn?encryPriPID=${entBasicInfo.encryPriPID }&classFlag=1">基本信息</a>
                    </li>
                    <li class="tab-selected"><a class="tab-item" href="../../depsyn/search/yrinfosyn?encryPriPID=${entBasicInfo.encryPriPID }&year=2015">企业年报信息</a>
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
                        <div class="title"><h3>2015年度报告</h3><a href="#nianbao">有0条修改记录</a></div>
                        <p>企业年报信息由该企业提供，企业对其年报信息的真实性、合法性负责</p>
                    </div>
                    <div class="time">填报时间：2016-05-24</div>
                </div>
                <h3 class="i-title">
                    <i></i>基本信息
                </h3>
                <ul class="encounter-info clearfix">
                    <li>
                        <em>• </em>
                        <span class="title">统一社会信用代码/注册号：</span>
	                        <span>330781000095736</span>
                    </li>
                    <li>
                        <em>• </em>
                        <span class="title">企业名称：</span>
                        <span>兰溪市诚溪医疗投资管理有限公司</span>
                    </li>
                    <li>
                        <em>• </em>
                        <span class="title ">企业联系电话：</span>
                        <span>15268633087</span>
                    </li>
                    <li>
                        <em>• </em>
                        <span class="title ">邮政编码：</span>
                        <span>321100</span>
                    </li>
                    <li class="item-width">
                        <em>• </em>
                        <span class="title ">企业通信地址：</span>
                        <span>浙江省金华市兰溪市兰江街道银岭路34号</span>
                    </li>
                    <li>
                        <em>• </em>
                        <span class="title ">企业电子邮箱：</span>
                        <span></span>
                    </li>
                    <li>
                        <em>• </em>
                        <span class="title ">从业人数：</span>
                        <span>企业选择不公示</span>
                    </li>
                    <li>
                        <em>• </em>
                        <span class="title ">企业经营状态：</span>
                        <span>开业</span>
                    </li>
                    <li>
                        <em>• </em>
                        <span class="title">报送时间：</span>
                        <span>2016-12-12</span>
                    </li>
                </ul>
            </div>
            <div class="mod-bd-panel_company no-borderlr">
                <h3 class="i-title">
                    <i></i>企业资产状况信息
                </h3>
                <table class="table-common mb20">
                    <thead>
                    <tr>
                        <th width="52">序号</th>
                        <th>资产总额</th>
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
                        <td>北京印染厂</td>
                        <td>非公司企业法人营业执照</td>
                        <td>1100005050504404</td>
                        <td>企业法人</td>
                        <td>企业法人</td>
                        <td>企业法人</td>
                        <td>企业法人</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="mod-bd-panel_company no-borderlr">
                <h3 class="i-title">
                    <i></i>股东出资信息
                </h3>
                <table class="table-common mb20">
                    <thead>
                    <tr>
                        <th width="52">序号</th>
                        <th>股东/发起人名称</th>
                        <th width="100">累计认缴额</th>
                        <th width="100">认缴出资日期</th>
                        <th width="100">认缴出资方式</th>
                        <th width="100">累计实缴额</th>
                        <th width="100">实缴出资日期</th>
                        <th width="100">实缴出资方式</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>北京印染厂</td>
                        <td>非公司企业法人营业执照</td>
                        <td>1100005050504404</td>
                        <td>企业法人</td>
                        <td>企业法人</td>
                        <td>企业法人</td>
                        <td>企业法人</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="mod-bd-panel_company no-borderlr">
                <h3 class="i-title">
                    <i></i>对外提供担保信息
                </h3>
                <table class="table-common mb20">
                    <thead>
                    <tr>
                        <th width="52">序号</th>
                        <th>债权人</th>
                        <th width="100">债务人</th>
                        <th width="100">主债权种类</th>
                        <th width="100">主债权数额</th>
                        <th width="100">履行债务的期限日</th>
                        <th width="100">履行债务的期限日</th>
                        <th width="100">保证的期间</th>
                        <th width="100">保证的期间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>北京印染厂</td>
                        <td>非公司企业法人营业执照</td>
                        <td>1100005050504404</td>
                        <td>企业法人</td>
                        <td>企业法人</td>
                        <td>企业法人</td>
                        <td>企业法人</td>
                        <td>企业法人</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="mod-bd-panel_company no-borderlr">
                <h3 class="i-title">
                    <i></i>对外投资信息
                </h3>
                <div class="renyuan-list renyuan-list2 member clearfix">
                     <div class="item"><span>责任有限公司</span><span class="manager">•统一社会信用代码：1454114</span></div><div class="item"><span>责任有限公司</span><span class="manager">•统一社会信用代码：1454114</span></div></div>
            </div>
            <div class="mod-bd-panel_company no-borderlr">
                <h3 class="i-title">
                    <i></i>外提供担保信息
                </h3>
                <table class="table-common mb20">
                    <thead>
                    <tr>
                        <th width="52">序号</th>
                        <th>债权人</th>
                        <th width="100">债务人</th>
                        <th width="100">主债权种类</th>
                        <th width="100">主债权数额</th>
                        <th width="100">履行债务的期限自</th>
                        <th width="100">履行债务的期限至</th>
                        <th width="100">保证的期间</th>
                        <th width="100">保证的方式</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>北京印染厂</td>
                        <td>非公司企业法人营业执照</td>
                        <td>1100005050504404</td>
                        <td>企业法人</td>
                        <td>企业法人</td>
                        <td>企业法人</td>
                        <td>企业法人</td>
                        <td>企业法人</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="mod-bd-panel_company no-borderlr">
                <h3 class="i-title">
                    <i></i>网站或网店信息
                </h3>
                <div class="renyuan-list renyuan-list2 member clearfix">
                    <div class="item"><span>责任有限公司</span><span class="manager">类型：网站</span><span class="manager">网址：</span></div>
                    <div class="item"><span>责任有限公司</span><span class="manager">类型：网站</span><span class="manager">网址：</span></div>
                    </div>
                </div>
            </div>
            <div class="mod-bd-panel_company no-borderlr">
                <h3 class="i-title">
                    <i></i>股权变更信息
                </h3>
                <table class="table-common mb20">
                    <thead>
                    <tr>
                        <th width="52">序号</th>
                        <th>股东名称</th>
                        <th width="180">转让前股权比例</th>
                        <th width="150">转让后股权比例</th>
                        <th width="120">股权变更日期</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>北京印染厂</td>
                        <td>非公司企业法人营业执照</td>
                        <td>1100005050504404</td>
                        <td>企业法人</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="mod-bd-panel_company no-borderlr">
                <h3 class="i-title">
                    <i></i>修改记录
                </h3>
                <table class="table-common mb20">
                    <thead>
                    <tr>
                        <th width="52">序号</th>
                        <th>修改事项</th>
                        <th width="180">修改前</th>
                        <th width="150">修改后</th>
                        <th width="120">修改日期</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>北京印染厂</td>
                        <td>非公司企业法人营业执照</td>
                        <td>1100005050504404</td>
                        <td>企业法人</td>
                    </tr>
                    </tbody>
                </table>
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
</body>
</html>