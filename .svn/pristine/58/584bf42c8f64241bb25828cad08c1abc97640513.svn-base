<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>抽查任务名单指派页面</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
    <div class="pd10 bg-gray" style="margin-top: 10px;">
       <div class="form-list pdr10">
       <form id="taskForm" class="form-box mb5">
           <input type="hidden" name="uids" id="uids" value="${uids }">
           <input type="hidden" id="deptFlag" value="${deptFlag }">
           <input type="hidden" id="dutyDeptCode" value="${dutyDeptCode }">
           <div class="form-item clearfix">
	           <div class="col-12">
	                <label class="item-name col-4"><span style="color:red;">*</span>指派抽查机关至：</label>
	                <div class="col-7">
	                    <div class="ipt-box col-11">
	                        <input type="hidden" class="ipt-txt" name="appointLocalAdm" id="appointLocalAdm" value=""/>
	                        <input type="text" readonly="readonly" class="ipt-txt" id="localAdmName" value="" />
	                         <span class="add-icon" id="choseregUnit">
	                             <i></i>
	                         </span>
	                     </div>
	                 </div>
                </div>
           </div>
       </form>
    </div>
</div>
    <p class="center mt10 mb10">
        <input type="button" id="ok" value="确定" class="btn mr20">
        <input type="button" id="close" value="关闭" class="btn mr20">
    </p>
<script>
    window._CONFIG = {
	    chooseUrl:'${sysUser.userType == 2 ? "/syn" : "/reg"}'
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sccheck/scent/scent_appoint.js"></script>
</body>
</html>