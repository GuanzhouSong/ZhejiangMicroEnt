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
 
<!-- 年度对外投资信息 -->
<div class="mod caiwu">
       <div class="mod-hd" >
           <jsp:include page="../template/tab_template.jsp"></jsp:include>
        </div>
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
    </c:if>        <div class="content js-content-show js-table">
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

<!-- 添加年度对外投资信息 -->
<div class="mod mod-border investment-info js-content-show js-editUI mt10" >
    <div class="mod-hd">
        <div class="title">
            <h3>添加/修改${year}年度对外投资信息</h3>
            <div class="currency">币种：<strong class="light">人民币</strong></div>
            <p>对外投资信息请按照你企业截止${year }年12月31日的实际情况填写。</p>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content">
            <form class="form-horizontal error-bottom" id="forinvestForm">
                <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td class="odd focus-state" colspan="2">

                            <input type="hidden" id="outinvid" name="outinvid" value="" />
                            <input type="hidden" id="priPID" name="priPID" value="${priPID}" />
                            <input type="hidden" id="year" name="year" value="${year}" />
                            <input type="hidden" id="anCheID" name="anCheID" value="${anCheID}" />

                            <div class="item-name bg">对外投资企业统一社会信<br/>用代码（或注册号）</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="uniCode" name="uniCode" class="ipt-txt  ipt-txt-lg" placeholder="无统一社会信用代码则填写注册号" >
                                <i class="icon-close"></i>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd  focus-state" colspan="2">
                            <div class="item-name bg">投资设立（或购买股权）<br/>境内企业名称 </div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="entName" name="entName"  class="ipt-txt  ipt-txt-lg w-730" placeholder="请输入中国境内的企业名称" readonly>
                                <i class="icon-close"></i>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="4">
                            <em style="color: #FE9E0E;font-size: 14px;padding-left: 108px;">请按照企业截至${year}年12月31日的累计认缴和实缴出资额、累计认缴和实缴投资所占比例、累计各类认缴和实缴出资方式进行填写。</em>
                        </td>
                    </tr>

                    <tr>
                        <td class="odd  focus-state">
                            <div class="item-name">认缴投资总额</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="subConAm" name="subConAm"  onkeyup="" class="ipt-txt ipt-txt-lg ">
                                <i class="icon-close"></i>
                            </div>
                            <strong class="light">万元</strong>
                        </td>
                        <td class="even  focus-state">
                            <div class="item-name">认缴投资所占比例（%）</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="subConProp" name="subConProp" class="ipt-txt ipt-txt-lg">
                                <i class="icon-close"></i>
                            </div>
                            <%--<strong>%</strong>--%>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd" colspan="2">
                            <div class="item-name"><%--<i class="icon-question"></i>--%>
                                认缴投资方式</div>
                            <div class="radio-box ">
                                <c:forEach var="listOne" items="${codeList}" >
                                    <label><input type="checkbox" name="conForm" value="${listOne.code}" data-text="${listOne.content}" class="conForm">${listOne.content}</label>
                                </c:forEach>
                                <input type="hidden" id="select_subConForm" name="subConForm" value=""/>
                                <input type="hidden" id="select_conFormCN" name="conFormCN" value=""/><%--存中文--%>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td class="odd  focus-state">
                            <div class="item-name">实缴投资总额</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="acConAm"  name="acConAm" class="ipt-txt ipt-txt-lg ">
                                <i class="icon-close"></i>
                            </div>
                            <strong class="light">万元</strong>
                        </td>
                        <td class="even  focus-state">
                            <div class="item-name">实缴投资所占比例（%）</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="acConAmProp" name="acConAmProp" class="ipt-txt ipt-txt-lg">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td class="odd" colspan="2">
                            <div class="item-name"><%--<i class="icon-question"></i>--%>
                                实缴投资方式</div>
                            <div class="radio-box" id="_czfs">
                                <c:forEach var="listTow" items="${codeList}" >
                                    <label><input type="checkbox" name="_acConForm" value="${listTow.code}" data-text="${listTow.content}" class="_acConForm">${listTow.content}</label>
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


