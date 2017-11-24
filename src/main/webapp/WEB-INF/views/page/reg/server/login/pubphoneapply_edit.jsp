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
    <title></title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<div class="clearfix">
    <h1 class="h4-title left mt5">联络员备案表</h1>
    <form id="taskForm">
        <input type="hidden" id="pasid" name="pasid" value="${pubPhoneapply.pasid}"/>
        <input type="hidden" id="pripid" name="pripid" value="${pubPhoneapply.pripid}"/>
        <input type="hidden" id="regno" name="regno" value="${pubPhoneapply.regno}"/>
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
            <tr>
                <td class="bg-gray right" width="20%">企业名称</td>
                <td width="30%">
                    <div class="ipt-box pd0">
                        <input type="text" id="entname" class="ipt-txt" value="${pubPhoneapply.entname}"
                               readonly="readonly"/>
                    </div>
                </td>
                <td class="bg-gray right" width="20%">企业统一代码/注册号</td>
                <td width="30%">
                    <div class="ipt-box pd0">
                        <input type="text" id="regno" name="regno" class="ipt-txt"
                               value="${empty pubPhoneapply.unicode?pubPhoneapply.regno:pubPhoneapply.unicode}"
                               readonly="readonly"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">法定代表人(负责人)姓名</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" id="lerep" name="lerep" class="ipt-txt" value="${pubPhoneapply.lerep}"
                               readonly="readonly"/>
                    </div>
                </td>
                <td class="bg-gray right">法定代表人(负责人)手机号码</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" id="lerepphone" name="lerepphone" class="ipt-txt"
                               value="${pubPhoneapply.lerepphone}" readonly="readonly"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">企业联络员姓名</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" id="lianame" name="lianame" class="ipt-txt" value="${pubPhoneapply.lianame}"
                               readonly="readonly"/>
                    </div>
                </td>
                <td class="bg-gray right">企业联络员手机号码</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" id="tel" name="tel" class="ipt-txt" value="${pubPhoneapply.tel}"
                               readonly="readonly"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">企业联络员证件类型</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="hidden" id="liaidtype" name="liaidtype" value="${pubPhoneapply.liaidtype}"/>
                        <c:forEach var="codeCertype" items="${codeCertypeList}" varStatus="">
                            <c:if test="${codeCertype.code == pubPhoneapply.liaidtype}">
                                <input type="text" value="${codeCertype.content}" class="ipt-txt" readonly="readonly"/>
                            </c:if>
                        </c:forEach>
                    </div>
                </td>
                <td class="bg-gray right">企业联络员证件号码</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" id="liaidnum" name="liaidnum" class="ipt-txt"
                               value="${pubPhoneapply.liaidnum}" readonly="readonly"/>
                    </div>
                </td>
            </tr>
        </table>
        <p class="center mt10">
            <input type="button" id="save" class="btn btn-primary save" value="接收"/>
        </p>
    </form>

    <div class="mt40">
        <h1 class="h4-title left mt5">历史备案表接收记录</h1>
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
                <th>备案表接收日期</th>
                <th>备案方式</th>
                <th>备案表接收员</th>
                <th>备案表接收部门</th>
            </tr>
            </thead>
        </table>
    </div>
</div>

<div class="layder-bd mt40" id="send-message-layer" style="display: none;">
    <div class="send-message">
        <div>
            <table border="0" cellspacing="0" cellpadding="0" class="table-row">
                <tr>
                    <td colspan="4" style="font-weight:bold;font-size:14px;text-align: left;">
                        提示：
                    </td>
                </tr>
                <tr>
                    <td colspan="4" style="font-weight:bold;font-size:14px;color: red;text-align: left;">
                        <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;企业联络员备案表接收成功！</span></td>
                </tr>
                <tr>
                    <td colspan="4" style="font-weight:bold;font-size:14px;color:black;text-align: left">
                        <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;备案表当面送达的，可选择是否打印备案表回执单交企业备存；邮寄方式送达的，可选择是否发送短信方式通知确认的联络员。</span>
                    </td>
                </tr>
                <tr>
                    <td style="color: black"><label><input type="checkbox" class="sendMsg"/> 发送短信通知联络员</label></td>
                    <td><a href="javascript:void(0)" id="print">打印备案表收讫回执单</a></td>
                </tr>
            </table>
        </div>
        <div class="clearfix mt20">
            <div class="center">
                <input type="button" class="btn mr20" value="确定" id="send">
            </div>
        </div>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/login/pubeppassword_edit_main.js"></script>
</body>
</html>