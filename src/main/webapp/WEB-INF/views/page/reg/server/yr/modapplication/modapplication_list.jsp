<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>年报修改申请审核</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
	<link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<style type="text/css">
    .accept {
        text-decoration: none;
        color: #003399;
        cursor: pointer;
        font-size: 13px;
    }
</style>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box">
        <input type="hidden" id="" name="auditType" value="edit"/>
        <input type="hidden" id="" name="resultFlag" value="NO"/>
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">统一代码/注册号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="regNo" placeholder="请输入统一代码/注册号">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName" placeholder="请输入企业名称">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">管辖单位：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="localAdm" id="localAdm" value=""/>
                            <input type="text" class="ipt-txt" id="localAdmName" value="" placeholder="请选择管辖单位" readonly="readonly"/>
                        <span class="add-icon" id="choseregUnit">
                            <i></i>
                        </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">审核员：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="audName" placeholder="请输入审核员">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5"> 申请日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" name="modSubmitDateStart" class="ipt-txt laydate-icon" readonly="readonly"
                                   onclick="laydate()">
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" name="modSubmitDateEnd" class="ipt-txt laydate-icon" readonly="readonly"
                                   onclick="laydate()">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">抽查机关：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="checkDep" id="checkDep" value=""/>
                            <input type="text" class="ipt-txt" id="checkDepName" value="" placeholder="请选择抽查机关" readonly="readonly"/>
                              <span class="add-icon" id="chosecheckDep">
                              <i></i>
                          </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">年度：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="year" style="cursor: pointer;">
                                <option value="">全部</option>
                                <c:forEach items="${yearList}" var="year" varStatus="status">
                                    <option value="${year }">${year }</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">审核日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" name="audDateStart" class="ipt-txt laydate-icon" readonly="readonly"
                                   onclick="laydate()">
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" name="audDateEnd" class="ipt-txt laydate-icon" readonly="readonly"
                                   onclick="laydate()">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="regOrg" id="regOrg" value=""/>
                            <input type="text" class="ipt-txt" id="regOrgName" value="" placeholder="请选择登记机关" readonly="readonly"/>
                        <span class="add-icon" id="choseorgReg">
                            <i></i>
                        </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
	                        <select id="modResults" name="modResult">
	                            <option value="0">待审核</option>
	                            <option value="1">审核通过</option>
	                            <option value="2">审核不通过</option>
	                        </select>
                        </div>
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
    </form>
    <div>
        <table border="0" id="modapplication-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt10"
               style="width: 100%;white-space: nowrap;">
            <thead>
            <tr>
                <th style="min-width: 50px">序号</th>
                <th style="min-width: 70px">操作</th>
                <th style="min-width: 70px">年度</th>
                <th style="min-width: 120px">统一代码/注册号</th>
                <th style="min-width: 140px">企业名称</th>
                <th style="min-width: 100px">年报状态</th>
                <th style="min-width: 120px">申请日期</th>
                <th style="min-width: 100px">审核结果</th>
                <th style="min-width: 100px">修改审核员</th>
                <th style="min-width: 120px">审核日期</th>
                <th style="min-width: 100px">登记机关</th>
                <th style="min-width: 100px">抽查机关</th>
                <th style="min-width: 100px">管辖单位</th>
            </tr>
            </
            <thead>
        </table>
    </div>
    <script src="/js/lib/require.js"></script>
    <script src="/js/config.js"></script>
    <script src="/js/reg/server/yr/modapplication/list_main.js"></script>
</div>
</body>
</html>