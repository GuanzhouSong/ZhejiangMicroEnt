require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars','jquery.form', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
	
	var initFlag = true;
	var searchParams={};
	var table;
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	
        bind();
        initDataTable() ;
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
                url:window._CONFIG.url+'/creditprovelist/selectCreditProveManListJSON.json',
                data:function(d){
                	 d.params = searchParams;
                }
            },
            columns: [
                {data: null,'defaultContent':'11'},
				{data: null,width:"100px"},
				{data: 'name',width:"450px"}, 
				{data: 'cerNO',width:"450px",cut: {length: 20,mark:'...'}},
				{data: 'uid',width:"150px",cut: {length: 20,mark:'...'}}
            ],
             columnDefs : [
							{
								targets : 1,
								render : function(data, type, row, meta) { 
									    
									    return "<input value='" + row.uid + "' cerNO="+row.cerNO+"  id="+row.uid+"  name = 'checkboxlist' class='chb checkbox' type='checkbox' />";
								 }
							},{
								targets : 4,
								render : function(data, type, row, meta) {
									if(data!=null&&data!="") {
					            		return "<a class='commit delete'>删除</a>";
					            	}else{
					            		return "";
					            	}
								}
							}
							]
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
            el: '#addBtn',
            event: 'click',
            handler: function () {
            	layer.dialog({
                    title: '新增自然人名单',
                    area: ['50%', '40%'],
                    content: window._CONFIG.url+"/creditprovelist/creditprovelistPage?proveType=2",
                    callback: function (data) { 
                    	
                   	 if(typeof data.status!="undefined"){
                   		 
                   		 if(data.status=="success"){ 
                       		 layer.msg("新增成功", {time: 2000}, function () {
                       			        table.ajax.reload(); 
                                 });
                       	 }else{
                       		 layer.msg(data.msg, {ltype: 0,time:2000});
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
            	var cerNOs="";
                $(":checkbox[name=checkboxlist]:checked").each(function(k,v){
               	ids[k]=this.value; 
               	cerNOs+=$("#"+ids[k]).attr("cerNO")+",";
                });
                if(ids.length==0){
               	 layer.msg("请选择自然人名单再操作", {ltype: 0,time:2000});
               	 return false;
                } 
                layer.dialog({
                    title: '信用查证比对',
                    area: ['100%', '100%'],
                    content: window._CONFIG.url+'/creditprovelist/creditProveManComparePage?cerNOs='+cerNOs+"&uids="+ids.join(","),
                    callback: function (data) { 
                    	 
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
                      url: window._CONFIG.url + '/creditprovelist/addManbatch',
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
            	  $('#regState').multipleSelect('setSelects',['K,A,B,X,DA']);
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
