require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() { 
        bind();
        
        var  flag=window._CONFIG._flag;
         if(flag=="2"||flag=="1"){//修改和查看时回显
         	var  _licZone=window._CONFIG._licZone;
           	var  _licZoneArr=_licZone.split(",");
      		var licZoneTemArr=$('input[name="licZoneTem"]');
      		$.each(_licZoneArr, function(a,b) { 
      			$.each(licZoneTemArr, function(c,d) { 
      				if(_licZoneArr[a]==d.value){
      					$(this).attr("checked",'true');
      				}
      		    });
      	    }); 
        }
        if(flag=="2"){
        	var ohterArr=$(".jyexpire input");
			$.each(ohterArr, function(i, n) {
			 if(this.id!=null&&this.id!="cancelcodelicense"){
				 $(this).attr("disabled",true); 
			 }
		    });
        }
        
      } 

    function bind() {
        util.bindEvents([
        {
            el: '#cancelcodelicense',
            event: 'click',
            handler: function () {
                layer.close();
            }
        },
        {
            el: '#choselicDeptType',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择职能部门',
                    area: ['400px', '600px'],
                    content: '/common/system/code_duty_dept/duty_dept_select',
                    callback: function (data) {  
                        $("#licDeptType").val(data.deptCodes);
                    	$("#licDeptTypeTem").val(data.deptNames); 
                    }
                })
            }
        },
        {
            el: '#selectDept',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择审批部门',
                    area: ['400px', '600px'],
                    content: '/common/system/sysdepart/alldeptcheckboxtreeselect?isNoCheck=1',
                    callback: function (data) {
                     	var adCodesArr=data.adCodes.split(",");
                    	var orgNamesArr=data.orgNames.split(",");
                    	if(adCodesArr.length>0){
                    		for(var i=0;i<adCodesArr.length;i++){
                    			if(adCodesArr[i].length!=13){
                    				orgNamesArr.splice(i,1); 
                     				adCodesArr.splice(i,1);
                    				i--;
                    			}
                    		}
                    	} 
                    	if(adCodesArr.length==0){
                    		layer.msg("请具体的审批部门", {ltype: 0,time:2000});
            	    		return false;
                    	}
                    	$("#deptCode").val(adCodesArr.join(","));
                    	$("#deptName").val(orgNamesArr.join(","));
                    	$("#deptNameText").val(orgNamesArr.join(","));
                   }
                })
            }
        },
        {
            el: '#savecodelicense',
            event: 'click',
            handler: function () { 
            	var  flag=window._CONFIG._flag;
            	//法律依据
        		var licRea=$.trim($("#licReaTem").val());
        		//审批部门
        		var licDeptTypeTem=$.trim($("#licDeptTypeTem").val());
        		//审批部门
        		var licDept=$.trim($("#licDeptTem").val());
        		//审批事项 编码
        	    var liccode=$.trim($("#exaCodeTem").val());
        	    //审批事项名称
        	    var exaName=$.trim($("#exaNameTem").val()) ; 
        	    if((liccode==""||liccode==null)){ 
    	    		layer.msg("后置审批事项编码不能为空", {ltype: 0,time:2000});
    	    		return false;
    	    	} 
    	    	if(exaName==""||exaName==null){ 
    	    		layer.msg("后置审批事项名称不能为空", {ltype: 0,time:2000});
    	    		return false;
    	    	} 
    	    	
    	    	if(licDept==""||licDept==null){ 
    	    		layer.msg("审批部门不能为空", {ltype: 0,time:2000});
    	    		return false;
    	    	}
    	    	
    	    	
    	    	 var licZoneStr="";
                 var licZoneArr=$('input[name="licZoneTem"]:checked');
                 if(licZoneArr.length==0){
                	 layer.msg("请选择审批部门级别", {ltype: 0,time:2000});
         			 return false;
                 }else{
                	 $.each(licZoneArr, function(a,b) { 
                		 if(a==licZoneArr.length-1){
                			 licZoneStr+=b.value;
                		 }else{
                			 licZoneStr+=b.value+",";
                		 }
      		         });
                  }
                 
                 
                if(licDeptTypeTem==""||licDeptTypeTem==null){ 
     	    		layer.msg("职能部门不能为空", {ltype: 0,time:2000});
     	    		return false;
     	    	} 
                 
    	    	if(licRea==""||licRea==null){ 
    	    		layer.msg("法律依据不能为空", {ltype: 0,time:2000});
    	    		return false;
    	    	} 
    	    	
    	    	$("#exaCodeTem").val(liccode);
    	    	$("#licRea").val(licRea);
    	    	$("#licDept").val(licDept);
    	    	$("#exaCode").val(liccode);
    	    	$("#exaName").val(exaName);
     	    	$("#licZone").val(licZoneStr);
     	    	var msg="新增";
     	    	if(flag=="1"){
     	    		msg="修改"; 
     	    	}
        	    layer.confirm('后置审批事项需和准入系统保持一致，若非准入系统的后置审批事项有变化，否则请勿执行'+msg+'操作,确定要'+msg+'吗?', {icon: 3, title: '提示'}, function () { 
        	    	var formParam=$('#codeLicenseform').serializeObject();
        	    	http.httpRequest({
	                    url: '/common/system/codedzlicense/commitCodeLicense',
	                    serializable: true,
	                    data: formParam,
	                    type: 'post',
	                    success: function (data) { 
	                    	
	                    	if (data.status == 'success') {  
                                layer.msg("保存成功", {time: 2000}, function () {
                                	layer.close({reload: true});
                                }); 
                        }else{
                        	layer.msg("保存失败", {ltype: 0,time:2000});
                        }
	                }
        	    	});	
                }) 
            }
        }
        ])
    }

})
