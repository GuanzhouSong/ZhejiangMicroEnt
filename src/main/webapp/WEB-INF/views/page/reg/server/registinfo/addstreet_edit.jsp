<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>编辑街道页面</title>
    <link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="/css/reg.server.css">

</head>
<body>
<input id="code" type="hidden" value="${code}"/>
<input id="content" type="hidden" value="${content}"/>
<input id="supCode" type="hidden" value="${supCode}"/>
<div class="layer-bd">
    <div class="mass-distribution pd20">
        <div class="dominion clearfix">
            <div class="fr">
                <input type="text" id="_key" placeholder="请输入关键字搜索" class="ipt-txt fl">
                <input type="button" class="btn-search" id="qry">
            </div>
        </div>
        <div class="option-box clearfix">
            <div class="col-6 h">
                <div class="mr40">
                    <div class="">
                        <ul class="ztree" id="permisionTree">
                    </div>
                </div>
            </div>
            <div id="optionlist" class="col-5 option-list ">

            </div>
        </div>
        <div class="selected clearfix mb10">
            <div class="fl">已选择：</div>
            <div class="fl" id="contentdiv">${content}</div>
        </div>
        <div class="center">
            <input id="save" type="button" class="btn mr20" value="确 定">
         <!--   <input type="button" class="btn mr20" value="清 空"> -->
            <input id="cancel" type="button" class="btn" value="关 闭">
        </div>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/registinfo/addstreet_edit.js"></script>
</body>
</html>