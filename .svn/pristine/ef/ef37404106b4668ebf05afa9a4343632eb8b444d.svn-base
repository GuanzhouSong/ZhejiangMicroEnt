require(['component/iframeLayer', 'common/util', 'common/http', 'handlebars', 'common/validateRules','jquery.validate',
    'jquery.serialize','component/backToTop','pagination'], function (layer, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */

    function init() {
    	initTable();
        bind();
    }
    
    function initTable() {
    	var repType = window._CONFIG.repType;
    	loadWebsiteData(0,10);
    	if (repType.indexOf("subcapital") != -1) {
    		loadSubcapitalData(0,10);
    	}
    	if (repType.indexOf("forinvestment") != -1) {
    		loadForinvestData(0,10);
    	}
    	loadForguaranteeData(0,10);
    	if (repType.indexOf("alterstockinfo") != -1) {
    		loadStockData(0,10);
    	}
    }
    
    //网站或网店信息
    function loadWebsiteData(page, length, callback) {
        var params = $('#_params').serializeObject();//查询参数
        http.httpRequest({
            url: '/reg/client/yr/ent/pubpreview/website/list.json',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $("#_isWebsite").text(itemCount > 0 ? "是" : "否");
                $('#_websitePagination').pagination(itemCount, {
	                prev_text: '<i class="icon-triangle-left"></i>上一页',
	                next_text: '下一页<i class="icon-triangle-right"></i>',
	                num_display_entries: 3,
	                num_edge_entries: 2,
	                current_page: page,
	                link_to: 'javascript:void(0)',
	                ellipse_text: '...',
	                first_text: '首页',
	                last_text: '末页',
	                callback: function (page) {
	                	loadWebsiteData(page,10);
	                }
                });
                //handlebars.registerHelper("addOne", function(index) {return index + 1;});//序号
                handlebars.registerHelper("webType", function(webType) {
                    if(webType&&webType=='2'){
                        return '网店(或微店)';
                    }else{
                        var webSmallType = this.webSmallType;
                        if(webSmallType){return webSmallType=='1'?'交易网站':'信息网站';}else{return '';}
                    }
                });
                var myTemplate = handlebars.compile($('#website-table-template').html());
                $('#_website').html(myTemplate(data));
                $("#_websiteItemCount").text(itemCount);//总数
                var pageNum = itemCount%10==0?itemCount/10:Math.ceil(itemCount/10);
                $("#_websitePageCount").text(pageNum);//共多少页
            }
        });
    };
    
    //股东及出资信息
    function loadSubcapitalData(page, length, callback) {
        var params = $('#_params').serializeObject();//查询参数
        http.httpRequest({
            url: '/reg/client/yr/ent/pubpreview/subcapital/list.json',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#_subcapitalPagination').pagination(itemCount, {
	                prev_text: '<i class="icon-triangle-left"></i>上一页',
	                next_text: '下一页<i class="icon-triangle-right"></i>',
	                num_display_entries: 3,
	                num_edge_entries: 2,
	                current_page: page,
	                link_to: 'javascript:void(0)',
	                ellipse_text: '...',
	                first_text: '首页',
	                last_text: '末页',
	                callback: function (page) {
	                	loadSubcapitalData(page,10);
	                }
                });
                //handlebars.registerHelper("addOne", function(index) {return index + 1;});//序号
                var myTemplate = handlebars.compile($('#subcapital-table-template').html());
                $('#_subcapital').html(myTemplate(data));
                $("#_subcapitalItemCount").text(itemCount);//总数
                var pageNum = itemCount%10==0?itemCount/10:Math.ceil(itemCount/10);
                $("#_subcapitalPageCount").text(pageNum);//共多少页
            }
        });
    };
    
    //对外投资信息
    function loadForinvestData(page, length, callback) {
        var params = $('#_params').serializeObject();//查询参数
        http.httpRequest({
            url: '/reg/client/yr/ent/pubpreview/forinvest/list.json',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $("#_isForinvest").text(itemCount > 0 ? "是" : "否");
                $('#_forinvestPagination').pagination(itemCount, {
	                prev_text: '<i class="icon-triangle-left"></i>上一页',
	                next_text: '下一页<i class="icon-triangle-right"></i>',
	                num_display_entries: 3,
	                num_edge_entries: 2,
	                current_page: page,
	                link_to: 'javascript:void(0)',
	                ellipse_text: '...',
	                first_text: '首页',
	                last_text: '末页',
	                callback: function (page) {
	                	loadForinvestData(page,10);
	                }
                });
                //handlebars.registerHelper("addOne", function(index) {return index + 1;});//序号
                var myTemplate = handlebars.compile($('#forinvest-table-template').html());
                $('#_forinvest').html(myTemplate(data));
                $("#_forinvestItemCount").text(itemCount);//总数
                var pageNum = itemCount%10==0?itemCount/10:Math.ceil(itemCount/10);
                $("#_forinvestPageCount").text(pageNum);//共多少页
            }
        });
    };
    
    //对外提供保证担保信息
    function loadForguaranteeData(page, length, callback) {
        var params = $('#_params').serializeObject();//查询参数
        http.httpRequest({
            url: '/reg/client/yr/ent/pubpreview/forguarantee/list.json',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $("#_isForguarantee").text(itemCount > 0 ? "是" : "否");
                $('#_forguaranteePagination').pagination(itemCount, {
	                prev_text: '<i class="icon-triangle-left"></i>上一页',
	                next_text: '下一页<i class="icon-triangle-right"></i>',
	                num_display_entries: 3,
	                num_edge_entries: 2,
	                current_page: page,
	                link_to: 'javascript:void(0)',
	                ellipse_text: '...',
	                first_text: '首页',
	                last_text: '末页',
	                callback: function (page) {
	                	loadForguaranteeData(page,10);
	                }
                });
                //handlebars.registerHelper("addOne", function(index) {return index + 1;});//序号
                handlebars.registerHelper("priClaSecKind", function(priClaSecKind) {return priClaSecKind == '1' ? '合同':'其它';});
                handlebars.registerHelper("guaPeriod", function(guaPeriod) {return guaPeriod == '1' ? '期间':'未约定';});
                handlebars.registerHelper("gaType", function(gaType) {
                	if(gaType == '1') {
                		return '一般保证';
                	}else if(gaType == '2') {
                		return '连带保证';
                	}else {
                		return '未约定';
                	}
            	});
                handlebars.registerHelper("isPubFlag", function(isPubFlag) {return isPubFlag == '1' ? '公示' : '不公示';});
                var myTemplate = handlebars.compile($('#forguarantee-table-template').html());
                $('#_forguarantee').html(myTemplate(data));
                $("#_forguaranteeItemCount").text(itemCount);//总数
                var pageNum = itemCount%10==0?itemCount/10:Math.ceil(itemCount/10);
                $("#_forguaranteePageCount").text(pageNum);//共多少页
            }
        });
    };
    
    //股权变更信息
    function loadStockData(page, length, callback) {
        var params = $('#_params').serializeObject();//查询参数
        http.httpRequest({
            url: '/reg/client/yr/ent/pubpreview/stock/list.json',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $("#_isStock").text(itemCount > 0 ? "是" : "否");
                $('#_stockPagination').pagination(itemCount, {
	                prev_text: '<i class="icon-triangle-left"></i>上一页',
	                next_text: '下一页<i class="icon-triangle-right"></i>',
	                num_display_entries: 3,
	                num_edge_entries: 2,
	                current_page: page,
	                link_to: 'javascript:void(0)',
	                ellipse_text: '...',
	                first_text: '首页',
	                last_text: '末页',
	                callback: function (page) {
	                	loadStockData(page,10);
	                }
                });
                //handlebars.registerHelper("addOne", function(index) {return index + 1;});//序号
                var myTemplate = handlebars.compile($('#stock-table-template').html());
                $('#_stock').html(myTemplate(data));
                $("#_stockItemCount").text(itemCount);//总数
                var pageNum = itemCount%10==0?itemCount/10:Math.ceil(itemCount/10);
                $("#_stockPageCount").text(pageNum);//共多少页
            }
        });
    };

    function bind() {
        util.bindEvents([{
        	//提交年报弹出框
            el: '#save',
            event: 'click',
            handler: function () {
            	//$(".layer").show();
            	//$(".yrpubpreview-pop").show();
                layer.dialog({
                    content: $('#yrpubpreview-pop'),
                    type: 1,
                    area: ['700px','400px']
                });
            }
        },{
        	//取消
            el: '#cancel',
            event: 'click',
            handler: function () {
                layer.closeAll();
            	//$(".layer").hide();
            	//$(.yrpubpreview-pop").hide();
            }
        },{
        	//提交
            el: '#commit',
            event: 'click',
            handler: function () {
            	$("#commit").attr("disabled","disabled");
            	var params = $('#_params').serializeObject();//查询参数
            	http.httpRequest({
                    url: '/reg/client/yr/yrcommit/ent/commitreport',
                    type:'post',
                    beforeSend:function(){ //发送前执
                        layer.msg('年报提交时数据处理可能比较慢,请您耐心等待,请勿关闭浏览器!', {icon: 16, time: -1, shade: [0.4, '#CCC']});
                    },
                    data: {year: params['year'], pripid: params['priPID']},
                    success: function (data) {
                        if (data.status == 'success') {
                        	layer.msg(data.msg, {icon: 6,time: 2000}, function () {
                                window.opener.location.reload();//刷新填报页面
                        		window.close();
                            });
                        }else {
                        	layer.msg(data.msg, {icon: 5,time: 3000}, function () {
                                return;
                            });
                        }
                    }
                });
            }
        }]);
    }
});