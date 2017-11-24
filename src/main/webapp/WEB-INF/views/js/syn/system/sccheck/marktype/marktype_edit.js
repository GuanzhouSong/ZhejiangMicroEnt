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
            	 var checkFlag =  $("input[name='checkFlag']:checked").val();
            	 if(checkFlag == null || checkFlag == "" || checkFlag == "undefined"){
            		 layer.tips("请选择是否需要专业监管",$("#ischeckFlag"),{tips:3,tipsMore:true,ltype:0});
            		 return false;
            	 }
//            	 var rightCodes =  $("input[name='rightCodesV']:checked").val();
//            	 if(rightCodes == null || rightCodes == "" || rightCodes == "undefined"){
//            		 layer.tips("请选择是否需要专业资格资质",$("#isrightCodes"),{tips:3,tipsMore:true,ltype:0});
//            		 return false;
//            	 }
//            	 var leaderCodes =  $("input[name='leaderCodesV']:checked").val();
//            	 if(leaderCodes == null || leaderCodes == "" || leaderCodes == "undefined"){
//            		 layer.tips("请选择是否需要配备专家（组长）",$("#isleaderCodes"),{tips:3,tipsMore:true,ltype:0});
//            		 return false;
//            	 }
            	 var dutyDeptName = $("#dutyDeptCode").find("option:selected").text();
            	 $("#dutyDeptName").val(dutyDeptName);
            	 var specialName = $("#specialCode").find("option:selected").text();
            	 $("#specialName").val(specialName);
            	var formParam = $("#sysUserForm").serializeObject();
     			http.httpRequest({
                	url: '/syn/server/sccheck/codemarktype/saveorupdate',
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
        },{
            el: '#rightAdd',
            event: 'click',
            handler: function () { 
            	 layer.dialog({
        	        title: '选择专业资格资质',
        	        area: ['400px', '600px'],
        	        content: '/syn/server/sccheck/righttype/tree',
        	        callback: function (data) { 
        	        	var returncode=data.returncode;
        	        	if(returncode!=null&&returncode!=""){
        	        		returncode=returncode.substr(0,returncode.length-1); 
        	        	}
        	        	$("#rightCodes").val(returncode);
        	        	$("#rightNames").val(data.returnname);  
        	        }
        	    })
            }
      },{
          el: '#expertAdd',
          event: 'click',
          handler: function () { 
          	 layer.dialog({
      	        title: '选择专家（组长）',
      	        area: ['400px', '600px'],
      	        content: '/syn/server/sccheck/positiontype/tree',
      	        callback: function (data) { 
      	        	var returncode=data.returncode;
      	        	if(returncode!=null&&returncode!=""){
      	        		returncode=returncode.substr(0,returncode.length-1); 
      	        	}
      	        	$("#leaderCodes").val(returncode);
      	        	$("#leaderNames").val(data.returnname);  
      	        }
      	    })
          }
    }])
    }
   
})
