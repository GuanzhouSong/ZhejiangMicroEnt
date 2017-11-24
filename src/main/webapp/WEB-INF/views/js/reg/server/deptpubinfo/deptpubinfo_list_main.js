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
    
        var regStateList = [];
        init();

        /**
         * 初始化函数集合
         */
        function init() {
            bind();
            getRegStateList();
        }
        
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
                    url: '/reg/server/deptpubinfo/list.json',
                    data: function(d) {
                            d.params = params;
                        }

                },
                //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
                //className不要写成class
                columns: [
                          {data: null, defaultContent: 'id', width: '24px', className: 'center'},   
//                          {data: null, width: '40px'}, //警示
                          {data: 'regNO', width: '15px'}, //统一代码/注册号
                          {data: 'entName', width: '20px', className: 'left'}, //企业名称
                          {data: 'leRep', width: '20px'}, //法定代表人
                          {data: 'estDate', width: '20px'}, //成立日期
//                          {data: 'mortTotal', width: '20px'}, //动产抵押
//                          {data: 'stockTotal', width: '20px'}, //股权出质
//                          {data: 'ippldgTotal', width: '20px'}, //知识产权出质
//                          {data: 'brandTotal', width: '20px'}, //商标注册
//                          {data: 'sccheckTotal', width: '20px'}, //抽查检查
//                          {data: 'justiceTotal', width: '20px'}, //司法协助
//                          {data: 'permitTotal', width: '20px'}, //行政许可
//                          {data: 'punishTotal', width: '20px'}, //行政处罚
//                          {data: 'anomalyTotal', width: '20px'}, //经营异常名录
//                          {data: 'illegalTotal', width: '20px'}, //严重违法失信
//                          {data: 'simpleescTotal', width: '20px'}, //简易注销
                          {data: 'dom', width: '20px', className: 'left'}, //住所
                          {data: 'regOrgName', width: '20px', className: 'left'}, //登记机关
                          {data: 'localAdmName', width: '20px', className: 'left'}, //管辖单位
                          {data: 'sliceNOName', width: '20px', className: 'left'}, //片区
                          {data: 'regState', width: '20px'}//登记状态
                          ],
                columnDefs: [
//                    {
// 					targets:1,
// 					render:function(data,type,row,meta){
// 						var isAnomaly = row.anomalyTotal > 0;
// 						var isIllegal = row.illegalTotal > 0;
// 						//列入经营异常名录（黄色警示）
// 						if(isAnomaly){
//							return "<i class='bulb yellow-b'></i>";
// 						}
// 						if(isIllegal){
// 							return "<i class='bulb orange-b'></i>";
// 						}
// 						if(isAnomaly && isIllegal){
// 							return "<i class='bulb red-b'></i>";
// 						}
// 						return "";
// 					}
// 				 },
 				 {
                    targets: 1,
                    render: function(data, type, row, meta) {
                        if (row.uniCode != null && row.uniCode.length > 0) {
                            return row.uniCode;
                        } else {
                            return row.regNO;
                        }
                    }
                }, {
                    targets: 4,
                    render: function(data, type, row, meta) {
                        return new Date(data).format("yyyy-MM-dd"); 
                    }
                }, {
                    targets: 9,
                    render: function(data, type, row, meta) {
                    	return switchRegStateList(row.regState);
                    }
                }
                ]
            });
        }

        //表格之外的查询按钮事件
        $("#search").click(function() {
        	//年报主体
        	var categCode=new Array();
    		$(":checkbox[name=entTypeCatgCode]:checked").each(function(k,v){
    			categCode[k]= this.value;
    		});
    		$("#entTypeCatg").val(categCode);
    		//登记状态
    		var regStateM = $("#regStateM").val();
    		$("#regState").val(regStateM);
    		
            params = $("#taskForm").serializeObject();
            initDataTable();
            table.ajax.reload();
        });

        //按钮事件
        function bind() {
            util.bindEvents([{
                    el: '#choseorgReg',
                    event: 'click',
                    handler: function() {
                    	layer.dialog({
                            title: '选择登记机关',
                            area: ['400px', '600px'],
                            content: '/commom/server/regorg/regorgmutiselect',
                            callback: function (data) { 
                            	var returncode=data.returncode;
                            	if(returncode!=null&&returncode!=""){
                            		returncode=returncode.substr(0,returncode.length-1); 
                            	}
                            	$("#regOrg").val(returncode);
                            	$("#regOrgName").val(data.returnname);  
                            }
                        });
                    }
                }, {
                    el: '#choseregUnit',
                    event: 'click',
                    handler: function() {
                    	layer.dialog({
                            title: '选择管辖单位',
                            area: ['400px', '600px'],
                            content: '/commom/server/regunit/regunitmutiselect',
                            callback: function (data) { 
                            	var returncode=data.returncode;
                            	if(returncode!=null&&returncode!=""){
                            		returncode=returncode.substr(0,returncode.length-1); 
                            	}
                              	$("#regUnit").val(returncode);
                              	$("#regUnitName").val(data.returnname); 
                            }
                        });
                    }
                }, {
                	el: '#chooseEntType',
                    event: 'click',
                    handler: function () { 
                    	var categCode=new Array();
                        $(":checkbox[name=entCatg]:checked").each(function(k,v){
                      	   categCode[k]= this.value;
                        });
                        
                        layer.dialog({
                            title: '选择企业类型',
                            area: ['400px', '600px'],
                            content: '/commom/server/entcatg/entcatgmutiselectCom?type='+categCode,
                            callback: function (data) { 
                            	var returncode=data.returncode;
                            	if(returncode!=null&&returncode!=""){
                            		returncode=returncode.substr(0,returncode.length-1); 
                            	}
                            	$("#entType").val(returncode);
                            	$("#entTypeName").val(data.returnname);  
                            }
                        });
                    }
                },{
                	el: '#choseindustry',
                    event: 'click',
                    handler: function () { 
                    	layer.dialog({
                            title: '选择行业',
                            area: ['400px', '600px'],
                            content: '/commom/server/industry/toIndustryPhyTree',
                            callback: function (data) { 
                            	var returncode=data.returncode;
                            	if(returncode!=null&&returncode!=""){
                            		returncode=returncode.substr(0,returncode.length-1); 
                            	}
                            	$("#industryCo").val(returncode);
                            	$("#industryCoName").val(data.returnname);  
                            }
                        });
                    }
                }, {
                	el: '#chooseSliceNo',
                    event: 'click',
                    handler: function () { 
                        layer.dialog({
                            title: '选择片区',
                            area: ['400px', '600px'],
                            content: '/commom/server/sliceno/slicenomutiselect',
                            callback: function (data) { 
                            	var returncode=data.returncode;
                            	if(returncode!=null&&returncode!=""){
                            		returncode=returncode.substr(0,returncode.length-1); 
                            	}
                            	$("#sliceNo").val(returncode);
                            	$("#sliceNoName").val(data.returnname);  
                            }
                        });
                    }
                },{
                    el: '#cancel',
                    event: 'click',
                    handler: function() {
                    	$('#taskForm')[0].reset();
                        $("#regOrg").val("");
                    	$("#regUnit").val("");
                    	$("#industryCo").val("");
                    	$("#sliceNo").val("");
                    	$("#entType").val("");
                    	$("#regState").val("");
                    	$('#regStateM').multipleSelect('setSelects',[$('#regStateM option[title="CUNXU"]').val()]);
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
                    	}
                    }
                }
            ]);
        }
    });