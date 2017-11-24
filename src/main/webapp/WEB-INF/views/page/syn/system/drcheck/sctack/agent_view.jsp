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
    <title>执法人员</title>
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="stylesheet" href="/css/vendor/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
<!--     <link rel="stylesheet" href="/css/vendor/bootstrap.min.css"> -->
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <div class="tab-content">
        <div class="tab-panel tab-panel-show">
            <form id="backFormId">
    			<input type="hidden" class="taskNO" name="taskNO" id="depttaskNO" value="${pubDeptSctaskDto.UID}"/>
	    	</form>
	    	<div class="clearfix mb5">
			    <h5 class="fl mr10 h5-title">检查人员</h5>
			</div>
			<table border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 mt30 mb10 nowrap" id="agentTableId">
			    <thead>
			    <tr>
			        <th width="5%">序号</th>
                    <th width="13%">单位</th>
                    <th width="8%">单位层级</th>
                    <th width="8%">部门机构</th>
                    <th width="11%">岗位大类</th>
                    <th width="8%">姓名</th>
                    <th width="10%">所属地区</th>
                    <th width="10%">岗位管辖片区</th>
                    <th>执法清单事项范围</th>
			    </tr>
			    </thead>
			</table>
        </div>
    </div>
</div>
<div class="center mb20">
<input type="button" value="关闭" class="btn" id="close"/>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/drcheck/sctack/randomagent_main.js"></script>
</body>
</html>