<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
<link rel="stylesheet" href="/css/sment/sment.server.css">

<title>加入培育库详细</title>
</head>
<body>
	<div class="pd20">
		<form id="webForm">
			<input  type="hidden" id="priPID" name="priPID" value=""/>
			<input  type="hidden" id="year" name="year" value=""/>
			<div class="form-list">
				<div class="form-item clearfix">
					<label class="item-name col-3"><span class="light">*</span>需求类型：</label>
					<div class="col-6">
						<div class="ipt-box">
								<input type="text"   id="helpTypeName" name="helpTypeName"  class="ipt-txt clx"  readonly/>
			                    <input type="hidden" id="helpTypeCode" name="helpTypeCode" class="clx"  />
				                 <a id="a_entarchivesHelpList" class="link " data-index="{{tableNum @index}}">
			                  		<span class="add-icon" ><i></i></span>
			                	 </a>
						</div>
					</div>
				</div>
				<div class="form-item clearfix">
					<label class="item-name col-3">需求内容：</label>
					<div class="col-6">
						<div class="ipt-box">
							<input id="helpText"  name="helpText"  class="ipt-txt">
						</div>
					</div>
				</div>
				<div class="form-item clearfix">
					<label class="item-name col-3">帮扶时间：</label>
					<div class="col-6">
						<div class="ipt-box">
							<input id="helpTime"  name="helpTime"  class="ipt-txt" onclick="laydate();" readonly="readonly">
						</div>
					</div>
				</div>
				<div class="form-item clearfix">
					<label class="item-name col-3">服务内容：</label>
					<div class="col-6">
						<div class="ipt-box">
							<input id="helpContent"  name="helpContent"  class="ipt-txt">
						</div>
					</div>
				</div>


				<div class="form-item clearfix">
					<div class="btn-box">
						<input id="save" type="button" value="保 存" class="btn mr20"> <input id="cancel" type="button" value="取 消" class="btn">
					</div>
				</div>
			</div>
		</form>
	</div>
	<script src="/js/lib/laydate/laydate.js"></script>
	<script src="/js/lib/require.js"></script>
	<script src="/js/config.js"></script>
	<script src="/js/sment/entarchives/entarchives_help_edit.js"></script>
</body>
</html>