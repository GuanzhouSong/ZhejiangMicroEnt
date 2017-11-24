require(['common/util', 'component/iframeLayer', 'common/http', 'handlebars', 'layer1', 'ztree','ztreeCheck'], function (util, layer, http, handlebars) {
   
	 var illegaltreeSetting = {
	    		check: {
					enable: true,
					chkStyle: "checkbox",
					radioType: "level"
				},
				data: {
					simpleData: {
						enable: true
					}
				} 
			};
	init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
        initillegaltreeTree();
      }
    
   
    function initillegaltreeTree() { 
    	 
    	var dataArr = [
	        	{id: "1", name: "违反企业名称管理规定的行为"},
	        	{id: "2", name: "违反了公司清算相关规定"},
	        	{id: "3", name: "违法清算组依法报送清算报告的相关规定"},
	        	{id: "4", name: "不按规定使用企业名称的"} 
	        ]; 
         
    	//初始化权限树
        treeObj = $.fn.zTree.init($('#illegaltree'), illegaltreeSetting, dataArr);
 		  
    }

    function bind() {
        util.bindEvents([{
            el: '#tree-box-searcher',
            event: 'click',
            handler: function () {
            	 
            }
        },
        {
            el: '#illegaltreeSubmit',
            event: 'click',
            handler: function () {
            	
    				var treeObj = $.fn.zTree.getZTreeObj("illegaltree");
    				var nodes = treeObj.getCheckedNodes(true); 
    				if(nodes.length == 0){
    					layer.msg("请选择违法行为", {ltype: 0,time:2000}); 
    					return false;
    				}else{ 
    					var idStr="";
    					var nameStr="";
    					for(var a=0;a<nodes.length;a++){ 
    						if(a==nodes.length-1){
    							idStr+=nodes[a].id;
     							nameStr+=nodes[a].name;
 							}else{
 								idStr+=nodes[a].id+"、";
 	 							nameStr+=nodes[a].name+"、";
 							}
  						} 
    					var data=new Object(); 
    					data.id=idStr; 
    					data.name=nameStr;
    					data.type="save";
     					layer.close(data);
    			 }
            }
        },
        {
            el: '#illegaltreeClose',
            event: 'click',
            handler: function () {
            	layer.close({type:'cancel'});
            }
        }
        ])
    }
})