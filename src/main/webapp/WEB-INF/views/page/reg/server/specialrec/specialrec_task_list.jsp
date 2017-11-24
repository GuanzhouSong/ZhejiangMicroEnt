<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>抽查检查任务设置列表</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box pd14-mr"> 
         <div class="form-list">
            <div class="form-item clearfix">
                <div id="uniCode" class="col-4">
                    <label class="item-name col-5"><span class="long-label">检查任务名称：</span></label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                             <input type="text" class="ipt-txt" name="taskName" value="" placeholder="请输入抽查任务名称">
                        </div>
                    </div>
                </div>
                <div class="col-4" id="entName">
                    <label class="item-name col-5">检查任务编号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                           <input type="text" class="ipt-txt" name="taskCode" value="" placeholder=" 请输入抽查任务编号">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">任务组织部门：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="orgDeptName" value="" placeholder="请输入任务组织部门"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">任务类型：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select name="taskType">
                                <option value="">全部</option>
                                <option value="1">本部门</option>
                                <option value="2">跨部门</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">任务结束期限：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                         		<div class="ipt-box col-575">
	                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly" name="taskStartTime"
	                                   id="startInfaustlDate" value=""/>
		                        </div>
		                        <span class="item-line col-05">-</span>
		                        <div class="ipt-box col-575">
		                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly" name="taskEndTime"
		                                   id="endInfaustlDate" value=""/>
		                        </div>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">检查参与部门：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                           <input type="text" class="ipt-txt" name="partiDeptName" value="" placeholder="请输入检查参与部门"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">任务执行状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select name="taskState">
                                <option value="">全部</option>
                                <option value="01">待执行</option>
                                <option value="02">执行中</option>
                                <option value="03">已完成</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">任务设置日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                         		<div class="ipt-box col-575">
	                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly" name="setStartTime"
	                                   id="setStartTime" onclick="laydate()" value=""/>
		                        </div>
		                        <span class="item-line col-05">-</span>
		                        <div class="ipt-box col-575">
		                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly" name="setEndTime" 
		                               id="setEndTime" onclick="laydate()" value=""/>
		                        </div>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">设置人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="setUserName" value="" placeholder="请输入任务设置人"/>
                        </div>
                    </div>
                </div>
            </div>
              
            <div class="center mt10">
            <input type="button" id="search" value="查询" class="btn mr20">
            <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
       		</div>
        </div>
    </form>
    <div class="clearfix mb5 mt5">
        <p class="fl"><input type="button" id="add" class="btn btn-sm mr5" value="添加专项整治检查任务"></p>
    </div>
    <div class="light-info mt5">
        <span class="light">提示：请先在本模块完成专项整治任务设置后，再进行专项整治检查结果录入。专项整治检查结果不对外公示。
    </div> 
    <div class="tip-info right">
		查询结果：
		检查任务共<label id="totalall" class="light-blue">0</label>个，
		待执行<label id="dzxgs" class="light-blue">0</label>个，
		执行中<label id="zxzgs" class="light-blue">0</label>个，
		已完成<label id="ywcgs" class="light-blue">0</label>个。
		应检查<label id="xjcgs" class="light-blue">0</label>家次。
		已检查<label id="yjcgs" class="light-blue">0</label>家次。
	</div>
    <div class="tab-content mb20">
        <div class="tab-panel tab-panel-show">
            <div class="">
                <div class="table-out">
                    <table id="specialrec_table"  border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap" width="100%">
                        <thead>
                        <tr>
                            <th style="padding:0 20px;">序号</th>
	                        <th>操作</th>
	                        <th>检查任务编号</th>
	                        <th>检查任务名称</th>
	                        <th>任务类型</th>
	                        <th>任务执行状态</th>
	                        <th>检查对象数</th>
	                        <th>已完成检查数</th>
	                        <th>任务期限始</th>
	                        <th>任务期限止</th>
	                        <th>检查参与部门</th>
	                        <th>任务组织部门</th>
	                        <th>任务设置人</th> 
	                        <th>任务设置日期</th> 
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
   chooseUrl:'${sysUser.userType == 2 ? "/syn" : "/reg"}', 
}
</script>
<script src="/js/reg/server/specialrec/specialrec_task_list.js"></script>
</body>
</html>