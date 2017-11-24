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
    	$("#pubjusticeForm").validate({
    		showErrors:function(errorMap,errorList){
                for(var i in errorMap){
                    layer.tips(errorMap[i],$('#pubjusticeForm input[name='+i+'],#pubjusticeForm select[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
            },
    		submitHandler:function(){
    			if($("#executeItem").val() ==''){
	             	 layer.tips("请选择执行事项",$('#executeItem'),{tips:3,tipsMore:true,ltype:0});
	             	 return false;
                }
    			if($("#cerType").val() ==''){
                	 layer.tips("被执行人证件类型不能为空",$('#cerType'),{tips:3,tipsMore:true,ltype:0});
                	 return false;
                }
    			if($("#executeItem").val() == "1" || $("#executeItem").val() == "2"){
    		        if (new Date($("#froFrom").val().replace(/-/g, "/")) > new Date($("#froTo").val().replace(/-/g, "/"))) {
    		        	layer.tips("冻结期限开始日期不能晚于冻结期限结束日期！",$('#froFrom'),{tips:3,tipsMore:true,ltype:0});
    		            return false;
    		        }
    			}
    			if($("#frozenProp").val() > 100){
    				layer.tips("冻结比例不能大于100%",$('#frozenProp'),{tips:3,tipsMore:true,ltype:0});
    				return false;
    			}
    			//股权冻结状态赋值
    			if($("#executeItem").val() == "1" || $("#executeItem").val() == "2"){
    				$("#frozState").val("1");//冻结
    			}else if($("#executeItem").val() == "3"){
    				$("#frozState").val("2");//解冻
    			}else if ($("#executeItem").val() == "4"){
    				$("#frozState").val("");
    			}
    			//公示信息类别：1：股权冻结信息、2：股东强制变更信息
    			if($("#executeItem").val() == "1" || $("#executeItem").val() == "2"|| $("#executeItem").val() == "3"){
    				$("#justiceType").val("1");
    			}else if($("#executeItem").val() == "4"){
    				$("#justiceType").val("2");
    			}
    			
    			layer.confirm('<span style="color:red">司法协助</span>信息一经公示后将不能修改与删除，请确认信息无误？', {icon: 2, title: '提示'}, function () {
    				  $("#hiddencerType").val($("#cerType").val());
	                  var formParam = $('#pubjusticeForm').serializeObject();
	                  var userType= $("#userType").val(); 
	                  var typeUrl="";
	                  if(userType=="2"){
	                	  typeUrl="/syn/other/pubjusticeinfo/addOrEdit";
	                  }else{
	                	  typeUrl="/reg/other/pubjusticeinfo/addOrEdit";
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
    	initHideOrShow($("#executeItem").val());
    }
    
    function hideOrShow(obj,type){
    	$(".commonType").hide();
		if(type == "1"){
			$(".commonType").find("input,select").removeClass("required").val("");
		}
		if(obj == "1"){
			$(".froType").show();
			$(".only").removeAttr("readonly").val("");
			$(".cer").prop("disabled",false).val("");
			$(".froType").find("input").addClass("required");
		}else if(obj == "2"){
			$(".froType").show();
			$(".only").attr("readonly","readonly").val("");
			//设置 被执行人证照(证件)种类 为disabled
			$(".cer").prop("disabled",true).val("");
			$(".froType").find("input").addClass("required");
		}else if(obj == "3"){
			$(".thawType").show();
			$(".only").attr("readonly","readonly").val("");
			//设置 被执行人证照(证件)种类 为disabled
			$(".cer").prop("disabled",true).val("");
			$(".thawType").find("input").addClass("required");
		}else if(obj == "4"){
			$(".alienType").show();
			$(".only").removeAttr("readonly").val("");
			$(".cer").prop("disabled",false).val("");
			$(".alienType").find("input,select").addClass("required");
		}else {
			$(".only").removeAttr("readonly").val("");
			$(".cer").prop("disabled",false).val("");
		}
    }
    
    //页面加载时调用此函数
	function initHideOrShow(obj){
		$(".commonType").hide();
		$(".commonType").find("input,select").removeClass("required");
		if(obj == "1"){
			$(".froType").show();
			$(".only").removeAttr("readonly");
			$(".cer").prop("disabled",false);
			$(".froType").find("input").addClass("required");
		}else if(obj == "2"){
			$(".froType").show();
			$(".only").attr("readonly","readonly");
			//设置 被执行人证照(证件)种类 为disabled
			$(".cer").prop("disabled",true);
			$(".froType").find("input").addClass("required");
		}else if(obj == "3"){
			$(".thawType").show();
			$(".only").attr("readonly","readonly");
			//设置 被执行人证照(证件)种类 为disabled
			$(".cer").prop("disabled",true);
			$(".thawType").find("input").addClass("required");
		}else if(obj == "4"){
			$(".alienType").show();
			$(".only").removeAttr("readonly");
			$(".cer").prop("disabled",false);
			$(".alienType").find("input,select").addClass("required");
		}else {
			$(".only").removeAttr("readonly");
			$(".cer").prop("disabled",false);
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
            el: '#executeItem',
            event: 'change',
            handler: function() {
        		hideOrShow($(this).val(),1);
             }
        },{
            el: '#cerType,#assCerType',
            event: 'change',
            handler: function() {
        		if($("#cerType option:selected").val() =='10'){
        			$("#cerNO").addClass("idCard");
        		}else{
        			$("#cerNO").removeClass("idCard");
        		}
        		if($("#assCerType option:selected").val() =='10'){
        			$("#assCerNO").addClass("idCard");
        		}else{
        			$("#assCerNO").removeClass("idCard");
        		}
             }
        },{
            el: '#doEnInclude',
            event: 'click',
            handler: function() {
            	if($("#executeItem").val() == ""){
        			alert("请先选择 执行事项！");
        			return false;
        		}
            	var priPID = $("#priPID").val();
            	var item = $("#executeItem").val();
            	var userType= $("#userType").val(); 
                var typeUrl="";
                if(userType=="2"){
                	 typeUrl="/syn";
                }else{
                	 typeUrl="/reg";
                }
            	layer.dialog({
                    area: ['60%', '80%'],
                    content: typeUrl+'/other/pubjusticeinfo/includeView?pripid='+priPID+'&executeItem='+item,
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
                        	$("#inv").val(data.inv);
                        	$("#cerType").val(data.cerType);
                        	$("#cerNO").val(data.cerNO);
                        	$("#froAm").val(data.froAm);
                        	var froAuth = data.froAuth;
                        	froAuth = (froAuth =='万元')?'万人民币元':froAuth;
                        	$("#regCapCur").find('option').each(function(){
                        		if(froAuth.indexOf($(this).text()) != -1){
                        			$(this).attr("selected",true);
                        		}
                        	})
                        	$("#froAuth").val(data.froAuth);
                        	$("#upJusticeNO").val(data.UID);
                        }
                    }
                })
             }
        }])
    }
})