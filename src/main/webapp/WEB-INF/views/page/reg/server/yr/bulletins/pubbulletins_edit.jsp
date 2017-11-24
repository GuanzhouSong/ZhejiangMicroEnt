<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
</head>
<body class="pd10">
    <form class="form-horizontal" id="form">
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
		<input type="hidden" name="UID" value="${Bulletins.UID}">
        <input type="hidden" name="setId"  value="${sysUser.id}" >
        <input type="hidden" name="bulType" id="bulType" value="1" >
        <input type="hidden" name="setDeptname"  value="${userType == 2 ? sysUser.sysDepart.orgName : sysUser.departMent.deptName}" >                               
        <input type="hidden" name="setDeptCode" id="setDeptCode" value="${userType == 2 ? sysUser.sysDepart.adcode : sysUser.deptCode}" >
        <input type="hidden" name="systemType"  value="${sysUser.userType}" >                               
        <input type="hidden" name="setName"  value="${sysUser.realName}" > 
        <input type="hidden" name="setTime"  value="<fmt:formatDate value="${empty Bulletins.setTime ? nowdate : Bulletins.setTime }" pattern="yyyy-MM-dd HH:mm:ss"/>" >
        <tr>
            <td class="bg-gray right" width="15%"><span class="light">*</span>标题</td>
            <td colspan="3">
                <div class="ipt-box col-12">
                 <input name="title" id="title" placeholder="请输入标题"  class="ipt-txt" value="${Bulletins.title}" >                
                </div>
            </td>
        </tr>
        <tr>
            <td class="bg-gray right"><span class="light">*</span>公告类型</td>
            <td>
                <div class="ipt-box col-12">
                     <select name="bulScope" id="bulScope">
                         <c:if test="${flag == 'insert'}">
                            <option value="" selected>请选择</option>                         
                         </c:if>                         
                         <option value="4" <c:if test="${Bulletins.bulScope == '4'}">selected</c:if> >拟吊销营业执照听证公告</option>
                         <option value="5" <c:if test="${Bulletins.bulScope == '5'}">selected</c:if> >吊销营业执照公告</option>
                         <option value="6" <c:if test="${Bulletins.bulScope == '6'}">selected</c:if> >企业登记机关注销公告</option>
                         <option value="7" <c:if test="${Bulletins.bulScope == '7'}">selected</c:if> >年度抽查工作计划公告</option>
                     </select>
                </div>
            </td>
            <td class="bg-gray right">公示日期 </td>
            <td><fmt:formatDate value="${empty Bulletins.setTime ? nowdate : Bulletins.setTime}" pattern="yyyy年MM月d日"/>
			</td>
        </tr>
        <tr>
            <td class="bg-gray right">发布部门</td>
            <td>
             ${userType == 2 ? sysUser.sysDepart.orgName : sysUser.departMent.deptName}
            </td>
            <td class="bg-gray right">发布人 </td>
            <td><div id="setName">${sysUser.realName}</div>
			</td>
        </tr>
        <c:if test="${flag == 'update'}">
         <tr>
            <td class="bg-gray right"><span class="light">*</span>状态</td>
            <td>
                <div class="radio-box pd0"> 
                     <label class="font-12"><input type="radio" value="1" name="isValid" checked >有效</label>
                     <label class="font-12"><input type="radio" value="0" name="isValid" >无效</label>
                </div>
            </td>
            <td class="bg-gray right"><span class="light">*</span>修改日期 </td>
            <td><fmt:formatDate value="${nowdate}" pattern="yyyy年MM月d日"/>
			</td>
          </tr>
          </c:if>
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
		                  &nbsp;&nbsp;<a href="javascript:void(0)"
		                                 path="${obj}">删除</a></p>
		          </c:forEach>
		        </div>
		        <p class="pd2 file-upload" id="fileList" style="padding:4px;">
	               <span id="fileBox">
	                 <input type="file" id="btnFile" class="btnFil" name="btnFile" style="width:450px;border: 1px solid #ccc;"/>
	               </span>
	              <input type="hidden" id="evidenceData" name="bulData" value="${Bulletins.bulData}"/>
		          <input type="hidden" id="file" value=""/>
		          <iframe width="0" height="0" name="uploadframe"></iframe>
		          <input type="button" id="btnUpload" value="点击上传"/>
		          <span id="uploadState" style="color:red;display:none">上传中....</span>
		         </p>
		        <span class="light" style="padding:2px;">说明：上传附件资料支持图片JPG格式进行上传，上传的单个文件不超过20M。</span>
		    </td>
		</tr>
	</table>
	</form>
	    <p class="center mt10"><input type="button" class="btn mr20" value="提交内容" id="submit" />
	    <input type="button" class="btn" value="取 消" id="cancel"/></p>
<script>
    window._CONFIG = {
       chooseUrl:'${userType == 2 ? "/syn" : "/reg/server"}',
       flag:2,
       czflag:'${flag}'
    }
</script>
<script charset="utf-8" src="/js/lib/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="/js/lib/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="/js/lib/kindeditor/plugins/code/prettify.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/yr/bulletins/list_edit.js"></script>	
</body>
</html>

