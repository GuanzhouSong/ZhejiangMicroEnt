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
    var searchParams={};//查询参数声明!
    var clickFlag = false ;
    /**
     * 初始化dataTable
     */
    function initDataTable() {
        var tpl = $('#tpl').html();
        var template = handlebars.compile(tpl);
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#sysversion-table',
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/reg/server/sysversion/list.json',
                data:function(d){
                	if(clickFlag){
                		 d.params = searchParams;
                	}
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
				{data: null,width: '12%',className: 'center'},
				{data: 'title',width: '12%', className: 'center'},
				{data: 'contents',width: '37%'},
				{data: 'setName',width: '10%'},
				{data: 'createTime',width: '17%'},
				{data: null,width: '12%',className: 'center'}
            ],
            columnDefs: [{
                 targets: 5,
                 render: function (data, type, row, meta) {
                     var context = {
                         func: [
                             {
                                 'text': '编辑',
                                 'class': 'pointer js-edit'
                             },
                             {
                                 'text': '删除',
                                 'class': 'pointer js-delete'
                             }
                         ]
                     };
                     return template(context);
                 }
             }]
        });
    }
    
  //表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#taskForm").serializeObject();
    	clickFlag =true;
        table.ajax.reload();
    }); 
    
    //按钮事件
    function bind() {
        util.bindEvents([{
            el: '#addSysVersion',
            event: 'click',
            handler: function () {
                layer.dialog({
                    title: '版本新增页面',
                    area: ['60%', '60%'],
                    content: '/reg/server/sysversion/show',
                    scrollbar: true,
                    callback: function (data) {
                    	if(data.reload == true){
                    		table.ajax.reload();
                    	}
                    }
                });
            }
        },{
            el: '.js-edit',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.dialog({
                    title: '修改',
                    area: ['60%', '60%'],
                    content: '/reg/server/sysversion/show?sysVersionId=' + data.id,
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        }, {
            el: '.js-delete',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.confirm('确定要删除吗?', {icon: 2, title: '提示'}, function (index) {
                    http.httpRequest({
                        url: '/reg/server/sysversion/delete',
                        data: {sysVersionId: data.id},
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
        },
        {
            el: '.js-clearAaddressMap',  //刷新操作
            event: 'click',
            handler: function () {
                http.httpRequest({
                    url: '/reg/server/yr/SelectCodeAddress/refresh',
                    serializable: false,
                    data: {},
                    type: 'post',
                    success: function (data) {
                        if (data.status = 'success') layer.msg(data.msg);
                    }
                });
            }
        }
        ]);
    }
});
