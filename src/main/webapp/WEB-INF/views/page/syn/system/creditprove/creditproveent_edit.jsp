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
				<label class="item-name col-3 light">* ${proveType=='1'?'统一信用代码/注册号':'姓名' } ：</label>
				<div class="col-6">
					    <div class="ipt-box">
					        <c:if test="${proveType=='1'}">
					          <input id="regNO" name="regNO" class="ipt-txt"  maxlength="20">
					        </c:if>
					 		<c:if test="${proveType=='2'}">
					          <input id="tname" name="tname" class="ipt-txt" maxlength="50" >
					        </c:if>
						</div>
				</div>
			</div>
			<div id="type_1" class="IDType">
				<div class="form-item clearfix">
					<label class="item-name col-3 light" >* ${proveType=='1'?'企业名称':'身份证件号码' }：</label>
					<div class="col-6">
						<div class="ipt-box">
						 <c:if test="${proveType=='1'}">
						    <input id="entName" name="entName" class="ipt-txt" maxlength="100" >
						 </c:if>
						 <c:if test="${proveType=='2'}">
						    <input id="cerNO" name="cerNO" class="ipt-txt"  maxlength="40">
						 </c:if>
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
	<script>
    window._CONFIG = {
    		url:'${sysUrl}',
    		proveType:'${proveType}'
    }
	</script>
	<script src="<c:url value="/js/syn/system/creditprove/creditproveent_edit.js"/>"></script>
	</body>
</html>