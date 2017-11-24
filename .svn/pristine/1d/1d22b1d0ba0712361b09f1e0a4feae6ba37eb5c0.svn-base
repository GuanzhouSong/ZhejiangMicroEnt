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
    //初始化部门节点显示
    var viewTemplate = handlebars.compile($('#viewTemplate').html());

    //树数据
    var zNodes =[];

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
				chkStyle: "checkbox",
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
        var parentNode = treeNode.getParentNode();

        showSysDepart(treeNode, parentNode);

    }
    //showDetail();//展现部门详细

    //$(".tbl").fadeIn();


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
                }
            }
        });
    }

    /**
     * 获取选中的部门节点ID
     * @returns {*}
     */
    function getFirstSelectedId() {
        var id;
        var treeObj = $.fn.zTree.getZTreeObj("sysDepartTree");
        if (treeObj) {
            var nodes = treeObj.getSelectedNodes();
            if (nodes.length > 0) {
                id = nodes[0].id;
            }
        }
        return id;
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
					debugger
					/* if(nodes.length==1 &&nodes[0].pcode==0){
						 layer.msg("必须选择具体的部门", {ltype: 0,time:2000});
						 return false;
					 }*/
					    var codeStr="";
						var contentStr="";
						var orgCodeStr="";
 						for(var a=0;a<nodes.length;a++){ 
							codeStr+=nodes[a].adcode+",";
							contentStr+=nodes[a].orgName+",";
							orgCodeStr+=nodes[a].orgCoding+","
 						}  
						if(codeStr!=""&&contentStr!=""){
							codeStr=codeStr.substr(0,codeStr.length-1);
							contentStr=contentStr.substr(0,contentStr.length-1); 
							orgCodeStr=orgCodeStr.substr(0,orgCodeStr.length-1);
						}
						var data=new Object(); 
						data.id=codeStr;
						data.deptName=contentStr;
						data.orgCode=orgCodeStr;
  						layer.close({reload:data});
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