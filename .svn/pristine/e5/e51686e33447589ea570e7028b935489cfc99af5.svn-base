require(['common/util', 'component/iframeLayer', 'common/http', 'handlebars', 'layer1', 'ztree'], function (util, layer, http, handlebars) {
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        showNodeOptBtn(null);
        loadTree();
        bind();
    }
    var _node = null;
    //部门树对象
    var treeObj = null;
    //初始化部门节点显示
    var viewTemplate = handlebars.compile($('#viewTemplate').html());

    //树数据
    var zNodes =[];

    function showNodeOptBtn(context){
        var optBtnsTemplate = handlebars.compile($('#optBtnsTemplate').html());
        $('#optBtns').html(optBtnsTemplate(context));
    }

    //加载部门树
    function loadTree(){
        var treeUrl=window._CONFIG.treeUrl;
        //部门树配置
        var setting = {
            async: {
                enable: true,
                url: treeUrl+'?t=' + new Date().getTime(),
                autoParam:["orgCoding=porgCoding"]
            },
            check: {
                enable: true,
                chkboxType: { "Y": "s", "N": "s" }
            },
            data: {
                key: {
                    name: "orgName",
                    title: "orgName"
                },
                simpleData: {
                    enable: true,
                    idKey: "orgCoding",
                    pIdKey: "porgCoding"
                }
            },
            callback:{
                onClick: treeNodeClicked,//
                beforeExpand: beforeExpand
            }
        };

        treeObj=$.fn.zTree.init($("#sysDepartTree"), setting,zNodes);
    }

    //部门树节点点击事件
    function treeNodeClicked(event, treeId, treeNode){
        $("#success").slideUp();
        _node = {
            parentNode: treeNode.getParentNode(treeNode),
            treeNode: treeNode,
            treeId: treeId
        };
        var parentNode = treeNode.getParentNode();
        showSysDepart(treeNode, parentNode);
    }

    //部门树展开时事件
    function beforeExpand(treeId, treeNode) {
        if (!treeNode.isAjaxing) {
            startTime = new Date();
            treeNode.times = 1;
            ajaxGetNodes(treeNode, "refresh");
            return true;
        } else {
            alert("zTree 正在下载数据中，请稍后展开节点。。。");
            return false;
        }
    }

    //异步加载树节点
    function ajaxGetNodes(treeNode, reloadType) {
        var zTree = $.fn.zTree.getZTreeObj("sysDepartTree");
        if (reloadType == "refresh") {
            zTree.updateNode(treeNode);
        }
        zTree.reAsyncChildNodes(treeNode, reloadType, true);
    }


    /**
     * 显示部门节点数据
     * @param id
     * @param parentNode
     */
    function showSysDepart(treeNode, parentNode) {
        if (!treeNode.id) {
            $('#showArea').html(viewTemplate());
            return;
        }
        $(".form-header").html("部门管理 - " + treeNode.orgName);
        //加载部门节点数据
        http.httpRequest({
            type: 'post',
            url: '/syn/system/sysdepart/query',
            data: {id: treeNode.id},
            success: function (data) {
                if (data.status == 'success') {
                    var context = data.data;
                    context.parentName = '--';
                    if (parentNode) {
                        context.parentName = parentNode.orgName;
                    }
                    //展示部门节点数据
                    $('#showArea').html(viewTemplate(context));
                    showOptBtnsByDepartInfo(context);
                }
            }
        });
    }

    /**
     * 显示对部门节点的操作按钮
     * @param sysdepart
     */
    function showOptBtnsByDepartInfo(sysdepart){
        var btnOption=new Object();
        var adcode=sysdepart.adcode;
        if(adcode!=undefined&&adcode.length==13){
            btnOption.delBtn="Y";
            btnOption.editBtn="Y";
        }
        if(adcode!=undefined&&adcode.length > 13){
            btnOption.delBtn="Y";
            btnOption.editBtn="Y";
        }
        if(sysdepart.orgCoding=='001003'||sysdepart.orgCoding.length==12||sysdepart.orgCoding.length==15){
            btnOption.addBtn='Y';
        }
        console.log(btnOption);
        showNodeOptBtn(btnOption);
    }

    function bind() {
        util.bindEvents([{
            el: '#addBtn',
            event: 'click',
            handler: function () {
                var treeNode=_node.treeNode;
                //选中的部门节点ID
                var sid = treeNode.id;
                layer.dialog({
                    title: '新增部门节点',
                    area: ['628px', '500px'],
                    content: '/syn/system/sysdepart/show?sid=' + sid,
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
                            //loadTree();
                    }
                    }
                })
            }
        }, {
            el: '#editBtn',
            event: 'click',
            handler: function () {
                var id = $('#id').val();
                if (!id) {
                    layer.msg('请选择要修改的部门节点', {time: 500});
                    return;
                }
                layer.dialog({
                    title: '修改部门节点',
                    area: ['628px', '500px'],
                    content: '/syn/system/sysdepart/show?id=' + id,
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
                            //loadTree();
                        }
                    }
                })
            }
        }, {
            el: '#delBtn',
            event: 'click',
            handler: function () {

                var id = $('#id').val();
                if (!id) {
                    layer.msg('请选择要修改的部门节点', {time: 500});
                    return;
                }
                layer.confirm('确定要删除该节点吗?', {icon: 2, title: '提示'}, function (index) {
                    http.httpRequest({
                        type: 'post',
                        url: '/syn/system/sysdepart/delete',
                        data: {id: id},
                        success: function (data) {
                            if (data.status == 'success') {
                                if (data.msg) {
                                    layer.msg(data.msg, {time: 500}, function () {
                                        //删除成功重新加载
                                        //loadTree();
                                    });
                                }
                                return;
                            }
                            var errorMsg = data.msg;
                            var errors = data.errors;
                            if (errors.length > 0) {
                                for (var i = 0; i < errors.length; i++) {
                                    errorMsg += '<br/>' + (i + 1) + '：' + errors[i].field + errors[i].info;
                                }
                            }
                            layer.msg(errorMsg, {time: 5000});
                        }
                    });
                });
            }
        }])
    }
})