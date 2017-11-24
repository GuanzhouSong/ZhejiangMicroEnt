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
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<style type="text/css">
</style>
<body class="pd10">
<div>
  <input type="hidden" id="userType" value="${userType }">
    <div class="">
            <h1 class="h4-title left mt5">行政处罚查询详情</h1>
        	<table cellpadding="0" cellspacing="0" border="0" width="80%" class="table-horizontal">
	            <tr>
	                <td width="10%" class="bg-gray right">企业名称:</td>
	                <td width="25%">
	                ${pubOtherpunish.entName}
	                </td>
	                <td width="10%" class="bg-gray right">注册号:</td>
	                <td width="25%">
	                ${pubOtherpunish.regNO}
	                </td>
	                <td width="10%" class="bg-gray right">来源:</td>
	                <td width="20%">
	                    <c:if test="${pubOtherpunish.punSource == 1}">其他部门公示</c:if>
                		<c:if test="${pubOtherpunish.punSource == 2}">工商部门公示</c:if>
                		<c:if test="${pubOtherpunish.punSource == 3}">企业公示</c:if>
	                </td>
	            </tr>
	             <tr>
	                <td width="10%" class="bg-gray right">法定代表人:</td>
	                <td width="25%">
	                ${pubOtherpunish.leRep}
	                </td>
	                <td width="10%" class="bg-gray right">住所:</td>
	                <td width="55%" colspan="3">
	                ${pubOtherpunish.dom}
	                </td>
	            </tr>
	            <tr>
	                <td width="10%" class="bg-gray right">登记机关:</td>
	                <td width="25%">
	                ${pubOtherpunish.regOrgDesc}
	                </td>
	                <td width="10%" class="bg-gray right">管辖单位:</td>
	                <td width="25%">
	                ${pubOtherpunish.localAdmName}
	                </td>
	                <td width="10%" class="bg-gray right">责任区:</td>
	                <td width="20%">
	                ${pubOtherpunish.sliceNOName}
	                </td>
	            </tr>
                </table>
    </div>
    <div style="position:relative;">
    <h1 class="h4-title left mt5">行政处罚信息</h1>
    <table  cellpadding="0" cellspacing="0" border="0" width="80%" class="table-horizontal">
                <tr>
	               <td width="20%" class="bg-gray right">处罚决定书文号:</td>
	                <td width="80%" colspan="5">
	                ${pubOtherpunish.penDecNo}
	                </td>
	            </tr>
	            <tr>
	                <td width="20%" class="bg-gray right">违法行为类型:</td>
	                <td width="80%" colspan="5">
	                ${pubOtherpunish.illegActType}
	                </td>
	            </tr>
	            <tr>
	              <td class="bg-gray right">行政处罚内容</td>
	              <td width="80%" colspan="5">
	              <div class="ipt-box pd0">
	                <textarea id="penContent" class="ipt-txt"  rows="" style="width:100%;height: 130px" readonly="readonly">${pubOtherpunish.penContent}</textarea>
	              </div>
	              </td>
	            </tr>
	            <tr>
	                <td width="10%" class="bg-gray right">处罚决定机关:</td>
	                <td width="20%">
	                ${pubOtherpunish.judAuth}
	                </td>
	                <td width="15%" class="bg-gray right">处罚决定日期:</td>
	                <td width="20%">
	                <fmt:formatDate value="${pubOtherpunish.penDecIssDate}" pattern="yyyy-MM-dd" />
	                </td>
	                 <td width="10%" class="bg-gray right">公示日期:</td>
	                <td width="25%">
	                 <fmt:formatDate value="${pubOtherpunish.auditDate}" pattern="yyyy-MM-dd" />
	                </td>
	            </tr>
	            <c:if test="${!empty pubOtherPunishAlterList}">
	              <tr>
	                 <td colspan="6">
	               <span style="margin-left:20px;color:red">有变更情形：</span><br>
	               <c:forEach var="alter" varStatus="vs" items="${pubOtherPunishAlterList}">
					        <span  style="margin-left:80px;color:red">${vs.count}、${alter.contents}</span><br>
					</c:forEach>
					</td>
				  </tr>
	            </c:if>
	            <c:if test="${!empty imCasaltList}">
	              <tr>
	                 <td colspan="6">
	               <span style="margin-left:20px;color:red">有变更情形：</span><br>
	               <c:forEach var="alter" varStatus="vs" items="${imCasaltList}">
					        <span  style="margin-left:80px;color:red">${vs.count}、${alter.penContent}</span><br>
					</c:forEach>
					</td>
				  </tr>
	            </c:if>
    </table>
    </div>
    
     <div style="position:relative;">
    <h1 class="h4-title left mt5">处罚详情摘要</h1>
    <table  cellpadding="0" cellspacing="0" border="0" width="80%" class="table-horizontal">
                <tr>
                        <td colspan="3" class="bg-gray right">行政处罚决定书文号</td>
                        <td> ${pubOtherpunish.penDecNo}</td>
	                </tr>
	                <tr>    
	                	<td rowspan="3" width="12%" >行政处罚当事人基本情况</td>
	                	<td rowspan="3" width="6%" >单位</td>
	                	<td width="17%" class="bg-gray right">名称</td>
	                	<td width="65%"  >${pubOtherpunish.entName}</td>
	                </tr>
	                <tr>    
	                	<td class="bg-gray right">注册号</td>
	                	<td>${pubOtherpunish.regNO}</td>
	                </tr>
	                <tr>    
	                	<td class="bg-gray right">法定代表人（负责人）姓名</td>
	                	<td>${pubOtherpunish.leRep}</td>
	                </tr>
	                <tr>    
	                	<td colspan="3" class="bg-gray right">违法行为类型</td>
	                    <td> ${pubOtherpunish.illegActType}</td>
	                </tr>
	                <tr>
	                	<td colspan="3" class="bg-gray right">行政处罚内容</td>
                        <td>
                        <div class="ipt-box pd0">
		                  <textarea id="penContent" class="ipt-txt"  rows="" style="width:100%;height: 130px" readonly="readonly">${pubOtherpunish.penContent}</textarea>
		                </div>
                        </td>
	                </tr>
	                <tr>
                        <td colspan="3" class="bg-gray right">作出行政处罚决定机关名称</td>
	                    <td>${pubOtherpunish.judAuth}</td>
                    </tr>
	                <tr>
	                    <td colspan="3" class="bg-gray right">作出行政处罚<br>决定日期</td>
                        <td><fmt:formatDate value="${pubOtherpunish.penDecIssDate}" pattern="yyyy-MM-dd" /></td>
	                </tr>
         </table>
    </div>
    <div>
            <c:if test="${pubOtherpunish.punSource == 2 && not empty pubOtherpunish.punDecDoc}">
        	<h1 class="h4-title left mt5">处罚决定书</h1>
        	<div>
                <table>
                <td style="padding:20px;">
        		${pubOtherpunish.punDecDoc}
        		</td>
        		</table>
        	</div>
        	</c:if>
    </div>
           <div class="center mt10 mb10">
                <button id="cancel" type="button" class="btn">关闭</button>
            </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script type="text/javascript">
require(['component/iframeLayer','jquery'],function(layer) {
    $("#cancel").click(function(){layer.close();});
})
</script>
</body>
</html>