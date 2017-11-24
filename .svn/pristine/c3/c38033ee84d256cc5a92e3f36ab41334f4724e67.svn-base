require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars',
    'component/paginationPage',
    'jquery','jquery.serialize','laydate','pagination','component/backToTop'], function (layer, dataTable, util, http, handlebars,paginationPage) {
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
    	if(entTypeCatg==11||entTypeCatg==33||entTypeCatg==21||entTypeCatg==27){
    		initDataTable_midliquidation();//清算信息
    	}
		if(window._CONFIG.pageType!='print'){
			initDataTable_yrinfo();
		}else{
            initDataTable_licenseinfo();//行政许可
            initDataTable_punishinfo();//行政处罚
            initDataTable_abnormalinfo();//异常经营名录
           // initDataTable_illegalinfo();//严重违法
        }

		//年报信息
    	initDataTable_pubscresult();//抽查检查结果信息
    	initDataTable_tmDetailInfo();//商标注册信息
    	bind();
    }
    
    var table;
    
    //股东信息
    function initDataTable_midinv_stock(){
		if(window._CONFIG.pageType=='print'){
			loadData_midinv_stock(0,9999);
		}else{
			loadData_midinv_stock(0,5);
		}
    }
    function loadData_midinv_stock(page, length, callback) {
        var params = $('#params').serializeObject();//查询参数
        http.httpRequest({
            url: '/midinv/list.json',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
            	var estDate = $("#estDate").val();
            	var invEnd = $("#invEnd").val();
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
                    } else if(data.invType == 2){
                	   return '自然人';
                    } else if(data.invType == 3){
                	   return '其他股东';
                    } else{
                    	return "";
                    }
                });
                handlebars.registerHelper("inv_tans", function(data) {
                    return data.inv;
                });
                handlebars.registerHelper("doType", function(data) {
                	if(data.invType == 1){
                		return "法人营业执照"
                    }else if(data.invType == 2){
                    	return data.cerTypeName;
                    }else if(data.invType == 3){
                    	return "其他";
                    }else{
                    	return "";
                    }
                });
                handlebars.registerHelper("doNO", function(data) {
                	if(data.invType == 1){
                		return data.uniSCID != null ? data.uniSCID : data.bLicNO;
                    }else if(data.invType == 2){
                    	return "( 非公示项 )";
                    }else if(data.invType == 3){
                    	return data.bLicNO;
                    }else{
                    	return "";
                    }
                });
                
                handlebars.registerHelper("isShow", function(data) {
                	if(estDate<invEnd){
                		return "<a href='javascript:void(0);' class='js-gudong-view'>查看</a>";
                	}else{
                		return "";
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
		if(window._CONFIG.pageType=='print'){
			loadData_midaltitem(0,9999);
		}else loadData_midaltitem(0,5);
    }
    function loadData_midaltitem(page, length, callback) {
        var params = $('#altitem_params').serializeObject();//查询参数
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
	                	if(value!=""&&value!=null){
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
                if(total>16){
                	$("#mainmember").show();
                }
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
                if(total>0){
                	$("#mainmember").show();
                }
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
    	var priPID = $("#priPID").val();
    	http.httpRequest({
            url: '/midbranch/list.json',
            serializable: false,
            data: {priPID:priPID},
            type: 'post',
            success: function (data) {
            	if(data.length>9){
            		$("#entbranch").show();
            	}
            	$("#midbranch").text("共计"+data.length+"条信息");
            	var jointHtml="";
            	for(var i=0;i<data.length;i++){
            		var entName = data[i].entName;
            		var regNO = data[i].regNO;
            		var regOrgName = data[i].regOrgName;
            		if(entName==null){
            			entName="";
            		}
            		if(regNO==null){
            			regNO="";
            		}
            		if(regOrgName==null){
            			regOrgName="";
            		}
        			jointHtml = jointHtml+"<div class='item item2'> <div class='title'>"+entName+"</div> <p>· 统一社会信用代码/注册号："+regNO+"</p> <p>· 登记机关："+regOrgName+"</p> </div> "
        			if(i==8&&window._CONFIG.pageType!='print'){
        				break;
        			}
            	}
            	$(".branch").append(jointHtml);
            }
        });
    }

    //清算信息
    function initDataTable_midliquidation(flag){
    	var priPID = $("#priPID").val();
    	http.httpRequest({
            url: '/midliquidation/get.json',
            serializable: false,
            data: {priPID:priPID},
            type: 'post',
            success: function (data) {
            	$("#ligPrincipal").html(data.ligPrincipal);
            	var liqMem = data.liqMem;
            	var liqMemArr;
            	if(liqMem != null && liqMem != ""){
            		liqMemArr = liqMem.split("、");
            		var length = liqMemArr.length;
            		var jointHtml="";

            		for(var i=0;i<length;i++){
            			jointHtml=jointHtml+"<td>"+liqMemArr[i]+"</td>";
            			if(i==3&&window._CONFIG.pageType!='print'){
            				break;
            			}
            		}
            		$("#liqMem").append(jointHtml);

            		var html = "";
            		for(i=1;i<length/4;i++){
            			var trhtml="<tr>";
                		var tdhtml="";
        				$(".ligmember").attr("rowspan",i+1);

        				for(var j=0;j<4;j++){
        					if(liqMemArr[4*i+j]!=undefined){
        						tdhtml = tdhtml+"<td>"+liqMemArr[4*i+j]+"</td>";
        					}
        				}
        				trhtml=trhtml+tdhtml+"</tr>";
        				html = html+trhtml;
            		}
            		$(".tbody-qingsuan").append(html);
            	}else{
            		$("#liqMem").append("<td>&nbsp;</td>");
            	}
            }
        });
    };

    //年报信息
    function initDataTable_yrinfo(){
        loadData_yrinfo(0,5);
    }
    function loadData_yrinfo(page, length, callback) {
        var params = $('#params').serializeObject();//查询参数
        var entTypeCatg = $('#entTypeCatg').val();
        var url;
        if(entTypeCatg==50){//个体户
        	url = "/entinfo/pblist.json";
        }else if(entTypeCatg==16||entTypeCatg==17){//农专
        	url = "/entinfo/sfclist.json";
        }else{
        	url = "/entinfo/list.json";
        }
        http.httpRequest({
            url: url,
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#pagination_yrinfo').pagination(itemCount, {
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
                handlebars.registerHelper("transAncheDate",
                    function(value) {
	                	if(value!=""&&value!=null){
	                		var date=value.substring(0,10).split("-");
	                		return date[0]+"年"+date[1]+"月"+date[2]+"日";
	                	}
                    }
                );

                handlebars.registerHelper("transType",
                   function(value) {
                	  var text;
                      if(value=="6"){
                    	 text = "该个体户已接收纸质年报";
                      }else{
                    	 text = '<a href="javascript:void(0)" class="js-yrinfo">查看</a>';
                      }
                      return text;
                   }
                );

                var myTemplate = handlebars.compile($('#table-template-yrinfo').html());
                if(typeof itemCount!='undefined' &&itemCount>0) $('#table-yrinfo').html(myTemplate(data));
                $("#_total_yrinfo").text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $("#_pageNum_yrinfo").text(pageNum);//共多少页
            }
        });
    }
    //严重违法
    function initDataTable_illegalinfo() {
        loadData_punishinfo(0,99999);
    }
    function loadData_illegalinfo(page, length, callback) {
        var options = {
            page:0,                                     //开始页
            length:5,                                   //长度
            items_per_page:5,                           //每页显示几条              默认10条
            params:$('#_params').serializeObject(),     //查询参数,                 必填项
            url:'/pub/pubotherpunish/list.json',    //url 访问路径              必填项
            type:'post',                                //请求方式
            pagination:'#pagination',                   //分页显示的位置             必填项
            myTemplate:'punish-table-template',               //script:模板路径           必填项
            html:'#punish_listData',                          //需要渲染的html            必填项
            total:'#_total',                            //显示页面总数的位置         必填项
            pageNmber:'#_pageNum' ,                     //显示多少页的位置           必填项
            isUseNOdata:'true'
        };
        paginationPage.loadData(options);
        var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*10);});//序号
        handlebars.registerHelper("penDecIssDate", function(penDecIssDate) {
            return util.dateFormat(new Date(penDecIssDate),"yy年mm月dd日");
        });
        handlebars.registerHelper("auditDate", function(auditDate) {
            return util.dateFormat(new Date(auditDate),"yy年mm月dd日");
        });
        handlebars.registerHelper("altDate", function(altDate) {
            return util.dateFormat(new Date(altDate),"yy年mm月dd日");
        });
        handlebars.registerHelper("addOne", function(index) {return index+1;});//序号
        handlebars.registerHelper("dataList", function(dataList) {
            if(dataList == null || dataList == ""){
                return "display:none";
            }else{
                return "";
            }
        });
    }
    //异常经营名录
    function initDataTable_abnormalinfo() {
        loadData_abnormalinfo(0,99999);
    }
    function loadData_abnormalinfo(page, length, callback) {
        var type = window._CONFIG.entTypeCatg == '50' ? 'pbopanomaly' : 'opanomaly';

        var options = {
            page:0,                                     //开始页
            length:5,                                   //长度
            items_per_page:5,                           //每页显示几条              默认10条
            params:$('#params').serializeObject(),     //查询参数,                 必填项
            url:'/pub/client/pub' + type + '/list/list.json',    //url 访问路径              必填项
            type:'post',                                //请求方式
            pagination:'#pagination',                   //分页显示的位置             必填项
            myTemplate:'#pbopanomaly-table-template',               //script:模板路径           必填项
            html:'#pbopanomaly_listData',                          //需要渲染的html            必填项
            total:'#_total',                            //显示页面总数的位置         必填项
            pageNmber:'#_pageNum' ,                     //显示多少页的位置           必填项
            isUseNOdata:'true'
        };
        paginationPage.loadData(options);
        var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*10);});//序号
        handlebars.registerHelper("abnTime", function(abnTime) {
            return util.dateFormat(new Date(abnTime),"yy年mm月dd日");
        });
        handlebars.registerHelper("remDate", function(remDate) {
            if(remDate != null) {
                return util.dateFormat(new Date(remDate),"yy年mm月dd日");
            }else{
                return "";
            }
        });
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
    //行政处罚
    function initDataTable_punishinfo() {
        loadData_punishinfo(0,99999);
    }
    function loadData_punishinfo(page, length, callback) {
        var options = {
            page:0,                                     //开始页
            length:5,                                   //长度
            items_per_page:5,                           //每页显示几条              默认10条
            params:$('#_params').serializeObject(),     //查询参数,                 必填项
            url:'/pub/pubotherpunish/list.json',    //url 访问路径              必填项
            type:'post',                                //请求方式
            pagination:'#pagination',                   //分页显示的位置             必填项
            myTemplate:'#punish-table-template',               //script:模板路径           必填项
            html:'#punish_listData',                          //需要渲染的html            必填项
            total:'#_total',                            //显示页面总数的位置         必填项
            pageNmber:'#_pageNum' ,                     //显示多少页的位置           必填项
            isUseNOdata:'true'
        };
        paginationPage.loadData(options);
        var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*10);});//序号
        handlebars.registerHelper("penDecIssDate", function(penDecIssDate) {
            return util.dateFormat(new Date(penDecIssDate),"yy年mm月dd日");
        });
        handlebars.registerHelper("auditDate", function(auditDate) {
            return util.dateFormat(new Date(auditDate),"yy年mm月dd日");
        });
        handlebars.registerHelper("altDate", function(altDate) {
            return util.dateFormat(new Date(altDate),"yy年mm月dd日");
        });
        handlebars.registerHelper("addOne", function(index) {return index+1;});//序号
        handlebars.registerHelper("dataList", function(dataList) {
            if(dataList == null || dataList == ""){
                return "display:none";
            }else{
                return "";
            }
        });
    }

