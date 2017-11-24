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
    <title>年报对外担保情况页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>

<!-- 头部  start-->
<jsp:include page="../../common/reportheader.jsp"></jsp:include>


<div class="fold-msg-bg js-fold-msg">
    <jsp:include page="../template/view_template.jsp"></jsp:include>
</div>
<!-- 头部  end-->



<%--隐藏域的值 start--%>

<%--当前年报的状态：--%>
<input type="hidden" id="_reportState" value="${yrRegCheck.reportState}">


<input type="hidden" id="_year"  value="${year}" />
<input type="hidden" id="_priPID" value="${priPID}" />
<%--隐藏域的值 end--%>




<!-- 对外担保信息 -->
<div class="mod caiwu">
    <div class="mod-hd" >
        <jsp:include page="../template/tab_template.jsp"></jsp:include>
    </div>

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
        </c:if>


        <div class="content js-content-show js-table" >
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
    </div>
</div>

<!-- 添加对外担保信息 -->
<div class="mod mod-border investment-info js-content-show js-editUI mt10">
    <div class="mod-hd">
        <div class="title">
            <h3>添加/修改${year}年对外担保信息</h3>
            <div class="currency">币种：<strong class="light">人民币</strong></div>
            <p>对外担保信息请按照你企业截止${year}年12月31日的实际情况填写。</p>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content">
            <form class="form-horizontal error-bottom" id="forguaranteeForm" >
                <input type="hidden" id="moreID" name="moreID" value="" />
                <input type="hidden" id="priPID" name="priPID" value="${priPID}" />
                <input type="hidden" id="year" name="year" value="${year}" />
                <input type="hidden" id="anCheID" name="anCheID" value="${anCheID}" />
                <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name bg">债权人</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="more" name="more" value="" class="ipt-txt  ipt-txt-lg" placeholder="请输入债权人姓名或者企业名称">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td class="even focus-state">
                            <div class="item-name bg">主债权种类
                            </div>
                            <div class="radio-box">
                                <label><input type="radio"  name="priClaSecKind" value="1">合同</label>
                                <label><input type="radio"  name="priClaSecKind" value="2">其它</label>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name bg">债务人</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="mortgagor" name="mortgagor" value="" class="ipt-txt  ipt-txt-lg" placeholder="请输入债务人姓名或者企业名称">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <td class="even focus-state">
                            <div class="item-name bg">保证的期间
                            </div>
                            <div class="radio-box">
                                <label><input type="radio" name="guaPeriod" value="1">期间</label>
                                <label><input type="radio" name="guaPeriod" value="2">未约定</label>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name bg">主债权数额</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="priClaSecAm" name="priClaSecAm" value="" class="ipt-txt ipt-txt-lg million_yuan">
                                <i class="icon-close"></i>
                            </div>
                            <strong class="light">万元</strong>
                        </td>
                        <td class="even focus-state">
                            <div class="item-name bg">保证的方式</div>
                            <div class="radio-box">
                                <label><input type="radio" name="gaType" value="1">一般保证</label>
                                <label><input type="radio" name="gaType" value="2">连带保证</label>
                                <label><input type="radio" name="gaType" value="3">未约定</label>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name bg">履行债务的期限始</div>
                            <div class="ipt-box">
                                <input type="text" id="pefPerForm" name="pefPerForm" class="ipt-txt ipt-txt-lg laydate-icon" readonly="readonly">
                              <%--  <i class="icon-close"></i>--%>
                            </div>
                        </td>
                        <td class="even focus-state">
                            <div class="item-name bg">履行债务的期限止</div>
                            <div class="ipt-box">
                                <input type="text" id="pefPerTo" name="pefPerTo" class="ipt-txt ipt-txt-lg laydate-icon" readonly="readonly">
                               <%-- <i class="icon-close"></i>--%>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name bg">保证担保的范围</div>
                            <div class="radio-box">
                                <label><input type="checkbox" name="gaRanges" value="1" data-text="主债权">主债权</label>
                                <label><input type="checkbox" name="gaRanges" value="2" data-text="利息">利息</label>
                                <label><input type="checkbox" name="gaRanges" value="3" data-text="违约金">违约金</label>
                                <label><input type="checkbox" name="gaRanges" value="4" data-text="损害赔偿金">损害赔偿金</label>
                                <label><input type="checkbox" name="gaRanges" value="5" data-text="实现债权的费用">实现债权的费用</label>
                                <label><input type="checkbox" name="gaRanges" value="6" data-text="其他约定">其他约定</label>
                                <input type="hidden" id="select_gaRange" name="gaRange" value="" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name bg">是否公示</div>
                            <div class="radio-box">
                                <label><input type="radio" name="isPubFlag" value="1">公示</label>
                                <label><input type="radio" name="isPubFlag" value="0">不公示</label>
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


