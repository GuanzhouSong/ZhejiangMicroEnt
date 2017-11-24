require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','pagination'], function (layer, dataTable, util, http,handlebars) {

	//警示 协同的URL前缀
	var _sysUrl=window._CONFIG._sysUrl;
	var _viewFalg=window._CONFIG._viewFalg;
    init();
    
    
    var startNorDate = {
            elem: '#taskStartTime', //选择ID为START的input
            format: 'YYYY-MM-DD', //自动生成的时间格式
            min: '1970-01-01', //设定最小日期为当前日期
            max: '2099-06-16', //最大日期
            istime: true, //必须填入时间
            istoday: false,  //是否是当天
            start: laydate.now(0,"YYYY-MM-DD"),  //设置开始时间为当前时间
            choose: function(datas){
            	endNorDate.min = datas; //开始日选好后，重置结束日的最小日期
            	endNorDate.start = datas //将结束日的初始值设定为开始日
            }
        };
        var endNorDate = {
            elem: '#taskEndTime',
            format: 'YYYY-MM-DD',
            min: '1970-01-01',
            max: '2099-06-16',
            istime: true,
            istoday: false,
            startNorDate: laydate.now(0,"YYYY-MM-DD"),
            choose: function(datas){
            	startNorDate.max = datas; //结束日选好后，重置开始日的最大日期
            }
        }; 
    
    
    $("#taskStartTime").click(function(){laydate(startNorDate);});
    $("#taskEndTime").click(function(){laydate(endNorDate);});
    
    
    /**
     * 初始化函数集合
     */
    
    function init() {
        bind();
        if(_viewFalg!="2"){
        	// initDataInvsraTable() ;
            $("#resourcePlanName").hide();
            $("#choseDept").hide();
            $("#planYear").hide();
        }else{
        	var _taskResource=window._CONFIG._taskResource;
        	if(_taskResource=="1"){
        		$("#resourcePlanName").hide();
                $("#choseDept").hide();
                $("#planYear").hide();
        	}else{
        		$("#resourcePlanName").show();
                $("#choseDept").show();
                $("#planYear").show();
        	}
        }
    }
    
    function initDataInvsraTable() {
        http.httpRequest({
            url: _sysUrl+'/sccheck/scplantask/selectPubSccheckTypeJSON.json',
            serializable: false,
            data:{start: 0,length: 9999,pageNum: 0},
            success: function (data) {
	        	 if (data.data == "" || data.data == null) {//如果没有
	                  $('#invsraltplPage').html("<td valign='top' colspan='5' class='dataTables_empty'>无</td>");
	                 // $("#invsralTotal").text(0); 
	                  return false;
	             }
                /*var showPage = data.recordsTotal;
                if(showPage==null||showPage==""){
                	showPage=0;
                }
                $("#invsralTotal").text(showPage); */
                /*$('#paginvsral').pagination(showPage, {//分页工具
                    callback: pageInvsraCallback,
                    items_per_page: 5,
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,
                    num_edge_entries: 2,
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页'
                });*/
                /*$("#invsralCount").text(data.recordsTotal);
                var totalPages = Math.ceil(data.recordsTotal / 5);
                $("#invsralPageCount").text(totalPages);*/
                var handleHelper = handlebars.registerHelper("addOne",
                    function (index) {
                            return index + 1;
                    });
                
                handlebars.registerHelper("transType",
                        function(value) { 
                	     return  '<a href="javascript:void(0)" class="js-yrinfo">删除</a>';
                         }
                     );
                var myTemplate = handlebars.compile($("#invsral-template").html());
                if (typeof data.recordsTotal != 'undefined' && data.recordsTotal > 0) $('#invsral').html(myTemplate(data.data));
            }
        })
    }
    
     
    function bind() {
        util.bindEvents([
        {
            el: '#cancel',
            event: 'click',
            handler: function() {
            	layer.close();
            }
       },
       {//删除
           el: '.js-yrinfo',
           event: 'click',
           handler: function () {
         //删除并重构表格数据
         var code = $(this).closest('tr').attr('data-id'); 
         layer.confirm('确定要删除吗?', {icon: 3, title: '提示'}, function () {
         		var  taskArr = $("#invsral tr");
         		var dataArr = [];
         		if(taskArr.length>0){
	         		for(var a=0;a<taskArr.length;a++){
	         			     var count=a+1;
	         				 var dataid=$(taskArr[a]).attr('data-id');
		           			 var dObject=new Object();
		           			 var tCode=$("#pubSccheckItemList"+count+"checkCode").val();
		           			 if(dataid!=code){
		           				 var tName=$("#pubSccheckItemList"+count+"checkName").val();
			           			 dObject.id=$("#pubSccheckItemList"+count+"remark").val();
			           			 dObject.pCode=$("#pubSccheckItemList"+count+"checkType").val();
			           			 dObject.deptCode=$("#pubSccheckItemList"+count+"checkTypeName").val();
			           			 dObject.code=tCode;
			           			 dObject.content=tName;
			           			 dataArr.push(dObject);
		           			 }
	           		 } 
	         		$("#"+code).remove();
	         		$("#invsral").html("");
         		}
         		
         		if(dataArr.length>0){
         			for(var b=0;b<dataArr.length;b++){
         				var  dataTemArr=[];
         				dataTemArr.push(dataArr[b]);
         				var  lastTr = $("#invsral tr:last").attr('data-index');
            			var indexs = 0;
            			if(typeof lastTr!="undefined" && lastTr!="0"&&lastTr!=0){
            				indexs = parseInt(lastTr) + 1;
            			}else{
            				indexs = 1;
            			}
        				var tpl_entarchivesHelpListAdd = $("#invsral-template").html();
        			    var entarchivesHelpListTemplateAdd = handlebars.compile(tpl_entarchivesHelpListAdd);
        			    var handleHelper = handlebars.registerHelper("addOne",
        	                    function (index) {
        	                            return indexs ;
        	                    });
        			    
        			    handlebars.registerHelper("transType",
                                function(value) { 
                        	     return  '<a href="javascript:void(0)" class="js-yrinfo">删除</a>';
                                 }
                          );
        				var tmpHtml = entarchivesHelpListTemplateAdd(dataTemArr);
        				$('#invsral').html($('#invsral').html()+tmpHtml); 
         			}
         		}
         		 layer.msg("删除成功", {time: 1000}, function () {
                	 
                 }); 
           })
           }
       },
       {
           el: '#save',
           event: 'click',
           handler: function() {
        	  var dutyDeptCode = $("#dutyDeptCode").val();
          	  if(dutyDeptCode == "" || dutyDeptCode == null){
          		  layer.msg("您的账号未设置对应的职能部门，请先设置职能部门！", {ltype: 0,time:2000});
  	    		  return false;
          	  }
          	  var dutyDeptName = $("#dutyDeptCode").find("option:selected").text();
          	  $("#dutyDeptName").val(dutyDeptName);
          	  var crossDepartFlag=$("input[name='crossDepartFlag']:checked").val();
	       	  if(typeof crossDepartFlag=="undefined"||crossDepartFlag==null||crossDepartFlag==""){
	       		  layer.msg("请选择任务类型", {ltype: 0,time:2000});
	 	    		  return false;
	       	  }
        	  var taskResource=$("input[name='taskResource']:checked").val();
         	  if(typeof taskResource=="undefined"||taskResource==null||taskResource==""){
         		  layer.msg("请选择任务来源", {ltype: 0,time:2000});
   	    		  return false;
         	  }
         	  if(taskResource=="2"){
         		  var  resourcePlanName=$.trim($("#resourcePlanName").val());
         		  var  resourcePlanUid=$.trim($("#resourcePlanUid").val());
	           	  if((resourcePlanName==null||resourcePlanName=="")||(resourcePlanUid==null||resourcePlanUid=="")  ){
	           		  layer.msg("请选择年度抽查工作计划", {ltype: 0,time:2000});
	     	    		  return false;
	           	  }
         	  }  
        	  var  taskName=$.trim($("#taskName").val());
        	  if(taskName==null||taskName==""){
        		  layer.msg("任务名称不能为空", {ltype: 0,time:2000});
  	    		  return false;
        	  }
        	  var taskType=$("input[name='taskType']:checked").val();
        	  if(typeof taskType=="undefined"||taskType==null||taskType==""){
        		  layer.msg("请选择抽查方式", {ltype: 0,time:2000});
  	    		  return false;
        	  }
        	  
        	  var  taskInspectDeptCode=$.trim($("#taskInspectDeptCode").val());
     		  var  taskInspectDeptName=$.trim($("#taskInspectDeptName").val());
           	  if((taskInspectDeptCode==null||taskInspectDeptCode=="")||(taskInspectDeptName==null||taskInspectDeptName=="")  ){
           		  layer.msg("请选择实施部门", {ltype: 0,time:2000});
     	    		  return false;
           	  }
        	  
        	  var  taskStartTime=$.trim($("#taskStartTime").val());
        	  var  taskEndTime=$.trim($("#taskEndTime").val());
        	  if((taskStartTime==null||taskStartTime=="")||(taskEndTime==null||taskEndTime=="")  ){
        		  layer.msg("请选择任务期限", {ltype: 0,time:2000});
  	    		  return false;
        	  }
        	  var publicFlag=$("input[name='publicFlag']:checked").val();
        	  if(typeof publicFlag=="undefined"||publicFlag==null||publicFlag==""){
        		  layer.msg("请选择抽取对象是否公示", {ltype: 0,time:2000});
  	    		  return false;
        	  }
        	  
        	 var  taskArr = $("#invsral tr");
 			 if(taskArr.length==0){
 				layer.msg("请添加检查事项", {ltype: 0,time:2000});
	    		return false;
 			 }
        	  
        	  //var formParam=$('#favorableForm').serializeArray();
        	  var formParam=$('#favorableForm').serializeArray();
        	  
        	  http.httpRequest({ 
                   url: _sysUrl+'/sccheck/scplantask/commitPubScPlanTask',
                   data: formParam,
                   type: 'post',
                   success: function (data) {
                	   if(data.status!=="success"){ 
                		   layer.msg(data.msg, {ltype: 0,time:3000});
                	   }else{
                		   layer.close(data);
                	   }
                   }
             });
           }
      },
      {
          el: '#addOtherSccheckType',
          event: 'click',
          handler: function () { 
        	  layer.dialog({
                  title: '添加其他检查事项',
                  area: ['50%', '40%'],
                  content: _sysUrl+"/sccheck/scplantask/addOtherSccheckType",
                  callback: function (data) { 
                 	  
                 	  if(data.flag=="1"){
                 		 var isExitFlag=false;
                 		 var dataArr = [];
                 		 var dObject=new Object();
                 		 dObject.pCode="OTHER";
                 		 dObject.deptCode="【其他类】";
                 		 dObject.content=data.checkName;
                 		 dObject.id=data.remark;
                 		 var  lastTr = $("#invsral tr:last").attr('data-index');
                 		 var indexs = 0;
                 		 if(typeof lastTr!="undefined" && lastTr!="0"&&lastTr!=0){
             				indexs = parseInt(lastTr) + 1;
                 		 }else{
             				indexs = 1;
                 		 }
                 		 dObject.code="OTHER"+indexs; 
                 		 var  taskArr = $("#invsral tr");
            			 if(taskArr.length>0){
		 	         		for(var a=0;a<taskArr.length;a++){
		 	         			 var count=a+1;
		 		           	     var checkName=$("#pubSccheckItemList"+count+"checkName").val();
 		           				 if(checkName==dObject.content){
 		           					isExitFlag=true;
 		           				    break;
 		           				 } 
		 	           		 }
		          		 }
                 		 if(isExitFlag){
                 			layer.msg("检查事项名称已存在", {ltype: 0,time:3000});
                 		 }else{
                 			 dataArr.push(dObject);
                 			 var tpl_entarchivesHelpListAdd = $("#invsral-template").html();
                     		 var entarchivesHelpListTemplateAdd = handlebars.compile(tpl_entarchivesHelpListAdd);
                     		 var handleHelper = handlebars.registerHelper("addOne",
         		                    function (index) {
         		                            return indexs ;
         		                    });
         				    
                     		 handlebars.registerHelper("transType",
         	                        function(value) { 
         	                	     return  '<a href="javascript:void(0)" class="js-yrinfo">删 除</a>';
         	                         }
         	                  );
                     		 var tmpHtml = entarchivesHelpListTemplateAdd(dataArr);
                     		 $('#invsral').html($('#invsral').html()+tmpHtml);
                 		 }
                 	  }
                  }
              })
          }
      },
      {
          el: '#choselicDeptType',
          event: 'click',
          handler: function () { 
              layer.dialog({
                  title: '选择职能部门',
                  area: ['400px', '600px'],
                  content: '/common/system/code_duty_dept/duty_dept_select',
                  callback: function (data) {  
                    $("#taskInspectDeptCode").val(data.deptCodes);
                  	$("#taskInspectDeptName").val(data.deptNames); 
                  }
              })
          }
      },
      {
          el: '#yearPlan',
          event: 'click',
          handler: function () { 
        	  $("#resourcePlanName").show();
              $("#choseDept").show();
              $("#planYear").show();
              $("#taskStartTime").val("");
              $("#taskEndTime").val("");
              $("#taskName").val("");
              $("#taskType1").prop("checked",false);
              $("#taskType2").prop("checked",false);
              $("#taskStartTime").attr("readonly","readonly"); 
	     		$("#taskEndTime").attr("readonly","readonly");
	     		$("#taskName").attr("readonly","readonly");
	 			$("#taskType1").attr("readonly","readonly");
	 			$("#taskType2").attr("readonly","readonly");
          }
      },
      {
          el: '#lsTatsk',
          event: 'click',
          handler: function () { 
              $("#resourcePlanName").hide();
              $("#choseDept").hide();
              $("#planYear").hide();
              $("#resourcePlanUid").val("");
              $("#resourcePlanName").val(""); 
              $("#taskStartTime").val("");
              $("#taskEndTime").val("");
              $("#taskName").val("");
              $("#taskType1").prop("checked",false);
              $("#taskType2").prop("checked",false);
              $("#taskStartTime").removeAttr("readonly"); 
	     		$("#taskEndTime").removeAttr("readonly"); 
	     		$("#taskName").removeAttr("readonly"); 
	 			$("#taskType1").removeAttr("readonly"); 
	 			$("#taskType2").removeAttr("readonly"); 
          }
      },
      {
          el: '#choseDept',
          event: 'click',
          handler: function () {  
              layer.dialog({
                  title: '年度抽查工作计划',
                  area: ['25%', '65%'],
                  content: _sysUrl+'/sccheck/pubscworkplan/pubScWorkPlanTreePage?treeType=radio&planYear='+$("#planYear").val(),
                  callback: function (data) {
                	  
                  	if(typeof data.orgCodes!="undefined"&&data.orgCodes!=""&&data.orgCodes!=null&&data.closeFlag=="1"){
                  		$("#resourcePlanUid").val(data.orgCodes); 
                   		$("#resourcePlanName").val(data.orgNames); 
                   		var dutyDeptCodeStrs = data.dutyDeptCode;
                   		var dutyDeptNameStrs = data.dutyDeptName;
                   		var planName = dutyDeptCodeStrs.split(";")[0];
                   		var taskStartTime = dutyDeptCodeStrs.split(";")[1];
                   		var planType = dutyDeptNameStrs.split(";")[0];
                   		var taskEndTime = dutyDeptNameStrs.split(";")[1];
                   		$("#taskStartTime").val(taskStartTime); 
                   		$("#taskEndTime").val(taskEndTime); 
                   		$("#taskName").val(planName); 
                   		if(planType == "1"){
                   			$("#taskType1").prop("checked",true);
                   		}else{
                   			$("#taskType2").prop("checked",true);
                   		}
                   	}
                 }
              })
          }
      },
      {
          el: '.crossDepartFlag',
          event: 'click',
          handler: function () {  
        	  var crossDepartFlag=$("input[name='crossDepartFlag']:checked").val();
        	  if(crossDepartFlag == "1"){
        		  $("#choselicDeptType").hide();
        		  var dutyDeptCode = $("#dutyDeptCode").val();
        		  var dutyDeptName = $("#dutyDeptCode").find("option:selected").text();
        		  if(dutyDeptCode != null && dutyDeptCode != ""){
        			  $("#taskInspectDeptCode").val(dutyDeptCode);
        			  $("#taskInspectDeptName").val(dutyDeptName);
        		  }else{
        			  $("#taskInspectDeptCode").val("");
        			  $("#taskInspectDeptName").val("");
        		  }
        	  }else{
        		  $("#choselicDeptType").show();
        		  $("#taskInspectDeptCode").val("");
    			  $("#taskInspectDeptName").val("");
        	  }
          }
      },{
          el: '#addSccheckType',
          event: 'click',
          handler: function () { 
              layer.dialog({
                  title: '添加检查事项',
                  area: ['400px', '600px'],
                  content: '/syn/server/drcheck/pubscagent/scChecktypeSelect?isPermissionCheck=true',
                  callback: function (data) { 
                	var msg=""; 
                	var returncodesArr= data.returncodes.split(","); 
                	var returnnameArr=data.returnname.split(",");
                	var pcodesArr=data.pcodes.split(",");
                	var pnamesArr=data.pnames.split(",");
                	if(returncodesArr.length>0){
                		 for(var b=0;b<returncodesArr.length;b++){
                			 var isExitFlag=false;
                			 var dataArr = [];
                			 var dObject=new Object();
                			 var tCode=returncodesArr[b];
                			 var tName=returnnameArr[b];
                			/* if(tCode.indexOf("A")>=0){
                				 dObject.pCode="A";
                				 dObject.deptCode="【A工商类】";
                			 }else if(tCode.indexOf("B")>=0){
                				 dObject.pCode="B";
                				 dObject.deptCode="【B食药类】";
                			 }else if(tCode.indexOf("C")>=0){
                				 dObject.pCode="C";
                				 dObject.deptCode="【C质监类】";
                			 }*/ 
                			 dObject.pCode=pcodesArr[b];
                			 //父类名称
            				 dObject.deptCode=pnamesArr[b];
                			 //检索列表中是否已经存在
                			 var  taskArr = $("#invsral tr");
                			 if(taskArr.length>0){
			 	         		for(var a=0;a<taskArr.length;a++){
			 	         			 var count=a+1;
			 		           	     var checkName=$("#pubSccheckItemList"+count+"checkName").val();
	 		           				 if(checkName==tName){
	 		           					isExitFlag=true;
	 		           				    msg+=checkName+",";
	 		           				    break;
	 		           				 } 
			 	           		 }
			          		}
                			//如果列表中已经存在或者节点是父节点时 跳出循环
                			if(isExitFlag||(pcodesArr[b]==null||pcodesArr[b]=="")){
                				continue;
                			}
                			 
                			dObject.code=tCode;
                			dObject.content=tName;
                			dataArr.push(dObject);
                			var  lastTr = $("#invsral tr:last").attr('data-index');
                 			var indexs = 0;
                 			if(typeof lastTr!="undefined" && lastTr!="0"&&lastTr!=0){
                 				indexs = parseInt(lastTr) + 1;
                 			}else{
                 				indexs = 1;
                 			}
         					var tpl_entarchivesHelpListAdd = $("#invsral-template").html();
         				    var entarchivesHelpListTemplateAdd = handlebars.compile(tpl_entarchivesHelpListAdd);
         				    var handleHelper = handlebars.registerHelper("addOne",
         		                    function (index) {
         		                            return indexs ;
         		                    });
         				    
         				    handlebars.registerHelper("transType",
         	                        function(value) { 
         	                	     return  '<a href="javascript:void(0)" class="js-yrinfo">删 除</a>';
         	                         }
         	                  );
         					var tmpHtml = entarchivesHelpListTemplateAdd(dataArr);
             				$('#invsral').html($('#invsral').html()+tmpHtml); 
                		 }
                	}   
                	if(msg!=""){
                		layer.msg(msg+"已存在,添加失败", {time: 2000}, function() {});
                	}
    		     }
              })
          }
      }
       ])
    }

})