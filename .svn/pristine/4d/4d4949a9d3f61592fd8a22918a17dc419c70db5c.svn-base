require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery', 'jquery.serialize', 'common/validateRules'], function (layer, dataTable, util, http, handlebars) {

    var selecttype = $('#selecttype').val();
    init();

    function init() {
        getSelectText()
        bind();
    }


    function getSelectText() {
        var template = handlebars.compile($('#listTemplate').html());
        var data = window[selecttype];
        for(var i=0;i<data.length;i++){
        	if(data[i].text.indexOf('】') != -1){
        		var splitArry = data[i].text.split('】');
            	data[i].text1 = splitArry[0]+'】';
            	data[i].text2 = splitArry[1];
        	}else{
        		data[i].text2 = data[i].text;
        	}
        }
        $('.select-intercept').html(template(data));
    }

    //事件绑定
    function bind() {
        util.bindEvents([{
            el: '#save',
            event: 'click',
            handler: function () {
                var data={};
                data.text = $(".select-intercept input[type='radio']:checked").parent().next('span').text();
                data.id=$(".select-intercept input[type='radio']:checked").attr('id');

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
