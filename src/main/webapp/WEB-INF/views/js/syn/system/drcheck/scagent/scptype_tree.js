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
    			},
			 
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
			}
    };

    
    function zTreeOnCheck(event, treeId, treeNode) {
    	var zTree = $.fn.zTree.getZTreeObj("permisionTree");
        var  	nodes = zTree.getSelectedNodes();
    	alert(nodes);

    };
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
    }

    
    
    /**
     * 初始化树状结构
     */
    function ztreeInit() {
        http.httpRequest({
            url: '/syn/server/drcheck/pubscagent/treeListJSON',
            data:{"isPermissionCheck":window._CONFIG.isPermissionCheck},	
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
    			var nameA="";
    			var nameB="";
    			var nameC="";
    			var nameD="";
    			var returnName = "";
    			$.each(nodes, function(k, v) {
    				var code = v.id;
    				var nodeDesc = v.name;
    				if(code != "A" && code != "B" && code != "C" && code != "D"){
    					if(nodeDesc.indexOf("A") != -1){
    						if(nameA == ""){
    							nameA = nodeDesc;
    						}else{
    							nameA += "；"+nodeDesc;
    						}
    					}
    					if(nodeDesc.indexOf("B") != -1){
    						if(nameB == ""){
    							nameB = nodeDesc;
    						}else{
    							nameB += "；"+nodeDesc;
    						}
    					}
    					if(nodeDesc.indexOf("C") != -1){
    						if(nameC == ""){
    							nameC = nodeDesc;
    						}else{
    							nameC += "；"+nodeDesc;
    						}
    					}
    					if(nodeDesc.indexOf("D") != -1){
    						if(nameD == ""){
    							nameD = nodeDesc;
    						}else{
    							nameD += "；"+nodeDesc;
    						}
    					}
    				}
    			});
    			if(nameA != ""){
    				returnName = "A工商类：【"+nameA+"】";
    			}
    			if(nameB != ""){
    				if(returnName == ""){
    					returnName = "B食药类：【"+nameB+"】";
    				}else{
    					returnName += "；B食药类：【"+nameB+"】";
    				}
    			}
    			if(nameC != ""){
    				if(returnName == ""){
    					returnName = "C质监类：【"+nameC+"】";
    				}else{
    					returnName += "；C质监类：【"+nameC+"】";
    				}
    			}
    			if(nameD != ""){
    				if(returnName == ""){
    					returnName = "D公安类：【"+nameD+"】";
    				}else{
    					returnName += "；D公安类：【"+nameD+"】";
    				}
    			}
    			if(returnName==null||returnName==""){
    				layer.msg("请至少选择一项",{time:1000});
    				return false;
    			}
    			
            	var data=new Object();
      			data.returnname=returnName;
            	layer.close(data);
            }
        }])
    }

})