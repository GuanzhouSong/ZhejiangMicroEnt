require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars',
    'component/paginationPage',
    'jquery','jquery.serialize','laydate','pagination'], function (layer, dataTable, util, http, handlebars,paginationPage) {
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	var entTypeCatg = $("#entTypeCatg").val();
    	if(entTypeCatg==11||entTypeCatg==31||entTypeCatg==21||entTypeCatg==13||entTypeCatg==33||entTypeCatg==27){
    		initDataTable_midinv_stock();//股东信息
    	}
    	initDataTable_midaltitem();//变更信息
		if(entTypeCatg==11||entTypeCatg==21||entTypeCatg==50){
    		initDataTable_midmember();//主要人员信息
    	}
    	if(entTypeCatg==16){
    		initDataTable_memberinv();//农专成员名册
    	}
    	if(entTypeCatg==11||entTypeCatg==33||entTypeCatg==31||entTypeCatg==21||entTypeCatg==27){
    		initDataTable_midbranch();//分支机构信息
    	}
		
    	initDataTable_licenseinfo();//行政许可
    	bind();
    }
    
    var table;
    
    //股东信息
    function initDataTable_midinv_stock(){
		loadData_midinv_stock(0,5);
    }
    function loadData_midinv_stock(page, length, callback) {
        var params = $('#params').serializeObject();//查询参数
        http.httpRequest({
            url: '/midinv/list.json',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#pagination_midinv_stock').pagination(itemCount, {
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
                    	loadData_midinv_stock(page,5);
                    }
                });
				var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*5);});//序号
                handlebars.registerHelper("doInvType", function(data) {
            	    if(data.invType == 1){
                	   return '企业法人';
                    }else{
                	   return '自然人';
                    } 
                });
                handlebars.registerHelper("doType", function(data) {
                	if(data.invType == 1){
                		if(data.bLicType == 1){
                			return "法人营业执照"
                		}else{
                			return "";
                		}
                    }else{
                    	return data.cerTypeName;
                    }
                });
                handlebars.registerHelper("doNO", function(data) {
                	if(data.invType == 1){
                  	   return data.bLicNO;
                    }else{
                  	   return "( 非公示项 )";
                    }
                });
                
                var myTemplate = handlebars.compile($('#table-template-midinv_stock').html());
                if(typeof itemCount!='undefined' &&itemCount>0) $('#table-midinv_stock').html(myTemplate(data));
                $("#_total_midinv_stock").text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $("#_pageNum_midinv_stock").text(pageNum);//共多少页
            }
        });
    }

    //变更信息
    function initDataTable_midaltitem(){
		loadData_midaltitem(0,5);
    }
    function loadData_midaltitem(page, length, callback) {
        var params = $('#params').serializeObject();//查询参数
        http.httpRequest({
            url: '/midaltitem/list.json',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#pagination_midaltitem').pagination(itemCount, {
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
                    	loadData_midaltitem(page,5);
                    }
                });
                var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*5);});//序号
                handlebars.registerHelper("transAltDate",
                    function(value) {
	                	if(value!=""){
	                		var date=value.split("-");
	                		return date[0]+"年"+date[1]+"月"+date[2]+"日";
	                	}
                    }
                );
                handlebars.registerHelper("subAltBeContent",
                    function(value) {
	                	if(value){
	                		if(value.length>100){
	                			return value.substring(0,100)+" ......";
	                		}else{
	                			return value;
	                		}
	                	}else{
	                		return "";
	                	}
                    }
                );
                handlebars.registerHelper("subAltAfContent",
            		function(value) {
	                	if(value){
	                		if(value.length>100){
	                			return value.substring(0,100)+" ......";
	                		}else{
	                			return value;
	                		}
	                	}else{
	                		return "";
	                	}
	                }
                );
                var myTemplate = handlebars.compile($('#table-template-midaltitem').html());
                if(typeof itemCount!='undefined' &&itemCount>0) $('#table-midaltitem').html(myTemplate(data));
             /*
                if(typeof itemCount=='undefined' ||itemCount==0){
                     // $('#table-midaltitem').html(' <tr><td colspan="5"><div class="no-con">暂无变更信息 </div></td></tr>');
                }else{
                    $('#table-midaltitem').html(myTemplate(data));
                }*/
                $("#_total_midaltitem").text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $("#_pageNum_midaltitem").text(pageNum);//共多少页
            }
        });
    }

    //主要人员信息
    function initDataTable_midmember(){
    	var priPID = $("#priPID").val();
    	http.httpRequest({
            url: '/midmember/list.json',
            serializable: false,
            data: {priPID:priPID},
            type: 'post',
            success: function (data) {
                var total=0;
                if(typeof (data.length) !='undefined') total=data.length;
                $("#member").text("共计"+total+"条信息");
            	var jointHtml="";
            	for(var i=0;i<data.length;i++){
            		var name = data[i].name;
            		if(name==null||name==undefined){
            			name="";
            		}
            		if(name.length>5){
            			name="<a style='color:#000' href='javascript:void(0)' title='"+name+"'>"+name.substring(0,5)+"...</a>"
            		}
            		var posiContent = data[i].posiContent;
            		if(posiContent==null||posiContent==undefined){
            			posiContent="";
            		}
            		if(posiContent.length>7){
            			posiContent="<a style='color:#666' href='javascript:void(0)' title='"+posiContent+"'>"+posiContent.substring(0,7)+"...</a>"
            		}
            		jointHtml = jointHtml+"<div class='item'><span>"+name+"</span><span class='manager'>"+posiContent+"</span></div> "
            		if(i==15&&window._CONFIG.pageType!='print'){
            			break;
            		}
            	}
            	$(".member").append(jointHtml);
            }
        });
    }

    //农专成员名册
    function initDataTable_memberinv(){
    	var priPID = $("#priPID").val();
    	http.httpRequest({
            url: '/midinv/sfclist.json',
            serializable: false,
            data: {priPID:priPID},
            type: 'post',
            success: function (data) {
                var total=0;
                if(typeof (data.length) !='undefined') total=data.length;
                $("#memberinv").text("共计"+total+"条信息");
            	var jointHtml="";
            	for(var i=0;i<data.length;i++){
            		var name = data[i].inv;
            		if(name==null||name==""){
            			name="";
            		}
            		if(name.length>5){
            			name="<a style='color:#000' href='javascript:void(0)' title='"+name+"'>"+name.substring(0,5)+"...</a>"
            		}
            		jointHtml = jointHtml+"<div class='item'><span>"+name+"</span></div> "
            		if(i==13&&window._CONFIG.pageType!='print'){
            			break;
            		}
            	}
            	$(".memberinv").append(jointHtml);
            }
        });
    }

    //分支机构信息
    function initDataTable_midbranch(){
		loadData_midbranch(0,5);
    }
    function loadData_midbranch(page, length, callback) {
        var params = $('#params').serializeObject();//查询参数
        http.httpRequest({
            url: '/midbranch/synlist.json',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#pagination_midbranch').pagination(itemCount, {
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
                    	loadData_midbranch(page,5);
                    }
                });
                var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*5);});//序号
                var myTemplate = handlebars.compile($('#table-template-midbranch').html());
                if(typeof itemCount!='undefined' &&itemCount>0) $('#table-midbranch').html(myTemplate(data));
                $("#_total_midbranch").text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $("#_pageNum_midbranch").text(pageNum);//共多少页
            }
        });
    }

  //行政许可
    function initDataTable_licenseinfo() {
        loadData_licenseinfo(0,5);
    }
    function loadData_licenseinfo(page, length, callback) {
    	var options = {
                page:0,                                     //开始页
                length:5,                                   //长度
                items_per_page:5,                           //每页显示几条              默认10条
                params:$('#params').serializeObject(),     //查询参数,                 必填项
                url:'/pub/pubohterlicence/list_data',    //url 访问路径              必填项
                type:'post',                                //请求方式
                pagination:'#pagination',                   //分页显示的位置             必填项
                myTemplate:'#table-template',               //script:模板路径           必填项
                html:'#_listData',                          //需要渲染的html            必填项
                total:'#_total',                            //显示页面总数的位置         必填项
                pageNmber:'#_pageNum'                      //显示多少页的位置           必填项
        };
        paginationPage.loadData(options);
        var handleHelper = handlebars.registerHelper("addOne", function(index) {return index+1;});//序号
        handlebars.registerHelper("altDate", function(altDate) {
        	return util.dateFormat(new Date(altDate),"yy年mm月dd日");
    	});
        handlebars.registerHelper("dataList", function(dataList) {
                 if(dataList == null || dataList == ""){
                	 return "display:none";
                 }else{
                	 return "";
                 }
        });
        handlebars.registerHelper("licValFrom", function(licValFrom) {
        	return util.dateFormat(new Date(licValFrom),"yy年mm月dd日");
    	});
        handlebars.registerHelper("licValTo", function(licValTo) {
        	return util.dateFormat(new Date(licValTo),"yy年mm月dd日");
    	});
    }
    
    function bind() {
        util.bindEvents([
	        {
	            el: '#mainmember',
	            event: 'click',
	            handler: function() {
	            	var encryPriPID=$("#encryPriPID").val();
	        		window.open("/midmember/list?encryPriPID="+encryPriPID);
	            }
	        }
	      ,{
	            el: '#entbranch',
	            event: 'click',
	            handler: function() {
	            	var encryPriPID=$("#encryPriPID").val();
	        		window.open("/midbranch/list?encryPriPID="+encryPriPID);
	            }
	        },{
	            el: '#mainbrand',
	            event: 'click',
	            handler: function() {
	            	var encryPriPID=$("#encryPriPID").val();
	        		window.open("/tmDetailInfo/list?encryPriPID="+encryPriPID);
	            }
	        }
        ])
    }

    
})
