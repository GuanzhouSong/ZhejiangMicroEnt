<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--//内外资公司法人（股份有限公司）--%>
<c:set var="entTypeLTD"
       value="1200,1210,1211,1212,1213,1219,1220,1221,1222,1223,1229,5200,5210,5220,5230,5240,5290,6200,6210,6220,6230,6240,6250,6260,6270,6280,6290"/>
<c:set var="entType" value="${sessionScope.midBaseInfoDto.entType}"/>
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
<!-- 头部  start-->
<jsp:include page="../../common/reportheader.jsp"></jsp:include>


<div class="fold-msg-bg js-fold-msg">
    <jsp:include page="../template/view_template.jsp"></jsp:include>
</div>
<!-- 头部  end-->


<%--当前年报的状态：--%>
<input type="hidden" id="_reportState" value="${yrRegCheck.reportState}">
<input type="hidden" id="_year" value="${year}"/>
<input type="hidden" id="_priPID" value="${priPID}"/>

<!-- 企业财务信息 -->
<div class="mod caiwu">

    <div class="mod-hd">
        <jsp:include page="../template/tab_template.jsp"></jsp:include>
    </div>

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
        </c:if>

        <div class="content js-content-show js-table">
            <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                <thead>
                <tr>
                    <th width="50">序号</th>
                    <th width="96" class="bg">
                        <c:if test="${fn:indexOf(entTypeLTD,entType) == -1}">发起人</c:if>
                        <c:if test="${fn:indexOf(entTypeLTD,entType) != -1}">股东</c:if>
                    </th>
                    <th width="150">证照号码</th>
                    <th width="98"  class="bg">认缴出资额<br/><strong class="light">(${(year-1)>2015?midBaseInfoDto.currencyCn:'元人民币'})</strong></th>
                    <th width="118" class="bg">出资方式<br/>（认缴）</th>
                    <th width="108" class="bg">认缴出资日期</th>
                    <th width="100" class="bg">实缴出资额<br/><strong class="light">(${(year-1)>2015?midBaseInfoDto.currencyCn:'元人民币'})</strong></th>
                    <th width="120" class="bg">出资方式<br/>（实缴）</th>
                    <th class="bg">实缴出资日期</th>
                </tr>
                </thead>
                <tbody id="last_list">
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
    </div>
</div>

