<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>成长历程</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<style type="text/css">
.conpinfo-cont {
    height: calc(100% - (229px));
}

.develop-trip {
   /*  height: 100%; */
    padding: 6px 13px 0 35px;
    position: relative;
    background-color: #fff;
    box-sizing: border-box;
}

 ul {
    list-style: none
}

.develop-trip li {
    padding-bottom: 10px;
}

.develop-trip td {
    font-size: 12px;
    line-height: 15px;
    font-weight: normal;
    color: #999;
    padding: 2px 8px 7px;

}

.develop-trip li h6, .develop-trip li p {
    color: #333;
    font-size: 14px;
    line-height: 20px;
    font-weight: normal;
    position: relative;
}

.develop-trip table {
    margin-top: 5px;
    border-bottom: 1px solid #ccc;
    width: 100%;
    text-align: center;
}

.develop-trip li h6:before {
    content: ' ';
    position: absolute;
    left: -16px;
    top: 4px;
    width: 12px;
    height: 12px;
    background: url("/img/reg/server/time-node.png") no-repeat 0 0;
    background-size: contain;
}

.develop-trip:before {
    content: " ";
    height: 100%;
    position: absolute;
    top: 0;
    left: 24px;
    border-left: 1px solid #ccc;
}

.develop-trip th {
    padding-top: 9px;
    font-size: 12px;
    line-height: 14px;
    font-weight: normal;
    width: 50%;
}

.develop-trip td:first-child, .develop-trip th:first-child {
    border-right: 1px solid #fff;
    background-color: #f5f5f5;
}


.develop-trip td, .develop-trip th {
    border-right: 1px solid #fff;
    background-color: #f5f5f5;
}
</style>
<body class="pd10"> 
        <div class="conpinfo-cont">
          <div class="develop-trip"> 
       		 <ul id="com_history">
                 <c:if test="${empty midAltitemDtoList }">
                      <li>该企业暂无数据</li>
                 </c:if>
                 <c:if test="${not empty midAltitemDtoList }">
                   <c:forEach items="${midAltitemDtoList}" var="midAltitemDto">
						  <li>
						    <div>
							    <h6><fmt:formatDate value="${midAltitemDto.altDate}" type="date" pattern="yyyy-MM-dd"/></h6>
						        <p>${midAltitemDto.altContent}</p>
						        <table cellpadding="0" cellspacing="0">
						          <tbody>
						            <tr><th>变更前</th><th>变更后</th></tr>
						       		<tr><td>${midAltitemDto.altBeContent}</td><td>${midAltitemDto.altAfContent}</td></tr>
						       	  </tbody>
						        </table>
					        </div>
					      </li>  
				   </c:forEach>
                 </c:if> 
		     </ul>
           </div> 
        </div> 
</body>
</html>
