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
    <title>多证合一接收列表</title>
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
                    <label class="item-name col-3">核准日期：</label>
                    <div class="col-9">
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt"readonly="readonly" onclick="laydate()" name="startApprDate" value=""/>
                        </div>
                        <span class="item-txt col-2"><i class="line-icon"></i></span>
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt"readonly="readonly" onclick="laydate()" name="endApprDate" value=""/>
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
                    <label class="item-name col-5">经营范围：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="opScope">
                        </div>
                    </div>
                </div>                 
                <div class="col-4">
                    <label class="item-name col-3">推送日期：</label>
                    <div class="col-9">
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt"readonly="readonly" onclick="laydate()" name="startCheckPushDate" value=""/>
                        </div>
                        <span class="item-txt col-2"><i class="line-icon"></i></span>
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt"readonly="readonly" onclick="laydate()" name="endCheckPushDate" value=""/>
                        </div>
                    </div>
                </div>                
                <div class="col-4">
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" name="regOrg" id="regOrg" value="" class="hidden_input"/>
                            <input type="text" class="fl ipt-txt" readonly="readonly" id="regOrgName" value="" placeholder="选择"/>
                            <span class="add-icon" id=choseorgReg><i></i></span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">备案事项：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" id="exaName" readonly="readonly" class="fl ipt-txt" placeholder="选择"/>
                            <input type="hidden" id="exaCode" name="exaCode" value="" class="hidden_input">
	                 <span class="add-icon" id="yccodetree">
	                     <i></i>
	                 </span>
                        </div>
                    </div>
                </div>                

                <div class="col-4">
                    <label class="item-name col-3">接收日期：</label>
                    <div class="col-9">
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt"readonly="readonly" onclick="laydate()" name="acceptDateStart" value=""/>
                        </div>
                        <span class="item-txt col-2"><i class="line-icon"></i></span>
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt"readonly="readonly" onclick="laydate()" name="acceptDateEnd" value=""/>
                        </div>
                    </div>
                </div>                

                <div class="col-4">
                    <label class="item-name col-5">新增/变更备案事项：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select id="checkRegType" name="checkRegType">
                                <option value="">全部</option>
                                <option value="1">新增备案事项</option>
                                <option value="2">变更备案事项</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <!-- <div class="form-item clearfix mb10">
                <div class="col-4">
                    <label class="item-name col-5">备案认领：</label>
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
                    <label class="item-name col-3">接收日期：</label>
                    <div class="col-9">
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt"readonly="readonly" onclick="laydate()" name="acceptDateStart" value=""/>
                        </div>
                        <span class="item-txt col-2"><i class="line-icon"></i></span>
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt"readonly="readonly" onclick="laydate()" name="acceptDateEnd" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">抄告接收：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select id="status" name="receiveState">
                                <option value="">全部</option>
                                <option value="0">未接收</option>
                                <option value="1">已接收</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div> -->
            <div class="form-item">
                <div class="center">
                    <input type="button" value="查 询" class="btn mr20" id="search">
                    <input type="reset" value="重 置" class="btn" id="reset">
                </div>
            </div>
        </div>
    </div>
</form>

<div class="clearfix mb5">
    <p class="fl"><input type="button" class="btn btn-sm mr5" value="批量处理" id="receiveAll"/></p>
</div>
<div class="light-info">
    <span class="light">提示：1.勾选备案企业可予以批量接收。2. 明确为错误推送的备案企业可点击接收中的“回退”后予以重新推送。3. 备案企业处理时限：超过10个工作日未处理的显示<i
            class="xbt-icon red-lamp lamp"></i>，超过7个工作日未处理的
显示<i class="xbt-icon yellow-lamp lamp"></i>，7个工作内未处理的显示<i class="xbt-icon blue-lamp lamp"></i>。</span>
</div>

<table id="user-table" class="table-row perc-100 nowrap" width="100%">
    <thead>
    <tr>
        <th>序号</th>
        <th>全选 <input type="checkbox" id="checkAll"></th>
        <th>警示图标</th>
        <th>操作</th>
        <th>备案事项</th>
        <th>企业名称</th>
        <th>法定代表人</th>
        <th>登记机关</th>
        <th>推送日期</th>
        <th>新增/变更备案事项</th> 
       <!--  <th>认领日期</th> -->
        <th>接收日期</th>               
        <!-- <th>推送机关类型</th> -->
        <th>对应备案部门</th>
        <th>实际备案部门</th>
        <th>职能部门</th>
        <th>统一社会信用代码</th>
        <th>注册号</th>
       <!--  <th>认领账号</th> -->
        <th>接收账号</th>
        <th>退回账号</th>
        <th>退回日期</th>
        <th>退回理由</th>
        <th>企业联系电话</th>
        <th>经营范围</th>
        <th>住所</th>
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
<script src="/js/syn/system/pubdzdtinfo/pubdtinforeceive_list.js"></script>
</body>
</html>
