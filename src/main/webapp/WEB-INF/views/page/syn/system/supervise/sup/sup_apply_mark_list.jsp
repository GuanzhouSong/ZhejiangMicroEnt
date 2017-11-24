<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>重点监管标识信息</title>
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body>
<c:if test="${fn:length(markList)==0}">
	<div class="center">
		<div style="width: 100%; padding-top : 120px;padding-bottom:100px; font-family: Microsoft Yahei; font-size: 30px;">暂无可用标识</div>
        <input type="button" id="cancel" value="关闭" class="btn mr20" />
    </div>
</c:if>
<c:if test="${fn:length(markList)!=0}">
	<form action="" id="hx-form">
    <div class="pd20 clearfix">
        <div class="col-4">
            <dl class="identification">
                <dt><label><i class="xbt-icon icon-send-dept"></i><span>标识列表</span></label></dt>
                <c:forEach items="${markList}" var="list" varStatus="inx">
		                <dd><label><input type="radio" class="markRadio" name="markCode" ${inx.count == 1?'checked':''} value="${list.markNo}"><span>${list.markName }</span></label></dd>
					</c:forEach>  
            </dl>
        </div>
        <div class="col-6">
            <c:forEach items="${markList}" var="list" varStatus="inx">
            	<div id="${list.markNo}" class="markTable" style="display: ${inx.count == 1?'block':'none'}" >
            	<div class="right mb5">批次编号：${batchNO}</div>
	            <table  cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mb10 ">
	                <tbody>
	                <tr>
	                    <td class="bg-gray right" width="40%">重点监管标识名称</td>
	                    <td class="bg-white" width="60%">${list.markName}</td>
	                </tr>
	                 <tr>
	                    <td class="bg-gray right">重点监管标识缟码</td>
	                    <td class="bg-white">${list.markNo }</td>
	                </tr>
	                <tr>
	                    <td class="bg-gray right">重点监管标识有效日期</td>
	                    <td class="bg-white">
	                    	<fmt:formatDate value="${list.markStartDate}" pattern="yyyy-MM-dd" />至<fmt:formatDate value="${list.markEndDate}" pattern="yyyy-MM-dd" />
	                    </td>
	                </tr>
	                <tr>
	                    <td class="bg-gray right">重点监管标识设置部门</td>
	                    <td class="bg-white">${list.markSetDept}</td>
	                </tr>
	                <tr>
	                    <td class="bg-gray right">重点监管标识内容简述</td>
	                    <td class="bg-white">${list.markContent}</td>
	                </tr>
	                </tbody>
	            </table>
	            </div>
            </c:forEach>
        	</div>
    </div>
    <div class="center">
    	<input type="hidden" name="priPIDStr" value="${priPIDStr}"/>
		<input type="hidden" name="batchNO" value="${batchNO}"/>
        <input type="submit" value="确 认" class="btn mr20" />
        <input type="button" id="cancel" value="取消申请" class="btn mr20" />
    </div>
    </form>
</c:if>
    
<script src="/js/lib/laydate/laydate.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/supervise/sup/sup_apply_mark_list.js"></script>
</body>
</html>