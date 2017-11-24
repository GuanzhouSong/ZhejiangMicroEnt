require([
    'component/iframeLayer',
    'common/util',
    'common/http',
    'handlebars',
    'component/paginationPage',
    'jquery.validate',
    'common/validateRules',
    'jquery.serialize',
    'component/backToTop',
    'pagination',
    'laydate',
    'jquery.placeholder',
    'jquery.icinfo'
], function (layer, util, http,handlebars,paginationPage) {
    $('input, textarea').placeholder();
    $('.js-ipt-box').expandInput();
    var _sysUrl=window._CONFIG._sysUrl;
    init();
    /**
     * 初始化函数集合
     */

    function init() {
		$(":radio").attr("disabled","disabled");
		$(":checkbox").attr("disabled","disabled");
		$(".ipt-txt").attr("readonly","readonly");
		init_table();
    }


    //列表初始化
    function init_table(){
        var options = {
            page:0,                                     //开始页
            length:5,                                   //长度
            items_per_page:5,                           //每页显示几条              默认10条
            params:$('#_params').serializeObject(),     //查询参数,                 必填项
            url:_sysUrl+'/cominfoserver/sfcHonorlist.json',    //url 访问路径              必填项
            type:'post',                                //请求方式
            pagination:'#pagination',                   //分页显示的位置             必填项
            myTemplate:'#table-template',               //script:模板路径           必填项
            html:'#_listPage',                          //需要渲染的html            必填项
            total:'#_total',                            //显示页面总数的位置         必填项
            pageNmber:'#_pageNum'                      //显示多少页的位置           必填项
        };
       paginationPage.loadData(options);

    };

});

