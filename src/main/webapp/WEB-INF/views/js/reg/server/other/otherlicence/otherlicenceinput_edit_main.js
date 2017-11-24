require(['component/iframeLayer', 'common/util', 'common/http','jquery', 'jquery.validate', 'jquery.serialize', 'laydate','common/validateRules','jquery.placeholder','jquery.icinfo'],
function(layer, util, http) {
	  $('input, textarea').placeholder();
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
        
        var start = {
            format: 'YYYY-MM-DD',
            min: '1970-01-01',
            max: '9999-09-09',
            istime: true,
            istoday: false,
            start: laydate.now(0,"YYYY-MM-DD"),
            choose: function(datas){
            end.min = datas;
            end.start = datas;
            }
        };
        var end = {
            format: 'YYYY-MM-DD',
            min: '1970-01-01',
            max: '9999-09-09',
            istime: true,
            istoday: false,
            start: laydate.now(0,"YYYY-MM-DD"),
            choose: function(datas){
            start.max = datas;
            }
        };
    $("#licValFrom").click(function(){laydate(start);});
    $("#licValTo").click(function(){laydate(end);});
    
    
    function formValid(){
    	$("#punishform").validate({
    		showErrors:function(errorMap,errorList){
                for(var i in errorMap){
                    layer.tips(errorMap[i],$('#punishform input[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                    if(i == 'penContent'){
                      	 layer.tips(errorMap[i],$('#penContent'),{tips:3,tipsMore:true,ltype:0});
                      }
                }
            },
    		submitHandler:function(){ 
    			 layer.confirm('<span style="color:red">行政许可</span>信息一经公示后将不能修改与删除，请确认信息无误？', {icon: 2, title: '提示'}, function () {
    				  $("#save").attr("disabled", true);
	                	 $("#save").val("提交中....");  
	                	  var userType= $("#userType").val(); 
	                      var typeUrl="";
	                      if(userType=="2"){
	                    	  typeUrl="/syn/server/other/pubohterlicenceinput/addOrEdit";
	                      }else{
	                    	  typeUrl="/reg/server/other/pubohterlicenceinput/addOrEdit";
	                      }
	                  var formParam = $('#punishform').serializeObject();
	                  $("#save").attr("disabled", true);
	                	 $("#save").val("提交中...."); 
	                  
	 				  http.httpRequest({
	 	                    url: typeUrl,
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
    
   
    
    function bind() {
        util.bindEvents([
        {
            el: '#cancel',
            event: 'click',
            handler: function() {
            	layer.close();
             }
        }, {
            el: '#longLic',
            event: 'click',
            handler: function() {
            	if($(this).prop("checked")){
            		$("#licValTo").val("9999-12-31");
            	}else{
            		$("#licValTo").val("");
            	}
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