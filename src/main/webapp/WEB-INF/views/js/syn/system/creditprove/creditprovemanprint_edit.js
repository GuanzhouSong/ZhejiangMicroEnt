require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery', 'jquery.validate', 'jquery.serialize', 'laydate','pagination'],
function(layer, dataTable, util, http, handlebars) {
	var initFlag = true;
	var searchParams={};
	var table;
	var createFalg="0";
    init();
    /**
     * 初始化函数集合
     */
    function init() { 
        bind(); 
    }

    function bind() {
        util.bindEvents([{
	      	  el:"#printButton",
	    	  event:'click',
	    	  handler:function(){
	    		  http.httpRequest({
	    	             url: window._CONFIG.url+'/creditproveprinthis/save',
	    	             serializable: false,
	    	             data: {"proveNo":$("#ProveNo").val()},
	    	             type: 'get',
	    	             success: function (data) {  
	    	             	   if(data.status!="success"){
	    	             		  layer.msg("保存打印记录异常", {ltype: 0,time:3000});
	    	             	   } 
	    	             }
	    	      });
	    		  Print();
	    	  }
	      }
	      ])
    }

})
