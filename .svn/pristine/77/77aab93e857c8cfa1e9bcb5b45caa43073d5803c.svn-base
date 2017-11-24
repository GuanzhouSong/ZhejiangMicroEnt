require(['component/iframeLayer', 'common/util', 'common/http','jquery.validate', 'jquery.serialize','common/validateRules'], function (layer, util, http){
	
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	$("#sa").click(function(){
    		search();
    	});
    	$("#saveBtndiv").click(function(){
    		doCreate();
    	});
    	bind();
    	formValid();
    } 
    
    /**
     * 表单验证
     */
    function formValid() {
        $('#pbpassWordForm').validate({
            rules: {
            	tel: {
                    required: true,
                    checkMobile:true
                }
            },
            messages:{
            	tel:{
            	   required:"手机号码不为空",
            	   checkMobile:"请输入最新正确格式手机号码，以便发送短信"
            	}
            },
            
            onkeyup:false,
            onfocusout:function(el){
                $(el).valid();
            },
            showErrors:function(errorMap,errorList){
                for(var i in errorMap){
                    layer.tips(errorMap[i],$('#pbpassWordForm input[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
            },
            submitHandler: function () {
            	//登录密码验证
       		    if($("#_password").text() == "密码尚未生成" || $.trim($("#_password").text()) == "" ){
       			 alert("密码不能为空，请点击生成密码按钮生成密码！");
       		        return false;
       		   }
                var formParam = $('#pbpassWordForm').serializeObject();
                http.httpRequest({
                    url: '/reg/server/yr/pubpbepassword/insert',
                    serializable: false,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                    	if(data.status =="success"){
                            layer.msg(data.msg, {time: 1000}, function () {
                                $('#pbpassWordForm')[0].reset();//输入框重置为空*/
                                $("#show").slideUp("slow");//设置添加框隐藏    
                            });
                    	}
                    }
                })
            }
        })
    }
    
    //六位随机数生成
    function doCreate(){
   	 var Num=""; 
   	 for(var i=0;i<6;i++) 
   	 { 
   	 Num+=Math.floor(Math.random()*10); 
   	 } 
   	 $("#_password").html(Num);
   	 $("#saveBtndiv").hide();
   	 $("#password").val(Num);
    }
    
   function search(){
        $('#pbpassWordForm')[0].reset();//输入框重置为空*/
        $("#show").slideUp("slow");//设置添加框隐藏    
	    if($.trim($("#searchregNO").val())==""&&$.trim($("#searchuniCode").val())==""&&$.trim($("#searchentName").val())==""){
	    	layer.msg("至少输入一个搜索条件");
	    	return;
	    }else{
//	    	var _index;
	    	searchParams = $("#taskForm").serializeObject();
	    	$.ajax({
		        url: "/reg/server/yr/pubpbepassword/search.json",    //请求的url地址
		        beforeSend:function(){ //发送前执
                    _index = layer.msg('处理中，请稍后', {icon: 16, time: -1, shade: [0.4, '#CCC']});
                },
		        dataType: "json",   //返回格式为json
		        data: { "regNO": $("#searchregNO").val(),
		        		"uniCode":$("#searchuniCode").val(),
		        		"entName":$("#searchentName").val()
		        		},    //参数值
		        type: "POST",   //请求方式
		        success: function(data) {
		        	if(data.PubPbePassword!="" && data.PubPbePassword!= null ){//已有密码 只能修改电话
	                	layer.close(_index);
		        	   $("#_entName").html(data.PubPbePassword.entName);
		  	           $("#_regNO").html(data.PubPbePassword.regNO);
		  	           $("#_liaName").html(data.PubPbePassword.liaName);
		  	           $("#_liaIDNum").html(data.PubPbePassword.liaIDNum);
		  	           $("#_password").html(data.PubPbePassword.password);
		  	           $("#_tel").val(data.PubPbePassword.tel);
		  	           $("#_appReviewOrg").html(data.sysUser.dept);
		  	           $("#_username").html(data.sysUser.username);
		  	           //传值框赋值
		  	           $("#entName").val(data.PubPbePassword.entName);
		  	           $("#uid").val(data.PubPbePassword.uid);
		  	           $("#regNO").val(data.PubPbePassword.regNO);
		  	           $("#appReviewOrg").val(data.sysUser.dept);
		  	           $("#username").val(data.sysUser.username);
		  	           $("#liaName").val(data.PubPbePassword.liaName);
			  	       $("#liaIDNum").val(data.PubPbePassword.liaIDNum);
			  	       $("#priPID").val(data.PubPbePassword.priPID);
		  	           $("#uniCode").val(data.PubPbePassword.uniCode);
		  	           $("#password").val(data.PubPbePassword.password);
		               
		  	           $("#saveBtndiv").hide();
			           $("#show").slideDown().show();	  	           
		        	}else if(data.midBaseInfo!="" && data.midBaseInfo!= null ){ //没有生成过密码 新增
	                	layer.close(_index);
		        		$("#_entName").html(data.midBaseInfo.entName);
			  	        $("#_regNO").html(data.midBaseInfo.regNO);
			  	        $("#_liaName").html(data.midBaseInfo.leRep);
			  	        $("#_liaIDNum").html(data.midBaseInfo.cerNO);
			  	        $("#_password").html("密码尚未生成");
			  	        $("#_tel").val(data.midBaseInfo.tel);
			  	        $("#_appReviewOrg").html(data.sysUser.dept);
		  	            $("#_username").html(data.sysUser.username);
		  	            //传值框赋值
		  	            $("#entName").val(data.midBaseInfo.entName);
			  	        $("#regNO").val(data.midBaseInfo.regNO);
			  	        $("#liaName").val(data.midBaseInfo.leRep);
			  	        $("#liaIDNum").val(data.midBaseInfo.cerNO);
			  	        $("#appReviewOrg").val(data.sysUser.dept);
		  	            $("#username").val(data.sysUser.username);
		  	            $("#priPID").val(data.midBaseInfo.priPID);
		  	            $("#uniCode").val(data.midBaseInfo.uniCode);
		        		
		  	            $("#saveBtndiv").show();
				        $("#show").slideDown().show();	  	           
		        	}else{
	                	layer.close(_index);
		        		layer.msg("找不到企业");
		        	}
		        },
		    });
	    }
   }
   
   
   function bind() {
       util.bindEvents([{
           el: '#cancelBtn',
           event: 'click',
           handler: function () {
       		 $('#pbpassWordForm')[0].reset();//输入框重置为空*/
             $("#show").slideUp("slow");//设置添加框隐藏   
           }
       }])
   }
})
