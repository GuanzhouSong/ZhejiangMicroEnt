require(['component/iframeLayer', 'common/util', 'common/http','jquery', 'jquery.validate', 'jquery.serialize', 'laydate','common/validateRules'],
function(layer, util, http) {

    init();
    /**
     * 初始化函数集合
     */
    
    function init() {
    	//时间绑定
        bind();
        //提交
        formValid(); 
    }
    
    
    function formValid(){
    	$("#alterForm").validate({
    		 showErrors:function(errorMap,errorList){
                 for(var i in errorMap){
                     layer.tips(errorMap[i],$('#alterForm input[name='+i+'],#alterForm textarea[name='+i+']'),{
                         tips:3,
                         tipsMore:true,
                         ltype:0
                     });
                 }
             },
    		submitHandler:function(){
	                  var formParam = $('#alterForm').serializeObject();
	                  var userType= $("#userType").val(); 
	                  var typeUrl="";
	                  if(userType=="2"){
	                	  typeUrl="/syn/server/pubotherpunishinput/save";
	                  }else{
	                	  typeUrl="/pub/server/pubotherpunishinput/save";
	                  }
	 				  http.httpRequest({
	 	                    url: typeUrl,
	 	                    serializable: false,
	 	                    data: formParam,
	 	                    type: 'post',
	 	                    success: function (data) {
	 	                    if(data.status == 'success'){
		                		layer.msg(data.msg, {time: 1000}, function () {
		                			layer.close({reload:true});
		                	  })
	 	                    }else{
	 	                    	layer.msg(data.msg);
	 	                    }
	 	                }
	 	           }) 
    		 }
    	});
    }
    
    function bind() {
        util.bindEvents([
        {
            el: '#cancel',
            event: 'click',
            handler: function() {
            	layer.close();
             }
        }])
    }

})