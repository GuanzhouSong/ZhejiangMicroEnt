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
        	$("#localAdm").val("");
        	$("#appReviewOrg").val("");
        	$("#sliceNO").val("");
        	$("#entType").val("");
        	$("#regState").val("");
        	$('#regStateM').multipleSelect('setSelects',['K,B,A,DA,X']);
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
                    url: '/reg/message/queryMessagPageList.json',
                    data: function(d) {
                            d.params = params;
                        }
                },

                columns : [
                    {data: '_idx', className: 'center'},
                    {data: null, className: 'center'},
                    {data : 'msgTitle', className: 'center'},
                    {data : null, className: 'center'},
                    {data : 'entName', className: 'center'}, 
                    {data : 'leRep', className: 'center'},
                    {data : 'sendTime', className: 'center'}, 
                    {data : 'sendName', className: 'center'},
                    {data : 'liaisonManName',className: 'center'}, 
                    {data : 'liaisonManTel', className: 'center'},
                    {data : null,className: 'center'},
                    {data : 'msgPcReadTime', className: 'center'},
                    {data : 'regOrgName',className: 'center'},
                    {data : 'localAdmName',className: 'center'},
                    {data : 'sliceNOName',className: 'center'},
                    {data : 'regState',className: 'center'}
        		],
                columnDefs: [{
                    targets: 1,
                    render: function(data, type, row, meta) {
                        return "<a href='#' class='mr10 js-viewlist'>查看详情</a></a>";
                    }
                },{
                    targets: 2,
                    render: function(data, type, row, meta) {
                    	if(row.msgTitle){
                    		if(row.msgTitle.length > 20){
                    			return row.msgTitle.substring(0,20)+"...";
                    		}else{
                    			return row.msgTitle;
                    		}
                    		
                    	}
                    }
                },{
                    targets: 3,
                    render: function(data, type, row, meta) {
                        if (data.uniCode != null && data.uniCode.length > 0) {
                            return data.uniCode;
                        } else {
                            return data.regNO;
                        }
                    }
                },{
                    targets: 6,
                    render: function(data, type, row, meta) {
                       return row.sendTime.substring(0,10);
                    }
                },{
                    targets: 10,
                    render: function(data, type, row, meta) {
                        if (data.msgPcReadState != null && data.msgPcReadState == "1") {
                            return "已查阅";
                        } else {
                            return '<font color="red">未查阅</font>';
                        }
                    }
                },{
                    targets: 11,
                    render: function(data, type, row, meta) {
                    	if(row.msgPcReadTime){
                    		return row.msgPcReadTime.substring(0,10);
                    	}
                    }
                },{
                    targets: 15,
                    render: function(data, type, row, meta) {
                    	if(row.regState=='A' || row.regState=='B' || row.regState=='K' ||row.regState=='DA' ||row.regState=='X' )
	            			 return "存续";
	            		 if(row.regState=='XX' || row.regState=='DX'){
	            			 return "注销";
	            		 }
	            		 if(row.regState=='C'){
	            			 return "撤销";
	            		 }
	            		 if(row.regState=='D'){
	            			 return "吊销";
	            		 }
	            		 if(row.regState=='Q'){
	            			 return "迁出";
	            		 }
                    }
                }]
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
            debugger;
            initDataTable();
            table.ajax.reload();
            debugger;
            http.httpRequest({
                url: '/reg/message/queryMessageCount.json',
                data:params,
                type: 'post',
                success: function(data) {
	            	if(data && data.status == "success"){
	            		var msgNum= data.data.msgNum;
	            		var msgReadNum= data.data.msgReadNum;
	            		var msgUnReadNum= data.data.msgUnReadNum;
	            		var entNum= data.data.entNum;
	            		$("#label_msgNum").text(msgNum);
	            		$("#label_msgReadNum").text(msgReadNum);
	            		$("#label_msgUnReadNum").text(msgUnReadNum);
	            		$("#label_entNum").text(entNum);
	            	}
            	
            	}	
            })
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
                    el: '#choselocalAdm',
                    event: 'click',
                    handler: function() {
                        layer.dialog({
                            title: '选择管辖单位',
                            area: ['400px', '600px'],
                            content: '/commom/server/regunit/regunitmutiselect?isPermissionCheck=true',
                            callback: function(data) {
                                var returncode = data.returncodes;

                                $("#localAdm").val(returncode);
                                $("#localAdmName").val(data.returnname);
                            }
                        })
                    }
                }, {
                    el: '#cancel',
                    event: 'click',
                    handler: function() {
                        $("#regOrg").val("");
                        $("#sliceNo").val("");
                        $("#localAdm").val("");
                    }
                }, {
                    el: '.js-viewlist',
                    event: 'click',
                    handler: function() {
                            var data = table.row($(this).closest('td')).data();
                            window.location='/reg/message/toMessageViewList?priPID='+data.priPID;
                   /*         layer.dialog({
                                title: '联络员备案详情',
                                area: ['95%', '95%'],
                                content: '/reg/server/backup/option?pasid=' + data.pasid+'&pripid='+data.pripid+'&='+data.regno
                            });*/
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
                    		$(this).val("收起");
                    	}else{
                    		$("#hiddendiv1").hide();
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
                    		$('#regStateM').multipleSelect('setSelects',['K,B,A,DA,X']);
                    	}
                    	$("#regStateM").multipleSelect({
        					selectAllText: '全部',
        					allSelected: '全部',
        					selectAllDelimiter: '',
        					minimumCountSelected: 10
        				});
                    }
                },{
                	el: '#btn_add',
                    event: 'click',
                    handler: function () {
                    	window.location="/reg/message/toMessageEntlist"
                    }
                }
            ])
        }
    });