<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<!-- 企业财务信息 -->
<div class="mod caiwu">
    <div class="mod-bd mod-bd">
        <div class="title">
            <h3>${year-1}年股东出资信息</h3>
            <div class="currency">
                <div class="show-tips js-ui-show">
                </div>
            </div>
        </div>
        <div class="content js-content-show js-table" style="display: block;">
            <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                <thead>
                <tr>
                    <th width="50">序号</th>
                    <th width="96" class="bg">股东</th>
                    <th width="150">注册号<br/>（或身份证号）</th>
                    <th width="98" class="bg">认缴出资额</th>
                    <th width="118" class="bg">出资方式<br/>（认缴）</th>
                    <th width="108" class="bg">认缴出资日期</th>
                    <th width="100" class="bg">实缴出资额</th>
                    <th width="120" class="bg">出资方式<br/>（实缴）</th>
                    <th class="bg">实缴出资日期</th>
                </tr>
                </thead>
                <tbody  id="cz_page_one">
                </tbody>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到<em id="_total_one"></em>条信息，共<em id="_pageNum_one"></em>页</span>
                <div id="pagination_one" class="pagination">
                </div>
            </div>
        </div>
    </div>
</div>


<div class="radio-box" style="display: none;">
    <c:forEach var="listOne" items="${codeList}" >
        <label><input type="checkbox" name="conForm" value="${listOne.code}" data-text="${listOne.content}" class="conForm">${listOne.content}</label>
    </c:forEach>
</div>





<!-- 股东出资表 -->
<div class="mod subcapital">
    <div class="mod-hd">
        <div class="title">
            <h3>${year}年股东出资表</h3>
            <div class="btn-box"></div>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content">
            <div class="subcapital-tips"></div>
            <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                <thead>
                <tr>
                    <th width="50">序号</th>
                    <th width="96" class="bg">股东</th>
                    <th width="150">注册号<br/>（或身份证号）</th>
                    <th width="98" class="bg pos">认缴出资额
                        <div class="arrow-box">
                            <i class="icon-arrow-up order_by" data-order=" lisubconam asc "></i>
                            <i class="icon-arrow-down order_by" data-order=" lisubconam desc "></i>
                        </div>
                    </th>
                    <th width="118" class="bg">出资方式<br/>（认缴）</th>
                    <th width="108" class="bg">认缴出资日期</th>
                    <th width="100" class="bg pos">
                        实缴出资额
                        <div class="arrow-box pos">
                            <i class="icon-arrow-up order_by" data-order=" liacconam asc "></i>
                            <i class="icon-arrow-down order_by" data-order=" liacconam desc "></i>
                        </div>
                    </th>
                    <th width="120" class="bg">出资方式<br/>（实缴）</th>
                    <th class="bg">实缴出资日期</th>
                </tr>
                </thead>
                <tbody id="cz_page">

                </tbody>

            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到<em id="_total"></em>条信息，共<em id="_pageNum"></em>页</span>
                <div id="pagination" class="pagination">

                </div>
            </div>
        </div>
    </div>
</div>




<%--查询参数值： table one 列表--%>
<form id="_params_one">
    <input type="hidden" name="year" value="${year-1}"/>
    <input type="hidden" name="priPID" value="${priPID}"/>
    <input type="hidden"  name="orderStr" value=""/>
</form>

<%--查询参数值： table tow 列表--%>
<form id="_params">
    <input type="hidden" name="year" value="${year}"/>
    <input type="hidden" name="priPID" value="${priPID}"/>
    <input type="hidden" id="_orderStr" name="orderStr" value=""/>
</form>


<%--  table noe 列表 --%>
<script id="table-template-none" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{xh @index}}</td>
        <td>{{inv}}</td>
        <td>{{invRegNO}}</td>
        <td>{{lisubconam}}<strong class="light">万元</strong></td>
        <td>{{textFormat subConForm}}</td>
        <td>{{subConDate}}</td>
        <td>{{liacconam}}<strong class="light">万元</strong></td>
        <td>{{textFormat acConForm}}</td>
        <td>{{acConDate}}</td>
    </tr>
    {{/each}}
</script>

<%-- table tow 列表 --%>
<script id="table-template" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{num @index}}</td>
        <td>{{inv}}</td>
        <td>{{invRegNO}}</td>
        <td>{{lisubconam}}<strong class="light">万元</strong></td>
        <td>{{textFormat subConForm}}</td>
        <td>{{subConDate}}</td>
        <td>{{liacconam}}<strong class="light">万元</strong></td>
        <td>{{textFormat acConForm}}</td>
        <td>{{acConDate}}</td>
    </tr>
    {{/each}}
</script>


<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/component/dropDown.js"/>"></script>
<script src="<c:url value="/js/lib/pagination/jquery.pagination.js"/>"></script>

<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/server/yr/subcapital/view_main.js"/>"></script>

</body>
</html>
