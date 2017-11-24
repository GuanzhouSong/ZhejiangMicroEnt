<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>责令整改申请列表</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box pd14-mr">
        <div class="form-list">
            <div class="form-item clearfix">
                <div id="uniCode" class="col-4">
                    <label class="item-name col-5"><span class="long-label">统一信用代码/注册号：</span></label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="regNoOrUniSciD" value=""
                                   placeholder="请输入统一信用代码/注册号">
                        </div>
                    </div>
                </div>
                <div class="col-4" id="entName">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="entName" value="" placeholder="请输入企业名称"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5"><span class="long-label">责令整改有效日期：</span></label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" onclick="laydate()" readonly="readonly" name="staDate"
                                   value="">
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" onclick="laydate()" readonly="readonly" name="endDate"
                                   value="">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">申请/审核人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="auditNames" value="" placeholder="请输入申请/审核人">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">审核状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select name="auditState" id="auditState">
                                <option value="">不限</option>
                                <option value="0">待审核</option>
                                <option value="2">退回修改</option>
                                <option value="1">同意责令整改</option>
                                <option value="3">取消责令整改</option>
                                <option value="4">中止</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">管辖单位：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="localAdm" id="localAdm" value=""/>
                            <input type="text" class="ipt-txt" id="localAdmName" value="" placeholder="请选择管辖单位"
                                   disabled="disabled"/>
	                            <span class="add-icon" id="choseregUnit">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">责令整改项目：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select name="adminGuideType">
                                <option value="">不限</option>
                                <option value="0">其他</option>
                                <option value="1">逾期出资</option>
                                <option value="2">法定代表人任职资格</option>
                                <option value="3">许可证到期、被吊销、被撤销</option>
                                <option value="4">经营期限到期</option>
                                <option value="5">登记事项变更或备案</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">提示状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select name="efftStatus">
                                <option value="">不限</option>
                                <option value="2">流程中</option>
                                <option value="1">有效</option>
                                <option value="0">无效</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="regOrg" id="regOrg" value=""/>
                            <input type="text" class="ipt-txt" id="regOrgName" value="" placeholder="请选择登记机关"
                                   disabled="disabled"/>
	                            <span class="add-icon" id="choseorgReg">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-group clearfix">
                <div class="center mt10">
                    <input type="button" id="search" value="查询" class="btn mr20">
                    <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
                </div>
            </div>
        </div>
    </form>
    <div class="clearfix mb5 mt5">
        <p class="fl"><input type="button" class="btn btn-sm mr5" value="新增" id="orderReformSetApplyPage"></p>
       <!--  <p class="fl"><input type="button" class="btn btn-sm mr5" value="导出" id="showpubOpanoMalyList"></p> -->
    </div>
    <div class="tab-content mb20">
        <div class="tab-panel tab-panel-show">
            <div class="">
                <div class="table-out">
                    <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap" width="100%">
                        <thead>
                        <tr>
                            <th style="padding:0 20px;">序号</th>
                            <th>操作</th>
                            <th>审核状态</th>
                            <th>提示状态</th>
                            <th>统一信用代码</th>
                            <th>注册号</th>
                            <th>企业名称</th>
                            <th>责令整改项目</th>
                            <th>开始日期</th>
                            <th>结束日期</th>
                            <th>申请人</th>
                            <th>申请日期</th>
                            <th>审核人</th>
                            <th>审核日期</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <script src="<c:url value="/js/lib/laydate/laydate.js"/>"></script>
    <script src="<c:url value="/js/lib/require.js"/>"></script>
    <script src="<c:url value="/js/config.js"/>"></script>
    <script src="<c:url value="/js/reg/server/orderreformset/orderreformset_list_main.js"/>"></script>
</body>
</html>