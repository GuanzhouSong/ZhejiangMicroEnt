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
            url: window._CONFIG.sysUrl+'/sccheck/pubscworkplan/pubScWorkPlanTree?planYear='+window._CONFIG.planYear,
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
                    if (nodes.length == 0) {
                        layer.msg("请选择年度抽查工作计划", {ltype: 0, time: 2000});
                        return false;
                    } else {
                    	if(window._CONFIG.treeType=="radio"){
                            if(nodes[0].adcode=="0"){
                            	layer.msg("请选择具体的年度抽查工作计划", {ltype: 0, time: 2000});
                                return false;
                            }
                        }  
                        var adCodeStr = "";
                        var orgNameStr = "";
                        var orgCodeStr = "";
                        var dutyDeptCode="";
                        var dutyDeptName="";
                        for (var a = 0; a < nodes.length; a++) {
                        		dutyDeptCode += nodes[a].dutyDeptCode + ",";
                        		dutyDeptName += nodes[a].dutyDeptName + ",";
                    			adCodeStr += nodes[a].adcode + ",";
                        		orgNameStr += nodes[a].orgName + ",";
                        		orgCodeStr += nodes[a].orgCoding + ","
                        }
                        if (adCodeStr != "" && orgNameStr != ""&&orgCodeStr!="") {
                            adCodeStr = adCodeStr.substr(0, adCodeStr.length - 1);
                            orgNameStr = orgNameStr.substr(0, orgNameStr.length - 1);
                            orgCodeStr = orgCodeStr.substr(0, orgCodeStr.length - 1);
                            dutyDeptCode = dutyDeptCode.substr(0, dutyDeptCode.length - 1);
                            dutyDeptName = dutyDeptName.substr(0, dutyDeptName.length - 1);
                        } 
                        data.adCodes = adCodeStr;
                        data.orgNames = orgNameStr;
                        data.orgCodes = orgCodeStr; 
                        data.dutyDeptCode = dutyDeptCode;
                        data.dutyDeptName = dutyDeptName;
                        data.closeFlag="1";
                        layer.close(data);
                    }
                }
            },
            {
                el: '#cancle',
                event: 'click',
                handler: function () {
                	var data = new Object();
                	data.closeFlag="0";
                    layer.close();
                }
            }
        ])
    }
})