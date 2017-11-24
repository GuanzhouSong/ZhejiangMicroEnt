require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery', 'jquery.serialize', 'laydate'], function (layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
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
            selectExport:true,
            //是否加索引值
            showIndex: true,
            ajax: {
                url: '/syn/server/opanomaly/pubopanomaly/getEntForDatajoinJSON.json',
                data: function (d) {
                    d.params = searchParams;
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //'className'不要写成class
            columns: [
                {data: null, 'defaultContent': '11'},
                {data: null,'defaultContent': '11'},
                {data: 'entName'},
                {data: 'uniSCID'},
                {data: 'estDate'},
                {data: 'penDecNo'},
                {data: 'abnTime'},
                {data: 'speCauseCN'},
                {data: 'decorgCN'},
                {data: 'downState'}
            ],
            columnDefs: [
                {   targets:1,
                    render:function(data,type,row,meta){
                        return  '<input type="checkbox" name="_checkbox" data-downstate="'+row.downState+'" data-pripid="'+row.priPID+'"  value='+row.id+'>';
                    }
                },
                {   targets:2,
                    render:function(data,type,row,meta){
                        return '<a href="javascript:void(0);" class="js-view">'+data+'</a>'
                    }
                },
                {
                    targets: 'uniCode',
                    render: function (data, type, row, meta) {
                        if (data == null || data == '')return '<a href="javascript:void(0);" class="js-view">'+row.regNO+'</a>';
                        else return '<a href="javascript:void(0);" class="js-view">'+data+'</a>';
                    }
                },
                {
                    targets: 'downstate',
                    render: function (data, type, row, meta) {
                        if(data>0)
                            return '已下载';
                        else
                            return "<a href='javascript:void(0);' class='js-download'>未下载</a>";
                    }
                }
            ],
            "drawCallback": function( settings ) {
                count_downinfo(searchParams);
            }

        })
    }

    //draw事件，统计下载信息
    function count_downinfo(searchParams) {
        var total=0;downed=0;nondown=0;
        var tinfo = $('#user-table_info').html();
        total=$.trim(tinfo.substring(tinfo.indexOf('共')+1,tinfo.lastIndexOf('项'))).replace(/,/g,'');
        http.httpRequest({
            url: '/syn/server/opanomaly/pubopanomaly/getEntForDatajoinJSON_downednum',
            serializable: false,
            data: searchParams,
            type: 'post',
            success: function (data) {
                downed=data.data;
                nondown=total-downed;
                if(nondown<0) nondown=0;
                var info = '共 '+total+' 条，已下载 '+downed+' 条，未下载 '+nondown+' 条';
                $('#downinfo').html(info);
            }
        });

    }
    function bind() {
        util.bindEvents([
            {
                el: '.js-batchdownload',
                event: 'click',
                handler: function () {
                    var ItemIds = new Array();
                    var ItemPripids = new Array();
                    var index = 0;
                    var flag=false;
                    $("input[name=_checkbox]:checked").each(function () {
                        ItemIds[index] = $(this).val();
                        ItemPripids[index] = $(this).data('pripid');
                        if($(this).data('downstate')=='1'){
                            flag=true;
                        }
                        index++;
                    });
                    if(flag){
                        layer.msg("已下载的不能重复下载", {ltype: 0, time: 500});
                        return false;
                    }
                    if (ItemIds.length == 0) {
                        layer.msg("请选择一项进行操作", {ltype: 0, time: 500});
                        return false;
                    }
                    $('.buttons-excel ').trigger('click');
                    http.httpRequest({
                        url: '/syn/infomange/inforecestat/save',
                        serializable: false,
                        data: {'id':ItemIds.toString(),'priPID':ItemPripids.toString(),'type':'3'},
                        type: 'post',
                        success: function (data) {
                            layer.msg(data.msg, {time: 1000}, function () {
                                if(data.status=='success'){
                                    table.ajax.reload();
                                }
                            });
                        }
                    });

                }
            },
            {
                el: '.js-download',
                event: 'click',
                handler: function () {
                    var data = table.row($(this).closest('td')).data();
                    http.httpRequest({
                        url: '/syn/infomange/inforecestat/save',
                        serializable: false,
                        data: {'id':data.id,'priPID':data.priPID,'type':'3'},
                        type: 'post',
                        success: function (data) {
                            layer.msg(data.msg, {time: 1000}, function () {
                                if(data.status=='success'){
                                    table.ajax.reload();
                                }
                            });
                        }
                    });
                    table.row($(this).closest('td')).select();
                    $('.buttons-excel ').trigger('click');
                }
            },
            {
                el: '.js-view',
                event: 'click',
                handler: function () {
                    var data = table.row($(this).closest('td')).data();
                    layer.dialog({
                        title: '照面信息',
                        area: ['70%', '60%'],
                        content: '/syn/anonpunish/anonpunish/toedit?pripid=' + data.priPID,
                        callback: function () {
                        }
                    })
                }
            },

            {
                el: '#qry',
                event: 'click',
                handler: function () {
                    searchParams = $("#qryForm").serializeObject();
                    table.ajax.reload();
                }
            },
            {
                el: '#cancel',
                event: 'click',
                handler: function () {
                    $(':input', '#qryForm')
                        .not(':button, :submit, :reset')
                        .val('')
                        .removeAttr('checked')
                        .removeAttr('selected');
                }
            },
            {
                el: '#checkAll',
                event: 'click',
                handler: function () {
                    var flag = $(this).prop("checked");
                    $("input[name='_checkbox']").prop("checked", flag);
                    if(flag){
                        table.rows( 'tr' ).select();
                    }else{
                        table.rows( 'tr' ).deselect();
                    }
                }
            }

        ])
    }

})
