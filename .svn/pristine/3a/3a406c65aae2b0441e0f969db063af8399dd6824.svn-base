<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
<title>分类标签审核列表</title>
<link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
<link rel="stylesheet" href="/css/reg.server.css">
<link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery-ui.css">


</head>
<div class="pd20">
	<form id="webForm">
		<input type="hidden" name="id" value="${bean.id}"> <input type="hidden" name="markUuid" value="${bean.markUuid}"> <input type="hidden" id="IDCode" name="IDCode" value="${bean.IDCode}"> <input type="hidden" id="doublyStoFirName" name="doublyStoFirName" value="${bean.doublyStoFirName}"> <input type="hidden" id="doublyStoSecName" name="doublyStoSecName" value="${bean.doublyStoSecName}"> <input type="hidden" id="doublyStoThiName" name="doublyStoThiName"
			value="${bean.doublyStoThiName}"> <input type="hidden" id="doublyStoFirCodeV" value="${bean.doublyStoFirCode}"> <input type="hidden" id="doublyStoSecCodeV" value="${bean.doublyStoSecCode}"> <input type="hidden" id="doublyStoThiCodeV" value="${bean.doublyStoThiCode}">

		<div class="form-list">
			<div class="form-item clearfix">
				<label class="item-name col-3">标签编号：</label>
				<div class="col-3">
					<div class="radio-box">
						<label>${bean.IDCode}</label>
					</div>
				</div>
			</div>
			<div class="form-item clearfix">
				<label class="item-name col-3">标签类型：</label>
				<div class="col-3">
					<div class="radio-box">
						<label><c:choose>
								<c:when test="${bean.IDType == '1'}">
							      	大类(执法领域)
							    </c:when>
								<c:when test="${bean.IDType == '2'}">
							       	中类(行业)
							    </c:when>
								<c:otherwise>  
							      	小类(许可监管项目)
							   </c:otherwise>
							</c:choose></label>
					</div>
				</div>
			</div>
			<div class="form-item clearfix">
				<label class="item-name col-3">标签有效期至：</label>

				<c:if test="${flag=='2'}">
					<c:if test="${fn:indexOf(bean.validDate, '2099') != -1}">
						<div class="col-2">
							<div class="radio-box">长期有效</div>
						</div>
					</c:if>
					<c:if test="${fn:indexOf(bean.validDate, '2099') == -1}">
						<div id="div_validDate" class="col-2">
							<div class="ipt-box">
								<input class="ipt-txt" disabled="disabled" readonly="readonly" value="<fmt:formatDate value="${bean.validDate}" pattern="yyyy-MM-dd"/>">
							</div>
						</div>
					</c:if>
				</c:if>
				<c:if test="${flag!='2'}">
					<c:if test="${fn:indexOf(bean.validDate, '2099') != -1}">
						<div id="div_validDate" class="col-2" style="display: none">
							<div class="ipt-box">
								<input id="validDate" class="ipt-txt" readonly="readonly" onclick="laydate();" name="validDate" value="<fmt:formatDate value="${bean.validDate}" pattern="yyyy-MM-dd"/>">
							</div>
						</div>
						<div class="col-2">
							<div class="radio-box">
								<input type='checkbox' id='checkValidDate' checked="checked">长期有效
							</div>
						</div>
					</c:if>
					<c:if test="${fn:indexOf(bean.validDate, '2099') == -1}">
						<div id="div_validDate" class="col-2">
							<div class="ipt-box">
								<input id="validDate" class="ipt-txt" readonly="readonly" value="<fmt:formatDate value="${bean.validDate}" pattern="yyyy-MM-dd"/>" onclick="laydate();" name="validDate">
							</div>
						</div>
						<div class="col-2">
							<div class="radio-box">
								<input type='checkbox' id='checkValidDate'>长期有效
							</div>
						</div>
					</c:if>
				</c:if>
			</div>

			<div class="form-item clearfix">
				<label class="item-name col-3"></label>
				<div class="col-6">
					<span class="light">注：全省适用的小类标签名称无需标注适用区域，地市、区县设置的自定义小类标签应在标签名称前标注适用区域，如杭州-危化品企业，杭州下城-餐饮服务企业，分别表示可适用于杭州全市和杭州下城区的监管标签。</span>
				</div>
			</div>
			<div id="type_1" class="IDType">
				<div class="form-item clearfix">
					<label class="item-name col-3">标签名称：</label>
					<div class="col-6">
						<div class="ipt-box">
							<input id="IDCode_1" name="IDName" class="ipt-txt" ${flag=='2'?'disabled':''} value="${bean.IDName}">
						</div>
					</div>
				</div>
			</div>
			<c:if test="${bean.IDType == '3'}">
				<div class="form-item clearfix">
					<label class="item-name col-3">对应的双随机检查事项：</label>
					<div class="col-3">
						<div class="radio-box">
							<label><input type="radio" name="doublyStoState" ${!(bean.doublyStoState eq '1') ?  'checked="checked"' :''} value="0" ${flag=='2'?'disabled':''}>无</label> <label><input name="doublyStoState" type="radio" value="1" ${bean.doublyStoState eq '1' ?  'checked="checked"' :''} ${flag=='2'?'disabled':''}>有</label>
						</div>
					</div>
				</div>
				<div class="form-item clearfix" id="div_doublyStoState" ${bean.doublyStoState eq '1'?'':' style="display: none"'}>
					<label class="item-name col-3"></label>
					<c:if test="${flag=='2'}">
						<div class="col-6">
							<div class="radio-box">
								<label>${bean.doublyStoFirName }，${bean.doublyStoSecName }，${bean.doublyStoThiName }</label>
							</div>
						</div>
					</c:if>
					<c:if test="${flag!='2'}">
						<div class="ipt-box col-2">
							<select id="doublyStoFirCode" name="doublyStoFirCode">

							</select>
						</div>
						<div class="ipt-box col-2">
							<select id="doublyStoSecCode" name="doublyStoSecCode">

							</select>
						</div>
						<div class="ipt-box col-2">
							<select id="doublyStoThiCode" name="doublyStoThiCode">

							</select>
						</div>
					</c:if>

				</div>
			</c:if>
			<div class="form-item clearfix">
				<label class="item-name col-3">备注说明：</label>
				<div class="col-6">
					<div class="ipt-box col-12">
						<textarea rows="3" id="IDDesc" name="IDDesc" ${flag=='2'?'disabled':''}>${bean.IDDesc}</textarea>
					</div>
				</div>
			</div>
			<div class="form-item clearfix">
				<label class="item-name col-3">适用范围：</label>
				<div class="col-3">
					<div class="radio-box">

						<c:if test="${flag=='2'}">
							<label><c:if test="${bean.applicationScopeCode eq '1'}">全省</c:if> <c:if test="${bean.applicationScopeCode eq '2'}">本市</c:if> <c:if test="${bean.applicationScopeCode eq '3'}">本局</c:if></label>
						</c:if>
						<c:if test="${flag!='2'}">
							<c:if test="${null != bean.auditTime && !('' eq bean.auditTime) }">
								<label><c:if test="${bean.applicationScopeCode eq '1'}">全省</c:if> <c:if test="${bean.applicationScopeCode eq '2'}">本市</c:if> <c:if test="${bean.applicationScopeCode eq '3'}">本局</c:if></label>
							</c:if>
							<c:if test="${null == bean.auditTime ||'' eq bean.auditTime }">
								<label><c:if test="${userType eq '1'}">
										<input type="radio" name="applicationScopeCode" ${bean.applicationScopeCode eq '1' ?'checked="checked"':'' } value="1" data-text="全省">全省</label>
								<label><input name="applicationScopeCode" type="radio" value="3" ${bean.applicationScopeCode eq '3' ?'checked="checked"':'' } data-text="本局">本局</label>
							</c:if>
							<c:if test="${userType eq '2'}">
								<input type="radio" name="applicationScopeCode" ${bean.applicationScopeCode eq '2' ?'checked="checked"':'' } value="2" data-text="本市">本市</label>
								<label><input name="applicationScopeCode" type="radio" value="3" data-text="本局" ${bean.applicationScopeCode eq '3' ?'checked="checked"':'' }>本局</label>
							</c:if>
							<c:if test="${userType eq '3'}">
								<label>本局</label>
							</c:if>
						</c:if>
			</c:if>

		</div>
