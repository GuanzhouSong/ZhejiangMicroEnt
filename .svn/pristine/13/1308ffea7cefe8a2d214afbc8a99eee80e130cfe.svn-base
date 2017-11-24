require(['layer1', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery', 'jquery.validate', 'jquery.serialize', 'laydate','pagination'],
function(layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    
    function init() {
    	 var entTypeCatg = $("#entTypeCatg").val();
    	 //个体户，农专无即时信息
    	 if(entTypeCatg!=50&&entTypeCatg!=16&&entTypeCatg!=17){
    		 var imReportType = window._CONFIG.repType;//修改获取 lijixiang
    		 
    		 if (imReportType.indexOf("investment") != -1) {
    			 initDataInvestmentTable(0);
    		 }
    		 if (imReportType.indexOf("invsralt") != -1) {
    			 initDataInvsraTable(0); 
    		 }
    		 
    		 initPermitTable(0);
    		 
    		 initIppldgTable(0);
    		 
    		 initCaseTable(0); 
    	 }
    	bind(); 
    }
     
    
    function transDte(value) {
        var date=value.split("-");
        return date[0]+"年"+date[1]+"月"+date[2]+"日";
     }
    
    //初始化股东投资信息
    function initDataInvestmentTable(page){
    	http.httpRequest({
            url: '/im/pub/investalter/investmentListJSON',
            serializable: false,
            data: {
            	"pageNum":page,
            	"priPID":$("#priPID").val(),
            	
               length:5,
               params:{ "pageNum":page }
            },
            success: function(data) {

                if(data.data==""||data.data==null){//如果没有
                	  $('#tplPage').html("<td valign='top' colspan='8' class='dataTables_empty'>没有匹配结果</td>"); 
                	return false;
                }
            	
                if(page==0){
            		page=page;
            	}else{
            	page=page-1;
            	}
            	
            	 var showPage= data.recordsTotal;
                $('#pageinvestment').pagination(showPage, {//分页工具
                    callback:pageInvesMentCallback,
                    items_per_page:5,
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,
                    num_edge_entries: 2,
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页'
                });
            	 
                $("#investmentCount").text(data.recordsTotal);
                var totalPages = Math.ceil(data.recordsTotal/5);  
           	    $("#investmentPageCount").text(totalPages);
                
              var handleHelper = handlebars.registerHelper("addOne",
                function(index) {
                    //返回+1之后的结果
            	  if(page>=0){
                      var toIn=((page)*5);
                      
                         return index + 1+toIn;
                         }else{
                         	return index+1;
                         }
                }); 
              handlebars.registerHelper("trsPubFlag",
                      function(value) {
                          if (value == "1") {
                              return "公示";
                          } else {
                              return "未公示";
                          }
                      });
                var myTemplate = handlebars.compile($("#investment-template").html());
                handlebars.registerHelper("transDate",
                        function(value) {
                           var date=value.split("-");
                           return date[0]+"年"+date[1]+"月"+date[2]+"日";
                        });

                if(typeof data.recordsTotal!='undefined' &&data.recordsTotal>0)  $('#investment').html(myTemplate(data));
            }
        }) 
    	
    	
    }
    
      
    //股权变更信息
    function initDataInvsraTable(page) { 
     
        http.httpRequest({
            url: '/im/pub/investalter/invsraListJSON',
            serializable: false,
            data: {
            	"pageNum":page,
            	"priPID":$("#priPID").val(),
               length:5,
               params:{ "pageNum":page }
            },
            success: function(data) {
               
            	
                if(page==0){
            		page=page;
            	}else{
            	page=page-1;
            	}
            	
            	 var showPage= data.recordsTotal;
                $('#paginvsral').pagination(showPage, {//分页工具
                    callback:pageInvsraCallback,
                    items_per_page:5,
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,
                    num_edge_entries: 2,
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页'
                });
            	 
                $("#invsralCount").text(data.recordsTotal);
                var totalPages = Math.ceil(data.recordsTotal/5);  
           	    $("#invsralPageCount").text(totalPages);
               
              var handleHelper = handlebars.registerHelper("addOne",
                function(index) {
                    //返回+1之后的结果
            	  if(page>=0){
                      var toIn=((page)*5);
                      
                         return index + 1+toIn;
                         }else{
                         	return index+1;
                         }
                }); 
                var myTemplate = handlebars.compile($("#invsral-template").html());
                handlebars.registerHelper("transDate",
                        function(value) {
                           var date=value.split("-");
                           return date[0]+"年"+date[1]+"月"+date[2]+"日";
                        });
                
                handlebars.registerHelper("dataFormat",
                        function(value) {
                            var myDate = new Date(value);
                            var month=myDate.getMonth()+1;
                            return myDate.getFullYear() + "年" + month+ "月" + myDate.getDate() + "日";
                        });
                
                
                $('#invsral').html(myTemplate(data)); 
            }
        })
    }
    
    function initPermitTable(page) { //行政许可
        
        http.httpRequest({
            url: '/im/pub/investalter/permitListJSON',
            serializable: false,
            data: {
            	"pageNum":page,
            	"priPID":$("#priPID").val(),
               length:5,
               params:{ "pageNum":page }
            },
            success: function(data) {
            	
                if(page==0){
            		page=page;
            	}else{
            	page=page-1;
            	}
            	
            	 var showPage= data.recordsTotal;
                $('#pagepermit').pagination(showPage, {//分页工具
                    callback:pagePermitCallback,
                    items_per_page:5,
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,
                    num_edge_entries: 2,
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页'
                });
            	 
                $("#permitCount").text(data.recordsTotal);
                var totalPages = Math.ceil(data.recordsTotal/5);  
           	    $("#permitPageCount").text(totalPages);
                
               
              var handleHelper = handlebars.registerHelper("addOne",
                function(index) {
                    //返回+1之后的结果
            	  if(page>=0){
                      var toIn=((page)*5);
                      
                         return index + 1+toIn;
                         }else{
                         	return index+1;
                         }
                }); 
                var myTemplate = handlebars.compile($("#permit-template").html());
                handlebars.registerHelper("transDate",
                        function(value) {
                           var date=value.split("-");
                           return date[0]+"年"+date[1]+"月"+date[2]+"日";
                        });
                  handlebars.registerHelper("transPubType",function(value){
                	if(value!=null&&value!=""){
                	  if(value=="1"){
                		 return "变更";
                	 }else  if(value=="2"){
                		 return "注销";
                	 }else  if(value=="3"){
                		 return "被吊销";
                	 }else if(value=="4"){
                		 return "撤销";
                	 }else{
                		 return "有效";
                	 }
                	}else{
                		return "有效";
                	}
                	 
                	 
                  });
                
                $('#permit').html(myTemplate(data)); 
            }
        })
    }
    function initIppldgTable(page) { //知识产权
        
        http.httpRequest({
            url: '/im/pub/investalter/ippldgListJSON',
            serializable: false,
            data: {
            	"pageNum":page,
            	"priPID":$("#priPID").val(),
               length:5,
               params:{ "pageNum":page }
            },
            success: function(data) {
            	
                if(page==0){
            		page=page;
            	}else{
            	page=page-1;
            	}
            	
            	 var showPage= data.recordsTotal;
                $('#pageippldg').pagination(showPage, {//分页工具
                    callback:pageIppldgCallback,
                    items_per_page:5,
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,
                    num_edge_entries: 2,
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页'
                });
            	 
                $("#ippldgCount").text(data.recordsTotal);
                var totalPages = Math.ceil(data.recordsTotal/5);  
           	    $("#ippldgPageCount").text(totalPages);
                
               
              var handleHelper = handlebars.registerHelper("addOne",
                function(index) {
                    //返回+1之后的结果
            	  if(page>=0){
                      var toIn=((page)*5);
                      
                         return index + 1+toIn;
                         }else{
                         	return index+1;
                         }
                }); 
                var myTemplate = handlebars.compile($("#ippldg-template").html());
                handlebars.registerHelper("transDate",
                        function(value) {
                           var date=value.split("-");
                           return date[0]+"年"+date[1]+"月"+date[2]+"日";
                        });
                handlebars.registerHelper("transType",function(value){
                	if(value=="1"){
                		return "变更";
                	}else if(value=="2"){
                		return "注销";
                	}else if(value=="3"){
                		return "撤销";
                	}else{
                		return "有效";
                	} 
                });
                
                handlebars.registerHelper("transkinds",function(value){
                	if(value=="1"){
                		return "商标";
                	}else if(value=="2"){
                		return "版权";
                	}else if(value=="3"){
                		return "专利";
                	}else{
                		return value;
                	} 
                });
                
                handlebars.registerHelper("dataFormat",
                        function(value) {
                            var myDate = new Date(value);
                            var month=myDate.getMonth()+1;
                            return myDate.getFullYear() + "年" + month+ "月" + myDate.getDate() + "日";
                        });
                handlebars.registerHelper("ifUnicode",
                        function(value) {
                          if(value==null||value==""){
                        	 return "display:block";
                          }else{
                        	  return "display:none";
                          }
                        });
                
                
                $('#ippldg').html(myTemplate(data)); 
            }
        })
    }
    
function initCaseTable(page) { //行政处罚
        
        http.httpRequest({
            url: '/im/pub/investalter/caseListJSON',
            serializable: false,
            data: {
            	"pageNum":page,
            	"priPID":$("#priPID").val(),
               length:5,
               params:{ "pageNum":page }
            },
            success: function(data) {
            	
            	if(page==0){
            		page=page;
            	}else{
            	page=page-1;
            	}
            	
            	 var showPage= data.recordsTotal;
                $('#pagecase').pagination(showPage, {//分页工具
                    callback:pageCaseCallback,
                    items_per_page:5,
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,
                    num_edge_entries: 2,
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页'
                });
            	 
                $("#caseCount").text(data.recordsTotal);
                var totalPages = Math.ceil(data.recordsTotal/5);  
           	    $("#casePageCount").text(totalPages);
              
              var handleHelper = handlebars.registerHelper("addOne",
                function(index) {
            	  if(page>=0){
                      var toIn=((page)*5);
                      
                         return index + 1+toIn;
                         }else{
                         	return index+1;
                         }
                }); 
                var myTemplate = handlebars.compile($("#case-template").html());
                handlebars.registerHelper("transDate",
                        function(value) {
                	if(value!=null&&value!=""){
                           var date=value.split("-");
                           return date[0]+"年"+date[1]+"月"+date[2]+"日";
                	}
                        });
                handlebars.registerHelper("dataFormat",
                        function(value) {
                    if(value!=null&&value!=""){       
                	var myDate = new Date(value);
                            var month=myDate.getMonth()+1;
                            return myDate.getFullYear() + "年" + month+ "月" + myDate.getDate() + "日";
                    }    
                    });
                handlebars.registerHelper("rowdisplay",
                        function(value) {
                         if(value == null || value == ""){
                        	 return "1";
                         }else{
                        	 return "2";
                         } 
                    });
                handlebars.registerHelper("dataList",
                        function(value) {
                         if(value==null||value==""){
                        	 return "display:none";
                         }else{
                        	 return "";
                         } 
                    });
                
                handlebars.registerHelper("transType",
                        function(value) {
                         if(value==null&&value==""){
                        	  if(value=="1"){
                        		  return "变更";
                        	  }else if(value=="2"){
                        		  return "诉讼";
                        	  }else if(value=="3"){
                        		  return "复议"
                        	  }else{
                        		  return "有效";
                        	  }
                         }else{
                        	 return "有效";
                         }  
                    });

                
                $('#case').html(myTemplate(data)); 
            }
        })
    }
    
    
    
    
    
   function pageInvsraCallback(page,jq){//翻页事件 
	   initDataInvsraTable(page+1);  
   }
   
   function pageInvesMentCallback(page,jq){//翻页事件 
	   initDataInvestmentTable(page+1);  
   }
   
   
   
   function pagePermitCallback(page,jq){//翻页事件 
	   initPermitTable(page+1);  
   }
   
   function pageIppldgCallback(page,jq){//翻页事件
	   
	   initIppldgTable(page+1);
   }
   
  function pageCaseCallback(page,jq){//翻页事件
	  initCaseTable(page+1);
	  
	  
  } 
   
   
   
   
   
    
  
    function bind() {
        util.bindEvents([
        {
            el: '#cancle',
            event: 'click',
            handler: function() {
            	$('#forinvestForm')[0].reset();
            	 $(".js-content-show").hide();
            }
        },
        {
        	el:".showIppldg",
        	event:'click',
        	handler:function(){ 
        		var priPID=$("#priPID").val();
        		 layer.open({
                     isIframeAuto: true,  //如果iframe内容是异步获取不要传此参数
                     type:2,
                     shadeClose: true,
                     closeBtn: 0,
                     area: ['800px','400px'],
                     title: false,
                     content: "/im/pub/investalter/showIppldg?pleID="+this.id+"&priPID="+priPID
                 });
        	}
        },
        {
        	el:".showPermit",
        	event:'click',
        	handler:function(){
        		var priPID=$("#priPID").val();
        		  layer.open({
                      isIframeAuto: true,  //如果iframe内容是异步获取不要传此参数
                      type:2,
                      shadeClose: true,
                      closeBtn: 0,
                      area: ['75%','30%'],
                      title: false,
                      content: "/im/pub/investalter/showPermit?licID="+this.id+"&priPID="+priPID
                  });
        		
        	 
        	}
        },
        {
        	el:"#showImvestupdate",
        	event:'click',
        	handler:function(){
        		var priPID=$("#priPID").val();
        		window.open("/im/pub/investalter/showImvestupdate?priPID="+priPID);
        	}
        }
        
        
       ])
    }
  
})