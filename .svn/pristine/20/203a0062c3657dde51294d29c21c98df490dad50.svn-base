<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="entTypeLTD" value="1200,1210,1211,1212,1213,1219,1220,1221,1222,1223,1229,5200,5210,5220,5230,5240,5290,6200,6210,6220,6230,6240,6250,6260,6270,6280,6290"/>
<c:set var="entType" value="${entType}"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>股东及出资情况页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>

<%--改隐藏域的值用于判断是否是2012年的数据是否进行显示--%>
<input type="hidden" id="_year" value="${year}">
<input type="hidden" id="_priPID" value="${priPID}" />

<!-- 企业财务信息 -->
<div class="mod caiwu">

    <div class="mod-bd mod-bd">
        <c:if test="${(year-1)!=2012}">
            <div class="title">
                <h3>${year-1}年度股东出资信息</h3>
                <div class="currency">
                    <div class="show-tips js-ui-show">
                        <span>展开</span>
                        <i></i>
                    </div>
                </div>
            </div>
            <div class="content js-content-show js-table">
                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th width="50">序号</th>
                        <th width="96" class="bg">
                            <c:if test="${fn:indexOf(entTypeLTD,entType) == -1}">发起人</c:if>
                            <c:if test="${fn:indexOf(entTypeLTD,entType) != -1}">股东</c:if>
                        </th>
                        <th width="150">统一证照号码</th>
                        <th width="98" class="bg">认缴出资额<br/><strong class="light">(${year>2015?currencyCn:'元'})</strong></th>
                        <th width="118" class="bg">出资方式<br/>（认缴）</th>
                        <th width="108" class="bg">认缴出资日期</th>
                        <th width="100" class="bg">实缴出资额<br/><strong class="light">(${year>2015?currencyCn:'元'})</strong></th>
                        <th width="120" class="bg">出资方式<br/>（实缴）</th>
                        <th class="bg">实缴出资日期</th>
                    </tr>
                    </thead>
                    <tbody  id="last_list">
                    </tbody>
                    <tr>
                        <td>合计：</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td><span id="last_money_rj"></span><strong class="light">万</strong></td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td><span id="last_money_sj"></span><strong class="light">万</strong></td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                </table>
                <div class="notice-pagination-box clearfix">
                    <span class="page-total">共查询到<em id="last_total"></em>条信息，共<em id="last_pageNum"></em>页</span>
                    <div id="last_pagination" class="pagination">
                    </div>
                </div>
            </div>
        </c:if>
    </div>
</div>



<!-- 股东出资表 -->
<div class="mod subcapital">
    <div class="mod-hd">
        <div class="title mt10">
            <h3>${year}年度股东出资信息</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content">
            <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                <thead>
                <tr>
                    <th width="50">序号</th>
                    <th width="96" class="bg">
                        <c:if test="${fn:indexOf(entTypeLTD,entType) == -1}">发起人</c:if>
                        <c:if test="${fn:indexOf(entTypeLTD,entType) != -1}">股东</c:if>
                    </th>
                    <th width="150">统一证照号码</th>
                    <th width="98" class="bg pos">认缴出资额<br/><strong class="light">(${year>2015?currencyCn:'元'})</strong>
                      <%--  <div class="arrow-box">
                            <i class="icon-arrow-up order_by" data-order=" lisubconam asc "></i>
                            <i class="icon-arrow-down order_by" data-order=" lisubconam desc "></i>
                        </div>--%>
                    </th>
                    <th width="118" class="bg">出资方式<br/>（认缴）</th>
                    <th width="108" class="bg">认缴出资日期</th>
                    <th width="100" class="bg pos">
                        实缴出资额<br/><strong class="light">(${year>2015?currencyCn:'元'})</strong>
                      <%--  <div class="arrow-box pos">
                            <i class="icon-arrow-up order_by" data-order=" liacconam asc "></i>
                            <i class="icon-arrow-down order_by" data-order=" liacconam desc "></i>
                        </div>--%>
                    </th>
                    <th width="120" class="bg">出资方式<br/>（实缴）</th>
                    <th class="bg">实缴出资日期</th>
                </tr>
                </thead>
                <tbody id="tody_list">

                </tbody>
                <tr>
                    <td>合计：</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td><span id="tody_money_rj"></span><strong class="light">万</strong></td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td><span id="tody_money_sj"></span><strong class="light">万</strong></td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>

            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到<em id="tody_total"></em>条信息，共<em id="tody_pageNum"></em>页</span>
                <div id="tody_pagination" class="pagination"></div>
            </div>
        </div>
    </div>
</div>

</div>


<%--查询参数值： table 上一年 列表--%>
<form id="last_params">
    <input type="hidden" name="year" value="${year-1}"/>
    <input type="hidden" name="priPID" value="${priPID}"/>
</form>

<%--查询参数值： table 当前年份 列表--%>
<form id="tody_params">
    <input type="hidden" name="year" value="${year}"/>
    <input type="hidden" name="priPID" value="${priPID}"/>
</form>


<%-- table 上一年 列表--%>
<script id="last-table-template" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{num1 @index}}</td>
        <td>{{inv}}</td>
        <td>{{invRegNO}}</td>
        <td>{{lisubconam}}<strong class="light">万</strong></td>
        <td>{{conFormCN}}</td>
        <td>{{subConDate}}</td>
        <td>{{liacconam}}<strong class="light">万</strong></td>
        <td>{{acConFormCn}}</td>
        <td>{{acConDate}}</td>
    </tr>
    {{/each}}
</script>

<%-- table 当前年份列表--%>
<script id="tody-table-template" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{num2 @index}}</td>
        <td>{{inv}}</td>
        <td>{{invRegNO}}</td>
        <td>{{lisubconam}}<strong class="light">万</strong></td>
        <td>{{conFormCN}}</td>
        <td>{{subConDate}}</td>
        <td>{{liacconam}}<strong class="light">万</strong></td>
        <td>{{acConFormCn}}</td>
        <td>{{acConDate}}</td>
    </tr>
    {{/each}}
</script>

<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/server/yr/entreportsearch/yrreport/subcapital_view.js"/>"></script>

</body>
</html>
