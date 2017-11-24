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
    				chkboxType:{ "Y" : "s", "N" : "ps" },
    				chkStyle:window._CONFIG.isPermissionCheck =='false'?'radio':'checkbox'
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
    	var treeUrl;
    	if(window._CONFIG.isMarkFlag == 'true'){
    		treeUrl = '/syn/server/drcheck/specialcheck/markTreeJSON';
    	}else{
    		treeUrl = '/syn/server/drcheck/specialcheck/treeListJSON';
    	}
        http.httpRequest({
            url: treeUrl,
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
            	var singleChoose = window._CONFIG.isPermissionCheck;
            	if(nodes.length > 1 && singleChoose =='false'){
            		layer.msg("只能选择一项",{time:1000});
    				return false;
            	}
    			var array = "";
    			var names= new Array();
    			var codes=new Array();
    			$.each(nodes, function(k, v) {
					array += v.id + ",";
    				names[k]=v.name;
    				codes[k]=v.id;
    			});
    			if(names==null||names==""){
    				layer.msg("请至少选择一项",{time:1000});
    				return false;
    			}
    			
            	  var data=new Object();
            	  
      			data.returncode=array; 
      			data.returnname=names.toString();
      			data.returncodes=codes.toString();
            	layer.close(data);
            	  
            }
        }])
    }

})