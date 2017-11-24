<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>选择惩戒类型</title>
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body>
<div class="pd20">
	<div class="tab-header type-tab clear pdb10 border-bottom" >
		<ul class="clearfix" style="margin-left:10px">
	     	<li class="tab-selected" id="ent"><span class="tab-item"><a href="javascript:void(0);">企业</a></span></li>
	
	     	<li class="tab-selected" id="man"><span class="tab-item"><a href="javascript:void(0);">自然人</a></span></li>
	     </ul>
     </div>
</div>
<script>
	var userType = '${sessionScope.session_sys_user.userType}';
	var urlHead = '/syn';
	if(userType==1){
		urlHead='/reg/server';
	}
    window._CONFIG = {
   		urlHead: urlHead
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/nocreditPunish/info/entrance.js"></script>

</body>
