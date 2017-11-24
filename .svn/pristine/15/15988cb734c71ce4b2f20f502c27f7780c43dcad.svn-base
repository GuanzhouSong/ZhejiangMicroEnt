require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars',
 'jquery.validate', 'jquery.serialize', 'laydate', 'ztree', 'ztreeCheck'],
function(layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */

    function init() {
        formValid();
        ztreeInit();
        bind();
    }

    var treeObj = null;
    //权限树配置
    var treeSetting = {
        check: {
            enable: true,
            chkStyle:'radio',
            radioType:'all'
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        view: {
            fontCss: util.setHighlight // 高亮一定要设置，setHighlight是自定义方法
        },
        callback: {
            onClick: onClick,
            onCheck:onClick
        }
    };


    /**
     * 点击触发事件\check事件
     */
    function onClick(e, treeId, treeNode) {
        $('#localAdm').val(treeNode.id);
        $('#localAdmName').val(treeNode.name);
        $('#localAdmNamep').html(treeNode.name);
    }

    /**
     * 初始化树状结构
     */
    function ztreeInit() {
        http.httpRequest({
            url: '/commom/server/regunit/treeRegUnitListNoCheckJSON?isPermissionCheck=true',
            // url: '/commom/server/regunit/treeRegUnitListNoCheckJSON_Permission',
            success: function(data) {
                var treeData = data.data;
                treeObj = $.fn.zTree.init($('#permisionTree'), treeSetting, treeData);
            }
        });
    }

    /**
     * 表单验证
     */
    function formValid() {

        $('#registInfoForm').validate({
            submitHandler: function() {

                    var formParam = $('#registInfoForm').serializeObject();
                    if ($('#localAdm').val() == "" || $('#localAdm').val().length != 8) {
                        layer.msg("请选择正确的管辖单位！", {
                            time: 1000
                        });
                        return false;
                    }
                    http.httpRequest({
                        url: '/reg/server/registinfo/registinfo/batchDistribute',
                        serializable: true,
                        data: formParam,
                        type: 'post',
                        success: function(data) {
                            layer.msg(data.msg, {
                                time: 1000
                            },
                            function() {
                                layer.close({
                                    reload: true
                                });
                            });
                        }
                    })

            }
        })
    }

    function bind() {
        util.bindEvents([{
            el: '#cancel',
            event: 'click',
            handler: function() {
                layer.close();
            }
        },
            {
                el: '#qry',
                event: 'click',
                handler: function() {
                    var _key = $('#_key').val();
                        util.searchNode($('#_key').val(),"name",treeObj,layer);
                }
            }

        ])
    }

})