</div>
</div>
<div class="form-item clearfix">
	<label class="item-name col-3">申请人：</label>
	<div class="col-2">
		<div class="ipt-box">
			<input name="setName" type="text" class="ipt-txt" style="border: 0" value="${bean.setName}">
		</div>
	</div>
</div>
<div class="form-item clearfix">
	<label class="item-name col-3">申请日期：</label>
	<div class="col-2">
		<div class="ipt-box">
			<input name="setTimeStr" type="text" class="ipt-txt" style="border: 0" value="${bean.setTimeStr}">
		</div>
	</div>
</div>
<div class="form-item clearfix">
	<label class="item-name col-3">申请部门：</label>
	<div class="col-2">
		<div class="ipt-box">
			<input name="setDeptname" type="text" class="ipt-txt" style="border: 0" value="${bean.setDeptname}">
		</div>
	</div>
</div>
<div class="form-item clearfix">
	<label class="item-name col-3">标签状态：</label>
	<div class="col-2">
		<div class="ipt-box">
			<select id="IDStateCode" name="IDStateCode" ${flag=='2'?'disabled':''}>
				<option value="1" ${bean.IDStateCode =="1" ? "selected='selected'" : "" }>有效</option>
				<option value="2" ${bean.IDStateCode =="2" ? "selected='selected'" : "" }>无效</option>
			</select>
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
				<th>标签说明</th>
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
<br>

<c:if test="${flag == '1' }">
	<div class="form-item clearfix">
		<div class="btn-box">
			<input id="btn_save" type="submit" value="保 存" class="btn mr20"> <input id="btn_cancel" type="button" value="取 消" class="btn">
		</div>
	</div>
</c:if>
<c:if test="${flag == '2' }">
	<div class="form-item clearfix">
		<div class="btn-box">
			<input id="btn_cancel" type="button" value="关 闭" class="btn">
		</div>
	</div>
</c:if>

</div>
</form>


<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/server/registmark/registmarkapply_edit.js"/>"></script>
</body>
</html>