require(['component/iframeLayer', 'common/util', 'common/http', 'handlebars','laydate' ,'jquery.validate', 'common/validateRules','jquery.serialize','ztree'], function (layer,util, http,handlebars) {


    init();

    /**
     * 初始化函数集合
     */

    function init() {
    	
    	initDomInfo();
        formValid();
        bind();
        
    	var viewFlag = $("#viewFlag").val();
    	if(viewFlag =='2'){
    		$("#sysUserForm input").each(function(){
    			$(this).attr("disabled",true);
    		})
    	}
    	// 初始化标签
    	if($("#markCode").val() ==""){
    		optMarkInfo($("#specialCode").val());
    	}
    	if($("#notSecial").prop("checked")){
    		$("#isLongTime").attr("disabled","disabled").attr("checked",false);
    	}
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
            	 if($("#sysUserForm input[name='specialLicFlag']:checked").length == 0){
            		 layer.tips("请选择对应专项库的许可证",$('#isSpecial'),{tips:3,tipsMore:true,ltype:0});
            		 return false;
            	 }
            	 if($("#sysUserForm input[name='superviseFlag']:checked").length == 0){
            		 layer.tips("请选择是否需要专业监管",$('#isSupervise'),{tips:3,tipsMore:true,ltype:0});
            		 return false;
            	 }
            	 if($('#isSupervise').prop("checked")){
            		 if($(".rightFlag:checked").length == 0){
                		 layer.tips("请选择是否需要专业资质资格",$('#isRightFlag'),{tips:3,tipsMore:true,ltype:0});
                		 return false;
                	 }
            	 }
            	 if($("#sysUserForm input[name='leadFlag']:checked").length == 0){
            		 layer.tips("请选择是否需要配备专家（组长）",$('#isLeadFlag'),{tips:3,tipsMore:true,ltype:0});
            		 return false;
            	 }
            	 if (new Date($("#licApprDate").val().replace(/-/g, "/")) > new Date($("#licSaveEndDate").val().replace(/-/g, "/"))) {
  		        	layer.tips("许可截止日期不能早于许可批准日期！",$('#licApprDate'),{tips:3,tipsMore:true,ltype:0});
  		            return false;
  		        }
                 var formParam = $('#sysUserForm').serializeObject();
                 var rightFlag = new Array();
                 var leadFlag = new Array();
                 // 专业资质资格
                 if($("#noRightFlag").prop("checked")){
                	 $(".detailsClassF").each(function(){
                		 if($(this).prop('checked')){
                			rightFlag.push($(this).val()); 
                		 }
                     })
                     if(rightFlag.toString() ==""){
                		 layer.tips("请选择专业资质资格信息",$('#tip'),{tips:3,tipsMore:true,ltype:0});
                		 return false;
                	 }
                     formParam.rightFlag = rightFlag.toString();
                 }
                 // 配备专家（组长）
                 if($("#noLeadFlag").prop("checked")){
                	 $(".detailsClassL").each(function(){
                		 if($(this).prop('checked')){
                			 leadFlag.push($(this).val());
                		 }
                	 })
                	 if(leadFlag.toString() ==""){
                		 layer.tips("请选择专家（组长）信息",$('#firTip'),{tips:3,tipsMore:true,ltype:0});
                		 return false;
                	 }
                	 formParam.leadFlag = leadFlag.toString();
                 }
                 // 标签名称
                 var markName = $("#markCode").find("option:selected").text();
                 formParam.markName = markName.toString();
                 
                 http.httpRequest({
                  	  url: '/syn/server/drcheck/specialcheck/saveOrEdit',
                      serializable: false,
                      data: formParam,
                      type: 'post',
                      success: function (data) {
                          layer.msg(data.msg, {time: 1000}, function () {
                              layer.close({reload: true});
                          });
                      }
                  })
              }
         })
    } 
    
    // 表单初始化
    function initDomInfo(){
	    if($('#noLeadFlag').prop("checked")){
	   		$("#checkLead").show(); 
	   	}
	   	if($('#noRightFlag').prop("checked")){
	   		     $("#checkRight").show(); 
	   	}
	   	if($('#notSecial').prop("checked")){
	   		$('.isShow').attr("disabled","disabled").removeAttr("required").val("");
	   		$('.isShow').parent().parent().prev().children().hide();
	   		$("#licApprDate,#licSaveEndDate").attr("onclick","");
	   		$("#qzcodetree").hide();
	   		$("#licName").attr("placeholder","");
	   	}
	   	if($("#noSupervise").prop("checked")){
	   		$(".noInput input").each(function(){
	   			$(this).prop("checked",false).attr("onclick",'return false');
	   		})
	   		$('.show').hide();
	   		$("#checkRight").hide();
	   	}
    }
   
    $("#sysUserForm input[name='superviseFlag']").click(function(){
    	if($(this).prop("checked")){
    		if($(this).val() =='1'){
    			$(".noInput input").each(function(){
    				$(this).attr("onclick",'');
    			})
    			$('.show').show();
    		}else{
    			$(".noInput input").each(function(){
    				$(this).prop("checked",false).attr("onclick",'return false');
    			})
				$('.show').hide();
    			$("#checkRight").hide();
    		}
    	}
    })
    
    function bind() {
        util.bindEvents([{
            el: '#cancel',
            event: 'click',
            handler: function () {
                layer.close();
              }
        },{
            el: '#isLongTime',
            event: 'click',
            handler: function () {
            	if($(this).prop("checked")){
            		$("#licSaveEndDate").val("9999-09-09");
            	}else{
            		$("#licSaveEndDate").val("");
            	}
              }
        },{
        	 el: '#isSpecial',
             event: 'click',
             handler: function () {
            	 if($(this).prop("checked")){
             		$('.isShow').attr("disabled",false).attr("required","required");
             		$('.isShow').parent().parent().prev().children().show();
             		$("#licApprDate,#licSaveEndDate").attr("onclick","laydate()");
             		$("#isLongTime").attr("disabled",false);
             		$("#qzcodetree").show();
             		$("#licName").attr("placeholder","无则手动输入");
             	}
             }
        },{
	       	 el: '#notSecial',
	         event: 'click',
	         handler: function () {
	        	 if($(this).prop("checked")){
	         		$('.isShow').attr("disabled","disabled").removeAttr("required").val("");
	         		$('.isShow').parent().parent().prev().children().hide();
	         		$("#licApprDate,#licSaveEndDate").attr("onclick","");
	         		$("#isLongTime").attr("disabled","disabled").attr("checked",false);
	         		$("#qzcodetree").hide();
	         		$("#licName").attr("placeholder","");
	         	}
	         }
        },{
	       	 el: '.rightFlag',
	         event: 'click',
	         handler: function () {
	        	 if($(this).prop("checked")){
	        		 if($(this).val() =='Y' && !$("#noSupervise").prop("checked")){
	        			 $("#checkRight").show(); 
	        		 }else{
	        			 $("#checkRight").hide();
	        		 }
	         	}
	         }
        },{
	       	 el: '.leadFlag',
	         event: 'click',
	         handler: function () {
	        	 if($(this).prop("checked")){
	        		 if($(this).val() =='Y'){
	        			 $("#checkLead").show(); 
	        		 }else{
	        			 $("#checkLead").hide();
	        		 }
	         	}
	         }
            },{
            	el: '#choseregUnit',
                event: 'click',
                handler: function () { 
                    layer.dialog({
                        title: '选择管辖单位',
                        area: ['350px', '666px'],
                        content: '/commom/server/regunit/regunitsingselect',
                        callback: function (data) {
                        	var returncode=data.returncode;
                          	$("#localAdm").val(returncode);
                          	$("#localAdmName").val(data.returname); 
                        }
                    })
                }
            },{
                el: '#choseSpecial',
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '选择专项库',
                        area: ['400px', '600px'],
                        content: '/syn/server/drcheck/specialcheck/scSpecialSelect?isPermissionCheck=false',
                        callback: function (data) { 
                        	var returncode=data.returncode;
                        	if(returncode!=null && returncode!="" && returncode!='undefine'){
                        		returncode=returncode.substr(0,returncode.length-1); 
                        		$("#specialCode").val(returncode);
                            	$("#specialName").val(data.returnname);
                            	optMarkInfo(returncode);
                        	}
                        }
                    })
                }
            },{
                el: '#qzcodetree',
                event: 'click',
                handler: function () { 
                	layer.dialog({
                        title: '选择许可证',
                        area: ['500px', '600px'],
                        content: '/syn/server/drcheck/specialcheck/licenseListCheckboxTreePage?isRadio=true',
                        callback: function (data) { 
                        	if(typeof data.reload.code=="undefined"){
                        		$("#licName").val("");
                        	}else{
                        		 var content = data.reload.content;
                        		 if(content != "" && content!=null){
                        			var nameArry = content.split('-');
                        			$("#licName").val(nameArry[1]);
                        		 }
                        	} 
                        }
                    })
                }
            }])
       }
    
    function optMarkInfo(returncode){
    	http.httpRequest({
        	url: '/syn/server/drcheck/specialcheck/getMarkInfo',
            serializable: false,
            data: {Code:returncode},
            type: 'get',
            success: function (data) {
            	if(data !=null){
            		$("#markCode").empty();
            		for(var i=0;i < data.data.length;i++){
            			$("#markCode").append("<option value='"+data.data[i].idcode+"'>"+data.data[i].idname+"</option>");
            		}
            	}
            }
        })
    }

})