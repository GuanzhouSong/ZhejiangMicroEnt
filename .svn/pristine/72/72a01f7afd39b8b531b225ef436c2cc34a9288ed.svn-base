<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<meta charset="utf-8">
<title></title>
<%--<link rel="stylesheet" href="/css/reg.server.css">--%>
<link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
<link rel="stylesheet" href="/css/reg.client.css">
<style type="text/css">
.op-title{
    padding-top: 30px;
    padding-bottom: 10px;
    box-sizing: border-box;
}

</style>

<!-- 正式 -->
<script type="text/javascript" src="https://hm.baidu.com/hm.js?503ba8bab9e32eb24b79b59a886d8e8f"></script>
<!-- 测试 -->
<!-- <script type="text/javascript" src="https://hm.baidu.com/hm.js?3ecdad4c6bf5c76ce987441f963a4fba"></script> -->
</head>
<body style="background-color: #fbf8ef;">
<div class="mod header">
     <h2 class=""><a href="#"><img src="/img/pub/zj-logo.png" alt=""></a></h2>
</div>
 <form id="taskForm" class="form-box">
	<div class="mt20">
	<div class="mod-wrap">
		<div class="mod mod-tb-notice-detail">
			<h1 class="center op-title">
				<c:if test="${isMove=='1'}">
				移出经营异常名录通知 
				</c:if>
				<c:if test="${isMove=='2'}">
				更正（撤销）经营异常名录通知 
				</c:if>
				<c:if test="${isMove=='3'}">
				  列入经营异常名录通知 
				</c:if>
				<p class="fs14 mb20 center">发送日期：<span class="span_sendDate"></span></p>
			</h1> 
			
		   <c:if test="${isMove=='1' && not empty pubOpaDetailList}">
				<p class="fs14 mb10">您担任工商联络员的以下企业已消除异常事由，<span class="font-red">成功移出经营异常名录</span></p>
				<p class="fs14 mb10 font-red">温馨提醒：企业列入和移出经营异常名录的信息将通过公示系统予以公示。</p> 
				<c:forEach items="${pubOpaDetailList}" var="pubOpaDetail">
				<p style="border-bottom:1px solid #9c9485;"></p><br>
		        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
		        <tbody>
		        <tr style="color: gray;">
		           <p class="fs14 mb10" style="color: gray;">
		           <label style="font-weight: bold;">企业名称 :</label>
		           <label>${pubOpaDetail.entName }</label>
		           </p>
		        </tr>
		        <tr>
		           <p class="fs14 mb10" style="color: gray;">
		           <label style="font-weight: bold;">列入原因 :</label> 
		           <label>${pubOpaDetail.speCauseCN }</label>
		           </p>
		        </tr>
		        <tr>
		           <p class="fs14 mb10" style="color: gray;">
		           <label style="font-weight: bold; ">列入机关:</label>
		           <label>${pubOpaDetail.decorgCN }</label>
		           </p>
		        </tr>
		        <tr> 
		        	<p class="fs14 mb10" style="color: gray;">
		        	<label style="font-weight: bold;">列入日期 :</label>
		            <label><fmt:formatDate value="${pubOpaDetail.abnTime}" type="date" pattern="yyyy-MM-dd"/></label>
		            </p>
		        </tr><br>
		         <tr>
		           <p class="fs14 mb10">
		           <label style="font-weight: bold;">移出原因 :</label> 
		           <label>${pubOpaDetail.remExcpresCN }</label>
		           </p>
		        </tr>
		        <tr>
		           <p class="fs14 mb10">
		           <label style="font-weight: bold;">移出机关:</label>
		           <label>${pubOpaDetail.reDecOrgCN }</label>
		           </p>
		        </tr>
		        <tr> 
		        	<p class="fs14 mb10">
		        	<label style="font-weight: bold;">移出日期 :</label>
		            <label><fmt:formatDate value="${pubOpaDetail.remDate}" type="date" pattern="yyyy-MM-dd"/></label>
		            </p>
		        </tr>
		        </tbody>
		  		</table><br>
		        </c:forEach>
		        <p style="border-bottom:1px solid #9c9485;"></p><br>
		   </c:if>
		   <c:if test="${isMove=='2' && not empty pubOpaDetailList}">
				<p class="fs14 mb10">您担任工商联络员的以下企业已更正（撤销）列入经营异常名录。</p>
				<p class="fs14 mb10 font-red">温馨提醒：更正（撤销）的经营异常名录不通过公示系统予以公示</p>
				<c:forEach items="${pubOpaDetailList}" var="pubOpaDetail">
				<p style="border-bottom:1px solid #9c9485;"></p><br>
		        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
		        <tbody>
		        <tr style="color: gray;">
		           <p class="fs14 mb10" style="color: gray;">
		           <label style="font-weight: bold;">企业名称 :</label>
		           <label>${pubOpaDetail.entName }</label>
		           </p>
		        </tr>
		        <tr>
		           <p class="fs14 mb10" style="color: gray;">
		           <label style="font-weight: bold;">列入原因 :</label> 
		           <label>${pubOpaDetail.speCauseCN }</label>
		           </p>
		        </tr>
		        <tr>
		           <p class="fs14 mb10" style="color: gray;">
		           <label style="font-weight: bold; ">列入机关:</label>
		           <label>${pubOpaDetail.decorgCN }</label>
		           </p>
		        </tr>
		        <tr> 
		        	<p class="fs14 mb10" style="color: gray;">
		        	<label style="font-weight: bold;">列入日期 :</label>
		            <label><fmt:formatDate value="${pubOpaDetail.abnTime}" type="date" pattern="yyyy-MM-dd"/></label>
		            </p>
		        </tr><br>
		         <tr>
		           <p class="fs14 mb10">
		           <label style="font-weight: bold;">更正（撤销）原因 :</label> 
		           <label>${pubOpaDetail.remExcpresCN }</label>
		           </p>
		        </tr>
		        <tr>
		           <p class="fs14 mb10">
		           <label style="font-weight: bold;">决定机关:</label>
		           <label>${pubOpaDetail.reDecOrgCN }</label>
		           </p>
		        </tr>
		        <tr> 
		        	<p class="fs14 mb10">
		        	<label style="font-weight: bold;">更正（撤销）日期 :</label>
		            <label><fmt:formatDate value="${pubOpaDetail.remDate}" type="date" pattern="yyyy-MM-dd"/></label>
		            </p>
		        </tr>
		        </tbody>
		  		</table><br>
		        </c:forEach>
		        <p style="border-bottom:1px solid #9c9485;"></p><br>
		   </c:if>
		   <c:if test="${isMove=='3' && not empty pubOpanoMalyList }"> 
		   	<p class="fs14 mb10">您担任工商联络员的以下<span class="font-red">${fn:length(pList)}</span>家企业<span class="font-red">被列入经营异常名录：</span></p>
			<p class="fs14 mb10 font-red">温馨提醒：请在消除列入异常事由后，向工商部门申请移出经营异常名录</p>
	        <c:forEach items="${pubOpanoMalyList}" var="pubOpanoMaly">
	        <p style="border-bottom:1px solid #9c9485;"></p><br>
	        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
	        <tbody>
	        <tr>
	           <p class="fs14 mb10">
	           <label style="font-weight: bold;">企业名称 :</label>
	           <label>${pubOpanoMaly.entName }</label>
	           </p>
	        </tr>
	        <tr>
	           <p class="fs14 mb10">
	           <label style="font-weight: bold;">列入原因 :</label> 
	           <label>${pubOpanoMaly.speCauseCN }</label>
	           </p>
	        </tr>
	        <tr>
	           <p class="fs14 mb10">
	           <label style="font-weight: bold;">列入机关:</label>
	           <label>${pubOpanoMaly.decorgCN }</label>
	           </p>
	        </tr>
	        <tr> 
	        	<p class="fs14 mb10">
	        	<label style="font-weight: bold;">列入日期 :</label>
	            <label><fmt:formatDate value="${pubOpanoMaly.abnTime}" type="date" pattern="yyyy-MM-dd"/></label>
	            </p>
	        </tr>
	        </tbody>
	  		</table><br>
	        </c:forEach>
	        <p style="border-bottom:1px solid #9c9485;"></p><br>
		  </c:if>

			 
		</div>
	</div>
<div class="mod1366">
<div class="footer-box">
    <div class="mod footer">
        <p>主办单位：浙江省工商行政管理局</p>
        <p>地址：杭州市莫干山路77号金汇大厦北门&nbsp;&nbsp;&nbsp;&nbsp;邮政编码：310005&nbsp;&nbsp;&nbsp;&nbsp;备案号：京ICP备16053442号</p>
    </div>
</div>
</div> 
</form> 
		<script src="/js/lib/require.js"></script>
		<script src="/js/config.js"></script>
		<script src="/js/reg/server/message/message_opanomaly_view.js"></script>
		
</body>
</html>