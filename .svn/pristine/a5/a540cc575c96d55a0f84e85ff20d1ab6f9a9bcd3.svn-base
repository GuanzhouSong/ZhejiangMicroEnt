<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<meta charset="utf-8">
<title>规上企业导入</title>
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
						<label class="item-name col-6">统一信用代码（源）：</label>
						<div class="col-6">
							<div class="ipt-box col-12">
								<input type="text" class="ipt-txt clx" name="uniCode" placeholder="可输入尾号后4位查询">
							</div>
						</div>
					</div>
					<div class="col-4">
						<label class="item-name col-5">企业名称（源）：</label>
						<div class="col-6">
							<div class="ipt-box col-12">
								<input type="text" class="ipt-txt clx" name="entName" placeholder="可输入名称关键词查询">
							</div>
						</div>
					</div>
					<div class="col-4">
						<label class="item-name col-5">导入批次：</label>
						<div class="col-6">
							<div class="ipt-box col-12">
								<input type="text" class="ipt-txt clx" name="imBatchNum" placeholder="可输入批次关键词查询">
							</div>
						</div>
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
					<a href="/sment/smEntAbovescale/downExcelTemplate"><b class="download-ico"></b>下载本站EXCEL模版</a>
				</h6>
				<div class="state pos-rel">
					<span>说明：</span>
					<p>1、导入数据时请先下载EXCEL导入模版；</p>
					<p>2、下载导入模板后请按照导入模板格式和内容要求完成导入信息的填录；</p>
					<p>3、使用非本系统提供的导入模板或擅自修改导入模板的格式和内容会导致操作不成功。</p>
				</div>
				<div class="lead-file">
					<form class="form-horizontal" id="file_import" enctype="multipart/form-data" method="post">
						<table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
						<tr>
						<td width="10%" class="right">
						<label>导入EXCEL文件</label>
						</td>
						<td colspan="3">
						<div class="ipt-box col-12">
						</div>
							<input type="file" id="js-file" name="file" class="ipt-txt ipt-txt-lg">
						</td>
						</tr>
						<tr>
						<td class="right">
							<label>导入年份</label>
						</td>
						<td width="40%">
							<div class="ipt-box">
						     <select name="year" class="ipt-txt">
						      <option value="2016">2016</option>
						      <option value="2017">2017</option>
						      </select>
						    </div>
						</td>
<!-- 						<td width="10%" class="right"> -->
<!-- 							<label>导入批次</label> -->
<!-- 						</td> -->
<!-- 						<td class="right"> -->
<!-- 							<div class="ipt-box"> -->
<!-- 							  <input type="text" name="imBatchNum" class="ipt-txt"/> -->
<!-- 						    </div> -->
<!-- 						</td> -->
						</tr>
						</table>
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
					<th>序号</th>
					<th>操作</th>
					<th>组织机构代码</th>
					<th>企业名称（源）</th>
					<th>统一信用代码（源）</th>
					<th>报表类别编码</th>
					<th>报表类别中文</th>
					<th>限上、规上标志</th>
					<th>年度</th>
					<th>导入批次</th>
					<th>是否匹配</th>
					<th>匹配后企业名称 </th>
					<th>匹配后统一社会信用代码</th>
					<th>匹配后注册号</th>
					<th>导入人姓名</th>
					<th>导入时间</th>
				</tr>
			</thead>
		</table>
	</div>
	<script src="/js/lib/laydate/laydate.js"></script>
	<script src="/js/lib/require.js"></script>
	<script src="/js/config.js"></script>
	<script src="/js/sment/smentabovescale/smentabovescale_list.js"></script>
</body>
</html>