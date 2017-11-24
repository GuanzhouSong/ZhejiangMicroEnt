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
    <title>编辑${iDTypename}标签页面</title>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body>
<input id="iDName" type="hidden" value="${iDName}"/>
<input id="iDCode" type="hidden" value="${iDCode}"/>
<input id="iDType" type="hidden" value="${iDType}"/>
<div class="layer-bd">
    <div class="mass-distribution pd20">
       <div class="dominion clearfix">
            <div class="fr">
                <input type="text" placeholder="请输入关键字搜索" id="_key" class="ipt-txt fl">
                <input type="button" class="btn-search" id="qry">
            </div>
        </div>
        <div class="option-box clearfix">
            <div class="option-list h" id="option-list">
                <input id="checkAll" type="checkbox">全选</label>
              <c:set value="${fn:split(iDCode,',')}" var="iDCode"/>
                 <c:forEach var="p" items="${registMarks}" >
                  <div class="option-item"><label><input type="checkbox" name="_checkbox"

                   value="${p.markNo}"><span>${p.markName}</span></label></div>
                  </c:forEach>
               </div>
        </div>
        <div class="selected clearfix mb10">
            <div class="fl">已选择：</div>
            <div class="fl">
                <p id="iDNamep">${iDName}</p>
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
<script src="/js/reg/server/registinfo/addmark_edit.js"></script>
</body>
</html>