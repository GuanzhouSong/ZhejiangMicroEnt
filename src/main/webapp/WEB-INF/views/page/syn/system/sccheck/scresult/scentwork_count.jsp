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
<title>抽查工作情况统计</title>
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
						<label class="item-name col-5">统计截止日期：</label>
	                     <div class="ipt-box col-7">
	                      <input type="text" class="ipt-txt laydate-icon" readonly="readonly"  
                              name="setTimeEnd" id="setTimeEnd" value="${setTimeEnd}"/>
	                     </div>
					</div>
					<div class="col-4">
						<label class="item-name col-5">年度：</label>
						<div class="ipt-box col-7">
                           <select name="year" id="year" class="rptselect">
                           		<c:forEach var="nowYear" items="${yearList}" varStatus="status" >
			        		    	<option value="${nowYear}">${nowYear}</option>
		        		        </c:forEach>
                           </select>
						</div>
					</div>
					<div class="col-4">
						<label class="item-name col-5">抽查任务组织部门：</label>
						<div class="ipt-box col-7">
                           <input type="hidden" class="ipt-txt" name="taskLeadDeptCode" id="appointLocalAdm" value=""/>
	                        <input type="text" readonly="readonly" class="ipt-txt" id="localAdmName" value="" />
	                         <span class="add-icon" id="choseregUnit">
	                             <i></i>
	                         </span>
						</div>
					</div>
				</div>
				<div class="center mt10">
					<input type="button" id="search" value="查询" class="btn mr20">
					<input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
				</div>
		</form>
	</div>
	
    <div class="light-info mt10">
         <p class="light">数据说明：
1、抽查户数=抽查基数*抽查比例；抽查完成率=已公示/抽查户数；完结率=完结数/已公示。
2、发现问题待后续处理=违反工商行政管理+违反食品药品管理+违反质量技术监督+违反其他部门</p>
    </div>
    <div class="table-out">
        <div>
            <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30" style="width: 100%;white-space: nowrap;">
                <thead>
                <tr>
	                <th rowspan="2" style="font-weight: bold">行次</th>
		            <th rowspan="2" style="font-weight: bold">抽查<br/>内容</th>
		            <th rowspan="2" style="font-weight: bold">抽查<br/>类型</th>
		            <th rowspan="2" style="font-weight: bold">抽查<br/>对象</th> 
		            <th rowspan="2" style="font-weight: bold">抽查<br/>基数</th> 
		            <th rowspan="2" style="font-weight: bold">抽查<br/>比例<br/>（%）</th> 
		            <th rowspan="2" style="font-weight: bold">抽查<br/>户数</th> 
		            <th colspan="3" style="font-weight: bold">抽查结果公示</th>
		            <th colspan="7" style="font-weight: bold">检查结果</th>
		            <th colspan="8" style="font-weight: bold">发现问题待后续处理</th>
		            <th colspan="6" style="font-weight: bold">后续处置</th>
		            <th colspan="2" style="font-weight: bold">完结情况</th>
                </tr>
                <tr>
		            <th>已<br/>公<br/>示</th>
		            <th>未<br/>公<br/>示</th>
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
						<th></th>
					</tr>
				</tfoot>
            </table>
        </div>
    </div>
<script>
	window._CONFIG = {
		chooseUrl : '${sysUser.userType == 2 ? "/syn" : "/reg"}'
	}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sccheck/scresult/scentwork_count.js"></script>
</body>
</html>
