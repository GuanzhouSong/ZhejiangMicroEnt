require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars','jquery.form', 'jquery','jquery.serialize','laydate','jquery.multiselect','jquery.validate','common/validateRules',], function (layer, dataTable, util, http,handlebars) {
	
	var searchParams={};
	var initFlag = true;
	var table;
	
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	formValid();
        bind();
        
        initDataTable();
        
        initDataPbPartyTable();
        
        if($("#isBuildOrg").prop("checked")){
        	$("#entinfo").show();
        	if($("#partyOrgName").val() == ""){
        		$("#partyOrgName").removeAttr("readonly");
        	}
        }
        $("#identityInfo").trigger("change");
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
    
    function initDataTable() {
    	initFlag = false;
        table = dataTable.load({
            el: '#table_dyxx',
			showIndex: true,
			scrollX:true,
			"aLengthMenu": [10, 25, 50, 100,1000,2000],
            ajax: {
                url:'/reg/server/party/member/partymaintain.json',
                data:function(d){
                   d.params = $("#search-form").serializeObject();
                }
            },
            columns: [
                {data: '_idx',width:'55px'},
                {data: 'memberName',width:'100px'},
                {data: 'identityInfo',width:'100px'},
                {data: 'sex',width:'100px'},
                {data: 'memberAge',width:'100px'},
                {data: 'qualifications',width:'100px'},
                {data: 'nationality',width:'100px'},
                {data: 'joinPartyTime',width:'100px'},
                {data: 'memberType',width:'100px'},
                {data: 'isSecretary',width:'100px'},
                {data: 'pmType',width:'100px'},
                {data: 'partyPosition',width:'100px'},
                {data: 'pmDistributed',width:'100px'},
                {data: 'originLoc',width:'100px'},
                {data: 'orgRelationLoc',width:'100px'},
                {data: 'partyOrgName',width:'100px'},
                {data: 'modifyTime',width:'100px'},
                {data: 'createTime',width:'100px'},
                {data: 'auditName',width:'100px'}
            ],
            columnDefs : [ 
							{
								targets : 1,
								render : function(data, type, row, meta) {
								   return "<a class='edit'>"+row.memberName+"</a>";
								}
							},{
								targets : 3,
								render : function(data, type, row, meta) {
								    if(row.sex == '1'){
								    	return "男";
								    }else if(row.sex == '2'){
								    	return "女";
								    }else{
								    	return "";
								    }
								}
							},{
								targets : 5,
								render : function(data, type, row, meta) {
								    if(row.qualifications == '1'){
								    	return "小学";
								    }else if(row.qualifications == '2'){
								    	return "初中";
								    }else if(row.qualifications == '3'){
								    	return "高中";
								    }else if(row.qualifications == '4'){
								    	return "大专";
								    }else if(row.qualifications == '5'){
								    	return "本科";
								    }else if(row.qualifications == '6'){
								    	return "研究生";
								    }else if(row.qualifications == '7'){
								    	return "硕士";
								    }else if(row.qualifications == '8'){
								    	return "博士";
								    }else if(row.qualifications == '9'){
								    	return "博士后";
								    }else{
								    	return "";
								    }
								}
							},{
								targets : 6,
								render : function(data, type, row, meta) {
								    if(row.nationality == '1'){
								    	return "汉族";
								    }else if(row.nationality == '2'){
								    	return "其它";
								    }else{
								    	return "";
								    }
								}
							},{
								targets : 8,
								render : function(data, type, row, meta) {
								    if(row.memberType == '1'){
								    	return "是";
								    }else if(row.memberType == '2'){
								    	return "否";
								    }else{
								    	return "";
								    }
								}
							},{
								targets : 9,
								render : function(data, type, row, meta) {
								    if(row.isSecretary == '1'){
								    	return "是";
								    }else{
								    	return "否";
								    }
								}
							},{
								targets :10,
								render : function(data, type, row, meta) {
								    if(row.pmType == '1'){
								    	return "正式党员";
								    }else if(row.pmType == '2'){
								    	return "预备党员";
								    }else{
								    	return "";
								    }
								}
							},{
								targets : 11,
								render : function(data, type, row, meta) {
								    if(row.partyPosition == '1'){
								    	return "普通党员";
								    }else if(row.partyPosition == '2'){
								    	return "干部";
								    }else{
								    	return "";
								    }
								}
							},{
								targets : 12,
								render : function(data, type, row, meta) {
								    if(row.pmDistributed == '1'){
								    	return "个体";
								    }else if(row.pmDistributed == '0'){
								    	return "市场";
								    }else{
								    	return "";
								    }
								}
							},{
								targets : 14,
								render : function(data, type, row, meta) {
								    if(row.orgRelationLoc == '1'){
								    	return "街道社区";
								    }else if(row.orgRelationLoc == '2'){
								    	return "辖区协会";
								    }else if(row.orgRelationLoc == '3'){
								    	return "市场";
								    }else if(row.orgRelationLoc == '4'){
								    	return "流动党员";
								    }else{
								    	return "";
								    }
								}
							}
					 ]
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
    
    //表格之外的查询按钮事件
    $("#searchBtn").click(function(){
    	searchParams = $("#search-form").serializeObject();
    	if(initFlag){
    		initDataTable();
    	}else{
    		table.ajax.reload();
    	}
    });
    
    function clearMemberDom(){
    	$("#qualifications,#orgRelationLoc,#remark,#locCity,#locCounty,#partyOrgID").val("");
    	$("#cleardom input").each(function(){
    		if($(this).attr("type") == "text"){
    			$(this).val("");
    		}else if($(this).attr("type") == "radio"){
    			$(this).prop("checked",false);
    		}else if($(this).attr("type") == "checkbox"){
    			$(this).prop("checked",false);
    		}
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
            el: '.edit',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data(); 
            	http.httpRequest({
               	   url: '/reg/server/party/member/getMemberData',
                   serializable: false,
                   data: {memberUid:data.uid},
                   type: 'post',
                   success: function (data) {
                      	 if(data.status == 'success') {
                      		 $("#delete").show();
                      		 var info = data.data;
                      		 $('#memberform')[0].reset();
                      		 $("#partymemberinfo").show();
                      		 $("#memberUid").val(info.uid);
                      		 $("#memberName").val(info.memberName);
                      		 $("#identityInfo").val(info.identityInfo);
                      		 $("#memberAge").val(info.memberAge);
                      		 $("#partyOrgID").val(info.partyOrgID);
                      		 $("#partyOrgName").val(info.partyOrgName);
                      		 $("#belongMarket").val(info.belongMarket);
                      		 $("#phoneNum").val(info.phoneNum);
                      		 $("#joinPartyTime").val(info.joinPartyTime);
                      		 $("#telNum").val(info.telNum);
                      		 $("#orgRegisterTime").val(info.orgRegisterTime);
                      		 $("#remark").val(info.remark);
                      		 $("#auditName").val(info.auditName);
                      		 $("#modifyTime").val(info.modifyTime);
                      		 $("#createTime").val(info.createTime);
                      		 $("#memberType"+info.memberType).prop("checked",true);
                      		 $("#sex"+info.sex).prop("checked",true);
                      		 $("#pmType"+info.pmType).prop("checked",true);
                      		 $("#partyPosition"+info.partyPosition).prop("checked",true);
                      		 $("#pmDistributed"+info.pmDistributed).prop("checked",true);
                      		 $("#nationality"+info.nationality).prop("checked",true);
                      		 $("#partyWorker"+info.partyWorker).prop("checked",true);
                      		 if(info.isSecretary == "1"){
                      			$("#isSecretary"+info.isSecretary).attr("checked",true);
                      		 }else{
                      			$("#isSecretary1").attr("checked",false);
                      		 }
                      	     //--------------------学历---------------
                      		 $("#qualifications option").each(function(){
                      			 if($(this).attr('value') == info.qualifications){
                      				 $(this).prop("selected",true);
                      			 }
                      		 })
                      		 //----------------组织关系所在地---------------
                      		 $("#orgRelationLoc option").each(function(){
                      			 if($(this).attr('value') == info.orgRelationLoc){
                      				 $(this).prop("selected",true);
                      			 }
                      		 })
                      		 //------------------地址选择-----------------------
                      		 $("#locCity option").each(function(){
                      			 if($(this).attr('value') == info.locCity){
                      				 $(this).prop("selected",true);
                      			 }
                      		 })
                      		 var originLoc = info.originLoc;
                      		 if (originLoc !=null && originLoc != '') {
                      			var suStrProCity = originLoc.substring(6);
                         		 $("#locCounty").html("").append("<option value="+info.locCounty+">"+suStrProCity+"</option>");
                      		 }
                      		 $("#identityInfo").trigger("change");
                       }
                   }
               })
             }
        },{
            el: '#delete',
            event: 'click',
            handler: function () {
            	 var memberUid = $("#memberUid").val();
	        	 layer.confirm('确定要删除吗？', {icon: 2, title: '提示'}, function (index) {
	        		 http.httpRequest({
                         url:'/reg/server/party/member/delete',
                         data:{UID : memberUid},
                         serializable: false,
                         type: 'get',
                         success: function (data) {
                             if(data.status=='success'){
                            	 layer.msg(data.msg, {time: 1000}, function () {
                            		 clearMemberDom();
                                 	 $("#partymemberinfo").hide();
                                 	 $("#topInfo").show();
                                 	 table.ajax.reload();
                            	 })
                             }
                         }
                     });
	        		 layer.close(index);
	             });
             }
        },{
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
            el: '#commit',
            event: 'click',
            handler: function () {
        		 http.httpRequest({
                 	  url: '/reg/server/party/member/commitAll',
                     serializable: false,
                     data: {priPID:$("#priPID").val()},
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
        },{
            el: '#identityInfo',
            event: 'change',
            handler: function () {
        		 http.httpRequest({
                 	  url: '/reg/server/party/member/getIdentiInfo',
                     serializable: false,
                     data: {identityInfo:$("#identityInfo").val()},
                     type: 'get',
                     success: function (data) {
                    	 if(data.status == 'success') {
                    		 $("#birthday").val(data.data.birthDay);
                    		 $("#memberAge").val(data.data.age);
                    	 }else{
                    		 $("#birthday,#memberAge").val("");
                    	 }
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
            el: '.attrPos',
            event: 'click',
            handler: function () {
            	if($(this).prop("checked")){
            		if($(this).val() == '2'){
            			$("#isSecretary1").removeAttr("disabled");
            		}else{
            			$("#isSecretary1").removeAttr("checked").attr("disabled","disabled");
            		}
            	}
             }
        },{
            el: '#addbtn',
            event: 'click',
            handler: function () {
            	clearMemberDom();
            	$("#delete").hide();
            	$("#memberUid").val("");
            	$("#partymemberinfo").show();
            	$("#topInfo").hide();
             }
        },{
            el: '#closemember',
            event: 'click',
            handler: function () {
        		$("#partymemberinfo").hide();
        		$("#topInfo").show();
             }
        },{
            el: '#close',
            event: 'click',
            handler: function () {
            	layer.close({reload: true});
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
            el: '#identityInfo',
            event: 'change',
            handler: function () {
        		 http.httpRequest({
                 	  url: '/reg/server/party/member/getIdentiInfo',
                     serializable: false,
                     data: {identityInfo:$("#identityInfo").val()},
                     type: 'get',
                     success: function (data) {
                    	 if(data.status == 'success') {
                    		 $("#birthday").val(data.data.birthDay);
                    		 $("#memberAge").val(data.data.age);
                    		 $("#sex"+data.data.sex).attr("checked",true);
                    	 }
                     }
                 })
             }
        },{
            el: '.attrPos',
            event: 'click',
            handler: function () {
            	if($(this).prop("checked")){
            		if($(this).val() == '2'){
            			$("#isSecretary1").removeAttr("disabled");
            		}else{
            			$("#isSecretary1").removeAttr("checked").attr("disabled","disabled");
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
