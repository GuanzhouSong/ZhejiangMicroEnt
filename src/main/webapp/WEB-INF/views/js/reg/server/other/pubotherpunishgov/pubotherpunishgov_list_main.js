require(['component/iframeLayer', 'component/dataTable', 'common/util',
        'common/http', 'jquery', 'jquery.serialize', 'laydate','jquery.multiselect'
    ],
    function(layer, dataTable, util, http) {
	    
	    var searchFlag = '0';
	    var params = {}; //查询参数声明!
        var table;
        init();

        /**
         * 初始化函数集合
         */
        function init() {
            bind();
        }

        /**
         * 初始化dataTable
         */
        function initDataTable() {
        	searchFlag = '1';
            table = dataTable.load({
                //需要初始化dataTable的dom元素
                el: '#permit-table',
                showIndex: true,
                scrollX: true, //支持滚动
                ajax: {
                    type: "POST",
                    url: '/reg/server/other/pubotherpunishgov/list.json',
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
                    data: 'entName',//企业名称
                    width: '20px',
                    'className': 'left'
                }, {
                    data: 'penDecNo',//处罚决定书文号
                    width: '20px',
                    'className': 'left'
                }, {
                    data: 'illegActType',//违法行为类型
                    width: '20px',
                    'className': 'left'
                }, {
                    data: 'punDecDoc',//行政处罚决定书
                    width: '20px',
                    'className': 'left'
                }, {
                    data: 'penDecIssDate',//处罚决定日期
                    width: '20px',
                    'className': 'center'
                }, {
                    data: 'judAuth',//处罚决定机关
                    width: '20px',
                    'className': 'center'
                }, {
                    data: 'pubFlag',//是否已公示
                    width: '20px',
                    'className': 'center'
                }, {
                    data: 'areaCode',//所属地区编码
                    width: '20px',
                    'className': 'center'
                }, {
                    data: 'areaName',//所属地区名称
                    width: '20px',
                    'className': 'center'
                }, {
                    data: 'setDeptname',//来源
                    width: '20px',
                    'className': 'center'
                }],
                fnDrawCallback:function(oSettings){
                	$("#allTotal").html("").text(oSettings._iRecordsTotal);
                	initTotal();
                }, 
                columnDefs: [{
					targets: 4,
                    render: function (data, type, row, meta) {
                    	if(data && (data.length > 20)){
                            $(table.cell( meta.row, meta.col ).node()).attr('title',data);
                            return (data.substr( 0, 20 )+'....');
                        }
                    	return data;
                    }
                },{
                    targets: 7,
                    render: function(data, type, row, meta) {
                        if (data == '0') {
                            return "否";
                        } else if (data == '1') {
                            return "是";
                        } else {
                            return "";
                        }
                    }
                }
                ]
            });
        }
        
      //查询结果统计
        function initTotal(){
        	var totalParams = $("#taskForm").serializeObject();
            http.httpRequest({
                url: "/reg/server/other/pubotherpunishgov/total.json",
                serializable: true,
                data: totalParams,
                type: 'post',
                success: function (data) {
                	if(data!=null){
                		var objectInfo = data.data;
                		$("#regTotal").html("").text(objectInfo.regTotal==null?'0':objectInfo.regTotal);
                		$("#compareTotal").html("").text(objectInfo.regAnthTotal==null?'0':objectInfo.regAnthTotal);
                		$("#anthTotal").html("").text(objectInfo.anthTotal==null?'0':objectInfo.anthTotal);
                	}
                }
            });
        }

        //表格之外的查询按钮事件
        $("#search").click(function() {
            params = $("#taskForm").serializeObject();
            if(searchFlag=="0"){
            	initDataTable();
        	}else{
        		table.ajax.reload();
        	}
        });

        //按钮事件
        function bind() {
            util.bindEvents([{
                    el: '#cancel',
                    event: 'click',
                    handler: function() {
                    	$('#taskForm')[0].reset();
                    }
                }
            ]);
        }
    });