<%--弹出框--%>
<div class="mod mod-border investment-info js-content-show js-upload mt10">
    <div class="forguarantee-lead">
        <h6 class="download" style="text-align: left;">
            <a  href="<c:url value="/reg/client/yr/ent/forguarantee/file_down"/>" ><b class="download-ico"></b>下载本站EXCEL模版</a>
        </h6>
        <div class="state pos-rel">
            <span>说明：</span>
            <p>1、导入数据时请先下载EXCEL导入模版；</p>
            <p>2、下载导入模板后请按照导入模板格式和内容要求完成导入信息的填录；</p>
            <p>3、使用非本系统提供的导入模板或擅自修改导入模板的格式和内容会导致操作不成功。</p>
        </div>
        <div class="lead-file">
            <label>导入EXCEL文件</label>
            <form id="file_import" enctype="multipart/form-data" method="post">
                <div class="ipt-box">
                    <input type="file" id="js-file" name="file"  class="ipt-txt ipt-txt-lg">
                    <input type="hidden" name="anCheID" value="${anCheID}">
                    <input type="hidden" name="year"  value="${year}" />
                    <input type="hidden" name="priPID" value="${priPID}" />
                </div>
                <input type="button" class="btn js-import" value="导入">
            </form>


        </div>
    </div>
    <div style="text-align: center;"><input type="button" class="_cancel btnCancel" value="关闭"></div>
</div>





<!-- 年度对外担保信息表 -->
<div class="mod subcapital mt10">
    <div class="mod-hd ">
        <div class="title">
            <h3>${year}年度对外担保信息</h3>
                <div class="btn-box">
                <a href="#" class="btn-common btn-add">新增</a>
                <a href="#" class="links-import">批量导入</a>
            </div>
        </div>
    </div>

    <div class="radio-box js-radio" style="margin: 6px 0">
        <label><input type="radio" name="danbao" value="1">有对外担保</label>
        <label><input type="radio" name="danbao" value="0">无对外担保</label>
    </div>

    <div class="mod-bd">
        <div class="content">
            <div class="subcapital-tips">
                <label><input type="checkbox" id="_checkAll">全选</label>
                系统默认显示你企业上年度填报信息，请比照你企业截止${year}年12月31日的实际情况进行<strong class="light">添加/修改</strong>。
                <div class="fr edit">
                    <a href="javascript:void(0)" class="btn-edit" >修改</a>
                    <a href="javascript:void(0)" class="btn-delete">删除</a>
                </div>
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



<div class="btn-box">
    <button id="save" class="btn-common btn-save">保存</button>
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
</div>



<jsp:include page="../../common/footer.jsp"></jsp:include>



<%-- table 上一年 列表--%>
<script id="last-table-template" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{num @index}}</td>
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

<%-- table 当前年份列表--%>
<script id="tody-table-template" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td><input type="checkbox" name="_checkbox" value="{{moreID}}">{{num @index}}</td>
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



<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/component/dropDown.js"/>"></script>


<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/client/yr/forguarantee/edit_main.js"/>"></script>




</body>
</html>
