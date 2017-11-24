require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','jquery.form','laydate'], function (layer, dataTable, util, http,handlebars) {
    var initFlag = true;
    var searchParams={};
    
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
    }


    var table;
    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	initFlag = false;
    	var userType= $("#userType").val(); 
        var typeUrl="";
        if(userType=="2"){
            typeUrl="/syn/other/pubjusticeinfo/list.json";
        }else{
        	typeUrl="/reg/other/pubjusticeinfo/list.json";
        }
        table = dataTable.load({
            el: '#justiceInfo_table',
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
                {data: 'uniCode',width:'130px'},
                {data: 'regNO',width:'120px'},
                {data: 'entName',width:'120px'},
                {data: 'justiceType',width:'100px'},
                {data: 'executeItem',width:'120px'},
                {data: 'inv',width:'100px'},
                {data: 'froAm',width:'100px'},
                {data: 'executionCourt',width:'100px'},
                {data: 'auditState',width:'100px'},
                {data: 'setName',width:'100px'},
                {data: 'setDate',width:'100px'},
                {data: 'auditName',width:'80px'},
                {data: 'auditDate',width:'100px'},
                {data: 'regOrgName',width:'120px'},
                {data: 'localAdmName',width:'120px'},
                {data: 'sliceNOName',width:'120px'}
            ],
             columnDefs : [{
								targets : 2,
								render : function(data, type, row, meta) {
									if(row.uniCode =='' || row.uniCode == null){
										return '-'
									}else{
										return row.uniCode;
									}
								}
							},{
								targets : 10,
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
			                      
			                    	if(userType=="1"){
			                    		//警示不判断
				                    	if (row.auditState == '0') {
				                    	    return "<a class='commit edit'>修改</a>&nbsp;<a class='commit delete'>删除</a>";
				                    	}else if(row.auditState == '1'){
				                    		return "<a class='commit view'>详情</a>";
				                    	}else{
				                    		return "<a class='commit edit'>修改</a>&nbsp;<a class='commit view'>详情</a>";
				                    	}
			                       }else{
			                    	   //协同判断
			                    	   if(deptCode==row.deptCode){ 
			                    		   if (row.auditState == '0') {
					                    	    return "<a class='commit edit'>修改</a>&nbsp;<a class='commit delete'>删除</a>";
					                    	}else if(row.auditState == '1'){
					                    		return "<a class='commit view'>详情</a>";
					                    	}else{
					                    		return "<a class='commit edit'>修改</a>&nbsp;<a class='commit view'>详情</a>";
					                    	} 
			                    	   }else{
			                    			return "<a class='commit view'>详情</a>";   
			                    	   }
			                       }
			                    }
			                },{
								targets : 5,
								render : function(data, type, row, meta) {
									if(row.justiceType == '1'){
		                            	return "股权冻结信息";
		                            }else if(row.justiceType == '2'){
		                            	return "股东强制变更信息";
		                            }else{
		                            	return "-";
		                            }
								}
							},{
								targets : 6,
								render : function(data, type, row, meta) {
									if(row.executeItem == '1'){
		                            	return "公示冻结股权、其他投资权益";
		                            }else if(row.executeItem == '2'){
		                            	return "续行冻结股权、其他投资权益";
		                            }else if(row.executeItem == '3'){
		                            	return "解除冻结股权、其他投资权益";
		                            }else if(row.executeItem == '4'){
		                            	return "强制转让被执行人股权，办理有限责任公司股东变更登记";
		                            }else{
		                            	return "";
		                            }
								}
							},{
								targets : 8,
								render : function(data, type, row, meta) {
									if(row.froAm=="null" || row.froAm == null){
										return "";
									}else{
										return row.froAm+'('+row.froAuth +')';
									}
								}
							}]
        })
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
                	  typeUrl="/syn/other/pubjusticeinfo/delete";
                  }else{
                	  typeUrl="/reg/other/pubjusticeinfo/delete";
                  }
            	 
	        	 layer.confirm('确定要删除吗？', {icon: 2, title: '提示'}, function (index) {
	        		 http.httpRequest({
                         url:typeUrl,
                         data:{priPID:data.priPID,UID:data.uid},
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
                	  typeUrl="/reg";
                  }
                layer.dialog({
                    area: ['68%', '100%'],
                    content: typeUrl+'/other/pubjusticeinfo/detailsView?pripid='+data.priPID+'&UID='+data.uid,
                    callback: function (data) {
                        if (data.reload) {
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
                	  typeUrl="/reg";
                  }
                layer.dialog({
                    area: ['60%', '95%'],
                    content: typeUrl+'/other/pubjusticeinfo/addOrEditView?pripid='+data.priPID+'&UID='+data.uid,
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        },{
            el: '#addBtn',
            event: 'click',
            handler: function () {
            	 var userType= $("#userType").val(); 
                 var typeUrl="";
                 if(userType=="2"){
                 window.location.href="/syn/other/pubjusticeinfo/addList"; 
                 }else{ 
            	 window.location.href="/reg/other/pubjusticeinfo/addList";
                 }
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
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	$("#regOrg").val("");
            	$("#localAdm").val("");
            	$("#sliceNO").val("");
            }
        },
        {
      	  el:".btnCancel",
      	  event:'click',
      	  handler:function(){
      		  $("#loadFile").hide();
      	  }
        },
        {
      	  el:"#importExcel",
      	  event:'click',
      	  handler:function(){ 
      		  $("#loadFile").show();
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
        	        	typeUrl="/syn/other/pubjusticeinfo/importExcel";
        	        }else{
        	        	typeUrl="/reg/other/pubjusticeinfo/importExcel";
        	        }
                    
                    $("#file_import").ajaxSubmit({
                        type: 'post',
                        url:typeUrl,
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
