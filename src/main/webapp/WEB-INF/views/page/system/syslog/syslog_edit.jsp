<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title></title>
	<link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">

<div>
    <div class="" style="margin-top: 10px;">
        <form class="form-horizontal" id="modapplication-form">
        	<table class="table-horizontal" width="100%">
	            <tr>
	                <td width="8%" class="bg-gray right">注册号</td>
	                <td width="15%">
	                    ${sysLogDto.regNO }
	                </td>
	
	                <td width="8%" class="bg-gray right">企业名称</td>
	                <td width="25%">
	                    ${sysLogDto.entName }
	                </td>
	                <td width="8%" class="bg-gray right">企业类型</td>
	                <td width="10%">
	                 ${sysLogDto.logEntTypeDesc }
	                </td>
	                <td width="10%" class="bg-gray right">年报年度</td>
	                <td width="16%">
	                 ${sysLogDto.year }
	                </td>
	            </tr>
	            <tr>
	                <td class="bg-gray right">操作类型</td>
	                <td>
	                	${sysLogDto.logOperationDesc }
	                </td>
	                <td class="bg-gray right">操作来源</td>
	                <td>
	                	<c:if test="${sysLogDto.logType == '1'}">工商端</c:if>
	                	<c:if test="${sysLogDto.logType == '0'}">企业端</c:if>
	                </td>
	                <td class="bg-gray right">操作人</td>
	                <td>
	                	${sysLogDto.setName }
	                </td>
	                <td class="bg-gray right">操作日期</td>
	                <td>
	                	<fmt:formatDate value="${sysLogDto.setTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
	                </td>
	            </tr>
	            <tr>
	            	<td class="bg-gray right">操作详情</td>
	            	<td colspan="7">
						<div class="ipt-box">
							<textarea rows="" cols="" readonly="readonly" style="width: 100%;height:250px;">${sysLogDto.logMsg }</textarea>
						</div>
	            	</td>
	            </tr>
				<tr>
					<td class="bg-gray right">其他详细信息</td>
					<td colspan="7">
						<div class="ipt-box">
							<textarea rows="" cols="" readonly="readonly" style="width: 100%;height:250px;">${sysLogDto.remark}</textarea>
						</div>
					</td>
				</tr>
            </table>
            <div class="center mt10">
                <button id="cancel" type="button" class="btn">关闭</button>
            </div>
        </form><br/>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/business/syslog/edit_main.js"></script>
</body>
</html>