<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
<title>手动触发定时分流</title>
<link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
<link rel="stylesheet" href="/css/reg.server.css">
<link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery-ui.css">


</head>
<div class="pd20">
	<form id="webForm"> 
		<div class="form-list">
			<div class="form-item clearfix">
				<label class="item-name col-3">推送类型：</label>
				<div class="col-7">
					<div class="radio-box">
						<label><input  type="radio" name="flag" checked="checked" value="1">按企业名称</label> <label><input  name="flag" type="radio" value="2">按注册号</label>
						<label><input  name="flag" type="radio" value="3">按主体身份代码</label><label><input  name="flag" type="radio" value="4">全部推送</label>
					</div>
				</div>
			</div>
			<div id="type_1" class="IDType">
				<div class="form-item clearfix">
					<label class="item-name col-3">推送条件：</label>
					<div class="col-6">
						<div class="ipt-box">
							<input id="priPIDStr" class="ipt-txt"  >
						</div>
					</div>
				</div>
			</div>
			      
			<div class="form-item clearfix">
				<div class="btn-box">
					<input id="btn_save" type="button"  value="保 存" class="btn"> <input id="btn_cancel" type="button" value="取 消" class="btn">
				</div>
			</div>
		</div>
	</form>

	<script src="<c:url value="/js/lib/require.js"/>"></script>
	<script src="<c:url value="/js/config.js"/>"></script>
	<script src="<c:url value="/js/syn/system/pubdtinfo/pubdtinfoMaintain_edit.js"/>"></script>
	</body>
</html>