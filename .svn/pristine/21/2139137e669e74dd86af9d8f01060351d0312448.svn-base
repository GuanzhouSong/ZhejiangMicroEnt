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
	        	{id: "1", name: "你企业营业期限有变动"},
	        	{id: "2", name: "你企业的隶属关系发生变动"},
	        	{id: "3", name: "你企业的分支机构（分公司）有变动"},
	        	{id: "4", name: "你企业的从业人员情况发生变化"},
	        	{id: "5", name: "你企业的经营场所有变动"} ,
	        	{id: "6", name: "公司类型发生变化"} ,
	        	{id: "7", name: "你企业住所（地址）已发生变化"} ,
	        	{id: "8", name: "你企业的出资人及出资情况发生变化"} ,
	        	{id: "9", name: "你个人独资企业投资人的姓名和居所的隶属关系发生变化"} ,
	        	{id: "10", name: "你个人独资企业的投资人出资额和出资方式发生变化"} ,
	        	{id: "11", name: "你合伙企业执行事务合伙人发生变化"} ,
	        	{id: "12", name: "你企业的资金数额发生变化"}, 
	        	{id: "13", name: "你企业的经营方式发生变化"}, 
	        	{id: "14", name: "你企业的经营期限"} ,
	        	{id: "15", name: "你企业的经济性质发生变化"}, 
	        	{id: "16", name: "你企业的实收资本有变动"} ,
	        	{id: "17", name: "你企业的注册资本（金）发生变化"} ,
	        	{id: "18", name: "你企业的法定代表人（负责人）有变动"} ,
	        	{id: "19", name: "企业名称有变动"} 
	        ]; 
         
    	//初始化权限树
        treeObj = $.fn.zTree.init($('#registrationtree'), illegaltreeSetting, dataArr);
 		  
    }

    function bind() {
        util.bindEvents([{
            el: '#tree-box-searcher',
            event: 'click',
            handler: function () {
            	 
            }
        },
        {
            el: '#registrationtreeSubmit',
            event: 'click',
            handler: function () {
            	
    				var treeObj = $.fn.zTree.getZTreeObj("registrationtree");
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
    					data.type="save";
    					data.name=nameStr;
     					layer.close(data);
    			 }
            }
        },
        {
            el: '#registrationtreeClose',
            event: 'click',
            handler: function () {
            	layer.close({type:'cancel'});
            }
        }
        ])
    }
})