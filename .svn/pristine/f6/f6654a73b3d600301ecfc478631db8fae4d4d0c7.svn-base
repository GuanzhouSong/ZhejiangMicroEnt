<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>登记机关联络员维护</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box mb5">
        <div class="form-list">
            <div class="form-item clearfix mb10">
                <div id="uniCode" class="col-4">
                    <label class="item-name col-5">登记机关名称：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="name" value="" >
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">联络员姓名：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="liaName" value="" >
                        </div>
                    </div>
                </div>
                <div class="col-4" id="entName">
                    <label class="item-name col-5">联络员电话：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="tel" value=""/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item">
                <div class="btn-box">
                    <input type="button" id="search" value="查询" class="btn mr20">
                    <input type="reset" id="reset" value="重置" class="btn">
                </div>
            </div>
        </div>
    </form>
<div class="light-info">
    <span class="light">提示：本模块只提供登记机关联络员姓名和联系电话的修改。 </span>
</div>    
<table id="user-table" class="table-row perc-100 nowrap" width="100%">
    <thead>
    <tr>
        <th>序号</th>
        <th>操作</th>
        <th>登记机关编码</th>
        <th>登记机关名称</th>
        <th>登记机关简称</th>
        <th>联络员姓名</th>
        <th>联系电话</th>
    </tr>
    </thead>
</table>
<script>
    window._CONFIG = {
       chooseUrl:'${userType == 2 ? "/syn" : "/reg/server"}', 
    }
</script>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="/js/syn/system/coderegorg/regorg_list.js"></script>
</body>
</html>