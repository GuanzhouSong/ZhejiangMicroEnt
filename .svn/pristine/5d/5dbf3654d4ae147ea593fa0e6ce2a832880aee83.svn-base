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
            rules:{
            	supportAm:{
            		number:true
            	}
            },
            
    		submitHandler:function(){ 
    			 
    				  $("#save").attr("disabled", true);
	                	 $("#save").val("提交中....");  
	                	  var userType= $("#userType").val(); 
	                      var typeUrl="";
	                      if(userType=="2"){
	                    	  typeUrl="/syn/server/other/pubSmallSupport/save";
	                      }else{
	                    	  typeUrl="/reg/server/other/pubSmallSupport/save";
	                      }
	                  var formParam = $('#supportform').serializeObject();
	 				  http.httpRequest({
	 	                    url: typeUrl,
	 	                    serializable:false, 
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
        },{
            el: '.penType',
            event: 'click',
            handler: function() {
            	if($(this).prop("checked")){
            		if($(this).val() =='2'){$(".penAm").show();$("#_penAm").val("").addClass("required")}//显示罚款金额
                	if($(this).val() =='3'){$(".forfAm").show();$("#_forfAm").val("").addClass("required")}//显示没收金额
            	}else{
            		if($(this).val() =='2'){$(".penAm").hide();$("#_penAm").val("").removeClass("required")}//隐藏罚款金额
                	if($(this).val() =='3'){$(".forfAm").hide();$("#_forfAm").val("").removeClass("required")}//隐藏没收金额
            	}
             }
        },
        
        {
            el: '#selectDept',
            event: 'click',
            handler: function () {
            	  var supCode='';
            	  var dutyDeptCodes=$("#dutyDeptCodes").val();
            	  var deptLink='/common/system/sysdepart/deptSelectByDuty?dutyDeptCodes=A001&isFilterBySysUser=true&treeType=radio&isNoCheck=true';
            	  
     	        layer.dialog({
     	            title: '选择部门',
     	            area: ['350px', '666px'],
     	            content: deptLink,
     	            callback: function (data) {
     	             
     	                if(data.orgCodes!=null&&data.orgNames!=null){
     	                    $("#deptName").val(data.orgNames);
     	                    $("#deptID").val(data.orgCodes);
     	                
     	                }
     	            }
     	        })
            }
        }
        
        ])
    }

})