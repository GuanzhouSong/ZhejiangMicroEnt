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

<!-- 头部  start-->
<jsp:include page="../../common/reportheader.jsp"></jsp:include>


<div class="fold-msg-bg js-fold-msg" >
    <jsp:include page="../template/view_template.jsp"></jsp:include>
</div>
<!-- 头部  end-->

<%--当前年报的状态：--%>
<input type="hidden" id="_reportState" value="${yrRegCheck.reportState}">
<input type="hidden" id="_year"  value="${year}" />
<input type="hidden" id="_priPID" value="${priPID}" />
 
<!-- 年度股权转让信息 -->
<div class="mod caiwu">

    <div class="mod-hd" >
        <jsp:include page="../template/tab_template.jsp"></jsp:include>
    </div>

</div>

<!-- 添加年度股权转让信息 -->
<div class="mod mod-border investment-info js-content-show js-editUI mt10" >
    <div class="mod-hd">
        <div class="title">
            <h3>添加/修改${year}年度股权转让信息</h3>
            <div class="currency">币种：<strong class="light">人民币</strong></div>
            <p> 请按照你企业${year }年1月1日至12月31日实际发生的股权变更信息进行填写。</p>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content">
            <form class="form-horizontal error-bottom" id="alterStockForm">
                <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td class="odd focus-state" colspan="2">

                            <input type="hidden" id="invAltID" name="invAltID" value="" />
                            <input type="hidden" id="priPID" name="priPID" value="${priPID}" />
                            <input type="hidden" id="year" name="year" value="${year}" />
                            <input type="hidden" id="anCheID" name="anCheID" value="${anCheID}" />

                            <div class="item-name bg">股东</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="inv" name="inv" class="ipt-txt w-650 " placeholder="请从列表中选择股东，列表以外的股东请直接输入">
                                <i class="icon-close"></i>
                            </div>
                            <input type="button" name="gd" class="btn-common js-inv-list" value="股东列表">
                        </td>

                    </tr>

                    <tr>
                        <td class="even focus-state">
                            <div class="item-name bg">变更前股权比例</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="beTransAmPr" name="beTransAmPr"  class="ipt-txt ipt-txt-lg">
                                <i class="icon-close"></i>
                            </div>
                            <strong>%</strong>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name bg" >变更后股权比例</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="afTransAmPr" name="afTransAmPr" class="ipt-txt ipt-txt-lg">
                                <i class="icon-close"></i>
                            </div>
                            <strong>%</strong>
                        </td>
                    </tr>

                    <tr>
                        <td class="even focus-state">
                            <div class="item-name bg">股权变更日期</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="altDate"  name="altDate"  class="ipt-txt laydate-icon ipt-txt-lg" readonly>
                                <%-- <i class="icon-close"></i>--%>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>

                <div class="btn-box">
                    <input type="submit" value="确定" class="btn-common js-submit">
                    <input type="button" value="取消" class="btn-common js-cancel">
                </div>
             </form>
        </div>
    </div>
</div>

<!-- 年度股权转让表 -->
<div class="mod subcapital">
    <div class="mod-hd">
        <div class="title mt10">
            <h3>${year }年度股权转让表</h3>
            <div class="btn-box">
                <a href="javascript:void(0)"  class="btn-common btn-add" >新增</a>
            </div>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content">
            <div class="subcapital-tips">
                <label><input type="checkbox" id="_checkAll">全选</label>
             请按照你企业${year }年1月1日至12月31日实际发生的股权变更信息进行<strong class="light">添加/修改</strong>
                <div class="fr edit">
                    <a href="javascript:void(0)" class="btn-edit" >修改</a>
                    <a href="javascript:void(0)" class="btn-delete">删除</a>
                </div>
            </div>
            <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                <thead>
                <tr>
                    <th width="60">序号</th>
                    <th width="310" class="bg">股东</th>
                    <th class="bg pos">变更前股权比例（%）
                        <div class="arrow-box">
                            <i class="icon-arrow-up order_by" data-order=" beTransAmPr asc "></i>
                            <i class="icon-arrow-down order_by" data-order=" beTransAmPr desc "></i>
                        </div>
                    </th>
                    <th class="bg pos">变更后股权比例（%）
                        <div class="arrow-box">
                            <i class="icon-arrow-up order_by" data-order=" afTransAmPr asc "></i>
                            <i class="icon-arrow-down order_by" data-order=" afTransAmPr desc "></i>
                        </div>
                    </th>
                    <th width="170" class="bg pos">
                        股权变更日期
                        <div class="arrow-box">
                            <i class="icon-arrow-up order_by" data-order=" altDate asc "></i>
                            <i class="icon-arrow-down order_by" data-order=" altDate desc "></i>
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

<div class="btn-box">
    <button id="js-save" class="btn-common btn-save">保存</button>
</div>

<%--查询参数值： table 当前年份 列表--%>
<form id="tody_params">
    <input type="hidden" name="year" value="${year}"/>
    <input type="hidden" name="priPID" value="${priPID}"/>
    <input type="hidden" id="_orderStr" name="orderStr" value=""/>
</form>



<jsp:include page="../../common/footer.jsp"></jsp:include>
<script id="tody-table-template" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td><input type="checkbox"  name="_checkbox" value="{{invAltID}}">{{num @index}}</td>
        <td>{{inv}}</td>
        <td>{{beTransAmPr}}</td>
        <td>{{afTransAmPr}}</td>
        <td>{{altDate}}</td>
    </tr>
    {{/each}}
</script>


<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/component/dropDown.js"/>"></script>
 
 <script src="<c:url value="/js/lib/require.js"/>"></script>
 <script src="<c:url value="/js/config.js"/>"></script>
 <script src="<c:url value="/js/reg/client/yr/stock/edit_main.js"/>"></script>
 

</body>
</html>