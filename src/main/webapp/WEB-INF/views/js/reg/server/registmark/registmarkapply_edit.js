require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','common/validateRules'], function (layer, dataTable, util, http,handlebars) {
	var table;
	var searchParams;
	init();
	
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
	
    function init() {
    	formValid();
        bind();
        initDataTable();
        initView();
    }
    
 function initView(){
    	
    	http.httpRequest({
            url: '/reg/server/registmark/queryDoublyStoListByPcode.json',
            data: {pcode:""},
            type: 'post',
            success: function(data) {
           	 	if (data.status == 'success') { 
           	 		var doublyStoFirCodeV = $("#doublyStoFirCodeV").val();
	           	 	for(var i in data.data){
	           	 		
						$("#doublyStoFirCode").append('<option value="'+data.data[i].code+'" '+(data.data[i].code == doublyStoFirCodeV ? 'selected="selected"':'')+'>'+data.data[i].codeDesc+'</option>');
					}
		           	 http.httpRequest({
		                 url: '/reg/server/registmark/queryDoublyStoListByPcode.json',
		                 data: {pcode:doublyStoFirCodeV},
		                 type: 'post',
		                 success: function(data) {
		                	 	if (data.status == 'success') { 
		                	 		var doublyStoSecCodeV = $("#doublyStoSecCodeV").val();
		     	           	 	for(var i in data.data){
		     						$("#doublyStoSecCode").append('<option value="'+data.data[i].code+'" '+(data.data[i].code == doublyStoSecCodeV ? 'selected="selected"':'')+'>'+data.data[i].codeDesc+'</option>');
		     					}
			     	           	http.httpRequest({
			     	               url: '/reg/server/registmark/queryDoublyStoThiInfoByCode.json',
			     	               data: {code:doublyStoSecCodeV},
			     	               type: 'post',
			     	               success: function(data) {
			     	               	var doublyStoThiCode = $("#doublyStoThiCodeV").val();
			     	              	 	if (data.status == 'success') { 
			     	   	           	 	for(var i in data.data){
			     	   						$("#doublyStoThiCode").append('<option value="'+data.data[i].code+'" '+(data.data[i].code == doublyStoThiCode ? 'selected="selected"':'')+'>'+data.data[i].codeDesc+'</option>');
			     	   					}	
			     	                   }else{
			     	                   	layer.msg("操作失败", {ltype: 0,time:1000});
			     	                   }
			     	                  
			     	               }
			     	           })
		                     }else{
		                     	layer.msg("操作失败", {ltype: 0,time:1000});
		                     }
		                    
		                 }
		             })
	           	 	
                }else{
                	layer.msg("操作失败", {ltype: 0,time:1000});
                }
               
            }
        })
 }
    
    
    function save(){
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
        		IDDesc: {
	        		required: false,
	        		maxlength:100
        		},
        		IDName: { 
	        		required: true,
	        		maxlength:50
        		},
        		validDate: { 
	        		required: true
        		}
        	},
            submitHandler: function() {
	            	var doublyStoState=$('input:radio[name="doublyStoState"]:checked').val();
	        	    
	        	    if("1" == doublyStoState){
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
                    if("2" == $("#IDStateCode").val()){
                    	 http.httpRequest({
    	   	                 url: '/reg/server/registmark/queryCountLikeIDCode.json',
    	   	                 data: {idcode:$("#IDCode").val()},
    	   	                 type: 'post',
    	   	                 success: function (data) {
      	                     	if(data.status=='success'){
      	                     		if(data.data >0){
      	                     			 layer.msg("请先删除子类标签！",
      	                                 function() {
      	                                     layer.close();
      	                                 });
      	                     		}else{
      	                     			save();
      	                     		}
      	                     	}
    	   	                 }
    	   	             });
                    }else{
                    	save();
                    }
            }
        })
    }
    
    
    function initDataTable() {
    	searchParams = $("#webForm").serializeObject();
        table = dataTable.load({
            el: '#user-table',
            showIndex: true,
            aLengthMenu: [10, 25, 50],
            scrollX:true, //支持滚动
			bScrollInfinite:true,
            ajax: {
            	type : "POST",
                url:'/reg/server/registmark/selectRegistMarkAuditHisJSON',
                data:function(d){
                	d.params = searchParams;
                }
            },
            columns: [
                      {data: "_idx"},
                      {data: 'idcode',cut: {length: 20,mark:'...'},width:'150px'},
                      {data: 'idname',cut: {length: 20,mark:'...'},width:'150px'},
                      {data: 'idtype',cut: {length: 20,mark:'...'}},
                      {data: 'iddesc',cut: {length: 20,mark:'...'}},
                      {data: 'setName',cut: {length: 20,mark:'...'}},
                      {data: 'setTime',cut: {length: 20,mark:'...'}},
                      {data: 'setDeptname',cut: {length: 20,mark:'...'}},
                      {data: 'auditorName',cut: {length: 20,mark:'...'}},
                      {data: 'auditTime',cut: {length: 20,mark:'...'}},
                      {data: 'auditDeptName',cut: {length: 20,mark:'...'}},
                      {data: "auditState",cut: {length: 20,mark:'...'}},
                      {data: "auditorDesc",cut: {length: 20,mark:'...'}},
                      {data: 'applicationScopeName',cut: {length: 20,mark:'...'}},
                      {data: 'auditTime',cut: {length: 20,mark:'...'}}
            ],
            columnDefs: [
 				{
 					targets:3,
 					render:function(data,type,row,meta){
 						if(row.idtype=='1'){
 							return '大类';
 						}else if(row.idtype=='2'){
 							return '中类';
 						}else if(row.idtype=='3'){
 							return '小类';
 						}else{
 							return '';
 						}
 					}
 				 },
	 			 {
	                     targets: 11,
	                     render: function (data, type, row, meta) { 
	                    	  //未审核
	                    	  if("1"==data){ 
	                    		  return  "待审核"; 
	                        }else if("2"==data){
	                      	  return  "审核通过"; 
	                        }else if("3"==data){
	                      	  return "审核不通过";
	                        }else {
	                      	  return "";
	                        }
	                     }
	                 }
             ]
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

  

