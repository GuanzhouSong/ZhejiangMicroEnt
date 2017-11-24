require(['component/iframeLayer', 'component/dataTable','common/util',
'common/http', 'handlebars', 'jquery','jquery.serialize','laydate',
    'jquery.validate', 'select2'], function (layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
        $("#lecences").select2({
         ajax: {
            url: "/reg/server/yr/syslicense/listSelect.json",
            dataType: 'json',
            delay: 250,
            data: function (params) {
              return {
                licName: params.term
              };
            },
            processResults: function (data) {
              return {
                results: data.data
              }
            },
            cache: true
          },
         allowClear:true,
         multiple:'multiple',
         // language: "zh-CN",
         placeholder:'请输入关键字进行搜索'
         });
      //  $("#lecences").click();
    }

    function bind() {
        util.bindEvents([

{
                    el: '#save',
                    event: 'click',
                    handler: function () {
                    var code='';
                    var name='';
                    $('#lecences option:selected').each(function(){
                    code+=','+$(this).val();
                    name+=','+$(this).text();
                    });
                    layer.close({name:name.substr(1),code:code.substr(1)});
                    }
},
 {
                     el: '#cancel',
                     event: 'click',
                     handler: function () {
                       layer.close();
                     }
                 }
])
    }

})
