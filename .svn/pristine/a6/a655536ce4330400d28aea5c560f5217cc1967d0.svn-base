<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="nowdate" class="java.util.Date" />
<fmt:formatDate var="sysDate" value="${nowdate}" pattern="yyyy-MM-dd"/>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>提请数据修正</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<body class="pd10">
<div class="">
    <div class="">
        <form id="js-apply-from">
            <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10">
                <tr>
                    <td width="18%" class="bg-gray right">注册号/统一代码:</td>
                    <td width="32%">
                        <div class="ipt-box pd0">
                            <input type="text" name="uniCode" class="ipt-txt"  value="${uniCode}" readonly>
                        </div>
                    </td>
                    <td width="18%" class="bg-gray right">企业名称:</td>
                    <td width="32%">
                        <div class="ipt-box pd0">
                            <input type="text" name="entName" class="ipt-txt" value="${entName}" readonly>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td class="bg-gray right"><span style="color:red;">*</span>申请人:</td>
                    <td>
                        <div class="ipt-box pd0">
                            <input type="text" name="applyPerson" class="ipt-txt" value="" >
                        </div>
                    </td>

                    <td class="bg-gray right"><span style="color:red;">*</span>联系电话:</td>
                    <td>
                        <div class="ipt-box pd0">
                            <input type="text" class="ipt-txt"  name="phone" value="" />
                        </div>
                    </td>
                </tr>

                <tr>
                    <td class="bg-gray right"><span style="color:red;">*</span>申请日期:</td>
                    <td>
                        <div class="ipt-box pd0">
                            <input type="text" class="ipt-txt"   name="applyDate" value="${sysDate}" readonly/>

                        </div>
                    </td>
                    <td class="bg-gray right"><span style="color:red;">*</span>反馈日期:</td>
                    <td>
                        <div class="ipt-box pd0">
                            <input type="text" class="ipt-txt"  onclick="laydate()" name="feedbackDate" value="" readonly/>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td class="bg-gray right"><span style="color:red;">*</span>数据修正类型:</td>
                    <td>
                        <div class="ipt-box pd0">
                            <select name="modifyType">
                                <option value="">--请选择--</option>
                                <option value="1">抽查检查结果修改</option>
                                <option value="2">异常名录结果修改</option>
                                <option value="3">严重违法结果修改</option>
                                <option value="4">即时信息公示修改</option>
                            </select>
                        </div>
                    </td>
                    <td class="bg-gray right">&nbsp;</td>
                    <td>
                        <div class="ipt-box pd0">

                        </div>
                    </td>
                </tr>

                <tr>
                    <td class="bg-gray right"><span style="color:red;">*</span>申请内容：</td>
                    <td colspan="3">
                        <div class="ipt-box pd0">
                            <textarea cols=""  class="ipt-txt"  rows="" style="width:100%;height: 130px" name="applyContent" ></textarea>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right">备注：</td>
                    <td colspan="3">
                        <div class="ipt-box pd0">
                            <textarea cols=""  class="ipt-txt"  rows="" style="width:100%;height: 130px" name="remark" ></textarea>
                        </div>
                    </td>
                </tr>
            </table>
            <input type="hidden" name="priPID" value="${pripid}">
        </form>

        <div class="clearfix mt10">
            <div class="center">
                <button id="js-submit-btn" type="submit" class="btn mr20">保存</button>
                <button id="js-cancel" type="button" class="btn">关闭</button>
            </div>
        </div>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/datamodify/mid_data_edit.js"></script>
</body>
</html>