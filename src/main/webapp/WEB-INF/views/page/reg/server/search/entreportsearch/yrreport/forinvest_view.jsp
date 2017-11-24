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
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <title> 对外投资情况页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>


<input type="hidden" id="_year"  value="${year}" />
<input type="hidden" id="_priPID" value="${priPID}" />

<!-- 年度对外投资信息 -->
<div class="mod caiwu">
    <div class="mod-bd mod-bd">
        <c:if test="${(year-1)!=2012}">
            <div class="title">
                <h3>${year-1}年度对外投资信息</h3>
                <div class="currency">
                    <div class="show-tips js-ui-show">
                        <span>展开</span>
                        <i></i>
                    </div>
                </div>
            </div>
        </c:if>
        <div class="content js-content-show js-table">
        <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
            <thead>
            <tr>
                <th width="50">序号</th>
                <th width="150" class="bg">对外投资企业统一社会<br/>信用代码(或注册号)</th>
                <th width="200" class="bg">投资设立(或购买股权)<br/>境内企业名称</th>
                <th width="88">认缴投资<br/>(总额)</th>
                <th width="80">认缴投资<br/>(方式)</th>
                <th width="120">认缴投资总额<br/>占比例(%)</th>
                <th width="118">实缴投资<br/>(总额)</th>
                <th width="80" >实缴投资<br/>(方式)</th>
                <th >实缴投资总额<br/>占比例(%)</th>
            </tr>
            </thead>
            <tbody id="last_list">

            </tbody>
            <tr>
                <td>合计：</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td><span id="last_money_rj"></span><strong class="light">万元</strong></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td><span id="last_money_sj"></span><strong class="light">万元</strong></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>

        </table>
        <div class="notice-pagination-box clearfix">
            <span class="page-total">共查询到 <em id="last_total"></em> 条信息，共<em id="last_pageNum"></em>页</span>
            <div id="last_pagination" class="pagination">

            </div>
        </div>
    </div>
    </div>
</div>



<!-- 年度对外投资信息表 -->
<div class="mod subcapital">
    <div class="mod-hd">
        <div class="title mt10">
            <h3>${year}年度对外投资信息</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content">
            <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                <thead>
                <tr>
                    <th width="50">序号</th>
                    <th width="150" class="bg">对外投资企业统一社会<br/>信用代码（或注册号）</th>
                    <th width="200" class="bg">投资设立（或购买股权）<br/>境内企业名称</th>
                    <th width="80" class="pos">
                        认缴投资<br/>(总额)
                        <div class="arrow-box">
                           <%-- <i class="icon-arrow-up order_by" data-order=" subConAm asc "></i>
                            <i class="icon-arrow-down order_by" data-order=" subConAm desc "></i>--%>
                        </div>
                    </th>
                    <th width="80" class="pos">
                        认缴投资<br/>(方式)
                        <div class="arrow-box">
                          <%--  <i class="icon-arrow-up order_by" data-order=" subConForm asc "></i>
                            <i class="icon-arrow-down order_by" data-order=" subConForm desc "></i>--%>
                        </div>
                    </th>
                    <th width="120" class="pos">
                        认缴投资总额<br/>占比例(%)
                        <div class="arrow-box">
                           <%-- <i class="icon-arrow-up order_by" data-order=" subConProp asc "></i>
                            <i class="icon-arrow-down order_by" data-order=" subConProp desc "></i>--%>
                        </div>
                    </th>
                    <th width="80" class="pos">
                        实缴投资<br/>(总额)
                        <div class="arrow-box">
                          <%--  <i class="icon-arrow-up order_by" data-order=" acConAm asc "></i>
                            <i class="icon-arrow-down order_by" data-order=" acConAm desc "></i>--%>
                        </div>
                    </th>
                    <th width="80" class="pos">
                        实缴投资<br/>(方式)
                        <div class="arrow-box">
                         <%--   <i class="icon-arrow-up order_by" data-order=" acConForm asc "></i>
                            <i class="icon-arrow-down order_by" data-order=" acConForm desc "></i>--%>
                        </div>
                    </th>
                    <th width="120" class="pos">
                        实缴投资总额<br/>占比例(%)
                        <div class="arrow-box">
                          <%--  <i class="icon-arrow-up order_by" data-order=" acConAmProp asc "></i>
                            <i class="icon-arrow-down order_by" data-order=" acConAmProp desc "></i>--%>
                        </div>
                    </th>
                </tr>
                </thead>
                <tbody id="tody_list">

                </tbody>
                <tr>
                    <td>合计：</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td><span id="tody_money_rj"></span><strong class="light">万元</strong></td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td><span id="tody_money_sj"></span><strong class="light">万元</strong></td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="tody_total"></em> 条信息，共<em id="tody_pageNum"></em>页</span>
                <div id="tody_pagination" class="pagination">

                </div>
            </div>
        </div>
    </div>
</div>
</div>


<%--查询参数值： table 上一年 列表--%>
<form id="last_params">
    <input type="hidden" name="year" value="${year-1}"/>
    <input type="hidden" name="priPID" value="${priPID}"/>
    <input type="hidden"  name="orderStr" value=""/>
</form>

<%--查询参数值： table 当前年份 列表--%>
<form id="tody_params">
    <input type="hidden" name="year" value="${year}"/>
    <input type="hidden" name="priPID" value="${priPID}"/>
    <input type="hidden" id="_orderStr" name="orderStr" value=""/>
</form>


<%-- table 上一年 列表--%>
<script id="last-table-template" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{num1 @index}}</td>
        <td>{{uniCode}}</td>
        <td>{{entName}}</td>
        <td>{{subConAm}}<strong class="light">万元</strong></td>
        <td>{{conFormCN}}</td>
        <td>{{subConProp}}</td>
        <td>{{acConAm}}<strong class="light">万元</strong></td>
        <td>{{acConFormCn}}</td>
        <td>{{acConAmProp}}</td>
    </tr>
    {{/each}}
</script>

<%-- table 当前年份列表--%>

<script id="tody-table-template" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{num2 @index}}</td>
        <td>{{uniCode}}</td>
        <td>{{entName}}</td>
        <td>{{subConAm}}<strong class="light">万元</strong></td>
        <td>{{conFormCN}}</td>
        <td>{{subConProp}}</td>
        <td>{{acConAm}}<strong class="light">万元</strong></td>
        <td>{{acConFormCn}}</td>
        <td>{{acConAmProp}}</td>
    </tr>
    {{/each}}
</script>


<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/server/yr/entreportsearch/yrreport/forinvest_view.js"/>"></script>
</body>
</html>