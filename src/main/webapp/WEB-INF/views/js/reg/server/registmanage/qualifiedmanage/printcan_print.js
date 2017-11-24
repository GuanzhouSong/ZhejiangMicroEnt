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
            	var uid =$("#uid").val();
            	var formParam=$('#params').serializeObject();
            	 http.httpRequest({
                     url: '/reg/server/registmanage/doPrintCan',
                     serializable: false,
                     data:formParam,
                     type: 'post',
                     success: function (data) { 
                    	 if(data.status=="success"){
                    		 var removeUid = data.data;
                    		 layer.msg("打印解除证明保存成功", {time: 1000}, function () {
		   			       	     var _id = "_doPrint_"+new Date().getTime();
		   			             var url = "/reg/server/registmanage/printCanView?uid="+uid+"&removeUid="+removeUid;
		   			             try{
		   			                 window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
		   			             }catch(e){
		   			                 alert("打印错误!");
		   			             }
	   							layer.close();
                      		 }); 
                    	 }else{
                    		 layer.msg("解除证明保存失败", {ltype: 0,time:500});
								layer.close();
                    	 }
                     }
                 });
            }
        }]);
    }

})
