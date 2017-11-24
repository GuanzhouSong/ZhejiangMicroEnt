<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>添加检查对象</title>
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<body class="pd10">
<div>
    <div>
        <form class="form-horizontal" id="sysForbidwordForm">
            <div class="form-list mt10">
                <div class="form-item clearfix">
                    <div class="col-12">
                        <label class="item-name col-3"><span class="light">*</span>检查对象类型:</label>
                        <div class="col-9">
                            <div class="ipt-box col-9">
	                            <input id="ent" type="radio" checked="checked" name="checkObjType" value="1">企业
			              		<input id="notlic" type="radio" name="checkObjType" value="2">无证无照户
			              		<input id="notent" type="radio" name="checkObjType" value="3">非企业单位
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-item clearfix">
                    <div class="col-12">
                        <label class="item-name col-3"><span class="light">*</span>被检查对象：</label>
                        <div class="col-9">
                            <div class="ipt-box col-9">
                            	<input type="text" id="entName" name="entName" readonly="readonly">
                            	<input type="button" class="btn mr20" id="queryselect" value="查询选入">
                            	<br>
                            	<span class="light">提示：不能查询选入的检查对象请直接录入完整的单位名称。</span>
                            </div>
                        </div>
                    </div>
                </div>
                
                <p class="center mb30 mt20">
                    <input type="button" class="btn mr20" id="save" value="确定">
	    			<input type="button" class="btn" id="close" value="取消">
                </p>
            </div>
        </form>
    </div>
</div>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sccheck/dailyresult/dailyresultinsert_edit.js"></script>
</body>
</html>