require(['component/iframeLayer', 'common/util', 'common/http','jquery', 'jquery.validate', 'jquery.serialize', 'laydate','common/validateRules'],
function(layer, util, http) {

    init();
    /**
     * 初始化函数集合
     */
    
    function init() {
    	 
    	//时间绑定
        bind();
        
       
    }
    
    
    function formValid(){ 
    		 layer.confirm('<span style="color:red">确认要回导数据吗?', {icon: 2, title: '提示'}, function () {
	                /*  var formParam = $('#auditForm').serializeObject();
	                  var userType= $("#userType").val(); 
	                  var typeUrl="";
	                  if(userType=="2"){
	                	  typeUrl='/syn/server/other/pubohterlicence/auditOtherLinence';
	                  }else{
	                	  typeUrl='/reg/server/other/pubohterlicence/auditOtherLinence';
	                  }*/
	                  
	                  $("#dataReturn").attr("disabled", true);
	                	 $("#dataReturn").val("提交中...."); 
	                  
	 				  http.httpRequest({
	 	                    url:"/reg/server/yr/yrdatareturn/dataReturn",
	 	                    serializable: false,
	 	                    data:{"priPID":$("#priPID").val(),"oldPriPID":$("#oldpriPID").val()},
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
        },
        {
        	el:"#dataReturn",
        	event:'click',
        	handler:function(){
        		formValid();
        	}
        }
        
        ])
    }

})