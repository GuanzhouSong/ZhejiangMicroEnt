require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {
	//警示 协同的URL前缀
	var _sysUrl=window._CONFIG._sysUrl;
     init();
    /**
     * 初始化函数集合
     */
    function init() { 
        bind();
        initCheckClaimStatus();
        //randomDeptByExaCode(); 
      }  
    
    
    function initCheckClaimStatus(){
    	//认领状态  默认未认领  
		var checkClaimState=window._CONFIG._checkClaimState;
		if(checkClaimState==null||checkClaimState==""){
			checkClaimState="0";
		}
		//接收状态 默认未接收 
		var checkReceiveState=window._CONFIG._checkReceiveState;
		if(checkReceiveState==null||checkReceiveState==""){
			checkReceiveState="0";
		}
		//部门类型   1：备案； 2：属地； 3：同级
		var checkDepttype = window._CONFIG._checkDepttype;
		if(checkDepttype==null||checkDepttype==""){
			checkDepttype="1";
		}
		if(checkDepttype=="1"){
			if(checkClaimState=="0"){
				$("#claimStateName").text("认领状态");
				$("#claimStateText").text("未认领");
				//标红
				$("#claimStateName").css("color","red");
				$("#claimStateText").css("color","red");
			}else if(checkClaimState=="1"){
				$("#claimStateName").text("认领状态");
				$("#claimStateText").text("已认领");
			} 
		}else{
			if(checkReceiveState=="0"){
				$("#claimStateName").text("接收状态");
				$("#claimStateText").text("未接收");
			}else if(checkReceiveState=="1"){
				$("#claimStateName").text("接收状态");
				$("#claimStateText").text("已接收");
			} 
		} 
    }
    
    //根据备案事项编码随机选择一个备案部门
    function randomDeptByExaCode(){ 
    	
    	  var formParam=$('#pubdtinfohandpushform').serialize(); 
    	  http.httpRequest({
              url: _sysUrl+'/licdept/randomDeptByExaCode',
              serializable: false,
              data: formParam,
              type: 'get',
              success: function (data) { 
              	if (data.status == 'success') {  
                    var dataArr=data.data;
                    if(dataArr.length>0){ 
                    	$("#deptname").val(dataArr[0].deptName);
                    	$("#checkDep").val(dataArr[0].deptCode);
                    	$("#checkDepName").val(dataArr[0].deptName);
                    }   
                } 
              }
          });
    }
    
    
    function doChange(){ 
    	
    	//是否终止标识 
        var pubdtinfostop=$('input:radio[name="pubdtinfostop"]:checked').val();
    	   //终止时显示终止日期 
        if(pubdtinfostop=="1"){
        	 $("#pubdtinfostopinfo").show();
        	 $("#pubdtinfostopdate").text(window._CONFIG._nowdate);
        	 $("#pubdtinforemark").val("不涉及该项备案，终止推送");
        }else{
        	 $("#pubdtinforemark").val("");
        	 $("#pubdtinfostopinfo").hide();
        }
        $("#checkStopState").val(pubdtinfostop);
    }
    

    function bind() {
        util.bindEvents([{
            el: 'input:radio[name="pubdtinfostop"]',
            event: 'click',
            handler: function () {
            	doChange();
            }
        },
        {
            el: '#cancelpubdtinfohandpush',
            event: 'click',
            handler: function () {
                layer.close();
            }
        },
        {
            el: '#yccodetree',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择备案事项',
                    area: ['400px', '600px'],
                    content: _sysUrl+'/pubdzdtinfo/codeLicenseRadioTreePage',
                    callback: function (data) { 
                        $("#exaCode").val(data.reload.exaCode);
                    	var contentArr= data.reload.exaName.split("-");
						if(contentArr.length>1){
 							$("#exaName").val(contentArr[1]);
						} 
                    	$("#exaCodetext").text(data.reload.licDept);
                    	$("#licDepType").val(data.reload.licDepType);
                    	$("#licName").val(data.reload.exaName);
                    	//选择备案事项后 随机选择一个备案部门
                    	//randomDeptByExaCode();
                    }
                })
            }
        },
        {
            el: '#selectDept',
            event: 'click',
            handler: function () { 
            	var licDepType=$("#licDepType").val();
            	var exaCode= $("#exaCode").val();
            	var licName= $("#licName").val();
            	if((exaCode==null||exaCode=="")||(licName==null||licName=="")){
            		layer.msg("请先选择备案事项", {ltype: 0,time:2000});
    	    		return false;
            	}
                layer.dialog({
                    title: '选择备案部门',
                    area: ['400px', '600px'],
                    content:'/common/system/sysdepart/deptSelectByDuty?treeType=radio&dutyDeptCodes='+licDepType+"&isNoCheck=true", 
                    callback: function (data) { 
                    	if(typeof data.adCodesExcParent!="undefined"&&data.adCodesExcParent!=""&&data.adCodesExcParent!=null){
                    		$("#checkDep").val(data.adCodesExcParent);
                        	$("#deptname").val(data.orgNamesExcParent);
                        	$("#checkDepName").val(data.orgNamesExcParent);
                        	$("#dutyDeptCode").val(data.dutyDeptCodes);
                        	$("#dutyDeptName").val(data.dutyDeptNameStr); 
                    	}
                    }
                })
            }
        },
        {
            el: '#savepubdtinfohandpush',
            event: 'click',
            handler: function () { 
            	//备案机关 
        		var deptname=$.trim($("#deptname").val());
            	//备案机关编码
            	var checkDep=$("#checkDep").val();
        		//备案事项 编码
        	    var liccode=$("#exaCode").val();
        	    //备案事项名称
        	    var licName=$("#licName").val(); 
        		//是否终止标识 
        	    var pubdtinfostop=$('input:radio[name="pubdtinfostop"]:checked').val();
        	    //终止理由 
        	    var pubdtinforemark=$("#pubdtinforemark").val();
        	    //终止时 验证终止理由 
        	    if(pubdtinfostop=="1"){
        	    	if(pubdtinforemark==""||pubdtinforemark==null){ 
        	    		layer.msg("请选择终止理由", {ltype: 0,time:2000});
        	    		return false;
        	    	} 
        	    	$("#reassignRemark").val(pubdtinforemark);
        	    }else{
        	    	if((liccode==null||liccode=="")||(licName==null||licName=="")){
         	    		layer.msg("请选择备案事项", {ltype: 0,time:2000});
        	    		return false;
        	    	}
        	    	if((deptname==null||deptname=="")||(checkDep==null||checkDep=="") ){ 
        	    		layer.msg("请选择备案机关", {ltype: 0,time:2000});
        	    		return false;
        	    	}
        	    	if(checkDep.length!=13){
        	    		layer.msg("请选择具体的备案机关", {ltype: 0,time:2000});
        	    		return false;
        	    	}
        	    }
        	    
        	    var formParam=$('#pubdtinfohandpushform').serializeObject();  
        	    if(pubdtinfostop=="1"){
        	    	layer.confirm('确定要终止吗?', {icon: 3, title: '提示'}, function () { 
    	                 http.httpRequest({
    	                    url: _sysUrl+'/pubdzdtinfo/commitPubDtInfoHandPush',
    	                    serializable: true,
    	                    data: formParam,
    	                    type: 'post',
	    	                    success: function (data) { 
	    	                    	if (data.status == 'success') {  
		                                layer.msg("操作成功", {time: 2000}, function () {
		                                	layer.close({reload: true});
		                                }); 
		                                
		                                /*layer.msg(data.msg, {time: 1000}, function () {
		                                    layer.close({reload: true});
		                                });*/
		                        }else{
		                        	layer.msg("操作失败", {ltype: 0,time:2000});
		                        }
    	                    }
    	                });
                    })
        	    }else{
        	    	layer.confirm('确定要推送吗?', {icon: 3, title: '提示'}, function () {
        	    		var pushFlag=false; 
                	    http.httpRequest({
                            url: _sysUrl+'/pubdzdtinfo/checkPush',
                            serializable: true,
                            data: formParam,
                            async:false,
                            type: 'post',
        	                    success: function (data) {  
        	                    	if (data.status == 'success'&& (data.data=="true"||data.data==true)) { 
        	                    		pushFlag=true;
                                        layer.msg("此企业同一备案事项该备案部门已经推送，不能重复推送", {time: 2000}, function () {
                                         });
                                }
                            }
                        }); 
                	    if(!pushFlag){
                	    	http.httpRequest({ 
        	                    url: _sysUrl+'/pubdzdtinfo/commitPubDtInfoHandPush',
        	                    serializable: true,
        	                    data: formParam  ,
        	                    type: 'post',
        	                    success: function (data) {
        	                        if (data.status == 'success') {  
        	                                layer.msg("操作成功", {time: 2000}, function () {
        	                                	layer.close({reload: true});
        	                                }); 
        	                        }else{
        	                        	layer.msg("操作失败", {ltype: 0,time:2000});
        	                        } 
        	                    }
        	                });
                	    }
                    }) 
        	    }
            }
        }
        ])
    }

})
