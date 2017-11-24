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
    <title>涉证企业查询</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">
<form id="taskForm">
    <div class="form-box mb5">
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">统一社会信用代码：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="uniSCID">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-3">注册号：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="regNO">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">法定代表人：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="leRep">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-3">经营范围：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="opScope">
                        </div>
                    </div>
                </div>                
                <div class="col-4">
                    <label class="item-name col-5">住所（经营场所）：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="dom">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
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
                <div class="col-4">
                    <label class="item-name col-3"><span class="ml-20">后置审批事项：</span></label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" id="exaName" readonly="readonly" class="fl ipt-txt" placeholder="选择">
                            <input type="hidden" id="exaCode" name="exaCode" value="" class="hidden_input">
                        <span class="add-icon" id="yccodetree">
                          <i></i>
                        </span>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">前置审批事项：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" id="qzName" readonly="readonly" class="fl ipt-txt" placeholder="选择">
                            <input type="hidden" id="qzCode" name="qzCode" value="" class="hidden_input">
                        <span class="add-icon" id="qzcodetree">
                          <i></i>
                        </span>
                        </div>
                    </div>
                </div>                                
            </div>
            <div class="form-item clearfix">
               <div class="col-4">
                    <label class="item-name col-5">推送状态：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select id="checkPushType" name="checkPushType">
                                <option value="">全部</option>
                                <option value="1">自动推送</option>
                                <option value="2">手动推送</option>
                                <option value="3">推送失败</option>
                                <option value="0">退回待推送</option>
                            </select>
                        </div>
                    </div>
                </div> 
                <div class="col-4">
                    <label class="item-name col-3">推送日期：</label>
                    <div class="col-9">
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt" readonly="readonly" onclick="laydate()" name="startCheckPushDate" value="">
                        </div>
                        <span class="item-txt col-2"><i class="line-icon"></i></span>
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt" readonly="readonly" onclick="laydate()" name="endCheckPushDate" value="">
                        </div>
                    </div>
                </div>                
                <div class="col-4">
                    <label class="item-name col-5">终止推送状态：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select id="checkStopState" name="checkStopState">
                                <option value="">全部</option>
                                <option value="0">未终止推送</option>
                                <option value="1">已终止推送</option>
                            </select>
                        </div>
                    </div>
                </div>                                              
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">审批认领：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select id="claimState" name="claimState">
                                <option value="">全部</option>
                                <option value="0">未认领</option>
                                <option value="1">已认领</option>
                            </select>
                        </div>
                    </div>
                </div>               
                <div class="col-4">
                    <label class="item-name col-3">认领日期：</label>
                    <div class="col-9">
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt" readonly="readonly" onclick="laydate()" name="claimDateStart" value="">
                        </div>
                    <span class="item-txt col-2">
                        <i class="line-icon"></i>
                    </span>
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt" readonly="readonly" onclick="laydate()" name="claimDateEnd" value="">
                        </div>
                    </div>
                </div>                
                <div class="col-4">
                    <label class="item-name col-5">推送机关类型：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select id="checkDeptType" name="checkDeptType">
                                <option value="">全部</option>
                                <option value="1">审批机关</option>
                                <option value="2">属地机关</option>
                                <option value="3">同级机关</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">审批机关：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" id="checkDepName" readonly="readonly" value="" class="fl ipt-txt" placeholder="选择">
                            <input type="hidden" id="checkDep" name="checkDeps" value="" class="hidden_input">
                            <span class="add-icon" id="selectDept"><i></i></span>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-3">接收日期：</label>
                    <div class="col-9">
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt" readonly="readonly" onclick="laydate()" name="acceptDateStart" value="">
                        </div>
                    <span class="item-txt col-2">
                        <i class="line-icon"></i>
                    </span>
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt" readonly="readonly" onclick="laydate()" name="acceptDateEnd" value="">
                        </div>
                    </div>
                </div>                               
                <div class="col-4">
                    <label class="item-name col-5">抄告接收：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select id="status" name="receiveState" >
                            <option value="">全部</option>
                            <option value="0">未接收</option>
                            <option value="1">已接收</option>
                            </select>
                        </div>
                    </div>
                </div>               
            </div>
            <div class="form-item clearfix mb10">
                <div class="col-4">
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" name="regOrg" id="regOrg" value="" class="hidden_input">
                            <input type="text" class="fl ipt-txt" readonly="readonly" id="regOrgName" value="" placeholder="选择">
                            <span class="add-icon" id="choseorgReg"><i></i></span>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-3">核准日期：</label>
                    <div class="col-9">
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt" readonly="readonly" onclick="laydate()" name="startApprDate" value="">
                        </div>
                        <span class="item-txt col-2"><i class="line-icon"></i></span>
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt" readonly="readonly" onclick="laydate()" name="endApprDate" value="">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">行业类型：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" id="industryCoName" readonly="readonly" class="fl ipt-txt" placeholder="选择">
                            <input type="hidden" id="industryCo" name="industryCo" value="" class="hidden_input">
                        <span class="add-icon" id="industryCotree">
                          <i></i>
                        </span>
                        </div>
                    </div>
                </div>                                 
            </div>
            <div class="form-item">
                <div class="btn-box">
                    <input type="button" id="search" value="查 询" class="btn mr20">
                    <input type="reset" id="reset" value="重 置" class="btn">
                </div>
            </div>
        </div>
    </div>
</form>

<div class="light-info">
    <span class="light">提示：单击选中企业可查看企业详情。黄色标识企业为推送失败、退回待推送企业。 </span>
    <i class="xbt-icon close"></i>
</div>
<div class="tip-info left">
    查询结果：推送企业<label id="sendBusinessCount" class="light-blue">0</label>家，
    推送审批部门<label id="sendDeptCount" class="light-blue">0</label>个，
    推送信息<label id="sendSuccessCount" class="light-blue">0</label>条，
   退回待推送<label id="rebackCount" class="light-blue">0</label>条，
   推送失败共<label id="sendFail" class="light-blue">0</label>条，
   其中 终止推送<label id="pushStopCount" class="light-blue">0</label>条。
</div>
<table id="user-table" class="table-row perc-100 nowrap" width="100%">
    <thead>
    <tr>
        <th>序号</th>
        <th>后置审批事项</th>
        <th>企业名称</th>
        <th>登记机关</th>
        <th>推送日期</th>
        <th>推送机关类型</th>
        <th>对应审批部门</th>
        <th>实际审批部门</th>
        <th>职能部门</th>
        <th>统一社会信用代码</th>
        <th>注册号</th>
        <th>审批认领</th>
        <th>抄告接收</th>
        <th>住所</th>
        <th>经营范围</th>
        <th>核准日期</th>
        <th>认领日期</th>
        <th>接收日期</th>
        <th>推送状态</th>
        <th>终止推送状态</th>
        <th>新增/变更许可事项</th>
        <th>法定代表人</th>
        <th>企业联系电话</th>
    </tr>
    </thead>
</table>
<script>
    window._CONFIG = {
       chooseUrl:'${userType == 2 ? "/syn" : "/reg/server"}', 
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/pubdtinfo/pubdtinfosearch_list.js"></script>
</body>
</html>
