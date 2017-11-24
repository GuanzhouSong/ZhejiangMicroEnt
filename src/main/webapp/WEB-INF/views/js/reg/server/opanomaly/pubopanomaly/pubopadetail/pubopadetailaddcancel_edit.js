require(['component/iframeLayer', 'common/util', 'common/http', 'jquery.validate', 'jquery.serialize','common/validateRules','laydate'], function (layer, util, http) {


    init();
    laydate.skin('molv');//初始化皮肤 (墨绿)
	
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
            el: '#save',
            event: 'click',
            handler: function () {
            	/* 校验开始 */
            	var removeRea=$.trim($("#removeRea").val());
            	var firstOpin=$.trim($("#firstOpin").val());
            	var remDate=$.trim($("#remDate").val());	 
            	
            	if(removeRea==null||removeRea==""){
            		layer.msg("请输入事实和理由", {ltype: 0,time:2000});
                    return false;
            	} 
            	
            	if(removeRea.length>250){
            		layer.msg("事实和理由不能超过250个字", {ltype: 0,time:2000});
                    return false;
            	} 
            	
            	if(firstOpin==null||firstOpin==""){
            		layer.msg("请输入初审意见", {ltype: 0,time:2000});
                    return false;
            	} 
            	if(firstOpin.length>250){
            		layer.msg("初审意见不能超过250个字", {ltype: 0,time:2000});
                    return false;
            	}
//            	if(remDate==null||remDate==""){
//            		layer.msg("请选择作出决定日期", {ltype: 0,time:2000});
//                    return false;
//            	}
            	if(remDate!=null&&remDate!=""){
            		if (new Date(remDate.replace(/-/g, "/")) > new Date($("#firstdate").html().replace(/-/g, "/"))) {
   	                 layer.msg("作出决定日期不能晚于初审日期", {ltype: 0,time:2000});
   	                 return false;
   	                }
            	} 
	        	 
//            	$("#sendabnTime").val($("#abnTime").html());
            	var formParam=$('#pubopadetailform').serializeObject();
//            	console.log(formParam);
        	    http.httpRequest({
                     url: '/reg/server/opadetail/pubopadetail/opadetailcommit',
                     serializable: false,
                     data:formParam,
                     type: 'post',
                     success: function (data) {
                    	 if(data.status == 'success'){
                    		 layer.msg(data.msg, {time: 1000}, function () {
 								layer.close({reload: true});
                    		 }); 
                    	 }else{
                    		 layer.msg(data.msg, {ltype: 0,time:2000});
                    	 }
                     }
                 });
            }
        }]);
    }

})
