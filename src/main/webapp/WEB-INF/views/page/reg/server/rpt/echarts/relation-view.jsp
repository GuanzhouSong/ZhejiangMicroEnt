<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="hx" uri="/WEB-INF/tld/hx.tld"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>关系图</title>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body>
<!--  头部信息 start -->

<div class="header clearfix">
    <a href="#" class="logo fl">
        <img src="/img/syn/logo_js.png" alt="" class="fl"/>
        <h1 class="fl">
            浙江省企业信用综合监管警示系统
        </h1>
    </a>
</div>
<%--<jsp:include page="../../../../common/header.jsp"></jsp:include>--%>
<%--<script src="/js/business/index/index_main.js"></script>--%>
<!-- 头部信息 end  -->
<div class="clearfix reg-company-basic reg-company-basic-yellowish" style="margin-top: 2px;">
    <div class="clearfix reg-caption">
        <div class="title clearfix">
            <span class="name fl mr5">${midBaseInfo.entName}</span>
            <span class="${hx:yReportStyle(midBaseInfo.regState)}">${hx:publicStatus(midBaseInfo.regState)}</span>
            <span class="icon-rectangle blue fl mr10">${midBaseInfo.isIndivid=='1'?'个转企':''}</span>
        </div>
        <div class="clearfix">
            <p class="w360">
                <i class="book2-icon"></i>统一社会信用代码/注册号：<span>${!empty midBaseInfo.uniCode?midBaseInfo.uniCode:midBaseInfo.regNO}</span>
            </p>
                <i class="person-icon"></i>法定代表人：<span>${midBaseInfo.leRep}</span>
            </p>
        </div>
    </div>
</div>

<%--参数值--%>
<form id="js-params">
    <input type="hidden" name="entName" value="${midBaseInfo.entName}">
    <input type="hidden" name="corpid" value="${midBaseInfo.priPID}">
    <input type="hidden" name="isGxcsSlt" value="2" id="isGxcsSlt"> <!-- 默认层级：2 -->
    <input type="hidden" name="nodeType" value="" id="js-nodeType"> <!-- 关系类型 -->

    <%--   <input type="hidden" name="entName" value="浙江汇信科技有限公司">
   <input type="hidden" name="corpid" value="3300000000012888">
   <input type="hidden" name="isGxcsSlt" value="2" id="isGxcsSlt"> <!-- 默认层级：2 -->--%>

</form>

<div style="margin-top: 10px;text-align: center;clear: both;height: 32px;">
    <div style="float: left;">
        <input type="button" class="js-relation btn mr20"  value="关系网图"  data-layout="force" >
        <input type="button" class="js-relation btn mr20"  value="关系圈图"  data-layout="circular">
    </div>
    <div class="ipt-box col-1" style="float: left;">
        <select id="js-cengji">
            <option>--请选择层级--</option>
            <option value="1">一层</option>
            <option value="2">二层</option>
        </select>
    </div>

   <%-- <div class="ipt-box col-1" style="float: left;">
        <select id="js-people-type">
            <option>--请选择类型--</option>
            <option value="1">法定代表人关系</option>
            <option value="2">股东关系</option>
            <option value="3">高管关系</option>
        </select>
    </div>--%>

   <%-- <div style="float: left;height: 30px;line-height: 30px;font-size: 14px;">--%>
    <div style="clear: both; height: 30px;line-height: 30px;font-size: 14px;">
         &nbsp;提示：(线条箭头颜色关系)
        【股东关系(红色):<span style="color: #ff8686;font-size: 18px;vertical-align: middle;font-weight: bold;">→</span>】
        【高管关系(蓝色):<span style="color: #7575ff;font-size: 18px;vertical-align: middle;font-weight: bold;">→</span>】
        【法定代表人关系(褐色):<span style="color: #ab5555;font-size: 18px;vertical-align: middle;font-weight: bold;">→</span>】
        【既是法人代表也是高管关系(绿色):<span style="color: #94dfc2;font-size: 18px;vertical-align: middle;font-weight: bold;">→</span>】
    </div>
</div>


<!-- 显示图 -->
<div id="main_rel" style="width: auto;height: 800px;margin: 2px auto;"></div>

<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/server/rpt/echarts/relation-view.js"/>"></script>

</body>
</html>
