require(['component/iframeLayer', 'common/util', 'common/http', 'jquery.validate', 'jquery.serialize','common/validateRules','laydate'], function (layer, util, http) {

    init();
    /**
     * 初始化函数集合
     */
    function init() { 
        bind(); 
       } 
    var searchParams={};//查询参数声明!
    var table; 
    function bind() {
        util.bindEvents([{
            el: '#cancel',
            event: 'click',
            handler: function () {
                layer.close();
            }
        },{
            el: '#savepubOpanoBtn',
            event: 'click',
            handler: function () { 
            	var consultTitle=$.trim($("#consultTitle").val()); 
            	 if(consultTitle==null||consultTitle==""){
            		layer.msg("请填写标题", {ltype: 0,time:2000});
                    return false;
            	 } 
            	 if(consultTitle.length>150){
             		layer.msg("您输入的标题长度已经超出最大限制", {ltype: 0,time:2000});
                     return false;
             	 } 
            	 var consultContent=$.trim($("#consultContent").val()); 
            	 if(consultContent==null||consultContent==""){
            		layer.msg("请填写异议内容", {ltype: 0,time:2000});
                    return false;
            	 } 
            	 if(consultContent.length>1000){
             		layer.msg("您输入的异议内容长度已经超出最大限制", {ltype: 0,time:2000});
                     return false;
             	 }
        		 var formParam=$('#pubauditosaveform').serializeObject();
            	 http.httpRequest({
                     url: '/reg/client/yr/ent/consult/commitClientConsultInfo',
                     serializable: true,
                     data:formParam,
                     type: 'post',
                     success: function (data) { 
                    	 if(data.status == 'success'){
                    		 layer.msg("保存成功", {time: 2000}, function () {
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
