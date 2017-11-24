<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body>
<div class="container .container-fluid">
    <div class="mb10 clearfix">
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
                    <textarea name="desc" rows="8" placeholder="请输入角色描述">${sysRole.desc}</textarea>
                </div>
            </form>
        </div>
        <div class="col-6">
            <h5>选择角色权限</h5>
            <ul id="permisionTree" class="ztree"></ul>
        </div>
    </div>
    <div class="row ml10 mt5">
        <button id="cancel" type="button" class="btn mr20">取消</button>
        <button id="save" type="button" class="btn">保存</button>
    </div>
</div>
<script>
    var roleId = '${sysRole.id}';
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js?v=138f208b85"></script>
<script src="/js/business/sysrole/edit_main.js?v=f14268f0e5"></script>
</body>
</html>