require(['common/util', 'component/iframeLayer', 'common/http', 'handlebars', 'layer1', 'ztree', 'ztreeCheck'], function (util, layer, http, handlebars) {
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
    var zNodes = [];

    //加载部门树
    function loadTree() {
        var treeUrl = window._CONFIG.treeUrl;
        //部门树配置
        var setting = {
            async: {
                enable: true,
                url: treeUrl + '&t=' + new Date().getTime(),
                autoParam: ["orgCoding=porgCoding"],
                dataFilter: ajaxDataFilter
            },
            check: {
                enable: true,
                chkStyle: "checkbox",
                autoCheckTrigger: true,
                radioType: "level"
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
            callback: {
                onClick: zTreeOnMouseUp,
                beforeExpand: beforeExpand
            }
        };
        treeObj = $.fn.zTree.init($("#sysDepartTree"), setting, zNodes);
    }

    /**
     * 异步加载子节点时触发这个过滤器<br/>
     * 这个过滤器的目的是，根据父节点是否选中，来给子节点相应地设置是否选中属性
     * @param treeId
     * @param parentNode
     * @param responseData
     * @returns {*}
     */
    function ajaxDataFilter(treeId, parentNode, responseData) {
        if (responseData) {
            if(parentNode&&parentNode.checked){
                for(var i =0; i < responseData.length; i++) {
                    responseData[i].checked = true;
                }
            }
        }
        return responseData;
    };

    //部门树节点点击事件
    function zTreeOnMouseUp(event, treeId, treeNode) {
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
            if(treeNode.children==null){//如果部门节点下存在数据，则不进行异步加载
                ajaxGetNodes(treeNode, "refresh");
            }
            return true;
        } else {
            layer.msg("zTree 正在下载数据中，请稍后展开节点。。。", {ltype: 0, time: 2000});
            return false;
        }
    }

    //异步加载树节点
    function ajaxGetNodes(treeNode, reloadType) {
        var zTree = $.fn.zTree.getZTreeObj("sysDepartTree");
        if (reloadType == "refresh") {
            zTree.updateNode(treeNode,true);
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
                    if (nodes.length == 0) {
                        layer.msg("请选择部门", {ltype: 0, time: 2000});
                        return false;
                    } else {
                        /* if(nodes.length==1 &&nodes[0].pcode==0){
                         layer.msg("必须选择具体的部门", {ltype: 0,time:2000});
                         return false;
                         }*/
                        var adCodeStr = "";
                        var orgNameStr = "";
                        var orgCodeStr = "";
                        var adCodeStrExcParent = "";
                        var orgNameStrExcParent = "";
                        var orgCodeStrExcParent = "";
                        for (var a = 0; a < nodes.length; a++) {
                    		adCodeStr += nodes[a].adcode + ",";
                    		orgNameStr += nodes[a].orgName + ",";
                    		orgCodeStr += nodes[a].orgCoding + ","
                    		if(nodes[a].adcode.length==13){
                    			adCodeStrExcParent += nodes[a].adcode + ",";
                    			orgNameStrExcParent += nodes[a].orgName + ",";
                    			orgCodeStrExcParent += nodes[a].orgCoding + ","
                    		}
                        }
                        if (adCodeStr != "" && orgNameStr != "") {
                            adCodeStr = adCodeStr.substr(0, adCodeStr.length - 1);
                            orgNameStr = orgNameStr.substr(0, orgNameStr.length - 1);
                            orgCodeStr = orgCodeStr.substr(0, orgCodeStr.length - 1);
                        }
                        if (adCodeStrExcParent != "" && orgNameStrExcParent != "") {
                            adCodeStrExcParent = adCodeStrExcParent.substr(0, adCodeStrExcParent.length - 1);
                            orgNameStrExcParent = orgNameStrExcParent.substr(0, orgNameStrExcParent.length - 1);
                            orgCodeStrExcParent = orgCodeStrExcParent.substr(0, orgCodeStrExcParent.length - 1);
                        }
                        var data = new Object();
                        data.adCodes = adCodeStr;
                        data.orgNames = orgNameStr;
                        data.orgCodes = orgCodeStr;
                        data.adCodesExcParent = adCodeStrExcParent;
                        data.orgNamesExcParent = orgNameStrExcParent;
                        data.orgCodesExcParent = orgCodeStrExcParent;
                        layer.close(data);
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