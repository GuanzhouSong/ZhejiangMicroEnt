require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery'], function (layer, dataTable, util, http, handlebars) {

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
        	el:"#close",
        	event:'click',
        	handler:function(){
        		window.close();
        	}
        },
        {
            el: '#print',
            event: 'click',
            handler: function () {
                var _id = "_doPrint_"+new Date().getTime();
                 var url = "/reg/client/yr/ent/pubprint/showReportProvePage?year="+window._CONFIG._encodeYear+"&printFalg=2";
                 try{
                     window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
                 }catch(e){
                     alert("打印错误!");
                 }
                }
             }
        ])
    }

})
