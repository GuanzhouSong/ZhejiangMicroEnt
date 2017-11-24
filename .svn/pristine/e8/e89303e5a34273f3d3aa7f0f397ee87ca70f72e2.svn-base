require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars','jquery.form', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
	
	var regStateList = [];
	var searchParams={};
	var table;
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	initRegState();
    	getRegStateList();
    	initDataTable();
        bind();
    }
    
  
    
    function initRegState(){
       	$("#regStateM").multipleSelect({
       		selectAllText: '全部',
    		allSelected: '全部',
    		selectAllDelimiter: '',
    		minimumCountSelected: 20
       	});
    }
    
    //获取登记状态
    function getRegStateList() {
    	$('#regStateM option').each(function(){
    		var states = [];
    		states = $(this).val().split(",");
    		for(var i in states){
    			regStateList.push({code: states[i] , text : $(this).text()});
    		};
    	});
    }
    
    function switchRegStateList(val) {
        var flag = "-";
        $.each(regStateList, function(i, n) {
            if (n.code.toUpperCase() == val.toUpperCase()) {
                flag = n.text;
            }
        });
        return flag;
    }

    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	//登记状态
		var regStateM = $("#regStateM").val();
		$("#regState").val(regStateM);
    	searchParams = $("#taskForm").serializeObject();
        table = dataTable.load({
            el: '#list-table',
			showIndex: true,
			scrollX:true,
			"aLengthMenu": [10, 25, 50, 100,1000,2000],
            ajax: {
                url:'/syn/server/sccheck/specialent/specialentlist.json',
                data:function(d){
                   d.params = searchParams;
                }
            },
            columns: [
                {data: '_idx'},
                {data: null},
                {data: 'specialName',cut: {length: 20,mark:'...'},className: 'left'},
                {data: 'markName',cut: {length: 20,mark:'...'},className: 'left'},
                {data: null},
                {data: null},
                {data: 'entName',className: 'left'},
                {data: 'checkDeptName',className: 'left'},
                {data: 'subjectType'},
                {data: 'licName',cut: {length: 20,mark:'...'},className: 'left'},
                {data: 'licNO'},
                {data: 'licApprDate'},
                {data: 'licSaveEndDate'},
                {data: 'licSendDeptName'},
                {data: 'dom',cut: {length: 20,mark:'...'}},
                {data: 'regOrgName',className: 'left'},
                {data: 'localAdmName',className: 'left'},
                {data: null},
                {data: 'creatTime'},
                {data: 'setUserName'}
            ],
            fnDrawCallback:function(nRow){
            	
            },
            columnDefs : [{
								targets : 1,
								render : function(data, type, row, meta) {
									return "<input type='checkbox' name='pubscinfocheckbox' uid='"+data.uid+"' value='"+data.priPID+"' />";
								}
							},{
								targets : 4,
								render : function(data, type, row, meta) {
									if(row.isVlid =='1') {
							    		return "有效";
							    	}else if(row.isVlid =='0'){
							    		return "<span class='light'>无效</span>";
							    	}else{
							    		return "-";
							    	}
								}
							},{
								targets : 5,
								render : function(data, type, row, meta) {
									if(row.subjectType == '1'){
										if(row.uniCode !="" && row.uniCode !=null) {
											return row.uniCode;
										}else{
											return row.regNO;
										}
									}else{
										if(row.uniCode !="" && row.uniCode !=null) {
											return row.uniCode;
										}
									}
								}
							},{
								targets : 8,
								render : function(data, type, row, meta) {
									if(row.subjectType =='1') {
							    		return "企业";
							    	}else if(row.subjectType =='2'){
							    		return "社团";
							    	}else if(row.subjectType =='3'){
							    		return "机构";
							    	}else{
							    		return "-";
							    	}
								}
							},{
								targets : 17,
								render : function(data, type, row, meta) {
									var regState = row.regState;
			            			if("A,B,K,Q,X".indexOf(regState) != -1){
			            				return "存续";
			            			}else if(regState == "C"){
			            				return "撤销";
			            			}else if(regState == "D" || regState == "DA"){
			            				return "吊销";
			            			}else if(regState == "XX" || regState == "DX"){
			            				return "注销";
			            			}else if(regState == "QX"){
			            				return "迁出";
			            			}else{
			            				return "-";
			            			}
								}
							}]
        })
    }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	//登记状态
		var regStateM = $("#regStateM").val();
		$("#regState").val(regStateM);
    	searchParams = $("#taskForm").serializeObject();
    	
    	if(table == null){
    		initDataTable();
    	}else{
    		table.ajax.reload();
    	}
    }); 
    
    $("#moresearch").click(function(){
    	if($(this).attr("status") == '0'){
    		$(".moresearch_oth").show();
    		$(this).val("收起").attr("status",'1');
    	}else{
    		$(".moresearch_oth").hide();
    		$(this).val("更多查询条件").attr("status",'0');
    	}
    })
    
    function bind() {
        util.bindEvents([{
            el: '#checkboxallid',
            event: 'click',
            handler: function () {
            	if($(this).prop("checked")){
					 $("#list-table input").prop("checked",true);
				 }else{
					 $("#list-table input").prop("checked",false);
				 }
            }
        },{
            el: '#add',
            event: 'click',
            handler: function () {
    			var pripIdList = new Array();
    			$("input:checkbox[name='pubscinfocheckbox']:checked").each(function () {
    				var pid = $(this).val();
    				var uid = $(this).attr("uid");
    				pripIdList.push(pid+","+uid);
    			});
    			if (pripIdList.length > 0) {
    				layer.confirm('您确定要导入这批企业吗？', {icon: 2, title: '提示'}, function (index) {
    					var formParam = {
    							taskUid:$("#taskUid").val(),
    							priPIDs: pripIdList
    					};
    					http.httpRequest({
    						url: '/syn/pub/server/sccheck/entback/addBatch',
    						dataType:"json",  
    						serializable: true,
    						data: formParam,
    						type:"post",
    						success: function (data) {
    							layer.msg(data.msg, {time: 1000}, function () {
    								if(data.status == 'success'){
    									layer.close({reload:true});
    								}
    							});
    						}
    					});
    				});
    			}else {
    				layer.msg("请您先<em style='color: red;'>【选中一项】</em>进行操作!", {icon: 7,time: 1000});
    			}
            }
        },{
            el: '#addAll',
            event: 'click',
            handler: function () {
    			layer.confirm('您确定要导入所有企业吗？', {icon: 2, title: '提示'}, function (index) {
    				var regStateM = $("#regStateM").val();
    				$("#regState").val(regStateM);
					http.httpRequest({
						url: '/syn/server/sccheck/specialent/addSpecialAll',
						serializable: true,
						data: $("#taskForm").serializeObject(),
						type:"post",
						success: function (data) {
							layer.msg(data.msg, {time: 1000}, function () {
								if(data.status == 'success'){
									layer.close({reload:true});
								}
							});
						}
					});
				});
            }
        },{
            el: '#choseregUnit',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择管辖单位',
                    area: ['400px', '600px'],
                    content: '/commom/server/regunit/regunitmutiselect?isPermissionCheck=true',
                    callback: function (data) { 
                    	var returncode=data.returncodes;
                      	$("#localAdm").val(returncode);
                      	$("#localAdmName").val(data.returnname); 
                    }
                })
            }
        },{
            el: '#choseorgReg',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择登记机关',
                    area: ['400px', '600px'],
                    content: '/commom/server/regorg/regorgmutiselect?isPermissionCheck=true',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    	}
                    	$("#regOrg").val(returncode);
                    	$("#regOrgName").val(data.returnname);  
                    }
                })
            }
        },{
            el: '#checkDeptNameAdd',
            event: 'click',
            handler: function () {
          	    var dutyDeptCode = $("#dutyDeptCode").val();
                layer.dialog({
                    title: '选择检查部门',
                    area: ['400px', '600px'],
                    content: '/common/system/sysdepart/deptSelectByDuty?treeType=checkbox&dutyDeptCodes='+dutyDeptCode+"&isNoCheck=true",
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
        	  $("#regOrg").val("");
        	  $("#localAdm").val("");
        	  $("#sliceNO").val("");
        	  $("#specialCode").val("");
        	  $("#qzName").val("");
        	  $("#markCode").val("");
        	  $('#leadFlag').multipleSelect('checkAll');
        	  $('#rightFlag').multipleSelect('checkAll');
        	  $("#regState").val("");
          	  $('#regStateM').multipleSelect('setSelects',[$('#regStateM option[title="CUNXU"]').val()]);
          	 $("#checkDeptCode").val("");
             $("#checkDeptName").val("");
           }
        },{
            el: '#close',
            event: 'click',
            handler: function () { 
          	  layer.close();
          }
        }])
    }
})
