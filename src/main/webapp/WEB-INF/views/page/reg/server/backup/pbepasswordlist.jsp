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
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <title>个体户登录校验码</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<form id="taskForm">
<div class="form-box">
    <div class="form-list pdr8">
        <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">联络员手机号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="tel" placeholder="请输入完整的手机号码">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">统一代码/注册号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="regNo" placeholder="请输入完整的统一代码/注册号">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName" placeholder="请输入完整的企业名称">
                        </div>
                    </div>
                </div>
            </div>
            <div class="mt10">
            <div class="center">
                <input type="button" value="查 询" id="search" class="btn mr20">
                <input type="button" value="重 置" id="cancel" class="btn" onclick="$('#taskForm')[0].reset();">
            </div>
        </div>
      </div>
    </form>

    <div class="light-info mt10">
        <span class="light">提示：仅限查询本部门登记或管辖的个体工商户登录校验码记录。个体工商户登录年报系统时获取的联络员手机验证码24小时内有效。</span>
    </div>
    <div class="table-out">
        <div>
            <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30" style="width: 100%;white-space: nowrap;">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>统一社会信用代码/注册号</th>
                    <th>个体户名称</th>
                    <th >经营者</th>
                    <th >经营者电话</th>
                    <th >企业联络员</th>
                    <th >联络员手机</th>
                    <th >验证码</th>
                    <th >获取时间</th>
                    <th >登记机关</th>
                    <th>管辖单位</th>
                </tr>
                </thead>
                <tbody></tbody>
            </table>
        </div>
    </div>
<script>
    window._CONFIG = {
       year:'${year}', 
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/backup/pbepasswordlist.js"></script>
</body>
</html>
