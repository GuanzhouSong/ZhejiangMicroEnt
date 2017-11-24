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
<body>
<div class="pd20 clearfix">
     <input type="hidden" id="userType" value="${userType }">
    <div class="audit" style="margin-top: 20px;">
             <div>
        	    <h1 class="h3-title left">股权变更登记情况</h1>
                <table cellpadding="0" cellspacing="0" border="0" width="80%" class="table-horizontal mt10">
	                <tr>
         			<td style="width:20%; _width:20%;" class="bg-gray right">执行法院</td>
         			<td style="width:30%; _width:30%;">
         			${pubJusticeInfo.executionCourt}</td>
         			<td style="width:20%; _width:20%;" class="bg-gray right">执行事项</td>
         			<td style="width:30%; _width:30%;">
         			<c:if test="${pubJusticeInfo.executeItem == '1'}">公示冻结股权、其他投资权益</c:if>
         			<c:if test="${pubJusticeInfo.executeItem == '2'}">续行冻结股权、其他投资权益</c:if>
         			<c:if test="${pubJusticeInfo.executeItem == '3'}">解除冻结股权、其他投资权益</c:if>
         			<c:if test="${pubJusticeInfo.executeItem == '4'}">强制转让被执行人股权，办理有限责任公司股东变更登记</c:if>
         			</td>
         		</tr>
         		<tr>
         			<td class="bg-gray right">执行裁定书文号</td>
         			<td>${pubJusticeInfo.exeRulNum}</td>
         			<td class="bg-gray right">执行通知书文号</td>
         			<td>${pubJusticeInfo.executeNo}</td>
         		</tr>
         		<tr>
         			<td class="bg-gray right">被执行人</td>
         			<td>${pubJusticeInfo.inv}</td>
         			<td class="bg-gray right">被执行人持有股权、其它投资权益的数额</td>
         			<td><fmt:formatNumber value="${pubJusticeInfo.froAm}" pattern="###,###,###,##0.0000"/> ${pubJusticeInfo.froAuth} </td>
         		</tr>
         		<tr>
         			<td class="bg-gray right">被执行人证件种类</td>
         			<td>
         			<c:forEach var="codeCertype" items="${codeCertypeList}" varStatus="">
						  <c:if test="${codeCertype.code == pubJusticeInfo.cerType}">
						      ${codeCertype.content}
						  </c:if>	
                    </c:forEach>
         			</td>
         			<td class="bg-gray right">被执行人证件号码</td>
         			<td>${pubJusticeInfo.cerNO}</td>
         		</tr>
         		
         		<tr>
         			<td class="bg-gray right">受让人</td>
         			<td>${pubJusticeInfo.assInv}</td>
         			<td class="bg-gray right">协助执行日期</td>
         			<td><fmt:formatDate value="${pubJusticeInfo.executeDate}" pattern="yyyy年MM月dd日"/></td>
         		</tr>
         		<tr>
         			<td class="bg-gray right">受让人证件种类</td>
         			<td>
         			<c:forEach var="codeCertype" items="${codeCertypeList}" varStatus="">
						  <c:if test="${codeCertype.code == pubJusticeInfo.assCerType}">
						      ${codeCertype.content}
						  </c:if>	
                    </c:forEach>
         			</td>
         			<td class="bg-gray right">受让人证件号码</td>
         			<td>${pubJusticeInfo.assCerNO}</td>
         		</tr>
	            </table>
	            </div>
	            
      </div>
      <div class="clearfix mt20">     
	     <div class="center" style="margin-bottom: 40px">
	                <button id="cancel" type="button" class="btn btn-primary">取消</button>
	     </div>
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