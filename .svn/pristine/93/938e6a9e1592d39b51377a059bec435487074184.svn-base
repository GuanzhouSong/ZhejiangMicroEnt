<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="hx" uri="/WEB-INF/tld/hx.tld"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>信息打印</title>
    <link rel="stylesheet" href="/css/pub.css">

</head>
<body class="enterprise-info-bg" >
<input type="hidden" name="encryPriPID" id="encryPriPID" value="${entBasicInfo.encryPriPID }"/>
<form id="params">
    <input type="hidden" name="priPID" id="priPID" value="${entBasicInfo.priPID }"/>
    <input type="hidden"  value="print" id="print">
</form>
<form id="mort_params">
    <input type="hidden" name="regNO" id="regNO" value="${entBasicInfo.regNO}"/>
    <input type="hidden" name="uniCode" id="uniCode" value="${entBasicInfo.UNICODE}"/>
</form>

<form id="altitem_params">
        <input type="hidden" name="priPID" id="priPID" value="${entBasicInfo.priPID }"/>
        <input type="hidden" name="entTypeCatg" value="${entBasicInfo.entTypeCatg }"/>
    </form>
<input type="hidden" name="entTypeCatg" id="entTypeCatg" value="${entBasicInfo.entTypeCatg }"/>


<div class="mod-1330">
    <div id="printbtn"  class="print-icon" >
        打印
    </div>
    <div id="printcon"  class="mod-1078 info-print">
        <div class="mod-1078" style="background-image: url(../../../../img/shuiyin.png);">
            <div class="logo"></div>
            <div class="title-name">企业信用信息公示报告</div>
            <div class="about">
                <p><label>企业名称</label>${entBasicInfo.entName }</p>
                <p><label>报告生成时间</label>${now}</p>
            </div>

            <div class="tips"style="padding-bottom:50px">（报告内容仅供参考，具体内容请以国家企业信用信息公示系统查询页面为准）</div>
            <div class="mod-1080">
                <h2>政府部门公示信息</h2>
                <div class="mod-bd-panel_company no-borderlr border-b-gray pb50">
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
                                <span>${entBasicInfo.regCap }万${entBasicInfo.currencyCn}</span>
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
                                <tr><td  colspan="5"><div class="no-con">暂无主管部门（出资人）信息 </div></td></tr>
                                </tbody>
                            </table>

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
                                <tr><td  colspan="3"><div class="no-con">暂无投资人信息 </div></td></tr>

                                </tbody>
                            </table>

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
                                <tr><td  colspan="5"><div class="no-con">暂无合伙人信息 </div></td></tr>

                                </tbody>
                            </table>

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
                        </h3>
                        <table class="table-common mb20">
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>股东类型</th>
                                <th>股东</th>
                                <th>证照/证件类型</th>
                                <th>证照/证件号码</th>
                            </tr>
                            </thead>
                            <tbody id="table-midinv_stock">
                            <tr><td  colspan="5"><div class="no-con">暂无股东及出资信息 </div></td></tr>

                            </tbody>
                        </table>

                    </div>
                    <script id="table-template-midinv_stock" type="text/x-handlebars-template">
                        {{#each data}}
                        <tr data-id="{{id}}">
                            <td>{{xh @index}}</td>
                            <td>{{doInvType this}}</td>
                            <td>{{inv_tans this}}</td>
                            <td>{{doType this}}</td>
                            <td>{{doNO this}}</td>
                        </tr>
                        {{/each}}
                    </script>
                </c:if>
                <%--主要人员信息--%>
                <!-- 公司，外商投资企业主要人员信息 -->
                <c:if test="${fn:indexOf('11,21', entBasicInfo.entTypeCatg)!=-1}">
                    <div class="mod-bd-panel_company">
                        <h3 class="i-title">
                            <i></i>主要人员信息

                            <span class="number" id="member"></span>
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
                            <span class="number" id="member"></span>
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
                            <span class="number" id="memberinv"></span>
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

                            <span class="number" id="midbranch"></span>
                        </h3>
                        <div class="renyuan-list branch clearfix">
                        </div>
                    </div>
                </c:if>
                <!-- 商标注册信息 -->
                <%-- <div class="mod-bd-panel_company">
                     <h3 class="i-title">
                         <i></i>商标注册信息
                         <span class="number" id="midbrand"></span>
                     </h3>
                     <div class="renyuan-list brand clearfix">
                     </div>
                 </div>--%>
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
                        <tr><td  colspan="5"><div class="no-con">暂无变更信息 </div></td></tr>
                        </tbody>
                    </table>

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
                                <td class="title right qyzc-info">清算组负责人</td>
                                <td id="ligPrincipal" colspan="4"></td>
                            </tr>
                            <tr id="liqMem">
                                <td class="col-first title ligmember" rowspan="2">清算组成员</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </c:if>

                <!-- 行政许可 -->
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
                        <tbody id="licenseinfo_listData">
                        <tr><td  colspan="7"><div class="no-con">暂无行政许可信息 </div></td></tr>

                        </tbody>
                    </table>
                </div>
                <script id="table-template-licenseinfo" type="text/x-handlebars-template">
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

                <!-- 行政处罚 -->
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
                        </tr>
                        </thead>
                        <tbody id="punish_listData">
                        <tr><td  colspan="7"><div class="no-con">暂无行政处罚信息 </div></td></tr>

                        </tbody>
                    </table>

                </div>
                <script id="punish-table-template" type="text/x-handlebars-template">
                    {{#each data}}
                    <tr>
                        <td>{{xh @index}}</td>
                        <td>{{penDecNo}}</td>
                        <td>{{illegActType}}</td>
                        <td>{{penContent}}</td>
                        <td>{{judAuth}}</td>
                        <td>{{penDecIssDate penDecIssDate}}</td>
                        <td>{{auditDate auditDate}}</td>
                    </tr>
                    <tr style="{{dataList pubOtherPunishAlterList}}">
                        <td colspan="8" class="tip2">
                            <div class="fl">有变更情形：</div>
                            <div class="fl">
                                {{#with pubOtherPunishAlterList}}
                                {{#each this}}
                                <p>{{addOne @index}}、{{judAuth}}{{altDate altDate}}{{contents}}。</p>
                                {{/each}}
                                {{/with}}
                            </div>
                        </td>
                    </tr>
                    {{/each}}
                </script>
                <!-- 经营异常 -->
                <!-- 企业、农专经营异常信息 -->
                <c:if test="${entBasicInfo.entTypeCatg != '50'}">
                    <div class="mod-bd-panel_company">
                        <h3 class="i-title">
                            <i></i>经营异常信息
                        </h3>
                        <table class="table-common table-chufa">
                            <thead>
                            <tr>
                                <th width="35">序号</th>
                                <th width="220">纳入经营异常名录原因</th>
                                <th width="105">列入日期</th>
                                <th width="140">作出决定机关（列入）</th>
                                <th width="250">移出经营异常名录原因</th>
                                <th width="105">移出日期</th>
                                <th>作出决定机关（移出）</th>
                            </tr>
                            </thead>
                            <tbody id="pbopanomaly_listData">
                            <tr><td  colspan="7"><div class="no-con">暂无列入经营异常名录信息 </div></td></tr>

                            </tbody>
                        </table>

                    </div>
                    <script id="pbopanomaly-table-template" type="text/x-handlebars-template">
                        {{#each data}}
                        <tr>
                            <td>{{xh @index}}</td>
                            <td>{{speCauseCN}}</td>
                            <td>{{abnTime abnTime}}</td>
                            <td>{{decorgCN}}</td>
                            <td>{{remExcpresCN}}</td>
                            <td>{{remDate remDate}}</td>
                            <td>{{reDecOrgCN}}</td>
                        </tr>
                        {{/each}}
                    </script>
                </c:if>
                <!-- 个体户经营异常信息 -->
                <c:if test="${entBasicInfo.entTypeCatg == '50'}">
                    <div class="mod-bd-panel_company">
                        <h3 class="i-title">
                            <i></i>经营异常信息
                        </h3>
                        <table class="table-common table-chufa">
                            <thead>
                            <tr>
                                <th width="35">序号</th>
                                <th width="220">标记经营异常状态原因</th>
                                <th width="105">标记日期</th>
                                <th width="140">作出决定机关（标记）</th>
                                <th width="250">恢复正常记载状态原因</th>
                                <th width="105">恢复日期</th>
                                <th>作出决定机关（恢复）</th>
                            </tr>
                            </thead>
                            <tbody id="pbopanomaly_listData">
                            <tr><td  colspan="7"><div class="no-con">暂无列入经营异常名录信息 </div></td></tr>

                            </tbody>
                        </table>
                    </div>

                    <script id="pbopanomaly-table-template" type="text/x-handlebars-template">
                        {{#each data}}
                        <tr>
                            <td>{{xh @index}}</td>
                            <td>{{excpStaResCN}}</td>
                            <td>{{cogDate cogDate}}</td>
                            <td>{{decorgCN}}</td>
                            <td>{{norReaCN}}</td>
                            <td>{{norDate norDate}}</td>
                            <td>{{norDecOrgCN}}</td>
                        </tr>
                        {{/each}}
                    </script>
                </c:if>
                <!-- 严重违法 -->
                <c:if test="${entBasicInfo.entTypeCatg != '16' && entBasicInfo.entTypeCatg != '17' && entBasicInfo.entTypeCatg != '50'}">
                    <div class="mod-bd-panel_company">
                        <h3 class="i-title">
                            <i></i>严重违法信息
                        </h3>
                        <table class="table-common table-chufa mb20">
                            <thead>
                            <tr>
                                <th width="35">
                                    序号
                                </th>
                                <th width="70">
                                    类别
                                </th>
                                <th width="185">
                                    列入严重违法失信企业名单（黑名单）原因
                                </th>
                                <th width="115">
                                    列入日期
                                </th>
                                <th width="120">
                                    作出决定机关（列入）
                                </th>
                                <th width="185">
                                    移出严重违法失信企业名单（黑名单）原因
                                </th>
                                <th width="115">
                                    移出日期
                                </th>
                                <th>
                                    作出决定机关（移出）
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr><td  colspan="20"><div class="no-con">暂无严重违法信息 </div></td></tr>

                            </tbody>
                        </table>

                    </div>
                </c:if>

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
                        <tr><td  colspan="5"><div class="no-con">暂无抽查检查结果信息</div></td></tr>

                        </tbody>
                    </table>

                </div>
                <script id="table-template-pubscresult" type="text/x-handlebars-template">
                    {{#each data}}
                    <tr>
                        <td>{{xh @index}}</td>
                        <td>{{inspectDesc}}</td>
                        <td>{{scType}}</td>
                        <td>{{transInspectDate inspectDate}}</td>
                        <td>{{transCN scResult}}</td>
                    </tr>
                    {{/each}}
                </script>
                <!-- 司法协助信息 -->
                <c:if test="${fn:indexOf('11,21', entBasicInfo.entTypeCatg)!=-1}">

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
                                <th width="260">执行法院</th>
                                <th width="290">执行通知书文号</th>
                                <th width="130">类型 | 状态</th>
                            </tr>
                            </thead>
                            <tbody id="_justice">
                            <tr><td  colspan="20"><div class="no-con">暂无司法协助信息</div></td></tr>
                            </tbody>
                        </table>

                        <script id="justice-table-template" type="text/x-handlebars-template">
                            {{#each data}}
                            <tr data-uid="{{uid}}">
                                <td>{{xh @index}}</td>
                                <td>{{inv}}</td>
                                <td>{{froAm}}{{froAuth}}</td>
                                <td>{{executionCourt}}</td>
                                <td>{{executeNo}}</td>
                                <td>{{justiceType this}}</td>
                            </tr>
                            {{/each}}
                        </script>
                    </div>
                </c:if>
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
                        </tr>
                        </thead>
                        <tbody id="_mort">
                        <tr><td  colspan="20"><div class="no-con">暂无动产抵押登记信息</div></td></tr>

                        </tbody>
                    </table>

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
                    </tr>
                    {{/each}}
                </script>
                <!-- 股权出质登记信息 -->
                <c:if test="${fn:indexOf('11,21', entBasicInfo.entTypeCatg)!=-1}">
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
                                <th width="150">证照/证件号码</th>
                                <th width="290">股权出质设立登记日期</th>
                                <th width="40">状态</th>
                                <th width="110">公示日期</th>
                            </tr>
                            </thead>
                            <tbody id="_pledge">
                            <tr><td  colspan="20"><div class="no-con">暂无股权出质登记信息</div></td></tr>

                            </tbody>
                        </table>

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
                            <td>{{status status}}</td>
                            <td>{{equPleDate equPleDate}}</td>
                        </tr>
                        {{/each}}
                    </script>
                </c:if>
                <!-- 知识产权出质登记信息 -->
                <%--<div class="mod-bd-panel_company">
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
                        <tr><td  colspan="20"><div class="no-con">暂无知识产权出质登记信息</div></td></tr>

                        </tbody>
                    </table>

                </div>--%>

                <h2>企业自行公示信息<span class="light ml10 font-14 va-top">(企业自行公示信息由该企业提供，企业对其即时信息的真实性、合法性负责)</span></h2>

                <!-- 个体户纸质接收的列表显示 start-->
                <table class="table-common mb20" style="display: ${year_pb_list.size()>0?'line-block':'none'}" >
                    <thead>
                    <tr>
                        <th width="130">序号</th>
                        <th width="250">报送年度</th>
                        <th width="250">公示日期</th>
                        <th>详情</th>
                    </tr>
                    </thead>
                    <tbody >
                    <c:forEach var="pblist" items="${year_pb_list}" varStatus="status">
                        <tr>
                            <td>${status.index + 1}</td>
                            <td>${pblist.year}</td>
                            <td>${fn:substring(pblist.ancheDateStr,0 ,4 )}年${fn:substring(pblist.ancheDateStr,5 ,7)}月${fn:substring(pblist.ancheDateStr,8 ,11)}日</td>
                            <td>该个体户已接收纸质年报</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <!-- 个体户纸质接收的列表显示 end-->

                <!-- 即时信息 Start -->
                <c:if test="${entBasicInfo.entTypeCatg!=16&&entBasicInfo.entTypeCatg!=17&&entBasicInfo.entTypeCatg!=50}">
                    <c:if test="${fn:indexOf(imReportType,'investment') != -1}">
                        <!-- 股东及出资信息 -->
                        <div class="mod-bd-panel_company">
                            <h3 class="i-title">
                                <i></i>股东及出资信息
                            </h3>
                            <table class="table-common table-gudong-imme table-nest mb20" cellspacing="0" cellpadding="0">
                                <thead>
                               <%-- <tr>
                                    <th width="8%">股东</th>
                                    <th width="8%">认缴额(万元)</th>
                                    <th width="8%">实缴额(万元)</th>
                                    <th valign="top" width="38%">
                                        <table border="0" cellpadding="0" cellspacing="0" width="100%" class="inner-table-common">
                                            <tr>
                                                <td colspan="4">认缴明细</td>
                                            </tr>
                                            <tr>
                                                <td width="28%">认缴<br/>出资方式</td>
                                                <td width="22%">认缴出资额<br/>（万元）</td>
                                                <td width="32%">认缴<br/>出资日期</td>
                                                <td>公示日期</td>
                                            </tr>
                                        </table>
                                    </th>
                                    <th valign="top">
                                        <table border="0" cellpadding="0" cellspacing="0" width="100%"  class="inner-table-common">
                                            <tr>
                                                <td colspan="4">实缴明细</td>
                                            </tr>
                                            <tr>
                                                <td width="28%">实缴出资方式</td>
                                                <td width="22%">实缴出资额<br/>（万元）</td>
                                                <td width="32%">实缴<br/>出资日期</td>
                                                <td>公示日期</td>
                                            </tr>
                                        </table>
                                    </th>
                                </tr>--%>
                               <tr>
                                   <th width="8%" rowspan="2">股东</th>
                                   <th width="10%" rowspan="2">认缴额(万${entBasicInfo.currencyCn})</th>
                                   <th width="10%" rowspan="2">实缴额(万${entBasicInfo.currencyCn})</th>
                                   <th colspan="4">认缴明细</th>
                                   <th colspan="4">实缴明细</th>
                               </tr>

                               <tr>
                                   <th width="9%">认缴<br/>出资方式</th>
                                   <th width="9%">认缴出资额<br/>（万${entBasicInfo.currencyCn}）</th>
                                   <th width="9%">认缴<br/>出资日期</th>
                                   <th width="9%">公示日期</th>

                                   <th width="9%">实缴出资方式</th>
                                   <th width="9%">实缴出资额<br/>（万${entBasicInfo.currencyCn}）</th>
                                   <th width="9%">实缴<br/>出资日期</th>
                                   <th width="9%">公示日期</th>
                               </tr>
                                </thead>
                                <tbody id="investment">
                                <tr><td  colspan="20"><div class="no-con">暂无股东及出资信息</div></td></tr>

                                </tbody>
                            </table>

                            <script id="investment-template" type="text/x-handlebars-template">
                                {{#each data}}
                                <tr>
                                    <td>{{invname}}</td>
                                    <td>{{liSubConAm}}</td>
                                    <td>{{liAcConAm}}</td>
                                    <td valign="top" width="27%">
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
                                    <td valign="top" width="27%">
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
                                <tr><td  colspan="20"><div class="no-con">暂无股权变更信息</div></td></tr>

                                </tbody>
                            </table>

                            <script id="invsral-template" type="text/x-handlebars-template">
                                 {{#each data}}
                                 <tr>
                                     <td>{{addOne @index}}</td>
                                     <td> {{inv_trans inv}}</td>
                                     <td> {{beTransAmPr_trans beTransAmPr}}%</td>
                                     <td> {{afTransAmPr_trans afTransAmPr}}%</td>
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
                                <th width="180">许可文件编号</th>
                                <th width="120">许可文件名称</th>
                                <th width="110">有效期自</th>
                                <th width="110">有效期至</th>
                                <th width="170">许可机关</th>
                                <th width="140">许可内容</th>
                                <th width="200">状态</th>
                            </tr>
                            </thead>
                            <tbody id="permit">
                            <tr><td  colspan="20"><div class="no-con">暂无行政许可信息</div></td></tr>

                            </tbody>
                        </table>

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
                                <th width="330">质权登记期限</th>
                                <th width="35">状态</th>
                                <th width="200">公示日期</th>
                            </tr>
                            </thead>
                            <tbody id="ippldg">
                            <tr><td  colspan="20"><div class="no-con">暂无知识产权出质登记信息</div></td></tr>

                            </tbody>
                        </table>

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
                            <tr><td  colspan="20"><div class="no-con">暂无行政处罚信息</div></td></tr>

                            </tbody>
                        </table>

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
                                <td rowspan="{{rowdisplay caslatList}}">{{transType pubType}} </td>
                            </tr>
                            <tr  style="{{dataList caslatList}}" >
                                <td colspan="7" class="tip2">
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

                <c:forEach var="baseInfo" items="${year_list}">
                    <form id="${baseInfo.year}params">
                        <input type="hidden"  name="anCheID" value="${baseInfo.anCheID}"/>
                    </form>
                    <input type="hidden" id="${baseInfo.year}repYearType"  value="${baseInfo.repYearType}"/>

                    <div class="mod-bd-panel_company no-borderlr border-b-gray pb50">
                        <h3 class="i-title fj-title">
                            <i></i>${baseInfo.year}年度报告
                        </h3>
                    </div>
                    <div class="mod-bd-panel_company no-borderlr border-b-gray pb50">
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
                                    <li>
                                        <em>• </em>
                                        <span class="title ">从业人数：</span>
                                        <span>
                                                ${baseInfo.empNumStr}
                                        </span>
                                    </li>
                                    <c:if test="${baseInfo.year>2015}">
                                        <li>
                                            <em>• </em>
                                            <span class="title ">女性从业人数：</span>
                                            <span>
                                                    ${baseInfo.femaleEmployeStr}
                                            </span>
                                        </li>
                                        <li class="item-width">
                                            <em>• </em>
                                            <c:choose>
                                                <c:when test="${fn:indexOf(baseInfo.altItem,'entMainBusActivity')!=-1 }">
                                                    <span class="title light">主营业务活动：</span>
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="title ">主营业务活动：</span>
                                                </c:otherwise>
                                            </c:choose>
                                            <span>${baseInfo.entMainBusActivity}</span>
                                        </li>
                                    </c:if>
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
                    <c:choose>
                        <c:when test="${entBasicInfo.entTypeCatg==16||entBasicInfo.entTypeCatg==17}">
                            <!-- 农专网站或网店信息 -->
                            <div class="mod-bd-panel_company">
                                <c:choose>
                                    <c:when test="${fn:indexOf(baseInfo.altTableItem,'SfcWebsiteInfo')!=-1 }">
                                        <h3 class="i-title">
                                            <i></i><span class="light">网站或网店信息</span>
                                            <span class="number" id="${baseInfo.year}sfcwebsitelight"></span>
                                        </h3>
                                    </c:when>
                                    <c:otherwise>
                                        <h3 class="i-title">
                                            <i></i>网站或网店信息
                                            <span class="${baseInfo.year}number" id="${baseInfo.year}sfcwebsite"></span>
                                        </h3>
                                    </c:otherwise>
                                </c:choose>
                                <div class="${baseInfo.year}renyuan-list ${baseInfo.year}sfc_website clearfix">
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
                                    <tbody id="${baseInfo.year}table-sfc_branchinfo">
                                    <tr><td  colspan="20"><div class="no-con">暂无分支机构信息</div></td></tr>

                                    </tbody>
                                </table>

                            </div>
                            <script id="${baseInfo.year}table-template-sfc_branchinfo" type="text/x-handlebars-template">
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
                                    <tbody id="${baseInfo.year}table-sfc_licenceinfo">
                                    <tr><td  colspan="20"><div class="no-con">暂无行政许可信息</div></td></tr>

                                    </tbody>
                                </table>

                            </div>
                            <script id="${baseInfo.year}table-template-sfc_licenceinfo" type="text/x-handlebars-template">
                                {{#each data}}
                                <tr>
                                    <td>{{xh @index}}</td>
                                    <td>{{{licNameCN this}}}</td>
                                    <td>{{{valTo this}}}</td>
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
                                            <span class="number" id="${baseInfo.year}pbwebsitelight"></span>
                                        </h3>
                                    </c:when>
                                    <c:otherwise>
                                        <h3 class="i-title">
                                            <i></i>网站或网店信息
                                            <span class="number" id="${baseInfo.year}pbwebsite"></span>
                                        </h3>
                                    </c:otherwise>
                                </c:choose>
                                <div class="renyuan-list ${baseInfo.year}pb_website clearfix">
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
                                    <tbody id="${baseInfo.year}table-pb_licenceinfo">
                                    <tr><td  colspan="20"><div class="no-con">暂无行政许可信息</div></td></tr>

                                    </tbody>
                                </table>

                            </div>
                            <script id="${baseInfo.year}table-template-pb_licenceinfo" type="text/x-handlebars-template">
                                {{#each data}}
                                <tr>
                                    <td>{{xh @index}}</td>
                                    <td>{{{licNameCN this}}}</td>
                                    <td>{{{valTo this}}}</td>
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
                                            <span class="number" id="websitelight"></span>
                                        </h3>
                                    </c:when>
                                    <c:otherwise>
                                        <h3 class="i-title">
                                            <i></i>网站或网店信息
                                            <span class="number" id="website"></span>
                                        </h3>
                                    </c:otherwise>
                                </c:choose>
                                <div class="renyuan-list ${baseInfo.year}website clearfix">
                                </div>
                            </div>
                            <!-- 股东及出资信息 -->
                            <c:if test="${fn:indexOf(baseInfo.repYearType,'subcapital') != -1}">
                                <div class="mod-bd-panel_company">
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
                                            <th>序号</th>
                                            <th>股东</th>
                                            <th>认缴出资额(万${baseInfo.year>2015?baseInfo.currencyCN:'元'})</th>
                                            <th>认缴出资时间</th>
                                            <th>认缴出资方式</th>
                                            <th>实缴出资额(万${baseInfo.year>2015?baseInfo.currencyCN:'元'})</th>
                                            <th>实缴出资时间</th>
                                            <th>实缴出资方式</th>
                                        </tr>
                                        </thead>
                                        <tbody id="${baseInfo.year}table-inv">
                                        <tr><td  colspan="20"><div class="no-con">暂无股东及出资信息</div></td></tr>

                                        </tbody>
                                    </table>

                                </div>
                                <script id="${baseInfo.year}table-template-inv" type="text/x-handlebars-template">
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

                            <!-- 对外投资信息 -->
                            <c:if test="${fn:indexOf(baseInfo.repYearType,'forinvestment') != -1}">
                                <div class="mod-bd-panel_company">

                                    <c:choose>
                                        <c:when test="${fn:indexOf(baseInfo.altTableItem,'ForinvestMent')!=-1 }">
                                            <h3 class="i-title">
                                                <i></i><span class="light">对外投资信息</span>
                                                <span class="number" id="${baseInfo.year}yrforinvestment"></span>
                                            </h3>
                                            <%--                   <table class="table-common mb20">
                                                                   <thead>
                                                                   <tr>
                                                                       <th>序号</th>
                                                                       <th>名称</th>
                                                                       <th>统一社会信用号码/注册号</th>
                                                                   </tr>
                                                                   </thead>
                                                                   <tbody id="${baseInfo.year}table-invest-for">
                                                                   <tr><td  colspan="20"><div class="no-con">暂无对外投资信息</div></td></tr>

                                                                   </tbody>
                                                               </table>--%>
                                        </c:when>
                                        <c:otherwise>
                                            <h3 class="i-title">
                                                <i></i>对外投资信息
                                                <span class="number" id="${baseInfo.year}yrforinvestment"></span>
                                            </h3>
                                            <%--   <table class="table-common mb20">
                                                   <thead>
                                                   <tr>
                                                       <th>序号</th>
                                                       <th>名称</th>
                                                       <th>统一社会信用号码/注册号</th>
                                                   </tr>
                                                   </thead>
                                                   <tbody id="${baseInfo.year}table-invest-for">
                                                   <tr><td  colspan="20"><div class="no-con">暂无对外投资信息</div></td></tr>

                                                   </tbody>
                                               </table>--%>
                                        </c:otherwise>
                                    </c:choose>
                                    <div class="renyuan-list ${baseInfo.year}forinvestment clearfix">
                                    </div>
                                </div>
                            </c:if>

                            <!-- 企业资产状况信息 -->
                            <c:if test="${fn:indexOf(baseInfo.repYearType,'asset') != -1 && fn:indexOf(baseInfo.repYearType,'assetbranch') == -1}">
                                <div class="mod-bd-panel_company">
                                    <h3 class="i-title">
                                        <i></i>企业资产状况信息
                                    </h3>
                                    <table class="table-common table-zichan">
                                        <tr>
                                            <td class="odd">资产总额</td>
                                            <td>${baseInfo.assGroStr}</td>
                                            <td class="odd">所有者权益合计</td>
                                            <td>${baseInfo.totEquStr}</td>
                                        </tr>
                                        <tr>
                                            <td class="odd">营业总收入</td>
                                            <td>${baseInfo.vendIncStr}</td>
                                            <td class="odd">利润总额</td>
                                            <td>${baseInfo.proGroStr}</td>
                                        </tr>
                                        <tr>
                                            <td class="odd">营业总收入中主营业务收入</td>
                                            <td>${baseInfo.maiBusIncStr}</td>
                                            <td class="odd">净利润</td>
                                            <td>${baseInfo.netIncStr}</td>
                                        </tr>
                                        <tr>
                                            <td class="odd">纳税总额</td>
                                            <td>${baseInfo.ratGroStr}</td>
                                            <td class="odd">负债总额</td>
                                            <td>${baseInfo.liaGroStr}</td>
                                        </tr>

                                    </table>
                                </div>
                            </c:if>

                            <!-- 生产经营情况信息 -->
                            <%--   <c:if test="${fn:indexOf(baseInfo.repYearType,'assetbranch') != -1}">
                                   <div class="mod-bd-panel_company">
                                       <h3 class="i-title">
                                           <i></i>生产经营情况信息
                                       </h3>
                                       <table class="table-common table-zichan">
                                           <tr>
                                               <td>主营业务收入</td>
                                               <td>${baseInfo.maiBusIncStr}</td>
                                               <td>净利润</td>
                                               <td>${baseInfo.netIncStr}</td>
                                           </tr>
                                           <tr>
                                               <td>纳税总额</td>
                                               <td>${baseInfo.ratGroStr}</td>
                                               <td></td>
                                               <td></td>
                                           </tr>
                                       </table>
                                   </div>
                               </c:if>--%>

                            <!-- 对外提供保证担保信息 -->
                            <div class="mod-bd-panel_company">
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
                                    <tbody id="${baseInfo.year}table-forguaranteeinfo">
                                    <tr><td  colspan="20"><div class="no-con">暂无对外提供保证担保信息</div></td></tr>

                                    </tbody>
                                </table>

                            </div>
                            <script id="${baseInfo.year}table-template-forguaranteeinfo" type="text/x-handlebars-template">
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

                            <!-- 股权变更信息 -->
                            <c:if test="${fn:indexOf(baseInfo.repYearType,'alterstockinfo') != -1}">
                                <div class="mod-bd-panel_company">
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
                                            <th width="280">股东</th>
                                            <th width="210">变更前股权比例</th>
                                            <th width="210">变更后股权比例</th>
                                            <th>股权变更日期</th>
                                        </tr>
                                        </thead>
                                        <tbody id="${baseInfo.year}table-alterstockinfo">
                                        <tr><td  colspan="20"><div class="no-con">暂无股权变更信息</div></td></tr>

                                        </tbody>
                                    </table>

                                </div>
                                <script id="${baseInfo.year}table-template-alterstockinfo" type="text/x-handlebars-template">
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

                            <!-- 社保信息 -->
                            <%--  <c:if test="${baseInfo.year > 2015}">
                                  <div class="mod-bd-panel_company">
                                      <h3 class="i-title">
                                          <i></i>社保信息
                                      </h3>
                                      <table class="table-common mb20">
                                          <thead>
                                          <tr>
                                              <th width="580">参保险种类型</th>
                                              <th>单位参保人数(单位:人)</th>
                                          </tr>
                                          </thead>
                                          <tbody>
                                          <tr>
                                              <td>城镇职工基本养老保险</td>
                                              <td>${baseInfo.endowmentNum}</td>
                                          </tr>
                                          <tr>
                                              <td>失业保险</td>
                                              <td>${baseInfo.unemploymentNum}</td>
                                          </tr>
                                          <tr>
                                              <td>职工基本医疗保险</td>
                                              <td>${baseInfo.medicalNum}</td>
                                          </tr>
                                          <tr>
                                              <td>工伤保险</td>
                                              <td>${baseInfo.empInjuryNum}</td>
                                          </tr>
                                          <tr>
                                              <td>生育保险</td>
                                              <td>${baseInfo.maternityNum}</td>
                                          </tr>
                                          </tbody>
                                      </table>
                                      <table class="table-common">
                                          <tbody>
                                          <tr>
                                              <td width="480" class="title">单位缴费基数（万元）</td>
                                              <td>${baseInfo.paymentBaseStr}</td>
                                          </tr>
                                          <tr>
                                              <td class="title">本期实际缴费金额（万元）</td>
                                              <td> ${baseInfo.actualPaymentStr}</td>
                                          </tr>
                                          <tr>
                                              <td class="title">单位累计欠缴金额（万元）</td>
                                              <td>${baseInfo.cumulArrearsStr}</td>
                                          </tr>
                                          </tbody>
                                      </table>
                                  </div>
                              </c:if>--%>

                        </c:otherwise>
                    </c:choose>
                </c:forEach>


                <div class="tips" style="padding-bottom:50px">（以上信息仅供参考，具体内容请以国家企业信用信息公示系统查询页面为准）</div>
            </div>
        </div>
    </div>
</div>
<script>
    //参数的传递
    window._CONFIG = {
        repType: '${imReportType}',
        entTypeCatg: '${entBasicInfo.entTypeCatg}',
        repYearType: '${repYearType}',
        pageType:'print',
        yearStr:'${yearstr}'
    }

</script>

<script src="../../../../js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="../../../../js/lib/pagination/jquery.pagination.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/pub/entinfo/yrinfo_main.js"></script>
<script src="/js/pub/entinfo/baseinfo_main.js"></script>
<script src="/js/pub/entinfo/other_main.js"></script>
<script src="/js/pub/entinfo/iminfo_main.js"></script>
<script src="/js/pub/entinfo/infoprint.js"></script>
</body>
</html>