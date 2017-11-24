<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>农专社列表</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab"> 
    <form id="taskForm" class="form-box">
         <div class="form-list">
             <input type="hidden"  name="entTypeCatg" id="entTypeCatg" value="16,17" >
             <input type="hidden"  name="regState" id="regState" value="A,B,K,DA,X,Q" >
             <div class="form-item clearfix">
                 <div id="uniCode" class="col-4">
                     <label class="item-name col-5">统一代码/注册号：</label>
                     <div class="col-7">
                         <div class="ipt-box col-11">
                             <input type="text" class="ipt-txt" name="cidRegNO" value="" placeholder="请输入完整精确查询">
                         </div>
                     </div>
                 </div>
                 <div class="col-4" id="entName">
                     <label class="item-name col-5">企业名称：</label>
                     <div class="col-7">
                         <div class="ipt-box col-11">
                             <input type="text" class="ipt-txt" name="entName" value="" placeholder="可输入名称关键词查询"/>
                         </div>
                     </div>
                 </div>
                 <div class="col-4">
                     <label class="item-name col-5">登记机关：</label>
                     <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="regOrgQx" id="regOrg" value="${codeRegorg.code }"/>
                            <input type="text" readonly="readonly" class="ipt-txt" name="regOrgName" id="regOrgName" value="${codeRegorg.content }"/>
                        </div>
                     </div>
                 </div> 
             </div> 
              <div class="form-item clearfix">
                 <div class="col-4">
                     <label class="item-name col-5">法定代表人/负责人：</label>
                     <div class="col-7">
                         <div class="ipt-box col-11">
                              <input type="text" class="ipt-txt" name="leRep" value="" placeholder="可输入关键词查询"/>
                         </div>
                     </div>
                 </div>
                 <div class="col-4">
                     <label class="item-name col-5">管辖单位：</label>
                     	<div class="col-7">
                         	<div class="ipt-box col-11">
                             	<input type="hidden" class="ipt-txt" name="localAdm" id="localAdm" value="" />
	                            <input type="text" class="ipt-txt" id="localAdmName" value="" placeholder="请选择管辖单位" readonly="readonly"/>
	                            <span class="add-icon" id="choseregUnit">
	                                <i></i>
	                            </span>
                         	</div>
                     	</div>
                 	</div>
             </div>
             <div class="form-item clearfix mt10">
     				<div class="center">
                 		<input type="button"  id="search" value="查询" class="btn mr20">
                 		<input type="button"  id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
                	</div>
             </div>
           </div>
     </form>
     <div class="clearfix mb5 mt5">
     	<p class="fl"><input type="button" class="btn btn-sm mr5" value="返回" id="backpubOpanoMalySfcList"></p>
	 	<p class="fl"><input type="button" class="btn btn-sm mr5" value="列入异常申请" id="pubOpanoMalySfcapply"></p>
      </div>
     
     <div>
    <table id="user-table"  border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap"width="100%">
        <thead>
        <tr>
           <th style="padding:0 20px;">序号</th>
           <th>单选</th>
           <th>统一代码/注册号</th>
<!--            <th>注册号</th> -->
           <th>企业名称 </th>
           <th> 法定代表人 /负责人</th>
           <th>登记机关</th>
           <th>管辖单位</th>
        </tr>
        </thead>
    </table>
</div>
<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="{{this.class}}">{{this.text}}</button>
    {{/each}}
</script>
<script>
window._CONFIG = {
     _regOrg:'${codeRegorg.code }'
   }
</script>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/server/opanomaly/pubopanomaly/pubopanomalysfc/pubopanomalysfcapply_list_main.js"/>"></script>  

</body>
</html>