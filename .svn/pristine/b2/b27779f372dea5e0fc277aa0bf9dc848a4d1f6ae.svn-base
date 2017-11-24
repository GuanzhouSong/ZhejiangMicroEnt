<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <title>片区管理</title>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body>
<div class="pd20 clearfix">
    <div class="" style="margin-top: 10px">
        <form id="slicenoInfoForm">
        <input type="hidden" id="id" name="id" value="${codeSliceno.id}">
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10">
        <tr>
              <td width="30%" class="bg-gray right">所属管辖地区名称:</td>
              <td width="70%">
               <div class="ipt-box pd0">
                 <input type="text"  class="ipt-txt"  value="${supContent}" readonly="readonly">
               </div>
              </td>
         </tr>
         <tr>
              <td width="30%" class="bg-gray right">所属管辖地区编码:</td>
              <td width="70%">
               <div class="ipt-box pd0">
                 <c:if test="${!empty codeSliceno}">
                    <input type="text"  class="ipt-txt" id="supCode" name="supCode"  value="${codeSliceno.supCode}" readonly="readonly">
                </c:if>
                <c:if test="${empty codeSliceno}">
                    <input type="text"  class="ipt-txt" id="supCode" name="supCode" value="${parentSid}" readonly="readonly">
                </c:if>     
               </div>
              </td>
         </tr>
         <tr>
              <td width="30%" class="bg-gray right">类型:</td>
              <td width="70%">
               <div class="ipt-box pd0">
                 <label><input type="radio"  name="type" id="checksuc"  value="1"  ${codeSliceno.type !='2'?'checked':''}>片区&nbsp;</label>
                 <label><input type="radio"  name="type"  value="2"  ${codeSliceno.type =='2'?'checked':''}>商圈</label>
               </div>
              </td>
         </tr>
         <tr>
              <td width="30%" class="bg-gray right"><span style="color:red;">*</span>片区名称:</td>
              <td width="70%">
               <div class="ipt-box pd0">
                 <input type="text" name="content" id="content" class="ipt-txt" placeholder="请输入片区名称" value="${codeSliceno.content}" required>
               </div>
              </td>
         </tr>
         <!-- 
          <tr>
              <td width="30%" class="bg-gray right"><span style="color:red;">*</span>片区编码:</td>
              <td width="70%">
               <div class="ipt-box pd0">
                 <input type="text"  id="deptCode" name="code"  class="ipt-txt number" placeholder="请输入片区编码" value="${codeSliceno.code}" required>
               </div>
              </td>
         </tr>
          -->
         </table>
         <div class="clearfix mt20">
            <div class="center">
	        <button id="save" type="submit" class="btn btn-primary">保存</button>&nbsp;
	        <button id="cancel" type="button" class="btn btn-primary">取消</button>
 		    </div>
 		 </div>
        </form>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/business/slicenomanage/edit_main.js"></script>
</body>
</html>
