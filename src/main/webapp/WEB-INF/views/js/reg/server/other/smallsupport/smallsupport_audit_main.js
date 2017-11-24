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
    	$("#supportform").validate({
    		showErrors:function(errorMap,errorList){ 
                for(var i in errorMap){ 
                    layer.tips(errorMap[i],$('#supportform input[name='+i+'],#supportform textarea[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
               
            },
    		submitHandler:function(){
    			
    		 layer.confirm('<span style="color:red">扶持</span>信息一经公示后将不能修改与删除，请确认信息无误？', {icon: 2, title: '提示'}, function () {
	                  var formParam = $('#supportform').serializeObject();
	                  var userType= $("#userType").val(); 
	                  var typeUrl="";
	                  if(userType=="2"){
	                	  typeUrl='/syn/server/other/pubSmallSupport/auditSmallSupport';
	                  }else{
	                	  typeUrl='/reg/server/other/pubSmallSupport/auditSmallSupport';
	                  }
	                  
	                  $("#save").attr("disabled", true);
	                	 $("#save").val("提交中...."); 
	                  
	 				  http.httpRequest({
	 	                    url:typeUrl,
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
    			 })
    		 }
    	});
    }
    
     
    
    $("#checksuc").click(function(){
    	if($(this).prop("checked")){$("#auditOpin").val("同意");}
    })
    $("#checkfal").click(function(){
    	if($(this).prop("checked")){$("#auditOpin").val("不同意");}
    })
    
    function bind() {
        util.bindEvents([
        {
            el: '#cancel',
            event: 'click',
            handler: function() {
            	layer.close({reload:true});
             }
        }])
    }

})