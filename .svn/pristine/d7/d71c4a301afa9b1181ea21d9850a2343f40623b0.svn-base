require(['component/iframeLayer', 'component/dataTable', 'common/util',
        'common/http', 'jquery', 'jquery.serialize', 'laydate','jquery.multiselect'
    ],
    function(layer, dataTable, util, http) {

        Date.prototype.format = function(fmt) {
            var o = {
                "M+": this.getMonth() + 1,
                // 月份
                "d+": this.getDate(),
                // 日
                "h+": this.getHours() % 12 == 0 ? 12 : this.getHours() % 12,
                // 小时
                "H+": this.getHours(),
                // 小时
                "m+": this.getMinutes(),
                // 分
                "s+": this.getSeconds(),
                // 秒
                "q+": Math.floor((this.getMonth() + 3) / 3),
                // 季度
                "S": this.getMilliseconds()
                    // 毫秒
            };
            var week = {
                "0": "/u65e5",
                "1": "/u4e00",
                "2": "/u4e8c",
                "3": "/u4e09",
                "4": "/u56db",
                "5": "/u4e94",
                "6": "/u516d"
            };
            if (/(y+)/.test(fmt)) {
                fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
                    .substr(4 - RegExp.$1.length));
            }
            if (/(E+)/.test(fmt)) {
                fmt = fmt
                    .replace(
                        RegExp.$1,
                        ((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "/u661f/u671f" : "/u5468") : "") + week[this.getDay() + ""]);
            }
            for (var k in o) {
                if (new RegExp("(" + k + ")").test(fmt)) {
                    fmt = fmt.replace(RegExp.$1,
                        (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k])
                            .substr(("" + o[k]).length)));
                }
            }
            return fmt;
        };

        //时间控件初始化
        // laydate.skin('molv');//初始化皮肤 (墨绿)
        var start = {
            elem: '#start', //选择ID为START的input
            format: 'YYYY-MM-DD', //自动生成的时间格式
            min: '1970-01-01', //设定最小日期为当前日期
            max: '2099-12-31', //最大日期
            istime: true, //必须填入时间
            istoday: false, //是否是当天
            start: laydate.now(0, "YYYY-MM-DD"), //设置开始时间为当前时间
            choose: function(datas) {
                end.min = datas; //开始日选好后，重置结束日的最小日期
                end.start = datas; //将结束日的初始值设定为开始日
            }
        };
        var end = {
            elem: '#end',
            format: 'YYYY-MM-DD',
            min: '1970-01-01',
            max: '2099-12-31',
            istime: true,
            istoday: false,
            start: laydate.now(0, "YYYY-MM-DD"),
            choose: function(datas) {
                start.max = datas; //结束日选好后，重置开始日的最大日期
            }
        };

        //开始时间和结束时间
        $("#start").click(function() {
            laydate(start);
        });
        $("#end").click(function() {
            laydate(end);
        });
        //重置时间开始时间选择 初始化
        function _intTime() {
            start.min = '1970-01-01';
            start.max = '2099-12-31';
            end.min = '1970-01-01';
            end.max = '2099-12-31';
            end.start = laydate.now(0, "YYYY-MM-DD");
        }


        $("#cancel").click(function() {
            $('#taskForm')[0].reset();
            _intTime();
            $("#regOrg").val("");
        	$("#regUnit").val("");
        	$("#appReviewOrg").val("");
        	$("#sliceNO").val("");
        	$("#entType").val("");
        	$("#regState").val("");
        	$('#regStateM').multipleSelect('setSelects',[$('#regStateM option[title="CUNXU"]').val()]);
        });

        init();

        /**
         * 初始化函数集合
         */
        function init() {
            $("#start").val("");
            $("#end").val("");
            bind();
        }

        var params = {}; //查询参数声明!
        var table;

        /**
         * 初始化dataTable
         */
        function initDataTable() {
            table = dataTable.load({
                //需要初始化dataTable的dom元素
                el: '#permit-table',
                showIndex: true,
                scrollX: true, //支持滚动
                ajax: {
                    type: "POST",
                    url: '/reg/server/backup/list.json',
                    data: function(d) {
                            d.params = params;
                        }
                        //                success:function(data){
                        //                  //alert(data.recordsTotal);
                        //                }

                },

                //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
                //className不要写成class
                columns: [{
                    data: 'id',
                    width: '5%'
                }, {
                    data: null,
                    width: '5%'
                }, {
                    data: 'regno',//统一代码/注册号
                    width: '15px'
                }, {
                    data: 'entname',//企业名称
                    width: '20px',
                    'className': 'left'
                }, {
                    data: 'lerep',//法定代表人/负责人
                    width: '20px'
                }, {
                    data: 'lerepphone',//负责人电话
                    width: '20px'
                }, {
                    data: 'lianame',//联络员姓名
                    width: '20px'
                }, {
                    data: 'tel',//联络员手机
                    width: '20px'
                }, {
                    data: 'applytime',//最近备案日期
                    width: '20px'
                }, {
                    data: null,//最近备案方式
                    width: '20px'
                }, {
                    data: 'username',//备案表接收人
                    width: '20px'
                }, {
                    data: 'apprevieworg',//备案表接收部门
                    width: '20px',
                    'className': 'left'
                }, {
                    data: 'estDate',//企业成立日期
                    width: '20px'
                }, {
                    data: 'dom',//住所
                    width: '20px',
                    'className': 'left'
                }, {
                    data: 'regOrg',//登记机关
                    width: '20px',
                    'className': 'left'
                }, {
                    data: 'regUnit',//管辖单位
                    width: '20px',
                    'className': 'left'
                }, {
                    data: 'sliceNOName',//片区
                    width: '20px',
                    'className': 'left'
                }],
                columnDefs: [{
                    targets: 1,
                    render: function(data, type, row, meta) {
                        return "<a href='#' class='mr10 js-show'>查看</a></a>";
                    }
                }, {
                    targets: 2,
                    render: function(data, type, row, meta) {
                        if (row.unicode != null && row.unicode.length > 0) {
                            return row.unicode;
                        } else {
                            return row.regno;
                        }
                    }
                }
//                , {
//                    targets: 8,
//                    render: function(data, type, row, meta) {
//                        if (data == '01') {
//                            return "已接收";
//                        } else if (data == '02') {
//                            return "申请"
//                        } else if (data == '03') {
//                            return "不接收";
//                        } else {
//                            return "";
//                        }
//                    }
//                }
                , {
                    targets: 8,
                    render: function(data, type, row, meta) {
                        return new Date(data)
                            .format("yyyy-MM-dd HH:mm:ss"); // 最新确认时间
                    }
                }, {
                    targets: 9,
                    render: function(data, type, row, meta) {
                    	if(row.username != null && row.username != ""){
                    		return "书式备案"; 
                    	}else{
                    		return "在线备案"; 
                    	}
                    }
                }, {
                    targets: 12,
                    render: function(data, type, row, meta) {
                        return new Date(data)
                            .format("yyyy-MM-dd"); // 最新确认时间
                    }
                }   ]
            })
        }

        //表格之外的查询按钮事件
        $("#search").click(function() {
        	var categCode=new Array();
    		$(":checkbox[name=entTypeCode]:checked").each(function(k,v){
    			categCode[k]= this.value;
    		});
    		$("#entType").val(categCode);
    		
    		var regStateM = $("#regStateM").val();
    		var value = $("#moresearch").val();
        	if(value == '更多查询条件'){
        		$("#regState").val("");
        	}else{
        		$("#regState").val(regStateM);
        	}
            params = $("#taskForm").serializeObject();
            initDataTable();
            table.ajax.reload();
        });

        $("#mobile").on("blur", function() {
            var mobile = this.value;
            if (mobile.length == 0) {
                // alert('请输入手机号码！');
                // $("#mobile").val('');
                return false;
            }
            if (mobile.length != 11) {
                layer.alert('请输入有效的手机号码！');
                $("#mobile").val('');
                return false;
            }

            var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1})|(14[0-9]{1}))+\d{8})$/;
            if (!myreg.test(mobile)) {
                layer.alert('请输入有效的手机号码！');
                $("#mobile").val('');
                return false;
            }

        });

        /**
        //表格双击事件 dblclick //单击事件 click
        $('#permit-table tbody').on('dblclick', 'tr', function() {
            //_DT_RowIndex 从0开始
            alert('click')
            var data = table.row(this._DT_RowIndex).data();
            debugger
            layer.dialog({
                title: '联络员通知书详情',
                area: ['100%', '100%'],
                content: '/reg/server/backup/option?pasid=' + data.pasid,
                callback: function(data) {
                    //重新加载列表数据
                    if (data.reload == true) {
                        table.ajax.reload();
                    }
                }
            })

        });
       **/
        //按钮事件
        function bind() {
            util.bindEvents([{
                    el: '#choseappReviewOrgDep',
                    event: 'click',
                    handler: function() {
                        layer.dialog({
                            title: '选择接收机关',
                            area: ['400px', '600px'],
                            content: '/commom/server/regunit/regunitmutiselect?isPermissionCheck=true',
                            callback: function(data) {
                                var returncode = data.returncodes;

                                $("#appReviewOrg").val(data.returnname);
                                $("#appReviewOrgName").val(data.returnname);
                            }
                        })
                    }
                }, {
                    el: '#choseorgReg',
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
                }, {
                    el: '#choseregUnit',
                    event: 'click',
                    handler: function() {
                        layer.dialog({
                            title: '选择管辖单位',
                            area: ['400px', '600px'],
                            content: '/commom/server/regunit/regunitmutiselect?isPermissionCheck=true',
                            callback: function(data) {
                                var returncode = data.returncodes;

                                $("#regUnit").val(returncode);
                                $("#regUnitName").val(data.returnname);
                            }
                        })
                    }
                }, {
                    el: '#cancel',
                    event: 'click',
                    handler: function() {
                        $("#regOrg").val("");
                        $("#appReviewOrg").val("");
                        $("#regUnit").val("");
                    }
                }, {
                    el: '.js-show',
                    event: 'click',
                    handler: function() {
                            var data = table.row($(this).closest('td')).data();
                            layer.dialog({
                                title: '联络员备案详情',
                                area: ['95%', '95%'],
                                content: '/reg/server/backup/option?pasid=' + data.pasid+'&pripid='+data.pripid+'&regno='+data.regno
                            });
                        }
                        // window.location.href= '/reg/server/backup/option?pasid=' + data.pasid     

                }, {
                	el: '#chooseSliceNo',
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
                }, {
                	el: '#moresearch',
                    event: 'click',
                    handler: function () { 
                    	var value = $(this).val();
                    	if(value == '更多查询条件'){
                    		$("#hiddendiv1").show();
                    		$("#hiddendiv2").show();
                    		$(this).val("收起");
                    	}else{
                    		$("#hiddendiv1").hide();
                    		$("#hiddendiv2").hide();
                    		$(this).val("更多查询条件");
                    		$("#startDate").val("");
                    		$("#endDate").val("");
                    		$("#appReviewOrg").val("");
                    		$("#appReviewOrgName").val("");
                    		$("#sliceNo").val("");
                    		$("#sliceNoName").val("");
                    		$("#estDateStart").val("");
                    		$("#estDateEnd").val("");
                    		$("#userName").val("");
                    		$('#regStateM').multipleSelect('setSelects',[$('#regStateM option[title="CUNXU"]').val()]);
                    	}
                    	$("#regStateM").multipleSelect({
        					selectAllText: '全部',
        					allSelected: '全部',
        					selectAllDelimiter: '',
        					minimumCountSelected: 10
        				});
                    }
                }
            ])
        }
    });