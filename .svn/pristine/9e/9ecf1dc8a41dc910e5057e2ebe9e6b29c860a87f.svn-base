require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {

	//警示 协同的URL前缀
	var _sysUrl=window._CONFIG._sysUrl;
	//deptType部门类型:0 农业 1 工商 2 农信
	var _deptType=window._CONFIG._deptType; 
	var _realName=window._CONFIG._realName; 
	var _aduitDate=window._CONFIG._aduitDate; 
     init();
    /**
     * 初始化函数集合
     */
    function init() { 
        bind();
       } 
    
    
     
    

    function bind() {
        util.bindEvents([ 
        {
            el: '#nySpanY',
            event: 'click',
            handler: function () { 
            	var temphtml = "审核通过"; 
    			temphtml += "\r查核人："+_realName;
    			temphtml += "\r查核时间："+_aduitDate;
    			$("#nyCheckOpinSfc").val(temphtml);
    			$("#declStatus").val("2");
    			$("#declStatus").val(_realName);
    			$("#declStatus").val(_aduitDate);
    			$("#declStatus").val("2");
            }
        },
        {
            el: '#nySpanN',
            event: 'click',
            handler: function () { 
            	var temphtml = "退回修改"; 
    			temphtml += "\r查核人："+_realName;
    			temphtml += "\r查核时间："+_aduitDate;
    			$("#nyCheckOpinSfc").val(temphtml);
    			$("#declStatus").val("3");
            }
        },
        {
            el: '#gsSpanY',
            event: 'click',
            handler: function () { 
            	var temphtml = "有异议"; 
    			temphtml += "\r查核人："+_realName;
    			temphtml += "\r查核时间："+_aduitDate;
    			$("#gsCheckOpinBur").val(temphtml); 
            }
        },
        {
            el: '#gsSpanN',
            event: 'click',
            handler: function () { 
            	var temphtml = "无异议"; 
    			temphtml += "\r查核人："+_realName;
    			temphtml += "\r查核时间："+_aduitDate;
    			$("#gsCheckOpinBur").val(temphtml);
            }
        },
        {
            el: '#jrSpanY',
            event: 'click',
            handler: function () { 
            	var temphtml = "有异议"; 
    			temphtml += "\r查核人："+_realName;
    			temphtml += "\r查核时间："+_aduitDate;
    			$("#jrCheckOpinBank").val(temphtml); 
            }
        },
        {
            el: '#jrSpanN',
            event: 'click',
            handler: function () { 
            	var temphtml = "无异议"; 
    			temphtml += "\r查核人："+_realName;
    			temphtml += "\r查核时间："+_aduitDate;
    			$("#jrCheckOpinBank").val(temphtml);
            }
        },
        {
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	layer.close({reload: false});
            }
        },
        {
            el: '#savepubOpanoBtn',
            event: 'click',
            handler: function () {
            	
            	var flag=true;
            	var year=$("#year").val();
            	var priPID=$("#priPID").val();
            	//修改条件的判断 以防修改数据错误
            	if((priPID==null||priPID=="")||(year==null||year=="")){
            		layer.msg("保存失败!请联系系统管理员", {ltype: 0,time:2000});
    	    		return false;
            	}
            	var stateArr=[];
            	 if(_deptType=="0"){
            		 stateArr= $('input:radio[name="nyState"]:checked'); 
            		 
            		 var nyCheckOpinSfc=$.trim($("#nyCheckOpinSfc").val());
            		 if(stateArr.length==0){
            			 layer.msg("请选择审核结果", {ltype: 0,time:2000});
            			 flag=false;
         	    		 return false;
            		 }
            		 if(nyCheckOpinSfc==null||nyCheckOpinSfc==""){
            			 layer.msg("请输入审核意见", {ltype: 0,time:2000});
            			 flag=false;
         	    		 return false; 
            		 }
            		 if(nyCheckOpinSfc.length>500){
            			 layer.msg("审核意见只能输入500个字符", {ltype: 0,time:2000});
            			 flag=false;
         	    		 return false;
            		 }
            		 $("#declStatus").val($('input:radio[name="nyState"]:checked').val());
            		 $("#checkOpinSfc").val(nyCheckOpinSfc);
            	 }else if(_deptType=="1"){ 
            		 var gsCheckOpinBur=$.trim($("#gsCheckOpinBur").val()); 
            		 if(gsCheckOpinBur==null||gsCheckOpinBur==""){
            			 layer.msg("请输入审核意见", {ltype: 0,time:2000});
            			 flag=false;
         	    		 return false; 
            		 }
            		 if(gsCheckOpinBur.length>500){
            			 layer.msg("审核意见只能输入500个字符", {ltype: 0,time:2000});
            			 flag=false;
         	    		 return false;
            		 }
            		 $("#checkOpinBur").val(gsCheckOpinBur);
            	 }else if(_deptType=="2"){
            		 var jrCheckOpinBank=$.trim($("#jrCheckOpinBank").val()); 
            		 if(jrCheckOpinBank==null||jrCheckOpinBank==""){
            			 layer.msg("请输入审核意见", {ltype: 0,time:2000});
            			 flag=false;
         	    		 return false; 
            		 }
            		 if(jrCheckOpinBank.length>500){
            			 layer.msg("审核意见只能输入500个字符", {ltype: 0,time:2000});
            			 flag=false;
         	    		 return false;
            		 }
            		 $("#checkOpinBank").val(jrCheckOpinBank);
            	 }
            	 
            	 if(flag){
            		 var formParam=$('#pubauditosaveform').serializeObject();
                	 http.httpRequest({
    	                    url:_sysUrl+'/cominfocheck/saveCominfocheck',
    	                    serializable: true,
    	                    data: formParam,
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
            }
        }
        ])
    }
})
