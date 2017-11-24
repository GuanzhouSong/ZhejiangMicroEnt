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
    	loadFavorableInfoData(0,5);//良好荣誉信息
    }
    
    //良好荣誉信息
    function loadFavorableInfoData(page, length, callback) {
        var params = $('#params').serializeObject();//查询参数
        http.httpRequest({
            url: '/pub/favorableinfo/list.json',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#_favorableinfoPagination').pagination(itemCount, {
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
	                	loadFavorableInfoData(page,5);
	                }
                });
                var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*5);});//序号
                handlebars.registerHelper("favType",function(favType){
                	if(favType == '0'){
                		return "百强民营企业";
                	}else if(favType == '1'){
                		return "驰名商标";
                	}else if(favType == '2'){
                		return "知名商号";
                	}else if(favType == '3'){
                		return "著名商标";
                	}else if(favType == '4'){
                		return "守合同重信用企业";
                	}else if(favType == '5'){
                		return "信用示范管理企业";
                	}else if(favType == '6'){
                		return "小微企业成长之星";
                	}
                });
                handlebars.registerHelper("licZone", function(licZone) {
                	if(licZone == '0'){
                		return "国家级";
                	}else if(licZone == '1'){
                		return "省级";
                	}else if(licZone == '2'){
                		return "市级";
                	}else if(licZone == '3'){
                		return "县级";
                	}else if(licZone == '4'){
                		return "AAA";
                	}else if(licZone == '5'){
                		return "AA";
                	}else if(licZone == '6'){
                		return "A";
                	}
            	});
                handlebars.registerHelper("regTo", function(regTo) {
                	if(regTo != null && regTo != "") {
                		return util.dateFormat(new Date(util.dateTransform(regTo)),"yy-mm-dd");
                	}else{
                		return "";
                	}
            	});
                handlebars.registerHelper("efftStatus",function(efftStatus){
                	if(efftStatus == '0'){
                		return "无效";
                	}else if(efftStatus == '1'){
                		return "有效";
                	}
                });
                var myTemplate = handlebars.compile($('#favorableinfo-table-template').html());
                $('#_favorableinfo').html(myTemplate(data));
                if(typeof (itemCount) =='undefined') itemCount=0;
                $("#_favorableinfoItemCount").text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $("#_favorableinfoPageCount").text(pageNum);//共多少页
            }
        });
    };
    
    function bind() {
        util.bindEvents([{
            el: '.js-favorableinfodetail-view',
            event: 'click',
            handler: function() {
            	var uid = $(this).attr('uid');
        		layer.open({
                    isIframeAuto: false,  //如果iframe内容是异步获取不要传此参数
                    type:2,
                    shadeClose: true,
                    closeBtn: 0,
                    area: ['800px','400px'],
                    title: false,
                    content: '../../pub/favorableinfo/detail?uid=' + uid
                });
            }
        }]);
    }
})
