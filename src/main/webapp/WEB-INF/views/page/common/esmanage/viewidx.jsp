<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>索引查看</title>
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
</head>
<body class="pd10">
<div>
    <div class="print-nocard mb20">
        <h3>全景索引查看</h3>
    </div>
    <form id="hx-form">
    <div class="form-list">
        <div class="form-item clearfix">
            <div class="col-12">
                <div class="ipt-box">
                    <textarea rows="30" id="area"></textarea>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <div class="col-1">
            </div>
            <div class="col-5">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" id="priPID" name="priPID" placeholder="请输入内部序号">
                </div>
            </div>
            <div class="col-3">
              <div class="btn-box">
                <input type="submit" value="提 交" class="btn mr20">
	        	</div>
            </div>
        </div>
    </div>
    </form>
    
</div>


<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/lib/laydate/laydate.js"></script>
<script src="/js/common/idxmanage/viewidx.js"></script>
</body>
</html>