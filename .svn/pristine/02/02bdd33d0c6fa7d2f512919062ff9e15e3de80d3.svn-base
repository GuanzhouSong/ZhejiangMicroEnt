<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:useBean id="nowdate" class="java.util.Date" />
<!doctype html>
<html lang="en">
<head>
 	<meta http-equiv="X-UA-Compatible" content="IE=8" >
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>异常名录查询详情</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<style>
#unusualCatalog {
	padding:0px;
	margin:0px;
    overflow-x: hidden;
    overflow-y: auto;
    height: 100px;
}
.warn {
    background:#F00 !important;
    color:#FFF !important
}
#form select,#form textarea{background:#F4F8F9;}
</style>
<body class="pd10">
	  <div class="main">
		<h1 id="title"></h1>
		<form id="pubauditosaveform"  >
             <div class="listBox2 thBg">
             <!-- 参数传递列表 -->
             <input type="hidden" name="priPID" id="priPID" value="${pubOpaDetail.priPID}"> 
             <input type="hidden" name="busExcList" id="busExcList" value="${pubOpaDetail.busExcList}">
             <input type="hidden" name="regOrg" id="regOrg" value="${pubOpaDetail.regOrg}">  
             <input type="hidden" name="auditName" value="${sysUser.realName}"> 
             <input type="hidden" name="auditState" id="auditState" value="">  
             <input type="hidden" name="auditDept" id="auditDept" value="${sysUser.dept}"> 
             <input type="hidden" name="operate" value="0"> 
                <div class="leftTop"></div>
                <div class="right1Top"></div>
                <table class="table-horizontal">
                    <tr id="appBasic">
                        <td class="bg-gray right" width="100px"><div class="tdBox">企业名称 </div></td>
                        <td width="270px"><div class="tdBox">${pubOpanoMaly.entName}</div></td>
	                    <td class="bg-gray right" width="100px"><div class="tdBox">注册号</div></td>
	                    <td width="180px"><div class="tdBox">${pubOpanoMaly.regNO}</div></td>
	                    <td class="bg-gray right" width="100px"><div class="tdBox">成立日期</div></td>
	                    <td width="150px"><div class="tdBox"><fmt:formatDate value="${empty midBaseInfoDto?pubOpanoMaly.estDate:midBaseInfoDto.estDate}" type="date" pattern="yyyy-MM-dd"/></div></td>
	                </tr>
	                <tr id="appBasic">
                        <td class="bg-gray right"><div class="tdBox">登记机关</div></td>
                        <td><div class="tdBox">${codeRegorg.content}</div></td>
                        <td class="bg-gray right"><div class="tdBox">法定代表人</div></td>
                        <td><div class="tdBox" >${empty midBaseInfoDto?pubOpanoMaly.leRep:midBaseInfoDto.leRep}</div></td>
	                    <td class="bg-gray right"><div class="tdBox">联系电话</div></td>
	                    <td><div class="tdBox">${empty midBaseInfoDto?'':midBaseInfoDto.tel}</div></td>
	                </tr>
	                <tr>
	                	<td class="bg-gray right"><div class="tdBox">列入状态</div></td>
                        <td><div class="tdBox">
                            <c:choose>
                               <c:when test="${empty  pubOpaDetail}">
                                  	 未移出
                               </c:when>
                               <c:otherwise>
                                     <c:if test="${pubOpaDetail.isMove==1}"> 
			                             ${pubOpaDetail.auditState == '1' ? '已移出' : '未移出'} 
			                         </c:if> 
			                         <c:if test="${pubOpaDetail.isMove==2}"> 
			                             ${pubOpaDetail.auditState == '1' ? '已撤销' : '未撤销'} 
			                         </c:if> 
                               </c:otherwise>
                            </c:choose>
                        </div></td>
                        <td class="bg-gray right"><div class="tdBox">公示状态</div></td>
                        <td><div class="tdBox">
                             ${pubOpanoMaly.auditState == '1' ? '已公示' : '未公示'} 
                        </div>
                        </td>
	                    <td class="bg-gray right"><div class="tdBox">管辖单位</div></td>
	                    <td><div class="tdBox">${codeRegunit.content}</div></td> 
	                </tr>
	                <tr>
	                	<td class="bg-gray right"><div class="tdBox">责任区</div></td>
                        <td><div class="tdBox">${midBaseInfoDto.sliceNOName}</div></td>
                        <td class="bg-gray right"><div class="tdBox">联络员</div></td>
                        <td><div class="tdBox">${pubEppassword.lianame}</div></td>
	                    <td class="bg-gray right"><div class="tdBox">联络员电话</div></td>
	                    <td><div class="tdBox">${pubEppassword.tel}</div></td> 
	                </tr>
	            </table>
        	</div>
        	<br />
        	<!-- 列入 -->
        	<div class="listBox2 thBg">
                    <div class="leftTop"></div>
                    <div class="right1Top"></div>
                    <table class="table-horizontal">
           	        	<tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center" width="100px"><div class="tdBox">列入文号</div></td>
                        	<td colspan="5" width="890px"><div class="tdBox">${pubOpanoMaly.penDecNo}</div></td>
                        </tr>
                    	<tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center"><div class="tdBox">列入原因</div></td>
                        	<td colspan="5" width="890px"><div class="tdBox">${pubOpanoMaly.speCauseCN}</div></td>
                        </tr> 
                        <tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center"><div class="tdBox" style="width:100px;"><font color="red"> </font>列入事实和事由</div></td>
                            <td colspan="5"><div class="tdBox"><textarea  class="txt_1" disabled="disabled">${pubOpanoMaly.anomalyRea}</textarea></div></td>
                        </tr>
                        <tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center"><div class="tdBox"><font color="red"> </font>初审意见</div></td>
                            <td colspan="5"><div class="tdBox"><textarea  class="txt_1" disabled="disabled">${pubOpanoMaly.firstOpin}</textarea></div>
                            </td>
                        </tr>
                        <tr>
                        	<td class="bg-gray right" width="100" valign="middle" class="lb_1" style="text-align:center"><div class="tdBox">初审日期</div></td>
                            <td width="180"><div class="tdBox"><fmt:formatDate value="${pubOpanoMaly.firstdate}" pattern="yyyy-MM-dd"/></div></td>
                            <td class="bg-gray right" width="120" valign="middle" class="lb_1" style="text-align:center"><div class="tdBox">初审人</div></td>
                            <td width="170"><div class="tdBox">${pubOpanoMaly.firstName}</div></td>
                            <td class="bg-gray right" width="130" valign="middle" class="lb_1" style="text-align:center"><div class="tdBox">初审部门</div></td>
                            <td width="250"><div class="tdBox">${pubOpanoMaly.firstDept}</div></td>
                        </tr>
                        <tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center"><div class="tdBox"><font color="red"> </font>审核意见</div></td>
                            <td colspan="5"><div class="tdBox"><textarea  class="txt_1" disabled="disabled">${pubOpanoMaly.auditOpin}</textarea></div>
                            </td>
                        </tr>
                        <tr>
                        	<td class="bg-gray right" width="100" valign="middle" class="lb_1" style="text-align:center"><div class="tdBox">审核日期</div></td>
                            <td width="180"><div class="tdBox"><fmt:formatDate value="${pubOpanoMaly.auditDate}" pattern="yyyy-MM-dd"/></div></td>
                            <td class="bg-gray right" width="120" valign="middle" class="lb_1" style="text-align:center"><div class="tdBox">审核人</div></td>
                            <td width="170"><div class="tdBox">${pubOpanoMaly.auditName}</div></td>
                            <td class="bg-gray right" width="130" valign="middle" class="lb_1" style="text-align:center"><div class="tdBox">审核部门</div></td>
                            <td width="250"><div class="tdBox">${pubOpanoMaly.auditDept}</div></td>
                        </tr>
                        <tr>
                        	<td class="bg-gray right" width="100" valign="middle" class="lb_1" style="text-align:center"><div class="tdBox">列入日期</div></td>
                            <td width="180"><div class="tdBox"><fmt:formatDate value="${pubOpanoMaly.abnTime}" pattern="yyyy-MM-dd"/></div></td>
                            <td class="bg-gray right" width="120" valign="middle" class="lb_1" style="text-align:center"><div class="tdBox">作出决定机关</div></td>
                            <td width="170"><div class="tdBox">${pubOpanoMaly.decorgCN}</div></td>
                            <c:if test="${not empty pubOpanoMaly.deptUpName && not empty pubOpanoMaly.deptSameCourt && not empty pubOpanoMaly.deptSameGov}">
                            <td class="bg-gray right" width="130" valign="middle" class="lb_1" style="text-align:center"><div class="tdBox">生成决定书</div></td>
                            <td width="250"><div class="tdBox"><a href="javascript:void(0);" id="printpubopanomalyentbook" >${pubOpanoMaly.penDecNo}</a></div></td>
                            </c:if> 
                        </tr> 
                    </table>
                </div>
                <!-- 移出 -->
                <c:if test="${not empty  pubOpaDetail  && pubOpaDetail.auditState=='1'}">
                <br></br>
                <div class="listBox2 thBg">
                    <div class="leftTop"></div>
                    <div class="right1Top"></div>
                    <table class="table-horizontal">
           	        	<tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center" width="100px"><div class="tdBox">移出文号</div></td>
                        	<td colspan="5" width="890px"><div class="tdBox">${pubOpaDetail.penDecNo}</div></td>
                        </tr>
                       <c:if test="${pubOpaDetail.isMove == '1'}"> 
	                    	<tr>
	                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center"><div class="tdBox">移出原因</div></td>
	                        	<td colspan="5" width="890px"><div class="tdBox">${pubOpaDetail.remExcpresCN}</div></td>
	                        </tr> 
                       </c:if>
                        <tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center"><div class="tdBox" style="width:100px;"><font color="red"> </font>移出事实和事由</div></td>
                            <td colspan="5"><div class="tdBox"><textarea  class="txt_1" disabled="disabled">${pubOpaDetail.removeRea}</textarea></div></td>
                        </tr>
                        <tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center"><div class="tdBox"><font color="red"> </font>初审意见</div></td>
                            <td colspan="5"><div class="tdBox"><textarea  class="txt_1" disabled="disabled">${pubOpaDetail.firstOpin}</textarea></div>
                            </td>
                        </tr>
                        <tr>
                        	<td class="bg-gray right" width="100" valign="middle" class="lb_1" style="text-align:center"><div class="tdBox">初审日期</div></td>
                            <td width="180"><div class="tdBox"><fmt:formatDate value="${pubOpaDetail.firstdate}" pattern="yyyy-MM-dd"/></div></td>
                            <td class="bg-gray right" width="120" valign="middle" class="lb_1" style="text-align:center"><div class="tdBox">初审人</div></td>
                            <td width="170"><div class="tdBox">${pubOpaDetail.firstName}</div></td>
                            <td class="bg-gray right" width="130" valign="middle" class="lb_1" style="text-align:center"><div class="tdBox">初审部门</div></td>
                            <td width="250"><div class="tdBox">${pubOpaDetail.firstDept}</div></td>
                        </tr>
                        <tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center"><div class="tdBox"><font color="red"> </font>审核意见</div></td>
                            <td colspan="5"><div class="tdBox"><textarea  class="txt_1" disabled="disabled">${pubOpaDetail.auditOpin}</textarea></div>
                            </td>
                        </tr>
                        <tr>
                        	<td class="bg-gray right" width="100" valign="middle" class="lb_1" style="text-align:center"><div class="tdBox">审核日期</div></td>
                            <td width="180"><div class="tdBox"><fmt:formatDate value="${pubOpaDetail.auditDate}" pattern="yyyy-MM-dd"/></div></td>
                            <td class="bg-gray right" width="120" valign="middle" class="lb_1" style="text-align:center"><div class="tdBox">审核人</div></td>
                            <td width="170"><div class="tdBox">${pubOpaDetail.auditName}</div></td>
                            <td class="bg-gray right" width="130" valign="middle" class="lb_1" style="text-align:center"><div class="tdBox">审核部门</div></td>
                            <td width="250"><div class="tdBox">${pubOpaDetail.auditDept}</div></td>
                        </tr>
                        <tr>
                        	<td class="bg-gray right" width="100" valign="middle" class="lb_1" style="text-align:center"><div class="tdBox">移出日期</div></td>
                            <td width="180"><div class="tdBox"><fmt:formatDate value="${pubOpaDetail.remDate}" pattern="yyyy-MM-dd"/></div></td>
                            <td class="bg-gray right" width="120" valign="middle" class="lb_1" style="text-align:center"><div class="tdBox">作出决定机关</div></td>
                            <td width="170"><div class="tdBox">${pubOpaDetail.reDecOrgCN}</div></td>
                            <c:if test="${not empty pubOpaDetail.deptUpName && not empty pubOpaDetail.deptSameCourt && not empty pubOpaDetail.deptSameGov&&pubOpaDetail.remExcpres!='7'}">
                            <td class="bg-gray right" width="130" valign="middle" class="lb_1" style="text-align:center"><div class="tdBox">生成决定书</div></td>
                            <td width="250"><div class="tdBox"><a href="javascript:void(0);" id="printpubopadetailbook" >${pubOpaDetail.penDecNo}</a></div></td>
                            </c:if>
                            </tr> 
                    </table>
                </div> 
                </c:if>
                <br>
                <div class="center mt10 mb10">
                     <input type="button" class="btn " id="cancel" value="关闭" />
                </div>
                </form>
        </div> 
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/server/opanomaly/pubopanomaly/pubopanomalyent/pubopanomalyentsearch_view_main.js"/>"></script>
<script>
    window._CONFIG = {
       _pubOpaDetail_busExcList:'${pubOpaDetail.busExcList}',//异常移出/撤销uid
       _pubOpanoMaly_busExcList:'${pubOpanoMaly.busExcList}',//移出列入UID
       chooseUrl:'${userType == 2 ? "/syn" : "/reg"}'
     } 
</script>
</body>
</html>
<style type="text/css">
table.gridtable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;
}
table.gridtable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #dedede;
}
table.gridtable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #ffffff;
}
.listBox2 {
    padding: 0px;
    position: relative;
    width: 100%;
    margin: auto;
}
.listBox2 table {
    border: 1px solid #dcdcdc;
    width: 100%;
    font-size: 12px;
}
.txt_1 {
    width: 99%;
    height: 50px;
    border: 1px solid #cccccc;
    font-size: 12px;
}
</style>