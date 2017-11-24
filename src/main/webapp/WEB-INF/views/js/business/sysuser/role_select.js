require(['component/iframeLayer', 'component/dataTable','common/util', 'common/http', 'ztree','ztreeCheck','handlebars', 'jquery.validate', 'common/validateRules', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {

    init();

    /**
     * 初始化函数集合
     */
    function init() {
        formValid();
        bind();
    }

    /**
     * 表单验证
     */
    function formValid() {
        $('#roleSelectForm').validate({
            onkeyup:false,
            rules: {
                roleIds: {
                    required: true
                }
            },
            showErrors:function(errorMap,errorList){
                for(var i in errorMap){
                    layer.tips(errorMap[i],$('#sysRoleForm input[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
            },
            submitHandler: function () {

            }
        })
    }

    var treeObj = null;

    var treeSetting = {

        check: {
            enable: true,
            chkboxType:{ "Y" : "s", "N" : "ps" }    //被勾选时：不关联父
        },

        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            //beforeClick: beforeClick,
        }
    };

    function ztreeInit(role_id,role_name) {
        var type=window._CONFIG.type;
        var ids = new Array();
        $(":checkbox[class=roles_ck]:checked").each(function (k, v) {
            ids[k] = this.value;
        });
        var ckbox_checked=$("#"+role_id).prop("checked")?true:false;
        // if(type=="del"||!ckbox_checked){
        //     treeObj = $.fn.zTree.init($('#permisionTree'), treeSetting, "");
        //     return;
        // }
        var roleIds=role_id;
        $("#comment").html("角色-【"+role_name+"】对应的权限资源如下:");
        http.httpRequest({
            url: window._CONFIG.namespace+'/server/syspermision/list4roleIds.json',
            data: {roleIds:roleIds.toString()},
            success: function (data) {
                var treeData = data.data;
                $.each(treeData, function (i, nodeData) {
                    treeData[i].open = true;
                    treeData[i].checked = true;
                    if(type=="del"){
                        treeData[i].chkDisabled = true;
                    }
                })
                treeObj = $.fn.zTree.init($('#permisionTree'), treeSetting, treeData);
            }
        });

        http.httpRequest({
            url: window._CONFIG.namespace+'/server/syspermision/list4roleIds.json',
            data: {roleIds:ids.toString()},
            success: function (data) {
                var treeData = data.data;
                $.each(treeData, function (i, nodeData) {
                    treeData[i].open = true;
                    treeData[i].checked = true;
                    if(type=="del"){
                        treeData[i].chkDisabled = true;
                    }
                })
                treeObj = $.fn.zTree.init($('#permisionTreeAll'), treeSetting, treeData);
            }
        });
    }

    function batchSetRoleUser(formParam){
        http.httpRequest({
            url: window._CONFIG.namespace+'/server/sysuser/bathSetRole',
            data: formParam,
            type: 'post',
            success: function (data) {
                layer.msg(data.msg, {time: 2300}, function () {
                    layer.close({reload: true});
                });
            }
        })
    }

    function bind() {
        util.bindEvents([{
            el: '#cancel',
            event: 'click',
            handler: function () {
                layer.close();
            }
        }, {
            el: '.roles_ck',
            event: 'click',
            handler: function (event) {
                var roleId  = $(this).val();
                var rolename = $(this).attr("rolename");
                ztreeInit(roleId,rolename);
                // var confirmRoleUrl=window._CONFIG.namespace+'/server/syspermision/role_permission_show?roleId='+roleId;
                // layer.dialog({
                //     title: '请确认岗位角色',
                //     area: ['98%', '90%'],
                //     content: confirmRoleUrl,
                //     callback: function (data) {
                //         if (data.check) {
                //             ztreeInit();
                //         }else{
                //
                //         }
                //     }
                // })
            }
        }, {
            el: '#save',
            event: 'click',
            handler: function () {
                if($("#roleSelectForm").valid()){
                    var ids = new Array();
                    var roleNames=new Array();
                    $(":checkbox[class=roles_ck]:checked").each(function (k, v) {
                        ids[k] = this.value;
                        roleNames[k] = $(this).attr("rolename");
                    });
                    var formParam = {
                        type: $('input[name="type"]').val(),
                        userIds: $('input[name="userIds"]').val(),
                        roleIds: ids.toString()
                    };
                    var userNames=$("#userNames").val();
                    if(formParam.type=="del"){
                        layer.confirm('确定要为用户【'+userNames+'】批量删除角色【'+roleNames.toString()+'】?', {icon: 2, title: '删除角色提示'}, function (index) {
                            batchSetRoleUser(formParam);
                        });
                    }

                    if(formParam.type=="add"){
                        layer.confirm('确定要为用户【'+userNames+'】批量添加角色【'+roleNames.toString()+'】?', {icon: 3, title: '添加角色提示'}, function (index) {
                            batchSetRoleUser(formParam);
                        });
                    }
                }
            }
        }])
    }
})