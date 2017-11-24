<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>全部公告</title>
    <link rel="stylesheet" href="/css/sment/sment.server.css">
    <style type="text/css">
    .ul-list li{
   		font-size:17px;
    }
    .h-time{
    	font-size: 16px;
   	 	margin-right: 9%;
    }
    </style>
</head>
<body class="pd10">
			<div class="home-item h-notice fl">
                <div class="h-title">
                    <i class="h-icon"></i>
                    <span class="h-name">通知公告</span>
                    <hr />
                    <input type="hidden" id="moreFlag" value="1"/>
                <div class="more_ul-list" >
                </div>
                </div>
            </div>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/sment/bulletins/bulletins_more.js"></script>
</body>
</html>