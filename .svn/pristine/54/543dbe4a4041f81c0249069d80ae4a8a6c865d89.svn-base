<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date" />
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>邮件任务添加页面</title>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<form id="emailForm">
<input type="hidden" name="deptId" value="${deptId}" />
    <h3 class="h22-title center"></h3>
    <div class="pd10 bg-gray">
        <div class="clearfix">
            <div class="clear">
	            <div class="form-item ">
	                <div class="col-4">
	                    <div class="item-name col-4"><span class='light'>*</span>邮件任务名称：</div>
	                    <div class="col-6">
	                        <div class="ipt-box">
	                            <input type="text" name="taskName" class="ipt-txt" value="" required="required"/>
	                        </div>
	                    </div>
	                </div>
	                <div class="col-4">
	                    <div class="item-name col-4">任务开始日期：</div>
	                    <div class="col-6">
	                        <div class="ipt-box">
	                            <input type="text" name="startTime" onclick="" readonly="readonly" class="ipt-txt" value="<fmt:formatDate value='${now }' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
	                        </div>
	                    </div>
	                </div>
	                <div class="col-4">
	                    <div class="item-name col-3"></div>
	                    <div class="col-6">
	                        <div class="ipt-box">
	                        </div>
	                    </div>
	                </div>
                </div>
            </div>
            
            <div class="clear">
	            <div class="form-item ">
	                <div class="col-4">
	                    <div class="item-name col-4"><span class='light'>*</span>发送邮件内容：</div>
	                    <div class="col-6">
	                        <div class="ipt-box">
	                            <textarea name="taskContent" rows="5" cols="100" required="required"></textarea>
	                        </div>
	                    </div>
	                </div>
	                <div class="col-4">
	                    <div class="item-name col-4">发送邮件说明：</div>
	                    <div class="col-6">
	                        <div class="ipt-box">
	                        	<textarea name="emailInstruction" rows="5" cols="100"></textarea>
	                        </div>
	                    </div>
	                </div>
	                <div class="col-4">
	                    <div class="item-name col-3"></div>
	                    <div class="col-6">
	                        <div class="ipt-box">
	                        </div>
	                    </div>
	                </div>
                </div>
            </div>
            
            <div class="clear">
	            <div class="form-item ">
	                <div class="col-4">
	                    <div class="item-name col-4">设置人：</div>
	                    <div class="col-6">
	                        <div class="ipt-box">
	                            <input type="text" readonly="readonly" name="setName" class="ipt-txt"  value="${setName}" />
	                        </div>
	                    </div>
	                </div>
	                <div class="col-4">
	                    <div class="item-name col-4">设置日期：</div>
	                    <div class="col-6">
	                        <div class="ipt-box">
	                            <input type="text" readonly="readonly" name="setTime" class="ipt-txt" value="<fmt:formatDate value='${now }' pattern='yyyy-MM-dd'/>"/>
	                        </div>
	                    </div>
	                </div>
	                <div class="col-4">
	                    <div class="item-name col-3">设置部门：</div>
	                    <div class="col-6">
	                        <div class="ipt-box">
	                            <input type="text" readonly="readonly" name="deptName" class="ipt-txt"  value="${deptName}" />
	                        </div>
	                    </div>
	                </div>
                </div>
            </div>
        </div>
    </div>
    <p class="center mt10 mb10">
        <input type="submit" class="btn mr20" value="确定"/>
        <input type="button" class="btn" value="关闭"  id="cancel"/>
    </p>
</form>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/emailsend/emailshow.js"></script>
</body>
</html>