<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body>
<form id="caseSourceform">
    <input type="hidden" id="" name="uid" value="${caseSourceInfo.uid}"/>
    <input type="hidden" id="" name="priPID" value="${baseInfo.priPID}"/>
    <input type="hidden" id="" name="regNO" value="${baseInfo.regNO}"/>
    <input type="hidden" id="" name="uniCode" value="${baseInfo.uniCode}"/>
    <input type="hidden" id="pageflag" value="${pageflag}"/>
    <div class="pd20 clearfix">
        <h3 class="h3-title center"></h3>
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10 f12">
            <tr>
                <td class="bg-gray right" width="30%">统一社会信用代码/注册号：</td>
                <td width="70%">
                    <div class="ipt-box pd0">
                        <input type="text" id="uniCodeOrReg"  value="${empty baseInfo.uniCode?baseInfo.regNO:baseInfo.uniCode}" class="ipt-txt" readonly="readonly"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right" width="30%">企业名称：</td>
                <td width="70%">
                    <div class="ipt-box pd0">
                        <input type="text" id="entName" name="entName"  value="${baseInfo.entName}" class="ipt-txt" readonly="readonly"/>
                    </div>
                </td>
            </tr>
             <tr>
                <td class="bg-gray right" width="30%"><span class="light">*</span>案源名称：</td>
                <td width="70%">
                    <div class="ipt-box pd0">
                        <input type="text" id="caseName" name="caseName"  value="${caseSourceInfo.caseName}" class="ipt-txt" required="required"/>
                    </div>
                </td>
            </tr>
             <tr>
                <td class="bg-gray right" width="30%"><span class="light">*</span>举报人姓名：</td>
                <td width="70%">
                    <div class="ipt-box pd0">
                        <input type="text" id="reporterName" name="reporterName"  value="${caseSourceInfo.reporterName}" class="ipt-txt" required="required"/>
                    </div>
                </td>
            </tr>
             <tr>
                <td class="bg-gray right" width="30%"><span class="light">*</span>举报人联系电话：</td>
                <td width="70%">
                    <div class="ipt-box pd0">
                        <input type="text" id="reporterTel" name="reporterTel"  value="${caseSourceInfo.reporterTel}" class="ipt-txt telandphone" required="required"/>
                    </div>
                </td>
            </tr>
             <tr>
                <td class="bg-gray right" width="30%"><span class="light">*</span>举报人证件号码：</td>
                <td width="70%">
                    <div class="ipt-box pd0">
                        <input type="text" id="reporterCard" name="reporterCard"  value="${caseSourceInfo.reporterCard}" class="ipt-txt idCard" required="required"/>
                    </div>
                </td>
            </tr>
            
            <tr>
                <td class="bg-gray right" width="30%"><span class="light">*</span>举报时间：</td>
                <td width="70%">
                    <div class="ipt-box pd0">
                        <input type="text" id="reportTime" name="reportTime" onclick="laydate()" readonly="readonly" style="width: 150px;cursor: pointer;"
                        value="<fmt:formatDate value="${caseSourceInfo.reportTime}" pattern="yyyy-MM-dd" />" class="ipt-txt" required="required"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right" width="30%"><span class="light">*</span>举报内容：</td>
                <td width="70%">
                    <div class="ipt-box pd0">
                        <textarea style="height: 100px" rows="10" id="reportContent" name="reportContent" class="ipt-txt" required="required">${caseSourceInfo.reportContent}</textarea>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right" width="30%">备注：</td>
                <td width="70%">
                    <div class="ipt-box pd0">
                        <textarea style="height: 50px" rows="10" id="remark" name="remark" class="ipt-txt">${caseSourceInfo.remark}</textarea>
                    </div>
                </td>
            </tr>
             <tr>
                <td class="bg-gray right" width="30%"><span class="light">*</span>受理意见：</td>
                <td width="70%">
                    <div class="ipt-box pd0">
                        <textarea style="height: 100px" rows="10" id="setOpinion" name="setOpinion" class="ipt-txt" required="required">${caseSourceInfo.setOpinion}</textarea>
                    </div>
                </td>
            </tr>
        </table>
        <c:if test="${empty pageflag}">
	        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10 f12">
	           <tr>
	             <td class="bg-gray right">受理人：</td>
	             <td>
	                    <div class="ipt-box pd0">
	                        <input type="text" id="setName" name="setName"  value="${sessionScope.session_sys_user.realName}" class="ipt-txt" readonly="readonly"/>
	                    </div>
	             </td>
	             <td class="bg-gray right">受理日期：</td>
	             <td>
	                    <div class="ipt-box pd0">
	                        <input type="text" id="setTime" name="setTime" value="<fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd" />" class="ipt-txt" readonly="readonly"/>
	                    </div>
	             </td>
	             <td class="bg-gray right">受理部门：</td>
	             <td>
	                    <div class="ipt-box pd0">
	                        <input type="hidden" id="setDeptCode" name="setDeptCode"  value="${sessionScope.session_sys_user.departMent.deptCode}" class="ipt-txt" readonly="readonly"/>
	                        <input type="text" id="setDeptName" name="setDeptName"  value="${sessionScope.session_sys_user.departMent.deptName}" class="ipt-txt" readonly="readonly"/>
	                    </div>
	             </td>
	           </tr>
	        </table>
        </c:if>
        <c:if test="${!empty pageflag}">
           <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10 f12">
	           <tr>
	             <td class="bg-gray right">受理人：</td>
	             <td>
	                    <div class="ipt-box pd0">
	                        <input type="text" id="setName"   value="${caseSourceInfo.setName}" class="ipt-txt" readonly="readonly"/>
	                    </div>
	             </td>
	             <td class="bg-gray right">受理日期：</td>
	             <td>
	                    <div class="ipt-box pd0">
	                        <input type="text" id="setTime"  value="<fmt:formatDate value="${caseSourceInfo.setTime}" pattern="yyyy-MM-dd" />" class="ipt-txt" readonly="readonly"/>
	                    </div>
	             </td>
	             <td class="bg-gray right">受理部门：</td>
	             <td>
	                    <div class="ipt-box pd0">
	                        <input type="text" id="setDeptName" value="${caseSourceInfo.setDeptName}" class="ipt-txt" readonly="readonly"/>
	                    </div>
	             </td>
	           </tr>
	        </table>
        </c:if>
          <p class="center mt10">
          	 <c:if test="${pageflag!= 3}">
	        	<input type="submit" id="save" class="btn mr20" value="保 存"/>
	       	 </c:if>
	       	  <button id="cancel" type="button" class="btn">关闭</button>
	     </p>
    </div>
</form>
<script>
window._CONFIG = {
   chooseUrl:'${sysUser.userType == 2 ? "/syn" : "/reg"}', 
}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/casesource/casesource_edit.js"></script>
</body>
</html>