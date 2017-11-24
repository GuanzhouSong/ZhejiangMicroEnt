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
    <title>年报逾期未报列表</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">

	<div class="zr-person-box">
		<form id="search-form" class="form-box">
			<input type="hidden" id="selectCode" name="selectCode" value="${selectCode }" >
			<div class="form-list">
				<div class="form-item clearfix">
					<label for="" class="col-2" style="width: 19%;"></label>
					<div class="col-6 ">
						<div class="col-2 pdr5">
							<div class="ipt-box col-12">
								<select name="entTypeCatg">
									<option value="">主体类型</option>
									<option value="1">企业</option>
									<option value="2">农专社</option>
									<option value="3">个体户</option>
								</select>
							</div>
						</div>
						<div class="col-10 ipt-box pdr5">
							<input type="text" id="keyword" class="ipt-txt mr5" name="keyword" value="" placeholder="请输入企业名称、统一社会信用代码或注册号" >						
						</div>
					</div>
					<div class="fl ml5">
						<input id="searchBtn" type="button" value="查询" class="btn mr20">
					</div>
				</div>
			</div>
		</form>
	</div>

    <div class="table-out">
        <div>
            <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30" style="width: 100%;white-space: nowrap;">
                <thead>
                <tr>
                    <th style="padding:0 20px;">序号</th>
                    <th>年度</th>
                    <th>年度年报状态</th>
                    <th>主体类型</th>
                    <th>统一社会代码/注册号</th>
                    <th >企业名称</th>
                    <th >法定代表人</th>
                    <th >法人电话</th>
                    <th >企业联络员</th>
                    <th >联络员电话</th>
                    <th >住所</th>
                    <th >登记机关</th>
                </tr>
                </thead>
                <tbody></tbody>
            </table>
        </div>
    </div>
<script>
    window._CONFIG = {
       year:'${year}'
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/riskwarningdetail/rptreporteover_list.js"></script>
</body>
</html>
