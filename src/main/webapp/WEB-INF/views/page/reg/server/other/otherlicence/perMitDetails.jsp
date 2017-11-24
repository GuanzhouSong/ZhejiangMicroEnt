<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.Date" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>行政许可审核</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<style>
.show {
    position:absolute;
    height:auto;
    background:#FFFFE1;
    border:1px solid #ffcc01;
    padding:4px;
    display:none;
    z-index:5;
    margin-top:15px;
    margin-left:25px;
    line-height:16px;
}
</style>
<body>
<div class="pd20 clearfix">
              
<div class="clearfix mb5 mt5">
<p>行政许可查询详情</p>
</div>
     <input type="hidden" id="userType" value="${userType }">
    <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
        <tr>
            <td class="bg-gray right" width="15%">企业名称</td>
            <td width="20%">${midBaseInfo.entName }</td> 
            <td class="bg-gray right" width="15%">注册号</td>
            <td width="18%">${midBaseInfo.regNO }</td>
           <td class="bg-gray right" width="15%">来源</td>
            <td>企业公示</td>
        </tr>
        <tr>
        
            <td class="bg-gray right">登记机关</td>
            <td>${midBaseInfo.regOrgName}</td>
            <td class="bg-gray right">法定代表人</td>
            <td>${midBaseInfo.leRep } </td>
            <td class="bg-gray right">管辖单位</td>
            <td>${midBaseInfo.localAdmName }</td>
        </tr>
        <tr>
            <td class="bg-gray right">责任区</td>
            <td>${midBaseInfo.sliceNOName}</td> 
            <td class="bg-gray right">住所</td>
            <td colspan="3">${midBaseInfo.dom }</td>
        </tr>
        
       
    </table> 
    <div>
    <div class="clearfix mb5 mt20">
    <p>许可信息</p>
    </div>
    <table id="licenceDetable" border="0" cellspacing="0" cellpadding="0" class="table-row mt30">
        <tbody>
        <tr>
            <th width="17%">许可编号</th> 
            <th width="17%">许可名称</th>
            <th width="13%">有效期自</th>
            <th width="13%">有效期至</th>
            <th width="16%">许可内容</th>
             <th width="8%">状态</th>
              <th width="15%">公示日期</th>
        </tr>
        <tbody>
          <tr>
            <td>${perMit.licNO}</td>
            <td>${perMit.licNameCN}</td>
            <td><fmt:formatDate value="${perMit.valFrom }" pattern="yyyy-MM-dd" />  </td>
            <td><fmt:formatDate value="${perMit.valTo }" pattern="yyyy-MM-dd" /> </td>
            <td>
                <div class="show" style="width:300px;"><c:out value="${perMit.licItem}"></c:out></div>
				<c:choose>  
				    <c:when test="${fn:length(perMit.licItem) > 15}">  
				        <c:out value="${fn:substring(perMit.licItem, 0, 15)}......" />  
				    </c:when>  
				   <c:otherwise>  
				      <c:out value="${ perMit.licItem}" />  
				    </c:otherwise>  
				</c:choose>  
            </td>
            <td>
	            <c:choose>
		            <c:when test="${permit.pubType ==1}">
		                                     变更
		            </c:when>
		            <c:when test="${permit.pubType ==2}">
		                                    注销                       
		            </c:when>
		            <c:when test="${permit.pubType ==2}">
		                                  被吊销                      
		            </c:when>
		              <c:when test="${permit.pubType ==2}">
		                                  撤销                   
		            </c:when>
		            <c:otherwise> </c:otherwise>
	            </c:choose>
            </td>
            <td><fmt:formatDate value="${perMit.publicDate }" pattern="yyyy-MM-dd" /> </td>
          </tr>
        </tbody>
    </table>
    
    <div class="clearfix mb5 mt20">
      <p> 变更信息</p>
    </div>
    <table border="0" cellspacing="0" cellpadding="0" class="table-row mt30">
        <tbody>
        <tr>
            <th width="7%">序号</th> 
            <th width="13%">变更事项</th>
            <th width="13%">变更日期</th>
            <th width="7%">变更前内容</th>
            <th width="8%">变更后内容</th>
            
        </tr>
        
         <c:forEach items="${perMaltlist}" var="item" varStatus="status">
	         <tr> 
	            <td>${status.index}</td>
	            <td> ${item.altItemContent }</td>
	            <td> <fmt:formatDate value="${item.altDate }" pattern="yyyy-MM-dd" /></td>
	            <td>
	            ${item.altBeContent }
	            </td>
	            <td>${item.altAfContent }</td>
	        </tr>
         </c:forEach>
         <c:if test="${empty perMaltlist}">
             <tr>
               <td colspan="5" align="center">暂无变更记录</td>
             </tr>
         </c:if>
        </tbody>
    </table>
</div> 
    
</div>
<div class="form-item clearfix">
            <div class="btn-box">
                <input type="button" id="cancel" value="关闭" class="btn">
            </div>
        </div>

</body>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/other/otherlicence/otherlicence_detail_main.js"></script>
</html>