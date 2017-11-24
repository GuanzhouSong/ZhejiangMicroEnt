require(['component/iframeLayer', 'common/util', 'common/http', 'jquery','jquery.validate', 'common/validateRules', 'jquery.serialize','jquery-ui'], function (layer, util, http) {
	init();
	
    function init() {
    	formValid();
    	initView();
        bind();
    }
    
    function showDoublyStoSelect2(pcode){
    	$("#doublyStoSecCode").html("");
    	http.httpRequest({
            url: '/reg/server/registmark/queryDoublyStoListByPcode.json',
            data: {pcode:pcode},
            type: 'post',
            success: function(data) {
           	 	if (data.status == 'success') { 
	           	 	for(var i in data.data){
						$("#doublyStoSecCode").append('<option value="'+data.data[i].code+'">'+data.data[i].codeDesc+'</option>');
					}
	           	 	showDoublyStoSelect3(data.data[0].code);
                }else{
                	layer.msg("操作失败", {ltype: 0,time:1000});
                }
               
            }
        })
    }
    
    function showDoublyStoSelect3(pcode){
    	$("#doublyStoThiCode").html("");
    	http.httpRequest({
            url: '/reg/server/registmark/queryDoublyStoThiInfoByCode.json',
            data: {code:pcode},
            type: 'post',
            success: function(data) {
           	 	if (data.status == 'success') { 
	           	 	for(var i in data.data){
						$("#doublyStoThiCode").append('<option value="'+data.data[i].code+'">'+data.data[i].codeDesc+'</option>');
					}	
                }else{
                	layer.msg("操作失败", {ltype: 0,time:1000});
                }
               
            }
        })
    }
    
    function initView(){
    	
    	http.httpRequest({
            url: '/reg/server/registmark/queryDoublyStoListByPcode.json',
            data: {pcode:""},
            type: 'post',
            success: function(data) {
           	 	if (data.status == 'success') { 
	           	 	for(var i in data.data){
						$("#doublyStoFirCode").append('<option value="'+data.data[i].code+'">'+data.data[i].codeDesc+'</option>');
					}
	           	 	showDoublyStoSelect2(data.data[0].code);
                }else{
                	layer.msg("操作失败", {ltype: 0,time:1000});
                }
               
            }
        })
    	
     $("#IDCode_1,#IDCode_2,#IDCode_3").autocomplete({  
    		 source: function (request, response) {  
    	         var url = '/reg/server/registmark/queryListInstrIDName.json';  
    	         $.ajax({  
    	             'url': url,  
    	             data:{term:request.term},
    	             dataType: 'json',  
    	             success: function (result) {  
    	            	 if (result && result.status == "success") {
    	            		var selectList = [];
         					for(var i in result.data){
         						selectList.push({  
         				            label : result.data[i].idcode +"   "+ result.data[i].idname,  
         				            value : result.data[i].idname  
         				        });
         					}
         					response(selectList)
         				}
    	              
    	             }  
    	         });  
    	     }
         }); 
     
    	 debugger;
    	 $.ajax({
    			url : "/reg/server/registmark/queryListByIDType.json?t="+Math.random(),
    			data : {type:"1"},
    			dataType:"json",
    			success : function(result) {
    				var resultStr = [];
    				if (result && result.status == "success") {
    					for(var i in result.data){
    						$("#type_2_IDCode_1").append('<option value="'+result.data[i].idcode+'">'+result.data[i].idcode+'  '+result.data[i].idname+'</option>');
    						$("#type_3_IDCode_1").append('<option value="'+result.data[i].idcode+'">'+result.data[i].idcode+'  '+result.data[i].idname+'</option>');
    					}
    					
    					 $.ajax({
    				 			url : "/reg/server/registmark/queryListByIDType.json?t="+Math.random(),
    				 			data : {type:"2",pcode:result.data[0].idcode},
    				 			dataType:"json",
    				 			success : function(result) {
    				 				var resultStr = [];
    				 				if (result && result.status == "success") {
    				 					$("#type_3_IDCode_2").html('');
    				 					for(var i in result.data){
    				 						$("#type_3_IDCode_2").append('<option value="'+result.data[i].idcode+'">'+result.data[i].idcode+'  '+result.data[i].idname+'</option>');
    				 					}
    				 				}
    				 			}
    				 		});
    				}
    			}
    		});
    	 
    	 
    	 
    	
    }
    
    /**
     * 校验
     * @param IDType
     * @returns
     */
    function check(IDType){
    	var IDName = $("#IDName").val();
        var validDate = $("#validDate").val();
    	if(!IDName || $.trim(IDName) == ""){
    		layer.msg("标签名称不能为空！",
            function() {
                layer.close();
            });
    		return false;
    	}
    	if("2" == IDType || "3" == IDType ){
    		var pSelectVal =  $("#type_"+IDType).find(".marklastSelect:last option:selected").val();
    		if(!pSelectVal || $.trim(pSelectVal) == ""){
        		layer.msg("父级标签不能为空！",
                function() {
                    layer.close();
                });
        		return false;
        	}
    	}
        if(!validDate || $.trim(validDate) == ""){
            layer.msg("标签有效期不能为空！",
                function() {
                    layer.close();
                });
            return false;
        }
    	return true;
    		 
    }
    
    /**
     * 表单验证
     */
    function formValid() {

        $('#webForm').validate({
        	onkeyup:false,
        	onfocusout:function(el){
                $(el).valid();
            },
        	showErrors:function(errorMap,errorList){
                for(var i in errorMap){
                    layer.tips(errorMap[i],$('#webForm input[name='+i+'],#webForm textarea[name='+i+'],#webForm select[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
            },
        	rules: { 
        		IDDesc: { //股东（发起人姓名）
	        		required: false,
	        		maxlength:100
        		}
        	},
            submitHandler: function() {
            	    var IDType=$('input:radio[name="IDType"]:checked').val();
            	    var applicationScopeCodeVal = $('input:radio[name="applicationScopeCode"]:checked').val();
                	var setDeptCode = $("#setDeptCode").val().substring(0,4);
            	    var IDCode = $("#type_"+IDType).find(".marklastSelect:last option:selected").val();
            	    var doublyStoState=$('input:radio[name="doublyStoState"]:checked').val();
            	    
            	    if("3"==IDType && "1" == doublyStoState){
            	    	var doublyStoFirName = $("#doublyStoFirCode option:selected").text();
            	    	var doublyStoSecName = $("#doublyStoSecCode option:selected").text();
            	    	var doublyStoThiName = $("#doublyStoThiCode option:selected").text();
            	    	
            	    	$("#doublyStoFirName").val(doublyStoFirName);
            	    	$("#doublyStoSecName").val(doublyStoSecName);
            	    	$("#doublyStoThiName").val(doublyStoThiName);
            	    	
            	    }else{
            	    	$("#doublyStoFirCode").val("");
            	    	$("#doublyStoSecCode").val("");
            	    	$("#doublyStoThiCode").val("");
            	    	$("#doublyStoFirName").val("");
            	    	$("#doublyStoSecName").val("");
            	    	$("#doublyStoThiName").val("");
            	    }
            	    
            	    $("#IDCode").val(IDCode);
            	    $("#IDName").val($("#IDCode_"+IDType).val());

					if("1" == applicationScopeCodeVal){//省局
                        $("#applicationScopeName").val("全省");
					}else if("2" == applicationScopeCodeVal) {//本市
                        if(setDeptCode == '3301'){
                            $("#applicationScopeName").val("杭州市");
                        }else if(setDeptCode == '3302'){
                            $("#applicationScopeName").val("宁波市");
                        }else if(setDeptCode == '3303'){
                            $("#applicationScopeName").val("温州市");
                        }else if(setDeptCode == '3304'){
                            $("#applicationScopeName").val("嘉兴市");
                        }else if(setDeptCode == '3305'){
                            $("#applicationScopeName").val("湖州市");
                        }else if(setDeptCode == '3306'){
                            $("#applicationScopeName").val("绍兴市");
                        }else if(setDeptCode == '3307'){
                            $("#applicationScopeName").val("金华市");
                        }else if(setDeptCode == '3308'){
                            $("#applicationScopeName").val("衢州市");
                        }else if(setDeptCode == '3309'){
                            $("#applicationScopeName").val("舟山市");
                        }else if(setDeptCode == '3310'){
                            $("#applicationScopeName").val("台州市");
                        }else if(setDeptCode == '3325'){
                            $("#applicationScopeName").val("丽水市");
                        }
                    }else{//本局
                        $("#applicationScopeName").val($("#setDeptname").val());
					}

            	    
            	    if(check(IDType)){
            	    	 var formParam = $('#webForm').serializeObject();
                         http.httpRequest({
                             url: '/reg/server/registmark/saveOrUpdate',
                             data: formParam,
                             type: 'post',
                             success: function(data) {
	                        	 if (data.status == 'success') { 
	                    			layer.msg("操作成功", {time: 1000}, function () {
	                                	layer.close({reload: true});
	                                }); 
	 	                        }else{
	 	                        	layer.msg("操作失败", {ltype: 0,time:1000});
	 	                        }
                                
                             }
                         })
            	    }

            }
        })
    }
    
    
    function bind() {
        util.bindEvents([{
            el: '#btn_cancel',
            event: 'click',
            handler: function() {
                layer.close();
            }
        },{
            el: "input[name='IDType']",
            event: 'change',
            handler: function () {
               $(".IDType").hide();
               $("#type_"+$(this).val()).show();
            }
        },{
            el: "#type_3_IDCode_1",
            event: 'change',
            handler: function () {
            	$.ajax({
        			url : "/reg/server/registmark/queryListByIDType.json",
        			data : {type:"2",pcode:$(this).val()},
        			dataType:"json",
        			success : function(result) {
        				var resultStr = [];
        				if (result && result.status == "success") {
        					$("#type_3_IDCode_2").html('');
        					for(var i in result.data){
        						$("#type_3_IDCode_2").append('<option value="'+result.data[i].idcode+'">'+result.data[i].idcode+'  '+result.data[i].idname+'</option>');
        					}
        				}
        			}
        		});
            }
        },{
            el: "#checkValidDate",
            event: 'change',
            handler: function () {
               if(this.checked){
               	$("#div_validDate").hide();
                $("#validDate").val("2099-12-31");
			   }else{
                   $("#validDate").val("");
                   $("#div_validDate").show();
			   }

            }
        },{
        	el: "input[name='doublyStoState']",
        	event: 'change',
        	handler: function () {
        		var thiVal = $(this).val();
        		if("0" == thiVal){
        			$("#div_doublyStoState").hide();
        		}else{
        			$("#div_doublyStoState").show();
        		}
        	}

        },{
        	el: "#doublyStoFirCode",
        	event: 'change',
        	handler: function () {
        		var thiVal = $(this).val();
        		showDoublyStoSelect2(thiVal);
        	}

        },{
        	el: "#doublyStoSecCode",
        	event: 'change',
        	handler: function () {
        		var thiVal = $(this).val();
        		showDoublyStoSelect3(thiVal);
        	}

        }
      ]);
    }
	
})

  

