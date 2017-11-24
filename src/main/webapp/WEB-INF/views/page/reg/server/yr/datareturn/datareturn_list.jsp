<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="renderer" content="webkit">
	<meta charset="utf-8">
	<title>全景查询</title>
	<link rel="stylesheet" href="/css/syn.css">
	<link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
	<link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
</head>
<body class="pd10">
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
					<label class="item-name col-5">企业名称：</label>
					<div class="col-6">
						<div class="ipt-box col-12">
							<input type="text" class="ipt-txt clx" name="entName">
						</div>
					</div>
				</div>
				<!-- <div class="col-4">
					<label class="item-name col-3">法定代表人：</label>
					<div class="col-8">
						<div class="ipt-box col-12">
							<input type="text" class="ipt-txt clx" name="leRep">
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
			<div class="form-item clearfix">
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
                                    <option value="A,B,K,DA">存续</option>
                                    <option value="X,XX,DX">注销</option>
                                    <option value="C">撤销</option>
									<option value="D">吊销</option>
									<option value="Q">迁出</option>
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
						<label class="item-name col-5">法人是否受限：</label>
						<div class="col-6">
							<div class="ipt-box col-12">
								<select name="leRepIsLim" class="clx">
									<option value="">暂无数据</option>
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
				</div> -->
				
			</div>
			<div class="form-item clearfix">
				<div class="btn-box mt10">
					<input type="button" value="查 询" class="btn mr20" id="search"> <input
						type="button" value="重 置" class="btn mr20" id="reset"> <!-- <input
						type="button" value="更多查询" class="btn mr20 js-more-query"> -->
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
			    <th>操作</th>
				<th >企业名称</th>
				<th >统一信用代码</th>
				<th >注册号</th>
				<th >登记状态</th>
				<th >核准日期</th>
				<th >成立日期</th>
				<th >注册资本（万元）</th>
				<th >法定代表人</th>
				<th >企业类型</th>
				<th >行业</th>
				<th >登记机关</th>
				<th >管辖单位</th>
			</tr>
			</thead>
		</table>
	</div>
	<script src="/js/lib/laydate/laydate.js"></script>
	<script src="/js/lib/require.js"></script>
	<script src="/js/config.js"></script>
	<script src="/js/reg/server/yr/datareturn/datareturn_list.js"></script>
</body>
</html>