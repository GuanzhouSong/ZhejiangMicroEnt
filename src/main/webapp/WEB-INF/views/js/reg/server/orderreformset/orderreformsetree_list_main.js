require(['common/util', 'component/iframeLayer', 'common/http', 'handlebars', 'layer1', 'ztree','ztreeCheck'], function (util, layer, http, handlebars) {
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
        initorderreformseTree();
      }
    
    
    function initorderreformseTree() { 
    	 var initorderreformseSetting = {
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
    	var dataArr = [
	        	{id: "1", name: "责令接受监督检查和提供真实情况"},
	        	{id: "2", name: "停止侵犯他人合法企业名称权的违法行为"},
	        	{id: "3", name: "责令停止涂改、出租出借、转让营业执照的违法活动"},
	        	{id: "4", name: "责令重新提交真实有效的年检材料"},
	        	{id: "5", name: "责令重新提交真实有效的清算报告"},
	        	{id: "5", name: "责令销除非法使用企业名称的公章、牌匾等相关物品 "}, 
	        	{id: "6", name: "责令重新出具相关资产评估报告/验资报告/审计报告"},
	        	{id: "7", name: "责令清算组成员退还其侵占的公司财产"},
	        	{id: "8", name: "责令将营业执照置于住所或营业场所醒目位置"}, 
	        	{id: "9", name: "责令限期办理年检"},
	        	{id: "10", name: "责令依照《公司法》相关规定履行清算程序"},
	        	{id: "11", name: "责令期限办理变更/备案登记"},
	        	{id: "12", name: "责令依法归还抽逃转移的公司资产"}, 
	        	{id: "13", name: "责令依法履行出资物（财物）移交程序"},
	        	{id: "14", name: "责令补足缴纳出资并依法办理相关登记手续"},
	        	{id: "15", name: "责令限期补办相关许可审批手续并将审批许可证明文件提交工商部门"}, 
	        	{id: "16", name: "重新办理验资/审计，提交验资报告/审计报告"},
	        	{id: "17", name: "依法重新提交合法有效的登记材料 "},
	        	{id: "18", name: "立即依法办理注销登记，拒不办理的，我局将依法吊销营业执照"}, 
	        	{id: "19", name: "立即停止违法经营活动 "}
	        ]; 
         
    	//初始化权限树
        treeObj = $.fn.zTree.init($('#orderreformseTree'), initorderreformseSetting, dataArr);
        var treeObj = $.fn.zTree.getZTreeObj("orderreformseTree");
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
            el: '#orderreformseTreeSubmit',
            event: 'click',
            handler: function () {
            	
    				var treeObj = $.fn.zTree.getZTreeObj("orderreformseTree");
    				var nodes = treeObj.getCheckedNodes(true); 
    				if(nodes.length == 0){
    					layer.msg("请选择责令整改事项", {ltype: 0,time:2000}); 
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
            el: '#orderreformseTreeClose',
            event: 'click',
            handler: function () {
            	layer.close({type:'cancel'});
            }
        }
        ])
    }
})