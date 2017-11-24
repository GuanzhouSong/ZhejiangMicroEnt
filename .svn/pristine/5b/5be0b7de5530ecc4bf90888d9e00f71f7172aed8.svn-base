require(['component/iframeLayer', 'common/util', 'common/http', 'handlebars','laydate' ,'jquery.validate', 'common/validateRules','jquery.serialize','ztree'], function (layer,util, http,handlebars) {


    init();

    /**
     * 初始化函数集合
     */

    function init() {
    	
        formValid();
        bind();
        
    }

    /**
     * 表单验证
     */
    function formValid() {
    	 $('#caseSourceform').validate({
             showErrors:function(errorMap,errorList){
                 for(var i in errorMap){
                     layer.tips(errorMap[i],$('#caseSourceform input[name='+i+'],#caseSourceform select[name='+i+']'),{
                         tips:3,
                         tipsMore:true,
                         ltype:0
                     });
                 }
             },
             submitHandler: function () {
                 var formParam = $('#caseSourceform').serializeObject();
                 http.httpRequest({
                  	  url: window._CONFIG.chooseUrl+'/server/casesource/saveOrEdit',
                      serializable: false,
                      data: formParam,
                      type: 'post',
                      success: function (data) {
                          layer.msg(data.msg, {time: 1000}, function () {
                              layer.close({reload: true});
                          });
                      }
                  })
              }
         })
    } 
    
    
    function bind() {
        util.bindEvents([{
            el: '#cancel',
            event: 'click',
            handler: function () {
                layer.close();
              }
        }])
    }
    

})