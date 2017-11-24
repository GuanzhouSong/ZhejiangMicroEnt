<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<style type="text/css">
    .ftd {
        font-weight: bold;
        text-align: right;
    }
</style>
<body class="pd10">
    <div>
        <form class="form-horizontal" id="supportform">
            <input type="hidden" id="uid" name="UID" value="${pubSamllSupport.UID}"> 
            <input type="hidden" name="deptID" id="deptID" value="${pubOtherLicence.deptID}">
               <input type="hidden" id="userType" value="${userType }"> 
                <input type="hidden" name="priPID" id="priPID" value="${midBase.priPID}">    
            <table class="table-horizontal" width="100%">
                <tr>
                    <td width="15%" class="bg-gray right">注册号:</td>
                    <td width="35%">
                        <div class="ipt-box col-12">
                            <input type="text" name="regNO" value="${midBase.regNO}" readonly 
                                   class="ipt-txt">
                        </div>

                    </td>
                    <td width="20%" class="bg-gray right">企业名称:</td>
                    <td width="30%">
                        <div class="ipt-box col-12">
                            <input type="text" name="entName"  value="${midBase.entName}" readonly 
                                   class="ipt-txt">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td width="20%" class="bg-gray right">扶持日期:</td>
                    <td width="35%">
                        <div class="ipt-box col-12">
                            <input type="text" name="helpDate" disabled readonly onclick="laydate()" value="<fmt:formatDate value="${pubSamllSupport.helpDate}" pattern="yyyy-MM-dd" />" required class="ipt-txt">
                        </div>
                    </td>
                    <td width="15%" class="bg-gray right">反馈日期:</td>
                    <td width="30%">
                        <div class="ipt-box col-12">
                            <input type="text" name="feedBackTime" disabled readonly onclick="laydate()" value="<fmt:formatDate value="${pubSamllSupport.feedBackTime}" pattern="yyyy-MM-dd" />" required
                                   class="ipt-txt">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td width="20%" class="bg-gray right">扶持金额:</td>
                    <td width="35%">
                        <div class="ipt-box col-12">
                            <input type="text" min="0" class="ipt-txt"  
                                   name="supportAm" readonly value="${pubSamllSupport.supportAm}"
                                   required/>
                        </div>
                         
                        </div>
                    </td>
                    <td width="15%" class="bg-gray right">扶持部门:</td>
                    <td width="30%">
                        <div class="ipt-box col-12">
                        <input type="text" name="deptName" id="deptName" readonly class="ipt-txt" value="${pubSamllSupport.deptName}" required>
                             
                            </div>
                    </td>
                </tr>

                <tr>
                    <td width="20%" class="bg-gray right">扶持内容(限制500字)</td>
                    <td colspan="3">
                        <div class="ipt-box col-12">
                        <textarea cols="" id="helpContent" readonly rows="9" maxlength="500" class="required"  name="helpContent"
                                  >${pubSamllSupport.helpContent}</textarea>
                        </div>
                    </td>
                </tr>
                <tr  style="display:none;">
                    <td width="20%" class="bg-gray right">错误代码(限制500字)</td>
                    <td colspan="3">
                        <div class="ipt-box col-12">
                        <textarea cols="" id="helpContent" readonly rows="5" maxlength="500"  name="errorCode"
                                  required>${pubSamllSupport.errorCode}</textarea>
                        </div>
                    </td>
                </tr> 


                
                 <tr>
                    <td width="20%" class="bg-gray right">录入人:</td>
                    <td width="35%">
                      <div class="ipt-box col-12">
                     <input type="text"  class="ipt-txt" name="setName" value="${pubSamllSupport.setName}" readonly="readonly">
                     </div>
                    </td>
                    <td width="15%" class="bg-gray right">录入日期:</td>
                    <td width="30%">
                    <div class="ipt-box col-12">
                    <input type="text" name="setDate"  disabled class="ipt-txt" value="<fmt:formatDate value="${pubSamllSupport.setDate}" pattern="yyyy-MM-dd" />" readonly="readonly">
                    </div>
                    </td>
                 </tr>
                  <tr>
                    <td width="20%" class="bg-gray right">审核人:</td>
                    <td width="35%">
                      <div class="ipt-box col-12">
                     <input type="text" name="auditName" class="ipt-txt"  value="${pubSamllSupport.auditName}" readonly="readonly">
                     </div>
                    </td>
                    <td width="15%" class="bg-gray right">审核日期:</td>
                    <td width="30%">
                     <div class="ipt-box col-12">
                    <input type="text" name="auditDate" disabled class="ipt-txt" value="<fmt:formatDate value="${pubSamllSupport.auditDate}" pattern="yyyy-MM-dd" />" readonly="readonly">
                     </div>
                    </td>
                 </tr>
                  <tr>
                    <td width="20%" class="bg-gray right">审核结果:</td>
                    <td width="35%">
                      
                     <label><input type="radio" id="checksuc"  disabled name="auditState" required value="1" ${pubSamllSupport.auditState =='1'?'checked':''}>通过</label>&nbsp;&nbsp;
                     <label><input type="radio" id="checkfal" disabled name="auditState" required value="2" ${pubSamllSupport.auditState =='2'?'checked':''}>不通过</label>
                    </td>
                    <td width="15%" class="bg-gray right">审核意见:</td>
                    <td width="30%">
                       <div class="ipt-box col-12">
                    <input type="text" id="auditOpin" class="ipt-txt required" name="auditOpin" value="${pubSamllSupport.auditOpin}" readonly="readonly">
                     </div>
                    </td>
                 </tr>
                 

            </table>
            <div class="center mt10"> 
                <button id="cancel" type="button" class="btn">关闭</button>
            </div>
        </form>
    </div>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/other/smallsupport/smallsupport_audit_main.js"></script>
</body>
</html>