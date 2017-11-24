require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {
	var systemDate = getNowFormatDate();
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

    //获取当前时间
    function getNowFormatDate() {
        var date = new Date();
        var seperator1 = "-";
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate;
        return currentdate;
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
                url:'/syn/con/csconcernobj/applylist.json',
                data:function(d){
                	d.params = searchParams;
                }
            },
            columns: [
                {data: null,defaultContent:1,width:'60px', className: 'center'},
                {data: null,defaultContent:1,width:'80px', className: 'center'},
                {data: 'checkState',width:'100px', className: 'center'},
                {data: 'conState',width:'100px', className: 'center' },
                {data: 'batchNO',width:'100px', className: 'center'},
                {data: 'uniscid',width:'120px', className: 'center'},
                {data: 'regNO',width:'100px', className: 'center'},
                {data: 'entName',width:'180px', className: 'center'},
                {data: 'markName',width:'100px', className: 'center'},
                {data: 'markUseArea',width:'100px', className: 'center'},
                {data: 'markStartDate',width:'100px', className: 'center'},
                {data: 'markEndDate',width:'100px', className: 'center'},
                {data: 'importPeople',width:'100px', className: 'center'},
                {data: 'importDate',width:'100px', className: 'center'},
                {data: 'checkPeople',width:'100px', className: 'center'},
                {data: 'checkDate',width:'120px', className: 'center'}
            ],
             columnDefs : [
							{
								targets: 1,
			                    render: function (data, type, row, meta) {
			                    	if(row.conState=='0'||(Date.parse(systemDate) > Date.parse(row.markEndDate))||(Date.parse(systemDate) < Date.parse(row.markStartDate))||row.markState=='0') 
			                    		return "<a href='javascript:void(0)' class='mr10 look'>查看</a>";
			                    	if(row.checkState=='3' || row.checkState=='2') 
			                    	    return "<a href='javascript:void(0)' class='mr10 edit'>批次修改</a>";
			                    	else if(row.checkState=='0')
			                    		return "<a href='javascript:void(0)' class='mr10 look'>查看</a>";
			                    	else if(row.checkState=='1')
			                    		return "<a href='javascript:void(0)' class='mr10 look'>查看</a><a class='disable'>失效</a>";
			                    }
			                },
			                {
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
			                },
			                {
								targets:3,
			                    render: function (data, type, row, meta) {
			                    	if(row.conState=='1'&& row.markState=='1'&&(!(Date.parse(systemDate) > Date.parse(row.markEndDate)))&&(!(Date.parse(systemDate) < Date.parse(row.markStartDate)))) 
			                    		return "有效";
			                    	else 
			                    		return "无效";
			                    }
			                }
					  ]
        })
    }
    

    function bind() {
        util.bindEvents([{
            el: '.edit',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
            	layer.dialog({title: '批次修改',area: ['80%', '80%'],
            		content: '/syn/con/csconcernobj/doEnConBatchMod?batchNO='+data.batchNO,
                    callback: function (data) {
                    		table.ajax.reload();
                    }
                })
            }
        },{
            el: '.look',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
            	layer.dialog({title: '查看详情',area: ['80%', '80%'],
            		content: '/syn/con/csconcernobj/applyview?batchNO='+data.batchNO+"&urlFlag=0",
                    callback: function (data) {
                    	
                    }
                })
            }
        },{
            el: '.add',
            event: 'click',
            handler: function () {
            	window.location.href='/syn/con/csconcernobj/enadd';
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
        },{
            el: '.disable',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
            	if(data.uid==null || data.uid=='') {layer.msg('请选择记录');return false;}
            	layer.confirm('确定要失效该条记录吗?', {icon: 3, title: '温馨提示'}, function (index) {
            		layer.close(index);
        			http.httpRequest({
                        url: '/syn/con/csconcernobj/doDisable/'+data.uid+'/'+data.priPID,
                        type: 'get',
                        data: {},
                        success: function (data) {
                        	if(data.status=='success'){
                        		table.ajax.reload();
                        	}
                        }
                    });
        		});
            }
        }
        ])
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
})
