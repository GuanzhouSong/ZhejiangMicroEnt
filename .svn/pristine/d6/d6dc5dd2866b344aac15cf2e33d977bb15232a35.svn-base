require(['component/iframeLayer', 'common/util', 'common/http','jquery', 'jquery.serialize','laydate','common/ajaxfileupload'], function (layer, util, http) {   
init();
    /**
     * 初始化函数集合
     */
    function init() {
    	bind();
    }
    var erEscEntName=$("#erEscEntName").val();
    
    //获取短信验证码
    $("#getCode").click(function(){
    	var tel = $("#mobTel").val();
    	if(!tel.match(/^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/)){
    		alert("手机号码格式不对");
    	}else{
    		var district = $("#regOrg").val();
    		getMsgCode(tel,district,erEscEntName);
    	}
	});
    $("#getCode1").click(function(){
    	var tel = $("#mobTel1").val();
    	if(!tel.match(/^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/)){
    		alert("手机号码格式不对");
    	}else{
    		var district = $("#regOrg1").val();
    		getMsgCode(tel,district,erEscEntName);
    	}
	});
    $("#getCode2").click(function(){
    	var tel = $("#mobTel2").val();
    	if(!tel.match(/^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/)){
    		alert("手机号码格式不对");
    	}else{
    		var district = $("#regOrg2").val();
    		getMsgCode(tel,district,erEscEntName);
    	}
	});
    function getMsgCode(tel,district,erEscEntName){
    	$.ajax({
            url: "getMsgCode",
            type: 'get',
            data: {"tel":tel,"district":district,"entName":erEscEntName},
            success: function(data, status){
	            layer.msg("获取验证码成功", {time: 1200}, function() {});
            },error: function(data, status){
            	layer.msg("获取验证码失败", {time: 3000}, function() {});
            }
        });
    }
    
    var prefix=$("#prefix").val();
    var prefix1=$("#prefix1").val();
    var prefix2=$("#prefix2").val();
    $("#btnUpload_1").click(function(){
    	$("#certificatesPic").val("");
    	var faceprefix = prefix+"personface"+new Date().getTime();
		upload($(this),1,faceprefix);
	});
    $("#btnUpload_2").click(function(){
    	$("#bcertificatesPic").val("");
    	var bcprefix = prefix+"personopposite"+new Date().getTime();
		upload($(this),2,bcprefix);
	});
    $("#btnUpload_3").click(function(){
    	$("#certificatesPic3").val("");
    	var faceprefix = prefix1+"ent"+new Date().getTime();
		upload($(this),3,faceprefix);
	});
    $("#btnUpload_4").click(function(){
    	$("#certificatesPic4").val("");
    	var faceprefix = prefix2+"otherunit"+new Date().getTime();
		upload($(this),4,faceprefix);
	});
	
	function upload(e,i,prefix){
    	var file=$("#btnFile_"+i).val();
    	if(file==""){
    		layer.msg("请先选择需要上传的文件", {time: 3000}, function() {});
    		return false;
    	}
    	var suffixArr = file.split(".");
    	var suffix = suffixArr[suffixArr.length-1];
    	var tp ="jpg,JPG";
    	var rs=tp.indexOf(suffix);
    	if(rs>=0){
    		 var filePath = "simpleesc/objection/"+prefix+"."+suffix;
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
    			 url: "upload",
    			 type: 'post',
    			 data: {"prefix":prefix,"suffix":suffix},
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
        		if(data.errorCode!="-1"){
        			layer.msg(data.msg, {time: 1000}, function () {
                    	window.location.href='objectionDetail?encryPriPID='+encryPriPID;
                    });
        		}else{
        			layer.msg(data.msg, {time: 1000}, function () {
                    	window.location.href='objectionApply?encryPriPID='+encryPriPID;
                    });
            	}
            }
        })
	}
	
	function validateCerNO(idcard){
		var area = {
                11: "北京", 12: "天津", 13: "河北", 14: "山西", 15: "内蒙古", 21: "辽宁", 22: "吉林", 23: "黑龙江", 31: "上海", 32: "江苏", 33: "浙江",
                34: "安徽", 35: "福建", 36: "江西", 37: "山东", 41: "河南", 42: "湖北", 43: "湖南", 44: "广东", 45: "广西", 46: "海南", 50: "重庆", 51: "四川",
                52: "贵州", 53: "云南", 54: "西藏", 61: "陕西", 62: "甘肃", 63: "青海", 64: "宁夏", 65: "新疆", 71: "台湾", 81: "香港", 82: "澳门", 91: "国外"
            };
            var Y, JYM, S, M, ereg,idcard_array =  idcard.split("");
            if (area[parseInt(idcard.substr(0, 2))] == null) {
                return false;
            }
            switch (idcard.length) {
                case 15:
                    if ((parseInt(idcard.substr(6, 2)) + 1900) % 4 == 0 || ((parseInt(idcard.substr(6, 2)) + 1900) % 100 == 0 && (parseInt(idcard.substr(6, 2)) + 1900) % 4 == 0)) {
                        ereg = /^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}$/;
                    } else {
                        ereg = /^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$/;
                    }
                    if (ereg.test(idcard)) {
                        return true;
                    } else {
                        return false;
                    }
                    break;
                case 18:
                    if (parseInt(idcard.substr(6, 4)) % 4 == 0 || (parseInt(idcard.substr(6, 4)) % 100 == 0 && parseInt(idcard.substr(6, 4)) % 4 == 0)) {
                        ereg = /^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9Xx]$/;
                    } else {
                        ereg = /^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9Xx]$/;
                    }
                    if (ereg.test(idcard)) {
                        S = (parseInt(idcard_array[0]) + parseInt(idcard_array[10])) * 7
                            + (parseInt(idcard_array[1]) + parseInt(idcard_array[11])) * 9
                            + (parseInt(idcard_array[2]) + parseInt(idcard_array[12])) * 10
                            + (parseInt(idcard_array[3]) + parseInt(idcard_array[13])) * 5
                            + (parseInt(idcard_array[4]) + parseInt(idcard_array[14])) * 8
                            + (parseInt(idcard_array[5]) + parseInt(idcard_array[15])) * 4
                            + (parseInt(idcard_array[6]) + parseInt(idcard_array[16])) * 2
                            + parseInt(idcard_array[7]) * 1
                            + parseInt(idcard_array[8]) * 6
                            + parseInt(idcard_array[9]) * 3;
                        Y = S % 11;
                        M = "F";
                        JYM = "10X98765432";
                        M = JYM.substr(Y, 1);
                        if (M == idcard_array[17]) {
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
            	}
            }
    
    function bind() {
        util.bindEvents([{
            el: '#btn0',
            event: 'click',
            handler: function () {
            	var name=$.trim($("#name").val());//姓名
            	var cerNO=$.trim($("#cerNO").val());//身份证号
            	var certificatesPic=$("#certificatesPic").val();//身份证正面照
            	var bcertificatesPic=$("#bcertificatesPic").val();//身份证背面照
            	var mobTel=$.trim($("#mobTel").val());//移动电话
            	var validateCode=$.trim($("#validateCode").val());//验证码
            	
            	var objections=new Array();//异议内容
            	var encryPriPID = $("#encryPriPID").val();
        		$(":checkbox:checked").each(function(k,v){
        			objections[k]= this.value;
        		});
        		$("#objection").val(objections);
        		
        		if(name==""){
        			alert("姓名不能为空");
        		}else if (cerNO==""||!validateCerNO(cerNO)){
        			alert("身份证号不能为空或者格式错误");
        		}else if (certificatesPic==""){
        			alert("身份证号正面照不能为空");
        		}else if (bcertificatesPic==""){
        			alert("身份证号背面照不能为空");
        		}else if (mobTel==""||!mobTel.match(/^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/)){
        			alert("手机号码不能为空或者格式错误");
        		}else if (validateCode==""){
        			alert("验证码不能为空");
        		}else if ($("#objection").val()==""){
        			alert("异议内容不能为空");
        		}else{
        			var formParam = $('#form0').serializeObject();
        			var url="saveByPerson";
        			save(formParam,url,encryPriPID);
        		}
            }
        },{
            el: '#btn1',
            event: 'click',
            handler: function () {
            	var entName=$.trim($("#entName").val());//企业名称
            	var unireg=$.trim($("#unireg1").val());//统一代码/注册号
            	var leRep=$.trim($("#leRep").val());//法定代表人
            	var cerNO=$.trim($("#cerNO1").val());//法定代表人证件号码
            	var certificatesPic=$("#certificatesPic3").val();//营业执照（正本）证件照片
            	var name=$.trim($("#name1").val());//联络员姓名
            	var mobTel=$.trim($("#mobTel1").val());//联系电话
            	var validateCode=$.trim($("#validateCode1").val());//验证码
            	
            	var objections="";
            	var encryPriPID = $("#encryPriPID1").val();
        		$(":checkbox:checked").each(function(k,v){
        			objections= objections+this.value+";";
        		});
        		objections = objections.substring(0,objections.length-1);
        		$("#objection1").val(objections);
        		
        		if(entName==""){
        			alert("企业名称不能为空");
        		}else if (leRep==""){
        			alert("法定代表人不能为空");
        		}else if (unireg==""){
        			alert("统一代码/注册号不能为空");
        		}else if (cerNO==""||!validateCerNO(cerNO)){
        			alert("法定代表人证件号码不能为空或者格式错误");
        		}else if (certificatesPic==""){
        			alert("营业执照（正本）证件照片不能为空");
        		}else if (name==""){
        			alert("联络员不能为空");
        		}else if (mobTel==""||!mobTel.match(/^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/)){
        			alert("手机号码不能为空或者格式错误");
        		}else if (validateCode==""){
        			alert("验证码不能为空");
        		}else if ($("#objection1").val()==""){
        			alert("异议内容不能为空");
        		}else{
        			if(unireg.length==18){
        				$("#uniSCID1").val(unireg);
        			}else{
        				$("#regNO1").val(unireg);
        			}
        			var formParam = $('#form1').serializeObject();
        			var url="saveByEnt";
        			save(formParam,url,encryPriPID);
        		}
            }
        },{
            el: '#btn2',
            event: 'click',
            handler: function () {
            	var entName=$.trim($("#entName2").val());//企业名称
            	var unireg=$.trim($("#unireg2").val());//统一代码/注册号
            	var certificatesPic=$("#certificatesPic4").val();//单位证照（正面）照片
            	var name=$.trim($("#name2").val());//联络员姓名
            	var mobTel=$.trim($("#mobTel2").val());//联系电话
            	var validateCode=$.trim($("#validateCode2").val());//验证码
            	var otherContent = $.trim($("#otherContent").val());//其他异议信息
            	
            	var objections=new Array();
            	var encryPriPID = $("#encryPriPID2").val();
            	var objections="";
        		$(":checkbox:checked").each(function(k,v){
        			objections= objections+this.value+";";
        		});
        		objections = objections.substring(0,objections.length-1);
        		$("#objection2").val(objections);
        		
        		if(entName==""){
        			alert("企业名称不能为空");
        		}else if (unireg==""){
        			alert("统一代码/注册号不能为空");
        		}else if (certificatesPic==""){
        			alert("单位证照（正面）照片不能为空");
        		}else if (name==""){
        			alert("联络员不能为空");
        		}else if (mobTel==""||!mobTel.match(/^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/)){
        			alert("手机号码不能为空或者格式错误");
        		}else if (validateCode==""){
        			alert("验证码不能为空");
        		}else if ($("#objection2").val()==""&&otherContent==""){
        			alert("异议内容不能为空");
        		}else{
        			if(unireg.length==18){
        				$("#uniSCID2").val(unireg);
        			}else{
        				$("#regNO2").val(unireg);
        			}
        			var formParam = $('#form2').serializeObject();
        			var url="saveByOtherUnit";
        			save(formParam,url,encryPriPID);
        		}
            }
        }
    ])}

})
