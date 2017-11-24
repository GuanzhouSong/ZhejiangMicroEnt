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
<title>抽查任务情况统计</title>
<link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon" />
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
					<div class="col-3">
						<label class="item-name col-5">任务年度：</label>
						<div class="col-7">
							<div class="ipt-box col-11">
                            <select name="searchYear">
                            	<c:forEach var="nowYear" items="${yearList}" varStatus="status" >
			        		    <option value="${nowYear}">${nowYear}</option>
		        		        </c:forEach>
                            </select>
							</div>
						</div>
					</div>
					<div class="col-3">
						<label class="item-name col-5">统计截止日期：</label>
	                      <div class="ipt-box col-7">
<!-- 	                        <div class="ipt-box col-575"> -->
	                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly"  
	                              name="setTimeEnd" id="setTimeEnd" value="${endCheckPushDate}"/>
<!-- 	                        </div> -->
	                     </div>
					</div>
					<div class="col-3">
						<label class="item-name col-5">统计层级：</label>
						<div class="col-7">
							<div class="ipt-box col-11">
                            <select name="statLevel" id="statLevel">
                                <c:if test="${sysUser.isAdmin == 1 || sysUser.isAdmin == 2 || sysUser.searchRangeLevel == 4 }"><option value="area">按地区</option></c:if>
                                <c:if test="${sysUser.isAdmin == 1 || sysUser.isAdmin == 2 || sysUser.searchRangeLevel != 1 }"><option value="regOrg">按登记机关</option></c:if>
                                <option value="localAdm">按管辖单位</option>
                            </select>
							</div>
						</div>
					</div>
					<div class="col-3">
						<label class="item-name col-5">统计范围：</label>
						<div class="col-7">
							<div class="ipt-box col-9">
                                <select name="statArea" id="statArea" multiple="multiple">
                            </select>
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
         <p class="light">
         数据说明：<br/>
1、“年度抽查计划”指部门制定的年度抽查计划活动数量；“抽查检查任务”指部门设置的抽查检查任务数量；“应检查数”指部门设置的检查任务中已抽取锁定的检查名单数量；“已检查数”指部门应检查名单中已完成检查结果录入并公示的数量；“完结数”指已检查数中后续处置措施已执行完结的数量。<br/>
2、“计划完成率”= 已完成 / 年度抽查计划；“任务完成率”= 已完成 / 抽查检查任务；“检查完成率” = 已检查数 / 应检查数；“完结率” = 完结数 / 已检查数。</p>
    </div>
    <div class="table-out">
        <div>
            <table id="user-table"  border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap" width="100%">
                <thead>
                <tr>
	                <th rowspan="2" style="font-weight: bold">行次</th>
		            <th rowspan="2" style="font-weight: bold">地区</th>
		            <th rowspan="2" style="font-weight: bold">部门</th>
		            <th rowspan="2" style="font-weight: bold">年<br/>度<br/>抽<br/>查<br/>计<br/>划</th> 
		            <th colspan="2" style="font-weight: bold">计划类型</th>
		            <th colspan="4" style="font-weight: bold">计划执行</th>
		            <th rowspan="2" style="font-weight: bold">抽<br/>查<br/>检<br/>查<br/>任<br/>务</th>
		            <th colspan="2" style="font-weight: bold">任务来源</th>
		            <th colspan="2" style="font-weight: bold">任务类型</th>
		            <th colspan="4" style="font-weight: bold">任务执行</th>
		            <th colspan="3" style="font-weight: bold">检查情况</th>
		            <th colspan="2" style="font-weight: bold">完结情况</th>
                </tr>
                <tr>
		            <th>本<br/>部<br/>门</th>
		            <th>跨<br/>部<br/>门</th>
		            <th>待<br/>执<br/>行<br/></th>
		            <th>执<br/>行<br/>中</th>
		            <th>已<br/>完<br/>成</th>
		            <th>计<br/>划<br/>完<br/>成<br/>率<br/>%</th>
		            <th>临<br/>时<br/>任<br/>务</th>
		            <th>年<br/>度<br/>计<br/>划</th>
		            <th>本<br/>部<br/>门</th>
		            <th>跨<br/>部<br/>门</th>
		            <th>待<br/>执<br/>行</th>
		            <th>执<br/>行<br/>中</th>
		            <th>已<br/>完<br/>成</th>
		            <th>任<br/>务<br/>完<br/>成<br/>率<br/>%</th>
		            <th>应<br/>检<br/>查<br/>数</th>
		            <th>已<br/>检<br/>查<br/>数</th>
		            <th>检<br/>查<br/>完<br/>成<br/>率<br/>%</th>
		            <th>完<br/>结<br/>数</th>
		            <th>完<br/>结<br/>率<br/>%</th>
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
	        </tr> 
	        </tfoot>
            </table>
        </div>
    </div>
<script>
    window._CONFIG = {
       year:'${year}',
       deptCode:'${deptCode}',
       endCheckPushDate:'${endCheckPushDate}',
       month:'${month}',
       _searchRangeLevel:'${sysUser.searchRangeLevel}',
       _isAdmin:'${sysUser.isAdmin}',
	    chooseUrl:'${sysUser.userType == 2 ? "/syn" : "/reg"}'
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sccheck/scplantask/scplantask_count.js"></script>
</body>
</html>
