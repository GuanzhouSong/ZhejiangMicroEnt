<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
<title>添加其他检查事项</title>
<link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
<link rel="stylesheet" href="/css/reg.server.css">
<link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery-ui.css"> 
</head>
<div class="pd20">
	<form id="webForm"> 
		<div class="form-list"> 
			<div  class="IDType">
				<div class="form-item clearfix">
					<label class="item-name col-3 light" >* 检查事项名称(限50个字符)：</label>
					<div class="col-6">
						<div class="ipt-box">
						    <input id="checkName" name="checkName" class="ipt-txt" maxlength="50" >
						</div>
					</div>
				</div>
			</div>
			<div  class="IDType">
				<div class="form-item clearfix">
					<label class="item-name col-3 light" > 说明(限300个字符)：</label>
					<div class="col-6">
						<div class="ipt-box">
						    <textarea id="remark" name="remark"  maxlength="300" style="height: 80px;"> </textarea>
						</div>
					</div>
				</div>
			</div>
			<div class="form-item clearfix">
				<div class="btn-box">
					<input id="btn_save" type="button"  value="保 存" class="btn"> <input id="cancel" type="button" value="取 消" class="btn">
				</div>
			</div>
		</div>
	</form>

	<script src="<c:url value="/js/lib/require.js"/>"></script>
	<script src="<c:url value="/js/config.js"/>"></script>
	<script>
    window._CONFIG = {
    		_sysUrl:'${sysUrl}' 
    }
	</script>
	<script src="<c:url value="/js/syn/system/sccheck/scplantask/addotherscchecktype_edit_main.js"/>"></script>
	</body>
</html>