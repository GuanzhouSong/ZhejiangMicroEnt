<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>添加勘察记录页面</title>
    <link rel="stylesheet" href="/css/reg.server.css">

</head>
<script type="text/javascript">
</script>
<body class="pd10">
<form id="registInfoForm">
	<input type="hidden" name="priPID" value="${priPID }">
	<input type="hidden" name="uid" value="${registSurver.uid }">
	<input type="hidden" name="id" value="${registSurver.id }">
    <div class="form-item clearfix">
        <label class="item-name col-2"><span class="light">*</span>勘查日期：</label>
        <div class="col-8">
            <div class="item-name left light">
                <input type="text" name="surverDate" class="ipt-txt inline-txt" readonly="readonly"
                       onclick="laydate()" value='<fmt:formatDate value="${registSurver.surverDate }" pattern="yyyy-MM-dd" />' />
            </div>
        </div>
    </div>
    <div class="form-item clearfix">
        <label class="item-name col-2"><span class="light">*</span>勘查人员：</label>
        <div class="col-8">
            <div class="item-name left light">
                <input type="text" value="${registSurver.surverName }" name="surverName" class="ipt-txt inline-txt" placeholder="添加多个人员，姓名请用逗号隔开" size="102">
            </div>
        </div>
    </div>
    <div class="form-item clearfix">
        <label class="item-name col-2">勘察情况：</label>
        <div class="col-8">
            <div class="ipt-box">
                <textarea maxlength="500" name="surverInfo" id="" cols="30" rows="3" class="ipt-txt min-height">${registSurver.surverInfo }</textarea>
            </div>
        </div>
    </div>
    <div class="center mt20">
        <input id="save" type="submit" class="btn mr20" value="保 存" style="margin-bottom: 50px">
        <input id="cancel" type="button" class="btn mr20" value="取 消" style="margin-bottom: 50px">
    </div>

</form>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/registinfo/registinfo_addrecord.js"></script>
</body>
</html>