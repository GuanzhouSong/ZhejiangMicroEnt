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
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>党组织录入</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<style type="text/css">
    .commit {
        text-decoration: none;
        color: #003399;
        cursor: pointer;
        font-size: 13px;
    }
</style>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box">
        <div class="form-list">
            <div class="form-item clearfix">
                 <div class="col-4">
                    <label class="item-name col-5">党组织类型：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <label><input type="checkbox" name="partyOrgType" checked="checked" value="1">党委</label>
                            <label><input type="checkbox" name="partyOrgType" checked="checked" value="2">党总支</label>
                            <label><input type="checkbox" name="partyOrgType" checked="checked" value="3">党支部</label>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">组建日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt pointer laydate-icon" onclick="laydate()"
                                   readonly="readonly" name="partyOrgBuildDateStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt pointer laydate-icon" onclick="laydate()"
                                   readonly="readonly" name="partyOrgBuildDateEnd" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">管辖单位：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="localAdm" id="localAdm" value=""/>
                            <input type="text" class="ipt-txt" id="localAdmName" value="" readonly="readonly" placeholder="请选择管辖单位"/>
	                            <span class="add-icon" id="choseregUnit">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">党组织名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="partyOrgName" value="" placeholder="可输入名称关键词查询"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">建档日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt pointer laydate-icon" onclick="laydate()"
                                   readonly="readonly" name="createTimeStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt pointer laydate-icon" onclick="laydate()"
                                   readonly="readonly" name="createTimeEnd" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                           <select name="inputState">
                                <option value="">全部</option> 
                                <option value="2">待入库</option>
                                <option value="1">有效</option>
                                <option value="0">无效</option>
                             </select>
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">党组织分布类型：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                           <select name="partyOrgDistributed">
                                <option value="">全部</option> 
                                <option value="1">个体户党组织</option>
                                <option value="2">企业党组织</option>
                                <option value="3">农贸市场党组织</option>
                                <option value="4">商品交易市场党组织</option>
                             </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">修改日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt pointer laydate-icon" onclick="laydate()"
                                   readonly="readonly" name="modifyTimeStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt pointer laydate-icon" onclick="laydate()"
                                   readonly="readonly" name="modifyTimeEnd" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">录入员：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="inputName" value="" placeholder=""/>
                        </div>
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
    </form>
</div>
 
<div class="iframe-wrap">
    <button type="button" id="addBtn" class="btn btn-primary mt5">新增党组织</button>
    <div class="light-info mb5 mt5">
        <span class="light">提示：新增信息在入库前可删除，入库后即为建档信息只能修改。企业注销后其自建的党组织自动变为失效状态。</span>
    </div>
    <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row display nowrap">
        <thead>
        <tr>
            <th>序号</th>
            <th>操作</th>
            <th>修改日期</th>
            <th>党组织名称</th>
            <th>状态</th>
            <th>管辖单位</th>
            <th>党组织分布类型</th>
            <th>党组织类型</th>
            <th>组建日期</th>
            <th>建档日期</th>
            <th>录入员</th>
        </tr>
        </thead>
    </table>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/partycreate/party_org_list.js"></script>
</body>
</html>
