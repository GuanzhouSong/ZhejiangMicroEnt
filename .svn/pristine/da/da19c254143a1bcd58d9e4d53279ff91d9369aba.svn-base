<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<meta charset="utf-8">
<title>自然人综合信息</title>
<link rel="stylesheet" href="/css/reg.server.css">
<link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">

</head>
<body>
	<form action="" id="hx-form">
		<input id="cerNO" type="hidden" name="cerNO" value="${dto.cerNO}"> 
		<c:forEach var="regState" items="${regStateEnumMap}">
   		<c:if test="${regState.value == 'CUNXU'}">
   		<input type="hidden" id="regState" name="regState" value="${regState.value.code}">
   		</c:if>
   		</c:forEach>
	</form>
	<div class="pd20">
		<%-- <div class="bg-gray pd20 pos-rel">
        <div class="user-header"><img src="/img/syn/user-header.jpg" alt="" class="mb10"> <a href="#"></a></div>
        <div class="comp-intro user-intro">
            <h4 class="mb5">${dto.name}   ${dto.sex=='1'?'男':'女'}   ${dto.cerNODesc}</h4>

            <table border="0" cellspacing="0" cellpadding="0" class="table-horizontal">
            
            	<tr>
                    <td class="bg-gray left" width="100px" rowspan="3">关联市场主体</td>
                </tr>
                
                 <tr>
                    <td class="bg-gray left">任职法定代表人</td>
                    <td style="text-align: center;" colspan="2">${dbrNum} 家</td>
                    <td class="bg-gray left">任职高管</td>
                    <td style="text-align: center;" colspan="2">${ggNum} 家</td>
                  </tr>
                  
                <tr>
                    <td class="bg-gray left">投资企业数</td>
                    <td style="text-align: center;" colspan="2">${invNum} 家</td>
                    <td class="bg-gray left">任职资格黑名单</td>
                    <td style="text-align: center;" colspan="2">${hmdNum==0?'否':'是'}</td>
                </tr>
                
                
                <tr>
                    <td class="bg-gray left" width="100px" rowspan="3">其它</td>
                </tr>
                <tr>
                	<td class="bg-gray left">现居住地</td>
                    <td style="text-align: center;" colspan="5">${dto.houseAdd}</td>
                </tr>
                
                <tr>
                	<td class="bg-gray left">家庭地址</td>
                    <td style="text-align: center;" colspan="5">${dto.regPerResAddr }</td>
                </tr>

            </table>
        </div>
    </div> --%>
		<div class="clearfix reg-company-basic reg-company-basic-yellowish">
			<div class="clearfix reg-caption pl135">
				<div class="legalperson-img">
					${dto.sex=='1'?'<img src="/img/reg/server/legalperson-img.jpg" alt="">':'<img src="/img/reg/server/women-legalperson-img.jpg" alt="">'}
				</div>
				<div class="title clearfix">
					<span class="name fl mr5">${dto.name}</span> <span>${(dto.sex eq '1' || dto.sex eq '2'?(dto.sex eq '1'?'男':'女'):'')}</span> <span>居民身份证</span> <span id="cerNODesc"></span> ${dto.isLimit=='true'?'<span class="icon-rectangle red fl mr10">任职资格受限</span>':''}
				</div>
				<div class="clearfix">
					<p class="w270">
						<i class="legalperson-icon"></i>任职法定代表人/负责人企业：<span><span class="light">${dbrNum}</span> 家</span>
					</p>
					<p>
						<i class="datebirth-icon"></i>出生日期：<span id="person_birthday"></span>
					</p>
				</div>
				<div class="clearfix">
					<p class="w270">
						<i class="person-icon"></i>任职高管企业：<span><span class="light">${ggNum}</span> 家</span>
					</p>
					<p>
						<i class="person-icon"></i>年龄：<span id="person_age"></span>
					</p>
				</div>

				<div class="clearfix">
					<p class="w270">
						<i class="capital-icon"></i>投资企业：<span><span class="light">${invNum}</span> 家</span>
					</p>
					<p>
						<i class="government-icon"></i>国籍<span></span>
					</p>
				</div>

				<div class="clearfix">
					<p class="w270">
						<i class="telephone-icon"></i>联系电话：<span>${dto.mobTel}</span>
					</p>
					<p>
						<i class="government-icon"></i>籍贯：<span></span>
					</p>
				</div>
				<div class="clearfix">
					<p class="w300">
						<i class="government-icon"></i>现居住地：${dto.houseAdd}<span></span>
					</p>
				</div>
				<div class="btn-box">
					<div class="mb5 clearfix">
						<a class="btn-attention-box"> <i class="attention-icon"></i> <span>关注本人</span>
						</a> <a class="btn-print-box"> <i class="print-icon2"></i> <span>打印</span>
						</a>
					</div>
					<div>
						<a class="btn-attention-box"> <i class="query-icon"></i> <span>关系网查询</span>
						</a> <a class="btn-print-box"> <i class="export-icon"></i> <span>导出</span>
						</a>
					</div>
				</div>
			</div>
		</div>
		<div class="mt10">
			<div class="tabbale" data-component="tab">
				<!-- <div class="tab-header type-tab tbmr1 border-bottom">
					<ul class="clearfix">
						<li class="tab-selected"><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="0">个人投资任职信息</a></span></li>
						<li><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="1">个人不良失信信息</a></span></li>
						<li><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="2">个人抵押质押担保</a></span></li>
						<li><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="3">个人良好荣誉信息</a></span></li>
						<li><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="4">投资任职企业不良信息</a></span></li>
					</ul>
				</div> -->
				<div class="tab-header w-a145 type-tab tbmr1 person-tab">
					<ul class="clearfix">
						<li class="tab-selected"><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="0">个人投资任职信息
							</a></span></li>
						<li class=""><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="1">个人不良失信信息
							</a></span></li>
						<li class=""><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="2">个人抵押质押担保
							</a></span></li>
						<li><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="3">个人良好荣誉信息
							</a></span></li>
						<li><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="4">投资任职企业不良信息
							</a></span></li>
					</ul>
				</div>
				<div class="tab-content">
					<div class="tab-panel tab-panel-show" id="tab_tzrzqk">
						<div class="">
							<!-- <h5 class="com-info-title mt10">
								<div class="col-1">
									<div class="ipt-box col-12">
										
									</div>
								</div>
								任职企业信息<span class="fr">数据来源：工商部门</span>
							</h5> -->
							<div class="clearfix sel-title-box">
								<i class="fl  flex-icon" id="table_rzqyxx_li"></i>
				                <h6 class="add-title fl seled-title">当前任职企业记录（<span id="table_rzqyxx_span" class="light">0</span>）</h6>
				                <h6 class="add-title fl">历史任职企业记录（<span class="light">0</span>）</h6>
				                <div class="ipt-box col-1">
				                    <select id="rzqyxxRegState" name="rzqyxxRegState" >
											<option value="">登记状态</option>
											<c:forEach var="regState" items="${regStateEnumMap}">
		                                	<option value='${regState.value.code}' title='${regState.value}' ${regState.value == 'CUNXU' ? 'selected':''}>${regState.value.name}</option>
		                            		</c:forEach>
										</select>
				                </div>
				                <span class="fr line-h30">数据来源：工商部门</span>
				            </div>
							<table id="table_rzqyxx" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100">
								<thead style="white-space: nowrap;">
									<tr>
										<th width="2%">序号</th>
										<th>统一信用代码/注册号</th>
										<th>企业名称</th>
										<th>法定代表/负责人</th>
										<th>成立日期</th>
										<th>注册资本</th>
										<th>企业类型</th>
										<th>行业</th>
										<th>关系</th>
										<th>登记状态</th>
										<th>住所</th>
										<th>登记机关</th>
										<th>管辖单位</th>
									</tr>
								</thead>
							</table>
							<div class="clearfix sel-title-box">
								<i class="fl  flex-icon" id="table_tzqyxx_li"></i>
				                <h6 class="add-title fl seled-title">当前投资企业记录（<span id="table_tzqyxx_span"  class="light">0</span>）</h6>
				                <h6 class="add-title fl">历史投资企业记录（<span class="light">0</span>）</h6>
				                <div class="ipt-box col-1">
				                    <select id="tzqyxxRegState" name="tzqyxxRegState" >
											<option value="">登记状态</option>
											<c:forEach var="regState" items="${regStateEnumMap}">
		                                	<option value='${regState.value.code}' title='${regState.value}' ${regState.value == 'CUNXU' ? 'selected':''}>${regState.value.name}</option>
		                            		</c:forEach>
										</select>
				                </div>
				                <span class="fr line-h30">数据来源：工商部门和企业年报</span>
				            </div>
							<table id="table_tzqyxx" border="0" cellspacing="0" cellpadding="0" class="table-row  perc-100">
								<thead style="white-space: nowrap;">
									<tr>
										<th width="2%">序号</th>
										<th>统一信用代码/注册号</th>
										<th>企业名称</th>
										<th>法定代表人/负责人</th>
										<th>成立日期</th>
										<th>注册资本</th>
										<th>本人投资认缴总额</th>
										<th>本人投资认缴比例</th>
										<th>企业类型</th>
										<th>行业</th>
										<th>登记状态</th>
										<th>住所</th>
										<th>登记机关</th>
										<th>管辖单位</th>
									</tr>
								</thead>
							</table>
						</div>
					</div>
					<div class="tab-panel" id="tab_sxcjxx">
						<div class="clearfix chose-title-box ">
							<i class="fl  flex-icon" id="table_sxbzxrxx_li"></i>
						    <h6 class="add-title fl">失信被执行人信息（<span id="table_sxbzxrxx_span" class="light">0</span>）</h6>
						</div>
						<table id="table_sxbzxrxx" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100">
							<thead>
								<tr>
									<th width="7.5%">序号</th>
									<th width="22.7%">案号</th>
									<th>执行法院</th>
									<th>日期</th>
								</tr>
							</thead>
						</table>

						<!-- <h5 class="com-info-title mt10">
							个人股权冻结信息<span class="fr">数据由司法部门提供</span>
						</h5> -->
						<div class="clearfix chose-title-box">
							<i class="fl  flex-icon" id="table_gqdjxx_li"></i>
						    <h6 class="add-title fl">个人股权冻结信息（<span id="table_gqdjxx_span" class="light">0</span>）</h6><span class="fr line-h30"></span>
						</div>
						<table id="table_gqdjxx" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100">
							<thead>
								<tr>
									<th width="7.5%">序号</th>
									<th width="22.7%">执行裁定书文号</th>
									<th>执行法院</th>
									<th>被冻结股权所在市场主体名称</th>
									<th>被冻结股权所在市场主体注册号</th>
									<th>冻结股权类型</th>
									<th>股权数额（万）</th>
									<th>冻结期限自</th>
									<th>冻结期限至</th>
								</tr>
							</thead>
						</table>

					<!-- 	<h5 class="com-info-title mt10">
							个人不动产查封信息<span class="fr"></span>
						</h5> -->
						<div class="clearfix chose-title-box">
							<i class="fl  flex-icon" id="table_bdccfxx_li"></i>
						    <h6 class="add-title fl">个人不动产查封信息（<span id="table_bdccfxx_span" class="light">0</span>）</h6><span class="fr line-h30"></span>
						</div>
						<table id="table_bdccfxx" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100">
							<thead>
								<tr>
									<th width="7.5%">序号</th>
									<th width="22.7%">查封文号</th>
									<th>查封不动产坐落</th>
									<th>申请查封单位</th>
									<th>查封申请日期</th>
									<th>撤销查封日期</th>
									<th>状态</th>
								</tr>
							</thead>
						</table>

					</div>

					<div class="tab-panel" id="tab_grzcdyzy">
						<!-- <h5 class="com-info-title mt10">
							个人不动产抵押登记信息<span class="fr">数据来源：不动产登记部门</span>
						</h5> -->
						<div class="clearfix chose-title-box">
							<i class="fl  flex-icon" id="table_bdcdyxx_li"></i>
						    <h6 class="add-title fl">个人不动产抵押登记信息（<span id="table_bdcdyxx_span" class="light">0</span>）</h6><span class="fr line-h30">数据来源：不动产登记部门</span>
						</div>
						<table id="table_bdcdyxx" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100">
							<thead>
								<tr>
									<th width="7.5%">序号</th>
									<th width="22.7%">抵押证编号</th>
									<th>抵押物类型</th>
									<th>抵押担保范围</th>
									<th>抵押权人名称</th>
									<th>抵押权人证件号</th>
									<th>被担保主债权数额（万元）</th>
									<th>债务期限起</th>
									<th>债务期限至</th>
									<th>申请抵押原因</th>
								</tr>
							</thead>
						</table>
						<!-- <h5 class="com-info-title mt10">
							个人动产抵押登记信息<span class="fr">数据来源：工商部门</span>
						</h5> -->
						<div class="clearfix chose-title-box">
							<i class="fl  flex-icon" id="table_dcdyxx_li"></i>
						    <h6 class="add-title fl">个人动产抵押登记信息（<span id="table_dcdyxx_span" class="light">0</span>）</h6><span class="fr line-h30">数据来源：工商部门</span>
						</div>
						<table id="table_dcdyxx" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100">
							<thead>
								<tr style="white-space: nowrap;">
									<th width="7.5%">序号</th>
									<th width="22.7%">抵押证编号</th>
									<th>抵押担保范围</th>
									<th>抵押权人名称</th>
									<th>抵押权人证件号</th>
									<th>被担保主债权数额（万元）</th>
									<th>债务期限起</th>
									<th>债务期限至</th>
								</tr>
							</thead>
						</table>
						<!-- <h5 class="com-info-title mt10">
							个人股权出质登记信息<span class="fr">数据来源：工商部门</span>
						</h5> -->
						<div class="clearfix chose-title-box">
							<i class="fl  flex-icon" id="table_gqczxx_li"></i>
						    <h6 class="add-title fl">个人股权出质登记信息（<span id="table_gqczxx_span" class="light">0</span>）</h6><span class="fr line-h30">数据来源：工商部门</span>
						</div>
						<table id="table_gqczxx" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100">
							<thead>
								<tr>
									<th width="7.5%">质权登记编号</th>
									<th width="22.7%">出质人</th>
									<th>质权人</th>
									<th>质权人证照号</th>
									<th>出质股权数额（万元）</th>
									<th>出质设立登记日期</th>
									<th>出质状态</th>
								</tr>
							</thead>
						</table>
						<!-- <h5 class="com-info-title mt10">
							个人知识产权出质登记信息<span class="fr">数据来源：知识产权登记部门</span>
						</h5> -->
						<div class="clearfix chose-title-box">
							<i class="fl  flex-icon" id="table_grzscqczdjxx_li"></i>
						    <h6 class="add-title fl">个人知识产权出质登记信息（<span id="table_grzscqczdjxx_span" class="light">0</span>）</h6><span class="fr line-h30">数据来源：知识产权登记部门</span>
						</div>
						<table id="table_grzscqczdjxx" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100">
							<thead>
								<tr>
									<th width="7.5%">序号</th>
									<th>名称</th>
									<th>商品注册号</th>
									<th>出质人</th>
									<th>质权人</th>
									<th>公示类型</th>
									<th>公示日期</th>
								</tr>
							</thead>
						</table>

						<!-- <h5 class="com-info-title mt10">
							个人对外提供担保信息<span class="fr">数据来源：年报信息</span>
						</h5> -->
						<div class="clearfix chose-title-box">
							<i class="fl  flex-icon" id="table_grdwtgdbxx_li"></i>
						    <h6 class="add-title fl">个人对外提供担保信息（<span id="table_grdwtgdbxx_span" class="light">0</span>）</h6><span class="fr line-h30">数据来源：年报信息</span>
						</div>
						<table id="table_grdwtgdbxx" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100">
							<thead>
								<tr>
									<th width="7.5%">序号</th>
									<th>债权人</th>
									<th>债务人</th>
									<th>保证担保额范围</th>
									<th>主债权数额</th>
									<th>保证的方式</th>
									<th>保证的期间</th>
								</tr>
							</thead>
						</table>
					</div>
					<div class="tab-panel" id="tab_grzccfdj">
						<!-- <h5 class="com-info-title mt10">个人良好荣誉信息</h5> -->
						<div class="clearfix chose-title-box">
							<i class="fl  flex-icon" id="table_grlhryxx_li"></i>
						    <h6 class="add-title fl">个人良好荣誉信息（<span id="table_grlhryxx_span" class="light">0</span>）</h6><span class="fr line-h30"></span>
						</div>
						<table id="table_grlhryxx" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100">
							<thead>
								<tr>
									<th width="7.5%">序号</th>
									<th>良好信息类别</th>
									<th>信息级别</th>
									<th>认定发布年度</th>
									<th>认定类别</th>
									<th>认定有效期始</th>
									<th>认定有效期止</th>
									<th>状态</th>
									<th>认定发布时间</th>
									<th>认定发布文号</th>
									<th>认定发布部门</th>
								</tr>
							</thead>
						</table>
					</div>

					<div class="tab-panel" id="tab_tzrzqyblxx">
						<!-- <h5 class="com-info-title mt10">
							投资任职企业被吊销<span class="fr">数据由工商部门提供</span>
						</h5> -->
						<div class="clearfix chose-title-box">
							<i class="fl  flex-icon" id="table_dxhmdxx_li"></i>
						    <h6 class="add-title fl">投资任职企业被吊销（<span id="table_dxhmdxx_span" class="light">0</span>）</h6><span class="fr line-h30">数据由工商部门提供</span>
						</div>
						<table id="table_dxhmdxx" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100">
							<thead>
								<tr>
									<th width="7.5%">序号</th>
									<th width="22.7%">所属单位名称</th>
									<th>所属单位注册号</th>
									<!-- <th>企业关系</th> -->
									<th>处罚文号</th>
									<th>处理日期</th>
									<th>到期日期</th>
									<!--                                 <th>处罚手段</th> -->
									<th>吊销原因类型</th>
									<th>吊销原因内容</th>
									<th>限制状态</th>
								</tr>
							</thead>
						</table>

					<!-- 	<h5 class="com-info-title mt10">投资任职企业被列入经营异常名录</h5> -->
						<div class="clearfix chose-title-box">
							<i class="fl  flex-icon" id="table_tzrzqyblrjyycml_li"></i>
						    <h6 class="add-title fl">投资任职企业被列入经营异常名录（<span id="table_tzrzqyblrjyycml_span" class="light">0</span>）</h6><span class="fr line-h30"></span>
						</div>
						<table id="table_tzrzqyblrjyycml" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100">
							<thead>
								<tr>
									<th width="7.5%">序号</th>
									<th width="22.7%">企业名称</th>
									<th>法定代表人/负责人</th>
									<th>登记机关</th>
									<th>管辖单位</th>
									<th>列入原因</th>
									<th>列入决定机关</th>
									<th>审核状态</th>
									<th>处罚文号</th>
									<th>登记状态</th>
								</tr>
							</thead>
						</table>
						<!-- <h5 class="com-info-title mt10">
							投资任职企业被列入严重违法失信<span class="fr">数据由工商部门提供</span>
						</h5> -->
						<div class="clearfix chose-title-box">
							<i class="fl  flex-icon" id="table_grsxcjxx_li"></i>
						    <h6 class="add-title fl">投资任职企业被列入严重违法失信（<span id="table_grsxcjxx_span" class="light">0</span>）</h6><span class="fr line-h30">数据由工商部门提供</span>
						</div>
						<table id="table_grsxcjxx" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100">
							<thead>
								<tr>
									<th width="7.5%">序号</th>
									<th width="22.7%">所属单位名称</th>
									<th>所属单位注册号</th>
									<!-- <th>企业关系</th> -->
									<th>处罚文号</th>
									<th>处罚时间</th>
									<th>处罚事实</th>
									<th>处罚依据</th>
									<th>处罚结果</th>
									<th>作出决定机关</th>
									<th>惩戒有效期</th>
									<!-- <th>发布时间</th>
                                <th>发布截至时间</th> -->
								</tr>
							</thead>
						</table>
						<!-- <h5 class="com-info-title mt10">工商严重违法失信<span class="fr">数据由工商部门提供</span></h5>
                        <table id="table_yzwfsxxx" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100">
                            <thead>
                            <tr>
                                <th width="7.5%">序号 </th>
                                <th width="22.7%">所属单位名称</th>
                                <th>所属单位统一信用代码/注册号</th>
                                <th>企业关系</th>
                                <th>列入日期</th>
                                <th>列入事由</th>
                                <th>权利救济的期限和途径</th>
                                <th>列入作出决定机关</th>
                                <th>移出日期</th>
                                <th>移出事由</th>
                                <th>移出作出决定机关</th>
                                <th>限制状态</th>
                            </tr>
                            </thead>
                        </table> -->
						<!-- <h5 class="com-info-title mt10">
							投资任职企业被行政处罚<span class="fr">数据由工商部门和其他政府部门提供</span>
						</h5> -->
						<div class="clearfix chose-title-box">
							<i class="fl  flex-icon" id="table_tzrzqybxzcf_li"></i>
						    <h6 class="add-title fl">投资任职企业被行政处罚（<span id="table_tzrzqybxzcf_span" class="light">0</span>）</h6><span class="fr line-h30">数据由工商部门和其他政府部门提供</span>
						</div>
						<table id="table_tzrzqybxzcf" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100">
							<thead>
								<tr>
									<th width="7.5%">序号</th>
									<th width="22.7%">处置部门</th>
									<th>设置人员</th>
									<th>处罚机关名称</th>
									<th>处罚文号</th>
									<th>处罚类型</th>
									<th>罚款金额</th>
									<th>处罚单位名称</th>
									<th>法定代表人/负责人</th>
								</tr>
							</thead>
						</table>
						<!-- <h5 class="com-info-title mt10">投资任职企业被失信联合惩戒</h5> -->
						<div class="clearfix chose-title-box">
							<i class="fl  flex-icon" id="table_tzrzqybsxlhcj_li"></i>
						    <h6 class="add-title fl">投资任职企业被失信联合惩戒（<span id="table_tzrzqybsxlhcj_span" class="light">0</span>）</h6><span class="fr line-h30"></span>
						</div>
						<table id="table_tzrzqybsxlhcj" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100">
							<thead>
								<tr>
									<th width="7.5%">序号</th>
									<th width="22.7%">批次号</th>
									<th>企业名称</th>
									<th>法定代表人/负责人</th>
									<th>当事人姓名</th>
									<th>当事人电话</th>
									<th>有无惩戒记录</th>
								</tr>
							</thead>
						</table>

					</div>

				</div>
			</div>
		</div>
	</div>
	<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
	<script src="/js/component/tab.js"></script>
	<script src="/js/lib/require.js"></script>
	<script src="/js/config.js"></script>
	<script src="/js/syn/system/search/personsearch/personsearchdetails.js"></script>
</body>
</html>