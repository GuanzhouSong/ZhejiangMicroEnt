require(['common/util', 'component/iframeLayer', 'common/http', 'ztree', 'ztreeCheck','jquery.validate', 'common/validateRules',], function (util, layer, http) {

    init();

    /**
     * 初始化函数集合
     */
    function init() {
        formValid();
        ztreeInit();
        bind();
    }


    /**
     * 表单验证
     */
    function formValid() {
        $('#sysRoleForm').validate({
            onkeyup:false,
            rules: {
                name: {
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

    //权限树配置
    var treeSetting = {
        check: {
            enable: true,
            chkboxType: {Y: "ps", N: "s"}
        },
        view: {
            dblClickExpand: true,
            showLine: true
        },
        data: {
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "pId",
                rootPId: ""
            }
        }
    };

    /**
     * 角色权限
     */
    function ztreeInit() {
        http.httpRequest({
            url: '/sment/server/syspermision/list.json',
            success: function (data) {
                var treeData = data.data;

                //获取角色权限

                http.httpRequest({
                    type: 'post',
                    url: '/sment/server/sysrole/permisions.json',
                    data: {roleId: roleId},
                    success: function (data) {
                        var rolePermions = data.data;
                        $.each(treeData, function (i, nodeData) {
                            treeData[i].open = true
                            $.each(rolePermions, function (j, permision) {
                                if (permision.permisionId == nodeData.id) {
                                    treeData[i].checked = true;
                                }
                            });
                        })
                        //初始化权限树
                        treeObj = $.fn.zTree.init($('#permisionTree'), treeSetting, treeData);
                    }
                })
            }
        });
    }

    function bind() {
        util.bindEvents([{
            el: '#cancel',
            event: 'click',
            handler: function () {
                layer.close();
            }
        }, {
            el: '#save',
            event: 'click',
            handler: function () {
                if($("#sysRoleForm").valid()){
                    var nodes = treeObj.getCheckedNodes(true);
                    if (nodes.length < 1) {
                        layer.alert('请至少选择一项权限！');
                        return false;
                    }

                    var arr = [];
                    $.each(nodes, function (k, v) {
                        arr.push(v.id);
                    });

                    var formParam = {
                        id: $('input[name="id"]').val(),
                        name: $('input[name="name"]').val(),
                        desc: $('textarea[name="desc"]').val(),
                        permisions: arr
                    };

                    http.httpRequest({
                        url: '/sment/server/sysrole/save',
                        serializable: true,
                        data: formParam,
                        type: 'post',
                        success: function (data) {
                        	if(data.status == 'fail'){
                        		layer.msg(data.msg, {time: 1000});
                        		return ;
                        	}
                            layer.msg(data.msg, {time: 1000}, function () {
                                layer.close({reload: true});
                            });
                        }
                    })
                }
            }
        }])
    }

})