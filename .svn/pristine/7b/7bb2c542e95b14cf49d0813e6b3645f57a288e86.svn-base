require(['component/iframeLayer','common/util', 'common/http', 'ztree','ztreeCheck','jquery','jquery.serialize'], function (layer,util, http) {

    init();

    /**
     * 初始化函数集合
     */
    function init() {
        ztreeInit();
        bind();
    }

    /**
     * 初始化树状结构
     */
    function ztreeInit() {
    	var treeData = [
					{"id":1, "pId":1, "name":"警告"},   
					{"id":2, "pId":1, "name":"罚款"},   
					{"id":3, "pId":1, "name":"没收违法所得和非法财物"},   
					{"id":4, "pId":1, "name":"责令停产停业"},
					{"id":5, "pId":1, "name":"暂扣许可证"},
					{"id":6, "pId":1, "name":"暂扣执照(登记证)"},
					{"id":7, "pId":1, "name":"吊销许可证"},
					{"id":8, "pId":1, "name":"吊销执照(登记证)"},
					{"id":9, "pId":1, "name":"法律、法规规定的其他行政处罚方式"},
    	         ];
    	treeObj = $.fn.zTree.init($('#permisionTree'), treeSetting, treeData); 
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
            	var nodes = treeObj.getCheckedNodes(true);
    			var array = "";
    			var names= new Array();
    			$.each(nodes, function(k, v) {
    				array += v.id + ",";
    				names[k]=v.name;
    			});
            	  var data=new Object();
      		 
      			data.returncode=array; 
      			data.returnname=names.toString();
            	  layer.close(data);
            	  
            }
        }])
    }
})
    var treeObj = null;

    //权限树配置
    var treeSetting = {
		check: {
			enable: true
		},
    };
