require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {
	 
      init();
    /**
     * 初始化函数集合
     */
    function init() { 
        bind(); 
       }  
    
       
    

    function bind() {
        util.bindEvents([ 
        {
            el: '#btn_cancel',
            event: 'click',
            handler: function () {
                layer.close();
            }
        },
        {
            el: '#btn_save',
            event: 'click',
            handler: function () { 
            	debugger
            	var pubdtinfostop="1"
            	//推送条件
        		var priPIDStr=$.trim($("#priPIDStr").val()); 
        		//推送类型
        	    var flag=$('input:radio[name="flag"]:checked').val();
     	    	if(flag==null||flag==""){
     	    		layer.msg("请选择推送类型", {ltype: 0,time:3000});
     	    		pubdtinfostop="0";
    	    		return false;
    	    	}
     	    	if("4"!=flag){
     	    		if(priPIDStr==null||priPIDStr==""){ 
        	    		layer.msg("请输入推送条件", {ltype: 0,time:3000});
        	    		pubdtinfostop="0";
        	    		return false;
        	    	} 
     	    	} 
        	    if(pubdtinfostop=="1"){
        	    	layer.confirm('确定要推送吗?', {icon: 3, title: '提示'}, function () { 
    	                 http.httpRequest({
    	                    url: '/quartz/pubDzDtInfoPush/pubDtInfoHandPush',
    	                    serializable: false,
    	                    data: {"flag":flag,"priPIDStr":priPIDStr},
    	                    type: 'post',
	    	                success: function (data) { 
	    	                    	layer.close(data);
    	                    }
    	                });
                    })
        	    } 
            }
        }
        ])
    }

})
