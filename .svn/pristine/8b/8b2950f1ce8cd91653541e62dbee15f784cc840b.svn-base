require(['component/iframeLayer', 'component/dataTable','common/util', 'common/http', 'ztree','ztreeCheck','handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {
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
				onCheck: zTreeOnCheck
				 
			}
    };

	
    init();

    /**
     * 初始化函数集合
     */
    function init() {
        ztreeInit();
        bind();
    }

    var treeObj = null;

   
    /*function beforeClick(treeId, treeNode) {
    	var check = (treeNode && !treeNode.isParent);
    	if (!check)   layer.msg("父级不可选", {ltype: 0,time:500});;
    	return check;
    }*/
 
    function zTreeOnCheck(event, treeId, treeNode) {
        
    	var treeObj = $.fn.zTree.getZTreeObj("permisionTree"); 
    	var node=treeObj.getNodeByTId("permisionTree_7");
     
    	var nodes = treeObj.getCheckedNodes(true);
    	var selectedNodes=treeObj.getCheckedNodes();
    	$.each(nodes, function(k, v) { 
    		if(v.name=="无"){
    		treeObj.checkAllNodes(false);
    		treeObj.checkNode(node,true,true);
    		}else{
    			treeObj.checkNode(node,false,false);
    		} 
    		if(v.name=="有"){ 
        		treeObj.checkNode(node,false,false);
    		}
    		
    		
        });

    };
	 	
    
    /**
     * 点击触发事件
     */
    function beforeonClick(e, treeId, treeNode) {
    	 
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
    	 alert(v); 
      //$("#values").text(v);
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
    	var treeData =[
    	 			{ id:0, pId:0, name:"有", open:true},
    	 			{ id:1, pId:0, name:"行政许可信息"},
    	 			{ id:2, pId:0, name:"股东及出资信息"},
    	 			{ id:3, pId:0, name:"知识产权出质登记信息"},
    	 			{id:4,pId:0,name:"股权变更信息"},
    	 			{ id:5, pId:0, name:"行政处罚信息"}, 
    	 			{ id:23, pId:11, name:"无"}
    	 		];
    	 		
           
      treeObj = $.fn.zTree.init($('#permisionTree'), treeSetting, treeData); 
            
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
            	var treeObj = $.fn.zTree.getZTreeObj("permisionTree");
            	var nodes = treeObj.getCheckedNodes(true);
    			var array = "";
    			var names= new Array();
    			var codes=new Array();
    			$.each(nodes, function(k, v) { 
    	    				names[k]=v.name;
    	    				codes[k]=v.id; 
    				
    				 
    			});
            	  var data=new Object();
      			data.returncode=array;
      			data.returncodes=codes;
      			data.returnname=names.toString();
            	  layer.close(data);
            	  
            }
        }])
    }

})