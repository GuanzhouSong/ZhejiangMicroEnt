require(['component/iframeLayer', 'component/dataTable', 'common/util',
        'common/http', 'jquery', 'jquery.serialize', 'laydate','jquery.multiselect'
    ],
    function(layer, dataTable, util, http) {
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
                    url: '/reg/server/yr/websiteinfo/list.json',
                    data: function(d) {
                            d.params = params;
                        }

                },

                //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
                //className不要写成class
                columns: [{
                    data: null,
                    defaultContent:'id',
                    width:'24px', 
                    'className': 'center'
                },  {
                    data: 'regNO',//统一代码/注册号
                    width: '15px'
                }, {
                    data: 'entName',//企业名称
                    width: '20px',
                    'className': 'left'
                }, {
                    data: 'year',//年报年度
                    width: '20px'
                }, {
                    data: 'webType',//类型
                    width: '20px'
                }, {
                    data: 'webSmallType',//网站类型/网店所属平台
                    width: '20px'
                }, {
                    data: 'webSitName',//网站网店名称
                    width: '20px',
                    'className': 'left'
                }, {
                    data: 'webSite',//网址（域名）
                    width: '20px',
                    'className': 'left'
                }, {
                    data: 'icpBackNO',//ICP备案号
                    width: '20px',
                    'className': 'left'
                }, {
                    data: 'weChatPublicNO',//微信公众号
                    width: '20px',
                    'className': 'left'
                }, {
                    data: 'appNames',//手机APP服务
                    width: '20px',
                    'className': 'left'
                }, {
                    data: 'sendAddress',//发货地址
                    width: '20px',
                    'className': 'left'
                }, {
                    data: 'backAddress',//退货地址
                    width: '20px',
                    'className': 'left'
                },{
                    data: 'leRep',//法定代表人
                    width: '20px'
                },{
                    data: 'leRepPhone',//联系电话
                    width: '20px'
                },{
                    data: 'liaName',//联络员
                    width: '20px'
                },{
                    data: 'tel',//联络员电话
                    width: '20px'
                },{
                    data: 'dom',//住所
                    width: '20px',
                    'className': 'left'
                }, {
                    data: 'regOrgName',//登记机关
                    width: '20px',
                    'className': 'left'
                }, {
                    data: 'localAdmName',//管辖单位
                    width: '20px',
                    'className': 'left'
                }, {
                    data: 'regState',//登记状态
                    width: '20px'
                }],
                fnDrawCallback:function(nRow){
                	initTotal();
                }, 
                columnDefs: [{
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
                        if (data == '1') {
                            return "网站";
                        } else if (data == '2') {
                            return "网店";
                        } else {
                            return "";
                        }
                    }
                }, {
                    targets: 5,
                    render: function(data, type, row, meta) {
                    	if (row.webType == '1') {
                    		if (data == '1') {
                                return "交易网站";
                            } else if (data == '2') {
                                return "信息网站";
                            } else {
                                return "";
                            }
                        } else if (row.webType == '2') {
                            return row.belongPlatFormName;
                        } else {
                            return "";
                        }
                    }
                }, {
                    targets: 20,
                    render: function(data, type, row, meta) {
                    	return switchRegStateList(row.regState);
                    }
                }
                ]
            });
        }
        
      	//查询结果统计
        function initTotal(){
        	var totalParams = $("#taskForm").serializeObject();
            http.httpRequest({
                url: "/reg/server/yr/websiteinfo/total.json",
                serializable: true,
                data: totalParams,
                type: 'post',
                success: function (data) {
                	$("#entTotal,#websiteTotal,#onlinestoreTotal").html("").text("0");
                	for(var i=0;i<data.length;i++){
                		if(data[i].webType == '1'){
                			$("#websiteTotal").html("").text(data[i].webTotal);
                		}
                		if(data[i].webType == '2'){
                			$("#onlinestoreTotal").html("").text(data[i].webTotal);
                		}
                		if(data[i].webType == '8'){
                			$("#entTotal").html("").text(data[i].entTotal);
                		}
                	}
                }
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
    		//网站类型
    		var webTypeCode=new Array();
    		$(":checkbox[name=webTypeCode]:checked").each(function(k,v){
    			webTypeCode[k]= this.value;
    		});
    		$("#webType").val(webTypeCode);
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
                },{
                    el: '#cancel',
                    event: 'click',
                    handler: function() {
                    	$('#taskForm')[0].reset();
                        $("#regOrg").val("");
                    	$("#regUnit").val("");
                    	$("#industryCo").val("");
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
                },{
                    el: '#permit-table tr',
                    event: 'click',
                    handler: function () {
                        var data = table.row($(this)).data();  //获取当前选中的数据
    					layer.dialog({
                    		title:'网站网店信息详情',
                    		area: ['100%', '100%'],
                    		maxmin: true, //开启最大化最小化按钮
                    		content: '/reg/server/yr/websiteinfo/details?year=' + data.year+'&priPID='+data.priPID,
                    		callback: function (data) {}
                    	})
                    }
                }
            ]);
        }
    });