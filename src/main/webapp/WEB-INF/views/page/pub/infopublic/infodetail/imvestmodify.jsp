<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>股东及出资信息修改记录</title>
    <link rel="stylesheet" href="/css/pub.css">
</head>
<body class="enterprise-info-bg">
<!-- 头部 -->
<jsp:include page="../../common/enterprise.jsp"></jsp:include>
<div class="mt20 mb20">
    <div class="mod detail-main">
        <div class="tab-panel">
            <div class="mod-bd-panel_company">
                <h3 class="i-title">
                    <i></i>股东及出资信息修改记录
                </h3>
                <table class="table-common mb20">
                    <thead>
                    <tr>
                        <th width="156">
                            变更事项
                        </th>
                        <th width="310">
                            变更前内容
                        </th>
                        <th width="310">
                            变更后内容
                        </th>
                        <th>
                            变更日期
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    
                    <c:forEach items="${list}" var="pr">
                         
                    <tr>
                        <td>
                         ${pr.altItemContent }
                        </td>
                        <td>
                        <c:if test="${fn:indexOf(pr.altItemContent,'出资方式') != -1}">
                        	<c:if test="${pr.altBeContent=='1' }">货币</c:if>
                        	<c:if test="${pr.altBeContent=='2' }">实物</c:if>
                        	<c:if test="${pr.altBeContent=='3' }">知识产权</c:if>
                        	<c:if test="${pr.altBeContent=='4' }">债权</c:if>
                        	<c:if test="${pr.altBeContent=='6' }">土地使用权</c:if>
                        	<c:if test="${pr.altBeContent=='7' }">股权</c:if>
                        	<c:if test="${pr.altBeContent=='8' }">劳务</c:if>
                        	<c:if test="${pr.altBeContent=='9' }">其他</c:if>
                        	<c:if test="${fn:indexOf('1,2,3,4,6,7,8,9', pr.altBeContent)==-1}">
                        	${pr.altBeContent } 
                        	</c:if>
                        </c:if>
                        <c:if test="${fn:indexOf(pr.altItemContent,'出资方式') == -1}">
                         ${pr.altBeContent } 
                        </c:if>
                        </td>
                        <td>
	                        <c:if test="${fn:indexOf(pr.altItemContent,'出资方式') != -1}">
	                        	<c:if test="${pr.altAfContent=='1' }">货币</c:if>
	                        	<c:if test="${pr.altAfContent=='2' }">实物</c:if>
	                        	<c:if test="${pr.altAfContent=='3' }">知识产权</c:if>
	                        	<c:if test="${pr.altAfContent=='4' }">债权</c:if>
	                        	<c:if test="${pr.altAfContent=='6' }">土地使用权</c:if>
	                        	<c:if test="${pr.altAfContent=='7' }">股权</c:if>
	                        	<c:if test="${pr.altAfContent=='8' }">劳务</c:if>
	                        	<c:if test="${pr.altAfContent=='9' }">其他</c:if>
	                        	<c:if test="${fn:indexOf('1,2,3,4,6,7,8,9', pr.altAfContent)==-1}">
	                        	${pr.altAfContent }
	                        	</c:if>
	                        </c:if>
	                        <c:if test="${fn:indexOf(pr.altItemContent,'出资方式') == -1}">
	                        ${pr.altAfContent }
	                        </c:if>
                        </td>
                        <td>
                          <fmt:formatDate value="${pr.altDate }" dateStyle="long" />
                        </td>
                    </tr>
                    
                    </c:forEach>
                    
                    
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../../common/footer.jsp"></jsp:include>
</body>
</html>