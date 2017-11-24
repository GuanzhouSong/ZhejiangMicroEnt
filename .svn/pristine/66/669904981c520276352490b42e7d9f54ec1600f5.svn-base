<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>抽查公告页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/pub.css"/>"/>
</head>
<style type="text/css">
.table-other td {
    border: 1px solid #edeeee;
    padding: 10px 5px;
    color: #666;
}
.checkcss {
    background-color: #eae3db;
    font-weight: bold;
    text-align: right;
    color: #87550F;
    text-align: center;
    white-space: nowrap;
}
.closemarkcss{
   position:absolute;
   top:0;right:10px;
   display:block;
   width:20px;
   height:20px;
   line-height:20px;
   text-align:center;
   margin-top:-5px;
   font-size:20px;
   color: #999999
}
</style>
<body class="enterprise-info-bg">
<jsp:include page="../common/noticeheader.jsp"></jsp:include>
<div class="mb20">
    <div class="mod mod-notice-detail" style="width: 1160px">
        <div class="mod-notice-hd mod-hd mt20">
            <h3>抽查结果公告</h3>
        </div>
        <div class="mod-notice-bd" style="margin-top: 50px;padding-bottom: 10px;">
            <table class="table-other" border="0" cellspacing="0" cellpadding="0" width="95%">
                        <thead>
                        <tr>
                            <td class="checkcss" style="color:#87550F;">序号</td>
                            <td class="checkcss" style="color:#87550F;">检查事项</td>
                            <td class="checkcss" style="color:#87550F;">检查结果</td>
                        </tr>
	                     </thead>
                        <tbody id="pageList">
	                          <c:forEach var="pubSccheckItem" items="${itemResultList}" varStatus="status">
					            <tr>
					                <td width="8%" style="text-align: center;">${status.index + 1}</td>
					                <td width="67%" style="text-align: center;">${pubSccheckItem.checkName}</td>
					                <td width="25%" style="text-align: center;">
					                <c:if test="${pubSccheckItem.problem == '无' }">未发现问题</c:if>
					                <c:if test="${empty pubSccheckItem.problem}">查无此项</c:if>
					                <c:if test="${!empty pubSccheckItem.problem && pubSccheckItem.problem != '无' }">${pubSccheckItem.problem }</c:if>
					                </td>
					            </tr>
					           </c:forEach>
                        </tbody>
                     </table>
               </div>
         </div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>