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
				<label class="item-name col-3">下放类型：</label>
				<div class="col-7">
					<div class="radio-box">
						<label><input  type="radio" name="yFlag"  value="1">下放到市级</label> <label><input checked="checked"  name="yFlag" type="radio" value="2">下放到各县市</label>
					</div>
				</div>
			</div>
			<div class="form-item clearfix">
				<label class="item-name col-3">是否下放省局登记<br>或省直属分局管辖企业数据：</label>
				<div class="col-7">
					<div class="radio-box">
						<label><input  type="radio" name="istransferFlag"  value="1">是</label> <label><input checked="checked"  name="istransferFlag" type="radio" value="2">否</label>
					</div>
				</div>
			</div>
			<div  class="IDType">
				<div class="form-item clearfix">
					<label class="item-name col-3">后置审批事项编码：</label>
					<div class="col-6">
						<div class="ipt-box">
							<input id="exaCodeStr" class="ipt-txt"  >
						</div>
					</div>
				</div>
			</div>
			<div  class="IDType">
				<div class="form-item clearfix">
					<label class="item-name col-3">部门编码：</label>
					<div class="col-6">
						<div class="ipt-box">
							<input id="checkDep" class="ipt-txt"  >
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
	<script src="<c:url value="/js/syn/system/licdept/pubdtinfotransfer_edit.js"/>"></script>
	</body>
</html>