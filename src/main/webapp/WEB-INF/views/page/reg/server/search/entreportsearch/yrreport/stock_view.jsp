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
    <title>股权转让情况页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>





<input type="hidden" id="_year"  value="${year}" />
<input type="hidden" id="_priPID" value="${priPID}" />

<!-- 年度股权转让信息 -->
<div class="mod caiwu">
    <div class="mod-hd" > </div>
</div>


<!-- 年度股权转让表 -->
<div class="mod subcapital">
    <div class="mod-hd">
        <div class="title mt10">
            <h3>${year }年度股权转让表</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content">
            <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                <thead>
                <tr>
                    <th width="60">序号</th>
                    <th width="310" class="bg">股东</th>
                    <th class="bg pos">变更前股权比例（%）
                        <div class="arrow-box">
                         <%--   <i class="icon-arrow-up order_by" data-order=" beTransAmPr asc "></i>
                            <i class="icon-arrow-down order_by" data-order=" beTransAmPr desc "></i>--%>
                        </div>
                    </th>
                    <th class="bg pos">变更后股权比例（%）
                        <div class="arrow-box">
                           <%-- <i class="icon-arrow-up order_by" data-order=" afTransAmPr asc "></i>
                            <i class="icon-arrow-down order_by" data-order=" afTransAmPr desc "></i>--%>
                        </div>
                    </th>
                    <th width="170" class="bg pos">
                        股权变更日期
                        <div class="arrow-box">
                           <%-- <i class="icon-arrow-up order_by" data-order=" altDate asc "></i>
                            <i class="icon-arrow-down order_by" data-order=" altDate desc "></i>--%>
                        </div>
                    </th>
                </tr>
                </thead>
                <tbody id="tody_list">

                </tbody>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到  <em id="tody_total"></em> 条信息，共<em id="tody_pageNum"></em>页</span>
                <div id="tody_pagination" class="pagination">

                </div>
            </div>
        </div>
    </div>
</div>
</div>


<%--查询参数值： table 当前年份 列表--%>
<form id="tody_params">
    <input type="hidden" name="year" value="${year}"/>
    <input type="hidden" name="priPID" value="${priPID}"/>
    <input type="hidden" id="_orderStr" name="orderStr" value=""/>
</form>


<script id="tody-table-template" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{num1 @index}}</td>
        <td>{{inv}}</td>
        <td>{{beTransAmPr}}</td>
        <td>{{afTransAmPr}}</td>
        <td>{{altDate}}</td>
    </tr>
    {{/each}}
</script>

<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/server/yr/entreportsearch/yrreport/stock_view.js"/>"></script>
</body>
</html>