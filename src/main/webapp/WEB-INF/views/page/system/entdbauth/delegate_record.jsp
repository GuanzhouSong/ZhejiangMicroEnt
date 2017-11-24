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

    <title>企业授权记录</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<body class="pd10">

<div class="tabbale" data-component="tab">
    <form id="entSearchForm"  class="form-box">
        <div class="form-list pdr8">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">统一代码：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="uniCode" value=""   />
                        </div>
                    </div>
                </div>
                <div class="col-4" >
                    <label class="item-name col-5">注册号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="regNO" value="" />
                        </div>
                    </div>
                </div>
                <div class="col-4" >
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName" value="" />
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">操作人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="username" value=""  />
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5"><span class="long-label">操作人所在部门名称：</span></label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="appReviewOrg" value="" />
                        </div>
                    </div>
                </div>
                <div class="col-4" >
                    <label class="item-name col-5">操作时间：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon"  onclick="laydate()" readonly="readonly" name="startSetDate" value="" />
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" onclick="laydate()" readonly="readonly" name="endSetDate" value="" />
                        </div>

                    </div>
                </div>
            </div>
            <div class="center mt10">
                <input type="button"  id="search" value="查询" class="btn mr20">
                <input type="button"  id="cancel" onclick="$('#entSearchForm')[0].reset();" value="重置" class="btn mr20">
            </div>
        </div>
    </form>
</div>

<div class="tab-content mb20 mt10">
    <div class="tab-panel tab-panel-show">
        <div class="">
            <div class="table-out">
                <table id="user-table" border="0" cellspacing="0" cellpadding="0"
                       class="table-row display nowrap">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>企业名称</th>
                        <th>委托机关</th>
                        <th>操作人</th>
                        <th>操作人所在部门</th>
                        <th>操作时间</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/business/entdbauth/delegate_record.js"></script>
</body>
</html>
