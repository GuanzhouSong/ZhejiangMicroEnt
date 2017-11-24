<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <title>党建信息统计报表</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
    <style type="text/css">
    .laydate_bottom{
		display:none;
	}
    </style>
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box mb5">
    <input type="hidden" name="partyOrgDistributed" id="partyOrgDistributed">
        <div class="form-list pdr8">
            <div class="form-item clearfix">
                <div class="col-3">
                    <label class="item-name col-5">统计日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt laydate-icon"
                                   onclick="laydate({max:laydate.now(-1)})" readonly="readonly"
                                   id = "createTime" name="createTime" value="${preDate }"/>
                        </div>
                    </div>
                </div>
                <div class="col-3">
                    <label class="item-name col-5">统计类别：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select name="partyOrgDistributedM" id="partyOrgDistributedM" multiple="multiple">
                            	<option value="1">个体户</option>
                            	<option value="4">企业</option>
                            	<option value="2">商品交易市场</option>
                            	<option value="3">农贸市场</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-3">
                    <label class="item-name col-5">统计范围：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select name="statArea" id="statArea" multiple="multiple">
                            </select>
                        </div>
                    </div>
                </div>
	            <div class="col-3">
	                <label class="item-name col-5">统计层级：</label>
	                <div class="col-7">
	                    <div class="ipt-box col-11">
	                        <select name="statLevel" id="statLevel">
	                            <c:if test="${sysUser.searchRangeLevel == 4 }"><option value="area">按地区</option></c:if>
	                            <c:if test="${sysUser.searchRangeLevel == 4||sysUser.searchRangeLevel == 3 }"><option value="regorg">按管辖机关</option></c:if>
	                            <c:if test="${sysUser.searchRangeLevel == 3||sysUser.searchRangeLevel == 2||sysUser.searchRangeLevel == 1 }"><option value="localadm">按管辖单位</option></c:if>
	                        </select>
	                    </div>
	                </div>
	            </div>
       </div></div>
        <div class="center mt10">
            <input type="button" id="search" value="查询" class="btn mr20">
            <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
        </div>
    </form>
</div>
    <div class="light-info mt10">
         <p class="light">数据说明：党组织=党委+党总支+党支部；业主党员数+从业人员党员数=组织关系所在合计（辖区协会+市场+街道社区+流动党员）</p>
    </div>
    <div class="table-out">
        <div>
            <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30" style="width: 100%;white-space: nowrap;">
                <thead>
	                <tr>
		                <th width="50" rowspan="2">行次</th>
			            <th rowspan="2">部门</th>
			            <th rowspan="2">党组织</th>
			            <th rowspan="2">党委</th>
			            <th rowspan="2">党总支</th>
			            <th rowspan="2">党支部</th>
			            <th rowspan="2">党组织覆盖非公企业</th>
			            <th rowspan="2">从业人员总数(不含业主)</th>
			            <th rowspan="2">业主党员</th>
			            <th rowspan="2">从业人员党员</th>
			            <th colspan="4">组织关系所在</th>
			            <th colspan="4">单独建立党组织</th>
			            <th colspan="4">联合建立党组织</th>
	                </tr>
	                <tr>
			            <th>辖区协会</th>
			            <th>市场</th>
			            <th>街道社区</th>
			            <th>流动党员</th>
			            <th>单独建立党组织</th>
			            <th>党委</th>
			            <th>党总支</th>
			            <th>党支部</th>
			            <th>联合建立党组织</th>
			            <th>联合建立党组织覆盖非公企业</th>
			            <th>有3名党员以上的非公企业</th>
			            <th>有党员但不足3名的非公企业</th>
	                </tr>
                </thead>
           <tfoot>
	          <tr>
	            <th colspan="2">合计</th>
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
       isAdmin :'${sysUser.isAdmin}',
       deptCode:'${deptCode}',
       searchRangeLevel:'${sysUser.searchRangeLevel}'
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/partycreate/partybuildinfocount_view.js"></script>
</body>
</html>
