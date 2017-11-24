<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<meta charset="utf-8">
<title>企业年报多年度综合查询</title>
<link rel="stylesheet" href="/css/reg.server.css">
<link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
<link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
	<div class="tabbale" data-component="tab">
		<form id="taskForm" class="form-box mb5">
			<div class="form-list pdr8">
				<div class="form-item clearfix">
					<div class="col-4">
						<label class="item-name col-5">年报主体：</label>
						<div class="col-7">
							<div class="ipt-box col-12">
								<input type="hidden" name="entTypeCatg" id="entTypeCatg"> <input type="checkbox" name="entCatg" checked="checked" value="11,13,31,33,12,14,32,34,21,27,24,22,28">企业 <input type="checkbox" name="entCatg" value="16,17">农专社 <input type="checkbox" name="entCatg" value="50">个体户
							</div>
						</div>
					</div>
					<input type="hidden" name="type" id="type"> <input type="hidden" name="regState" id="regState">
					<div class="col-4">
						<label class="item-name col-5">统一信用代码/注册号：</label>
						<div class="col-7">
							<div class="ipt-box col-12">
								<input type="text" class="ipt-txt" name="cidRegNO" value="" placeholder="可输入尾号后4位查询">
							</div>
						</div>
					</div>
					<div class="col-4">
						<label class="item-name col-5">法定代表人/负责人：</label>
						<div class="col-7">
							<div class="ipt-box col-11">
								<input type="text" class="ipt-txt" name="leRep" value="" />
							</div>
						</div>
					</div>
				</div>
				<div class="form-item clearfix">
					<div class="col-4">
						<label class="item-name col-5">企业类型：</label>
						<div class="col-7">
							<div class="ipt-box col-11">
								<input type="hidden" class="ipt-txt" name="entType" id="entType" value="" /> <input type="text" readonly="readonly" class="ipt-txt" id="entTypeName" value="" /> <span class="add-icon" id="chooseEntType"> <i></i>
								</span>
							</div>
						</div>
					</div>
					<div class="col-4">
						<label class="item-name col-5">企业名称：</label>
						<div class="col-7">
							<div class="ipt-box col-12">
								<input type="text" class="ipt-txt" name="entName" value="" placeholder="可输入名称关键词查询" />
							</div>
						</div>
					</div>
					<div class="col-4">
						<label class="item-name col-5">登记机关：</label>
						<div class="col-7">
							<div class="ipt-box col-11">
								<input type="hidden" class="ipt-txt" name="regOrg" id="regOrg" value="" /> <input type="text" readonly="readonly" class="ipt-txt" id="regOrgName" value="" /> <span class="add-icon" id="choseorgReg"> <i></i>
								</span>
							</div>
						</div>
					</div>

				</div>
				<div class="form-item clearfix">
					<div class="col-4">
						<label class="item-name col-5">年度年报与状态：</label>
						<div class="col-7">
							<div class="ipt-box col-11">
								<input type="hidden" class="ipt-txt" name="yearMode" id="yearMode" value="" /> <input type="text" readonly="readonly" class="ipt-txt" id="yearModeName" value="" /> <span class="add-icon" id="chooseYearMode"> <i></i>
								</span>
							</div>
						</div>
					</div>
					<div class="col-4">
						<label class="item-name col-5">成立日期：</label>
						<div class="col-7">
							<div class="ipt-box col-575">
								<input type="text" class="ipt-txt laydate-icon" style="cursor: pointer;" onclick="laydate()" readonly="readonly" name="estDateStart" value="" />
							</div>
							<span class="item-line col-05">-</span>
							<div class="ipt-box col-575">
								<input type="text" class="ipt-txt laydate-icon" style="cursor: pointer;" onclick="laydate()" readonly="readonly" name="estDateEnd" value="" />
							</div>
						</div>
					</div>
					<div class="col-4">
						<label class="item-name col-5">管辖单位：</label>
						<div class="col-7">
							<div class="ipt-box col-11">
								<input type="hidden" class="ipt-txt" name="localAdm" id="localAdm" value="" /> <input type="text" readonly="readonly" class="ipt-txt" id="localAdmName" value="" /> <span class="add-icon" id="choseregUnit"> <i></i>
								</span>
							</div>
						</div>
					</div>
				</div>
				<div id="hideorshow" style="display: none">
					<div class="form-item clearfix">
						<div class="col-4">
							<label class="item-name col-5">企业联络员：</label>
							<div class="col-7">
								<div class="ipt-box col-11">
									<input type="text" name="liaName" class="ipt-txt" value="" />
								</div>
							</div>
						</div>
						<div class="col-4">
							<label class="item-name col-5"><span class="long-label">个转企：</span></label>
							<div class="col-7">
								<div class="ipt-box col-12">
									<select name="isIndivid" id="isIndivid">
										<option value="">全部</option>
										<option value="1">是</option>
										<option value="0">否</option>
									</select>
								</div>
							</div>
						</div>
						<div class="col-4">
							<label class="item-name col-5">片区：</label>
							<div class="col-7">
								<div class="ipt-box col-11">
									<input type="hidden" class="ipt-txt" name="sliceNO" id="sliceNo" value="" /> <input type="text" readonly="readonly" class="ipt-txt" id="sliceNoName" value="" /> <span class="add-icon" id="chooseSliceNo"> <i></i>
									</span>
								</div>
							</div>
						</div>
					</div>
					<div class="form-item clearfix">
						<div class="col-4">
							<label class="item-name col-5">经营范围：</label>
							<div class="col-7">
								<div class="ipt-box col-11">
									<input type="text" class="ipt-txt" name="opScope" value="" placeholder="可输入关键词查询" />
								</div>
							</div>
						</div>
						<div class="col-4">
							<label class="item-name col-5">住所：</label>
							<div class="col-7">
								<div class="ipt-box col-12">
									<input type="text" class="ipt-txt" name="dom" value="" placeholder="可输入关键词查询" />
								</div>
							</div>
						</div>
						<div class="col-4">
							<label class="item-name col-5">联系电话：</label>
							<div class="col-7">
								<div class="ipt-box col-11">
									<input type="text" class="ipt-txt" name="tel" value="" />
								</div>
							</div>
						</div>
					</div>
					<div class="form-item clearfix">
						<div class="col-4">
							<label class="item-name col-5"><span class="long-label">列入经营异常：</span></label>
							<div class="col-7">
								<div class="ipt-box col-11">
									<select id="isOpan" name="isOpan">
										<option value="">全部</option>
										<option value="Y">是</option>
										<option value="N">否</option>
									</select>
								</div>
							</div>
						</div>
						<div class="col-4">
							<label class="item-name col-5">注册资本：</label>
							<div class="col-7">
								<div class="ipt-box col-575">
									<input type="text" class="ipt-txt" id="regCapStart" name="regCapStart" value="" placeholder="单位(万元)" />
								</div>
								<span class="item-line col-05">-</span>
								<div class="ipt-box col-575">
									<input type="text" class="ipt-txt" id="regCapEnd" name="regCapEnd" value="" placeholder="单位(万元)" />
								</div>
							</div>
						</div>
						<div class="col-4">
							<label class="item-name col-5">行业：</label>
							<div class="col-7">
								<div class="ipt-box col-11">
									<input type="hidden" class="ipt-txt" name="industryCo" id="industryCo" value="" /> <input type="text" readonly="readonly" class="ipt-txt" id="industryCoName" value="" /> <span class="add-icon" id="choseindustry"> <i></i>
									</span>
								</div>
							</div>
						</div>
					</div>
					<div class="form-item clearfix">
						<div class="col-4">
							<label class="item-name col-5">登记状态：</label>
							<div class="col-7">
								<div class="ipt-box col-11">
									<select name="regStateM" id="regStateM" multiple="multiple">
										<option value='K,B,A,DA,X' selected="selected">存续</option>
										<option value='C'>撤销</option>
										<option value='D'>吊销</option>
										<option value='Q'>迁出</option>
										<option value='XX,DX'>注销</option>
									</select>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="center mt10">
				<input type="button" id="js-search" value="查询" class="btn mr20"> <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20"> <input type="button" id="more" value="更多查询条件" class="btn mr20">
			</div>
		</form>
	</div>
	<div class="light-info">
		<span class="light">提示：此处仅提供同时复选近4个年度内的年报名单查询 &nbsp;&nbsp; <img src='/img/reg/server/year-status3.png' width='15' height='15' /> 表示被列入严违名单或异常名录企业
		</span>
	</div>
	<div class="tab-content mb20 mt10">
		<div class="tab-panel tab-panel-show">
			<div class="">
				<div class="clearfix mb5 mt5">
					<p class="fl">
						<input type='checkbox' id='checkAllEnt'>选择所有企业&nbsp;&nbsp;<input id="btn_add" type="button" class="btn btn-sm mr5 js-batchregist" value="设置消息内容"> <input id="btn_back" type="button" class="btn btn-sm mr5 js-batchregist" value="返回">
					</p>
				</div>

				<div class="table-out">
					<table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row display nowrap">
						<thead>
							<tr>
								<th>序号</th>
								<th width="4%">全选<input type='checkbox' id='checkAll'></th>
								<th>警示</th>
								<th>统一代码/注册号</th>
								<th>企业名称</th>
								<th>成立日期</th>
								<th>法定代表人/负责人</th>
								<th>负责人电话</th>
								<th>企业联络员</th>
								<th>联络员电话</th>
								<th>注册资本(万元)</th>
								<th>企业类型</th>
								<th>行业</th>
								<th>住所地</th>
								<th>登记机关</th>
								<th>管辖单位</th>
								<th>片区/商圈</th>
								<th>登记状态</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script src="/js/lib/require.js"></script>
	<script src="/js/config.js"></script>
	<script src="/js/reg/server/message/message_entlist.js"></script>
	</div>
</body>
</html>
