require(['component/iframeLayer', 'component/dataTable', 'common/util',
        'common/http', 'jquery', 'jquery.serialize', 'laydate','jquery.multiselect'
    ],
    function(layer, dataTable, util, http) {

        init();

        /**
         * 初始化函数集合
         */
        function init() {
        	initDataTable();
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
                    url: '/reg/message/queryMessagPageListByPriPID.json',
                    data: function(d) {
                            d.params = $("#taskForm").serializeObject();
                        }
                },

                columns : [
                    {data: '_idx', className: 'center'},
                    {data: null, className: 'center'},
                    {data : 'msgTitle', className: 'center'},
                    {data : 'sendName', className: 'center'},
                    {data : 'sendTime', className: 'center'}, 
                    {data : null,className: 'center'},
                    {data : 'msgPcReadTime', className: 'center'},
                    {data : 'msgPcReadName', className: 'center'},
                    {data : 'msgPcReadTel', className: 'center'},
                    {data : 'msgRemark',className: 'center'}
        		],
                columnDefs: [{
                    targets: 1,
                    render: function(data, type, row, meta) {
                        return "<a href='#' class='mr10 js-view'>查看内容</a></a>";
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
                    targets: 4,
                    render: function(data, type, row, meta) {
                       return row.sendTime.substring(0,10);
                    }
                }, {
                    targets: 5,
                    render: function(data, type, row, meta) {
                        if (data.msgPcReadState != null && data.msgPcReadState == "1") {
                            return '<font color="green">已查阅</font>';
                        } else {
                            return '<font color="red">未查阅</font>';
                        }
                    }
                },{
                    targets: 6,
                    render: function(data, type, row, meta) {
                    	if(row.msgPcReadTime){
                    		return row.msgPcReadTime.substring(0,10);
                    	}
                    }
                },{
                    targets: 9,
                    render: function(data, type, row, meta) {
                    	if(row.msgRemark){
                    		if(row.msgRemark.length > 20){
                    			return row.msgRemark.substring(0,20)+"...";
                    		}else{
                    			return row.msgRemark;
                    		}
                    		
                    	}
                    }
                }],
                initComplete: function (settings, json){
                	var tableId = settings.sTableId;
                	$("#"+tableId+"_span").text(json.recordsTotal);
                }
            })
        }

       
        //按钮事件
        function bind() {
            util.bindEvents([{
                el: '.js-view',
                event: 'click',
                handler: function() {
                        var data = table.row($(this).closest('td')).data();
                        layer.dialog({
                            title: '消息详情',
                            area: ['95%', '95%'],
                            content: '/reg/message/toMessageView?msgUid='+data.msgUid
                        });
                    }

            },{
            	el: '#btn_back',
                event: 'click',
                handler: function() {
                	window.location="/reg/message/toMessagelist";
                }
            	
            }
            ])
        }
    });