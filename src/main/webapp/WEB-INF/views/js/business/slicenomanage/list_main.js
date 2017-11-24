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
                if(parentNode == null || parentNode.id.length > 6){
                	showPermision(treeNode.id, parentNode);
                }
                if(treeNode.id.length == 8){
                	$("#addBtn").show();
                }else{
                	$("#addBtn").hide();
                }
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
            url: '/reg/system/slicenomanage/list.json',
            success: function (data) {
                if (data.status == 'success') {
                    //初始化权限树
                    treeObj = $.fn.zTree.init($('#sliceNoTree'), treeSetting, data.data);
                    //默认展开
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
            url: '/reg/system/slicenomanage/selectDetail.json',
            data: {code: id},
            success: function (data) {
                if (data.status == 'success') {
                    var context = data.data;
                    if(context !=null){
	                    context.parentName = '--';
	                    if (parentNode) {
	                        context.parentName = parentNode.name;
	                    }
	                    if(context.type=='1'){context.type = "片区";}else if(context.type=='2'){context.type = "商圈";}
	                    //展示权限数据
	                    $('#showArea').html(viewTemplate(context));
                    }else{
                    	$(".text-left").text("");
                    }
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
            	   layer.msg('请选择某个管辖单位节点', {time: 1500});
            	   return false;
                }
                if(sid ==$("#code").val()){
                   layer.msg('责任区不能作为上级节点，请重新选择', {time: 1500});
             	   return false;
                }
                var sNodes = treeObj.getSelectedNodes();
                if (sNodes.length > 0) {
                	var content = sNodes[0].name;
                }
                layer.dialog({
                    title: '新增片区',
                    area: ['50%', '50%'],
                    content: '/reg/system/slicenomanage/show?sid=' + sid+'&supContent='+content,
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
                var code = $('#code').val();
                var sid = getFirstSelectedId();
                if (!code || sid !=$("#code").val()) {
                    layer.msg('请选择片区进行修改', {time: 1500});
                    return;
                }
                var sNodes = treeObj.getSelectedNodes();
                if (sNodes.length > 0) {
                	var content = sNodes[0].getParentNode().name;
                }
                layer.dialog({
                    title: '修改片区',
                    area: ['50%', '50%'],
                    content: '/reg/system/slicenomanage/show?code=' + code+'&supContent='+content,
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
                var code = $('#code').val();
                if (!code) {
                    layer.msg('请选择要删除的片区', {time: 1000});
                    return;
                }
                layer.confirm('确定要删除吗?', {icon: 2, title: '提示'}, function () {
	                http.httpRequest({
	                    type: 'post',
	                    url: '/reg/system/slicenomanage/delete',
	                    data: {code: code},
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