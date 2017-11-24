require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
    }

    
    var searchParams={};//查询参数声明!
    var table;
    var clickFlag = false;
    var systemDate = getNowFormatDate();
    /**
     * 初始化dataTable
     */
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
    function initDataTable() {
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#ent-apply-table',
			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/syn/risk/csentwarn/list.json',
                data:function(d){
                	if(clickFlag){
                		d.params = searchParams;
                	}else{
                		 d.params = {"deptCode":$('#deptCode').val(),"needHis":"1"};
                	}
                }
            },
            columns: [
                {data: null,defaultContent:1,width:'60px', className: 'center'},
                {data: null,defaultContent:1,width:'80px', className: 'center'},
                {data: 'checkState',width:'100px', className: 'center'},
                {data: 'entWarnState',width:'80px', className: 'center' },
                {data: 'batchNo',width:'100px', className: 'center'},
                {data: 'uniscid',width:'120px', className: 'center'},
                {data: 'regNO',width:'100px', className: 'center'},
                {data: 'entName',width:'180px', className: 'center'},
                {data: 'markName',width:'100px', className: 'center'},
                {data: 'markContent',width:'150px', className: 'center'},
                {data: 'markClass',width:'100px', className: 'center'},
                {data: 'markAppointWay',width:'130px', className: 'center'},
                {data: 'markAppointDept',width:'130px', className: 'center'},
                {data: 'markStartDate',width:'100px', className: 'center'},
                {data: 'markEndDate',width:'100px', className: 'center'},
                {data: 'importPeople',width:'100px', className: 'center'},
                {data: 'importDate',width:'100px', className: 'center'},
                {data: 'checkPeople',width:'100px', className: 'center'},
                {data: 'checkDate',width:'100px', className: 'center'}
            ],
             columnDefs : [
							{
								targets: 1,
			                    render: function (data, type, row, meta) {
			                    	if(row.entWarnState=='0'||(Date.parse(systemDate) > Date.parse(row.markEndDate))||(Date.parse(systemDate) < Date.parse(row.markStartDate)) || row.markState=='0')
			                    		return "<a href='javascript:void(0)' class='mr10 look'>查看</a>";
			                    	if(row.checkState=='3' || row.checkState=='2') 
			                    	    return "<a href='javascript:void(0)' class='mr10 edit'>批次修改</a>";
			                    	else if(row.checkState=='0')
			                    		return "<a href='javascript:void(0)' class='mr10 look'>查看</a>";
			                    	else if(row.checkState=='1')
			                    		return "<a href='javascript:void(0)' class='mr10 look'>查看</a><a href='javascript:void(0)' class='disable'>失效</a>";
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
			                    	if(row.entWarnState=='1'&& row.markState=='1'&&(!(Date.parse(systemDate) > Date.parse(row.markEndDate)))&&(!(Date.parse(systemDate) < Date.parse(row.markStartDate)))) 
			                    	    return "有效";
			                    	else 
			                    		return "无效";
			                    }
			                }, {
								targets:10,
			                    render: function (data, type, row, meta) {
			                    	if(row.markClass=='0') 
			                    	    return "关注";
			                    	else if(row.markClass=='1')
			                    		return "警示";
			                    	else if(row.markClass=='2')
			                    		return "限制";
			                    }
			                },{
								targets:11,
			                    render: function (data, type, row, meta) {
			                    	if(row.markAppointWay=='0') 
			                    	    return "对内提示";
			                    	else if(row.markAppointWay=='1')
			                    		return "部门共享";
			                    	else if(row.markAppointWay=='2')
			                    		return "公开发布";
			                    }
			                }
					  ]
        })
    }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	clickFlag = true;
    	searchParams = $("#entSearchForm").serializeObject();
        table.ajax.reload();
    }); 

    function bind() {
        util.bindEvents([{
            el: '.edit',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
            	window.location.href='/syn/risk/csentwarn/enedit?batchNo='+data.batchNo;
            }
        },{
            el: '.enadd',
            event: 'click',
            handler: function () {
            	window.location.href='/syn/risk/csentwarn/enadd';
            }
        },{
            el: '#cancel',
            event: 'click',
            handler: function () {
            	window.location.href='/syn/risk/csentwarn/list';
            }
        },{
            el: '#reset',
            event: 'click',
            handler: function () {
            	$('.clx').val('');
            }
        },{
            el: '.look',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
            	window.location.href='/syn/risk/csentwarn/lookinfo?batchNo='+data.batchNo+"&urlFlag=0";
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
            	layer.confirm('确定要失效该条记录吗?', {icon: 3, title: '温馨提示'}, function (index) {
             	   layer.close(index);
            	http.httpRequest({
                    url: '/syn/risk/csentwarn/disable',
                    data: {'uid':data.uid,'priPID':data.priPID},
                    type: 'post',
                    success: function (data) {
                        layer.msg(data.msg, {time: 1000}, function () {
                        	table.ajax.reload();
                        });
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
