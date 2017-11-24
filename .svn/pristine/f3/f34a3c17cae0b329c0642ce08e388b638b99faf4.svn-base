<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>个体户年报公示预览页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>
<jsp:include page="../../common/header.jsp"></jsp:include>
<div class="banner-bg">
    <div class="mod banner">
        <h4>欢迎您！${midBaseInfoDto.entName}</h4>
        <p>
        	<em class="register-office">登记机关：${midBaseInfoDto.regOrgName}</em>
        	<c:if test="${!empty midBaseInfoDto.uniCode}"><em>统一社会信用代码：${midBaseInfoDto.uniCode}</em></c:if>
            <em>注册号：${midBaseInfoDto.regNO}</em>
        </p>
        <p>
            <em class="register-office">法定代表人/负责人：${midBaseInfoDto.leRep}</em>
            <em>成立日期：<fmt:formatDate value="${midBaseInfoDto.estDate}" dateStyle="long"/></em>
            <c:if test="${!empty midBaseInfoDto.regCap}">
                <em>注册资本：<fmt:formatNumber type="number"  value=" ${midBaseInfoDto.regCap }"  pattern="0.00" maxFractionDigits="2"/>万${midBaseInfoDto.currencyCn}</em>
            </c:if>
        </p>
    </div>
</div>
<div class="mod info-title">
    <h5 class="pdt20 center">个体户年报公示信息表</h5>
    <strong class="light">注：以下为个体户公示信息，若有误请返回年度报告报表中进行修改。</strong>
</div>
<div class="mod">
    <div class="mod-hd">
        <div class="title">
            <h3>基本信息</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
          <input type="hidden" name="anCheID" id = "anCheID" value="${yrPbBaseInfo.anCheID}"/>
          <input type="hidden" name="priPID" id ="priPID" value="${yrPbBaseInfo.priPID}"/>
          <input type="hidden" name="year" id = "year" value="${yrPbBaseInfo.year}"/>
            <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td class="odd">
                        <div class="item-name">名称：</div>
                        <div class="item-txt">${yrPbBaseInfo.traName}</div>
                    </td>
                    <td class="odd">
                        <div class="item-name">经营者姓名：</div>
                        <div class="item-txt">${yrPbBaseInfo.name}</div>
                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="item-name">统一社会信用代码/注册号：</div>
                        <div class="item-txt">${empty yrPbBaseInfo.uniCode ? yrPbBaseInfo.regNO : yrPbBaseInfo.uniCode}</div>
                    </td>
                    <td class="odd">
                        <div class="item-name">联系电话：</div>
                        <div class="item-txt">${yrPbBaseInfo.tel}</div>
                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="item-name">资金数额：</div>
                        <div class="item-txt"><fmt:formatNumber value="${yrPbBaseInfo.fundAm}" pattern="###,###,###,##0.0000"/>万元</div>
                    </td>
                    <td class="odd">
                        <div class="item-name">从业人数：</div>
                        <div class="item-txt">${yrPbBaseInfo.empNum}人</div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<div class="mod">
    <div class="mod-hd">
        <div class="title">
            <h3>生产经营情况信息</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
            <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td class="odd">
                        <div class="item-name">销售额或营业收入：</div>
                        <div class="item-txt">
                        <c:if test="${yrPbBaseInfo.vendIncIsPub == '1'}"><fmt:formatNumber value="${yrPbBaseInfo.vendInc}" pattern="###,###,###,##0.0000"/>万元</c:if>
                    	<c:if test="${yrPbBaseInfo.vendIncIsPub == '0'}">企业选择不公示</c:if></div>
                    </td>
                    <td class="odd">
                        <div class="item-name">纳税总额：</div>
                        <div class="item-txt">
                        <c:if test="${yrPbBaseInfo.ratGroIsPub == '1'}"><fmt:formatNumber value="${yrPbBaseInfo.ratGro}" pattern="###,###,###,##0.0000"/>万元</c:if>
                        <c:if test="${yrPbBaseInfo.ratGroIsPub == '0'}">企业选择不公示</c:if>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
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
            <div class="content-sm-height">
             
                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th width="20%" >类型</th>
                        <th width="40%" >名称</th>
                        <th width="40%" >网址</th>
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
                        <th width="50%">行政许可名称</th>
                        <th width="50%">有效期至</th>
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


<%-- 签章参数 start --%>
<form id="signature_params">
    <input type="hidden"  name="keyCerSn" value="${sessionScope.keyCerSn}"> <%--证书序列号--%>
    <input type="hidden"  name="year" value="${yrPbBaseInfo.year}"/>
    <input type="hidden"  name="pripid" value="${yrPbBaseInfo.priPID}"/>
</form>
<%-- 签章参数 end   --%>

<div class="mod" id="js-signature-box" style="display: ${sessionScope.loginType!='2'?'block':'none'}">
    <div class="btn-box">
        <button id="js-signature"  type="button" class="btn-common btn-save">加盖电子公章</button>
        <p class="center mb10"><strong class="light">注：加盖电子公章前请先插入数字证书。</strong></p>
    </div>
</div>

<div id="js-yearbox" style="display: ${sessionScope.loginType=='2'?'block':'none'}">
    <div class="mod btn-box">
        <button class="btn-common" id="save">提交</button>
        <button class="btn-common" id="cancel">取消</button>
    </div>
</div>


<form id="_params">
    <input type="hidden" name="year" value="${year}"/>
    <input type="hidden" name="priPID" value="${param.priPID}"/>
</form>

<%--弹出框--%>
<div class="layer"></div>
<div class="yrpubpreview-pop" id="yrpubpreview-pop">
    <h5>确认报送你个体户年度报告？</h5>
    <p>1、该年度报告内容将通过企业信用信息公示系统（ http://gsxt.zjaic.gov.cn ）向社会公示，接受社会公众查询和监督；</p>
    <p>2、你企业对年度报告内容的合法性、真实性负责。因公示信息错误、遗漏及违反国家相关规定引起的后果与法律责任由你企业承担；</p>
    <p>3、工商机关对年度报告内容不审查，但将对报告内容进行抽查检查。检查中发现企业在年度报告时弄虚作假、隐瞒真实的，将依法处理并予公示。</p>
    <strong>请确认年度报告信息真实完整！如需修改请取消返回</strong>
    <div class="btn-box">
        <input type="button" value="确定" class="btn-common" id="commit"/>
        <input type="button" value="取消" class="btn-common" id="confirmCancel"/>
    </div>
    <div class="center b-tip">
        服务热线：400-888-4636   服务QQ群：12790338
    </div>
</div>
<jsp:include page="../../common/footer.jsp"></jsp:include>

<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script id="table-template-one" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{licNameCN}}</td>
        <td>{{valto valTo}}</td>
    </tr>
    {{/each}}
</script>
<script id="table-template" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{webtype webType}}</td>
        <td>{{webSitName}}</td>
        <td>{{webSite}}</td>
    </tr>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/client/yr/pbyr/pbyrpubpreview.js"></script>
<script src="<c:url value="/js/reg/client/yr/qianzhang/qz_edit.js"/>"></script>
</body>
</html>