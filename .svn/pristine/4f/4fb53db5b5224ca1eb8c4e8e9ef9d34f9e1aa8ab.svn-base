<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>检查人员随机抽取</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<form id="qryForm">
<input type="hidden" id="userType" value="${sysUser.userType}">
<input type="hidden" id="deptCode" value="${deptCode}">
<input type="hidden" id="userId" value="${sysUser.id}">
<div class="form-box mb5">
    <div class="form-list">
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-4">任务名称：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <input type="text" name="taskName" class="ipt-txt">
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-4">任务编号：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <input type="text" name="taskCode" class="ipt-txt">
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-4"> 任务组织部门：</label>
                <div class="col-7">
                    <div class="ipt-box col-12"> 
                 <input type="text" id="taskLeadDeptCodeName" value="" readonly class="fl ipt-txt" placeholder="选择" style="height: 30px;cursor: pointer;">
                 <input type="hidden" id="taskLeadDeptCode" name="taskLeadDeptCode" value="">
                 <span class="add-icon" id="choseorgReg"><i></i></span>
                 
                    </div>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
           <div class="col-4">
                <label class="item-name col-4">抽查方式：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <select name="taskType">
                            <option value="">全部</option>
                            <option value="1">定向</option>
                            <option value="2">不定向</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-4">任务期限：</label>
                <div class="col-8">
                    <div class="ipt-box col-5">
                        <input type="text" readonly="readonly" name="taskStartTime" onclick="laydate()" class="ipt-txt">
                    </div>
                    <span class="item-txt col-1"><i class="line-icon"></i></span>
                    <div class="ipt-box col-5">
                        <input type="text" readonly="readonly" name="taskEndTime" onclick="laydate()" class="ipt-txt">
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-4">设置人：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <input type="text" name="setUserName" class="ipt-txt">
                    </div>
                </div>
            </div>
        </div>
         <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-4">检查对象类型：</label>
                <p class="radio-box">
                        <input type="hidden" name="taskObject" id="depttaskEntCatgCode">
                        <label class="checkbox-inline font-12">
                            <input type="checkbox" name="deptcatgCode" class="roles required" id="1" value="1">企业
                        </label>

                        <label class="checkbox-inline font-12">
                            <input type="checkbox" name="deptcatgCode" class="roles" id="3" value="3">个体户
                        </label>

                        <label class="checkbox-inline font-12">
                            <input type="checkbox" name="deptcatgCode" class="roles" id="2" value="2">农专社
                        </label>
                        <label class="checkbox-inline font-12">
                            <input type="checkbox" name="deptcatgCode" class="roles" id="4" value="4">外企代表机构
                        </label>
                    </p>
             </div>
             <div class="col-4">
                <label class="item-name col-4"> 人员名单状态：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <select name="deptState">
                            <option value="">全部</option>
                            <option value="1">待抽取</option>
                            <option value="2">已抽取</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-4">抽查部门：</label>
                <div class="col-7">
		            <div class="ipt-box pd0">
		              <input type="hidden" name="unitDeptCodes" id="localAdm"/>
		              <input type="text" class="ipt-txt" id="localAdmName" value="${sysUser.dept}" placeholder="选择抽查部门" readonly/>
		              <span class="add-icon" id="choseregUnit">
		                   <i></i>
		              </span>
		            </div>
	            </div>
            </div>
        </div>            
        <div class="form-item clearfix">
            <div class="btn-box">
                <input type="button" value="查 询" id="qry" class="btn mr20">
                <input type="button" value="重 置" id="cancel" onclick="$('#qryForm')[0].reset();" class="btn">
            </div>
        </div>
    </div>
</div>
</form>
<div class="light-info mb5">
    <span class="light">提示：仅对本部门登记或管辖的检查对象涉及的抽查任务进行执法人员随机抽取。</span>
</div>
<div>
 <table id="scstack-table" class="table-row perc-100 nowrap" width="100%">
    <thead>
    <tr>
        <th style="padding:0 20px;">序号</th>
        <th>操作</th>
        <th>任务编号</th>
        <th>任务名称</th>
        <th>抽查部门</th>
        <th>人员名单状态</th>
<!--         <th>检查人员数</th> -->
<!--         <th>专家人员数</th> -->
        <th>检查对象范围</th>
        <th>检查对象数</th>
        <th>抽查方式</th>
        <th>任务开始日期</th>
        <th>任务结束日期</th>
        <th>任务组织部门</th>
        <th>设置人</th>
        <th>设置日期</th>
    </tr>
    </thead>
</table>
</div>
</body>
<script>
    window._CONFIG = {
       chooseUrl:'${sysUser.userType == 2 ? "/syn" : "/reg/server"}', 
       chooseViewUrl:'${sysUser.userType == 2 ? "/syn" : "/reg"}'
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sccheck/scplantask/scplantaskanddept_list.js"></script>
</html>