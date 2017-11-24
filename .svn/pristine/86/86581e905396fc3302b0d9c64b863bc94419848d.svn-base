require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery', 'jquery.validate', 'jquery.serialize', 'laydate','pagination'],
function(layer, dataTable, util, http, handlebars) {
	var initFlag = true;
	var searchParams={};
	var table;
    init();
    /**
     * 初始化函数集合
     */
    function init() { 
        bind(); 
    }
    
    //经营异常名录
    function initOpanomaTable(page,length,callback) { 
    	var params={
        		"pripids":$("#pripids").val(),
        		"proveStartDate":$("#proveStartDate").val(),
        		"proveEntDate":$("#proveEntDate").val(),
        		"pageNum":page};
        http.httpRequest({
        	url:window._CONFIG.url+'/creditprovelist/selectOpanomalyResultMapByPripids.json',
            serializable: false,
            showIndex: true, 
            data: {start: page*length,length: length,params:params},
            success: function(data) { 
            	
                if(data.data==""||data.data==null){//如果没有
                	  $('#tplPage').html("<td valign='top' colspan='7' class='dataTables_empty'>无</td>"); 
                	return false;
                }
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#pagination_one').pagination(itemCount, {
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,//主体页数
                    num_edge_entries: 2,//边缘页数
                    current_page: page,
                    items_per_page: 5,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页',
                    callback:function(page,jq){
                    	initOpanomaTable(page,5);
                    }
                });
                var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*5);});//序号
                
                handlebars.registerHelper("transUniSCID",
                        function(value) { 
                        if(value==null||value==""){
                        	return this.regNO;
                        }else{
                        	return value;
                        }
                        }
                     );
                var myTemplate = handlebars.compile($('#table-template').html());
                $('#tplPage').html(myTemplate(data));
                $("#itemCount").text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $("#pageCount").text(pageNum);//共多少页
            }
        })
    }

   
   
   //工商行政处罚
   function initMidCaseTable(page,length,callback) { 
   	var params={
       		"pripids":$("#pripids").val(),
       		"proveStartDate":$("#proveStartDate").val(),
       		"proveEntDate":$("#proveEntDate").val(),
       		"pageNum":page};
       http.httpRequest({
       	url:window._CONFIG.url+'/creditprovelist/selectMidCaseInfoByPripids.json',
           serializable: false,
           showIndex: true, 
           data: {start: page*length,length: length,params:params},
           success: function(data) {
        	   
               if(data.data==""||data.data==null){//如果没有
               	  $('#midCasetplPage').html("<td valign='top' colspan='7' class='dataTables_empty'>无</td>"); 
               	return false;
               }
               var itemCount = data.recordsTotal; //获取查询出来的总数
               $('#midCase_pagination_one').pagination(itemCount, {
                   prev_text: '<i class="icon-triangle-left"></i>上一页',
                   next_text: '下一页<i class="icon-triangle-right"></i>',
                   num_display_entries: 3,//主体页数
                   num_edge_entries: 2,//边缘页数
                   current_page: page,
                   items_per_page: 5,
                   link_to: 'javascript:void(0)',
                   ellipse_text: '...',
                   first_text: '首页',
                   last_text: '末页',
                   callback:function(page,jq){
                	   initMidCaseTable(page,5);
                   }
               });
               var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*5);});//序号
               
               handlebars.registerHelper("transUniSCID",
                       function(value) { 
                       if(value==null||value==""){
                       	return this.regNO;
                       }else{
                       	return value;
                       }
                       }
                    );
               var myTemplate = handlebars.compile($('#midCase-table-template').html());
               $('#midCasetplPage').html(myTemplate(data));
               $("#midCaseitemCount").text(itemCount);//总数
               var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
               $("#midCasepageCount").text(pageNum);//共多少页
           }
       })
   }
   
   
   //其他部门行政处罚
   function initOtherpunishTable(page,length,callback) { 
   	var params={
       		"pripids":$("#pripids").val(),
       		"proveStartDate":$("#proveStartDate").val(),
       		"proveEntDate":$("#proveEntDate").val(),
       		"pageNum":page};
       http.httpRequest({
       	url:window._CONFIG.url+'/creditprovelist/selectPubOtherpunishByPripids.json',
           serializable: false,
           showIndex: true, 
           data: {start: page*length,length: length,params:params},
           success: function(data) {
        	   
               if(data.data==""||data.data==null){//如果没有
               	  $('#OtherpunishtplPage').html("<td valign='top' colspan='7' class='dataTables_empty'>无</td>"); 
               	return false;
               }
               var itemCount = data.recordsTotal; //获取查询出来的总数
               $('#Otherpunish_pagination_one').pagination(itemCount, {
                   prev_text: '<i class="icon-triangle-left"></i>上一页',
                   next_text: '下一页<i class="icon-triangle-right"></i>',
                   num_display_entries: 3,//主体页数
                   num_edge_entries: 2,//边缘页数
                   current_page: page,
                   items_per_page: 5,
                   link_to: 'javascript:void(0)',
                   ellipse_text: '...',
                   first_text: '首页',
                   last_text: '末页',
                   callback:function(page,jq){
                	   initOtherpunishTable(page,5);
                   }
               });
               var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*5);});//序号
               
               handlebars.registerHelper("transUniSCID",
                       function(value) { 
                       if(value==null||value==""){
                       	return this.regNO;
                       }else{
                       	return value;
                       }
                       }
                    );
               var myTemplate = handlebars.compile($('#Otherpunish-table-template').html());
               $('#OtherpunishtplPage').html(myTemplate(data));
               $("#OtherpunishitemCount").text(itemCount);//总数
               var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
               $("#OtherpunishpageCount").text(pageNum);//共多少页
           }
       })
   }
   
   
   //严重违法失信（黑名单）
   function initExpSeriousCrimeTable(page,length,callback) { 
   	var params={
       		"pripids":$("#pripids").val(),
       		"proveStartDate":$("#proveStartDate").val(),
       		"proveEntDate":$("#proveEntDate").val(),
       		"pageNum":page};
       http.httpRequest({
       	url:window._CONFIG.url+'/creditprovelist/selectExpSeriousCrimeByPripids.json',
           serializable: false,
           showIndex: true, 
           data: {start: page*length,length: length,params:params},
           success: function(data) {
        	   
               if(data.data==""||data.data==null){//如果没有
               	  $('#ExpSeriousCrimetplPage').html("<td valign='top' colspan='7' class='dataTables_empty'>无</td>"); 
               	return false;
               }
               var itemCount = data.recordsTotal; //获取查询出来的总数
               $('#ExpSeriousCrimepagination_one').pagination(itemCount, {
                   prev_text: '<i class="icon-triangle-left"></i>上一页',
                   next_text: '下一页<i class="icon-triangle-right"></i>',
                   num_display_entries: 3,//主体页数
                   num_edge_entries: 2,//边缘页数
                   current_page: page,
                   items_per_page: 5,
                   link_to: 'javascript:void(0)',
                   ellipse_text: '...',
                   first_text: '首页',
                   last_text: '末页',
                   callback:function(page,jq){
                	   initExpSeriousCrimeTable(page,5);
                   }
               });
               var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*5);});//序号
               
               handlebars.registerHelper("transUniSCID",
                       function(value) { 
                       if(value==null||value==""){
                       	return this.regNO;
                       }else{
                       	return value;
                       }
                       }
                    );
               var myTemplate = handlebars.compile($('#ExpSeriousCrime-table-template').html());
               $('#ExpSeriousCrimetplPage').html(myTemplate(data));
               $("#ExpSeriousCrimeitemCount").text(itemCount);//总数
               var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
               $("#ExpSeriousCrimepageCount").text(pageNum);//共多少页
           }
       })
   }
   
   
   //任职资格限制
   function initQualificationLimitTable(page,length,callback) { 
   	var params={
       		"pripids":$("#pripids").val(),
       		"proveStartDate":$("#proveStartDate").val(),
       		"proveEntDate":$("#proveEntDate").val(),
       		"pageNum":page};
       http.httpRequest({
       	url:window._CONFIG.url+'/creditprovelist/selectQualificationLimitByPripids.json',
           serializable: false,
           showIndex: true, 
           data: {start: page*length,length: length,params:params},
           success: function(data) {
        	   
               if(data.data==""||data.data==null){//如果没有
               	  $('#QualificationLimittplPage').html("<td valign='top' colspan='7' class='dataTables_empty'>无</td>"); 
               	return false;
               }
               var itemCount = data.recordsTotal; //获取查询出来的总数
               $('#QualificationLimitpagination_one').pagination(itemCount, {
                   prev_text: '<i class="icon-triangle-left"></i>上一页',
                   next_text: '下一页<i class="icon-triangle-right"></i>',
                   num_display_entries: 3,//主体页数
                   num_edge_entries: 2,//边缘页数
                   current_page: page,
                   items_per_page: 5,
                   link_to: 'javascript:void(0)',
                   ellipse_text: '...',
                   first_text: '首页',
                   last_text: '末页',
                   callback:function(page,jq){
                	   initQualificationLimitTable(page,5);
                   }
               });
               var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*5);});//序号
               
               handlebars.registerHelper("transUniSCID",
                       function(value) { 
                       if(value==null||value==""){
                       	return this.regNO;
                       }else{
                       	return value;
                       }
                       }
                    );
               var myTemplate = handlebars.compile($('#QualificationLimit-table-template').html());
               $('#QualificationLimittplPage').html(myTemplate(data));
               $("#QualificationLimititemCount").text(itemCount);//总数
               var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
               $("#QualificationLimitepageCount").text(pageNum);//共多少页
           }
       })
   }
    
    
 
   

    function bind() {
        util.bindEvents([{
            el: '#createProButton',
            event: 'click',
            handler: function () {
            	 
            	 var proveStartDate=$("#proveStartDate").val();
            	 if(proveStartDate==null||proveStartDate==""){
            		 layer.msg("请选择查证开始日期", {ltype: 0,time:2000});
            		 return false;
            	 } 
            	 var proveEntDate=$("#proveEntDate").val();
            	 if(proveEntDate==null||proveEntDate==""){
            		 layer.msg("请选择查证结束日期", {ltype: 0,time:2000});
            		 return false;
            	 }
            	 var ids=$(":checkbox[name=searchType]:checked");
            	 if(ids.length==0){
                	 layer.msg("请选择查证范围", {ltype: 0,time:2000});
                	 return false;
                 }
            	 $("#midCasetplDiv").css("display","none"); 
            	 $("#OtherpunishDiv").css("display","none"); 
            	 $("#opanomalyDiv").css("display","none"); 
            	 $("#permitDiv").css("display","none"); 
            	 $("#qualificationLimitDiv").css("display","none"); 
            	 $("#otherPermitDiv").css("display","none");
            	 var ivalStr="";
            	 $(":checkbox[name=searchType]:checked").each(function(k,v){
                 	var ival=this.value;
                 	ivalStr+=ival+",";
                 	if("1"==ival){
                 	 $("#midCasetplDiv").css("display",""); 
                 		//工商行政处罚
                   	 initMidCaseTable(0,5);
                 	}else if("2"==ival){
                 	  $("#OtherpunishDiv").css("display",""); 
                 		//其他部门行政处罚
                   	 initOtherpunishTable(0,5); 
                 	}else if("3"==ival){
                 	 $("#opanomalyDiv").css("display","");
                 		//经营异常名录
                   	 initOpanomaTable(0,5); 
                 	}else if("4"==ival){
                 	 $("#permitDiv").css("display",""); 
                 		//严重违法失信
                   	 initExpSeriousCrimeTable(0,5);
                 	}else if("5"==ival){
                 	 $("#qualificationLimitDiv").css("display",""); 
                 		 //任职资格限制
                   	 initQualificationLimitTable(0,5);
                 	}
                 	
                 	var midBaseInfoDtoListLength=window._CONFIG.midBaseInfoDtoListLength;
                 	if(parseInt(midBaseInfoDtoListLength)>1){
                 		$("#entList").css("display","");
                 	}else{
                 		$("#entList").css("display","none");
                 	}
                 });
             	var pripids=$("#pripids").val();
             	http.httpRequest({
                     url: window._CONFIG.url+'/creditprovelist/checkIspunish',
                     serializable: false,
                     data: {"proveStartDate":proveStartDate,"proveEntDate":proveEntDate,"pripids":pripids,"searchType":ivalStr},
                     type: 'get',
 	                success: function (data) {  
 	                	     
 	                	   if(data.status="success"){
 	                		   if(data.data!=0&&data.data!="0"){
 	                			   $("#ent_one_no").css("display","none"); 
 	                        	   $("#ent_more_no").css("display","none"); 
 	                			   $("#ent_more_yes").css("display","");
 	                			   $("#ent_one_yes").css("display","");
 	                		   }else{
 	                			   $("#ent_one_yes").css("display","none"); 
	                        	   $("#ent_more_yes").css("display","none");
 	                			   $("#ent_more_no").css("display","");
	                			   $("#ent_one_no").css("display",""); 
	                			   
	                			   $("#midCasetplDiv").css("display","none"); 
		                           $("#OtherpunishDiv").css("display","none"); 
		                           $("#opanomalyDiv").css("display","none"); 
		                           $("#permitDiv").css("display","none"); 
		                           $("#qualificationLimitDiv").css("display","none"); 
		                           $("#otherPermitDiv").css("display","none");
 	                		   }
 	                	   } 
                     }
                 });
             	 $("#butDiv").css("display","");  
             	 
             	var proveStartDateArr=proveStartDate.substring(0,10).split("-");
             	$(".proveStart").text(proveStartDateArr[0]+"年"+proveStartDateArr[1]+"月"+proveStartDateArr[2]+"日");
        		
        		var proveEntDateArr=proveEntDate.substring(0,10).split("-");
        		$(".proveEnt").text(proveEntDateArr[0]+"年"+proveEntDateArr[1]+"月"+proveEntDateArr[2]+"日")  ;
        		$("#ProveNo").val("");
            }
        },{
            el: '#addTz',
            event: 'click',
            handler: function () {
            	var proveNo=$("#ProveNo").val();
	        	if(proveNo!=null&&proveNo!=""){
	        		layer.msg("您已经加入台账不能重复操作", {ltype: 0,time:2000});
            		return false;
	        	}else{
	        		var proveStartDate=$("#proveStartDate").val();
	            	var proveEntDate=$("#proveEntDate").val();
	            	var pripids=$("#pripids").val();
	            	var nowDateStr=window._CONFIG.nowDateStr;
		           	var ivalStr="";
		        	$(":checkbox[name=searchType]:checked").each(function(k,v){
	                 	ivalStr+=this.value+",";
		        	 });
	            	http.httpRequest({
	                    url: window._CONFIG.url+'/creditprovelist/creatTz',
	                    serializable: false,
	                    data: {"nowDate":nowDateStr,"proveStartDate":proveStartDate,"proveEntDate":proveEntDate,"pripids":pripids,"searchType":ivalStr},
	                    type: 'get',
		                success: function (data) { 
		                	
		                	    if(data.status=="success"){
		                	    	//查证单号
		                	    	$("#ProveNo").val(data.data);
		                	    	layer.msg("操作成功", {ltype: 0,time:3000});
		                	    }else{
		                	    	layer.msg("操作失败", {ltype: 0,time:3000});
		                	    }
	                    }
	                });
	        	}
             }
        },{
            el: '#printTz',
            event: 'click',
            handler: function () {
           	 var proveNo=$("#ProveNo").val();
           	 if(proveNo==null||proveNo==""){
           		layer.msg("请先加入台账", {ltype: 0,time:3000});
           	 }else{
           		 var _id = "_doPrint_"+new Date().getTime();
                 var url = window._CONFIG.url+'/creditprovelist/print?proveNo='+proveNo;
                  try{
                      window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
                  }catch(e){
                      alert("打印错误!");
                  }
              } 
           	 }
        },{
            el: '#ent_list',
            event: 'click',
            handler: function () {
            	$("#ent_table_list").css("display","");
             }
        },{
	      	  el:"#closeW",
	    	  event:'click',
	    	  handler:function(){ 
	    		  layer.close();
	    	  }
	      }
	      ])
    }

})
