<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
            <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10">
                <tr>
                    <td width="18%" class="bg-gray right">注册号/统一代码:</td>
                    <td width="32%">
                        <div class="ipt-box pd0">
                            <input type="text" name="" class="ipt-txt"  value="${applyDataModify.uniCode}" readonly>
                        </div>
                    </td>
                    <td width="18%" class="bg-gray right">企业名称:</td>
                    <td width="32%">
                        <div class="ipt-box pd0">
                            <input type="text" name="entName" class="ipt-txt" value="${applyDataModify.entName}" readonly>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td class="bg-gray right">申请人:</td>
                    <td>
                        <div class="ipt-box pd0">
                            <input type="text" name="" class="ipt-txt" value="${applyDataModify.applyPerson}" readonly>
                        </div>
                    </td>

                    <td class="bg-gray right">联系电话:</td>
                    <td>
                        <div class="ipt-box pd0">
                            <input type="text" class="ipt-txt"   name="" value="${applyDataModify.phone}" readonly/>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td class="bg-gray right">申请日期:</td>
                    <td>
                        <div class="ipt-box pd0">
                            <input type="text" class="ipt-txt"   name="" value="<fmt:formatDate value="${applyDataModify.applyDate}" pattern="yyyy-MM-dd"/>" readonly/>

                        </div>
                    </td>
                    <td class="bg-gray right">反馈日期:</td>
                    <td>
                        <div class="ipt-box pd0">
                            <input type="text" class="ipt-txt"   name="" value="<fmt:formatDate value="${applyDataModify.feedbackDate}" pattern="yyyy-MM-dd"/>" readonly/>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td class="bg-gray right">数据修正类型:</td>
                    <td>
                        <div class="ipt-box pd0">
                            <input type="${applyDataModify.modifyType=='1'?'text':'hidden'}" class="ipt-txt"   value="${applyDataModify.modifyType=='1'?'抽查检查结果修改':''}" readonly/>
                            <input type="${applyDataModify.modifyType=='2'?'text':'hidden'}" class="ipt-txt"   value="${applyDataModify.modifyType=='2'?'异常名录结果修改':''}" readonly/>
                            <input type="${applyDataModify.modifyType=='3'?'text':'hidden'}" class="ipt-txt"   value="${applyDataModify.modifyType=='3'?'严重违法结果修改':''}" readonly/>
                            <input type="${applyDataModify.modifyType=='4'?'text':'hidden'}" class="ipt-txt"   value="${applyDataModify.modifyType=='4'?'即时信息公示修改':''}" readonly/>
                        </div>
                    </td>
                    <td class="bg-gray right">&nbsp;</td>
                    <td>
                        <div class="ipt-box pd0">
                            <%-- <input type="text" name="" class="ipt-txt" value="${applyDataModify.feedbackDate}" disabled>--%>
                        </div>
                    </td>

                </tr>


                <tr>
                    <td class="bg-gray right">申请内容：</td>
                    <td colspan="3">
                        <div class="ipt-box pd0">
                            <textarea cols=""  class="ipt-txt"  rows="" style="width:100%;height: 130px" name="" readonly>${applyDataModify.applyContent}</textarea>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right">备注：</td>
                    <td colspan="3">
                        <div class="ipt-box pd0">
                            <textarea cols=""  class="ipt-txt"  rows="" style="width:100%;height: 130px" name="" readonly>${applyDataModify.remark}</textarea>
                        </div>
                    </td>
                </tr>
            </table>

        <div class="clearfix mt10">
            <div class="center">
                <button id="js-cancel" type="button" class="btn">关闭</button>
            </div>
        </div>
    </div>
</div>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script>
    require([
        'component/iframeLayer'
    ], function (layer) {
        $('#js-cancel').on('click',function(){
            layer.close();
        });
    });
</script>
</body>
</html>