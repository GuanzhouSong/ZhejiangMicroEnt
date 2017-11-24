<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>抽查检查任务设置</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">
<form id="qryForm">
<input type="hidden" id="userType" value="${sysUser.userType}">
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
                <label class="item-name col-4">任务期始：</label>
                <div class="col-8">
                    <div class="ipt-box col-5">
                        <input type="text" readonly="readonly" name="startDateStart" onclick="laydate()" class="ipt-txt">
                    </div>
                    <span class="item-txt col-1"><i class="line-icon"></i></span>
                    <div class="ipt-box col-5">
                        <input type="text" readonly="readonly" name="startDateEnd" class="ipt-txt" onclick="laydate()">
                    </div>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-4">检查主体类型：</label>
                <p class="radio-box">
                        <input type="hidden" name="taskEntCatgCode" id="depttaskEntCatgCode">
                        <label class="checkbox-inline font-12">
                            <input type="checkbox" name="deptcatgCode" class="roles required" id="0" value="企业">企业
                        </label>

                        <label class="checkbox-inline font-12">
                            <input type="checkbox" name="deptcatgCode" class="roles" id="1" value="个体户">个体户
                        </label>

                        <label class="checkbox-inline font-12">
                            <input type="checkbox" name="deptcatgCode" class="roles" id="2" value="农专社">农专社
                        </label>
                    </p>
             </div>
            <!-- <div class="col-4">
                <label class="item-name col-4">检查实施部门：</label>
                <div class="col-8">
                    <div class="ipt-box col-12">
                           <input type="text" id="InspectDeptName" value="" readonly class="fl ipt-txt" placeholder="选择" style="height: 30px;cursor: pointer;">
                 <input type="hidden" id="inspectDept" name="inspectDept" value="">
                 <span class="add-icon" id="choseImplDept"><i></i></span>
                    </div>
                </div>
            </div> -->
            <div class="col-4">
                <label class="item-name col-4"> 任务状态：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <select name="taskState">
                            <option value="">全部</option>
                            <option value="">待抽取执法人员</option>
                            <option value="05">实施中</option>
                            <option value="06">已完成</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-4">任务设置日期：</label>
                <div class="col-8">
                    <div class="ipt-box col-5">
                        <input type="text" readonly="readonly" name="setTimeStart" onclick="laydate()" class="ipt-txt">
                    </div>
                    <span class="item-txt col-1"><i class="line-icon"></i></span>
                    <div class="ipt-box col-5">
                        <input type="text" readonly="readonly" name="setTimeEnd" onclick="laydate()" class="ipt-txt">
                    </div>
                </div>
            </div>
        </div>
         <div class="form-item clearfix">
              <div class="col-4">
                <label class="item-name col-4"> 任务组织部门：</label>
                <div class="col-7">
                    <div class="ipt-box col-12"> 
                 <input type="text" id="leaderDeptName" value="" readonly class="fl ipt-txt" placeholder="选择" style="height: 30px;cursor: pointer;">
                 <input type="hidden" id="leaderDeptCode" name="leaderDeptCode" value="">
                 <span class="add-icon" id="choseorgReg"><i></i></span>
                 
                    </div>
                </div>
            </div>
        </div>            
        <div class="form-item clearfix">
            <div class="btn-box">
                <input type="button" value="查 询" id="qry" class="btn mr20">
                <input type="button" value="重 置" id="cancel" class="btn">
            </div>
        </div>
    </div>
</div>
</form>
<div class="clearfix mb5">
    <p>
<!--     <span class="light-yellow fr mt15">共发起<em id="allCount">0</em>条抄告抄送，其中<em id="waitSetEnt">0</em>条待抽取，<em id="waitSetPlan">0</em>条设置任务计划，<em id="inspecting">0</em>条已实施，<em id="waitConfirmAgent">0</em>条待选择执法待选人员，<em id="chooseAgent"></em>条待抽选执法人员，<em id="finished"></em>条已抄告完</span> -->
  
<!--    
  <input type="button" class="btn btn-sm mr5 " id="toAdd" value="添加新任务">
 <input type="button" class="btn btn-sm mr5" id="test" value="导出"> -->
<!--     <input type="button" class="btn btn-sm" value="打印"> -->
    </p>
</div>
<div>
    <table border="0"  id="scstack-table" cellspacing="0" cellpadding="0" class="table-row nowrap">
       <thead>
        <tr>
            <th width="7%">序号</th>
            <th width="13%">操作 </th>
            <th width="7%"> 本部门任务状态 </th>
            <th width="7%">整体任务状态</th>
            <th width="13%"> 任务编号 </th>
            <th width="7%">任务名称</th>
            <th width="13%">任务期始 </th>
            <th width="13%"> 任务期止 </th>
            <th width="7%">  检查主体类型</th>
            <th width="7%">检查对象数量</th>
        </tr>
        </thead>
    </table>
</div>
</body>
<script id="table-template" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="{{this.class}}">{{this.text}}</button>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/drcheck/sctack/deptstack_list.js"></script>
</html>