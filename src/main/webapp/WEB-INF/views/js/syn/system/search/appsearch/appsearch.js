require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'jquery', 'jquery.serialize', 'laydate', 'jquery.multiselect'], function (layer, dataTable, util, http) {
    var params = $("#entSearchForm").serializeObject();//查询参数声明!
    var initFlag = '1';
    var regStateList = [];
    init();
    /**
     * 初始化函数集合
     */
    function init() {
//    	initDataTable();
        bind();
        getRegStateList();
    }

    $("#badInfoM").multipleSelect({
        selectAllText: '全部',
        allSelected: '全部',
        selectAllDelimiter: '',
        minimumCountSelected: 10
    });

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

    function initDataTable() {
        initFlag = '0';
        table = dataTable.load({
            el: '#search-table',
            showIndex: true,
            scrollX: true,
            lengthMenu: [10, 20, 30, 50, 100],
            ajax: {
                type: "post",
                url: '/syn/panoramasearch/panoQueryPage',
                data: function (d) {
                    d.params = params;
                }
            },
            buttons: [],
            columns: [
                {data: '_idx', className: 'center'},
                {data: 'regState', className: 'center'},
                {data: 'uniscid', className: 'center'},
                {data: 'entName', className: 'left'},
                {data: 'leRep', className: 'center'},
                {data: 'estDate', className: 'center'},
                {data: 'regCap', className: 'center'},
                {data: 'entTypeName', className: 'left'},
                {data: 'industryCoName', className: 'left'},
                {data: 'dom', className: 'left'},
                {data: 'regOrgName', className: 'left'},
                {data: 'localAdmName', className: 'left'},
                {data: 'sliceNOName', className: 'left'}
            ],
            columnDefs: [
                {
                    targets: 3,
                    render: function (data, type, row, meta) {
                        return "<a href='javascript:void(0)' class='mr10 look' priPID='" + row.priPIDDesc + "'>" + row.entName + "</a>";
                    }

                }, {
                    targets: 2,
                    render: function (data, type, row, meta) {
                        var isSim = row.isSim;
                        if (isSim == "Y") {
                            if (row.uniscid) {
                                return "<span class='yellow-bg'>" + row.uniscid + "</span>";
                            } else {
                                return "<span class='yellow-bg'>" + row.regNO + "</span>";
                            }
                        } else {
                            if (row.uniscid) {
                                return row.uniscid;
                            } else {
                                return row.regNO;
                            }
                        }
                    }
                }, {
                    targets: 1,
                    render: function (data, type, row, meta) {
                    	return switchRegStateList(row.regState);
                    }

                }
            ],
            "fnRowCallback": function (nRow, aData, iDisplayIndex, iDisplayIndexFull) {

                if (aData.regState == 'XX' || aData.regState == 'DX' || aData.regState == 'C' || aData.regState == 'D' || aData.regState == 'DA' || aData.regState == 'QX') {
                    nRow.style.backgroundColor = "#FF0000";
                }


                var hisInfo="<span class='history-info' style='display: none'>原注册号：3309658412356    曾用名：诸暨大唐<em class='light'>铜铁</em>废品回收经营部；诸暨大唐铜铁废品回收公司</span>"

                if(aData.uniscid == '913302060847515990'){
                    $(nRow).addClass('hashistoey')
                    $(nRow).find('td').eq(1).addClass('pdb0');
                    $(nRow).find('td').eq(2).append(hisInfo);
                }
            },
            "fnDrawCallback":function () {
                var width=$('#search-table').outerWidth()-$('#search-table th').eq(0).innerWidth()-$('#search-table th').eq(1).innerWidth()-3;
                $('.history-info').css('width',width).show();
            }

        })
    }


    function bind() {
        util.bindEvents([
            {
                el: '#search',
                event: 'click',
                handler: function () {
                    var regCapStart = $("#regCapStart").val();
                    var regCapEnd = $("#regCapEnd").val();
                    if (isNaN(regCapStart) || isNaN(regCapEnd)) {
                        alert("注册资本格式不正确");
                    } else {
                        var categCode = new Array();
                        $(":checkbox[name=entCatg]:checked").each(function (k, v) {
                            categCode[k] = this.value;
                        });
                        $("#entTypeCatg").val(categCode);

                        var badInfoM = $("#badInfoM").val();
                        $("#badInfo").val(badInfoM);

                        var regStateM = $("#regStateM").val();
                        $("#regState").val(regStateM);

                        params = $("#entSearchForm").serializeObject();
                        if (initFlag == "1") {
                            initDataTable();
                        } else {
                            table.ajax.reload();
                        }
                    }
                }
            }, {
                el: '#cancle',
                event: 'click',
                handler: function () {
                    $("#regOrg").val("");
                    $("#localAdm").val("");
                    $("#sliceNo").val("");
                    $("#entType").val("");
                    $("#industryCo").val("");
                    $('#yearMode').val("");
                    $('#badInfoM').multipleSelect('setSelects', ['']);
                    $('#regStateM').multipleSelect('setSelects',[$('#regStateM option[title="CUNXU"]').val()]);
                }
            }, {
                el: '.look',
                event: 'click',
                handler: function () {
                    var priPID = $(this).attr("priPID");
                    if (priPID != null && priPID != '') {
                        window.open('/syn/panoramasearch/doEnAppSearchDetails/' + priPID, '_blank');
                    }
                }
            }, {
                el: '.js-more-query',
                event: 'click',
                handler: function () {
                    if ($('.more-show').css("display") == "none") {
                        $('.js-more-query').attr('value', '收起');
                        $('.more-show').css("display", "block");
                    } else {
                        $('.js-more-query').attr('value', '更多查询');
                        $('.more-show').css("display", "none");
                    }
                }
            }, {
                el: '#selectIndustry',
                event: 'click',
                handler: function () {
                    showIndustryTree()
                }//行业树
            }, {
                el: '#chooseEntType',
                event: 'click',
                handler: function () {
                    var categCode = new Array();
                    $(":checkbox[name=entCatg]:checked").each(function (k, v) {
                        categCode[k] = this.value;
                    });
                    layer.dialog({
                        title: '选择企业类型',
                        area: ['400px', '600px'],
                        content: '/commom/server/entcatg/entcatgmutiselectCom?type=' + categCode,
                        callback: function (data) {
                            var returncode = data.returncode;
                            if (returncode != null && returncode != "") {
                                returncode = returncode.substr(0, returncode.length - 1);
                            }
                            $("#entType").val(returncode);
                            $("#entTypeName").val(data.returnname);
                        }
                    })
                }
            }, {
                el: '#selectLocalAdm',
                event: 'click',
                handler: function () {
                    showLocalAdmTree()
                }//管辖单位
            }, {
                el: '#chooseSliceNo',
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '选择片区',
                        area: ['400px', '600px'],
                        content: '/commom/server/sliceno/slicenomutiselect',
                        callback: function (data) {
                            var returncode = data.returncode;
                            if (returncode != null && returncode != "") {
                                returncode = returncode.substr(0, returncode.length - 1);
                            }
                            $("#sliceNo").val(returncode);
                            $("#sliceNoName").val(data.returnname);
                        }
                    })
                }
            }, {
                el: '#chooseYearMode',
                event: 'click',
                handler: function () {
                    var categCode = new Array();
                    $(":checkbox[name=chooseEntCatg]:checked").each(function (k, v) {
                        categCode[k] = this.value;
                    });

                    layer.dialog({
                        title: '选择年度年报状态',
                        area: ['400px', '600px'],
                        content: '/syn/panoramasearch/yearStatusTree',
                        callback: function (data) {
                            var returncode = data.returncode;
                            if (returncode != null && returncode != "") {
                                returncode = returncode.substr(0, returncode.length - 1);
                            }
                            $("#yearMode").val(returncode);
                            $("#yearModeName").val(data.returnname);
                        }
                    })
                }
            }, {
                el: '#selectRegOrg',
                event: 'click',
                handler: function () {
                    showRegOrgTree()
                }//登记机关
            }
        ]);
    }

    function showIndustryTree() {
        layer.dialog({
            title: '选择行业',
            area: ['400px', '600px'],
            content: '/commom/server/industry/toIndustryPhyTree',
            callback: function (data) {
                $("#industryCo").val('');
                $("#industryName").val('');
                $("#industryCo").val(data.returncodes);
                $("#industryName").val(data.returnname);
            }
        })
    }

    function showLocalAdmTree() {
        layer.dialog({
            title: '选择管辖单位',
            area: ['400px', '600px'],
            content: '/commom/server/regunit/regunitmutiselectnocheck',
            callback: function (data) {
                $("#localAdm").val('');
                $("#localAdmName").val('');
                $("#localAdm").val(data.returncodes);
                $("#localAdmName").val(data.returnname);
            }
        })
    }

    function showRegOrgTree() {
        layer.dialog({
            title: '选择登记机关',
            area: ['400px', '600px'],
            content: '/commom/server/regorg/regorgmutiselectnocheck',
            callback: function (data) {
                $("#regOrg").val('');
                $("#regOrgName").val('');
                $("#regOrg").val(data.returncodes);
                $("#regOrgName").val(data.returnname);
            }
        })
    }


})
