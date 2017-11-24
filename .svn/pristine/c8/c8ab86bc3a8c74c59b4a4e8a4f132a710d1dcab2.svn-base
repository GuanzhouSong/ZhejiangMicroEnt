<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String htmlData = request.getParameter("content1") != null ? request.getParameter("content1") : "";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean id="nowdate" class="java.util.Date" />
<!doctype html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
	<title>KindEditor JSP</title>
	<link rel="stylesheet" href="/js/lib/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="/css/reg.server.css">

	<script charset="utf-8" src="/js/lib/kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="/js/lib/kindeditor/lang/zh_CN.js"></script>
	<script charset="utf-8" src="/js/lib/kindeditor/plugins/code/prettify.js"></script>
	<script src="/js/lib/require.js"></script>
	<script src="/js/config.js"></script>
	<script src="/js/reg/server/yr/bulletins/list_edit.js"></script>	
</head>
<body class="pd10">
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
		<input type="hidden" id="UID" name="">
        <tr>
            <td class="bg-gray right" width="15%">标题</td>
            <td colspan="3">
                <div class="ipt-box col-12">
                 <input id="title" placeholder="请输入标题"  readonly="readonly"  class="ipt-txt" value="${Bulletins.title}" >                
                </div>
            </td>
        </tr>
         <tr>
            <td class="bg-gray right"><span class="light">*</span>发布范围</td>
            <td>
                <div class="radio-box pd0">
               <!-- 省级人员及管理员可以看到省级 -->
                <c:if test="${userVest == 4 || userVest == 0 }">   
                     <label class="font-12"><input type="radio" value="1" name="bulScope" <c:if test="${Bulletins.bulScope == '1'}">checked</c:if> >全省</label>
                </c:if>
                <!-- 市局级别及管理员可以看到 -->
                <c:if test="${userVest == 3 || userVest == 0 }">   
                     <label class="font-12"><input type="radio" value="3" name="bulScope" <c:if test="${Bulletins.bulScope == '3'}">checked</c:if> >全市</label>
                </c:if>
                     <label class="font-12"><input type="radio" value="2" name="bulScope" <c:if test="${Bulletins.bulScope == '2'}">checked</c:if> >本局</label>
                </div>
            </td>
            <td class="bg-gray right">发布日期 </td>
            <td><fmt:formatDate value="${empty Bulletins.setTime ? nowdate : Bulletins.setTime}" pattern="yyyy年MM月d日"/>
			</td>
        </tr>
        <tr>
            <td class="bg-gray right">发布部门</td>
            <td>
             ${Bulletins.setDeptname}
            </td>
            <td class="bg-gray right">发布人 </td>
            <td><div id="setName">${Bulletins.setName}</div>
			</td>
        </tr>
         <tr>
            <td class="bg-gray right"><span class="light">*</span>状态</td>
            <td>
                <div class="radio-box pd0"> 
                     <label class="font-12"><input type="radio" value="1" name="isValid" <c:if test="${empty Bulletins.isValid || Bulletins.isValid == '1'}">checked</c:if> >有效</label>
                     <label class="font-12"><input type="radio" value="0" name="isValid" <c:if test="${Bulletins.isValid == '0'}">checked</c:if> >无效</label>
                </div>
            </td>
            <td class="bg-gray right"><span class="light">*</span>修改日期 </td>
            <td>
            <c:if test="${empty Bulletins.modTime}"></c:if>
            <c:if test="${not empty Bulletins.modTime}">
            <fmt:formatDate value="${Bulletins.modTime}" pattern="yyyy年MM月d日"/>
            </c:if>
			</td>
          </tr>
        <tr>
            <td class="bg-gray right">内容</td>
            <td colspan="3">
                <div class="ipt-box col-12">
                <textarea  id="text1"  name="contents" cols="100" rows="10" style="width:700px;height:280px;visibility:hidden;">${Bulletins.contents}</textarea>
                </div>
                <span class="light-green">字数统计<span class="light" id="count"></span></span>
            </td>         
        </tr>
		<tr>
		    <td class="bg-gray right">附件
		    </td>
		    <td colspan="3">
		        <div id="filelabel">
		            <c:forEach items="${files}" var="obj">
		              <p><span path="${obj}" style="color:blue;cursor:pointer;padding: 9px 8px;"
		                       title="查看详情"><i
		                      class="xbt-icon file-icon"></i>${fn:substringAfter(obj, '-')}</span>
		                  &nbsp;&nbsp;
<%-- 		                  <a href="javascript:void(0)" path="${obj}">删除</a> --%>
		              </p>
		          </c:forEach>
		        </div>
		        <p class="pd2 file-upload" id="fileList" style="padding:4px;display: none;">
	               <span id="fileBox">
	                 <input type="file" id="btnFile" class="btnFil" name="btnFile" style="width:450px;border: 1px solid #ccc;"/>
	               </span>
	              <input type="hidden" id="evidenceData" name="bulData" value="${Bulletins.bulData}"/>
		          <input type="hidden" id="file" value=""/>
		          <iframe width="0" height="0" name="uploadframe"></iframe>
		          <input type="button" id="btnUpload" value="点击上传"/>
		          <span id="uploadState" style="color:red;display:none">上传中....</span>
		         </p>
		        <span class="light" style="padding:2px;display: none;">说明：上传附件资料支持图片JPG格式进行上传，上传的单个文件不超过20M。</span>
		    </td>
		</tr>
	</table>
<script>
    window._CONFIG = {
       chooseUrl:'${userType == 2 ? "/syn" : "/reg/server"}',
       flag:1,
       czflag:'${flag}'
    }
</script>
</body>
</html>