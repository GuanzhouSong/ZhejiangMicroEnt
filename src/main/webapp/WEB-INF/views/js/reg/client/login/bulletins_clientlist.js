require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','pagination'], function (layer, dataTable, util, http,handlebars) {
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	init_all(2);
    	bind();
    }
    
    /**
     * 全部
     */
    function init_all(orderFlag){
    	 loadData_one(0,5,orderFlag,"");
    };
    
    //地市库
    function init_part(deptScope,orderFlag){
   	      loadData_one(0,5,orderFlag,deptScope);
    }
    
    function loadData_one(page, length, orderFlag, deptScope, callback) {
    	http.httpRequest({
            url: '/reg/client/login/bulletins/list.json',
            serializable: false,
            data: {start: page*length,length: length,params:{"orderFlag":orderFlag,"deptScope":deptScope}},
            type: 'post',
            success: function (data) {
            	var myTemplate = handlebars.compile($('#listTemplate').html());
                $('#dbao_page_one'+deptScope).html(myTemplate(data));
            	var itemCount = data.recordsTotal; //获取查询出来的总数
//            	console.log(data.data);
            	if(itemCount < 5){  //总数<5  分页情况不显示
            		$('#pageforhide'+deptScope).hide();
            	}else{
            		$('#pageforhide'+deptScope).show();
            	}
                $('.pagination'+deptScope).pagination(itemCount, {
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,
                    num_edge_entries: 2,
                    current_page: page,
                    items_per_page:5,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页',
                    callback:function(page,jq){
                        loadData_one(page,5,orderFlag,deptScope);
                    }
                });
                $("#notice-total"+deptScope).text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $("#notice_pageNum"+deptScope).text(pageNum);//共多少页
            }
        });
    };
    
    
    function bind(){
    	util.bindEvents([
    	             	{//tab页面加载
    	                     el: '.tab-item',
    	                     event: 'click',
    	                     handler: function () {
    	                    	 var departcode = $(this).attr('mtab');
    	                    	 if(departcode == 0){
    	             	    		init_all(2);
    	                    	 }else{
    	                    		 init_part(departcode,2);    	                    	 }
    	                     }
    	                 }
    ])
    }
   
})
