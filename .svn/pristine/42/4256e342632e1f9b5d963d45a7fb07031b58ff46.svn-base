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
<link rel="stylesheet"
	href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
	<div class="tabbale" data-component="tab">
		<form id="taskForm" class="form-box mb5">
			<div class="form-list pdr8">
				<div class="form-item clearfix">
					<div class="col-5">
						<label class="item-name col-3">检查主体：</label>
						<div class="col-8">
							<div class="ipt-box col-12">
								<input type="checkbox" name="entTypeCode" value="11,13,31,33,12,14,32,34,21,27,24,22,28" checked="checked">企业 
								<input type="checkbox" name="entTypeCode" value="16,17" checked="checked">农专社
								<input type="checkbox" name="entTypeCode" value="50" checked="checked">个体户 
								<input type="checkbox" name="entTypeCode" value="23" checked="checked">外企代表机构 
								<input type="hidden" name="entType" id="entType" value="11,13,31,33,12,14,32,34,21,27,24,22,28,16,17,50,23">
							</div>
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
				<div class="form-item clearfix">
	                <div class="col-8">
	                <label class="item-name col-2">统计截止日期：</label>
	                <div class="col-9">
	                      <div class="ipt-box col-4">
	                        <div class="ipt-box col-575">
	                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly"  
	                              name="setTimeEnd" id="setTimeEnd" value="${endCheckPushDate }" />
	                        </div>
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
	<div class="table-out">
		<div>
			<table id="user-table" border="0" cellspacing="0" cellpadding="0"
				class="table-row perc-100  mt30 nowrap" style="width: 100%;">
				<thead>
					<tr>
						<th>行次</th>
						<th>地区</th>
						<th>部门</th>
						<th>直销<br/>企业<br/>(户)</th>
						<th>拍卖活动<br/>经营主体<br/>(户)</th>
						<th>文物经<br/>营单位<br/>(户)</th>
						<th>广告经<br/>营单位<br/>(户)</th>
						<th>商标代<br/>理机构<br/>(户)</th>
						<th>特殊标志<br/>使用企业<br/>(户)</th>
						<th>食品生<br/>产企业<br/>(户)</th>
						<th>食品添加<br/>剂企业<br/>(户)</th>
						<th>保健食品<br/>生产企业<br/>(户)</th>
						<th>食品流<br/>通企业<br/>(户)</th>
						<th>餐饮<br/>企业<br/>(户)</th>
						<th>化妆品生<br/>产企业<br/>(户)</th>
						<th>药品经<br/>营企业<br/>(户)</th>
						<th>医疗<br/>机构<br/>(户)</th>
						<th>医疗器械<br/>经营企业<br/>(户)</th>
						<th>计量器具<br/>生产企业<br/>(户)</th>
						<th>用能产品生<br/>产销售单位<br/>(户)</th>
						<th>定量包装<br/>商品生产<br/>销售单位<br/>(户)</th>
						<th>强制检定<br/>计量器具<br/>使用单位<br/>(户)</th>
						<th>计量标准、<br/>技术机构<br/>(户)</th>
						<th>检验检<br/>测机构<br/>(户)</th>
						<th>自愿性<br/>认证获<br/>证组织<br/>(户)</th>
						<th>特种设备<br/>生产单位<br/>(户)</th>
						<th>特种设备检<br/>验检测单位<br/>(户)</th>
						<th>特种设<br/>备经营<br/>（出租<br/>）单位<br/>(户)</th>
						<th>特种设备<br/>使用单位<br/>(户)</th>
						<th>重要工业<br/>产品生产<br/>许可证企业<br/>(户)</th>
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
			year : '${year}',
			deptCode : '${deptCode}',
			endCheckPushDate : '${endCheckPushDate}',
			month : '${month}',
			isAdmin : '${sysUser.isAdmin}',
			searchRangeLevel : '${sysUser.searchRangeLevel}',
		    chooseUrl:'${sysUser.userType == 2 ? "/syn" : "/reg"}'
		}
	</script>
	<script src="/js/lib/require.js"></script>
	<script src="/js/config.js"></script>
	<script src="/js/syn/system/drcheck/scspecial/scspecial_count.js"></script>
</body>
</html>
