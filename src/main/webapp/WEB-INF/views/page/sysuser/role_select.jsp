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

    <title>岗位成员管理</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
</head>
<body class="pd10">
<form id="roleSelectForm">
    <h3 class="h22-title center"></h3>
    <div class="bg-gray">
        <div class="border-bottom clearfix">
            <div class="form-list border-bottom">
                    <div class="form-item clearfix">
                        <div class="col-4">
                            <%--<div class="col-12">--%>
                                    <input type="hidden" name="type" id="type" value="${type}"/>
                                    <input type="hidden" name="userIds" id="userIds" value="${userIds}"/>
                                    <input type="hidden"  id="userNames" value="${userNames}"/>

                                    <h5 class="h6-title mb10 mt10">点击角色名称，可在右侧预览角色对应的权限资源</h5>

                                    <c:forEach var="role" items="${allRoles}">
                                        <label style="line-width:215px;width: 255px;" roleid="${role.id}">
                                            <input class="roles_ck"  name="roleIds" type="checkbox" roleid="${role.id}" id="${role.id}" value="${role.id}" rolename="${role.name}" /> ${role.name}
                                        </label>
                                        <br/>
                                    </c:forEach>
                            <%--</div>--%>
                        </div>
                        <div class="col-4" style="height:600px;overflow-y: scroll">
                            <%--<div class="col-12">--%>
                                    <h5 id="comment" class="h6-title mb10 mt10">角色对应的权限资源预览</h5>
                                    <ul id="permisionTree" class="ztree" ></ul>
                            <%--</div>--%>
                        </div>
                        <div class="col-4" style="height:600px;overflow-y: scroll">
                            <%--<div class="col-12">--%>
                                    <h5  class="h6-title mb10 mt10">所有勾选的角色权限预览</h5>
                                    <ul id="permisionTreeAll" class="ztree" ></ul>
                            <%--</div>--%>
                        </div>
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
<script src="/js/business/sysuser/role_select.js"></script>
</body>
</html>