require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {
	var searchParams=$("#hx-form").serializeObject();//查询参数声明!
	var table;
	
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
    }
    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#apply_table',
			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: false,
            ajax: {
                url:'/syn/supervise/doQueryByBatchNOListPage',
                data:function(d){
                	d.params = searchParams;
                }
            },
            columns: [
                {data: null, className: 'center'},
                {data: 'supCheckState',width:'100px', className: 'center'},
                {data: 'batchNO', className: 'center'},
                {data: 'markName', className: 'center'},
                {data: 'markUseArea', className: 'center'},
                {data: 'markStartDateDesc', className: 'center'},
                {data: 'markEndDateDesc',className: 'center'},
                {data: 'inputPer', className: 'center'},
                {data: 'inputDateDesc',className: 'center'},
                {data: 'checkPer',className: 'center'},
                {data: 'checkDateDesc',className: 'center'}
            ],
             columnDefs : [
							{
								targets: 0,
			                    render: function (data, type, row, meta) {
			                    	if(row.supCheckState=='2')
			                    		return "<a href='javascript:void(0)' class='mr10 check'>审核</a>";
			                    	else
			                    		return "<a href='javascript:void(0)' class='mr10 view'>查看</a>";
			                    }
			                },
			                {
								targets:1,
			                    render: function (data, type, row, meta) {
			                    	if(row.supCheckState=="0") return "未通过";
			                    	else if(row.supCheckState=="1") return "通过";
			                    	else if(row.supCheckState=="2") return "未审核";
			                    	else if(row.supCheckState=="3") return "审核退回";
			                    }
			                }
					  ]
        })
    }
    

    function bind() {
        util.bindEvents([{
            el: '.check',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
            	layer.dialog({title: '企业重点监管审核',
            		area: ['86%', '86%'],
            		content: '/syn/supervise/doEnCheckConfirm?batchNO='+data.batchNO,
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
                        	window.location.href='/syn/supervise/doEnSupCheckList';
                        }
                    }
                })
            }
        },{
            el: '.view',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
            	layer.dialog({title: '企业重点监管查看',
            		area: ['86%', '86%'],
            		content: '/syn/supervise/doEnCheckView?batchNO='+data.batchNO,
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
                        	window.location.href='/syn/supervise/doEnSupCheckList';
                        }
                    }
                })
            }
        },{
            el: '#reset',
            event: 'click',
            handler: function () {
            	$('.clx').val('');
            }
        },{
            el: '#cancel',
            event: 'click',
            handler: function () {
            	window.location.href='/risk/csentwarn/list';
            }
        },{
            el: '#search',
            event: 'click',
            handler: function () {
            	searchParams = $("#hx-form").serializeObject();
                table.ajax.reload();
            }
        }
        ])
    }
    
})
