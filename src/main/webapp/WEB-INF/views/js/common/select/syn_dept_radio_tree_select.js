require(['common/util', 'component/iframeLayer', 'common/http', 'handlebars', 'layer1', 'ztree','ztreeCheck'], function (util, layer, http, handlebars) {
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        loadTree();
        bind();
       }

    var _node = null;
    //部门树对象
    var treeObj = null;

    //树数据
    var zNodes =[];


    //加载部门树
    function loadTree(){
        var treeUrl=window._CONFIG.treeUrl;
        //部门树配置
        var setting = {
            async: {
                enable: true,
                url: treeUrl+'&t=' + new Date().getTime(),
                autoParam:["orgCoding=porgCoding"]
            },
            check: {
            	enable: true,
				chkStyle: "radio",
				radioType: "all"
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
                onClick: zTreeOnMouseUp,//
                beforeExpand: beforeExpand
            }
        };

        treeObj=$.fn.zTree.init($("#sysDepartTree"), setting,zNodes);
    }

    //部门树节点点击事件
    function zTreeOnMouseUp(event, treeId, treeNode){
        $("#success").slideUp();
        _node = {
            parentNode: treeNode.getParentNode(treeNode),
            treeNode: treeNode,
            treeId: treeId
        };
    }


    //部门树展开时事件
    function beforeExpand(treeId, treeNode) {
        if (!treeNode.isAjaxing) {
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

    function bind() {
        util.bindEvents([
        {
            el: '#departmentSubmit',
            event: 'click',
            handler: function () {
            	var treeObj = $.fn.zTree.getZTreeObj("sysDepartTree");
				var nodes = treeObj.getCheckedNodes(true); 
				if(nodes.length == 0){
					layer.msg("请选择部门", {ltype: 0,time:2000}); 
					return false;
				}else{ 
                    var treeObj = $.fn.zTree.getZTreeObj("sysDepartTree");
                    var nodes = treeObj.getCheckedNodes(true);
				    var adCodeStr=nodes[0].adcode;

                    var orgNameStr=nodes[0].orgName;
                    var orgCodeStr=nodes[0].orgCoding;
                    var parentNode=nodes[0].getParentNode();
                    var data = new Object();

                    data.parentNode=parentNode;
                    data.adCode=adCodeStr;
 					data.orgName=orgNameStr;
 					data.orgCode=orgCodeStr;
                    //加载部门节点数据
                    http.httpRequest({
                        type: 'get',
                        url: '/common/system/sysdepart/query',
                        data: {id: nodes[0].id},
                        success: function (rlt) {
                            if (rlt.status == 'success') {
                                data.dutyCodes=rlt.data.dutyCodes;
                            }
                            layer.close(data);
                        }
                    });

			     }
            }
        },
        {
            el: '#departmentClose',
            event: 'click',
            handler: function () {
            	layer.close();
            }
        }
        ])
    }
})