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
    <title><c:if test="${pubType == '13'}">拟吊销企业营业执照听证公告</c:if><c:if test="${pubType == '14'}">吊销企业营业执照公告</c:if>
    <c:if test="${pubType == '15'}">企业登记机关注销公告</c:if><c:if test="${pubType == '17'}">年度抽查工作计划公告</c:if>
    </title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/pub.css"/>"/>
</head>
<body class="enterprise-info-bg">
<jsp:include page="../common/noticeheader.jsp"></jsp:include>
<div class="mod detail-main" style="text-align: center;">
	<div class="tab-panel">
	    <div class="undertaking-img" style="text-align: left;padding: 70px 250px 110px 250px;">
			<c:if test="${pubType != '12'}">
	            <div class="content">
	                <div class="bd">
	                    <div class="bd-cont" id="content">
	                     <p id="content">${Bulletins.contents }</p>
	                    </div>
	                </div>
			    <c:if test="${not empty Bulletins.bulData }">          
			    <div id="filelabel">
			                  附件：
		            <c:forEach items="${files}" var="obj">
		              <p><span path="${obj}" style="color:blue;cursor:pointer;padding: 9px 8px;"
		                       title="查看详情"><i
		                      class="xbt-icon file-icon"></i>${fn:substringAfter(obj, '-')}</span>
		                  &nbsp;&nbsp;
		              </p>
		          </c:forEach>
		        </div>
		        </c:if>
		       </div>
		     </c:if>
		</div>
	</div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
 <script>
     $(function () {
         $("#filelabel").delegate('span', 'click', function () {
             var path = $(this).attr("path");
             window.open("/pub/yr/bulletins/view?fileName=" + path);
         });
     })
 </script>
 <script src="/js/lib/require.js"></script>
 <script src="/js/config.js"></script>
</body>
</html>