require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery', 'jquery.validate', 'jquery.serialize', 'laydate', 'pagination'],
    function (layer, dataTable, util, http, handlebars) {
	   //警示 协同的URL前缀
	   var _sysUrl=window._CONFIG._sysUrl;
        init();
        /**
         * 初始化函数集合
         */

        function init() { 
        	    initCaseTable(0); 
                initfavorableInfo(0);
                bind();
                
                $(".js-fold").html('展开详情<i></i>');
                $(".js-fold").addClass("reverse");
                $(".js-fold").addClass("more");
                $("#entDetail").hide();
        }

        //不良信息
        function initCaseTable(page) { //知识产权
            var length=5;
            if(window._CONFIG.pageType=='print'){
                length=9999;
            }
            http.httpRequest({
                url:  _sysUrl+'/favorable/selectCaseInfoBypriPIDAndEfftStatusJSON',
                serializable: false,
                data: {
                    "priPID": $("#priPID").val()
                },
                success: function (data) { 
                    var showPage = data.recordsTotal;
                    if(showPage==0){
                    	$("#ippldg").html("");
                    	var html="<tr><td colspan=5><div class='no-con'>暂无企业不良信息</div></td></tr>";
                    	$("#ippldg").append(html); 
                    } 
                   /* $('#pageippldg').pagination(showPage, {//分页工具
                        callback: pageIppldgCallback,
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
                    $("#CaseTotalCount").text(showPage); 

                    //序号
                    var handleHelper = handlebars.registerHelper("addOne",
                        function (index) { 
                                return index + 1; 
                        });
                    handlebars.registerHelper("transRegDocNo",function(value){
                    	 
                    	var favType=this.favType;
                    	if("3"==favType){
                    		if(value=="0"){
                        		return "吊销企业";
                        	}else if(value=="1"){
                        		return "失信被执行人";
                        	}else if(value=="2"){
                        		return "刑事责任司法判决";
                        	}else if(value=="3"){
                        		return "失信惩戒黑名单";
                        	}else if(value=="4"){
                        		return "工商严重违法失信";
                        	}else{
                        		return "";
                        	} 
                    	} else{
                    		return value;
                    	}
                    });
                    
                    handlebars.registerHelper("transRegDeptCn",function(value){
                    	if(value=="1"){
                    		return "工商";
                    	}else if(value=="2"){
                    		return "法院";
                    	}else if(value=="3"){
                    		return "其他部门";
                    	}else if(value=="4"){
                    		return "企业";
                    	}else{
                    		return "";
                    	} 
                    });

                    handlebars.registerHelper("transEfftStatus",function(value){
                    	if(value=="1"){
                    		return "有效";
                    	}else if(value=="0"){
                    		return "无效";
                    	}else{
                    		return "";
                    	} 
                    });
                    var myTemplate = handlebars.compile($("#ippldg-template").html());
                    if (typeof data.recordsTotal != 'undefined' && data.recordsTotal > 0)  $('#ippldg').html(myTemplate(data));
                }
            })
        }
        
        
        $('#efftStatus').on('change',function(){
        	initfavorableInfo(0);
        });

        //企业良好信息
        function initfavorableInfo(page) {  
            var length=5;
            if(window._CONFIG.pageType=='print'){
                length=9999;
            }
            http.httpRequest({
                url: _sysUrl+'/favorable/selectFavorAbleInfoJSON',
                serializable: false,
                data: { 
                    "priPID": $("#priPID").val(),
                    "efftStatus": $("#efftStatus").val() 
                },
                success: function (data) {
                    if(data.recordsTotal==0){
                    	$("#case").html("");
                    	var html="<tr><td colspan=11><div class='no-con'>暂无企业良好信息</div></td></tr>";
                    	$("#case").append(html);
                    } 
                    var showPage = data.recordsTotal;
//                    $('#pagecase').pagination(showPage, {//分页工具
//                        callback: pageCaseCallback,
//                        items_per_page: 5,
//                        prev_text: '<i class="icon-triangle-left"></i>上一页',
//                        next_text: '下一页<i class="icon-triangle-right"></i>',
//                        num_display_entries: 3,
//                        num_edge_entries: 2,
//                        current_page: page,
//                        link_to: 'javascript:void(0)',
//                        ellipse_text: '...',
//                        first_text: '首页',
//                        last_text: '末页'
//                    });

                    $("#favorableCount").text(data.recordsTotal);
                   // var totalPages = Math.ceil(data.recordsTotal / 5);
                    //$("#casePageCount").text(totalPages);

                    var handleHelper = handlebars.registerHelper("addOne",
                        function (index) { 
                                return index + 1; 
                        });
                  //良好信息类别
                    handlebars.registerHelper("transfavType", function (value) {
                        if (value == "0") {
                            return "百强民营企业";
                        } else if (value == "1") {
                            return "驰名商标";
                        } else if (value == "2") {
                            return "知名商号";
                        }else if (value == "3") {
                            return "著名商标";
                        }else if (value == "4") {
                            return "守合同重信用企业";
                        }else if (value == "5") {
                            return "信用示范管理企业";
                        }else if (value == "6") {
                            return "小微企业成长之星";
                        } else {
                            return "";
                        }
                    });
                    //良好信息级别
                    handlebars.registerHelper("translicZone", function (value) {
                        if (value == "0") {
                            return "全国";
                        } else if (value == "1") {
                            return "省级";
                        } else if (value == "2") {
                            return "市级";
                        }else if (value == "3") {
                            return "县级";
                        }else if (value == "4") {
				    		 return "AAA";
				    	}else if (value == "5") {
				    		 return "AA";
				    	}else if (value == "6") {
				    		 return "A";
				    	}else {
                            return "";
                        }
                    }); 
                    
                    handlebars.registerHelper("transEfftStatus", function (value) {
                        if (value == "1") {
                            return "有效";
                        } else if (value == "0") {
                            return "无效";
                        }else {
                            return "";
                        }
                    });
                    var myTemplate = handlebars.compile($("#case-template").html());
                    if (typeof data.recordsTotal != 'undefined' && data.recordsTotal > 0)  $('#case').html(myTemplate(data));
                }
            })
        }


         

        function pageInvesMentCallback(page, jq) {//翻页事件
            initDataInvestmentTable(page + 1);
        }


        

        function pageIppldgCallback(page, jq) {//翻页事件

            initIppldgTable(page + 1);
        }

        function pageCaseCallback(page, jq) {//翻页事件
            initCaseTable(page + 1);


        }


        function bind() {
            util.bindEvents([
                {
                    el: '#cancle',
                    event: 'click',
                    handler: function () {
                        $('#forinvestForm')[0].reset();
                        $(".js-content-show").hide();
                    }
                },
                {
                    el: ".showIppldg",
                    event: 'click',
                    handler: function () {
                    	
                    	var busExcList=this.id;
                    	var title=this.title;
                    	var pripid=this.pripid;
                    	
                    	layer.dialog({
                            title: '查看详情',
                            area: ['80%', '88%'],
                            content: _sysUrl+'/opanomaly/pubopanomaly/pubOpanoMalyAuditEdit?busExcList='+busExcList+"&viewFlag=2",
                            callback: function (data) {
                                
                            }
                        }) 
                    }
                },
                {
                	el:"#infoImport",
                	event:'click',
                	handler:function(){
                 		location.href=_sysUrl+"/favorable/createPdf?priPID="+$("#priPID").val()+"&uid="+$('#uid').val()+"&efftStatus="+$('#efftStatus').val()+"&caseEfftStatus="+$('#caseEfftStatus').val();
                	}
                },
                {
                	el:"#moreButton",
                	event:'click',
                	handler:function(){
                        if($('#moreInfo').css("display") == "none"){
                        	$("#moreInfo").show();
                            $(this).text("收起更多");
                        }else {
                        	$("#moreInfo").hide();
                            $(this).text("展开更多");
                        }
                		 
                	}
                },
                
                {
                    el: "#showImvestupdate",
                    event: 'click',
                    handler: function () {
                        var priPID = $("#priPID").val();
                        window.open("/im/pub/investalter/showImvestupdate?priPID=" + priPID);
                    }
                } ,{
                    el: '#printbtn',
                    event: 'click',
                    handler: function () { 
                    	window.open(_sysUrl+'/favorable/favorAbleInfoDetail?uid='+$("#uid").val()+"&type=2");
                    }
                },
                {
                    el: '.js-fold',
                    event: 'click',
                    handler: function () {
                        if ($(this).hasClass('reverse')) {
                        	$(this).html('收起详情<i></i>');
                            $(this).removeClass("reverse"); 
                            $(this).addClass("more");
                            $("#entDetail").show();
                        } else {
                            $(this).html('展开详情<i></i>');
                            $(this).addClass("reverse");
                            $(this).addClass("more");
                            $("#entDetail").hide(); 
                        } 
                    }
                }
            ])
        }

    })