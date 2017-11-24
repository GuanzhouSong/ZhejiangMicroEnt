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
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <title>异常状态设置申请</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
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
             <input type="hidden" name="auditState" id="auditState" value="${pubOpaDetail.auditState}">  
             <input type="hidden" name="auditDept" id="auditDept" value="${sysUser.departMent.deptName}"> 
             <input type="hidden" name="operate" value="1"> 
                <div class="leftTop"></div>
                <div class="right1Top"></div>
                <table class="table-horizontal">
                    <tr id="appBasic">
                        <td class="bg-gray right" width="100px"><div class="ipt-box">企业名称 </div></td>
                        <td width="270px"><div class="ipt-box">${midBaseInfoDto.entName}</div></td>
	                    <td class="bg-gray right" width="100px"><div class="ipt-box">注册号</div></td>
	                    <td width="180px"><div class="ipt-box">${midBaseInfoDto.regNO}</div></td>
	                    <td class="bg-gray right" width="100px"><div class="ipt-box">成立日期</div></td>
	                    <td width="150px"><div class="ipt-box"><fmt:formatDate value="${midBaseInfoDto.estDate}" type="date" pattern="yyyy-MM-dd"/></div></td>
	                </tr>
	                <tr id="appBasic">
                        <td class="bg-gray right"><div class="ipt-box">登记机关</div></td>
                        <td><div class="ipt-box">${midBaseInfoDto.regOrgName}</div></td>
                        <td class="bg-gray right"><div class="ipt-box">法定代表人</div></td>
                        <td><div class="ipt-box" >${midBaseInfoDto.leRep}</div></td>
	                    <td class="bg-gray right"><div class="ipt-box">联系电话</div></td>
	                    <td><div class="ipt-box">${midBaseInfoDto.tel}</div></td>
	                </tr>
	                <tr>
	                	<td class="bg-gray right"><div class="ipt-box">管辖单位</div></td>
                        <td><div class="ipt-box">${midBaseInfoDto.localAdmName}</div></td>
                        <td class="bg-gray right"><div class="ipt-box">联络员</div></td>
                        <td><div class="ipt-box">${pubEppassword.lianame }</div></td>
	                    <td class="bg-gray right"><div class="ipt-box">联络员电话</div></td>
	                    <td><div class="ipt-box">${pubEppassword.tel}</div></td>
	                      
	                </tr>
	            </table>
        	</div>
        	<br />
        	<div class="listBox2 thBg">
                    <div class="leftTop"></div>
                    <div class="right1Top"></div>
                    <table class="table-horizontal">
           	        	<tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" width="100px"><div class="ipt-box">列入文号</div></td>
                        	<td colspan="5"><div class="ipt-box">${pubOpanoMaly.penDecNo}</div></td>
                        </tr>
                    	<tr>
                            <td class="bg-gray right" valign="middle" class="lb_1"><div class="ipt-box">列入原因</div></td>
                        	<td colspan="5"><div class="ipt-box">${pubOpanoMaly.speCauseCN}</div></td>
                        </tr>
                        <tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" ><div class="ipt-box">列入事实和事由</div></td>
                            <td colspan="5"><div class="ipt-box">${pubOpanoMaly.anomalyRea}</div></td>
                        </tr>
                        <tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" ><div class="ipt-box">作出决定日期</div></td>
                            <td colspan="5"><div class="ipt-box" id="abnTime"><fmt:formatDate value="${pubOpanoMaly.abnTime}" type="date" pattern="yyyy-MM-dd"/></div></td>
                        </tr>
                        <tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" ><div class="ipt-box">决定机关</div></td>
                            <td colspan="5"><div class="ipt-box">${pubOpanoMaly.decorgCN}</div></td>
                        </tr>
                        <tr>
                            <td class="bg-gray right" valign="middle" class="lb_1"><div class="ipt-box"><font color="red">* </font>更正（撤销）原因</div></td>
                            <td colspan="5"><div class="ipt-box"><textarea id="removeRea" name="removeRea"  class="txt_1" disabled="disabled">${pubOpaDetail.removeRea}</textarea></div></td>
                        </tr>
                        <tr>
                            <td class="bg-gray right" valign="middle" class="lb_1"><div class="ipt-box"><font color="red">* </font>初审意见</div></td>
                            <td colspan="5"><div class="ipt-box"><textarea id="firstOpin" name="firstOpin" class="txt_1" disabled="disabled">${pubOpaDetail.firstOpin}</textarea></div>
                            </td>
                        </tr>
                        <tr>
                        	<td class="bg-gray right" valign="middle" class="lb_1"><div class="ipt-box">作出决定日期</div></td>
                            <td width="180"><div class="ipt-box"><input class="laydate-icon view-opadetail" type="text" style="width: 150px;cursor: pointer;" name="remDate" id="remDate" value="<fmt:formatDate value="${pubOpaDetail.remDate}" type="date" pattern="yyyy-MM-dd"/>" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" /></div></td>
                            <td colspan="2"><div class="ipt-box" style="color:red;">该日期为公示的决定日期。</div></td>
                            <td class="bg-gray right" valign="middle" class="lb_1"><div class="ipt-box"><font color="red">* </font>决定机关</div></td>
                            <td><div class="ipt-box">${pubOpaDetail.reDecOrgCN}</div></td>
                        </tr>
                        <tr>
                        	<td class="bg-gray right" width="100" valign="middle" class="lb_1"><div class="ipt-box">初审日期</div></td>
                            <td width="180"><div class="ipt-box"><fmt:formatDate value="${pubOpaDetail.firstdate}" pattern="yyyy-MM-dd"/></div></td>
                            <td class="bg-gray right" width="120" valign="middle" class="lb_1"><div class="ipt-box">初审人</div></td>
                            <td width="170"><div class="ipt-box">${pubOpaDetail.firstName}</div></td>
                            <td class="bg-gray right" width="130" valign="middle" class="lb_1"><div class="ipt-box">初审部门</div></td>
                            <td width="250"><div class="ipt-box">${pubOpaDetail.firstDept}</div></td>
                        </tr>
                        <tr>
                            <td class="bg-gray right" valign="middle" class="lb_1"><font color="red">* </font>审核意见</td>
                            <td colspan="5">
                                <div class="radio-box" id="unusualRadio">
                                    <label class="font-12"><input type="radio" class="view-opadetail" name="auditOpinselect" id="yes" value="1" <c:if test="${pubOpaDetail.auditState == '1'}">checked</c:if> />予以更正（撤销）</label>
                                    <label class="font-12"><input type="radio" class="view-opadetail" name="auditOpinselect" id="no" value="2" <c:if test="${pubOpaDetail.auditState == '2'}">checked</c:if> />不予更正（撤销）</label>
                                </div>
                                <div class="ipt-box">
                                    <textarea id="auditOpin" name="auditOpin" class="txt_1 view-opadetail" >${pubOpaDetail.auditOpin}</textarea>
                                </div>
                            </td>
                        </tr>
                        <tr>
                        	<td class="bg-gray right" width="100" valign="middle" class="lb_1"><div class="ipt-box">审核日期</div></td>
                            <td width="180"><div class="ipt-box" id="auditDate">
                            <c:if test="${pubOpaDetail.auditState == '1'}">
                            	<fmt:formatDate value="${pubOpaDetail.auditDate}" pattern="yyyy-MM-dd" />
                            </c:if>
                            <c:if test="${pubOpaDetail.auditState != '1'}">
                            	<fmt:formatDate value="${nowdate}" type="date" pattern="yyyy-MM-dd"/>
                            </c:if>
                            </div></td>
                            <td class="bg-gray right" width="120" valign="middle" class="lb_1"><div class="ipt-box">审核人</div></td>
                            <td width="170"><div class="ipt-box">${pubOpaDetail.auditState == '1' ? pubOpaDetail.auditName : sysUser.realName}</div></td>
                            <td class="bg-gray right" width="130" valign="middle" class="lb_1"><div class="ipt-box">审核部门</div></td>
                            <td><div class="ipt-box">${pubOpaDetail.auditState == '1' ? pubOpaDetail.auditDept : sysUser.departMent.deptName}</div></td>
                        </tr>
                        <tr>
                        	<td colspan="6"><div class="ipt-box"><font class="light">注：审核通过的日期即为该决定信息对外公示的公示日期。</font></div></td>
                        </tr>
                    </table>
                </div>
                <div class="center mt10 mb10">
                    <input type="button" class="btn btn-info" id="save" value="保存" />
                    <input type="button" class="btn " id="cancel" value="取消" />
                </div>
                </form>
        </div> 
    </body>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="<c:url value="/js/reg/server/opanomaly/pubopanomaly/pubopadetail/pubopadetailcancelaudit_edit.js"/>"></script> </body>
<script>
    window._CONFIG = {
       _auditState:'${pubOpaDetail.auditState}'
     } 
</script>
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