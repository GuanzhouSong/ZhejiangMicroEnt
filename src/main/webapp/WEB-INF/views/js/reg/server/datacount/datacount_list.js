require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery', 'jquery.serialize', 'laydate'], function (layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        // initDataTable();
        bind();
    }


    var searchParams = {};//查询参数声明!
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        var tpl = $('#tpl').html();
        var template = handlebars.compile(tpl);
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
            scrollX: true, //支持滚动
            pageLength: 100,
            //是否加索引值
            //  showIndex: true,
            ajax: {
                url: '/reg/server/datacount/list.json',
                data: function (d) {
                    if (typeof searchParams == 'undefined' || typeof searchParams.statLevel == 'undefined') {
                        d.params = {statLevel: 'RegOrg'};
                    } else {
                        d.params = searchParams;
                    }
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //'className'不要写成class
            columns: [
                {data: 'index'},
                {data: 'area'},
                {data: 'infoTrade'},
                {data: 'infoTrade_'},
                {data: 'environmentTrade'},
                {data: 'environmentTrade_'},
                {data: 'travelTrade'},
                {data: 'travelTrade_'},
                {data: 'financeTrade'},
                {data: 'financeTrade_'},
                {data: 'healthTrade'},
                {data: 'healthTrade_'},
                {data: 'popTrade'},
                {data: 'popTrade_'},
                {data: 'highInd'},
                {data: 'highInd_'},
                {data: 'countTrade'},
                {data: 'countTrade_'}

            ],
            /* "footerCallback": function ( row, data, start, end, display ) {
             var api = this.api();
             // Remove the formatting to get integer data for summation
             var intVal = function ( i ) {
             return typeof i === 'string' ?
             i.replace(/[\$,]/g, '')*1 :
             typeof i === 'number' ?
             i : 0;
             };

             for(var i=2;i<18;i++){
             // Total over this page
             var pageTotal = api
             .column( i, { page: 'current'} )
             .data()
             .reduce( function (a, b) {
             return intVal(a) + intVal(b);
             }, 0 );
             // Update footer
             $( api.column( i ).footer() ).html(pageTotal);
             }
             },*/
            columnDefs: [
                {
                    targets: [3,5,7,9,11,13,15,17],
                    render: function (data, type, row, meta) {
                        return outputdollars(data);
                    }
                }
            ]
            /*,
             "drawCallback": function( settings ) {
             table_index();
             }*/
        })
    }


    //格式化金额
    function outputdollars(number) {
        if (number.length <= 3)
            return (number == '' ? '0' : number);
        else {
            var mod = number.length % 3;
            var output = (mod == 0 ? '' : (number.substring(0, mod)));
            for (i = 0; i < Math.floor(number.length / 3); i++) {
                if ((mod == 0) && (i == 0))
                    output += number.substring(mod + 3 * i, mod + 3 * i + 3);
                else
                    output += ',' + number.substring(mod + 3 * i, mod + 3 * i + 3);
            }
            return (output);
        }
    }

//自己手动写的表格序号，--暂时没用
    function table_index() {
        var i = 0;
        var cellSize = 0;
        var nodes = table.column(0, {
            search: 'applied',
            order: 'applied'
        }).nodes();
        cellSize = nodes.length;
        nodes.each(function (cell, i) {
            //i 从0开始，所以这里先加1
            i = i + 1;
            //服务器模式下获取分页信息，使用 DT 提供的 API 直接获取分页信息
            var page = table.page.info();
            //当前第几页，从0开始
            var pageno = page.page;
            //每页数据
            var length = page.length;
            //行号等于 页数*每页数据长度+行号
            var columnIndex = (i + pageno * length);
            cell.innerHTML = columnIndex;
            /*        if(i<cellSize){
             //行号等于 页数*每页数据长度+行号
             var columnIndex = (i + pageno * length);
             cell.innerHTML = columnIndex;
             }else{
             cell.innerHTML ='<font color="red">合计：</font>';
             }*/

        });


    }

    function bind() {
        util.bindEvents([


            {
                el: '#qry',
                event: 'click',
                handler: function () {
                    searchParams = $("#qryForm").serializeObject();
                    if (table == null || typeof table == 'undefined') {
                        initDataTable();
                    }
                    else {
                        table.ajax.reload();
                    }
                }
            },
            {
                el: '#cancel',
                event: 'click',
                handler: function () {
                    $(':input', '#qryForm')
                        .not(':button, :submit, :reset')
                        .val('')
                        .removeAttr('checked');
                    $('#statLevel').val('RegOrg');
                }
            }
            , {
                el: '#choseorgReg',
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '选择登记机关',
                        area: ['25%', '60%'],
                        content: '/commom/server/regorg/regorgmutiselectnocheck',
                        callback: function (data) {
                            //重新加载列表数据
                            $("#regOrg").val(data.returncode);
                            $("#regOrgName").val(data.returnname);
                        }
                    })
                }
            },

            {
                el: '#choseregUnit',
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '选择管辖单位',
                        area: ['25%', '60%'],
                        content: '/commom/server/regunit/regunitmutiselectnocheck',
                        callback: function (data) {
                            //重新加载列表数据
                            $("#localAdm").val(data.returncodes);
                            $("#localAdmName").val(data.returnname);
                        }
                    })
                }
            },
            {
                el: '#choseEntType',
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '选择企业类型',
                        area: ['25%', '70%'],
                        content: '/commom/server/entcatg/entcatgmutiselectnocheck',
                        callback: function (data) {
                            //重新加载列表数据
                            $("#entType").val(data.returncodes);
                            var name = data.returnname;
                            $("#entTypeName").val(name);
                        }
                    })
                }
            }
        ])
    }

})
