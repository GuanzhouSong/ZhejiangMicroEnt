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
               <input type="hidden" id="dutyDeptCodes" value="${dutyDeptCodes }">
                <input type="hidden" name="priPID" id="priPID" value="${midBase.priPID}">    
            <table class="table-horizontal" width="100%">
                <tr>
                    <td width="15%" class="bg-gray right">注册号:</td>
                    <td width="35%">
                        <div class="ipt-box col-12">
                            <input type="text" name="regNO" value="${midBase.regNO}" readonly="readonly"
                                   class="ipt-txt" placeholder="请输入注册号">
                        </div>

                    </td>
                    <td width="20%" class="bg-gray right">企业名称:</td>
                    <td width="30%">
                        <div class="ipt-box col-12">
                            <input type="text" name="entName" value="${midBase.entName}" readonly="readonly"
                                   class="ipt-txt" placeholder="请输入企业名称">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td width="20%" class="bg-gray right">扶持日期:</td>
                    <td width="35%">
                        <div class="ipt-box col-12">
                            <input type="text" name="helpDate" readonly onclick="laydate()" value="<fmt:formatDate value="${pubSamllSupport.helpDate}" pattern="yyyy-MM-dd" />" required class="ipt-txt" placeholder="请选择扶持日期">
                        </div>
                    </td>
                    <td width="15%" class="bg-gray right">反馈日期:</td>
                    <td width="30%">
                        <div class="ipt-box col-12">
                            <input type="text" name="feedBackTime" readonly onclick="laydate()" value="<fmt:formatDate value="${pubSamllSupport.feedBackTime}" pattern="yyyy-MM-dd" />" required
                                   class="ipt-txt" placeholder="请选择反馈日期">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td width="20%" class="bg-gray right">扶持金额（元） :</td>
                    <td width="35%">
                        <div class="ipt-box col-12" style="float:left;">
                            <input type="text" min="0" class="ipt-txt"  
                                   name="supportAm" value="${pubSamllSupport.supportAm}"
                                   required placeholder="请输入扶持金额"/> 
                        </div>
                         
                        </div>
                    </td>
                   <%--  <td width="15%" class="bg-gray right">扶持部门:</td>
                    <td width="30%">
                        <div class="ipt-box col-12">
                        <input type="text" name="deptName" id="deptName" readonly class="ipt-txt" value="${pubSamllSupport.deptName}" required>
                             <span class="add-icon" id="selectDept">
                                <i></i>
                         </span>
                            </div> --%>
                    </td>
                </tr>

                <tr>
                    <td width="20%" class="bg-gray right">扶持内容(限制500字)</td>
                    <td colspan="3">
                        <div class="ipt-box col-12">
                        <textarea cols="" id="helpContent" rows="9" maxlength="500" class="required"  name="helpContent"
                                 placeholder="请输入扶持内容" >${pubSamllSupport.helpContent}</textarea>
                        </div>
                    </td>
                </tr>
                <tr style="display:none;">
                    <td width="20%" class="bg-gray right">错误代码(限制500字)</td>
                    <td colspan="3">
                        <div class="ipt-box col-12">
                        <textarea cols="" id="helpContent" rows="5" maxlength="500"  name="errorCode"
                                   >${pubSamllSupport.errorCode}</textarea>
                        </div>
                    </td>
                </tr>
                


                <%-- <c:if test="${pubOtherpunish.auditState =='2'}">
                 <tr>
                    <td width="20%" class="bg-gray right">录入人:</td>
                    <td width="35%">
                     <input type="text" name="setName" value="${pubOtherpunish.setName}" readonly="readonly">
                    </td>
                    <td width="15%" class="bg-gray right">录入日期:</td>
                    <td width="30%">
                    <input type="text" name="setDate" value="<fmt:formatDate value="${pubOtherpunish.setDate}" pattern="yyyy-MM-dd" />" readonly="readonly">
                    </td>
                 </tr>
                  <tr>
                    <td width="20%" class="bg-gray right">审核人:</td>
                    <td width="35%">
                     <input type="text" name="auditName" value="${pubOtherpunish.auditName}" readonly="readonly">
                    </td>
                    <td width="15%" class="bg-gray right">审核日期:</td>
                    <td width="30%">
                    <input type="text" name="auditDate" value="<fmt:formatDate value="${pubOtherpunish.auditDate}" pattern="yyyy-MM-dd" />" readonly="readonly">
                    </td>
                 </tr>
                  <tr>
                    <td width="20%" class="bg-gray right">审核结果:</td>
                    <td width="35%">
                      <c:if test="">

                      </c:if>
                     <label><input type="radio" id="checksuc" name="auditState" value="1" ${pubOtherpunish.auditState =='1'?'checked':''}>通过</label>&nbsp;&nbsp;
                     <label><input type="radio" id="checkfal" name="auditState" value="2" ${pubOtherpunish.auditState =='2'?'checked':''}>不通过</label>
                    </td>
                    <td width="15%" class="bg-gray right">审核意见:</td>
                    <td width="30%">
                    <input type="text" id="auditOpin" name="auditOpin" value="${pubOtherpunish.auditOpin}" readonly="readonly">
                    </td>
                 </tr>
                 </c:if> --%>

            </table>
            <div class="center mt10">
                <button id="save" type="submit" class="btn mr20">保存</button>
                <button id="cancel" type="button" class="btn">关闭</button>
            </div>
        </form>
    </div>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/other/smallsupport/smallsupport_edit.js"></script>
</body>
</html>