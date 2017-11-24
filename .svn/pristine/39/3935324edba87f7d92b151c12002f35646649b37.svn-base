<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date"%>
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
    <title>申请恢复正常记载页面</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
	  <div class="main">
		<h1 id="title"></h1>
		<form id="pbosaveform"  >
             <div class="listBox2 thBg">
             <input type="hidden" name="priPID" value="${midBaseInfo.priPID}"> 
             <input type="hidden" name="year" value="${pubPbopanomalyDto.year}"> 
             <input type="hidden" name="busExcList" value="${pubPbopanomalyDto.busExcList}">
             <input type="hidden" name="norReaCN" id="norReaCN" value="">
             <input type="hidden" name="norDecOrgCN" id="norDecOrgCN" value="${codeRegorg.contentShort}">
             <input type="hidden" name="norDecOrg" id="norDecOrg" value="${codeRegorg.code}">
             
                <div class="leftTop"></div>
                <div class="right1Top"></div>
                <table class="table-horizontal">
                    <tr>
                        <td class="bg-gray right" width="100px"><div class="ipt-box">企业名称 </div></td>
                        <td width="270px"><div class="ipt-box">${midBaseInfo.entName}</div></td>
	                    <td class="bg-gray right" width="100px"><div class="ipt-box">注册号</div></td>
	                    <td width="180px"><div class="ipt-box">${midBaseInfo.regNO}</div></td>
	                    <td class="bg-gray right" width="100px"><div class="ipt-box">经营者</div></td>
	                    <td width="150px"><div class="ipt-box">${midBaseInfo.leRep}</div></td>
	                </tr>
	                <tr>
                        <td class="bg-gray right"><div class="ipt-box">登记机关</div></td>
                        <td><div class="ipt-box">${midBaseInfo.regOrgName}</div></td>
	                	<td class="bg-gray right"><div class="ipt-box">管辖单位</div></td>
                        <td><div class="ipt-box">${midBaseInfo.localAdmName}</div></td>
                        <td class="bg-gray right"><div class="ipt-box">责任区</div></td>
                        <td><div class="ipt-box">${midBaseInfo.sliceNOName }</div></td>                        
	                </tr>
	            </table>
        	</div>
        	<br />
        	<div class="listBox2 thBg">
                    <div class="leftTop"></div>
                    <div class="right1Top"></div>
                    <table class="table-horizontal">
                    	<tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center"><div class="ipt-box">标记原因</div></td>
                        	<td colspan="5" width="890px"><div class="ipt-box">${pubPbopanomalyDto.excpStaResCN}</div></td>
                        </tr>
                        <tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center" ><div class="ipt-box">标记事实和事由</div></td>
                            <td colspan="5"><div class="ipt-box">${pubPbopanomalyDto.signRea}</div></td>
                        </tr>
                        <tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center" ><div class="ipt-box">作出决定日期</div></td>
                            <td colspan="5"><div class="ipt-box" id="abnTime"><fmt:formatDate value="${pubPbopanomalyDto.cogDate}" type="date" pattern="yyyy-MM-dd"/></div></td>
                        </tr>
                        <tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center" ><div class="ipt-box">决定机关</div></td>
                            <td colspan="5"><div class="ipt-box">${pubPbopanomalyDto.decorgCN}</div></td>
                        </tr>
                        <tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center" ><div class="ipt-box"><font color="red">* </font>恢复类型</div></td>
                            <td colspan="5"><div class="ipt-box">
                            <input type="radio" name="recoveryType" value="1" checked="checked" id="move">正常恢复
                            <input type="radio" name="recoveryType" id="notMove" value="2">更正恢复
                            </div>
                            </td>
                        </tr>
                        <tr id="td-remExcpres">
                            <td class="bg-gray right"><font color="red">* </font>恢复原因</td>
	                        <td colspan="5"><div class="ipt-box">
	                        	<select id="norRea" name="norRea" style="width: 98%" >
	                        		<option value="" >请选择</option>  
	                        	</select></div>
	                        </td>
                        </tr>
                        <tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center"><div class="ipt-box"><font color="red">* </font>事实和理由</div></td>
                            <td colspan="5"><div class="ipt-box"><textarea id="recoverRea" name="recoverRea"  class="txt_1" ></textarea></div></td>
                        </tr>
                        <tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center"><div class="ipt-box"><font color="red">* </font>初审意见</div></td>
                            <td colspan="5"><div class="ipt-box"><textarea id="firstOpin" name="firstOpin" class="txt_1" ></textarea></div>
                            </td>
                        </tr>
                        <tr>
                        	<td class="bg-gray right"><font color="red">* </font>做出决定日期</td>
                            <td>
                            	<div class="ipt-box"><input class="laydate-icon ipt-txt" type="text"
                                                  readonly="readonly" name="norDate" id="norDate"
                                                  onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"/></div>
                            </td>
                            <td colspan="2" class="bg-gray">注：局领导已在纸质材料上审批的，请录入领导审批日期，若尚无审批可不填写</td>
                            <td class="bg-gray right">决定机关</td>
                            <td><input type="text" value="${codeRegorg.contentShort}" readonly="readonly"/></td>
                        </tr>
                        <tr>
                        	<td class="bg-gray right">初审日期</td>
                            <td><input type="text" class="ipt-txt laydate-icon pointer" readonly="readonly"
                                   name="firstDate" value="<fmt:formatDate value='<%=new Date()%>' pattern='yyyy-MM-dd'/>"/></td>
                            <td class="bg-gray right">初审人</td>
                            <td><input readonly="readonly" type="text" name="firstName" value="${sysuser.realName }"></td>
                            <td class="bg-gray right">初审部门</td>
                            <td><input type="text" readonly="readonly" name="firstDept" value="${sysuser.departMent.deptName }"> </td>
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
<script src="/js/reg/server/opanomaly/pbopanomaly/pbopanomalyrecovery_add.js"></script>
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