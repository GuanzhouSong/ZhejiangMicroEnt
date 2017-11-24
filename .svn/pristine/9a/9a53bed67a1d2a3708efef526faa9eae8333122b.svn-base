require(['common/util', 'layer1', 'component/dataTable', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','pagination'], function (util, layer, dataTable,  http, handlebars) {
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	initTable();
    }
    
    function initTable() {
    	loadAnomalyData(0,20);//纳入经营异常名录信息
    }
    
    //纳入经营异常名录信息
    function loadAnomalyData(page, length, callback) {
        var params = $('#params').serializeObject();//查询参数
        var type = window._CONFIG.entTypeCatg == '50' ? 'pbopanomaly' : 'opanomaly';
        http.httpRequest({
            url: '/pub/client/pub' + type + '/list/list.json',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#_' + type + 'Pagination').pagination(itemCount, {
	                prev_text: '<i class="icon-triangle-left"></i>上一页',
	                next_text: '下一页<i class="icon-triangle-right"></i>',
	                num_display_entries: 3,
	                num_edge_entries: 2,
	                items_per_page:20,
	                current_page: page,
	                link_to: 'javascript:void(0)',
	                ellipse_text: '...',
	                first_text: '首页',
	                last_text: '末页',
	                callback: function (page) {
	                	loadAnomalyData(page,20);
	                }
                });
                var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*20);});//序号
                handlebars.registerHelper("abnTime", function(abnTime) {
                	if(abnTime){
                		return util.dateFormat(new Date(util.dateTransform(abnTime)),"yy年mm月dd日");
                	}else{
                		return "";
                	}
            	});
                handlebars.registerHelper("remDate", function(remDate) {
                	if(remDate != null) {
                		return util.dateFormat(new Date(util.dateTransform(remDate)),"yy年mm月dd日");
                	}else{
                		return "";
                	}
            	});
                handlebars.registerHelper("cogDate", function(cogDate) {
                	return util.dateFormat(new Date(util.dateTransform(cogDate)),"yy年mm月dd日");
            	});
                handlebars.registerHelper("norDate", function(norDate) {
                	if(norDate != null) {
                		return util.dateFormat(new Date(util.dateTransform(norDate)),"yy年mm月dd日");
                	}else{
                		return "";
                	}
            	});
                
                var myTemplate = handlebars.compile($('#' + type + '-table-template').html());
                $('#_' + type).html(myTemplate(data));
                if(typeof (itemCount) =='undefined') itemCount=0;
                $("#_" + type + "ItemCount").text(itemCount);//总数
                var pageNum = itemCount%20==0?itemCount/20:Math.ceil(itemCount/20);
                $("#_" + type + "PageCount").text(pageNum);//共多少页
            }
        });
    };
    
})
