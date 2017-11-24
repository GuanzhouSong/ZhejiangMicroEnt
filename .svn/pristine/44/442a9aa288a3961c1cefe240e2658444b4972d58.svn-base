<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
								<input type="text" class="ipt-txt clx" name="regNO" placeholder="可输入尾号后4位查询">
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
						<label class="item-name col-7"></label>
						<div class="col-12"></div>
					</div>
				</div>

				<div class="form-item clearfix">
					<div class="btn-box mt10">
						<input type="button" value="查 询" class="btn mr20" id="search"> <input type="button" id="cancle" onclick="$('#entSearchForm')[0].reset();" value="重置" class="btn mr20">
					</div>
				</div>
			</form>
		</div>

		<div class="mod-border investment-info js-content-show js-upload mt10" id="loadFile">
			<div class="forguarantee-lead">
				<h6 class="download" style="text-align: left;">
					<a href="/reg/server/creditprovelist/downLoadEnt"><b class="download-ico"></b>下载本站EXCEL模版</a>
				</h6>
				<div class="state pos-rel">
					<span>说明：</span>
					<p>1、导入数据时请先下载EXCEL导入模版；</p>
					<p>2、下载导入模板后请按照导入模板格式和内容要求完成导入信息的填录；</p>
					<p>3、使用非本系统提供的导入模板或擅自修改导入模板的格式和内容会导致操作不成功。</p>
				</div>
				<div class="lead-file">
					<label>导入EXCEL文件</label>
					<form id="file_import" enctype="multipart/form-data" method="post">
						<div class="ipt-box">
							<input type="file" id="js-file" name="file" class="ipt-txt ipt-txt-lg">
						</div>
						<input type="button" class="btn mt10 js-import" value="导入">
					</form>
				</div>
			</div>
		</div>

	</div>
	<div>
		<table id="search-table" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100  mt30 nowrap" style="width: 100%;">
			<thead>
				<tr>
					<th width="4%">序号</th>
					<th width="6%">操作</th>
					<th width="60%">企业名称</th>
					<th width="30%">统一信用代码/注册号</th>
				</tr>
			</thead>
		</table>
	</div>
	<script src="/js/lib/laydate/laydate.js"></script>
	<script src="/js/lib/require.js"></script>
	<script src="/js/config.js"></script>
	<script src="/js/sment/smbaseinfotemp/smbaseinfotemp_list.js"></script>
</body>
</html>