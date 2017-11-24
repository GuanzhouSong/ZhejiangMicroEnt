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
    				enable: true
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
            url: '/commom/server/codestreet/treeStreetListNoCheckJSON',
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
    			$.each(nodes, function(k, v) {
    				array += v.id + ",";
    				names[k]=v.name;
    				codes[k]=v.id;
    			});
            	  var data=new Object();
      		 
      			data.returncode=array; 
      			data.returncodes=codes.toString();
      			data.returnname=names.toString();
            	  layer.close(data);
            	  
            }
        }])
    }

})