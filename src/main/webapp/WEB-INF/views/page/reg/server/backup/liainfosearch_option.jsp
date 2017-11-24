<%--
  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>联络员备案表详情</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<div class="clearfix">
    <h1 class="h4-title left mt5">联络员备案表详情&nbsp;&nbsp;备案方式:${empty pubEppassword.username?"在线备案":"书式备案"  }</h1>
    <form id="taskForm">
        <input type="hidden" id="pripid" name="pripid" value="${pubEppassword.pripid}"/>
        <input type="hidden" id="pasid" name="pasid" value="${pasid}"/>
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
            <tr>
                <td class="bg-gray right" width="20%">企业名称</td>
                <td width="30%">
                    <div class="ipt-box pd0">
                        <input type="text" id="entname" class="ipt-txt" value="${pubEppassword.entname}"
                               readonly="readonly"/>
                    </div>
                </td>
                <td class="bg-gray right" width="20%">企业统一代码/注册号</td>
                <td width="30%">
                    <div class="ipt-box pd0">
                        <input type="text" name="regno" class="ipt-txt"
                               value="${empty pubEppassword.unicode?pubEppassword.regno:pubEppassword.unicode}"
                               readonly="readonly"/>
                        <input type="hidden" id="regno" value="${pubEppassword.regno}"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">法定代表人(负责人)姓名</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" id="lerep" name="lerep" class="ipt-txt" value="${pubEppassword.lerep}"
                               readonly="readonly"/>
                    </div>
                </td>
                <td class="bg-gray right">法定代表人(负责人)手机号码</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" id="lerepphone" name="lerepphone" class="ipt-txt"
                               value="${pubEppassword.lerepphone}" readonly="readonly"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">企业联络员姓名</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" id="lianame" name="lianame" class="ipt-txt" value="${pubEppassword.lianame}"
                               readonly="readonly"/>
                    </div>
                </td>
                <td class="bg-gray right">企业联络员手机号码</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" id="tel" name="tel" class="ipt-txt" value="${pubEppassword.tel}"
                               readonly="readonly"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">企业联络员证件类型</td>
                <td>
                    <div class="ipt-box pd0">
                        <c:forEach var="codeCertype" items="${Certypes}" varStatus="">
                            <c:if test="${codeCertype.code == pubEppassword.liaidtype}">
                                <input type="text" value="${codeCertype.content}" class="ipt-txt" readonly="readonly"/>
                            </c:if>
                        </c:forEach>
                    </div>
                </td>
                <td class="bg-gray right">企业联络员证件号码</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" id="liaidnum" name="liaidnum" class="ipt-txt"
                               value="${pubEppassword.liaidnum}" readonly="readonly"/>
                    </div>
                </td>
            </tr>
        </table>
        <c:if test="${!empty pubEppassword.username}">
        	 <p class="center mt10">
	            <input type="button" id="print" class="btn btn-primary doPrint" value="收讫回执单打印"/>
	        </p>
        </c:if>
    </form>

    <div class="mt40">
        <h1 class="h4-title left mt5">历史备案表记录</h1>
        <table id="permit-table" border="0" cellspacing="0" cellpadding="0" class="table-row"
               style="width: 100%;white-space: nowrap;">
            <thead>
            <tr>
                <th style="min-width: 40px">序号</th>
                <th>流水号</th>
                <th>法人代表姓名</th>
                <th>法人代表手机号</th>
                <th>企业联络员</th>
                <th>联络员手机号码</th>
                <th>联络员证件类型</th>
                <th>联络员证件号码</th>
                <th>备案日期</th>
                <th>备案方式</th>
                <th>备案表接收员</th>
                <th>备案表接收部门</th>
            </tr>
            </thead>
        </table>
    </div>
</div>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/backup/liainfosearch_option_main.js"></script>
</body>
</html>