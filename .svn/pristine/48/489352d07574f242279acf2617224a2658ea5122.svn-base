<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="/css/reg.client.css">
    <script type="text/javascript">
    	if("${error}"!=""){
    		alert("${error}");
    	}
    </script>
</head>
<body>
<div class="mt20">
    <div class="mod mod-tb-notice-detail">
        <div class="mod-bd">
            <div class="content">
                <div class="hd center">
                    <h3>${SmentBulletins.title }</h3>
                    <p><span class="mr40">来源：${SmentBulletins.setDeptname }</span><span class="mr40">发布时间：<fmt:formatDate value="${SmentBulletins.setTime }" pattern="yyyy-MM-dd"/>
                    </p>
                </div>
                <div class="bd">
                    <div class="bd-cont" id="content">
                     <p id="content">${SmentBulletins.contents }</p>
                    </div>
                </div>
                <div class="fd">
                   	 发布人：${SmentBulletins.setName }
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
</body>
</html>