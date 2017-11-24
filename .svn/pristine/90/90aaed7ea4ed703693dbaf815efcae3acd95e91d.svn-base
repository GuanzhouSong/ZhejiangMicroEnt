<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>企业关注服务审核</title>
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css"> 
</head>
<body>
<div class="pd10">
<form id="hx-form">
    <div class="bg-gray pd10 mb20">
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mb10">
            <tr>
                <td width="10%" class="bg-gray right">批次编号：</td>
                <td width="10%">${dto.batchNO}</td>
                <td width="20%" class="bg-gray right">标识适用地区：</td>
                <td width="10%">${dto.markUseArea }</td>
                <td width="10%" class="bg-gray right">标识级别：</td>
                <td width="10%" >
                	<c:if test="${dto.markClass=='0'}">关注</c:if>
                	<c:if test="${dto.markClass=='1'}">警示</c:if>
                	<c:if test="${dto.markClass=='2'}">限制</c:if>
                </td>
                <td width="10%" class="bg-gray right">标识状态：</td>
                <td>
					<c:if test="${dto.markState=='0'}">无效</c:if>
                	<c:if test="${dto.markState=='1'}">有效</c:if>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">标识名称：</td>
                <td colspan="7">
                    <div class="ipt-box">
                        ${dto.markName}
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">标识内容：</td>
                <td colspan="7">
                    <div class="ipt-box">
                        ${dto.markName}
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right" colspan="5">录入人：</td>
                <td>${dto.importPeople}</td>
                <td class="bg-gray right">录入日期：</td>
                <td><fmt:formatDate value="${dto.importDate}" pattern="yyyy-MM-dd" /></td>
            </tr>
            <tr>
                <td class="bg-gray right">审核结果：</td>
                <td colspan="3">
                    <div class="radio-box">
                    	<c:if test="${dto.urlFlag =='1'}">
                        	<label><input name="checkState" type="radio" checked="checked" <c:if test="${dto.checkState =='1'}">checked="checked" disabled="disabled"</c:if> value="1">同意</label>
                        	<label><input name="checkState" type="radio" <c:if test="${dto.checkState =='3'}">checked="checked"</c:if> value="3">退回修改 </label>
                        	<label><input name="checkState" type="radio" <c:if test="${dto.checkState =='0'}">checked="checked"</c:if>value="0">不同意</label>
                        </c:if>
                        <c:if test="${dto.urlFlag =='0'}">
                        	<label>
                        		<c:if test="${dto.checkState =='1'}">同意</c:if>
                        		<c:if test="${dto.checkState =='3'}">退回修改</c:if>
                        		<c:if test="${dto.checkState =='0'}">不同意</c:if>
                        		<c:if test="${dto.checkState =='2'}">待审核</c:if>
                       		</label>
                        </c:if>
                    </div>
                </td>
                <td class="bg-gray right">审核人：</td>
                <td>${dto.checkPeople}</td>
                <td class="bg-gray right">审核日期：</td>
                <td><fmt:formatDate value="${dto.checkDate}" pattern="yyyy-MM-dd" /></td>
            </tr>
            <tr>
                <td class="bg-gray right"> 审核意见：</td>
                <td colspan="7">
                    <div class="ipt-box">
                        <textarea rows="4" name="checkView" <c:if test="${dto.checkState =='1' || dto.urlFlag =='0'}">readonly</c:if>>${dto.checkView}</textarea>
                    </div>
                </td>
            </tr>
        </table>
        	<input type="hidden" name="checkPeople" value="${dto.checkPeople }">
        	<input type="hidden" name="batchNO" value="${batchNO}">
	        <div class="form-item clearfix">
	            <div class="btn-box">
	            	<c:if test="${ dto.urlFlag =='1'}">
	                	<input type="submit"  value="审核" class="btn mr20">
	                </c:if>
	                <input type="button" id="back" value="返回" class="btn">
	            </div>
	        </div>
     </div>
     </form>
    
    <div>
    	<form action="" id="search-form">
    		<input type="hidden" name="batchNO" value="${batchNO}">
    	</form>
        <table id="hx-table" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 mt30" width="100%">
            <thead>
            <tr>
                <th>操作</th>
				<th>统一信用代码</th>
				<th>注册号</th>
				<th>企业名称</th>
				<th>行业</th>
				<th>住所</th>
				<th>登记机关</th>
				<th>管辖单位</th>
				<th>历史关注记录</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
    
<script src="/js/lib/laydate/laydate.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/concern/conc/con_apply_audit.js"></script>
</body>
</html>