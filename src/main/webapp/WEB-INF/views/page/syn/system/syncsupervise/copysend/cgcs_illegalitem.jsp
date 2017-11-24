<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>企业违法案件--涉嫌违法事项</title>
    <link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body>
<input id="deptcode" type="hidden" value="${deptcode}"/>

    <div class="layer-bd pd20">
        <div class="mass-distribution">
            <div class="clearfix">
                <div class="ipt-box col-10">
                    <input id="searchparam" type="text" placeholder="请输入关键字搜索" class="ipt-txt fl">
                </div>
                <div class="center col-2">
                    <input type="button" class="btn btn-xs btn-search" value="搜索">
                </div>
            </div>
            <div id="illegalList" class="mt15">
            </div>
            <div class="center mt20">
                <input id="save" type="button" class="btn mr20" value="保 存">
                <input id="cancel" type="button" class="btn" value="取 消">
            </div>
        </div>
    </div>
    <script>
		if("${sysUser.userType}" == "1"){
			 window._CONFIG = {
					 _illegalitemUrlHead:'/reg/server/illegalitem/',
		     } 
		}else{
			window._CONFIG = {
					_illegalitemUrlHead:'/syn/illegalitem/',
		     } 
		}
</script>
    
    
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/copysend/cgcs_illegalitem.js"></script>
</body>
</html>