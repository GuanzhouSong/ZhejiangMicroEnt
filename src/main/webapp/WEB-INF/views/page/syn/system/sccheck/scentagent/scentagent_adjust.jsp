<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>执法人员调整</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<div class="form-box">
	<form id="chooseagentform">
	<input type="hidden" value="${deptTaskUid }" name="taskDeptUid" id="taskDeptUid"/>
    <div class="form-list">
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5">检查人员：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt" name="agentName">
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">统一信用代码/注册号：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt" name="regNO">
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">抽查机关：</label>
                <div class="col-7">
                    <div class="ipt-box col-11">
                        <input type="text" class="ipt-txt" value="${sysUser.dept }" readonly="readonly">
                    </div>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
        	<div class="col-4">
                <label class="item-name col-5">组长/专家：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt" name="teamLeader">
                    </div>
                </div>
            </div>
            <div class="col-4">
                <div class="item-name col-5">企业名称：</div>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" name="entName" class="ipt-txt" value="" />
                    </div>
                </div>
            </div>
            <div class="col-4">
	            <label class="item-name col-5">登记机关：</label>
	            <div class="col-7">
	                <div class="ipt-box col-11">
	                    <input type="hidden" class="ipt-txt" name="regOrg" id="regOrg" value=""/>
	                    <input type="text" readonly="readonly" class="ipt-txt" id="regOrgName" value="" />
	                     <span class="add-icon" id="choseorgReg">
	                         <i></i>
	                  </span>
	                </div>
	            </div>
            </div>
        </div>
        <div class="form-item clearfix">
        	<div class="col-4">
                <label class="item-name col-5">抽查任务编号：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt" name="taskCode">
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">抽查任务名称：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt" name="taskName">
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">管辖单位：</label>
                <div class="col-7">
                   <div class="ipt-box col-11">
                       <input type="hidden" class="ipt-txt" name="localAdm" id="localAdm" value=""/>
                       <input type="text" readonly="readonly" class="ipt-txt" id="localAdmName" value="" />
                        <span class="add-icon" id="choseregUnit">
                            <i></i>
                        </span>
                    </div>
                 </div>
            </div>
        </div>
        <div id="hideorshow" style="display: none">
            <div class="form-item clearfix">
            	<div class="col-4">
                    <label class="item-name col-5">设置人：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="adjustUserName" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">设置日期：</label>
                    <div class="col-6">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" onclick="laydate()" readonly="readonly" name="adjustTimeStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" onclick="laydate()" readonly="readonly" name="adjustTimeEnd" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select name="auditState">
                            	<option value="1">待录入</option>
                            	<option value="2">待审核</option>
                            	<option value="4">审核不通过</option>
                            	<option value="5">已公示</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
       </div>
        <div class="form-item clearfix mt10">
            <div class="btn-box">
                <input type="button" value="查 询" id="search" class="btn mr20">
                <input type="button" value="重 置" class="btn mr20" onclick="$('#chooseagentform')[0].reset();" id="cancel">
                <input type="button" id="more" value="更多查询条件" class="btn mr20">
            </div>
        </div>
   </div>
    </form>
</div>
<div class="mt5">
	 <div class="light-info mb5 mt5">
    <span class="light"><input type="button" class="btn btn-sm mb5" id="adjust" value="调整">提示：仅对待录入状态下的检查名单可进行检查执法人员调整处理。</span>
 	</div>
    <table border="0" id="agent-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap" width="100%">
        <thead>
        <tr>
            <th>序号</th>
            <th><input type="checkbox" id="chooseAll"/></th>
            <th>检查人员 </th>
            <th>组长</th>
            <th>专家</th>
            <th>统一社会信用代码/注册号</th>
            <th>企业名称</th>
            <th>状态</th>
            <th>任务编号</th>
            <th>任务名称</th>
            <th>登记机关</th>
            <th>管辖单位</th>
            <th>设置人</th>
            <th>设置日期</th>
        </tr>
        </thead>
    </table>
</div>
<script>
    window._CONFIG = {
       chooseUrl:'${sysUser.userType == 2 ? "/syn" : "/reg"}', 
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sccheck/scentagent/scentagent_adjust.js"></script>
</body>
</html>