<!-- 股东出资信息 -->
<div class="mod mod-border investment-info js-content-show js-editUI mt10"><%--style="display: block;" 测试完需要拿掉--%>
    <div class="mod-hd">
        <div class="title">
            <h3>添加/修改${year}年出资信息</h3>
            <div class="currency">币种：<strong class="light">
             ${year>2015?midBaseInfoDto.currencyCn:'元人民币'}
            </strong></div>
            <%-- <p>认缴出资信息请按照企业章程中该股东（发起人）的所有认缴出资总额、最末次认缴出资日期、各类认缴出资方式进行填写。”“实缴出资信息请按照该股东截止${year}年12月31日的累计实缴出资额、最后一次实缴出资日期、各类实缴出资方式进行填写。</p>--%>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content">
            <form class="form-horizontal error-bottom" id="subcapitalForm">
                <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                    <tbody>

                    <tr>
                        <td colspan="4">
                            <em style="color: #FE9E0E;font-size: 14px;padding-left: 18px;">每一个股东（发起人）的出资信息只需填报一条，股东（发起人）的认缴信息应与企业章程约定一致；股东（发起人）认缴和实缴出资额为截至${year}年度12月31日的累计数额，其中外商投资企业认缴和实缴出资额的币种与注册资本一致；认缴和实缴出资时间为截至${year}年度12月31日最后一次认缴和实缴时间，出资方式可以多选。</em>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state" colspan="2">
                            <input type="hidden" id="invID" name="invID" value=""/>
                            <input type="hidden" id="priPID" name="priPID" value="${priPID}"/>
                            <input type="hidden" id="year" name="year" value="${year}"/>
                            <input type="hidden" id="anCheID" name="anCheID" value="${anCheID}"/>

                            <div class="item-name bg">股东（发起人）</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="inv" name="inv" value="" class="ipt-txt w-650"
                                       placeholder="请从列表中选择股东（发起人），列表以外的股东（发起人）请直接输入">
                                <i class="icon-close"></i>
                            </div>
                            <input type="button" name="gd" class="btn-common js-inv-list" value="股东列表">
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name">证照号码</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="invRegNO" name="invRegNO" value="" class="ipt-txt w-650"
                                       placeholder="请输入自然人股东的身份证号码或法人股东的统一社会信用代码（注册号）" readonly>
                                <i class="icon-close"></i>
                            </div>
                        </td>
                    </tr>

                    <%--
                    <tr>
                        <td colspan="4">
                            <em style="color: #FE9E0E;font-size: 14px;padding-left: 20px;">认缴出资信息请按照企业章程中该股东的所有认缴出资总额、最末次认缴出资日期、各类认缴出资方式进行填写。</em>
                        </td>
                    </tr>
                    --%>

                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name bg">
                                <%-- <i class="icon-question" id="rj_cze" data-id="rj_cze" data-msg="外币出资情况请按照你企业注册资本登记时的汇率折算为对应的人民币认缴出资额" ></i>--%>
                                认缴出资额
                            </div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="lisubconam" name="lisubconam" value=""
                                       class="ipt-txt ipt-txt-lg million_yuan" placeholder="请输入贵企业认缴出资额">
                                <i class="icon-close"></i>
                            </div>
                            <strong class="light">万</strong>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name bg">认缴出资日期</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="subConDate" name="subConDate" value=""
                                       class="ipt-txt ipt-txt-lg laydate-icon" readonly="readonly">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name bg">认缴出资方式</div>
                            <div class="radio-box">
                                <c:forEach var="listOne" items="${codeList}">
                                    <label><input type="checkbox" name="conForm" value="${listOne.code}"
                                                  data-text="${listOne.content}" class="conForm">${listOne.content}
                                    </label>
                                </c:forEach>
                                <input type="hidden" id="select_subConForm" name="subConForm" value=""/>
                                <input type="hidden" id="select_conFormCN" name="conFormCN" value=""/><%--存中文--%>
                            </div>
                        </td>
                    </tr>

                    <%--
                      <tr>
                          <td colspan="4">
                              <em style="color: #FE9E0E;font-size: 14px;padding-left: 20px;">实缴出资信息请按照股东截止${year}年12月31日的累计实缴出资额、最后一次实缴出资日期、各类实缴出资方式进行填写。</em>
                          </td>
                      </tr>
                    --%>

                    <tr>
                        <td class="even focus-state">
                            <div class="item-name bg">
                                <%-- <i class="icon-question" id="sj_cze" data-id="sj_cze" data-msg="外币出资情况请按照你企业注册资本登记时的汇率折算为对应的人民币实缴出资额" ></i>--%>
                                实缴出资额
                            </div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="liacconam" name="liacconam" value=""
                                       class="ipt-txt ipt-txt-lg million_yuan" placeholder="未发生的实缴出资请填写0">
                                <i class="icon-close"></i>
                            </div>
                            <strong class="light">万</strong>
                        </td>

                        <td class="even focus-state">
                            <div class="item-name bg">实缴出资日期</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="acConDate" name="acConDate" value=""
                                       class="ipt-txt ipt-txt-lg laydate-icon" readonly="readonly" placeholder="">
                                <input type="text" id="_acConDate" class="ipt-txt ipt-txt-lg " readonly="readonly"
                                       disabled="disabled">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name bg">实缴出资方式</div>
                            <div class="radio-box" id="_czfs">
                                <c:forEach var="listTow" items="${codeList}">
                                    <label><input type="checkbox" name="_acConForm" value="${listTow.code}"
                                                  data-text="${listTow.content}" class="_acConForm">${listTow.content}
                                    </label>
                                </c:forEach>
                                <input type="hidden" id="select_acConForm" name="acConForm" value=""/>
                                <input type="hidden" id="select_acConFormCn" name="acConFormCn" value=""/><%--存中文--%>
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

