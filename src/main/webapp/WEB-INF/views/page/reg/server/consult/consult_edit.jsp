<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
 	<meta http-equiv="X-UA-Compatible" content="IE=8" >
    <title>异议反馈</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/style.css">
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
<body>
<div class="main">
    <h1 id="title"></h1>
    <form id="pubauditosaveform">
        <div class="listBox2 thBg">
            <!-- 参数传递列表 --> 
            <input type="hidden" name="uid" id="uid" value="${consultInfo.uid}"> 
            <div class="leftTop"></div>
            <div class="right1Top"></div>
            <table class="table-horizontal">
                <tr id="appBasic">
                    <td class="bg-gray right" width="100px">
                        <div class="ipt-box">企业名称</div>
                    </td>
                    <td width="270px">
                        <div class="ipt-box">${midBaseInfoDto.entName}</div>
                    </td>
                    <td class="bg-gray right" width="100px">
                        <div class="ipt-box">注册号</div>
                    <td width="180px">
                        <div class="ipt-box">${midBaseInfoDto.regNO}</div>
                    </td>
                    <td class="bg-gray right" width="100px">
                        <div class="ipt-box">成立日期</div>
                    </td>
                    <td width="150px">
                        <div class="ipt-box"><fmt:formatDate value="${midBaseInfoDto.estDate}" type="date"
                                                           pattern="yyyy-MM-dd"/></div>
                    </td>
                </tr>
                <tr id="appBasic">
                    <td class="bg-gray right">
                        <div class="ipt-box">登记机关</div>
                    </td>
                    <td>
                        <div class="ipt-box">${midBaseInfoDto.regOrgName}</div>
                    </td>
                    <td class="bg-gray right">
                        <div class="ipt-box">法定代表人</div>
                    </td>
                    <td>
                        <div class="ipt-box">${midBaseInfoDto.leRep}</div>
                    </td>
                    <td class="bg-gray right">
                        <div class="ipt-box">管辖单位</div>
                    </td>
                    <td>
                        <div class="ipt-box">${midBaseInfoDto.localAdmName}</div>
                    </td>
                </tr> 
            </table>
        </div>
        <br/>
        <div class="listBox2 thBg">
            <div class="leftTop"></div>
            <div class="rightTop"></div>
            <table width="100%" border="0" class="table-horizontal"> 
                <tr>
                    <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box"><font color="red"></font>标题</div>
                    </td>
                    <td colspan="6">
                        <div class="ipt-box">
                            <textarea disabled="disabled"  
                                      style="width: 100%;height: 50px;">${consultInfo.consultTitle}</textarea></div>
                    </td>
                </tr> 
                <tr>
                    <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box"><font color="red"></font>异议内容</div>
                    </td>
                    <td colspan="6">
                        <div class="ipt-box">
                            <textarea disabled="disabled" id="anomalyRea" name="anomalyRea"
                                      style="width: 100%;height: 50px;">${consultInfo.consultContent}</textarea></div>
                    </td>
                </tr> 
                <tr>
                    <td class="bg-gray right" width="100" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box">申请日期</div>
                    </td>
                    <td width="180">
                        <div class="ipt-box"><fmt:formatDate value="${consultInfo.consultTime}" type="date"
                                                           pattern="yyyy-MM-dd"/></div>
                    </td>
                    <td class="bg-gray right" width="120" valign="middle" class="lb_1" style="text-align:center">
                        <!-- <div class="ipt-box">咨询人</div> -->
                    </td>
                    <td width="180">
                        <%-- <div class="ipt-box">${consultInfo.consultName}</div> --%>
                    </td>
                    <td class="bg-gray right" width="130" valign="middle" class="lb_1" style="text-align:center">
                       <!--  <div class="ipt-box">咨询人联系电话</div> -->
                    </td>
                    <td width="250" colspan="2">
                       <%--  <div class="ipt-box">${consultInfo.consultTel}</div> --%>
                    </td>
                </tr>
                <tr>
	                <c:if test="${flag==1 }">
	        		<td class="bg-gray right" width="100" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box">* 反馈意见<br>(限1000字)</div>
                    </td>
                    <td colspan="6"> 
                        <div class="ipt-box">
                             <textarea id="backContent" name="backContent"
                                       style="width: 100%;height: 50px;"></textarea>
                        </div>
                    </td>
	      			</c:if>
			        <c:if test="${flag==2 }">
			        <td class="bg-gray right" width="100" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box">反馈意见<br>(限1000字)</div>
                    </td>
                    <td colspan="6"> 
                        <div class="ipt-box">
                             <textarea id="backContent" name="backContent" readonly="readonly"
                                       style="width: 100%;height: 50px;">${consultInfo.backContent}</textarea>
                        </div>
                    </td>
			        </c:if> 
                </tr>
                <tr>
                    <td class="bg-gray right" width="100" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box">反馈日期</div>
                    </td>
                    <td width="180">
                        <div class="ipt-box">
                         <c:if test="${flag==2 }">
                         <fmt:formatDate value="${consultInfo.backTime}" type="date" pattern="yyyy-MM-dd"/>
                         </c:if>
                         <c:if test="${flag==1 }">
                         ${nowDate}
                         </c:if> 
                        </div>
                    </td>
                    <td class="bg-gray right" width="120" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box">反馈人</div>
                    </td>
                    <td width="180">
                        <div class="ipt-box">
                         <c:if test="${flag==2 }">
                         ${consultInfo.backName}
                         </c:if>
                         <c:if test="${flag==1 }">
                         ${sysUser.realName}
                         </c:if> 
                        </div>
                    </td>
                    <td class="bg-gray right" width="130" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box">反馈部门</div>
                    </td>
                    <td width="250" colspan="2">
                        <div class="ipt-box">
                         <c:if test="${flag==2 }">
                         ${consultInfo.backDept}
                         </c:if>
                         <c:if test="${flag==1 }">
                         ${deptName}
                         </c:if> 
                        </div>
                    </td>
                </tr> 
            </table>
        </div>
    </form>
    <br><br>
    <div align="center">
        <c:if test="${flag==1 }">
        <input type="button" class="btn btn-info" id="savepubOpanoBtn" value="保存"/>
        <input type="button" class="btn " id="cancel" value="取消"/>
        </c:if>
        <c:if test="${flag==2 }">
         <input type="button" class="btn " id="cancel" value="关闭"/>
        </c:if> 
    </div>
</div>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/server/consult/consult_edit_main.js"/>"></script>
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
</style>