<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<meta charset="utf-8">
<meta http-equiv="Content-Type"
	content="multipart/form-data; charset=utf-8" />
<title>专项检查主体库统计</title>
<link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
<link rel="stylesheet" href="/css/reg.server.css">
<link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<!-- <img  src="/img/reg/server/zfryktj.jpg"> -->
	<div class="tabbale" data-component="tab">
		<form id="taskForm" class="form-box mb5">
			<div class="form-list pdr8">
				<div class="form-item clearfix">
					<div class="col-3">
						<label class="item-name col-5">统计截止日期：</label>
	                      <div class="ipt-box col-7">
<!-- 	                        <div class="ipt-box col-575"> -->
	                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly"  
	                              name="setTimeEnd" id="setTimeEnd" value="${endCheckPushDate}"/>
<!-- 	                        </div> -->
	                     </div>
					</div>
					<div class="col-3">
						<label class="item-name col-5">统计层级：</label>
						<div class="col-7">
							<div class="ipt-box col-11">
                            <select name="statLevel" id="statLevel">
                                <option value="area">按地区</option>
                                <option value="check">按检查部门</option>
                            </select>
							</div>
						</div>
					</div>
					<div class="col-4">
						<label class="item-name col-5">统计范围：</label>
						<div class="col-7">
							<div class="ipt-box col-9">
                            <select name="statArea" id="statArea" multiple="multiple">
                                <option value='3300'>省局</option>
					       		<option value='3301'>杭州</option>
					       		<option value='3302'>宁波</option>
					       		<option value='3303'>温州</option>
					       		<option value='3304'>嘉兴</option>
					       		<option value='3305'>湖州</option>
					       		<option value='3306'>绍兴</option>
					       		<option value='3307'>金华</option>
					       		<option value='3308'>衢州</option>
					       		<option value='3309'>舟山</option>
					       		<option value='3310'>台州</option>
					       		<option value='3325'>丽水</option>
                            </select>
							</div>
						</div>
					</div>
				</div>
				<div class="center mt10">
					<input type="button" id="search" value="查询" class="btn mr20">
					<input type="button" id="cancel"
						onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
				</div>
		</form>
	</div>
	
    <div class="light-info mt10">
         <p class="light">数据说明：检查人员数包含专家人员数。</p>
    </div>
    <div class="table-out">
        <div>
            <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30" style="width: 100%;white-space: nowrap;">
                <thead>
                <tr>
                <th rowspan="2" style="padding:0 20px;">行次</th>
	            <th rowspan="2">地区</th>
	            <th rowspan="2" style="padding:0 40px;">部门</th>
	            <th rowspan="2">检查人员</th> 
	            <th colspan="6">检查人员中</th>
	            <th rowspan="2">专家人员</th>
                </tr>
                <tr>
	            <th>公安消防管理</th>
	            <th>公安治安管理</th>
	            <th>公安禁毒管理</th>
	            <th>公安出入境管理</th>
	            <th>公安网络安全管理</th>
	            <th>公安交通安全管理</th>
                </tr>
                </thead>
                <tfoot>
	        <tr>
	            <th>合计</th>
	            <th>-</th>
	            <th>-</th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	        </tr> 
	        </tfoot>
            </table>
        </div>
    </div>
<script>
    window._CONFIG = {
       endCheckPushDate:'${endCheckPushDate}',
	    chooseUrl:'${sysUser.userType == 2 ? "/syn" : "/reg"}'
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/drcheck/scagent/scagent_syn_count.js"></script>
</body>
</html>
