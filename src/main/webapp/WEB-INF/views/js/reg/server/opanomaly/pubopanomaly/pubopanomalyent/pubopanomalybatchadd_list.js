require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {

    var searchParams={};//查询参数声明!
    var table;
    var clickFlag = false;
    var searchFlag = 0 ;
    var batchType = 1;
    var count = 0;
    var formparams = '';
    
	function timeOut(){
    	$("#js-download").prop('disabled',false);
    }
	
    init(); 
//    laydate.skin('molv');//初始化皮肤 (墨绿)
    $(".laydate-icon").click(function(){laydate({istime: true, format: 'YYYY-MM-DD'})});//给所有日期选项添加函数

    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
      }

    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	batchType = $("#batchEntType").val();
    	searchFlag = 1;
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#addmove_table',
            aLengthMenu: [10,100,500,1000,2000],
			showIndex: true,
			scrollX:true, //支持滚动
            ajax: {
                url:'/reg/server/opanomaly/pubopanomaly/selectBatchInAddListJson.json',
                data:function(d){
                	    searchParams = $("#taskForm").serializeObject();
                	    formparams = $("#taskForm").serialize();
                		d.params = searchParams;               		
                }
            },
            columns: [
                  	{data: 'uid',defaultContent:'id',width:'24px', className: 'center'}, 
                  	{data: 'priPID',defaultContent:'priPID', width: '100px', className: 'center'},
    				{data: 'year'},
    				{data: 'regNO'},
    				{data: 'entName',cut: {length: 20,mark:'...'}},
    				{data: 'batchEntType'},
    				{data: 'estDate'},
    				{data: 'isIndivid'},
    				{data: 'individDate'},
    				{data: 'regOrgName',cut: {length: 20,mark:'...'}},
    				{data: 'localAdmName',cut: {length: 20,mark:'...'}}
            ] ,
            columnDefs: [
                         {
                             targets: 1,
                             render: function (data, type, row, meta) {
                           		 return '<input type="checkbox" name="_checkbox" class="chb" year="'+row.year+'" batchEntType="'+row.batchEntType+'" value='+row.priPID+'>';
                             }
                       }, 
                       {
                    	   targets: 3,
                    	   render: function (data, type, row, meta) {
                    		   if(row.uniCode == null || row.uniCode == "" ){
                    			   return row.regNO;
                    		   }else{
                    			   return row.uniCode;
                    		   }
                    	   }
                       }, 
                       {
                    	   targets: 5,
                    	   render: function (data, type, row, meta) {
                    		   if(row.batchEntType == 2){
                    			   return "农专社";
                    		   }else if (row.batchEntType == 3){
                    			   return "外资企业";
                    		   }else if(row.batchEntType == 1){
                        		   return "内资企业";
                    		   }else{
                    			   return data;
                    		   }
                    	   }
                       }, 
                       {
                    	   targets: 7,
                    	   render: function (data, type, row, meta) { 
                    		   if(data == null || data == "" || data == "undefined"){
           		    			   return "否";
           		    		   }else if( data == '1'){
           			    		   return "<span style='color:red;'>是</span>";
           					   }else if( data == "0"){
           						   return "否";
           					   }else{
           						   return data;
           					   }
                    	   }
                       }
            ],
            "fnDrawCallback": function (oSettings) {
           	     count = oSettings._iRecordsTotal;//查询总数赋值
            }
         })
    }
    
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	clickFlag = true;
        table.ajax.reload();
    }); 
    
    
    //全部导出
    $("#js-download").click(function(){
    	if(count<=5000){
        	layer.msg('处理中，请稍后', {icon: 16, time: 7000, shade: [0.4, '#CCC']});
    	}else if(count>5000 && count<=10000){
        	layer.msg('处理中，请稍后', {icon: 16, time: 15000, shade: [0.4, '#CCC']});
    	}else{
        	layer.msg('处理中，请稍后', {icon: 16, time: 20000, shade: [0.4, '#CCC']});
    	}
    	$("js-download").attr("disabled",true);
    	if(count<=0){
            layer.msg("当前条件下无可批量列入的数据，请确认查询条件后重新选择", {ltype: 0, time: 500});
            return false;
    	}
    	if(count>20000){
            layer.msg("当前批量查询数据为"+count+"条，大于>20000条，确认查询条件", {ltype: 0, time: 500});
            return false;
    	}
		$("#map").val(JSON.stringify(searchParams)); 
		setTimeout(timeOut,15000);
   	    document._form.submit();
    });
    

    function bind() {
        util.bindEvents([{
            el: '#back',
            event: 'click',
            handler: function () {
            	window.location.href='/reg/server/opanomaly/pubopanomaly/selectBatchInList';
            }
        },{
            el: '#batchin',
            event: 'click',
            handler: function () {
            	var batchEntType = 1;
            	var year = 2016
                var ItemIds = new Array();
                var index = 0;
                var trueFlag = true;
                if($("#checkBatchAll").prop("checked")){//全部全选被选中
                	if(count<=0){
                        layer.msg("当前条件下无可批量列入的数据，请确认查询条件后重新选择", {ltype: 0, time: 500});
                        return false;
                	}
                	formparams = formparams+'&initBatchNum='+count;
                    layer.dialog({
                        title: '批量列入异常（企业、农专社）-新增批量列入记录',
                        area: ['1024px', '650px'],
                        content: '/reg/server/opanomaly/pubopanomaly/selectBatchInAddAll?'+formparams,
                        callback: function (data) {
                            //重新加载列表数据
                            if (data.reload) {
                                table.ajax.reload();
                            }
                        }
                    })
                }else{
                    $(":checkbox[name=_checkbox]:checked").each(function () {
                        ItemIds[index++] = $(this).val();
                        batchEntType = $(this).attr('batchEntType');
                        year = $(this).attr('year')
                        
                    });
                    if (ItemIds.length == 0) {
                        layer.msg("请选择一项进行操作", {ltype: 0, time: 500});
                        return false;
                    }
                    else {
                  	  if (window.localStorage) {
              		    //本地存储先清除，再赋值
              		    localStorage.removeItem("itemIds");
              		    localStorage.setItem("itemIds", ItemIds.toString());	
              		  }
                  	  
                      layer.dialog({
                          title: '批量列入异常（企业、农专社）-新增批量列入记录',
                          area: ['1024px', '650px'],
                          content: '/reg/server/opanomaly/pubopanomaly/selectBatchInAdd?batchEntType='+batchEntType+'&year='+year+'&decorgCN='+$("#decorgCN").val()+'&decOrg='+$("#decOrg").val()+'&initBatchNum='+ItemIds.length,
                          callback: function (data) {
                              //重新加载列表数据
                              if (data.reload) {
                                  table.ajax.reload();
                              }
                          }
                      })                 	  
//                      debugger
                      //处理pripid数组传值
//                	  $.ajax({
//                      url: "/reg/server/opanomaly/pubopanomaly/getPriCode",
//                      type: 'post',
//                      data: {'priPID':ItemIds.toString()},
//                      success: function(data, status){
//                    	  //设置本地存储，大小限制为5M
//                 	  
////                    	debugger  
//                    	if(data.status == 'success' && data.data == ItemIds.toString()){
//
//                    	}else{
//                            layer.msg("操作失败", {ltype: 0, time: 500});
//                    	} 
//                        },
//                      error: function(data, status){
//                      	alert("操作失败");
//                      }
//                     });
                    }
                }

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
                    	var returncode=data.returncodes;
                    	var returnname=data.returnname;
                    	$("#regOrg").val(returncode);
                    	$("#regOrgName").val(returnname);
                    }
                })
            }
        },{
            el: '#choseCheckDep',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择抽检机关',
                    area: ['400px', '600px'],
                    content: '/commom/server/regorg/regorgmutiselect?isPermissionCheck=true',
                    callback: function (data) { 
                    	var returncode=data.returncodes;
                    	var returnname=data.returnname;
                    	$("#checkDep").val(returncode);
                    	$("#checkDepName").val(returnname);
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
                    	var returnname=data.returnname;	 
                      	$("#localAdm").val(returncode);
                      	$("#localAdmName").val(returnname);
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
                    	var returncode=data.returncodes;
                    	$("#sliceNO").val(returncode);
                    	$("#sliceNOName").val(data.returnname);  
                    }
                })
            }
        }, {
            el: '#select-intercept',
            event: 'click',
            handler: function () {
                layer.dialog({
                    title: '移出原因',
                    area: ['580px', '300px'],
                    content: '/commom/server/intercept/interceptselect?selecttype=canOutReaCodeList',
                    callback: function (data) {
                        if(data){
                            $("#remExcpres").val(data.id);
                            $("#remExcpresText").val(data.text);
                        }
                    }
                })
            }
        }, {
            el: '#select-intercept_in',
            event: 'click',
            handler: function () {
                layer.dialog({
                    title: '列入原因',
                    area: ['580px', '300px'],
                    content: '/commom/server/intercept/interceptselect?selecttype=appInReaCodeList',
                    callback: function (data) {
                        if(data){
                            $("#speCause").val(data.id);
                            $("#speCauseText").val(data.text);
                        }
                    }
                })
            }
        },
        {
            el: '#reset', //重置
            event: 'click',
            handler: function () {
            	$('.hidden_input').val('');//重置隐藏域
            	$('#decorgCN').val(window._CONFIG._decorgCN);
            	$('#decOrg').val(window._CONFIG._decOrg);
            	
            }
        },
        {
        	el: '#checkAll', //单页全选
        	event: 'click',
        	handler: function () {
            	var allChecked= $("#checkAll").prop("checked");   
            	$(".chb").prop("checked", allChecked);
        	}
        }
        ]);
    }

})
