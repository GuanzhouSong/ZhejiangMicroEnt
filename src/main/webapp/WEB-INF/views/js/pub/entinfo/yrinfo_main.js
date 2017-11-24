require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','pagination'], function (layer, dataTable, util, http, handlebars) {


    if( typeof(window._CONFIG) != "undefined" && window._CONFIG.pageType=='print'){
        var yearstr = window._CONFIG.yearStr;
        var _year = yearstr.split(",");
        if(_year.length>0){
            for (var i=0;i<_year.length;i++){
                if(_year!='')
                init(_year[i]);
            }
        }
    }else{
        init();
    }

    /**
     * 初始化函数集合
     */
    function init(_year) {
        if(typeof _year =='undefined'){
            _year='';
        }
    	var entTypeCatg = $("#entTypeCatg").val();
    	if(entTypeCatg==16||entTypeCatg==17){
            initDataTable_sfc_licenceinfo(_year);//农专年报行政许可
            initDataTable_sfc_websiteinfo(_year);//农专网站或网店信息
            initDataTable_sfc_branchinfo(_year);//农专分支机构信息
            if(window._CONFIG.pageType!='print') initDataTable_sfc_updateinfo();//农专年报修改
    	}else if(entTypeCatg==50){
            initDataTable_pb_licenceinfo(_year);//个体户年报行政许可
            initDataTable_pb_websiteinfo(_year);//个体户网站或网店信息
            if(window._CONFIG.pageType!='print') initDataTable_pb_updateinfo();//个体户年报修改
    	}else{
    		var repType
            if(window._CONFIG.pageType!='print'){
                repType = window._CONFIG.repType;
            }else{
                repType=$('#'+_year+'repYearType').val();
            }
    		initDataTable_website(_year);//网站或网店信息
    		if (repType.indexOf("subcapital") != -1) {
    			 initDataTable_inv(_year);//股东及出资信息
    		}
    		if (repType.indexOf("forinvestment") != -1) {
    			initDataTable_forinvestment(_year);//对外投资信息
    		}
    		initDataTable_forguaranteeinfo(_year);//对外提供保证担保信息
    		if (repType.indexOf("alterstockinfo") != -1) {
    			initDataTable_alterstockinfo(_year);//股权变更信息
    		}
            if(window._CONFIG.pageType!='print') initDataTable_updateinfo();//修改信息
    	}

    }

    var table;

    //网站或网店信息
    function initDataTable_website(_year){

        var params = $('#'+_year+'params').serializeObject();//查询参数
    
    	http.httpRequest({
            url: '/pub/WebsiteInfo/publist.json',
            serializable: false,
            data: params,
            type: 'post',
            success: function (data) {
            	$('#'+_year+'website').text("共计"+data.length+"条信息");
            	$('#'+_year+'websitelight').text("共计"+data.length+"条信息");
            	var jointHtml="";
            	for(var i=0;i<data.length;i++){
            		var webSite = data[i].webSite;//网址
            		var webType = data[i].webType;//网站类型
            		var webTypeName;
            		if(webType == '1'){
            			webTypeName = "网站";
            		}else{
            			webTypeName = "网店";
            		}
            		var webSitName = data[i].webSitName;//网站名称
        			jointHtml = jointHtml+"<div class='item item2'> <div class='title'>"+webSitName+"</div> <p>· 类型："+webTypeName+"</p> <p>· 网址："+webSite+"</p> </div> "
            	}

            	$("."+_year+"website").append(jointHtml);
            }
        });
    }

    //股东及出资信息
    function initDataTable_inv(_year){
        loadData_inv(0,5,_year);
    }
    function loadData_inv(page, length, _year) {
        if(window._CONFIG.pageType=='print'){
            length=9999;
        }
        var params = $('#'+_year+'params').serializeObject();//查询参数

        http.httpRequest({
            url: '/pub/subcapitalInfo/publist.json',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#'+_year+'pagination_inv').pagination(itemCount, {
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
                    	loadData_inv(page,5,_year);
                    }
                });
                var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*5);});//序号
                handlebars.registerHelper("inv", function(data) {
//                	var ifHight = $("#ifHight").val();
//					if (data.altItem != "undefined" && data.altItem != null
//							&& data.altItem.indexOf("inv") > -1
//							&& ifHight ==1) {
//						return '<font size="3" color="red">'+data.inv+'</font>';
//					} else {
						return data.inv;
//					}
                 });

                handlebars.registerHelper("lisubconam", function(data) {
//                	var ifHight = $("#ifHight").val();
//					if (data.altItem != "undefined" && data.altItem != null
//							&& data.altItem.indexOf("lisubconam") > -1
//							&& ifHight ==1) {
//						return '<font size="3" color="red">'+data.lisubconam+'</font>';
//					} else {
						return data.lisubconam;
//					}
                 });

                handlebars.registerHelper("subConDate", function(data) {
                	var subConDate = data.subConDate;
                	if(subConDate!=null&&subConDate!=""){
                        var date=subConDate.split("-");
                        var fmtDate = date[0]+"年"+date[1]+"月"+date[2]+"日";

//	                	var ifHight = $("#ifHight").val();
//						if (data.altItem != "undefined" && data.altItem != null
//								&& data.altItem.indexOf("subConDate") > -1
//								&& ifHight ==1) {
//							return '<font size="3" color="red">'+fmtDate+'</font>';
//						} else {
							return fmtDate;
//						}
                	}
                 });

                handlebars.registerHelper("conFormCN", function(data) {
//                	var ifHight = $("#ifHight").val();
//					if (data.altItem != "undefined" && data.altItem != null
//							&& data.altItem.indexOf("conFormCN") > -1
//							&& ifHight ==1) {
//						return '<font size="3" color="red">'+data.conFormCN+'</font>';
//					} else {
						return data.conFormCN;
//					}
                 });

                handlebars.registerHelper("liacconam", function(data) {
//                	var ifHight = $("#ifHight").val();
//					if (data.altItem != "undefined" && data.altItem != null
//							&& data.altItem.indexOf("liacconam") > -1
//							&& ifHight ==1) {
//						return '<font size="3" color="red">'+data.liacconam+'</font>';
//					} else {
						return data.liacconam;
//					}
                 });

                handlebars.registerHelper("acConDate", function(data) {
                	var acConDate = data.acConDate;
                	if(acConDate!=null&&acConDate!=""){
                		var date=acConDate.split("-");
                        var fmtDate = date[0]+"年"+date[1]+"月"+date[2]+"日";

//                		var ifHight = $("#ifHight").val();
//                		if (data.altItem != "undefined" && data.altItem != null
//                				&& data.altItem.indexOf("acConDate") > -1
//                				&& ifHight ==1) {
//                			return '<font size="3" color="red">'+fmtDate+'</font>';
//                		} else {
                			return fmtDate;
//                		}
                	}
                 });

                handlebars.registerHelper("acConFormCn", function(data) {
//                	var ifHight = $("#ifHight").val();
//					if (data.altItem != "undefined" && data.altItem != null
//							&& data.altItem.indexOf("acConFormCn") > -1
//							&& ifHight ==1) {
//						return '<font size="3" color="red">'+data.acConFormCn+'</font>';
//					} else {
						return data.acConFormCn;
//					}
                 });
                
                var myTemplate = handlebars.compile($('#'+_year+'table-template-inv').html());
                if(typeof itemCount!='undefined' &&itemCount>0) $('#'+_year+'table-inv').html(myTemplate(data));
                $('#'+_year+'_total_inv').text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $('#'+_year+'_pageNum_inv').text(pageNum);//共多少页
            }
        });
    };

    //对外投资信息
    function initDataTable_forinvestment(_year){
        var params = $('#'+_year+'params').serializeObject();//查询参数
    	http.httpRequest({
            url: '/pub/forinvestMentInfo/publist.json',
            serializable: false,
            data: params,
            type: 'post',
            success: function (data) {
            	$('#'+_year+'yrforinvestment').text("共计"+data.length+"条信息");
            	var jointHtml="";
            	for(var i=0;i<data.length;i++){
            		var entName = data[i].entName;//企业名称
            		var uniCode = data[i].uniCode;//统一代码
            		if(uniCode==null){
            			uniCode="";
            		}
        			jointHtml = jointHtml+"<div class='item item2'> <div class='title'>"+entName+"</div> <p>· 统一社会信用代码/注册号："+uniCode+"</p> </div> "
            	}
            	$("."+_year+"forinvestment").append(jointHtml);
            }
        });
    }

    //对外提供保证担保信息
    function initDataTable_forguaranteeinfo(_year){
        loadData_forguaranteeinfo(0,5,_year);
    };
    function loadData_forguaranteeinfo(page, length, _year) {
        if(window._CONFIG.pageType=='print'){
            length=9999;
        }
        var params = $('#'+_year+'params').serializeObject();//查询参数
        http.httpRequest({
            url: '/pub/GuaranteeInfo/publist.json',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#'+_year+'pagination_forguaranteeinfo').pagination(itemCount, {
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
                    	loadData_forguaranteeinfo(page,5,_year);
                    }
                });
                var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*5);});//序号
                handlebars.registerHelper("more", function(data) {
//                	var ifHight = $("#ifHight").val();
//					if (data.altItem != "undefined" && data.altItem != null
//							&& data.altItem.indexOf("more") > -1
//							&& ifHight ==1) {
//						return '<font size="3" color="red">'+data.more+'</font>';
//					} else {
						return data.more;
//					}
                 });

                handlebars.registerHelper("mortgagor", function(data) {
//                 	var ifHight = $("#ifHight").val();
// 					if (data.altItem != "undefined" && data.altItem != null
// 							&& data.altItem.indexOf("mortgagor") > -1
// 							&& ifHight ==1) {
// 						return '<font size="3" color="red">'+data.mortgagor+'</font>';
// 					} else {
 						return data.mortgagor;
// 					}
                  });

                handlebars.registerHelper("transKindCN", function(data) {
//                	var ifHight = $("#ifHight").val();
//					if (data.altItem != "undefined" && data.altItem != null
//							&& data.altItem.indexOf("transKind") > -1
//							&& ifHight ==1) {
//						if(data.priClaSecKind == 1){
//							    return '<font size="3" color="red">合同</font>';
//		                    }else{
//		                    	return '<font size="3" color="red">其他</font>';
//		                    }
//					} else {
						if(data.priClaSecKind == 1){
		                 	   return "合同";
		                    }else{
		                 	   return "其他";
		                    }
//					}
                 });

                handlebars.registerHelper("priClaSecAm", function(data) {
//                 	var ifHight = $("#ifHight").val();
// 					if (data.altItem != "undefined" && data.altItem != null
// 							&& data.altItem.indexOf("priClaSecAm") > -1
// 							&& ifHight ==1) {
// 						return '<font size="3" color="red">'+data.priClaSecAm+'万元</font>';
// 					} else {
 						return data.priClaSecAm+"万元";
// 					}
                  });

                handlebars.registerHelper("pefPerDate", function(data) {
                	var pefPerForm = data.pefPerForm;
                	var pefPerTo = data.pefPerTo;
                	var fmtDate1="";
                	var fmtDate2="";
                	if(pefPerForm!=null&&pefPerForm!=""){
                		var date=pefPerForm.split("-");
                        fmtDate1 = date[0]+"年"+date[1]+"月"+date[2]+"日";
                	}
                	if(pefPerTo!=null&&pefPerTo!=""){
                		var date=pefPerTo.split("-");
                        fmtDate2 = date[0]+"年"+date[1]+"月"+date[2]+"日";
                	}

//                 	var ifHight = $("#ifHight").val();
// 					if (data.altItem != "undefined" && data.altItem != null
// 							&& data.altItem.indexOf("pefPer") > -1
// 							&& ifHight ==1) {
// 						return '<font size="3" color="red">'+fmtDate1+'~'+fmtDate2+'</font>';
// 					} else {
 						return fmtDate1+'-'+fmtDate2;
// 					}

                  });

                handlebars.registerHelper("transTypeCN", function(data) {
//                	var ifHight = $("#ifHight").val();
//					if (data.altItem != "undefined" && data.altItem != null
//							&& data.altItem.indexOf("transType") > -1
//							&& ifHight ==1) {
//						return '<font size="3" color="red">'+data.transType+'</font>';
//
//						if(data.gaType == 1){
//		                 	   return '<font size="3" color="red">一般保证</font>';
//		                    }else if(data.gaType == 2){
//		                    	return '<font size="3" color="red">连带保证</font>';
//		                    }else{
//		                    	return '<font size="3" color="red">未约定</font>';
//		                    }
//					} else {
						if(data.gaType == 1){
		                 	   return "一般保证";
		                    }else if(data.gaType == 2){
		                    	return "连带保证";
		                    }else{
		                 	   return "未约定";
		                    }
//					}
                 });

                handlebars.registerHelper("guaPeriodCN", function(data) {
//                	var ifHight = $("#ifHight").val();
//					if (data.altItem != "undefined" && data.altItem != null
//							&& data.altItem.indexOf("guaPeriod") > -1
//							&& ifHight ==1) {
//						return '<font size="3" color="red">'+data.guaPeriod+'</font>';
//
//						 if(data.guaPeriod == 1){
//		                 	   return '<font size="3" color="red">期间</font>';
//		                    }else{
//		                       return '<font size="3" color="red">未约定</font>';
//		                    }
//					} else {
						 if(data.guaPeriod == 1){
		                 	   return "期间";
		                    }else{
		                 	   return "未约定";
		                    }
//					}
                 });
                var myTemplate = handlebars.compile($('#'+_year+'table-template-forguaranteeinfo').html());
                if(typeof itemCount!='undefined' &&itemCount>0) $('#'+_year+'table-forguaranteeinfo').html(myTemplate(data));
                $('#'+_year+'_total_forguaranteeinfo').text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $('#'+_year+'_pageNum_forguaranteeinfo').text(pageNum);//共多少页
            }
        });
    };

    //股权变更信息
    function initDataTable_alterstockinfo(_year){
        loadData_alterstockinfo(0,5,_year);
    };
    function loadData_alterstockinfo(page, length, _year) {
        if(window._CONFIG.pageType=='print'){
            length=9999;
        }
        var params = $('#'+_year+'params').serializeObject();//查询参数
        http.httpRequest({
            url: '/pub/alterStockInfo/publist.json',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#'+_year+'pagination_alterstockinfo').pagination(itemCount, {
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
                    	loadData_alterstockinfo(page,5,_year);
                    }
                });
                var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*5);});//序号

                handlebars.registerHelper("inv", function(data) {
//                 	var ifHight = $("#ifHight").val();
// 					if (data.altItem != "undefined" && data.altItem != null
// 							&& data.altItem.indexOf("inv") > -1 
// 							&& ifHight ==1) {
// 						return '<font size="3" color="red">'+data.inv+'</font>';
// 					} else {
 						return data.inv;
// 					}
                  });

                handlebars.registerHelper("beTransAmPr", function(data) {
//                 	var ifHight = $("#ifHight").val();
// 					if (data.altItem != "undefined" && data.altItem != null
// 							&& data.altItem.indexOf("beTransAmPr") > -1 
// 							&& ifHight ==1) {
// 						return '<font size="3" color="red">'+data.beTransAmPr+'%</font>';
// 					} else {
 						return data.beTransAmPr+"%";
// 					}
                  });

                handlebars.registerHelper("afTransAmPr", function(data) {
//                 	var ifHight = $("#ifHight").val();
// 					if (data.altItem != "undefined" && data.altItem != null
// 							&& data.altItem.indexOf("afTransAmPr") > -1 
// 							&& ifHight ==1) {
// 						return '<font size="3" color="red">'+data.afTransAmPr+'%</font>';
// 					} else {
 						return data.afTransAmPr+"%";
// 					}
                  });

                handlebars.registerHelper("altDate", function(data) {
                	var altDate = data.altDate;
                	var fmtDate="";
                	if(altDate!=null&&altDate!=""){
                		var date=altDate.split("-");
                        fmtDate = date[0]+"年"+date[1]+"月"+date[2]+"日";
                	}

//                 	var ifHight = $("#ifHight").val();
// 					if (data.altItem != "undefined" && data.altItem != null
// 							&& data.altItem.indexOf("altDate") > -1 
// 							&& ifHight ==1) {
// 						return '<font size="3" color="red">'+fmtDate+'</font>';
// 					} else {
 						return fmtDate;
// 					}
                  });

                var myTemplate = handlebars.compile($('#'+_year+'table-template-alterstockinfo').html());
                if(typeof itemCount!='undefined' &&itemCount>0) $('#'+_year+'table-alterstockinfo').html(myTemplate(data));
                $('#'+_year+'_total_alterstockinfo').text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $('#'+_year+'_pageNum_alterstockinfo').text(pageNum);//共多少页
            }
        });
    };

    //修改信息
    function initDataTable_updateinfo(){
        
        loadData_updateinfo(0,5);
    };
    function loadData_updateinfo(page, length) {
        var params = $('#params').serializeObject();//查询参数
        http.httpRequest({
            url: '/pub/updateinfo/publist.json',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#pagination_updateinfo').pagination(itemCount, {
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
                    	loadData_updateinfo(page,5);
                    }
                });
                var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*5);});//序号

                handlebars.registerHelper("transAltDate", function(value) {
                	if(value!=null&&value!=""){
                           var date=value.split("-");
                           return date[0]+"年"+date[1]+"月"+date[2]+"日";
                	}
                });

                handlebars.registerHelper("altBe", function(data) {
                	if(data.altBe =="undefined" || data.altBe == null ){
                		return "";
                	}
 					if (data.altBe.indexOf("CST") > -1 ||data.altBe.indexOf("GMT") > -1) {
 						var time = new Date(data.altBe);
 						var y = time.getFullYear();
 					    var m = time.getMonth() + 1;
 					    m = m < 10 ? ('0' + m) : m;
 					    var d = time.getDate();
 					    d = d < 10 ? ('0' + d) : d;
 						return y + '年' + m + '月' + d+"日";
 					} else if (data.altItem&&(data.altItem.toUpperCase().indexOf("ISPUB") > -1||data.altItem.indexOf("empNumDis")>-1)) {
 						if(data.altBe==1){
 							return '是';
 						}else{
 							return "否";
 						}
 					} else if (data.altItem&&data.altItem.toUpperCase().indexOf("WEBTYPE") > -1) {
 						if(data.altBe==1){
 							return '网站';
 						}else{
 							return "网店";
 						}
 					}else {
 						return data.altBe;
 					}
                 });

                handlebars.registerHelper("altAf", function(data) {
                    if(data.altAf =="undefined" || data.altAf == null ){
                		return "";
                	}
 					if (data.altAf.indexOf("CST") > -1 ||data.altAf.indexOf("GMT") > -1) {
 						var time = new Date(data.altAf);
 						var y = time.getFullYear();
 					    var m = time.getMonth() + 1;
 					    m = m < 10 ? ('0' + m) : m;
 					    var d = time.getDate();
 					    d = d < 10 ? ('0' + d) : d;
 					   return y + '年' + m + '月' + d+"日";
 					} else if (data.altItem&&(data.altItem.toUpperCase().indexOf("ISPUB") > -1||data.altItem.indexOf("empNumDis")>-1)) {
 						if(data.altAf==1){
 							return '是';
 						}else{
 							return "否";
 						}
 					} else if (data.altItem&&data.altItem.toUpperCase().indexOf("WEBTYPE") > -1) {
 						if(data.altAf==1){
 							return '网站';
 						}else{
 							return "网店";
 						}
 					} else {
 						return data.altAf;
 					}
                });
                var myTemplate = handlebars.compile($('#table-template-updateinfo').html());
                if(typeof itemCount!='undefined' &&itemCount>0) $('#table-updateinfo').html(myTemplate(data));
                $('#_total_updateinfo').text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $('#_pageNum_updateinfo').text(pageNum);//共多少页
            }
        });
    };

    //个体户行政许可
    function initDataTable_pb_licenceinfo(_year){
        loadData_pb_licenceinfo(0,5,_year);
    };
    function loadData_pb_licenceinfo(page, length, _year) {
    	if(_year==undefined){
    		_year="";
    	}
        if(window._CONFIG.pageType=='print'){
            length=9999;
        }
        var params = $('#'+_year+'params').serializeObject();//查询参数
        http.httpRequest({
            url: '/pub/pblicenceinfo/list.json',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#'+_year+'pagination_pb_licenceinfo').pagination(itemCount, {
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
                    	loadData_pb_licenceinfo(page,5, _year);
                    }
                });
                var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*5);});//序号
                handlebars.registerHelper("licNameCN", function(data) {
//			    	var ifHight = $("#ifHight").val();
//					if (data.altItem != "undefined" && data.altItem != null
//							&& data.altItem.indexOf("licNameCN") > -1
//							&& ifHight == 1) {
//						return '<font size="3" color="red">'+data.licNameCN+'</font>';
//					} else {
						return data.licNameCN;
//					}
				});

                handlebars.registerHelper("valTo", function(data) {
                	var valTo = data.valTo;
                	if(valTo!=null&&valTo!=""){
                        var date=valTo.split("-");
                        valTo = date[0]+"年"+date[1]+"月"+date[2]+"日";
                	}
//			    	var ifHight = $("#ifHight").val();
//					if (data.altItem != "undefined" && data.altItem != null
//							&& data.altItem.indexOf("valTo") > -1
//							&& ifHight == 1) {
//						return '<font size="3" color="red">'+valTo+'</font>';
//					} else {
						return valTo;
//					}
				});
                var myTemplate = handlebars.compile($('#'+_year+'table-template-pb_licenceinfo').html());
                if(typeof itemCount!='undefined' &&itemCount>0) $('#'+_year+'table-pb_licenceinfo').html(myTemplate(data));
                $('#'+_year+'_total_pb_licenceinfo').text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $('#'+_year+'_pageNum_pb_licenceinfo').text(pageNum);//共多少页
            }
        });
    };

    //个体户网站信息
    function initDataTable_pb_websiteinfo(_year){

        var params = $('#'+_year+'params').serializeObject();//查询参数
        http.httpRequest({
            url: '/pub/pbwebsiteinfo/list.json',
            serializable: false,
            data: params,
            type: 'post',
            success: function (data) {
            	$('#'+_year+'pbwebsite').text("共计"+data.length+"条信息");
            	$('#'+_year+'pbwebsitelight').text("共计"+data.length+"条信息");
            	var jointHtml="";
            	for(var i=0;i<data.length;i++){
            		var webSite = data[i].webSite;//网址
            		var webType = data[i].webType;//网站类型
            		var webTypeName;
            		if(webType == '1'){
            			webTypeName = "网站";
            		}else{
            			webTypeName = "网店";
            		}
            		var webSitName = data[i].webSitName;//网站名称
        			jointHtml = jointHtml+"<div class='item item2'> <div class='title'>"+webSitName+"</div> <p>· 类型："+webTypeName+"</p> <p>· 网址："+webSite+"</p> </div> "
            	}
            	$("."+_year+"pb_website").append(jointHtml);
            }
        });
    }

    //个体户修改信息
    function initDataTable_pb_updateinfo(){
        
        loadData_pb_updateinfo(0,5);
    }
    function loadData_pb_updateinfo(page, length) {
        if(window._CONFIG.pageType=='print'){
            length=9999;
        }
        var params = $('#params').serializeObject();//查询参数
        http.httpRequest({
            url: '/pub/pbupdateinfo/list.json',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#pagination_pb_updateinfo').pagination(itemCount, {
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
                    	loadData_pb_updateinfo(page,5);
                    }
                });
                var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*5);});//序号
                handlebars.registerHelper("transAltDate", function(value) {
                	if(value!=null&&value!=""){
                           var date=value.split("-");
                           return date[0]+"年"+date[1]+"月"+date[2]+"日";
                	}
                });
                handlebars.registerHelper("altBe", function(data) {
                	if(data.altBe =="undefined" || data.altBe == null ){
                		return "";
                	}
 					if (data.altBe.indexOf("CST") > -1||data.altBe.indexOf("GMT") > -1 ) {
 						var time = new Date(data.altBe);
 						var y = time.getFullYear();
 					    var m = time.getMonth() + 1;
 					    m = m < 10 ? ('0' + m) : m;
 					    var d = time.getDate();
 					    d = d < 10 ? ('0' + d) : d;
 						return y + '年' + m + '月' + d+"日";
 					} else if (data.altItem&&data.altItem.toUpperCase().indexOf("ISPUB") > -1) {
 						if(data.altBe==1){
 							return '是';
 						}else{
 							return "否";
 						}
 					} else if (data.altItem&&data.altItem.toUpperCase().indexOf("WEBTYPE") > -1) {
 						if(data.altBe==1){
 							return '网站';
 						}else{
 							return "网店";
 						}
 					} else {
 						return data.altBe;
 					}
                  });

                handlebars.registerHelper("altAf", function(data) {
                    if(data.altAf =="undefined" || data.altAf == null ){
                		return "";
                	}
 					if (data.altAf.indexOf("CST") > -1 ||data.altAf.indexOf("GMT") > -1) {
 						var time = new Date(data.altAf);
 						var y = time.getFullYear();
 					    var m = time.getMonth() + 1;
 					    m = m < 10 ? ('0' + m) : m;
 					    var d = time.getDate();
 					    d = d < 10 ? ('0' + d) : d;
 					   return y + '年' + m + '月' + d+"日";
 					} else if (data.altItem&&data.altItem.toUpperCase().indexOf("ISPUB") > -1) {
 						if(data.altAf==1){
 							return '是';
 						}else{
 							return "否";
 						}
 					} else if (data.altItem&&data.altItem.toUpperCase().indexOf("WEBTYPE") > -1) {
 						if(data.altAf==1){
 							return '网站';
 						}else{
 							return "网店";
 						}
 					} else {
 						return data.altAf;
 					}
                });
                var myTemplate = handlebars.compile($('#table-template-pb_updateinfo').html());
                if(typeof itemCount!='undefined' &&itemCount>0) $('#table-pb_updateinfo').html(myTemplate(data));
                $('#_total_pb_updateinfo').text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $('#_pageNum_pb_updateinfo').text(pageNum);//共多少页
            }
        });
    };

    //农专行政许可
    function initDataTable_sfc_licenceinfo(_year){
        loadData_sfc_licenceinfo(0,5,_year);
    }
    function loadData_sfc_licenceinfo(page, length, _year) {

        if(window._CONFIG.pageType=='print'){
            length=9999;
        }
        var params = $('#'+_year+'params').serializeObject();//查询参数
        http.httpRequest({
            url: '/pub/sfclicenceinfo/list.json',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#'+_year+'pagination_sfc_licenceinfo').pagination(itemCount, {
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
                    	loadData_sfc_licenceinfo(page,5, _year);
                    }
                });
                var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*5);});//序号
                handlebars.registerHelper("licNameCN", function(data) {
//			    	var ifHight = $("#ifHight").val();
//					if (data.altItem != "undefined" && data.altItem != null
//							&& data.altItem.indexOf("licNameCN") > -1
//							&& ifHight == 1) {
//						return '<font size="3" color="red">'+data.licNameCN+'</font>';
//					} else {
						return data.licNameCN;
//					}
				});

                handlebars.registerHelper("valTo", function(data) {
                	var valTo = data.valTo;
                	if(valTo!=null&&valTo!=""){
                        var date=valTo.split("-");
                        valTo = date[0]+"年"+date[1]+"月"+date[2]+"日";
                	}
//			    	var ifHight = $("#ifHight").val();
//					if (data.altItem != "undefined" && data.altItem != null
//							&& data.altItem.indexOf("valTo") > -1
//							&& ifHight == 1) {
//						return '<font size="3" color="red">'+valTo+'</font>';
//					} else {
						return valTo;
//					}
				});
                var myTemplate = handlebars.compile($('#'+_year+'table-template-sfc_licenceinfo').html());
                if(typeof itemCount!='undefined' &&itemCount>0)  $('#'+_year+'table-sfc_licenceinfo').html(myTemplate(data));
                $('#'+_year+'_total_sfc_licenceinfo').text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $('#'+_year+'_pageNum_sfc_licenceinfo').text(pageNum);//共多少页
            }
        });
    };

    //农专网站或网店信息
    function initDataTable_sfc_websiteinfo(_year){
        if(window._CONFIG.pageType=='print'){
            length=9999;
        }
        var params = $('#'+_year+'params').serializeObject();//查询参数
        http.httpRequest({
            url: '/pub/sfcwebsiteinfo/list.json',
            serializable: false,
            data: params,
            type: 'post',
            success: function (data) {
            	$('#'+_year+'sfcwebsite').text("共计"+data.length+"条信息");
            	$('#'+_year+'sfcwebsitelight').text("共计"+data.length+"条信息");
            	var jointHtml="";
            	for(var i=0;i<data.length;i++){
            		var webSite = data[i].webSite;//网址
            		var webType = data[i].webType;//网站类型
            		var webTypeName;
            		if(webType == '1'){
            			webTypeName = "网站";
            		}else{
            			webTypeName = "网店";
            		}
            		var webSitName = data[i].webSitName;//网站名称
        			jointHtml = jointHtml+"<div class='item item2'> <div class='title'>"+webSitName+"</div> <p>· 类型："+webTypeName+"</p> <p>· 网址："+webSite+"</p> </div> "
            	}
            	$("."+_year+"sfc_website").append(jointHtml);
            }
        });
    }

    //农专分支机构信息
    function initDataTable_sfc_branchinfo(_year){
        loadData_sfc_branchinfo(0,5,_year);
    }
    function loadData_sfc_branchinfo(page, length, _year) {
        if(window._CONFIG.pageType=='print'){
            length=9999;
        }
        var params = $('#'+_year+'params').serializeObject();//查询参数
        http.httpRequest({
            url: '/pub/sfcbranchinfo/list.json',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#'+_year+'pagination_sfc_branchinfo').pagination(itemCount, {
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
                    	loadData_sfc_branchinfo(page,5, _year);
                    }
                });
                var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*5);});//序号
                handlebars.registerHelper("uniCode", function(data) {
//			    	var ifHight = $("#ifHight").val();
//					if (data.altItem != "undefined" && data.altItem != null
//							&& data.altItem.indexOf("uniCode") > -1
//							&& ifHight == 1) {
//						return '<font size="3" color="red">'+data.uniCode+'</font>';
//					} else {
						return data.uniCode;
//					}
				});

                handlebars.registerHelper("brName", function(data) {
//			    	var ifHight = $("#ifHight").val();
//					if (data.altItem != "undefined" && data.altItem != null
//							&& data.altItem.indexOf("brName") > -1
//							&& ifHight == 1) {
//						return '<font size="3" color="red">'+data.brName+'</font>';
//					} else {
						return data.brName;
//					}
				});
                var myTemplate = handlebars.compile($('#'+_year+'table-template-sfc_branchinfo').html());
                if(typeof itemCount!='undefined' &&itemCount>0) $('#'+_year+'table-sfc_branchinfo').html(myTemplate(data));
                $('#'+_year+'_total_sfc_branchinfo').text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $('#'+_year+'_pageNum_sfc_branchinfo').text(pageNum);//共多少页
            }
        });
    };

    //农专年报修改信息
    function initDataTable_sfc_updateinfo(){
        
        loadData_sfc_updateinfo(0,5);
    }
    function loadData_sfc_updateinfo(page, length) {
        if(window._CONFIG.pageType=='print'){
            length=9999;
        }
        var params = $('#params').serializeObject();//查询参数
        http.httpRequest({
            url: '/pub/sfcupdateinfo/list.json',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#pagination_sfc_updateinfo').pagination(itemCount, {
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
                    	loadData_sfc_updateinfo(page,5);
                    }
                });
                var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*5);});//序号

                handlebars.registerHelper("transAltDate", function(value) {
                	if(value!=null&&value!=""){
                           var date=value.split("-");
                           return date[0]+"年"+date[1]+"月"+date[2]+"日";
                	}
                });
                handlebars.registerHelper("altBe", function(data) {
                	if(data.altBe =="undefined" || data.altBe == null ){
                		return "";
                	}
 					if (data.altBe.indexOf("CST") > -1 ||data.altBe.indexOf("GMT") > -1) {
 						var time = new Date(data.altBe);
 						var y = time.getFullYear();
 					    var m = time.getMonth() + 1;
 					    m = m < 10 ? ('0' + m) : m;
 					    var d = time.getDate();
 					    d = d < 10 ? ('0' + d) : d;
 						return y + '年' + m + '月' + d+"日";
 					} else if (data.altItem&&data.altItem.toUpperCase().indexOf("ISPUB") > -1) {
 						if(data.altBe==1){
 							return '是';
 						}else{
 							return "否";
 						}
 					} else if (data.altItem&&data.altItem.toUpperCase().indexOf("WEBTYPE") > -1) {
 						if(data.altBe==1){
 							return '网站';
 						}else{
 							return "网店";
 						}
 					}else {
 						return data.altBe;
 					}
                });

                handlebars.registerHelper("altAf", function(data) {
                    if(data.altAf =="undefined" || data.altAf == null ){
                		return "";
                	}
 					if (data.altAf.indexOf("CST") > -1 ||data.altAf.indexOf("GMT") > -1) {
 						var time = new Date(data.altAf);
 						var y = time.getFullYear();
 					    var m = time.getMonth() + 1;
 					    m = m < 10 ? ('0' + m) : m;
 					    var d = time.getDate();
 					    d = d < 10 ? ('0' + d) : d;
 					   return y + '年' + m + '月' + d+"日";
 					} else if (data.altItem&&data.altItem.toUpperCase().indexOf("ISPUB") > -1) {
 						if(data.altAf==1){
 							return '是';
 						}else{
 							return "否";
 						}
 					} else if (data.altItem&&data.altItem.toUpperCase().indexOf("WEBTYPE") > -1) {
 						if(data.altAf==1){
 							return '网站';
 						}else{
 							return "网店";
 						}
 					} else {
 						return data.altAf;
 					}
                });
                var myTemplate = handlebars.compile($('#table-template-sfc_updateinfo').html());
                if(typeof itemCount!='undefined' &&itemCount>0) $('#table-sfc_updateinfo').html(myTemplate(data));
                $('#_total_sfc_updateinfo').text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $('#_pageNum_sfc_updateinfo').text(pageNum);//共多少页
            }
        });
    };
    /**
     * 根据年报年份获取params
     * add by liuhq
     * @returns {*|jQuery}
     */
/*    function  getParam_forprint(_year) {
        if(window._CONFIG.pageType=='print'){
            length=9999;
            return $('#'+_year+'params').serializeObject();//查询参数
        }
        return $('#params').serializeObject();//查询参数
    }*/

})
