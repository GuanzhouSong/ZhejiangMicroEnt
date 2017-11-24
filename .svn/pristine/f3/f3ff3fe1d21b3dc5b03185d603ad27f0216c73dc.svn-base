require(['component/iframeLayer', 'common/util', 'common/http','jquery', 'jquery.serialize','laydate','common/ajaxfileupload'], function (layer, util, http) {   
init();
    /**
     * 初始化函数集合
     */
    function init() {
    	bind();
    }
    
    //获取短信验证码 
    $("#getCode2").click(function(){
    	var tel = $("#mobTel2").val();
    	if(!tel.match(/^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/)){
    		alert("手机号码格式不对");
    	}else{
    		var entName= window._CONFIG._entName;
    		var district = $("#regOrg2").val();
    		getMessageCode(tel,district,entName);
    	}
	});
    function getMessageCode(tel,district,entName){ 
    	/*$.ajax({
            url: "/syn/erescobjinfo/getMessageCode",
            type: 'get',
            data: {"tel":tel,"district":district},
            success: function(data, status){
	            layer.msg("获取验证码成功", {time: 1200}, function() {});
            },error: function(data, status){
            	layer.msg("获取验证码失败", {time: 3000}, function() {});
            }
        });*/
    	   http.httpRequest({
               url: '/syn/erescobjinfo/getMessageCode',
               serializable: false,
               data: {"tel":tel,"district":district,"entName":entName},
               type: 'get',
               success: function (data) {
            	   if(data.status=="success"){
            		   layer.msg("获取验证码成功", {time: 2000}, function() {});
            	   } else{
            		   layer.msg("获取验证码失败", {time: 2000}, function() {});
            	   }
               }
           });
    }
    
    var prefix=$("#prefix").val();
    var prefix1=$("#prefix1").val();
    var prefix2=$("#prefix2").val();
    $("#btnUpload_4").click(function(){
    	$("#certificatesPic4").val("");
    	var faceprefix = prefix2+"_otherunit_"+new Date().getTime();
		upload($(this),4,faceprefix);
	});
	
	function upload(e,i,prefix){
    	var file=$("#btnFile_"+i).val();
    	if(file==""){
    		layer.msg("请先选择需要上传的文件", {time: 3000}, function() {});
    		return false;
    	}
    	var pos=file.lastIndexOf("\\");
    	file = file.substring(pos+1); 
    	var suffixArr = file.split(".");
    	var suffix = suffixArr[suffixArr.length-1];
    	var tp ="jpg,JPG";
    	var rs=tp.indexOf(suffix);
    	if(rs>=0){
    		 var filePath = prefix+file;
    		 if(i=="1"){
    			 $("#certificatesPic").val(filePath);
    		 }else if(i=="2"){
    			 $("#bcertificatesPic").val(filePath);
    		 }else if(i=="3"){
    			 $("#certificatesPic3").val(filePath);
    		 }else if(i=="4"){
    			 $("#certificatesPic4").val(filePath);
    		 }
    		 e.hide();
    		 $("#uploadState_"+i).show();
    		 $.ajaxFileUpload({
    			 url: "/syn/erescobjinfo/upload",
    			 type: 'post',
    			 data: {"prefix":prefix},
    			 secureuri: false,
    			 fileElementId: 'btnFile_'+i,
    			 dataType: 'text',
    			 success: function(data, status){
    				 if(data !="error") {
    					 layer.msg("上传成功", {time: 1200}, function() {});
    				 }else {
    					 layer.msg("上传失败", {time: 2000}, function() {});
    				 }
    				 //$("#file").val("");
    				 //重置file选择
    				 //$("#fileBox").html("").append('<input type="file" id="btnFile" class="btnFile" name="btnFile"/>');
    				 $("#uploadState_"+i).hide();
    				 e.show();
    			 },error: function(data, status){
    				 //$("#file").val("");
    				 //重置file选择
    				 //$("#fileBox").html("").append('<input type="file" id="btnFile" class="btnFile" name="btnFile"/>');
    				 $("#uploadState_"+i).hide();
    				 e.show();
    				 layer.msg("上传失败，请检查网络及文件大小", {time: 3000}, function() {});
    			 }
    		 });
    	}else{
    		 alert("您选择的上传文件不是有效的图片文件！");
    	}
    }
	
	function save(formParam,url,encryPriPID){
		http.httpRequest({
            url: url,
            serializable: true,
            data: formParam,
            type: 'post',
            success: function (data) {
        		if(data.status=="success"){
        			layer.msg("提交成功", {time: 2000}, function () {
        				window.close();
                    	//window.location.href='objectionDetail?encryPriPID='+encryPriPID;
                    });
        		}else{
        			layer.msg(data.msg, {time: 1000}, function () {
                    	//window.location.href='objectionApply?encryPriPID='+encryPriPID;
                    });
            	}
            }
        })
	}
	
    
    function bind() {
        util.bindEvents([{
            el: '#btn2',
            event: 'click',
            handler: function () {
            	var entName=$.trim($("#entName2").val());//企业名称
            	var regNO=$.trim($("#regNO2").val());//注册号
            	var certificatesPic=$("#certificatesPic4").val();//单位证照（正面）照片
            	var name=$.trim($("#name2").val());//联络员姓名
            	var mobTel=$.trim($("#mobTel2").val());//联系电话
            	var validateCode=$.trim($("#validateCode2").val());//验证码
            	var otherContent=$.trim($("#otherContent").val());//其他
            	
            	var objections=new Array();
            	var encryPriPID = $("#encryPriPID2").val();
        		$(":checkbox:checked").each(function(k,v){
        			
        			objections[k]= this.value;
        		});
        		$("#objection2").val(objections);
        		if(entName==""){ 
        			layer.msg("单位名称不能为空", {ltype: 0,time:2000});
        		}/*else if (regNO==""){ 
        			layer.msg("统一社会信用代码/单位证照号码不能为空", {ltype: 0,time:2000});
        		}else if (certificatesPic==""){
        			layer.msg("单位证照（正面）照片不能为空", {ltype: 0,time:2000});
        		}*/else if (name==""){
        			layer.msg("联络员不能为空", {ltype: 0,time:2000});
        		}else if (mobTel==""||!mobTel.match(/^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/)){
        			layer.msg("手机号码不能为空或者格式错误", {ltype: 0,time:2000});
        		}else if (validateCode==""){
        			layer.msg("验证码不能为空", {ltype: 0,time:2000});
        		}else if ($("#objection2").val()==""&&otherContent==""){
        			layer.msg("异议内容不能为空", {ltype: 0,time:2000});
        		}else{
        			var formParam = $('#form2').serializeObject();
        			var url="/syn/erescobjinfo/saveByOtherUnit";
        			save(formParam,url,encryPriPID);
        		}
            }
        }
    ])}

})
