<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="renderer" content="webkit">
	<meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title></title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<style type="text/css">
.colorcss{background-color: #f4f4f5;}
</style>
<body>
<div class="pd20 clearfix">
     <input type="hidden" id="groupUid" value="${groupUid}"/>
     <div class="mt6">
           <div id="scgroupDiv">
             <h1 class="h3-title left">检查小组成员<a class="addGroup pointer fr">添加</a></h1>
             <table id="scgroupTable" border="0" cellspacing="0" cellpadding="0" width="100%" class="table-row mt30">
		        <thead>
		        <tr>
		            <th>序号</th>
		            <th>部门</th>
		            <th>检查人员</th>
		            <th>设为组长</th>
		            <th>设为专家</th>
		            <th>操作</th>
		        </tr>
		        </thead>
		     </table>
	        </div>
	        <div class="clearfix mt6">     
		         <div class="center" style="position: relative;margin-bottom: 50px">
	                <button id="save" type="button" class="btn btn-primary">提交</button>
	                <button id="cancel" type="button" class="btn btn-primary">关闭</button>
	             </div>
            </div>
    </div>
</div>
<script>
    window._CONFIG = {
       chooseUrl:'${sysUser.userType == 2 ? "/syn" : "/reg"}', 
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sccheck/scgroup/randomscgroup_add.js"></script>
</body>
</html>