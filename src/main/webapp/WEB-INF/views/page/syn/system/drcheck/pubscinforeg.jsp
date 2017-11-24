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
    <title>摇号</title>
    <link rel="stylesheet" type="text/css" href="/css/reg.server.css">
</head>
<body class="bg-lightblue">
<div class="yh-bg">
    <div class="yh-mod yh-header">
        <a href="##"></a>
    </div>
    <div class="yh-mod">
        <div class="yh-box">
            <h3 class="yh-title">抽查检查名单抽取结果</h3>
            <div class="clearfix">
                <table class="yh-table fl">
                    <tr>
                        <th>地区</th>
                        <th width="100" class="js-th">企业总数</th>
                        <th width="100" class="js-th">应抽数量</th>
                        <th width="100" class="js-th">实抽数量</th>
                    </tr>
                    <c:forEach items="${pubScinfoDtoList}" var="pubScinfoDto" varStatus="vstatus" begin="0" step="2">
	                    <tr>
	                        <td>${pubScinfoDto.regOrgShortDesc }</td>
	                        <td>${pubScinfoDto.backTotalEnt }</td>
	                        <td>${pubScinfoDto.totalEnt }</td>
	                        <td>${pubScinfoDto.totalEnt }</td>
	                    </tr>
                    </c:forEach>
                </table>
                <table class="yh-table fr">
                    <tr>
                        <th>地区</th>
                        <th width="100" class="js-th">企业总数</th>
                        <th width="100" class="js-th">应抽数量</th>
                        <th width="100" class="js-th">实抽数量</th>
                    </tr>
                   <c:forEach items="${pubScinfoDtoList}" var="pubScinfoDto" varStatus="vstatus" begin="1" step="2">
	                    <tr>
	                        <td>${pubScinfoDto.regOrgShortDesc }</td>
	                        <td>${pubScinfoDto.backTotalEnt }</td>
	                        <td>${pubScinfoDto.totalEnt }</td>
	                        <td>${pubScinfoDto.totalEnt }</td>
	                    </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
    </div>
<script>
    var browserWidth = screen.width;
    if (browserWidth >= 1440) {
        document.querySelector('body').className = "scr1440";
        var ele = document.querySelectorAll('.js-th');
        for(var i = 0 ;i < ele.length; i++){
            ele[i].style.width = "128px";
        }
    }
</script>
</body>