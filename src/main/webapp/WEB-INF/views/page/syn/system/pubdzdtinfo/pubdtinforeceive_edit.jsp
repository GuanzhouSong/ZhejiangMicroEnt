<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean id="nowdate" class="java.util.Date" />
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8"> 
    <title>多证合一接收页面</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/syn.css">      
</head>
<body>
<div class="pd20 clearfix">
     <h4 class="h4-title">企业信息</h4>
       <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mb5">
           <input type="hidden" id="receiveState" value="${pubDtInfoDto.receiveState }"/>
           <input type="hidden" id="claimState" value="${pubDtInfoDto.claimState }"/>       
           <tbody>
           <tr>
               <td class="bg-gray right" width="15%">统一代码</td>
               <td width="35%">${pubDtInfoDto.uniSCID }</td>
               <td class="bg-gray right" width="15%">注册号</td>
               <td>${pubDtInfoDto.regNO }</td>
           </tr>
           <tr>
               <td class="bg-gray right">企业名称</td>
               <td>${pubDtInfoDto.entName }</td>
               <td class="bg-gray right">注册资本</td>
               <td><fmt:formatNumber value="${pubDtInfoDto.regCap }" pattern="###,###,###,##0.0000"/>万元</td>
           </tr>
           <tr>
               <td class="bg-gray right">是否个转企</td>
               <td><c:if test="${pubDtInfoDto.isIndivid==1}"> 是</c:if>
	            <c:if test="${pubDtInfoDto.isIndivid==0}">否</c:if></td>
               <td class="bg-gray right">住所</td>
               <td>${pubDtInfoDto.dom }</td>
           </tr>
           <tr>
               <td class="bg-gray right">企业类型</td>
               <td>${pubDtInfoDto.entCatgName }</td>
               <td class="bg-gray right">行业类型</td>
               <td>${pubDtInfoDto.industryName }</td>
           </tr>
           <tr>
               <td class="bg-gray right">成立日期</td>
               <td><fmt:formatDate value="${pubDtInfoDto.estDate }" pattern="yyyy年MM月d日"/></td>
               <td class="bg-gray right">核准日期</td>
               <td><fmt:formatDate value="${pubDtInfoDto.apprDate }" pattern="yyyy年MM月d日"/></td>
           </tr>
           <tr>
               <td class="bg-gray right">经营范围</td>
               <td colspan="3" class='td-font-18'>${pubDtInfoDto.opScope }</td>
           </tr>
           <tr>
               <td class="bg-gray right">法定代表人</td>
               <td>${pubDtInfoDto.leRep }</td>
               <td class="bg-gray right">联系电话</td>
               <td>${pubDtInfoDto.tel }</td>
           </tr>
           <tr>
               <td class="bg-gray right">企业联络员</td>
               <td></td>
               <td class="bg-gray right">联系电话</td>
               <td></td>
           </tr>
           <tr>
               <td class="bg-gray right">登录机关联络员</td>
               <td>${codeRegorg.liaName }</td>
               <td class="bg-gray right">联系电话</td>
               <td>${codeRegorg.liaPhone }</td>
           </tr>
            <tr>
               <td class="bg-gray right">备案部门联络员</td>
               <td>${sysDepart.liaName}</td>
               <td class="bg-gray right">联系电话</td>
               <td>${sysDepart.liaPhone}</td>
           </tr>          
           <tr>
               <td class="bg-gray right light">备案机关</td>
               <td class="light">${pubDtInfoDto.checkDepName }</td>
               <td class="bg-gray right light">备案事项名称</td>
               <td class="light">${pubDtInfoDto.exaName }</td>
           </tr>
            <tr>
               <td class="bg-gray right">推送方式</td>
               <td><c:if test="${pubDtInfoDto.checkPushType==0}">
	                                     退回待推送               
	            </c:if>
	            <c:if test="${pubDtInfoDto.checkPushType==1}">
	                                     自动推送               
	            </c:if>
	            <c:if test="${pubDtInfoDto.checkPushType==2}">
	                                    手动推送            
	            </c:if>
	            <c:if test="${pubDtInfoDto.checkPushType==3}">
	                                     推送失败               
	            </c:if></td>
               <td class="bg-gray right">推送日期</td>
               <td><fmt:formatDate value="${pubDtInfoDto.checkPushDate }" pattern="yyyy年MM月d日"/></td>
           </tr>
          <c:if test="${pubDtInfoDto.checkPushType==3}">
          <tr>
              <td class="bg-gray right">推送失败原因</td>
              <td colspan="3">${pubDtInfoDto.reassignRemark}</td>                            
          </tr>
          </c:if>           
           </tbody>
       </table>
       <br>
       <!-- 备案信息 -->
	   <jsp:include page="pubdtinfobeian_edit.jsp" flush="true"></jsp:include>        
        <!-- 已接收 -->
		<c:if test="${ pubDtInfoDto.receiveState =='1'}">
		<h4 class="h4-title" >接收信息</h4>					
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mb10">
		<tbody>
		<tr>
			<td class="bg-gray right"  width="15%">接收人</td>
			<td width="35%">${pubDtInfoDto.acceptName}</td>
			<td class="bg-gray right" width="15%">接收日期</td>
			<td><fmt:formatDate value="${pubDtInfoDto.acceptDate}" pattern="yyyy年MM月dd日"/></td>
		</tr> 
		</tbody>
	    </table>
	    </c:if>
	    
	    
	    <!-- 已认领 -->
	    <c:if test="${pubDtInfoDto.claimState=='1' }">
		<h4 class="h4-title">认领信息</h4>					
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mb5">
		<tbody>
		<tr>
			<td class="bg-gray right"  width="15%">认领人</td>
			<td width="35%">${pubDtInfoDto.claimName}</td>
			<td class="bg-gray right"  width="15%">认领日期</th>
			<td ><fmt:formatDate value="${pubDtInfoDto.claimDate}" pattern="yyyy年MM月d日"/></td>
		</tr> 
		</tbody>
	    </table>
	    </c:if>	
	    
	    <!-- 已回退 -->
	    <c:if test="${ not empty pubDtInfoDto.reassignName && pubDtInfoDto.reassignType == '2' }">
		<h4 class="h4-title">回退信息</h4>					 
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mb5">
		<tbody>
        <tr>
			<td class="bg-gray right"  width="15%">退回人</th>
			<td width="35%">${pubDtInfoDto.reassignName}</td>
			<td class="bg-gray right"  width="15%">联系电话</th>
		    <td >${reassignSysUser.phoneExt}</td>
		</tr> 
		<tr>
		    <td class="bg-gray right" >退回日期</th>
			<td><fmt:formatDate value="${pubDtInfoDto.reassignDate}" pattern="yyyy年MM月d日"/></td>
		    <td class="bg-gray right">退回理由</th>
		    <td>
		     <c:if test="${pubDtInfoDto.reassignCode==0}">经营范围内无此备案事项</c:if>
		     <c:if test="${pubDtInfoDto.reassignCode==1}">经营范围不在备案部门的管辖范围内</c:if>
		     <c:if test="${pubDtInfoDto.reassignCode==2}">地址不在备案部门的管辖范围内</c:if>
		     </td>
		</tr>
		<tr>
			<td class="bg-gray right" >备    注</th> 
		    <td colspan="3" style="height:50px;">${pubDtInfoDto.reassignRemark}</td>
		</tr> 
		<tbody>
	    </table>
	    </c:if>	
	    <!-- 已回退 -->
	    <c:if test="${not empty pubDtInfoDto.reassignName && pubDtInfoDto.reassignType == '1' }">
		<h4 class="h4-title">重新指派信息</h4>					 
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mb5">
		<tbody>
        <tr>
			<td class="bg-gray right"  width="15%">重新指派操作人</th>
			<td width="35%">${pubDtInfoDto.reassignName}</td>
			<td class="bg-gray right"  width="15%">联系电话</th>
		    <td >${reassignSysUser.phoneExt}</td>
		</tr> 
		<tr>
		    <td class="bg-gray right" >重新指派操作日期</th>
			<td><fmt:formatDate value="${pubDtInfoDto.reassignDate}" pattern="yyyy年MM月d日"/></td>
		    <td class="bg-gray right light">重新指派操作部门</th>
		    <td class="light">${pubDtInfoDto.reassignDeptName}</td>
		</tr>
		<tr>
			<td class="bg-gray right" >备    注</th> 
		    <td colspan="3" style="height:50px;">${pubDtInfoDto.reassignRemark}</td>
		</tr> 
		<tbody>
	    </table>
	    </c:if>	
                 
                 
       <div id ="btnDiv" style="display:none;">
		<!-- 认领/回退信息 -->
		<c:if test="${pubDtInfoDto.checkDeptType == '1'}">
	      <h4 class="h4-title">认领信息</h4>
           <form id ="claimForm" class="mb10">
           <input type="hidden" name="uid" value="${pubDtInfoDto.uid }"/>
           <input type="hidden" name="priPID" value="${pubDtInfoDto.priPID }"/>
           <input type="hidden" name="checkDeptType" value="${pubDtInfoDto.checkDeptType}"/>
           <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mb10">
		   <tbody>
	       <tr>
              <td class="bg-gray right light" width="15%" >认领人</td>
              <td width="35%">
                  <div class="ipt-box">
                      <input type="text" name="claimName" class="fl ipt-txt" value="${sysUser.realName}" readonly="readonly" />
                  </div>
              </td>
             <td class="bg-gray right" width="15%" >认领日期</td>
		     <td><div class="ipt-box"><fmt:formatDate value="${nowdate}" pattern="yyyy-MM-dd"/></div></td>
	      </tr>
	      </tbody>
	      </table>
	      </form>
	     <div class="center mb10">
	        <input type="button" class="btn mr20" value="认 领" id="claim">
	        <input type="button" class="btn" value="回 退" id="reback">
	     </div>
	     <div class="light-info center"><span class="light f14">企业所涉备案事项确认由你部门备案请点击“认领”，否则请点击“回退”</span></div>
		 </c:if>
		
		<!-- 接收信息 -->
		<c:if test="${pubDtInfoDto.checkDeptType != '1'}">
		   <h4 align="left">接收信息</h4>
		   <form id ="receiveForm">
           <input type="hidden" name="uid" value="${pubDtInfoDto.uid }"/>
           <input type="hidden" name="priPID" value="${pubDtInfoDto.priPID }"/>
           <input type="hidden" name="checkDeptType" value="${pubDtInfoDto.checkDeptType}"/>
		    <table border="0" cellspacing="0" cellpadding="0" class="table-horizontal mb10">
		        <tbody>
		        <tr>
		            <td class="bg-gray right light" width="15%">接收人</td>
		            <td width="35%">
                       <div class="ipt-box">
                       <input type="text" name="acceptName" value="${sysUser.realName}" readonly="readonly" class="fl ipt-txt"/>
		               </div>
		            </td>
		            <td class="bg-gray right" width="15%">接收日期</td>
		            <td><div class="ipt-box"><fmt:formatDate value="${nowdate}" pattern="yyyy-MM-dd"/></div></td>
		        </tr>
		        </tbody>
		    </table>
		    <div class="center">
		        <input type="button" class="btn" value="接 收" id="receive">
		        <input type="button" class="btn" value="回 退" id="reback">
		    </div>
		    <div class="light-info center"><span class="light bold f14">企业所涉备案事项确认由你部门接收请点击“接收”。</span></div>					    
		</c:if> 
	  </div>   
</div>
</body>
<script>
    window._CONFIG = {
       _uid:'${pubDtInfoDto.uid}', 
       _priPID:'${pubDtInfoDto.priPID}',
       chooseUrl:'${userType == 2 ? "/syn" : "/reg/server"}'      
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/pubdzdtinfo/pubdtinforeceive_edit.js"></script>
</html>