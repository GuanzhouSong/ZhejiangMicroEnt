require(['common/util', 'component/iframeLayer', 'common/http', 'handlebars', 'layer1', 'ztree', 'ztreeCheck'], function (util, layer, http, handlebars) {
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
        var treeType = window._CONFIG.treeType;
        if(treeType=="")treeType="checkbox";
        //部门树配置
        var setting = {
            check: {
                enable: true,
                chkStyle: treeType,
                radioType: "all"
            },
            data: {
                key: {
                    name: "deptName",
                    title: "deptName"
                },
                simpleData: {
                    enable: true,
                    idKey: "deptCode",
                    pIdKey: "pId"

                }
            },
            callback: {
            }
        };

        http.httpRequest({
            type: 'post',
            url: window._CONFIG.treeUrl+"?selectedCodes="+window._CONFIG.deptDutyCodes,
            success: function (data) {
                var treeData=data;
                var parentNode=new Object();
                parentNode.deptCode="0";
                parentNode.deptName="职能部门";
                parentNode.open="true";
                parentNode.nocheck="true";
                treeData.push(parentNode);
                treeObj = $.fn.zTree.init($('#tree'), setting, treeData);
            }
        });
    }

    function bind() {
        util.bindEvents([
            {
                el: '#ok',
                event: 'click',
                handler: function () {
                    var treeObj = $.fn.zTree.getZTreeObj("tree");
                    var nodes = treeObj.getCheckedNodes(true);
                    if (nodes.length == 0) {
                        layer.msg("请选择职能部门类型", {ltype: 0, time: 2000});
                        return false;
                    } else {
                        var deptCodes="";
                        var deptNames="";

                        for (var a = 0; a < nodes.length; a++) {
                            deptCodes += nodes[a].deptCode + ",";
                            deptNames += nodes[a].deptName + ",";
                        }
                        if (deptCodes != "" && deptNames != "") {
                            deptCodes = deptCodes.substr(0, deptCodes.length - 1);
                            deptNames = deptNames.substr(0, deptNames.length - 1);
                        }
                        var data = new Object();
                        data.deptCodes = deptCodes;
                        data.deptNames = deptNames;
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