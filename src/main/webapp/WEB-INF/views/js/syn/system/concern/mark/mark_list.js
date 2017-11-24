require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {
	var table_one,table_all,table,paramsType;
	var flag_one=false;
	var flag_all = false;
	var searchParams_one=$("#form_one").serializeObject();
	var searchParams_all=$("#form_all").serializeObject();
	var systemDate = getNowFormatDate();
	init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable('one');
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
    function initDataTable(type) {
    	if(type=='one') flag_one = true;
    	else     		flag_all = true;
    	table = (type == 'one') ? table_one : table_all;
    	var tableId = '#table-' + type
    	paramsType = (type == 'one') ? searchParams_one : searchParams_all;
    	table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: tableId,
			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/syn/risk/cswarnmark/doGetConMarklist',
                data:function(d){
                	d.params = paramsType;
                }
            },
            columns: [
                {data: '_idx',width:'60px', className: 'center'},
                {data: null,width:'80px', className: 'center'},
                {data: 'markNo',width:'100px', className: 'center'},
                {data: 'markSetYear',width:'130px', className: 'center' },
                {data: 'markClass',width:'100px', className: 'center'},
                {data: 'markName',width:'100px', className: 'center'},
                {data: 'markAppointWay',width:'150px', className: 'center'},
                {data: 'markState',width:'100px', className: 'center'},
                {data: 'markStartDate',width:'130px', className: 'center'},
                {data: 'markEndDate',width:'130px', className: 'center'},
                {data: 'setDeptContact',width:'160px', className: 'center'},
                {data: 'markSetDept',width:'120px', className: 'center'},
                {data: 'markSetDate',width:'120px', className: 'center'}
            ],
             columnDefs : [
							{
								targets: 4,
			                    render: function (data, type, row, meta) {
			                    	if(row.markClass=='0')  return '关注';
			                    	else if(row.markClass=='1') return '警示';
			                    	else  if(row.markClass=='2') return '限制';
			                    }
			                },{
								targets: 7,
			                    render: function (data, type, row, meta) {
			                    	if(row.markState=='1' &&(!(Date.parse(systemDate) > Date.parse(row.markEndDate)))&&(!(Date.parse(systemDate) < Date.parse(row.markStartDate))))
			                    			return '有效';
			                    	else return '无效';
			                    }
			                },{
								targets: 6,
			                    render: function (data, type, row, meta) {
			                    	if(row.markAppointWay=='0')  return '对内提示';
			                    	else if(row.markAppointWay=='1') return '部门共享';
			                    	else return '公开发布';
			                    }
			                },{
								targets: 1,
			                    render: function (data, type, row, meta) {
			                    	if(tableId=='#table-one'&&row.markState=='1' && (Date.parse(systemDate) <= Date.parse(row.markEndDate)) && (Date.parse(systemDate) >= Date.parse(row.markStartDate)))
			                    		  return "<a href='javascript:void(0)' class='mr10 markedit'>修改</a><a href='javascript:void(0)' class='disable'>失效</a>";
				                    else if(tableId=='#table-all') 
				                    	    return "<a href='javascript:void(0)' class='mr10 look'>查看</a>";	
				                    else
				                    	return "<a href='javascript:void(0)' class='mr10 look'>查看</a>";
			                    }
			                }
					  ]
             })
        }
    
    
    function bind() {
        util.bindEvents([
        {
            el: '#searchOne',
            event: 'click',
            handler: function () {
            	paramsType = $("#form_one").serializeObject();
            	table.ajax.reload();
            }
        },{
        	el: '#searchAll',
        	event: 'click',
            handler: function () {
            	paramsType = $("#form_all").serializeObject();
            	table.ajax.reload();
            }
        },{
        	el: '._tab',
        	event: 'click',
            handler: function () {
            	var _id = $(this).attr('id');
            	if(_id == 'one' && !flag_one) initDataTable(_id);
            	if(_id == 'all' && !flag_all) initDataTable(_id);
            }
        },{
        	el: '.markadd',
        	event: 'click',
            handler: function () {
            	window.location.href='/syn/risk/cswarnmark/doEnConMarkAddAndEdit';
            }
        },{
        	el: '#reset_one',
        	event: 'click',
            handler: function () {
            	$('.clx_one').val('');
            }
        },{
        	el: '#reset_all',
        	event: 'click',
            handler: function () {
            	$('.clx_all').val('');
            }
        },{
        	el: '.markedit',
        	event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
            	if(data.uid==null || data.uid=='') return ;
            	window.location.href='/syn/risk/cswarnmark/doEnConMarkAddAndEdit?uid='+data.uid;
            }
        },{
            el: '.look',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
                window.location.href='/syn/risk/cswarnmark/lookdetailforgz?uid='+data.uid;
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
                    data: {'uid':data.uid,'markNo':data.markNo,'type':'gz'},
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

})
