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
    <title>党员信息统计报表</title>
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
        <div class="form-list pdr8">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">统计截止日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt laydate-icon"
                                   onclick="laydate({max:laydate.now(-1)})" readonly="readonly"
                                   id = "createTime" name="createTime" value="${preDate }"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">统计范围：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select name="statArea" id="statArea" multiple="multiple">
                            </select>
                        </div>
                    </div>
                </div>
	            <div class="col-4">
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
         <p class="light">数据说明：党员数=业主党员+从业人员党员=男性党员+女性党员=汉族党员+少数民族党员=正式党员+预备党员=干部党员+普通党员=党员分布之和=各年龄党员之和=各学历党员之和=企业类型之和</p>
    </div>
    <div class="table-out">
        <div>
            <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30" style="width: 100%;white-space: nowrap;">
                <thead>
	                <tr>
		                <th width="50" rowspan="2">行次</th>
			            <th rowspan="2">部门</th>
			            <th rowspan="2">党组织</th>
			            <th rowspan="2">党员数</th>
			            <th colspan="2">成员类型</th>
			            <th colspan="2">党员性别</th>
			            <th colspan="2">党员民族</th>
			            <th colspan="2">党员类别</th>
			            <th colspan="3">党内职务</th>
			            <th colspan="2">党员分布</th>
			            <th colspan="5">党员年龄</th>
			            <th colspan="6">党员学历</th>
			            <th colspan="2">企业类型</th>
	                </tr>
	                <tr>
			            <th>业主党员</th>
			            <th>从业人员党员</th>
			            <th>男性党员</th>
			            <th>女性党员</th>
			            <th>汉族</th>
			            <th>少数民族</th>
			            <th>正式党员</th>
			            <th>预备党员</th>
			            <th>党员干部</th>
			            <th>书记</th>
			            <th>普通党员</th>
			            <th>个体</th>
			            <th>市场</th>
			            <th>30岁以下</th>
			            <th>30-40岁以下</th>
			            <th>40-50岁以下</th>
			            <th>50-60岁以下</th>
			            <th>60岁及以上</th>
			            <th>小学及以下</th>
			            <th>初中</th>
			            <th>高中</th>
			            <th>大专</th>
			            <th>本科</th>
			            <th>研究生及以上</th>
			            <th>个体户</th>
			            <th>企业</th>
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
<script src="/js/reg/server/partycreate/partymemberinfocount_view.js"></script>
</body>
</html>
