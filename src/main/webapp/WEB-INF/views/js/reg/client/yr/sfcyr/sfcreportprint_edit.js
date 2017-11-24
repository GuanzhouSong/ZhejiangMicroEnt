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
            el: '#sfcprintreport',
            event: 'click',
            handler: function () {
                var _id = "_doPrint_"+new Date().getTime();
                 var url = "/reg/client/yr/sfc/yrprint/showSfcReportProve?year="+window._CONFIG._year+"&pripid="+window._CONFIG._pripid+"&printFalg=2";
                try{
                    window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
                }catch(e){
                    alert("打印错误!");
                }
               /* layer.dialog({
                    title: '打印年度报告证明',
                    area: ['100%', '100%'],
                    content: url,
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                 })*/
            }
        }
        ])
    }

})
