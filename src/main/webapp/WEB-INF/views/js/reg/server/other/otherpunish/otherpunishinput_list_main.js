require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars','jquery.form', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {
	
	var initFlag = true;
	var searchParams={};
	
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
    }

    //处罚类型
    var punishTypeList=[
	{id: "1", text: "警告"},
	{id: "2", text: "罚款"},
	{id: "3", text: "没收违法所得和非法财物"},
	{id: "4", text: "责令停产停业"},
	{id: "5", text: "暂扣许可证"},
	{id: "6", text: "暂扣执照(登记证)"},
	{id: "7", text: "吊销许可证"},
	{id: "8", text: "吊销执照(登记证)"},
	{id: "9", text: "法律、法规规定的其他行政处罚方式"}
	];
     
    var table;
    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	  initFlag = false;
    	  var userType= $("#userType").val(); 
          var typeUrl="";
          if(userType=="2"){
        	  typeUrl="/syn/server/pubotherpunish/list.json";
          }else{
        	  typeUrl="/pub/server/pubotherpunish/list.json";
          }
    	
        table = dataTable.load({
            el: '#user-table',
			showIndex: true,
			scrollX:true, //支持滚动
            showIndex: true,
            ajax: {
                url:typeUrl,
                data:function(d){
                   d.params = searchParams;
                }
            },
            columns: [
                {data: 'id',width:'55px'},
                {data: null,width:'85px'},
                {data: 'penDecNo',width:'120px'},
                {data: 'illegActType',width:'120px'},
                {data: 'penType',width:'120px'},
                {data: 'penAm',width:'80px'},
                {data: 'forfAm',width:'80px'},
                {data: 'judAuth',width:'120px'},
                {data: 'penDecIssDate',width:'100px'},
                {data: 'punIsAlter',width:'80px'},
                {data: 'pubFlag',width:'80px'},
                {data: 'auditState',width:'80px'},
                {data: 'setName',width:'120px'},
                {data: 'setDate',width:'100px'},
                {data: 'auditName',width:'120px'},
                {data: 'auditDate',width:'100px'},
                {data: 'regNO',width:'120px'},
                {data: 'entName',width:'120px'},
                {data: 'regOrgDesc',width:'120px'},
                {data: 'localAdmName',width:'120px'},
                {data: 'sliceNOName',width:'120px'}
            ],
             columnDefs : [
							{
								targets : 11,
								render : function(data, type, row, meta) {
									if(row.auditState =='0') {
					            		return "待审核";
					            	}else if(row.auditState == '1'){
					            		return "审核通过";
					            	}else if(row.auditState == '2'){
					            		return "审核不通过";
					            	}else{
					            		return "";
					            	}
								}
							}, {
								targets: 1,
			                    render: function (data, type, row, meta) {
			                    	var deptCode=$("#deptCode").val(); 
			                    	var userType= $("#userType").val();  
			                    	if(userType=="1"){//警示不判断
			                    		if (row.auditState == '0') {
			                    	    return "<a class='commit edit'>修改</a>&nbsp;<a class='commit delete'>删除</a>";
			                    	}else if(row.auditState == '1'){
			                    		return "<a class='commit alter'>变更</a>&nbsp;<a class='commit view'>详情</a>";
			                    	}else{
			                    		return "<a class='commit edit'>修改</a>&nbsp;<a class='commit view'>详情</a>";
			                    	}
			                       }else{//协同判断
			                    		if(deptCode==row.setDeptname){
			                    			if (row.auditState == '0') {
					                    	    return "<a class='commit edit'>修改</a>&nbsp;<a class='commit delete'>删除</a>";
					                    	}else if(row.auditState == '1'){
					                    		return "<a class='commit alter'>变更</a>&nbsp;<a class='commit view'>详情</a>";
					                    	}else{
					                    		return "<a class='commit edit'>修改</a>&nbsp;<a class='commit view'>详情</a>";
					                    	}
			                    		}else{ 
			                    			return "<a class='commit view'>详情</a>";
			                    		}
			                        }
			                    }
			                },{
								targets: 10,
			                    render: function (data, type, row, meta) {
			                    	if(row.pubFlag =='1') {
			                    		return "已公示";
			                    	}else if(row.pubFlag == '0'){
			                    		return "未公示";
			                    	}else{
			                    		return "";
			                    	}
			                    }
			                },{
								targets: 3,
			                    render: function (data, type, row, meta) {
			                    	 if(row.illegActType != null && row.illegActType != ""){
			                    		 var data = row.illegActType;
				                    	 if(data && (data.length > 20)){
			                                    $(table.cell( meta.row, meta.col ).node()).attr('title',data);
			                                    return (data.substr( 0, 20 )+'....');
			                              }
				                    	 return row.illegActType;
			                    	 }else{
			                    		 return "";
			                    	 }
			                    }
			                },{
								targets: 4,
			                    render: function (data, type, row, meta) {
				                     if(row.penType!=null && row.penType != ""){//增加判断
				                    	 var data = switchPunishInfoForm(row.penType);
				                    	 if(data && (data.length > 20)){
			                                    $(table.cell( meta.row, meta.col ).node()).attr('title',data);
			                                    return (data.substr( 0, 20 )+'....');
			                                }
				                    	return switchPunishInfoForm(row.penType);
				                    }else{
				                    	return " ";
				                    }
			                    }
			                }]
        })
    }
    
    //处罚类型数据处理
    function switchPunishInfoForm(val){
    	if(val != ""){
    		var punishForm = [];
    		var tempVal = "";
    		punishForm = val.split(",");
    		for(var i=0;i<=punishForm.length;i++){
    			for(var j in punishTypeList){
    	    		if (punishTypeList[j].id == punishForm[i]) {
    	    			tempVal += punishTypeList[j].text +"，";
    	    			}
    				};
    			}
    		val = tempVal.substring(0,tempVal.length-1);
    	}
       return val;
    }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#taskForm").serializeObject();
    	if(initFlag)initDataTable();
        table.ajax.reload();
    }); 

    function bind() {
        util.bindEvents([{
            el: '.delete',
            event: 'click',
            handler: function () {
            	 var data = table.row($(this).closest('td')).data();
            	 var userType= $("#userType").val(); 
                 var typeUrl="";
                 if(userType=="2"){
                	 typeUrl="/syn";
                 }else{
                	 typeUrl="/pub";
                 }
	        	 layer.confirm('确定要删除吗？', {icon: 2, title: '提示'}, function (index) {
	        		 http.httpRequest({
                         url: typeUrl+'/server/pubotherpunishinput/delete',
                         data:{priPID:data.priPID,caseNO:data.caseNO},
                         serializable: false,
                         type: 'get',
                         success: function (data) {
                             if(data.status=='success'){
                            	 layer.msg(data.msg, {time: 1000}, function () {
                            		 table.ajax.reload(); 
                            	 })
                             }
                         }
                     });
	        		 layer.close(index);
	             });
             }
        },{
            el: '.view',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
            	var userType= $("#userType").val(); 
                var typeUrl="";
                if(userType=="2"){
                	 typeUrl="/syn";
                }else{
                	 typeUrl="/pub";
                }
                layer.dialog({
                    area: ['68%', '85%'],
                    content: typeUrl+'/server/pubotherpunish/doEnt?pripid='+data.priPID+'&caseNO='+data.caseNO+'&entType='+'view',
                    callback: function (data) {
                        if (data.reload) {
                        }
                    }
                })
            }
        },{
            el: '.alter',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
            	 var userType= $("#userType").val(); 
                 var typeUrl="";
                 if(userType=="2"){
                	 typeUrl="/syn";
                 }else{
                	 typeUrl="/pub";
                 }
                layer.dialog({
                    area: ['68%', '68%'],
                    content: typeUrl+'/server/pubotherpunishinput/alter?pripid='+data.priPID+'&caseNO='+data.caseNO,
                    callback: function (data) {
                        //重新加载列表数据
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
            	var userType= $("#userType").val(); 
                var typeUrl="";
                if(userType=="2"){
               	 typeUrl="/syn";
                }else{
               	 typeUrl="/pub";
                }
                layer.dialog({
                    area: ['70%', '60%'],
                    content: typeUrl+'/server/pubotherpunishinput/addOrEditView?pripid='+data.priPID+'&caseNO='+data.caseNO,
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
                            table.ajax.reload();
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
            el: '#choseEntType',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择企业类型',
                    area: ['400px', '600px'],
                    content: '/commom/server/entcatg/entcatgmutiselect',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    	}
                    	$("#entTypeCode").val(returncode);
                    	$("#entTypeName").val(data.returnname);  
                    }
                })
            }
        },{
            el: '#chosepenType',
            event: 'click',
            handler: function () { 
            	var userType= $("#userType").val(); 
                var typeUrl="";
                if(userType=="2"){
               	 typeUrl="/syn";
                }else{
               	 typeUrl="/pub";
                }
                layer.dialog({
                    title: '选择处罚类型',
                    area: ['400px', '600px'],
                    content: typeUrl+'/server/pubotherpunishinput/viewPenType',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    	}
                    	$("#penType").val(returncode);
                    	$("#penTypeName").val(data.returnname);  
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
            	$("#entTypeCode").val("");
            	$("#penType").val("");
            }
        },{
            el: '#addBtn',
            event: 'click',
            handler: function () {
            	var userType= $("#userType").val(); 
                var typeUrl="";
                if(userType=="2"){
               	 typeUrl="/syn";
                }else{
               	 typeUrl="/pub";
                }
            	window.location.href=typeUrl+"/server/pubotherpunishinput/addView";
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
        },{
          el: '.js-import',  // 对外担保 导入Excel
          event: 'click',
          handler: function () {
                  var _file = $("#js-file").val(); 
                  if (!_file) {
                      layer.msg("请上传Excel模板文件!", {icon: 7, time: 3000});
                      return;
                  } else {
                      var ext = _file.toLowerCase().substr(_file.lastIndexOf(".")); //获取文件后缀
                      if (!(ext == ".xls" || ext == ".xlsx")) {   //判断是否是Excel文件
                          layer.msg("请选择Excel模板文件!", {icon: 7, time: 3000});
                          return;
                      }
                  }
                  var userType= $("#userType").val(); 
        	        var typeUrl="";
        	        if(userType=="2"){
        	        	typeUrl="/syn/server/pubotherpunishinput/importExcel";
        	        }else{
        	        	typeUrl="/pub/server/pubotherpunishinput/importExcel";
        	        }
                  
                  $("#file_import").ajaxSubmit({
                      type: 'post',
                      url: typeUrl,
                      data: $("#file_import").serialize(),
                      dataType: 'json',  //不填写默认是 字符串格式
                      cache: false,
                      success: function (data) {
                    	 
                          if (data.status == 'success') {
                        	
                        	  var msg="导入成功";
                        	  if(data.regNO!=null&&data.regNO!=""){
                        		  msg="部分导入成功,注册号为"+data.regNO+"的数据导入失败";
                        	  }
                              layer.msg(msg, {time: 1000}, function () {
                            	  table.ajax.reload(); //重新加载列表
                            	  $("#js-file").val("");
                            	  $("#loadFile").hide();
                              });
                          }
                          if (data.status == 'faill') {
                        	  var msg=data.msg;
                        	  if(data.regNO!=null&&data.regNO!=""){
                        		  msg="注册号为"+data.regNO+"的数据导入失败";
                        	  }
                              layer.msg(msg, {time: 3000});
                          }
                      },
                      error: function (data) {
                      }
                  });
	           }
	     }])
    }

})
