require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {
    var searchFlag="0";
    var searchParams = {};//查询参数声明!
    var table;
  
    init();
    //时间控件初始化
    // laydate.skin('molv');//初始化皮肤 (墨绿)
    var start = {
        elem: '#startCogDate', //选择ID为START的input
        format: 'YYYY-MM-DD', //自动生成的时间格式
        min: '1970-01-01', //设定最小日期为当前日期
        max: '2099-06-16', //最大日期
        istime: true, //必须填入时间
        istoday: false,  //是否是当天
        start: laydate.now(0, "YYYY-MM-DD"),  //设置开始时间为当前时间
        choose: function (datas) {
            end.min = datas; //开始日选好后，重置结束日的最小日期
            end.start = datas //将结束日的初始值设定为开始日
        }
    };
    var end = {
        elem: '#endCogDate',
        format: 'YYYY-MM-DD',
        min: '1970-01-01',
        max: '2099-06-16',
        istime: true,
        istoday: false,
        start: laydate.now(0, "YYYY-MM-DD"),
        choose: function (datas) {
            start.max = datas; //结束日选好后，重置开始日的最大日期
        }
    };

    var startNorDate = {
        elem: '#startNorDate', //选择ID为START的input
        format: 'YYYY-MM-DD', //自动生成的时间格式
        min: '1970-01-01', //设定最小日期为当前日期
        max: '2099-06-16', //最大日期
        istime: true, //必须填入时间
        istoday: false,  //是否是当天
        start: laydate.now(0, "YYYY-MM-DD"),  //设置开始时间为当前时间
        choose: function (datas) {
            endNorDate.min = datas; //开始日选好后，重置结束日的最小日期
            endNorDate.start = datas //将结束日的初始值设定为开始日
        }
    };
    var endNorDate = {
        elem: '#endNorDate',
        format: 'YYYY-MM-DD',
        min: '1970-01-01',
        max: '2099-06-16',
        istime: true,
        istoday: false,
        startNorDate: laydate.now(0, "YYYY-MM-DD"),
        choose: function (datas) {
            startNorDate.max = datas; //结束日选好后，重置开始日的最大日期
        }
    };


    var startExtDate = {
        elem: '#startExtDate', //选择ID为START的input
        format: 'YYYY-MM-DD', //自动生成的时间格式
        min: '1970-01-01', //设定最小日期为当前日期
        max: '2099-06-16', //最大日期
        istime: true, //必须填入时间
        istoday: false,  //是否是当天
        start: laydate.now(0, "YYYY-MM-DD"),  //设置开始时间为当前时间
        choose: function (datas) {
            endExtDate.min = datas; //开始日选好后，重置结束日的最小日期
            endExtDate.start = datas //将结束日的初始值设定为开始日
        }
    };
    var endExtDate = {
        elem: '#endExtDate',
        format: 'YYYY-MM-DD',
        min: '1970-01-01',
        max: '2099-06-16',
        istime: true,
        istoday: false,
        startExtDate: laydate.now(0, "YYYY-MM-DD"),
        choose: function (datas) {
            startExtDate.max = datas; //结束日选好后，重置开始日的最大日期
        }
    };

    //开始时间和结束时间
    $("#startCogDate").click(function () {
        laydate(start);
    });
    $("#endCogDate").click(function () {
        laydate(end);
    });

    $("#startNorDate").click(function () {
        laydate(startNorDate);
    });
    $("#endNorDate").click(function () {
        laydate(endNorDate);
    });

    $("#startExtDate").click(function () {
        laydate(startExtDate);
    });
    $("#endExtDate").click(function () {
        laydate(endExtDate);
    });


    /**
     * 初始化函数集合
     */
    function init() {
        //initDataTable();
        bind();
    }



    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	searchFlag="1";
    	searchParams = $("#taskForm").serializeObject();
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#pubopanomalylist_table',
            showIndex: true,
            scrollX: true, //支持滚动
            "aLengthMenu": [10, 25, 50, 100,1000,2000],
            //是否加索引值
            showIndex: true,
            ajax: {
                url: '/reg/server/opanomaly/pubopanomaly/selectPubOpanoMalySfcSearchListJSON.json',
                data: function (d) {
                    d.params = searchParams;
                }
            },
            columns: [
                {data: null, 'defaultContent': '11'},
                {data: null, width: "250px",defaultContent:'id' },
                {data: 'uniSCID',cut: {length: 20,mark:'...'}},
                {data: 'regNO',cut: {length: 20,mark:'...'}},
                {data: 'entName',cut: {length: 20,mark:'...'}},
                {data: 'leRep'},
                {data: 'estDate'},
                {data: 'speCauseCN',cut: {length: 20,mark:'...'}},
                {data: 'abnTime',cut: {length: 20,mark:'...'}},
                {data: 'decorgCN',cut: {length: 20,mark:'...'}},
                {data: 'isMove',cut: {length: 20,mark:'...'}},
                {data: 'canOutPenDecNo',cut: {length: 20,mark:'...'}},
                {data: 'remExcpresCN',cut: {length: 20,mark:'...'}},
                {data: 'remDate',cut: {length: 20,mark:'...'}},
                {data: 'reDecOrgCN',cut: {length: 20,mark:'...'}},
                {data: 'removeRea',cut: {length: 20,mark:'...'}},
                {data: 'dom',cut: {length: 20,mark:'...'}},
                {data: 'regOrgName',cut: {length: 20,mark:'...'}},
                {data: 'localAdmName',cut: {length: 20,mark:'...'}},
                {data: 'sliceNOName',cut: {length: 20,mark:'...'}}
            ],
            columnDefs: [
                {
                    targets: 1,
                    render: function (data, type, row, meta) {

                        return '<a class="printspbook link" id="' + row.busExcList + '" priPID="' + row.priPID + '" href="javascript:void(0);" style="color:blue;">' + row.penDecNo + '</a>';
                    }
                },
                {
                    targets: 10,
                    render: function (data, type, row, meta) {
                    	var auditState=row.auditState;
                        if (data == null || data == "") {
                            return "未移出";
                        } else if (data == "1") {
                        	if(auditState=="1"){ 
                        		 return "已移出";
                        	}else{
                        		 return "未移出";
                        	} 
                        } else if (data == "2") {
                        	if(auditState=="1"){ 
                                return "已撤销";
                        	}else{
                        		return "未撤销";
                        	} 
                        }
                    }
                }
            ],
            fnDrawCallback: function (nRow) {
                //统计查询结果
                getSearchResultCount();
            }
        })
    }


   


    //统计查询结果
    function getSearchResultCount() {
    	 $("#isPubCount").text("加载中...");
         $("#isInAndNotOutCount").text("加载中...");
         $("#isInAndIsOutCount").text("加载中...");
        http.httpRequest({
            url: '/reg/server/opanomaly/pubopanomaly/getSearchResultCount',
            serializable: false,
            data: null,
            type: 'get',
            success: function (data) {
                var isPubCount = data.data.isPubCount == null ? "0" : data.data.isPubCount;
                var isInAndNotOutCount = data.data.isInAndNotOutCount == null ? "0" : data.data.isInAndNotOutCount;
                var isInAndIsOutCount = data.data.isInAndIsOutCount == null ? "0" : data.data.isInAndIsOutCount;
                $("#isPubCount").text(isPubCount);
                $("#isInAndNotOutCount").text(isInAndNotOutCount);
                $("#isInAndIsOutCount").text(isInAndIsOutCount);
            }
        });
    }


    function bind() {
        util.bindEvents([{
            el: '.printspbook',
            event: 'click',
            handler: function () {
                var busExcList = this.id;
                var _id = "_doPrint_" + new Date().getTime();
                var url = "/reg/server/opanomaly/pubopanomaly/pubOpanoPrintJDBook?busExcList=" + busExcList;
                try {
                    window.open(url, _id, "menubar=no,location=no,resizable=yes,scrollbars=yes,status=no");
                } catch (e) {
                    alert("打印错误!");
                }
            }
        },
            {
                el: '#pubopanomalylist_table td',
                event: 'click',
                handler: function () {
                    //点击第一列第二列时不需要弹窗
                    var cellIndex = this.cellIndex;
                    if (cellIndex == 0 || cellIndex == 1) {
                        return false;
                    }
                    var data = table.row($(this)).data();
                    var url = "/reg/server/opanomaly/pubopanomaly/pubOpanoMalySearchViewPage?busExcList=" + data.busExcList;

                    layer.dialog({
                        title: '经营异常状态查询详情',
                        area: ['80%', '88%'],
                        content: url,
                        callback: function (data) {

                        }
                    })
                }
            },
            {
                el: '#cancel',
                event: 'click',
                handler: function () {
                    $("#regOrg").val("");
                    $("#localAdm").val("");
                    $("#remExcpres").val("");
                    $("#speCause").val("");
                    $("#sliceNO").val("");
                }
            }, {
                el: '#choseregUnit',
                event: 'click',
                handler: function () {
                	layer.dialog({
                        title: '选择管辖单位',
                        area: ['25%', '60%'],
                        content: '/commom/server/regunit/regunitmutiselect?isPermissionCheck=true',
                        callback: function (data) { 
                        	var returncode=data.returncodes;
                        	var returnname=data.returnname;	 
                          	$("#localAdm").val(returncode);
                          	$("#localAdmName").val(returnname);
                        }
                    })
                }
            }, {
                el: '#choseorgReg',
                event: 'click',
                handler: function () {
                	layer.dialog({
                        title: '选择登记机关',
                        area: ['25%', '60%'],
                        content: '/commom/server/regorg/regorgmutiselect?isPermissionCheck=true',
                        callback: function (data) {
                       	var returncode=data.returncodes;
                        	var returnname=data.returnname;
                        	$("#regOrg").val(returncode);
                        	$("#regOrgName").val(returnname);
                        }
                    })
                }
            }, {
                el: '#select-intercept',
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '移出原因',
                        area: ['580px', '300px'],
                        content: '/commom/server/intercept/interceptselect?selecttype=canOutReaCodeList',
                        callback: function (data) {
                            if(data){
                                $("#remExcpres").val(data.id);
                                $("#remExcpresText").val(data.text);
                            }
                        }
                    })
                }
            }, {
                el: '#select-intercept_in',
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '列入原因',
                        area: ['580px', '300px'],
                        content: '/commom/server/intercept/interceptselect?selecttype=appInReaCodeList',
                        callback: function (data) {
                            if(data){
                                $("#speCause").val(data.id);
                                $("#speCauseText").val(data.text);
                            }
                        }
                    })
                }
            },{
            	el: '#chooseSliceNo',
                event: 'click',
                handler: function () { 
                	  layer.dialog({
                          title: '选择责任区',
                          area: ['25%', '60%'],
                          content: '/commom/server/sliceno/slicenomutiselect?isPermissionCheck=true',
                          callback: function (data) { 
                          	var returncode=data.returncodes;
                          	$("#sliceNO").val(returncode);
                          	$("#sliceNoName").val(data.returnname);  
                          }
                      })
                }
            },{
            	el: '#search',
                event: 'click',
                handler: function () { 
                	$("#isPubCount").text("加载中...");
                    $("#isInAndNotOutCount").text("加载中...");
                    $("#isInAndIsOutCount").text("加载中...");
                	searchParams = $("#taskForm").serializeObject(); 
                	if(searchFlag=="0"){
                		initDataTable();
                	}else{
                		table.ajax.reload();
                	}
                }
            }
        ]);
    }

})
