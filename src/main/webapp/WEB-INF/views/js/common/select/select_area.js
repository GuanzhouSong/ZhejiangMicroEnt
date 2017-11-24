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
    //权限树配置
    var treeSetting = {
    		 
    			check: {
    				enable: true,
                    chkStyle: "radio",
    				chkboxType:{ "Y" : "s", "N" : "ps" }    //被勾选时：不关联父
    			},
			 
			data: {
				simpleData: {
					enable: true
				}
			},
 
			 
			callback: {
				//beforeClick: beforeClick,
				 
			}
    };

    /*function beforeClick(treeId, treeNode) {
    	var check = (treeNode && !treeNode.isParent);
    	if (!check)   layer.msg("父级不可选", {ltype: 0,time:500});;
    	return check;
    }*/

    
    /**
     * 初始化树状结构
     */
    function ztreeInit() {
        http.httpRequest({
            url: '/commom/server/regunit/selectAreaJSON',
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
            	var nodes = treeObj.getCheckedNodes(true);
    			var array = "";
    			var names= new Array();
    			var codes=new Array();
    			var flag =false;
    			$.each(nodes, function(k, v) {
    				if(flag){
    					array += v.id;
    					flag = true;
    				}else{
    					array += v.id + ",";
    				}
    				names[k]=v.name;
    				codes[k]=v.id;
    			});
    			
    			if(names==null||names==""){
    				layer.msg("请至少选择一项",{time:1000});
    				return false;
    			}
    			
            	  var data=new Object();
      		 
      			data.returncode=array; 
      			data.returncodes=codes.toString();
      			data.returnname=names.toString();
            	  layer.close(data);
            	  
            }
        }])
    }

})