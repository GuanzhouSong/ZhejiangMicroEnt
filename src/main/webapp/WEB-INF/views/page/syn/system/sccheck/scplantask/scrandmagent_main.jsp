<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>随机抽取执法人员</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<form id="paramForm"><input type="hidden" value="${pubScPlanTaskDto.uid }" name="deptTaskUid" id="taskUid"/><!-- 部门任务表uid --></form>
<input type="hidden" value="${sessionDeptCode }" name="deptCode" id="deptCode"/> <!-- 当前用户orgcoding编码 -->
<input type="hidden" value="${pubScPlanTaskDto.taskUid }" name="uid" id="uid"/> <!-- 当前任务uid -->
<input type="hidden" value="${pubScPlanTaskDto.randomType }" id="randomType"/> <!-- 当前任务uid -->
<input type="hidden" id="randomTypeValue"/> <!-- 当前任务uid -->
<input type="hidden" id="groupNumValue"/> <!-- 当前任务uid -->
<h5 class="h5-title center">任务名称：
     <input type="text" class="ipt-txt" readonly="readonly" value="${pubScPlanTaskDto.taskName} "  style="width: 400px; box-sizing: border-box; padding: 1px 3px;line-height: 28px;height: 30px;font: 13.3333px Arial;"/>
     <a href="javascript:void(0);" style="color:blue;" class="view">详情</a>
</h5>
<h5 class="h5-title">抽查对象名单</h5>
 <div id="waitrandom-table">
<table id="info-table" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 mt30 mb10 nowrap">
        <thead>
        <tr>
            <th>序号</th>
            <th>统一信用代码/注册号</th>
            <th>企业名称</th>
            <th>成立日期</th>
            <th>主体类别</th>
<!--             <th>上次抽查日期</th> -->
<!--             <th>所属专项库</th> -->
            <th>登记机关</th>
            <th>管辖单位</th>
        </tr>
        </thead>
    </table>
</div>
 	 <h5 class="h5-title">检查人员抽取库设置&nbsp;&nbsp;
 	 	<input type="radio" class="type" id="type1" name="randomType" value="1" style="cursor: pointer;" <c:if test="${pubScPlanTaskDto.randomType == '1'}">checked="checked"</c:if> <c:if test="${pubScPlanTaskDto.deptState != '1'}">disabled="disabled"</c:if>>
 	 	<label for="type1" style="cursor: pointer;">按检查小组建库</label>
 	 	<input type="radio" class="type" id="type2" name="randomType" value="2" style="cursor: pointer;"  <c:if test="${pubScPlanTaskDto.randomType == '2'}">checked="checked"</c:if> <c:if test="${pubScPlanTaskDto.deptState != '1'}">disabled="disabled"</c:if>>
 	 	<label for="type2" style="cursor: pointer;">按检查人员建库</label>
 	 </h5>
<div  id="group-div" <c:if test="${pubScPlanTaskDto.randomType != '1'}">style="display: none;"</c:if>>
 	 <div>
 	 <input type="hidden" id="groupCount" name="groupCount"/>
 	  <div class="clearfix mb5" id="waitgrouprandom">
	     <c:if test="${pubScPlanTaskDto.deptState != '2'}">
	    	<p class="fl"><input type="button" class="btn btn-sm" id="addGroupId" value="添加检查小组">
	    	<input type="button" class="btn btn-sm" id="deleteGroup" value="删除检查小组">
	    	<input type="button" class="btn btn-sm" id="deleteAllGroup" value="清空设置">
	    	</p>
	     </c:if>
	 </div>
     <table  border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 mt30 mb10 nowrap" id="groupTableId">
         <thead>
          <tr>
              <th>序号</th>
              <th>全选<input type="checkbox" id="checkAllGroup"/></th>
              <th>小组成员数</th>
              <th>检查小组成员</th>
              <th>组长</th>
              <th>专家</th>
          </tr>
         </thead>
     </table>
     <h5 class="fl mr10 h5-title">检查小组匹配规则设置</h5>
     <div class="center">
	   	<div class="form-box" id="agent-form">
	    <div class="form-list">
	        <div class="form-item clearfix">
	              	<div class="col-5">
	              		<div class="col-4 item-name"></div>
	               	<div class="col-5 ipt-box">
	               		随机抽取<input type="text" id="randomGroupNumber" class="ipt-txt" style="width: 120px;" value="${pubScPlanTaskDto.minNum }" <c:if test="${pubScPlanTaskDto.deptState != '1'}">disabled="disabled"</c:if>/>个小组
	               	</div>
	              	</div>
	           </div>
	          </div>
	      </div>
	</div>
	</div>
