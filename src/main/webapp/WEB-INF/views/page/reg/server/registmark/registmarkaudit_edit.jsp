<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<meta charset="utf-8">
<title>分类标签审核</title>
<link rel="stylesheet" href="/css/reg.server.css">
<link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<body class="pd10">
	<form id="taskForm">
		<input type="hidden" name="IDName" value="${registMark.IDName }" />
		<input type="hidden" name="IDName" value="${registMark.IDStateCode }" />
		<input type="hidden" name="IDCode" id="IDCode" value="${registMark.IDCode }" /> <input type="hidden" name="markUuid" value="${registMark.markUuid }" /> <input type="hidden" name="auditorDesc" id="auditorDesc" value="" /> <input type="hidden" name="auditState" id="auditState" value="" />


	</form>
	<h3 class="h22-title center"></h3>
	<div class="pd10 bg-gray">
		<div class="clearfix">
			<div class="col-8 border0">
				<h5 class="h6-title mb10">标签审核信息</h5>
				<div class="form-list">
					<div class="form-item clearfix">
						<div class="col-6">
							<div class="item-name col-4">标签编号：</div>
							<div class="col-6">
								<div class="ipt-box">
									<input type="text" readonly="readonly" class="ipt-txt" value="${registMark.IDCode}">
								</div>
							</div>
						</div>
					</div>
					<div class="form-item clearfix">
						<div class="col-12">
							<div class="item-name col-2">标签名称：</div>
							<div class="col-10">
								<div class="ipt-box">
									<input type="text" readonly="readonly" class="ipt-txt" value="${registMark.IDName}" />
								</div>
							</div>
						</div>
					</div>
					<div class="form-item clearfix">
						<div class="col-12">
							<div class="item-name col-2">标签类别：</div>
							<div class="col-10">
								<div class="ipt-box">
									<input type="text" readonly="readonly" id="IDTypeTem" class="ipt-txt" value="" />
								</div>
							</div>
						</div>
					</div>
					<div class="form-item clearfix">
						<div class="col-6">
							<div class="item-name col-4">标签有效期至：</div>
							<div class="col-6">
								<div class="ipt-box">
									<c:if test="${fn:indexOf(registMark.validDate, '2099') != -1}">
										<input type="text" readonly="readonly" class="ipt-txt" value="长期有效" />
									</c:if>
									<c:if test="${fn:indexOf(registMark.validDate, '2099') == -1}">
										<input type="text" readonly="readonly" class="ipt-txt" value="<fmt:formatDate value="${registMark.validDate}" pattern="yyyy-MM-dd"/>" />
									</c:if>


								</div>
							</div>
						</div>
					</div>
					
					<div class="form-item clearfix">
						<div class="col-12">
							<div class="item-name col-2">对应的双随机检查事项：</div>
							<div class="col-10">
								<div class="radio-box">
									<label><input disabled="disabled" type="radio" name="doublyStoState" ${!(registMark.doublyStoState eq '1') ?  'checked="checked"' :''} value="0">无</label> <label><input disabled="disabled" name="doublyStoState" type="radio" value="1" ${registMark.doublyStoState eq '1' ?  'checked="checked"' :''}>有</label>
								</div>
							</div>
						</div>
					</div>
					<div class="form-item clearfix"  ${registMark.doublyStoState eq '1'?'':' style="display: none"'}>
						<div class="col-12">
							<div class="item-name col-2"></div>
							<div class="col-10">
								<div class="radio-box">
									<label>${registMark.doublyStoFirName }，${registMark.doublyStoSecName }，${registMark.doublyStoThiName }</label>
								</div>
							</div>
						</div>
					</div>
					<div class="form-item clearfix">
						<div class="col-12">
							<div class="item-name col-2">备注说明：</div>
							<div class="col-10">
								<div class="ipt-box">
									<textarea rows="3" cols="50" readonly="readonly">${registMark.IDDesc}</textarea>
								</div>
							</div>
						</div>
					</div>
					<div class="form-item clearfix">
						<div class="col-12">
							<div class="item-name col-2">适用范围：</div>
							<div class="col-10">
								<div class="radio-box">
									<label><c:if test="${registMark.applicationScopeCode eq '1'}">全省</c:if>
										<c:if test="${registMark.applicationScopeCode eq '2'}">本市</c:if>
										<c:if test="${registMark.applicationScopeCode eq '3'}">本局</c:if></label>
								</div>
							</div>
						</div>
					</div>
					<div class="form-item clearfix">
						<div class="col-12">
							<div class="item-name col-2">适用状态：</div>
							<div class="col-10">
								<div class="radio-box">
									<c:choose>
										<c:when test="${registMark.IDStateCode=='1'}">
											<input disabled="disabled" type="radio" name="IDStateCode" checked> 有效
                                			<input disabled="disabled" type="radio" name="IDStateCode"> 无效
		                                </c:when>
										<c:otherwise>
											<input disabled="disabled" type="radio" name="IDStateCode"> 有效
                                			<input disabled="disabled" type="radio" name="IDStateCode" checked> 无效
		                                </c:otherwise>
									</c:choose>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="clear">
				<div class="form-item ">
					<div class="col-4">
						<div class="item-name col-4">申请人：</div>
						<div class="col-6">
							<div class="ipt-box">
								<input type="text" readonly="readonly" class="ipt-txt" value="${registMark.setName}" />
							</div>
						</div>
					</div>
					<div class="col-4">
						<div class="item-name col-4">申请日期：</div>
						<div class="col-6">
							<div class="ipt-box">
								<input type="text" readonly="readonly" class="ipt-txt" value="<fmt:formatDate value='${registMark.setTime}' pattern="yyyy-MM-dd"/>" />
							</div>
						</div>
					</div>
					<div class="col-4">
						<div class="item-name col-3">申请部门：</div>
						<div class="col-6">
							<div class="ipt-box">
								<input type="text" readonly="readonly" class="ipt-txt" value="${registMark.setDeptname}" />
							</div>
						</div>
					</div>
				</div>
				<div class="form-item ">
					<div class="col-4">
						<div class="item-name col-4">审核人：</div>
						<div class="col-6">
							<div class="ipt-box">
								<c:if test="${flag=='1'}">
									<input type="text" readonly="readonly" class="ipt-txt" value="${sysUser.realName}" />
								</c:if>
								<c:if test="${flag=='2'}">
									<input type="text" readonly="readonly" class="ipt-txt" value="${registMark.auditorName}" />
								</c:if>
							</div>
						</div>
					</div>
					<div class="col-4">
						<div class="item-name col-4">审核日期：</div>
						<div class="col-6">
							<div class="ipt-box">
								<c:if test="${flag=='1'}">
									<input type="text" readonly="readonly" class="ipt-txt" value="${nowDate}" />
								</c:if>
								<c:if test="${flag=='2'}">
									<input type="text" readonly="readonly" class="ipt-txt" value="<fmt:formatDate value='${registMark.auditTime}' pattern="yyyy-MM-dd"/>" />
								</c:if>
							</div>
						</div>
					</div>
					<div class="col-4">
						<div class="item-name col-3">审核部门：</div>
						<div class="col-6">
							<div class="ipt-box">
								<c:if test="${flag=='1'}">
									<input type="text" readonly="readonly" class="ipt-txt" value="${auditDeptName}" />
								</c:if>
								<c:if test="${flag=='2'}">
									<input type="text" readonly="readonly" class="ipt-txt" value="${registMark.auditDeptName}" />
								</c:if>
							</div>
						</div>
					</div>
				</div>
				<div class="form-item ">
					<c:if test="${flag=='1'}">
						<div class="col-4">
							<div class="item-name col-4">审核结果：</div>
							<div class="col-6">
								<div class="radio-box">
									<input type="radio" name="auditStateTem" value="2"> 同意 <input type="radio" name="auditStateTem" value="3"> 不同意
								</div>
							</div>
						</div>
						<div class="col-8">
							<div class="item-name col-2">审核意见(限300字以内)：</div>
							<div class="col-8">
								<div class="ipt-box">
									<input type="text" id="auditorDescTem" class="ipt-txt" maxlength="300" />
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${flag=='2'}">
						<div class="col-4">
							<div class="item-name col-4">审核结果：</div>
							<div class="col-6">
								<div class="ipt-box">
									<input type="radio" name="auditStateTem" disabled="disabled" ${registMark.auditState=='2'?'checked':''}> 同意 <input type="radio" name="auditStateTem" disabled="disabled" ${registMark.auditState=='3'?'checked':''}> 不同意
								</div>
							</div>
						</div>
						<div class="col-8">
							<div class="item-name col-2">审核意见：</div>
							<div class="col-8">
								<div class="ipt-box">
									<input type="text" id="auditorDescTem" class="ipt-txt" readonly="readonly" value="${registMark.auditorDesc}" maxlength="300" />
								</div>
							</div>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</div>

	<div>
		<br>
		<h5 class="h6-title mb10 mt10">标签历史记录</h5>
		<table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row display nowrap" style="margin-top: 10px;">
			<thead>
				<tr>
					<th>序号</th>
					<th>标签编号</th>
					<th>标签名称</th>
					<th>标签类别</th>
					<th>备注说明</th>
					<th>设置人</th>
					<th>设置时间</th>
					<th>设置部门</th>
					<th>审核人</th>
					<th>审核时间</th>
					<th>审核部门</th>
					<th>审核状态</th>
					<th>审核意见</th>
					<th>适用范围</th>
					<th>修改日期</th>
				</tr>
			</thead>
		</table>
	</div>
	<div class="clearfix mt10">
		<div class="center">
			<c:if test="${flag=='1'}">
				<button id="save" type="submit" class="btn mr20">保存</button>
				<button id="cancel" type="button" class="btn">关闭</button>
			</c:if>
			<c:if test="${flag=='2'}">
				<button id="cancel" type="button" class="btn">关闭</button>
			</c:if>
		</div>
	</div>
	<script>
		//参数的传递
		window._CONFIG = {
			_IDType : '${registMark.IDType}',
			_sysUrl : '${sysUrl}'

		}
	</script>
	<script src="/js/lib/require.js"></script>
	<script src="/js/config.js"></script>
	<script src="/js/reg/server/registmark/registmarkaudit_edit.js"></script>
</body>
</html>