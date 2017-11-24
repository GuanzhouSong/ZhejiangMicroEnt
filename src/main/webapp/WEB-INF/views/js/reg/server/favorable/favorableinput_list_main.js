require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars','jquery.form', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
	
	var initFlag = true;
	var searchParams={};
	
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	initFavType();
        bind();
    }
    
    //初始化良好信息类别
    function initFavType(){ 
  		$("#favType").append("<option value='0'>百强民营企业</option>");
  		$("#favType").append("<option value='1'>驰名商标</option>");
  		$("#favType").append("<option value='2'>知名商号</option>");
  		$("#favType").append("<option value='3'>著名商标</option>");
  		$("#favType").append("<option value='4'>守合同重信用企业</option>");
  		$("#favType").append("<option value='5'>信用示范管理企业</option>");
  		$("#favType").append("<option value='6'>小微企业成长之星</option>"); 
       	$("#favType").multipleSelect({
       		selectAllText: '全部',
    		allSelected: '全部',
    		selectAllDelimiter: '',
    		minimumCountSelected: 20
       	});
       	//全选
        $('#favType').multipleSelect('checkAll'); 
   }

    var table;
    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	initFlag = false;
        table = dataTable.load({
            el: '#user-table',
			showIndex: true,
			scrollX:true,
            ajax: {
                url:window._CONFIG.url+'/favorableinput/list.json',
                data:function(d){
                   d.params = searchParams;
                }
            },
            columns: [
                {data: 'id',width:'55px'},
                {data: null,width:'85px'},
                {data: null,width:'120px'},
                {data: 'entName',width:'120px',cut: {length: 20,mark:'...'},className: 'left'},
                {data: 'favName',width:'120px'},
                {data: 'favType',width:'120px'},
                {data: 'licZone',width:'80px'},
                {data: 'auditState',width:'80px'},
                {data: 'regYear',width:'120px'},
                {data: 'regType',width:'100px'},
                {data: 'regDate',width:'80px'},
                {data: 'regDocNo',width:'80px'},
                {data: 'regDeptCn',width:'100px',cut: {length: 20,mark:'...'},className: 'left'},
                {data: 'setName',width:'120px'},
                {data: 'setTime',width:'100px'},
                {data: 'setDept',width:'100px',cut: {length: 20,mark:'...'},className: 'left'},
                {data: 'auditName',width:'120px'},
                {data: 'auditDate',width:'100px'},
                {data: 'regOrgName',cut: {length: 20,mark:'...'},className: 'left'},
                {data: 'localAdmName',cut: {length: 20,mark:'...'},className: 'left'}
            ],
             columnDefs : [
							{
								targets : 2,
								render : function(data, type, row, meta) {
									if(row.uniSCID !="" && row.uniSCID !=null) {
							    		return row.uniSCID;
							    	}else{
							    		return row.regNO;
							    	}
								}
							},{
								targets : 7,
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
							},{
								targets : 1,
								render : function(data, type, row, meta) {
									if(row.auditState =='0') {
					            		return "<a class='commit edit'>修改</a>&nbsp;<a class='commit delete'>删除</a>";
					            	}else if(row.auditState == '1'){
					            		return "<a class='commit view'>详情</a>";
					            	}else if(row.auditState == '2'){
					            		return "<a class='commit edit'>修改</a>&nbsp;<a class='commit view'>详情</a>";
					            	}else{
					            		return "";
					            	}
								}
							},{
								targets : 5,
								render : function(data, type, row, meta) {
									if(row.favType == '0'){
										return "百强民营企业";
									}else if(row.favType == '1'){
										return "驰名商标";
									}else if(row.favType == '2'){
										return "知名商号";
									}else if(row.favType == '3'){
										return "著名商标";
									}else if(row.favType == '4'){
										return "守合同重信用企业";
									}else if(row.favType == '5'){
										return "信用示范管理企业";
									}else if(row.favType == '6'){
										return "小微企业成长之星";
									}else{
									   return "";
									}
								}
							},{
								targets : 6,
								render : function(data, type, row, meta) {
									if(row.licZone =='0') {
					            		return "国家级";
					            	}else if(row.licZone == '1'){
					            		return "省级";
					            	}else if(row.licZone == '2'){
					            		return "市级";
					            	}else if(row.licZone == '3'){
					            		return "县级";
					            	}else{
					            		return "";
					            	}
								}
							}]
        })
    }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	 var favType = $('#favType').val(); favType.toString()
    	searchParams = $("#taskForm").serializeObject();
    	searchParams.favType = favType.toString();
    	console.log(searchParams);
    	if(initFlag)initDataTable();
        table.ajax.reload();
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
            el: '#addBtn',
            event: 'click',
            handler: function () {
            	window.location.href = window._CONFIG.url+"/favorableinput/addview";
            }
        },{
            el: '.delete',
            event: 'click',
            handler: function () {
            	 var data = table.row($(this).closest('td')).data();
	        	 layer.confirm('确定要删除吗？', {icon: 2, title: '提示'}, function (index) {
	        		 http.httpRequest({
                         url: window._CONFIG.url+'/favorableinput/delete',
                         data:{uid:data.uid},
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
            el: '.edit',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
                layer.dialog({
                    title: '修改',
                    area: ['65%', '72%'],
                    content: window._CONFIG.url+'/favorableinput/addOrEditView?priPID='+data.priPID+'&uid='+data.uid,
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
                	area: ['65%', '90%'],
                    content: window._CONFIG.url +'/favorableaudit/details?uid='+data.uid,
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
            el: '#choseDept',
            event: 'click',
            handler: function () {
                layer.dialog({
                    title: '选择部门',
                    area: ['400px', '600px'],
                    content: window._CONFIG.select_detp_tree_url,
                    callback: function (data) {
                        $("#regDeptCn").val(data.deptName);
                    }
                })
            }
        },{
            el: '#choseDept2',
            event: 'click',
            handler: function () {
                layer.dialog({
                    title: '选择部门',
                    area: ['400px', '600px'],
                    content: window._CONFIG.select_detp_tree_url,
                    callback: function (data) {
                        $("#setDeptCn").val(data.deptName);
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
                      if (!(ext == ".xls" || ext == ".xlsx")) {
                          layer.msg("请选择Excel模板文件!", {icon: 7, time: 3000});
                          return;
                      }
                  }
                  $("#file_import").ajaxSubmit({
                      type: 'post',
                      url: window._CONFIG.url + '/favorableinput/addbatch',
                      data: $("#file_import").serialize(),
                      dataType: 'json',
                      cache: false,
                      success: function (data) {
                    	  console.log(data);
                          if (data.status == 'success') {
                        	  if(data.regNOs == "" || data.regNOs == null){
                        		  layer.msg("导入成功", {time: 1500}, function () {
                                	  table.ajax.reload(); //重新加载列表
                                	  $("#js-file").val("");
                                	  $("#loadFile").hide();
                                  });
                        	  }else{
                        		      layer.alert("注册号/统一信用代码为：</br><span style='color:red'>"+data.regNOs+"</span>&nbsp;的数据导入失败 ！" 
                        		    		  +"<br/>失败原因：1.该注册号/统一信用代码已经存在重复的企业良好信息 " 
                        		    		  +"2.该注册号/统一信用代码不存在，请核对是否正确。如有疑问请联系管理员。");
                                	  table.ajax.reload(); //重新加载列表
                                	  $("#js-file").val("");
                                	  $("#loadFile").hide();
                        	  }
                          }else{
                        	  layer.msg("导入失败", {time: 1000}, function () {});
                          }
                      }
                  });
	           }
	      },{
              el: '#cancel',
              event: 'click',
              handler: function () { 
            	  $("#regOrg").val("");
            	  $("#localAdm").val("");
            	  $("#regDept").val("");
            	  $("#setDept").val("");
            	  $('#favType').multipleSelect('checkAll');
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
