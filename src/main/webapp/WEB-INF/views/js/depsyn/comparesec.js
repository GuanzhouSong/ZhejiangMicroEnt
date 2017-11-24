require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars',
    'component/paginationPage',
    'jquery','jquery.serialize','laydate','pagination'], function (layer, dataTable, util, http, handlebars,paginationPage) {
	var msg = $("#msg").val();
	var fileName = $("#fileName").text();
	var pageflag = $("#pageflag").val();
	//执行初始化函数
    init();

    /**
     * 初始化集合
     */
    function init() {
        bind();
        if(msg!=null&&msg!=""){
        	layer.msg(msg, {time: 1200}, function() {});
        }
        if(pageflag!=null&&pageflag!=""){
        	initPubdtinfoTable(0,5);
        }
    }

    function initPubdtinfo(){
    	initPubdtinfoTable(0,5);
    }
    
    function initPubdtinfoTable(page, length, callback) {
    	var params = {entName:$("#entName").val(),uniSCID:$("#uniSCID").val()};
    	http.httpRequest({
            url: '/depsyn/doBulidPage',
            data: {start: page*length,length: length,params:params},
            success: function (data) {
            	console.log(data);
                var itemCount = data.length;
                $('.pagination').pagination(itemCount, {
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
                    callback:function(page,jq){
                    	initPubdtinfoTable(page,5);
                    }
                });
                var infoArry = data.data
                if(infoArry != null){
                	for(var i=0;i<data.data.length;i++){
                    	if(infoArry[i].downState == '1'){
                    		infoArry[i].downStateDesc = "已下载";
                    	}else{
                    		infoArry[i].downStateDesc = "未下载";
                    	}
                    	if(infoArry[i].uniSCID == null){
                    		infoArry[i].uniSCID = infoArry[i].regNO;
                    	}
                	}
                }
                var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*5);});//序号
                var myTemplate = handlebars.compile($("#pubdtinfo_list").html());
                $('#pubdtinfo_page').html(myTemplate(data));
                $("#pro_total").text(itemCount);
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $("#pro_pageNum").text(pageNum);
            }
        });
    }
    
    
    function bind() {
        util.bindEvents([{
            el: '#compare',
            event: 'click',
            handler: function() {
            	window.location.href="/depsyn/doGetCompareList?fileName="+fileName;
             }
        }, {
            el: '#getout',
            event: 'click',
            handler: function() {
            	window.location.href="/depsyn/doGetOutCompare";
             }
        }
        ])
    }

})