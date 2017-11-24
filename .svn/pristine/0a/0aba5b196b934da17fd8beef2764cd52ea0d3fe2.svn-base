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
            var sendTimeStart = {
                elem: '#sendTimeStart', //选择ID为START的input
                format: 'YYYY-MM-DD', //自动生成的时间格式
                min: '1900-01-01', //设定最小日期为当前日期
                max: '2299-06-16', //最大日期
                istime: true, //必须填入时间
                istoday: false,  //是否是当天
                start: laydate.now(0,"YYYY-MM-DD"),  //设置开始时间为当前时间
                choose: function(datas){
                    sendTimeEnd.min = datas; //开始日选好后，重置结束日的最小日期
                    sendTimeEnd.start = datas; //将结束日的初始值设定为开始日
                }
            };
            var sendTimeEnd = {
                elem: '#sendTimeEnd',
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

            var writReceiveTimeStart = {
                elem: '#writReceiveTimeStart', //选择ID为START的input
                format: 'YYYY-MM-DD', //自动生成的时间格式
                min: '1900-01-01', //设定最小日期为当前日期
                max: '2299-06-16', //最大日期
                istime: true, //必须填入时间
                istoday: false,  //是否是当天
                start: laydate.now(0,"YYYY-MM-DD"),  //设置开始时间为当前时间
                choose: function(datas){
                    writReceiveTimeEnd.min = datas; //开始日选好后，重置结束日的最小日期
                    writReceiveTimeEnd.start = datas; //将结束日的初始值设定为开始日
                }
            };
            var writReceiveTimeEnd = {
                elem: '#writReceiveTimeEnd',
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
            $("#sendTimeStart").click(function(){laydate(sendTimeStart);});
            $("#sendTimeEnd").click(function(){laydate(sendTimeEnd);});
            $("#writReceiveTimeStart").click(function(){laydate(writReceiveTimeStart);});
            $("#writReceiveTimeEnd").click(function(){laydate(writReceiveTimeEnd);});

        };
    /*****************时间控件初始化 end *************************/
    var table;
    var searchParams={};//查询参数
    var firstRequest = 0;//首次进入页面不加载数据
    var regStateList = [];

    init();//初始化
    function init(){
        dateTime();
        bind();
        getRegStateList();
    }
    
    /*****************登记状态 start *************************/
    //登记状态初始化
    $("#regStateM").multipleSelect({
        selectAllText: '全部',
        allSelected: '全部',
        selectAllDelimiter: '',
        minimumCountSelected: 10
    });
    
    //获取登记状态
    function getRegStateList() {
    	$('#regStateM option').each(function(){
    		var states = [];
    		states = $(this).val().split(",");
    		for(var i in states){
    			regStateList.push({code: states[i] , text : $(this).text()});
    		};
    	});
    }
    
    function switchRegStateList(val) {
        var flag = "-";
        $.each(regStateList, function(i, n) {
            if (n.code.toUpperCase() == val.toUpperCase()) {
                flag = n.text;
            }
        });
        return flag;
    }
    /*****************登记状态 end *************************/

    /****************************************************** 格式转化 为datatable服务 start *****************************************************************/
    //文书类别格式转化
    var writType = function (data) {
        var txt = '';
        if (data == '1')return txt = '行政指导书';
        if (data == '2')return txt = '责令整改书';
        if (data == '3')return txt = '抽查检查通知书';
        if (data == '4')return txt = '列入经营异常名录决定书';
        if (data == '5')return txt = '移出经营异常名录决定书';
        if (data == '6')return txt = '撤销列入经营异常名录决定书';

        return txt;
    };

    /****************************************************** 格式转化 为datatable服务 end *****************************************************************/

    //加载数据列表
    function initDataTable() {
        firstRequest = '1';
        table = dataTable.load({
            el: '#writ-table',
            showIndex: true,
            scrollX:true,
            bAutoWidth:false,//是否自适应宽度
            ajax: {
                type : "post",
                url:'/reg/server/writ/list_json',
                data:function(d){d.params = searchParams;}
            },
            columns: [
                {data: "_idx",width:'20px'},
                {data: null,width:'60px'},
                {data: 'writType'},
                {data: 'uniCode'},
                {data: 'regNO'},
                {data: 'entName',cut: {length: 20,mark:'...'}},
                {data: 'leRep'},
                {data: 'sendTime'},
                {data: 'sendPeople'},
                {data: 'noticePeople'},
                {data: 'tel'},
                {data: 'messageLookStatue'},
                {data: 'writReceiveStatue'},
                {data: 'informNum'},
                {data: 'newestInformTime'},
                {data: 'regOrg'},
                {data: 'localAdmName'},
                {data: 'sliceNOName'},
                {data: 'regState'}
            ],
            columnDefs : [
                {
                    targets: 1,
                    render: function (data, type, row, meta) {
                        return "<a class='mr10 js-view' target='_blank'>查看详情</a></a>";
                    }
                },
                {
                    targets: 2,
                    render: function (data, type, row, meta) {
                        return writType(row.writType);
                    }
                },
                {
                    targets: 3,
                    render: function (data, type, row, meta) {
                        var text = '-';
                        if(row.uniCode){text =  row.uniCode;}
                        return text;
                    }

                },
                {
                    targets: 4,
                    render: function (data, type, row, meta) {
                        var text = '-';
                        if(row.regNO){text = row.regNO}
                        return text;
                    }

                },
                {
                    targets: 11,
                    render: function (data, type, row, meta) {
                        return row.messageLookStatue=='1'?'<em style="color: green">已查阅</em>':'<em style="color: red">未查阅</em>';
                    }
                },
                {
                    targets: 12,
                    render: function (data, type, row, meta) {
                        console.log("回执状态："+row.writReceiveStatue);
                        return row.writReceiveStatue=='1'?'<em style="color: green">已回执</em>':'<em style="color: red">未回执</em>';
                    }
                },
                {
                    targets: 18,
                    render: function (data, type, row, meta) {
                    	return switchRegStateList(row.regState);
                    }
                }
            ],
            initComplete: function(settings, json){

            },
            fnDrawCallback:function(nRow) {  //回调函数
                countResut();
            }
        });
    }

    //计算统计结果集
    function countResut(){
        $("#js-qysum").text('获取中...');$("#js-wssum").text('获取中...');$("#js-look").text('获取中...');$("#js-notLook").text('获取中...');
        var params = searchParams;
        http.httpRequest({
            url: '/reg/server/writ/writCount',
            serializable: false,
            data:{params:params},
            type: 'post',
            beforeSend:function(){ },//发送前执
            success: function (data) {
                var $thisData = data.data;
                if($thisData){
                    $("#js-qysum").text($thisData.entNameNum);
                    $("#js-wssum").text($thisData.writNum);
                    $("#js-look").text($thisData.lookNum);
                    $("#js-notLook").text($thisData.notLookNum);
                }
            }
        });
    }

    //查询
    $('#js-search').click(function(){
        ////输入的内容去掉前后空格
        $('#writForm').find('.js-trim').each(function(){$(this).val($.trim($(this).val()));});

        //获取主体类别
        var entTypeCatg = [];
        $("input:checkbox[name='entCatg']:checked").each(function () {entTypeCatg.push($(this).val());});
        entTypeCatg.length>0?$('#entTypeCatg').val(entTypeCatg.toString()):layer.msg('主体类别必选一项');

        //登记状态
        $("#regState").val($("#regStateM").val());

        searchParams = $("#writForm").serializeObject();
        //去掉不用传递的参数
        delete searchParams.regStateM;
        delete searchParams.entCatg;

        //重新加载列表
        firstRequest =='0'?initDataTable():table.ajax.reload();

    });

    //重置
    $('#js-reset').click(function(){
        $('#writForm')[0].reset();
        $('#writForm .js-clearValue').val('');
        $('#regStateM').multipleSelect('setSelects',[$('#regStateM option[title="CUNXU"]').val()]);
    });

    //触发事件
    function bind() {
        util.bindEvents([
            {
                el: '.js-view',
                event: 'click',
                handler: function () {
                    var data = table.row($(this).closest('td')).data();
                    var priPID = data.priPID;
                    var noticePeople = data.noticePeople;
                    var tel = data.tel;
                    var uuid = data.uuid;
                    if(priPID&&noticePeople&&tel&&uuid){layer.msg("未获取到选中行的参数,操作失败!");}
                    //测试页面：
                    var url = '/reg/server/writ/writDetails?priPID='+priPID+"&noticePeople="+noticePeople+"&tel="+tel+"&uuid="+uuid;
                    //window.open (url);
                    //window.open (url, "newwindow");
                    layer.dialog({
                        title: '文书回执详情',
                        area: ['95%', '95%'],
                        content: url
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
            }
        ]);
    }
});