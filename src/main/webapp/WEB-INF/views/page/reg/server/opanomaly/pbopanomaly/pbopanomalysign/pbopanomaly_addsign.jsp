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
    <title>新增异常页面</title>
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
		<form id="pbosaveform"  >
             <div class=" ">
             <!-- 参数传递列表 -->
             <input type="hidden" name="priPID" id="priPID" value="${midBaseInfo.priPID }"> 
             <input type="hidden" name="entName" value="${midBaseInfo.entName }"> 
             <input type="hidden" name="regNO" id="regNO" value="${midBaseInfo.regNO }"> 
             <input type="hidden" name="uniSCID" value="${midBaseInfo.uniCode }"> 
             <input type="hidden" name="leRep" value="${midBaseInfo.leRep }"> 
             <input type="hidden" name="cerNO" value="${midBaseInfo.cerNO }"> 
             <input type="hidden" name="cerType" value="10"> 
             <input type="hidden" name="regOrg" value="${midBaseInfo.regOrg }"> 
             <input type="hidden" name="localAdm" value="${midBaseInfo.localAdm}"> 
             <input type="hidden" name="setName" value="${sysuser.realName}"> 
             <input type="hidden" name="decorgCN" id="decorgCN" value="${codeRegorg.contentShort}">
             <input type="hidden" name="decOrg" id="decorgCN" value="${codeRegorg.code}">
             <input type="hidden" name="isRecovery" value="1"> 
             <input type="hidden" id="excpStaResCN"name="excpStaResCN" value=""> 
             <input type="hidden" name="cogDate" id="cogDate" value="${currentTime}"> 
             <input type="hidden" name="PBSource" value="1"> <!-- 来源为工商录入 -->
             
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
                    		<td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center" rowspan="2" height="100px"><div class="ipt-box">当前异常记录</div></td>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center" colspan="4"><div class="ipt-box">标记异常原因</div></td>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center" width="150px"><div class="ipt-box">标记日期</div></td>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center" width="100px"><div class="ipt-box">详情</div></td>
                        </tr>
                        <tr>
                            <td colspan="6" style="padding:0px;">
                            	<div id="unusualCatalog">
	                                <table style="border:none;">
	                                	<col width="600px" />
					                    <col width="150px"/>
					                    <col width="100px"/>
					                    <c:forEach var="PubPbopanomalyDto" items="${pbopanomalyList}" varStatus="vs">
			                                <span class="appInReaCodeExist" style="display:none">${PubPbopanomalyDto.excpStaRes}</span>
			                                <tr style="border:none">
				                                <td style="border:0px;text-align:left;background:none">
				                                	<div class="ipt-box">
				                                			${PubPbopanomalyDto.year}年度${PubPbopanomalyDto.excpStaResCN}
				                                	</div>
				                                </td>
	 				                                <td style="border:0px;text-align:center;background:none"><fmt:formatDate value="${PubPbopanomalyDto.cogDate}" type="date" pattern="yyyy-MM-dd"/></td> 
	 				                                <td style="border:0px;text-align:center;background:none"><a href="javascript:void(0);" class="toDetail" style="color:red" value="${PubPbopanomalyDto.busExcList}">详情</a></td>
			                                </tr>
		                                </c:forEach>
	                                </table>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center"><div class="ipt-box"><font color="red">* </font>新增异常原因</div></td>
	                        <td colspan="6"><div class="ipt-box">
	                        	<select id="excpStaRes" name="excpStaRes" style="width: 98%" >
	                        		<option value="" >请选择</option>  
	                        	</select></div>
	                        </td>
                        </tr>
                        <tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center"><div class="ipt-box"><font color="red">* </font>事实和理由</div></td>
                            <td colspan="6"><div class="ipt-box">
                            <textarea id="signRea" name="signRea" class="txt_1"></textarea></div></td>
                        </tr>
                        <tr>
                        	<td class="bg-gray right" width="100" valign="middle" class="lb_1" style="text-align:center"><div class="ipt-box">标记日期</div></td>
                            <td width="180"><div class="ipt-box">${currentTime}</div></td>
                            <td class="bg-gray right" width="120" valign="middle" class="lb_1" style="text-align:center"><div class="ipt-box">设置人</div></td>
                            <td width="170"><div class="ipt-box">${sysuser.realName}</div></td>
                            <td class="bg-gray right" width="130" valign="middle" class="lb_1" style="text-align:center"><div class="ipt-box">决定机关</div></td>
                            <td width="250" colspan="2"><div class="ipt-box">${codeRegorg.contentShort}</div></td>
                        </tr>
                    </table>
                </div> 
            </form>
                <div class="center mt10 mb10">
                    <input type="button" class="btn btn-info" id="saveBtn" value="保存" />
                    <input type="button" class="btn " id="cancel" value="取消" />
                </div>
        </div> 
    </body>
    <script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="{{this.class}}">{{this.text}}</button>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/opanomaly/pbopanomaly/pbopanomalysign/list_edit.js"></script>
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