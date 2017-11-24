<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>任务设置主页面</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">
<input type="hidden" id="userType" value="${sysUser.userType}">
<input type="hidden" id="dutyDeptCodes" value="${sysUser.dutyDeptCodes}">
<input id="realtab" type="hidden" value="lead"/>
<div class="tabbale" id="cgcs-tab">
    <div class="tab-header tab-chaogao">
        <ul class="clearfix">
            <li class="tab-selected" style="display:none;"><span id="leadTab" class="tab-item"></span></li>
            <!--  <li><span id="deptTab" class="tab-item">本部门待实施的任务</span></li> -->
        </ul>
    </div>
    <div class="tab-content mb20">
        <div id="leadbody" class="tab-panel">
            <div class="tabbale">
                <form id="leadsctackForm">
                    <div class="form-box mb5">
                        <div class="form-list">
                            <div class="form-item clearfix">
                                <div class="col-4">
                                    <label class="item-name col-4">任务编号：</label>
                                    <div class="col-7">
                                        <div class="ipt-box col-12">
                                            <input type="text" name="taskCode" class="ipt-txt">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-4">
                                    <label class="item-name col-4">任务名称：</label>
                                    <div class="col-7">
                                        <div class="ipt-box col-12">
                                            <input type="text" name="taskName" class="ipt-txt">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-4">
                                    <label class="item-name col-4">任务设置日期：</label>
                                    <div class="col-8">
                                        <div class="ipt-box col-5">
                                            <input type="text" readonly="readonly" name="setTimeStart"
                                                   onclick="laydate()" class="ipt-txt">
                                        </div>
                                        <span class="item-txt col-1"><i class="line-icon"></i></span>
                                        <div class="ipt-box col-5">
                                            <input type="text" readonly="readonly" name="setTimeEnd" onclick="laydate()"
                                                   class="ipt-txt">
                                        </div>
                                    </div>
                                </div>
<!--                             <div class="col-4">
                                    <label class="item-name col-4"> 任务组织部门：</label>
                                    <div class="col-7">
                                        <div class="ipt-box col-12">
                                            <input type="text" id="leaderleadDeptName" value="" class="fl ipt-txt"
                                                   readonly placeholder="选择" style="height: 30px;cursor: pointer;">
                                            <input type="hidden" id="leaderleadDeptCode" name="leaderDeptCode" value="">
                                            <span class="add-icon" id="choseleadorgReg"><i></i></span>

                                        </div>
                                    </div>
                                </div> -->
                            </div>
                            <div class="form-item clearfix">
                                <div class="col-4">
                                    <label class="item-name col-4">检查主体类型：</label>
                                    <div class="col-8">
                                        <p class="radio-box">
                                            <input type="hidden" name="taskEntCatgCode" id="leadtaskEntCatgCode">

                                            <label class="checkbox-inline font-12">
                                                <input type="checkbox" name="catgCode" class="roles required" id="0"
                                                       value="企业">企业
                                            </label>

                                            <label class="checkbox-inline font-12">
                                                <input type="checkbox" name="catgCode" class="roles" id="1" value="个体户">个体户
                                            </label>

                                            <label class="checkbox-inline font-12">
                                                <input type="checkbox" name="catgCode" class="roles" id="2" value="农专社">农专社
                                            </label>

                                        </p>

                                    </div>
                                </div>
                                <div class="col-4">
                                    <label class="item-name col-4">检查实施部门：</label>
                                    <div class="col-7">
                                        <div class="ipt-box col-12">
                                            <input type="text" id="InspectleadDeptName" value="" readonly
                                                   class="fl ipt-txt" placeholder="选择"
                                                   style="height: 30px;cursor: pointer;">
                                            <input type="hidden" id="inspectleadDept" name="inspectDept" value="">
                                            <span class="add-icon" id="choseleadImplDept"><i></i></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-4">
                                    <label class="item-name col-4">任务状态：</label>
                                    <div class="col-8">
                                        <div class="ipt-box col-11">
                                            <select name="taskState">
                                                <option value="">全部</option>
                                                <option value="01">待抽取对象</option>
                                                <option value="02">待设置任务计划</option>
                                                <option value="05">实施中</option>
                                                <option value="06">已完成</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
<!--                             <div class="form-item clearfix mb10"> -->
<!--                                  <div class="col-4"> -->
<!--                                     <label class="item-name col-4"> 任务状态：</label> -->
<!--                                     <div class="col-7"> -->
<!--                                         <div class="ipt-box col-12"> -->
<!--                                             <select name="taskState"> -->
<!--                                                 <option value="">全部</option> -->
<!--                                                 <option value="01">待抽取对象</option> -->
<!--                                                 <option value="02">待设置任务计划</option> -->
<!--                                                 <option value="05">实施中</option> -->
<!--                                                 <option value="06">已完成</option> -->
<!--                                             </select> -->
<!--                                         </div> -->
<!--                                     </div> -->
<!--                                 </div> -->
<!--                             </div> -->
                            <div class="form-item clearfix mt10">
                                <div class="btn-box">
                                    <input type="button" value="查 询" id="qrylead" class="btn mr20">
                                    <input type="button" value="重 置" id="cancellead" class="btn">
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

            <div class="clearfix mb5">
<!--                 <p class="fl"><input id="toAdd" value="添加新任务" type="button" class="btn btn-sm mr5" /> -->
            </div>

            <div class="table-out">
                <div class="iframe-wrap">
                    <table id="lead-table" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap">
                        <thead>
                        <tr>
                            <th style="min-width: 35px">序号</th>
                            <th style="min-width: 50px">操作</th>
                            <th>任务状态</th>
                            <th>任务编号</th>
                            <th>任务组织部门</th>
                            <th>任务实施部门</th>
                            <th>任务名称</th>
                            <th>任务期始</th>
                            <th>任务期止</th>
                            <th>检查主体类型</th>
                            <th>检查对象数量</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="{{this.class}}">{{this.text}}</button>
    {{/each}}
</script>

<script id="accept_tpl" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="{{this.class}}">{{this.text}}</button>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/drcheck/sctack/sctack_list.js"></script>
</body>
</html>