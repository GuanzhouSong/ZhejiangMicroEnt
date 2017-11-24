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
				chkStyle: "radio",
				radioType: "all"
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
     * 点击触发事件
     */
    function onClick(e, treeId, treeNode) {
    	var zTree = $.fn.zTree.getZTreeObj("permisionTree"),
    	nodes = zTree.getSelectedNodes(),
    	v = "";
    	c="";
    	nodes.sort(function compare(a,b){return a.id-b.id;});
    	for (var i=0, l=nodes.length; i<l; i++) {
    		v += nodes[i].name + ",";
    	    c+=nodes[i].id+",";
    	}
    	if (v.length > 0 ) v = v.substring(0, v.length-1);
    	 
      $("#values").text(v);
    	/*if(c.length>0){
    		c=c.substring(0,c.length-1);
    	http.httpRequest({
            url: '/admin/legtalmanager/department/selectDetail.json',
            data:{deptId:c},	
            success: function (data) {
            	//console.log(JSON.stringify(data));
            	$("#cityCode").val(data.data.deptInterfaceId);
            	zTree.expandAll(false);
            }
        });
    	}*/
    }

    
    
    /**
     * 初始化树状结构
     */
    function ztreeInit() {
        http.httpRequest({
            url: '/commom/server/regunit/treeRegUnitListNoCheckJSON?isPermissionCheck='+window._CONFIG.isPermissionCheck+'&content='+$.trim($("#tree-box-searchertree_Njjg").val()),
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
            	if(selectedCode.returncode==null||selectedCode.returncode==""){
					layer.msg("请选择单位",{time:1000});
				}else if(selectedCode.returncode.length != 8){
            		layer.msg("请选择最后一级",{time:1000});
            	}else{
					layer.close(selectedCode);
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