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
    setTimeout(function(){$("#Prompting_show").hide();},8000);
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
    };

    //按钮事件
    function bind() {
        util.bindEvents([
            {
                el: '.js-item',   //tab 表单的切换
                event: 'click',
                handler: function () {
                    $('.js-type-tab').find('.js-item').addClass('tab-selected').not(this).removeClass('tab-selected');
                    var itemName = $(this).data('name');
                    $(".js-tab-content").find(".tab-panel").removeClass("tab-panel-show"); //移出掉
                    $("#"+itemName).addClass("tab-panel-show");
                   /* $(".js-type-tab").find(".js-item").find("span").removeClass("tab-selected");
                    $(this).find("span").addClass("tab-selected");
                    var item = $(this).data("name"); //tab 名称
                    $(".js-tab-content").find(".tab-panel").removeClass("tab-panel-show"); //移出掉
                    $("#"+item).addClass("tab-panel-show");*/
                }
            },
            {
                el: '#year_list',   //重新选择年份加载数据
                event: 'change',
                handler: function () {

                    var yearValue = $("#year_list").val();
                    if(!yearValue){return};
                    $("#params_year").val(yearValue);
                    //禁用select 选择
                    $("#year_list").prop("disabled",true);
                    layer.msg("页面加载数据需要点时间,请您耐心等待!", {icon: 6,time: 5000});
                    var url ='/server/yr_view/tab?'+$("#praramContent").serialize();
                    window.location.href=url;
                }
            },
            {
                el: '.js-fold',
                event: 'click',
                handler: function () {
                    if ($(this).hasClass('reverse')) {
                        $(this).html('收起详情<i></i>');
                        $(this).removeClass("reverse");
                        $(this).addClass("more");
                        $(".js-table-horizontal").show();
                    } else {
                        $(this).html('展开详情<i></i>');
                        $(this).addClass("reverse");
                        $(this).addClass("more");
                        $(".js-table-horizontal").hide();
                    }
                }
            },
            {
                el: '.dy-report-bg',  //打印年报年度报告
                event: 'click',
                handler: function () {
                    //获取选中的年份：
                    var yearValue = $("#year_list").val();
                    $('.js-year').each(function(){
                        if($(this).val()==yearValue){
                            layer.msg("打印年度报告加载数据需要点时间,请您耐心等待!", {icon: 6,time: 4000});
                            var year = $(this).data('year');
                            var pripid= $("#js-pripid").val();
                            var url = $('.js-reprot-year').val();
                            url = url+"?year="+year+"&priPID="+pripid+"&printFalg=2";
                            window.open(url);
                        }
                    });
                }
            },
            {
                el: '.dy-reprot-zm', //打印年度报告证明
                event: 'click',
                handler: function () {
                    //获取选中的年份：
                    var yearValue = $("#year_list").val();
                    $('.js-year').each(function(){
                        if($(this).val()==yearValue){
                            layer.msg("打印年度报告加载数据需要点时间,请您耐心等待!", {icon: 6,time: 4000});
                            var year = $(this).data('year');
                            var pripid= $("#js-pripid").val();
                            var url = $('.js-reprot-zm').val();
                            url = url+"?year="+year+"&priPID="+pripid;
                            window.open(url);
                        }
                    });
                }
            }
        ])
    }
});


