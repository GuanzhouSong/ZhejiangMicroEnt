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
    <title>公示系统访问情况统计</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box mb5">
        <div class="form-list pdr8">
            <div class="form-item clearfix">
            	<div class="col-7">
                    <label class="item-name col-2">统计日期：</label>
                     <div class="ipt-box col-2">
                           <select name="rptyear" id="rptyear">
                           </select>
                    </div>
                    <div class="ipt-box col-2 mr-col-005">
                           <select name="rptmouth" id="rptmouth">
                           <option value="00" id="00">当前</option>
                           <option value="01" class="rm">1月</option>
                           <option value="02" class="rm">2月</option>
                           <option value="03" class="rm">3月</option>
                           <option value="04" class="rm">4月</option>
                           <option value="05" class="rm">5月</option>
                           <option value="06" class="rm">6月</option>
                           <option value="07" class="rm">7月</option>
                           <option value="08" class="rm">8月</option>
                           <option value="09" class="rm">9月</option>
                           <option value="10">10月</option>
                           <option value="11">11月</option>
                           <option value="12">12月</option>
                           </select>
                    </div>
                     <div class="ipt-box col-4">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly"  
                              name="endCheckPushDate" id="endCheckPushDate" value="${endCheckPushDate}"/>
                        </div>
                    </div>
                </div>
            </div>    
       </div>
        <div class="center mt10">
            <input type="button" id="search" value="查询" class="btn mr20">
            <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
        </div>
    </form>
</div>
    <div class="table-out">
        <div>
            <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30" style="width: 100%;white-space: nowrap;">
                <thead>
                <tr>
                <th>行次</th>
	            <th>年度</th>
	            <th>日期</th>
	            <th>访问量</th> 
                </tr>
                </thead>
                <tfoot>
	        <tr>
	            <th>合计</th>
	            <th>-</th>
	            <th>-</th>
	            <th></th>
	        </tr> 
	        </tfoot>
            </table>
        </div>
    </div>
<script>
    window._CONFIG = {
       year:'${year}',
       endCheckPushDate:'${endCheckPushDate}',
       month:'${month}'
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/rpt/pubsearchlogrpt_list.js"></script>
</body>
</html>
