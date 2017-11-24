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
            el: '#user-table',
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
            	initScSpecialTotal();
            },
            columnDefs : [{
								targets : 1,
								render : function(data, type, row, meta) {
									return "<a class='commit edit'>修改</a>&nbsp;<a class='commit view'>详情</a>";
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
    
    // 初始化个数统计
    function initScSpecialTotal(){
        http.httpRequest({
            url: '/syn/server/sccheck/specialent/searchcount.json',
            serializable: true,
            data: searchParams,
            type: 'post',
            success: function (data) {
                $("#entCount,#markCount,#licCount").html("").text("0");
            	if(data !=null){
            		$("#entCount").text(data[0].count);
            		$("#markCount").text(data[1].count);
            		$("#licCount").text(data[2].count);
            	}
            }
        })
    }
    
    function bind() {
        util.bindEvents([{
            el: '#addBtn',
            event: 'click',
            handler: function () {
                layer.dialog({
                    title: '添加',
                    area: ['80%', '90%'],
                    content: '/syn/server/sccheck/specialent/edit?uid=',
                    callback: function (data) {
                        if (data.reload) {
                        	table.ajax.reload();
                        }
                    }
                })
            }
        },{
            el: '.edit',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
                layer.dialog({
                    title: '修改',
                    area: ['80%', '90%'],
                    content: '/syn/server/sccheck/specialent/edit?uid='+data.uid+'&viewFlag=1',
                    callback: function (data) {
                        if (data.reload) {
                        	table.ajax.reload();
                        }
                    }
                })
             }
        },{
            el: '.view',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
                layer.dialog({
                	title: '查看',
                	area: ['80%', '90%'],
                    content: '/syn/server/sccheck/specialent/edit?uid='+data.uid+'&viewFlag=2',
                    callback: function (data) {
                        if (data.reload) {
                        }
                    }
                })
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
            el: '#choseSpecial',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择专项库',
                    area: ['400px', '600px'],
                    content: '/syn/server/drcheck/specialcheck/scSpecialSelect?isPermissionCheck=true',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!="" && returncode!='undifine'){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    		$("#specialCode").val(returncode);
                        	$("#specialName").val(data.returnname);  
                    	}
                    }
                })
            }
        },{
            el: '#choseMark',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择监管标签',
                    area: ['400px', '600px'],
                    content: '/syn/server/drcheck/specialcheck/markTreeView?isMarkFlag=true',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1);
                    		$("#markCode").val(returncode);
                        	$("#markName").val(data.returnname);  
                    	}
                    }
                })
            }
        },{
            el: '#chosesliceNo',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择责任区',
                    area: ['400px', '600px'],
                    content: '/commom/server/sliceno/slicenomutiselect?isPermissionCheck=true',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    	}
                    	$("#sliceNO").val(returncode);
                    	$("#sliceNOName").val(data.returnname);  
                    }
                })
            }
        },{
            el: '#qzcodetree',
            event: 'click',
            handler: function () { 
            	layer.dialog({
                    title: '选择许可证',
                    area: ['500px', '600px'],
                    content: '/syn/server/drcheck/specialcheck/licenseListCheckboxTreePage',
                    callback: function (data) { 
                    	if(typeof data.reload.code=="undefined"){
                    		$("#qzCode").val("");
                         	$("#qzName").val("");
                    	}else{
                    		 var content = data.reload.content;
                    		 if(content != "" && content!=null){
                    			var nameArry = content.split(',');
                    			var licStr="";
                    			for(var i=0;i<nameArry.length;i++){
                    				var strArry = nameArry[i].split('-');
                    				licStr += strArry[1]+',';
                    			}
                    			$("#qzName").val(licStr.substring(0, licStr.length-1));
                    		 }
                    	} 
                    }
                })
            }
        },{
          el: '.js-import', 
          event: 'click',
          handler: function () {
                  var _file = $("#js-file").val(); 
                  if (!_file) {
                      layer.msg("请上传Excel模板文件!", {icon: 7, time: 3000});
                      return;
                  } else {
                	  //判断是否是Excel文件
                      var ext = _file.toLowerCase().substr(_file.lastIndexOf("."));
                      if (!(ext == ".xls" || ext == ".xlsx" || ext == ".xlsm")) {
                          layer.msg("请选择Excel模板文件!", {icon: 7, time: 3000});
                          return;
                      }
                  }
                  var index;
                  index = layer.msg('导入中，请稍后', {icon: 16, time: -1, shade: [0.4, '#CCC']});
                  $("#file_import").ajaxSubmit({
                      type: 'post',
                      url: '/syn/server/sccheck/specialent/addexcel',
                      data: $("#file_import").serialize(),
                      dataType: 'json',
                      cache: false,
                      success: function (data) {
                          if (data.status == 'success') {
                        	  layer.msg("导入成功", {time: 1500}, function () {
                            	  $("#js-file").val("");
                            	  $("#loadFile").hide();
                                  $("#search").click();
                              });
                          }else{
                        	  layer.alert("导入提示如下：<br/>"+data.message);
                          }
                          layer.close(index);
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
	      	  el:"#importExcel",
	    	  event:'click',
	    	  handler:function(){ 
	    		  $("#loadFile").show();
	    	  }
	      },{
	      	  el:".btnCancel",
	      	  event:'click',
	      	  handler:function(){
	      		  $("#loadFile").hide();
	      	  }
	      }])
    }

})
