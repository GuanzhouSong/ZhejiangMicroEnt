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
<body class="pd10">
  <input type="hidden" id="userType" value="${userType }">
<div>
   <!--  <div class="bg-gray2 clearfix company-info-title"><h3 class="h3-title">杭州若泉贸易有限公司</h3>注册号：330104000299976</div>
    <h4 class="h4-title mt10">企业基本信息</h4> -->
    
      
    <div class="clearfix mb5 mt5">
       <p class="h4-title">许可信息</p>
    </div>
    <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
        <tr>
              <td class="bg-gray right" width="20%">注册号详情</td>
            <td width="30%">${pubOtherlicence.regNO }</td> 
            <td class="bg-gray right" width="20%">企业名称</td>
            <td width="30%">${pubOtherlicence.entName }</td>
          
        </tr>
        <tr>
            <td class="bg-gray right" width="20%">许可文件编号</td>
            <td width="30%">${pubOtherlicence.licNO }</td>
            <td class="bg-gray right" width="20%">许可文件名称</td>
            <td width="30%">${pubOtherlicence.licNameCN }</td>
        </tr>
        <tr>
            <td class="bg-gray right" width="20%">有效起止日期</td>
            <td width="30%"><fmt:formatDate value="${pubOtherlicence.licValFrom }" pattern="yyyy-MM-dd" />~
            <fmt:formatDate value="${pubOtherlicence.licValTo }" pattern="yyyy-MM-dd" /></td>
            <td class="bg-gray right" width="20%">许可机关</td>
            <td width="30%">${pubOtherlicence.licAnth }</td>
        </tr>
        
        <tr>
            <td class="bg-gray right" >许可内容(限制500字)</td>
            <td colspan="3"> ${pubOtherlicence.licScope }
            </td>
           
        </tr>
    </table> 
    
   
    
    <div class="form-box   pdr20">
    <p class="h4-title">     审核信息</p>
         <form id="auditForm">
         <input type="hidden" name="licID" value="${pubOtherlicence.licID}">
          <input type="hidden" name="priPID" value="${pubOtherlicence.priPID}">
           <input type="hidden" name="licNO" value="${pubOtherlicence.licNO}">
      <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
        <tr>
              <td class="bg-gray right" width="20%">录入人</td>
            <td width="30%">${pubOtherlicence.setName}</td> 
            <td class="bg-gray right" width="20%">录入日期</td>
            <td width="30%"> <fmt:formatDate value="${pubOtherlicence.setDate }" pattern="yyyy-MM-dd" /></td>
          
        </tr>
        <tr>
              <td class="bg-gray right" width="20%">审核人</td>
            <td width="30%">${sessionScope.session_sys_user.realName}
            <input type="hidden" name="auditName" value="${sessionScope.session_sys_user.realName}">
            </td> 
            
            <td class="bg-gray right" width="20%">审核日期</td>
            <td width="30%"><fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd" />
            <input type="hidden" name="auditDate" value="<fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd" />">
            </td>
            
        </tr>
        
        <tr>
              <td class="bg-gray right" width="20%">审核结果</td>
            <td  width="30%">   <label><input type="radio" class="required" id="checksuc" name="auditState" value="1">通过</label>
                    <label><input type="radio" class="required" id="checkfal" name="auditState"value="2">不通过</label></td>  
            <td class="bg-gray right" width="20%">审核意见</td>
            <td  width="30%">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" name="auditOpin" class="required" id="auditOpin">
                </div>
            </td>
          
        </tr> 
         
    </table> 
            
            <div class="form-item clearfix  ">
            <div class="btn-box mt20 pdr20">
                <input type="submit"  id="save" value="保 存" class="btn mr20">
                <input type="button" value="关 闭" id="cancel" class="btn">
            </div>
        </div>
            
        </table>
        </form> 
        
    </div>
</div>
</body>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/other/otherlicence/otherlicence_audit_main.js"></script>
</html>