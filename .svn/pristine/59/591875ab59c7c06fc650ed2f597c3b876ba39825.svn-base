<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<body>
	<div class="pd20">
		<form id="webForm">
			<input type="hidden" name="id"> <input type="hidden" name="markUuid"> <input type="hidden" id="IDName" name="IDName"> <input type="hidden" id="IDCode" name="IDCode"> <input type="hidden" id="applicationScopeName" name="applicationScopeName"> <input type="hidden" id="setDeptCode" name="setDeptCode" value="${deptCode}"> <input type="hidden" id="doublyStoFirName" name="doublyStoFirName"> <input type="hidden" id="doublyStoSecName"
				name="doublyStoSecName"> <input type="hidden" id="doublyStoThiName" name="doublyStoThiName">

			<div class="form-list">
				<div class="form-item clearfix" style="text-align: center;">
					<label><span class="light">提示：监管标签大类与中类由省局统一管理维护，各地可自行设置标签小类。 </span></label>
					<!-- 	<div class="col-7">
							<span class="light">提示：监管标签大类与中类由省局统一管理维护，各地可自行设置标签小类。 </span>
					</div> -->
				</div>
				<div class="form-item clearfix">
					<label class="item-name col-3">标签类型：</label>
					<div class="col-6">
						<div class="radio-box">
							<label> <c:if test="${deptCode eq '330000'}">
									<input type="radio" name="IDType" checked="checked" value="1">大类(执法领域)</label> <label><input name="IDType" type="radio" value="2">中类(行业)</label><label><input name="IDType" type="radio" value="3">小类 (许可监管项目)</label>
							</c:if>
							<c:if test="${!(deptCode eq '330000')}">
								<label><input name="IDType" type="radio" value="3" checked="checked">小类(许可监管项目) </label>
							</c:if>
						</div>
					</div>
				</div>
				<div class="form-item clearfix">
					<label class="item-name col-3">标签有效期至：</label>
					<div id="div_validDate" class="col-2">
						<div class="ipt-box">
							<input id="validDate" class="ipt-txt" readonly="readonly" onclick="laydate();" name="validDate">
						</div>
					</div>
					<div class="col-2">
						<div class="radio-box">
							<input type='checkbox' id='checkValidDate'>长期有效
						</div>
					</div>

				</div>


				<div id="type_1" class="IDType" ${deptCode eq '330000' ? '':'style="display: none;"'}>
					<div class="form-item clearfix">
						<label class="item-name col-3"></label>
						<div class="col-6">
							<span class="light">注：全省适用的小类标签名称无需标注适用区域，地市、区县设置的自定义小类标签应在标签名称前标注适用区域，如杭州-危化品企业，杭州下城-餐饮服务企业，分别表示可适用于杭州全市和杭州下城区的监管标签。</span>
						</div>
					</div>
					<div class="form-item clearfix">
						<label class="item-name col-3">标签名称（大类）：</label>
						<div class="col-6">
							<div class="ipt-box">
								<input id="IDCode_1" class="ipt-txt" maxlength="50">
							</div>
						</div>
					</div>
				</div>
				<div id="type_2" class="IDType" style="display: none;">
					<div class="form-item clearfix">
						<label class="item-name col-3">标签名称（大类）：</label>
						<div class="col-6">
							<div class="ipt-box">
								<select id="type_2_IDCode_1" class="marklastSelect">

								</select>
							</div>
						</div>
					</div>
					<div class="form-item clearfix">
						<label class="item-name col-3"></label>
						<div class="col-6">
							<span class="light">注：全省适用的小类标签名称无需标注适用区域，地市、区县设置的自定义小类标签应在标签名称前标注适用区域，如杭州-危化品企业，杭州下城-餐饮服务企业，分别表示可适用于杭州全市和杭州下城区的监管标签。</span>
						</div>
					</div>
					<div class="form-item clearfix">
						<label class="item-name col-3">标签名称（中类）：</label>
						<div class="col-6">
							<div class="ipt-box">
								<input id="IDCode_2" class="ipt-txt">
							</div>
						</div>
					</div>
				</div>
				<div id="type_3" class="IDType" ${deptCode eq '330000' ? 'style="display: none;"':''}>
					<div class="form-item clearfix">
						<label class="item-name col-3">标签名称（大类）：</label>
						<div class="col-6">
							<div class="ipt-box">
								<select id="type_3_IDCode_1">

								</select>
							</div>
						</div>
					</div>
					<div class="form-item clearfix">
						<label class="item-name col-3">标签名称（中类）：</label>
						<div class="col-6">
							<div class="ipt-box">
								<select id="type_3_IDCode_2" class="marklastSelect">

								</select>
							</div>
						</div>
					</div>
					<div class="form-item clearfix">
						<label class="item-name col-3"></label>
						<div class="col-6">
							<span class="light">注：全省适用的小类标签名称无需标注适用区域，地市、区县设置的自定义小类标签应在标签名称前标注适用区域，如杭州-危化品企业，杭州下城-餐饮服务企业，分别表示可适用于杭州全市和杭州下城区的监管标签。</span>
						</div>
					</div>
					<div class="form-item clearfix">
						<label class="item-name col-3">标签名称（小类）：</label>
						<div class="col-6">
							<div class="ipt-box">
								<input id="IDCode_3" class="ipt-txt">
							</div>
						</div>
					</div>

					<div class="form-item clearfix">
						<label class="item-name col-3">对应的双随机检查事项：</label>
						<div class="col-2">
							<div class="radio-box">
								<label><input type="radio" name="doublyStoState" checked="checked" value="0">无</label> <label><input name="doublyStoState" type="radio" value="1">有</label>
							</div>
						</div>
					</div>
					<div class="form-item clearfix" id="div_doublyStoState" style="display: none">
						<label class="item-name col-3"></label>
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
					</div>
				</div>
				<div class="form-item clearfix">
					<label class="item-name col-3">备注说明：</label>
					<div class="col-6">
						<div class="ipt-box col-12">
							<textarea rows="3" id="IDDesc" name="IDDesc"></textarea>
						</div>
					</div>
				</div>
				<div class="form-item clearfix">
					<label class="item-name col-3">适用范围：</label>
					<div class="col-3">
						<div class="radio-box">
							<label><c:if test="${userType eq '1'}">
									<input type="radio" name="applicationScopeCode" checked="checked" value="1" data-text="全省">全省</label> <label><input name="applicationScopeCode" type="radio" value="3" data-text="本局">本局</label>
							</c:if>
							<c:if test="${userType eq '2'}">
								<input type="radio" name="applicationScopeCode" checked="checked" value="2" data-text="本市">本市</label>
								<label><input name="applicationScopeCode" type="radio" value="3" data-text="本局">本局</label>
							</c:if>
							<c:if test="${userType eq '3'}">
								<label><input name="applicationScopeCode" type="radio" value="3" data-text="本局">本局</label>
							</c:if>
						</div>
					</div>
				</div>
				<div class="form-item clearfix">
					<label class="item-name col-3">申请人：</label>
					<div class="col-2">
						<div class="ipt-box">
							<input name="setName" type="text" class="ipt-txt" style="border: 0" readonly="readonly" value="${sysUser.realName}">
						</div>
					</div>
				</div>
				<div class="form-item clearfix">
					<label class="item-name col-3">申请日期：</label>
					<div class="col-2">
						<div class="ipt-box">
							<input name="setTime" type="text" class="ipt-txt" style="border: 0" readonly="readonly" value="${nowDate}">
						</div>
					</div>
				</div>
				<div class="form-item clearfix">
					<label class="item-name col-3">申请部门：</label>
					<div class="col-3">
						<div class="ipt-box">
							<input id="setDeptname" name="setDeptname" type="text" class="ipt-txt" style="border: 0" readonly="readonly" value="${sysUser.departMent.deptName}">
						</div>
					</div>
				</div>
				<div class="form-item clearfix">
					<div class="btn-box">
						<input id="btn_save" type="submit" value="保 存" class="btn mr20"> <input id="btn_cancel" type="button" value="取 消" class="btn">
					</div>
				</div>
			</div>
		</form>
		<script src="/js/lib/laydate/laydate.js"></script>
		<script src="<c:url value="/js/lib/require.js"/>"></script>
		<script src="<c:url value="/js/config.js"/>"></script>
		<script src="<c:url value="/js/reg/server/registmark/registmarkapply_add.js"/>"></script>
</body>
</html>