<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>岗位权限</title>
    <link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body>
<div class="pd20 clearfix post-permissions">
    <div class="col-3">
        <div class="fr mr40">
            <h4 class="ft14"><i class="xbt-icon icon-send-dept"></i><strong>岗位列表</strong></h4>
            <div class="">
                <ul class="ztree" id="post-list-tree"></ul>
            </div>
        </div>
    </div>
    <div class="col-8 information-input-box">
        <!-- 没有选中项时开始 -->
        <div class="empty center mt120 none"><h3>请先选中一个岗位！</h3></div>
        <!-- 没有选中项时结束 -->
        <h4 class="ft14"><strong>外资信息录入员</strong></h4>
        <ul class="ztree" id="information-input-tree"></ul>
        <p class="center mt40"><input type="button" class="btn mr5" value="提 交"/></p>
    </div>
</div>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="/js/lib/ztree/jquery.ztree.core.min.js"></script>
<script src="/js/lib/ztree/jquery.ztree.excheck.min.js"></script>
<script>

    var setting2 = {
        check: {
            enable: true,
            chkStyle: "radio",
            radioType: "level"
        },
        data: {
            simpleData: {
                enable: true
            }
        }
    };

    var zNodes2 =[
        { id:1, pId:0, name:"随意勾选 1", open:true},
        { id:11, pId:1, name:"随意勾选 1-1", open:true},
        { id:111, pId:11, name:"随意勾选 1-1-1"},
        { id:112, pId:11, name:"随意勾选 1-1-2"},
        { id:12, pId:1, name:"随意勾选 1-2", open:true},
        { id:121, pId:12, name:"随意勾选 1-2-1"},
        { id:122, pId:12, name:"随意勾选 1-2-2"},
        { id:2, pId:0, name:"随意勾选 2", open:true},
        { id:21, pId:2, name:"随意勾选 2-1"},
        { id:22, pId:2, name:"随意勾选 2-2", open:true},
        { id:221, pId:22, name:"随意勾选 2-2-1", checked:true},
        { id:222, pId:22, name:"随意勾选 2-2-2"},
        { id:23, pId:2, name:"随意勾选 2-3"}
    ];


    var setting = {
        check: {
            enable: true,
            chkDisabledInherit: true
        },
        data: {
            simpleData: {
                enable: true
            }
        }
    };

    var zNodes =[
        { id:1, pId:0, name:"随意勾选 1", open:true},
        { id:11, pId:1, name:"随意勾选 1-1", open:true},
        { id:111, pId:11, name:"disabled 1-1-1", chkDisabled:true},
        { id:112, pId:11, name:"随意勾选 1-1-2"},
        { id:12, pId:1, name:"disabled 1-2", chkDisabled:true, checked:true, open:true},
        { id:121, pId:12, name:"disabled 1-2-1", checked:true},
        { id:122, pId:12, name:"disabled 1-2-2"},
        { id:2, pId:0, name:"随意勾选 2", checked:true, open:true},
        { id:21, pId:2, name:"随意勾选 2-1"},
        { id:22, pId:2, name:"随意勾选 2-2", open:true},
        { id:221, pId:22, name:"随意勾选 2-2-1", checked:true},
        { id:222, pId:22, name:"随意勾选 2-2-2"},
        { id:23, pId:2, name:"随意勾选 2-3"}
    ];

    $(document).ready(function(){
        $.fn.zTree.init($("#information-input-tree"), setting, zNodes);
        $.fn.zTree.init($("#post-list-tree"), setting2, zNodes2);
//        $("#disabledTrue").bind("click", {disabled: true}, disabledNode);
//        $("#disabledFalse").bind("click", {disabled: false}, disabledNode);

    });

</script>
</body>
</html>