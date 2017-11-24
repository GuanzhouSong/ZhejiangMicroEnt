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
    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#ent-check-table',
			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/syn/risk/csentwarn/checklist.json',
                data:function(d){
                	if(clickFlag){
                		d.params = searchParams;
                	}else{
                		 d.params = {"deptCode":$('#deptCode').val()};
                	}
                }
            },
            columns: [
                {data: null,defaultContent:1,width:'60px', className: 'center'},
                {data: null,defaultContent:1,width:'80px', className: 'center'},
                {data: 'checkState',width:'100px', className: 'center'},
                {data: 'batchNo',width:'100px', className: 'center'},
                {data: 'markSetYear',width:'100px', className: 'center'},
                {data: 'markName',width:'100px', className: 'center'},
                {data: 'markContent',width:'100px', className: 'center'},
                {data: 'markClass',width:'100px', className: 'center'},
                {data: 'markAppointWay',width:'150px', className: 'center'},
                {data: 'markAppointDept',width:'150px', className: 'center'},
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
			                    	if(row.checkState=='3' || row.checkState=='2') 
			                    	    return "<a href='javascript:void(0)' class='mr10 check'>审核</a>";
			                    	else if(row.checkState=='1'||row.checkState=='0')
			                    		return "<a href='javascript:void(0)' class='mr10 look'>查看</a>";
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
			                },{
								targets:7,
			                    render: function (data, type, row, meta) {
			                    	if(row.markClass=='0') 
			                    	    return "关注";
			                    	else if(row.markClass=='1')
			                    		return "警示";
			                    	else if(row.markClass=='2')
			                    		return "限制";
			                    }
			                },{
								targets:8,
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
    	searchParams = $("#checkSearchForm").serializeObject();
        table.ajax.reload();
    }); 

    function bind() {
        util.bindEvents([{
            el: '.check',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
            	window.location.href='/syn/risk/csentwarn/encheck?batchNo='+data.batchNo+'&urlFlag=1';
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
            	window.location.href='/syn/risk/csentwarn/lookinfo?batchNo='+data.batchNo+'&urlFlag=1';
            }
        }
        ])
    }
    
})
