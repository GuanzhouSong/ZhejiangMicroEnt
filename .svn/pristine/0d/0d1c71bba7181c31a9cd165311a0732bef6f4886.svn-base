<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean id="nowdate" class="java.util.Date"/>
<fmt:formatDate var="nowyear" value="${nowdate}" pattern="yyyy"/>
<fmt:formatDate var="duedate" value="${nowdate}" pattern="MMdd"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>个体户年报报送页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
    <style>
        .mod{
            width: auto;
        }
    </style>
</head>
<body>
<div class="mod caiwu">
    <div class="mod-hd">
        <div class="tips">
            <span class="txt">报表中背景颜色为</span>
            <span class="blockage"></span>
            <span class="txt">的内容经选择公示后将公示于企业信用信息公示系统</span>
        </div>
        <%--基本信息--%>
        <form class="form-horizontal error-bottom" id="form">
            <input type="hidden" name="anCheID" id="anCheID" value="${yrPbBaseInfo.anCheID}"/>
            <input type="hidden" name="priPID" id="priPID" value="${yrPbBaseInfo.priPID}"/>
            <input type="hidden" name="year" id="year" value="${yrPbBaseInfo.year}"/>
            <input type="hidden" name="regNO" value="${yrPbBaseInfo.regNO}"/>
            <input type="hidden" name="uniCode" value="${yrPbBaseInfo.uniCode}"/>
            <div class="pbreport-basic">
                <div class="mod-hd">
                    <div class="title">
                        <h3>基本信息</h3>
                        <p>以下内容请按照当前个体工商户最新的情况进行填写</p>
                    </div>
                </div>
                <div class="mod-bd">
                    <div class="content content-contact">
                        <table class="table-public table-contact pbReport" border="0" cellspacing="0" cellpadding="0">
                            <tbody>
                            <tr>
                                <td class="odd" colspan="2">
                                    <div class="item-name bg">名称字号</div>
                                    <div class="ipt-box">
                                        ${yrPbBaseInfo.traName}
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="odd">
                                    <div class="item-name bg">统一社会信用代码/注册号</div>
                                    <div class="ipt-box">
                                        ${empty yrPbBaseInfo.uniCode ? yrPbBaseInfo.regNO : yrPbBaseInfo.uniCode}
                                    </div>
                                </td>
                                <td class="odd">
                                    <div class="item-name bg">经营者姓名</div>
                                    <div class="ipt-box">
                                        ${yrPbBaseInfo.name}
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="odd ">
                                    <div class="item-name bg"><strong class="light">* </strong>对外公开联系电话</div>
                                    <div class="ipt-box">
                                        ${yrPbBaseInfo.tel}
                                    </div>
                                </td>
                                <td class="odd ">
                                    <div class="item-name "><strong class="light">* </strong>联系手机号码</div>
                                    <div class="ipt-box">
                                        ${yrPbBaseInfo.comPhone}
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="odd " colspan="2">
                                    <div class="item-name">经营场所</div>
                                    <div class="ipt-box">
                                        ${yrPbBaseInfo.opLoc}
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="odd " colspan="2">
                                    <div class="item-name">实际经营场所</div>
                                    <div class="ipt-box">
                                        ${yrPbBaseInfo.addr}
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="odd ">
                                    <div class="item-name bg"><strong class="light">* </strong>累积已投入经营资金</div>
                                    <div class="ipt-box">
                                        <fmt:formatNumber value="${yrPbBaseInfo.fundAm}" pattern="###,###,###,##0.00"/>元
                                </td>
                                <td class="odd ">
                                    <div class="item-name bg"><strong class="light">* </strong>其中，${yrPbBaseInfo.year}年投入经营资金
                                    </div>
                                    <div class="ipt-box">
                                        <fmt:formatNumber value="${yrPbBaseInfo.pbFundAm}"
                                                          pattern="###,###,###,##0.00"/>元
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="odd " colspan="2">
                                    <div class="item-name bg"><strong class="light">* </strong>${yrRegCheck.year}年末,从业人数（含雇工）
                                    </div>
                                    <div class="ipt-box">
                                        ${yrPbBaseInfo.empNum}人
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="odd " colspan="2">
                                    <div class="item-name">其中，经营者属于</div>
                                    <div class="radio-box pbReport">
                                        <label><c:if test="${yrPbBaseInfo.isLegRep == '1'}">高校毕业生</c:if></label>
                                        <label><c:if test="${yrPbBaseInfo.isLegRep == '2'}">退役士兵</c:if></label>
                                        <label><c:if test="${yrPbBaseInfo.isLegRep == '3'}">残疾人</c:if></label>
                                        <label><c:if test="${yrPbBaseInfo.isLegRep == '4'}">失业人员再就业</c:if></label>
                                        <label><c:if test="${yrPbBaseInfo.isLegRep == '5'}">不属于高校毕业生、退役士兵、残疾人及失业人员再就业人员</c:if></label>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="odd " colspan="2">
                                    <div class="item-name">其中，雇工人员中属于</div>
                                    高校毕业生
                                    <div class="ipt-box">
                                        ${yrPbBaseInfo.uniGradEmps}人,
                                    </div>
                                    退役士兵
                                    <div class="ipt-box">
                                        ${yrPbBaseInfo.exSoldEmps}人,
                                    </div>
                                    残疾人
                                    <div class="ipt-box">
                                        ${yrPbBaseInfo.disEmps}人,
                                    </div>
                                    失业人员再就业
                                    <div class="ipt-box">
                                        ${yrPbBaseInfo.unemEmps}人
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<%--经营信息--%>
<div class="mod contact">
    <div class="mod-hd">
        <div class="title">
            <h3>经营信息</h3>
            <p>以下内容请按照${yrRegCheck.year}年1月1日-12月31日期间的信息进行填写</p>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
            <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td class="odd ">
                        <div class="item-name bg js-ipt-box"><strong class="light">* </strong>营业额或营业收入</div>
                        <div class="ipt-box">
                            <fmt:formatNumber value="${yrPbBaseInfo.vendInc}" pattern="###,###,###,##0.00"/>元
                            <c:if test="${yrSfcBaseinfo.vendIncIsPub == '1'}">公示</c:if>
                            <c:if test="${yrSfcBaseinfo.vendIncIsPub == '0'}">不公示</c:if>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd " colspan="2">
                        <div class="item-name"><strong class="light">* </strong>属于免征纳税对象</div>
                        <div class="radio-box">
                            <label><c:if test="${yrPbBaseInfo.rreeTaxIs == '1'}">是</c:if></label>
                            <label><c:if test="${yrPbBaseInfo.rreeTaxIs == '0'}">否</c:if></label>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd ">
                        <div class="item-name bg"><strong class="light">* </strong>纳税总额</div>
                        <div class="ipt-box">
                            <fmt:formatNumber value="${yrPbBaseInfo.ratGro}" pattern="###,###,###,##0.00"/>元
                            <c:if test="${yrSfcBaseinfo.ratGroIsPub == '1'}">公示</c:if>
                            <c:if test="${yrSfcBaseinfo.ratGroIsPub == '0'}">不公示</c:if>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%--共产党员党建情况--%>
