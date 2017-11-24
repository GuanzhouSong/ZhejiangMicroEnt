require(['component/iframeLayer', 'common/util', 'common/http','handlebars', 'layer1', 'ztree'], function (layer,util, http,handlebars) {

    init();

    /**
     * 初始化函数集合
     */
    function init() {
        ztreeInit(null);
        bind();
    }

    var treeObj = null;
    
    var treeNodeObj=null;

    //权限树配置
    var treeSetting = {
    		view: {
				dblClickExpand: false
			},
			data: {
				simpleData: {
					enable: true,
	                idKey: 'id',
	                pIdKey: 'pId',
	                rootPId: ''
				}
			},
			check: {enable: true, chkStyle: "radio", radioType: "all"},
			callback: {
				//beforeClick: beforeClick,
				onClick: onClick
			}
    };

    /**
     * 点击触发事件
     */
    function onClick(e, treeId, treeNode) {
    	treeNodeObj=treeNode;
    }

    
    
    /**
     * 初始化树状结构
     */
    function ztreeInit(licConent) {
        http.httpRequest({
            type: 'post',
            data: {"licConent":licConent},
            url: '/commom/yr/syslicense/treelist.json',
            success: function (data) {
            	if (data.status == 'success') {
                	//初始化权限树
	                treeObj = $.fn.zTree.init($('#permisionTree'), treeSetting, data.data);
                    var treeObj = $.fn.zTree.getZTreeObj("permisionTree");
					  //展开树
				    treeObj.expandAll(true);
				    if(data.data != null && data.data.length == 1){
    					layer.msg("当前条件下没有查询到有效许可事项", {ltype: 0,time:2000}); 
				    }
                }
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
        },
        {
            el: '#tree-box-searcher',
            event: 'click',
            handler: function () {
            	var licConent=$.trim($("#tree-box-searchertree_Njjg").val());
            	ztreeInit(licConent);
            }
        },
        {
            el: '#save',
            event: 'click',
            handler: function () {      
            	 if(typeof c=="undefine"||treeNodeObj==null){
           		  layer.msg("请选择许可证", {ltype: 0,time:500});
	           	    return false;
	           	  }
            	  var data=new Object();
      			data.returncode=treeNodeObj.id;
      		    data.returnName= treeNodeObj.name;
            	  layer.close({reload:data});  
            }
        }])
    }

})