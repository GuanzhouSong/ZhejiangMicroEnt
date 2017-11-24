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
    <title>提请数据信息修正</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">

<div class="tabbale" data-component="tab">
    <form id="searchForm" class="form-box mb5">
        <div class="form-list pdr8">
            <!-- 第1行 start  -->
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">统一信用代码/注册号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt js-trim  js-clearValue" name="uniCode" value="" placeholder="">
                        </div>
                    </div>
                </div>

                <div class="col-4">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt js-trim js-clearValue" name="entName" value="" placeholder=""/>
                        </div>
                    </div>
                </div>

                <div class="col-4">
                    <label class="item-name col-5">联系电话：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt js-trim js-clearValue" name="phone" value="" placeholder=""/>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 第1行 end  -->

            <!------------------------------------------------------------分割线------------------------------------------------------------------------------>

            <!-- 第2行 start  -->
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">申请人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt js-trim  js-clearValue" name="applyPerson" value="" placeholder="">
                        </div>
                    </div>
                </div>

                <div class="col-4">
                    <label class="item-name col-5">申请日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" id="applyDateStart" class="ipt-txt laydate-icon js-clearValue"   name="applyDateStart" value=""  readonly="readonly"/>
                        </div>

                        <span class="item-line col-05">-</span>

                        <div class="ipt-box col-575">
                            <input type="text" id="applyDateEnd" class="ipt-txt laydate-icon js-clearValue"   name="applyDateEnd" value=""  readonly="readonly"/>
                        </div>
                    </div>
                </div>

                <div class="col-4">
                    <label class="item-name col-5">反馈日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" id="feedbackDateStart" class="ipt-txt laydate-icon js-clearValue"   name="feedbackDateStart" value=""  readonly="readonly"/>
                        </div>

                        <span class="item-line col-05">-</span>

                        <div class="ipt-box col-575">
                            <input type="text" id="feedbackDateEnd" class="ipt-txt laydate-icon js-clearValue"   name="feedbackDateEnd" value=""  readonly="readonly"/>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 第2行 end  -->
            <!------------------------------------------------------------分割线------------------------------------------------------------------------------>
        </div>
    </form>

    <div class="center mt10">
        <input type="button" id="js-search" value="查询" class="btn mr20">
        <input type="button" id="js-reset"  value="重置" class="btn mr20">
     <%--   <span style="text-align: right !important;"><a href="/reg/server/datamodify/list/" target="_blank">(新开操作页面)</a></span>--%>
        <%-- &lt;%&ndash; <input type="button" id="more" value="更多查询条件" class="btn mr20">&ndash;%&gt;--%>
    </div>
</div>


<div class="clearfix mb5 mt5">
    <p class="fl"><input id="js-add-datamodify" type="button" class="btn btn-sm mr5 " value="新增数据信息修正">
</div>



<!-- 表格列表 -->
<div class="tab-content mb20 mt10">
    <div class="tab-panel tab-panel-show">
        <div class="">
            <div class="table-out">
                <table id="data-table" border="0" cellspacing="0" cellpadding="0" class="table-row display nowrap">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>操作</th>
                        <th>统一代码/注册号</th>
                        <th>企业名称</th>
                        <th>申请人</th>
                        <th>申请日期</th>
                        <th>联系电话</th>
                        <th>反馈日期</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/datamodify/datamodify_server_list.js"></script>
</body>
</html>
