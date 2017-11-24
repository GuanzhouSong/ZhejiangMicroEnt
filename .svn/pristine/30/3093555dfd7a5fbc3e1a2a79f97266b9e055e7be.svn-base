<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
<link rel="stylesheet" href="/css/syn.css">
<link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css"> 
</head>
<body class="pd10">
<div>
    <table border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 mt30">
        <thead>
         <tr>
            <th style="text-align: center;">序号</th>
            <th style="text-align: center;">标识名称</th>
         </tr>
        </thead>
        <tbody>
             <c:forEach var="csConcernObj"   items="${csConcernObjList}"   varStatus="status">
                 <tr>
                    <td >${status.index+1}</td>
                    <td>${csConcernObj.markName}</td>
                 </tr>
             </c:forEach>
        </tbody>
    </table>
     <div class="form-item clearfix mt40">
            <div class="btn-box">
                <input type="button" id="cancel" value="返回" class="btn mr20">
            </div>
        </div>
</div>

<script src="/js/lib/laydate/laydate.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/concern/conc/con_apply_his.js"></script>
</body>
</html>