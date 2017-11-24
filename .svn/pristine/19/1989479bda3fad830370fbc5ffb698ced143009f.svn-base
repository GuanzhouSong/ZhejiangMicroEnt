<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>岗位权限展现</title>
    <link rel="stylesheet" href="/css/sment/sment.server.css">
    <link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
</head>
<form id="roleSelectForm">
    <h3 class="h22-title center"></h3>
    <div class="pd10 bg-gray">
        <div class="border-bottom clearfix">
            <div class="fl w70p" style="width: 100%">
                <div class="col-offset-1 pdr10">
                    <table class="mb10">
                        <tr>
                            <td>
                                <div class="col-12" style="height:600px;overflow-y: scroll">
                                    <input type="hidden" value="${roleId}"/>
                                    <ul id="permisionTree" class="ztree"></ul>
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <p class="center mt10 mb10">
        <input type="button" id="save" class="btn mr20" value="提 交"/>
        <input type="button" class="btn" value="取 消"  id="cancel"/>
    </p>
</form>
<script>
    window._CONFIG = {
        type:'${type}',
        namespace:'${sessionScope.session_sys_user.userType=="1"?"/reg":"/syn"}'
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/business/sysuser/syspermision/role_permission_show.js"></script>
</body>
</html>