<!-- 股东出资表 -->
<div class="mod subcapital">
    <div class="mod-hd">
        <div class="title mt10">
            <h3>${year}年度股东出资信息</h3>
            <div class="btn-box">
                <a href="javascript:void(0)" class="btn-common btn-add js-btn-add">新增</a>
            </div>
        </div>

        <div class="focus-state pd10 js-search_subcaptial">
            <div class="ipt-box js-ipt-box">
                <input type="text" id="subcapita_value" class="ipt-txt w-650" value="" placeholder="请输入股东/发起人姓名或证照号码">
                <i class="icon-close"></i>
            </div>
            <button id="search_subcaptial" class="btn-common btn-add h30">搜索</button>
        </div>

    </div>
    <div class="mod-bd">
        <div class="content">
            <div class="subcapital-tips">
                <label><input type="checkbox" id="_checkAll">全选</label>
                系统默认显示你企业上年度填报信息，请比照你企业截止${year}年12月31日的实际情况进行<strong class="light">添加/修改。</strong>
                <div class="fr edit">
                    <a href="javascript:void(0)" class="btn-edit">修改</a>
                    <a href="javascript:void(0)" class="btn-delete">删除</a>
                </div>
            </div>
            <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                <thead>
                <tr>
                    <th width="50">序号</th>
                    <th width="96" class="bg">
                        <c:if test="${fn:indexOf(entTypeLTD,entType) == -1}">发起人</c:if>
                        <c:if test="${fn:indexOf(entTypeLTD,entType) != -1}">股东</c:if>
                    </th>
                    <th width="150">证照号码</th>
                    <th width="98" class="bg pos">认缴出资额<br/><strong class="light">(${year>2015?midBaseInfoDto.currencyCn:'元人民币'})</strong>
                        <div class="arrow-box">
                            <i class="icon-arrow-up order_by" data-order=" lisubconam asc "></i>
                            <i class="icon-arrow-down order_by" data-order=" lisubconam desc "></i>
                        </div>
                    </th>
                    <th width="118" class="bg">出资方式<br/>（认缴）</th>
                    <th width="108" class="bg">认缴出资日期</th>
                    <th width="100" class="bg pos">
                        实缴出资额<br/><strong class="light">(${year>2015?midBaseInfoDto.currencyCn:'元人民币'})</strong>
                        <div class="arrow-box pos">
                            <i class="icon-arrow-up order_by" data-order=" liacconam asc "></i>
                            <i class="icon-arrow-down order_by" data-order=" liacconam desc "></i>
                        </div>
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
                <div id="tody_pagination" class="pagination">

                </div>
            </div>
        </div>
    </div>
</div>
<div class="btn-box">
    <button id="js-save" class="btn-common btn-save">保存</button>
</div>

</div>


<%--查询参数值： table 上一年 列表--%>
<form id="last_params">
    <input type="hidden" name="year" value="${year-1}"/>
    <input type="hidden" name="priPID" value="${priPID}"/>
    <input type="hidden" name="orderStr" value=""/>
</form>

<%--查询参数值： table 当前年份 列表--%>
<form id="tody_params">
    <input type="hidden" name="year" value="${year}"/>
    <input type="hidden" name="priPID" value="${priPID}"/>
    <input type="hidden" id="_orderStr" name="orderStr" value=""/>
    <input type="hidden" id="key_value" name="keyValue" value="">
</form>

<jsp:include page="../../common/footer.jsp"></jsp:include>

<%-- table 上一年 列表--%>
<script id="last-table-template" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{num @index}}</td>
        <td>{{inv}}</td>
        <td>{{invRegNO}}</td>
        <td>{{lisubconam}}<strong class="light">万</strong></td>
        <td>{{textFormat subConForm}}</td>
        <td>{{subConDate}}</td>
        <td>{{liacconam}}<strong class="light">万</strong></td>
        <td>{{textFormat acConForm}}</td>
        <td>{{acConDate}}</td>
    </tr>
    {{/each}}
</script>

<%-- table 当前年份列表--%>
<script id="tody-table-template" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td><input type="checkbox" name="_checkbox" value="{{invID}}">{{num @index}}</td>
        <td>{{inv}}</td>
        <td>{{invRegNO}}</td>
        <td>{{lisubconam}}<strong class="light">万</strong></td>
        <td>{{textFormat subConForm}}</td>
        <td>{{subConDate}}</td>
        <td>{{liacconam}}<strong class="light">万</strong></td>
        <td>{{textFormat acConForm}}</td>
        <td>{{acConDate}}</td>
    </tr>
    {{/each}}

</script>


<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/component/dropDown.js"/>"></script>

<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/client/yr/subcapital/edit_main.js"/>"></script>

</body>
</html>
