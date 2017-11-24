<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>添加企业标识</title>
<link rel="stylesheet" href="/css/syn.css">
<link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css"> 
</head>
<body>
<div class="pd20">
   <form id="checkForm">
    <div class="pd20 mb5">
    <div class="bg-gray pd10 mb5">
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mb10">
            <tr>
                <td align="right">批次编号：</td>
                <td>${csEntWarn.batchNo}</td>
                <td align="right">标识类型：</td>
                <td>${csEntWarn.markType}</td>
                <td align="right">标识级别：</td>
                <td>${csEntWarn.markClass=='0'?'关注':(csEntWarn.markClass=='1'?'警示':'限制')}</td>
                <td align="right">标识状态：</td>
                <td>${csEntWarn.markState=='0'?'无效':'有效'}</td>
            </tr>
            <tr>
                <td align="right">标识名称：</td>
                <td colspan="7">
                    <div class="ipt-box" >
                        <input type="text" class="ipt-txt" name="markName" value="${csEntWarn.markName}" readonly>
                    </div>
                </td>
            </tr>
            <tr>
                <td align="right">标识内容：</td>
                <td colspan="7">
                    <div class="ipt-box">
                        <input type="text" class="ipt-txt" name="markContent" value="${csEntWarn.markContent}" readonly>
                    </div>
                </td>
            </tr>
            <tr>
                <td align="right" colspan="5">录入人：</td>
                <td>${csEntWarn.importPeople}</td>
                <td align="right">录入日期：</td>
                <td>
                <fmt:formatDate value="${csEntWarn.importDate}" pattern="yyyy-MM-dd" />
                </td>
            </tr>
            <tr>
                <td align="right">审核结果：</td>
                <td colspan="3">
                    <div class="radio-box">
                        <c:if test="${csEntWarn.checkState=='0'}">
                           <label>取消预警</label>
                        </c:if>
                        <c:if test="${csEntWarn.checkState == '1'}">
                           <label>同意设置预警</label>
                        </c:if>
                        <c:if test="${csEntWarn.checkState == '2'}">
                            <label>待审核</label>
                        </c:if>
                        <c:if test="${csEntWarn.checkState == '3'}">
                            <label>审核退回</label>
                        </c:if>
                    </div>
                </td>
                <td align="right">审核人：</td>
                <td>
                ${csEntWarn.checkPeople}
                </td>
                <td align="right">审核日期：</td>
                <td><fmt:formatDate value="${csEntWarn.checkDate}" pattern="yyyy-MM-dd" />
                </td>
            </tr>
            <tr>
                <td align="right"> 审核意见：</td>
                <td colspan="7">
                    <div class="ipt-box">
                           <textarea rows="4" name="checkView" readonly="readonly">${csEntWarn.checkView}</textarea>
                    </div>
                </td>
            </tr>
        </table>
        <input type="hidden" class="ipt-txt" id="batchNo" name="batchNo" value="${csEntWarn.batchNo}">
        <div class="form-item clearfix">
            <div class="btn-box">
                <input type="button" id="${csEntWarn.urlFlag}" value="返 回" class="btn cancel">
            </div>
        </div>
    </div>
    </form>
    <div>
        <table id="ent-check-edit" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap">
				<thead>
					<tr>
						<th>序号</th>
						<th>统一信用代码</th>
						<th>注册号</th>
						<th>企业名称</th>
						<th>法定代表人</th>
						<th>企业类型</th>
						<th>行业</th>
						<th>住所</th>
						<th>登记机关</th>
						<th>管辖单位</th>
						<th>历史预警记录</th>
					</tr>
				</thead>
			</table>
    </div>
</div>
<script src="/js/lib/laydate/laydate.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/risk/entwarninfo/entwarninfo_list.js"></script>
</body>
</html>