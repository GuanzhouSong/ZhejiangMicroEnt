<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:useBean id="nowdate" class="java.util.Date" />
<!doctype html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
	<title>规上企业修改</title>
	<link rel="stylesheet" href="/css/sment/sment.server.css">
</head>
<body class="pd10">
    <form class="form-horizontal" id="form">
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
		<input type="hidden" name="UID" value="${smEntAbovescale.UID}">
        <input type="hidden" name="id"  value="${smEntAbovescale.id}" >                     
        <input type="hidden" name="year"  value="${smEntAbovescale.year}" >                                        
        <input type="hidden" name="imBatchNum"  value="${smEntAbovescale.imBatchNum}" >                                        
        <input type="hidden" name="importName"  value="${sysUser.realName}">                                                                     
        <tr>
            <td class="bg-gray right" width="15%"><font class="light">*</font>企业名称(源)</td>
            <td colspan="3">
                <div class="ipt-box col-12">
                 <input name="entName" id="entName"  class="ipt-txt" value="${smEntAbovescale.entName}" >                
                </div>
            </td>
        </tr>
        <tr>
            <td class="bg-gray right">统一社会信用代码（源）</td>
            <td width="35%">
                <div class="ipt-box">
                 <input name="uniCode" id="uniCode" class="ipt-txt" value="${smEntAbovescale.uniCode}" >                
                </div>
            </td>
            <td class="bg-gray right" width="15%" id="isValid">组织机构代码 </td>
            <td>
                <div class="ipt-box">
                 <input name="organizecode" id="organizecode"  class="ipt-txt" value="${smEntAbovescale.organizecode}" >                
                </div>
            </td>
        </tr>
        <tr>
            <td class="bg-gray right">报表类别编码</td>
            <td width="35%">
                <div class="ipt-box">
                 <input name="formType" is="formType" class="ipt-txt" value="${smEntAbovescale.formType}" >                
                </div>
            </td>
            <td class="bg-gray right" width="15%" id="isValid">报表类别中文 </td>
            <td>
                <div class="ipt-box">
                 <input name="formTypeCn" id="formTypeCn" class="ipt-txt" value="${smEntAbovescale.formTypeCn}" >                
                </div>
            </td>
        </tr>
        <tr>
            <td class="bg-gray right">导入人</td>
            <td><div id="importName">${sysUser.realName}</div>
            </td>
            <td class="bg-gray right">导入时间 </td>
            <td><div id="importTime"><fmt:formatDate value="${nowdate}" type="date" pattern="yyyy-MM-dd"/></div>
			</td>
        </tr>
	</table>
	</form>
	  <p class="center mt10"><input type="button" class="btn mr20" value="提交" id="submit" />
	  <input type="button" class="btn" value="取 消" id="cancel"/></p>
<script>
    window._CONFIG = {
       flag:2
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/sment/smentabovescale/smentabovescale_edit.js"></script>	
</body>
</html>