<!-- 年度对外投资信息表 -->
<div class="mod subcapital">
    <div class="mod-hd">
        <div class="title mt10">
            <h3>${year}年度对外投资信息</h3>
            <div class="btn-box">
                <a href="javascript:void(0)"  class="btn-common btn-add" >新增</a>
            </div>
        </div>
    </div>

    <div class="radio-box js-radio" style="margin: 6px 0">
        <label><input type="radio" name="touzhi" value="1">有对外投资</label>
        <label><input type="radio" name="touzhi" value="0">无对外投资</label>
    </div>

    <div class="mod-bd">
        <div class="content">
            <div class="subcapital-tips">
                <label><input type="checkbox" id="_checkAll">全选</label>
              系统默认显示你企业上年度填报信息，请比照你企业截止${year}年的实际情况进行<strong class="light">添加/修改</strong>
                <div class="fr edit">
                    <a href="javascript:void(0)" class="btn-edit" >修改</a>
                    <a href="javascript:void(0)" class="btn-delete">删除</a>
                </div>
            </div>
            <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                <thead>
                <tr>
                    <th width="50">序号</th>
                    <th width="150" class="bg">对外投资企业统一社会<br/>信用代码（或注册号）</th>
                    <th width="200" class="bg">投资设立（或购买股权）<br/>境内企业名称</th>
                    <th width="80" class="pos">
                        认缴投资<br/>(总额)
                        <div class="arrow-box">
                            <i class="icon-arrow-up order_by" data-order=" subConAm asc "></i>
                            <i class="icon-arrow-down order_by" data-order=" subConAm desc "></i>
                        </div>
                    </th>
                    <th width="80" class="pos">
                        认缴投资<br/>(方式)
                        <div class="arrow-box">
                            <i class="icon-arrow-up order_by" data-order=" subConForm asc "></i>
                            <i class="icon-arrow-down order_by" data-order=" subConForm desc "></i>
                        </div>
                    </th>
                    <th width="120" class="pos">
                        认缴投资总额<br/>占比例(%)
                        <div class="arrow-box">
                            <i class="icon-arrow-up order_by" data-order=" subConProp asc "></i>
                            <i class="icon-arrow-down order_by" data-order=" subConProp desc "></i>
                        </div>
                    </th>
                    <th width="80" class="pos">
                        实缴投资<br/>(总额)
                        <div class="arrow-box">
                            <i class="icon-arrow-up order_by" data-order=" acConAm asc "></i>
                            <i class="icon-arrow-down order_by" data-order=" acConAm desc "></i>
                        </div>
                    </th>
                    <th width="80" class="pos">
                        实缴投资<br/>(方式)
                        <div class="arrow-box">
                            <i class="icon-arrow-up order_by" data-order=" acConForm asc "></i>
                            <i class="icon-arrow-down order_by" data-order=" acConForm desc "></i>
                        </div>
                    </th>
                    <th width="120" class="pos">
                        实缴投资总额<br/>占比例(%)
                        <div class="arrow-box">
                            <i class="icon-arrow-up order_by" data-order=" acConAmProp asc "></i>
                            <i class="icon-arrow-down order_by" data-order=" acConAmProp desc "></i>
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

<div class="btn-box">
    <button id="js-save" class="btn-common btn-save">保存</button>
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

<jsp:include page="../../common/footer.jsp"></jsp:include>

<%-- table 上一年 列表--%>
<script id="last-table-template" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{num @index}}</td>
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
        <td><input type="checkbox" name="_checkbox" value="{{outinvid}}">{{num @index}}</td>
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
 

<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/component/dropDown.js"/>"></script>

<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/client/yr/forinvest/edit_main.js"/>"></script>
</body>
</html>