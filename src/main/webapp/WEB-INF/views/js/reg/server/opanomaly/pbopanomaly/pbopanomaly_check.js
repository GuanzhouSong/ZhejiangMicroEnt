require(['component/iframeLayer', 'common/util', 'common/http', 'jquery.validate', 'jquery.serialize','common/validateRules','laydate'], function (layer, util, http) {


    init();
      
    /**
     * 初始化函数集合
     */
    function init() { 
        bind();
    }

    function bind() {
        util.bindEvents([{
            el: '#cancel',
            event: 'click',
            handler: function () {
                layer.close();
            }
        },{
            el: '#yes',
            event: 'click',
            handler: function () {
                 $("#auditOpin").val("予以标记异常"); 
                
            }
        },{
            el: '#no',
            event: 'click',
            handler: function () {
            	 $("#auditOpin").val("不予标记异常");
            }
        },{
            el: '#save',
            event: 'click',
            handler: function () {
            	var auditOpin = $.trim($("#auditOpin").val());
            	var cogDate = $("#cogDate").val();
            	if(auditOpin==""){
            		layer.msg("审核意见为必填项!", {ltype: 0,time:2000});
            	}else if(auditOpin.length>500){
            		layer.msg("审核意见不多于500字!", {ltype: 0,time:2000});
            	}else if(cogDate==""){
            		layer.msg("做出决定日期为必填项!", {ltype: 0,time:2000});
            	}else{
            		var formParam=$('#pubauditosaveform').serializeObject();
	               	http.httpRequest({
                        url: '/reg/server/opanomaly/pbopanomaly/docheckpbopanomaly',
                        data:formParam,
                        type: 'post',
                        success: function (data) {
	                       	 if(data.status == 'success'){
	                       		 layer.msg("审核成功", {time: 1000}, function () {
     								layer.close({reload: true});
	                        	 });  
	                 	     }else{
	                 	    	 layer.msg("审核失败", {ltype: 0,time:1000});
	                 	     }
                        }
                    });
            	}
            }
        }]);
    } 
})
