<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>协同首页</title>
    <link rel="shortcut icon" href="../img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/layout-default-latest.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body style="overflow: hidden; position: relative">
<jsp:include page="common/header.jsp"/>
<div id="container">
    <div class="pane ui-layout-center">
        <div id="page-wrapper">
            <div class="content-tabs mt10">
                <div class="page-tabs  J_menuTabs">
                    <div class="page-tabs-content">
                        <em class="tab-close js-closeAll-tab"><i class="xbt-icon"></i></em>
                        <em class="flex pos-rel">
                        </em>
                        <a href="javascript:void(0);" class="J_menuTab active" data-id="/admin/dashboard"
                           style="border-left: 0;">首页</a>
                    </div>
                </div>
            </div>
            <div id="content-main" class="J_mainContent">
                <iframe class="J_iframe" name="iframe0" width="100%" height="100%"
                        src="/syn/system/bulletin/list"
                        data-id="/admin/dashboard" frameborder="0"></iframe>
            </div>
            <div class="footer">
                版权所有：浙江省工商行政管理局<span class="ml40">技术支持：浙江汇信科技有限公司</span><span class="ml40">客服 400-888-4636</span><span
                    class="ml40">技术 0571-88234769</span>
            </div>
        </div>
    </div>

    <div class="pane ui-layout-west">
        <div class="nano">
            <div class="nano-content">
                <div class="sidebar">
                    <div class="sidebar-nav">
                        <div class="search-box-panel">
                            <div class="search-box-menu clearfix">
                                <input type="text" placeholder="功能搜索" id="key-word" class="ipt-txt js-search-input">
                                <a href="javascript:void(0);" class="search-btn xbt-icon js-search-btn"></a>
                            </div>
                            <ul class="search-result-list js-search-result-list" id="rltMenuItem" style="display: none;">
                            </ul>
                        </div>
                        <ul id="side-menu" class="metismenu">
                            <c:forEach var="menu_1" items="${menus['-1']}">
                                <li class="list-item">
                                    <a href="javascript:void(0)"><span class="nav-arrow"></span> <span
                                            class="nav-label" title="${menu_1.name}">${menu_1.name}</span></a>

                                    <c:if test="${!empty menus[menu_1.id]}">
                                        <ul class="nav nav-second-level collapse">

                                            <c:forEach var="menu_2" items="${menus[menu_1.id]}">

                                                <c:if test="${empty menus[menu_2.id]}"> <%--不存在三级目录 则二级目录触发--%>
                                                    <li><a class="J_menuItem" data-index="${menu_2.id}" title="${menu_2.name}" href="${menu_2.url}"
                                                    >${menu_2.name}</a></li>
                                                </c:if>

                                                <c:if test="${!empty menus[menu_2.id]}"> <%--存在三级目录 则二级目录不触发 三级目录触发--%>
                                                    <li>
                                                        <a href="javascript:void(0)" title="${menu_2.name}"> <span class="nav-arrow"></span>${menu_2.name}</a>
                                                        <ul class="nav nav-third-level collapse">
                                                            <c:forEach var="menu_3" items="${menus[menu_2.id]}">
                                                                <li><a class="J_menuItem" data-index="${menu_3.id}" title="${menu_3.name}" href="${menu_3.url}"
                                                                >${menu_3.name}</a></li>
                                                            </c:forEach>
                                                        </ul>

                                                    </li>
                                                </c:if>

                                            </c:forEach>
                                        </ul>
                                    </c:if>

                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script id="tpl" type="text/x-handlebars-template">
    {{#each menus}}
    <li data-index="{{id}}">{{name}}</li>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/index/index_main.js"></script>

</body>
</html>