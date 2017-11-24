require(['common/util', 'layer1', 'component/dataTable', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','pagination'], function (util, layer, dataTable,  http, handlebars) {
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	initTable();
    	bind();
    }
    
    function initTable() {
    	var entTypeCatg = $("#entTypeCatg").val();
    	if(entTypeCatg==11||entTypeCatg==21){
            if(window._CONFIG.pageType!='print') loadJusticeData(0,5);//司法协助信息
            else loadJusticeData(0,9999);//司法协助信息
            if(window._CONFIG.pageType!='print') loadPledgeData(0,5);//股权出质登记信息
            else loadPledgeData(0,9999);//股权出质登记信息
    	}
        if(window._CONFIG.pageType!='print') loadMortData(0,5);//动产抵押登记信息
        else loadMortData(0,9999);//动产抵押登记信息
    	
    }
    
    //司法协助信息
    function loadJusticeData(page, length, callback) {
        var params = $('#params').serializeObject();//查询参数
        http.httpRequest({
            url: '/pub/pubjusticeinfo/list.json',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#_justicePagination').pagination(itemCount, {
	                prev_text: '<i class="icon-triangle-left"></i>上一页',
	                next_text: '下一页<i class="icon-triangle-right"></i>',
	                num_display_entries: 3,
	                num_edge_entries: 2,
	                items_per_page:5,
	                current_page: page,
	                link_to: 'javascript:void(0)',
	                ellipse_text: '...',
	                first_text: '首页',
	                last_text: '末页',
	                callback: function (page) {
	                	loadJusticeData(page,5);
	                }
                });
                var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*5);});//序号
                handlebars.registerHelper("justiceType", function(data) {
                	if(data.justiceType == 1) {
                		return "股权冻结 | " + getFrozStateName(data.frozState);
                	}else {
                		return "股东变更";
                	}
            	});
                var myTemplate = handlebars.compile($('#justice-table-template').html());
                if(typeof itemCount!='undefined' &&itemCount>0) $('#_justice').html(myTemplate(data));
                $("#_justiceItemCount").text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $("#_justicePageCount").text(pageNum);//共多少页
            }
        });
    };
    
    //动产抵押登记信息
    function loadMortData(page, length, callback) {
        var params = $('#mort_params').serializeObject();//查询参数
        http.httpRequest({
            url: '/pub/mortreginfo/list.json',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#_mortPagination').pagination(itemCount, {
	                prev_text: '<i class="icon-triangle-left"></i>上一页',
	                next_text: '下一页<i class="icon-triangle-right"></i>',
	                num_display_entries: 3,
	                num_edge_entries: 2,
	                items_per_page:5,
	                current_page: page,
	                link_to: 'javascript:void(0)',
	                ellipse_text: '...',
	                first_text: '首页',
	                last_text: '末页',
	                callback: function (page) {
	                	loadMortData(page,5);
	                }
                });
                var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*5);});//序号
                handlebars.registerHelper("cancelStatus", function(cancelStatus) {return cancelStatus == 0 ? "有效" : "无效";});
                handlebars.registerHelper("checkDate", function(checkDate) {
                	return util.dateFormat(new Date(checkDate),"yy年mm月dd日");
            	});
                var myTemplate = handlebars.compile($('#mort-table-template').html());
                if(typeof itemCount!='undefined' &&itemCount>0) $('#_mort').html(myTemplate(data));
                $("#_mortItemCount").text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $("#_mortPageCount").text(pageNum);//共多少页
            }
        });
    };
    
    //股权出质登记信息
    function loadPledgeData(page, length, callback) {
        var params = $('#params').serializeObject();//查询参数
        http.httpRequest({
            url: '/pub/sppledge/list.json',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#_pledgePagination').pagination(itemCount, {
	                prev_text: '<i class="icon-triangle-left"></i>上一页',
	                next_text: '下一页<i class="icon-triangle-right"></i>',
	                num_display_entries: 3,
	                num_edge_entries: 2,
	                items_per_page:5,
	                current_page: page,
	                link_to: 'javascript:void(0)',
	                ellipse_text: '...',
	                first_text: '首页',
	                last_text: '末页',
	                callback: function (page) {
	                	loadPledgeData(page,5);
	                }
                });
                var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*5);});//序号
                handlebars.registerHelper("pleBLicNO", function(data) {
                	if(data.pledgor.length < 6) {
//                		return data.pleBLicNO.substring(0,12) + "***";
                		return "( 非公示项 )";
                	}else{
                		return data.pleBLicNO;
                	}
            	});
                handlebars.registerHelper("impAm", function(impAm) {
                	return impAm == "" ? "" : impAm + " 万元";
            	});
                handlebars.registerHelper("impBLicNO", function(data) {
                	if(data.impOrg.length < 6) {
//                		return data.impBLicNO.substring(0,12) + "***";
                		return "( 非公示项 )";
                	}else{
                		return data.impBLicNO;
                	}
            	});
                handlebars.registerHelper("recDate", function(recDate) {
                	return util.dateFormat(new Date(recDate),"yy年mm月dd日");
            	});
                handlebars.registerHelper("status", function(status) {
                	if(status == "K" || status == "B" ) {
                		return "有效";
                	}else{
                		return "无效";
                	}
            	});
                handlebars.registerHelper("equPleDate", function(equPleDate) {
                	return util.dateFormat(new Date(equPleDate),"yy年mm月dd日");
            	});
                var myTemplate = handlebars.compile($('#pledge-table-template').html());
                if(typeof itemCount!='undefined' &&itemCount>0) $('#_pledge').html(myTemplate(data));
                $("#_pledgeItemCount").text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $("#_pledgePageCount").text(pageNum);//共多少页
            }
        });
    };
    
    
    //获取股权冻结状态名称
    function getFrozStateName(frozState) {
    	if(frozState == 1) {
    		return "冻结";
    	}else if(frozState == 2) {
    		return "解除冻结";
    	}else if(frozState == 3) {
    		return "失效";
    	}
    };
    
    function bind() {
        util.bindEvents([{
        	//司法协助详情
            el: '.js-justicedetail-view',
            event: 'click',
            handler: function () {
            	var uid = $(this).closest('tr').attr('data-uid');
                layer.open({
                    isIframeAuto: false,  //如果iframe内容是异步获取不要传此参数
                    type:2,
                    shadeClose: true,
                    closeBtn: 0,
                    area: ['800px','700px'],
                    title: false,
                    content: '../../pub/pubjusticeinfo/detail?uid=' + uid
                });
            }
        },{
        	//动产抵押登记信息详情
            el: '.js-mortdetail-view',
            event: 'click',
            handler: function () {
            	var id = $(this).closest('tr').attr('data-id');
                layer.open({
                    isIframeAuto: false,  //如果iframe内容是异步获取不要传此参数
                    type:2,
                    shadeClose: true,
                    closeBtn: 0,
                    area: ['800px','700px'],
                    title: false,
                    content: '../../pub/mortreginfo/detail?id=' + id
                });
            }
        },{
        	//股权出质登记信息详情
            el: '.js-pledgedetail-view',
            event: 'click',
            handler: function () {
            	var id = $(this).closest('tr').attr('data-id');
                layer.open({
                    isIframeAuto: false,  //如果iframe内容是异步获取不要传此参数
                    type:2,
                    shadeClose: true,
                    closeBtn: 0,
                    area: ['800px','700px'],
                    title: false,
                    content: '../../pub/sppledge/detail?id=' + id
                });
            }
        }]);
    }
})
