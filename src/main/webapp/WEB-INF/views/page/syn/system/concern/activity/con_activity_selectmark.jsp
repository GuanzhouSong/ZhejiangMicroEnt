<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>选择标识</title>
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css"> 
</head>
<body>
	<form id="hx-form">
	    <div class="pd20 clearfix">
	        <div class="col-4">
	            <dl class="identification">
	                <dt><label><i class="xbt-icon icon-send-dept"></i><span>标识列表</span></label></dt>
	                <c:forEach items="${markList}" var="list" varStatus="inx">
		                <dd><label><input type="radio" class="markRadio" name="markNo" ${inx.count == 1?'checked':''} value="${list.markNo}" markName="${list.markName}"><span>${list.markName}</span></label></dd>
					</c:forEach>  
	            </dl>
	        </div>
	        <div class="col-6">
	            <c:forEach items="${markList}" var="list" varStatus="inx">
	            	<div id="${list.markNo}" class="markTable" style="display: ${inx.count == 1?'block':'none'}" >
		            <table  cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mb10 ">
		                <tbody>
		                <tr>
		                    <td class="bg-gray right" width="40%">标识名称</td>
		                    <td class="bg-white" width="60%">${list.markName}</td>
		                </tr>
		                 <tr>
		                    <td class="bg-gray right">标识编码</td>
		                    <td class="bg-white">${list.markNo }</td>
		                </tr>
		                <tr>
		                    <td class="bg-gray right">标识有效日期</td>
		                    <td class="bg-white">
		                    	<fmt:formatDate value="${list.markStartDate}" pattern="yyyy-MM-dd" />至<fmt:formatDate value="${list.markEndDate}" pattern="yyyy-MM-dd" />
		                    </td>
		                </tr>
		                <tr>
		                    <td class="bg-gray right">标识设置部门</td>
		                    <td class="bg-white">${list.markSetDept}</td>
		                </tr>
		                <tr>
		                    <td class="bg-gray right">标识内容简述</td>
		                    <td class="bg-white">${list.markContent}</td>
		                </tr>
		                </tbody>
		            </table>
		            </div>
	            </c:forEach>
	        	</div>
	    </div>
	    <div class="center">
	        <input type="button" id="confirm" value="确认" class="btn mr20" />
	        <input type="button" id="cancel" value="取消" class="btn mr20" />
	    </div>
    </form>
    
<script src="/js/lib/laydate/laydate.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/concern/activity/con_activity_selectmark.js"></script>
</body>
</html>