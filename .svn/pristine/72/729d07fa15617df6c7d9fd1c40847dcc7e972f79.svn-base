<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="renderer" content="webkit">
	<meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <title></title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<style type="text/css">
.frecss{background-color: #f4f4f5;}
</style>
<body class="pd10">
<div>
    <div class="" >
             <input type="hidden" id="userType" value="${userType }">
            <input type="hidden" id="priPID" name="priPID" value="${pubOtherpunish.priPID}">
            <input type="hidden" id="caseNO" name="caseNO" value="${pubOtherpunish.caseNO}">
            <input type="hidden"  name="setDeptname" value="${pubOtherpunish.setDeptname}">
            <!--处罚类型 -->
            <input type="hidden" id="penType" value="${pubOtherpunish.penType}">
             <h1 class="h4-title left mt5">行政处罚</h1>
        	<table class="table-horizontal" width="100%">
	            <tr>
	                <td width="15%" class="bg-gray right">注册号:</td>
	                <td width="35%">
	                ${pubOtherpunish.regNO}
	                </td>
	                <td width="20%" class="bg-gray right">企业名称:</td>
	                <td width="30%">
	                ${pubOtherpunish.entName}
	                </td>
	            </tr>
	            <tr>
	               <td width="20%" class="bg-gray right">处罚决定书文号:</td>
	                <td width="35%">
	                ${pubOtherpunish.penDecNo}
	                </td>
	                <td width="15%" class="bg-gray right">违法行为类型:</td>
	                <td width="30%">
	                ${pubOtherpunish.illegActType}
	                </td>
	            </tr>
	            <tr>
	              <td class="bg-gray right">行政处罚内容</td>
	              <td colspan="3">
	              <div class="ipt-box pd0">
	                <textarea id="penContent" class="ipt-txt"  rows="" style="width:100%;height: 130px" readonly="readonly">${pubOtherpunish.penContent}</textarea>
	              </div>
	              </td>
	            </tr>
	             <tr>
	              <td class="bg-gray right">处罚类型</td>
	              <td colspan="3" id="penTypeShow">
	              </td>
	            </tr>
	            <tr>
	               <td width="20%" class="bg-gray right penAm" style="display: none">罚款金额（万元）:</td>
	                <td width="35%" class="penAm" style="display: none">
	                ${pubOtherpunish.penAm}
	                </td>
	                <td width="15%" class="bg-gray right forfAm" style="display: none">没收金额（万元）:</td>
	                <td width="30%" class="forfAm" style="display: none">
	                ${pubOtherpunish.forfAm}
	                </td>
	            </tr>
	            <tr>
	               <td width="20%" class="bg-gray right">处罚决定日期:</td>
	                <td width="35%">
	                <fmt:formatDate value="${pubOtherpunish.penDecIssDate}" pattern="yyyy-MM-dd" />
	                </td>
	                <td width="15%" class="bg-gray right">处罚决定机关:</td>
	                <td width="30%">
	                ${pubOtherpunish.judAuth}
	                </td>
	            </tr>
	            <tr>
	              <td class="bg-gray right">公示状态</td>
	              <td colspan="3">
	              <c:if test="${pubOtherpunish.pubFlag =='1'}">已公示</c:if>
	              <c:if test="${pubOtherpunish.pubFlag =='0'}">未公示</c:if>
	              </td>
	            </tr>
                </table>
    </div>
    <div id="otherPunishHis">
    <h1 class="h4-title left mt5">修改记录</h1>
    <table id="punishHisTable" cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
        <thead>
        <tr>
            <td class='frecss'>序号</td>
            <td class='frecss'>修改日期</td>
            <td class='frecss'>修改人</td>
            <td class='frecss'>审核结果</td>
            <td class='frecss'>审核人</td>
            <td class='frecss'>审核日期</td>
            <td class='frecss'>操作</td>
        </tr>
        </thead>
    </table>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/other/otherpunish/otherpunish_view_main.js"></script>
</body>
</html>