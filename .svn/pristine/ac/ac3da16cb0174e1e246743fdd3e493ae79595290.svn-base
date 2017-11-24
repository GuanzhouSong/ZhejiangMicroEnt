<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>股东列表选择</title>
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body class="pd10">
    <input  id="input_text" class="tree-box-searcher"  placeholder="输入关键字进行检索">

    <input type="button" id="input_search" class="tree-box-searcher-btn btn-common"  value="检索">

    <p id="msg-info" style="color: red;font-size: 14px;text-align: center;"></p>

    <div style="min-height:300px;margin-top: 10px;" id="radioContent">
        <c:forEach var="inv" items="${midInvList}">
            <div style="margin-top: 2px;margin-bottom: 2px;">
                <label style="line-width:215px;width: 255px;" >
                    <input  name="midInvIds" type="radio" class="textContent"
                            id="${inv.id}" data-inv="${inv.inv}" data-cerno="${inv.cerNO}" data-invtype="${inv.invType}" data-blicno="${inv.bLicNO}" value="${inv.inv}"/>
                            <span>${inv.inv}</span>
                </label>
            </div>
        </c:forEach>
    </div>
    <p class="center mt10 mb10">
        <input type="button" id="save"  class="btn mr20" value="确 定"     style="background: #4786c8;border:1px solid #3b75b2"/>
        <input type="button" id="cancel" class="btn"     value="取 消"     style="background: #4786c8;border:1px solid #3b75b2" />
    </p>
</form>
 
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/client/im/investment/mid_inv_select.js"/>"></script>
</body>
</html>