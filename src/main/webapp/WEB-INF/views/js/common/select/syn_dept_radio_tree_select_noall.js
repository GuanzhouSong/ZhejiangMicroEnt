require(['common/util', 'component/iframeLayer', 'common/http', 'handlebars', 'layer1', 'ztree','ztreeCheck'], function (util, layer, http, handlebars) {
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        loadTree();
        bind();
       }

    //部门树对象
    var treeObj = null;

    //加载部门树
    function loadTree(){
        var treeUrl=window._CONFIG.treeUrl;
        //部门树配置
        var setting = {
            check: {
            	enable: true,
				chkStyle: "radio",
				radioType: "all"
            },
            data: {
                key: {
                    name: "orgName",
                    title: "orgName"
                },
                simpleData: {
                    enable: true,
                    idKey: "orgCoding",
                    pIdKey: "porgCoding"

                }
            },
            callback:{
            }
        };
        http.httpRequest({
            type: 'post',
            url: window._CONFIG.treeUrl,
            data:{"adCode":window._CONFIG.adCode,"adCodes":window._CONFIG.adCodes,"isNoCheck":window._CONFIG.isNoCheck},
            success: function (data) {
                treeObj = $.fn.zTree.init($('#sysDepartTree'), setting, data);
            }
        });
    }

    function bind() {
        util.bindEvents([
        {
            el: '#departmentSubmit',
            event: 'click',
            handler: function () {
            	var treeObj = $.fn.zTree.getZTreeObj("sysDepartTree");
				var nodes = treeObj.getCheckedNodes(true);
				if(nodes.length == 0){
					layer.msg("请选择部门", {ltype: 0,time:2000});
					return false;
				}else{
					/* if(nodes[0].id==0||nodes[0].id=="0"){
 						 layer.msg("必须选择具体的部门", {ltype: 0,time:2000});
						 return false;
					 }*/
				    var adCodeStr=nodes[0].adcode;
					var orgNameStr=nodes[0].orgName;
					var orgCodeStr=nodes[0].orgCoding;
 					var data=new Object();
					data.adCode=adCodeStr;
 					data.orgName=orgNameStr;
 					data.orgCode=orgCodeStr;
					layer.close(data);
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