require(['common/util', 'component/iframeLayer', 'common/http', 'handlebars', 'layer1', 'ztree','ztreeCheck'], function (util, layer, http, handlebars) {
	 var illegaltreeSetting = {
	    		check: {
					enable: true,
					chkStyle: "checkbox",
					radioType: "level"
				},
				 view: {
                     // 设置具体条文的单选按钮组
                     addDiyDom: function(treeId, treeNode){
                         // 根节点没有具体条文
                         if(treeNode.level == 0)return;
                         // 获取节点的jquery对象
                         var nodeObj = $("#" + treeNode.tId);
                         // 配置单选按钮组
                         var radio = [
                             "<label><input type='radio' name='radio_"+treeId+treeNode.id+"'  value='1' />显示具体条文</label>",
                             "<label><input type='radio' name='radio_"+treeId+treeNode.id+"' checked value='0' />不显示</label>"
                         ].join("");
                         // 将单选按钮组插入节点
                         nodeObj.find("a:eq(0)").after(radio);
                         // 获取单选按钮组的jquery对象
                         var radios = $(":radio[name='radio_"+treeId+treeNode.id+"']");
                         // 绑定单选按钮组的点击事件
                         radios.bind("click", function(a,b,c){
                        	 
                             // 设置具体条文的显示与否
                             treeNode.showDicRemark = $(this).val() == 1 ? true : false;
                             // 获取树对象
                             var treeObj = $.fn.zTree.getZTreeObj(treeId);
                             // 更新节点数据
                             treeObj.updateNode(treeNode);
                             // 触发节点的选中事件 PS：具体参数详见ztree api 中的 checkNode
                             treeObj.checkNode(treeNode, true, true);
                         });
                     }
                 },
				data: {
					simpleData: {
						enable: true,
						idKey: 'id',
						pIdKey: 'parentId',
						rootPId: ''
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
    	 
    	   
         http.httpRequest({
             type: 'post',
             data: null,
             url: '/reg/server/orderreformset/selectCommonDicListByDicColumn',
             success: function (data) {
             	
                 if (data.status == 'success') {
                     //初始化权限树
                     treeObj = $.fn.zTree.init($("#lawtree"), illegaltreeSetting, data.data);
                     var treeObj = $.fn.zTree.getZTreeObj("lawtree");
 				}
             }
         });
    }

    function bind() {
        util.bindEvents([{
            el: '#tree-box-searcher',
            event: 'click',
            handler: function () {
            	 
            }
        },
        {
            el: '#lawtreeSubmit',
            event: 'click',
            handler: function () {
            	
    				var treeObj = $.fn.zTree.getZTreeObj("lawtree");
    				var nodes = treeObj.getCheckedNodes(true); 
    				if(nodes.length == 0){
    					layer.msg("请选择法律法规", {ltype: 0,time:2000}); 
    					return false;
    				}else{ 
    					var idStr="";
    					var nameStr="";
    					for(var a=0;a<nodes.length;a++){ 
    						var nId= nodes[a].id;
    						var nName=nodes[a].name;
    						var r="radio_lawtree"+nId;
    						if(nodes[a].parentId!=""){
    							 //是否显示法律条文
         						 var inVal=$('input:radio[name="'+r+'"]:checked').val();
         						 if(inVal=="1"){
         								nameStr+=nodes[a].permisionSysType;
         						 }else{
         							if(a==nodes.length-1){
            							idStr+=nId;
             							nameStr+=nName;
         							}else{
         								idStr+=nId+"、";
         	 							nameStr+=nName+"、";
         							} 
         						 }
    						}else{
    							idStr+=nId+"、";
 	 							nameStr+=nName+"、";
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
            el: '#lawtreeClose',
            event: 'click',
            handler: function () {
            	layer.close({type:'cancel'}); 
            }
        }
        ])
    }
})