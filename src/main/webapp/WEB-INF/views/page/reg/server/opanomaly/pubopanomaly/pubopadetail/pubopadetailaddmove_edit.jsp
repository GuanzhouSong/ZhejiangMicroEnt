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
<body class="pd10">
	  <div class="main">
		<h1 id="title"></h1>
		<form id="pubopadetailform"  >
             <div class="listBox2 thBg">
             <input type="hidden" name="priPID" value="${midBaseInfoDto.priPID}"> 
             <input type="hidden" name="entName" value="${midBaseInfoDto.entName}"> 
             <input type="hidden" name="regNO" id="regNO" value="${midBaseInfoDto.regNO}"> 
             <input type="hidden" name="uniSCID" value="${midBaseInfoDto.uniCode}"> 
             <input type="hidden" name="leRep" value="${midBaseInfoDto.leRep}"> 
             <input type="hidden" name="cerNO" value="${pubOpanoMaly.cerNO}"> 
             <input type="hidden" name="cerType" value="10">
             <input type="hidden" name="regOrg" value="${midBaseInfoDto.regOrg}"> 
             <input type="hidden" name="localAdm" value="${midBaseInfoDto.localAdm}"> 
             <input type="hidden" name="year" value="${pubOpanoMaly.year}"> 
             <input type="hidden" name="speCauseCN" id="speCauseCN" value="${pubOpanoMaly.speCauseCN}"> 
             <input type="hidden" name="speCause" id="speCause" value="${pubOpanoMaly.speCause}"> 
             <input type="hidden" name="abnTime" id="sendabnTime" value="<fmt:formatDate value="${pubOpanoMaly.abnTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss "/>"> 
             <input type="hidden" name="decorgCN" id="decorgCN" value="${pubOpanoMaly.decorgCN}">
             <input type="hidden" name="decOrg" id="decOrg" value="${pubOpanoMaly.decOrg}">
             <input type="hidden" name="remExcpresCN" id="remExcpresCN" value="">
 
             <input type="hidden" name="auditState" value="0"> 
             <input type="hidden" name="reDecOrgCN" id="reDecOrgCN" value="${codeRegorg.contentShort}">
             <input type="hidden" name="reDecOrg" id="reDecOrg" value="${codeRegorg.code}">
             <input type="hidden" name="firstDept" id="firstDept" value="${sysUser.departMent.deptName}">
             <input type="hidden" name="firstName" value="${sysUser.realName}"> 
             <input type="hidden" name="entTypeCatg" value="${midBaseInfoDto.entTypeCatg}">
             <input type="hidden" name="busExcList" id="busExcList" value="${pubOpanoMaly.busExcList}">  
             <input type="hidden" name="operate" value="${operate}">  
             
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
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center" width="100px"><div class="ipt-box">列入文号</div></td>
                        	<td colspan="5" width="890px"><div class="ipt-box">${pubOpanoMaly.penDecNo}</div></td>
                        </tr>
                    	<tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center"><div class="ipt-box">列入原因</div></td>
                        	<td colspan="5" width="890px"><div class="ipt-box">${pubOpanoMaly.speCauseCN}</div></td>
                        </tr>
                        <tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center" ><div class="ipt-box">列入事实和事由</div></td>
                            <td colspan="5"><div class="ipt-box">${pubOpanoMaly.anomalyRea}</div></td>
                        </tr>
                        <tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center" ><div class="ipt-box">作出决定日期</div></td>
                            <td colspan="5"><div class="ipt-box" id="abnTime"><fmt:formatDate value="${pubOpanoMaly.abnTime}" type="date" pattern="yyyy-MM-dd"/></div></td>
                        </tr>
                        <tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center" ><div class="ipt-box">决定机关</div></td>
                            <td colspan="5"><div class="ipt-box">${pubOpanoMaly.decorgCN}</div></td>
                        </tr>
                        <tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center" ><div class="ipt-box"><font color="red">* </font>类型</div></td>
                            <td colspan="5"><div class="ipt-box"><input type="radio" name="isMove" value="1" id="move" <c:if test="${pubOpaDetail.isMove == '1' }">checked</c:if> >正常移出
                            <input type="radio" name="isMove" id="notMove" value="2" <c:if test="${pubOpaDetail.isMove == '2' }">checked</c:if> >更正（撤销）
                            <span class="light">（更正（撤销）则仅仅适用于错误被列入经营异常名录的企业，由登记机关予以更正并撤销原列入决定，是一种特殊的移出情形，更正（撤销）之后，其列入与移出的情况视同自始不存在，也不再向社会公示。）</span>
                            </div>
                            </td>
                        </tr>
                        <tr id="td-remExcpres" style="display:<c:if test="${pubOpaDetail.isMove == '2'}">none</c:if> ;">
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center"><div class="ipt-box"><font color="red">* </font>移出原因</div></td>
	                        <td colspan="5"><div class="ipt-box">
	                        	<select id="remExcpres" name="remExcpres" style="width: 98%" >
	                        		<option value="">请选择</option>
	                        	</select></div>
	                        </td>
                        </tr>
                        <tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center"><div class="ipt-box"><font color="red">* </font>事实和理由</div></td>
                            <td colspan="5"><div class="ipt-box"><textarea id="removeRea" name="removeRea"  class="txt_1" >${pubOpaDetail.removeRea}</textarea></div></td>
                        </tr>
                        <tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center"><div class="ipt-box"><font color="red">* </font>初审意见</div></td>
                            <td colspan="5"><div class="ipt-box"><textarea id="firstOpin" name="firstOpin" class="txt_1" >${pubOpaDetail.firstOpin == null ? '拟移出经营异常名录。' : pubOpaDetail.firstOpin}</textarea></div>
                            </td>
                        </tr>
                        <tr>
                        	<td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center"><div class="ipt-box">作出决定日期</div></td>
                            <td width="180"><div class="ipt-box"><input class="ipt-txt laydate-icon" type="text" style="width: 150px;cursor: pointer;"  name="remDate" readonly="readonly" id="remDate" value="" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" /></div></td>
                            <td colspan="2"><div class="ipt-box light">注：局领导已在纸质材料上审批的，请录入领导审批日期，若尚未审批可不填写。</div></td>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center"><div class="ipt-box"><font color="red">* </font>决定机关</div></td>
                            <td colspan="2"><div class="ipt-box">${codeRegorg.contentShort}</div></td>
                        </tr>
                        <tr>
                        	<td class="bg-gray right" width="100" valign="middle" class="lb_1" style="text-align:center"><div class="ipt-box">初审日期</div></td>
                            <td width="180"><div class="ipt-box" id="firstdate">
                            	<fmt:formatDate value="${nowdate}" type="date" pattern="yyyy-MM-dd"/>
                            </div></td>
                            <td class="bg-gray right" width="120" valign="middle" class="lb_1" style="text-align:center"><div class="ipt-box">初审人</div></td>
                            <td width="170"><div class="ipt-box">${sysUser.realName}</div></td>
                            <td class="bg-gray right" width="130" valign="middle" class="lb_1" style="text-align:center"><div class="ipt-box">初审部门</div></td>
                            <td width="250"><div class="ipt-box">${sysUser.departMent.deptName}</div></td>
                        </tr>
                    </table>
                </div>
              </form>
                <div class="center mt10 mb10">
                    <input type="button" class="btn btn-info" id="save" value="保存" />
                    <input type="button" class="btn " id="cancel" value="取消" />
                </div>
        </div> 
    </body>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="<c:url value="/js/reg/server/opanomaly/pubopanomaly/pubopadetail/pubopadetailaddmove_edit.js"/>"></script> </body>
<script>
    window._CONFIG = {
       _remExcpres:'${pubOpaDetail.remExcpres}',
       _impFlag:'${pubOpanoMaly.impFlag}',
       _batchEntType:'${pubOpanoMaly.batchEntType}'
     } 
</script>
</html>
<style type="text/css">
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