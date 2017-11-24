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
                                <c:if test="${sysUser.isAdmin == 1 || sysUser.isAdmin == 2 || sysUser.searchRangeLevel == 4 }"><option value="area">按地区</option></c:if>
                                <c:if test="${sysUser.isAdmin == 1 || sysUser.isAdmin == 2 || sysUser.searchRangeLevel != 1 }"><option value="regOrg">按登记机关</option></c:if>
                                <option value="localAdm">按管辖单位</option>
                            </select>
							</div>
						</div>
					</div>
					<div class="col-4">
						<label class="item-name col-5">统计范围：</label>
						<div class="col-7">
							<div class="ipt-box col-9">
                                <select name="statArea" id="statArea" multiple="multiple">
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
	            <th colspan="5">检查人员中</th>
	            <th rowspan="2">专家人员</th>
	            <th colspan="5">专家人员中</th>
                </tr>
                <tr>
	            <th>工商行政管理类</th>
	            <th>食品药品管理类</th>
	            <th>质量技术监督类</th>
	            <th>安全生产类</th>
	            <th>物价管理类</th>
	            <th>保化组长</th>
	            <th>药品GSP</th>
	            <th>药品GMP</th>
	            <th>医疗器械GSP</th>
	            <th>医疗器械GMP</th>
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
       year:'${year}',
       deptCode:'${deptCode}',
       endCheckPushDate:'${endCheckPushDate}',
       month:'${month}',
       _searchRangeLevel:'${sysUser.searchRangeLevel}',
       _isAdmin:'${sysUser.isAdmin}',
	    chooseUrl:'${sysUser.userType == 2 ? "/syn" : "/reg"}'
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/drcheck/scspecial/zfperson_count.js"></script>
</body>
</html>
