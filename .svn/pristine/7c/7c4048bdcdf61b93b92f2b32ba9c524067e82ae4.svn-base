<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>无证无照--涉嫌违法事项</title>
    <link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body>

<div class="layer-bd pd10">

    <div class="mass-distribution">
        <div id="licType" class="radio-box pd0">
            <label class="mr20"><input id="front" type="radio" name="licType" value="1"/>前置许可事项</label>
            <label><input id="back" type="radio" name="licType" value="2" checked/>后置许可事项</label>
        </div>
        <div class="clearfix mt5">
            <div class="ipt-box col-10">
                <input id="searchparam" type="text" placeholder="请输入关键字搜索" class="ipt-txt fl">
            </div>
            <div class="center col-2">
                <input type="button" class="btn btn-xs" value="搜索">
            </div>

        </div>
        <div id="illegalList" class="mt15 ztree h-160">

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
		    		_urlHead:'/reg/server/yr/syslicense/',
		     } 
		}else{
			window._CONFIG = {
		    		_urlHead:'/syn/yr/syslicense/',
		     } 
		}
</script>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sendaffairs/cgcs_nocarditem.js"></script>
</body>
</html>