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
    <title>批量列入异常名录（企业、农专社）新增</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd20">
<form id="taskForm">
<div class="form-box">
    <div class="form-list pdr8">
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-4">列入对象：</label>
                  <div class="col-8">
                        <div class="ipt-box col-12">
                            <input type="radio" name="batchEntType" checked="checked" value="1" id="qy">内资企业
                            <input type="radio" name="batchEntType" value="3" id="nz">外资企业
                            <input type="radio" name="batchEntType" value="2" id="gt">农专社
                        </div>
                  </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">成立日期：</label>
                <div class="col-7">
                    <div class="ipt-box col-575">
                        <input type="text" class="ipt-txt laydate-icon"  name="estDateStart" id="startEstDate" value="" readonly="readonly"/>
                    </div>
                    <span class="item-line col-05">-</span>
                    <div class="ipt-box col-575">
                        <input type="text" class="ipt-txt laydate-icon" name="estDateEnd" id="endEstDate" value="" readonly="readonly"/>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">登记机关：</label>
                <div class="col-7">
                      <div class="ipt-box col-12">
                            <input type="text" readonly="readonly" class="ipt-txt" id="regOrgContent" value="${codeRegorg.content }"/>
                            <input type="hidden" class="ipt-txt" name="decorgCN" id="decorgCN" value="${codeRegorg.content }"/>
                            <input type="hidden" class="ipt-txt" name="decOrg" id="decOrg" value="${codeRegorg.code }"/>
                      </div>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <div class="col-4">
                  <label class="item-name col-4">年报年度：</label>
                  <div class="col-7">
                      <div class="ipt-box col-12">
                           <select name="year">
	        		           <option value="${year-1}">${year-1}</option>
                           </select>
                      </div>
                  </div>
	         </div>
            <div class="col-4">
                  <label class="item-name col-5">个转企：</label>
                  <div class="col-7">
                      <div class="ipt-box col-12">
                           <select name="isIndivid">
	        		           <option value="">全部</option>
	        		           <option value="1">是</option>
	        		           <option value="0">否</option>
                           </select>
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
        <div class="form-item clearfix">
            <div class="col-4">
                  <label class="item-name col-4">统一代码：</label>
                  <div class="col-7">
                      <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="uniSCID" value=""/>
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
    <span class="light"><strong>全部全选</strong></span><input type="checkbox" id="checkBatchAll">
    <button type="button" id="back" class="btn btn-sm">返回</button>
    <button type="button" id="batchin" class="btn btn-sm">未年报成批列异</button>
    <button type="button" id="js-download" class="btn btn-sm">导出全部</button>
	注：导出全部最多支持2万条，请务必先填写条件，查询出不要超过2万条的数据，再点击全部导出。
</div>
<div style="display: none">
	<form action="/reg/server/opanomaly/pubopanomaly/batchAllDownLoad" method="post" name="_form">
		<input type="hidden" name="map" id="map">
	</form>
</div>
<div class="light-info mb5">
    <p class="light">提示：此处仅查询本部门登记且当前年报年度属于未按时年报情形尚未被列入异常的在册企业、农专社。</p>
</div>
<table id="addmove_table" border="0" cellspacing="0" cellpadding="0" class="table-row" style="width: 100%;white-space: nowrap;"  cellspacing="0"  >
     <thead>
     <tr>
          <th style="padding:0 20px;">序号</th> 
          <th>全选 <input type="checkbox" id="checkAll"></th> 
          <th>年度</th>
          <th>统一代码/注册号</th>
          <th>企业名称</th>
          <th>类型</th>
          <th>成立日期</th> 
          <th>个转企</th>
          <th>个转企日期</th>
          <th>登记机关</th>
          <th>管辖单位</th>
      </tr>
      </thead>
</table>
    
<!-- <input type="text" id="js-pripid" value="123456"> -->
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="<c:url value="/js/reg/server/opanomaly/pubopanomaly/pubopanomalyent/pubopanomalybatchadd_list.js"/>"></script>
<script>
    window._CONFIG = {
       _decorgCN:'${codeRegorg.content}',
       _decOrg:'${codeRegorg.code}'
     } 
</script>
</body>
</html>
