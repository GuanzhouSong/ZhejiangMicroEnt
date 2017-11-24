<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.Date" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>年报数据回导</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body>
   
<div class="pd10 clearfix">
    <!--  <div class="bg-gray2 clearfix company-info-title"><h3 class="h3-title">杭州若泉贸易有限公司</h3>注册号：330104000299976</div>
     <h4 class="h4-title mt10">企业基本信息</h4> -->
    <div class="clearfix mb5 mt5">
        <p class="h4-title"> 企业基本信息</p>
    </div>
    <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
       <input type="hidden" id="priPID" value="${midBaseInfo.priPID}">
       <tr>
         <td class="bg-gray right">注册号</td>
          <td>${midBaseInfo.regNO }</td>
           <td class="bg-gray right">企业名称</td>
          <td>${midBaseInfo.entName }</td>
        </tr>
      
        <tr>
            <td class="bg-gray right">法定代表人</td>
            <td>${midBaseInfo.leRep}</td>
            <td class="bg-gray right">住所</td>
            <td>${midBaseInfo.dom }</td>
        </tr>
        
        <tr>
            <td class="bg-gray right">营业期限自</td>
            <td><fmt:formatDate value="${midBaseInfo.opFrom }" pattern="yyyy-MM-dd"/>
               </td>
            <td class="bg-gray right">营业期限至</td>
            <td> <fmt:formatDate value="${midBaseInfo.opTo }" pattern="yyyy-MM-dd"/></td>
        </tr>
 
        <tr>
            <td class="bg-gray right">经营范围</td>
            <td colspan="3">${midBaseInfo.opScope}</td>

        </tr>  
        
        <tr>
            <td class="bg-gray right">联系电话</td>
            <td > ${midBaseInfo.tel }</td>
            <td class="bg-gray right">核准日期</td>
            <td colspan="3"><fmt:formatDate value="${midBaseInfo.apprDate }" pattern="yyyy-MM-dd"/></td>

        </tr>  
    </table>
    <div>
        <div class="clearfix mb5 mt5">
            <p class="h4-title">企业年报记录</p>
        </div>
        <table border="0" cellspacing="0" cellpadding="0" class="table-row mt30">
            <tbody>
            <tr>
                <th width="7%">序号</th>
                <th width="13%">企业名称</th>
                <th width="13%">法定代表人</th>
                 <th width="13%">年报状态</th>
                <th width="7%">年报年度</th>
                <th width="8%">首次报告时间</th>
                <th width="13%">最近报告时间</th>
            </tr>
   <input type="hidden" name="oldpriPID" id="oldpriPID" value="${oldpriPID}">
       <c:forEach items="${checkList}" var="item" varStatus="status">
                <tr>
             

                    <td>${status.index}</td>
                    <td>${item.entName }</td>
                    <td>${item.leRep}</td>
                    <td>
                        <c:if test="${item.isReported=='0' }">未年报</c:if>
                        <c:if test="${item.isReported=='1' }">已年报</c:if>
                          <c:if test="${item.isReported=='2' }">已年报（已逾期）</c:if>

                    </td>
                    <td>${item.year }</td>
                    <td><fmt:formatDate value="${item.firstReportTime }" pattern="yyyy-MM-dd"/></td>
                    <td><fmt:formatDate value="${item.lastReportTime }" pattern="yyyy-MM-dd"/></td>
                </tr>
            </c:forEach>
 
            </tbody>
        </table>
    </div>
    <div class="clearfix mb5 mt5">
            <p class="h4-title">企业年报回导</p>
        </div>
    <table border="0" cellspacing="0" cellpadding="0" class="table-row mt30">
     <tr>
     <td class="bg-gray">是否需要回导</td>
     <td colspan="3"><c:if test="${ifreturn=='false' }">不需要</c:if><c:if test="${ifreturn=='true' }">需要</c:if></td> 
     </tr>
      <tr>
     <td class="bg-gray">回导操作</td>
     <td colspan="3"><c:if test="${ifreturn=='false' }">无</c:if><c:if test="${ifreturn=='true' }">
     <input type="button" id="dataReturn" value="回导" class="btn">
     </c:if></td> 
     </tr>
    </table>

</div>
<div class="form-item clearfix">
    <div class="btn-box">

        <input type="button" id="cancel" value="关闭" class="btn">
    </div>
</div>

</body>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/yr/datareturn/datareturn_main.js"></script>
 
</html>