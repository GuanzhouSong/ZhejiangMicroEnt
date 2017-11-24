<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>在线录入</title>
    <link rel="stylesheet" href="/css/pub-syn.css">
</head>
<body class="outer-bg">
<jsp:include page="../common/header.jsp"></jsp:include>
<div class="mod clearfix">
    <jsp:include page="../common/menu.jsp?module=zxlr&menu=zxlr"></jsp:include>
    <div class="main">
        <div class="crumbs">
            <a href="<c:url value='/depsyn/index'/>">首页</a> &gt;
            <a href="<c:url value='/depsyn/index'/>">信息提供</a> &gt;
            <a href="javascript:void(0)" class="cur">在线录入</a>
        </div>
        <div class="pdlr5">
            <div class="tab">
                <li><a href="<c:url value='/depsyn/punish/index'/>">行政处罚信息</a></li>
                <li><a href="<c:url value='/depsyn/license/index'/>">行政许可信息</a></li>
                <li><a href="<c:url value='/depsyn/spot/index'/>">抽查检查结果</a></li>
                <li><a href="<c:url value='/depsyn/small/index'/>" class="cur">小微企业扶持信息</a></li>
                <li><a href="<c:url value='/depsyn/compun/index'/>">联合惩戒信息</a></li>
                <li><a href="<c:url value='/depsyn/notice/index'/>">部门公告</a></li>
            </div>
            <div class="panel-bd">
                <form id="searchForm">
                    <div class="tips">正在填报：小微企业扶持信息</div>
                    <div class="search-box">
                        <input id="js-keyword" name="keyword" type="text" placeholder="输入《企业名称》、《注册号》、《统一社会信用代码》为检索的关键字"
                               class="ipt-txt">
                        <input id="js-search" type="button" value="搜索" class="ipt-btn">
                    </div>
                </form>
            </div>
            <div id="js-result" class="none">
                <div class="company-info">
                    <label id="js-company-name"></label>
                    注册号/统一社会信用代码：<span id="js-company-id"></span>
                </div>
                <input id="js-add" type="button" value="添加" class="ipt-btn fr mr20 mb3">
                <table cellpadding="0" cellspacing="0" class="table-common">
                    <thead>
                    <tr>
                        <th width="76">序号</th>
                        <th width="180">部门</th>
                        <th width="192">扶持内容</th>
                        <th width="186">扶持日期</th>
                    </tr>
                    </thead>
                    <tbody id="js-list-content">
                    </tbody>
                </table>
                <div class="notice-pagination-box clearfix">
                    <span class="page-total">共查询到
                        <em id="js-total"></em> 条信息，共
                        <em id="js-pageTotal"></em> 页
                    </span>
                    <div class="pagination">
                    </div>
                </div>
            </div>
            <div id="js-no-result" class="none no-result">
                没有查询到对应企业
            </div>
        </div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
<script id="listTemplate" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{id}}</td>
        <td>{{depName}}</td>
        <td>{{helpContent}}</td>
        <td>{{helpDate}}</td>
    </tr>
    {{/each}}
</script>
<script src="/js/depsyn/small/small_main.js"></script>
</body>
</html>