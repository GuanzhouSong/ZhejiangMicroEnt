require(['common/util', 'component/iframeLayer', 'common/http', 'handlebars', 'layer1', 'ztree','ztreeCheck'], function (util, layer, http, handlebars) {
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
        initDeptTree(null);
     }
    
    var departmentradiotreetreeSetting = {
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
      
    function initDeptTree(licConent) {
        //加载权限数据
        http.httpRequest({
            type: 'post',
            data: {"licConent":licConent},
            url: '/syn/pubdtinfo/departMentRadioTreeJSON',
            success: function (data) {
            	
                if (data.status == 'success') {
                    //初始化权限树
                    treeObj = $.fn.zTree.init($('#departmentchecktree'), departmentradiotreetreeSetting, data.data);
                    //ar treeObj = $.fn.zTree.getZTreeObj("departmentradiotree");
					  //展开树
				    //treeObj.expandAll(true);
                }
            }
        });
    }

    function bind() {
        util.bindEvents([
        {
            el: '#departmentSubmit',
            event: 'click',
            handler: function () {
            	var treeObj = $.fn.zTree.getZTreeObj("departmentchecktree");
				var nodes = treeObj.getCheckedNodes(true); 
				if(nodes.length == 0){
					layer.msg("请选择审批部门", {ltype: 0,time:2000}); 
					return false;
				}else{ 
					 if(nodes.length==1 &&nodes[0].pcode==0){
						 layer.msg("必须选择具体的审批部门", {ltype: 0,time:2000});
						 return false;
					 }
					    var codeStr="";
						var contentStr="";
 						for(var a=0;a<nodes.length;a++){ 
							codeStr+=nodes[a].deptId+",";
							contentStr+=nodes[a].name+",";
 						}  
						if(codeStr!=""&&contentStr!=""){
							codeStr=codeStr.substr(0,codeStr.length-1);
							contentStr=contentStr.substr(0,contentStr.length-1); 
						}
						var data=new Object(); 
						data.id=codeStr;
						data.deptName=contentStr;
						data.closeFlag="1";
 						layer.close({reload:data});
				}  
            }
        },
        {
            el: '#departmentClose',
            event: 'click',
            handler: function () {
            	layer.close();
            }
        }
        ])
    }
})