require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars','jquery.form', 'jquery','jquery.serialize','laydate','jquery.multiselect','jquery.validate','common/validateRules',], function (layer, dataTable, util, http,handlebars) {
	
	var searchParams={};
	
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	formValid();
        bind();
        
        initDataPbPartyTable();
        
        if($("#isBuildOrg").prop("checked")){
        	$("#entinfo").show();
        	$("#partyOrgName").removeAttr("readonly");
        }
        var viewFlag = window._CONFIG.viewFlag;
        if(viewFlag != '1'){
        	$("#partymemberinfo").show();
        	$("#topInfo").hide();
        }
        // 地址显示初始化
        if($("#locProvince").val() != '33'){
        	$("#locChoose").hide();
        }else{
        	$("#locCity").attr("required","required");
    		$("#locCounty").attr("required","required");
        }
    }
    
    
    /**
     * 表单验证
     */
    function formValid() {
    	 $('#memberform').validate({
             showErrors:function(errorMap,errorList){
                 for(var i in errorMap){
                     layer.tips(errorMap[i],$('#memberform input[name='+i+'],#memberform select[name='+i+']'),{
                         tips:3,
                         tipsMore:true,
                         ltype:0
                     });
                 }
             },
             submitHandler: function () {
            	 if($("#memberform input[name='memberType']:checked").length == 0){
            		 layer.tips("请选择党员成分",$("#memberType1"),{tips:3,tipsMore:true,ltype:0});
            		 return false;
            	 }
            	 if($("#memberform input[name='sex']:checked").length == 0){
            		 layer.tips("请选择党员性别",$("#sex1"),{tips:3,tipsMore:true,ltype:0});
            		 return false;
            	 }
            	 if($("#memberform input[name='pmType']:checked").length == 0){
            		 layer.tips("请选择党员类别",$("#pmType1"),{tips:3,tipsMore:true,ltype:0});
            		 return false;
            	 }
            	 if($("#memberform input[name='partyPosition']:checked").length == 0){
            		 layer.tips("请选择党内职务",$("#partyPosition1"),{tips:3,tipsMore:true,ltype:0});
            		 return false;
            	 }
            	 if($("#memberform input[name='pmDistributed']:checked").length == 0){
            		 layer.tips("请选择党员分布",$("#pmDistributed1"),{tips:3,tipsMore:true,ltype:0});
            		 return false;
            	 }
            	 if($("#memberform input[name='nationality']:checked").length == 0){
            		 layer.tips("请选择民族",$("#nationality1"),{tips:3,tipsMore:true,ltype:0});
            		 return false;
            	 }
            	 if($("#memberform input[name='partyWorker']:checked").length == 0){
            		 layer.tips("请选择是否是党务工作者",$("#partyWorker1"),{tips:3,tipsMore:true,ltype:0});
            		 return false;
            	 }
            	 if(!validateEntinfoForm()){
            		 return false;
            	 }
            	 
                 if($("#locProvince").val() == '33'){
                	 var comAddrCity = $("#locCity option:selected").text();
                     var comAddrRegion = $("#locCounty option:selected").text();
                	 $("#originLoc").val("浙江省" + comAddrCity + comAddrRegion);
                 }else{
                	 $("#originLoc").val($("#locProvince option:selected").text());
                 }
                 var formParam = $('#memberform').serializeObject();
                 
                 var entInfoFrom = $('#entInfoFrom').serializeObject();
                 formParam.isBuildPartyOrg = entInfoFrom.isBuildPartyOrg;
                 formParam.buildOrgType = entInfoFrom.buildOrgType;
             	 formParam.createOrgTime = entInfoFrom.createOrgTime;
             	 formParam.partyMemberNum = entInfoFrom.partyMemberNum;
             	 formParam.buildOrgWay = entInfoFrom.buildOrgWay;
             	 
                 http.httpRequest({
                  	  url: '/reg/server/party/member/saveOrEdit',
                      serializable: false,
                      data: formParam,
                      type: 'post',
                      success: function (data) {
                          layer.msg(data.msg, {time: 1000}, function () {
                        	  if(data.status == 'success') {
                        		 layer.close({reload: true});
                        	  }
                          });
                      }
                  })
              }
         })
    } 
    

    var threeYeartable;
    /**
     * 初始化dataTable
     */
    function initDataPbPartyTable() {
    	threeYeartable = dataTable.load({
            el: '#table_threeyear',
			showIndex: true,
			scrollX:true,
			"aLengthMenu": [10, 25, 50, 100,1000,2000],
            ajax: {
                url:'/reg/server/party/member/partyYearInfo.json',
                data:function(d){
                	d.params = {"priPID":$("#priPID").val(),"entType":$("#entType").val()};
                }
            },
            columns: [
                {data: '_idx',width:'55px'},
                {data: 'year',width:'100px'},
                {data: 'firstReportTime',width:'100px'},
                {data: 'lastReportTime',width:'100px'},
                {data: 'empNum',width:'100px'},
                {data: 'numParM',width:'100px'},
                {data: 'resParMSign',width:'100px'},
                {data: 'resParSecSign',width:'100px'},
                {data: 'parIns',width:'100px'},
                {data: 'parSetTime',width:'100px'},
                {data: 'parOrgW',width:'100px'}
            ],
            columnDefs : [ 
						{
							targets : 6,
							render : function(data, type, row, meta) {
							   if(data == '1'){
								   return "是";
							   }else{
								   return "否";
							   }
							}
						},{
							targets : 7,
							render : function(data, type, row, meta) {
							   if(data == '1'){
								   return "是";
							   }else{
								   return "否";
							   }
							}
						},{
							targets : 8,
							render : function(data, type, row, meta) {
							   if(data == '0'){
								   return "未组建党支部";
							   }else if(data == '1'){
								   return "党支部";
							   }else if(data == '2'){
								   return "党总支";
							   }else if(data == '3'){
								   return "党委";
							   }else{
								   return "";
							   }
							}
						},{
							targets : 10,
							render : function(data, type, row, meta) {
								if(data == '1'){
									return "单独组建";
								}else if(data == '2'){
									return "联合组建";
								}
							}
						}
					 ]
           })
    }
    
    function validateEntinfoForm(){
    	if($("#entInfoFrom input[name = isBuildPartyOrg]:checked").val() =='1'){
    		if($("#buildOrgType").val() == ''){
    			layer.tips("请选择党组织建制",$("#buildOrgType"),{tips:3,tipsMore:true,ltype:0});
    			return false;
    		}
    		if($("#createOrgTime").val() == ''){
    			layer.tips("请输入组建日期",$("#createOrgTime"),{tips:3,tipsMore:true,ltype:0});
    			return false;
    		}
    		if($("#partyMemberNum").val() == ''){
    			layer.tips("请输入党员人数（含预备党员）",$("#partyMemberNum"),{tips:3,tipsMore:true,ltype:0});
    			return false;
    		}
    		if($("#buildOrgWay").val() == ''){
    			layer.tips("请选择组建方式",$("#buildOrgWay"),{tips:3,tipsMore:true,ltype:0});
    			return false;
    		}
    	}
    	return true;
    }
    
    function bind() {
        util.bindEvents([{
            el: '#save',
            event: 'click',
            handler: function () {
            	if(!validateEntinfoForm()){
            		 return false;
            	}
                var formParam = $('#entInfoFrom').serializeObject();
                if(formParam.isBuildPartyOrg == '0'){
                	formParam.buildOrgType = null;
                	formParam.createOrgTime = null;
                	formParam.partyMemberNum = null;
                	formParam.buildOrgWay = null;
                }
                http.httpRequest({
                 	  url: '/reg/server/party/ent/saveOrEdit',
                     serializable: false,
                     data: formParam,
                     type: 'post',
                     success: function (data) {
                         layer.msg(data.msg, {time: 1000}, function () {
                        	 window.location.reload();
                         });
                     }
                 })
             }
        },{
            el: '#locCity',
            event: 'change',
            handler: function () {
            	if($(this).val() == ''){
            		$("#locCounty").html("");
            		return;
            	}
                http.httpRequest({
                 	 url: '/reg/server/party/member/chooseOriginLoc',
                     serializable: false,
                     data: {cityCode:$("#locCity").val()},
                     type: 'get',
                     success: function (data) {
                    	 if(data.status == 'success'){
                    		 var list = data.data;
                             var html = '';
                             for(var i=0; i<list.length; i++){
                                 html +='<option value="'+list[i].code+'" >'+list[i].addressName+'</option>';
                                 $("#locCounty").html(" ").append("<option></option>"+html);
                             }
                     	}
                     }
                 })
             }
        },{
            el: '#locProvince',
            event: 'change',
            handler: function () {
                if($(this).val() == '33'){
            		$("#locChoose").show();
            		$("#locCity").attr("required","required");
            		$("#locCounty").attr("required","required");
            	}else{
            		$("#locChoose").hide();
            		$("#locCity").removeAttr("required");
            		$("#locCounty").removeAttr("required");
            	}
             }
        },{
            el: '#cliam',
            event: 'click',
            handler: function () {
            	$("#partymemberinfo").show();
            	$("#topInfo").hide();
             }
        },{
            el: '#close',
            event: 'click',
            handler: function () {
            	layer.close();
             }
        },{
            el: '#closemember',
            event: 'click',
            handler: function () {
            	var viewFlag = window._CONFIG.viewFlag;
            	if(viewFlag == '3'){
            		layer.close();
            	}else{
            		$("#partymemberinfo").hide();
                	$("#topInfo").show();
            	}
             }
        },{
            el: '.isBuild',
            event: 'click',
            handler: function () {
            	if($(this).prop("checked")){
            		if($(this).val() == '1'){
                		$("#entinfo").show();
                		$("#partyOrgName").removeAttr("readonly");
                	}else{
                		$("#entinfo").hide();
                		$("#partyOrgName").attr("readonly","readonly");
                	}
            	}
             }
        },{
            el: '.attrPos',
            event: 'click',
            handler: function () {
            	if($(this).prop("checked")){
            		if($(this).val() == '2'){
            			$("#isSecretary").removeAttr("disabled");
            		}else{
            			$("#isSecretary").removeAttr("checked").attr("disabled","disabled");
            		}
            	}
             }
        },{
            el: '#choseOrg',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择党组织',
                    area: ['75%', '80%'],
                    content: '/reg/server/party/organize/chooseOrg',
                    callback: function (data) {
                    	if(data.returnCode == 'success'){
                        	$("#partyOrgID").val(data.orgCode);
                        	$("#partyOrgName").val(data.orgName);  
                    	}
                    }
                })
            }
        }])
    }

})
