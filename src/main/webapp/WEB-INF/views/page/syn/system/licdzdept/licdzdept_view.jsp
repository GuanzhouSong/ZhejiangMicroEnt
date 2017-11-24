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
    <h4 class="h4-title light" ></h4>
    <table border="0" cellspacing="0" cellpadding="0" class="table-horizontal mb10">
        <tbody>
        <tr>
            <td class="bg-gray right " width="11%"><span class="light"> </span>备案事项选择</td>
            <td width="40%">
                <div class="ipt-box col-12">
                    ${codeLicense.exaName} 
                </div>
            </td>
            <td class="bg-gray right" width="10%"><span class="light"> </span> 设置人</td>
          	<td width="40%">
              <div class="ipt-box col-12"> 
                   ${licDeptList[0].setName} 
           </div>
          	</td>
        </tr>
        <tr>
            <td class="bg-gray right " width="10%">备案事项名称</td>
            <td width="40%">
                <div class="ipt-box col-12">
                    ${codeLicense.exaName}
                </div>
            </td>
            <td class="bg-gray right" width="10%">备案机关</td>
            <td><span id="exaCodetext"> 
                 ${codeLicense.licDept}
                </span>
	       </td>
        </tr> 
        <tr>
          <td class="bg-gray right" width="10%">职能部门</td>
          <td width="40%">
              <div class="ipt-box col-12"> 
                 <span id="deptNames">${licDeptList[0].dutyDeptName}</span>
              </div>
          </td>
          <td class="bg-gray right" width="10%">法律依据</td>
          <td><span >
                    ${codeLicense.licRea}
           </span>
      	 </td>
        </tr>
        <tr>
          <td class="bg-gray right " width="10%"><span class="light"> </span> 文件规定对应备案部门</td>
          <td width="40%">
              <div class="ipt-box col-12"> 
                   ${licDeptList[0].deptName}
              </div>
          </td>
          <td class="bg-gray right" width="10%"><span class="light"></span> 设置日期</td>
	            <td><div class="ipt-box col-12"> 
	                 <fmt:formatDate value="${licDeptList[0].setTime}" type="date" pattern="yyyy-MM-dd"/> 
	                </div>
		  </td>
         </tr> 
         <tr>
          <td class="bg-gray right " width="10%">企业所属行政区划</td>
          <td width="40%">
              <div class="ipt-box col-12"> 
                  ${licDeptList[0].areaName}   
              </div>
          </td>
          <td class="bg-gray right" width="10%">实际备案部门</td>
          <td><span id="exaCodetext">
                    ${licDeptList[0].orgName} 
           </span>
          </td>
        </tr> 
         <tr>
            <td class="bg-gray right " width="15%"><span class="light"></span>是否有效</td>
            <td width="40%">
                <div class="ipt-box col-12"> 
                      ${licDeptList[0].isValid=='1'?'有效':'无效'}   
                </div>
            </td>
            <td class="bg-gray right" width="15%"><span class="light"></span> </td>
            <td><div class="ipt-box col-12"> 
                    
                </div>
	       </td>
	     </tr> 
         </tbody>
    </table> 
    <p class="center"><input type="button" id="cancellicdept" class="btn" value="关闭"></p>
</div>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/syn/system/licdzdept/licdzdept_view_main.js"/>"></script> 
 <script>
   window._CONFIG = {
       _licDeptType:'${licDeptList[0].licDeptType}',
       _isValid:'${licDeptList[0].isValid}',
    }
</script>
</body>
</html>