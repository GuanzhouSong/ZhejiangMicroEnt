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
        		var exaCodeStr=$.trim($("#exaCodeStr").val()); 
            	//推送条件
        		var checkDep=$.trim($("#checkDep").val()); 
        		//推送类型
        	    var yFlag=$('input:radio[name="yFlag"]:checked').val();
        	    var istransferFlag=$('input:radio[name="istransferFlag"]:checked').val();
     	    	if(yFlag==null||yFlag==""){
     	    		layer.msg("请选择下放类型", {ltype: 0,time:3000});
     	    		pubdtinfostop="0";
    	    		return false;
    	    	} 
     	    	if(checkDep==null||checkDep==""){
     	    		layer.msg("请输入部门编码", {ltype: 0,time:3000});
     	    		pubdtinfostop="0";
    	    		return false;
    	    	} 
     	    	if(exaCodeStr==null||exaCodeStr==""){
     	    		layer.msg("请输入后置审批事项编码", {ltype: 0,time:3000});
     	    		pubdtinfostop="0";
    	    		return false;
    	    	} 
        	    if(pubdtinfostop=="1"){
        	    	layer.confirm('确定要操作吗?', {icon: 3, title: '提示'}, function () { 
    	                 http.httpRequest({
    	                    url: '/syn/licdept/transferExaCode',
    	                    serializable: false,
    	                    data: {"yFlag":yFlag,"exaCodeStr":exaCodeStr,"checkDep":checkDep,"istransferFlag":istransferFlag},
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
