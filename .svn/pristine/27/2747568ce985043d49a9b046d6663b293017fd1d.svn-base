require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars','jquery.form', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
	var regStateList = [];
	var initFlag = true;
	var searchParams={};
	var table;
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	initRegState();
        bind();
        initDataTable() ;
        getRegStateList();
    }
    
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
                url:window._CONFIG.url+'/creditprovelist/selectCreditProveEntListJSON.json',
                data:function(d){
                	var regState = $('#regState').val(); 
                	d.params = $.extend({}, searchParams, {"regState":regState==null?"":regState.toString()
                          });
                }
            },
            columns: [
                {data: null,'defaultContent':'11'},
				{data: null,width:"100px"},
				{data: 'uniSCID',width:"150px"}, 
				{data: 'entName',width:"150px",cut: {length: 20,mark:'...'}},
				{data: 'leRep',width:"150px",cut: {length: 20,mark:'...'}},
				{data: 'regOrgName',width:"200px",cut: {length: 20,mark:'...'}},
				{data: 'localAdmName',width:"200px",cut: {length: 20,mark:'...'}},
				{data: 'regState',width:"150px",cut: {length: 20,mark:'...'}},
				{data: 'uid',width:"150px",cut: {length: 20,mark:'...'}}
            ],
             columnDefs : [
							{
								targets : 1,
								render : function(data, type, row, meta) { 
									    
									    return "<input value='" + row.uid + "' pripid="+row.priPID+"  id="+row.uid+"  name = 'checkboxlist' class='chb checkbox' type='checkbox' />";
								 }
							},
							{
								targets : 2,
								render : function(data, type, row, meta) {
									
									if(row.uniSCID !="" && row.uniSCID !=null) {
							    		return row.uniSCID;
							    	}else{
							    		return row.regNO;
							    	}
								}
							},
							{
								targets: 7,
							    render: function (data, type, row, meta) { 
							    	return switchRegStateList(row.regState);
							    }
							},{
								targets : 8,
								render : function(data, type, row, meta) {
									if(data!=null&&data!="") {
					            		return "<a class='commit delete'>删除</a>";
					            	}else{
					            		return "";
					            	}
								}
							}]
        })
    }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){ 
    	var uniCode_regNO=$.trim($("#uniCode_regNO").val()); 
    	var entName=$.trim($("#entName").val()); 
        //查证范围
   	    var ids=$(":checkbox[name=searchType]:checked");
	   	if(ids.length>0){
	   		 if((uniCode_regNO==null||uniCode_regNO=="")&&(entName==null||entName=="")){
	   			 layer.msg("请输入完整的统一信用代码/注册号或名称/字号", {ltype: 0,time:2000});
	          	 return false;
	   		 }
   		 	//查询结果显示区域
        	var ivalStr="";
        	$(ids).each(function(k,ival){ 
            	ivalStr+=this.value+",";
            });
        	$("#searchTypeStr").val(ivalStr);
	   	}else{
   	    	$("#searchTypeStr").val(null);
   	    }
    	searchParams = $("#taskForm").serializeObject();
    	if(initFlag)initDataTable();
        table.ajax.reload();
    }); 
    
    
    function initRegState(){ 
       	$("#regState").multipleSelect({
       		selectAllText: '全部',
    		allSelected: '全部',
    		selectAllDelimiter: '',
    		minimumCountSelected: 20
       	}); 
        
   }
    
    //获取登记状态
    function getRegStateList() {
    	$('#regState option').each(function(){
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
    
   

    function bind() {
        util.bindEvents([{
            el: '#addBtn',
            event: 'click',
            handler: function () {
            	layer.dialog({
                    title: '新增企业名单',
                    area: ['50%', '40%'],
                    content: window._CONFIG.url+"/creditprovelist/creditprovelistPage?proveType=1",
                    callback: function (data) { 
                    	
                   	 if(typeof data.status!="undefined"){
                   		 if(data.status=="success"){ 
                       		 layer.msg("新增成功", {time: 2000}, function () {
                       			        table.ajax.reload(); 
                                 });
                       	 }else{
                       		 layer.msg(data.msg, {ltype: 0,time:3000});
                       	 } 
                   	 }
                    }
                })
            }
        },{
            el: '#entRebackBtn',
            event: 'click',
            handler: function () {
            	window.location.href = window._CONFIG.url+"/creditproveinfo/creditproveinfoListPage";
            }
        },{
            el: '.delete',
            event: 'click',
            handler: function () {
            	 var data = table.row($(this).closest('td')).data();
	        	 layer.confirm('确定要删除吗？', {icon: 2, title: '提示'}, function (index) {
	        		 http.httpRequest({
                         url: window._CONFIG.url+'/creditprovelist/delete',
                         data:{uid:data.uid},
                         serializable: false,
                         type: 'get',
                         success: function (data) {
                             if(data.status=='success'){
                            	 layer.msg(data.msg, {time: 1000}, function () {
                            		 table.ajax.reload(); 
                            	 })
                             }else{
                            	 layer.msg("删除失败", {ltype: 0,time:2000});
                             }
                         }
                     }); 
	             });
             }
        },{
        	  el: '#checkAll',  //全选
              event: 'click',
              handler: function () {
              	var allChecked= $("#checkAll").prop("checked");   
              	$(".chb").prop("checked", allChecked);
              }
        },{
            el: '#deleteBtn',
            event: 'click',
            handler: function () {
            	 var ids=new Array();
                 $(":checkbox[name=checkboxlist]:checked").each(function(k,v){
                	ids[k]=this.value; 
                 });
                 if(ids.length==0){
                	 layer.msg("请选择要删除的企业名单", {ltype: 0,time:2000});
                	 return false;
                 }
                 layer.confirm('确定要删除选中的'+ids.length+'条记录吗？', {icon: 2, title: '提示'}, function (index) { 
	        		  http.httpRequest({
		                    type: 'post',
		                    url: window._CONFIG.url+'/creditprovelist/delete',
		                    data: {uid: ids.join(",")},
		                    success: function (data) {
		                        if (data.status == 'success') {  
		                                layer.msg("删除成功", {time: 1000}, function () {
		                                	table.ajax.reload();
		                                }); 
		                        }else{
		                        	layer.msg("删除失败", {ltype: 0,time:2000});
		                        } 
		                    }
		                });
	             });
            }
        },{
            el: '#comparBtn',
            event: 'click',
            handler: function () { 
            	
            	var ids=new Array();
            	var pripids="";
                $(":checkbox[name=checkboxlist]:checked").each(function(k,v){
               	ids[k]=this.value; 
               	pripids+=$("#"+ids[k]).attr("pripid")+",";
                });
                if(ids.length==0){
               	 layer.msg("请选择企业名单再操作", {ltype: 0,time:2000});
               	 return false;
                } 
                layer.dialog({
                    title: '信用查证比对',
                    area: ['100%', '100%'],
                    content: window._CONFIG.url+'/creditprovelist/creditProveEntComparePage?pripids='+pripids,
                    callback: function (data) { 
                    	 
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
                      url: window._CONFIG.url + '/creditprovelist/addbatch',
                      data: $("#file_import").serialize(),
                      dataType: 'json',
                      cache: false,
                      success: function (data) {
                    	  if (data.state == 'success') {
                        	  if(data.status == "1"){ 
                        		  layer.alert("本次共成功导入<span style='color:red'>"+data.allImportTatol+"</span>条记录;" 
                    		    		  +"<br/>由于以下原因导致导入失败的有："+data.msg+" ");
                        		/*  layer.msg("导入成功", {time: 1500}, function () {
                                	  table.ajax.reload(); //重新加载列表
                                	  $("#js-file").val("");
                                	  $("#loadFile").hide();
                                  });*/
                        		  table.ajax.reload(); //重新加载列表
                            	  $("#js-file").val("");
                            	  $("#loadFile").hide();
                        	  }else{
                        		  layer.alert("导入成功！本次共成功导入<span style='color:red'>"+data.allImportTatol+"</span>条记录;");
                        		     /* layer.alert("注册号/统一信用代码为：</br><span style='color:red'>"+data.regNOs+"</span>&nbsp;的数据导入失败 ！" 
                        		    		  +"<br/>失败原因：1.该注册号/统一信用代码已经存在重复的企业良好信息 " 
                        		    		  +"2.该注册号/统一信用代码不存在，请核对是否正确。如有疑问请联系管理员。");*/
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
            	  $('#regState').multipleSelect('setSelects',[$('#regState option[title="CUNXU"]').val()]);
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
