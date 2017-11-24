require(['component/iframeLayer', 'common/util', 'common/http', 'handlebars','laydate' ,'jquery.validate', 'common/validateRules','jquery.serialize','ztree'], function (layer,util, http,handlebars) {
	
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
        formValid();
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
            	 var priPID = $("#priPID").val();
            	if(priPID == ""){
            		layer.tips("请先查询一家企业主体",$('#keyword'),{tips:3,tipsMore:true,ltype:0});
            		return false;
            	}
            	if($("#markCode").val() != ''){
            		$("#markName").val($("#markCode option:selected").text());
            	}
            	if($("#specialCode").val() != ''){
            		$("#specialName").val($("#specialCode option:selected").text());
            	}
            	var formParam = $("#sysUserForm").serializeObject();
     			http.httpRequest({
                	  url: '/syn/server/sccheck/specialent/saveorupdate',
                    serializable: false,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                        layer.msg(data.msg, {time: 1000}, function () {
                        	if(data.status == 'success'){
                        		layer.close({reload: true});
                        	}
                        });
                    }
                })
             }
         })
    } 
    
    function bind() {
        util.bindEvents([{
            el: '#isLongTime',
            event: 'click',
            handler: function () { 
            	if($(this).prop('checked')){
            		$("#licSaveEndDate").val("9999-09-09");
            	}else{
            		$("#licSaveEndDate").val("");
            	}
            }
        },{
            el: '#specialCode',
            event: 'change',
            handler: function () { 
            	var specialCode = $("#specialCode").val();
            	if(specialCode != null && specialCode != ''){
            		http.httpRequest({
            			url: '/syn/server/sccheck/codemarktype/search',
            			serializable: true,
            			data: {"specialCode":specialCode},
            			type: 'post',
            			success: function (data) {
            				var html = '';
            				if(data){
            					for(var i = 0;i<data.length;i++){
            						html += '<option value="'+data[i].markCode+'">'+data[i].markName+'</option>';
            					}
            				}else{
            					html = '<option value="">暂无专项库对应的标签</option>';
            				}
            				$("#markCode").empty().append(html);
            			}
            		});
            	}
            }
        },{
            el: '#search',
            event: 'click',
            handler: function () { 
            	var keyword = $("#keyword").val();
            	if(keyword == ""){
            		layer.tips("请填写信息",$("#keyword"),{tips:3, tipsMore:true, ltype:0});
            		return false;
            	}
            	http.httpRequest({
		            url: '/syn/server/sccheck/specialent/search',
		            serializable: true,
		            data: {"keyword":keyword},
		            type: 'post',
		            success: function (data) {
		            	if(data){
		            		$("#entName").val(data.entName==null?"":data.entName);
		            		$("#regNOV").val(data.uniCode==null?data.regNO:data.uniCode);
		            		$("#leRep").val(data.leRep==null?"":data.leRep);
		            		$("#estDate").val(data.estDate==null?"":data.estDate);
		            		$("#regOrgName").val(data.regOrgName==null?"":data.regOrgName);
		            		$("#entTypeCatgName").val(data.entTypeCatgName==null?"":data.entTypeCatgName);
		            		$("#localAdmName").val(data.localAdmName==null?"":data.localAdmName);
		            		$("#dom").val(data.dom==null?"":data.dom);
		            		$("#opScope").val(data.opScope==null?"":data.opScope);
		            		$("#regState").val(data.regState==null?"":data.regState);
		            		$("#regStateV").val(data.regStateDesc==null?"":data.regStateDesc);
		            		$("#regOrg").val(data.regOrg==null?"":data.regOrg);
		            		$("#localAdm").val(data.localAdm==null?"":data.localAdm);
		            		$("#priPID").val(data.priPID==null?"":data.priPID);
		            		$("#regNO").val(data.regNO==null?"":data.regNO);
		            		$("#uniCode").val(data.uniCode==null?"":data.uniCode);
		            	}else{
		            		$("#entName").val("");
		            		$("#regNOV").val("");
		            		$("#leRep").val("");
		            		$("#estDate").val("");
		            		$("#regOrgName").val("");
		            		$("#entTypeCatgName").val("");
		            		$("#localAdmName").val("");
		            		$("#regStateV").val("");
		            		$("#dom").val("");
		            		$("#opScope").val("");
		            		$("#regState").val("");
		            		$("#localAdm").val("");
		            		$("#regOrg").val("");
		            		$("#priPID").val("");
		            		$("#regNO").val("");
		            		$("#uniCode").val("");
		            	}
		            }
		        });
            }
        },{
            el: '#checkDeptNameAdd',
            event: 'click',
            handler: function () {
          	    var dutyDeptCode = $("#dutyDeptCode").val();
                layer.dialog({
                    title: '选择部门',
                    area: ['400px', '600px'],
                    content: '/common/system/sysdepart/deptSelectByDuty?treeType=radio&dutyDeptCodes='+dutyDeptCode+"&isNoCheck=true",
                    callback: function (data) {
                        if(data.adCodes){
                            $("#checkDeptCode").val(data.adCodes);
                            $("#checkDeptName").val(data.orgNames);
                        }
                    }
                })
            }
        },{
              el: '#cancel',
              event: 'click',
              handler: function () { 
            	  layer.close();
              }
        }])
    }

})
