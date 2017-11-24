require(['component/iframeLayer', 'common/util', 'common/http','jquery', 'jquery.validate', 'jquery.serialize', 'laydate','common/validateRules'],
function(layer, util, http) {

    init();
    /**
     * 初始化函数集合
     */
    
    function init() {
    	//初始化
    	initData();
    	//时间绑定
        bind();
        //提交
        formValid(); 
    }
    
    
    function formValid(){
    	$("#punishform").validate({
    		showErrors:function(errorMap,errorList){
                for(var i in errorMap){
                    layer.tips(errorMap[i],$('#punishform input[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
            },
    		submitHandler:function(){
    			 if($("#penContent").val() ==''){
    				 layer.tips("请填写行政处罚内容",$('#penContent'),{tips:3,tipsMore:true,ltype:0});
    				 return false;
    			 }
    			 if($("input[type = 'checkbox']:checked").length == 0){
    				 layer.tips("请选择处罚类型",$('#_penType'),{tips:3,tipsMore:true,ltype:0});
    				 return false;
    			 }
    			 layer.confirm('<span style="color:red">处罚决定书文号</span>信息一经公示后将不能修改与删除，请确认信息无误？', {icon: 2, title: '提示'}, function () {
    				  var checkArry = new Array();
    				  $(".penType").each(function(){
    					  if($(this).prop("checked")){
    						  checkArry.push($(this).val()); 
    					  }
    				  })
    				  $("#penType").val(checkArry.toString());
	                  var formParam = $('#punishform').serializeObject();
	                  var userType= $("#userType").val(); 
	                  var typeUrl="";
	                  if(userType=="2"){
	                	  typeUrl="/syn/server/pubotherpunishinput/addOrEdit";
	                  }else{
	                	  typeUrl="/pub/server/pubotherpunishinput/addOrEdit";
	                  }
	                  
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
    
    //处罚类型初始化处理
    function initData(){
    	var val = $("#penType").val();
    	if(val != ""){
			var punFormVal = [];
			punFormVal = val.split(",");
			for(var i = 0; i < punFormVal.length; i++){
				$(":checkbox").each(function(k,n){
					if(punFormVal[i] == $(n).val()){
						$(n).prop("checked",true);
						if(punFormVal[i] == 2){
							$(".penAm").show();//显示罚款金额
						}
						if(punFormVal[i] == 3){
							$(".forfAm").show();//显示没收金额
						}
					}
				});
			}
		}
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
        }])
    }

})