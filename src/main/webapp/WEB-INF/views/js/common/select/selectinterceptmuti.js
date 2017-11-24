require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery', 'jquery.serialize', 'common/validateRules'], function (layer, dataTable, util, http, handlebars) {

    var selecttype = $('#selecttype').val();
    init();

    function init() {
        getSelectText()
        bind();
    }


    function getSelectText() {
        var template = handlebars.compile($('#listTemplate').html());
        $('.select-intercept').html(template(window[selecttype]));
    }

    //事件绑定
    function bind() {
        util.bindEvents([{
            el: '#save',
            event: 'click',
            handler: function () {
                var data={};
                data.text = $(".select-intercept input[type='checkbox']:checked").parent().next('span').text();
                
                var categCode=new Array();
        		$(".select-intercept input[type='checkbox']:checked").each(function(k,v){
        			categCode[k]= this.value;
        		});
                data.id=categCode;

                if (!data.text) {
                    layer.msg("请选择！", {time: 1500}, function () {
                    });
                    return false;
                }
                layer.close(data);
            }
        }, {
            el: '#cancel',
            event: 'click',
            handler: function (){
                layer.close();
            }

        }])
    }
})
