/**
 * Created by wangjin .
 */
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
        var handleHelper = handlebars.registerHelper("addOne", function(index) {return index+1;});//序号
        handlebars.registerHelper("altDate", function(altDate) {
        	if(altDate != null && altDate != "") {
        		return util.dateFormat(new Date(util.dateTransform(altDate)),"yy年mm月dd日");
        	}else{
        		return "";
        	}
    	});
        handlebars.registerHelper("dataList", function(dataList) {
                 if(dataList == null || dataList == ""){
                	 return "display:none";
                 }else{
                	 return "";
                 }
        });
        handlebars.registerHelper("licValFrom", function(licValFrom) {
        	if(licValFrom != null && licValFrom != "") {
        		return util.dateFormat(new Date(util.dateTransform(licValFrom)),"yy年mm月dd日");
        	}else{
        		return "";
        	}
    	});
        handlebars.registerHelper("licValTo", function(licValTo) {
        	if(licValTo != null && licValTo != "") {
        		return util.dateFormat(new Date(util.dateTransform(licValTo)),"yy年mm月dd日");
        	}else{
        		return "";
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
            url:'/pub/pubohterlicence/list_data',    //url 访问路径              必填项
            type:'post',                                //请求方式
            pagination:'#pagination',                   //分页显示的位置             必填项
            myTemplate:'#table-template',               //script:模板路径           必填项
            html:'#_listData',                          //需要渲染的html            必填项
            total:'#_total',                            //显示页面总数的位置         必填项
            pageNmber:'#_pageNum'                      //显示多少页的位置           必填项
        };
        paginationPage.loadData(options);

    };


});