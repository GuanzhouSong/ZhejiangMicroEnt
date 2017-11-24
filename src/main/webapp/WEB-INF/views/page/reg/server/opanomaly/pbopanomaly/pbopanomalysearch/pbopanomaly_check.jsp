<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean id="nowdate" class="java.util.Date"/>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>标记异常状态审核</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<style>
    #unusualCatalog {
        padding: 0px;
        margin: 0px;
        overflow-x: hidden;
        overflow-y: auto;
        height: 100px;
    }

    .warn {
        background: #F00 !important;
        color: #FFF !important
    }

    #form select, #form textarea {
        background: #F4F8F9;
    }
</style>
<body class="pd10">
<div class="main">
    <h1 id="title"></h1>
    <form id="pubauditosaveform">
        <div class="listBox2 thBg">
            <input type="hidden" name="busExcList" id="busExcList" value="${pubPbopanomalyDto.busExcList}">
            <div class="leftTop"></div>
            <div class="right1Top"></div>
            <table class="table-horizontal">
                <tr id="appBasic">
                        <td class="bg-gray right"><div class="ipt-box">企业名称 </div></td>
                        <td><div class="ipt-box">${pubPbopanomalyDto.entName}</div></td>
	                    <td class="bg-gray right"><div class="ipt-box">注册号</div></td>
	                    <td><div class="ipt-box">${pubPbopanomalyDto.regNO}</div></td>
	                    <td class="bg-gray right"><div class="ipt-box">经营者</div></td>
	                    <td><div class="ipt-box">${pubPbopanomalyDto.leRep}</div></td>
	                </tr>
	                <tr id="appBasic">
                        <td class="bg-gray right"><div class="ipt-box">登记机关</div></td>
                        <td><div class="ipt-box">${pubPbopanomalyDto.regOrgName}</div></td>
	                    <td class="bg-gray right"><div class="ipt-box">成立日期</div></td>
	                    <td><div class="ipt-box"><fmt:formatDate value="${pubPbopanomalyDto.estDate}" pattern="yyyy-MM-dd"/></div></td>
	                    <td class="bg-gray right"><div class="ipt-box">管辖单位</div></td>
                        <td colspan="5"><div class="ipt-box">${pubPbopanomalyDto.localAdmName}</div></td>
	                </tr>
            </table>
        </div>
        <br/>
        <div class="listBox2 thBg">
            <div class="leftTop"></div>
            <div class="right1Top"></div>
            <table class="table-horizontal">
                <tr>
                    <td class="bg-gray right" valign="middle" class="lb_1">
                        <div class="ipt-box">列入原因</div>
                    </td>
                    <td colspan="5">
                        <div class="ipt-box">${pubPbopanomalyDto.excpStaResCN}</div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" valign="middle" class="lb_1">
                        <div class="ipt-box">列入事实和事由</div>
                    </td>
                    <td colspan="5">
                        <div class="ipt-box">${pubPbopanomalyDto.signRea}</div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" valign="middle" class="lb_1">
                        <div class="ipt-box">决定机关</div>
                    </td>
                    <td colspan="5">
                        <div class="ipt-box">${pubPbopanomalyDto.decorgCN}</div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" valign="middle" class="lb_1">
                        <div class="ipt-box">初审意见</div>
                    </td>
                    <td colspan="5">
                        <div class="ipt-box"><textarea id="firstOpin" name="firstOpin" class="txt_1"
                                                       disabled="disabled">${pubPbopanomalyDto.firstOpin}</textarea></div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" valign="middle" class="lb_1">
                        <div class="ipt-box"><font color="red">* </font>作出决定日期</div>
                    </td>
                    <td width="180">
                        <div class="ipt-box">
                        	<input type="text" class="ipt-txt laydate-icon" style="cursor: pointer;" onclick="laydate()"
                                   readonly="readonly" id="cogDate" name="cogDate" value="<fmt:formatDate value="${pubPbopanomalyDto.cogDate}" pattern="yyyy-MM-dd"/>"/>
                         </div>
                    </td>
                    <td colspan="2">
                        <div class="tdBox light">该日期为公示的决定日期。</div>
                    </td>
                    <td class="bg-gray right" valign="middle" class="lb_1">
                        <div class="ipt-box">决定机关</div>
                    </td>
                    <td>
                        <div class="ipt-box">${pubPbopanomalyDto.decorgCN}</div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" width="100" valign="middle" class="lb_1">
                        <div class="ipt-box">初审日期</div>
                    </td>
                    <td width="180">
                        <div class="ipt-box"><fmt:formatDate value="${pubPbopanomalyDto.firstDate}"
                                                             pattern="yyyy-MM-dd"/></div>
                    </td>
                    <td class="bg-gray right" width="120" valign="middle" class="lb_1">
                        <div class="ipt-box">初审人</div>
                    </td>
                    <td width="170">
                        <div class="ipt-box">${pubPbopanomalyDto.firstName}</div>
                    </td>
                    <td class="bg-gray right" width="130" valign="middle" class="lb_1">
                        <div class="ipt-box">初审部门</div>
                    </td>
                    <td width="250">
                        <div class="ipt-box">${pubPbopanomalyDto.firstDept}</div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" valign="middle" class="lb_1">
                        <font color="red">* </font>审核意见
                    </td>
                    <td colspan="5">
                        <div class="radio-box" id="unusualRadio">
                            <label class="font-12"><input type="radio" class="view-opadetail" name="auditState" id="yes" value="1"
                                        checked />予以标记异常</label>
                            <label class="font-12"><input type="radio" class="view-opadetail" name="auditState" id="no" value="2"
                                         />不予标记异常</label>
                        </div>
                        <div class="ipt-box">
                            <textarea id="auditOpin" name="auditOpin" maxlength="500"
                                  class="txt_1 view-opadetail">予以标记异常</textarea>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td class="bg-gray right" width="100" valign="middle" class="lb_1">
                        <div class="ipt-box"><font color="red">* </font>审核日期</div>
                    </td>
                    <td width="180">
                        <div class="ipt-box" >
                        	<input type="text" readonly="readonly" name="auditDate" value='<fmt:formatDate value="<%=new Date() %>" pattern="yyyy-MM-dd"/>'>
                        </div>
                    </td>
                    <td class="bg-gray right" width="120" valign="middle" class="lb_1">
                        <div class="ipt-box"><font color="red">* </font>审核人</div>
                    </td>
                    <td width="170">
                        <div class="ipt-box">
                        	<input type="text" readonly="readonly" id="auditName" name="auditName" value="${sysUser.realName}">
                        </div>
                    </td>
                    <td class="bg-gray right" width="130" valign="middle" class="lb_1">
                        <div class="ipt-box"><font color="red">* </font>审核部门</div>
                    </td>
                    <td width="250">
                        <div class="ipt-box">
                        	<input type="text" id="auditDept" readonly="readonly" name="auditDept" value="${sysUser.departMent.deptName}">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td colspan="6">
                        <div class="ipt-box"><font class="light">注：审核通过的日期即为该决定信息对外公示的公示日期。</font></div>
                    </td>
                </tr>
            </table>
        </div>
        </form>
        <div class="center mt10 mb10">
            <input type="button" class="btn btn-info" id="save" value="保存"/>
            <input type="button" class="btn " id="cancel" value="取消"/>
        </div>
</div>
</body>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="<c:url value='/js/reg/server/opanomaly/pbopanomaly/pbopanomaly_check.js'/>"></script>
</body>

</html>
<style type="text/css">
    table.gridtable {
        font-family: verdana, arial, sans-serif;
        font-size: 11px;
        color: #333333;
        border-width: 1px;
        border-color: #666666;
        border-collapse: collapse;
    }

    table.gridtable th {
        border-width: 1px;
        padding: 8px;
        border-style: solid;
        border-color: #666666;
        background-color: #dedede;
    }

    table.gridtable td {
        border-width: 1px;
        padding: 8px;
        border-style: solid;
        border-color: #666666;
        background-color: #ffffff;
    }

    .listBox2 {
        padding: 0px;
        position: relative;
        width: 100%;
        margin: auto;
    }

    .listBox2 table {
        border: 1px solid #dcdcdc;
        width: 100%;
        font-size: 12px;
    }

    .txt_1 {
        width: 99%;
        height: 50px;
        border: 1px solid #cccccc;
        font-size: 12px;
    }
</style>