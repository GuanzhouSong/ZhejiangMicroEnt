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
            check: {
                enable: true,
                chkStyle: "checkbox",
                radioType: "all",
                chkboxType:{ "Y" : "s", "N" : "ps" }    
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
            }
        };
        http.httpRequest({
            type: 'post',
            url: window._CONFIG.treeUrl,
            success: function (data) {
                treeObj = $.fn.zTree.init($('#sysDepartTree'), setting, data);
            }
        });
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