require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	bind();
     }
  
    function bind() {
    	 util.bindEvents([
    	 {
             el: '.toDetail',
             event: 'click',
             handler: function () {
            	 var busExcList = $(this).attr("value");
            	 layer.dialog({
                     title: '异常标记详情',
                     area: ['1024px', '400px'],
                     content: '/reg/server/opanomaly/pbopanomaly/toDetail?busExcList='+busExcList,
                     callback: function(data){
                   	  
                     }
                 });
             }
         }]);
    }

});
