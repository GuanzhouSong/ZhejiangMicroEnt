require(['component/iframeLayer', 'component/dataTable','common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize', 'jquery.form','laydate','jquery.placeholder','jquery.icinfo'], function (layer, dataTable, util, http, handlebars) {
	var initFlag = '1';
    init();
    /**
     * 初始化函数集合
     */
    function init() { 
       //initDataTable();
        bind();
    }


    var searchParams={};//查询参数声明!
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	initFlag = '0';
        var tpl = $('#tpl').html();
        var template = handlebars.compile(tpl);
        var userType= $("#userType").val(); 
        var typeUrl="";
        if(userType=="2"){
        	typeUrl="/syn/server/other/pubohterlicence/listJSON";
        }else{
        	typeUrl="/reg/server/other/pubohterlicence/listJSON";
        }
        
        
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
            //是否加索引值
        	scrollX:true, //支持滚动
            showIndex: true,
            ajax: {
                url:typeUrl,
                data:function(d){
	               		 d.params = searchParams;
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //'className'不要写成class
            columns: [
                {data: null,'defaultContent':'11'},
                {data: null,width:"80px",defaultContent:'id'},
             
                {data: 'licNO'},
                {data: 'licNameCN'},
                {data: 'licValFrom'},
                {data: 'licValTo'},
                {data: 'licAnth'},
                {data: 'licScope',cut:{length:20,mark:'...'}},
                {data: 'licType'},
                {data: 'pubFlag'},
                {data: 'auditState'},
                {data: 'setName'},
                {data: 'setDate'},
                {data: 'auditName'},
                {data: 'entName'},
                {data: 'regNO'},
                {data:'regOrgName'},
                {data:'localAdmName'},
                {data:'sliceNOName'}
              
            ],
            columnDefs: [
                         
{
	targets: 1,
    render: function (data, type, row, meta) {
    	var deptCode=$("#deptCode").val(); 
    	var userType= $("#userType").val();  
    	if(userType=="1"){//警示不判断
    	if (row.auditState == '0') {
    	    return "<a class='commit edit'>修改</a>&nbsp;<a class='commit delete'>删除</a>";
    	}else if(row.auditState == '1'){
    		return "<a class='commit alter'>变更</a>&nbsp;<a class='commit js_view'>详情</a>";
    	}else{
    		return "<a class='commit edit'>修改</a>&nbsp;<a class='commit js_view'>详情</a>";
    	}
    }else{//协同判断部门id
    	 
    	if(deptCode==row.setDeptname){
    		if (row.auditState == '0') {
        	    return "<a class='commit edit'>修改</a>&nbsp;<a class='commit delete'>删除</a>";
        	}else if(row.auditState == '1'){
        		return "<a class='commit alter'>变更</a>&nbsp;<a class='commit js_view'>详情</a>";
        	}else{
        		return "<a class='commit edit'>修改</a>&nbsp;<a class='commit js_view'>详情</a>";
        	}
    		
    	}else{
    		return "<a class='commit js_view'>详情</a>";
    	}
    	
    }
    	
    }
} ,{
	targets: 8,
    render: function (data, type, row, meta) {
    	  if(row.licState=="1"){
    		  return "有效"; 
    	  } else {
    		  return "无效"; 
    	  } 
    	  
    		 
    }
},{
	targets: 9,
    render: function (data, type, row, meta) {
    	  if(row.pubFlag=="1"){
    		  return "已公示"; 
    	  } else{
    		  return "未公示";
    	  } 
    		 
    }
},
{
	targets: 10,
    render: function (data, type, row, meta) {
    	  if(row.auditState=="0"){
    		  return "待审核"; 
    	  } else if(row.auditState=="1"){
    		  return "已审核";
    	  } else if(row.auditState=="2"){
    		  return "审核通不过";
    	  }else{
    		  return "";
    	  }
    		 
    }
}          
            ]
        })
    }

   

    function bind() {
        util.bindEvents([
{
    el: '.delete',
    event: 'click',
    handler: function () {
    	 var data = table.row($(this).closest('td')).data();
    	  var userType= $("#userType").val(); 
          var typeUrl="";
          if(userType=="2"){
        	  typeUrl="/syn/server/other/pubohterlicenceinput/delete";
          }else{
        	  typeUrl="/reg/server/other/pubohterlicenceinput/delete";
          }
    	 
    	 layer.confirm('确定要删除吗？', {icon: 2, title: '提示'}, function (index) {
    		 http.httpRequest({
                 url: typeUrl,
                 data:{"licID":data.licID },
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
},
     
{
    el: '.alter',
    event: 'click',
    handler: function () {
    	var data = table.row($(this).closest('td')).data();
    	var userType= $("#userType").val(); 
        var typeUrl="";
        if(userType=="2"){
        	typeUrl='/syn/server/other/pubohterlicenceinput/change?licID='+data.licID;
        }else{
        	typeUrl='/reg/server/other/pubohterlicenceinput/change?licID='+data.licID
        }
        layer.dialog({
            area: ['78%', '78%'],
            content:typeUrl,
            callback: function (data) {
                //重新加载列表数据
                if (data.reload) {
                    table.ajax.reload();
                }
            }
        })
    }
},


  
{
    el: '.js_view',
    event: 'click',
    handler: function () {
    	var data = table.row($(this).closest('td')).data();
    	var licID=data.licID;
    	var userType= $("#userType").val(); 
        var typeUrl="";
        if(userType=="2"){
        	typeUrl='/syn/server/other/pubohterlicence/show?licID='+licID+"&entType=view";
        }else{
        	typeUrl='/reg/server/other/pubohterlicence/show?licID='+licID+"&entType=view";
        }
    	
   layer.dialog({
            title: '行政许可详情',
            area: ['1000px', '580px'],
            content:typeUrl,
            callback: function (data) {
                //重新加载列表数据
                if (data.reload) { 
                	 
                }
            }
        })

}
},  {
    el: '.edit',
    event: 'click',
    handler: function () {
    	var data = table.row($(this).closest('td')).data();
    	var userType= $("#userType").val(); 
        var typeUrl="";
        if(userType=="2"){
        	typeUrl='/syn/server/other/pubohterlicenceinput/addOrEditView?licID='+data.licID;
        }else{
        	typeUrl='/reg/server/other/pubohterlicenceinput/addOrEditView?licID='+data.licID;
        }
    	
        layer.dialog({
            area: ['62%', '50%'],
            content:typeUrl,
            callback: function (data) {
                //重新加载列表数据
                if (data.reload) {
                    table.ajax.reload();
                }
            }
        })
    }
},



                         {
                el: '#choseorgReg',
                event: 'click',
                handler: function () {
         
           layer.dialog({
                        title: '选择登记机关',
                        area: ['328px', '600px'],
                        content: '/commom/server/regorg/regorgmutiselect?isPermissionCheck='+true,
                        callback: function (data) {
                            //重新加载列表数据
                            if (data) { 
                            	$("#regOrg").val(data.returncode);
                            	$("#regOrgName").val(data.returnname);
                                
                            }
                        }
                    })
            
         }
      }, 
      
      {
          el: '#choseregUnit',
          event: 'click',
          handler: function () {
   
     layer.dialog({
                  title: '选择管辖单位',
                  area: ['328px', '600px'],
                  content: '/commom/server/regunit/regunitmutiselect?isPermissionCheck='+true,
                  callback: function (data) {
                      //重新加载列表数据
                      if (data) { 
                    	 
                      	$("#localAdm").val(data.returncodes);
                      	$("#localAdmName").val(data.returnname);
                        
                      }
                  }
              })
      
   }
},

{
    el: '#choseEntcatg',
    event: 'click',
    handler: function () {

layer.dialog({
            title: '选择企业类型',
            area: ['328px', '600px'],
            content: '/commom/server/entcatg/entcatgmutiselect',
            callback: function (data) {
                //重新加载列表数据
                if (data) { 
                 
                	$("#entType").val(data.returncode);
                	var name=data.returnname;
                	$("#entTypeName").val(name);
                 
                }
            }
        })

}
},

{
    el: '#choseSilceno',
    event: 'click',
    handler: function () {

layer.dialog({
            title: '选择责任区',
            area: ['328px', '600px'],
            content: '/commom/server/sliceno/slicenomutiselect?isPermissionCheck='+true,
            callback: function (data) {
                //重新加载列表数据
                if (data) { 
                 
                	$("#sliceNO").val(data.returncode);
                	$("#sliceNoName").val(data.returnname);
                   table.ajax.reload();
                }
            }
        })

}
},
    {      el: '.js-edit',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.dialog({
                    title: '修改',
                    area: ['728px', '500px'],
                    content: '/reg/server/registinfo/registinfo/toShow?priPID=' + data.priPID+'&UID='+data.uid,
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        }, {
                    el: '#qry',
                    event: 'click',
                    handler: function () {
                         searchParams=$("#qryForm").serializeObject();
                         if(initFlag == '1'){
                     		initDataTable();
                     	}
                         
                         table.ajax.reload();
                    }
                },
 {
                     el: '#cancel',
                     event: 'click',
                     handler: function () {
                     $('#qryForm')[0].reset();
                     $("#regOrg").val("");
                     $("#localAdm").val("");
                     $("#entType").val("");
                     $("#sliceNO").val("");
                 	$("#licState").attr("disabled",false); 
          			$("#pubFlag").attr("disabled",false); 
          			$("#auditState").attr("disabled",false); 
                     }
                 },
 {
                el: '#checkAll',
                event: 'click',
                handler: function () {
                 var flag=$(this).prop("checked");
                 $("input:checkbox[name='_checkbox']").prop("checked", flag);
                 }
              },
              {
            	  el:"#addBtn",
            	  event:'click',
            	  handler:function(){  
            		  var userType= $("#userType").val(); 
            	        var typeUrl="";
            	        if(userType=="2"){
            	        	window.location.href="/syn/server/other/pubohterlicenceinput/addView";
            	        }else{
            	        	window.location.href="/reg/server/other/pubohterlicenceinput/addView";
            	        } 
            	  }
              },{
            	  el:"#importExcel",
            	  event:'click',
            	  handler:function(){ 
            		  $("#loadFile").show();
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
                  el: '.js-import',  // 对外担保 导入Excel
                  event: 'click',
                  handler: function () {
                	  var userType= $("#userType").val(); 
          	        var typeUrl="";
          	        if(userType=="2"){
          	        	typeUrl="/syn/server/other/pubohterlicenceinput/importExcel";
          	        }else{
          	        	typeUrl="/reg/server/other/pubohterlicenceinput/importExcel";
          	        }
                     // layer.confirm('<em style="color: red">导入信息时将同时清空之前已填录的信息，请确定是否继续导入操作!</em>', {btn: ['确定', '取消'], icon: 7, title: '温馨提示'}, function () {
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
                                  } else if (data.status == 'faill') {
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
              }
              
              
                 
                 
])
    }

})
