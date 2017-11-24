<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>备案部门对照维护</title>
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body>
<jsp:useBean id="nowdate" class="java.util.Date" />
<fmt:formatDate var="nowdate" value="${nowdate}" pattern="yyyy-MM-dd"/>
<div class="pd20 clearfix">
    <h4 class="h4-title light" >提示：文件对应备案部门是指:国家法律法规规定本应该负责备案监管的部门,实际备案部门是指:实际落实备案监管的部门;系统会把信息推送到实际备案部门名下  
    </h4>
    <table border="0" cellspacing="0" cellpadding="0" class="table-horizontal mb10">
        <tbody>
        <tr>
            <td class="bg-gray right " width="11%"><span class="light">* </span>备案事项选择</td>
            <td width="40%">
                <div class="ipt-box col-12">
                    <input type="text" id="licName" value="${codeLicense.exaName}"  class="fl ipt-txt" disabled="disabled">
                    <span class="add-icon"  id="yccodetree"><i></i></span>
                </div>
            </td>
            <td class="bg-gray right " width="10%">设置人</td>
	            <td width="40%">
	                <div class="ipt-box col-12"> 
	                    ${sysUser.realName} 
	                </div>
	        </td>
        </tr>
        <tr>
            <td class="bg-gray right " width="10%">备案事项名称</td>
            <td width="40%">
                <div class="ipt-box col-12">
                    <input type="text" id="licNameText"  value="${codeLicense.exaName}" class="fl ipt-txt" value="" disabled="disabled">
                </div>
            </td>
            <td class="bg-gray right" width="10%">备案机关</td>
            <td><span id="exaCodetext"> 
                 ${codeLicense.licDept}
                </span>
	       </td>
        </tr>
        <!-- 新增 -->
        <c:if test="${flag==1 }">
        	<tr>
	            <td class="bg-gray right" width="10%">职能部门</td>
	            <td width="40%">
	                <div class="ipt-box col-12"> 
	                   <span id="licDeptTypeName"></span>
	                </div>
	            </td>
	            <td class="bg-gray right" width="10%">法律依据</td>
	            <td><span id="licReaTem">
	                      
		            </span>
		       </td>
	        </tr>
	        <tr>
	            <td class="bg-gray right " width="17%"><span class="light">* </span> 文件规定对应备案部门</td>
	            <td width="40%">
	                <div class="ipt-box col-12"> 
	                     <input type="text" id="deptNameText"  class="fl ipt-txt" value="${licDeptList[0].deptName}"  disabled="disabled">
 	                     <span class="add-icon"  id="selectDept"><i></i></span>
	                </div>
	            </td>
	            <td class="bg-gray right" width="10%">设置日期</td>
	            <td><span id="exaCodetext">
	                    ${nowdate}
		            </span>
		       </td>
	        </tr> 
	        <tr>
	            <td class="bg-gray right " width="10%">* 企业所属行政区划</td>
	            <td width="40%">
	                <div class="ipt-box col-12"> 
	                    <input type="text" id="areaNameText"  class="fl ipt-txt" value="${licDeptList[0].areaName}"  disabled="disabled">
 	                    <span class="add-icon"  id="selectcity"><i></i></span>
	                </div>
	            </td>
	            <td class="bg-gray right" width="10%">* 实际备案部门</td>
	            <td>
	                <div class="ipt-box col-12"> 
	                <span id="exaCodetext">
	                    <input type="text" id="orgNameText"  class="fl ipt-txt" value="${licDeptList[0].orgName}"  disabled="disabled">
 	                    <span class="add-icon"  id="selectAdDept"><i></i></span>
		            </span>
		            </div>
		       </td>
	        </tr> 
        </c:if>
        <!-- 修改 -->
        <c:if test="${flag==2 }">
	        <tr>
	            <td class="bg-gray right" width="10%">职能部门</td>
	            <td width="40%">
	                <div class="ipt-box col-12"> 
	                   <span id="licDeptTypeName">${licDeptList[0].dutyDeptName}</span>
	                </div>
	            </td>
	            <td class="bg-gray right" width="10%">法律依据</td>
	            <td><span id="licReaTem">
	                      ${codeLicense.licRea}
		            </span>
		       </td>
	        </tr>
	        <tr>
	            <td class="bg-gray right " width="17%"><span class="light">* </span> 文件规定对应备案部门</td>
	            <td width="40%">
	                <div class="ipt-box col-12"> 
	                     <input type="text" id="deptNameText"  class="fl ipt-txt" value="${licDeptList[0].deptName}"  disabled="disabled">
 	                     <span class="add-icon"  id="selectDept"><i></i></span>
	                </div>
	            </td>
	            <td class="bg-gray right" width="10%">设置日期</td>
	            <td><span id="exaCodetext">
	                    ${nowdate}
		            </span>
		       </td>
	        </tr> 
	          <tr>
	            <td class="bg-gray right " width="15%"><span class="light">* </span>企业所属行政区划</td>
	            <td width="40%">
	                <div class="ipt-box col-12"> 
	                     <input type="text" id="areaNameText"  class="fl ipt-txt" value="${licDeptList[0].areaName}"  disabled="disabled">
 	                     <span class="add-icon"  id="selectcity"><i></i></span>
	                </div>
	            </td>
	            <td class="bg-gray right" width="15%"><span class="light">* </span> 实际备案部门</td>
	            <td><div class="ipt-box col-12"> 
	                     <input type="text" id="orgNameText"  class="fl ipt-txt" value="${licDeptList[0].orgName}"  disabled="disabled">
 	                     <span class="add-icon"  id="selectAdDept"><i></i></span>
	                </div>
		       </td>
	        </tr> 
	        <tr>
	            <td class="bg-gray right" width="10%"><span class="light">* </span> 是否有效</td>
	            <td width="40%">
	                <div class="ipt-box col-12"> 
	                    <input type="radio" value="1" name="isValidText" checked="checked">有效
		                <input type="radio" value="0" name="isValidText">无效
		            </div>
	            </td>
	            <td class="bg-gray right" width="10%"><span class="light"></span></td>
	            <td><div class="ipt-box col-12">
	                    
	                </div>
		        </td>
	        </tr>
	      
        </c:if> 
        </tbody>
    </table> 
    <!-- 传递参数区域 -->
    <form  id="licDeptform"> 
        <input type="hidden"  id="isValid" name="isValid" value="${licDeptList[0].isValid}" >
        <input type="hidden"  id="deptCode" name="deptCode" value="${licDeptList[0].deptCode}" >
        <input type="hidden"  id="exaCode" name="exaCode" value="${licDeptList[0].exaCode}" >
        <input type="hidden"  id="isSameGov" name="isSameGov" value="${licDeptList[0].isSameGov}" >
        <input type="hidden"  id="uid" name="uid" value="${licDeptList[0].uid}" >
        <input type="hidden"  id="adCode" name="adCode" value="${licDeptList[0].adCode}" >
        <input type="hidden"  id="orgName" name="orgName" value="${licDeptList[0].orgName}" >
        <input type="hidden"  id="yiedistrict" name="yiedistrict" value="${licDeptList[0].yiedistrict}" > 
        <input type="hidden"  id="areaName" name="areaName" value="${licDeptList[0].areaName}" > 
        <input type="hidden"  id="setTime" name="setTime" value="${nowdate}" > 
        <input type="hidden"  id="setName" name="setName" value="${sysUser.realName}" >
        <input type="hidden"  id="licDeptType" name="licDeptType" value="${licDeptList[0].licDeptType}" >
        <input type="hidden"  id="deptName" name="deptName" value="${licDeptList[0].deptName}" > 
        <input type="hidden"  id="dutyDeptCode" name="dutyDeptCode" value="${licDeptList[0].dutyDeptCode}" >
        <input type="hidden"  id="dutyDeptName" name="dutyDeptName" value="${licDeptList[0].dutyDeptName}" > 
    </form> 
    <p class="center"><input type="button" id="savelicdept" class="btn mr20" value="确 定"><input type="button" id="cancellicdept" class="btn" value="关闭"></p>
</div>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/syn/system/licdzdept/licdzdept_edit_main.js"/>"></script>
 <script>
    window._CONFIG = {
       _flag:'${flag}', //修改标识   
       _licDeptType:'${licDeptList[0].licDeptType}',
       _isValid:'${licDeptList[0].isValid}',
       _sysUrl:'${sysUrl}'
     }
</script>
</body>
</html>