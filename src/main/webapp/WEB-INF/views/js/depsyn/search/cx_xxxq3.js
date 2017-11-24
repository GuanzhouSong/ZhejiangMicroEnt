require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars',
    'component/paginationPage',
    'jquery','jquery.serialize','laydate','pagination','component/backToTop'], function (layer, dataTable, util, http, handlebars,paginationPage) {
	init();
	
	function init(){
		initCaseTable(0);//行政处罚
        initDataTable_abnormalinfo();//异常经营名录
        initDataTable_pubscresult();//抽查检查结果信息
        initDataTable_illegalinfo();//严重违法信息
	}
	
	//严重违法
    function initDataTable_illegalinfo() {
    	loadData_illegalinfo(0,99999);
    }
    function loadData_illegalinfo(page, length, callback) {
    	var params = $('#params').serializeObject();
        var options = {
            page:0,                                     //开始页
            length:5,                                   //长度
            items_per_page:5,                           //每页显示几条              默认10条
            params:params,     //查询参数,                 必填项
            url:'/depsyn/search/doGetCsPubIlldisDetailList',    //url 访问路径              必填项
            type:'post',                                //请求方式
            pagination:'#pageillegal',                   //分页显示的位置             必填项
            myTemplate:'#illegal-template',               //script:模板路径           必填项
            html:'#illegal',                          //需要渲染的html            必填项
            total:'#illegalCount',                            //显示页面总数的位置         必填项
            pageNmber:'#illegalPageCount' ,                     //显示多少页的位置           必填项
            isUseNOdata:'true'
        };
        paginationPage.loadData(options);
        var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*10);});//序号
    }
    //异常经营名录
    function initDataTable_abnormalinfo() {
        loadData_abnormalinfo(0,99999);
    }
    function loadData_abnormalinfo(page, length, callback) {
        var type = window._CONFIG.entTypeCatg == '50' ? 'pbopanomaly' : 'opanomaly';
        var params = $('#params').serializeObject();
        var options = {
            page:0,                                     //开始页
            length:5,                                   //长度
            items_per_page:5,                           //每页显示几条              默认10条
            params:params,     //查询参数,                 必填项
            url:'/pub/client/pub' + type + '/list/list.json',    //url 访问路径              必填项
            type:'post',                                //请求方式
            pagination:'#pageabnormal',                   //分页显示的位置             必填项
            myTemplate:'#abnormal-template',               //script:模板路径           必填项
            html:'#abnormal',                          //需要渲染的html            必填项
            total:'#abnormalCount',                            //显示页面总数的位置         必填项
            pageNmber:'#abnormalPageCount' ,                     //显示多少页的位置           必填项
            isUseNOdata:'true'
        };
        paginationPage.loadData(options);
        var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*10);});//序号
        handlebars.registerHelper("cogDate", function(cogDate) {
            return util.dateFormat(new Date(cogDate),"yy年mm月dd日");
        });
        handlebars.registerHelper("norDate", function(norDate) {
            if(norDate != null) {
                return util.dateFormat(new Date(norDate),"yy年mm月dd日");
            }else{
                return "";
            }
        });
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


                if(typeof data.recordsTotal!='undefined' &&data.recordsTotal>0)  $('#case').html(myTemplate(data));
            }
        })
    }
    
  //抽查检查结果信息
    function initDataTable_pubscresult(){
        loadData_pubscresult(0,5);
    }
    function loadData_pubscresult(page, length, callback) {
        var params = $('#params').serializeObject();//查询参数
        http.httpRequest({
            url: '/pubscresult/list.json',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#pagination_pubscresult').pagination(itemCount, {
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,//主体页数
                    num_edge_entries: 2,//边缘页数
                    items_per_page:5,
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页',
                    callback:function(page,jq){
                    	loadData_pubscresult(page,5);
                    }
                });
                var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*5);});//序号

                handlebars.registerHelper("transInspectDate",
                        function(value) {
    	                	if(value){
    	                		value=value.substring(0,10);
    	                		var date=value.split("-");
    	                		return date[0]+"年"+date[1]+"月"+date[2]+"日";
    	                	}
                        }
                    );
                handlebars.registerHelper("transCN", function(data) {
                	var scResults = data;
                	if(data==""||data==null){
                		return "";
                	}
                	var scResultArr = scResults.split(",");
                	var showResult = "";
                	for(var i=0;i<scResultArr.length;i++){
                		if(parseInt(scResultArr[i]) == 1){
                			showResult = showResult + '正常（符合信息公示相关规定）;';
                		}else if(parseInt(scResultArr[i]) == 2){
                			showResult = showResult + '未按规定公示即时信息;';
                		}else if(parseInt(scResultArr[i]) == 3){
                			showResult = showResult + '未按规定公示年报信息;';
                		}else if(parseInt(scResultArr[i]) == 4){
                			showResult = showResult + '通过登记的住所（经营场所）无法联系;';
                		}else if(parseInt(scResultArr[i]) == 5){
                			showResult = showResult + '公示信息隐瞒真实情况、弄虚作假;';
                		}else if(parseInt(scResultArr[i]) == 6){
                			showResult = showResult +  '不予配合情节严重;';
                		}else if(parseInt(scResultArr[i]) == 7){
                			showResult = showResult +  '已办理营业执照注销;';
                		}else if(parseInt(scResultArr[i]) == 8){
                			showResult = showResult +  '被吊销营业执照;';
                		}else if(parseInt(scResultArr[i]) == 9){
                			showResult = showResult +  '被撤销登记;';
                		}else{
                			showResult = showResult +  "正常（符合信息公示相关规定）;";
                		}
                	}

                	return showResult;

                });
                var myTemplate = handlebars.compile($('#table-template-pubscresult').html());
                if(typeof itemCount!='undefined' &&itemCount>0) $('#table-pubscresult').html(myTemplate(data));
                $("#_total_pubscresult").text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $("#_pageNum_pubscresult").text(pageNum);//共多少页
            }
        });

    }
    
    function pageCaseCallback(page,jq){//翻页事件
  	  initCaseTable(page+1);
    } 
})