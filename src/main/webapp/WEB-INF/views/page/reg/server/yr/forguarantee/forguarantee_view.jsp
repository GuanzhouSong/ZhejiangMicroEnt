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
    <title>年报对外担保情况页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>


<!-- 对外担保信息 -->
<div class="mod caiwu">
    <div class="mod-bd mod-bd">
            <div class="title mb-10">
                <h3>${year-1}年度对外担保信息</h3>
                <div class="currency">
                    <div class="show-tips js-ui-show">
                    </div>
                </div>
            </div>
        <div class="content js-content-show js-table" style="display: block;" >
            <div class="content-xs-height">
                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th width="52">序号</th>
                        <th width="106" class="bg">债权人</th>
                        <th width="106" class="bg">债务人</th>
                        <th width="78" class="bg">主债权种类</th>
                        <th width="99" class="bg">主债权<br />数额（万元）</th>
                        <th width="88" class="bg">保证的<br />期间</th>
                        <th width="88" class="bg">保证的<br />方式</th>
                        <th width="88" class="bg">保证担保<br />的范围</th>
                        <th width="88" class="bg">履行债务<br />的期限始</th>
                        <th width="88" class="bg">履行债务<br />的期限止</th>
                        <th class="bg">是否公示</th>
                    </tr>
                    </thead>
                    <tbody id="dbao_page_one">

                    </tbody>
                </table>
            </div>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到<em id="_total_one"></em>条信息，共<em id="_pageNum_one"></em>页</span>
                <div id="pagination_one" class="pagination">
                </div>
            </div>
        </div>
    </div>
</div>

<%--对外担保范围--%>
<div  style="display: none">
    <label><input type="checkbox" name="gaRanges" value="1">主债权</label>
    <label><input type="checkbox" name="gaRanges" value="2">利息</label>
    <label><input type="checkbox" name="gaRanges" value="3">违约金</label>
    <label><input type="checkbox" name="gaRanges" value="4">损害赔偿金</label>
    <label><input type="checkbox" name="gaRanges" value="5">实现债权的费用</label>
    <label><input type="checkbox" name="gaRanges" value="6">其他约定</label>
</div>


<!-- 年度对外担保信息表 -->
<div class="mod subcapital">
    <div class="mod-hd">
        <div class="title">
            <h3>${year}年度对外担保信息表</h3>
            <div class="btn-box"></div>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content">
            <div class="subcapital-tips"></div>
            <div class="content-sm-height">
                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th width="52">序号</th>
                        <th width="106" class="bg">债权人</th>
                        <th width="106" class="bg">债务人</th>
                        <th width="78" class="bg">主债权种类</th>
                        <th width="99" class="bg">主债权<br />数额（万元）</th>
                        <th width="88" class="bg">保证的<br />期间</th>
                        <th width="88" class="bg">保证的<br />方式</th>
                        <th width="88" class="bg">保证担保<br />的范围</th>
                        <th width="88" class="bg">履行债务<br />的期限始</th>
                        <th width="88" class="bg">履行债务<br />的期限止</th>
                        <th class="bg">是否公示</th>
                    </tr>
                    </thead>
                    <tbody id="dbao_page">
                    </tbody>
                </table>
            </div>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到<em id="_total"></em>条信息，共<em id="_pageNum"></em>页</span>
                <div id="pagination" class="pagination">

                </div>
            </div>
        </div>
    </div>
</div>


<%--查询参数值： table noe 列表--%>
<form id="params_one">
    <input type="hidden" name="year" value="${year-1}"/>
    <input type="hidden" name="priPID" value="${priPID}"/>
</form>

<%--查询参数值： table tow 列表--%>
<form id="params_tow">
    <input type="hidden" name="year" value="${year}"/>
    <input type="hidden" name="priPID" value="${priPID}"/>
</form>
</div>


<%-- table one 列表--%>
<script id="table-template-one" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{xh @index}}</td>
        <td>{{more}}</td>
        <td>{{mortgagor}}</td>
        <td>{{textOne priClaSecKind}}</td>
        <td>{{priClaSecAm}}</td>
        <td>{{textTow guaPeriod}}</td>
        <td>{{textThree gaType}}</td>
        <td>{{formatterCode gaRange}}</td>
        <td>{{pefPerForm}}</td>
        <td>{{pefPerTo}}</td>
        <td>{{textFour isPubFlag}}</td>
    </tr>
    {{/each}}
</script>

<%-- table tow 列表--%>
<script id="table-template" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{num @index}}</td>
        <td>{{more}}</td>
        <td>{{mortgagor}}</td>
        <td>{{textOne priClaSecKind}}</td>
        <td>{{priClaSecAm}}</td>
        <td>{{textTow guaPeriod}}</td>
        <td>{{textThree gaType}}</td>
        <td>{{formatterCode gaRange}}</td>
        <td>{{pefPerForm}}</td>
        <td>{{pefPerTo}}</td>
        <td>{{textFour isPubFlag}}</td>
    </tr>
    {{/each}}
</script>



<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script><%-- 填报表单中的jquery 这行代码不能删除  这里涉及到提交年报使用到的$.ajax请求--%>
<script src="<c:url value="/js/component/dropDown.js"/>"></script>
<script src="<c:url value="/js/lib/pagination/jquery.pagination.js"/>"></script>
<script src="<c:url value="/js/lib/placeholder/jquery.placeholder.min.js"/>"></script>
<script src="<c:url value="/js/lib/jquery/jquery.icinfo.js"/>"></script>
<script>
    $('input, textarea').placeholder(); //ie8支持placeholder
    $('.js-ipt-box').expandInput();
</script>

<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/server/yr/forguarantee/view_main.js"/>"></script>




</body>
</html>
