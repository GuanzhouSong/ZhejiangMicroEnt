<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title></title>
     <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<div>
        <form class="form-horizontal" id="sysversion-form">
        	<input type="hidden" name="id" value="${sysVersion.id }"/>
        	<table class="table-horizontal" width="100%">
	            <tr>
	                <td class="bg-gray right" width="15%">标题</td>
	                <td width="85%">
                        <div class="ipt-box">
                            <input type="text" name="title" id="title" value="${sysVersion.title }" class="ipt-txt" />
                        </div>
	                 </td>
	            </tr>
	            <tr>
	            	<td class="bg-gray right">更新内容</td>
	            	<td>
                        <div class="ipt-box">
                            <textarea name="contents" id="contents" style="height:250px;" class="required" >${sysVersion.contents }</textarea>
                        </div>
                    </td>
	            </tr>
            </table>
            <div class="center mt10">
                <button id="save" type="submit" class="btn ">保存</button>
                <button id="cancel" type="button" class="btn ">关闭</button>
            </div>
        </form><br/>
    </div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/business/sysversion/edit_main.js"></script>
</body>
</html>