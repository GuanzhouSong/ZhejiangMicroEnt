/**
 * Created by wangjin on 2017-06-13.
 */
require([
    'component/iframeLayer',
    'component/dataTable',
    'common/util',
    'common/http',
    'laydate',
    'jquery.validate',
    'common/validateRules',
    'jquery.serialize',
    'jquery.multiselect'
], function (layer,dataTable, util, http) {

    /*****************时间控件初始化 start*************************/
    //时间控件初始
    var dateTime = function(){
        var start1 = {
            elem: '#applyDateStart', //选择ID为START的input
            format: 'YYYY-MM-DD', //自动生成的时间格式
            min: '1900-01-01', //设定最小日期为当前日期
            max: '2299-06-16', //最大日期
            istime: true, //必须填入时间
            istoday: false,  //是否是当天
            start: laydate.now(0,"YYYY-MM-DD"),  //设置开始时间为当前时间
            choose: function(datas){
                end1.min = datas; //开始日选好后，重置结束日的最小日期
                end1.start = datas; //将结束日的初始值设定为开始日
            }
        };
        var end1 = {
            elem: '#applyDateEnd',
            format: 'YYYY-MM-DD',
            min: '1900-01-01', //设定最小日期为当前日期
            max: '2299-06-16', //最大日期
            istime: true,
            istoday: false,
            start: laydate.now(0,"YYYY-MM-DD"),
            choose: function(datas){
                sendTimeStart.max = datas; //结束日选好后，重置开始日的最大日期
            }
        };

        var start2 = {
            elem: '#feedbackDateStart', //选择ID为START的input
            format: 'YYYY-MM-DD', //自动生成的时间格式
            min: '1900-01-01', //设定最小日期为当前日期
            max: '2299-06-16', //最大日期
            istime: true, //必须填入时间
            istoday: false,  //是否是当天
            start: laydate.now(0,"YYYY-MM-DD"),  //设置开始时间为当前时间
            choose: function(datas){
                end2.min = datas; //开始日选好后，重置结束日的最小日期
                end2.start = datas; //将结束日的初始值设定为开始日
            }
        };
        var end2 = {
            elem: '#feedbackDateEnd',
            format: 'YYYY-MM-DD',
            min: '1900-01-01', //设定最小日期为当前日期
            max: '2299-06-16', //最大日期
            istime: true,
            istoday: false,
            start: laydate.now(0,"YYYY-MM-DD"),
            choose: function(datas){
                writReceiveTimeStart.max = datas; //结束日选好后，重置开始日的最大日期
            }
        };
        //时间开始和结束
        $("#applyDateStart").click(function(){laydate(start1);});
        $("#applyDateEnd").click(function(){laydate(end1);});
        $("#feedbackDateStart").click(function(){laydate(start2);});
        $("#feedbackDateEnd").click(function(){laydate(end2);});

    };
    /*****************时间控件初始化 end *************************/



    var table;
    var searchParams={};//查询参数
    var firstRequest = 0;//首次进入页面不加载数据

    init();//初始化
    function init(){
        dateTime();
        bind();
        //initDataTable();
    }

    //加载数据列表
    function initDataTable() {
        firstRequest = '1';
        table = dataTable.load({
            el: '#data-table',
            showIndex: true,
            scrollX:true,
            bAutoWidth:false,//是否自适应宽度
            ajax: {
                type : "post",
                url:'/reg/server/datamodify/list_json',
                data:function(d){d.params = searchParams;}
            },
            columns: [
                {data: "_idx",width:'20px'},
                {data: null,width:'60px'},
                {data: 'uniCode',width:'60px'},
                {data: 'entName',cut: {length: 20,mark:'...'},width:'100px'},
                {data: 'applyPerson',width:'40px'},
                {data: 'applyDate',width:'40px'},
                {data: 'phone',width:'40px'},
                {data: 'feedbackDate',width:'40px'}
            ],
            columnDefs : [
                {
                    targets: 1,
                    render: function (data, type, row, meta) {
                        return "<a class='mr10 js-view' t>详情</a></a>";
                    }
                },
                {
                    targets: 5,
                    render: function (data, type, row, meta) {
                        if(!row.applyDate){return "-"}else{return util.dateFtt('yyyy-MM-dd',new Date(util.dateTransform(row.applyDate)));}
                    }
                },
                {
                    targets: 7,
                    render: function (data, type, row, meta) {
                        if(!row.feedbackDate){return "-"}else{return util.dateFtt('yyyy-MM-dd',new Date(util.dateTransform(row.feedbackDate)));}
                    }
                }
            ],
            initComplete: function(settings, json){

            },
            fnDrawCallback:function(nRow) {  //回调函数

            }
        });
    }


    //查询
    $('#js-search').click(function(){
        ////输入的内容去掉前后空格
        $('#searchForm').find('.js-trim').each(function(){$(this).val($.trim($(this).val()));});
        searchParams = $("#searchForm").serializeObject();
        //重新加载列表
        firstRequest =='0'?initDataTable():table.ajax.reload();
    });

    //重置
    $('#js-reset').click(function(){
        $('#searchForm')[0].reset();
        $('#searchForm .js-clearValue').val('');
    });

    //触发事件
    function bind() {
        util.bindEvents([
            {
                el: '.js-view',
                event: 'click',
                handler: function () {
                    var data = table.row($(this).closest('td')).data();
                    var uid = data.uid;
                    if(!uid){layer.msg("未获取参数,操作失败!"); return;}
                    //测试页面：
                    var url = '/reg/server/datamodify/mid_data_view?uid='+uid;
                    layer.dialog({
                        title: '详情',
                        area: ['80%', '80%'],
                        content: url,
                        callback: function(data) {

                        }
                    });

                }
            },
            {
                el: '.js-choseorgReg',  //登记机关
                event: 'click',
                handler: function() {
                    layer.dialog({
                        title: '选择登记机关',
                        area: ['400px', '600px'],
                        content: '/commom/server/regorg/regorgmutiselect?isPermissionCheck=true',
                        callback: function(data) {
                            var returncode = data.returncodes;
                            $("#regOrg").val(returncode);
                            $("#regOrgName").val(data.returnname);
                        }
                    })
                }
            },
            {
                el: '.js-chooseSliceNo',  //片区
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '选择片区',
                        area: ['400px', '600px'],
                        content: '/commom/server/sliceno/slicenomutiselect?isPermissionCheck=true',
                        callback: function (data) {
                            var returncode=data.returncode;
                            if(returncode!=null&&returncode!=""){
                                returncode=returncode.substr(0,returncode.length-1);
                            }
                            $("#sliceNo").val(returncode);
                            $("#sliceNoName").val(data.returnname);
                        }
                    })
                }
            },
            {
                el: '.js-choseregUnit', //管辖单位
                event: 'click',
                handler: function() {
                    layer.dialog({
                        title: '选择管辖单位',
                        area: ['400px', '600px'],
                        content: '/commom/server/regunit/regunitmutiselect?isPermissionCheck=true',
                        type:'post',
                        callback: function(data) {
                            var returncode = data.returncodes;
                            $("#localAdm").val(returncode);
                            $("#localAdmName").val(data.returnname);
                        }
                    })
                }
            },
            {
                el: '#js-add-datamodify', //新增数据修正
                event: 'click',
                handler: function() {
                    window.location.href='/reg/server/datamodify/mid_data_list';
                    return;
                  /*  layer.dialog({
                        title: '新增数据修正',
                        area: ['96%', '96%'],
                        content: '/reg/server/datamodify/mid_data_list',
                        callback: function(data) {

                        }
                    })*/
                }
            }

        ]);
    }
});