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
    	loadPunishData(0,5);//行政处罚信息
    }
    
    //行政处罚信息
    function loadPunishData(page, length, callback) {
        var params = $('#params').serializeObject();//查询参数
        http.httpRequest({
            url: '/pub/pubotherpunish/list.json',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#_punishPagination').pagination(itemCount, {
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
	                	loadPunishData(page,5);
	                }
                });
                var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*5);});//序号
                handlebars.registerHelper("penDecIssDate", function(penDecIssDate) {
                	if(penDecIssDate != null && penDecIssDate != "") {
                		return util.dateFormat(new Date(util.dateTransform(penDecIssDate)),"yy年mm月dd日");
                	}else{
                		return "";
                	}
            	});
                handlebars.registerHelper("auditDate", function(auditDate) {
                	if(auditDate != null && auditDate != "") {
                		return util.dateFormat(new Date(util.dateTransform(auditDate)),"yy年mm月dd日");
                	}else{
                		return "";
                	}
            	});
                handlebars.registerHelper("altDate", function(altDate) {
                	if(altDate != null && altDate != "") {
                		var date=altDate.split("-");
                		var fmtAltDate = date[0]+"年"+date[1]+"月"+date[2]+"日";
                		return fmtAltDate;
                	}else{
                		return "";
                	}
            	});
                handlebars.registerHelper("addOne", function(index) {return index+1;});//序号
                handlebars.registerHelper("dataList", function(dataList) {
                         if(dataList == null || dataList == ""){
                        	 return "display:none";
                         }else{
                        	 return "";
                         }
                });
                handlebars.registerHelper("miniShow",function(v){
                	if(v){
                		if(v.length <= 30){
                			return '<td>'+v+'</td>';
                		}else{
                			return '<td title="'+v+'">'+v.substr(0,30)+'...</td>';
                		}
                	}
                });
                var myTemplate = handlebars.compile($('#punish-table-template').html());
                $('#_punish').html(myTemplate(data));
                if(typeof (itemCount) =='undefined') itemCount=0;
                $("#_punishItemCount").text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $("#_punishPageCount").text(pageNum);//共多少页
            }
        });
    };
    
    function bind() {
        util.bindEvents([{
            el: '.js-punishdetail-view',
            event: 'click',
            handler: function() {
            	var caseNO = $(this).attr('id');
        		window.open('../../pub/pubotherpunish/detail?caseNO=' + caseNO);
            }
        }]);
    }
})
