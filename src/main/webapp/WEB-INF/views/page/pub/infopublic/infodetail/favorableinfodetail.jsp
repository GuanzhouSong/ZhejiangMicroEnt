<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>良好荣誉信息详情</title>
    <link rel="stylesheet" href="/css/pub.css">
</head>
<body>
  <div class="mod-bd-panel_company">
      <h3 class="i-title">
          <i></i>
          <c:if test="${favorAbleInfo.favType == '0'}">百强民营企业</c:if>
          <c:if test="${favorAbleInfo.favType == '1'}">驰名商标</c:if>
          <c:if test="${favorAbleInfo.favType == '2'}">知名商号</c:if>
          <c:if test="${favorAbleInfo.favType == '3'}">著名商标</c:if>
          <c:if test="${favorAbleInfo.favType == '4'}">守合同重信用企业</c:if>
          <c:if test="${favorAbleInfo.favType == '5'}">信用示范管理企业</c:if>
          <c:if test="${favorAbleInfo.favType == '6'}">小微企业成长之星</c:if>
      </h3>
      <table class="table-common table-zichan">
		 <tbody>
		 <tr>
		     <td width="200" class="odd">统一社会信用代码/注册号</td>
		     <td width="230">
		      <c:choose>
		          <c:when test="${not empty favorAbleInfo.uniSCID}">${favorAbleInfo.uniSCID}</c:when>
		          <c:otherwise>${favorAbleInfo.regNO}</c:otherwise>
		     	</c:choose>
		     </td>
		     <td width="190" class="odd">企业名称</td>
		     <td width="240">${favorAbleInfo.entName}</td>
		 </tr>
		 <tr>
		     <td class="odd">评定级别</td>
		     <td>
		     	<c:if test="${favorAbleInfo.licZone == '0'}">国家级</c:if>
		     	<c:if test="${favorAbleInfo.licZone == '1'}">省级</c:if>
		     	<c:if test="${favorAbleInfo.licZone == '2'}">市级</c:if>
		     	<c:if test="${favorAbleInfo.licZone == '3'}">县级</c:if>
		     	<c:if test="${favorAbleInfo.licZone == '4'}">AAA</c:if>
		     	<c:if test="${favorAbleInfo.licZone == '5'}">AA</c:if>
		     	<c:if test="${favorAbleInfo.licZone == '6'}">A</c:if>
		     </td>
		     <td class="odd">认定发布部门</td>
		     <td>${favorAbleInfo.regDeptCn}</td>
		 </tr>
		 <tr>
		     <td class="odd">公示时间</td>
		     <td><fmt:formatDate value="${favorAbleInfo.regDate}" pattern="yyyy-MM-dd"/></td>
		     <td class="odd">有效期至</td>
		     <td><fmt:formatDate value="${favorAbleInfo.regTo}" pattern="yyyy-MM-dd"/></td>
		 </tr>
		 <tr>
		     <td class="odd">认定发布年度</td>
		     <td>${favorAbleInfo.regYear}</td>
		     <td class="odd">认定类别</td>
		     <td>${favorAbleInfo.regType}</td>
		 </tr>
<%-- 		 <c:if test="${favorAbleInfo.favType == '1' || favorAbleInfo.favType == '2' || favorAbleInfo.favType == '3'}"> --%>
<!-- 		 <tr> -->
<!-- 		     <td class="odd">商标信息</td> -->
<!-- 		     <td colspan="3"></td> -->
<!-- 		 </tr> -->
<%-- 		 </c:if> --%>
    </tbody>
	</table>
</div>
</body>
</html>