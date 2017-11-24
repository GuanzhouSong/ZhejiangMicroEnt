require([
    'component/iframeLayer',
    'common/util',
    'common/http',
    'handlebars',
    'component/paginationPage',
    'jquery.validate',
    'common/validateRules',
    'jquery.serialize'
], function (layer, util, http,handlebars,paginationPage) {
	


    init();
    
   
    
    /**
     * 初始化函数集合
     */
    function init() {
        bind(); 
        setTimeout(function(){
        	$("#zhxxli").click();
        },1000);
    };

    //按钮事件
    function bind() {
        util.bindEvents([
            {
                el: '.js-item',   //tab 表单的切换
                event: 'click',
                handler: function () { 
                    $(".js-type-tab").find(".js-item").find("span").removeClass("tab-selected");
                    $(this).find("span").addClass("tab-selected");
                    var item = $(this).data("name"); //tab 名称
                    $(".js-tab-content").find(".tab-panel").removeClass("tab-panel-show"); //移出掉
        			setTimeout(function(){
                	   var iframeHeight = $("#"+item+"iframe").contents().find("body").innerHeight();
                       $("#"+item+" iframe").css("height",iframeHeight+"px");
                    },500);
                    $("#"+item).addClass("tab-panel-show");
                }
            }
        ])
    }
});


