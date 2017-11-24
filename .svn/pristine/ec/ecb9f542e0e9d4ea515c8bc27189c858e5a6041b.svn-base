require(['component/iframeLayer', 'component/dataTable','common/util', 'common/http', 'ztree','ztreeCheck','handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {

    init();

    /**
     * 初始化函数集合
     */
    function init() {
        ztreeInit();
        bind();
    }

    var treeObj = null;
    var selectedCode=new Object();
    //权限树配置
    var treeSetting = {
    		view: {
    			dblClickExpand: true,
    			showLine: true
    		},
    			check: {
    				enable: true,
    				chkboxType:{ "Y" : "s", "N" : "ps" }    //被勾选时：不关联父
    			},
			 
			data: {
				simpleData: {
					enable: true
				}
			},
			check: {
				enable: true,
				chkStyle: "checkbox",
				radioType: "level"
			},     
			
			 
			callback: {
				onCheck: function (event, treeId, treeNode) {
					getSelectedDeptCode(treeNode);
				}
				 
			}
    };

    function getSelectedDeptCode(treeNode){
	 
    	if (treeNode) {
			selectedCode=new Object();
			selectedCode.returname=treeNode.name;
			selectedCode.returncode=treeNode.id;
		}
	}
    
    
    /**
     * 初始化树状结构
     */
    function ztreeInit() {
        http.httpRequest({
            url: '/commom/server/regunit/treeRegUnitListNewNoCheckJSON?isPermissionCheck='+window._CONFIG.isPermissionCheck+'&content='+$.trim($("#tree-box-searchertree_Njjg").val()),
            success: function (data) {
                var treeData = data.data;  
                      treeObj = $.fn.zTree.init($('#permisionTree'), treeSetting, treeData); 
            }
        });
    }

    function bind() {
        util.bindEvents([{
            el: '#cancel',
            event: 'click',
            handler: function () {
                layer.close();
            }
        }, {
            el: '#save',
            event: 'click',
            handler: function () {
            	var codes = "";
            	var names = "";
    			var treeObj = $.fn.zTree.getZTreeObj("permisionTree");
				var nodes = treeObj.getCheckedNodes(true);
				if(nodes.length > 0 ){
					 for(var a=0;a<nodes.length;a++){ 
						codes+=nodes[a].id+",";
						names+=nodes[a].name+",";
					}  
					if(codes!=""&&names!=""){
						codes=codes.substr(0,codes.length-1);
						names=names.substr(0,names.length-1);
					}
                    layer.close({
                        names: names,
                        codes: codes
                    });
				 }else{
					layer.msg("请选择一个部门"); 
				 } 
            	
            }
        },
        {
            el: '#tree-box-searcher',
            event: 'click',
            handler: function () {
            	ztreeInit();
            }
        }
        ])
    }

})