</div>
<div id="agent-div" <c:if test="${pubScPlanTaskDto.randomType != '2'}">style="display: none;"</c:if>>
 <div class="clearfix mb5" id="waitrandom">
     <c:if test="${pubScPlanTaskDto.deptState != '2'}">
    	<p class="fl"><input type="button" class="btn btn-sm" id="addAgentId" value="添加检查人员">
    	<input type="button" class="btn btn-sm" id="delete" value="删除检查人员">
    	<input type="button" class="btn btn-sm" id="deleteAll" value="清空设置">
    	</p>
     </c:if>
 </div>
 <div class="clearfix mb5 center">
 <h5>
     <input type="text" class="ipt-txt" id="agentName" placeholder="请输入人员姓名" style="width: 400px; box-sizing: border-box; padding: 1px 3px;line-height: 28px;height: 30px;font: 13.3333px Arial;"/>
     <input type="button" class="btn btn-sm" id="searchChecker" value="查询">
 </h5>
 </div>
 
 <div id="waitrandom-table">
     <input type="hidden" value="" id="clientNameCount"/> <!-- 当前用户orgcoding编码 -->
     <table  border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 mt30 mb10 nowrap" id="backTableId">
         <thead>
          <tr>
              <th width="5%">序号</th>
              <th width="5%">全选<input type="checkbox" id="checkAll"/></th>
              <th>姓名</th>
            <th>性别</th>
            <th>单位工号</th>
            <th>身份证号</th>
            <th>手机号</th>
            <th>学历</th>
            <th>年龄</th>
            <th>岗位大类</th>
            <th>专家</th>
            <th>岗位状态</th>
            <th>地区</th>
            <th>层级</th>
            <th>部门/机构</th>
            <th>担任职务</th>
            <th>工作单位</th>
            <th>工商部门执法证</th>
            <th>有效期</th>
            <th>省政府执法证</th>
            <th>有效期</th>
            <th>设置人</th>
            <th>设置日期</th>
          </tr>
         </thead>
     </table>
     <h5 class="fl mr10 h5-title">检查人员匹配规则设置</h5>
     <div class="center">
	   	<div class="form-box" id="agent-form">
	    <div class="form-list">
	        <div class="form-item clearfix">
	              	<div class="col-5">
	              		<div class="col-4 item-name">每户检查对象配置：</div>
	               	<div class="col-5 ipt-box">
	               		检查人员<input type="text" id="checkNumber" class="ipt-txt" style="width: 120px;" value="${pubScPlanTaskDto.minNum }" <c:if test="${pubScPlanTaskDto.deptState != '1'}">disabled="disabled"</c:if>/>个
	               	</div>
	              	</div>
	           </div>
	          </div>
	      </div>
	</div>
 </div>
</div>
<div class="center mb20" style="padding: 20px;">
<c:if test="${pubScPlanTaskDto.deptState == '1'}">
<input type="button" value="开始抽取检查名单" class="btn mr20" id="random"/>
<input type="button" value="查看企业人员配对结果" class="btn mr20" id="view" style="display: none;"/>
<input type="button" value="锁定" class="btn mr20" id="lock" style="display: none;"/>
</c:if>
<c:if test="${pubScPlanTaskDto.deptState != '1'}">
<input type="button" value="查看企业人员配对结果" class="btn mr20" id="view"/>
</c:if>
<input type="button" value="关闭" class="btn" id="close"/>
</div>
<script>
    window._CONFIG = {
       chooseUrl:'${sysUser.userType == 2 ? "/syn" : "/reg"}', 
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sccheck/scplantask/scrandmagent_main.js"></script>
</body>
</html>