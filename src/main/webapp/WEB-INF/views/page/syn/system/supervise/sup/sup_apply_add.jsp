<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="renderer" content="webkit">
	<meta charset="utf-8">
	<title>重点监管标识信息</title>
	<link rel="stylesheet" href="/css/syn.css">
	<link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
	<link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
</head>
<body class="pd10">
	<h6 class="h6-title mt10 mb5 light-yellow">第一步：请选择企业添加至下方表单（支持多次选择）</h6>
	<div class="form-box mb5">
		<div class="form-list">
		  <form id="entSearchForm">
			<div class="form-item clearfix">
				<div class="col-4">
					<label class="item-name col-6">统一信用代码/注册号：</label>
					<div class="col-6">
						<div class="ipt-box col-12">
							<input type="text" class="ipt-txt clx" name="cidRegNO">
						</div>
					</div>
				</div>
				<div class="col-4">
					<label class="item-name col-5">法定代表人：</label>
					<div class="col-6">
						<div class="ipt-box col-12">
							<input type="text" class="ipt-txt clx" name="leRep">
						</div>
					</div>
				</div>
				<div class="col-4">
					<label class="item-name col-3">企业名称：</label>
					<div class="col-8">
						<div class="ipt-box col-12">
							<input type="text" class="ipt-txt clx" name="entName">
						</div>
					</div>
				</div>
			</div>
			<div class="form-item clearfix">
				<div class="col-4">
					<label class="item-name col-6">行业：</label>
					<div class="col-6">
						<div class="ipt-box col-12">
			                 <input type="text"  id="industryName"  class="ipt-txt clx" value="" readonly/>
			                 <input type="hidden" id="industryCo" name="industryCo" class="clx" value="" />
				                 <a id="selectIndustry" class="link js-show">
			                  <span class="add-icon" id="yccodetree"><i></i></span>
			                 </a>
	            		</div>
					</div>
				</div>
				<div class="col-4">
					<label class="item-name col-5"> 企业类型：</label>
					<div class="col-6">
						<div class="ipt-box col-12">
			                 <input type="text"  id="entTypeName"  class="ipt-txt clx" value="" readonly/>
			                 <input type="hidden" id="entType" name="entType" class="clx" value="" />
				                 <a id="selectEntType" class="link js-show">
			                  <span class="add-icon" id="yccodetree"><i></i></span>
			                 </a>
	            		</div>
					</div>
				</div>
				<div class="col-4">
					<label class="item-name col-3"> 住所：</label>
					<div class="col-8">
						<div class="ipt-box col-12">
							<input type="text" class="ipt-txt clx" name="dom">
						</div>
					</div>
				</div>
			</div>
			<div class="form-item clearfix mb10">
				<div class="col-4">
					<label class="item-name col-6">管辖单位：</label>
					<div class="col-6">
						<div class="ipt-box col-12">
			                 <input type="text"  id="localAdmName"  class="ipt-txt clx" value="" readonly/>
			                 <input type="hidden" id="localAdm" name="localAdm" class="clx" value="" />
				                 <a id="selectLocalAdm" class="link js-show">
			                  <span class="add-icon" id="yccodetree"><i></i></span>
			                 </a>
	            		</div>
					</div>
				</div>
				<div class="col-4">
					<label class="item-name col-5">登记机关：</label>
					<div class="col-6">
						<div class="ipt-box col-12">
			                 <input type="text"  id="regOrgName"  class="ipt-txt clx" value="" readonly/>
			                 <input type="hidden" id="regOrg" name="regOrg" class="clx" value="" />
				                 <a id="selectRegOrg" class="link js-show">
			                  <span class="add-icon" id="yccodetree"><i></i></span>
			                 </a>
	            		</div>
					</div>
				</div>
				<div class="col-4">
					<label class="item-name col-3">经营范围：</label>
					<div class="col-8">
						<div class="ipt-box col-12">
							<input type="text" class="ipt-txt clx" name="opScope">
						</div>
					</div>
				</div>
			</div>
			<div class="more-show " style="display:none;">
				<div class="form-item clearfix">
					<div class="col-4">
						<label class="item-name col-6">登记状态：</label>
						<div class="col-6">
							<div class="ipt-box col-12">
								<select name="regState" class="clx">
									<option value="">请选择</option>
									<c:forEach var="regState" items="${regStateEnumMap}">
                                	<option value='${regState.value.code}'>${regState.value.name}</option>
                            		</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="col-4">
						<label class="item-name col-5">是否进入异常名录：</label>
						<div class="col-6">
							<div class="ipt-box col-12">
								<select name="isOpan" class="clx">
									<option value="">请选择</option>
									<option value="Y">是</option>
									<option value="N">否</option>
								</select>
							</div>
						</div>
					</div>
					<div class="col-4">
						<label class="item-name col-3">核准日期：</label>
						<div class="col-8">
							<div class="ipt-box col-5">
		                        <input type="text" class="ipt-txt clx" readonly="readonly" onclick="laydate();" name="apprDateStart">
		                    </div>
		                    <span class="item-txt col-2"><i class="line-icon"></i></span>
		                    <div class="ipt-box col-5">
		                        <input type="text" class="ipt-txt clx" readonly="readonly" onclick="laydate();" name="apprDateEnd">
		                    </div>
						</div>
					</div>
				</div>
				<div class="form-item clearfix">
					<div class="col-4">
						<label class="item-name col-6">许可证名称：</label>
						<div class="col-6">
							<div class="ipt-box col-12">
								<input type="text" class="ipt-txt clx" name="licNameAft">
							</div>
						</div>
					</div>
					
					<div class="col-4">
						<label class="item-name col-5">是否有风险预警：</label>
						<div class="col-6">
							<div class="ipt-box col-12">
								<select name="isRiskWarn clx">
									<option value="">请选择</option>
									<option value="Y">是</option>
									<option value="N">否</option>
								</select>
							</div>
						</div>
					</div>
					<div class="col-4">
						<label class="item-name col-3"> 注册资本：</label>
						<div class="col-8">
							<div class="ipt-box col-12">
								<div class="ipt-box col-5">
		                        	<input type="text" class="ipt-txt clx" name="regCapStart" placeholder="单位(万元)" >
			                    </div>
			                    <span class="item-txt col-2"><i class="line-icon"></i></span>
			                    <div class="ipt-box col-5">
			                        <input type="text" class="ipt-txt clx"  name="regCapEnd" placeholder="单位(万元)">
			                    </div>
							</div>
						</div>
					</div>
				</div>
				<div class="form-item clearfix">
					<div class="col-4">
						<label class="item-name col-6">信用等级：</label>
						<div class="col-6">
							<div class="ipt-box col-12">
								<select name="" class="clx">
									<option value="">暂无数据</option>
								</select>
							</div>
						</div>
					</div>
					<div class="col-4">
						<label class="item-name col-5">是否有行政处罚：</label>
						<div class="col-6">
							<div class="ipt-box col-12">
								<select name="isCase" class="clx">
									<option value="">请选择</option>
									<option value="Y">是</option>
									<option value="N">否</option>
								</select>
							</div>
						</div>
					</div>
					<div class="col-4">
						<label class="item-name col-3">成立日期：</label>
						<div class="col-8">
							<div class="ipt-box col-5">
								<input type="text" class="ipt-txt clx" readonly="readonly" onclick="laydate();" name="estDateStart">
							</div>
							<span class="item-txt col-2"><i class="line-icon"></i></span>
							<div class="ipt-box col-5">
								<input type="text" class="ipt-txt clx" readonly="readonly" onclick="laydate();" name="estDateEnd">
							</div>
						</div>
					</div>
				</div>
				
				<div class="form-item clearfix mb10">
				
					<div class="col-4">
						<label class="item-name col-6">法人是否受限：</label>
						<div class="col-6">
							<div class="ipt-box col-12">
								<select name="leRepIsLim" class="clx">
									<option value="">暂无数据</option>
								</select>
							</div>
						</div>
					</div>
				
					<div class="col-4">
						<label class="item-name col-5">是否为关注服务对象：</label>
						<div class="col-6">
							<div class="ipt-box col-12">
								<select name="isFocusObj" class="clx">
									<option value="">请选择</option>
									<option value="Y">是</option>
									<option value="N">否</option>
								</select>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-item clearfix">
				<div class="btn-box">
					<input type="button" value="查 询" class="btn mr20" id="search"> <input
						type="button" id="reset" value="重 置" class="btn mr20"> <input
						type="button" value="更多查询" class="btn mr20 js-more-query">
				</div>
			</div>
			</form>
		</div>
	</div>
	<div>
		<table id="search-table" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100  mt30 nowrap" style="width:100%;">
			<thead >
			<tr>
				<th style="padding: 0 20px;">序号</th>
				<th ><input type="checkbox" class="chbAll">选择 </th>
				<th >企业名称</th>
				<th >统一信用代码</th>
				<th >注册号</th>
				<th >法定代表人</th>
				<th >企业类型</th>
				<th >行业</th>
				<th >登记机关</th>
				<th >管辖单位</th>
				<th >历史监管记录</th>
			</tr>
			</thead>
		</table>
		<div class="btn-box"><input type="button" id="getData" class="btn btn-sm mr5" value="确定添加选中企业"></div>
	</div>
	<h6 class="h6-title mt20 mb5 light-yellow">第二步：添加重点监管对象标识</h6>
	<div class="clearfix mb5">
		<p class="fl">
			<input type="button" class="btn btn-sm mr5" id="goback" value="返回"><input
				type="button" class="btn btn-sm" id = "enaddmark" value="添加重点监管对象标识"><span
				class="ml20">您已经选中了<span id="entNum"></span> 家企业 </span>
		</p>
	</div>
	<div style="padding-bottom: 50px;">
		<table  border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 mt30" style="width: 100%;">
			<thead>
				<tr style="white-space: nowrap;">
					<th >操作</th>
					<th >企业名称</th>
					<th >统一信用代码</th>
					<th >注册号</th>
					<th >企业类型</th>
					<th >行业</th>
					<th >登记机关</th>
					<th >管辖单位</th>
				</tr>
			</thead>
			<tbody id="enttbody">
			</tbody>
		</table>
	</div>
	<script src="/js/lib/laydate/laydate.js"></script>
	<script src="/js/lib/require.js"></script>
	<script src="/js/config.js"></script>
	<script src="/js/syn/system/supervise/sup/sup_apply_add.js"></script>
</body>
</html>