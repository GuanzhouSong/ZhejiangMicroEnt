require(['component/iframeLayer', 'common/util', 'common/http', 'handlebars','laydate' ,'jquery.validate', 'common/validateRules','jquery.serialize','ztree'], function (layer,util, http,handlebars) {
	
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
        formValid();
    }
    
    /**
     * 表单验证
     */
    function formValid() {
    	 $('#sysUserForm').validate({
             showErrors:function(errorMap,errorList){
                 for(var i in errorMap){
                     layer.tips(errorMap[i],$('#sysUserForm input[name='+i+'],#sysUserForm select[name='+i+']'),{
                         tips:3,
                         tipsMore:true,
                         ltype:0
                     });
                 }
             },
             submitHandler: function () {
            	 var dutyDeptName = $("#dutyDeptCode").find("option:selected").text();
            	 $("#dutyDeptName").val(dutyDeptName);
            	 var checkName = $("#checkCode").find("option:selected").text();
            	 $("#checkName").val(checkName);
            	var formParam = $("#sysUserForm").serializeObject();
     			http.httpRequest({
                	url: '/syn/server/sccheck/specialtype/saveorupdate',
                    serializable: false,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                        layer.msg(data.msg, {time: 1000}, function () {
                        	if(data.status == 'success'){
                        		layer.close({reload: true});
                        	}
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
