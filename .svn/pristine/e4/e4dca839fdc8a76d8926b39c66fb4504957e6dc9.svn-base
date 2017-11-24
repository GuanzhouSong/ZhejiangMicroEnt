require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {
	//警示 协同的URL前缀
	var _sysUrl=window._CONFIG._sysUrl;
	var  flag=window._CONFIG._flag;
    init();
    /**
     * 初始化函数集合
     */
    function init() { 
        bind();
        
        var  flag=window._CONFIG._flag;
        var  _licDeptType=window._CONFIG._licDeptType;
        var  _isValid=window._CONFIG._isValid;
        
        if(flag=="2"){//修改时回显是否推送
        	$("#licDeptTypeText").val(_licDeptType);
        	$("#isSameGovTem").val($("#isSameGov").val()); 
        	var isValidTextArr=$("input[name=isValidText]");
        	//回显有效标识
			$.each(isValidTextArr, function(i, n) {
			 if(_isValid==n.value){
				 $(this).attr("checked",true); 
			  }
		    });
        }
      } 

    function bind() { 
        util.bindEvents([
        {
            el: '#cancellicdept',
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
                    title: '选择后置备案事项',
                    area: ['400px', '600px'],
                    content: _sysUrl+'/pubdzdtinfo/codeLicenseRadioTreePage',
                    callback: function (data) { 
                    	$("#dutyDeptCode").val(data.reload.licDepType); 
                        $("#exaCode").val(data.reload.exaCode);
                    	$("#exaName").val(data.reload.exaName);
                    	$("#exaCodetext").text(data.reload.licDept);
                    	$("#licDeptTypeName").text(data.reload.licDeptTypeName);
                    	$("#licReaTem").text(data.reload.licrea); 
                    	$("#licName").val(data.reload.exaName); 
                    	var contentArr= data.reload.exaName.split("-");
						if(contentArr.length>1){
							$("#licNameText").val(contentArr[1]);
						}
                    }
                })
            }
        },
        {
            el: '#selectDept',
            event: 'click',
            handler: function () { 
            	//备案事项编码
            	var exaCode=$("#exaCode").val();
            	//职能部门编码
            	var dutyDeptCodes=$("#dutyDeptCode").val();
            	if(exaCode==null||exaCode==""){
            		layer.msg("请先选择后置备案事项", {ltype: 0,time:2000});
    	    		return false;
            	}
            	var url='/common/system/sysdepart/deptSelectByDuty?dutyDeptCodes='+dutyDeptCodes+"&treeType=radio";
                /*if(flag!="2"){
                	url='/common/system/sysdepart/deptSelectByDuty?dutyDeptCodes='+dutyDeptCodes;
                }*/
                layer.dialog({
                    title: '选择对应备案部门',
                    area: ['25%', '65%'],
                    content: url,
                    callback: function (data) { 
                    	if(typeof data.adCodesExcParent!="undefined"&&data.adCodesExcParent!=""&&data.adCodesExcParent!=null){
                    		$("#deptCode").val(data.adCodesExcParent);
                        	$("#deptName").val(data.orgNamesExcParent);
                        	$("#deptNameText").val(data.orgNamesExcParent); 
                        	$("#dutyDeptCode").val(data.dutyDeptCodes);
                        	$("#dutyDeptName").val(data.dutyDeptNameStr); 
                     	}
                   }
                }) 
            }
        },
        {
            el: '#selectcity',
            event: 'click',
            handler: function () {  
            	//备案事项编码
            	var exaCode=$("#exaCode").val(); 
            	if(exaCode==null||exaCode==""){
            		layer.msg("请先选择后置备案事项", {ltype: 0,time:2000});
    	    		return false;
            	}
                layer.dialog({
                    title: '选择行政区划',
                    area: ['25%', '65%'],
                    content: '/common/system/sysdepart/deptSelectCtity',
                    callback: function (data) {
                    	if(typeof data.adCodes!="undefined"&&data.adCodes!=""&&data.adCodes!=null){
                    		$("#yiedistrict").val(data.adCodes); 
                    		$("#areaName").val(data.orgNames); 
                    		$("#areaNameText").val(data.orgNames); 
                     	}
                   }
                })
            }
        },
        {
            el: '#savelicdept',
            event: 'click',
            handler: function () { 
            	var  _flag=window._CONFIG._flag;
            	var licDeptType=$("#licDeptTypeText").val();
            	var isSameGovTem=$("#isSameGovTem").val(); 
            	//有效标识 新增时默认1有效  修改时取选择的值
            	var isValid="1";
            	if(_flag=="2"){
            		isValid=$('input:radio[name="isValidText"]:checked').val();
            	}
            	$("#isValid").val(isValid);
            	$("#licDeptType").val("1");
            	$("#isSameGov").val("0");
            	//备案机关 
        		var deptCode=$.trim($("#deptCode").val());
        		//部门中文名称
        		var deptname=$.trim($("#deptNameText").val());
        		//备案事项 
        	    var liccode=$.trim($("#exaCode").val());
        	    //备案事项中文名称
        	    var licName=$.trim($("#licName").val()) ; 
        	    if((liccode==""||liccode==null)||(licName==""||licName==null)){ 
    	    		layer.msg("请选择备案事项", {ltype: 0,time:2000});
    	    		return false;
    	    	} 
    	    	if((deptCode==""||deptCode==null)||(deptname==""||deptname==null)){ 
    	    		layer.msg("请选择对应备案部门", {ltype: 0,time:2000});
    	    		return false;
    	    	} 
    	    	var areaNameText=$.trim($("#areaNameText").val());
    	    	var yiedistrict=$.trim($("#yiedistrict").val());
    	    	if((yiedistrict==null||yiedistrict=="") ||(areaNameText==null||areaNameText=="")){
    	    		layer.msg("请选择企业所属行政区划", {ltype: 0,time:2000});
    	    		return false;
    	    	} 
    	    	
    	    	var orgNameText=$.trim($("#orgNameText").val());
    	    	var adCode=$.trim($("#adCode").val());
    	    	if((orgNameText==null||orgNameText=="") ||(adCode==null||adCode=="")){
    	    		layer.msg("请选择实际备案部门", {ltype: 0,time:2000});
    	    		return false;
    	    	} 
        	    var formParam=$('#licDeptform').serializeObject();
    	    	if(_flag=="2"){//修改
   	                 http.httpRequest({
   	                    url: _sysUrl+'/licdzdept/commitLicDeptEdit',
   	                    serializable: true,
   	                    data: formParam,
   	                    type: 'post',
    	                    success: function (data) { 
    	                    	if (data.status == 'success') { 
    	                    		if(data.data=="1"){
    	                    			layer.confirm(data.msg, {icon: 3, title: '提示'}, function () { 
    	                 	                 http.httpRequest({ 
    	                 	                    url: _sysUrl+'/licdzdept/commitLicDeptUpdate', 
    	                 	                    serializable: true,
    	                  	                    data: formParam,
    	                  	                    type: 'post',
    	                 	                    success: function (data) {
    	                 	                        if (data.status == 'success') {  
    	                 	                                layer.msg("操作成功", {time: 1000}, function () {
    	                 	                                	layer.close({reload: true});
    	                 	                                }); 
    	                 	                        }else{
    	                 	                        	layer.msg("操作失败", {ltype: 0,time:2000});
    	                 	                        } 
    	                 	                    }
    	                 	                  });
    	                                   })
    	                    		}else{
    	                    			layer.msg("操作成功", {time: 1000}, function () {
    	                                	layer.close({reload: true});
    	                                }); 
    	                    		}
	                        }else{
	                        	layer.msg("操作失败", {ltype: 0,time:1000});
	                        }
   	                    }
   	                }); 
    	       }else{//新增
    	    	   http.httpRequest({
  	                    url:_sysUrl+'/licdzdept/commitLicDeptAdd',
  	                    serializable: true,
  	                    data: formParam,
  	                    type: 'post',
   	                    success: function (data) {
   	                    	
   	                    	if (data.status == 'success') { 
                    		    if(data.data=="1"){
                    		    	layer.confirm(data.msg, {icon: 3, title: '提示'}, function () { 
                 	                 http.httpRequest({ 
                 	                    url: _sysUrl+'/licdzdept/commitLicDeptUpdate', 
                 	                    serializable: true,
                  	                    data: formParam,
                  	                    type: 'post',
                 	                    success: function (data) {
                 	                        if (data.status == 'success') {  
                 	                                layer.msg("操作成功", {time: 1000}, function () {
                 	                                	layer.close({reload: true});
                 	                                }); 
                 	                        }else{
                 	                        	layer.msg("操作失败", {ltype: 0,time:2000});
                 	                        } 
                 	                    }
                 	                  });
                                   })
                    		    }else{
                    		      layer.msg("操作成功", {time: 1000}, function () {
                                	layer.close({reload: true});
                                  });
                    		    } 
	                        }else{
	                        	layer.msg("操作失败", {ltype: 0,time:1000});
	                        }
  	                    }
  	                });
    	       }	
            }
        },
        {
            el: '#selectAdDept',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择实际备案部门',
                    area: ['25%', '65%'],
                    content: '/common/system/sysdepart/alldeptradiotreeselect',
                    callback: function (data) { 
                    	
                    	if(typeof data.adCode!="undefined"&&data.adCode!=""&&data.adCode!=null){
                    		 if(data.adCode.length!=13){
                    			 layer.msg("请选择具体的部门", {ltype: 0,time:2000});
                    			 return false;
                    		 }else{
                    			$("#adCode").val(data.adCode);
                             	$("#orgName").val(data.orgName);
                             	$("#orgNameText").val(data.orgName);
                    		 }
                    	}else{
                    		layer.msg("请选择部门", {ltype: 0,time:2000});
               			    return false;
                    	} 
                   }
                })
            }
        }
        ])
    }

})
