<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>统一开发框架2.0版</title>
    <link rel="shortcut icon" href="../img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/css/vendor/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css?v=0177205e80">
    <link rel="stylesheet" href="/css/vendor/layout-default-latest.css">
</head>
<body style="overflow: hidden; position: relative">
<div id="container">
    <div class="pane ui-layout-north"><jsp:include page="common/header.jsp"/></div>
    <div class="pane ui-layout-center">
        <div id="page-wrapper">
            <div class="content-tabs">
                <div class="page-tabs J_menuTabs">
                    <div class="page-tabs-content">
                        <a href="javascript:;" class="active J_menuTab" data-id="/admin/dashboard">首页</a>
                    </div>
                </div>
            </div>
            <div id="content-main" class="J_mainContent">
                <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="/admin/dashboard"
                        data-id="/admin/dashboard" frameborder="0"></iframe>
            </div>
        </div>
    </div>

    <div class="pane ui-layout-west">
        <div class="sidebar">
            <div class="sidebar-nav">
                <ul class="metismenu" id="menu">
                    <li class="active cur list-item">
                        <a href="/admin/dashboard" class="J_menuItem"><i
                                class="fa fa-lg fa-fw fa-home"></i> <span
                                class="menu-item-parent">首页</span></a>
                    </li>
                    <c:forEach var="menu_1" items="${menus['-1']}">
                        <li class="list-item">
                            <a href="${menu_1.url}"><i class="fa fa-lg fa-fw fa-cogs"></i> <span
                                    class="menu-item-parent">${menu_1.name}</span></a>
                            <c:if test="${!empty menus[menu_1.id]}">
                                <ul>
                                    <c:forEach var="menu_2" items="${menus[menu_1.id]}">
                                        <li><a href="${menu_2.url}" class="J_menuItem">${menu_2.name}</a></li>
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
<script src="/js/lib/require.js"></script>
<script src="/js/config.js?v=138f208b85"></script>
<script src="/js/business/index/index_main.js?v=2f4cf97651"></script>
</body>
</html>