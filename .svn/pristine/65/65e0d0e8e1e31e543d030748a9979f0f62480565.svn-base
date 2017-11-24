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
        <form class="form-horizontal" id="punishform">
            <input type="hidden" id="id" name="id" value="${pubOtherpunish.id}">
            <input type="hidden" id="priPID" name="priPID" value="${pubOtherLicence.priPID}">
            <input type="hidden" id="licID" name="licID" value="${pubOtherLicence.licID}">
            <input type="hidden" name="setDeptname" value="${pubOtherLicence.setDeptname}">
               <input type="hidden" id="userType" value="${userType }"> 

            <table class="table-horizontal" width="100%">
                <tr>
                    <td width="15%" class="bg-gray right">注册号:</td>
                    <td width="33%">
                        <div class="ipt-box col-12">
                            <input type="text" name="regNO" value="${pubOtherLicence.regNO}" readonly="readonly"
                                   class="ipt-txt" >
                        </div>

                    </td>
                    <td width="15%" class="bg-gray right">企业名称:</td>
                    <td width="37%">
                        <div class="ipt-box col-12">
                            <input type="text" name="entName" value="${pubOtherLicence.entName}" readonly="readonly"
                                   class="ipt-txt" >
                        </div>
                    </td>
                </tr>
                <tr>
                    <td width="15%" class="bg-gray right">许可文件编号:</td>
                    <td width="33%">
                        <div class="ipt-box col-12">
                            <input type="text" name="licNO" value="${pubOtherLicence.licNO}" required class="ipt-txt" >
                        </div>
                    </td>
                    <td width="15%" class="bg-gray right">许可文件名称:</td>
                    <td width="37%">
                        <div class="ipt-box col-12">
                            <input type="text" name="licNameCN" value="${pubOtherLicence.licNameCN}" required class="ipt-txt">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td width="15%" class="bg-gray right">有效起止日期:</td>
                    <td width="33%">
                        <div class="ipt-box col-575">
                            <input id="licValFrom" type="text" class="ipt-txt laydate-icon"  readonly="readonly"
                                   name="licValFrom"
                                   value="<fmt:formatDate value="${pubOtherLicence.licValFrom}" pattern="yyyy-MM-dd" />"
                                   required/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input id="licValTo" type="text" class="ipt-txt laydate-icon"  readonly="readonly"
                                   name="licValTo"
                                   value="<fmt:formatDate value="${pubOtherLicence.licValTo}" pattern="yyyy-MM-dd" />"
                                   required/>
                        </div>
                        <label><input id="longLic" type="checkbox"/>长期有效</label>
                    </td>
                    <td width="15%" class="bg-gray right">许可机关:</td>
                    <td width="37%">
                        <div class="ipt-box col-12">
                        <input type="text" name="licAnth" class="ipt-txt" value="${pubOtherLicence.licAnth}" />
                            </div>
                    </td>
                </tr>

                <tr>
                    <td width="18%" class="bg-gray right">许可内容(限制500字)</td>
                    <td colspan="3">
                        <div class="ipt-box col-12">
                        <textarea cols="" id="licScope" rows="5" maxlength="500"  name="licScope"
                                  required >${pubOtherLicence.licScope}</textarea>
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
<script src="/js/reg/server/other/otherlicence/otherlicenceinput_edit_main.js"></script>
</body>
</html>