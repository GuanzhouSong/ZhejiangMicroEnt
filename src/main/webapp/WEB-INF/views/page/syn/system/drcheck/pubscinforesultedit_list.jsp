<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>抽查检查结果录入</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">
<div class="form-box mb5">
    <form id="scinforesultform">
        <input type="hidden" id="" name="auditType" value="edit"/>
        <input type="hidden" id="" name="resultFlag" value="NO"/>
        <input type="hidden" id="userType"  value="${sysUser.userType}"/>
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-6">统一信用代码/注册号：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="regNO">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-4">企业名称：</label>
                    <div class="col-8">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5"> 登记机关：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="regOrg" id="regOrg" value=""/>
                            <input type="text" class="ipt-txt" readonly="readonly" id="regOrgName" value="" placeholder="选择"/>
                        <span class="add-icon" id="choseorgReg">
                            <i></i>
                        </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-6">任务编号：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="taskCode">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-4">任务名称：</label>
                    <div class="col-8">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="taskName">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5"> 管辖单位：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="localAdm" id="localAdm" value=""/>
                            <input type="text" class="ipt-txt" readonly="readonly" id="localAdmName" value=""
                                   placeholder="选择"/>
                        <span class="add-icon" id="choseregUnit">
                            <i></i>
                        </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-6">检查主体类型：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select name="entTypeCatg">
                                <option value="">全部</option>
                                <c:forEach items="${listEntcatg}" var="entcatg" varStatus="status">
                                    <option value="${entcatg.code }">${entcatg.content }</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-4">任务设置日期：</label>
                    <div class="col-8">
                        <div class="col-12">
                            <div class="ipt-box col-5">
                                <input type="text" class="ipt-txt" readonly="readonly" name="startDate"
                                       onclick="laydate()">
                            </div>
                            <span class="item-txt col-2"><i class="line-icon"></i></span>
                            <div class="ipt-box col-5">
                                <input type="text" class="ipt-txt" readonly="readonly" name="endDate"
                                       onclick="laydate()">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5"> 任务组织部门：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" id="leaderDeptName" readonly="readonly" value="" class="fl ipt-txt" placeholder="选择"
                                  >
                            <input type="hidden" id="leaderDept" name="leaderDept" value="">
                            <span class="add-icon" id="leaderDeptChoose"><i></i></span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix mt10">
                <div class="btn-box">
                    <input type="button" value="查 询" id="search" class="btn mr20">
                    <input type="button" value="重 置" class="btn" id="cancel"
                           onclick="$('#scinforesultform')[0].reset();">
                </div>
            </div>
        </div>
    </form>
</div>
<!-- <div class="clearfix mb5 mt20"> -->
<!--     <p><input type="button" class="btn btn-sm mr5" value="导出"><input type="button" class="btn btn-sm" value="打印"></p> -->
<!-- </div> -->
<div>
    <table border="0" id="scinforesult-table" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap">
        <thead>
        <tr>
            <th>序号</th>
            <th>操作</th>
            <th>任务完成状态</th>
            <th>任务编号</th>
            <th>任务名称</th>
            <th>任务截止时间</th>
            <th>统一信用代码/注册号</th>
            <th>企业名称</th>
            <th>指定检查人员</th>
            <th>法定代表人</th>
            <th>成立日期</th>
            <th>住所</th>
        </tr>
        </
        <thead>
    </table>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/drcheck/pubscinforesultedit_list.js"></script>
</body>
</html>