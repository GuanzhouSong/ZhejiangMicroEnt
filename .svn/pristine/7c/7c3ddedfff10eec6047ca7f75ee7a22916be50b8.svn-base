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
    <title>部门管理</title>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body>
<div class="pd20 clearfix">
    <div class="" style="margin-top: 10px">
        <form  id="deptEditInfoForm">
            <input type="hidden" name="deptDID" value="${department.deptDID}">
            <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10">
              <tr>
                <td width="30%" class="bg-gray right">上级部门:</td>
                <td width="70%">
	                <div class="ipt-box pd0">
	                    <c:choose>
                         <c:when test="${empty department}">
                            <label><input type="radio" name="parentId" checked="checked" value="${parentIdForSibling}">添加同级部门</label>
                            <label><input type="radio" name="parentId" value="${parentIdForSub}">添加子部门</label>
                        </c:when>
                        <c:otherwise>
                            ${empty parentName?"-无上级部门-":parentName}
                        </c:otherwise>
                       </c:choose>
	                </div>
                </td>
	          </tr>
	          <tr>
                <td width="30%" class="bg-gray right"><span style="color:red;">*</span>部门名称:</td>
                <td width="70%">
	                <div class="ipt-box pd0">
	                  <input type="text" name="deptName" id="deptName" class="ipt-txt" 
	                  placeholder="请输入部门名称" value="${department.deptName}" required>
	                </div>
                </td>
	          </tr>
	          <tr>
                <td width="30%" class="bg-gray right"><span style="color:red;">*</span>部门简称:</td>
                <td width="70%">
	                <div class="ipt-box pd0">
	                  <input type="text" id="deptShortName"  name="deptShortName"  class="ipt-txt" placeholder="请输入部门简称"
                           value="${department.deptShortName}" required>
	                </div>
                </td>
	          </tr>
	          <tr>
                <td width="30%" class="bg-gray right"><span style="color:red;">*</span>部门编码:</td>
                <td width="70%">
	                <div class="ipt-box pd0">
	                  <input type="text"  id="deptCode" name="deptCode"  class="ipt-txt number" placeholder="请输入部门编码" value="${department.deptCode}" required>
	                </div>
                </td>
	          </tr>
	          <tr>
                <td width="30%" class="bg-gray right"><span style="color:red;">*</span>部门地址:</td>
                <td width="70%">
	                <div class="ipt-box pd0">
	                  <input type="text" id="deptAddress" name="deptAddress"  class="ipt-txt" placeholder="请输入部门地址"
                           value="${department.deptAddress}" required>
	                </div>
                </td>
	          </tr>
	          <tr>
                <td width="30%" class="bg-gray right"><span style="color:red;">*</span>邮编:</td>
                <td width="70%">
	                <div class="ipt-box pd0">
	                  <input type="text" id="postalCode" name="postalCode"  class="ipt-txt isZipCode" placeholder="请输入邮编"
                           value="${department.postalCode}" required>
	                </div>
                </td>
	          </tr>
	          <tr>
                <td width="30%" class="bg-gray right">备注:</td>
                <td width="70%">
	                <div class="ipt-box pd0">
	                 <textarea type="text" name="remark" style="height: 60px"  class="ipt-txt">${department.remark}</textarea>
	                </div>
                </td>
	          </tr>
	          <tr>
                <td width="30%" class="bg-gray right"><span style="color:red;">*</span>是否有效:</td>
                <td width="70%">
	                <div class="ipt-box pd0">
	                 <label><input type="radio" id="isValid" name="isValid"  value="1" ${department.isValid =='1'?'checked':''}/>是</label>&nbsp;&nbsp;&nbsp;
                     <label><input type="radio" name="isValid"  value="0" ${department.isValid =='0'?'checked':''}/>否</label>
	                </div>
                </td>
	          </tr>
            </table>
            <div class="clearfix mt20">
		    <div class="center">
		        <button id="save" type="submit" class="btn btn-primary">保存</button>
		        <button id="cancel" type="button" class="btn btn-primary">取消</button>
		    </div>
          </div>
       </form>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/yr/deptmanage/edit_main.js"></script>
</body>
</html>
