require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars','jquery.form', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
    init();
    var table;
    /**	
     * 初始化函数集合
     */
    function init() {
    	//initDataTable();
    	initData();
        bind();
    }
    
    function initData(){
    	initYearList();
    }
    
    function initYearList(){
    	var mydate = new Date();
        var year = mydate.getFullYear();
        for (var i = year-1; i > year-5; i--) {
			$("#year").append('<option value="'+i+'">'+i+'</option>');
		}
    }
    
	function initDataTable() {
		table = dataTable.load({
		el : '#search-table',
		showIndex: true,
		scrollX: true,
		aLengthMenu: [10, 20,30,40,50],
		ajax : {
			type : "post",
			url : '/sment/smBaseinfoTemp/queryPageList.json',
			data : function(d) {
				d.params =  $("#entSearchForm").serializeObject();
			}
		},
		columns : [
		    {data: '_idx', className: 'center'},
		    {data : null, className: 'center'},
		    {data : 'entName', className: 'center'},
		    {data : 'regNO', className: 'center'}
		],
		columnDefs : [
			{
                targets: 1,
                render: function (data, type, row, meta) {
                	return '<a href="javascript:void(0);" class="list-add">加入培育库</a>'+'<a href="javascript:void(0);" class="list-del">删除</a>';
                }
            }]

	  })
	}
	
    
    
   
    function bind() {
        util.bindEvents([
       {
            el: '#search',
            event: 'click',
            handler: function () {
    
            	     if(table){
            	    	 table.ajax.reload();
            	     }else{
            	    	 initDataTable();
            	     }
            }
        },{
        	el:'#cancle',
        	event:'click',
        	handler:function(){
        		$("#regOrg").val("");
            	$("#localAdm").val("");
            	$("#sliceNo").val("");
            	$("#entType").val("");
            	$("#industryCo").val("");
        	}
        },{
            el: '.look',
            event: 'click',
            handler: function () {
            	var priPID = $(this).attr("priPID");
            	if(priPID!=null && priPID != ''){
            		window.open('/syn/panoramasearch/doEnAppSearchDetails/' + priPID,'_blank');
            	}
            }
        },{
            el: '.js-more-query',
            event: 'click',
            handler: function () {
            	if($('.more-show').css("display")=="none"){
            		$('.js-more-query').attr('value','收起');
            		$('.more-show').css("display","block");
            	}else{
            		$('.js-more-query').attr('value','更多查询');
            		$('.more-show').css("display","none");
            	}
            }
        },{
        	el:'#selectIndustry',
        	event:'click',
        	handler:function(){showIndustryTree()}//行业树
        }, {
        	el: '#chooseEntType',
            event: 'click',
            handler: function () { 
            	var categCode=new Array();
                $(":checkbox[name=entCatg]:checked").each(function(k,v){
              	   categCode[k]= this.value;
                });
                layer.dialog({
                    title: '选择企业类型',
                    area: ['400px', '600px'],
                    content: '/commom/server/entcatg/entcatgmutiselectCom?type='+categCode,
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    	}
                    	$("#entType").val(returncode);
                    	$("#entTypeName").val(data.returnname);  
                    }
                })
            }
        },{
        	el:'#selectLocalAdm',
        	event:'click',
        	handler:function(){showLocalAdmTree()}//管辖单位
        }, {
        	el: '#chooseSliceNo',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择片区',
                    area: ['400px', '600px'],
                    content: '/commom/server/sliceno/slicenomutiselect',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    	}
                    	$("#sliceNo").val(returncode);
                    	$("#sliceNoName").val(data.returnname);  
                    }
                })
            }
        }, {
        	el: '#chooseYearMode',
            event: 'click',
            handler: function () { 
            	var categCode=new Array();
                $(":checkbox[name=chooseEntCatg]:checked").each(function(k,v){
              	   categCode[k]= this.value;
                });
                
                layer.dialog({
                    title: '选择年度年报状态',
                    area: ['400px', '600px'],
                    content: '/syn/panoramasearch/yearStatusTree',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    	}
                    	$("#yearMode").val(returncode);
                    	$("#yearModeName").val(data.returnname);  
                    }
                })
            }
        },{
        	el:'#selectRegOrg',
        	event:'click',
        	handler:function(){showRegOrgTree()}//登记机关
        },{
            el: '#checkAll',
            event: 'click',
            handler: function () {
                var flag = $(this).prop("checked");
                $("input:checkbox[name='_checkbox']").prop("checked", flag);
            }
        },{
        	el:'#btn_add',
        	event:'click',
        	handler:function(){
        		var priPIDs = "";
        		var count = 0;
        		$("input:checkbox[name='_checkbox']:checked").each(function (index){
        			priPIDs += (index >0?",":"")+$(this).val();
        			count++;
        		});
        		if(priPIDs){
        			sessionStorage.setItem("priPIDs",priPIDs);
        			if(count >1){
        				layer.dialog({
        					 title: '培育库-批量新增',
                            area: ['100%', '100%'],
                            content: '/sment/entarchives/toEntarchivesBatchAdd',
                            callback: function (data) {
           	                   	 if (data.reload) { //close是否有传递此参数
           	                         table.ajax.reload();
           	                     }
               				}
                        });
        			}else{
        				sessionStorage.setItem("priPID",priPIDs);
        				layer.dialog({
        					title: '培育库-新增',
            				area: ['100%', '100%'],
            				content: '/sment/entarchives/toEntarchivesEdit?isAdd=true',
            				callback: function (data) {
        	                   	 if (data.reload) { //close是否有传递此参数
        	                         table.ajax.reload();
        	                     }
            				}
            			})
        			}
        			
        		}else{
        			layer.msg("至少选择一家企业！",
        		            function() {
        		                layer.close();
        		            });
        		}
        	}
        },{
        	el:'#btn_back',
        	event:'click',
        	handler:function(){
        		window.location = '/reg/server/mainmark/toMainmarkapplyList';
        	}
        },{
        	el:'.list-add',
        	event:'click',
        	handler:function(){
        		var listData = table.row($(this).closest('td')).data();
        		
        		http.httpRequest({
                url: '/sment/smBaseinfoTemp/queryPriPIDByRegNoOrUniCode.json',
                type: 'post',
                data:{regNoOrUniCode:listData.regNO},
                success: function(data) {
    	            	if(data && data.status == "success"){
    	            		var priPID = data.data;
    	            		if(priPID){
    	            			sessionStorage.setItem("priPIDs",priPID);
    	                		sessionStorage.setItem("priPID",priPID);
    	                		layer.dialog({
    	        					title: '培育库-新增',
    	            				area: ['100%', '100%'],
    	            				content: '/sment/entarchives/toEntarchivesEdit?isAdd=true',
    	            				callback: function (data) {
    	        	                   	 if (data.reload) { //close是否有传递此参数
    	        	                   		 http.httpRequest({
    	        	  	    	                 url: '/sment/smBaseinfoTemp/deleteByid.json',
    	        	  	    	                 data: {id:listData.id},
    	        	  	    	                 type: 'post',
    	        	  	    	                 success: function (data) {
    	        	  	    	                     layer.msg("删除成功！", {time: 1000}, function () {
    	        	  	    	                     	if(data.status=='success'){
    	        	  	    	                     		table.ajax.reload();
    	        	  	    	                     	}
    	        	  	    	                     });
    	        	  	    	                 }
    	        	  	    	             });
    	        	                     }
    	            				}
    	            			})
    	            		}else{
    	            			 layer.alert("当前企业不属于小微企业或者已加入培育库");
    	            		}
    	            	}else{
    	            		 layer.alert(data.msg);
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
                        if (!(ext == ".xlsx")) {
                            layer.msg("请选择Excel模板文件!", {icon: 7, time: 3000});
                            return;
                        }
                    }
                    $("#file_import").ajaxSubmit({
                        type: 'post',
                        url: '/sment/smBaseinfoTemp/excelImport',
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
                          	  }else{
                          		  layer.alert("导入成功！本次共成功导入<span style='color:red'>"+data.allImportTatol+"</span>条记录;");
                          		     /* layer.alert("注册号/统一信用代码为：</br><span style='color:red'>"+data.regNOs+"</span>&nbsp;的数据导入失败 ！" 
                          		    		  +"<br/>失败原因：1.该注册号/统一信用代码已经存在重复的企业良好信息 " 
                          		    		  +"2.该注册号/统一信用代码不存在，请核对是否正确。如有疑问请联系管理员。");*/
                                  	  table.ajax.reload(); //重新加载列表
                                  	  $("#js-file").val("");
                          	  }
                            }else{
                          	  layer.msg("导入失败", {time: 1000}, function () {});
                            }
                        }
                    });
  	           }
        },{
  	        	 el:'.list-del',
  	        	 event:'click',
  	        	 handler:function(){
  	        		var listData = table.row($(this).closest('td')).data();
  	        		
  	        		layer.confirm('确定要删除选中记录吗?', {icon: 3, title: '温馨提示'}, function (index) {
  	    	             layer.close(index);
  	    	             http.httpRequest({
  	    	                 url: '/sment/smBaseinfoTemp/deleteByid.json',
  	    	                 data: {id:listData.id},
  	    	                 type: 'post',
  	    	                 success: function (data) {
  	    	                     layer.msg("删除成功！", {time: 1000}, function () {
  	    	                     	if(data.status=='success'){
  	    	                     		table.ajax.reload();
  	    	                     	}
  	    	                     });
  	    	                 }
  	    	             });
  	    	      	  }); 
  	        		
  	        	
  	        	}
  	        }
        ]);
    }
    
    
})
