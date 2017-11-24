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
    <title>移出异常名录申请新增</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd20">
<form id="taskForm">
<div class="form-box">
    <div class="form-list pdr8">
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5">统一信用代码/注册号：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt" name="regNO" placeholder="可输入尾号后四位查询">
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">企业名称：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt" name="entName" placeholder="可输入名称关键词查询">
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">登记机关：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <input type="hidden" class="ipt-txt" name="regOrg" id="regOrg" value="${codeRegorg.code }"/>
                        <input type="text" readonly="readonly" class="ipt-txt" name="regOrgName" id="regOrgName" value="${codeRegorg.content }"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5">列入文号：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt" name="penDecNo">
                    </div>
                </div>
            </div> 
            <div class="col-4">
                <label class="item-name col-5">列入原因：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                       <input type="hidden" class="hidden_input" name="speCause" id="speCause" value=""/>
                       <input type="text" class="ipt-txt text-over" value="" placeholder="请选择列入原因" id="speCauseText" readonly="readonly"/>
                       <span class="add-icon" id="select-intercept_in">
                           <i></i>
                       </span>
                   </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">管辖单位：</label>
                	<div class="col-7">
                    	<div class="ipt-box col-12">
                        	<input type="hidden" class="hidden_input" name="localAdm" id="localAdm" value=""/>
                        <input type="text" class="ipt-txt" id="localAdmName" value="" placeholder="选择"  readonly="readonly"/>
                        <span class="add-icon" id="choseregUnit">
                            <i></i>
                        </span>
                    	</div>
                	</div>
            </div>                          
        </div>
        <div class="center mt10 mb10">
            <div class="btn-box">
                <input type="button" id="search" value="查 询" class="btn mr20">
                <input type="reset" id="reset" value="重 置" class="btn">
            </div>
        </div>
     </div>
</div>
</form>          
<div class="mb5 mt5">
    <button type="button" id="back" class="btn btn-sm">返回</button>
    <button type="button" id="moveApply" class="btn btn-sm">移出异常申请</button>
</div>
<div class="light-info mb5">
    <p class="light">提示：此处仅查询显示当前还未移出的列入经营异常名录信息。</p>
</div>
<table id="addmove_table" border="0" cellspacing="0" cellpadding="0" class="table-row" style="width: 100%;white-space: nowrap;"  cellspacing="0"  >
     <thead>
     <tr>
          <th style="padding:0 20px;">序号</th> 
          <th>操作</th> 
          <th>统一信用代码/注册号</th>
          <th>企业名称</th>
          <th>列入文号</th>
          <th>列入原因</th> 
          <th>列入日期</th>
          <th>决定机关</th>
          <th>登记机关</th>
          <th>管辖单位</th>
      </tr>
      </thead>
</table>
    
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="<c:url value="/js/reg/server/opanomaly/pubopanomaly/pubopadetail/pubopadetailaddmove_list.js"/>"></script>
<script>
    window._CONFIG = {
       _systemType:'${systemType}',
	   _regOrg:'${codeRegorg.code }'
     } 
</script>
</body>
</html>