<div class="mod contact">
    <div class="mod-hd">
        <div class="title">
            <h3>共产党员党建情况</h3>
            <p>以下内容请按照当前你个体工商户最新的情况进行填写</p>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
            <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td class="odd ">
                        <div class="item-name w240"><strong class="light">*</strong>从业人员中，有中共党员（含预备党员）</div>
                        <div class="ipt-box">
                            ${yrPbBaseInfo.numParM}人
                        </div>
                    </td>
                    <td class="odd">
                        <div class="item-name w240"><strong class="light">*</strong>已独立或联合建立党支部</div>
                        <div class="radio-box">
                            <label><c:if test="${yrPbBaseInfo.partOrgIs == '1'}">是</c:if></label>
                            <label><c:if test="${yrPbBaseInfo.partOrgIs == '0'}">否</c:if></label>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd ">
                        <div class="item-name w240"><strong class="light">*</strong>经营者本人为党员</div>
                        <div class="radio-box">
                            <label><c:if test="${yrPbBaseInfo.resParMSign == '1'}">是</c:if></label>
                            <label><c:if test="${yrPbBaseInfo.resParMSign == '2'}">否</c:if></label>
                        </div>
                    </td>
                    <td class="odd">
                        <div class="item-name w240"><strong class="light">*</strong>经营者本人为党组织书记</div>
                        <div class="radio-box">
                            <label><c:if test="${yrPbBaseInfo.resParSecSign == '1'}">是</c:if></label>
                            <label><c:if test="${yrPbBaseInfo.resParSecSign == '2' || empty yrPbBaseInfo.resParSecSign }">否</c:if></label>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</form>

<%--开设网站网店情况--%>
<div class="mod subcapital">
    <div class="mod-hd">
        <div class="title">
            <h3>网站或网店信息</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
            <div class="content-sm-height">

                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th width="90" class="bg">序号</th>
                        <th width="90" class="bg">类型</th>
                        <th class="bg">名称</th>
                        <th class="bg">网址</th>
                    </tr>
                    </thead>
                    <tbody id="dbao_page">
                    </tbody>
                </table>
            </div>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="itemCount"></em> 条信息，共<em id="pageCount"></em>页</span>
                <div id="pagination2" class="pagination">
                </div>
            </div>
        </div>
    </div>
</div>

<%--取得许可证情况--%>
<div class="mod">
    <div class="mod-hd">
        <div class="title">
            <h3>行政许可情况</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
            <div class="content-sm-height">
                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th width="90" class="bg">序号</th>
                        <th class="bg">行政许可名称</th>
                        <th class="bg">有效期至</th>
                    </tr>
                    </thead>
                    <tbody id="dbao_page_one">
                    </tbody>
                </table>
            </div>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="itemCount1"></em> 条信息，共<em id="pageCount1"></em>页</span>
                <div id="pagination1" class="pagination">
                </div>
            </div>
        </div>
    </div>
</div>

<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/component/dropDown.js"/>"></script>
<script id="table-template-one" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{xh @index}}</td>
        <td>{{licNameCN}}</td>
        <td>{{valto valTo}}</td>
    </tr>
    {{/each}}
</script>
<script id="table-template" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{num @index}}</td>
        <td>{{webtype webType}}</td>
        <td>{{webSitName}}</td>
        <td>{{webSite}}</td>
    </tr>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/yr/entreportsearch/pbreport_view.js"></script>
</body>
</html>