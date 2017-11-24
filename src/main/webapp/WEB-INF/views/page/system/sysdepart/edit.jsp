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

    <title>全省部门维护</title>
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body>
<form id="sysDepartForm">
    <div class="pd20 clearfix">
        <h3 class="h3-title center"></h3>
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10">
            <input type="hidden" name="id" id="deptUId" value="${sysDepart.id}">
            <input type="hidden" name="porgCoding" id="porgCoding" value="${sysDepart.porgCoding}">
            <tr>
                <td class="bg-gray right" width="25%"><span class="light"> *</span>上级部门：</td>
                <td>
                    <div class="ipt-box pd0">
                        <c:choose>
                            <c:when test="${empty sysDepart}">
                                <%--<input type="radio" id="sibling" name="porgCoding" checked="checked" value="${parentIdForSibling}">添加同级部门--%>
                                <input type="radio" id="sub" checked name="porgCoding" value="${parentIdForSub}">添加子部门
                            </c:when>
                            <c:otherwise>
                                ${empty parentName?"没有了":parentName}
                            </c:otherwise>
                        </c:choose>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right" width="25%"><span class="light"> *</span>部门编码：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" name="orgCoding" id="orgCoding" class="ipt-txt"  readonly
                               value="${sysDepart.orgCoding==null?nextOrgCode:sysDepart.orgCoding}">
                    </div>
                </td>
            </tr>

            <tr>
                <td class="bg-gray right" width="25%"><span class="light"> *</span>部门名称(简称)：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" name="orgName" class="ipt-txt"
                               value="${sysDepart.orgName}">
                    </div>
                </td>
            </tr>

            <tr>
                <td class="bg-gray right" width="25%"><span class="light"> *</span>部门名称(全称)：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" name="organizeAllName" class="ipt-txt"
                               value="${sysDepart.organizeAllName}">
                    </div>
                </td>
            </tr>

            <tr>
                <td class="bg-gray right" width="25%"><span class="light"> *</span>职能部门：</td>
                <td >
                    <div class="ipt-box pd0">
                        <input type="hidden" id="dutyNamesHidden" name="dutyNames"
                               value="${sysDepart.dutyNames}">
                        <input type="text" id="dutyNames" class="ipt-txt"  readonly
                               value="${sysDepart.dutyNames}">
                        <input type="hidden" name="dutyCodes" id="dutyCodes" value="${sysDepart.dutyCodes}"/>
                         <span class="add-icon" id="selectDutyCode">
                            <i></i>
                         </span>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right" width="25%"><span class="light"> *</span>行政编码：</td>
                <td >
                    <div class="ipt-box pd0">
                        <input type="text" name="adcode" class="ipt-txt"
                               value="${sysDepart==null?nextAdCode:sysDepart.adcode}" >
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right" width="25%"><span class="light"> *</span>部门联络员：</td>
                <td >
                    <div class="ipt-box pd0">
                        <input type="text" name="liaName" class="ipt-txt"
                               value="${sysDepart.liaName}" >
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right" width="25%"><span class="light"> *</span>联络员电话号码：</td>
                <td >
                    <div class="ipt-box pd0">
                        <input type="text" name="liaPhone" class="ipt-txt"
                               value="${sysDepart.liaPhone}" >
                    </div>
                </td>
            </tr>
        </table>

        <p class="center mt10">
            <input type="button" id="save" class="btn mr20" value="保 存"/>
            <input type="button" class="btn" value="取 消" id="cancel"/></p>
    </div>
</form>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/business/sysdepart/edit_main.js"></script>
<script>
    window._CONFIG = {
        select_dept_url:'<c:url value="/common/system/code_duty_dept/duty_dept_select"/>'
    }
</script>
</body>
</html>
