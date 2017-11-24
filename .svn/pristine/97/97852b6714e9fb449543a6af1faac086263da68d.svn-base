<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>添加惩戒企业</title>
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body>
<div class="form-list send-message">
    <form id="taskForm">
      <input type="hidden" class="ipt-txt" id="type" name="type" value="${type}">
      <input type="hidden" class="ipt-txt" id="key" name="key" value="">
	</form> 
    <div class="form-item clearfix">
        <label class="item-name col-3"></label>
        <div class="col-6">
            <div class="ipt-box">
                <input type="text" id="keyword" class="ipt-txt " style="width:61%"placeholder="请输入完整的企业名称或统一信用代码精确查询">
                <input type="button" id="searchEnt" class="btn btn-xs chose" value="查询">
            </div>
        </div>
    </div>
   
    <input type="hidden" class="ipt-txt" id="priPID" value="">
    
    <div class="form-item clearfix">
        <label class="item-name col-3">统一社会信用码：</label>
        <div class="col-6">
            <div class="ipt-box">
                <input type="text" class="ipt-txt" id="uniCode" value="" disabled="disabled">
            </div>
        </div>
    </div>
    <div class="form-item clearfix">
        <label class="item-name col-3">企业名称：</label>
        <div class="col-6">
            <div class="ipt-box">
                <input type="text" class="ipt-txt" id="entName" value="" disabled="disabled">
            </div>
        </div>
    </div>
    <div class="form-item clearfix">
        <label class="item-name col-3"></label>
        <div class="col-6">
            <div class="ipt-box light" style="font-size: 10px">
                	企业当前的法定代表人（负责人）信息如果与惩戒时的信息不一致，请按照惩戒时的法定代表人（负责人）信息进行录入。
            </div>
        </div>
    </div>
    <div class="form-item clearfix">
        <label class="item-name col-3">法定代表人(负责人)：</label>
        <div class="col-6">
            <div class="ipt-box">
                <input type="text" class="ipt-txt" id="leRep" value="">
            </div>
        </div>
    </div> 
    <div class="form-item clearfix">
        <label class="item-name col-3">身份证号：</label>
        <div class="col-6">
            <div class="ipt-box">
                <input type="text" class="ipt-txt" id="cardNo" value="">
            </div>
        </div>
    </div> 
    <div class="clearfix mb5">
        <span class="light">失信联合惩戒记录有<span id="totalCount">0</span>条。</span>
    </div>
    <div class="table-out">
	    <table id="record_table" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap">
	        <thead>
	        <tr>
	            <th>序号</th>
	            <th>法律文书编号</th>
	            <th>文书日期</th>
	            <th>惩戒领域</th>
	            <th>惩戒事由</th>
	            <th>惩戒措施</th>
	            <th>惩戒期限</th>
	            <th>惩戒执行部门</th>
	            <th>惩戒提请部门</th>
	            <th>提请人</th>
	            <th>提请日期</th>
	            <th>审核人</th>
	            <th>审核日期</th>
	        </tr>
	        </thead>
	    </table>
	</div><br>
    <div class="form-item clearfix col-offset-3">
        <div class="ml60">
            <input type="submit" id="confirm"   value="提 交" class="btn mr20">
            <input type="submit" id="close" value="关 闭" class="btn">
        </div>
    </div>
</div>
<script>
	var userType = '${sessionScope.session_sys_user.userType}';
	var urlHead = '/syn';
	if(userType==1){
		urlHead='/reg/server';
	}
    window._CONFIG = {
   		urlHead: urlHead
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/nocreditPunish/info/select_ent.js"></script>
</body>
</html>