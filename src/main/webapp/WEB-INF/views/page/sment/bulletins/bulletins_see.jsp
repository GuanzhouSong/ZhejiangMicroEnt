<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
	<title>KindEditor JSP</title>
	<link rel="stylesheet" href="/js/lib/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="/css/sment/sment.server.css">
</head>
<body class="pd10">
    <form class="form-horizontal" id="form">
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">                            
       	<input type="hidden" id="UID" name="">
        <tr>
            <td class="bg-gray right" width="15%">标题</td>
            <td colspan="3">
                <div class="ipt-box col-12">
                 <input name="title" id="title" readonly="readonly" placeholder="请输入标题"  class="ipt-txt" value="${SmentBulletins.title}" >                
                </div>
            </td>
        </tr>
        <tr>
            <td class="bg-gray right">公告类型 </td>
            <td width="35%">
                <div class="radio-box pd0">
                     <label class="font-12"><input type="radio" value="3" name="bulType" <c:if test="${SmentBulletins.bulType == '3'}">checked</c:if> >对内公告</label>
                     <label class="font-12"><input type="radio" value="1" name="bulType" <c:if test="${SmentBulletins.bulType == '1'}">checked</c:if> >对外公告</label>
                     <label class="font-12"><input type="radio" value="5" name="bulType" <c:if test="${SmentBulletins.bulType == '5'}">checked</c:if>>内外公告</label>
                </div>
            </td>
            <td class="bg-gray right" width="15%" id="isValid">是否有效 </td>
            <td>
                <div class="radio-box pd0">
                     <label class="font-12"><input type="radio" value="1" name="isValid" <c:if test="${SmentBulletins.isValid == '1'}">checked</c:if>>是</label>
                     <label class="font-12"><input type="radio" value="0" name="isValid" <c:if test="${SmentBulletins.isValid == '0'}">checked</c:if>>否</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="bg-gray right">发布范围</td>
            <td>
                <div class="radio-box pd0">
               <!-- 省级人员及管理员可以看到省级 -->
                <c:if test="${userVest == 4 || userVest == 0 }">   
                     <label class="font-12"><input type="radio" value="1" name="bulScope" <c:if test="${SmentBulletins.bulScope == '1'}">checked</c:if> >全省</label>
                </c:if>
                <!-- 市局级别及管理员可以看到 -->
                <c:if test="${userVest == 3 || userVest == 0 }">   
                     <label class="font-12"><input type="radio" value="3" name="bulScope" <c:if test="${SmentBulletins.bulScope == '3'}">checked</c:if> >本市</label>
                </c:if>
                     <label class="font-12"><input type="radio" value="2" name="bulScope" <c:if test="${SmentBulletins.bulScope == '2'}">checked</c:if> >本局</label>
                </div>
            </td>
            <td class="bg-gray right">添加人 </td>
            <td><div id="setName">${SmentBulletins.setName}</div>
			</td>
        </tr>
        <tr>
        	<td class="bg-gray right">创建时间</td>
        	<td>${SmentBulletins.createTime}</td>
        	<td class="bg-gray right">点击量</td>
        	<td>${SmentBulletins.readCount}</td>
        </tr>
        <tr>
            <td class="bg-gray right">内容</td>
            <td colspan="3">
                <div class="ipt-box col-12">
                <textarea  id="text1" readonly="readonly"  name="contents" cols="100" rows="10" style="width:700px;height:280px;visibility:hidden;">${SmentBulletins.contents}</textarea>
                </div>
            </td>         
        </tr>
	</table>
	</form>
	 <input type="button" class="btn" value="关 闭" id="cancel" style="margin-left: 45%;margin-top: 11px;"/></p>
<script>
    window._CONFIG = {
       flag:1
    }
</script>
<script charset="utf-8" src="/js/lib/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="/js/lib/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="/js/lib/kindeditor/plugins/code/prettify.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/sment/bulletins/list_edit.js"></script>	
</body>
</html>

