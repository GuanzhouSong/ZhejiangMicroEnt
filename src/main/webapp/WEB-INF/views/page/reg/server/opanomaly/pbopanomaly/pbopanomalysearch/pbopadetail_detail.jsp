<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date"%>
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
    <title>恢复正常记载详情页面</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
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
             <div class=" ">
             <!-- 参数传递列表 -->
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
                            <td class="bg-gray right">标记原因</td>
	                        <td colspan="6">
		                        <div class="ipt-box">
		                        	<textarea class="txt_1" disabled="disabled" maxlength="500">${pubPbopanomalyDto.excpStaResCN }
		                        	</textarea>
	                        	</div>
	                        </td>
                        </tr>
                        <tr>
                            <td class="bg-gray right">标记事实和理由</td>
                            <td colspan="6">
                            	<textarea disabled="disabled" class="txt_1" maxlength="500">${pubPbopanomalyDto.signRea }</textarea>
                            </td>
                        </tr>
                        <tr>
                            <td class="bg-gray right">做出决定日期</td>
                            <td colspan="6">
                            	<fmt:formatDate value="${pubPbopanomalyDto.cogDate }" type="date" pattern="yyyy-MM-dd"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="bg-gray right">决定机关</td>
                            <td colspan="6">
                             	${codeRegorg.contentShort }
                            </td>
                        </tr>
                        
                        <tr>
                            <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center" ><div class="ipt-box">恢复类型</div></td>
                            <td colspan="5"><div class="ipt-box">
                            <input type="radio" name="recoveryType" value="1" disabled="disabled"
                            <c:if test="${pubPbOpadetailDto.recoveryType=='1' }"> checked </c:if>
                            >正常恢复
                            <input type="radio" name="recoveryType" value="2" disabled="disabled"
                            <c:if test="${pubPbOpadetailDto.recoveryType=='2' }"> checked </c:if>
                            >更正恢复
                            </div>
                            </td>
                        </tr>
                        <tr <c:if test="${pubPbOpadetailDto.recoveryType=='2' }"> style='display:none' </c:if> >
                            <td class="bg-gray right">恢复原因</td>
	                        <td colspan="6">
		                        <div class="ipt-box">
		                        	${pubPbOpadetailDto.norReaCN }
	                        	</div>
	                        </td>
                        </tr>
                        <tr>
                            <td class="bg-gray right">恢复事实和理由</td>
	                        <td colspan="6">
		                        <div class="ipt-box">
		                        	<textarea disabled="disabled" class="txt_1" maxlength="500">${pubPbOpadetailDto.recoverRea }</textarea>
	                        	</div>
	                        </td>
                        </tr>
                        <tr>
                            <td class="bg-gray right">初审意见</td>
	                        <td colspan="6">
		                        <div class="ipt-box">
		                        	<textarea disabled="disabled" class="txt_1" maxlength="500">${pubPbOpadetailDto.firstOpin }</textarea>
	                        	</div>
	                        </td>
                        </tr>
                        <tr>
                        	<td class="bg-gray right">做出决定日期</td>
                            <td>
                            	<div class="ipt-box">
                            	<input class="laydate-icon ipt-txt" type="text" readonly="readonly" 
                                    value="<fmt:formatDate value="${pubPbOpadetailDto.norDate }"  pattern="yyyy-MM-dd"/>"/></div>
                            </td>
                            <td colspan="3" class="bg-gray">注：局领导已在纸质材料上审批的，请录入领导审批日期，若尚无审批可不填写</td>
                            <td class="bg-gray right">决定机关</td>
                            <td><input type="text" value="${codeRegorg.contentShort}" readonly="readonly"/></td>
                        </tr>
                        <tr>
                        	<td class="bg-gray right">初审日期</td>
                            <td><input type="text" class="ipt-txt laydate-icon pointer" readonly="readonly"
                                   name="firstDate" value='<fmt:formatDate value="${pubPbOpadetailDto.firstDate }" pattern="yyyy-MM-dd "/>'/></td>
                            <td colspan="1" class="bg-gray right">初审人</td>
                            <td colspan="2"><input readonly="readonly" type="text" name="firstName" value="${pubPbOpadetailDto.firstName }"></td>
                            <td class="bg-gray right">初审部门</td>
                            <td><input readonly="readonly" type="text" name="firstDept" value="${pubPbOpadetailDto.firstDept }"> </td>
                        </tr>
                        <tr>
                    <td class="bg-gray right" valign="middle" class="lb_1">
                        	审核意见
                    </td>
                    <td colspan="6">
                        <div class="radio-box" id="unusualRadio">
                            <label <c:if test="${pubPbOpadetailDto.recoveryType=='2' }">style="display:none"</c:if> class="font-12">
                            <input type="radio" disabled="disabled" class="view-opadetail" name="auditState" id="yes" value="1"
                            <c:if test="${pubPbOpadetailDto.auditState=='1' }">checked</c:if>
                                         />
                                        	予以恢复正常</label>
                            <label <c:if test="${pubPbOpadetailDto.recoveryType=='2' }">style="display:none"</c:if> class="font-12">
                            <input type="radio" disabled="disabled" class="view-opadetail" name="auditState" id="no" value="2"
                                       <c:if test="${pubPbOpadetailDto.auditState=='2' }">checked</c:if>
                                         />不予恢复正常</label>
                            <label <c:if test="${pubPbOpadetailDto.recoveryType=='1' }">style="display:none"</c:if> class="font-12">
                            <input type="radio" disabled="disabled" class="view-opadetail" name="auditState" id="yes" value="1"
                            <c:if test="${pubPbOpadetailDto.auditState=='3' }">checked</c:if>
                                         />
                                        	予以更正恢复</label>
                            <label <c:if test="${pubPbOpadetailDto.recoveryType=='1' }">style="display:none"</c:if> class="font-12">
                            <input type="radio" disabled="disabled" class="view-opadetail" name="auditState" id="no" value="2"
                                       <c:if test="${pubPbOpadetailDto.auditState=='4' }">checked</c:if>
                                         />不予更正恢复</label>
                        </div>
                        <div class="ipt-box">
                            <textarea disabled="disabled" maxlength="500"
                                  class="txt_1 view-opadetail">${pubPbOpadetailDto.auditOpin}</textarea>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" width="100" valign="middle" class="lb_1">
                        <div class="ipt-box"> 审核日期</div>
                    </td>
                    <td width="180">
                        <div class="ipt-box" >
                        	<input type="text" readonly="readonly" name="auditDate" value='<fmt:formatDate value="${pubPbOpadetailDto.auditDate}" pattern='yyyy-MM-dd'/>'/>
                        </div>
                    </td>
                    <td class="bg-gray right" width="120" valign="middle" class="lb_1">
                        <div class="ipt-box">审核人</div>
                    </td>
                    <td width="170">
                        <div class="ipt-box">
                        	<input type="text" readonly="readonly" id="auditName" name="auditName" value="${pubPbOpadetailDto.auditName}">
                        </div>
                    </td>
                    <td class="bg-gray right" width="130" valign="middle" class="lb_1">
                        <div class="ipt-box"> 审核部门</div>
                    </td>
                    <td colspan="2" width="250">
                        <div class="ipt-box">
                        	<input type="text" id="auditDept" readonly="readonly" name="auditDept" value="${pubPbOpadetailDto.auditDept}">
                        </div>
                    </td>
                </tr>
                    </table>
                </div> 
            </form>
        </div> 
    </body>
    <script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="{{this.class}}">{{this.text}}</button>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/opanomaly/pbopanomaly/pb_detail.js"></script>
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