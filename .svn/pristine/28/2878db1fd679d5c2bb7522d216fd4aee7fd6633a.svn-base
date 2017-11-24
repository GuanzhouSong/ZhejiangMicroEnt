require(['common/util', 'component/iframeLayer', 'common/http', 'handlebars', 'layer1', 'ztree', 'ztreeCheck','ztreeHide'], function (util, layer, http, handlebars) {
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        loadTree();
        bind();
    }

    //部门树对象
    var treeObj = null;

    //加载部门树
    function loadTree() {
        var treeUrl = window._CONFIG.treeUrl;
        var treeType= window._CONFIG.treeType;
        if(treeType=="")treeType="checkbox";
        //部门树配置
        var setting = {
            check: {
                enable: true,
                chkStyle: treeType,
                autoCheckTrigger: true,
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
            }
        };
        http.httpRequest({
            type: 'post',
            url: treeUrl,
            success: function (data) {
                treeObj = $.fn.zTree.init($('#sysDepartTree'), setting, data);
                var tree = $.fn.zTree.getZTreeObj("sysDepartTree");
                beforeExpand(tree.getNodes(),tree);
            }
        });
    }
    //部门树展开时事件
    function beforeExpand(treeNodes,tree) {
        if(treeNodes!=null){
            hideNullNode(treeNodes,tree);
        }
    }

    /**
     * 以递归的形式隐藏子节点为空的节点
     * @param treeNode
     * @param treeObj
     */
    function hideNullNode(treeNode,treeObj){
        for(var i in treeNode){
            if(treeNode[i].children!=null){
                hideNullNode(treeNode[i].children,treeObj);
            }else{
                if(treeNode[i].isParent==true){
                    treeObj.hideNode(treeNode[i]);
                }
            }
        }
    }

    function bind() {
        util.bindEvents([
            {
                el: '#ok',
                event: 'click',
                handler: function () {
                    var data = new Object();
                    var treeObj = $.fn.zTree.getZTreeObj("sysDepartTree");
                    var nodes = treeObj.getCheckedNodes(true);
                    if(window._CONFIG.treeType=="radio"){
                        var parentNode=nodes[0].getParentNode();
                        data.parentNode=parentNode;
                    }
                    if (nodes.length == 0) {
                        layer.msg("请选择部门", {ltype: 0, time: 2000});
                        return false;
                    } else {
                        var adCodeStr = "";
                        var orgNameStr = "";
                        var orgCodeStr = "";
                        var adCodeStrExcParent = "";
                        var orgNameStrExcParent = "";
                        var orgCodeStrExcParent = "";
                        var dutyDeptCodeStr="";
                        var dutyDeptNamesStr="";
                        for (var a = 0; a < nodes.length; a++) {
                    		adCodeStr += nodes[a].adcode + ",";
                    		orgNameStr += nodes[a].orgName + ",";
                    		orgCodeStr += nodes[a].orgCoding + ","
                    		if(nodes[a].adcode.length==13){
                                adCodeStrExcParent += nodes[a].adcode + ",";
                                orgNameStrExcParent += nodes[a].orgName + ",";
                                orgCodeStrExcParent += nodes[a].orgCoding + ","
                                dutyDeptCodeStr += nodes[a].dutyDeptCode + ","
                                dutyDeptNamesStr += nodes[a].dutyDeptName + ","
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
                            dutyDeptCodeStr = dutyDeptCodeStr.substr(0, dutyDeptCodeStr.length - 1);
                            dutyDeptNamesStr = dutyDeptNamesStr.substr(0, dutyDeptNamesStr.length - 1);
                        }

                        data.adCodes = adCodeStr;
                        data.orgNames = orgNameStr;
                        data.orgCodes = orgCodeStr;
                        data.dutyDeptCodes = dutyDeptCodeStr;
                        data.dutyDeptNameStr = dutyDeptNamesStr;
                        data.adCodesExcParent = adCodeStrExcParent;
                        data.orgNamesExcParent = orgNameStrExcParent;
                        data.orgCodesExcParent = orgCodeStrExcParent;
                        layer.close(data);
                    }
                }
            },
            {
                el: '#cancle',
                event: 'click',
                handler: function () {
                    layer.close();
                }
            }
        ])
    }
})