<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>网站信息详情页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>
	<c:if test="${yrWebsiteInfo.webType == '1' }">
	<c:if test="${yrWebsiteInfo.webSmallType == '1' }">
		<div class="deal-layer">
	    <div class="mod-bd">
	        <ul class="deal-list">
	            <li><label>网站类型：</label>网络交易平台</li>
	            <li><label>平台名称：</label>${yrWebsiteInfo.webSitName}</li>
	            <li><label>网址：</label>${yrWebsiteInfo.webSite}</li>
	            <li><label>网络交易平台运营类型：</label>${yrWebsiteInfo.webPlatFormType}</li>
	            <li><label>网络交易产品类型：</label>${yrWebsiteInfo.webGoodsType}</li>
	            <li><label>电商类型：</label>${yrWebsiteInfo.eCommerceType}</li>
	            <li><label>ICP证号/备案号：</label>${yrWebsiteInfo.icpBackNO}</li>
	            <li><label>微信公众服务号：</label>${yrWebsiteInfo.weChatPublicNO}</li>
	            <li><label>APP软件名称：</label>${yrWebsiteInfo.appNames}</li>
	            <li>
	                <label></label>
	                <input type="button" value="确 定" class="btn-common btn-sure">
	            </li>
	        </ul>
	    </div>
	</div>
	</c:if>
	<c:if test="${yrWebsiteInfo.webSmallType == '2' }">
		<div class="deal-layer">
	    <div class="mod-bd">
	        <ul class="deal-list">
	            <li><label>网站类型：</label>企业信息网</li>
	            <li><label>平台名称：</label>${yrWebsiteInfo.webSitName}</li>
	            <li><label>网址：</label>${yrWebsiteInfo.webSite}</li>
	            <li><label>ICP证号/备案号：</label>${yrWebsiteInfo.icpBackNO}</li>
	            <li>
	                <label></label>
	                <input type="button" value="确 定" class="btn-common btn-sure">
	            </li>
	        </ul>
	    </div>
	</div>
	</c:if>
	</c:if>
	<c:if test="${yrWebsiteInfo.webType == '2' }">
	<div class="deal-layer">
	    <div class="mod-bd">
	        <ul class="deal-list">
	            <li><label>平台名称：</label>${yrWebsiteInfo.webSitName}</li>
	            <li><label>网址：</label>${yrWebsiteInfo.webSite}</li>
	            <li><label>所属平台名称：</label>${yrWebsiteInfo.belongPlatFormName}</li>
	            <li><label>发货地址：</label>${yrWebsiteInfo.sendAddress}</li>
	            <li><label>退货地址：</label>${yrWebsiteInfo.backAddress}</li>
	            <li>
	                <label></label>
	                <input type="button" value="确 定" class="btn-common btn-sure">
	            </li>
	        </ul>
	    </div>
	</div>
	</c:if>


<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/client/yr/other/otherwebsite_detail.js"/>"></script>
</body>
</html>
