<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>重点监管标识信息</title>
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
</head>
<body  class="pd10">
<div>
	<form action="" id="hx-form">
	<c:if test="${dto.checkAdv != null && dto.checkAdv !=''}">
		<div class="mb10 clearfix">
			<div class="col-12">审核意见：${dto.checkAdv}</div>
		</div>
	</c:if>
    <div class="bg-gray2 mb10 pd20 clearfix">
        <div class="col-4">
            <dl class="identification">
                <dt><label><i class="xbt-icon icon-send-dept"></i><span>标识列表</span></label></dt>
                <c:forEach items="${markList}" var="list" varStatus="inx">
                	<c:if test="${list.markNo == dto.markCode}">
		                <dd><label><input type="radio" class="markRadio" name="markCode" checked value="${list.markNo}"><span>${list.markName }</span></label></dd>
                	</c:if>
				</c:forEach>
            </dl>
        </div>
        <div class="col-6">
             <c:forEach items="${markList}" var="list" varStatus="inx">
            	<div id="${list.markNo}" class="markTable" style="display: ${list.markNo == dto.markCode?'block':'none'}" >
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
    <div class="mb5 clearfix">
    	<input type="hidden" name="batchNO" value="${dto.batchNO}"/>
    	<input type="hidden" name="supCheckState" value="2"/>
<%--         <input type="button" id="add" class="btn btn-sm mr5" batchNO="${batchNO}" value="添加"> --%>
    </div>
    </form>
    
	<div>
    	<form action="" id="search-form">
    		<input type="hidden" name="batchNO" value="${dto.batchNO}">
    	</form>
        <table id="hx-table" border="0" cellspacing="0" cellpadding="0" class="table-row nowrap perc-100 mt30" width="100%">
            <thead>
            <tr>
                <th width="7%">序号</th>
               <th >批次号</th>
                <th >企业名称</th>
                <th >注册号</th>
                <th >统一信用代码</th>
                <th >法定代表人</th>
                <th >企业类型</th>
                <th >行业</th>
                <th >住所</th>
                <th >登记机关</th>
                <th >管辖单位</th>
            </tr>
            </thead>
        </table>
    </div>
        <div class="center">
        <input type="button" id="cancel" value="关闭" class="btn" />
    </div>
</div>


<script src="/js/lib/laydate/laydate.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/supervise/sup/sup_apply_batch_view.js"></script>
</body>
</html>