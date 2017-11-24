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
    <meta http-equiv="Content-Type" content="application/json; charset=UTF-8" />
    <title>${year}年报对外担保情况页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>



<%--改隐藏域的值用于判断是否是2012年的数据是否进行显示--%>
<input type="hidden" id="_year" value="${year}">
<input type="hidden" id="_priPID" value="${priPID}">


<!-- 对外担保信息 -->
<div class="mod caiwu">
    <div class="mod-bd mod-bd">
        <c:if test="${(year-1)!=2012}">
            <div class="title">
                <h3>${year-1}年度对外担保信息</h3>
                <div class="currency">
                    <div class="show-tips js-ui-show">
                        <span>展开</span>
                        <i></i>
                    </div>
                </div>
            </div>
            <div class="content js-content-show js-table">
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
                        <tbody id="last_list">

                        </tbody>
                        <tr>
                            <td>合计：</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td><span id="last_money"></span></td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>

                        </tr>
                    </table>
                </div>
                <div class="notice-pagination-box clearfix">
                    <span class="page-total">共查询到<em id="last_total"></em>条信息，共<em id="last_pageNum"></em>页</span>
                    <div id="last_pagination" class="pagination">
                    </div>
                </div>
            </div>
        </c:if>
    </div>
</div>

<%--隐藏域 --%>
<div style="display: none">
    <label><input type="checkbox" name="gaRanges" value="1" data-text="主债权">主债权</label>
    <label><input type="checkbox" name="gaRanges" value="2" data-text="利息">利息</label>
    <label><input type="checkbox" name="gaRanges" value="3" data-text="违约金">违约金</label>
    <label><input type="checkbox" name="gaRanges" value="4" data-text="损害赔偿金">损害赔偿金</label>
    <label><input type="checkbox" name="gaRanges" value="5" data-text="实现债权的费用">实现债权的费用</label>
    <label><input type="checkbox" name="gaRanges" value="6" data-text="其他约定">其他约定</label>
</div>

<!-- 年度对外担保信息表 -->
<div class="mod subcapital mt10">
    <div class="mod-hd ">
        <div class="title">
            <h3>${year}年度对外担保信息</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content">
            <div class="subcapital-tips">
            </div>
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
                    <tbody id="tody_list">
                    </tbody>
                    <tr>
                        <td>合计：</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td><span id="tody_money"></span></td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>

                    </tr>
                </table>
            </div>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到<em id="tody_total"></em>条信息，共<em id="tody_pageNum"></em>页</span>
                <div id="tody_pagination" class="pagination">

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
  <%--
    //判断当前数据是否为空的写法
    {{#ifCond data 'length' 0}}
         <tr><td colspan="11">无</td></tr>
    {{else}}
    --%>
    {{#each data}}
    <tr>
        <td>{{num1 @index}}</td>
        <td>{{more}}</td>
        <td>{{mortgagor}}</td>
        <td>{{textOne priClaSecKind}}</td>
        <td>{{priClaSecAm}}</td>
        <td>{{textTow guaPeriod}}</td>
        <td>{{textThree gaType}}</td>
        <td>{{textFormat gaRange}}</td>
        <td>{{pefPerForm}}</td>
        <td>{{pefPerTo}}</td>
        <td>{{textFour isPubFlag}}</td>
    </tr>
    {{/each}}
   <%-- {{/ifCond}}--%>
</script>

<%-- table 当前年份列表--%>
<script id="tody-table-template" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{num2 @index}}</td>
        <td>{{more}}</td>
        <td>{{mortgagor}}</td>
        <td>{{textOne priClaSecKind}}</td>
        <td>{{priClaSecAm}}</td>
        <td>{{textTow guaPeriod}}</td>
        <td>{{textThree gaType}}</td>
        <td>{{textFormat gaRange}}</td>
        <td>{{pefPerForm}}</td>
        <td>{{pefPerTo}}</td>
        <td>{{textFour isPubFlag}}</td>
    </tr>
    {{/each}}
</script>

<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/server/yr/entreportsearch/yrreport/forguarantee_view.js"/>"></script>


</body>
</html>