//行政许可
    function initDataTable_licenseinfo() {
        loadData_licenseinfo(0,99999);
    }
    function loadData_licenseinfo(page, length, callback) {
        var options = {
            page:0,                                     //开始页
            length:5,                                   //长度
            items_per_page:5,                           //每页显示几条              默认10条
            params:$('#_params').serializeObject(),     //查询参数,                 必填项
            url:'/pub/pubohterlicence/list_data',    //url 访问路径              必填项
            type:'post',                                //请求方式
            pagination:'#pagination',                   //分页显示的位置             必填项
            myTemplate:'#table-template-licenseinfo',               //script:模板路径           必填项
            html:'#licenseinfo_listData',                          //需要渲染的html            必填项
            total:'#_total',                            //显示页面总数的位置         必填项
            pageNmber:'#_pageNum' ,                     //显示多少页的位置           必填项
            isUseNOdata:'true'
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

                handlebars.registerHelper("transCheckDate",
                        function(value) {
    	                	if(value){
    	                		value=value.substring(0,10);
    	                		var date=value.split("-");
    	                		return date[0]+"年"+date[1]+"月"+date[2]+"日";
    	                	}
                        }
                    );
                handlebars.registerHelper("transScType",function(value) {
    	                	if(value == '抽查历史'){
    	                		return '抽查';
    	                	}else{
    	                		return value;
    	                	}
                        }
                    );
                handlebars.registerHelper("transCN", function(data1,data2) {
                	var scResults = data1;
                	if(data1==""||data1==null){
                		return "";
                	}
                	if(data2=='检查'){
                		return data1;
                	}
                	if(data2=="抽查历史"){
                		var scResultArr = scResults.split(",");
                    	var showResult = "";
                    	for(var i=0;i<scResultArr.length;i++){
                    		if(parseInt(scResultArr[i]) == 1){
                    			showResult = showResult + '未发现违法行为;';
                    		}else if(parseInt(scResultArr[i]) == 2){
                    			showResult = showResult.replace("违反工商行政管理相关规定；","");
                    			showResult = showResult + '违反工商行政管理相关规定；';
                    		}else if(parseInt(scResultArr[i]) == 3){
                    			showResult = showResult.replace("违反工商行政管理相关规定；","");
                    			showResult = showResult + '违反工商行政管理相关规定；';
                    		}else if(parseInt(scResultArr[i]) == 4){
                    			showResult = showResult + '查无下落;';
                    		}else if(parseInt(scResultArr[i]) == 5){
                    			showResult = showResult.replace("违反工商行政管理相关规定；","");
                    			showResult = showResult + '违反工商行政管理相关规定；';
                    		}else if(parseInt(scResultArr[i]) == 6){
                    			showResult = showResult +  '不予配合情节严重；';
                    		}else if(parseInt(scResultArr[i]) == 7){
                    			showResult = showResult +  '注销；';
                    		}else if(parseInt(scResultArr[i]) == 8){
                    			showResult = showResult +  '被吊销；';
                    		}else if(parseInt(scResultArr[i]) == 9){
                    			showResult = showResult +  '被撤销；';
                    		}
                    	}
                    	return showResult;
                	}
                	var scResultArr = scResults.split(",");
                	var showResult = "";
                	for(var i=0;i<scResultArr.length;i++){
                		if(parseInt(scResultArr[i]) == 1){
//                			showResult = showResult + '未发现违法行为;';
                			showResult = showResult + '未发现问题；';
//                		}else if(parseInt(scResultArr[i]) == 2){
//                			showResult = showResult + '违反工商行政管理相关规定；';
                		}else if(parseInt(scResultArr[i]) == 3){
                			showResult = showResult + '违反食品药品管理相关规定；';
                		}else if(parseInt(scResultArr[i]) == 4){
                			showResult = showResult + '违反质量技术监督相关规定；';
                		}else if(parseInt(scResultArr[i]) == 5){
                			showResult = showResult + '违反其他部门相关规定；';
                		}else if(parseInt(scResultArr[i]) == 6){
                			showResult = showResult +  '通过登记的住所（经营场所）无法联系；';
//                			showResult = showResult +  '查无下落;';
                		}else if(parseInt(scResultArr[i]) == 7){
                			showResult = showResult +  '已关闭停业或正在组织清算；';
                		}else if(parseInt(scResultArr[i]) == 8){
                			showResult = showResult +  '不配合检查情节严重；';
//                			showResult = showResult +  '不予配合情节严重;';
                		}else if(parseInt(scResultArr[i]) == 9){
                			showResult = showResult +  '注销；';
                		}else if(parseInt(scResultArr[i]) == 10){
                			showResult = showResult +  '被吊销；';
                		}else if(parseInt(scResultArr[i]) == 11){
                			showResult = showResult +  '被撤销；';
                		}else if(parseInt(scResultArr[i]) == 12){
                			showResult = showResult +  '迁出；';
//                		}else if(scResultArr[i] == "A"){
//                			showResult = showResult +  '发现问题待后续处理；';
                		}else if(scResultArr[i] == "B"){
                			showResult = showResult +  '未按规定公示应当公示的信息；';
                		}else if(scResultArr[i] == "C"){
                			showResult = showResult +  '公示信息隐瞒真实情况弄虚作假；';
                		}else if(scResultArr[i] == "D"){
                			showResult = showResult +  '违反其他工商行政管理规定行为；';
                		}else if(scResultArr[i] == "E"){
                			showResult = showResult +  '发现问题经责令已改正；';
                		}else if(scResultArr[i] == "F"){
                			showResult = showResult +  '未发现开展本次抽查涉及的经营活动；';
                		}else if(scResultArr[i] == "G"){
                			showResult = showResult +  '违反公安部门相关规定；';
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

    //商标注册信息
    function initDataTable_tmDetailInfo(){
    	var priPID = $("#priPID").val();
//    	var priPID = "3300006000006451";
    	http.httpRequest({
            url: '/tmDetailInfo/list.json',
            serializable: false,
            data: {priPID:priPID},
            type: 'post',
            success: function (data) {
                if(typeof (data.length) =='undefined')
                $("#midbrand").text("共计0条信息");
            	var jointHtml="";
            	if(data.length>0){
                	$("#mainbrand").show();
                	$("#midbrand").text("共计"+data.length+"条信息");
                	for(var i=0;i<data.length;i++){
                		var regnum = data[i].reg_NUM;
                		if(regnum==null||regnum==undefined){
                			regnum="--";
                		}
                		var intcls = data[i].int_CLS;
                		if(intcls==null||intcls==undefined){
                			intcls="--";
                		}
                		var tmimage = data[i].tm_IMAGE;
                		if(tmimage==null||tmimage==undefined){
                			tmimage="";
                		}
                		var reganncdate = data[i].REG_ANNC_DATE;
                		if(reganncdate==null||reganncdate==undefined){
                			reganncdate="--";
                		}               		
                		

                		var enRegnum = data[i].enRegNum;//加密商标注册号

                		var  url = '/tmDetailInfo/listDetail?enregnum='+enRegnum

//                		<div class="item item3">
//            			<div class="pic"><img src="/img/pub/nike.png"></div>
//            			<p>商标注册号：87423</p>
//            			<p>类别：第25类</p>
//            			<p>注册公告日期：2014年5月1日</p>
//            			<p><a href="javascript:void(0);" class="fr a-orange">&lt;&lt;查看详情&gt;&gt;</a></p>
//            		</div>
                		jointHtml = jointHtml+"<div class='item item3'><div class='pic'>"+"<img src='data:image/png;base64,"+tmimage+"' height='125px'>"+"</div><p> 商标注册号："+regnum+"</p><p> 类别：第"+intcls+"类</p><p>注册公告日期："+reganncdate+"</p><p>";
						if(window._CONFIG.pageType!='print') {
							jointHtml+="<a target='_blank' href='" + url + "' class='fr a-orange'>&lt;&lt;查看详情&gt;&gt;</a>" ;
						}

						jointHtml+="</p></div>"
                		if(i==5){
                			break;
                		}
                	}
                	$(".brand").append(jointHtml);
            	}
            }
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
	      //  打印事件
			,
			{
				el: '#print-icon',
				event: 'click',
				handler: function() {
					
					var encryPriPID=$("#encryPriPID").val();
					window.open("/midbranch/toinfoprint?encryPriPID="+encryPriPID);
				}
			},{
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
