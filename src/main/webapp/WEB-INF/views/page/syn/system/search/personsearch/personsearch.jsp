<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<meta charset="utf-8">
<title>自然人综合信息</title>
<link rel="stylesheet" href="/css/reg.server.css">
<link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
<style type="text/css">

/*  .pagination span.current {
    color: #fff;
    background: #fff !important;
}

.pagination .active a {
    background: #d2aa64 !important;
    border: 1px solid #d2aa64 !important;
    color: #fff !important;
} */

.entName{
    text-decoration:underline;
    color:black;
}
.num-icon {
	width: 25px;
	
}
</style>
</head>
<body class="pd10">
	<div class="zr-person-box">
		<form id="search-form" class="form-box">
			<div class="form-list">
				<div class="form-item clearfix">
					<label for="" class="col-2"></label>
					<div class=" col-6 ">
						<div class="col-8 ipt-box pdr5">
							<input type="text" id="keyword" class="ipt-txt mr5" name="keyword" value="" placeholder="请输入姓名全称或完整身份证号码" >
						</div>
						<div class="col-2 pdr5">
							<div class="ipt-box col-12">
								<select name="sex">
									<option value="">性别</option>
									<option value="1">男</option>
									<option value="2">女</option>
								</select>
							</div>
						</div>
						<div class="col-2 pdr5">
							<div class="ipt-box col-12">
								<select id="type" name="type">
									<option value="">关系</option>
									<option value="1">法定代表人/负责人</option>
									<option value="2">股东</option>
									<option value="3">高管</option>
								</select>
							</div>
						</div>
						<%-- 	<div class="col-2 pdr5">
							<div class="ipt-box col-12">
								<select name="dictCode">
									<option value="33" ${deptCode =="3300" ? "selected='selected'" : "" } >浙江省</option>
									<option value="3301"  ${deptCode =="3301" ? "selected='selected'" : "" } >杭州市</option>
									<option value="3302"  ${deptCode =="3302" ? "selected='selected'" : "" } >宁波市</option>
									<option value="3303"  ${deptCode =="3303" ? "selected='selected'" : "" } >温州市</option>
									<option value="3304"  ${deptCode =="3304" ? "selected='selected'" : "" } >嘉兴市</option>
									<option value="3305"  ${deptCode =="3305" ? "selected='selected'" : "" } >湖州市</option>
									<option value="3306"  ${deptCode =="3306" ? "selected='selected'" : "" } >绍兴市</option>
									<option value="3307"  ${deptCode =="3307" ? "selected='selected'" : "" } >金华市</option>
									<option value="3308"  ${deptCode =="3308" ? "selected='selected'" : "" } >衢州市</option>
									<option value="3309"  ${deptCode =="3309" ? "selected='selected'" : "" } >舟山市</option>
									<option value="3310"  ${deptCode =="3310" ? "selected='selected'" : "" } >台州市</option>
									<option value="3325"  ${deptCode =="3325" ? "selected='selected'" : "" } >丽水市</option>
								</select>
							</div>
						</div> --%>
					</div>
					<div class="fl ml5">
						<input id="searchBtn" type="submit" value="查询" class="btn mr20">
					</div>
				</div>

			</div>

		</form>
	</div>
	<h4 id="h4_count" class="ps-title" style="display: none" >查询结果：共<span id="num" class="light"></span>人<span id="numText" style="display: none;">,只显示<span class="light">100</span>人以内的信息，请输入更精确的查询条件。</span></h4>
	<div class="tabbale" data-component="tab">
		<div class="tab-content" id="search-list"></div>
	</div>

	<!-- 搜索结果列表 start -->
	<script id="tpl_searchlist" type="text/x-handlebars-template">

</br>
{{#each this}}
	<div class="tab-panel tab-panel-show" >
				<div class="clearfix sel-title-box">
					<i class="fl  num-icon">{{tableNum @index}}</i> <span class="fl line-h30"><a href="javascript:;" id="{{cerNOAESE}}" class="entName light">{{name}}</a> {{sexFormat sex}} 身份证号：{{cerNOFormat cerNO}} </span> <strong class="red-light">{{isLimitFormat isLimit}}</strong>

				</div>
				<div class="clearfix sel-title-box">
					<i class="fl  flex-icon " id="divTable_{{cerNO}}_li"></i>
					<h6 class="add-title fl seled-title">
						当前投资/任职企业记录（<span id="page_num_{{cerNO}}"  class="light">0</span>）
					</h6>
					<h6 class="add-title fl">
						历史投资/任职企业记录（<span class="light">0</span>）
					</h6>

				</div>
				<div id="divTable_{{cerNO}}" >
				<table  border="0" cellspacing="0" cellpadding="0" class="table-row perc-100">
					<thead style="white-space: nowrap;">
						<tr>
							<th width="2%" class="center">序号</th>
							<th class="center">统一信用代码/注册号</th>
							<th class="center">所投资/企业名称</th>
							<th class="center">关系/职务</th>
							<th class="center">成立时间</th>
							<th class="center">登记机关</th>
							<th class="center">登记状态</th>
						</tr>
					</thead>
					<tbody id="table_{{cerNO}}"></tbody>
				</table>
				<br>
				<div class="notice-pagination-box clearfix">
                	<span class="page-total">共查询到  <em id="investmentCount_{{cerNO}}"></em> 条信息，共<em id="investmentPageCount_{{cerNO}}"></em>页</span>
                	<div id="{{cerNO}}" class="pagination">

                	</div>
            	</div>
				</div>
	{{eachFunction cerNO}}
</div>
</br>
{{/each}}
</script>
	<!-- 搜索结果列表 end -->



	<script src="/js/lib/require.js"></script>
	<script src="/js/config.js"></script>
	<script src="/js/syn/system/search/personsearch/personsearch.js"></script>
</body>
</html>