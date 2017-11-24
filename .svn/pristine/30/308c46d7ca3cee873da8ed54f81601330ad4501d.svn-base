require([
    'component/iframeLayer',
    'common/util',
    'common/http',
    'handlebars',
    'component/paginationPage',
    'jquery.validate',
    'common/validateRules',
    'jquery.serialize',
    'component/backToTop'
], function (layer, util, http,handlebars,paginationPage) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        init_table();//表格初始化
        
        bind();
        
        handlebars.registerHelper("state", function(state) {
            if(state == 1){
           	   return "有效";
            }else{
           	   return "无效";
            }
       });
    }

   
    //列表初始化
    function init_table(){
        var options = {
            page:0,                                     //开始页
            length:5,                                   //长度
            items_per_page:5,                           //每页显示几条              默认10条
            params:$('#_params').serializeObject(),     //查询参数,                 必填项
            url:'/entinfo/nocreditpunish',    //url 访问路径              必填项
            type:'post',                                //请求方式
            pagination:'#pagination',                   //分页显示的位置             必填项
            myTemplate:'#table-template',               //script:模板路径           必填项
            html:'#_listData',                          //需要渲染的html            必填项
            total:'#_total',                            //显示页面总数的位置         必填项
            pageNmber:'#_pageNum'                      //显示多少页的位置           必填项
        };
        paginationPage.loadData(options);
       
    };
    
        function bind() {
	        util.bindEvents([{
	            el: '.details',
	            event: 'click',
	            handler: function () {
	            	var enCodeBatchNo = $(this).attr('batchNo');
	            	var enCodePriPID = $(this).attr('priPID');
	            	window.open("/entinfo/nocreditview?enCodeBatchNo="+enCodeBatchNo+'&enCodePriPID='+enCodePriPID);
	            }
	        }])
    }

});