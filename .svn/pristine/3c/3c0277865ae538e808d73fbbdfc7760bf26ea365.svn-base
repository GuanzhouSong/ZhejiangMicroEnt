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
 	<meta http-equiv="X-UA-Compatible" content="IE=8" >
    <title>证照联动_涉证企业分流</title>
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body>
<jsp:useBean id="nowdate" class="java.util.Date" />
<fmt:formatDate var="nowdate" value="${nowdate}" pattern="yyyy-MM-dd"/>
<div class="pd20 clearfix">
<input type="hidden"  id="licDepType"  value="${codeLicense.licDeptType}" >
    <h4 class="h4-title">企业信息</h4>
    <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
        <tbody>
        <tr>
            <td class="bg-gray right" width="10%">统一代码</td>
            <td width="40%">${pubDtInfo.uniSCID}</td>
            <td class="bg-gray right" width="10%">注册号</td>
            <td>${pubDtInfo.regNO}</td>
        </tr>
        <tr>
            <td class="bg-gray right">企业名称</td>
            <td>${pubDtInfo.entName}</td>
            <td class="bg-gray right">注册资本</td>
            <td>
	           <c:if test="${not  empty pubDtInfo.regCap}">
	               <fmt:formatNumber value="${pubDtInfo.regCap}" pattern="###,###,###,##0.0000"/>万元                 
	           </c:if>
            </td>
        </tr>
        <tr>
            <td class="bg-gray right">是否个转企</td>
            <td>
                <c:if test="${pubDtInfo.isIndivid==1}">
	                                     是
	            </c:if>
	            <c:if test="${pubDtInfo.isIndivid==0}">
	                                     否
	            </c:if> 
            </td>
            <td class="bg-gray right">住所</td>
            <td>${pubDtInfo.dom}</td>
        </tr>
        <tr>
            <td class="bg-gray right">企业类型</td>
            <td>${codeEntType.content}</td>
            <td class="bg-gray right">行业类型</td>
            <td>${codeInDusTry.content}</td>
        </tr>
        <tr>
            <td class="bg-gray right">成立日期</td>
            <td><fmt:formatDate value="${pubDtInfo.estDate}" type="date" pattern="yyyy-MM-dd"/></td>
            <td class="bg-gray right">核准日期</td>
            <td><fmt:formatDate value="${pubDtInfo.apprDate}" type="date" pattern="yyyy-MM-dd"/></td>
        </tr>
        <tr>
            <td class="bg-gray right">经营范围</td>
            <td colspan="3" class="td-font-18">${pubDtInfo.opScope}</td>
        </tr>
        <tr>
            <td class="bg-gray right">法定代表人</td>
            <td>${pubDtInfo.leRep}</td>
            <td class="bg-gray right">联系电话</td>
            <td>${pubDtInfo.tel}</td>
        </tr>
        <tr>
            <td class="bg-gray right">企业联络员</td>
            <td></td>
            <td class="bg-gray right">联系电话</td>
            <td></td>
        </tr>
        <tr>
            <td class="bg-gray right">登记机关联络员</td>
            <td>${codeRegorg.liaName}</td>
            <td class="bg-gray right">联系电话</td>
            <td>${codeRegorg.liaPhone}</td>
        </tr>
        <tr>
            <td class="bg-gray right">审批部门联络员</td>
            <td>${sysDepartList[0].liaName}</td>
            <td class="bg-gray right">联系电话</td>
            <td>${sysDepartList[0].liaPhone}</td>
        </tr>
        <tr>
            <td class="bg-gray right light">审批机关</td>
            <td>${pubDtInfo.reassignDeptName}</td>
            <td class="bg-gray right light">后置审批事项名称</td>
            <td class="light">${pubDtInfo.exaName}</td>
        </tr>
        <tr>
            <td class="bg-gray right">推送方式</td>
            <td>
               <c:if test="${pubDtInfo.checkPushType==0}">
	                                     退回待推送               
	            </c:if>
	            <c:if test="${pubDtInfo.checkPushType==1}">
	                                     自动分流               
	            </c:if>
	            <c:if test="${pubDtInfo.checkPushType==2}">
	                                    手动分流             
	            </c:if>
	            <c:if test="${pubDtInfo.checkPushType==3}">
	                                     分流失败               
	            </c:if>
            </td>
            <td class="bg-gray right">推送日期</td>
            <td><fmt:formatDate value="${pubDtInfo.checkPushDate}" type="date" pattern="yyyy-MM-dd"/></td>
        </tr>
        <c:if test="${pubDtInfo.checkPushType==3}">
		    <tr>
	            <td class="bg-gray right">推送失败原因</td>
	            <td colspan="3" class="td-font-18">${pubDtInfo.reassignRemark}</td>
	            <!-- <td class="bg-gray right"></td>
	            <td></td> -->
	        </tr>           
	    </c:if>
       
        
        </tbody>
    </table>
    <!-- 回退 -->
    <c:if test="${pubDtInfo.reassignType==2}">
        <h4 class="h4-title">回退信息</h4>
	    <table border="0" cellspacing="0" cellpadding="0" class="table-horizontal mb5">
	        <tbody>
	        <tr>
	            <td class="bg-gray right light" width="10%">退回人</td>
	            <td width="40%">
	                <div class="ipt-box col-12">
	                  ${pubDtInfo.reassignName}
	                </div>
	            </td>
	            <td class="bg-gray right" width="10%">联系电话</td>
	            <td><span > 
	                  <c:choose>
	                     <c:when test="${not empty rebackUser.telPhone && not empty rebackUser.phone}">
	                        ${rebackUser.telPhone}、 ${rebackUser.phone}
	                     </c:when>
	                     <c:when test="${empty rebackUser.telPhone&&not empty rebackUser.phone }">
	                         ${rebackUser.phone}
	                     </c:when>
	                     <c:when test="${empty rebackUser.phone&&not  empty rebackUser.telPhone }">
	                         ${rebackUser.telPhone}
	                     </c:when>
	                  </c:choose> 
	               </span>
	            </td>
	        </tr>
	        <tr>
	            <td class="bg-gray right light">推送机关类型</td>
	            <td>
	                <div class="ipt-box col-12">
	                    <c:if test="${pubDtInfo.checkDeptType==1}">
	                                                                审批机关
	                    </c:if>
	                    <c:if test="${pubDtInfo.checkDeptType==2}">
	                                                               属地机关
	                    </c:if>
	                    <c:if test="${pubDtInfo.checkDeptType==3}">
	                                                                审批机关
	                    </c:if> 
	                </div>
	            </td>
	            <td class="bg-gray right light" width="10%">审批机关</td>
	            <td><span class="light">${pubDtInfo.reassignDeptName}</span></td>
	        </tr>
	         <tr>
	            <td class="bg-gray right light">后置审批事项</td>
	            <td>
	                <div class="ipt-box col-12 light">
	                    ${pubDtInfo.exaName}
	                </div>
	            </td>
	            <td class="bg-gray right" width="10%">退回理由</td>
	            <td><span >
                    <c:if test="${pubDtInfo.reassignCode==0}">
	                                                                经营范围内无此审批事项
	                </c:if>
                    <c:if test="${pubDtInfo.reassignCode==1}">
                                                                            经营范围不在审批部门的管辖范围内
                    </c:if>
	                <c:if test="${pubDtInfo.reassignCode==2}">
	                                                                地址不在审批部门的管辖范围内
	                </c:if>
               </span></td>
	        </tr>
	         <tr>
	            <td class="bg-gray right light">退回日期</td>
	            <td>
	                <div class="ipt-box col-12">
	                     <fmt:formatDate value="${pubDtInfo.reassignDate}" type="date" pattern="yyyy-MM-dd"/>
	                </div>
	            </td>
	            <td class="bg-gray right" width="10%">备注</td>
	            <td>
	            <span >
	                ${pubDtInfo.reassignRemark}
	            </span></td>
	        </tr>
	        </tbody>
	    </table>
    </c:if>
    
    <h4 class="h4-title">人工分流</h4>
    <div class="light-info left">
        <span class="light">提示：请选择指定审批机关。</span>
    </div>
    <table border="0" cellspacing="0" cellpadding="0" class="table-horizontal mb5">
        <tbody>
        <tr>
            <td class="bg-gray right light" width="10%">* 后置审批事项</td>
            <td width="40%">
                <div class="ipt-box col-12">
                    <input type="text" id="licName"  class="fl ipt-txt" value="${pubDtInfo.exaName}" disabled="disabled">
                   <!--  <input type="text" class="fl ipt-txt" placeholder="选择"> -->
                    <span class="add-icon"  id="yccodetree"><i></i></span>
                </div>
            </td>
            <td class="bg-gray right" width="10%">后置审批机关</td>
            <td><span id="exaCodetext">${codeLicense.licDept}</span></td>
        </tr>
        <tr>
            <td class="bg-gray right light">* 指定审批机关</td>
            <td>
                <div class="ipt-box col-12">
                     <input type="text" id="deptname" class="fl ipt-txt" value=""  placeholder="请选择"   disabled="disabled">         
                     <span id="selectDept" class="add-icon"><i></i></span>
                </div>
            </td>
            <td colspan="2"></td>
        </tr>
        </tbody>
    </table>
    <h4 class="h4-title">终止推送</h4>
    <div class="light-info left">
        <span class="light">提示：如果确定不涉及该项后置审批，请选择“是否终止推送项”为：是。终止后的信息不再参与推送，请谨慎操作。</span>
    </div>
    <table border="0" cellspacing="0" cellpadding="0" class="table-horizontal mt30">
        <tbody>
        <tr>
            <td class="left light" width="50%" colspan="2">
                                      该企业不涉及该项后置审批，是否终止推送:<input type="radio" name="pubdtinfostop" value="1">是  <input type="radio" name="pubdtinfostop" value="0" checked="checked">否
            </td>
            <!-- <td width="40%">
                <div class="ipt-box col-2">
                    <select id="pubdtinfostop" >
                         <option value="1">是</option>
                   	     <option value="0" selected="selected">否</option>
                    </select> 
                </div>
            </td> -->
            <td class="left" width="10%"><span class="light">* </span>终止理由</td>
            <td>
                <div class="ipt-box col-7">
                    <select id="pubdtinforemark" >
                        <option value="" selected="selected">请选择</option>
                        <option value="不涉及该项后置审批，终止推送">不涉及该项后置审批，终止推送</option>  
                    </select>
                </div>
            </td>
        </tr>
        <tr style="display:none; " id="pubdtinfostopinfo">
            <td class="bg-gray left light" width="10%" >终止日期</td>
            <td width="40%">
                <div class="ipt-box col-6">
                     <span id="pubdtinfostopdate"></span>
                </div>
            </td>
            <td class="bg-gray right" width="10%"></td>
            <td>
                 
            </td>
        </tr>
        </tbody>
    </table>
    <!-- 传递参数区域 -->
    <form  id="pubdtinfohandpushform"> 
        <input type="hidden"  id="checkDep" name="checkDep" value="${pubDtInfo.checkDep}" >
        <input type="hidden"  id="checkStopState" name="checkStopState" value="${pubDtInfo.checkStopState}" >
        <input type="hidden"  id="uid" name="uid" value="${pubDtInfo.uid}" >
        <input type="hidden"  id="exaName" name="exaName" value="${pubDtInfo.exaName}" >
        <input type="hidden"  id="exaCode" name="exaCode" value="${pubDtInfo.exaCode}" >
        <input type="hidden"  id="reassignRemark" name="reassignRemark" value="" >
        <input type="hidden"  id="checkDepName" name="checkDepName" value="${pubDtInfo.checkDepName}" >
        <input type="hidden"  id="priPID" name="priPID" value="${pubDtInfo.priPID}" >
        <input type="hidden"  id="checkPushType" name="checkPushType" value="${pubDtInfo.checkPushType}" >
        <input type="hidden"  id="dutyDeptCode" name="dutyDeptCode" value="${pubDtInfo.dutyDeptCode}" >
        <input type="hidden"  id="dutyDeptName" name="dutyDeptName" value="${pubDtInfo.dutyDeptName}" > 
     </form>
    <p class="center mt20"><input type="button" id="savepubdtinfohandpush" class="btn mr20" value="确 定"><input type="button" id="cancelpubdtinfohandpush" class="btn" value="关闭"></p>
</div>
 <script src="<c:url value="/js/lib/require.js"/>"></script>
 <script src="<c:url value="/js/config.js"/>"></script>
 <script src="<c:url value="/js/syn/system/pubdtinfo/pubdtinfohandpush_edit_main.js"/>"></script>
 <script>
    window._CONFIG = {
       _checkClaimState:'${pubDtInfo.claimState}', //认领状态 
       _checkReceiveState:'${pubDtInfo.receiveState}',  //接收状态
       _checkDepttype:'${pubDtInfo.checkDeptType}',
       _nowdate:'${nowdate}',
       _sysUrl:'${sysUrl}'
    }
</script>
</body>
</html>