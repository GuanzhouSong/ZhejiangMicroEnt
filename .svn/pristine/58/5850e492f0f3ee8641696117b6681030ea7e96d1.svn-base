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
			url : '/sment/smEntAbovescale/smEntAbovescaleList.json',
			data : function(d) {
				d.params =  $("#entSearchForm").serializeObject();
			}
		},
		columns : [
		    {data: '_idx', className: 'center'},
		    {data : null, className: 'center'},
		    {data : 'organizecode', className: 'center'},
		    {data : 'entName', className: 'center'},
		    {data : 'uniCode', className: 'center'},
		    {data : 'formType', className: 'center'},
		    {data : 'formTypeCn', className: 'center'},
		    {data : 'aboveType', className: 'center'},
		    {data : 'year', className: 'center'},
		    {data : 'imBatchNum', className: 'center'},
		    {data : 'isMatch', className: 'center'},
		    {data : 'matchEntName', className: 'center'},
		    {data : 'matchUniCode', className: 'center'},
		    {data : 'matchRegNO', className: 'center'},
		    {data : 'importName', className: 'center'},
		    {data : 'importTime', className: 'center'}
		],
		columnDefs : [
			{
                targets: 1,
                render: function (data, type, row, meta) {
                	return '<a href="javascript:void(0);" class="list-edit">修正</a>';
                }
            },
			{
                targets: 7,
                render: function (data, type, row, meta) {
                	if(data != null){
                		if("1" == data){
                    		return "限上";
                    	}else if("2" == data){
                    		return "规上工业";
                    	}else if("3" == data){
                    		return "规上服务业";
                    	}else{
                        	return data;
                    	}
                	}else{
                		return "";
                	}
                	
                }
            },
			{
                targets: 10,
                render: function (data, type, row, meta) {
                	if("1" == data){
                		return "是";
                	}else if("0" == data){
                		return "否";
                	}else{
                    	return data;
                	}
                }
            }
            ]

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
            el: '#checkAll',
            event: 'click',
            handler: function () {
                var flag = $(this).prop("checked");
                $("input:checkbox[name='_checkbox']").prop("checked", flag);
            }
        },
        {
        	el:'.list-edit',
        	event:'click',
        	handler:function(){
	        	var row = table.row($(this).closest('td')).data();
        				layer.dialog({
        					title: '规上企业--修改',
                            area: ['800px', '350px'],
                            content: '/sment/smEntAbovescale/smEntAbovescaleEdit?uid='+row.uid,
                            callback: function (data) {
           	                   	 if (data.reload) { //close是否有传递此参数
           	                         table.ajax.reload();
           	                     }
               				}
                        });
        	}
        },
        {
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
                    
                	$(".js-import").attr("disabled",true);
                	layer.msg('若导入数据过多，会导致处理时间过长，处理过程中，请勿要关闭浏览器！', {icon: 16, time: 7000, shade: [0.4, '#CCC']});
                    $("#file_import").ajaxSubmit({
                        type: 'post',
                        url: '/sment/smEntAbovescale/excelImport',
                        data: $("#file_import").serialize(),
                        dataType: 'json',
                        cache: false,
                        success: function (data) {
                      	  if (data.state == 'success') {
                          	  if(data.status == "1"){ 
                          		  layer.alert("本次共匹配成功<span style='color:red'>"+data.allImportTatol+"</span>条记录;"+"匹配失败<span style='color:red'>"+data.notMatchCount+"</span>条记录;" 
                      		    		  +"<br/>由于以下原因导致导入失败的有："+data.msg);
                         	     if(table){
                        	    	 table.ajax.reload();
                        	     }else{
                        	    	 initDataTable();
                        	     }
                              	  $("#js-file").val("");
                          	  }else if(data.status == "2" || data.status == "3"){
                          		  layer.alert("本次导入失败！失败原因为："+data.msg);
                         	     if(table){
                        	    	 table.ajax.reload();
                        	     }else{
                        	    	 initDataTable();
                        	     }
                              	  $("#js-file").val("");
                          	  }else{
                          		  layer.alert("导入成功！本次共匹配成功<span style='color:red'>"+data.allImportTatol+"</span>条记录;"+"匹配失败<span style='color:red'>"+data.notMatchCount+"</span>条记录");
                         	     if(table){
                        	    	 table.ajax.reload();
                        	     }else{
                        	    	 initDataTable();
                        	     }
                              	  $("#js-file").val("");
                          	  }
                            }else{
                          	  layer.msg("导入失败", {time: 1000}, function () {});
                            }
                      	$(".js-import").attr("disabled",false);
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
