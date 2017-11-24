<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="hx" uri="/WEB-INF/tld/hx.tld" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>国家企业信用信息公示系统</title>
    <link rel="stylesheet" href="/css/pub.css">
</head>
<body class="enterprise-info-bg">
<!-- 头部 -->
<jsp:include page="../../common/enterprise.jsp"></jsp:include>
<jsp:include page="../../common/basicheader.jsp"></jsp:include>

<div class="mod detail-main">
    <input type="hidden" name="encryPriPID" id="encryPriPID" value="${entBasicInfo.encryPriPID }"/>
    <input type="hidden" name="estDate" id="estDate" value="${entBasicInfo.estDateLong }"/>
    <input type="hidden" id="invEnd" value="${invEnd}"/>
    
    <form id="params">
        <input type="hidden" name="priPID" id="priPID" value="${entBasicInfo.priPID }"/>
    </form>
    
    <form id="altitem_params">
        <input type="hidden" name="priPID" id="priPID" value="${entBasicInfo.priPID }"/>
        <input type="hidden" name="entTypeCatg" value="${entBasicInfo.entTypeCatg }"/>
    </form>
    
    <form id="mort_params">
        <input type="hidden" name="regNO" id="regNO" value="${entBasicInfo.regNO}"/>
        <input type="hidden" name="uniCode" id="uniCode" value="${entBasicInfo.UNICODE}"/>
    </form>
    <input type="hidden" name="entTypeCatg" id="entTypeCatg" value="${entBasicInfo.entTypeCatg }"/>
    <div class="tab-panel">
        <!-- 营业执照信息 -->
        <div class="mod-bd-panel_company mb36">
            <h3 class="i-title">
                <i></i>营业执照信息
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
                    <c:if test="${!empty entBasicInfo.basx }">
	                    <li class="item-width">
	                        <span class="title right qyzc-info"><em>• </em>多证合一：</span>
	                        <span>${entBasicInfo.basxCN }</span>
	                    </li>
                    </c:if>
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
	                    <span>${hx:publicStatus(entBasicInfo.regState)}</span>
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
                        <span>${entBasicInfo.regCap }万${entBasicInfo.currencyCn }</span>
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
                    <c:if test="${!empty entBasicInfo.basx }">
	                    <li class="item-width">
	                        <span class="title right qyzc-info"><em>• </em>多证合一：</span>
	                        <span>${entBasicInfo.basxCN }</span>
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
	                    <span>${hx:publicStatus(entBasicInfo.regState)}</span>
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
                    <c:if test="${!empty entBasicInfo.basx }">
	                    <li class="item-width">
	                        <span class="title right qyzc-info"><em>• </em>多证合一：</span>
	                        <span>${entBasicInfo.basxCN }</span>
	                    </li>
                    </c:if>
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
	                    <span>${hx:publicStatus(entBasicInfo.regState)}</span>
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
	                    <span>${hx:publicStatus(entBasicInfo.regState)}</span>
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
                    <c:if test="${!empty entBasicInfo.basx }">
	                    <li class="item-width">
	                        <span class="title right qyzc-info"><em>• </em>多证合一：</span>
	                        <span>${entBasicInfo.basxCN }</span>
	                    </li>
                    </c:if>
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
                            <span>
                            <c:choose>
                                <c:when test="${entBasicInfo.compForm=='1' }">
                                    个人经营
                                </c:when>
                                <c:when test="${entBasicInfo.compForm=='2' }">
                                    家庭经营
                                </c:when>
                                <c:otherwise>
                                </c:otherwise>
                            </c:choose>
                            
                            </span>
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
	                    <span>${hx:publicStatus(entBasicInfo.regState)}</span>
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
                    <c:if test="${!empty entBasicInfo.basx }">
	                    <li class="item-width">
	                        <span class="title right qyzc-info"><em>• </em>多证合一：</span>
	                        <span>${entBasicInfo.basxCN }</span>
	                    </li>
                    </c:if>
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
					<td>{{{isShow this}}}</td>
                </tr>
                {{/each}}
            </script>
        </c:if>

        <!-- 公司，外商投资企业主要人员信息 -->
        <c:if test="${fn:indexOf('11,21', entBasicInfo.entTypeCatg)!=-1}">
            <div class="mod-bd-panel_company">
                <h3 class="i-title">
                    <i></i>主要人员信息
                    <a href="javascript:void(0)" class="more" id="mainmember" style="display: none;"> <
                        <查看更多>>
                    </a>
                    <span class="number" id="member">共计0条信息</span>
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
                    <span class="number" id="member">共计0条信息</span>
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
                    <span class="number" id="memberinv">共计0条信息</span>
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
                    <a href="javascript:void(0)" class="more" id="entbranch" style="display: none;"> <
                        <查看更多>>
                    </a>
                    <span class="number" id="midbranch">共计0条信息</span>
                </h3>
                <div class="renyuan-list branch clearfix">
                </div>
            </div>
        </c:if>
        <!-- 公司,合伙企业,外商投资企业,外商投资合伙企业清算信息 -->
        <c:if test="${fn:indexOf('11,33,21,27', entBasicInfo.entTypeCatg)!=-1}">
            <div class="mod-bd-panel_company">
                <h3 class="i-title">
                    <i></i>清算信息
                </h3>
                <table class="table-common table-qingsuan mb20">
                    <thead>
                    <tr>
                        <th class="col-first" colspan="5">
                            清算信息
                        </th>
                    </tr>
                    </thead>
                    <tbody class="tbody-qingsuan">
                    <tr>
                        <td class="title"><strong>清算组负责人</strong></td>
                        <td id="ligPrincipal" colspan="4"></td>
                    </tr>
                    <tr id="liqMem">
                        <td class="col-first title ligmember" rowspan="2"><strong>清算组成员</strong></td>
                    </tr>
                    </tbody>
                </table>
            </div>
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

        <!-- 动产抵押登记信息 -->
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>动产抵押登记信息
            </h3>
            <table class="table-common mb20">
                <thead>
                <tr>
                    <th width="40">序号</th>
                    <th width="120">登记编号</th>
                    <th width="130">登记日期</th>
                    <th width="240">登记机关</th>
                    <th width="150">被担保债权数额</th>
                    <th width="55">状态</th>
                    <th>公示日期</th>
                    <th width="55">详情</th>
                </tr>
                </thead>
                <tbody id="_mort">
                </tbody>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="_mortItemCount"></em> 条信息，共 <em id="_mortPageCount"></em> 页</span>
                <div id="_mortPagination" class="pagination">
                </div>
            </div>
        </div>
        <script id="mort-table-template" type="text/x-handlebars-template">
            {{#each data}}
            <tr data-id="{{id}}">
                <td>{{xh @index}}</td>
                <td>{{filingNO}}</td>
                <td>{{checkDate checkDate}}</td>
                <td>{{departMentName}}</td>
                <td>{{mortGageAmount}} 万元</td>
                <td>{{cancelStatus cancelStatus}}</td>
                <td>{{checkDate checkDate}}</td>
                <td><a href="javascript:void(0);" class="js-mortdetail-view">查看</a></td>
            </tr>
            {{/each}}
        </script>

        <c:if test="${fn:indexOf('11,21', entBasicInfo.entTypeCatg)!=-1}">
            <!-- 股权出质登记信息 -->
            <div class="mod-bd-panel_company">
                <h3 class="i-title">
                    <i></i>股权出质登记信息
                </h3>
                <table class="table-common mb20">
                    <thead>
                    <tr>
                        <th width="35">序号</th>
                        <th width="80">登记编号</th>
                        <th width="80">出质人</th>
                        <th width="100">证照/证件号码</th>
                        <th width="100">出质股权数额</th>
                        <th width="100">质权人</th>
                        <th width="100">证照/证件号码</th>
                        <th width="110">股权出质设立登记日期</th>
                        <th width="40">状态</th>
                        <th width="110">公示日期</th>
                        <th width="">详情</th>
                    </tr>
                    </thead>
                    <tbody id="_pledge">
                    </tbody>
                </table>
                <div class="notice-pagination-box clearfix">
                    <span class="page-total">共查询到 <em id="_pledgeItemCount"></em> 条信息，共 <em id="_pledgePageCount"></em> 页</span>
                    <div id="_pledgePagination" class="pagination">
                    </div>
                </div>
            </div>
            <script id="pledge-table-template" type="text/x-handlebars-template">
                {{#each data}}
                <tr data-id="{{id}}">
                    <td>{{xh @index}}</td>
                    <td>{{orderNO}}</td>
                    <td>{{pledgor}}</td>
                    <td>{{pleBLicNO this}}</td>
                    <td>{{impAm impAm}}</td>
                    <td>{{impOrg}}</td>
                    <td>{{impBLicNO this}}</td>
                    <td>{{recDate recDate}}</td>
                    <td>{{status equSource}}</td>
                    <td>{{equPleDate equPleDate}}</td>
                    <td><a href="javascript:void(0);" class="js-pledgedetail-view">查看</a></td>
                </tr>
                {{/each}}
            </script>
        </c:if>
        <!-- 知识产权出质登记信息 -->
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>知识产权出质登记信息
            </h3>
            <table class="table-common mb20">
                <thead>
                <tr>
                    <th width="35">序号</th>
                    <th width="140">知识产权登记证号</th>
                    <th width="80">名称</th>
                    <th width="70">种类</th>
                    <th width="92">出质人名称</th>
                    <th width="92">质权人名称</th>
                    <th width="230">质权登记期限</th>
                    <th width="35">状态</th>
                    <th width="100">公示日期</th>
                    <th>详情</th>
                </tr>
                </thead>
                <tbody id="ippldgBase">
                </tbody>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="ippldgCountBase">0</em> 条信息，共 <em id="ippldgPageCountBase">0</em> 页</span>
                <div id="pageippldgBase" class="pagination">
                    <a href="javascript:void(0)" class="prev disabled">首页</a><a
                        href="javascript:void(0)" class="prev"><i class="icon-triangle-left"></i>上一页</a><a
                        href="javascript:void(0)">1</a><a href="javascript:void(0)" class="next">下一页<i
                        class="icon-triangle-right"></i></a><a href="javascript:void(0)"
                                                               class="prev disabled">末页</a>
                </div>
            </div>
        </div>

        <!-- 商标注册信息 -->
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>商标注册信息
                <a href="javascript:void(0)" class="more" id="mainbrand" style="display: none;"> <
                    <查看更多>>
                </a>
                <span class="number" id="midbrand">共计0条信息</span>
            </h3>
            <div class="renyuan-list brand clearfix">
            </div>
        </div>

        <!-- 抽查检查结果信息 -->
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>抽查检查结果信息
            </h3>
            <table class="table-common mb20">
                <thead>
                <tr>
                    <th width="50">序号</th>
                    <th width="290">检查实施机关</th>
                    <th>类型</th>
                    <th width="130">日期</th>
                    <th width="390">结果</th>
                </tr>
                </thead>
                <tbody id="table-pubscresult">
                </tbody>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="_total_pubscresult"></em> 条信息，共 <em
                        id="_pageNum_pubscresult"></em> 页</span>
                <div id="pagination_pubscresult" class="pagination">
                </div>
            </div>
        </div>
        <script id="table-template-pubscresult" type="text/x-handlebars-template">
            {{#each data}}
            <tr>
                <td>{{xh @index}}</td>
                <td>{{checkDeptName}}</td>
                <td>{{transScType scType}}</td>
                <td>{{transCheckDate checkDate}}</td>
                <td>{{transCN checkResult scType}}</td>
            </tr>
            {{/each}}
        </script>
        <c:if test="${fn:indexOf('11,21', entBasicInfo.entTypeCatg)!=-1}">
            <!-- 司法协助信息 -->
            <div class="mod-bd-panel_company">
                <h3 class="i-title">
                    <i></i>司法协助信息
                </h3>
                <table class="table-common mb20">
                    <thead>
                    <tr>
                        <th width="40">序号</th>
                        <th width="240">被执行人</th>
                        <th width="120">股权数额</th>
                        <th width="160">执行法院</th>
                        <th width="190">执行通知书文号</th>
                        <th width="130">类型 | 状态</th>
                        <th>详情</th>
                    </tr>
                    </thead>
                    <tbody id="_justice">
                    </tbody>
                </table>
                <div class="notice-pagination-box clearfix">
                    <span class="page-total">共查询到 <em id="_justiceItemCount"></em> 条信息，共 <em
                            id="_justicePageCount"></em> 页</span>
                    <div id="_justicePagination" class="pagination">
                    </div>
                </div>
                <script id="justice-table-template" type="text/x-handlebars-template">
                    {{#each data}}
                    <tr data-uid="{{uid}}">
                        <td>{{xh @index}}</td>
                        <td>{{inv}}</td>
                        <td>{{froAm}}{{froAuth}}</td>
                        <td>{{executionCourt}}</td>
                        <td>{{executeNo}}</td>
                        <td>{{justiceType this}}</td>
                        <td><a href="javascript:void(0);" class="js-justicedetail-view">查看</a></td>
                    </tr>
                    {{/each}}
                </script>
            </div>
        </c:if>
        <div class="explain-txt">以下信息由该企业提供，企业对其报送信息的真实性、合法性负责</div>

        <!-- 企业年报信息 -->
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>
                <c:choose>
                    <c:when test="${entBasicInfo.entTypeCatg==50 }">
                        个体年报信息
                    </c:when>
                    <c:when test="${entBasicInfo.entTypeCatg==16||entBasicInfo.entTypeCatg==17 }">
                        农专年报信息
                    </c:when>
                    <c:otherwise>
                        企业年报信息
                    </c:otherwise>
                </c:choose>
            </h3>
            <table class="table-common mb20">
                <thead>
                <tr>
                    <th width="130">序号</th>
                    <th width="250">报送年度</th>
                    <th width="250">公示日期</th>
                    <th>详情</th>
                </tr>
                </thead>
                <tbody id="table-yrinfo">
                </tbody>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="_total_yrinfo"></em> 条信息，共 <em id="_pageNum_yrinfo"></em> 页</span>
                <div id="pagination_yrinfo" class="pagination">
                </div>
            </div>
        </div>
        <script id="table-template-yrinfo" type="text/x-handlebars-template">
            {{#each data}}
            <tr data-id="{{year}}">
                <td>{{xh @index}}</td>
                <td>{{{year}}}</td>
                <td>{{{transAncheDate ancheDate}}}</td>
                <td>{{{transType reportType}}}</td>
            </tr>
            {{/each}}
        </script>

        <!-- 即时信息 Start -->
        <c:if test="${entBasicInfo.entTypeCatg!=16&&entBasicInfo.entTypeCatg!=17&&entBasicInfo.entTypeCatg!=50}">
            <c:if test="${fn:indexOf(imReportType,'investment') != -1}">
                <!-- 股东及出资信息 -->
                <div class="mod-bd-panel_company">
                    <h3 class="i-title">
                        <i></i>股东及出资信息
                        <a href="javascript:void(0)" id="showImvestupdate" class="more">查看修改记录&gt;&gt;</a>
                    </h3>
                    <table class="table-common table-gudong-imme table-nest mb20" cellspacing="0" cellpadding="0">
                        <thead>
                        <tr>
                            <th width="8%">股东</th>
                            <th width="8%">认缴额<br>(万${entBasicInfo.currencyCn})</th>
                            <th width="8%">实缴额<br>(万${entBasicInfo.currencyCn})</th>
                            <th valign="top" width="38%">
                                <table border="0" cellpadding="0" cellspacing="0" width="100%"
                                       class="inner-table-common">
                                    <tr>
                                        <td colspan="4">认缴明细</td>
                                    </tr>
                                    <tr>
                                        <td width="28%">认缴<br/>出资方式</td>
                                        <td width="22%">认缴出资额<br/>（万${entBasicInfo.currencyCn}）</td>
                                        <td width="32%">认缴<br/>出资日期</td>
                                        <td>公示日期</td>
                                    </tr>
                                </table>
                            </th>
                            <th valign="top">
                                <table border="0" cellpadding="0" cellspacing="0" width="100%"
                                       class="inner-table-common">
                                    <tr>
                                        <td colspan="4">实缴明细</td>
                                    </tr>
                                    <tr>
                                        <td width="28%">实缴出资方式</td>
                                        <td width="22%">实缴出资额<br/>（万${entBasicInfo.currencyCn}）</td>
                                        <td width="32%">实缴<br/>出资日期</td>
                                        <td>公示日期</td>
                                    </tr>
                                </table>
                            </th>
                        </tr>
                        </thead>
                        <tbody id="investment">
                        </tbody>
                    </table>
                    <div class="notice-pagination-box clearfix">
                        <span class="page-total">共查询到 <em id="investmentCount">0</em> 条信息，共 <em
                                id="investmentPageCount">0</em> 页</span>
                        <div id="pageinvestment" class="pagination">
                            <a href="javascript:void(0)" class="prev disabled">首页</a><a
                                href="javascript:void(0)" class="prev"><i class="icon-triangle-left"></i>上一页</a><a
                                href="javascript:void(0)">1</a><a href="javascript:void(0)" class="next">下一页<i
                                class="icon-triangle-right"></i></a><a href="javascript:void(0)"
                                                                       class="prev disabled">末页</a>
                        </div>
                    </div>
                    <script id="investment-template" type="text/x-handlebars-template">
                        {{#each data}}
                        <tr>
                            <td>{{inv}}</td>
                            <td>{{liSubConAm}}</td>
                            <td>{{liAcConAm}}</td>
                            <td valign="top">
                                <table border="0" cellpadding="0" cellspacing="0" width="100%" class="inner-table">
                                    <tbody> {{#with imInvprodetailList}} {{#each this}}
                                    <tr>
                                        <td width="28%">{{conFormCN}}</td>
                                        <td width="22%">{{subConAm}}</td>
                                        <td width="32%">{{transDate conDate}}</td>
                                        <td>{{transDate publicDate}}</td>
                                    </tr>
                                    {{/each}} {{/with}}
                                    </tbody>
                                </table>
                            </td>
                            <td valign="top">
                                <table border="0" cellpadding="0" cellspacing="0" width="100%" class="inner-table">
                                    <tbody> {{#with imInvactdetailList}} {{#each this}}
                                    <tr>
                                        <td width="28%">{{acConFormCn}}</td>
                                        <td width="22%">{{acConAm}}</td>
                                        <td width="32%">{{transDate conDate}}</td>
                                        <td>{{transDate publicDate}}</td>
                                    </tr>
                                    {{/each}} {{/with}}
                                    </tbody>
                                </table>
                            </td>

                        </tr>
                        {{/each}}
                    </script>
                </div>
            </c:if>
            <c:if test="${fn:indexOf(imReportType,'invsralt') != -1}">
                <!-- 股权变更信息 -->
                <div class="mod-bd-panel_company">
                    <h3 class="i-title">
                        <i></i>股权变更信息
                    </h3>
                    <table class="table-common mb20">
                        <thead>
                        <tr>
                            <th width="80">序号</th>
                            <th width="200">股东</th>
                            <th width="200">变更前股权比例</th>
                            <th width="170">变更后股权比例</th>
                            <th width="150">股权变更日期</th>
                            <th>公示日期</th>
                        </tr>
                        </thead>
                        <tbody id="invsral">
                        </tbody>
                    </table>
                    <div class="notice-pagination-box clearfix">
                        <span class="page-total">共查询到 <em id="invsralCount">0</em> 条信息，共 <em
                                id="invsralPageCount">0</em> 页</span>
                        <div id="paginvsral" class="pagination">
                            <a href="javascript:void(0)" class="prev disabled">首页</a><a
                                href="javascript:void(0)" class="prev"><i class="icon-triangle-left"></i>上一页</a><a
                                href="javascript:void(0)">1</a><a href="javascript:void(0)" class="next">下一页<i
                                class="icon-triangle-right"></i></a><a href="javascript:void(0)"
                                                                       class="prev disabled">末页</a>
                        </div>
                    </div>
                    <script id="invsral-template" type="text/x-handlebars-template">
                        {{#each data}}
                        <tr>
                            <td>{{addOne @index}}</td>
                            <td> {{inv}}</td>
                            <td> {{beTransAmPr}}%</td>
                            <td> {{afTransAmPr}}%</td>
                            <td> {{transDate equAltDate}}</td>
                            <td> {{dataFormat publicDate}}</td>
                        </tr>
                        {{/each}}
                    </script>
                </div>
            </c:if>
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
                    <span class="page-total">共查询到 <em id="permitCount">0</em>  条信息，共 <em
                            id="permitPageCount">0</em> 页</span>
                    <div id="pagepermit" class="pagination">
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
            <!-- 知识产权出质登记信息 -->
            <div class="mod-bd-panel_company">
                <h3 class="i-title">
                    <i></i>知识产权出质登记信息
                </h3>
                <table class="table-common mb20">
                    <thead>
                    <tr>
                        <th width="35">序号</th>
                        <th width="140">知识产权登记证号</th>
                        <th width="80">名称</th>
                        <th width="70">种类</th>
                        <th width="92">出质人名称</th>
                        <th width="92">质权人名称</th>
                        <th width="230">质权登记期限</th>
                        <th width="35">状态</th>
                        <th width="100">公示日期</th>
                        <th>详情</th>
                    </tr>
                    </thead>
                    <tbody id="ippldg">
                    </tbody>
                </table>
                <div class="notice-pagination-box clearfix">
                    <span class="page-total">共查询到 <em id="ippldgCount">0</em> 条信息，共 <em
                            id="ippldgPageCount">0</em> 页</span>
                    <div id="pageippldg" class="pagination">
                        <a href="javascript:void(0)" class="prev disabled">首页</a><a
                            href="javascript:void(0)" class="prev"><i class="icon-triangle-left"></i>上一页</a><a
                            href="javascript:void(0)">1</a><a href="javascript:void(0)" class="next">下一页<i
                            class="icon-triangle-right"></i></a><a href="javascript:void(0)"
                                                                   class="prev disabled">末页</a>
                    </div>
                </div>
                <script id="ippldg-template" type="text/x-handlebars-template">
                    {{#each data}}
                    <tr>
                        <td>{{addOne @index}}</td>
                        <td>
                            {{tmregNo}}
                        </td>
                        <td>{{tmname}}</td>
                        <td>{{transkinds kinds}}</td>
                        <td> {{pledgor}}</td>
                        <td>{{impOrg}}</td>
                        <td>{{transDate pleRegPerFrom}}-{{transDate pleRegPerTo}}</td>
                        <td>{{transType pubType}}</td>
                        <td>{{dataFormat publicDate}}</td>
                        <td><a id={{pleID}} href="javascript:void(0)" class="showIppldg">查看</a></td>
                    </tr>
                    {{/each}}
                </script>
            </div>
            <!-- 行政处罚信息 -->
            <div class="mod-bd-panel_company">
                <h3 class="i-title">
                    <i></i>行政处罚信息
                </h3>
                <table class="table-common table-chufa mb20">
                    <thead>
                    <tr>
                        <th width="35">序号</th>
                        <th width="155">决定书文号</th>
                        <th width="155">违法行为类型</th>
                        <th width="130">行政处罚内容</th>
                        <th width="155">决定机关名称</th>
                        <th width="110">处罚决定日期</th>
                        <th width="110">公示日期</th>
                        <th>备注</th>
                    </tr>
                    </thead>
                    <tbody id="case">
                    </tbody>
                </table>
                <div class="notice-pagination-box clearfix">
                    <span class="page-total">共查询到 <em id="caseCount">0</em> 条信息，共 <em id="casePageCount">0</em> 页</span>
                    <div id="pagecase" class="pagination">
                        <a href="javascript:void(0)" class="prev disabled">首页</a><a
                            href="javascript:void(0)" class="prev"><i class="icon-triangle-left"></i>上一页</a><a
                            href="javascript:void(0)">1</a><a href="javascript:void(0)" class="next">下一页<i
                            class="icon-triangle-right"></i></a><a href="javascript:void(0)"
                                                                   class="prev disabled">末页</a>
                    </div>
                </div>
                <script id="case-template" type="text/x-handlebars-template">
                    {{#each data}}
                    <tr>
                        <td> {{addOne @index}}</td>
                        <td>{{penDecNo}}</td>
                        <td>{{illegActType}}</td>
                        <td>{{penContent}}</td>
                        <td>{{judAuth}}</td>
                        <td>{{transDate penDecIssDate}}</td>
                        <td>{{dataFormat publicDate}}</td>

                        <td rowspan="">{{transType pubType}}</td>
                    </tr>
                    <tr style="{{dataList caslatList}}">
                        <td colspan="8" class="tip2">
                            <div class="fl">有变更情形：</div>
                            <div class="fl">
                                {{#with caslatList}}
                                {{#each this}}
                                <p>{{addOne @index}}.{{dataFormat altDate}}{{penAuthName}}将{{penContent}}。</p>
                                {{/each}}
                                {{/with}}
                            </div>
                        </td>
                    </tr>

                    {{/each}}
                </script>
            </div>
        </c:if>
        <!-- 即时信息 End -->
        
	<!-- 简易注销公告信息 -->
	<c:if test="${flag=='1'}">
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>企业简易注销公告信息
            </h3>
            <div class="renyuan-list clearfix">
                <div class="item item3">
                    <p>${entBasicInfo.entName }简易注销公告信息</p>
                    <p>公告期：<fmt:formatDate value="${erEscAppinfo.noticeFrom}" pattern="yyyy年MM月dd日"/>-<fmt:formatDate value="${erEscAppinfo.noticeTo}" pattern="yyyy年MM月dd日"/></p>
                    <p><a href="../../../pub/simpleesc/erescobjinfo/objectionDetail?encryPriPID=${entBasicInfo.encryPriPID }" class="a-orange" target="_blank">&lt;&lt;查看详情&gt;&gt;</a></p>
                </div>
            </div>
        </div>
     </c:if>
    </div>
</div>

<script>
    //参数的传递
    window._CONFIG = {
        repType: '${imReportType}',

    }
</script>
<jsp:include page="../../common/footer.jsp"></jsp:include>
<script src="../../../../js/lib/jquery/jquery-1.12.3.min.js"></script>

<script type="text/javascript">
    var jiathis_config = {
        url: 'http://118.178.31.19/client/entsearch/toEntSearch?entName=' + '${hx:encodeYear(entBasicInfo.entName)}',
        title: "国家企业信用信息公示系统",
        summary: '',
        desc: '',
        data_track_clickback: false
    };
</script>
<script type="text/javascript" src="http://v3.jiathis.com/code/jia.js" charset="utf-8"></script>
<script type="text/javascript" src="http://v3.jiathis.com/code/plugin.client.js" charset="utf-8"></script>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/pub/entinfo/baseinfo_main.js"></script>
<script src="/js/pub/entinfo/other_main.js"></script>
<script src="/js/pub/entinfo/iminfo_main.js"></script>
<script type="text/javascript" src="http://fwtj.gsxt.gov.cn/js/logcollector.js?nodenum=330000"></script>
<script src="/js/pub/entinfo/sendPdf.js"></script>


<%--信息分享--%>
<script src="/js/pub/entinfo/information_share.js"></script>
<script>
    window.onload = function () {
        var sessionId = '<%=request.getSession().getId()%>';
        sessionId_gsxt = sessionId; // 正常情况JS可以拿到sessionId,但经过测试发现有些web服务器，js拿不到sessionId，这种情况需要手动对sessionId进行赋值，如sessionId_gsxt=${sessionId}
        try {
            t1Collect_gsxt(); // 收集访问信息，每个页面都需要调用该方法
            var entName = '${entBasicInfo.entName }';
            t2Collect_gsxt(entName); // 企业详情页收集被访问的企业名称，当用户进入企业详情页时，调用该方法，并将企业完整名称作为该方法的入参
        } catch (e) {

        }
    }

    $(document).on('click', '.js-gudong-view', function () {
        var id = $(this).closest('tr').attr('data-id');
        layer.open({
            type: 2,
            shadeClose: true,
            closeBtn: 0,
            area: ['580px', '550px'],
            title: false,
            content: '../../midinv/findMidInvById?midInvId=' + id+'&currencyCn=${entBasicInfo.currencyCn }'
        })
    });

    $(document).on('click', '.js-yrinfo', function () {
        var year = $(this).closest('tr').attr('data-id');
        var encryPriPID = '${entBasicInfo.encryPriPID }';
        var classFlag = '${classFlag}';
        window.open('../../entinfo/yrinfo?year=' + year + "&encryPriPID=" + encryPriPID + "&classFlag=" + classFlag, 'newwindow');
    });

    $(function () {
        var ele = $('.explain-txt'), st, oldtop;
        var top; //存储原来的距离顶部的距离
        var flag = false;
        $('html,body').animate({scrollTop: '0'}, 10, function () {
            $(window).scroll(function () {
                top = ele.offset().top;
                st = Math.max(document.body.scrollTop || document.documentElement.scrollTop);
                if (st >= parseInt(top)) {
                    if (!flag) {
                        oldtop = top;
                        flag = true;
                    }
                    ele.css({'position': 'fixed', top: 0});
                }
                if (st < oldtop) {
                    ele.css({'position': 'static', 'top': 'auto'})
                }
                ;
            });
        });
    });
</script>
</body>
</html>