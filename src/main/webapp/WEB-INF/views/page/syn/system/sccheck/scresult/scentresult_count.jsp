<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<meta charset="utf-8">
<meta http-equiv="Content-Type"
	content="multipart/form-data; charset=utf-8" />
<title>综合抽查结果统计</title>
<link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
<link rel="stylesheet" href="/css/reg.server.css">
<link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<!-- <img  src="/img/reg/server/zfryktj.jpg"> -->
	<div class="tabbale" data-component="tab">
		<form id="taskForm" class="form-box mb5">
			<div class="form-list pdr8">
				<div class="form-item clearfix">
					<div class="col-4">
						<label class="item-name col-5">任务名称：</label>
	                      <div class="ipt-box col-7">
								<select name="taskUid">
									<option></option>
									 <c:forEach var="pubScPlanTask" items="${taskNameList}">
									 	<option value="${pubScPlanTask.uid }">【${pubScPlanTask.taskCode }】${pubScPlanTask.taskName }</option>
									</c:forEach>
								</select>
	                     </div>
					</div>
					<div class="col-4">
						<label class="item-name col-5">统计层级：</label>
						<div class="ipt-box col-7">
                           <select name="statLevel" id="statLevel">
                               <c:if test="${sysUser.isAdmin == 1 || sysUser.isAdmin == 2 || sysUser.searchRangeLevel == 4 }"><option value="area">按地区</option></c:if>
                               <c:if test="${sysUser.isAdmin == 1 || sysUser.isAdmin == 2 || sysUser.searchRangeLevel != 1 }"><option value="regOrg">按登记机关</option></c:if>
                               <option value="localAdm">按管辖单位</option>
                           </select>
						</div>
					</div>
					<div class="col-4">
						<label class="item-name col-5">统计范围：</label>
						<div class="ipt-box col-7">
                               <select name="statArea" id="statArea" multiple="multiple">
                           </select>
						</div>
					</div>
				</div>
				 <div class="form-item clearfix">
                <div class="col-9">
                <label class="item-name" style="width:18.4%">统计日期：</label>
                <div class="col-9">
                    <div class="ipt-box col-2 mr-col-005">
                           <select name="countType" id="countType" class="rptselect">
                           <option value="00" id="now">按月度</option>
                           <option value="01" id="month">自定义</option>
                           </select>
                    </div>
                    <div class="ipt-box col-2 mr-col-005" id="yearDiv">
                           <select name="rptyear" id="rptyear" class="rptselect">
                           </select>
                    </div>
                    <input type="hidden" id="setTimeMonthStart" name="setTimeMonthStart"/>
                    <input type="hidden" id="setTimeMonthEnd" name="setTimeMonthEnd"/>
                    <div class="monthchoose" id="monthDiv">
	                     <div class="ipt-box col-2">
	                           <select id="monthStart" class="rptselect">
	                           	   <option value=""></option>
		                           <option value="1">1月</option>
		                           <option value="2">2月</option>
		                           <option value="3">3月</option>
		                           <option value="4">4月</option>
		                           <option value="5">5月</option>
		                           <option value="6">6月</option>
		                           <option value="7">7月</option>
		                           <option value="8">8月</option>
		                           <option value="9">9月</option>
		                           <option value="10">10月</option>
		                           <option value="11">11月</option>
		                           <option value="12">12月</option>
	                           </select>
	                    </div>
	                    <div class="ipt-box">                  
	                    <span class="item-line">-</span>
	                    </div>
	                    <div class="ipt-box col-2 mr-col-005">
	                           <select id="monthEnd" class="rptselect">
		                           <option value=""></option>
		                           <option value="1">1月</option>
		                           <option value="2">2月</option>
		                           <option value="3">3月</option>
		                           <option value="4">4月</option>
		                           <option value="5">5月</option>
		                           <option value="6">6月</option>
		                           <option value="7">7月</option>
		                           <option value="8">8月</option>
		                           <option value="9">9月</option>
		                           <option value="10">10月</option>
		                           <option value="11">11月</option>
		                           <option value="12">12月</option>
	                           </select>
	                    </div>
                    </div>
                      <div class="ipt-box col-4" id="dateDiv" style="display: none;">
                     	  <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly" id="setTimeStart"
                                   name="setTimeStart"/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly"  
                              name="setTimeEnd" id="setTimeEnd" value="${endCheckPushDate}"/>
                        </div>
                     </div>
               </div>
              </div>          
       </div>
				<div class="center mt10">
					<input type="button" id="search" value="查询" class="btn mr20">
					<input type="button" id="cancel"
						onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
				</div>
		</form>
	</div>
	
    <div class="light-info mt10">
         <p class="light">数据说明： 
         1、“应检查数”指抽查任务中涉及本部门检查事项的检查名单数量；
         “录入中”指含已录入的检查结果信息等待审核或审核不通过情况；
         “完结数”指已检查数中后续处置措施已执行完结的数量。
         2、“完成率” = 已公示数 / 应检查数；
          “完结率” = 完结数 / 已公示数。</p>
    </div>
    <div class="table-out">
        <div>
            <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30" style="width: 100%;white-space: nowrap;">
                <thead>
                <tr>
	                <th rowspan="2">行次</th>
		            <th rowspan="2">地区</th>
		            <th rowspan="2">部门</th>
		            <th rowspan="2">应<br/>检<br/>查<br/>数</th> 
		            <th colspan="4">抽查结果公示</th>
		            <th colspan="7">检查结果</th>
		            <th colspan="8">发现问题待后续处理</th>
		            <th colspan="6">后续处置</th>
		            <th colspan="2">完结情况</th>
                </tr>
                <tr>
               	 	<th>待<br/>录<br/>入</th>
		            <th>录<br/>入<br/>中</th>
		            <th>已<br/>公<br/>示</th>
		            <th>抽<br/>查<br/>完<br/>成<br/>率<br/>%</th>
		            <th>未<br/>发<br/>现<br/>问<br/>题<br/></th>
		            <th>发<br/>现<br/>问<br/>题<br/>已<br/>责<br/>令<br/>改<br/>正</th>
		            <th>未发<br/>现开<br/>展本<br/>次抽<br/>查涉<br/>及的<br/>经营<br/>活动</th>
		            <th>已关<br/>闭停<br/>业或<br/>正在<br/>组织<br/>清算</th>
		            <th>不<br/>配<br/>合<br/>检<br/>查<br/>情<br/>节<br/>严<br/>重</th>
		            <th>迁<br/>移<br/>、<br/>注<br/>销<br/>等<br/>其<br/>他<br/>情<br/>况</th>
		            <th>发<br/>现<br/>问<br/>题<br/>待<br/>后<br/>续<br/>处<br/>理</th>
		            <th>违<br/>反<br/>工<br/>商<br/>行<br/>政<br/>管<br/>理<br/>相<br/>关<br/>规<br/>定</th>
		            <th>未按<br/>规定<br/>公示<br/>应当<br/>公示<br/>的信<br/>息</th>
		            <th>公示<br/>信息<br/>隐瞒<br/>真实<br/>情况<br/>、弄<br/>虚作<br/>假</th>
		            <th>通过<br/>登记<br/>的住<br/>所（<br/>经营<br/>场所<br/>）无<br/>法联<br/>系</th>
		            <th>违法<br/>其他<br/>工商<br/>行政<br/>管理<br/>规定</th>
		            <th>违反<br/>食品<br/>药品<br/>管理<br/>相关<br/>规定</th>
		            <th>违反<br/>质量<br/>技术<br/>监督<br/>相关<br/>规定</th>
		            <th>违<br/>反<br/>其<br/>他<br/>部<br/>门<br/>相<br/>关<br/>规<br/>定</th>
		            <th>未发<br/>现问<br/>题或<br/>相关<br/>问题<br/>已规<br/>范、<br/>已改<br/>正，<br/>无需<br/>后续<br/>处置</th>
		            <th>停止<br/>检查<br/>，反<br/>馈日<br/>常监<br/>管部<br/>门</th>
		            <th>违反<br/>本部<br/>门相<br/>关规<br/>定，<br/>责令<br/>改正</th>
		            <th>发现<br/>案件<br/>线索<br/>，移<br/>送办<br/>案机<br/>构</th>
		            <th>违反<br/>其他<br/>部门<br/>相关<br/>规定<br/>，抄<br/>告相<br/>关部<br/>门</th>
		            <th>其他</th>
		            <th>完结<br/>数</th>
		            <th>完结<br/>率%</th>
                </tr>
                </thead>
                <tfoot>
					<tr>
						<th>合计</th>
						<th>-</th>
						<th>-</th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
					</tr>
				</tfoot>
            </table>
        </div>
    </div>
<script>
	window._CONFIG = {
		year : '${year}',
		deptCode : '${deptCode}',
		endCheckPushDate : '${endCheckPushDate}',
		month : '${month}',
		_searchRangeLevel : '${sysUser.searchRangeLevel}',
		_isAdmin : '${sysUser.isAdmin}',
		chooseUrl : '${sysUser.userType == 2 ? "/syn" : "/reg"}'
	}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sccheck/scresult/scentresult_count.js"></script>
</body>
</html>
