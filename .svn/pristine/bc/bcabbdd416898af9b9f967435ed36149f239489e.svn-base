require(['component/iframeLayer', 'component/dataTable','common/util', 'common/http', 'ztree','ztreeCheck','handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {
	
	
    $(function(){
    	
    	   
    	
    	    //权限树配置
    	    var treeSetting = {
    	    	
    	    			check: {
    	    				enable: true,
    	    				chkboxType:{ "Y" : "s", "N" : "ps" }    
    	    			},
    				data: {
    		           	key: {
    		                   name: "areaName",
    		                   title: "areaName"
    		               },
    		               simpleData: {
    		                   enable: true,
    		                   idKey: 'areaCode',
    		                   pIdKey: 'parentid',
    		                   rootPId: ''
    		               }
    		           },
    	 
    				 
    				callback: {
    					//beforeClick: beforeClick,
    					 
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
     
     function ztreeInit() {
         //加载权限数据
         http.httpRequest({
             type: 'post',
             url: '/sment/areatype/list.json',
             success: function (data) {
                 //初始化权限树
            	 debugger;
                 treeObj = $.fn.zTree.init($('#permisionTree'), treeSetting, data);
             }
         });
     }

    

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
             	debugger;
             	var nodes = treeObj.getCheckedNodes(true);
     			var array = "";
     			var names= new Array();
     			var codes=new Array();
     			$.each(nodes, function(k, v) {
     				array += v.areaCode + ",";
     				names[k]=v.areaName;
     				codes[k]=v.areaCode;
     			});
             	  var data=new Object();
       		 
       			data.returncode=array; 
       			data.returncodes=codes.toString();
       			data.returnname=names.toString();
             	  layer.close(data);
             	  
             }
         }])
     }
	});
	
   
    
  
   

})