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
            el: '#con_apply_table',
			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/syn/con/csconcernobj/applyauditlist.json',
                data:function(d){
                	d.params = searchParams;
                }
            },
            columns: [
                {data: null,width:'80px', className: 'center'},
                {data: null,width:'80px', className: 'center'},
                {data: 'checkState',width:'110px', className: 'center'},
                {data: 'batchNO',width:'110px', className: 'center'},
                {data: 'markName',width:'110px', className: 'center'},
                {data: 'markUseArea',width:'110px', className: 'center'},
                {data: 'markStartDate',width:'110px', className: 'center'},
                {data: 'markEndDate',width:'110px', className: 'center'},
                {data: 'importPeople',width:'110px', className: 'center'},
                {data: 'importDate',width:'110px', className: 'center'},
                {data: 'checkPeople',width:'110px', className: 'center'},
                {data: 'checkDate',width:'110px', className: 'center'}
            ],
             columnDefs : [
							{
								targets: 1,
			                    render: function (data, type, row, meta) {
			                    	if(row.checkState=='2')
			                    		return "<a href='javascript:void(0)' class='mr10 check'>审核</a>";
			                    	else
			                    		return "<a href='javascript:void(0)' class='mr10 view'>查看</a>";
			                    }
			                },{
								targets:2,
			                    render: function (data, type, row, meta) {
			                    	if(row.checkState=='0') 
			                    	    return "未通过";
			                    	else if(row.checkState=='1')
			                    		return "通过";
			                    	else if(row.checkState=='2')
			                    		return "未审核";
			                    	else if(row.checkState=='3')
			                    		return "审核退回";
			                    }
			                }
					  ]
        })
    }
    
    function doSelectLocalAdm(){
        var select_localAdm_url=window._CONFIG.select_localAdm_url;
        layer.dialog({
            title: '选择管辖单位',
            area: ['350px', '666px'],
            content: select_localAdm_url,
            callback: function (data) {
                 $("#localAdm").val('');
                 $("#localAdm").val(data.returnname);
                 $("#localAdmCode").val('');
                 $("#localAdmCode").val(data.returncodes);
            }
        })
      }
    function doSelectRegOrg(){
         var select_regOrg_url=window._CONFIG.select_regOrg_url;
         layer.dialog({
             title: '选择登记机关',
             area: ['350px', '666px'],
             content: select_regOrg_url,
             callback: function (data) {
                  $("#regOrg").val('');
                  $("#regOrg").val(data.returnname);
                  $("#regOrgCode").val('');
                  $("#regOrgCode").val(data.returncodes);
             }
         })
     }
    

    function bind() {
        util.bindEvents([{
            el: '.check',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
            	layer.dialog({title: '企业关注服务审核',
            		area: ['86%', '86%'],
            		content: '/syn/con/csconcernobj/applyaudit?batchNO='+data.batchNO+"&urlFlag=1",
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
                        	window.location.href='/syn/con/csconcernobj/applyauditlist';
                        }
                    }
                })
            }
        },{
            el: '.view',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
            	layer.dialog({title: '企业关注服务查看',
            		area: ['86%', '86%'],
            		content: '/syn/con/csconcernobj/applyview?batchNO='+data.batchNO+"&urlFlag=0",
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
                        	window.location.href='/syn/con/csconcernobj/applyauditlist';
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
        },{
            el: '#selectLocalAdm',
            event: 'click',
            handler: function () {
            	doSelectLocalAdm();
            }
        },{
            el: '#selectRegOrg',
            event: 'click',
            handler: function () {
            	doSelectRegOrg();
            }
        }])
    }
    
})
