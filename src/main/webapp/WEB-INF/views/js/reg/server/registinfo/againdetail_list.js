require(['component/iframeLayer', 'component/dataTable','common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */

    function init() {
        initDataTable();
        bind();
    }



    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        var searchParams={priPID:_priPID};//查询参数声明!
        var tpl = $('#tpl').html();
        var template = handlebars.compile(tpl);
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/reg/server/registinfo/registinfo/againdetailList.json',
                data:function(d){
	               		 d.params = searchParams;
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //'className'不要写成class
            columns: [
                {data: null, 'className': 'center'},
                {data: 'altContent'},
                {data: 'altBeContent'},
                {data: 'altAfContent'},
                {data: 'altDate'}
            ],
            columnDefs: [
				/* {  targets:1,
                    render:function(data,type,row,meta){
                    if(data =='02'){
                    return '住所(营业场所、地址)变更';
                    }else if(data =='04'){
                     return '企业类型变更';
                    }else if(data =='11'){
                     return '行业代码变更';
                    }else if(data =='12'){
                      return '经营范围(业务范围)变更';
                     }
                   else if(data =='14'){
                      return '登记机关变更';
                     }
                   else if(data =='24'){
                      return '个体其他形式变更';
                     }
                     else return '';
              }
              }*/
            ]
        })
    }

    function bind() {
        util.bindEvents([
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
