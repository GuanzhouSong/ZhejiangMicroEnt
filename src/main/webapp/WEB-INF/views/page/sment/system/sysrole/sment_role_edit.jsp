<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>角色修改页面</title>
	<link rel="stylesheet" href="/css/sment/sment.server.css">
    <link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
</head>
<body>
<div class="container .container-fluid">
    <div class="clearfix mb10">
        <div class="col-6">
            <form class="form-list ml10 mr10" id="sysRoleForm">
                <input type="hidden" name="id" value="${sysRole.id}">
                <div class="form-item">
                    <label class="item-name">角色名称：</label>
                    <div class="ipt-box">
                        <input type="text" name="name" class="ipt-txt" placeholder="请输入角色名称"
                               value="${sysRole.name}">
                    </div>
                </div>
                <div class="form-item">
                    <label class="item-name">备注：</label>
                    <div class="ipt-box">
                        <textarea name="desc" rows="8" placeholder="请输入角色描述">${sysRole.desc}</textarea>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-6" style="height:520px;overflow-y: scroll">
            <h5>选择角色权限</h5>
            <ul id="permisionTree" class="ztree"></ul>
        </div>
    </div>
    <p class="center mt10 mb10">
        <input type="button" id="save" class="btn mr20" value="提 交"/>
        <input type="button" class="btn" value="取 消"  id="cancel"/>
    </p>
</div>
<script>
    var roleId = '${sysRole.id}';
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/sment/system/sysrole/sment_sysrole_edit.js"></script>
</body>
</html>