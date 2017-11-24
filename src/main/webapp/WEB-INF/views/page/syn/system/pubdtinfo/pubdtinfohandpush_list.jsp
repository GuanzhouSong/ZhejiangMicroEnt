<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>涉证企业待分流列表</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box mb5">
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">统一社会信用代码：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="uniSCID" value="" placeholder="请输入统一社会信用代码"/>
                        </div>
                    </div>
                </div>
                <div id="uniCode" class="col-4">
                    <label class="item-name col-3">注册号：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="regNO" value="" placeholder="请输入注册号">
                        </div>
                    </div>
                </div>
                <div class="col-4" id="entName">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName" value="" placeholder="请输入企业名称"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">法定代表人：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="leRep" value="" placeholder="请输入法定代表人"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-3">登记机关：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="regOrg" id="regOrg" value=""/>
                            <input type="text" class="ipt-txt" id="regOrgName" readonly="readonly" value="" placeholder="请选择登记机关"/>
                            <span class="add-icon" id=choseorgReg>
                                <i></i>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">新增/变更许可事项：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select id="checkRegType" name="checkRegType">
                                <option value="">全部</option>
                                <option value="1">新增许可事项</option>
                                <option value="2">变更许可事项</option>
                            </select>
                        </div> 
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">住所（经营场所）：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="dom" value="" placeholder="请输入住所(经营场所)"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-3">推送日期：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <div class="col-5">
                                <input type="text" class="ipt-txt" readonly="readonly" onclick="laydate()"
                                       name="startCheckPushDate" id="startCheckPushDate" value=""/>
                            </div>
                            <div class="col-2 item-txt"><i class="line-icon"></i></div>
                            <div class="col-5">
                                <input type="text" class="ipt-txt" readonly="readonly" onclick="laydate()"
                                       name="endCheckPushDate" id="endCheckPushDate" value=""/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">后置审批事项：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="exaCode" id="exaCode" value=""/>
                            <input type="text" class="ipt-txt" readonly="readonly" id="exaName" value="" placeholder="请选择后置审批事项"/>
                           <span class="add-icon" id="yccodetree">
                                <i></i>
                           </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix mb10">
                <div class="col-4">
                    <label class="item-name col-5">经营范围：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="opScope" value="" placeholder="请输入经营范围"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-3">核准日期：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <div class="col-5">
                                <input type="text" class="ipt-txt" readonly="readonly" onclick="laydate()"
                                       id="startApprDate" name="startApprDate" value=""/>
                            </div>
                            <div class="col-2 item-txt"><i class="line-icon"></i></div>
                            <div class="col-5">
                                <input type="text" class="ipt-txt" readonly="readonly" onclick="laydate()"
                                       id="endApprDate" name="endApprDate" value=""/>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">推送状态：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select id="checkPushType" name="checkPushType">
                                <option value="">全部</option>
                                <option value="3">推送失败</option>
                                <option value="0">退回待推送</option>
                            </select>
                        </div> 
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="center">
                    <input type="button" id="search" value="查询" class="btn mr20">
                    <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
                </div>
            </div>
        </div>
    </form>
    <div class="clearfix mb5">
        <p class="fl"><input type="button" class="btn btn-sm mr5" value="人工分流操作" id="pubdtinfohandpushlist"></p>
        <!-- <p class="fl"><input type="button" class="btn btn-sm mr5" value="手动触发定时分流(测试用)" id="pubDtInfoPush"></p> -->
         <!-- <p class="fl"><input type="button" class="btn btn-sm mr5" value="重新推送分流失败的数据" id="pubDtInfoFailPush"></p> -->
   </div>
    <div class="light-info clearfix">
        <p class="fl light">提示：勾选推送失败或退回待推送企业后点击“人工分流操作”进行人工重新分配处理。</p>
    </div>
    <div class="tab-content mb20">
        <div class="tab-panel tab-panel-show">
            <div class="">
                <div class="table-out">
                    <!-- <table id="user-table" border="0" cellspacing="0" cellpadding="0"
                           class="table table-bordered table-hover table-row perc-100">
                        --> 
                        <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap" width="100%">
                        <thead>
                        <tr>
                            <th style="padding:0 20px;">序号</th>
                            <th>操作</th>
                            <th>后置审批事项</th>
                            <th>企业名称</th>
                            <th>登记机关</th>
                            <th>推送日期</th>
                            <th>推送机关类型</th>
                            <th>对应审批部门</th>
                            <th>实际审批部门</th>
                            <th>职能部门</th>
                            <th>退回部门</th>
                            <th>退回日期</th>
                            <th>退回事由</th>
                            <th>统一社会信用代码</th>
                            <th>注册号</th>
                            <th>推送状态</th>
                            <th>住所</th>
                            <th>经营范围</th>
                            <th>核准日期</th>
                            <th>新增/变更许可事项</th>
                            <th>法定代表人</th>
                            <th>企业联系电话</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <script src="<c:url value="/js/lib/require.js"/>"></script>
    <script src="<c:url value="/js/config.js"/>"></script>
    <script>
    window._CONFIG = { 
       _sysUrl:'${sysUrl}'
    }
	</script>
    <script src="<c:url value="/js/syn/system/pubdtinfo/pubdtinfohandpush_list_main.js"/>"></script>
</body>
</html>