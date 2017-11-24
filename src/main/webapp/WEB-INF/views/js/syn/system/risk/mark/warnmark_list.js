require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {
	var searchParams=$("#warnSearchForm").serializeObject();//查询参数声明!
	var table;
	
	var searchParamsAll=$("#warnSearchFormAll").serializeObject();//查询参数声明!
	var tableAll;
	var systemDate = getNowFormatDate();
	
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
            el: '#warn-table',
			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/syn/risk/cswarnmark/warnlist.json',
                data:function(d){
                	d.params = searchParams;
                }
            },
            columns: [
                {data: null,width:'60px',defaultContent:1,className: 'center'},
                {data: null,width:'80px', defaultContent:1,className: 'center'},
                {data: 'markNo',width:'130px', className: 'center'},
                {data: 'markSetYear',width:'100px', className: 'center' },
                {data: 'markType',width:'120px', className: 'center'},
                {data: 'markClass',width:'100px', className: 'center'},
                {data: 'markName',width:'180px', className: 'center'},
                {data: 'markStartDate',width:'100px', className: 'center'},
                {data: 'markEndDate',width:'100px', className: 'center'},
                {data: 'markState',width:'100px', className: 'center'},
                {data: 'markAppointWay',width:'150px', className: 'center'},
                {data: 'markSetDept',width:'130px', className: 'center'},
                {data: 'markSetDate',width:'100px', className: 'center'}
            ],
             columnDefs : [
							{
								targets: 1,
							    render: function (data, type, row, meta) {
							    	if(row.markState=='1' &&(!(Date.parse(systemDate) > Date.parse(row.markEndDate)))&&(!(Date.parse(systemDate) < Date.parse(row.markStartDate))))
							        	    return "<a href='javascript:void(0)' class='mr10 edit'>修改</a><a href='javascript:void(0)' class='disable'>失效</a>";
							            else 
							        	    return "<a href='javascript:void(0)' id='one' class='mr10 look'>查看</a>";
							    }
							},{
								targets: 5,
			                    render: function (data, type, row, meta) {
			                    	if(row.markClass=='0')
			                    	    return "关注";
			                    	else if(row.markClass=='1')
			                    		return "警示"
			                    	else  if(row.markClass=='2')
			                    		return "限制"
			                    }
			                },{
								targets: 9,
			                    render: function (data, type, row, meta) {
			                    	if(row.markState=='1' &&(!(Date.parse(systemDate) > Date.parse(row.markEndDate)))&&(!(Date.parse(systemDate) < Date.parse(row.markStartDate))))
			                    		return "有效";
			                    	else
			                    		return "无效"
			                    	
			                    }
			                },{
								targets: 10,
			                    render: function (data, type, row, meta) {
			                    	if(row.markAppointWay=='0')
			                    	    return "对内提示";
			                    	else if(row.markAppointWay=='1')
			                    		return "部门共享";
			                    	else
			                    		return "公开发布";
			                    }
			                }
					  ]
             })
        }
    
    
    //表格之外的查询按钮事件
    $("#mySearch").click(function(){
    	searchParams = $("#warnSearchForm").serializeObject();
        table.ajax.reload();
    }); 

    function initDataTableAll() {
        tableAll = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#warn-table-all',
			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/syn/risk/cswarnmark/warnlist.json',
                data:function(d){
                		d.params = searchParamsAll;
                }
            },
            columns: [
                      {data: null,width:'60px',defaultContent:1, className: 'center'},
                      {data: null,width:'80px', defaultContent:1,className: 'center'},
                      {data: 'markNo',width:'100px', className: 'center'},
                      {data: 'markSetYear',width:'100px', className: 'center' },
                      {data: 'markType',width:'100px', className: 'center'},
                      {data: 'markClass',width:'100px', className: 'center'},
                      {data: 'markName',width:'100px', className: 'center'},
                      {data: 'markStartDate',width:'100px', className: 'center'},
                      {data: 'markEndDate',width:'100px', className: 'center'},
                      {data: 'markState',width:'100px', className: 'center'},
                      {data: 'markAppointWay',width:'150px', className: 'center'},
                      {data: 'markSetDept',width:'150px', className: 'center'},
                      {data: 'markSetDate',width:'150px', className: 'center'}
            ],
             columnDefs : [
							{
								targets: 1,
			                    render: function (data, type, row, meta) {
				                    	    return "<a href='javascript:void(0)' id='all' class='mr10 look'>查看</a>";	
			                    }
			                },{
								targets: 5,
			                    render: function (data, type, row, meta) {
			                    	if(row.markClass=='0')
			                    	    return "关注";
			                    	else if(row.markClass=='1')
			                    		return "警示"
			                    	else if(row.markClass=='2')
			                    		return "限制"
			                    }
			                },{
			                	targets: 9,
			                    render: function (data, type, row, meta) {

							    	if(row.markState=='1' &&(!(Date.parse(systemDate) > Date.parse(row.markEndDate)))&&(!(Date.parse(systemDate) < Date.parse(row.markStartDate))))
			                    		return "有效";
			                    	else
			                    		return "无效"
			                    }
			                },{
								targets: 10,
			                    render: function (data, type, row, meta) {
			                    	if(row.markAppointWay=='0')
			                    	    return "对内提示";
			                    	else if(row.markAppointWay=='1')
			                    		return "部门共享";
			                    	else
			                    		return "公开发布";
			                    }
			                }
					]
        })
    }
    
    //表格之外的查询按钮事件
    $("#allSearch").click(function(){
    	clickFlagAll = true;
    	searchParamsAll = $("#warnSearchFormAll").serializeObject();
        tableAll.ajax.reload();
    }); 
    
    function bind() {
        util.bindEvents([{
            el: '.edit',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
            	window.location.href='/syn/risk/cswarnmark/enaddAndedit?uid='+data.uid;
            }
        },{
            el: '.look',
            event: 'click',
            handler: function () {
            	if(this.id=='one')
            	    var data = table.row($(this).closest('td')).data();
            	else if(this.id=='all')
            		var data = tableAll.row($(this).closest('td')).data();	
            	window.location.href='/syn/risk/cswarnmark/lookdetail?uid='+data.uid;
            }
        },{
            el: '.enaddAddedit',
            event: 'click',
            handler: function () {
            	window.location.href='/syn/risk/cswarnmark/enaddAndedit';
            }
        },{
            el: '#cancel',
            event: 'click',
            handler: function () {
            	window.location.href='/syn/risk/cswarnmark/list';
            }
        },{
            el: '#selectMarkSetDept',
            event: 'click',
            handler: function () {
            	doSelectWarnMarkSetDept();
            }
        },{
        	el:'#reset_all',
        	event:'click',
        	handler:function(){
        		$('.clx_all').val('');
        	}
        },{
        	el:'#reset_one',
        	event:'click',
        	handler:function(){
        		$('.clx_one').val('');
        	}
        },{
            el: '#tabAll',
            event: 'click',
            handler: function () {
            	if(tableAll==undefined)
            	initDataTableAll();
            }
        },{
            el: '.disable',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
            	layer.confirm('确定要失效该条记录吗?', {icon: 3, title: '温馨提示'}, function (index) {
            	   layer.close(index);
            	http.httpRequest({
                    url: '/syn/risk/cswarnmark/disable',
                    data: {'uid':data.uid,'markNo':data.markNo,'type':'yj'},
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
    //选择部门
    function doSelectWarnMarkSetDept() {
        var select_dept_url=window._CONFIG.select_dept_url;
        layer.dialog({
            title: '选择设置部门',
            area: ['350px', '666px'],
            content: select_dept_url,
            callback: function (data) {
                if(data.orgCode!=null&&data.orgName!=null){
                    $("#markSetDept").val(data.orgName);
                    $("#markSetDeptCode").val(data.orgCode);
                }
            }
        })
    }

})
