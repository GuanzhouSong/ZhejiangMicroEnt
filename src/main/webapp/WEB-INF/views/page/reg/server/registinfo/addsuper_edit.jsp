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
    <meta http-equiv="X-UA-Compatible" content="IE=8">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>编辑监管项目页面</title>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body>
<input id="superNoNames" type="hidden" value="${superNoNames}"/>
<input id="superNos" type="hidden" value="${superNos}"/>
<input id="superType" type="hidden" value="${superType}"/>
<div class="layer-bd">
    <div class="mass-distribution pd20">
        <div class="dominion clearfix">
            <div class="fr">
                <input type="text" placeholder="请输入关键字搜索" id="_key" class="ipt-txt fl">
                <input type="button" class="btn-search" id="qry">
            </div>
        </div>
        <div class="option-box clearfix">
            <div class="option-list h">

                <c:set value="${fn:split(superNos,',')}" var="superNos"/>
                <input id="checkAll" type="checkbox">全选</label>
                <c:forEach var="p" items="${superItems}" >
                 <div class="option-item"><label><input type="checkbox" name="_checkbox"

                  value="${p.superNO}"><span>${p.superName}</span></label></div>
                 </c:forEach>
               </div>
        </div>
        <div class="selected clearfix mb10">
            <div class="fl">已选择：</div>
            <div class="fl">
                <p id="superNoNamesp">${superNoNames}</p>
            </div>

        </div>
        <div class="center">
            <input id="save" type="button" class="btn mr20" value="确 定">
            <input id="cancel" type="button" class="btn" value="关 闭">
        </div>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/registinfo/addsuper_edit.js"></script>
</body>
</html>