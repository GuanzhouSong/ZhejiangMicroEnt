require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars',
    'jquery','jquery.serialize','laydate',], function (layer, dataTable, util, http, handlebars,paginationPage) {
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	initUndertakingLetter();//获取全体投资人承诺书
    }
    
    function initUndertakingLetter() {
    	var encryPriPID = $("#encryPriPID").val();
        http.httpRequest({
            url: 'getLetter.json',
            serializable: false,
            data: {encryPriPID: encryPriPID},
            type: 'get',
            success: function (data) {
            	$("#undertakingletter").attr("src","data:image/jpg;base64,"+data);
            }
        });
    }
    
    //简易注销结果信息
    function initDataTable_scanResult(){
		loadData_scanResult(0,5);
    }
    function loadData_scanResult(page, length, callback) {
        var params = $('#params').serializeObject();//查询参数
        http.httpRequest({
            url: '/pub/simpleesc/erescscrinfo/list.json',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#pagination_scrinfo').pagination(itemCount, {
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
                    	loadData_scanResult(page,5);
                    }
                });
				var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*5);});//序号
                
                var myTemplate = handlebars.compile($('#table-template-scrinfo').html());
                if(typeof itemCount!='undefined' &&itemCount>0) $('#table-scrinfo').html(myTemplate(data));
                $("#_total_scrinfo").text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $("#_pageNum_scrinfo").text(pageNum);//共多少页
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
