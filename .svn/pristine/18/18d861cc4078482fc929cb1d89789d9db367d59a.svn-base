<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>股东及出资信息新增页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body> 
<%-- <div class="banner-bg">
    <div class="mod banner">
        <h4>欢迎您！${midBaseInfoDto.entName}<font>（登记机关：${midBaseInfoDto.regOrgName}）</font></h4>
         <p><c:if test="${!empty midBaseInfoDto.uniCode}">
            <em>统一社会信用代码：${midBaseInfoDto.uniCode} </em></c:if><em>注册号：${midBaseInfoDto.regNO}</em></p>
         
    </div>
</div> --%>
<div class="mod pdt20">
<input type="hidden" name="inv" id="inv" value="${invID}"></p>
         <input type="hidden" name="id" id="id" value="${invID}">
          <input type="hidden" name="uniCode" value=${midBaseInfoDto.uniCode }>
         <input type="hidden" name="invID" id="invID" value="${invID}">
    <div class="mod-cont permit-cont">
        <h4>股东及出资信息</h4>
        <div class="investment-add">
            <ul class="form-common-list">
                <li>
                    <div class="col-6">
                        <div class="item-name">股东：</div>
                        <input type="hidden" name="invd" id="invd" value="${invID}"></p>
   <input type="hidden" name="id" id="id" value="${id}">
                        <div class="item-txt">
                         <input type="text"   value="${inv}" id="invr" readonly class="ipt-txt">  
                         
                        </div>
                    </div>
                </li>
            </ul>
            <div class="add-more">
               
            </div>
            <table border="0"  id="permit-table"cellspacing="0" cellpadding="0" class="table-ordinary mb14">
                <thead>
                <tr>
                    <th width="208">出资方式</th>
                    <th width="218">认缴出资额（万元）</th>
                    <th width="235">出资日期</th>
                    <th>公示状态</th> 
                     
                </tr>
                </thead>
               <tbody>
               <c:forEach var="item" items="${prvList}" varStatus="status">
                 <tr>
                 <td>${item.conFormCN }</td>
                    <td>${item.subConAm }</td>
                 <td> 	<fmt:formatDate value="${item.conDate }"  dateStyle="long"/></td>
                 <td> 
                  <c:if test="${item.pubFlag=='1' }">已公示</c:if>
                 <c:if test="${item.pubFlag=='2' }">未公示</c:if>
                  <c:if test="${item.pubFlag=='0' }">未公示</c:if>
                 </td>
                 </tr>
               
               </c:forEach>
               
               </tbody>
               
            </table>
              
            <div class="add-more">
              
            </div>
            <table border="0" id="investment-table" cellspacing="0" cellpadding="0" class="table-ordinary">
                <thead>
                <tr>
                    <th width="208">出资方式</th>
                    <th width="218">实缴出资额（万元）</th>
                    <th width="235">出资日期</th>
                    <th>公示状态</th> 
                </tr>
                </thead> 
                <tbody>
                <c:forEach items="${actList }" var="item">
                 <tr>
                <td>${item.acConFormCn }</td>
                 <td>${item.acConAm }</td>
                 <td>	<fmt:formatDate value="${item.conDate }"  dateStyle="long"/></td>
                <td>
                <c:if test="${item.pubFlag=='1' }">已公示</c:if>
                 <c:if test="${item.pubFlag=='2' }">未公示</c:if>
                  <c:if test="${item.pubFlag=='0' }">未公示</c:if>
                </td>
                </tr>
                </c:forEach>  
                </tbody>
                
            </table>
        </div>
       
    </div>
</div> 
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script> 
</body>
</html>