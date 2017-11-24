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
        initleReppunishTree();
      }
    
   
    function initleReppunishTree() { 
    	 
    	var dataArr = [
	        	{id: "1", name: "法律和国务院规定的其他不能担任企业法定代表人的"},
	        	{id: "2", name: "担任因违法被吊销营业执照的企业的法定代表人，并对该企业违法行为负有个人责任，自该企业被吊销营业执照之日起未逾三年的"},
	        	{id: "3", name: "担任因经营不善破产清算的企业的法定代表人或者董事、经理并对该企业的破产负有个人责任，自该企业破产清算完结之日起未逾三年的"},
	        	{id: "4", name: "因犯有贪污贿赂罪、侵犯财产罪或者破坏社会主义市场经济秩序罪，被判处刑罚，执行期满未逾五年的；因犯有其他罪，被判处刑罚，执行期满未逾三年的；或者因犯罪被判处剥 夺政治权利，执行期满未逾五年的"}, 
	        	{id: "1", name: "正在被公安机关或者国家安全机关通缉的"},
	        	{id: "1", name: "正在被执行刑罚或者正在被执行刑事强制措施的 "} 
	        	]; 
         
    	//初始化权限树
        treeObj = $.fn.zTree.init($('#leReppunishTree'), illegaltreeSetting, dataArr);
        var treeObj = $.fn.zTree.getZTreeObj("leReppunishTree");
		  //展开树
	    treeObj.expandAll(true);
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
            	
    				var treeObj = $.fn.zTree.getZTreeObj("leReppunishTree");
    				var nodes = treeObj.getCheckedNodes(true); 
    				if(nodes.length == 0){
    					layer.msg("请选择法人处罚", {ltype: 0,time:2000}); 
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
            el: '#leReppunishTreeClose',
            event: 'click',
            handler: function () {
            	layer.close({type:'cancel'}); 
            }
        }
        ])
    }
})