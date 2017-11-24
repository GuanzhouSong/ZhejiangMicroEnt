require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
    }


    var table;
    var params = {};//表格查询参数

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        var tpl = $('#tpl').html();
        var template = handlebars.compile(tpl);
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
            showIndex: true,
            ajax: {
                type:"get",
                url:'/reg/server/entdbauth/listAssignRecord.json',
                data:function(d){
                    d.params = params;
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
                {data: null, className: 'center'},
                {data: ''},
                {data: 'entName'},
                {data: 'assignUserName'},
                {data: 'assignDeptName'},
                {data: 'setTime'},
                {data: 'setName'}

            ],
            columnDefs: [

                {   targets:1,
                    render:function(data,type,row,meta){
                        var context = {
                            func: [
                                {
                                    'text': '取消指定',
                                    'class': 'js-cancle'
                                }
                            ]
                        };
                        return template(context);
                    }
                }
            ]
        })
    }

    function bind() {
        util.bindEvents([
            {
                el: '#search',
                event: 'click',
                handler: function () {
                    params = $("#entSearchForm").serializeObject();
                    table.ajax.reload();
                }
            },
            {
            el: '.js-cancle',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.confirm('确定要取消该指定分配吗?', {icon: 2, title: '提示'}, function (index) {
                    http.httpRequest({
                        url: '/reg/server/entdbauth/cancle_assign',
                        data: {assignUID:data.uid,userId: data.assignUserId,priPID:data.priPID},
                        success: function (data) {
                            if (data.status == 'success') {
                                //重新加载列表数据
                                if (data.msg) {
                                    layer.msg(data.msg, {time: 500}, function () {
                                        table.ajax.reload();
                                    });
                                }
                            }
                        }
                    });

                });
            }
        }]);
    }

})
