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
//            	 if($("#sysUserForm input[name='partyOrgType']:checked").length == 0){
//            		 layer.tips("请选择党组织类型",$('#partyOrgType'),{tips:3,tipsMore:true,ltype:0});
//            		 return false;
//            	 }
                 var formParam = $('#sysUserForm').serializeObject();
                 http.httpRequest({
                  	  url: '/reg/server/party/member/saveOrEdit',
                      serializable: false,
                      data: formParam,
                      type: 'post',
                      success: function (data) {
                          layer.msg(data.msg, {time: 1000}, function () {
                        	  if(data.status == 'success') {
                        		 layer.close({reload: true});
                        	  }
                          });
                      }
                  })
              }
         })
    } 
    
    function bind() {
        util.bindEvents([
            {
	            el: '#cancel',
	            event: 'click',
	            handler: function () {
	                layer.close();
	              }
            },{
                el: '#choseOrg',
                event: 'click',
                handler: function () { 
                    layer.dialog({
                        title: '选择党组织',
                        area: ['75%', '80%'],
                        content: '/reg/server/party/organize/chooseOrg',
                        callback: function (data) {
                        	if(data.returnCode == 'success'){
                            	$("#partyOrgID").val(data.orgCode);
                            	$("#partyOrgName").val(data.orgName);  
                        	}
                        }
                    })
                }
            }])
       }
    

})