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
   
   
   //失信被执行人黑名单
   function initQualificationLimitTypeTable(page,length,callback) { 
   	var params={
       		"pripids":$("#pripids").val(),
       		"proveStartDate":$("#proveStartDate").val(),
       		"proveEntDate":$("#proveEntDate").val(),
       		"pageNum":page};
       http.httpRequest({
       	url:window._CONFIG.url+'/creditprovelist/selectQualificationLimitTypePripids.json',
           serializable: false,
           showIndex: true, 
           data: {start: page*length,length: length,params:params},
           success: function(data) {
        	   
               if(data.data==""||data.data==null){//如果没有
               	  $('#QualificationLimitType-tplPage').html("<td valign='top' colspan='6' class='dataTables_empty'>无</td>"); 
               	return false;
               }
               var itemCount = data.recordsTotal; //获取查询出来的总数
               $('#QualificationLimitType-pagination-one').pagination(itemCount, {
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
                	   initQualificationLimitTypeTable(page,5);
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
               var myTemplate = handlebars.compile($('#QualificationLimitType-table-template').html());
               $('#QualificationLimitType-tplPage').html(myTemplate(data));
               $("#QualificationLimitType-itemCount").text(itemCount);//总数
               var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
               $("#QualificationLimitType-pageCount").text(pageNum);//共多少页
           }
       })
   }
   
   
   //投资任职情况
   function initMidInvDivTable(page,length,callback) { 
	   
	   	var params={
	       		"cerNO":$("#cerNO").val(),
	       		"pageNum":page};
	       http.httpRequest({
	       	url:window._CONFIG.url+'/creditprovelist/selectMidInvDivTableBycerNOs.json',
	           serializable: false,
	           showIndex: true, 
	           data: {start: page*length,length: length,params:params},
	           success: function(data) {
	        	   var creditProveListDtoListLength=window._CONFIG.creditProveListDtoListLength; 
	               if(data.data==""||data.data==null){//如果没有
	            	   if(parseInt(creditProveListDtoListLength)>1){
	            		   $("#ent_more_no").css("display",""); 
		               }else{
		            	   $("#ent_one_no").css("display",""); 
		               }
	               	  $('#mid-inv-tplPage').html("<td valign='top' colspan='7' class='dataTables_empty'>无</td>");
	               }
	               var itemCount = data.recordsTotal; //获取查询出来的总数
	               if(itemCount==0){
	            	   if(parseInt(creditProveListDtoListLength)>1){
	            		   $("#ent_more_no").css("display",""); 
		               }else{
		            	   $("#ent_one_no").css("display",""); 
		               }
	               }else{
	            	   if(parseInt(creditProveListDtoListLength)>1){
	            		   $("#cerNO_more").css("display",""); 
		               }else{
		            	   $("#cerNO_one").css("display",""); 
		               }
	               }
	               $('#mid-inv-pagination-one').pagination(itemCount, {
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
	                	   initMidInvDivTable(page,5);
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
	               var myTemplate = handlebars.compile($('#mid-invtable-template').html());
	               $('#mid-inv-tplPage').html(myTemplate(data));
	               $("#mid-inv-itemCount").text(itemCount);//总数
	               var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
	               $("#mid-inv-pageCount").text(pageNum);//共多少页
	           }
	       })
	   }
    
    
 
   

    function bind() {
        util.bindEvents([{
            el: '#createProButton',
            event: 'click',
            handler: function () {
            	 //企业主体身份代码
            	 var pripids=$("#pripids").val();
            	 //查证开始日期
            	 var proveStartDate=$("#proveStartDate").val();
            	 if(proveStartDate==null||proveStartDate==""){
            		 layer.msg("请选择查证开始日期", {ltype: 0,time:2000});
            		 return false;
            	 } 
            	 //查证结束日期
            	 var proveEntDate=$("#proveEntDate").val();
            	 if(proveEntDate==null||proveEntDate==""){
            		 layer.msg("请选择查证结束日期", {ltype: 0,time:2000});
            		 return false;
            	 }
            	 //查证范围
            	 var ids=$(":checkbox[name=searchType]:checked");
            	 if(ids.length==0){
                	 layer.msg("请选择查证范围", {ltype: 0,time:2000});
                	 return false;
                 }
            	 
            	 //点击生成查证时先隐藏所有表格及信息
            	 $("#midCasetplDiv").css("display","none"); 
            	 $("#OtherpunishDiv").css("display","none"); 
            	 $("#opanomalyDiv").css("display","none"); 
            	 $("#permitDiv").css("display","none"); 
            	 $(".sxbzxr").css("display","none"); 
            	 $("#otherPermitDiv").css("display","none");
            	 $("#butDiv").css("display","");
            	 $("#grgszm_one").css("display","");
            	 //自然人投资/任职关系
            	initMidInvDivTable(0,5);
            	//生成查证单的人数
            	var creditProveListDtoListLength=window._CONFIG.creditProveListDtoListLength;
            	if(parseInt(creditProveListDtoListLength)>1){
              		$("#entList").css("display","");
              		//$("#cerNO_more").css("display",""); 
              	}else{
              		$("#entList").css("display","none");
              		//$("#cerNO_one").css("display",""); 
              	}
            	
            	
            	if(pripids!=null&&pripids!=""){
            	 $("#mid_invDiv_none").css("display","");  
            	 $("#ent_more_yes1").css("display","");
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
                    	  //$("#qualificationLimitDiv").css("display",""); 
                    	  //失信被执行人 
                      	  initQualificationLimitTypeTable(0,5);
                    	  $(".sxbzxr").css("display",""); 
                    	}else if("6"==ival){//其他失信
                    	 $("#otherPermitDiv").css("display",""); 
                    	}
                    });
                	 
                	var proveStartDateArr=proveStartDate.substring(0,10).split("-");
                	$(".proveStart").text(proveStartDateArr[0]+"年"+proveStartDateArr[1]+"月"+proveStartDateArr[2]+"日");
           		
	           		var proveEntDateArr=proveEntDate.substring(0,10).split("-");
	           		$(".proveEnt").text(proveEntDateArr[0]+"年"+proveEntDateArr[1]+"月"+proveEntDateArr[2]+"日")  ;
	           		$("#ProveNo").val("");
            	}
            }
        },{
            el: '#addTz',
            event: 'click',
            handler: function () {
            	var proveStartDate=$("#proveStartDate").val();
            	var proveEntDate=$("#proveEntDate").val();
            	var uids=$("#uids").val();
            	var nowDateStr=window._CONFIG.nowDateStr;
	           	var ivalStr="";
	        	$(":checkbox[name=searchType]:checked").each(function(k,v){
                 	ivalStr+=this.value+",";
	        	 });
	        	//查证单编号
	        	var proveNo=$("#ProveNo").val();
	        	if(proveNo!=null&&proveNo!=""){
	        		layer.msg("您已经加入台账不能重复操作", {ltype: 0,time:2000});
            		return false;
	        	}else{
	        		http.httpRequest({
	                    url: window._CONFIG.url+'/creditprovelist/creatManTz',
	                    serializable: false,
	                    data: {"nowDate":nowDateStr,"proveStartDate":proveStartDate,"proveEntDate":proveEntDate,"uids":uids,"searchType":ivalStr},
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
