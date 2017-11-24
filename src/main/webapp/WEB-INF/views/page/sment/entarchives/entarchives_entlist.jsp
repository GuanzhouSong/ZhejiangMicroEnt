<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="renderer" content="webkit">
	<meta charset="utf-8">
	<title>全景查询</title>
	<link rel="stylesheet" href="/css/sment/sment.server.css">
	<link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
	<link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
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
							<input type="text" class="ipt-txt clx" name="cidRegNO" placeholder="可输入尾号后4位查询">
						</div>
					</div>
				</div>
				<div class="col-4">
					<label class="item-name col-5">企业名称：</label>
					<div class="col-6">
						<div class="ipt-box col-12">
							<input type="text" class="ipt-txt clx" name="entName" placeholder="可输入名称关键词查询">
						</div>
					</div>
				</div>
					<div class="col-4">
						<label class="item-name col-4">八大重点产业：</label>
						<div class="col-7">
							<div class="ipt-box col-12">
								<select name="industryType" id="industryType">
									<option value="">不限</option>
									<option value="1">信息经济产业</option>
									<option value="2">环保产业</option>
									<option value="3">旅游产业</option>
									<option value="4">金融产业</option>
									<option value="5">健康产业</option>
									<option value="6">时尚产业</option>
									<option value="7">高端装备制造产业</option>
									<option value="8">文化创意产业</option>
									<option value="0">全部</option>
								</select>
							</div>
						</div>
					</div>
				</div>
			<div class="form-item clearfix">
				<div class="col-4">
                    <label class="item-name col-6">企业类型：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                        	<input type="hidden" class="ipt-txt" name="entType" id="entType" value=""/>
                            <input type="text" readonly="readonly" class="ipt-txt" id="entTypeName" value="" />
	                         <span class="add-icon" id="chooseEntType">
                                <i></i>
	                         </span>
                        </div>
                    </div>
	             </div>
				<div class="col-4">
					<label class="item-name col-5">行业：</label>
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
					<label class="item-name col-4">登记机关：</label>
					<div class="col-7">
						<div class="ipt-box col-12">
			                 <input type="text"  id="regOrgName"  class="ipt-txt clx" value="" readonly/>
			                 <input type="hidden" id="regOrg" name="regOrg" class="clx" value="" />
				                 <a id="selectRegOrg" class="link js-show">
			                  <span class="add-icon" id="yccodetree"><i></i></span>
			                 </a>
	            		</div>
					</div>
				</div>
			</div>
			<div class="form-item clearfix">
				<div class="col-4">
					<label class="item-name col-6">注册资本：</label>
					<div class="col-6">
						<div class="ipt-box col-12">
							<div class="ipt-box col-5">
		                        	<input type="text" class="ipt-txt clx" name="regCapStart" id="regCapStart" placeholder="单位(万元)" >
			                    </div>
			                    <span class="item-txt col-2"><i class="line-icon"></i></span>
			                    <div class="ipt-box col-5">
			                        <input type="text" class="ipt-txt clx"  name="regCapEnd" id="regCapEnd" placeholder="单位(万元)">
			                    </div>
						</div>
					</div>
				</div>
				<div class="col-4">
						<label class="item-name col-5">成立日期：</label>
						<div class="col-6">
							<div class="ipt-box col-5">
								<input type="text" class="ipt-txt clx" readonly="readonly" onclick="laydate();" name="estDateStart">
							</div>
							<span class="item-txt col-2"><i class="line-icon"></i></span>
							<div class="ipt-box col-5">
								<input type="text" class="ipt-txt clx" readonly="readonly" onclick="laydate();" name="estDateEnd">
							</div>
						</div>
					</div>
				<div class="col-4">
					<label class="item-name col-4">管辖单位：</label>
					<div class="col-7">
						<div class="ipt-box col-12">
			                 <input type="text"  id="localAdmName"  class="ipt-txt clx" value="" readonly/>
			                 <input type="hidden" id="localAdm" name="localAdm" class="clx" value="" />
				                 <a id="selectLocalAdm" class="link js-show">
			                  <span class="add-icon" id="yccodetree"><i></i></span>
			                 </a>
	            		</div>
					</div>
				</div>
			</div>
			<div class="form-item clearfix">
				<div class="col-4">
					<label class="item-name col-6">年报年份：</label>
					<div class="col-6">
						<div class="ipt-box col-12">
                            <select name="year" id="year">
                            	<option value="">不限</option>
                            </select>
						</div>
					</div>
				</div>
				<div class="col-4">
						<label class="item-name col-5">营业收入：</label>
						<div class="col-6">
						
						<div class="ipt-box col-5">
		                        	<input type="text" class="ipt-txt clx" name="vendIncStart" id="vendIncStart" placeholder="单位(万元)" >
			                    </div>
			                    <span class="item-txt col-2"><i class="line-icon"></i></span>
			                    <div class="ipt-box col-5">
			                        <input type="text" class="ipt-txt clx"  name="vendIncEnd" id="vendIncEnd" placeholder="单位(万元)">
			                    </div>
			                    
						
						</div>
					</div>
				<div class="col-4">
					<label class="item-name col-4">从业人数：</label>
					<div class="col-7">
						<div class="ipt-box col-12">
			                	<div class="ipt-box col-5">
								<input type="text" class="ipt-txt clx" id="empNumStart"  name="empNumStart">
							</div>
							<span class="item-txt col-2"><i class="line-icon"></i></span>
							<div class="ipt-box col-5">
								<input type="text" class="ipt-txt clx" id="empNumEnd"  name="empNumEnd">
							</div>
	            		</div>
					</div>
				</div>
			</div>
			<div class="form-item clearfix">
				<div class="btn-box mt10">
					<input type="button" value="查 询" class="btn mr20" id="search"> 
					<input type="button" id="cancle" onclick="$('#entSearchForm')[0].reset();" value="重置" class="btn mr20">
				</div>
			</div>
			</form>
		</div>
	</div>
	    <div class="light-info mt5 mb5">
        <span class="light">提示：如果年报年份选择不限时，从业人数和营业收入为空。</span> 
    </div>
	
<!-- 	<div class="light-info">
    <span class="light">提示：当页全选，如果选择框选中2项及以上则为批量新增
    </span>
</div> -->
<!-- <div class="clearfix mb5 mt5">
    <p class="fl">
        <input id="btn_add" type="button" class="btn btn-sm mr5 js-batchregist" value="添加">
    </p>
</div> -->
	<div>
		<table id="search-table" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100  mt30 nowrap" style="width:100%;">
			<thead >
			<tr>
				<th style="padding: 0 20px;">序号</th>
				<th width="4%">操作</th>
				<th >统一信用代码/注册号</th>
				<th >企业名称</th>
				<th >行业</th>
				<th >成立日期</th>
				<th >企业类型</th>
				<th >注册资本（万元）</th>
				<th >登记机关</th>
				<th >管辖单位</th>
				<th >从业人数</th>
				<th >营业收入（万元）</th>
			</tr>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
			</thead>
		</table>
	</div>
	<script src="/js/lib/laydate/laydate.js"></script>
	<script src="/js/lib/require.js"></script>
	<script src="/js/config.js"></script>
	<script src="/js/sment/entarchives/entarchives_entlist.js"></script>
</body>
</html>