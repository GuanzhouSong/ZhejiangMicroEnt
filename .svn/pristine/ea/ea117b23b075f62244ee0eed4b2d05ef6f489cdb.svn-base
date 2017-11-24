<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
		<form id="pboRecoform"  >
			 <!-- 传递参数 -->
		     <input type="hidden" name="resetName" value="${userName}"> 
		     <input type="hidden" name="busExcList" value="${pbopanomaly.busExcList}"> 
		     <input type="hidden" name="priPID" value="${pbopanomaly.priPID}"> 
             <input type="hidden" name="resetName" value="${sysuser.realName}"> 
             <input type="hidden" name="norDecOrgCN" id="norDecOrgCN" value="${codeRegorg.contentShort}">
             <input type="hidden" name="norDecOrg" id="norDecOrg" value="${codeRegorg.code}">
             <input type="hidden" name="isRecovery" value="0"> 
             <input type="hidden" name="norDate" id="norDate" value="${currentTime}"> 
             <input type="hidden" name="year" value="${pbopanomaly.year }"> 

             <div class="listBox2 thBg">
                <div class="leftTop"></div>
                <div class="right1Top"></div>
                <table class="table-horizontal" width="100%">
                    <tr id="appBasic">
                        <td class="bg-gray right" width="100px"><div class="ipt-box">企业名称 </div></td>
                        <td width="270px"><div class="ipt-box">${pbopanomaly.entName}</div></td>
	                    <td class="bg-gray right" width="100px"><div class="ipt-box">注册号</div></td>
	                    <td width="180px"><div class="ipt-box">${pbopanomaly.regNO}</div></td>
	                    <td class="bg-gray right" width="100px"><div class="ipt-box">经营者</div></td>
	                    <td width="150px"><div class="ipt-box">${pbopanomaly.leRep}</div></td>
	                </tr>
	                <tr id="appBasic">
                        <td class="bg-gray right"><div class="ipt-box">登记机关</div></td>
                        <td><div class="ipt-box">${pbopanomaly.regOrgName}</div></td>
	                	<td class="bg-gray right"><div class="ipt-box">管辖单位</div></td>
                        <td><div class="ipt-box">${pbopanomaly.localAdmName}</div></td>
                        <td class="bg-gray right"><div class="ipt-box">责任区</div></td>
                        <td><div class="ipt-box">${pbopanomaly.sliceNOName }</div></td>                        
	                </tr>
	            </table>
        	</div>
        	<br />
        	<div class="listBox2 thBg">
                    <div class="leftTop"></div>
                    <div class="rightTop"></div>
                    <table width="100%" border="0" class="table-horizontal">
                        <tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center"><div class="ipt-box">标记异常原因</div></td>
	                        <td colspan="6"><div class="ipt-box">${pbopanomaly.excpStaResCN }</div></td>
                        </tr>
                        <tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center"><div class="ipt-box">事实和理由</div></td>
                            <td colspan="6"><div class="ipt-box">
                            ${pbopanomaly.signRea } </div></td>
                        </tr>
                        <tr>
                        	<td class="bg-gray right" width="100" valign="middle" class="lb_1" style="text-align:center"><div class="ipt-box">标记日期</div></td>
                            <td width="180"><div class="ipt-box"><fmt:formatDate value="${pbopanomaly.cogDate}" type="date" pattern="yyyy-MM-dd"/></div></td>
                            <td class="bg-gray right" width="130" valign="middle" class="lb_1" style="text-align:center"><div class="ipt-box">决定机关</div></td>
                            <td width="250" colspan="3"><div class="ipt-box">${pbopanomaly.decorgCN}</div></td>
                        </tr>
                        <tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center"><div class="ipt-box"><font color="red">* </font>恢复正常原因</div></td>
	                        <td colspan="6">
	                        <div class="ipt-box">
	                        <c:if test="${pbopanomaly.excpStaRes==1 }">
	                        <input type="hidden" name="norRea" value="1"> 
	                        <input type="hidden" name="norReaCN" value="依照《个体工商户年度报告办法》第十四条规定被标记为经营异常状态的个体工商户，向工商行政管理部门报送更正后的纸质年度报告并申请恢复正常记载状态"> 
								依照《个体工商户年度报告办法》第十四条规定被标记为经营异常状态的个体工商户，向工商行政管理部门报送更正后的纸质年度报告并申请恢复正常记载状态
	                        </c:if>
	                        <c:if test="${pbopanomaly.excpStaRes==2 }">
	                        <input type="hidden" name="norRea" value="2"> 
	                        <input type="hidden" name="norReaCN" value="依照《个体工商户年度报告办法》第十五条规定被标记为经营异常状态的个体工商户，依法办理经营场所、经营者住所变更登记，申请恢复正常记载状态"> 
								依照《个体工商户年度报告办法》第十五条规定被标记为经营异常状态的个体工商户，依法办理经营场所、经营者住所变更登记，申请恢复正常记载状态
	                        </c:if>
	                        	</div>
	                        </td>
                        </tr>
                        <tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center"><div class="ipt-box"><font color="red">* </font>事实和理由</div></td>
                            <td colspan="6"><div class="ipt-box">
                            <textarea id="recoverRea" name="recoverRea" class="txt_1"></textarea></div></td>
                        </tr>
                        <tr>
                        	<td class="bg-gray right" width="100" valign="middle" class="lb_1" style="text-align:center"><div class="ipt-box">标记日期</div></td>
                            <td width="180"><div class="ipt-box">${currentTime }</div></td>
                            <td class="bg-gray right" width="120" valign="middle" class="lb_1" style="text-align:center"><div class="ipt-box">设置人</div></td>
                            <td width="170"><div class="ipt-box">${sysuser.realName}</div></td>
                            <td class="bg-gray right" width="130" valign="middle" class="lb_1" style="text-align:center"><div class="ipt-box">决定机关</div></td>
                            <td width="250" colspan="2"><div class="ipt-box">${codeRegorg.contentShort}</div></td>
                        </tr>
                    </table>
                </div> 
            </form>

                <div class="center mt10 mb10 ">
                    <input type="button" class="btn btn-info" id="recoBtn" value="保存" />
                    <input type="button" class="btn " id="cancel" value="取消" />
                </div>
        </div> 
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/opanomaly/pbopanomaly/pbopanomalyreco/list_main.js"></script>
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