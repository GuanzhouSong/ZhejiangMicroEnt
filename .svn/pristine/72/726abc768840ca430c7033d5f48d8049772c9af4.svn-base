require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {


    init();

    /**
     * 初始化函数集合
     */

    function init() {
        bind();
    }
    
    $("#deptCatgM").multipleSelect({
    	selectAllText: '全部',
    	allSelected: '工商行政管理类,食品药品管理类,质量技术监督类,安全生产类,物价管理类',
    	selectAllDelimiter: '',
    	minimumCountSelected: 10
    });
   
    function bind() {
        util.bindEvents([{
            el: '#cancel',
            event: 'click',
            handler: function () {
                layer.close();
              }
        }])
    }

})