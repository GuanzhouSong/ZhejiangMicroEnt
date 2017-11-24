require(['common/util', 'component/iframeLayer', 'common/http', 'handlebars', 'layer1', 'ztree','ztreeCheck'], function (util, layer, http, handlebars) {
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
        initCodeLicenseTree(null);
      }
    
    var ycCodeLicensetreeSetting = {
    		check: {
				enable: true,
				chkStyle: "radio",
				radioType: "level"
			},
			data: {
				simpleData: {
					enable: true
				}
			} 
		}; 
    function initCodeLicenseTree(licConent) {
         
        http.httpRequest({
            type: 'post',
            data: {"licConent":licConent},
            url: '/syn/pubdzdtinfo/codelicenseListTreeJSON',
            success: function (data) {
            	
                if (data.status == 'success') {
                    //初始化权限树
                    treeObj = $.fn.zTree.init($('#ycCodeLicenseTree'), ycCodeLicensetreeSetting, data.data);
                    var treeObj = $.fn.zTree.getZTreeObj("ycCodeLicenseTree");
					  //展开树
				    treeObj.expandAll(true);
                }
            }
        });
    }

    function bind() {
        util.bindEvents([{
            el: '#tree-box-searcher',
            event: 'click',
            handler: function () {
            	
            	var licConent=$.trim($("#tree-box-searchertree_Njjg").val());
            	initCodeLicenseTree(licConent);
            }
        },
        {
            el: '#codelicenseSubmit',
            event: 'click',
            handler: function () {
            	
    				var treeObj = $.fn.zTree.getZTreeObj("ycCodeLicenseTree");
    				var nodes = treeObj.getCheckedNodes(true); 
    				if(nodes.length == 0){
    					layer.msg("请选择备案事项", {ltype: 0,time:2000}); 
    					return false;
    				}else{ 
    					 if(nodes[0].id==0||nodes[0].id=="0"){
     						 layer.msg("必须选择具体的备案事项", {ltype: 0,time:2000});
    						 return false;
    					 } 
     					var data=new Object(); 
    					data.exaCode=nodes[0].id; 
    					data.licDept=nodes[0].licdept;
    					data.exaName=nodes[0].name;
    					data.licrea=nodes[0].licrea;
    					data.licDeptTypeName=nodes[0].licDeptTypeName;
    					data.licDepType=nodes[0].code;
    					layer.close({reload:data});
    			 }
            }
        },
        {
            el: '#codelicenseClose',
            event: 'click',
            handler: function () {
            	layer.close(); 
            }
        }
        ])
    }
})