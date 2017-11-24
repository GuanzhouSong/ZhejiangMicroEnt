<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!doctype html>
<html lang="en">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="renderer" content="webkit">
	<meta charset="utf-8">
	<title>全景查询</title>
	<link rel="stylesheet" href="/css/reg.server.css">
	<link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
	<link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
	<div class="form-box mb5">
		<div class="form-list">
		  <form id="entSearchForm">
		  <input type="hidden" name="regState" id="regState">
			<div class="form-item clearfix">
				<div class="col-4">
                    <label class="item-name col-6">主体类别：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                        	<input type="hidden" name="entTypeCatg" id="entTypeCatg">
                            <input type="checkbox" name="entCatg" checked="checked" value="11,13,31,33,12,14,32,34,21,27,24,22,28">企业
                            <input type="checkbox" name="entCatg" value="16,17">农专社
                            <input type="checkbox" name="entCatg" value="50">个体户
                        </div>
                    </div>
                </div>
				<div class="col-4">
					<label class="item-name col-5">统一信用代码/注册号：</label>
					<div class="col-6">
						<div class="ipt-box col-12">
							<input type="text" class="ipt-txt clx" name="cidRegNO" placeholder="可输入尾号后4位查询">
						</div>
					</div>
				</div>
				<div class="col-4">
					<label class="item-name col-4">法定代表人/负责人：</label>
					<div class="col-7">
						<div class="ipt-box col-12">
							<input type="text" class="ipt-txt clx" name="leRep">
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
					<label class="item-name col-5">企业名称：</label>
					<div class="col-6">
						<div class="ipt-box col-12">
							<input type="text" class="ipt-txt clx" name="entName" placeholder="可输入名称关键词查询">
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
					<label class="item-name col-6">登记状态：</label>
					<div class="col-6">
						<div class="ipt-box col-12">
							<select name="regStateM" id="regStateM" multiple="multiple">
                                <c:forEach var="regState" items="${regStateEnumMap}">
                                	<option value='${regState.value.code}' title='${regState.value}' ${regState.value == 'CUNXU' ? 'selected':''}>${regState.value.name}</option>
                            	</c:forEach>
                            </select>
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
			<div class="more-show " style="display:none;">
				<div class="form-item clearfix">
					<div class="col-4">
	                    <label class="item-name col-6">年度年报与状态：</label>
	                    <div class="col-6">
	                        <div class="ipt-box col-12">
	                        	<input type="hidden" class="ipt-txt" name="yearMode" id="yearMode" value=""/>
	                            <input type="text" readonly="readonly" class="ipt-txt" id="yearModeName" value="" />
		                         <span class="add-icon" id="chooseYearMode">
	                                <i></i>
		                         </span>
	                        </div>
	                    </div>
	                </div>
	           		<div class="col-4">
						<label class="item-name col-5">经营期限：</label>
						<div class="col-6">
							<div class="ipt-box col-5">
								<input type="text" class="ipt-txt clx" readonly="readonly" onclick="laydate();" name="opFrom">
							</div>
							<span class="item-txt col-2"><i class="line-icon"></i></span>
							<div class="ipt-box col-5">
								<input type="text" class="ipt-txt clx" readonly="readonly" onclick="laydate();" name="opTo">
							</div>
						</div>
					</div>
					<div class="col-4">
	                    <label class="item-name col-4">片区/商圈：</label>
	                    <div class="col-7">
	                        <div class="ipt-box col-12">
	                            <input type="hidden" class="ipt-txt" name="sliceNO" id="sliceNo" value=""/>
	                            <input type="text" readonly="readonly" class="ipt-txt" id="sliceNoName" value="" />
		                         <span class="add-icon" id="chooseSliceNo">
	                                <i></i>
		                         </span>
	                        </div>
	                    </div>
	                </div>
	             </div>
	             <div class="form-item clearfix">
	                <div class="col-4">
	                    <label class="item-name col-6">不良信息：</label>
	                    <div class="col-6">
	                        <div class="ipt-box col-12">
	                            <input type="hidden" class="ipt-txt" name="badInfo" id="badInfo" value=""/>
	                            <select name="badInfoM" id="badInfoM" multiple="multiple">
	                                <option value='1'>列入经营异常</option>
	                                <option value='2'>列入严重违法失信（黑名单）</option>
	                                <option value='3'>有行政处罚信息</option>
	                                <option value='4'>有司法协助信息</option>
	                                <option value='5'>任职资格受限</option>
	                            </select>
	                        </div>
	                    </div>
	                </div>
	                <div class="col-4">
						<label class="item-name col-5">核准日期：</label>
						<div class="col-6">
							<div class="ipt-box col-5">
		                        <input type="text" class="ipt-txt clx" readonly="readonly" onclick="laydate();" name="apprDateStart">
		                    </div>
		                    <span class="item-txt col-2"><i class="line-icon"></i></span>
		                    <div class="ipt-box col-5">
		                        <input type="text" class="ipt-txt clx" readonly="readonly" onclick="laydate();" name="apprDateEnd">
		                    </div>
						</div>
					</div>
					<div class="col-4">
	                    <label class="item-name col-4">经营范围：</label>
	                    <div class="col-7">
	                        <div class="ipt-box col-12">
	                            <input type="text" class="ipt-txt" name="opScope" value="" placeholder="可输入关键词查询"/>
	                        </div>
	                    </div>
	             	</div>
	             </div>
	             <div class="form-item clearfix">
	             	<div class="col-4">
						<label class="item-name col-6">许可证：</label>
						<div class="col-6">
							<div class="ipt-box col-12">
								<input type="text" class="ipt-txt clx" name="licNameAft">
							</div>
						</div>
					</div>
					<div class="col-4">
						<label class="item-name col-5"> 注册资本：</label>
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
						<label class="item-name col-4"> 住所：</label>
						<div class="col-7">
							<div class="ipt-box col-12">
								<input type="text" class="ipt-txt clx" name="dom" placeholder="可输入关键词查询">
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
                    <label class="item-name col-5">是否简易注销：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select name="isSim" id="isSim">
                                <option value=''>全部</option>
                                <option value='Y'>是</option>
                                <option value='N'>否</option>
                            </select>
                        </div>
                    </div>
                 </div>
				</div>
			</div>
			<div class="form-item clearfix">
				<div class="btn-box mt10">
					<input type="button" value="查 询" class="btn mr20" id="search"> 
					<input type="button" id="cancle" onclick="$('#entSearchForm')[0].reset();" value="重置" class="btn mr20">
					<input type="button" value="更多查询" class="btn mr20 js-more-query">
				</div>
			</div>
			</form>
		</div>
	</div>
	<div class="light-info">
    <span class="light">提示：系统默认显示本部门登记或管辖的企业类信息。 <i class="light-box-y mr5"></i>表示正在进行简易注销公告。
    </span>
</div>
	<div>
		<table id="search-table" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100  mt30 nowrap" style="width:100%;">
			<thead >
			<tr>
				<th style="padding: 0 20px;">序号</th>
				<th >登记状态</th>
				<th >统一信用代码/注册号</th>
				<th >企业名称</th>
				<th >法定代表人/负责人</th>
				<th >成立日期</th>
				<th >注册资本（万元）</th>
				<th >企业类型</th>
				<th >行业</th>
				<th >住所</th>
				<th >登记机关</th>
				<th >管辖单位</th>
				<th >片区/商圈</th>
			</tr>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
			</thead>
		</table>
	</div>
	<script src="/js/lib/laydate/laydate.js"></script>
	<script src="/js/lib/require.js"></script>
	<script src="/js/config.js"></script>
	<script src="/js/syn/system/search/appsearch/appsearch.js"></script>
</body>
</html>