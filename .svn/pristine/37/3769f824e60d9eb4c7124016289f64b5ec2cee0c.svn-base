require(['common/util', 'component/iframeLayer', 'common/http', 'handlebars', 'layer1', 'ztree'], function (util, layer, http, handlebars) {
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        ztreeInit();
        bind();
    }

    //权限树对象
    var treeObj = null;
    //初始化权限显示
    var viewTemplate = handlebars.compile($('#viewTemplate').html());

    //权限树配置
    var treeSetting = {
        view: {
            dblClickExpand: true,
            showLine: true
        },
        data: {
            simpleData: {
                enable: true,
                idKey: 'id',
                pIdKey: 'pId',
                rootPId: ''
            }
        },
        callback: {
            onClick: function (event, treeId, treeNode) {
                var parentNode = treeNode.getParentNode();
                showPermision(treeNode.id, parentNode);
            }
        }
    };

    /**
     * 角色权限
     */
    function ztreeInit() {
        //加载权限数据
        http.httpRequest({
            type: 'post',
            url: '/reg/server/yr/department/list.json',
            success: function (data) {
                if (data.status == 'success') {
                    //初始化权限树
                    treeObj = $.fn.zTree.init($('#departmentTree'), treeSetting, data.data);
                    treeObj.expandNode(treeObj.getNodes()[0], true, false, true);
                    showPermision();
                }
            }
        });
    }

    /**
     * 显示权限数据
     * @param id
     * @param parentNode
     */
    function showPermision(id, parentNode) {
        if (!id) {
            $('#showArea').html(viewTemplate());
            return;
        }
        
        //加载权限数据
        http.httpRequest({
            type: 'post',
            url: '/reg/server/yr/department/selectDetail.json',
            data: {deptId: id},
            success: function (data) {
                if (data.status == 'success') {
                    var context = data.data;
                    context.parentName = '--';
                    if (parentNode) {
                        context.parentName = parentNode.name;
                    }
                    context.isValid = (context.isValid == '1'?'是':'否');
                    //展示权限数据
                    $('#showArea').html(viewTemplate(context));
                }
            }
        });
    }

    /**
     * 获取选中的权限ID
     * @returns {*}
     */
    function getFirstSelectedId() {
        var id;
        if (treeObj) {
            var nodes = treeObj.getSelectedNodes();
            if (nodes.length > 0) {
                id = nodes[0].id;
            }
        }
        return id;
    }

    function bind() {
        util.bindEvents([{
            el: '#addBtn',
            event: 'click',
            handler: function () {
                //选中的权限ID
                var sid = getFirstSelectedId();
                
                if(sid==null||sid==""){
                	   layer.msg('请选择某个部门节点', {time: 1000});
                	   return false;
                }
                layer.dialog({
                    title: '新增部门',
                    area: ['600px', '550px'],
                    content: '/reg/server/yr/department/show?sid=' + sid,
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
                            ztreeInit();
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
                    layer.msg('请选择要修改的部门', {time: 1000});
                    return;
                }
                layer.dialog({
                    title: '修改部门',
                    area: ['600px', '550px'],
                    content: '/reg/server/yr/department/show?deptid=' + id,
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
                            ztreeInit();
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
                    layer.msg('请选择要删除的部门', {time: 1000});
                    return;
                }
                layer.confirm('确定要删除吗?', {icon: 2, title: '提示'}, function () {
	                http.httpRequest({
	                    type: 'post',
	                    url: '/reg/server/yr/department/delete',
	                    data: {deptId: id},
	                    success: function (data) {
	                        if (data.status == 'success') {
	                            if (data.msg) {
	                                layer.msg(data.msg, {time: 1000}, function () {
	                                    //删除成功重新加载
	                                    ztreeInit();
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
	                        layer.msg(errorMsg, {time: 1000});
	                    }
	                });
                })
            }
        }])
    }
})